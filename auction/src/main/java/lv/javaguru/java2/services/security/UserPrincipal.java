package lv.javaguru.java2.services.security;

import lv.javaguru.java2.domain.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by Vladislav on 3/28/2015.
 */
public class UserPrincipal extends org.springframework.security.core.userdetails.User {
    private User user;

    public UserPrincipal(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserPrincipal(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    // Methods to work with attached user
    public void attachDomainUser(User user){
        this.user = user;
    }

    public User getDomainUser(){
        return user;
    }

}
