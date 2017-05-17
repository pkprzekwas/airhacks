
package pl.infoshare.press.media.boundary;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
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

    @Resource
    ManagedExecutorService mes;

    @GET
    public void all(@Suspended AsyncResponse response) {
        response.setTimeout(2, TimeUnit.SECONDS);
        supplyAsync(this::getContent, mes).thenAccept(response::resume);
    }

    String getContent() {
        return "press: -> " + this.agent.all();
    }


}
