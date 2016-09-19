package iu.edu.teambash;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import iu.edu.teambash.auth.UserAuthenticator;
import iu.edu.teambash.core.User;
import iu.edu.teambash.db.UserDao;
import iu.edu.teambash.health.TemplateHealthCheck;
import iu.edu.teambash.resources.DataIngestorResource;
import iu.edu.teambash.resources.LoginResource;

public class APIGatewayApplication extends Application<APIGatewayConfiguration> {

    private final HibernateBundle<APIGatewayConfiguration> hibernateBundle =
            new HibernateBundle<APIGatewayConfiguration>(User.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(APIGatewayConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    public static void main(final String[] args) throws Exception {
        new APIGatewayApplication().run(args);
    }

    @Override
    public String getName() {
        return "APIGateway";
    }

    @Override
    public void initialize(final Bootstrap<APIGatewayConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }


    @Override
    public void run(final APIGatewayConfiguration configuration,
                    final Environment environment) {
        final UserDao dao = new UserDao(hibernateBundle.getSessionFactory());
        final LoginResource resource = new LoginResource(dao
        );
        final DataIngestorResource dataIngestorResource = new DataIngestorResource();
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck("hello");
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(new UserAuthenticator())
                .setRealm("User Authenticator")
                .buildAuthFilter()));
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
        environment.jersey().register(resource);
        environment.jersey().register(dataIngestorResource);
    }

}
