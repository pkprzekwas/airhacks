/*
 */
package pl.infoshare.events.conferences.boundary;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class ConferenceResourceIT {

    private Client client;
    private WebTarget tut;

    @Before
    public void initClient() {
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:8080/events/resources/conferences");
    }

    @Test
    public void all() {
        Response allResponse = this.tut.request().get();
        assertThat(allResponse.getStatus(), is(200));
        JsonArray conferences = allResponse.readEntity(JsonArray.class);
        assertNotNull(conferences);
        System.out.println("conferences = " + conferences);
    }

    @Test
    public void saveInvalid() {
        JsonObject conference = Json.createObjectBuilder().add("desc", "nice").build();
        Response response = this.tut.request().post(Entity.json(conference));
        assertThat(response.getStatus(), is(204));

    }




}
