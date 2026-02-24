package g3;

import d2.b;
import d2.w0;
import d2.x0;
import d2.y;
import g1.a0;
import g1.b1;
import g1.z;
import j1.b0;
import j1.l0;

public final class a implements b {

    /* renamed from: m  reason: collision with root package name */
    public static final int[] f6796m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

    /* renamed from: n  reason: collision with root package name */
    public static final int[] f6797n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

    /* renamed from: a  reason: collision with root package name */
    public final y f6798a;

    /* renamed from: b  reason: collision with root package name */
    public final x0 f6799b;

    /* renamed from: c  reason: collision with root package name */
    public final b f6800c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6801d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f6802e;

    /* renamed from: f  reason: collision with root package name */
    public final b0 f6803f;

    /* renamed from: g  reason: collision with root package name */
    public final int f6804g;

    /* renamed from: h  reason: collision with root package name */
    public final a0 f6805h;

    /* renamed from: i  reason: collision with root package name */
    public int f6806i;

    /* renamed from: j  reason: collision with root package name */
    public long f6807j;

    /* renamed from: k  reason: collision with root package name */
    public int f6808k;

    /* renamed from: l  reason: collision with root package name */
    public long f6809l;

    public a(y yVar, x0 x0Var, b bVar) {
        this.f6798a = yVar;
        this.f6799b = x0Var;
        this.f6800c = bVar;
        int i10 = bVar.f4145b;
        int max = Math.max(1, i10 / 10);
        this.f6804g = max;
        b0 b0Var = new b0((byte[]) bVar.f4148e);
        b0Var.n();
        int n10 = b0Var.n();
        this.f6801d = n10;
        int i11 = bVar.f4144a;
        int i12 = bVar.f4146c;
        int i13 = (((i12 - (i11 * 4)) * 8) / (bVar.f4147d * i11)) + 1;
        if (n10 == i13) {
            int i14 = l0.f8453a;
            int i15 = ((max + n10) - 1) / n10;
            this.f6802e = new byte[(i15 * i12)];
            this.f6803f = new b0(n10 * 2 * i11 * i15);
            int i16 = ((i12 * i10) * 8) / n10;
            z zVar = new z();
            zVar.f6754k = "audio/raw";
            zVar.f6749f = i16;
            zVar.f6750g = i16;
            zVar.f6755l = max * 2 * i11;
            zVar.f6767x = i11;
            zVar.f6768y = i10;
            zVar.f6769z = 2;
            this.f6805h = new a0(zVar);
            return;
        }
        throw b1.a("Expected frames per block: " + i13 + "; got: " + n10, (Exception) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0052 A[EDGE_INSN: B:42:0x0052->B:12:0x0052 ?: BREAK  
    EDGE_INSN: B:44:0x0052->B:12:0x0052 ?: BREAK  ] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(d2.w r25, long r26) {
        /*
            r24 = this;
            r0 = r24
            int r1 = r0.f6808k
            d2.b r2 = r0.f6800c
            int r3 = r2.f4144a
            int r3 = r3 * 2
            int r1 = r1 / r3
            int r3 = r0.f6804g
            int r1 = r3 - r1
            int r4 = j1.l0.f8453a
            int r4 = r0.f6801d
            int r1 = r1 + r4
            r5 = -1
            int r1 = r1 + r5
            int r1 = r1 / r4
            int r6 = r2.f4146c
            int r1 = r1 * r6
            r6 = 0
            int r10 = (r26 > r6 ? 1 : (r26 == r6 ? 0 : -1))
            r11 = r0
            r6 = r2
            r7 = r3
            if (r10 != 0) goto L_0x002b
            r10 = r4
            r2 = r26
            r4 = r1
            r1 = r25
            goto L_0x004a
        L_0x002b:
            r10 = r4
            r12 = 0
            r2 = r26
            r4 = r1
            r1 = r25
        L_0x0032:
            byte[] r13 = r11.f6802e
            if (r12 != 0) goto L_0x0052
            int r14 = r11.f6806i
            if (r14 >= r4) goto L_0x0052
            int r14 = r4 - r14
            long r14 = (long) r14
            long r14 = java.lang.Math.min(r14, r2)
            int r15 = (int) r14
            int r14 = r11.f6806i
            int r13 = r1.o(r13, r14, r15)
            if (r13 != r5) goto L_0x004c
        L_0x004a:
            r12 = 1
            goto L_0x0032
        L_0x004c:
            int r14 = r11.f6806i
            int r14 = r14 + r13
            r11.f6806i = r14
            goto L_0x0032
        L_0x0052:
            int r1 = r11.f6806i
            int r2 = r6.f4146c
            int r1 = r1 / r2
            d2.b r2 = r11.f6800c
            if (r1 <= 0) goto L_0x0169
            r3 = 0
        L_0x005c:
            int r4 = r6.f4146c
            j1.b0 r5 = r11.f6803f
            if (r3 >= r1) goto L_0x0136
            r14 = 0
        L_0x0063:
            int r15 = r6.f4144a
            if (r14 >= r15) goto L_0x0126
            byte[] r8 = r5.f8414a
            int r16 = r3 * r4
            int r17 = r14 * 4
            int r17 = r17 + r16
            int r16 = r15 * 4
            int r16 = r16 + r17
            int r18 = r4 / r15
            int r18 = r18 + -4
            int r19 = r17 + 1
            byte r9 = r13[r19]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r9 = r9 << 8
            byte r0 = r13[r17]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r0 = r0 | r9
            short r0 = (short) r0
            int r17 = r17 + 2
            byte r9 = r13[r17]
            r9 = r9 & 255(0xff, float:3.57E-43)
            r17 = r6
            r6 = 88
            int r9 = java.lang.Math.min(r9, r6)
            int[] r19 = f6797n
            r21 = r19[r9]
            int r22 = r3 * r10
            int r22 = r22 * r15
            int r22 = r22 + r14
            int r22 = r22 * 2
            r6 = r0 & 255(0xff, float:3.57E-43)
            byte r6 = (byte) r6
            r8[r22] = r6
            int r6 = r22 + 1
            r26 = r9
            int r9 = r0 >> 8
            byte r9 = (byte) r9
            r8[r6] = r9
            r9 = r26
            r26 = r12
            r6 = 0
        L_0x00b2:
            int r12 = r18 * 2
            if (r6 >= r12) goto L_0x0116
            int r12 = r6 / 8
            int r23 = r6 / 2
            int r23 = r23 % 4
            int r12 = r12 * r15
            int r12 = r12 * 4
            int r12 = r12 + r16
            int r12 = r12 + r23
            byte r12 = r13[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r23 = r6 % 2
            if (r23 != 0) goto L_0x00cf
            r12 = r12 & 15
            goto L_0x00d1
        L_0x00cf:
            int r12 = r12 >> 4
        L_0x00d1:
            r23 = r12 & 7
            int r23 = r23 * 2
            r20 = 1
            int r23 = r23 + 1
            int r23 = r23 * r21
            r21 = r13
            int r13 = r23 >> 3
            r23 = r12 & 8
            if (r23 == 0) goto L_0x00e4
            int r13 = -r13
        L_0x00e4:
            int r0 = r0 + r13
            r13 = -32768(0xffffffffffff8000, float:NaN)
            r23 = r7
            r7 = 32767(0x7fff, float:4.5916E-41)
            int r0 = j1.l0.h(r0, r13, r7)
            int r7 = r15 * 2
            int r22 = r7 + r22
            r7 = r0 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7
            r8[r22] = r7
            int r7 = r22 + 1
            int r13 = r0 >> 8
            byte r13 = (byte) r13
            r8[r7] = r13
            int[] r7 = f6796m
            r7 = r7[r12]
            int r9 = r9 + r7
            r7 = 88
            r12 = 0
            int r9 = j1.l0.h(r9, r12, r7)
            r12 = r19[r9]
            int r6 = r6 + 1
            r13 = r21
            r7 = r23
            r21 = r12
            goto L_0x00b2
        L_0x0116:
            r23 = r7
            r21 = r13
            r20 = 1
            int r14 = r14 + 1
            r0 = r24
            r12 = r26
            r6 = r17
            goto L_0x0063
        L_0x0126:
            r17 = r6
            r23 = r7
            r26 = r12
            r21 = r13
            r20 = 1
            int r3 = r3 + 1
            r0 = r24
            goto L_0x005c
        L_0x0136:
            r23 = r7
            r26 = r12
            int r10 = r10 * r1
            int r0 = r2.f4144a
            int r10 = r10 * 2
            int r10 = r10 * r0
            r0 = 0
            r5.G(r0)
            r5.F(r10)
            int r0 = r11.f6806i
            int r1 = r1 * r4
            int r0 = r0 - r1
            r11.f6806i = r0
            int r0 = r5.f8416c
            d2.x0 r1 = r11.f6799b
            r1.d(r0, r5)
            int r1 = r11.f6808k
            int r1 = r1 + r0
            r11.f6808k = r1
            int r0 = r2.f4144a
            int r0 = r0 * 2
            int r1 = r1 / r0
            r7 = r23
            if (r1 < r7) goto L_0x016b
            r11.d(r7)
            goto L_0x016b
        L_0x0169:
            r26 = r12
        L_0x016b:
            if (r26 == 0) goto L_0x0179
            int r0 = r11.f6808k
            int r1 = r2.f4144a
            int r1 = r1 * 2
            int r0 = r0 / r1
            if (r0 <= 0) goto L_0x0179
            r11.d(r0)
        L_0x0179:
            return r26
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.a.a(d2.w, long):boolean");
    }

    public final void b(int i10, long j10) {
        this.f6798a.g(new f(this.f6800c, this.f6801d, (long) i10, j10));
        this.f6799b.a(this.f6805h);
    }

    public final void c(long j10) {
        this.f6806i = 0;
        this.f6807j = j10;
        this.f6808k = 0;
        this.f6809l = 0;
    }

    public final void d(int i10) {
        int i11 = i10;
        long j10 = this.f6807j;
        long j11 = this.f6809l;
        b bVar = this.f6800c;
        long M = j10 + l0.M(j11, 1000000, (long) bVar.f4145b);
        int i12 = i11 * 2 * bVar.f4144a;
        this.f6799b.e(M, 1, i12, this.f6808k - i12, (w0) null);
        this.f6809l += (long) i11;
        this.f6808k -= i12;
    }
}
