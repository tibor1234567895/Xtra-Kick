package f6;

import e6.e1;
import e6.x;
import n3.k4;
import n3.n4;
import n3.o4;
import xa.j;

public final class k extends n4 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5861b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final Object f5862c;

    public k(x xVar) {
        j.f("apiRepository", xVar);
        this.f5862c = xVar;
    }

    public final /* bridge */ /* synthetic */ Integer a(o4 o4Var) {
        switch (this.f5861b) {
            case 0:
                return c(o4Var);
            default:
                return c(o4Var);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:11|12|13|33|34|35|36|78) */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bf, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        return new n3.h4(r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00b6 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d A[Catch:{ Exception -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ad A[Catch:{ Exception -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x011c A[Catch:{ Exception -> 0x013c }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0128 A[Catch:{ Exception -> 0x013c }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x012d A[Catch:{ Exception -> 0x013c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(n3.g4 r25, pa.e r26) {
        /*
            r24 = this;
            r1 = r24
            r0 = r26
            qa.a r2 = qa.a.COROUTINE_SUSPENDED
            int r3 = r1.f5861b
            r4 = 0
            java.lang.Object r5 = r1.f5862c
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r7 = 0
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r9 = 1
            switch(r3) {
                case 0: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x00c6
        L_0x0016:
            boolean r3 = r0 instanceof f6.j
            if (r3 == 0) goto L_0x0027
            r3 = r0
            f6.j r3 = (f6.j) r3
            int r10 = r3.f5860k
            r11 = r10 & r8
            if (r11 == 0) goto L_0x0027
            int r10 = r10 - r8
            r3.f5860k = r10
            goto L_0x002c
        L_0x0027:
            f6.j r3 = new f6.j
            r3.<init>(r1, r0)
        L_0x002c:
            java.lang.Object r0 = r3.f5858i
            int r8 = r3.f5860k
            if (r8 == 0) goto L_0x0040
            if (r8 != r9) goto L_0x003a
            java.util.ArrayList r2 = r3.f5857h
            hb.h0.O1(r0)     // Catch:{ Exception -> 0x00b6 }
            goto L_0x0061
        L_0x003a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r6)
            throw r0
        L_0x0040:
            hb.h0.O1(r0)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x00b6 }
            r0.<init>()     // Catch:{ Exception -> 0x00b6 }
            e6.e1 r5 = (e6.e1) r5     // Catch:{ Exception -> 0x00b6 }
            r3.f5857h = r0     // Catch:{ Exception -> 0x00b6 }
            r3.f5860k = r9     // Catch:{ Exception -> 0x00b6 }
            r5.getClass()     // Catch:{ Exception -> 0x00b6 }
            nb.d r6 = hb.p0.f7834b     // Catch:{ Exception -> 0x00b6 }
            e6.b1 r8 = new e6.b1     // Catch:{ Exception -> 0x00b6 }
            r8.<init>(r5, r7)     // Catch:{ Exception -> 0x00b6 }
            java.lang.Object r3 = hb.h0.c2(r6, r8, r3)     // Catch:{ Exception -> 0x00b6 }
            if (r3 != r2) goto L_0x005f
            goto L_0x00c5
        L_0x005f:
            r2 = r0
            r0 = r3
        L_0x0061:
            java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x00b6 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x00b6 }
        L_0x0067:
            boolean r3 = r0.hasNext()     // Catch:{ Exception -> 0x00b6 }
            if (r3 == 0) goto L_0x00a7
            java.lang.Object r3 = r0.next()     // Catch:{ Exception -> 0x00b6 }
            com.github.andreyasadchy.xtra.model.offline.LocalFollowGame r3 = (com.github.andreyasadchy.xtra.model.offline.LocalFollowGame) r3     // Catch:{ Exception -> 0x00b6 }
            com.github.andreyasadchy.xtra.model.ui.Game r5 = new com.github.andreyasadchy.xtra.model.ui.Game     // Catch:{ Exception -> 0x00b6 }
            java.lang.Integer r6 = r3.getGameId()     // Catch:{ Exception -> 0x00b6 }
            if (r6 == 0) goto L_0x0081
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x00b6 }
            r11 = r6
            goto L_0x0082
        L_0x0081:
            r11 = 0
        L_0x0082:
            java.lang.String r12 = r3.getGameName()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r13 = r3.getGameSlug()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r14 = r3.getBoxArt()     // Catch:{ Exception -> 0x00b6 }
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 1
            r22 = 1008(0x3f0, float:1.413E-42)
            r23 = 0
            r10 = r5
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x00b6 }
            r2.add(r5)     // Catch:{ Exception -> 0x00b6 }
            goto L_0x0067
        L_0x00a7:
            int r0 = r2.size()     // Catch:{ Exception -> 0x00b6 }
            if (r0 <= r9) goto L_0x00b8
            f6.i r0 = new f6.i     // Catch:{ Exception -> 0x00b6 }
            r0.<init>()     // Catch:{ Exception -> 0x00b6 }
            ma.v.j(r2, r0)     // Catch:{ Exception -> 0x00b6 }
            goto L_0x00b8
        L_0x00b6:
            ma.b0 r2 = ma.b0.f10801h     // Catch:{ Exception -> 0x00bf }
        L_0x00b8:
            n3.k4 r0 = new n3.k4     // Catch:{ Exception -> 0x00bf }
            r0.<init>(r2, r7, r7)     // Catch:{ Exception -> 0x00bf }
            r2 = r0
            goto L_0x00c5
        L_0x00bf:
            r0 = move-exception
            n3.h4 r2 = new n3.h4
            r2.<init>(r0)
        L_0x00c5:
            return r2
        L_0x00c6:
            boolean r3 = r0 instanceof f6.v
            if (r3 == 0) goto L_0x00d7
            r3 = r0
            f6.v r3 = (f6.v) r3
            int r10 = r3.f5894k
            r11 = r10 & r8
            if (r11 == 0) goto L_0x00d7
            int r10 = r10 - r8
            r3.f5894k = r10
            goto L_0x00dc
        L_0x00d7:
            f6.v r3 = new f6.v
            r3.<init>(r1, r0)
        L_0x00dc:
            java.lang.Object r0 = r3.f5892i
            int r8 = r3.f5894k
            if (r8 == 0) goto L_0x00f0
            if (r8 != r9) goto L_0x00ea
            int r2 = r3.f5891h
            hb.h0.O1(r0)     // Catch:{ Exception -> 0x013c }
            goto L_0x0110
        L_0x00ea:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r6)
            throw r0
        L_0x00f0:
            hb.h0.O1(r0)
            java.lang.Object r0 = r25.a()
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 == 0) goto L_0x0100
            int r0 = r0.intValue()
            goto L_0x0101
        L_0x0100:
            r0 = 1
        L_0x0101:
            e6.x r5 = (e6.x) r5     // Catch:{ Exception -> 0x013c }
            r3.f5891h = r0     // Catch:{ Exception -> 0x013c }
            r3.f5894k = r9     // Catch:{ Exception -> 0x013c }
            java.io.Serializable r3 = r5.d(r0, r3)     // Catch:{ Exception -> 0x013c }
            if (r3 != r2) goto L_0x010e
            goto L_0x0142
        L_0x010e:
            r2 = r0
            r0 = r3
        L_0x0110:
            la.p r0 = (la.p) r0     // Catch:{ Exception -> 0x013c }
            n3.k4 r3 = new n3.k4     // Catch:{ Exception -> 0x013c }
            java.lang.Object r5 = r0.f9809h     // Catch:{ Exception -> 0x013c }
            java.util.List r5 = (java.util.List) r5     // Catch:{ Exception -> 0x013c }
            java.lang.Object r6 = r0.f9810i     // Catch:{ Exception -> 0x013c }
            if (r6 == 0) goto L_0x0128
            int r6 = r2 + -1
            int r6 = java.lang.Math.max(r4, r6)     // Catch:{ Exception -> 0x013c }
            java.lang.Integer r8 = new java.lang.Integer     // Catch:{ Exception -> 0x013c }
            r8.<init>(r6)     // Catch:{ Exception -> 0x013c }
            goto L_0x0129
        L_0x0128:
            r8 = r7
        L_0x0129:
            java.lang.Object r0 = r0.f9811j     // Catch:{ Exception -> 0x013c }
            if (r0 == 0) goto L_0x0137
            int r2 = r2 + r9
            int r0 = java.lang.Math.max(r4, r2)     // Catch:{ Exception -> 0x013c }
            java.lang.Integer r7 = new java.lang.Integer     // Catch:{ Exception -> 0x013c }
            r7.<init>(r0)     // Catch:{ Exception -> 0x013c }
        L_0x0137:
            r3.<init>(r5, r8, r7)     // Catch:{ Exception -> 0x013c }
            r2 = r3
            goto L_0x0142
        L_0x013c:
            r0 = move-exception
            n3.h4 r2 = new n3.h4
            r2.<init>(r0)
        L_0x0142:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.k.b(n3.g4, pa.e):java.lang.Object");
    }

    public final Integer c(o4 o4Var) {
        int i10;
        Integer num;
        Integer num2;
        int i11;
        Integer num3;
        Integer num4;
        Integer num5 = o4Var.f11383b;
        switch (this.f5861b) {
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

    public k(e1 e1Var) {
        j.f("localFollowsGame", e1Var);
        this.f5862c = e1Var;
    }
}
