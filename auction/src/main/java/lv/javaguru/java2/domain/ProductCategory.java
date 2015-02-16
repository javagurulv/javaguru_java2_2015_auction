package lv.javaguru.java2.domain;

/**
 * Created by Vladislav on 2/15/2015.
 */
public class ProductCategory {

    private long categoryId;
    private String name;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
