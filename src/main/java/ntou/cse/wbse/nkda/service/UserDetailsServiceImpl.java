package ntou.cse.wbse.nkda.service;

import ntou.cse.wbse.nkda.entity.User;
import ntou.cse.wbse.nkda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found with username: " + userName);
        }
        List authorities = new ArrayList<>();
        if (user.getAuth().equals("admin")) {
            authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else if (user.getAuth().equals("user")) {
            authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        } else {

        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
    }


}
