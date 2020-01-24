package domain;

public class StoreDTO {
    private Store store;
    private Integer femei;
    private Integer brabarti;
    private String predominant;

    public StoreDTO(Store store, Integer femei, Integer brabarti) {
        this.store = store;
        this.femei = femei;
        this.brabarti = brabarti;
        if(this.femei>this.brabarti)
            predominant="F";
        else if(this.femei<this.brabarti)
            predominant="M";
        else if(this.femei==this.brabarti)
            predominant="M=F";

    }

    @Override
    public String toString() {
        return "Store{" +
                "magazin=" + store.getId() +" "+ store.getName()+
                ", predominant" + predominant +
                '}';
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Integer getFemei() {
        return femei;
    }

    public void setFemei(Integer femei) {
        this.femei = femei;
    }

    public Integer getBrabarti() {
        return brabarti;
    }

    public void setBrabarti(Integer brabarti) {
        this.brabarti = brabarti;
    }
}
