package iu.edu.teambash;

import iu.edu.teambash.auth.UserAuthenticator;
import iu.edu.teambash.core.User;
import iu.edu.teambash.health.TemplateHealthCheck;
import iu.edu.teambash.resources.APIGatewayResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class APIGatewayApplication extends Application<APIGatewayConfiguration> {

    public static void main(final String[] args) throws Exception {
        new APIGatewayApplication().run(args);
    }

    @Override
    public String getName() {
        return "APIGateway";
    }

    @Override
    public void initialize(final Bootstrap<APIGatewayConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final APIGatewayConfiguration configuration,
                    final Environment environment) {
        final APIGatewayResource resource = new APIGatewayResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(new UserAuthenticator())
                .setRealm("User Authenticator")
                .buildAuthFilter()));
        environment.jersey().register(resource);
    }

}
