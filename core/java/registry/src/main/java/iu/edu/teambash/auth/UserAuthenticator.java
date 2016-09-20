package iu.edu.teambash.auth;

/**
 * Created by janakbhalla on 15/09/16.
 */

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.hibernate.UnitOfWork;
import iu.edu.teambash.core.UsersEntity;
import iu.edu.teambash.db.UserDao;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class UserAuthenticator implements Authenticator<BasicCredentials, UsersEntity> {

    private static final Map<String, Set<String>> VALID_USERS = ImmutableMap.of(
            "guest", ImmutableSet.of(),
            "good-guy", ImmutableSet.of("BASIC_GUY"),
            "chief-wizard", ImmutableSet.of("ADMIN", "BASIC_GUY")
    );
    private UserDao userDao;

    public UserAuthenticator(UserDao userDao) {
        this.userDao = userDao;

    }

    @Override
    @UnitOfWork
    public Optional<UsersEntity> authenticate(BasicCredentials credentials) throws AuthenticationException {
        List<UsersEntity> usersEntityList = userDao.findByNamePassword(credentials.getUsername(), credentials.getPassword());
        if (usersEntityList.size() > 0) {
            return Optional.of(usersEntityList.get(0));
        }
        return Optional.empty();
    }

}
