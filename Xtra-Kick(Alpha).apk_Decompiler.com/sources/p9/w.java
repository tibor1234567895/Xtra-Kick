package p9;

public final class w {
    private w() {
    }

    public /* synthetic */ w(int i10) {
        this();
    }

    public static x a(int i10) {
        switch (i10) {
            case 1:
                return x.QUEUED;
            case 2:
                return x.DOWNLOADING;
            case 3:
                return x.PAUSED;
            case 4:
                return x.COMPLETED;
            case Constants.MAX_COMPATIBILITY_VERSION:
                return x.CANCELLED;
            case 6:
                return x.FAILED;
            case 7:
                return x.REMOVED;
            case 8:
                return x.DELETED;
            case 9:
                return x.ADDED;
            default:
                return x.NONE;
        }
    }
}
