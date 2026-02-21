package u;

import android.support.v4.media.session.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import v.b;
import v.e;
import v.o;

public final class g extends o {
    public int A0 = 0;
    public int B0 = 0;
    public c[] C0 = new c[4];
    public c[] D0 = new c[4];
    public int E0 = 257;
    public boolean F0 = false;
    public boolean G0 = false;
    public WeakReference H0 = null;
    public WeakReference I0 = null;
    public WeakReference J0 = null;
    public WeakReference K0 = null;
    public final HashSet L0 = new HashSet();
    public final b M0 = new b();

    /* renamed from: s0  reason: collision with root package name */
    public final u f15123s0 = new u(this);

    /* renamed from: t0  reason: collision with root package name */
    public final e f15124t0 = new e(this);

    /* renamed from: u0  reason: collision with root package name */
    public int f15125u0;

    /* renamed from: v0  reason: collision with root package name */
    public o f15126v0 = null;

    /* renamed from: w0  reason: collision with root package name */
    public boolean f15127w0 = false;

    /* renamed from: x0  reason: collision with root package name */
    public final s.e f15128x0 = new s.e();

    /* renamed from: y0  reason: collision with root package name */
    public int f15129y0;

    /* renamed from: z0  reason: collision with root package name */
    public int f15130z0;

