package net.awaken.springboot;

import net.awaken.springboot.domain.primary.Role;
import net.awaken.springboot.domain.secondary.RoleReadonly;
import net.awaken.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        Role role = this.userService.obtainRole(1l);
        RoleReadonly roleReadonly = this.userService.getRole(1l);
        assert role.getId().equals(roleReadonly.getId());
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
