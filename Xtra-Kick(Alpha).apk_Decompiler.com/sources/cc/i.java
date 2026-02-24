package cc;

public final class i {

    /* renamed from: g  reason: collision with root package name */
    public static final h f3116g = new h(0);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f3117a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f3118b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f3119c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f3120d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f3121e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f3122f;

    public i() {
        this(false, (Integer) null, false, (Integer) null, false, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (cc.i) r5;
        r1 = r5.f3117a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof cc.i
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            cc.i r5 = (cc.i) r5
            boolean r1 = r5.f3117a
            boolean r3 = r4.f3117a
            if (r3 == r1) goto L_0x0013
            return r2
        L_0x0013:
            java.lang.Integer r1 = r4.f3118b
            java.lang.Integer r3 = r5.f3118b
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x001e
            return r2
        L_0x001e:
            boolean r1 = r4.f3119c
            boolean r3 = r5.f3119c
            if (r1 == r3) goto L_0x0025
            return r2
        L_0x0025:
            java.lang.Integer r1 = r4.f3120d
            java.lang.Integer r3 = r5.f3120d
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x0030
            return r2
        L_0x0030:
            boolean r1 = r4.f3121e
            boolean r3 = r5.f3121e
            if (r1 == r3) goto L_0x0037
            return r2
        L_0x0037:
            boolean r1 = r4.f3122f
            boolean r5 = r5.f3122f
            if (r1 == r5) goto L_0x003e
            return r2
        L_0x003e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.i.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        boolean z10 = true;
        boolean z11 = this.f3117a;
        if (z11) {
            z11 = true;
        }
        int i10 = (z11 ? 1 : 0) * true;
        int i11 = 0;
        Integer num = this.f3118b;
        int hashCode = (i10 + (num == null ? 0 : num.hashCode())) * 31;
        boolean z12 = this.f3119c;
        if (z12) {
            z12 = true;
        }
        int i12 = (hashCode + (z12 ? 1 : 0)) * 31;
        Integer num2 = this.f3120d;
        if (num2 != null) {
            i11 = num2.hashCode();
        }
        int i13 = (i12 + i11) * 31;
        boolean z13 = this.f3121e;
        if (z13) {
            z13 = true;
        }
        int i14 = (i13 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.f3122f;
        if (!z14) {
            z10 = z14;
        }
        return i14 + (z10 ? 1 : 0);
    }

    public final String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.f3117a + ", clientMaxWindowBits=" + this.f3118b + ", clientNoContextTakeover=" + this.f3119c + ", serverMaxWindowBits=" + this.f3120d + ", serverNoContextTakeover=" + this.f3121e + ", unknownValues=" + this.f3122f + ')';
    }

    public i(boolean z10, Integer num, boolean z11, Integer num2, boolean z12, boolean z13) {
        this.f3117a = z10;
        this.f3118b = num;
        this.f3119c = z11;
        this.f3120d = num2;
        this.f3121e = z12;
        this.f3122f = z13;
    }
}
