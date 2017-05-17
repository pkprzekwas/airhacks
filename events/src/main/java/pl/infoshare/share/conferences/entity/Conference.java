
package pl.infoshare.share.conferences.entity;

import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author airhacks.com
 */
public class Conference {

    private String name;
    private String description;

    public Conference(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public Conference(JsonObject input) {
        this.name = input.getString("name");
        this.description = input.getString("desc", null);
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder().
                add("name", this.name).add("desc", this.description).
                build();
    }


}
