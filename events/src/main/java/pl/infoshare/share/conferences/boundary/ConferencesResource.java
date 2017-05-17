
package pl.infoshare.share.conferences.boundary;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import pl.infoshare.share.conferences.entity.Conference;

@Stateless
@Path("conferences")
public class ConferencesResource {

    @Inject
    ConferenceStore store;

    @POST
    public void save(JsonObject input) {
        this.store.save(new Conference(input));
    }


    @GET
    public JsonArray all() {
        JsonArrayBuilder result = Json.createArrayBuilder();
        List<Conference> all = store.all();
        all.stream().map(Conference::toJson).forEach(result::add);
        return result.build();

    }


}
