package iu.edu.teambash;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import iu.edu.teambash.health.TemplateHealthCheck;
import iu.edu.teambash.resources.*;

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
    }


    @Override
    public void run(final APIGatewayConfiguration configuration,
                    final Environment environment) {
        final DataIngestorResource dataIngestorResource = new DataIngestorResource();
        final StormDetectionResource stormDetectionResource = new StormDetectionResource();
        final ForecastTriggerResource forecastTriggerResource = new ForecastTriggerResource();
        final StormClusteringResource clusteringResource = new StormClusteringResource();
        final LoginResource loginResource = new LoginResource();
        final RunWeatherForecastResource runWeatherForecastResource = new RunWeatherForecastResource();
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck("hello");
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(dataIngestorResource);
        environment.jersey().register(stormDetectionResource);
        environment.jersey().register(forecastTriggerResource);
        environment.jersey().register(clusteringResource);
        environment.jersey().register(loginResource);
        environment.jersey().register(runWeatherForecastResource);
    }

}
