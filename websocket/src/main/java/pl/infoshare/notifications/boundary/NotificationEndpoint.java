
package pl.infoshare.notifications.boundary;

import java.io.IOException;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author airhacks.com
 */
@Startup
@Singleton
@ServerEndpoint("/notifications")
public class NotificationEndpoint {

    private Session session;

    @OnOpen
    public void onConnect(Session session) {
        System.out.println("session = " + session);
        this.session = session;
    }

    @OnMessage
    public void onMessage(String message) {
        if (this.session != null && this.session.isOpen()) {
            try {
                this.session.getBasicRemote().sendText("Hello from server: " + message);
            } catch (IOException ex) {
                Logger.getLogger(NotificationEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }


    @Schedule(minute = "*", second = "*/5", hour = "*")
    public void sendPeriodically() {
        if (this.session != null && this.session.isOpen()) {
            try {
                this.session.getBasicRemote().sendText("Hello from infoshare " + LocalTime.now());
            } catch (IOException ex) {
                Logger.getLogger(NotificationEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }



}
