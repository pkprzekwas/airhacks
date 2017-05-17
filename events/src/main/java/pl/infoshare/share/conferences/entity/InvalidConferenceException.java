
package pl.infoshare.share.conferences.entity;

import javax.ejb.ApplicationException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author airhacks.com
 */
@ApplicationException(rollback = true)
public class InvalidConferenceException extends WebApplicationException {

    public InvalidConferenceException(String message) {
        super(Response.status(400).header("additional-info", message).build());
    }


}
