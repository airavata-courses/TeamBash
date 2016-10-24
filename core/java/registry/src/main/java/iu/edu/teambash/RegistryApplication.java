package iu.edu.teambash;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import iu.edu.teambash.core.LogEntity;
import iu.edu.teambash.core.UsersEntity;
import iu.edu.teambash.db.LogDao;
import iu.edu.teambash.db.UserDao;
import iu.edu.teambash.resources.DisplayData;
import iu.edu.teambash.resources.UserResource;

public class RegistryApplication extends Application<RegistryConfiguration> {

    private final HibernateBundle<RegistryConfiguration> hibernateBundle =
            new HibernateBundle<RegistryConfiguration>(UsersEntity.class, LogEntity.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(RegistryConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    public static void main(final String[] args) throws Exception {
        new RegistryApplication().run(args);
    }

    @Override
    public String getName() {
        return "APIGateway";
    }

    @Override
    public void initialize(final Bootstrap<RegistryConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }


    @Override
    public void run(final RegistryConfiguration configuration,
                    final Environment environment) {
        final UserDao userDao = new UserDao(hibernateBundle.getSessionFactory());
        final LogDao logDao = new LogDao(hibernateBundle.getSessionFactory());
        final UserResource userResource = new UserResource(userDao);
        final DisplayData displayData = new DisplayData(logDao);
        environment.jersey().register(userResource);
        environment.jersey().register(displayData);
    }

}
