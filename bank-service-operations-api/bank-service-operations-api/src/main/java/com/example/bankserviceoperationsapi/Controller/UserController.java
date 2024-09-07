package com.example.bankserviceoperationsapi.Controller;

import com.example.bankserviceoperationsapi.Entity.User;
import com.example.bankserviceoperationsapi.Service.TelephoneService;
import com.example.bankserviceoperationsapi.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TelephoneService telephoneService;

    /**
     * Через POST запрос создаёт новую запись в таблице users с null значением в поле
     * telephones и emails. Т.к. это отдельные объекты, ссылающиеся через внешний ключ
     * к id юзера, то и создавать их нужно в отдельном запросе.
     * @param user новый юзер
     * @return сообщение в консоль
     */
    @PostMapping("/createNewUser")
    public User createNewUser(@RequestBody User user) {
        log.info(user.getName() + " has been added to table users");
        return userService.createUser(user);
    }

    @DeleteMapping("/deleteUserById")
    public void deleteUserById(@RequestBody User user) {
        log.info(user.getName() + " has been removed from table users");
        userService.deleteUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        log.info("User %d has been removed from table", id);
        userService.deleteUser(id);
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getAllUsers")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/deleteAllUsers")
    public void  deleteAllUsers() {
        userService.deleteAllUsers();
    }
}
