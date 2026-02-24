package f6;

import e6.x;
import e6.y0;
import n3.k4;
import n3.n4;
import n3.o4;
import xa.j;

public final class p extends n4 {

    /* renamed from: b  reason: collision with root package name */
    public final y0 f5878b;

    /* renamed from: c  reason: collision with root package name */
    public final x f5879c;

    public p(x xVar, y0 y0Var) {
        j.f("localFollowsChannel", y0Var);
        j.f("apiRepository", xVar);
        this.f5878b = y0Var;
        this.f5879c = xVar;
    }

    public final Integer a(o4 o4Var) {
        int i10;
        Integer num;
        Integer num2;
        Integer num3 = o4Var.f11383b;
        if (num3 != null) {
            k4 a10 = o4Var.a(num3.intValue());
            if (a10 != null && (num2 = (Integer) a10.f11288b) != null) {
                i10 = num2.intValue() + 1;
            } else if (!(a10 == null || (num = (Integer) a10.f11289c) == null)) {
                i10 = num.intValue() - 1;
            }
            return Integer.valueOf(i10);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007b A[Catch:{ Exception -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0092 A[SYNTHETIC, Splitter:B:34:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ba A[Catch:{ Exception -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c6 A[Catch:{ Exception -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cf A[Catch:{ Exception -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(n3.g4 r11, pa.e r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof f6.m
            if (r0 == 0) goto L_0x0013
            r0 = r12
            f6.m r0 = (f6.m) r0
            int r1 = r0.f5868m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f5868m = r1
            goto L_0x0018
        L_0x0013:
            f6.m r0 = new f6.m
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f5866k
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f5868m
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 == r5) goto L_0x0038
            if (r2 != r4) goto L_0x0030
            java.util.List r11 = r0.f5865j
            f6.p r0 = r0.f5863h
            hb.h0.O1(r12)     // Catch:{ Exception -> 0x00b3 }
            goto L_0x00af
        L_0x0030:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0038:
            java.util.List r11 = r0.f5865j
            n3.g4 r2 = r0.f5864i
            f6.p r6 = r0.f5863h
            hb.h0.O1(r12)     // Catch:{ Exception -> 0x00e0 }
            r9 = r12
            r12 = r11
            r11 = r2
            r2 = r9
            goto L_0x006a
        L_0x0046:
            hb.h0.O1(r12)
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ Exception -> 0x00e0 }
            r12.<init>()     // Catch:{ Exception -> 0x00e0 }
            e6.y0 r2 = r10.f5878b     // Catch:{ Exception -> 0x00e0 }
            r0.f5863h = r10     // Catch:{ Exception -> 0x00e0 }
            r0.f5864i = r11     // Catch:{ Exception -> 0x00e0 }
            r0.f5865j = r12     // Catch:{ Exception -> 0x00e0 }
            r0.f5868m = r5     // Catch:{ Exception -> 0x00e0 }
            r2.getClass()     // Catch:{ Exception -> 0x00e0 }
            nb.d r6 = hb.p0.f7834b     // Catch:{ Exception -> 0x00e0 }
            e6.v0 r7 = new e6.v0     // Catch:{ Exception -> 0x00e0 }
            r7.<init>(r2, r3)     // Catch:{ Exception -> 0x00e0 }
            java.lang.Object r2 = hb.h0.c2(r6, r7, r0)     // Catch:{ Exception -> 0x00e0 }
            if (r2 != r1) goto L_0x0069
            return r1
        L_0x0069:
            r6 = r10
        L_0x006a:
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch:{ Exception -> 0x00e0 }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x00e0 }
            r7.<init>()     // Catch:{ Exception -> 0x00e0 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x00e0 }
        L_0x0075:
            boolean r8 = r2.hasNext()     // Catch:{ Exception -> 0x00e0 }
            if (r8 == 0) goto L_0x008b
            java.lang.Object r8 = r2.next()     // Catch:{ Exception -> 0x00e0 }
            com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel r8 = (com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel) r8     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r8 = r8.getUserLogin()     // Catch:{ Exception -> 0x00e0 }
            if (r8 == 0) goto L_0x0075
            r7.add(r8)     // Catch:{ Exception -> 0x00e0 }
            goto L_0x0075
        L_0x008b:
            boolean r2 = r7.isEmpty()     // Catch:{ Exception -> 0x00e0 }
            r2 = r2 ^ r5
            if (r2 == 0) goto L_0x00ba
            r0.f5863h = r6     // Catch:{ Exception -> 0x00b3 }
            r0.f5864i = r11     // Catch:{ Exception -> 0x00b3 }
            r0.f5865j = r12     // Catch:{ Exception -> 0x00b3 }
            r0.f5868m = r4     // Catch:{ Exception -> 0x00b3 }
            r6.getClass()     // Catch:{ Exception -> 0x00b3 }
            nb.d r11 = hb.p0.f7834b     // Catch:{ Exception -> 0x00b3 }
            f6.o r2 = new f6.o     // Catch:{ Exception -> 0x00b3 }
            r2.<init>(r7, r6, r3)     // Catch:{ Exception -> 0x00b3 }
            java.lang.Object r11 = hb.h0.c2(r11, r2, r0)     // Catch:{ Exception -> 0x00b3 }
            if (r11 != r1) goto L_0x00ab
            return r1
        L_0x00ab:
            r0 = r6
            r9 = r12
            r12 = r11
            r11 = r9
        L_0x00af:
            java.util.List r12 = (java.util.List) r12     // Catch:{ Exception -> 0x00b3 }
            r6 = r0
            goto L_0x00bf
        L_0x00b3:
            r11 = move-exception
            n3.h4 r12 = new n3.h4     // Catch:{ Exception -> 0x00e0 }
            r12.<init>(r11)     // Catch:{ Exception -> 0x00e0 }
            return r12
        L_0x00ba:
            ma.b0 r11 = ma.b0.f10801h     // Catch:{ Exception -> 0x00e0 }
            r9 = r12
            r12 = r11
            r11 = r9
        L_0x00bf:
            boolean r0 = r12.isEmpty()     // Catch:{ Exception -> 0x00e0 }
            r0 = r0 ^ r5
            if (r0 == 0) goto L_0x00c9
            r11.addAll(r12)     // Catch:{ Exception -> 0x00e0 }
        L_0x00c9:
            int r12 = r11.size()     // Catch:{ Exception -> 0x00e0 }
            if (r12 <= r5) goto L_0x00d7
            f6.l r12 = new f6.l     // Catch:{ Exception -> 0x00e0 }
            r12.<init>()     // Catch:{ Exception -> 0x00e0 }
            ma.v.j(r11, r12)     // Catch:{ Exception -> 0x00e0 }
        L_0x00d7:
            n3.k4 r12 = new n3.k4     // Catch:{ Exception -> 0x00e7 }
            r6.getClass()     // Catch:{ Exception -> 0x00e7 }
            r12.<init>(r11, r3, r3)     // Catch:{ Exception -> 0x00e7 }
            goto L_0x00ed
        L_0x00e0:
            r11 = move-exception
            n3.h4 r12 = new n3.h4     // Catch:{ Exception -> 0x00e7 }
            r12.<init>(r11)     // Catch:{ Exception -> 0x00e7 }
            return r12
        L_0x00e7:
            r11 = move-exception
            n3.h4 r12 = new n3.h4
            r12.<init>(r11)
        L_0x00ed:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.p.b(n3.g4, pa.e):java.lang.Object");
    }
}
