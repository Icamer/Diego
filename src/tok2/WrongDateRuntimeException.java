package tok2;

/**
 * Created by icamer on 15.11.16.
 */

public class WrongDateRuntimeException extends RuntimeException {
    public WrongDateRuntimeException(String s) {
        super(s);
//        System.exit(0);
    }

    public WrongDateRuntimeException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public WrongDateRuntimeException(Throwable throwable) {
        super(throwable);
    }
}