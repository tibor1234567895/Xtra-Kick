package c9;

import b4.e0;

public final class t extends a {

    /* renamed from: j  reason: collision with root package name */
    public final CharSequence f3046j;

    /* renamed from: k  reason: collision with root package name */
    public final g f3047k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f3048l;

    /* renamed from: m  reason: collision with root package name */
    public int f3049m = 0;

    /* renamed from: n  reason: collision with root package name */
    public int f3050n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ e0 f3051o;

    public t(e0 e0Var, u uVar, CharSequence charSequence) {
        this.f3051o = e0Var;
        this.f3047k = uVar.f3052a;
        this.f3048l = false;
        this.f3050n = uVar.f3054c;
        this.f3046j = charSequence;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        r3 = r7.f3047k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r0 >= r1) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r3.b(r4.charAt(r0)) == false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (r1 <= r0) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        r5 = r1 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004e, code lost:
        if (r3.b(r4.charAt(r5)) == false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0050, code lost:
        r1 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        if (r7.f3048l == false) goto L_0x0059;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a() {
        /*
            r7 = this;
        L_0x0000:
            int r0 = r7.f3049m
        L_0x0002:
            int r1 = r7.f3049m
            r2 = -1
            if (r1 == r2) goto L_0x0080
            b4.e0 r3 = r7.f3051o
            java.lang.Object r3 = r3.f2538i
            c9.g r3 = (c9.g) r3
            java.lang.CharSequence r4 = r7.f3046j
            int r1 = r3.a(r1, r4)
            if (r1 != r2) goto L_0x001c
            int r1 = r4.length()
            r7.f3049m = r2
            goto L_0x0020
        L_0x001c:
            int r3 = r1 + 1
            r7.f3049m = r3
        L_0x0020:
            int r3 = r7.f3049m
            if (r3 != r0) goto L_0x0031
            int r3 = r3 + 1
            r7.f3049m = r3
            int r1 = r4.length()
            if (r3 <= r1) goto L_0x0002
            r7.f3049m = r2
            goto L_0x0002
        L_0x0031:
            c9.g r3 = r7.f3047k
            if (r0 >= r1) goto L_0x0042
            char r5 = r4.charAt(r0)
            boolean r5 = r3.b(r5)
            if (r5 == 0) goto L_0x0042
            int r0 = r0 + 1
            goto L_0x0031
        L_0x0042:
            if (r1 <= r0) goto L_0x0052
            int r5 = r1 + -1
            char r6 = r4.charAt(r5)
            boolean r6 = r3.b(r6)
            if (r6 == 0) goto L_0x0052
            r1 = r5
            goto L_0x0042
        L_0x0052:
            boolean r5 = r7.f3048l
            if (r5 == 0) goto L_0x0059
            if (r0 != r1) goto L_0x0059
            goto L_0x0000
        L_0x0059:
            int r5 = r7.f3050n
            r6 = 1
            if (r5 != r6) goto L_0x0074
            int r1 = r4.length()
            r7.f3049m = r2
        L_0x0064:
            if (r1 <= r0) goto L_0x0077
            int r2 = r1 + -1
            char r5 = r4.charAt(r2)
            boolean r5 = r3.b(r5)
            if (r5 == 0) goto L_0x0077
            r1 = r2
            goto L_0x0064
        L_0x0074:
            int r5 = r5 - r6
            r7.f3050n = r5
        L_0x0077:
            java.lang.CharSequence r0 = r4.subSequence(r0, r1)
            java.lang.String r0 = r0.toString()
            goto L_0x0084
        L_0x0080:
            r0 = 3
            r7.f3028h = r0
            r0 = 0
        L_0x0084:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c9.t.a():java.lang.String");
    }
}
