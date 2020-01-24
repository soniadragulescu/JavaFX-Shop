package domain;

public class Store extends Entity<String> {
    private String name;
    private Category category;

    public Store(String id,String name, Category category) {
        this.setId(id);
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Store{ id=" +this.getId()+
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}
