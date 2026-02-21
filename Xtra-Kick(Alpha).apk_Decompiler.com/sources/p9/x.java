package p9;

public enum x {
    NONE(0),
    QUEUED(1),
    DOWNLOADING(2),
    PAUSED(3),
    COMPLETED(4),
    CANCELLED(5),
    FAILED(6),
    REMOVED(7),
    DELETED(8),
    ADDED(9);
    

    /* renamed from: t  reason: collision with root package name */
    public static final w f12743t = null;

    /* renamed from: h  reason: collision with root package name */
    public final int f12744h;

    /* access modifiers changed from: public */
    static {
        f12743t = new w(0);
    }

    /* access modifiers changed from: public */
    x(int i10) {
        this.f12744h = i10;
    }
}
