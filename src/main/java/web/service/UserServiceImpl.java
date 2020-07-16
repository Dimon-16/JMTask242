package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public void addUser(User user) {userDAO.addUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {userDAO.deleteUser(id);
    }
    @Transactional
    @Override
    public void updateUser(long id, User user) {
        userDAO.updateUser(id, user);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        List<User> list;
        list = userDAO.getAllUsers();
        return list;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUserName(String name) {
        return userDAO.loadUserByUserName(name);
    }
}
