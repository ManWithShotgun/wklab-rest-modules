/**
 * info.
 */
package ru.ilia.rest.exception;

/**
 * Created by ILIA on 12.04.2017.
 * @author ILIA
 */
public class NotImplementedException extends Exception {
    /**
     * Super method.
     * */
    public NotImplementedException() {
        super("SERVER ERROR: 501 Method not implemented");
    }
}
