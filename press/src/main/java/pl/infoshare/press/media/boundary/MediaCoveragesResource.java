
package pl.infoshare.press.media.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Path("coverages")
public class MediaCoveragesResource {

    @Inject
    MediaCoverageAgent agent;

    @GET
    public String all() {
        return "press: -> " + this.agent.all();
    }


}
