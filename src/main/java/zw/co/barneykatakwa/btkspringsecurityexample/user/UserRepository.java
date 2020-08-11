package zw.co.barneykatakwa.btkspringsecurityexample.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findAllByUsername(String username);
}
