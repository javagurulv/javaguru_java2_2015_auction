package lv.javaguru.java2.services.security;

import lv.javaguru.java2.database.DBException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import lv.javaguru.java2.database.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Vladislav on 3/24/2015.
 */
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    //get user from the database, via Hibernate
    @Qualifier("ORM_UserDAO")
    @Autowired
    private UserDAO userDao;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(final String username){

        lv.javaguru.java2.domain.User user = getUserByLogin(username);

        List<GrantedAuthority> authorities =  buildUserAuthority();

        return buildUserForAuthentication(user, authorities);

    }

    // Converts domain User user to
    // org.springframework.security.core.userdetails.User
    private UserPrincipal buildUserForAuthentication(lv.javaguru.java2.domain.User user,
                                            List<GrantedAuthority> authorities) {

        // Creating user that will be stored by Spring security
        UserPrincipal userPrincipal = new UserPrincipal(user.getLogin(), user.getPassword(),
                true, true, true, true, authorities);
        // Adding domain user, so we can get it any where we want.
        userPrincipal.attachDomainUser(user);

        return  userPrincipal;
    }

    private List<GrantedAuthority> buildUserAuthority() {

        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
        result.add(new SimpleGrantedAuthority("LOGINNED_USER"));

        return result;
    }

    private lv.javaguru.java2.domain.User getUserByLogin(String username){
        lv.javaguru.java2.domain.User user = null;
        try {
            user = userDao.getByLogin(username);
        } catch (DBException e) {
            e.printStackTrace();
        }
        return user;
    };

}