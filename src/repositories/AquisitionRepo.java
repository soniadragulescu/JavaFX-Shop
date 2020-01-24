package repositories;

import domain.Aquisition;
import domain.Client;
import domain.Store;
import javafx.util.Pair;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AquisitionRepo extends FileRepo<Pair<String,String>, Aquisition> {

    private ClientRepo clientRepo;
    private StoreRepo storeRepo;
    public AquisitionRepo(String fileName, ClientRepo clientRepo, StoreRepo storeRepo) {
        super(fileName);
        this.clientRepo=clientRepo;
        this.storeRepo=storeRepo;
        readFromFile();
    }

    @Override
    protected Aquisition createEntityFromLine(String line) {
        String[] args=line.split(",");
        Client c=clientRepo.findOne(args[0]);
        Store s=storeRepo.findOne(args[1]);
        DateTimeFormatter pattern=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Aquisition a=new Aquisition(c,s, LocalDateTime.parse(args[2], pattern),Float.parseFloat(args[3]));
        return a;
    }
}
