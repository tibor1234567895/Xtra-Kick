package e2;

import d2.o;
import d2.u0;
import d2.v;
import d2.w;
import d2.x0;
import d2.y;
import j1.l0;
import java.util.Arrays;

public final class a implements v {

    /* renamed from: p  reason: collision with root package name */
    public static final int[] f4966p = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: q  reason: collision with root package name */
    public static final int[] f4967q;

    /* renamed from: r  reason: collision with root package name */
    public static final byte[] f4968r = l0.z("#!AMR\n");

    /* renamed from: s  reason: collision with root package name */
    public static final byte[] f4969s = l0.z("#!AMR-WB\n");

    /* renamed from: t  reason: collision with root package name */
    public static final int f4970t;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f4971a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4972b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4973c;

    /* renamed from: d  reason: collision with root package name */
    public long f4974d;

    /* renamed from: e  reason: collision with root package name */
    public int f4975e;

    /* renamed from: f  reason: collision with root package name */
    public int f4976f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4977g;

    /* renamed from: h  reason: collision with root package name */
    public long f4978h;

    /* renamed from: i  reason: collision with root package name */
    public int f4979i;

    /* renamed from: j  reason: collision with root package name */
    public int f4980j;

    /* renamed from: k  reason: collision with root package name */
    public long f4981k;

    /* renamed from: l  reason: collision with root package name */
    public y f4982l;

    /* renamed from: m  reason: collision with root package name */
    public x0 f4983m;

