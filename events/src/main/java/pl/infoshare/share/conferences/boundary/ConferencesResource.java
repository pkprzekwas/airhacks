
package pl.infoshare.share.conferences.boundary;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("conferences")
public class ConferencesResource {

    @GET
    public JsonArray all() {
        try (JsonReader reader = Json.createReader(this.getClass().getResourceAsStream("/conferences.json"))) {
            return reader.readArray();
        }
    }


}
