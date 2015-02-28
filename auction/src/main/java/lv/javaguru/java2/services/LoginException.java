package lv.javaguru.java2.services;

/**
 * Created by Vladislav on 2/28/2015.
 */
public class LoginException extends Exception {

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException(Throwable cause) {
        super(cause);
    }

}
