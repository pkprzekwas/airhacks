
package pl.infoshare.press.media.boundary;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.interceptor.Interceptors;
import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author airhacks.com
 */
@Singleton
@Interceptors(CircuitBreaker.class)
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class MediaCoverageAgent {
    private Client client;
    private WebTarget tut;

    @PostConstruct
    public void initClient() {
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://iev:8080/events/resources/conferences");
    }

    public String all() {
        JsonArray conferences = this.tut.request(MediaType.APPLICATION_JSON).
                get(JsonArray.class);
        //return conferences.toString();
        throw new IllegalStateException("conference is over");
    }
}
