package zw.co.barneykatakwa.btkspringsecurityexample.user;

import lombok.*;
import zw.co.barneykatakwa.btkspringsecurityexample.comon.BaseEntity;
import zw.co.barneykatakwa.btkspringsecurityexample.role.Role;

import javax.persistence.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Project Name btk-spring-security-example
 * Developed by bkatakwa
 * Date         11/8/2020
 */

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends BaseEntity {

    private String username;
    private String password;
    private boolean active;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

}
