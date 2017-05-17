
package pl.infoshare.share.conferences.boundary;

import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;
import pl.infoshare.share.conferences.entity.Conference;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class ConferenceStore {

    public List<Conference> all() {
        return Arrays.asList(new Conference("infoshare", "startup && co"),
                new Conference("geecon", "geeks everywhere"));
    }

    public void save(Conference conference) {
        conference.validate();
    }

}
