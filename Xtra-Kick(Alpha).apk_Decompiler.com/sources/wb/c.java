package wb;

public enum c {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    

    /* renamed from: i  reason: collision with root package name */
    public static final b f16191i = null;

    /* renamed from: h  reason: collision with root package name */
    public final int f16199h;

    /* access modifiers changed from: public */
    static {
        f16191i = new b(0);
    }

    /* access modifiers changed from: public */
    c(int i10) {
        this.f16199h = i10;
    }
}
