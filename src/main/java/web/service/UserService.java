package web.service;

import org.springframework.security.core.userdetails.UserDetails;
import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void deleteUser(long id);
    void updateUser(long id, User user);
    List<User> getAllUsers();
    UserDetails loadUserByUserName(String name);
}
