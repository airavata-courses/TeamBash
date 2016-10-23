package iu.edu.teambash;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import iu.edu.teambash.health.TemplateHealthCheck;
import iu.edu.teambash.resources.MonitorService;

public class MonitorApplication extends Application<MonitorConfiguration> {

    public static void main(final String[] args) throws Exception {
        new MonitorApplication().run(args);
    }

    @Override
    public String getName() {
        return "Monitor";
    }

    @Override
    public void initialize(final Bootstrap<MonitorConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final MonitorConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application

        final MonitorService service = new MonitorService();

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck();
        environment.healthChecks().register("template",healthCheck);
        environment.jersey().register(service);
    }

}
