package f6;

import com.github.andreyasadchy.xtra.model.ui.FollowOrderEnum;
import com.github.andreyasadchy.xtra.model.ui.FollowSortEnum;
import e6.e0;
import e6.o1;
import e6.y0;
import n3.k4;
import n3.n4;
import n3.o4;
import xa.j;

public final class h extends n4 {

    /* renamed from: b  reason: collision with root package name */
    public final y0 f5854b;

    /* renamed from: c  reason: collision with root package name */
    public final FollowSortEnum f5855c;

    /* renamed from: d  reason: collision with root package name */
    public final FollowOrderEnum f5856d;

    public h(y0 y0Var, o1 o1Var, e0 e0Var, FollowSortEnum followSortEnum, FollowOrderEnum followOrderEnum) {
        j.f("localFollowsChannel", y0Var);
        j.f("offlineRepository", o1Var);
        j.f("bookmarksRepository", e0Var);
        j.f("sort", followSortEnum);
        j.f("order", followOrderEnum);
        this.f5854b = y0Var;
        this.f5855c = followSortEnum;
        this.f5856d = followOrderEnum;
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

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0067 A[Catch:{ Exception -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007c A[Catch:{ Exception -> 0x019a }, LOOP:0: B:24:0x0076->B:26:0x007c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c4 A[Catch:{ Exception -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fb A[Catch:{ Exception -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x011b A[SYNTHETIC, Splitter:B:50:0x011b] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0154 A[Catch:{ Exception -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00f4 A[EDGE_INSN: B:73:0x00f4->B:41:0x00f4 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(n3.g4 r27, pa.e r28) {
        /*
            r26 = this;
            r1 = r26
            r0 = r28
            boolean r2 = r0 instanceof f6.g
            if (r2 == 0) goto L_0x0017
            r2 = r0
            f6.g r2 = (f6.g) r2
            int r3 = r2.f5853l
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f5853l = r3
            goto L_0x001c
        L_0x0017:
            f6.g r2 = new f6.g
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.f5851j
            qa.a r3 = qa.a.COROUTINE_SUSPENDED
            int r4 = r2.f5853l
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x0038
            if (r4 != r6) goto L_0x0030
            java.util.ArrayList r3 = r2.f5850i
            f6.h r2 = r2.f5849h
            hb.h0.O1(r0)     // Catch:{ Exception -> 0x019a }
            goto L_0x005f
        L_0x0030:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0038:
            hb.h0.O1(r0)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x019a }
            r0.<init>()     // Catch:{ Exception -> 0x019a }
            e6.y0 r4 = r1.f5854b     // Catch:{ Exception -> 0x019a }
            r2.f5849h = r1     // Catch:{ Exception -> 0x019a }
            r2.getClass()     // Catch:{ Exception -> 0x019a }
            r2.f5850i = r0     // Catch:{ Exception -> 0x019a }
            r2.f5853l = r6     // Catch:{ Exception -> 0x019a }
            r4.getClass()     // Catch:{ Exception -> 0x019a }
            nb.d r7 = hb.p0.f7834b     // Catch:{ Exception -> 0x019a }
            e6.v0 r8 = new e6.v0     // Catch:{ Exception -> 0x019a }
            r8.<init>(r4, r5)     // Catch:{ Exception -> 0x019a }
            java.lang.Object r2 = hb.h0.c2(r7, r8, r2)     // Catch:{ Exception -> 0x019a }
            if (r2 != r3) goto L_0x005c
            return r3
        L_0x005c:
            r3 = r0
            r0 = r2
            r2 = r1
        L_0x005f:
            java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x019a }
            com.github.andreyasadchy.xtra.model.ui.FollowOrderEnum r4 = r2.f5856d     // Catch:{ Exception -> 0x019a }
            com.github.andreyasadchy.xtra.model.ui.FollowOrderEnum r5 = com.github.andreyasadchy.xtra.model.ui.FollowOrderEnum.ASC     // Catch:{ Exception -> 0x019a }
            if (r4 != r5) goto L_0x0072
            java.lang.String r4 = "<this>"
            xa.j.f(r4, r0)     // Catch:{ Exception -> 0x019a }
            ma.k0 r4 = new ma.k0     // Catch:{ Exception -> 0x019a }
            r4.<init>((java.util.List) r0)     // Catch:{ Exception -> 0x019a }
            r0 = r4
        L_0x0072:
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x019a }
        L_0x0076:
            boolean r4 = r0.hasNext()     // Catch:{ Exception -> 0x019a }
            if (r4 == 0) goto L_0x00b4
            java.lang.Object r4 = r0.next()     // Catch:{ Exception -> 0x019a }
            com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel r4 = (com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel) r4     // Catch:{ Exception -> 0x019a }
            com.github.andreyasadchy.xtra.model.ui.User r5 = new com.github.andreyasadchy.xtra.model.ui.User     // Catch:{ Exception -> 0x019a }
            int r8 = r4.getUserId()     // Catch:{ Exception -> 0x019a }
            r9 = 0
            java.lang.String r10 = r4.getUserLogin()     // Catch:{ Exception -> 0x019a }
            java.lang.String r11 = r4.getUserName()     // Catch:{ Exception -> 0x019a }
            r12 = 0
            r13 = 0
            java.lang.String r14 = r4.getChannelLogo()     // Catch:{ Exception -> 0x019a }
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 1
            r24 = 32690(0x7fb2, float:4.5808E-41)
            r25 = 0
            r7 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x019a }
            r3.add(r5)     // Catch:{ Exception -> 0x019a }
            goto L_0x0076
        L_0x00b4:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x019a }
            r0.<init>()     // Catch:{ Exception -> 0x019a }
            java.util.Iterator r4 = r3.iterator()     // Catch:{ Exception -> 0x019a }
        L_0x00bd:
            boolean r5 = r4.hasNext()     // Catch:{ Exception -> 0x019a }
            r7 = 0
            if (r5 == 0) goto L_0x00f4
            java.lang.Object r5 = r4.next()     // Catch:{ Exception -> 0x019a }
            com.github.andreyasadchy.xtra.model.ui.User r5 = (com.github.andreyasadchy.xtra.model.ui.User) r5     // Catch:{ Exception -> 0x019a }
            java.lang.String r8 = r5.getProfileImageUrl()     // Catch:{ Exception -> 0x019a }
            if (r8 == 0) goto L_0x00e7
            java.lang.String r8 = r5.getProfileImageUrl()     // Catch:{ Exception -> 0x019a }
            if (r8 == 0) goto L_0x00df
            java.lang.String r9 = "image_manager_disk_cache"
            boolean r8 = fb.y.n(r8, r9, r7)     // Catch:{ Exception -> 0x019a }
            if (r8 != r6) goto L_0x00df
            r7 = 1
        L_0x00df:
            if (r7 != 0) goto L_0x00e7
            java.lang.String r7 = r5.getLastBroadcast()     // Catch:{ Exception -> 0x019a }
            if (r7 != 0) goto L_0x00bd
        L_0x00e7:
            int r5 = r5.getChannelId()     // Catch:{ Exception -> 0x019a }
            java.lang.Integer r7 = new java.lang.Integer     // Catch:{ Exception -> 0x019a }
            r7.<init>(r5)     // Catch:{ Exception -> 0x019a }
            r0.add(r7)     // Catch:{ Exception -> 0x019a }
            goto L_0x00bd
        L_0x00f4:
            boolean r4 = r0.isEmpty()     // Catch:{ Exception -> 0x019a }
            r4 = r4 ^ r6
            if (r4 == 0) goto L_0x0112
            r4 = 100
            java.util.ArrayList r0 = ma.z.m(r0, r4)     // Catch:{ Exception -> 0x019a }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x019a }
        L_0x0105:
            boolean r4 = r0.hasNext()     // Catch:{ Exception -> 0x019a }
            if (r4 == 0) goto L_0x0112
            java.lang.Object r4 = r0.next()     // Catch:{ Exception -> 0x019a }
            java.util.List r4 = (java.util.List) r4     // Catch:{ Exception -> 0x019a }
            goto L_0x0105
        L_0x0112:
            com.github.andreyasadchy.xtra.model.ui.FollowOrderEnum r0 = r2.f5856d     // Catch:{ Exception -> 0x019a }
            com.github.andreyasadchy.xtra.model.ui.FollowOrderEnum r4 = com.github.andreyasadchy.xtra.model.ui.FollowOrderEnum.ASC     // Catch:{ Exception -> 0x019a }
            r5 = 2
            com.github.andreyasadchy.xtra.model.ui.FollowSortEnum r2 = r2.f5855c
            if (r0 != r4) goto L_0x0154
            int[] r0 = f6.e.f5846a     // Catch:{ Exception -> 0x019a }
            int r2 = r2.ordinal()     // Catch:{ Exception -> 0x019a }
            r0 = r0[r2]     // Catch:{ Exception -> 0x019a }
            if (r0 == r6) goto L_0x0145
            if (r0 == r5) goto L_0x0136
            oa.c r0 = oa.b.b()     // Catch:{ Exception -> 0x019a }
            oa.a r2 = new oa.a     // Catch:{ Exception -> 0x019a }
            r2.<init>(r6, r0)     // Catch:{ Exception -> 0x019a }
            f6.f r0 = new f6.f     // Catch:{ Exception -> 0x019a }
            r0.<init>(r2, r5)     // Catch:{ Exception -> 0x019a }
            goto L_0x018f
        L_0x0136:
            oa.c r0 = oa.b.b()     // Catch:{ Exception -> 0x019a }
            oa.a r2 = new oa.a     // Catch:{ Exception -> 0x019a }
            r2.<init>(r6, r0)     // Catch:{ Exception -> 0x019a }
            f6.f r0 = new f6.f     // Catch:{ Exception -> 0x019a }
            r0.<init>(r2, r6)     // Catch:{ Exception -> 0x019a }
            goto L_0x018f
        L_0x0145:
            oa.c r0 = oa.b.b()     // Catch:{ Exception -> 0x019a }
            oa.a r2 = new oa.a     // Catch:{ Exception -> 0x019a }
            r2.<init>(r6, r0)     // Catch:{ Exception -> 0x019a }
            f6.f r0 = new f6.f     // Catch:{ Exception -> 0x019a }
            r0.<init>(r2, r7)     // Catch:{ Exception -> 0x019a }
            goto L_0x018f
        L_0x0154:
            int[] r0 = f6.e.f5846a     // Catch:{ Exception -> 0x019a }
            int r2 = r2.ordinal()     // Catch:{ Exception -> 0x019a }
            r0 = r0[r2]     // Catch:{ Exception -> 0x019a }
            if (r0 == r6) goto L_0x0180
            if (r0 == r5) goto L_0x0170
            oa.c r0 = oa.b.b()     // Catch:{ Exception -> 0x019a }
            oa.a r2 = new oa.a     // Catch:{ Exception -> 0x019a }
            r2.<init>(r7, r0)     // Catch:{ Exception -> 0x019a }
            f6.f r0 = new f6.f     // Catch:{ Exception -> 0x019a }
            r4 = 5
            r0.<init>(r2, r4)     // Catch:{ Exception -> 0x019a }
            goto L_0x018f
        L_0x0170:
            oa.c r0 = oa.b.b()     // Catch:{ Exception -> 0x019a }
            oa.a r2 = new oa.a     // Catch:{ Exception -> 0x019a }
            r2.<init>(r7, r0)     // Catch:{ Exception -> 0x019a }
            f6.f r0 = new f6.f     // Catch:{ Exception -> 0x019a }
            r4 = 4
            r0.<init>(r2, r4)     // Catch:{ Exception -> 0x019a }
            goto L_0x018f
        L_0x0180:
            oa.c r0 = oa.b.b()     // Catch:{ Exception -> 0x019a }
            oa.a r2 = new oa.a     // Catch:{ Exception -> 0x019a }
            r2.<init>(r7, r0)     // Catch:{ Exception -> 0x019a }
            f6.f r0 = new f6.f     // Catch:{ Exception -> 0x019a }
            r4 = 3
            r0.<init>(r2, r4)     // Catch:{ Exception -> 0x019a }
        L_0x018f:
            java.util.List r0 = ma.z.F(r3, r0)     // Catch:{ Exception -> 0x019a }
            n3.k4 r2 = new n3.k4     // Catch:{ Exception -> 0x01a1 }
            r3 = 0
            r2.<init>(r0, r3, r3)     // Catch:{ Exception -> 0x01a1 }
            goto L_0x01a7
        L_0x019a:
            r0 = move-exception
            n3.h4 r2 = new n3.h4     // Catch:{ Exception -> 0x01a1 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x01a1 }
            return r2
        L_0x01a1:
            r0 = move-exception
            n3.h4 r2 = new n3.h4
            r2.<init>(r0)
        L_0x01a7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.h.b(n3.g4, pa.e):java.lang.Object");
    }
}
