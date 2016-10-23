package iu.edu.teambash.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class StormClusteringResourceTest {
    @ClassRule
    public static final ResourceTestRule RESOURCES = ResourceTestRule.builder()
            .addResource(new StormClusteringResource())
            .build();


    @Test
    public void testStormClustering() throws JsonProcessingException {
        final Response response = RESOURCES.client().target("/StormClustering")
                .request(MediaType.APPLICATION_XML)
                .get();

        assertThat(response.getStatusInfo()).isEqualTo(Response.Status.OK);
        assertThat(response.readEntity(String.class)).isEqualTo("<kml><b1>Data Here</b1></kml>");
    }
}