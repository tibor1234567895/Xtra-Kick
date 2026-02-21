package androidx.lifecycle;

public enum s {
    DESTROYED,
    INITIALIZED,
    CREATED,
    STARTED,
    RESUMED;

    public final boolean a(s sVar) {
        return compareTo(sVar) >= 0;
    }
}
