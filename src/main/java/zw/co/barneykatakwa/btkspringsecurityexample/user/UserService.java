package zw.co.barneykatakwa.btkspringsecurityexample.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDetails loadUserByUsername(String username);
}
