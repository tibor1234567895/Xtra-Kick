package n3;

import la.v;
import pa.e;
import ra.i;
import wa.q;

public final class x1 extends i implements q {

    /* renamed from: i  reason: collision with root package name */
    public n4 f11554i;

    /* renamed from: j  reason: collision with root package name */
    public int f11555j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ t1 f11556k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ boolean f11557l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ i2 f11558m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ d5 f11559n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x1(i2 i2Var, d5 d5Var, e eVar) {
        super(3, eVar);
        this.f11558m = i2Var;
        this.f11559n = d5Var;
    }

    public final Object e(Object obj, Object obj2, Object obj3) {
        boolean booleanValue = ((Boolean) obj2).booleanValue();
        x1 x1Var = new x1(this.f11558m, this.f11559n, (e) obj3);
        x1Var.f11556k = (t1) obj;
        x1Var.f11557l = booleanValue;
        return x1Var.invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0085 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f11555j
            r3 = 2
            n3.i2 r4 = r0.f11558m
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0030
            if (r2 == r5) goto L_0x0026
            if (r2 != r3) goto L_0x001e
            boolean r1 = r0.f11557l
            n3.n4 r2 = r0.f11554i
            n3.t1 r3 = r0.f11556k
            hb.h0.O1(r19)
            r7 = r3
            r3 = r19
            goto L_0x006c
        L_0x001e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0026:
            boolean r2 = r0.f11557l
            n3.t1 r7 = r0.f11556k
            hb.h0.O1(r19)
            r8 = r19
            goto L_0x0051
        L_0x0030:
            hb.h0.O1(r19)
            n3.t1 r2 = r0.f11556k
            boolean r7 = r0.f11557l
            if (r2 != 0) goto L_0x003b
            r8 = r6
            goto L_0x003f
        L_0x003b:
            n3.g3 r8 = r2.f11486a
            n3.n4 r8 = r8.f11195b
        L_0x003f:
            r0.f11556k = r2
            r0.f11557l = r7
            r0.f11555j = r5
            java.lang.Object r8 = n3.i2.a(r4, r8, r0)
            if (r8 != r1) goto L_0x004c
            return r1
        L_0x004c:
            r17 = r7
            r7 = r2
            r2 = r17
        L_0x0051:
            n3.n4 r8 = (n3.n4) r8
            if (r7 != 0) goto L_0x0059
            r13 = r2
            r3 = r6
            r10 = r8
            goto L_0x0070
        L_0x0059:
            r0.f11556k = r7
            r0.f11554i = r8
            r0.f11557l = r2
            r0.f11555j = r3
            n3.g3 r3 = r7.f11486a
            java.lang.Object r3 = r3.e(r0)
            if (r3 != r1) goto L_0x006a
            return r1
        L_0x006a:
            r1 = r2
            r2 = r8
        L_0x006c:
            n3.o4 r3 = (n3.o4) r3
            r13 = r1
            r10 = r2
        L_0x0070:
            if (r3 != 0) goto L_0x0074
            r1 = r6
            goto L_0x0076
        L_0x0074:
            java.util.List r1 = r3.f11382a
        L_0x0076:
            r2 = 0
            if (r1 == 0) goto L_0x0082
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0080
            goto L_0x0082
        L_0x0080:
            r1 = 0
            goto L_0x0083
        L_0x0082:
            r1 = 1
        L_0x0083:
            if (r1 == 0) goto L_0x009f
            if (r7 != 0) goto L_0x0088
            goto L_0x009a
        L_0x0088:
            n3.o4 r1 = r7.f11487b
            if (r1 != 0) goto L_0x008d
            goto L_0x009a
        L_0x008d:
            java.util.List r1 = r1.f11382a
            if (r1 != 0) goto L_0x0092
            goto L_0x009a
        L_0x0092:
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r5
            if (r1 != r5) goto L_0x009a
            goto L_0x009b
        L_0x009a:
            r5 = 0
        L_0x009b:
            if (r5 == 0) goto L_0x009f
            n3.o4 r3 = r7.f11487b
        L_0x009f:
            if (r3 != 0) goto L_0x00a3
            r1 = r6
            goto L_0x00a5
        L_0x00a3:
            java.lang.Integer r1 = r3.f11383b
        L_0x00a5:
            if (r1 != 0) goto L_0x00b6
            if (r7 != 0) goto L_0x00aa
            goto L_0x00ae
        L_0x00aa:
            n3.o4 r1 = r7.f11487b
            if (r1 != 0) goto L_0x00b0
        L_0x00ae:
            r1 = r6
            goto L_0x00b2
        L_0x00b0:
            java.lang.Integer r1 = r1.f11383b
        L_0x00b2:
            if (r1 == 0) goto L_0x00b6
            n3.o4 r3 = r7.f11487b
        L_0x00b6:
            if (r3 != 0) goto L_0x00ba
            r1 = r6
            goto L_0x00be
        L_0x00ba:
            java.lang.Integer r1 = r10.a(r3)
        L_0x00be:
            if (r1 != 0) goto L_0x00c2
            java.lang.Object r1 = r4.f11251b
        L_0x00c2:
            r9 = r1
            if (r7 != 0) goto L_0x00c6
            goto L_0x00cd
        L_0x00c6:
            n3.g3 r1 = r7.f11486a
            hb.o1 r1 = r1.f11206m
            r1.e(r6)
        L_0x00cd:
            if (r7 != 0) goto L_0x00d0
            goto L_0x00d5
        L_0x00d0:
            hb.l1 r1 = r7.f11488c
            r1.e(r6)
        L_0x00d5:
            n3.t1 r1 = new n3.t1
            n3.r3 r11 = r4.f11252c
            n3.b0 r5 = r4.f11254e
            androidx.fragment.app.p0 r12 = r5.f11057b
            n3.w1 r5 = new n3.w1
            r5.<init>(r2, r4)
            n3.g3 r2 = new n3.g3
            n3.d5 r14 = r0.f11559n
            r8 = r2
            r15 = r3
            r16 = r5
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16)
            hb.o1 r4 = new hb.o1
            r4.<init>(r6)
            r1.<init>(r2, r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.x1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
