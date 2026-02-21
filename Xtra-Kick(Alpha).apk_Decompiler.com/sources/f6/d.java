package f6;

import c6.b;
import e6.s0;
import n3.k4;
import n3.n4;
import n3.o4;
import xa.j;

public final class d extends n4 {

    /* renamed from: b  reason: collision with root package name */
    public final String f5843b;

    /* renamed from: c  reason: collision with root package name */
    public final s0 f5844c;

    /* renamed from: d  reason: collision with root package name */
    public final b f5845d;

    public d(String str, s0 s0Var, b bVar) {
        j.f("kickApiRepository", s0Var);
        j.f("kickMapper", bVar);
        this.f5843b = str;
        this.f5844c = s0Var;
        this.f5845d = bVar;
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

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(n3.g4 r6, pa.e r7) {
        /*
            r5 = this;
            boolean r6 = r7 instanceof f6.c
            if (r6 == 0) goto L_0x0013
            r6 = r7
            f6.c r6 = (f6.c) r6
            int r0 = r6.f5842k
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L_0x0013
            int r0 = r0 - r1
            r6.f5842k = r0
            goto L_0x0018
        L_0x0013:
            f6.c r6 = new f6.c
            r6.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r6.f5840i
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r6.f5842k
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            f6.d r6 = r6.f5839h
            hb.h0.O1(r7)     // Catch:{ Exception -> 0x0063 }
            goto L_0x0052
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            hb.h0.O1(r7)
            e6.s0 r7 = r5.f5844c     // Catch:{ Exception -> 0x0063 }
            java.lang.String r1 = r5.f5843b     // Catch:{ Exception -> 0x0063 }
            xa.j.c(r1)     // Catch:{ Exception -> 0x0063 }
            r6.f5839h = r5     // Catch:{ Exception -> 0x0063 }
            r6.f5842k = r2     // Catch:{ Exception -> 0x0063 }
            r7.getClass()     // Catch:{ Exception -> 0x0063 }
            nb.d r2 = hb.p0.f7834b     // Catch:{ Exception -> 0x0063 }
            e6.i0 r4 = new e6.i0     // Catch:{ Exception -> 0x0063 }
            r4.<init>(r7, r1, r3)     // Catch:{ Exception -> 0x0063 }
            java.lang.Object r7 = hb.h0.c2(r2, r4, r6)     // Catch:{ Exception -> 0x0063 }
            if (r7 != r0) goto L_0x0051
            return r0
        L_0x0051:
            r6 = r5
        L_0x0052:
            java.util.List r7 = (java.util.List) r7     // Catch:{ Exception -> 0x0063 }
            c6.b r6 = r6.f5845d     // Catch:{ Exception -> 0x0063 }
            r6.getClass()     // Catch:{ Exception -> 0x0063 }
            java.util.ArrayList r6 = c6.b.d(r7)     // Catch:{ Exception -> 0x0063 }
            n3.k4 r7 = new n3.k4     // Catch:{ Exception -> 0x0063 }
            r7.<init>(r6, r3, r3)     // Catch:{ Exception -> 0x0063 }
            goto L_0x0069
        L_0x0063:
            r6 = move-exception
            n3.h4 r7 = new n3.h4
            r7.<init>(r6)
        L_0x0069:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.d.b(n3.g4, pa.e):java.lang.Object");
    }
}
