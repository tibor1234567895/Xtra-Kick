package v;

import u.e;
import u.f;

public abstract class q implements d {

    /* renamed from: a  reason: collision with root package name */
    public int f15541a;

    /* renamed from: b  reason: collision with root package name */
    public f f15542b;

    /* renamed from: c  reason: collision with root package name */
    public m f15543c;

    /* renamed from: d  reason: collision with root package name */
    public int f15544d;

    /* renamed from: e  reason: collision with root package name */
    public final g f15545e = new g(this);

    /* renamed from: f  reason: collision with root package name */
    public int f15546f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15547g = false;

    /* renamed from: h  reason: collision with root package name */
    public final f f15548h = new f(this);

    /* renamed from: i  reason: collision with root package name */
    public final f f15549i = new f(this);

    /* renamed from: j  reason: collision with root package name */
    public int f15550j = 1;

    public q(f fVar) {
        this.f15542b = fVar;
    }

    public static void b(f fVar, f fVar2, int i10) {
        fVar.f15519l.add(fVar2);
        fVar.f15513f = i10;
        fVar2.f15518k.add(fVar);
    }

    public static f h(e eVar) {
        q qVar;
        q qVar2;
        e eVar2 = eVar.f15076f;
        if (eVar2 == null) {
            return null;
        }
        int ordinal = eVar2.f15075e.ordinal();
        f fVar = eVar2.f15074d;
        if (ordinal == 1) {
            qVar = fVar.f15086d;
        } else if (ordinal != 2) {
            if (ordinal == 3) {
                qVar2 = fVar.f15086d;
            } else if (ordinal == 4) {
                qVar2 = fVar.f15088e;
            } else if (ordinal != 5) {
                return null;
            } else {
                return fVar.f15088e.f15525k;
            }
            return qVar2.f15549i;
        } else {
            qVar = fVar.f15088e;
        }
        return qVar.f15548h;
    }

