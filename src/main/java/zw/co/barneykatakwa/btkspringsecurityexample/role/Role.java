package zw.co.barneykatakwa.btkspringsecurityexample.role;

import lombok.*;
import zw.co.barneykatakwa.btkspringsecurityexample.comon.BaseEntity;

import javax.persistence.Entity;

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
public class Role extends BaseEntity {

    private String name;
}
