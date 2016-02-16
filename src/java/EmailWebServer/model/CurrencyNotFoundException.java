/**
 * Thrown when inputcurrency or outputcurrency is not found.
 */
package EmailWebServer.model;

/**
 *
 * @author huan
 */
public class CurrencyNotFoundException extends Exception {
    private static final long serialVersionUID = 16247164402L;

    public CurrencyNotFoundException(String msg) {
        super(msg);
    }
}
