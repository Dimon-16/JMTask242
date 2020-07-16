package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);
    void deleteUser(long id);
    void updateUser(long id, User user);
    List<User> getAllUsers();
    User loadUserByUserName(String name);

}
