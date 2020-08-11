package zw.co.barneykatakwa.btkspringsecurityexample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import zw.co.barneykatakwa.btkspringsecurityexample.user.UserDetailsServiceImpl;

/**
 * Project Name btk-spring-security-example
 * Developed by bkatakwa
 * Date         11/8/2020
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/").hasAnyAuthority("USER","MAKER","CHECKER","ADMIN")
                .antMatchers("/new").hasAnyAuthority("MAKER","ADMIN")
                .antMatchers("/edit/**").hasAnyAuthority("CHECKER","ADMIN")
                .antMatchers("/delete/**").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                ;

        http.headers().frameOptions().disable();
    }
}
