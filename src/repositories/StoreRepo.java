package repositories;

import domain.Category;
import domain.Store;

public class StoreRepo extends FileRepo<String, Store> {
    public StoreRepo(String fileName) {
        super(fileName);
        readFromFile();
    }

    @Override
    protected Store createEntityFromLine(String line) {
        String[] args=line.split(",");
        Store s=new Store(args[0],args[1],Category.valueOf(args[2]));
        return s;
    }
}
