
package pl.infoshare.press.media.boundary;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author airhacks.com
 */
public class CircuitBreaker {

    private AtomicLong COUNTER = new AtomicLong();

    @AroundInvoke
    public Object watch(InvocationContext ic) throws Exception {
        Method method = ic.getMethod();
        try {
            if (COUNTER.get() > 2) {
                System.out.println("-- open: " + method);
                return null;
            }
            return ic.proceed();
        } catch (Exception ex) {
            System.out.println("-- Error happened " + COUNTER.get() + " " + method);
            COUNTER.incrementAndGet();
            throw ex;
        }
    }


}