    public static f i(e eVar, int i10) {
        e eVar2 = eVar.f15076f;
        if (eVar2 == null) {
            return null;
        }
        f fVar = eVar2.f15074d;
        q qVar = i10 == 0 ? fVar.f15086d : fVar.f15088e;
        int ordinal = eVar2.f15075e.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            return qVar.f15548h;
        }
        if (ordinal == 3 || ordinal == 4) {
            return qVar.f15549i;
        }
        return null;
    }

    public final void c(f fVar, f fVar2, int i10, g gVar) {
        fVar.f15519l.add(fVar2);
        fVar.f15519l.add(this.f15545e);
        fVar.f15515h = i10;
        fVar.f15516i = gVar;
        fVar2.f15518k.add(fVar);
        gVar.f15518k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i10, int i11) {
        int i12;
        if (i11 == 0) {
            f fVar = this.f15542b;
            int i13 = fVar.f15119w;
            i12 = Math.max(fVar.f15118v, i10);
            if (i13 > 0) {
                i12 = Math.min(i13, i10);
            }
            if (i12 == i10) {
                return i10;
            }
        } else {
            f fVar2 = this.f15542b;
            int i14 = fVar2.f15122z;
            int max = Math.max(fVar2.f15121y, i10);
            if (i14 > 0) {
                max = Math.min(i14, i10);
            }
            if (i12 == i10) {
                return i10;
            }
        }
        return i12;
    }

    public long j() {
        g gVar = this.f15545e;
        if (gVar.f15517j) {
            return (long) gVar.f15514g;
        }
        return 0;
    }

    public abstract boolean k();

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        if (r9.f15541a == 3) goto L_0x00a6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(u.e r12, u.e r13, int r14) {
        /*
            r11 = this;
            v.f r0 = h(r12)
            v.f r1 = h(r13)
            boolean r2 = r0.f15517j
            if (r2 == 0) goto L_0x00df
            boolean r2 = r1.f15517j
            if (r2 != 0) goto L_0x0012
            goto L_0x00df
        L_0x0012:
            int r2 = r0.f15514g
            int r12 = r12.e()
            int r12 = r12 + r2
            int r2 = r1.f15514g
            int r13 = r13.e()
            int r2 = r2 - r13
            int r13 = r2 - r12
            v.g r3 = r11.f15545e
            boolean r4 = r3.f15517j
            r5 = 1056964608(0x3f000000, float:0.5)
            if (r4 != 0) goto L_0x00a6
            int r4 = r11.f15544d
            r6 = 3
            if (r4 != r6) goto L_0x00a6
            int r4 = r11.f15541a
            if (r4 == 0) goto L_0x009e
            r7 = 1
            if (r4 == r7) goto L_0x0093
            r8 = 2
            if (r4 == r8) goto L_0x0071
            if (r4 == r6) goto L_0x003d
            goto L_0x00a6
        L_0x003d:
            u.f r4 = r11.f15542b
            v.l r8 = r4.f15086d
            int r9 = r8.f15544d
            if (r9 != r6) goto L_0x0054
            int r9 = r8.f15541a
            if (r9 != r6) goto L_0x0054
            v.n r9 = r4.f15088e
            int r10 = r9.f15544d
            if (r10 != r6) goto L_0x0054
            int r9 = r9.f15541a
            if (r9 != r6) goto L_0x0054
            goto L_0x00a6
        L_0x0054:
            if (r14 != 0) goto L_0x0058
            v.n r8 = r4.f15088e
        L_0x0058:
            v.g r6 = r8.f15545e
            boolean r8 = r6.f15517j
            if (r8 == 0) goto L_0x00a6
            float r4 = r4.X
            if (r14 != r7) goto L_0x0069
            int r6 = r6.f15514g
            float r6 = (float) r6
            float r6 = r6 / r4
            float r6 = r6 + r5
            int r4 = (int) r6
            goto L_0x00a3
        L_0x0069:
            int r6 = r6.f15514g
            float r6 = (float) r6
            float r4 = r4 * r6
            float r4 = r4 + r5
            int r4 = (int) r4
            goto L_0x00a3
        L_0x0071:
            u.f r4 = r11.f15542b
            u.f r6 = r4.U
            if (r6 == 0) goto L_0x00a6
            if (r14 != 0) goto L_0x007c
            v.l r6 = r6.f15086d
            goto L_0x007e
        L_0x007c:
            v.n r6 = r6.f15088e
        L_0x007e:
            v.g r6 = r6.f15545e
            boolean r7 = r6.f15517j
            if (r7 == 0) goto L_0x00a6
            if (r14 != 0) goto L_0x0089
            float r4 = r4.f15120x
            goto L_0x008b
        L_0x0089:
            float r4 = r4.A
        L_0x008b:
            int r6 = r6.f15514g
            float r6 = (float) r6
            float r6 = r6 * r4
            float r6 = r6 + r5
            int r4 = (int) r6
            goto L_0x009f
        L_0x0093:
            int r4 = r3.f15520m
            int r4 = r11.g(r4, r14)
            int r4 = java.lang.Math.min(r4, r13)
            goto L_0x00a3
        L_0x009e:
            r4 = r13
        L_0x009f:
            int r4 = r11.g(r4, r14)
        L_0x00a3:
            r3.d(r4)
        L_0x00a6:
            boolean r4 = r3.f15517j
            if (r4 != 0) goto L_0x00ab
            return
        L_0x00ab:
            int r4 = r3.f15514g
            v.f r6 = r11.f15549i
            v.f r7 = r11.f15548h
            if (r4 != r13) goto L_0x00ba
            r7.d(r12)
            r6.d(r2)
            return
        L_0x00ba:
            u.f r13 = r11.f15542b
            if (r14 != 0) goto L_0x00c1
            float r13 = r13.f15089e0
            goto L_0x00c3
        L_0x00c1:
            float r13 = r13.f15091f0
        L_0x00c3:
            if (r0 != r1) goto L_0x00cb
            int r12 = r0.f15514g
            int r2 = r1.f15514g
            r13 = 1056964608(0x3f000000, float:0.5)
        L_0x00cb:
            int r2 = r2 - r12
            int r2 = r2 - r4
            float r12 = (float) r12
            float r12 = r12 + r5
            float r14 = (float) r2
            float r14 = r14 * r13
            float r14 = r14 + r12
            int r12 = (int) r14
            r7.d(r12)
            int r12 = r7.f15514g
            int r13 = r3.f15514g
            int r12 = r12 + r13
            r6.d(r12)
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v.q.l(u.e, u.e, int):void");
    }
}