    /* renamed from: n  reason: collision with root package name */
    public u0 f4984n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f4985o;

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f4967q = iArr;
        f4970t = iArr[8];
    }

    public a() {
        this(0);
    }

    public final void a() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
        if (r0 != false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b(d2.w r6) {
        /*
            r5 = this;
            r6.f()
            byte[] r0 = r5.f4971a
            r1 = 0
            r2 = 1
            r6.m(r0, r1, r2)
            byte r6 = r0[r1]
            r0 = r6 & 131(0x83, float:1.84E-43)
            r3 = 0
            if (r0 > 0) goto L_0x006f
            int r6 = r6 >> 3
            r0 = 15
            r6 = r6 & r0
            if (r6 < 0) goto L_0x003b
            if (r6 > r0) goto L_0x003b
            boolean r0 = r5.f4973c
            if (r0 == 0) goto L_0x0028
            r4 = 10
            if (r6 < r4) goto L_0x0026
            r4 = 13
            if (r6 <= r4) goto L_0x0028
        L_0x0026:
            r4 = 1
            goto L_0x0029
        L_0x0028:
            r4 = 0
        L_0x0029:
            if (r4 != 0) goto L_0x003a
            if (r0 != 0) goto L_0x0037
            r0 = 12
            if (r6 < r0) goto L_0x0035
            r0 = 14
            if (r6 <= r0) goto L_0x0037
        L_0x0035:
            r0 = 1
            goto L_0x0038
        L_0x0037:
            r0 = 0
        L_0x0038:
            if (r0 == 0) goto L_0x003b
        L_0x003a:
            r1 = 1
        L_0x003b:
            if (r1 != 0) goto L_0x0061
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Illegal AMR "
            r0.<init>(r1)
            boolean r1 = r5.f4973c
            if (r1 == 0) goto L_0x004b
            java.lang.String r1 = "WB"
            goto L_0x004d
        L_0x004b:
            java.lang.String r1 = "NB"
        L_0x004d:
            r0.append(r1)
            java.lang.String r1 = " frame type "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            g1.b1 r6 = g1.b1.a(r6, r3)
            throw r6
        L_0x0061:
            boolean r0 = r5.f4973c
            if (r0 == 0) goto L_0x006a
            int[] r0 = f4967q
            r6 = r0[r6]
            goto L_0x006e
        L_0x006a:
            int[] r0 = f4966p
            r6 = r0[r6]
        L_0x006e:
            return r6
        L_0x006f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Invalid padding bits for frame header "
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            g1.b1 r6 = g1.b1.a(r6, r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.a.b(d2.w):int");
    }

    public final void c(long j10, long j11) {
        this.f4974d = 0;
        this.f4975e = 0;
        this.f4976f = 0;
        if (j10 != 0) {
            u0 u0Var = this.f4984n;
            if (u0Var instanceof o) {
                o oVar = (o) u0Var;
                this.f4981k = ((Math.max(0, j10 - oVar.f4252b) * 8) * 1000000) / ((long) oVar.f4255e);
                return;
            }
        }
        this.f4981k = 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: d2.o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: d2.e0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v9, resolved type: d2.o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: d2.o} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(d2.w r14, d2.s0 r15) {
        /*
            r13 = this;
            d2.x0 r15 = r13.f4983m
            j1.a.f(r15)
            int r15 = j1.l0.f8453a
            long r0 = r14.p()
            r2 = 0
            int r15 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r15 != 0) goto L_0x0020
            boolean r15 = r13.f(r14)
            if (r15 == 0) goto L_0x0018
            goto L_0x0020
        L_0x0018:
            java.lang.String r14 = "Could not find AMR header."
            r15 = 0
            g1.b1 r14 = g1.b1.a(r14, r15)
            throw r14
        L_0x0020:
            boolean r15 = r13.f4985o
            r0 = 1
            if (r15 != 0) goto L_0x0050
            r13.f4985o = r0
            boolean r15 = r13.f4973c
            if (r15 == 0) goto L_0x002e
            java.lang.String r1 = "audio/amr-wb"
            goto L_0x0030
        L_0x002e:
            java.lang.String r1 = "audio/3gpp"
        L_0x0030:
            if (r15 == 0) goto L_0x0035
            r15 = 16000(0x3e80, float:2.2421E-41)
            goto L_0x0037
        L_0x0035:
            r15 = 8000(0x1f40, float:1.121E-41)
        L_0x0037:
            d2.x0 r2 = r13.f4983m
            g1.z r3 = new g1.z
            r3.<init>()
            r3.f6754k = r1
            int r1 = f4970t
            r3.f6755l = r1
            r3.f6767x = r0
            r3.f6768y = r15
            g1.a0 r15 = new g1.a0
            r15.<init>(r3)
            r2.a(r15)
        L_0x0050:
            int r15 = r13.f4976f
            r1 = 0
            r2 = -1
            r3 = 20000(0x4e20, double:9.8813E-320)
            if (r15 != 0) goto L_0x007c
            int r15 = r13.b(r14)     // Catch:{ EOFException -> 0x007a }
            r13.f4975e = r15     // Catch:{ EOFException -> 0x007a }
            r13.f4976f = r15
            int r15 = r13.f4979i
            if (r15 != r2) goto L_0x006e
            long r5 = r14.p()
            r13.f4978h = r5
            int r15 = r13.f4975e
            r13.f4979i = r15
        L_0x006e:
            int r15 = r13.f4979i
            int r5 = r13.f4975e
            if (r15 != r5) goto L_0x007c
            int r15 = r13.f4980j
            int r15 = r15 + r0
            r13.f4980j = r15
            goto L_0x007c
        L_0x007a:
            goto L_0x0086
        L_0x007c:
            d2.x0 r15 = r13.f4983m
            int r5 = r13.f4976f
            int r15 = r15.c(r14, r5, r0)
            if (r15 != r2) goto L_0x0088
        L_0x0086:
            r15 = -1
            goto L_0x00a5
        L_0x0088:
            int r5 = r13.f4976f
            int r5 = r5 - r15
            r13.f4976f = r5
            if (r5 <= 0) goto L_0x0090
            goto L_0x00a4
        L_0x0090:
            d2.x0 r6 = r13.f4983m
            long r7 = r13.f4981k
            long r9 = r13.f4974d
            long r7 = r7 + r9
            r9 = 1
            int r10 = r13.f4975e
            r11 = 0
            r12 = 0
            r6.e(r7, r9, r10, r11, r12)
            long r5 = r13.f4974d
            long r5 = r5 + r3
            r13.f4974d = r5
        L_0x00a4:
            r15 = 0
        L_0x00a5:
            long r8 = r14.c()
            boolean r14 = r13.f4977g
            if (r14 == 0) goto L_0x00ae
            goto L_0x00fa
        L_0x00ae:
            int r14 = r13.f4972b
            r5 = r14 & 1
            if (r5 == 0) goto L_0x00e7
            r5 = -1
            int r7 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00e7
            int r7 = r13.f4979i
            if (r7 == r2) goto L_0x00c3
            int r5 = r13.f4975e
            if (r7 == r5) goto L_0x00c3
            goto L_0x00e7
        L_0x00c3:
            int r5 = r13.f4980j
            r6 = 20
            if (r5 >= r6) goto L_0x00cb
            if (r15 != r2) goto L_0x00fa
        L_0x00cb:
            r14 = r14 & 2
            if (r14 == 0) goto L_0x00d1
            r12 = 1
            goto L_0x00d2
        L_0x00d1:
            r12 = 0
        L_0x00d2:
            long r1 = (long) r7
            r5 = 8
            long r1 = r1 * r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r1 = r1 * r5
            long r1 = r1 / r3
            int r6 = (int) r1
            d2.o r14 = new d2.o
            long r10 = r13.f4978h
            r5 = r14
            r5.<init>(r6, r7, r8, r10, r12)
            goto L_0x00f1
        L_0x00e7:
            d2.e0 r14 = new d2.e0
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r14.<init>(r1)
        L_0x00f1:
            r13.f4984n = r14
            d2.y r1 = r13.f4982l
            r1.g(r14)
            r13.f4977g = r0
        L_0x00fa:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.a.d(d2.w, d2.s0):int");
    }

    public final void e(y yVar) {
        this.f4982l = yVar;
        this.f4983m = yVar.d(0, 1);
        yVar.a();
    }

    public final boolean f(w wVar) {
        int i10;
        wVar.f();
        byte[] bArr = f4968r;
        byte[] bArr2 = new byte[bArr.length];
        wVar.m(bArr2, 0, bArr.length);
        if (Arrays.equals(bArr2, bArr)) {
            this.f4973c = false;
            i10 = bArr.length;
        } else {
            wVar.f();
            byte[] bArr3 = f4969s;
            byte[] bArr4 = new byte[bArr3.length];
            wVar.m(bArr4, 0, bArr3.length);
            if (!Arrays.equals(bArr4, bArr3)) {
                return false;
            }
            this.f4973c = true;
            i10 = bArr3.length;
        }
        wVar.g(i10);
        return true;
    }

    public final boolean h(w wVar) {
        return f(wVar);
    }

    public a(int i10) {
        this.f4972b = 0;
        this.f4971a = new byte[1];
        this.f4979i = -1;
    }
}
