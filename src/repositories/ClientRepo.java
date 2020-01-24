package repositories;

import domain.Client;
import domain.Sex;

public class ClientRepo extends FileRepo<String, Client> {

    public ClientRepo(String fileName) {
        super(fileName);
        readFromFile();
    }

    @Override
    protected Client createEntityFromLine(String line) {
        String[] args=line.split(",");
        Client c=new Client(args[0],args[1], Sex.valueOf(args[2]),Integer.parseInt(args[3]));
        return c;
    }
}
