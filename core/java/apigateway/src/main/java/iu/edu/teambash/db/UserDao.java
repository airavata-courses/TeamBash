package iu.edu.teambash.db;

import io.dropwizard.hibernate.AbstractDAO;
import iu.edu.teambash.core.User;
import org.hibernate.SessionFactory;

import java.util.Optional;

/**
 * Created by janakbhalla on 17/09/16.
 */
public class UserDao extends AbstractDAO<User> {
    public UserDao(SessionFactory factory) {
        super(factory);
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    public User create(User user) {
        return persist(user);
    }

    /*public User findByNamePassword() {
        return new User(namedQuery("db.User.findByNamePassword"));
    }*/
}