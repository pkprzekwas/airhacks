
package pl.infoshare.press.media.boundary;

import com.airhacks.porcupine.execution.boundary.Dedicated;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 *
 * @author airhacks.com
 */
@Path("coverages")
public class MediaCoveragesResource {

    @Inject
    MediaCoverageAgent agent;

    @Inject
    @Dedicated
    ExecutorService conferencesPool;

    @GET
    public void all(@Suspended AsyncResponse response) {
        response.setTimeout(2, TimeUnit.SECONDS);
        supplyAsync(this::getContent, conferencesPool).thenAccept(response::resume);
    }

    String getContent() {
        return "press: -> " + this.agent.all();
    }


}
