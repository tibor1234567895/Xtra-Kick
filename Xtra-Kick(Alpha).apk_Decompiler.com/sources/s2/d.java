package s2;

import android.support.v4.media.h;
import android.util.SparseArray;
import d2.p;
import d2.p0;
import d2.v;
import d2.x0;
import d2.y;
import d2.y0;
import g1.b1;
import j1.a;
import j1.b0;
import j1.l0;
import j1.w;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public final class d implements v {

    /* renamed from: c0  reason: collision with root package name */
    public static final byte[] f14122c0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: d0  reason: collision with root package name */
    public static final byte[] f14123d0 = l0.z("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* renamed from: e0  reason: collision with root package name */
    public static final byte[] f14124e0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* renamed from: f0  reason: collision with root package name */
    public static final byte[] f14125f0 = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};

    /* renamed from: g0  reason: collision with root package name */
    public static final UUID f14126g0 = new UUID(72057594037932032L, -9223371306706625679L);

    /* renamed from: h0  reason: collision with root package name */
    public static final Map f14127h0;
    public long A;
    public long B;
    public w C;
    public w D;
    public boolean E;
    public boolean F;
    public int G;
    public long H;
    public long I;
    public int J;
    public int K;
    public int[] L;
    public int M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public long R;
    public int S;
    public int T;
    public int U;
    public boolean V;
    public boolean W;
    public boolean X;
    public int Y;
    public byte Z;

    /* renamed from: a  reason: collision with root package name */
    public final b f14128a;

    /* renamed from: a0  reason: collision with root package name */
    public boolean f14129a0;

    /* renamed from: b  reason: collision with root package name */
    public final f f14130b;

    /* renamed from: b0  reason: collision with root package name */
    public y f14131b0;

    /* renamed from: c  reason: collision with root package name */
    public final SparseArray f14132c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f14133d;

    /* renamed from: e  reason: collision with root package name */
    public final b0 f14134e;

    /* renamed from: f  reason: collision with root package name */
    public final b0 f14135f;

    /* renamed from: g  reason: collision with root package name */
    public final b0 f14136g;

    /* renamed from: h  reason: collision with root package name */
    public final b0 f14137h;

    /* renamed from: i  reason: collision with root package name */
    public final b0 f14138i;

    /* renamed from: j  reason: collision with root package name */
    public final b0 f14139j;

    /* renamed from: k  reason: collision with root package name */
    public final b0 f14140k;

    /* renamed from: l  reason: collision with root package name */
    public final b0 f14141l;

    /* renamed from: m  reason: collision with root package name */
    public final b0 f14142m;

    /* renamed from: n  reason: collision with root package name */
    public final b0 f14143n;

    /* renamed from: o  reason: collision with root package name */
    public ByteBuffer f14144o;

    /* renamed from: p  reason: collision with root package name */
    public long f14145p;

    /* renamed from: q  reason: collision with root package name */
    public long f14146q;

    /* renamed from: r  reason: collision with root package name */
    public long f14147r;

    /* renamed from: s  reason: collision with root package name */
    public long f14148s;

    /* renamed from: t  reason: collision with root package name */
    public long f14149t;

    /* renamed from: u  reason: collision with root package name */
    public c f14150u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f14151v;

    /* renamed from: w  reason: collision with root package name */
    public int f14152w;

    /* renamed from: x  reason: collision with root package name */
    public long f14153x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f14154y;

    /* renamed from: z  reason: collision with root package name */
    public long f14155z;

    static {
        HashMap hashMap = new HashMap();
        h.v(0, hashMap, "htc_video_rotA-000", 90, "htc_video_rotA-090", 180, "htc_video_rotA-180", 270, "htc_video_rotA-270");
        f14127h0 = Collections.unmodifiableMap(hashMap);
    }

    public d() {
        this(0);
    }

    public static byte[] i(long j10, long j11, String str) {
        a.b(j10 != -9223372036854775807L);
        int i10 = (int) (j10 / 3600000000L);
        long j12 = j10 - ((((long) i10) * 3600) * 1000000);
        int i11 = (int) (j12 / 60000000);
        long j13 = j12 - ((((long) i11) * 60) * 1000000);
        int i12 = (int) (j13 / 1000000);
        return l0.z(String.format(Locale.US, str, new Object[]{Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf((int) ((j13 - (((long) i12) * 1000000)) / j11))}));
    }

    public final void a() {
    }

    public final void b(int i10) {
        if (this.C == null || this.D == null) {
            throw b1.a("Element " + i10 + " must be in a Cues", (Exception) null);
        }
    }

    public final void c(long j10, long j11) {
        this.B = -9223372036854775807L;
        this.G = 0;
        b bVar = this.f14128a;
        bVar.f14093e = 0;
        bVar.f14090b.clear();
        f fVar = bVar.f14091c;
        fVar.f14160b = 0;
        fVar.f14161c = 0;
        f fVar2 = this.f14130b;
        fVar2.f14160b = 0;
        fVar2.f14161c = 0;
        k();
        int i10 = 0;
        while (true) {
            SparseArray sparseArray = this.f14132c;
            if (i10 < sparseArray.size()) {
                y0 y0Var = ((c) sparseArray.valueAt(i10)).T;
                if (y0Var != null) {
                    y0Var.f4309b = false;
                    y0Var.f4310c = 0;
                }
                i10++;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v21, resolved type: int[]} */
    /* JADX WARNING: type inference failed for: r3v5, types: [int, byte, boolean] */
    /* JADX WARNING: type inference failed for: r3v104 */
    /* JADX WARNING: type inference failed for: r3v105 */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x047a, code lost:
        throw g1.b1.a("EBML lacing sample size out of range.", (java.lang.Exception) null);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x04ba  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x04bc  */
    /* JADX WARNING: Removed duplicated region for block: B:456:0x0969 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:469:0x096b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(d2.w r36, d2.s0 r37) {
        /*
            r35 = this;
            r0 = r35
            r1 = r36
            r2 = r37
            r3 = 0
            r0.F = r3
            r4 = 1
            r5 = 1
        L_0x000b:
            r6 = -1
            if (r5 == 0) goto L_0x097f
            boolean r7 = r0.F
            if (r7 != 0) goto L_0x097f
            s2.b r7 = r0.f14128a
            e.a r5 = r7.f14092d
            j1.a.f(r5)
        L_0x0019:
            java.util.ArrayDeque r5 = r7.f14090b
            java.lang.Object r8 = r5.peek()
            s2.a r8 = (s2.a) r8
            if (r8 == 0) goto L_0x003c
            long r11 = r36.p()
            long r13 = r8.f14088b
            int r8 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r8 < 0) goto L_0x003c
            e.a r6 = r7.f14092d
            java.lang.Object r5 = r5.pop()
            s2.a r5 = (s2.a) r5
            int r5 = r5.f14087a
            r6.E(r5)
            goto L_0x0940
        L_0x003c:
            int r8 = r7.f14093e
            r12 = 524531317(0x1f43b675, float:4.144378E-20)
            r13 = 0
            r15 = 8
            r9 = 4
            byte[] r10 = r7.f14089a
            s2.f r11 = r7.f14091c
            if (r8 != 0) goto L_0x00c5
            long r19 = r11.b(r1, r4, r3, r9)
            r21 = -2
            int r8 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1))
            if (r8 != 0) goto L_0x00b3
            r36.f()
        L_0x0059:
            r1.m(r10, r3, r9)
            byte r8 = r10[r3]
            r4 = 0
        L_0x005f:
            if (r4 >= r15) goto L_0x0075
            long[] r19 = s2.f.f14158d
            r22 = r19[r4]
            r24 = r10
            long r9 = (long) r8
            long r9 = r22 & r9
            int r19 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            int r4 = r4 + 1
            if (r19 == 0) goto L_0x0071
            goto L_0x0078
        L_0x0071:
            r10 = r24
            r9 = 4
            goto L_0x005f
        L_0x0075:
            r24 = r10
            r4 = -1
        L_0x0078:
            if (r4 == r6) goto L_0x00aa
            r8 = 4
            if (r4 > r8) goto L_0x00aa
            r8 = r24
            long r9 = s2.f.a(r8, r4, r3)
            int r10 = (int) r9
            e.a r9 = r7.f14092d
            java.lang.Object r9 = r9.f4852i
            s2.d r9 = (s2.d) r9
            r9.getClass()
            r9 = 357149030(0x1549a966, float:4.072526E-26)
            if (r10 == r9) goto L_0x00a1
            if (r10 == r12) goto L_0x00a1
            r9 = 475249515(0x1c53bb6b, float:7.0056276E-22)
            if (r10 == r9) goto L_0x00a1
            r9 = 374648427(0x1654ae6b, float:1.718026E-25)
            if (r10 != r9) goto L_0x009f
            goto L_0x00a1
        L_0x009f:
            r9 = 0
            goto L_0x00a2
        L_0x00a1:
            r9 = 1
        L_0x00a2:
            if (r9 == 0) goto L_0x00ac
            r1.g(r4)
            long r9 = (long) r10
            r4 = 1
            goto L_0x00b6
        L_0x00aa:
            r8 = r24
        L_0x00ac:
            r4 = 1
            r1.g(r4)
            r10 = r8
            r9 = 4
            goto L_0x0059
        L_0x00b3:
            r8 = r10
            r9 = r19
        L_0x00b6:
            r16 = -1
            int r19 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r19 != 0) goto L_0x00bf
            r5 = 0
            goto L_0x0941
        L_0x00bf:
            int r10 = (int) r9
            r7.f14094f = r10
            r7.f14093e = r4
            goto L_0x00c6
        L_0x00c5:
            r8 = r10
        L_0x00c6:
            int r9 = r7.f14093e
            r10 = 2
            if (r9 != r4) goto L_0x00d3
            long r12 = r11.b(r1, r3, r4, r15)
            r7.f14095g = r12
            r7.f14093e = r10
        L_0x00d3:
            e.a r4 = r7.f14092d
            int r11 = r7.f14094f
            java.lang.Object r4 = r4.f4852i
            s2.d r4 = (s2.d) r4
            r4.getClass()
            r4 = 5
            r12 = 3
            switch(r11) {
                case 131: goto L_0x00ed;
                case 134: goto L_0x00eb;
                case 136: goto L_0x00ed;
                case 155: goto L_0x00ed;
                case 159: goto L_0x00ed;
                case 160: goto L_0x00e9;
                case 161: goto L_0x00e7;
                case 163: goto L_0x00e7;
                case 165: goto L_0x00e7;
                case 166: goto L_0x00e9;
                case 174: goto L_0x00e9;
                case 176: goto L_0x00ed;
                case 179: goto L_0x00ed;
                case 181: goto L_0x00e5;
                case 183: goto L_0x00e9;
                case 186: goto L_0x00ed;
                case 187: goto L_0x00e9;
                case 215: goto L_0x00ed;
                case 224: goto L_0x00e9;
                case 225: goto L_0x00e9;
                case 231: goto L_0x00ed;
                case 238: goto L_0x00ed;
                case 241: goto L_0x00ed;
                case 251: goto L_0x00ed;
                case 16868: goto L_0x00e9;
                case 16871: goto L_0x00ed;
                case 16877: goto L_0x00e7;
                case 16980: goto L_0x00ed;
                case 16981: goto L_0x00e7;
                case 17026: goto L_0x00eb;
                case 17029: goto L_0x00ed;
                case 17143: goto L_0x00ed;
                case 17545: goto L_0x00e5;
                case 18401: goto L_0x00ed;
                case 18402: goto L_0x00e7;
                case 18407: goto L_0x00e9;
                case 18408: goto L_0x00ed;
                case 19899: goto L_0x00e9;
                case 20529: goto L_0x00ed;
                case 20530: goto L_0x00ed;
                case 20532: goto L_0x00e9;
                case 20533: goto L_0x00e9;
                case 21358: goto L_0x00eb;
                case 21419: goto L_0x00e7;
                case 21420: goto L_0x00ed;
                case 21432: goto L_0x00ed;
                case 21680: goto L_0x00ed;
                case 21682: goto L_0x00ed;
                case 21690: goto L_0x00ed;
                case 21930: goto L_0x00ed;
                case 21936: goto L_0x00e9;
                case 21945: goto L_0x00ed;
                case 21946: goto L_0x00ed;
                case 21947: goto L_0x00ed;
                case 21948: goto L_0x00ed;
                case 21949: goto L_0x00ed;
                case 21968: goto L_0x00e9;
                case 21969: goto L_0x00e5;
                case 21970: goto L_0x00e5;
                case 21971: goto L_0x00e5;
                case 21972: goto L_0x00e5;
                case 21973: goto L_0x00e5;
                case 21974: goto L_0x00e5;
                case 21975: goto L_0x00e5;
                case 21976: goto L_0x00e5;
                case 21977: goto L_0x00e5;
                case 21978: goto L_0x00e5;
                case 21998: goto L_0x00ed;
                case 22186: goto L_0x00ed;
                case 22203: goto L_0x00ed;
                case 25152: goto L_0x00e9;
                case 25188: goto L_0x00ed;
                case 25506: goto L_0x00e7;
                case 28032: goto L_0x00e9;
                case 30113: goto L_0x00e9;
                case 30114: goto L_0x00ed;
                case 30320: goto L_0x00e9;
                case 30321: goto L_0x00ed;
                case 30322: goto L_0x00e7;
                case 30323: goto L_0x00e5;
                case 30324: goto L_0x00e5;
                case 30325: goto L_0x00e5;
                case 2274716: goto L_0x00eb;
                case 2352003: goto L_0x00ed;
                case 2807729: goto L_0x00ed;
                case 290298740: goto L_0x00e9;
                case 357149030: goto L_0x00e9;
                case 374648427: goto L_0x00e9;
                case 408125543: goto L_0x00e9;
                case 440786851: goto L_0x00e9;
                case 475249515: goto L_0x00e9;
                case 524531317: goto L_0x00e9;
                default: goto L_0x00e3;
            }
        L_0x00e3:
            r11 = 0
            goto L_0x00ee
        L_0x00e5:
            r11 = 5
            goto L_0x00ee
        L_0x00e7:
            r11 = 4
            goto L_0x00ee
        L_0x00e9:
            r11 = 1
            goto L_0x00ee
        L_0x00eb:
            r11 = 3
            goto L_0x00ee
        L_0x00ed:
            r11 = 2
        L_0x00ee:
            if (r11 == 0) goto L_0x0970
            r13 = 0
            r14 = 1
            if (r11 == r14) goto L_0x087a
            r5 = 255(0xff, float:3.57E-43)
            java.lang.String r9 = " not supported"
            r22 = 1
            r24 = 8
            if (r11 == r10) goto L_0x05c5
            r26 = 2147483647(0x7fffffff, double:1.060997895E-314)
            if (r11 == r12) goto L_0x052b
            r14 = 4
            if (r11 == r14) goto L_0x020c
            if (r11 != r4) goto L_0x01f9
            long r9 = r7.f14095g
            r11 = 4
            int r4 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r4 == 0) goto L_0x012a
            int r4 = (r9 > r24 ? 1 : (r9 == r24 ? 0 : -1))
            if (r4 != 0) goto L_0x0115
            goto L_0x012a
        L_0x0115:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Invalid float size: "
            r1.<init>(r2)
            long r2 = r7.f14095g
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            g1.b1 r1 = g1.b1.a(r1, r13)
            throw r1
        L_0x012a:
            e.a r4 = r7.f14092d
            int r6 = r7.f14094f
            int r10 = (int) r9
            r1.readFully(r8, r3, r10)
            r9 = 0
            r13 = 0
        L_0x0135:
            if (r9 >= r10) goto L_0x0141
            long r11 = r13 << r15
            byte r13 = r8[r9]
            r13 = r13 & r5
            long r13 = (long) r13
            long r13 = r13 | r11
            int r9 = r9 + 1
            goto L_0x0135
        L_0x0141:
            r5 = 4
            if (r10 != r5) goto L_0x014b
            int r5 = (int) r13
            float r5 = java.lang.Float.intBitsToFloat(r5)
            double r8 = (double) r5
            goto L_0x014f
        L_0x014b:
            double r8 = java.lang.Double.longBitsToDouble(r13)
        L_0x014f:
            java.lang.Object r4 = r4.f4852i
            s2.d r4 = (s2.d) r4
            r5 = 181(0xb5, float:2.54E-43)
            if (r6 == r5) goto L_0x01ef
            r5 = 17545(0x4489, float:2.4586E-41)
            if (r6 == r5) goto L_0x01ea
            switch(r6) {
                case 21969: goto L_0x01bd;
                case 21970: goto L_0x01b3;
                case 21971: goto L_0x01a9;
                case 21972: goto L_0x019f;
                case 21973: goto L_0x0195;
                case 21974: goto L_0x018b;
                case 21975: goto L_0x0181;
                case 21976: goto L_0x0177;
                case 21977: goto L_0x016d;
                case 21978: goto L_0x0163;
                default: goto L_0x015e;
            }
        L_0x015e:
            switch(r6) {
                case 30323: goto L_0x01db;
                case 30324: goto L_0x01d1;
                case 30325: goto L_0x01c7;
                default: goto L_0x0161;
            }
        L_0x0161:
            goto L_0x01e5
        L_0x0163:
            r4.f(r6)
            s2.c r4 = r4.f14150u
            float r5 = (float) r8
            r4.M = r5
            goto L_0x093e
        L_0x016d:
            r4.f(r6)
            s2.c r4 = r4.f14150u
            float r5 = (float) r8
            r4.L = r5
            goto L_0x093e
        L_0x0177:
            r4.f(r6)
            s2.c r4 = r4.f14150u
            float r5 = (float) r8
            r4.K = r5
            goto L_0x093e
        L_0x0181:
            r4.f(r6)
            s2.c r4 = r4.f14150u
            float r5 = (float) r8
            r4.J = r5
            goto L_0x093e
        L_0x018b:
            r4.f(r6)
            s2.c r4 = r4.f14150u
            float r5 = (float) r8
            r4.I = r5
            goto L_0x093e
        L_0x0195:
            r4.f(r6)
            s2.c r4 = r4.f14150u
            float r5 = (float) r8
            r4.H = r5
            goto L_0x093e
        L_0x019f:
            r4.f(r6)
            s2.c r4 = r4.f14150u
            float r5 = (float) r8
            r4.G = r5
            goto L_0x093e
        L_0x01a9:
            r4.f(r6)
            s2.c r4 = r4.f14150u
            float r5 = (float) r8
            r4.F = r5
            goto L_0x093e
        L_0x01b3:
            r4.f(r6)
            s2.c r4 = r4.f14150u
            float r5 = (float) r8
            r4.E = r5
            goto L_0x093e
        L_0x01bd:
            r4.f(r6)
            s2.c r4 = r4.f14150u
            float r5 = (float) r8
            r4.D = r5
            goto L_0x093e
        L_0x01c7:
            r4.f(r6)
            s2.c r4 = r4.f14150u
            float r5 = (float) r8
            r4.f14116u = r5
            goto L_0x093e
        L_0x01d1:
            r4.f(r6)
            s2.c r4 = r4.f14150u
            float r5 = (float) r8
            r4.f14115t = r5
            goto L_0x093e
        L_0x01db:
            r4.f(r6)
            s2.c r4 = r4.f14150u
            float r5 = (float) r8
            r4.f14114s = r5
            goto L_0x093e
        L_0x01e5:
            r4.getClass()
            goto L_0x093e
        L_0x01ea:
            long r5 = (long) r8
            r4.f14148s = r5
            goto L_0x093e
        L_0x01ef:
            r4.f(r6)
            s2.c r4 = r4.f14150u
            int r5 = (int) r8
            r4.Q = r5
            goto L_0x093e
        L_0x01f9:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Invalid element type "
            r1.<init>(r2)
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            g1.b1 r1 = g1.b1.a(r1, r13)
            throw r1
        L_0x020c:
            e.a r4 = r7.f14092d
            int r8 = r7.f14094f
            long r5 = r7.f14095g
            int r6 = (int) r5
            java.lang.Object r4 = r4.f4852i
            s2.d r4 = (s2.d) r4
            android.util.SparseArray r5 = r4.f14132c
            r9 = 161(0xa1, float:2.26E-43)
            r11 = 163(0xa3, float:2.28E-43)
            if (r8 == r9) goto L_0x02f6
            if (r8 == r11) goto L_0x02f6
            r9 = 165(0xa5, float:2.31E-43)
            if (r8 == r9) goto L_0x02c8
            r5 = 16877(0x41ed, float:2.365E-41)
            if (r8 == r5) goto L_0x02a8
            r5 = 16981(0x4255, float:2.3795E-41)
            if (r8 == r5) goto L_0x029a
            r5 = 18402(0x47e2, float:2.5787E-41)
            if (r8 == r5) goto L_0x0286
            r5 = 21419(0x53ab, float:3.0014E-41)
            if (r8 == r5) goto L_0x026c
            r5 = 25506(0x63a2, float:3.5742E-41)
            if (r8 == r5) goto L_0x025e
            r5 = 30322(0x7672, float:4.249E-41)
            if (r8 != r5) goto L_0x024b
            r4.f(r8)
            s2.c r4 = r4.f14150u
            byte[] r5 = new byte[r6]
            r4.f14117v = r5
            r1.readFully(r5, r3, r6)
            goto L_0x084b
        L_0x024b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unexpected id: "
            r1.<init>(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            g1.b1 r1 = g1.b1.a(r1, r13)
            throw r1
        L_0x025e:
            r4.f(r8)
            s2.c r4 = r4.f14150u
            byte[] r5 = new byte[r6]
            r4.f14106k = r5
            r1.readFully(r5, r3, r6)
            goto L_0x084b
        L_0x026c:
            j1.b0 r5 = r4.f14138i
            byte[] r8 = r5.f8414a
            java.util.Arrays.fill(r8, r3)
            byte[] r8 = r5.f8414a
            int r9 = 4 - r6
            r1.readFully(r8, r9, r6)
            r5.G(r3)
            long r5 = r5.w()
            int r6 = (int) r5
            r4.f14152w = r6
            goto L_0x084b
        L_0x0286:
            byte[] r5 = new byte[r6]
            r1.readFully(r5, r3, r6)
            r4.f(r8)
            s2.c r4 = r4.f14150u
            d2.w0 r6 = new d2.w0
            r8 = 1
            r6.<init>(r8, r3, r3, r5)
            r4.f14105j = r6
            goto L_0x084b
        L_0x029a:
            r4.f(r8)
            s2.c r4 = r4.f14150u
            byte[] r5 = new byte[r6]
            r4.f14104i = r5
            r1.readFully(r5, r3, r6)
            goto L_0x084b
        L_0x02a8:
            r4.f(r8)
            s2.c r4 = r4.f14150u
            int r5 = r4.f14102g
            r8 = 1685485123(0x64767643, float:1.8185683E22)
            if (r5 == r8) goto L_0x02bf
            r8 = 1685480259(0x64766343, float:1.8180206E22)
            if (r5 != r8) goto L_0x02ba
            goto L_0x02bf
        L_0x02ba:
            r1.g(r6)
            goto L_0x084b
        L_0x02bf:
            byte[] r5 = new byte[r6]
            r4.N = r5
            r1.readFully(r5, r3, r6)
            goto L_0x084b
        L_0x02c8:
            int r8 = r4.G
            if (r8 == r10) goto L_0x02ce
            goto L_0x084b
        L_0x02ce:
            int r8 = r4.M
            java.lang.Object r5 = r5.get(r8)
            s2.c r5 = (s2.c) r5
            int r8 = r4.P
            r9 = 4
            if (r8 != r9) goto L_0x02f1
            java.lang.String r8 = "V_VP9"
            java.lang.String r5 = r5.f14097b
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x02f1
            j1.b0 r4 = r4.f14143n
            r4.D(r6)
            byte[] r4 = r4.f8414a
            r1.readFully(r4, r3, r6)
            goto L_0x084b
        L_0x02f1:
            r1.g(r6)
            goto L_0x084b
        L_0x02f6:
            int r9 = r4.G
            j1.b0 r14 = r4.f14136g
            if (r9 != 0) goto L_0x0316
            s2.f r9 = r4.f14130b
            r11 = 1
            long r12 = r9.b(r1, r3, r11, r15)
            int r13 = (int) r12
            r4.M = r13
            int r9 = r9.f14161c
            r4.N = r9
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r4.I = r12
            r4.G = r11
            r14.D(r3)
        L_0x0316:
            int r9 = r4.M
            java.lang.Object r5 = r5.get(r9)
            s2.c r5 = (s2.c) r5
            if (r5 != 0) goto L_0x032a
            int r5 = r4.N
            int r6 = r6 - r5
            r1.g(r6)
            r4.G = r3
            goto L_0x084b
        L_0x032a:
            d2.x0 r9 = r5.X
            r9.getClass()
            int r9 = r4.G
            r11 = 1
            if (r9 != r11) goto L_0x04d9
            r9 = 3
            r4.j(r1, r9)
            byte[] r9 = r14.f8414a
            byte r9 = r9[r10]
            r9 = r9 & 6
            int r9 = r9 >> r11
            if (r9 != 0) goto L_0x0363
            r4.K = r11
            int[] r9 = r4.L
            if (r9 != 0) goto L_0x034a
            int[] r9 = new int[r11]
            goto L_0x0357
        L_0x034a:
            int r12 = r9.length
            if (r12 < r11) goto L_0x034e
            goto L_0x0357
        L_0x034e:
            int r9 = r9.length
            int r9 = r9 * 2
            int r9 = java.lang.Math.max(r9, r11)
            int[] r9 = new int[r9]
        L_0x0357:
            r4.L = r9
            int r11 = r4.N
            int r6 = r6 - r11
            r11 = 3
            int r6 = r6 - r11
            r9[r3] = r6
        L_0x0360:
            r3 = r4
            goto L_0x048d
        L_0x0363:
            r11 = 3
            r12 = 4
            r4.j(r1, r12)
            byte[] r12 = r14.f8414a
            byte r12 = r12[r11]
            r11 = 255(0xff, float:3.57E-43)
            r12 = r12 & r11
            r13 = 1
            int r12 = r12 + r13
            r4.K = r12
            int[] r13 = r4.L
            if (r13 != 0) goto L_0x037a
            int[] r13 = new int[r12]
            goto L_0x0387
        L_0x037a:
            int r11 = r13.length
            if (r11 < r12) goto L_0x037e
            goto L_0x0387
        L_0x037e:
            int r11 = r13.length
            int r11 = r11 * 2
            int r11 = java.lang.Math.max(r11, r12)
            int[] r13 = new int[r11]
        L_0x0387:
            r4.L = r13
            if (r9 != r10) goto L_0x0397
            int r9 = r4.N
            int r6 = r6 - r9
            r11 = 4
            int r6 = r6 - r11
            int r9 = r4.K
            int r6 = r6 / r9
            java.util.Arrays.fill(r13, r3, r9, r6)
            goto L_0x0360
        L_0x0397:
            r11 = 4
            r12 = 1
            if (r9 != r12) goto L_0x03d7
            r9 = 4
            r11 = 0
            r13 = 0
        L_0x039e:
            int r10 = r4.K
            r18 = -1
            int r10 = r10 + -1
            if (r11 >= r10) goto L_0x03cd
            int[] r10 = r4.L
            r10[r11] = r3
        L_0x03aa:
            int r9 = r9 + r12
            r4.j(r1, r9)
            byte[] r10 = r14.f8414a
            int r12 = r9 + -1
            byte r10 = r10[r12]
            r12 = 255(0xff, float:3.57E-43)
            r10 = r10 & r12
            int[] r15 = r4.L
            r19 = r15[r11]
            int r19 = r19 + r10
            r15[r11] = r19
            if (r10 == r12) goto L_0x03c9
            int r13 = r13 + r19
            int r11 = r11 + 1
            r12 = 1
            r15 = 8
            goto L_0x039e
        L_0x03c9:
            r12 = 1
            r15 = 8
            goto L_0x03aa
        L_0x03cd:
            int[] r11 = r4.L
            int r15 = r4.N
            int r6 = r6 - r15
            int r6 = r6 - r9
            int r6 = r6 - r13
            r11[r10] = r6
            goto L_0x0360
        L_0x03d7:
            r10 = 3
            if (r9 != r10) goto L_0x04c5
            r9 = 4
            r10 = 0
            r11 = 0
        L_0x03dd:
            int r13 = r4.K
            r15 = -1
            int r13 = r13 + r15
            if (r10 >= r13) goto L_0x0483
            int[] r13 = r4.L
            r13[r10] = r3
            int r9 = r9 + 1
            r4.j(r1, r9)
            byte[] r13 = r14.f8414a
            int r18 = r9 + -1
            byte r13 = r13[r18]
            if (r13 == 0) goto L_0x047b
            r12 = 8
            r13 = 0
        L_0x03f7:
            if (r13 >= r12) goto L_0x0450
            int r12 = 7 - r13
            r21 = 1
            int r12 = r21 << r12
            byte[] r15 = r14.f8414a
            byte r15 = r15[r18]
            r15 = r15 & r12
            if (r15 == 0) goto L_0x0447
            int r9 = r9 + r13
            r4.j(r1, r9)
            byte[] r15 = r14.f8414a
            int r28 = r18 + 1
            byte r15 = r15[r18]
            r3 = 255(0xff, float:3.57E-43)
            r15 = r15 & r3
            int r12 = ~r12
            r12 = r12 & r15
            r15 = r4
            long r3 = (long) r12
            r12 = r28
        L_0x0419:
            if (r12 >= r9) goto L_0x0435
            r18 = 8
            long r3 = r3 << r18
            r28 = r9
            byte[] r9 = r14.f8414a
            int r18 = r12 + 1
            byte r9 = r9[r12]
            r12 = 255(0xff, float:3.57E-43)
            r9 = r9 & r12
            r24 = r13
            long r12 = (long) r9
            long r3 = r3 | r12
            r12 = r18
            r13 = r24
            r9 = r28
            goto L_0x0419
        L_0x0435:
            r28 = r9
            r24 = r13
            if (r10 <= 0) goto L_0x0444
            int r13 = r24 * 7
            int r13 = r13 + 6
            long r12 = r22 << r13
            long r12 = r12 - r22
            long r3 = r3 - r12
        L_0x0444:
            r9 = r28
            goto L_0x0453
        L_0x0447:
            r15 = r4
            r24 = r13
            int r13 = r24 + 1
            r3 = 0
            r12 = 8
            goto L_0x03f7
        L_0x0450:
            r15 = r4
            r3 = 0
        L_0x0453:
            r12 = -2147483648(0xffffffff80000000, double:NaN)
            int r18 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r18 < 0) goto L_0x0473
            int r12 = (r3 > r26 ? 1 : (r3 == r26 ? 0 : -1))
            if (r12 > 0) goto L_0x0473
            int r4 = (int) r3
            r3 = r15
            int[] r12 = r3.L
            if (r10 != 0) goto L_0x0465
            goto L_0x046a
        L_0x0465:
            int r13 = r10 + -1
            r13 = r12[r13]
            int r4 = r4 + r13
        L_0x046a:
            r12[r10] = r4
            int r11 = r11 + r4
            int r10 = r10 + 1
            r4 = r3
            r3 = 0
            goto L_0x03dd
        L_0x0473:
            java.lang.String r1 = "EBML lacing sample size out of range."
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x047b:
            r2 = 0
            java.lang.String r1 = "No valid varint length mask found"
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x0483:
            r3 = r4
            int[] r4 = r3.L
            int r10 = r3.N
            int r6 = r6 - r10
            int r6 = r6 - r9
            int r6 = r6 - r11
            r4[r13] = r6
        L_0x048d:
            byte[] r4 = r14.f8414a
            r6 = 0
            byte r9 = r4[r6]
            r6 = 8
            int r6 = r9 << 8
            r9 = 1
            byte r4 = r4[r9]
            r9 = 255(0xff, float:3.57E-43)
            r4 = r4 & r9
            r4 = r4 | r6
            long r9 = r3.B
            long r11 = (long) r4
            long r11 = r3.l(r11)
            long r11 = r11 + r9
            r3.H = r11
            int r4 = r5.f14099d
            r6 = 2
            if (r4 == r6) goto L_0x04bc
            r4 = 163(0xa3, float:2.28E-43)
            if (r8 != r4) goto L_0x04ba
            byte[] r4 = r14.f8414a
            byte r4 = r4[r6]
            r9 = 128(0x80, float:1.794E-43)
            r4 = r4 & r9
            if (r4 != r9) goto L_0x04ba
            goto L_0x04bc
        L_0x04ba:
            r4 = 0
            goto L_0x04bd
        L_0x04bc:
            r4 = 1
        L_0x04bd:
            r3.O = r4
            r3.G = r6
            r4 = 0
            r3.J = r4
            goto L_0x04da
        L_0x04c5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unexpected lacing value: "
            r1.<init>(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x04d9:
            r3 = r4
        L_0x04da:
            r4 = 163(0xa3, float:2.28E-43)
            if (r8 != r4) goto L_0x0514
        L_0x04de:
            int r4 = r3.J
            int r6 = r3.K
            if (r4 >= r6) goto L_0x050e
            int[] r6 = r3.L
            r4 = r6[r4]
            r6 = 0
            int r33 = r3.m(r1, r5, r4, r6)
            long r8 = r3.H
            int r4 = r3.J
            int r6 = r5.f14100e
            int r4 = r4 * r6
            int r4 = r4 / 1000
            long r10 = (long) r4
            long r30 = r10 + r8
            int r4 = r3.O
            r34 = 0
            r28 = r3
            r29 = r5
            r32 = r4
            r28.g(r29, r30, r32, r33, r34)
            int r4 = r3.J
            r6 = 1
            int r4 = r4 + r6
            r3.J = r4
            goto L_0x04de
        L_0x050e:
            r4 = 0
            r6 = 1
            r3.G = r4
            goto L_0x084b
        L_0x0514:
            r6 = 1
            int r4 = r3.J
            int r8 = r3.K
            if (r4 >= r8) goto L_0x0928
            int[] r8 = r3.L
            r9 = r8[r4]
            int r9 = r3.m(r1, r5, r9, r6)
            r8[r4] = r9
            int r4 = r3.J
            int r4 = r4 + r6
            r3.J = r4
            goto L_0x0514
        L_0x052b:
            long r3 = r7.f14095g
            int r5 = (r3 > r26 ? 1 : (r3 == r26 ? 0 : -1))
            if (r5 > 0) goto L_0x05af
            e.a r5 = r7.f14092d
            int r6 = r7.f14094f
            int r4 = (int) r3
            if (r4 != 0) goto L_0x053b
            java.lang.String r3 = ""
            goto L_0x0551
        L_0x053b:
            byte[] r3 = new byte[r4]
            r8 = 0
            r1.readFully(r3, r8, r4)
        L_0x0541:
            if (r4 <= 0) goto L_0x054b
            int r10 = r4 + -1
            byte r11 = r3[r10]
            if (r11 != 0) goto L_0x054b
            r4 = r10
            goto L_0x0541
        L_0x054b:
            java.lang.String r10 = new java.lang.String
            r10.<init>(r3, r8, r4)
            r3 = r10
        L_0x0551:
            java.lang.Object r4 = r5.f4852i
            s2.d r4 = (s2.d) r4
            r4.getClass()
            r5 = 134(0x86, float:1.88E-43)
            if (r6 == r5) goto L_0x05a6
            r5 = 17026(0x4282, float:2.3859E-41)
            if (r6 == r5) goto L_0x057d
            r5 = 21358(0x536e, float:2.9929E-41)
            if (r6 == r5) goto L_0x0574
            r5 = 2274716(0x22b59c, float:3.187556E-39)
            if (r6 == r5) goto L_0x056b
            goto L_0x084b
        L_0x056b:
            r4.f(r6)
            s2.c r4 = r4.f14150u
            r4.W = r3
            goto L_0x084b
        L_0x0574:
            r4.f(r6)
            s2.c r4 = r4.f14150u
            r4.f14096a = r3
            goto L_0x084b
        L_0x057d:
            java.lang.String r4 = "webm"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0928
            java.lang.String r4 = "matroska"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x058f
            goto L_0x084b
        L_0x058f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "DocType "
            r1.<init>(r2)
            r1.append(r3)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x05a6:
            r4.f(r6)
            s2.c r4 = r4.f14150u
            r4.f14097b = r3
            goto L_0x084b
        L_0x05af:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "String element size: "
            r1.<init>(r2)
            long r2 = r7.f14095g
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x05c5:
            long r3 = r7.f14095g
            int r5 = (r3 > r24 ? 1 : (r3 == r24 ? 0 : -1))
            if (r5 > 0) goto L_0x0864
            e.a r5 = r7.f14092d
            int r6 = r7.f14094f
            int r4 = (int) r3
            r3 = 0
            r1.readFully(r8, r3, r4)
            r3 = 0
            r10 = 0
        L_0x05d7:
            if (r3 >= r4) goto L_0x05e6
            r12 = 8
            long r10 = r10 << r12
            byte r13 = r8[r3]
            r14 = 255(0xff, float:3.57E-43)
            r13 = r13 & r14
            long r12 = (long) r13
            long r10 = r10 | r12
            int r3 = r3 + 1
            goto L_0x05d7
        L_0x05e6:
            java.lang.Object r3 = r5.f4852i
            s2.d r3 = (s2.d) r3
            r3.getClass()
            r4 = 20529(0x5031, float:2.8767E-41)
            if (r6 == r4) goto L_0x0845
            r4 = 20530(0x5032, float:2.8769E-41)
            if (r6 == r4) goto L_0x0829
            switch(r6) {
                case 131: goto L_0x07d3;
                case 136: goto L_0x07c3;
                case 155: goto L_0x07bb;
                case 159: goto L_0x07b1;
                case 176: goto L_0x07a7;
                case 179: goto L_0x0799;
                case 186: goto L_0x078f;
                case 215: goto L_0x0785;
                case 231: goto L_0x077d;
                case 238: goto L_0x0778;
                case 241: goto L_0x0767;
                case 251: goto L_0x0762;
                case 16871: goto L_0x0758;
                case 16980: goto L_0x0739;
                case 17029: goto L_0x0716;
                case 17143: goto L_0x06f9;
                case 18401: goto L_0x06da;
                case 18408: goto L_0x06bd;
                case 21420: goto L_0x06b6;
                case 21432: goto L_0x068d;
                case 21680: goto L_0x0683;
                case 21682: goto L_0x0679;
                case 21690: goto L_0x066f;
                case 21930: goto L_0x065f;
                case 21998: goto L_0x0655;
                case 22186: goto L_0x064c;
                case 22203: goto L_0x0643;
                case 25188: goto L_0x0639;
                case 30114: goto L_0x0635;
                case 30321: goto L_0x060b;
                case 2352003: goto L_0x0601;
                case 2807729: goto L_0x05fd;
                default: goto L_0x05f8;
            }
        L_0x05f8:
            switch(r6) {
                case 21945: goto L_0x0814;
                case 21946: goto L_0x0804;
                case 21947: goto L_0x07ef;
                case 21948: goto L_0x07e6;
                case 21949: goto L_0x07dd;
                default: goto L_0x05fb;
            }
        L_0x05fb:
            goto L_0x084b
        L_0x05fd:
            r3.f14147r = r10
            goto L_0x084b
        L_0x0601:
            r3.f(r6)
            s2.c r3 = r3.f14150u
            int r4 = (int) r10
            r3.f14100e = r4
            goto L_0x084b
        L_0x060b:
            r3.f(r6)
            int r4 = (int) r10
            if (r4 == 0) goto L_0x062e
            r5 = 1
            if (r4 == r5) goto L_0x0628
            r6 = 2
            if (r4 == r6) goto L_0x0622
            r8 = 3
            if (r4 == r8) goto L_0x061c
            goto L_0x084b
        L_0x061c:
            s2.c r3 = r3.f14150u
            r3.f14113r = r8
            goto L_0x084b
        L_0x0622:
            s2.c r3 = r3.f14150u
            r3.f14113r = r6
            goto L_0x084b
        L_0x0628:
            s2.c r3 = r3.f14150u
            r3.f14113r = r5
            goto L_0x084b
        L_0x062e:
            s2.c r3 = r3.f14150u
            r4 = 0
            r3.f14113r = r4
            goto L_0x084b
        L_0x0635:
            r3.R = r10
            goto L_0x084b
        L_0x0639:
            r3.f(r6)
            s2.c r3 = r3.f14150u
            int r4 = (int) r10
            r3.P = r4
            goto L_0x084b
        L_0x0643:
            r3.f(r6)
            s2.c r3 = r3.f14150u
            r3.S = r10
            goto L_0x084b
        L_0x064c:
            r3.f(r6)
            s2.c r3 = r3.f14150u
            r3.R = r10
            goto L_0x084b
        L_0x0655:
            r3.f(r6)
            s2.c r3 = r3.f14150u
            int r4 = (int) r10
            r3.f14101f = r4
            goto L_0x084b
        L_0x065f:
            r3.f(r6)
            s2.c r3 = r3.f14150u
            int r4 = (r10 > r22 ? 1 : (r10 == r22 ? 0 : -1))
            if (r4 != 0) goto L_0x066a
            r4 = 1
            goto L_0x066b
        L_0x066a:
            r4 = 0
        L_0x066b:
            r3.U = r4
            goto L_0x084b
        L_0x066f:
            r3.f(r6)
            s2.c r3 = r3.f14150u
            int r4 = (int) r10
            r3.f14111p = r4
            goto L_0x084b
        L_0x0679:
            r3.f(r6)
            s2.c r3 = r3.f14150u
            int r4 = (int) r10
            r3.f14112q = r4
            goto L_0x084b
        L_0x0683:
            r3.f(r6)
            s2.c r3 = r3.f14150u
            int r4 = (int) r10
            r3.f14110o = r4
            goto L_0x084b
        L_0x068d:
            int r4 = (int) r10
            r3.f(r6)
            if (r4 == 0) goto L_0x06af
            r5 = 1
            if (r4 == r5) goto L_0x06ab
            r6 = 3
            if (r4 == r6) goto L_0x06a5
            r8 = 15
            if (r4 == r8) goto L_0x069f
            goto L_0x084b
        L_0x069f:
            s2.c r3 = r3.f14150u
            r3.f14118w = r6
            goto L_0x084b
        L_0x06a5:
            s2.c r3 = r3.f14150u
            r3.f14118w = r5
            goto L_0x084b
        L_0x06ab:
            s2.c r3 = r3.f14150u
            r10 = 2
            goto L_0x06b2
        L_0x06af:
            s2.c r3 = r3.f14150u
            r10 = 0
        L_0x06b2:
            r3.f14118w = r10
            goto L_0x084b
        L_0x06b6:
            long r4 = r3.f14146q
            long r10 = r10 + r4
            r3.f14153x = r10
            goto L_0x084b
        L_0x06bd:
            int r3 = (r10 > r22 ? 1 : (r10 == r22 ? 0 : -1))
            if (r3 != 0) goto L_0x06c3
            goto L_0x084b
        L_0x06c3:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "AESSettingsCipherMode "
            r1.<init>(r2)
            r1.append(r10)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x06da:
            r3 = 5
            int r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x06e2
            goto L_0x084b
        L_0x06e2:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "ContentEncAlgo "
            r1.<init>(r2)
            r1.append(r10)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r3 = 0
            g1.b1 r1 = g1.b1.a(r1, r3)
            throw r1
        L_0x06f9:
            r3 = 0
            int r4 = (r10 > r22 ? 1 : (r10 == r22 ? 0 : -1))
            if (r4 != 0) goto L_0x0700
            goto L_0x084b
        L_0x0700:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "EBMLReadVersion "
            r1.<init>(r2)
            r1.append(r10)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            g1.b1 r1 = g1.b1.a(r1, r3)
            throw r1
        L_0x0716:
            int r3 = (r10 > r22 ? 1 : (r10 == r22 ? 0 : -1))
            if (r3 < 0) goto L_0x0722
            r3 = 2
            int r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0722
            goto L_0x084b
        L_0x0722:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "DocTypeReadVersion "
            r1.<init>(r2)
            r1.append(r10)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x0739:
            r3 = 3
            int r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0741
            goto L_0x084b
        L_0x0741:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "ContentCompAlgo "
            r1.<init>(r2)
            r1.append(r10)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x0758:
            r3.f(r6)
            s2.c r3 = r3.f14150u
            int r4 = (int) r10
            r3.f14102g = r4
            goto L_0x084b
        L_0x0762:
            r4 = 1
            r3.Q = r4
            goto L_0x084b
        L_0x0767:
            r4 = 1
            boolean r5 = r3.E
            if (r5 != 0) goto L_0x0928
            r3.b(r6)
            j1.w r5 = r3.D
            r5.a(r10)
            r3.E = r4
            goto L_0x084b
        L_0x0778:
            int r4 = (int) r10
            r3.P = r4
            goto L_0x084b
        L_0x077d:
            long r4 = r3.l(r10)
            r3.B = r4
            goto L_0x084b
        L_0x0785:
            r3.f(r6)
            s2.c r3 = r3.f14150u
            int r4 = (int) r10
            r3.f14098c = r4
            goto L_0x084b
        L_0x078f:
            r3.f(r6)
            s2.c r3 = r3.f14150u
            int r4 = (int) r10
            r3.f14109n = r4
            goto L_0x084b
        L_0x0799:
            r3.b(r6)
            j1.w r4 = r3.C
            long r5 = r3.l(r10)
            r4.a(r5)
            goto L_0x084b
        L_0x07a7:
            r3.f(r6)
            s2.c r3 = r3.f14150u
            int r4 = (int) r10
            r3.f14108m = r4
            goto L_0x084b
        L_0x07b1:
            r3.f(r6)
            s2.c r3 = r3.f14150u
            int r4 = (int) r10
            r3.O = r4
            goto L_0x084b
        L_0x07bb:
            long r4 = r3.l(r10)
            r3.I = r4
            goto L_0x084b
        L_0x07c3:
            r3.f(r6)
            s2.c r3 = r3.f14150u
            int r4 = (r10 > r22 ? 1 : (r10 == r22 ? 0 : -1))
            if (r4 != 0) goto L_0x07ce
            r4 = 1
            goto L_0x07cf
        L_0x07ce:
            r4 = 0
        L_0x07cf:
            r3.V = r4
            goto L_0x084b
        L_0x07d3:
            r3.f(r6)
            s2.c r3 = r3.f14150u
            int r4 = (int) r10
            r3.f14099d = r4
            goto L_0x084b
        L_0x07dd:
            r3.f(r6)
            s2.c r3 = r3.f14150u
            int r4 = (int) r10
            r3.C = r4
            goto L_0x084b
        L_0x07e6:
            r3.f(r6)
            s2.c r3 = r3.f14150u
            int r4 = (int) r10
            r3.B = r4
            goto L_0x084b
        L_0x07ef:
            r3.f(r6)
            s2.c r4 = r3.f14150u
            r5 = 1
            r4.f14119x = r5
            int r4 = (int) r10
            int r4 = g1.o.i(r4)
            r5 = -1
            if (r4 == r5) goto L_0x0928
            s2.c r3 = r3.f14150u
            r3.f14120y = r4
            goto L_0x084b
        L_0x0804:
            r5 = -1
            r3.f(r6)
            int r4 = (int) r10
            int r4 = g1.o.j(r4)
            if (r4 == r5) goto L_0x0928
            s2.c r3 = r3.f14150u
            r3.f14121z = r4
            goto L_0x084b
        L_0x0814:
            r3.f(r6)
            int r4 = (int) r10
            r5 = 1
            r6 = 2
            if (r4 == r5) goto L_0x0824
            if (r4 == r6) goto L_0x081f
            goto L_0x084b
        L_0x081f:
            s2.c r3 = r3.f14150u
            r3.A = r5
            goto L_0x084b
        L_0x0824:
            s2.c r3 = r3.f14150u
            r3.A = r6
            goto L_0x084b
        L_0x0829:
            int r3 = (r10 > r22 ? 1 : (r10 == r22 ? 0 : -1))
            if (r3 != 0) goto L_0x082e
            goto L_0x084b
        L_0x082e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "ContentEncodingScope "
            r1.<init>(r2)
            r1.append(r10)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x0845:
            r3 = 0
            int r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x084d
        L_0x084b:
            goto L_0x0928
        L_0x084d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "ContentEncodingOrder "
            r1.<init>(r2)
            r1.append(r10)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x0864:
            r2 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid integer size: "
            r1.<init>(r3)
            long r3 = r7.f14095g
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x087a:
            long r3 = r36.p()
            long r12 = r7.f14095g
            long r12 = r12 + r3
            s2.a r6 = new s2.a
            int r8 = r7.f14094f
            r6.<init>(r8, r12)
            r5.push(r6)
            e.a r5 = r7.f14092d
            int r6 = r7.f14094f
            long r12 = r7.f14095g
            java.lang.Object r5 = r5.f4852i
            s2.d r5 = (s2.d) r5
            d2.y r8 = r5.f14131b0
            j1.a.f(r8)
            r8 = 160(0xa0, float:2.24E-43)
            if (r6 == r8) goto L_0x0937
            r8 = 174(0xae, float:2.44E-43)
            if (r6 == r8) goto L_0x092e
            r8 = 187(0xbb, float:2.62E-43)
            if (r6 == r8) goto L_0x092a
            r8 = 19899(0x4dbb, float:2.7884E-41)
            if (r6 == r8) goto L_0x0921
            r8 = 20533(0x5035, float:2.8773E-41)
            if (r6 == r8) goto L_0x0918
            r8 = 21968(0x55d0, float:3.0784E-41)
            if (r6 == r8) goto L_0x090f
            r8 = 408125543(0x18538067, float:2.7335937E-24)
            if (r6 == r8) goto L_0x08f5
            r8 = 475249515(0x1c53bb6b, float:7.0056276E-22)
            if (r6 == r8) goto L_0x08e6
            r3 = 524531317(0x1f43b675, float:4.144378E-20)
            if (r6 == r3) goto L_0x08c2
            goto L_0x0928
        L_0x08c2:
            boolean r3 = r5.f14151v
            if (r3 != 0) goto L_0x0928
            boolean r3 = r5.f14133d
            if (r3 == 0) goto L_0x08d6
            long r3 = r5.f14155z
            r8 = -1
            int r6 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x08d6
            r3 = 1
            r5.f14154y = r3
            goto L_0x0928
        L_0x08d6:
            r3 = 1
            d2.y r4 = r5.f14131b0
            d2.e0 r6 = new d2.e0
            long r8 = r5.f14149t
            r6.<init>(r8)
            r4.g(r6)
            r5.f14151v = r3
            goto L_0x0928
        L_0x08e6:
            j1.w r3 = new j1.w
            r3.<init>()
            r5.C = r3
            j1.w r3 = new j1.w
            r3.<init>()
            r5.D = r3
            goto L_0x0928
        L_0x08f5:
            long r8 = r5.f14146q
            r10 = -1
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x090a
            int r6 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x0902
            goto L_0x090a
        L_0x0902:
            java.lang.String r1 = "Multiple Segment elements not supported"
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x090a:
            r5.f14146q = r3
            r5.f14145p = r12
            goto L_0x0928
        L_0x090f:
            r5.f(r6)
            s2.c r3 = r5.f14150u
            r4 = 1
            r3.f14119x = r4
            goto L_0x0928
        L_0x0918:
            r4 = 1
            r5.f(r6)
            s2.c r3 = r5.f14150u
            r3.f14103h = r4
            goto L_0x0928
        L_0x0921:
            r3 = -1
            r5.f14152w = r3
            r3 = -1
            r5.f14153x = r3
        L_0x0928:
            r3 = 0
            goto L_0x093e
        L_0x092a:
            r3 = 0
            r5.E = r3
            goto L_0x093e
        L_0x092e:
            r3 = 0
            s2.c r4 = new s2.c
            r4.<init>()
            r5.f14150u = r4
            goto L_0x093e
        L_0x0937:
            r3 = 0
            r5.Q = r3
            r8 = 0
            r5.R = r8
        L_0x093e:
            r7.f14093e = r3
        L_0x0940:
            r5 = 1
        L_0x0941:
            if (r5 == 0) goto L_0x096b
            long r6 = r36.p()
            boolean r4 = r0.f14154y
            if (r4 == 0) goto L_0x0954
            r0.A = r6
            long r6 = r0.f14155z
            r2.f4296a = r6
            r0.f14154y = r3
            goto L_0x0964
        L_0x0954:
            boolean r3 = r0.f14151v
            if (r3 == 0) goto L_0x0966
            long r3 = r0.A
            r6 = -1
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0966
            r2.f4296a = r3
            r0.A = r6
        L_0x0964:
            r4 = 1
            goto L_0x0967
        L_0x0966:
            r4 = 0
        L_0x0967:
            if (r4 == 0) goto L_0x096b
            r3 = 1
            return r3
        L_0x096b:
            r3 = 1
            r3 = 0
            r4 = 1
            goto L_0x000b
        L_0x0970:
            r3 = 1
            long r4 = r7.f14095g
            int r5 = (int) r4
            r1.g(r5)
            r4 = 0
            r7.f14093e = r4
            r3 = 0
            r4 = 1
            r6 = -1
            goto L_0x0019
        L_0x097f:
            if (r5 != 0) goto L_0x09a5
            r3 = 0
        L_0x0982:
            android.util.SparseArray r1 = r0.f14132c
            int r2 = r1.size()
            if (r3 >= r2) goto L_0x09a3
            java.lang.Object r1 = r1.valueAt(r3)
            s2.c r1 = (s2.c) r1
            d2.x0 r2 = r1.X
            r2.getClass()
            d2.y0 r2 = r1.T
            if (r2 == 0) goto L_0x09a0
            d2.x0 r4 = r1.X
            d2.w0 r1 = r1.f14105j
            r2.a(r4, r1)
        L_0x09a0:
            int r3 = r3 + 1
            goto L_0x0982
        L_0x09a3:
            r1 = -1
            return r1
        L_0x09a5:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.d.d(d2.w, d2.s0):int");
    }

    public final void e(y yVar) {
        this.f14131b0 = yVar;
    }

    public final void f(int i10) {
        if (this.f14150u == null) {
            throw b1.a("Element " + i10 + " must be in a TrackEntry", (Exception) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d2 A[EDGE_INSN: B:59:0x00d2->B:49:0x00d2 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(s2.c r18, long r19, int r21, int r22, int r23) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            d2.y0 r2 = r1.T
            r9 = 1
            if (r2 == 0) goto L_0x001c
            d2.x0 r3 = r1.X
            d2.w0 r8 = r1.f14105j
            r1 = r2
            r2 = r3
            r3 = r19
            r5 = r21
            r6 = r22
            r7 = r23
            r1.b(r2, r3, r5, r6, r7, r8)
            goto L_0x0105
        L_0x001c:
            java.lang.String r2 = r1.f14097b
            java.lang.String r3 = "S_TEXT/UTF8"
            boolean r2 = r3.equals(r2)
            r4 = 0
            java.lang.String r5 = "S_TEXT/WEBVTT"
            java.lang.String r6 = "S_TEXT/ASS"
            if (r2 != 0) goto L_0x003b
            java.lang.String r2 = r1.f14097b
            boolean r2 = r6.equals(r2)
            if (r2 != 0) goto L_0x003b
            java.lang.String r2 = r1.f14097b
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0054
        L_0x003b:
            int r2 = r0.K
            if (r2 <= r9) goto L_0x0042
            java.lang.String r2 = "Skipping subtitle sample in laced block."
            goto L_0x004f
        L_0x0042:
            long r7 = r0.I
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r2 != 0) goto L_0x0058
            java.lang.String r2 = "Skipping subtitle sample with no duration."
        L_0x004f:
            java.lang.String r3 = "MatroskaExtractor"
            j1.v.g(r3, r2)
        L_0x0054:
            r2 = r22
            goto L_0x00dd
        L_0x0058:
            java.lang.String r2 = r1.f14097b
            j1.b0 r10 = r0.f14140k
            byte[] r11 = r10.f8414a
            r2.getClass()
            int r12 = r2.hashCode()
            r13 = 738597099(0x2c0618eb, float:1.9056378E-12)
            r14 = 2
            if (r12 == r13) goto L_0x0088
            r6 = 1045209816(0x3e4ca2d8, float:0.19983995)
            if (r12 == r6) goto L_0x007f
            r5 = 1422270023(0x54c61e47, float:6.807292E12)
            if (r12 == r5) goto L_0x0076
            goto L_0x008e
        L_0x0076:
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x007d
            goto L_0x008e
        L_0x007d:
            r2 = 2
            goto L_0x0091
        L_0x007f:
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x0086
            goto L_0x008e
        L_0x0086:
            r2 = 1
            goto L_0x0091
        L_0x0088:
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x0090
        L_0x008e:
            r2 = -1
            goto L_0x0091
        L_0x0090:
            r2 = 0
        L_0x0091:
            if (r2 == 0) goto L_0x00b1
            r5 = 1000(0x3e8, double:4.94E-321)
            if (r2 == r9) goto L_0x00a8
            if (r2 != r14) goto L_0x00a2
            java.lang.String r2 = "%02d:%02d:%02d,%03d"
            byte[] r2 = i(r7, r5, r2)
            r3 = 19
            goto L_0x00bb
        L_0x00a2:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>()
            throw r1
        L_0x00a8:
            java.lang.String r2 = "%02d:%02d:%02d.%03d"
            byte[] r2 = i(r7, r5, r2)
            r3 = 25
            goto L_0x00bb
        L_0x00b1:
            java.lang.String r2 = "%01d:%02d:%02d:%02d"
            r5 = 10000(0x2710, double:4.9407E-320)
            byte[] r2 = i(r7, r5, r2)
            r3 = 21
        L_0x00bb:
            int r5 = r2.length
            java.lang.System.arraycopy(r2, r4, r11, r3, r5)
            int r2 = r10.f8415b
        L_0x00c1:
            int r3 = r10.f8416c
            if (r2 >= r3) goto L_0x00d2
            byte[] r3 = r10.f8414a
            byte r3 = r3[r2]
            if (r3 != 0) goto L_0x00cf
            r10.F(r2)
            goto L_0x00d2
        L_0x00cf:
            int r2 = r2 + 1
            goto L_0x00c1
        L_0x00d2:
            d2.x0 r2 = r1.X
            int r3 = r10.f8416c
            r2.d(r3, r10)
            int r2 = r10.f8416c
            int r2 = r22 + r2
        L_0x00dd:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r3 = r21 & r3
            if (r3 == 0) goto L_0x00f5
            int r3 = r0.K
            j1.b0 r5 = r0.f14143n
            if (r3 <= r9) goto L_0x00ed
            r5.D(r4)
            goto L_0x00f5
        L_0x00ed:
            int r3 = r5.f8416c
            d2.x0 r4 = r1.X
            r4.b(r3, r5)
            int r2 = r2 + r3
        L_0x00f5:
            r14 = r2
            d2.x0 r10 = r1.X
            d2.w0 r1 = r1.f14105j
            r11 = r19
            r13 = r21
            r15 = r23
            r16 = r1
            r10.e(r11, r13, r14, r15, r16)
        L_0x0105:
            r0.F = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.d.g(s2.c, long, int, int, int):void");
    }

    public final boolean h(d2.w wVar) {
        long a10;
        int i10;
        e eVar = new e();
        p pVar = (p) wVar;
        long j10 = pVar.f4273c;
        long j11 = 1024;
        int i11 = (j10 > -1 ? 1 : (j10 == -1 ? 0 : -1));
        if (i11 != 0 && j10 <= 1024) {
            j11 = j10;
        }
        int i12 = (int) j11;
        b0 b0Var = eVar.f14156a;
        pVar.k(b0Var.f8414a, 0, 4, false);
        eVar.f14157b = 4;
        for (long w10 = b0Var.w(); w10 != 440786851; w10 = ((w10 << 8) & -256) | ((long) (b0Var.f8414a[0] & 255))) {
            int i13 = eVar.f14157b + 1;
            eVar.f14157b = i13;
            if (i13 == i12) {
                return false;
            }
            pVar.k(b0Var.f8414a, 0, 1, false);
        }
        long a11 = eVar.a(pVar);
        long j12 = (long) eVar.f14157b;
        if (a11 == Long.MIN_VALUE) {
            return false;
        }
        if (i11 != 0 && j12 + a11 >= j10) {
            return false;
        }
        while (true) {
            int i14 = (((long) eVar.f14157b) > (j12 + a11) ? 1 : (((long) eVar.f14157b) == (j12 + a11) ? 0 : -1));
            if (i14 < 0) {
                if (eVar.a(pVar) == Long.MIN_VALUE || a10 < 0 || a10 > 2147483647L) {
                    return false;
                }
                if (i10 != 0) {
                    int a12 = (int) (a10 = eVar.a(pVar));
                    pVar.h(a12, false);
                    eVar.f14157b += a12;
                }
            } else if (i14 == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public final void j(d2.w wVar, int i10) {
        b0 b0Var = this.f14136g;
        if (b0Var.f8416c < i10) {
            byte[] bArr = b0Var.f8414a;
            if (bArr.length < i10) {
                b0Var.a(Math.max(bArr.length * 2, i10));
            }
            byte[] bArr2 = b0Var.f8414a;
            int i11 = b0Var.f8416c;
            wVar.readFully(bArr2, i11, i10 - i11);
            b0Var.F(i10);
        }
    }

    public final void k() {
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = 0;
        this.Z = 0;
        this.f14129a0 = false;
        this.f14139j.D(0);
    }

    public final long l(long j10) {
        long j11 = this.f14147r;
        if (j11 != -9223372036854775807L) {
            return l0.M(j10, j11, 1000);
        }
        throw b1.a("Can't scale timecode prior to timecodeScale being set.", (Exception) null);
    }

    public final int m(d2.w wVar, c cVar, int i10, boolean z10) {
        int i11;
        int i12;
        int i13;
        d2.w wVar2 = wVar;
        c cVar2 = cVar;
        int i14 = i10;
        if ("S_TEXT/UTF8".equals(cVar2.f14097b)) {
            n(wVar2, f14122c0, i14);
        } else if ("S_TEXT/ASS".equals(cVar2.f14097b)) {
            n(wVar2, f14124e0, i14);
        } else if ("S_TEXT/WEBVTT".equals(cVar2.f14097b)) {
            n(wVar2, f14125f0, i14);
        } else {
            x0 x0Var = cVar2.X;
            boolean z11 = this.V;
            b0 b0Var = this.f14139j;
            boolean z12 = true;
            if (!z11) {
                boolean z13 = cVar2.f14103h;
                b0 b0Var2 = this.f14136g;
                if (z13) {
                    this.O &= -1073741825;
                    int i15 = 128;
                    if (!this.W) {
                        wVar2.readFully(b0Var2.f8414a, 0, 1);
                        this.S++;
                        byte b10 = b0Var2.f8414a[0];
                        if ((b10 & 128) != 128) {
                            this.Z = b10;
                            this.W = true;
                        } else {
                            throw b1.a("Extension bit is set in signal byte", (Exception) null);
                        }
                    }
                    byte b11 = this.Z;
                    if ((b11 & 1) == 1) {
                        boolean z14 = (b11 & 2) == 2;
                        this.O |= 1073741824;
                        if (!this.f14129a0) {
                            b0 b0Var3 = this.f14141l;
                            wVar2.readFully(b0Var3.f8414a, 0, 8);
                            this.S += 8;
                            this.f14129a0 = true;
                            byte[] bArr = b0Var2.f8414a;
                            if (!z14) {
                                i15 = 0;
                            }
                            bArr[0] = (byte) (i15 | 8);
                            b0Var2.G(0);
                            x0Var.b(1, b0Var2);
                            this.T++;
                            b0Var3.G(0);
                            x0Var.b(8, b0Var3);
                            this.T += 8;
                        }
                        if (z14) {
                            if (!this.X) {
                                wVar2.readFully(b0Var2.f8414a, 0, 1);
                                this.S++;
                                b0Var2.G(0);
                                this.Y = b0Var2.v();
                                this.X = true;
                            }
                            int i16 = this.Y * 4;
                            b0Var2.D(i16);
                            wVar2.readFully(b0Var2.f8414a, 0, i16);
                            this.S += i16;
                            short s10 = (short) ((this.Y / 2) + 1);
                            int i17 = (s10 * 6) + 2;
                            ByteBuffer byteBuffer = this.f14144o;
                            if (byteBuffer == null || byteBuffer.capacity() < i17) {
                                this.f14144o = ByteBuffer.allocate(i17);
                            }
                            this.f14144o.position(0);
                            this.f14144o.putShort(s10);
                            int i18 = 0;
                            int i19 = 0;
                            while (true) {
                                i13 = this.Y;
                                if (i18 >= i13) {
                                    break;
                                }
                                int y10 = b0Var2.y();
                                if (i18 % 2 == 0) {
                                    this.f14144o.putShort((short) (y10 - i19));
                                } else {
                                    this.f14144o.putInt(y10 - i19);
                                }
                                i18++;
                                i19 = y10;
                            }
                            int i20 = (i14 - this.S) - i19;
                            int i21 = i13 % 2;
                            ByteBuffer byteBuffer2 = this.f14144o;
                            if (i21 == 1) {
                                byteBuffer2.putInt(i20);
                            } else {
                                byteBuffer2.putShort((short) i20);
                                this.f14144o.putInt(0);
                            }
                            byte[] array = this.f14144o.array();
                            b0 b0Var4 = this.f14142m;
                            b0Var4.E(i17, array);
                            x0Var.b(i17, b0Var4);
                            this.T += i17;
                        }
                    }
                } else {
                    byte[] bArr2 = cVar2.f14104i;
                    if (bArr2 != null) {
                        b0Var.E(bArr2.length, bArr2);
                    }
                }
                if ("A_OPUS".equals(cVar2.f14097b) ? z10 : cVar2.f14101f > 0) {
                    this.O |= 268435456;
                    this.f14143n.D(0);
                    int i22 = (b0Var.f8416c + i14) - this.S;
                    b0Var2.D(4);
                    byte[] bArr3 = b0Var2.f8414a;
                    bArr3[0] = (byte) ((i22 >> 24) & 255);
                    bArr3[1] = (byte) ((i22 >> 16) & 255);
                    bArr3[2] = (byte) ((i22 >> 8) & 255);
                    bArr3[3] = (byte) (i22 & 255);
                    x0Var.b(4, b0Var2);
                    this.T += 4;
                }
                this.V = true;
            }
            int i23 = i14 + b0Var.f8416c;
            if (!"V_MPEG4/ISO/AVC".equals(cVar2.f14097b) && !"V_MPEGH/ISO/HEVC".equals(cVar2.f14097b)) {
                if (cVar2.T != null) {
                    if (b0Var.f8416c != 0) {
                        z12 = false;
                    }
                    a.e(z12);
                    cVar2.T.c(wVar2);
                }
                while (true) {
                    int i24 = this.S;
                    if (i24 >= i23) {
                        break;
                    }
                    int i25 = i23 - i24;
                    int i26 = b0Var.f8416c - b0Var.f8415b;
                    if (i26 > 0) {
                        i12 = Math.min(i25, i26);
                        x0Var.d(i12, b0Var);
                    } else {
                        i12 = x0Var.c(wVar2, i25, false);
                    }
                    this.S += i12;
                    this.T += i12;
                }
            } else {
                b0 b0Var5 = this.f14135f;
                byte[] bArr4 = b0Var5.f8414a;
                bArr4[0] = 0;
                bArr4[1] = 0;
                bArr4[2] = 0;
                int i27 = cVar2.Y;
                int i28 = 4 - i27;
                while (this.S < i23) {
                    int i29 = this.U;
                    if (i29 == 0) {
                        int min = Math.min(i27, b0Var.f8416c - b0Var.f8415b);
                        wVar2.readFully(bArr4, i28 + min, i27 - min);
                        if (min > 0) {
                            b0Var.d(bArr4, i28, min);
                        }
                        this.S += i27;
                        b0Var5.G(0);
                        this.U = b0Var5.y();
                        b0 b0Var6 = this.f14134e;
                        b0Var6.G(0);
                        x0Var.d(4, b0Var6);
                        this.T += 4;
                    } else {
                        int i30 = b0Var.f8416c - b0Var.f8415b;
                        if (i30 > 0) {
                            i11 = Math.min(i29, i30);
                            x0Var.d(i11, b0Var);
                        } else {
                            i11 = x0Var.c(wVar2, i29, false);
                        }
                        this.S += i11;
                        this.T += i11;
                        this.U -= i11;
                    }
                }
            }
            if ("A_VORBIS".equals(cVar2.f14097b)) {
                b0 b0Var7 = this.f14137h;
                b0Var7.G(0);
                x0Var.d(4, b0Var7);
                this.T += 4;
            }
        }
        int i31 = this.T;
        k();
        return i31;
    }

    public final void n(d2.w wVar, byte[] bArr, int i10) {
        int length = bArr.length + i10;
        b0 b0Var = this.f14140k;
        byte[] bArr2 = b0Var.f8414a;
        if (bArr2.length < length) {
            byte[] copyOf = Arrays.copyOf(bArr, length + i10);
            b0Var.E(copyOf.length, copyOf);
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        wVar.readFully(b0Var.f8414a, bArr.length, i10);
        b0Var.G(0);
        b0Var.F(length);
    }

    public d(int i10) {
        b bVar = new b();
        this.f14146q = -1;
        this.f14147r = -9223372036854775807L;
        this.f14148s = -9223372036854775807L;
        this.f14149t = -9223372036854775807L;
        this.f14155z = -1;
        this.A = -1;
        this.B = -9223372036854775807L;
        this.f14128a = bVar;
        bVar.f14092d = new e.a(this);
        this.f14133d = true;
        this.f14130b = new f();
        this.f14132c = new SparseArray();
        this.f14136g = new b0(4);
        this.f14137h = new b0(ByteBuffer.allocate(4).putInt(-1).array());
        this.f14138i = new b0(4);
        this.f14134e = new b0(p0.f4278a);
        this.f14135f = new b0(4);
        this.f14139j = new b0();
        this.f14140k = new b0();
        this.f14141l = new b0(8);
        this.f14142m = new b0();
        this.f14143n = new b0();
        this.L = new int[1];
    }
}
