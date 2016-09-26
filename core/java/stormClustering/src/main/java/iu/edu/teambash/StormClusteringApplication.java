package iu.edu.teambash;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import iu.edu.teambash.resources.StormClusteringResource;

public class StormClusteringApplication extends Application<StormClusteringConfiguration> {

    public static void main(final String[] args) throws Exception {
        new StormClusteringApplication().run(args);
    }

    @Override
    public String getName() {
        return "StormClustering";
    }

    @Override
    public void initialize(final Bootstrap<StormClusteringConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final StormClusteringConfiguration configuration,
                    final Environment environment) {
        final StormClusteringResource clusteringResource = new StormClusteringResource();
        environment.jersey().register(clusteringResource);
    }

}