    public static void U(f fVar, o oVar, b bVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int i10;
        int i11;
        int i12;
        if (oVar != null) {
            if (fVar.f15095h0 == 8 || (fVar instanceof j) || (fVar instanceof a)) {
                bVar.f15491e = 0;
                bVar.f15492f = 0;
                return;
            }
            int[] iArr = fVar.f15113q0;
            bVar.f15487a = iArr[0];
            boolean z14 = true;
            bVar.f15488b = iArr[1];
            bVar.f15489c = fVar.q();
            bVar.f15490d = fVar.l();
            bVar.f15495i = false;
            bVar.f15496j = 0;
            if (bVar.f15487a == 3) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (bVar.f15488b == 3) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z10 || fVar.X <= 0.0f) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (!z11 || fVar.X <= 0.0f) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (z10 && fVar.t(0) && fVar.f15115s == 0 && !z12) {
                bVar.f15487a = 2;
                if (z11 && fVar.f15116t == 0) {
                    bVar.f15487a = 1;
                }
                z10 = false;
            }
            if (z11 && fVar.t(1) && fVar.f15116t == 0 && !z13) {
                bVar.f15488b = 2;
                if (z10 && fVar.f15115s == 0) {
                    bVar.f15488b = 1;
                }
                z11 = false;
            }
            if (fVar.A()) {
                bVar.f15487a = 1;
                z10 = false;
            }
            if (fVar.B()) {
                bVar.f15488b = 1;
                z11 = false;
            }
            int[] iArr2 = fVar.f15117u;
            if (z12) {
                if (iArr2[0] == 4) {
                    bVar.f15487a = 1;
                } else if (!z11) {
                    if (bVar.f15488b == 1) {
                        i12 = bVar.f15490d;
                    } else {
                        bVar.f15487a = 2;
                        oVar.b(fVar, bVar);
                        i12 = bVar.f15492f;
                    }
                    bVar.f15487a = 1;
                    bVar.f15489c = (int) (fVar.X * ((float) i12));
                }
            }
            if (z13) {
                if (iArr2[1] == 4) {
                    bVar.f15488b = 1;
                } else if (!z10) {
                    if (bVar.f15487a == 1) {
                        i10 = bVar.f15489c;
                    } else {
                        bVar.f15488b = 2;
                        oVar.b(fVar, bVar);
                        i10 = bVar.f15491e;
                    }
                    bVar.f15488b = 1;
                    if (fVar.Y == -1) {
                        i11 = (int) (((float) i10) / fVar.X);
                    } else {
                        i11 = (int) (fVar.X * ((float) i10));
                    }
                    bVar.f15490d = i11;
                }
            }
            oVar.b(fVar, bVar);
            fVar.N(bVar.f15491e);
            fVar.K(bVar.f15492f);
            fVar.F = bVar.f15494h;
            int i13 = bVar.f15493g;
            fVar.f15083b0 = i13;
            if (i13 <= 0) {
                z14 = false;
            }
            fVar.F = z14;
            bVar.f15496j = 0;
        }
    }

    public final void C() {
        this.f15128x0.t();
        this.f15129y0 = 0;
        this.f15130z0 = 0;
        super.C();
    }

    public final void O(boolean z10, boolean z11) {
        super.O(z10, z11);
        int size = this.f15168r0.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((f) this.f15168r0.get(i10)).O(z10, z11);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v0, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v72, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v1, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v2, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v68, resolved type: u.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v69, resolved type: u.a} */
    /* JADX WARNING: type inference failed for: r6v5, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v12 */
    /* JADX WARNING: type inference failed for: r6v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x05d9  */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x0630  */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0646  */
    /* JADX WARNING: Removed duplicated region for block: B:390:0x0675  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0677  */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x0682 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x0695  */
    /* JADX WARNING: Removed duplicated region for block: B:402:0x0697  */
    /* JADX WARNING: Removed duplicated region for block: B:405:0x06a1  */
    /* JADX WARNING: Removed duplicated region for block: B:411:0x06be  */
    /* JADX WARNING: Removed duplicated region for block: B:480:0x07ab  */
    /* JADX WARNING: Removed duplicated region for block: B:492:0x07f2  */
    /* JADX WARNING: Removed duplicated region for block: B:503:0x081b A[LOOP:34: B:502:0x0819->B:503:0x081b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:515:0x0881  */
    /* JADX WARNING: Removed duplicated region for block: B:516:0x088d  */
    /* JADX WARNING: Removed duplicated region for block: B:519:0x08a0  */
    /* JADX WARNING: Removed duplicated region for block: B:520:0x08a9  */
    /* JADX WARNING: Removed duplicated region for block: B:522:0x08ad  */
    /* JADX WARNING: Removed duplicated region for block: B:534:0x08de  */
    /* JADX WARNING: Removed duplicated region for block: B:537:0x08e6  */
    /* JADX WARNING: Removed duplicated region for block: B:541:0x08f3  */
    /* JADX WARNING: Removed duplicated region for block: B:633:0x08e7 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Q() {
        /*
            r30 = this;
            r1 = r30
            r2 = 0
            r1.Z = r2
            r1.f15081a0 = r2
            r1.F0 = r2
            r1.G0 = r2
            java.util.ArrayList r0 = r1.f15168r0
            int r3 = r0.size()
            int r0 = r30.q()
            int r0 = java.lang.Math.max(r2, r0)
            int r4 = r30.l()
            int r4 = java.lang.Math.max(r2, r4)
            int[] r5 = r1.f15113q0
            r6 = 1
            r7 = r5[r6]
            r8 = r5[r2]
            int r9 = r1.f15125u0
            u.e r12 = r1.K
            u.e r13 = r1.J
            if (r9 != 0) goto L_0x0257
            int r9 = r1.E0
            boolean r9 = u.m.b(r9, r6)
            if (r9 == 0) goto L_0x0257
            v.o r9 = r1.f15126v0
            v.b r14 = v.h.f15521a
            r14 = r5[r2]
            r15 = r5[r6]
            r30.E()
            java.util.ArrayList r11 = r1.f15168r0
            int r10 = r11.size()
        L_0x0049:
            if (r2 >= r10) goto L_0x0057
            java.lang.Object r17 = r11.get(r2)
            u.f r17 = (u.f) r17
            r17.E()
            int r2 = r2 + 1
            goto L_0x0049
        L_0x0057:
            boolean r2 = r1.f15127w0
            if (r14 != r6) goto L_0x0064
            int r14 = r30.q()
            r6 = 0
            r1.I(r6, r14)
            goto L_0x006a
        L_0x0064:
            r6 = 0
            r13.l(r6)
            r1.Z = r6
        L_0x006a:
            r6 = 0
            r14 = 0
            r18 = 0
        L_0x006e:
            r19 = 1056964608(0x3f000000, float:0.5)
            if (r6 >= r10) goto L_0x00d8
            java.lang.Object r20 = r11.get(r6)
            r21 = r13
            r13 = r20
            u.f r13 = (u.f) r13
            r20 = r4
            boolean r4 = r13 instanceof u.j
            if (r4 == 0) goto L_0x00bf
            u.j r13 = (u.j) r13
            int r4 = r13.f15156v0
            r22 = r5
            r5 = 1
            if (r4 != r5) goto L_0x00cf
            int r4 = r13.f15153s0
            r5 = -1
            if (r4 == r5) goto L_0x0091
            goto L_0x00b5
        L_0x0091:
            int r4 = r13.f15154t0
            if (r4 == r5) goto L_0x00a3
            boolean r4 = r30.A()
            if (r4 == 0) goto L_0x00a3
            int r4 = r30.q()
            int r5 = r13.f15154t0
            int r4 = r4 - r5
            goto L_0x00b5
        L_0x00a3:
            boolean r4 = r30.A()
            if (r4 == 0) goto L_0x00bd
            float r4 = r13.f15152r0
            int r5 = r30.q()
            float r5 = (float) r5
            float r4 = r4 * r5
            float r4 = r4 + r19
            int r4 = (int) r4
        L_0x00b5:
            u.e r5 = r13.f15155u0
            r5.l(r4)
            r4 = 1
            r13.f15157w0 = r4
        L_0x00bd:
            r14 = 1
            goto L_0x00cf
        L_0x00bf:
            r22 = r5
            boolean r4 = r13 instanceof u.a
            if (r4 == 0) goto L_0x00cf
            u.a r13 = (u.a) r13
            int r4 = r13.S()
            if (r4 != 0) goto L_0x00cf
            r18 = 1
        L_0x00cf:
            int r6 = r6 + 1
            r4 = r20
            r13 = r21
            r5 = r22
            goto L_0x006e
        L_0x00d8:
            r20 = r4
            r22 = r5
            r21 = r13
            if (r14 == 0) goto L_0x00fd
            r4 = 0
        L_0x00e1:
            if (r4 >= r10) goto L_0x00fd
            java.lang.Object r5 = r11.get(r4)
            u.f r5 = (u.f) r5
            boolean r6 = r5 instanceof u.j
            if (r6 == 0) goto L_0x00f9
            u.j r5 = (u.j) r5
            int r6 = r5.f15156v0
            r13 = 1
            if (r6 != r13) goto L_0x00f9
            r6 = 0
            v.h.b(r6, r5, r9, r2)
            goto L_0x00fa
        L_0x00f9:
            r6 = 0
        L_0x00fa:
            int r4 = r4 + 1
            goto L_0x00e1
        L_0x00fd:
            r6 = 0
            v.h.b(r6, r1, r9, r2)
            if (r18 == 0) goto L_0x0125
            r4 = 0
        L_0x0104:
            if (r4 >= r10) goto L_0x0125
            java.lang.Object r5 = r11.get(r4)
            u.f r5 = (u.f) r5
            boolean r6 = r5 instanceof u.a
            if (r6 == 0) goto L_0x0122
            u.a r5 = (u.a) r5
            int r6 = r5.S()
            if (r6 != 0) goto L_0x0122
            boolean r6 = r5.R()
            if (r6 == 0) goto L_0x0122
            r6 = 1
            v.h.b(r6, r5, r9, r2)
        L_0x0122:
            int r4 = r4 + 1
            goto L_0x0104
        L_0x0125:
            r4 = 1
            if (r15 != r4) goto L_0x0131
            int r4 = r30.l()
            r5 = 0
            r1.J(r5, r4)
            goto L_0x0137
        L_0x0131:
            r5 = 0
            r12.l(r5)
            r1.f15081a0 = r5
        L_0x0137:
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x013a:
            if (r4 >= r10) goto L_0x0193
            java.lang.Object r13 = r11.get(r4)
            u.f r13 = (u.f) r13
            boolean r14 = r13 instanceof u.j
            if (r14 == 0) goto L_0x0182
            u.j r13 = (u.j) r13
            int r14 = r13.f15156v0
            if (r14 != 0) goto L_0x0190
            int r5 = r13.f15153s0
            r14 = -1
            if (r5 == r14) goto L_0x0152
            goto L_0x0176
        L_0x0152:
            int r5 = r13.f15154t0
            if (r5 == r14) goto L_0x0164
            boolean r5 = r30.B()
            if (r5 == 0) goto L_0x0164
            int r5 = r30.l()
            int r14 = r13.f15154t0
            int r5 = r5 - r14
            goto L_0x0176
        L_0x0164:
            boolean r5 = r30.B()
            if (r5 == 0) goto L_0x017f
            float r5 = r13.f15152r0
            int r14 = r30.l()
            float r14 = (float) r14
            float r5 = r5 * r14
            float r5 = r5 + r19
            int r5 = (int) r5
        L_0x0176:
            u.e r14 = r13.f15155u0
            r14.l(r5)
            r14 = 1
            r13.f15157w0 = r14
            goto L_0x0180
        L_0x017f:
            r14 = 1
        L_0x0180:
            r5 = 1
            goto L_0x0190
        L_0x0182:
            r14 = 1
            boolean r15 = r13 instanceof u.a
            if (r15 == 0) goto L_0x0190
            u.a r13 = (u.a) r13
            int r13 = r13.S()
            if (r13 != r14) goto L_0x0190
            r6 = 1
        L_0x0190:
            int r4 = r4 + 1
            goto L_0x013a
        L_0x0193:
            if (r5 == 0) goto L_0x01af
            r4 = 0
        L_0x0196:
            if (r4 >= r10) goto L_0x01af
            java.lang.Object r5 = r11.get(r4)
            u.f r5 = (u.f) r5
            boolean r13 = r5 instanceof u.j
            if (r13 == 0) goto L_0x01ac
            u.j r5 = (u.j) r5
            int r13 = r5.f15156v0
            if (r13 != 0) goto L_0x01ac
            r13 = 1
            v.h.g(r13, r5, r9)
        L_0x01ac:
            int r4 = r4 + 1
            goto L_0x0196
        L_0x01af:
            r4 = 0
            v.h.g(r4, r1, r9)
            if (r6 == 0) goto L_0x01d7
            r4 = 0
        L_0x01b6:
            if (r4 >= r10) goto L_0x01d7
            java.lang.Object r5 = r11.get(r4)
            u.f r5 = (u.f) r5
            boolean r6 = r5 instanceof u.a
            if (r6 == 0) goto L_0x01d4
            u.a r5 = (u.a) r5
            int r6 = r5.S()
            r13 = 1
            if (r6 != r13) goto L_0x01d4
            boolean r6 = r5.R()
            if (r6 == 0) goto L_0x01d4
            v.h.g(r13, r5, r9)
        L_0x01d4:
            int r4 = r4 + 1
            goto L_0x01b6
        L_0x01d7:
            r4 = 0
        L_0x01d8:
            if (r4 >= r10) goto L_0x020d
            java.lang.Object r5 = r11.get(r4)
            u.f r5 = (u.f) r5
            boolean r6 = r5.z()
            if (r6 == 0) goto L_0x020a
            boolean r6 = v.h.a(r5)
            if (r6 == 0) goto L_0x020a
            v.b r6 = v.h.f15521a
            U(r5, r9, r6)
            boolean r6 = r5 instanceof u.j
            if (r6 == 0) goto L_0x0203
            r6 = r5
            u.j r6 = (u.j) r6
            int r6 = r6.f15156v0
            if (r6 != 0) goto L_0x01fe
            r6 = 0
            goto L_0x0207
        L_0x01fe:
            r6 = 0
            v.h.b(r6, r5, r9, r2)
            goto L_0x020a
        L_0x0203:
            r6 = 0
            v.h.b(r6, r5, r9, r2)
        L_0x0207:
            v.h.g(r6, r5, r9)
        L_0x020a:
            int r4 = r4 + 1
            goto L_0x01d8
        L_0x020d:
            r2 = 0
        L_0x020e:
            if (r2 >= r3) goto L_0x025d
            java.util.ArrayList r4 = r1.f15168r0
            java.lang.Object r4 = r4.get(r2)
            u.f r4 = (u.f) r4
            boolean r5 = r4.z()
            if (r5 == 0) goto L_0x0254
            boolean r5 = r4 instanceof u.j
            if (r5 != 0) goto L_0x0254
            boolean r5 = r4 instanceof u.a
            if (r5 != 0) goto L_0x0254
            boolean r5 = r4 instanceof u.n
            if (r5 != 0) goto L_0x0254
            boolean r5 = r4.G
            if (r5 != 0) goto L_0x0254
            r5 = 0
            int r6 = r4.k(r5)
            r5 = 1
            int r9 = r4.k(r5)
            r10 = 3
            if (r6 != r10) goto L_0x0247
            int r6 = r4.f15115s
            if (r6 == r5) goto L_0x0247
            if (r9 != r10) goto L_0x0247
            int r6 = r4.f15116t
            if (r6 == r5) goto L_0x0247
            r5 = 1
            goto L_0x0248
        L_0x0247:
            r5 = 0
        L_0x0248:
            if (r5 != 0) goto L_0x0254
            v.b r5 = new v.b
            r5.<init>()
            v.o r6 = r1.f15126v0
            U(r4, r6, r5)
        L_0x0254:
            int r2 = r2 + 1
            goto L_0x020e
        L_0x0257:
            r20 = r4
            r22 = r5
            r21 = r13
        L_0x025d:
            s.e r2 = r1.f15128x0
            r4 = 2
            if (r3 <= r4) goto L_0x0656
            if (r8 == r4) goto L_0x0266
            if (r7 != r4) goto L_0x0656
        L_0x0266:
            int r6 = r1.E0
            r9 = 1024(0x400, float:1.435E-42)
            boolean r6 = u.m.b(r6, r9)
            if (r6 == 0) goto L_0x0656
            v.o r6 = r1.f15126v0
            java.util.ArrayList r9 = r1.f15168r0
            int r10 = r9.size()
            r11 = 0
        L_0x0279:
            if (r11 >= r10) goto L_0x02ad
            java.lang.Object r13 = r9.get(r11)
            u.f r13 = (u.f) r13
            r14 = 0
            r15 = r22[r14]
            r17 = 1
            r4 = r22[r17]
            int[] r5 = r13.f15113q0
            r23 = r12
            r12 = r5[r14]
            r5 = r5[r17]
            boolean r4 = v.i.b(r15, r4, r12, r5)
            if (r4 != 0) goto L_0x0297
            goto L_0x029b
        L_0x0297:
            boolean r4 = r13 instanceof u.i
            if (r4 == 0) goto L_0x02a7
        L_0x029b:
            r26 = r0
            r25 = r3
            r24 = r7
            r27 = r8
            r0 = 0
            r8 = r2
            goto L_0x060b
        L_0x02a7:
            int r11 = r11 + 1
            r12 = r23
            r4 = 2
            goto L_0x0279
        L_0x02ad:
            r23 = r12
            r4 = 0
            r5 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x02b6:
            if (r4 >= r10) goto L_0x0397
            java.lang.Object r24 = r9.get(r4)
            r25 = r3
            r3 = r24
            u.f r3 = (u.f) r3
            r24 = r7
            r16 = 0
            r7 = r22[r16]
            r26 = r0
            r17 = 1
            r0 = r22[r17]
            r27 = r8
            int[] r8 = r3.f15113q0
            r28 = r2
            r2 = r8[r16]
            r8 = r8[r17]
            boolean r0 = v.i.b(r7, r0, r2, r8)
            if (r0 != 0) goto L_0x02e3
            v.b r0 = r1.M0
            U(r3, r6, r0)
        L_0x02e3:
            boolean r0 = r3 instanceof u.j
            if (r0 == 0) goto L_0x0308
            r2 = r3
            u.j r2 = (u.j) r2
            int r7 = r2.f15156v0
            if (r7 != 0) goto L_0x02f9
            if (r12 != 0) goto L_0x02f6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r12 = r7
        L_0x02f6:
            r12.add(r2)
        L_0x02f9:
            int r7 = r2.f15156v0
            r8 = 1
            if (r7 != r8) goto L_0x0308
            if (r5 != 0) goto L_0x0305
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
        L_0x0305:
            r5.add(r2)
        L_0x0308:
            boolean r2 = r3 instanceof u.l
            if (r2 == 0) goto L_0x034b
            boolean r2 = r3 instanceof u.a
            if (r2 == 0) goto L_0x0333
            r2 = r3
            u.a r2 = (u.a) r2
            int r7 = r2.S()
            if (r7 != 0) goto L_0x0324
            if (r11 != 0) goto L_0x0321
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r11 = r7
        L_0x0321:
            r11.add(r2)
        L_0x0324:
            int r7 = r2.S()
            r8 = 1
            if (r7 != r8) goto L_0x034b
            if (r13 != 0) goto L_0x0348
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            goto L_0x0347
        L_0x0333:
            r2 = r3
            u.l r2 = (u.l) r2
            if (r11 != 0) goto L_0x033d
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
        L_0x033d:
            r11.add(r2)
            if (r13 != 0) goto L_0x0348
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x0347:
            r13 = r7
        L_0x0348:
            r13.add(r2)
        L_0x034b:
            u.e r2 = r3.J
            u.e r2 = r2.f15076f
            if (r2 != 0) goto L_0x0367
            u.e r2 = r3.L
            u.e r2 = r2.f15076f
            if (r2 != 0) goto L_0x0367
            if (r0 != 0) goto L_0x0367
            boolean r2 = r3 instanceof u.a
            if (r2 != 0) goto L_0x0367
            if (r14 != 0) goto L_0x0364
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
        L_0x0364:
            r14.add(r3)
        L_0x0367:
            u.e r2 = r3.K
            u.e r2 = r2.f15076f
            if (r2 != 0) goto L_0x0389
            u.e r2 = r3.M
            u.e r2 = r2.f15076f
            if (r2 != 0) goto L_0x0389
            u.e r2 = r3.N
            u.e r2 = r2.f15076f
            if (r2 != 0) goto L_0x0389
            if (r0 != 0) goto L_0x0389
            boolean r0 = r3 instanceof u.a
            if (r0 != 0) goto L_0x0389
            if (r15 != 0) goto L_0x0386
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
        L_0x0386:
            r15.add(r3)
        L_0x0389:
            int r4 = r4 + 1
            r7 = r24
            r3 = r25
            r0 = r26
            r8 = r27
            r2 = r28
            goto L_0x02b6
        L_0x0397:
            r26 = r0
            r28 = r2
            r25 = r3
            r24 = r7
            r27 = r8
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r5 == 0) goto L_0x03be
            java.util.Iterator r2 = r5.iterator()
        L_0x03ac:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x03be
            java.lang.Object r3 = r2.next()
            u.j r3 = (u.j) r3
            r4 = 0
            r5 = 0
            v.i.a(r3, r5, r0, r4)
            goto L_0x03ac
        L_0x03be:
            r4 = 0
            r5 = 0
            if (r11 == 0) goto L_0x03df
            java.util.Iterator r2 = r11.iterator()
        L_0x03c6:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x03df
            java.lang.Object r3 = r2.next()
            u.l r3 = (u.l) r3
            v.p r6 = v.i.a(r3, r5, r0, r4)
            r3.Q(r5, r6, r0)
            r6.a(r0)
            r4 = 0
            r5 = 0
            goto L_0x03c6
        L_0x03df:
            u.d r2 = u.d.LEFT
            u.e r2 = r1.j(r2)
            java.util.HashSet r2 = r2.f15071a
            if (r2 == 0) goto L_0x0401
            java.util.Iterator r2 = r2.iterator()
        L_0x03ed:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0401
            java.lang.Object r3 = r2.next()
            u.e r3 = (u.e) r3
            u.f r3 = r3.f15074d
            r4 = 0
            r5 = 0
            v.i.a(r3, r5, r0, r4)
            goto L_0x03ed
        L_0x0401:
            u.d r2 = u.d.RIGHT
            u.e r2 = r1.j(r2)
            java.util.HashSet r2 = r2.f15071a
            if (r2 == 0) goto L_0x0423
            java.util.Iterator r2 = r2.iterator()
        L_0x040f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.next()
            u.e r3 = (u.e) r3
            u.f r3 = r3.f15074d
            r4 = 0
            r5 = 0
            v.i.a(r3, r5, r0, r4)
            goto L_0x040f
        L_0x0423:
            u.d r2 = u.d.CENTER
            u.e r3 = r1.j(r2)
            java.util.HashSet r3 = r3.f15071a
            if (r3 == 0) goto L_0x0445
            java.util.Iterator r3 = r3.iterator()
        L_0x0431:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0445
            java.lang.Object r4 = r3.next()
            u.e r4 = (u.e) r4
            u.f r4 = r4.f15074d
            r5 = 0
            r6 = 0
            v.i.a(r4, r6, r0, r5)
            goto L_0x0431
        L_0x0445:
            r5 = 0
            r6 = 0
            if (r14 == 0) goto L_0x045d
            java.util.Iterator r3 = r14.iterator()
        L_0x044d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x045d
            java.lang.Object r4 = r3.next()
            u.f r4 = (u.f) r4
            v.i.a(r4, r6, r0, r5)
            goto L_0x044d
        L_0x045d:
            if (r12 == 0) goto L_0x0474
            java.util.Iterator r3 = r12.iterator()
        L_0x0463:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0474
            java.lang.Object r4 = r3.next()
            u.j r4 = (u.j) r4
            r6 = 1
            v.i.a(r4, r6, r0, r5)
            goto L_0x0463
        L_0x0474:
            r6 = 1
            if (r13 == 0) goto L_0x0494
            java.util.Iterator r3 = r13.iterator()
        L_0x047b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r3.next()
            u.l r4 = (u.l) r4
            v.p r7 = v.i.a(r4, r6, r0, r5)
            r4.Q(r6, r7, r0)
            r7.a(r0)
            r5 = 0
            r6 = 1
            goto L_0x047b
        L_0x0494:
            u.d r3 = u.d.TOP
            u.e r3 = r1.j(r3)
            java.util.HashSet r3 = r3.f15071a
            if (r3 == 0) goto L_0x04b6
            java.util.Iterator r3 = r3.iterator()
        L_0x04a2:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04b6
            java.lang.Object r4 = r3.next()
            u.e r4 = (u.e) r4
            u.f r4 = r4.f15074d
            r5 = 0
            r6 = 1
            v.i.a(r4, r6, r0, r5)
            goto L_0x04a2
        L_0x04b6:
            u.d r3 = u.d.BASELINE
            u.e r3 = r1.j(r3)
            java.util.HashSet r3 = r3.f15071a
            if (r3 == 0) goto L_0x04d8
            java.util.Iterator r3 = r3.iterator()
        L_0x04c4:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04d8
            java.lang.Object r4 = r3.next()
            u.e r4 = (u.e) r4
            u.f r4 = r4.f15074d
            r5 = 0
            r6 = 1
            v.i.a(r4, r6, r0, r5)
            goto L_0x04c4
        L_0x04d8:
            u.d r3 = u.d.BOTTOM
            u.e r3 = r1.j(r3)
            java.util.HashSet r3 = r3.f15071a
            if (r3 == 0) goto L_0x04fa
            java.util.Iterator r3 = r3.iterator()
        L_0x04e6:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04fa
            java.lang.Object r4 = r3.next()
            u.e r4 = (u.e) r4
            u.f r4 = r4.f15074d
            r5 = 0
            r6 = 1
            v.i.a(r4, r6, r0, r5)
            goto L_0x04e6
        L_0x04fa:
            u.e r2 = r1.j(r2)
            java.util.HashSet r2 = r2.f15071a
            if (r2 == 0) goto L_0x051a
            java.util.Iterator r2 = r2.iterator()
        L_0x0506:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x051a
            java.lang.Object r3 = r2.next()
            u.e r3 = (u.e) r3
            u.f r3 = r3.f15074d
            r4 = 0
            r5 = 1
            v.i.a(r3, r5, r0, r4)
            goto L_0x0506
        L_0x051a:
            r4 = 0
            r5 = 1
            if (r15 == 0) goto L_0x0532
            java.util.Iterator r2 = r15.iterator()
        L_0x0522:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0532
            java.lang.Object r3 = r2.next()
            u.f r3 = (u.f) r3
            v.i.a(r3, r5, r0, r4)
            goto L_0x0522
        L_0x0532:
            r2 = 0
        L_0x0533:
            if (r2 >= r10) goto L_0x058e
            java.lang.Object r3 = r9.get(r2)
            u.f r3 = (u.f) r3
            int[] r4 = r3.f15113q0
            r6 = 0
            r7 = r4[r6]
            r6 = 3
            if (r7 != r6) goto L_0x0549
            r4 = r4[r5]
            if (r4 != r6) goto L_0x0549
            r4 = 1
            goto L_0x054a
        L_0x0549:
            r4 = 0
        L_0x054a:
            if (r4 == 0) goto L_0x058a
            int r4 = r3.f15109o0
            int r5 = r0.size()
            r7 = 0
        L_0x0553:
            if (r7 >= r5) goto L_0x0563
            java.lang.Object r8 = r0.get(r7)
            v.p r8 = (v.p) r8
            int r11 = r8.f15537b
            if (r4 != r11) goto L_0x0560
            goto L_0x0564
        L_0x0560:
            int r7 = r7 + 1
            goto L_0x0553
        L_0x0563:
            r8 = 0
        L_0x0564:
            int r3 = r3.f15111p0
            int r4 = r0.size()
            r5 = 0
        L_0x056b:
            if (r5 >= r4) goto L_0x057b
            java.lang.Object r7 = r0.get(r5)
            v.p r7 = (v.p) r7
            int r11 = r7.f15537b
            if (r3 != r11) goto L_0x0578
            goto L_0x057c
        L_0x0578:
            int r5 = r5 + 1
            goto L_0x056b
        L_0x057b:
            r7 = 0
        L_0x057c:
            if (r8 == 0) goto L_0x058a
            if (r7 == 0) goto L_0x058a
            r3 = 0
            r8.c(r3, r7)
            r3 = 2
            r7.f15538c = r3
            r0.remove(r8)
        L_0x058a:
            int r2 = r2 + 1
            r5 = 1
            goto L_0x0533
        L_0x058e:
            int r2 = r0.size()
            r3 = 1
            if (r2 > r3) goto L_0x0599
            r8 = r28
            goto L_0x0608
        L_0x0599:
            r2 = 0
            r4 = r22[r2]
            r5 = 2
            if (r4 != r5) goto L_0x05d1
            java.util.Iterator r4 = r0.iterator()
            r5 = 0
            r6 = 0
        L_0x05a5:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x05c6
            java.lang.Object r7 = r4.next()
            v.p r7 = (v.p) r7
            int r8 = r7.f15538c
            if (r8 != r3) goto L_0x05b8
            r8 = r28
            goto L_0x05c2
        L_0x05b8:
            r8 = r28
            int r9 = r7.b(r8, r2)
            if (r9 <= r5) goto L_0x05c2
            r6 = r7
            r5 = r9
        L_0x05c2:
            r28 = r8
            r2 = 0
            goto L_0x05a5
        L_0x05c6:
            r8 = r28
            if (r6 == 0) goto L_0x05d3
            r1.L(r3)
            r1.N(r5)
            goto L_0x05d4
        L_0x05d1:
            r8 = r28
        L_0x05d3:
            r6 = 0
        L_0x05d4:
            r2 = r22[r3]
            r4 = 2
            if (r2 != r4) goto L_0x0602
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
            r4 = 0
        L_0x05df:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x05f9
            java.lang.Object r5 = r0.next()
            v.p r5 = (v.p) r5
            int r7 = r5.f15538c
            if (r7 != 0) goto L_0x05f0
            goto L_0x05df
        L_0x05f0:
            int r7 = r5.b(r8, r3)
            if (r7 <= r2) goto L_0x05df
            r4 = r5
            r2 = r7
            goto L_0x05df
        L_0x05f9:
            if (r4 == 0) goto L_0x0602
            r1.M(r3)
            r1.K(r2)
            goto L_0x0603
        L_0x0602:
            r4 = 0
        L_0x0603:
            if (r6 != 0) goto L_0x060a
            if (r4 == 0) goto L_0x0608
            goto L_0x060a
        L_0x0608:
            r0 = 0
            goto L_0x060b
        L_0x060a:
            r0 = 1
        L_0x060b:
            if (r0 == 0) goto L_0x064d
            r2 = r27
            r3 = 2
            if (r2 != r3) goto L_0x0628
            int r0 = r30.q()
            r3 = r26
            if (r3 >= r0) goto L_0x0623
            if (r3 <= 0) goto L_0x0623
            r1.N(r3)
            r4 = 1
            r1.F0 = r4
            goto L_0x062a
        L_0x0623:
            int r0 = r30.q()
            goto L_0x062b
        L_0x0628:
            r3 = r26
        L_0x062a:
            r0 = r3
        L_0x062b:
            r4 = r24
            r3 = 2
            if (r4 != r3) goto L_0x0646
            int r3 = r30.l()
            r5 = r20
            if (r5 >= r3) goto L_0x0641
            if (r5 <= 0) goto L_0x0641
            r1.K(r5)
            r3 = 1
            r1.G0 = r3
            goto L_0x0648
        L_0x0641:
            int r3 = r30.l()
            goto L_0x0649
        L_0x0646:
            r5 = r20
        L_0x0648:
            r3 = r5
        L_0x0649:
            r5 = r3
            r3 = r0
            r0 = 1
            goto L_0x0664
        L_0x064d:
            r5 = r20
            r4 = r24
            r3 = r26
            r2 = r27
            goto L_0x0663
        L_0x0656:
            r25 = r3
            r4 = r7
            r23 = r12
            r5 = r20
            r3 = r0
            r29 = r8
            r8 = r2
            r2 = r29
        L_0x0663:
            r0 = 0
        L_0x0664:
            r6 = 64
            boolean r7 = r1.V(r6)
            if (r7 != 0) goto L_0x0677
            r7 = 128(0x80, float:1.794E-43)
            boolean r7 = r1.V(r7)
            if (r7 == 0) goto L_0x0675
            goto L_0x0677
        L_0x0675:
            r7 = 0
            goto L_0x0678
        L_0x0677:
            r7 = 1
        L_0x0678:
            r8.getClass()
            r9 = 0
            r8.f13940g = r9
            int r10 = r1.E0
            if (r10 == 0) goto L_0x0688
            if (r7 == 0) goto L_0x0688
            r7 = 1
            r8.f13940g = r7
            goto L_0x0689
        L_0x0688:
            r7 = 1
        L_0x0689:
            java.util.ArrayList r10 = r1.f15168r0
            r11 = r22[r9]
            r12 = 2
            if (r11 == r12) goto L_0x0697
            r11 = r22[r7]
            if (r11 != r12) goto L_0x0695
            goto L_0x0697
        L_0x0695:
            r7 = 0
            goto L_0x0698
        L_0x0697:
            r7 = 1
        L_0x0698:
            r1.A0 = r9
            r1.B0 = r9
            r11 = r25
            r9 = 0
        L_0x069f:
            if (r9 >= r11) goto L_0x06b5
            java.util.ArrayList r12 = r1.f15168r0
            java.lang.Object r12 = r12.get(r9)
            u.f r12 = (u.f) r12
            boolean r13 = r12 instanceof u.o
            if (r13 == 0) goto L_0x06b2
            u.o r12 = (u.o) r12
            r12.Q()
        L_0x06b2:
            int r9 = r9 + 1
            goto L_0x069f
        L_0x06b5:
            boolean r9 = r1.V(r6)
            r12 = r0
            r0 = 0
            r13 = 1
        L_0x06bc:
            if (r13 == 0) goto L_0x08ed
            r14 = 1
            int r15 = r0 + 1
            r8.t()     // Catch:{ Exception -> 0x078d }
            r14 = 0
            r1.A0 = r14     // Catch:{ Exception -> 0x078d }
            r1.B0 = r14     // Catch:{ Exception -> 0x078d }
            r1.h(r8)     // Catch:{ Exception -> 0x078d }
            r0 = 0
        L_0x06cd:
            if (r0 >= r11) goto L_0x06dd
            java.util.ArrayList r14 = r1.f15168r0     // Catch:{ Exception -> 0x078d }
            java.lang.Object r14 = r14.get(r0)     // Catch:{ Exception -> 0x078d }
            u.f r14 = (u.f) r14     // Catch:{ Exception -> 0x078d }
            r14.h(r8)     // Catch:{ Exception -> 0x078d }
            int r0 = r0 + 1
            goto L_0x06cd
        L_0x06dd:
            r1.S(r8)     // Catch:{ Exception -> 0x078d }
            java.lang.ref.WeakReference r0 = r1.H0     // Catch:{ Exception -> 0x0781 }
            r13 = 5
            if (r0 == 0) goto L_0x070d
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0707 }
            if (r0 == 0) goto L_0x070d
            java.lang.ref.WeakReference r0 = r1.H0     // Catch:{ Exception -> 0x0707 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0707 }
            u.e r0 = (u.e) r0     // Catch:{ Exception -> 0x0707 }
            r14 = r23
            s.j r6 = r8.l(r14)     // Catch:{ Exception -> 0x0709 }
            s.j r0 = r8.l(r0)     // Catch:{ Exception -> 0x0709 }
            r23 = r14
            r14 = 0
            r8.f(r0, r6, r14, r13)     // Catch:{ Exception -> 0x0707 }
            r6 = 0
            r1.H0 = r6     // Catch:{ Exception -> 0x0707 }
            goto L_0x070d
        L_0x0707:
            r0 = move-exception
            goto L_0x0731
        L_0x0709:
            r0 = move-exception
            r23 = r14
            goto L_0x0731
        L_0x070d:
            java.lang.ref.WeakReference r0 = r1.J0     // Catch:{ Exception -> 0x0781 }
            if (r0 == 0) goto L_0x0733
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0707 }
            if (r0 == 0) goto L_0x0733
            java.lang.ref.WeakReference r0 = r1.J0     // Catch:{ Exception -> 0x0707 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0707 }
            u.e r0 = (u.e) r0     // Catch:{ Exception -> 0x0707 }
            u.e r6 = r1.M     // Catch:{ Exception -> 0x0707 }
            s.j r6 = r8.l(r6)     // Catch:{ Exception -> 0x0707 }
            s.j r0 = r8.l(r0)     // Catch:{ Exception -> 0x0707 }
            r14 = 0
            r8.f(r6, r0, r14, r13)     // Catch:{ Exception -> 0x0707 }
            r6 = 0
            r1.J0 = r6     // Catch:{ Exception -> 0x0707 }
            goto L_0x0733
        L_0x0731:
            r6 = 0
            goto L_0x078b
        L_0x0733:
            java.lang.ref.WeakReference r0 = r1.I0     // Catch:{ Exception -> 0x0781 }
            if (r0 == 0) goto L_0x075d
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0781 }
            if (r0 == 0) goto L_0x075d
            java.lang.ref.WeakReference r0 = r1.I0     // Catch:{ Exception -> 0x0781 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0781 }
            u.e r0 = (u.e) r0     // Catch:{ Exception -> 0x0781 }
            r6 = r21
            s.j r14 = r8.l(r6)     // Catch:{ Exception -> 0x0759 }
            s.j r0 = r8.l(r0)     // Catch:{ Exception -> 0x0759 }
            r21 = r6
            r6 = 0
            r8.f(r0, r14, r6, r13)     // Catch:{ Exception -> 0x0781 }
            r6 = 0
            r1.I0 = r6     // Catch:{ Exception -> 0x078a }
            goto L_0x075d
        L_0x0759:
            r0 = move-exception
            r21 = r6
            goto L_0x0731
        L_0x075d:
            java.lang.ref.WeakReference r0 = r1.K0     // Catch:{ Exception -> 0x0781 }
            if (r0 == 0) goto L_0x0783
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0781 }
            if (r0 == 0) goto L_0x0783
            java.lang.ref.WeakReference r0 = r1.K0     // Catch:{ Exception -> 0x0781 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0781 }
            u.e r0 = (u.e) r0     // Catch:{ Exception -> 0x0781 }
            u.e r6 = r1.L     // Catch:{ Exception -> 0x0781 }
            s.j r6 = r8.l(r6)     // Catch:{ Exception -> 0x0781 }
            s.j r0 = r8.l(r0)     // Catch:{ Exception -> 0x0781 }
            r14 = 0
            r8.f(r6, r0, r14, r13)     // Catch:{ Exception -> 0x0781 }
            r6 = 0
            r1.K0 = r6     // Catch:{ Exception -> 0x078a }
            goto L_0x0784
        L_0x0781:
            r0 = move-exception
            goto L_0x0731
        L_0x0783:
            r6 = 0
        L_0x0784:
            r8.q()     // Catch:{ Exception -> 0x078a }
            r20 = 1
            goto L_0x07a7
        L_0x078a:
            r0 = move-exception
        L_0x078b:
            r13 = 1
            goto L_0x078f
        L_0x078d:
            r0 = move-exception
            r6 = 0
        L_0x078f:
            r0.printStackTrace()
            java.io.PrintStream r14 = java.lang.System.out
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r20 = r13
            java.lang.String r13 = "EXCEPTION : "
            r6.<init>(r13)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r14.println(r0)
        L_0x07a7:
            boolean[] r0 = u.m.f15160a
            if (r20 == 0) goto L_0x07f2
            r6 = 2
            r13 = 0
            r0[r6] = r13
            r6 = 64
            boolean r13 = r1.V(r6)
            r1.P(r8, r13)
            java.util.ArrayList r14 = r1.f15168r0
            int r14 = r14.size()
            r6 = 0
            r20 = 0
        L_0x07c1:
            if (r6 >= r14) goto L_0x07ee
            r24 = r14
            java.util.ArrayList r14 = r1.f15168r0
            java.lang.Object r14 = r14.get(r6)
            u.f r14 = (u.f) r14
            r14.P(r8, r13)
            r25 = r13
            int r13 = r14.f15096i
            r26 = r12
            r12 = -1
            if (r13 != r12) goto L_0x07e0
            int r13 = r14.f15098j
            if (r13 == r12) goto L_0x07de
            goto L_0x07e0
        L_0x07de:
            r13 = 0
            goto L_0x07e1
        L_0x07e0:
            r13 = 1
        L_0x07e1:
            if (r13 == 0) goto L_0x07e5
            r20 = 1
        L_0x07e5:
            int r6 = r6 + 1
            r14 = r24
            r13 = r25
            r12 = r26
            goto L_0x07c1
        L_0x07ee:
            r26 = r12
            r12 = -1
            goto L_0x080b
        L_0x07f2:
            r26 = r12
            r12 = -1
            r1.P(r8, r9)
            r6 = 0
        L_0x07f9:
            if (r6 >= r11) goto L_0x0809
            java.util.ArrayList r13 = r1.f15168r0
            java.lang.Object r13 = r13.get(r6)
            u.f r13 = (u.f) r13
            r13.P(r8, r9)
            int r6 = r6 + 1
            goto L_0x07f9
        L_0x0809:
            r20 = 0
        L_0x080b:
            r6 = 8
            if (r7 == 0) goto L_0x0871
            if (r15 >= r6) goto L_0x0871
            r13 = 2
            boolean r0 = r0[r13]
            if (r0 == 0) goto L_0x0871
            r0 = 0
            r13 = 0
            r14 = 0
        L_0x0819:
            if (r0 >= r11) goto L_0x0840
            java.util.ArrayList r12 = r1.f15168r0
            java.lang.Object r12 = r12.get(r0)
            u.f r12 = (u.f) r12
            int r6 = r12.Z
            int r25 = r12.q()
            int r6 = r25 + r6
            int r13 = java.lang.Math.max(r13, r6)
            int r6 = r12.f15081a0
            int r12 = r12.l()
            int r12 = r12 + r6
            int r14 = java.lang.Math.max(r14, r12)
            int r0 = r0 + 1
            r6 = 8
            r12 = -1
            goto L_0x0819
        L_0x0840:
            int r0 = r1.f15085c0
            int r0 = java.lang.Math.max(r0, r13)
            int r6 = r1.f15087d0
            int r6 = java.lang.Math.max(r6, r14)
            r12 = 2
            if (r2 != r12) goto L_0x085f
            int r13 = r30.q()
            if (r13 >= r0) goto L_0x085f
            r1.N(r0)
            r13 = 0
            r22[r13] = r12
            r20 = 1
            r26 = 1
        L_0x085f:
            if (r4 != r12) goto L_0x0871
            int r0 = r30.l()
            if (r0 >= r6) goto L_0x0871
            r1.K(r6)
            r6 = 1
            r22[r6] = r12
            r20 = 1
            r26 = 1
        L_0x0871:
            int r0 = r1.f15085c0
            int r6 = r30.q()
            int r0 = java.lang.Math.max(r0, r6)
            int r6 = r30.q()
            if (r0 <= r6) goto L_0x088d
            r1.N(r0)
            r6 = 1
            r12 = 0
            r22[r12] = r6
            r17 = 1
            r20 = 1
            goto L_0x0890
        L_0x088d:
            r6 = 1
            r17 = r26
        L_0x0890:
            int r0 = r1.f15087d0
            int r12 = r30.l()
            int r0 = java.lang.Math.max(r0, r12)
            int r12 = r30.l()
            if (r0 <= r12) goto L_0x08a9
            r1.K(r0)
            r22[r6] = r6
            r0 = 1
            r20 = 1
            goto L_0x08ab
        L_0x08a9:
            r0 = r17
        L_0x08ab:
            if (r0 != 0) goto L_0x08de
            r12 = 0
            r13 = r22[r12]
            r14 = 2
            if (r13 != r14) goto L_0x08c5
            if (r3 <= 0) goto L_0x08c5
            int r13 = r30.q()
            if (r13 <= r3) goto L_0x08c5
            r1.F0 = r6
            r22[r12] = r6
            r1.N(r3)
            r0 = 1
            r20 = 1
        L_0x08c5:
            r12 = r22[r6]
            r13 = 2
            if (r12 != r13) goto L_0x08df
            if (r5 <= 0) goto L_0x08df
            int r12 = r30.l()
            if (r12 <= r5) goto L_0x08df
            r1.G0 = r6
            r22[r6] = r6
            r1.K(r5)
            r0 = 8
            r6 = 1
            r12 = 1
            goto L_0x08e4
        L_0x08de:
            r13 = 2
        L_0x08df:
            r12 = r0
            r6 = r20
            r0 = 8
        L_0x08e4:
            if (r15 <= r0) goto L_0x08e7
            r6 = 0
        L_0x08e7:
            r13 = r6
            r0 = r15
            r6 = 64
            goto L_0x06bc
        L_0x08ed:
            r26 = r12
            r1.f15168r0 = r10
            if (r26 == 0) goto L_0x08f9
            r3 = 0
            r22[r3] = r2
            r2 = 1
            r22[r2] = r4
        L_0x08f9:
            s.d r0 = r8.f13945l
            r1.F(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u.g.Q():void");
    }

    public final void R(int i10, f fVar) {
        if (i10 == 0) {
            int i11 = this.A0 + 1;
            c[] cVarArr = this.D0;
            if (i11 >= cVarArr.length) {
                this.D0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
            }
            c[] cVarArr2 = this.D0;
            int i12 = this.A0;
            cVarArr2[i12] = new c(fVar, 0, this.f15127w0);
            this.A0 = i12 + 1;
        } else if (i10 == 1) {
            int i13 = this.B0 + 1;
            c[] cVarArr3 = this.C0;
            if (i13 >= cVarArr3.length) {
                this.C0 = (c[]) Arrays.copyOf(cVarArr3, cVarArr3.length * 2);
            }
            c[] cVarArr4 = this.C0;
            int i14 = this.B0;
            cVarArr4[i14] = new c(fVar, 1, this.f15127w0);
            this.B0 = i14 + 1;
        }
    }

    public final void S(s.e eVar) {
        boolean z10;
        int i10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean V = V(64);
        c(eVar, V);
        int size = this.f15168r0.size();
        boolean z14 = false;
        for (int i11 = 0; i11 < size; i11++) {
            f fVar = (f) this.f15168r0.get(i11);
            boolean[] zArr = fVar.T;
            zArr[0] = false;
            zArr[1] = false;
            if (fVar instanceof a) {
                z14 = true;
            }
        }
        if (z14) {
            for (int i12 = 0; i12 < size; i12++) {
                f fVar2 = (f) this.f15168r0.get(i12);
                if (fVar2 instanceof a) {
                    a aVar = (a) fVar2;
                    for (int i13 = 0; i13 < aVar.f15159s0; i13++) {
                        f fVar3 = aVar.f15158r0[i13];
                        if (aVar.f15042u0 || fVar3.d()) {
                            int i14 = aVar.f15041t0;
                            if (i14 == 0 || i14 == 1) {
                                fVar3.T[0] = true;
                            } else if (i14 == 2 || i14 == 3) {
                                fVar3.T[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = this.L0;
        hashSet.clear();
        for (int i15 = 0; i15 < size; i15++) {
            f fVar4 = (f) this.f15168r0.get(i15);
            fVar4.getClass();
            if ((fVar4 instanceof n) || (fVar4 instanceof j)) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z13) {
                if (fVar4 instanceof n) {
                    hashSet.add(fVar4);
                } else {
                    fVar4.c(eVar, V);
                }
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n nVar = (n) ((f) it.next());
                int i16 = 0;
                while (true) {
                    if (i16 >= nVar.f15159s0) {
                        z12 = false;
                        continue;
                        break;
                    } else if (hashSet.contains(nVar.f15158r0[i16])) {
                        z12 = true;
                        continue;
                        break;
                    } else {
                        i16++;
                    }
                }
                if (z12) {
                    nVar.c(eVar, V);
                    hashSet.remove(nVar);
                    break;
                }
            }
            if (size2 == hashSet.size()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((f) it2.next()).c(eVar, V);
                }
                hashSet.clear();
            }
        }
        if (s.e.f13932p) {
            HashSet hashSet2 = new HashSet();
            for (int i17 = 0; i17 < size; i17++) {
                f fVar5 = (f) this.f15168r0.get(i17);
                fVar5.getClass();
                if ((fVar5 instanceof n) || (fVar5 instanceof j)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    hashSet2.add(fVar5);
                }
            }
            if (this.f15113q0[0] == 2) {
                i10 = 0;
            } else {
                i10 = 1;
            }
            b(this, eVar, hashSet2, i10, false);
            Iterator it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                f fVar6 = (f) it3.next();
                m.a(this, eVar, fVar6);
                fVar6.c(eVar, V);
            }
        } else {
            for (int i18 = 0; i18 < size; i18++) {
                f fVar7 = (f) this.f15168r0.get(i18);
                if (fVar7 instanceof g) {
                    int[] iArr = fVar7.f15113q0;
                    int i19 = iArr[0];
                    int i20 = iArr[1];
                    if (i19 == 2) {
                        fVar7.L(1);
                    }
                    if (i20 == 2) {
                        fVar7.M(1);
                    }
                    fVar7.c(eVar, V);
                    if (i19 == 2) {
                        fVar7.L(i19);
                    }
                    if (i20 == 2) {
                        fVar7.M(i20);
                    }
                } else {
                    m.a(this, eVar, fVar7);
                    if ((fVar7 instanceof n) || (fVar7 instanceof j)) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z10) {
                        fVar7.c(eVar, V);
                    }
                }
            }
        }
        if (this.A0 > 0) {
            b.a(this, eVar, (ArrayList) null, 0);
        }
        if (this.B0 > 0) {
            b.a(this, eVar, (ArrayList) null, 1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x010c A[EDGE_INSN: B:76:0x010c->B:60:0x010c ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean T(int r14, boolean r15) {
        /*
            r13 = this;
            r0 = 1
            r15 = r15 & r0
            v.e r1 = r13.f15124t0
            java.lang.Object r2 = r1.f15501c
            u.g r2 = (u.g) r2
            r3 = 0
            int r4 = r2.k(r3)
            int r5 = r2.k(r0)
            int r6 = r2.r()
            int r7 = r2.s()
            java.lang.Object r8 = r1.f15503e
            if (r15 == 0) goto L_0x0072
            r9 = 2
            if (r4 == r9) goto L_0x0022
            if (r5 != r9) goto L_0x0072
        L_0x0022:
            r10 = r8
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            java.util.Iterator r10 = r10.iterator()
        L_0x0029:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0040
            java.lang.Object r11 = r10.next()
            v.q r11 = (v.q) r11
            int r12 = r11.f15546f
            if (r12 != r14) goto L_0x0029
            boolean r11 = r11.k()
            if (r11 != 0) goto L_0x0029
            r15 = 0
        L_0x0040:
            if (r14 != 0) goto L_0x0059
            if (r15 == 0) goto L_0x0072
            if (r4 != r9) goto L_0x0072
            r2.L(r0)
            int r15 = r1.e(r2, r3)
            r2.N(r15)
            v.l r15 = r2.f15086d
            v.g r15 = r15.f15545e
            int r9 = r2.q()
            goto L_0x006f
        L_0x0059:
            if (r15 == 0) goto L_0x0072
            if (r5 != r9) goto L_0x0072
            r2.M(r0)
            int r15 = r1.e(r2, r0)
            r2.K(r15)
            v.n r15 = r2.f15088e
            v.g r15 = r15.f15545e
            int r9 = r2.l()
        L_0x006f:
            r15.d(r9)
        L_0x0072:
            r15 = 4
            int[] r9 = r2.f15113q0
            if (r14 != 0) goto L_0x0092
            r7 = r9[r3]
            if (r7 == r0) goto L_0x007d
            if (r7 != r15) goto L_0x0099
        L_0x007d:
            int r15 = r2.q()
            int r15 = r15 + r6
            v.l r7 = r2.f15086d
            v.f r7 = r7.f15549i
            r7.d(r15)
            v.l r7 = r2.f15086d
            v.g r7 = r7.f15545e
            int r15 = r15 - r6
            r7.d(r15)
            goto L_0x00af
        L_0x0092:
            r6 = r9[r0]
            if (r6 == r0) goto L_0x009b
            if (r6 != r15) goto L_0x0099
            goto L_0x009b
        L_0x0099:
            r15 = 0
            goto L_0x00b0
        L_0x009b:
            int r15 = r2.l()
            int r15 = r15 + r7
            v.n r6 = r2.f15088e
            v.f r6 = r6.f15549i
            r6.d(r15)
            v.n r6 = r2.f15088e
            v.g r6 = r6.f15545e
            int r15 = r15 - r7
            r6.d(r15)
        L_0x00af:
            r15 = 1
        L_0x00b0:
            r1.i()
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            java.util.Iterator r1 = r8.iterator()
        L_0x00b9:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x00d7
            java.lang.Object r6 = r1.next()
            v.q r6 = (v.q) r6
            int r7 = r6.f15546f
            if (r7 == r14) goto L_0x00ca
            goto L_0x00b9
        L_0x00ca:
            u.f r7 = r6.f15542b
            if (r7 != r2) goto L_0x00d3
            boolean r7 = r6.f15547g
            if (r7 != 0) goto L_0x00d3
            goto L_0x00b9
        L_0x00d3:
            r6.e()
            goto L_0x00b9
        L_0x00d7:
            java.util.Iterator r1 = r8.iterator()
        L_0x00db:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x010c
            java.lang.Object r6 = r1.next()
            v.q r6 = (v.q) r6
            int r7 = r6.f15546f
            if (r7 == r14) goto L_0x00ec
            goto L_0x00db
        L_0x00ec:
            if (r15 != 0) goto L_0x00f3
            u.f r7 = r6.f15542b
            if (r7 != r2) goto L_0x00f3
            goto L_0x00db
        L_0x00f3:
            v.f r7 = r6.f15548h
            boolean r7 = r7.f15517j
            if (r7 != 0) goto L_0x00fa
            goto L_0x010b
        L_0x00fa:
            v.f r7 = r6.f15549i
            boolean r7 = r7.f15517j
            if (r7 != 0) goto L_0x0101
            goto L_0x010b
        L_0x0101:
            boolean r7 = r6 instanceof v.c
            if (r7 != 0) goto L_0x00db
            v.g r6 = r6.f15545e
            boolean r6 = r6.f15517j
            if (r6 != 0) goto L_0x00db
        L_0x010b:
            r0 = 0
        L_0x010c:
            r2.L(r4)
            r2.M(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u.g.T(int, boolean):boolean");
    }

    public final boolean V(int i10) {
        return (this.E0 & i10) == i10;
    }

    public final void n(StringBuilder sb2) {
        sb2.append(this.f15100k + ":{\n");
        StringBuilder sb3 = new StringBuilder("  actualWidth:");
        sb3.append(this.V);
        sb2.append(sb3.toString());
        sb2.append(Constants.WRITE_NEW_LINE);
        sb2.append("  actualHeight:" + this.W);
        sb2.append(Constants.WRITE_NEW_LINE);
        Iterator it = this.f15168r0.iterator();
        while (it.hasNext()) {
            ((f) it.next()).n(sb2);
            sb2.append(",\n");
        }
        sb2.append("}");
    }
}
