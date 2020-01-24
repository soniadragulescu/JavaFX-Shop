package repositories;

import domain.Entity;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class FileRepo<ID, E extends Entity<ID>> implements CrudRepository<ID,E>{
    protected List<E> entities=new ArrayList<>();;
    private String fileName;

    public FileRepo(String fileName) {
        this.fileName=fileName;
        //this.readFromFile();
    }

    @Override
    public Collection<E> findAll() {
        return this.entities;
    }

    protected abstract E createEntityFromLine(String line);

    public E findOne(ID id) {
        if(id==null)
            throw new IllegalArgumentException(("The id must not be null!"));
        for(E pereche:entities){
            if(pereche.getId().equals(id))
                return pereche;
        }
        return null;
    }

    public E save(E entity)  {
        entities.add(entity);
        return entity;
    }
    protected void readFromFile(){
        Path path= Paths.get(fileName);
        try {
            List<String> list = Files.readAllLines(path);
            list.forEach(l -> {
                E entity=createEntityFromLine(l);
                this.save(entity);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
