package f6;

import com.github.andreyasadchy.xtra.model.ui.StreamSortEnum;
import e6.x;
import n3.k4;
import n3.n4;
import n3.o4;
import xa.j;

public final class b extends n4 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5836b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f5837c;

    /* renamed from: d  reason: collision with root package name */
    public final x f5838d;

    public b(x xVar, StreamSortEnum streamSortEnum) {
        this.f5836b = 3;
        j.f("apiRepository", xVar);
        j.f("sort", streamSortEnum);
        this.f5838d = xVar;
        this.f5837c = streamSortEnum;
    }

    public final /* bridge */ /* synthetic */ Integer a(o4 o4Var) {
        switch (this.f5836b) {
            case 0:
                return c(o4Var);
            case 1:
                return c(o4Var);
            case 2:
                return c(o4Var);
            default:
                return c(o4Var);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0175 A[Catch:{ Exception -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x017d A[Catch:{ Exception -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0182 A[Catch:{ Exception -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0110 A[Catch:{ Exception -> 0x0118 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0113 A[Catch:{ Exception -> 0x0118 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x013b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(n3.g4 r11, pa.e r12) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.f5837c
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r10.f5836b
            r3 = 0
            e6.x r4 = r10.f5838d
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 1
            switch(r2) {
                case 0: goto L_0x00b9;
                case 1: goto L_0x0066;
                case 2: goto L_0x0013;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x011f
        L_0x0013:
            boolean r11 = r12 instanceof f6.x
            if (r11 == 0) goto L_0x0024
            r11 = r12
            f6.x r11 = (f6.x) r11
            int r2 = r11.f5900j
            r8 = r2 & r6
            if (r8 == 0) goto L_0x0024
            int r2 = r2 - r6
            r11.f5900j = r2
            goto L_0x0029
        L_0x0024:
            f6.x r11 = new f6.x
            r11.<init>(r10, r12)
        L_0x0029:
            java.lang.Object r12 = r11.f5898h
            int r2 = r11.f5900j
            if (r2 == 0) goto L_0x003b
            if (r2 != r7) goto L_0x0035
            hb.h0.O1(r12)     // Catch:{ Exception -> 0x005e }
            goto L_0x0055
        L_0x0035:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            r11.<init>(r5)
            throw r11
        L_0x003b:
            hb.h0.O1(r12)
            r12 = r0
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x005e }
            boolean r12 = fb.w.h(r12)     // Catch:{ Exception -> 0x005e }
            if (r12 == 0) goto L_0x004a
            ma.b0 r11 = ma.b0.f10801h     // Catch:{ Exception -> 0x005e }
            goto L_0x0058
        L_0x004a:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x005e }
            r11.f5900j = r7     // Catch:{ Exception -> 0x005e }
            java.io.Serializable r12 = r4.e(r0, r11)     // Catch:{ Exception -> 0x005e }
            if (r12 != r1) goto L_0x0055
            goto L_0x0065
        L_0x0055:
            r11 = r12
            java.util.List r11 = (java.util.List) r11     // Catch:{ Exception -> 0x005e }
        L_0x0058:
            n3.k4 r12 = new n3.k4     // Catch:{ Exception -> 0x005e }
            r12.<init>(r11, r3, r3)     // Catch:{ Exception -> 0x005e }
            goto L_0x0064
        L_0x005e:
            r11 = move-exception
            n3.h4 r12 = new n3.h4
            r12.<init>(r11)
        L_0x0064:
            r1 = r12
        L_0x0065:
            return r1
        L_0x0066:
            boolean r11 = r12 instanceof f6.w
            if (r11 == 0) goto L_0x0077
            r11 = r12
            f6.w r11 = (f6.w) r11
            int r2 = r11.f5897j
            r8 = r2 & r6
            if (r8 == 0) goto L_0x0077
            int r2 = r2 - r6
            r11.f5897j = r2
            goto L_0x007c
        L_0x0077:
            f6.w r11 = new f6.w
            r11.<init>(r10, r12)
        L_0x007c:
            java.lang.Object r12 = r11.f5895h
            int r2 = r11.f5897j
            if (r2 == 0) goto L_0x008e
            if (r2 != r7) goto L_0x0088
            hb.h0.O1(r12)     // Catch:{ Exception -> 0x00b1 }
            goto L_0x00a8
        L_0x0088:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            r11.<init>(r5)
            throw r11
        L_0x008e:
            hb.h0.O1(r12)
            r12 = r0
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x00b1 }
            boolean r12 = fb.w.h(r12)     // Catch:{ Exception -> 0x00b1 }
            if (r12 == 0) goto L_0x009d
            ma.b0 r11 = ma.b0.f10801h     // Catch:{ Exception -> 0x00b1 }
            goto L_0x00ab
        L_0x009d:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00b1 }
            r11.f5897j = r7     // Catch:{ Exception -> 0x00b1 }
            java.io.Serializable r12 = r4.f(r0, r11)     // Catch:{ Exception -> 0x00b1 }
            if (r12 != r1) goto L_0x00a8
            goto L_0x00b8
        L_0x00a8:
            r11 = r12
            java.util.List r11 = (java.util.List) r11     // Catch:{ Exception -> 0x00b1 }
        L_0x00ab:
            n3.k4 r12 = new n3.k4     // Catch:{ Exception -> 0x00b1 }
            r12.<init>(r11, r3, r3)     // Catch:{ Exception -> 0x00b1 }
            goto L_0x00b7
        L_0x00b1:
            r11 = move-exception
            n3.h4 r12 = new n3.h4
            r12.<init>(r11)
        L_0x00b7:
            r1 = r12
        L_0x00b8:
            return r1
        L_0x00b9:
            boolean r2 = r12 instanceof f6.a
            if (r2 == 0) goto L_0x00ca
            r2 = r12
            f6.a r2 = (f6.a) r2
            int r8 = r2.f5835j
            r9 = r8 & r6
            if (r9 == 0) goto L_0x00ca
            int r8 = r8 - r6
            r2.f5835j = r8
            goto L_0x00cf
        L_0x00ca:
            f6.a r2 = new f6.a
            r2.<init>(r10, r12)
        L_0x00cf:
            java.lang.Object r12 = r2.f5833h
            int r6 = r2.f5835j
            if (r6 == 0) goto L_0x00e1
            if (r6 != r7) goto L_0x00db
            hb.h0.O1(r12)     // Catch:{ Exception -> 0x0118 }
            goto L_0x00fd
        L_0x00db:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            r11.<init>(r5)
            throw r11
        L_0x00e1:
            hb.h0.O1(r12)
            java.lang.Object r11 = r11.a()     // Catch:{ Exception -> 0x0118 }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ Exception -> 0x0118 }
            if (r11 == 0) goto L_0x00f1
            int r11 = r11.intValue()     // Catch:{ Exception -> 0x0118 }
            goto L_0x00f2
        L_0x00f1:
            r11 = 1
        L_0x00f2:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0118 }
            r2.f5835j = r7     // Catch:{ Exception -> 0x0118 }
            java.io.Serializable r12 = r4.a(r11, r0, r2)     // Catch:{ Exception -> 0x0118 }
            if (r12 != r1) goto L_0x00fd
            goto L_0x011e
        L_0x00fd:
            la.i r12 = (la.i) r12     // Catch:{ Exception -> 0x0118 }
            n3.k4 r1 = new n3.k4     // Catch:{ Exception -> 0x0118 }
            java.lang.Object r11 = r12.f9799h     // Catch:{ Exception -> 0x0118 }
            java.lang.Object r12 = r12.f9800i
            java.util.List r11 = (java.util.List) r11     // Catch:{ Exception -> 0x0118 }
            r0 = r12
            java.lang.Number r0 = (java.lang.Number) r0     // Catch:{ Exception -> 0x0118 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x0118 }
            if (r0 == 0) goto L_0x0113
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ Exception -> 0x0118 }
            goto L_0x0114
        L_0x0113:
            r12 = r3
        L_0x0114:
            r1.<init>(r11, r3, r12)     // Catch:{ Exception -> 0x0118 }
            goto L_0x011e
        L_0x0118:
            r11 = move-exception
            n3.h4 r1 = new n3.h4
            r1.<init>(r11)
        L_0x011e:
            return r1
        L_0x011f:
            boolean r2 = r12 instanceof f6.z
            if (r2 == 0) goto L_0x0130
            r2 = r12
            f6.z r2 = (f6.z) r2
            int r8 = r2.f5905k
            r9 = r8 & r6
            if (r9 == 0) goto L_0x0130
            int r8 = r8 - r6
            r2.f5905k = r8
            goto L_0x0135
        L_0x0130:
            f6.z r2 = new f6.z
            r2.<init>(r10, r12)
        L_0x0135:
            java.lang.Object r12 = r2.f5903i
            int r6 = r2.f5905k
            if (r6 == 0) goto L_0x0149
            if (r6 != r7) goto L_0x0143
            int r11 = r2.f5902h
            hb.h0.O1(r12)     // Catch:{ Exception -> 0x018c }
            goto L_0x0169
        L_0x0143:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            r11.<init>(r5)
            throw r11
        L_0x0149:
            hb.h0.O1(r12)
            java.lang.Object r11 = r11.a()     // Catch:{ Exception -> 0x018c }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ Exception -> 0x018c }
            if (r11 == 0) goto L_0x0159
            int r11 = r11.intValue()     // Catch:{ Exception -> 0x018c }
            goto L_0x015a
        L_0x0159:
            r11 = 1
        L_0x015a:
            java.lang.String r12 = ""
            com.github.andreyasadchy.xtra.model.ui.StreamSortEnum r0 = (com.github.andreyasadchy.xtra.model.ui.StreamSortEnum) r0     // Catch:{ Exception -> 0x018c }
            r2.f5902h = r11     // Catch:{ Exception -> 0x018c }
            r2.f5905k = r7     // Catch:{ Exception -> 0x018c }
            java.io.Serializable r12 = r4.c(r11, r12, r0, r2)     // Catch:{ Exception -> 0x018c }
            if (r12 != r1) goto L_0x0169
            goto L_0x0192
        L_0x0169:
            la.p r12 = (la.p) r12     // Catch:{ Exception -> 0x018c }
            n3.k4 r1 = new n3.k4     // Catch:{ Exception -> 0x018c }
            java.lang.Object r0 = r12.f9809h     // Catch:{ Exception -> 0x018c }
            java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x018c }
            java.lang.Object r2 = r12.f9810i     // Catch:{ Exception -> 0x018c }
            if (r2 == 0) goto L_0x017d
            int r2 = r11 + -1
            java.lang.Integer r4 = new java.lang.Integer     // Catch:{ Exception -> 0x018c }
            r4.<init>(r2)     // Catch:{ Exception -> 0x018c }
            goto L_0x017e
        L_0x017d:
            r4 = r3
        L_0x017e:
            java.lang.Object r12 = r12.f9811j     // Catch:{ Exception -> 0x018c }
            if (r12 == 0) goto L_0x0188
            int r11 = r11 + r7
            java.lang.Integer r3 = new java.lang.Integer     // Catch:{ Exception -> 0x018c }
            r3.<init>(r11)     // Catch:{ Exception -> 0x018c }
        L_0x0188:
            r1.<init>(r0, r4, r3)     // Catch:{ Exception -> 0x018c }
            goto L_0x0192
        L_0x018c:
            r11 = move-exception
            n3.h4 r1 = new n3.h4
            r1.<init>(r11)
        L_0x0192:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.b.b(n3.g4, pa.e):java.lang.Object");
    }

    public final Integer c(o4 o4Var) {
        int i10;
        Integer num;
        Integer num2;
        int i11;
        Integer num3;
        Integer num4;
        int i12;
        Integer num5;
        Integer num6;
        int i13;
        Integer num7;
        Integer num8;
        Integer num9 = o4Var.f11383b;
        switch (this.f5836b) {
            case 0:
                if (num9 == null) {
                    return null;
                }
                k4 a10 = o4Var.a(num9.intValue());
                if (a10 != null && (num4 = (Integer) a10.f11288b) != null) {
                    i11 = num4.intValue() + 1;
                } else if (a10 == null || (num3 = (Integer) a10.f11289c) == null) {
                    return null;
                } else {
                    i11 = num3.intValue() - 1;
                }
                return Integer.valueOf(i11);
            case 1:
                if (num9 == null) {
                    return null;
                }
                k4 a11 = o4Var.a(num9.intValue());
                if (a11 != null && (num6 = (Integer) a11.f11288b) != null) {
                    i12 = num6.intValue() + 1;
                } else if (a11 == null || (num5 = (Integer) a11.f11289c) == null) {
                    return null;
                } else {
                    i12 = num5.intValue() - 1;
                }
                return Integer.valueOf(i12);
            case 2:
                if (num9 == null) {
                    return null;
                }
                k4 a12 = o4Var.a(num9.intValue());
                if (a12 != null && (num8 = (Integer) a12.f11288b) != null) {
                    i13 = num8.intValue() + 1;
                } else if (a12 == null || (num7 = (Integer) a12.f11289c) == null) {
                    return null;
                } else {
                    i13 = num7.intValue() - 1;
                }
                return Integer.valueOf(i13);
            default:
                if (num9 == null) {
                    return null;
                }
                k4 a13 = o4Var.a(num9.intValue());
                if (a13 != null && (num2 = (Integer) a13.f11288b) != null) {
                    i10 = num2.intValue() + 1;
                } else if (a13 == null || (num = (Integer) a13.f11289c) == null) {
                    return null;
                } else {
                    i10 = num.intValue() - 1;
                }
                return Integer.valueOf(i10);
        }
    }

    public b(String str, x xVar, int i10) {
        this.f5836b = i10;
        if (i10 == 1) {
            j.f("query", str);
            j.f("apiRepository", xVar);
            this.f5837c = str;
            this.f5838d = xVar;
        } else if (i10 != 2) {
            j.f("channelSlug", str);
            j.f("apiRepository", xVar);
            this.f5837c = str;
            this.f5838d = xVar;
        } else {
            j.f("query", str);
            j.f("apiRepository", xVar);
            this.f5837c = str;
            this.f5838d = xVar;
        }
    }
}
