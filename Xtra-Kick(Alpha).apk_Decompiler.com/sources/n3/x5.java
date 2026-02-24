package n3;

import hb.l1;
import hb.s;
import hb.t;
import ob.d;
import ob.e;
import wa.r;

public final class x5 {

    /* renamed from: a  reason: collision with root package name */
    public final r f11569a;

    /* renamed from: b  reason: collision with root package name */
    public final t f11570b = new t((l1) null);

    /* renamed from: c  reason: collision with root package name */
    public final d f11571c = e.a();

    /* renamed from: d  reason: collision with root package name */
    public final s[] f11572d;

    /* renamed from: e  reason: collision with root package name */
    public final Object[] f11573e;

    public x5(c2 c2Var) {
        this.f11569a = c2Var;
        s[] sVarArr = new s[2];
        for (int i10 = 0; i10 < 2; i10++) {
            sVarArr[i10] = new t((l1) null);
        }
        this.f11572d = sVarArr;
        Object[] objArr = new Object[2];
        for (int i11 = 0; i11 < 2; i11++) {
            objArr[i11] = q0.f11419a;
        }
        this.f11573e = objArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: ob.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: ob.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: ob.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: ob.a} */
    /* JADX WARNING: type inference failed for: r2v22 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x010c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0123 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0159 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fc A[Catch:{ all -> 0x0164, all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0113 A[Catch:{ all -> 0x0164, all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0126 A[Catch:{ all -> 0x0164, all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x015a A[Catch:{ all -> 0x0164, all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0166 A[Catch:{ all -> 0x0164, all -> 0x003b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.Object r17, pa.e r18, int r19) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            r2 = r19
            boolean r3 = r0 instanceof n3.w5
            if (r3 == 0) goto L_0x0019
            r3 = r0
            n3.w5 r3 = (n3.w5) r3
            int r4 = r3.f11548n
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f11548n = r4
            goto L_0x001e
        L_0x0019:
            n3.w5 r3 = new n3.w5
            r3.<init>(r1, r0)
        L_0x001e:
            java.lang.Object r0 = r3.f11546l
            qa.a r4 = qa.a.COROUTINE_SUSPENDED
            int r5 = r3.f11548n
            r6 = 3
            r7 = 1
            r8 = 2
            r9 = 0
            if (r5 == 0) goto L_0x005e
            if (r5 == r7) goto L_0x0053
            if (r5 == r8) goto L_0x0046
            if (r5 != r6) goto L_0x003e
            java.lang.Object r2 = r3.f11543i
            ob.a r2 = (ob.a) r2
            n3.x5 r3 = r3.f11542h
            hb.h0.O1(r0)     // Catch:{ all -> 0x003b }
            goto L_0x0149
        L_0x003b:
            r0 = move-exception
            goto L_0x0171
        L_0x003e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0046:
            int r2 = r3.f11545k
            ob.d r5 = r3.f11544j
            java.lang.Object r8 = r3.f11543i
            n3.x5 r10 = r3.f11542h
            hb.h0.O1(r0)
            goto L_0x00f5
        L_0x0053:
            int r2 = r3.f11545k
            java.lang.Object r5 = r3.f11543i
            n3.x5 r10 = r3.f11542h
            hb.h0.O1(r0)
            goto L_0x00e0
        L_0x005e:
            hb.h0.O1(r0)
            hb.s[] r0 = r1.f11572d
            r5 = r0[r2]
            hb.u1 r5 = (hb.u1) r5
            java.lang.Object r5 = r5.H()
            boolean r5 = r5 instanceof hb.f1
            r5 = r5 ^ r7
            if (r5 == 0) goto L_0x00c1
            r3.f11542h = r1
            r5 = r17
            r3.f11543i = r5
            r3.f11545k = r2
            r3.f11548n = r7
        L_0x007a:
            hb.t r0 = r1.f11570b
            java.lang.Object r10 = r0.H()
            boolean r11 = r10 instanceof hb.f1
            if (r11 != 0) goto L_0x0092
            boolean r0 = r10 instanceof hb.w
            if (r0 != 0) goto L_0x008d
            java.lang.Object r0 = hb.v1.a(r10)
            goto L_0x00be
        L_0x008d:
            hb.w r10 = (hb.w) r10
            java.lang.Throwable r0 = r10.f7875a
            throw r0
        L_0x0092:
            int r10 = r0.Y(r10)
            if (r10 < 0) goto L_0x007a
            hb.q1 r10 = new hb.q1
            pa.e r11 = qa.d.b(r3)
            r10.<init>(r11, r0)
            r10.w()
            hb.j1 r11 = new hb.j1
            r11.<init>(r7, r10)
            hb.q0 r0 = r0.L(r11)
            hb.h r11 = new hb.h
            r11.<init>(r7, r0)
            r10.j(r11)
            java.lang.Object r0 = r10.u()
            if (r0 != r4) goto L_0x00be
            hb.h0.m1(r3)
        L_0x00be:
            if (r0 != r4) goto L_0x00df
            return r4
        L_0x00c1:
            r5 = r17
            r0 = r0[r2]
            la.v r10 = la.v.f9814a
            hb.t r0 = (hb.t) r0
        L_0x00c9:
            java.lang.Object r11 = r0.H()
            java.lang.Object r11 = r0.a0(r11, r10)
            h3.u1 r12 = hb.v1.f7867a
            if (r11 != r12) goto L_0x00d6
            goto L_0x00df
        L_0x00d6:
            h3.u1 r12 = hb.v1.f7868b
            if (r11 != r12) goto L_0x00db
            goto L_0x00df
        L_0x00db:
            h3.u1 r12 = hb.v1.f7869c
            if (r11 == r12) goto L_0x00c9
        L_0x00df:
            r10 = r1
        L_0x00e0:
            ob.d r0 = r10.f11571c
            r3.f11542h = r10
            r3.f11543i = r5
            r3.f11544j = r0
            r3.f11545k = r2
            r3.f11548n = r8
            java.lang.Object r8 = r0.e(r3)
            if (r8 != r4) goto L_0x00f3
            return r4
        L_0x00f3:
            r8 = r5
            r5 = r0
        L_0x00f5:
            java.lang.Object[] r0 = r10.f11573e     // Catch:{ all -> 0x0164 }
            int r11 = r0.length     // Catch:{ all -> 0x0164 }
            r12 = 0
            r13 = 0
        L_0x00fa:
            if (r13 >= r11) goto L_0x010c
            r14 = r0[r13]     // Catch:{ all -> 0x0164 }
            java.lang.Object r15 = n3.q0.f11419a     // Catch:{ all -> 0x0164 }
            if (r14 != r15) goto L_0x0104
            r14 = 1
            goto L_0x0105
        L_0x0104:
            r14 = 0
        L_0x0105:
            if (r14 == 0) goto L_0x0109
            r11 = 1
            goto L_0x010d
        L_0x0109:
            int r13 = r13 + 1
            goto L_0x00fa
        L_0x010c:
            r11 = 0
        L_0x010d:
            r0[r2] = r8     // Catch:{ all -> 0x0164 }
            int r8 = r0.length     // Catch:{ all -> 0x0164 }
            r13 = 0
        L_0x0111:
            if (r13 >= r8) goto L_0x0123
            r14 = r0[r13]     // Catch:{ all -> 0x0164 }
            java.lang.Object r15 = n3.q0.f11419a     // Catch:{ all -> 0x0164 }
            if (r14 != r15) goto L_0x011b
            r14 = 1
            goto L_0x011c
        L_0x011b:
            r14 = 0
        L_0x011c:
            if (r14 == 0) goto L_0x0120
            r8 = 0
            goto L_0x0124
        L_0x0120:
            int r13 = r13 + 1
            goto L_0x0111
        L_0x0123:
            r8 = 1
        L_0x0124:
            if (r8 == 0) goto L_0x0166
            if (r11 == 0) goto L_0x012b
            n3.y r2 = n3.y.INITIAL     // Catch:{ all -> 0x0164 }
            goto L_0x0132
        L_0x012b:
            if (r2 != 0) goto L_0x0130
            n3.y r2 = n3.y.RECEIVER     // Catch:{ all -> 0x0164 }
            goto L_0x0132
        L_0x0130:
            n3.y r2 = n3.y.OTHER     // Catch:{ all -> 0x0164 }
        L_0x0132:
            wa.r r8 = r10.f11569a     // Catch:{ all -> 0x0164 }
            r11 = r0[r12]     // Catch:{ all -> 0x0164 }
            r0 = r0[r7]     // Catch:{ all -> 0x0164 }
            r3.f11542h = r10     // Catch:{ all -> 0x0164 }
            r3.f11543i = r5     // Catch:{ all -> 0x0164 }
            r3.f11544j = r9     // Catch:{ all -> 0x0164 }
            r3.f11548n = r6     // Catch:{ all -> 0x0164 }
            java.lang.Object r0 = r8.k(r11, r0, r2, r3)     // Catch:{ all -> 0x0164 }
            if (r0 != r4) goto L_0x0147
            return r4
        L_0x0147:
            r2 = r5
            r3 = r10
        L_0x0149:
            hb.t r0 = r3.f11570b     // Catch:{ all -> 0x003b }
            la.v r3 = la.v.f9814a     // Catch:{ all -> 0x003b }
        L_0x014d:
            java.lang.Object r4 = r0.H()     // Catch:{ all -> 0x003b }
            java.lang.Object r4 = r0.a0(r4, r3)     // Catch:{ all -> 0x003b }
            h3.u1 r5 = hb.v1.f7867a     // Catch:{ all -> 0x003b }
            if (r4 != r5) goto L_0x015a
            goto L_0x0167
        L_0x015a:
            h3.u1 r5 = hb.v1.f7868b     // Catch:{ all -> 0x003b }
            if (r4 != r5) goto L_0x015f
            goto L_0x0167
        L_0x015f:
            h3.u1 r5 = hb.v1.f7869c     // Catch:{ all -> 0x003b }
            if (r4 == r5) goto L_0x014d
            goto L_0x0167
        L_0x0164:
            r0 = move-exception
            goto L_0x0172
        L_0x0166:
            r2 = r5
        L_0x0167:
            la.v r0 = la.v.f9814a     // Catch:{ all -> 0x003b }
            ob.d r2 = (ob.d) r2
            r2.f(r9)
            la.v r0 = la.v.f9814a
            return r0
        L_0x0171:
            r5 = r2
        L_0x0172:
            ob.d r5 = (ob.d) r5
            r5.f(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.x5.a(java.lang.Object, pa.e, int):java.lang.Object");
    }
}
