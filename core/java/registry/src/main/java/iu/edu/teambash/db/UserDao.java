package iu.edu.teambash.db;

import io.dropwizard.hibernate.AbstractDAO;
import iu.edu.teambash.core.UsersEntity;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

/**
 * Created by janakbhalla on 17/09/16.
 */
public class UserDao extends AbstractDAO<UsersEntity> {
    public UserDao(SessionFactory factory) {
        super(factory);
    }

    public Optional<UsersEntity> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    public UsersEntity create(UsersEntity user) {
        return persist(user);
    }

    public List<UsersEntity> findByName(String uname) {
        return list(namedQuery("db.UsersEntity.findByName").setParameter("uname", uname));
    }
}