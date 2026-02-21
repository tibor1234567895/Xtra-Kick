package androidx.lifecycle;

public enum r {
    ON_CREATE,
    ON_START,
    ON_RESUME,
    ON_PAUSE,
    ON_STOP,
    ON_DESTROY,
    ON_ANY;
    
    public static final p Companion = null;

    /* access modifiers changed from: public */
    static {
        Companion = new p(0);
    }

    public final s a() {
        switch (q.f1740a[ordinal()]) {
            case 1:
            case 2:
                return s.CREATED;
            case 3:
            case 4:
                return s.STARTED;
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                return s.RESUMED;
            case 6:
                return s.DESTROYED;
            default:
                throw new IllegalArgumentException(this + " has no target state");
        }
    }
}
