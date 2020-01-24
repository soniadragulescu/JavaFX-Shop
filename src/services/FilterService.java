package services;

import domain.*;
import javafx.util.Pair;
import repositories.AquisitionRepo;
import repositories.ClientRepo;
import repositories.StoreRepo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FilterService {
    private ClientRepo clientRepo;
    private StoreRepo storeRepo;
    private AquisitionRepo aquisitionRepo;

    public FilterService(ClientRepo clientRepo, StoreRepo storeRepo, AquisitionRepo aquisitionRepo) {
        this.clientRepo = clientRepo;
        this.storeRepo = storeRepo;
        this.aquisitionRepo = aquisitionRepo;
    }

    public List<Client> clientiVarstaInterval(int startAge, int endAge){
        List<Client> result=new ArrayList<>();
        clientRepo.findAll().forEach(result::add);
        return result
                .stream()
                .filter(c->c.getAge()>=startAge&&c.getAge()<=endAge)
                .collect(Collectors.toList());
    }

    public List<StoreDTO> sexPredominantMagazin(){
        List<Store> magazine=new ArrayList<>();
        storeRepo.findAll().forEach(magazine::add);
        List<Aquisition> achizitii=new ArrayList<>();
        aquisitionRepo.findAll().forEach(achizitii::add);
        List<StoreDTO> result=new ArrayList<>();
        for(Store s:magazine){
            Integer femei=0;
            Integer barbati=0;
            for(Aquisition a:achizitii){
                if(a.getStore().getId()==s.getId())
                    if(a.getClient().getSex().toString()=="F")
                        femei++;
                    else barbati++;
            }
            result.add(new StoreDTO(s,femei,barbati));
        }
        return result;
    }

    public List<CategoryDTO> mediePeCategorie(){
        List<CategoryDTO> result=new ArrayList<>();
        HashMap<Category, Pair<Float, Integer>> map=new HashMap<>();
        map.put(Category.Electronics,new Pair(0.00f,0));
        map.put(Category.Entertaining,new Pair(0.00f,0));
        map.put(Category.Cosmetics,new Pair(0.00f,0));
        map.put(Category.Fashion,new Pair(0.00f,0));
        map.put(Category.Furniture,new Pair(0.00f,0));
        map.put(Category.Groceries,new Pair(0.00f,0));
        List<Aquisition> achizitii=new ArrayList<>();
        aquisitionRepo.findAll().forEach(achizitii::add);
        for(Aquisition a:achizitii){
           Pair<Float,Integer> pair=map.get(a.getStore().getCategory());
           Pair<Float,Integer> pair2=new Pair((float)pair.getKey()+(float)a.getPrice(),pair.getValue()+1);
           map.replace(a.getStore().getCategory(),pair2);
        }
        for(Category x:map.keySet()){
            Float pretMediu=(float) map.get(x).getKey()/map.get(x).getValue();
            result.add(new CategoryDTO(x,pretMediu));
        }
        return result;
    }

    public List<CategoryDTO> procentajeCategorii(LocalDateTime start, LocalDateTime end){
        List<CategoryDTO> result=new ArrayList<>();
        HashMap<Category, Float> map=new HashMap<>();
        map.put(Category.Electronics,0.00f);
        map.put(Category.Entertaining,0.00f);
        map.put(Category.Cosmetics,0.00f);
        map.put(Category.Fashion,0.00f);
        map.put(Category.Furniture,0.00f);
        map.put(Category.Groceries,0.00f);
        List<Aquisition> achizitii=new ArrayList<>();
        aquisitionRepo.findAll().forEach(achizitii::add);
        Float total=0.00f;
        for(Aquisition a:achizitii){
            if(a.getTime().isBefore(end)&&a.getTime().isAfter(start)) {
                Float cantitate = a.getPrice();
                total = total + cantitate;
                Float cantitateCurenta = map.get(a.getStore().getCategory());
                Float cantitateNoua = cantitateCurenta + cantitate;
                map.replace(a.getStore().getCategory(), cantitateNoua);
            }
        }
        for(Category x:map.keySet()){
            Float pret=0.00f;
            result.add(new CategoryDTO(x,pret, map.get(x) *100/total));
        }
        return result;

    }

}
