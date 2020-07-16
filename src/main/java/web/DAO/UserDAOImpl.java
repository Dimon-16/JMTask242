package web.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        try {
            session.save(user);
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteUser(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Query query = session.createQuery("DELETE FROM User WHERE id = :idUser");
            query.setParameter("idUser", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception exc) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateUser(long id, User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Query query = session.createQuery("UPDATE User Set name = :newName, password= :newPassword," +
                    "age = :newAge WHERE id = :id");
            query.setParameter("newName", user.getName());
            query.setParameter("newPassword", user.getPassword());
            query.setParameter("newAge", user.getAge());
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception exc) {
            transaction.rollback();
        }
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = (TypedQuery<User>) sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Transactional
    @Override
    public User loadUserByUserName(String name) {
        User user = null;
        TypedQuery<User> query = (TypedQuery<User>) sessionFactory.getCurrentSession().createQuery("from User where name = :name");
        query.setParameter("name", name);
        user = query.getSingleResult();
        return user;
    }
}
