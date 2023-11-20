package springdatajpa;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@AllArgsConstructor
public class Application implements CommandLineRunner {
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var userService = new UsersService(userRepository);
        var user = userService.createUser(new UserDTO(0L, "", "Misha2", "Test123@test.ua", UserRole.CUSTOMER));
        System.out.println(user);
        var userRead2 = userService.getUserById(user.id());
        System.out.println(userRead2);
        userService.deleteUserById(userRead2.id());
        var userRead = userService.getUserById(1L);
        var userForUpdate = new UserDTO(userRead.id(), userRead.uid(), "Misha Postol-Takanov", userRead.email(), userRead.userRole());
        var updatedUser = userService.updateUser(userForUpdate, userForUpdate.id());
        System.out.println(updatedUser);
        //System.out.println(userRepository.findAll());
    }
}
