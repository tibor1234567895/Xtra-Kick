package m8;

public final class l extends Exception {
    public l(Exception exc) {
        super("Error thrown initializing StaticLayout " + exc.getMessage(), exc);
    }
}
