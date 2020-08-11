package zw.co.barneykatakwa.btkspringsecurityexample.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Project Name btk-spring-security-example
 * Developed by bkatakwa
 * Date         11/8/2020
 */
@Service
public class UserDetailsServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findAllByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("could not find user " + username);
        }
        return new MyUserDetails(user);
    }
}
