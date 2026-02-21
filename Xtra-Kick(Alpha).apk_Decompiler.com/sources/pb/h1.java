package pb;

public enum h1 {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic"),
    HTTP_3("h3");
    

    /* renamed from: i  reason: collision with root package name */
    public static final g1 f12866i = null;

    /* renamed from: h  reason: collision with root package name */
    public final String f12875h;

    /* access modifiers changed from: public */
    static {
        f12866i = new g1(0);
    }

    /* access modifiers changed from: public */
    h1(String str) {
        this.f12875h = str;
    }

    public final String toString() {
        return this.f12875h;
    }
}
