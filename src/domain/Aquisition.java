package domain;

import javafx.util.Pair;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Aquisition extends Entity<Pair<String,String>> {
    private Client client;
    private Store store;
    private LocalDateTime time;
    private Float price;

    public Aquisition(Client client, Store store, LocalDateTime time, Float price) {
        this.setId(new Pair(client.getId(),store.getId()));
        this.client = client;
        this.store = store;
        this.time = time;
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Aquisition{ id=" +this.getId().getValue()+" "+this.getId().getKey()+
                ", client=" + client +
                ", store=" + store +
                ", time=" + time +
                ", price=" + price +
                '}';
    }
}
