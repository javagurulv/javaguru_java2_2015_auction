package lv.javaguru.java2.domain;

import javax.persistence.*;

/**
 * Created by Vladislav on 2/15/2015.
 */

@Entity
@Table(name="categories")
public class ProductCategory {

    @Column(name="CategoryID", columnDefinition = "int")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryId;

    @Column(name="Name", columnDefinition="char(32)")
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
