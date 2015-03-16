package lv.javaguru.java2.domain;

import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;

/**
 * Created by Vladislav on 2/15/2015.
 */


@Entity
@Indexed
@Table(name = "products")
public class Product{

    @Column(name="PRODUCTID", columnDefinition = "int")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productID;

    @Column(name = "Name")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String name;

    @Column(name = "Description")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNERID", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CategoryID", nullable = false)
    private  ProductCategory category;

    @Column(name = "Status")
    private boolean status;

    @Column(name = "Image")
    private String image = null;

    @Column(name = "Price")
    private transient double price;


    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isStatus() {
        return status;
    }
}