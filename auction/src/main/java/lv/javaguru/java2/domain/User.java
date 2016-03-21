package lv.javaguru.java2.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Created by Viktor on 01/07/2014.
 */
@Entity
@Table(name = "users")
public class User {

    @Column(name="UserID", columnDefinition = "int")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Login")
    private String login;

    @Column(name = "Password")
    private String password;

    @Column(name = "Balance")
    private BigDecimal balance;

    @Column(name = "Email")
    private String email;

    @Column(name = "Avatar")
    private String avatar;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Product> productList;

    public void addToBalance(BigDecimal money){
        setBalance(getBalance().add(money));
    }

    @Override
    public boolean equals(Object object) {
        if (object==null) return false;
        if (!(object instanceof User)) return false;
        if (((User) object).getUserId()==this.userId) return true;
        else return false;

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}

