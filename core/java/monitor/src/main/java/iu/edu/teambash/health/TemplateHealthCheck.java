package iu.edu.teambash.health;

/**
 * Created by murugesm on 10/17/16.
 */
import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck {
    //private final Template template;

    public TemplateHealthCheck() {

    }

    @Override
    protected Result check() throws Exception {
        /*template.render(Optional.of("woo"));
        template.render(Optional.empty());*/
        return Result.healthy();
    }
}