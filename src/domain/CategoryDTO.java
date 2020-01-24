package domain;

public class CategoryDTO {
    private Category category;
    private Float pretMediu;
    private Float procentaj;

    public CategoryDTO(Category category, Float pretMediu, Float procentaj) {
        this.category = category;
        this.pretMediu = pretMediu;
        this.procentaj = procentaj;
    }

    public Float getProcentaj() {
        return procentaj;
    }

    public void setProcentaj(Float procentaj) {
        this.procentaj = procentaj;
    }

    public CategoryDTO(Category category, Float pretMediu) {
        this.category = category;
        this.pretMediu = pretMediu;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Float getPretMediu() {
        return pretMediu;
    }

    public void setPretMediu(Float pretMediu) {
        this.pretMediu = pretMediu;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "category=" + category +
                ", pretMediu=" + pretMediu +
                '}';
    }
}
