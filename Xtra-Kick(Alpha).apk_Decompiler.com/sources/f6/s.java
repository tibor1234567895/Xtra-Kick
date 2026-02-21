package f6;

import com.github.andreyasadchy.xtra.model.ui.StreamSortEnum;
import e6.x;
import n3.k4;
import n3.n4;
import n3.o4;
import xa.j;

public final class s extends n4 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5883b = 1;

    /* renamed from: c  reason: collision with root package name */
    public final String f5884c;

    /* renamed from: d  reason: collision with root package name */
    public final x f5885d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f5886e;

    public s(String str, x xVar, StreamSortEnum streamSortEnum) {
        j.f("apiRepository", xVar);
        j.f("sort", streamSortEnum);
        this.f5884c = str;
        this.f5885d = xVar;
        this.f5886e = streamSortEnum;
    }

    public final /* bridge */ /* synthetic */ Integer a(o4 o4Var) {
        switch (this.f5883b) {
            case 0:
                return c(o4Var);
            default:
                return c(o4Var);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0074 A[Catch:{ Exception -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0077 A[Catch:{ Exception -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d7 A[Catch:{ Exception -> 0x00ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00df A[Catch:{ Exception -> 0x00ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e4 A[Catch:{ Exception -> 0x00ee }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(n3.g4 r12, pa.e r13) {
        /*
            r11 = this;
            java.lang.Object r0 = r11.f5886e
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r11.f5883b
            r3 = 0
            java.lang.String r4 = r11.f5884c
            e6.x r5 = r11.f5885d
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = 1
            switch(r2) {
                case 0: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0083
        L_0x0015:
            boolean r2 = r13 instanceof f6.r
            if (r2 == 0) goto L_0x0026
            r2 = r13
            f6.r r2 = (f6.r) r2
            int r9 = r2.f5882j
            r10 = r9 & r7
            if (r10 == 0) goto L_0x0026
            int r9 = r9 - r7
            r2.f5882j = r9
            goto L_0x002b
        L_0x0026:
            f6.r r2 = new f6.r
            r2.<init>(r11, r13)
        L_0x002b:
            java.lang.Object r13 = r2.f5880h
            int r7 = r2.f5882j
            if (r7 == 0) goto L_0x003d
            if (r7 != r8) goto L_0x0037
            hb.h0.O1(r13)     // Catch:{ Exception -> 0x007c }
            goto L_0x0061
        L_0x0037:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            r12.<init>(r6)
            throw r12
        L_0x003d:
            hb.h0.O1(r13)
            java.lang.Object r12 = r12.a()
            java.lang.Integer r12 = (java.lang.Integer) r12
            if (r12 == 0) goto L_0x004d
            int r12 = r12.intValue()
            goto L_0x004e
        L_0x004d:
            r12 = 1
        L_0x004e:
            if (r4 != 0) goto L_0x0052
            java.lang.String r4 = ""
        L_0x0052:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x007c }
            if (r0 != 0) goto L_0x0058
            java.lang.String r0 = "all"
        L_0x0058:
            r2.f5882j = r8     // Catch:{ Exception -> 0x007c }
            java.io.Serializable r13 = r5.b(r12, r4, r0, r2)     // Catch:{ Exception -> 0x007c }
            if (r13 != r1) goto L_0x0061
            goto L_0x0082
        L_0x0061:
            la.i r13 = (la.i) r13     // Catch:{ Exception -> 0x007c }
            n3.k4 r1 = new n3.k4     // Catch:{ Exception -> 0x007c }
            java.lang.Object r12 = r13.f9799h     // Catch:{ Exception -> 0x007c }
            java.lang.Object r13 = r13.f9800i
            java.util.List r12 = (java.util.List) r12     // Catch:{ Exception -> 0x007c }
            r0 = r13
            java.lang.Number r0 = (java.lang.Number) r0     // Catch:{ Exception -> 0x007c }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x007c }
            if (r0 == 0) goto L_0x0077
            java.lang.Integer r13 = (java.lang.Integer) r13     // Catch:{ Exception -> 0x007c }
            goto L_0x0078
        L_0x0077:
            r13 = r3
        L_0x0078:
            r1.<init>(r12, r3, r13)     // Catch:{ Exception -> 0x007c }
            goto L_0x0082
        L_0x007c:
            r12 = move-exception
            n3.h4 r1 = new n3.h4
            r1.<init>(r12)
        L_0x0082:
            return r1
        L_0x0083:
            boolean r2 = r13 instanceof f6.t
            if (r2 == 0) goto L_0x0094
            r2 = r13
            f6.t r2 = (f6.t) r2
            int r9 = r2.f5890k
            r10 = r9 & r7
            if (r10 == 0) goto L_0x0094
            int r9 = r9 - r7
            r2.f5890k = r9
            goto L_0x0099
        L_0x0094:
            f6.t r2 = new f6.t
            r2.<init>(r11, r13)
        L_0x0099:
            java.lang.Object r13 = r2.f5888i
            int r7 = r2.f5890k
            if (r7 == 0) goto L_0x00ad
            if (r7 != r8) goto L_0x00a7
            int r12 = r2.f5887h
            hb.h0.O1(r13)     // Catch:{ Exception -> 0x00ee }
            goto L_0x00cb
        L_0x00a7:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            r12.<init>(r6)
            throw r12
        L_0x00ad:
            hb.h0.O1(r13)
            java.lang.Object r12 = r12.a()     // Catch:{ Exception -> 0x00ee }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ Exception -> 0x00ee }
            if (r12 == 0) goto L_0x00bd
            int r12 = r12.intValue()     // Catch:{ Exception -> 0x00ee }
            goto L_0x00be
        L_0x00bd:
            r12 = 1
        L_0x00be:
            com.github.andreyasadchy.xtra.model.ui.StreamSortEnum r0 = (com.github.andreyasadchy.xtra.model.ui.StreamSortEnum) r0     // Catch:{ Exception -> 0x00ee }
            r2.f5887h = r12     // Catch:{ Exception -> 0x00ee }
            r2.f5890k = r8     // Catch:{ Exception -> 0x00ee }
            java.io.Serializable r13 = r5.c(r12, r4, r0, r2)     // Catch:{ Exception -> 0x00ee }
            if (r13 != r1) goto L_0x00cb
            goto L_0x00f4
        L_0x00cb:
            la.p r13 = (la.p) r13     // Catch:{ Exception -> 0x00ee }
            n3.k4 r1 = new n3.k4     // Catch:{ Exception -> 0x00ee }
            java.lang.Object r0 = r13.f9809h     // Catch:{ Exception -> 0x00ee }
            java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x00ee }
            java.lang.Object r2 = r13.f9810i     // Catch:{ Exception -> 0x00ee }
            if (r2 == 0) goto L_0x00df
            int r2 = r12 + -1
            java.lang.Integer r4 = new java.lang.Integer     // Catch:{ Exception -> 0x00ee }
            r4.<init>(r2)     // Catch:{ Exception -> 0x00ee }
            goto L_0x00e0
        L_0x00df:
            r4 = r3
        L_0x00e0:
            java.lang.Object r13 = r13.f9811j     // Catch:{ Exception -> 0x00ee }
            if (r13 == 0) goto L_0x00ea
            int r12 = r12 + r8
            java.lang.Integer r3 = new java.lang.Integer     // Catch:{ Exception -> 0x00ee }
            r3.<init>(r12)     // Catch:{ Exception -> 0x00ee }
        L_0x00ea:
            r1.<init>(r0, r4, r3)     // Catch:{ Exception -> 0x00ee }
            goto L_0x00f4
        L_0x00ee:
            r12 = move-exception
            n3.h4 r1 = new n3.h4
            r1.<init>(r12)
        L_0x00f4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.s.b(n3.g4, pa.e):java.lang.Object");
    }

    public final Integer c(o4 o4Var) {
        int i10;
        Integer num;
        Integer num2;
        int i11;
        Integer num3;
        Integer num4;
        Integer num5 = o4Var.f11383b;
        switch (this.f5883b) {
            case 0:
                if (num5 == null) {
                    return null;
                }
                k4 a10 = o4Var.a(num5.intValue());
                if (a10 != null && (num4 = (Integer) a10.f11288b) != null) {
                    i11 = num4.intValue() + 1;
                } else if (a10 == null || (num3 = (Integer) a10.f11289c) == null) {
                    return null;
                } else {
                    i11 = num3.intValue() - 1;
                }
                return Integer.valueOf(i11);
            default:
                if (num5 == null) {
                    return null;
                }
                k4 a11 = o4Var.a(num5.intValue());
                if (a11 != null && (num2 = (Integer) a11.f11288b) != null) {
                    i10 = num2.intValue() + 1;
                } else if (a11 == null || (num = (Integer) a11.f11289c) == null) {
                    return null;
                } else {
                    i10 = num.intValue() - 1;
                }
                return Integer.valueOf(i10);
        }
    }

    public s(String str, x xVar, String str2) {
        j.f("apiRepository", xVar);
        this.f5884c = str;
        this.f5885d = xVar;
        this.f5886e = str2;
    }
}
