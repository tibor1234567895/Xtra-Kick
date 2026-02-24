package x2;

import androidx.recyclerview.widget.RecyclerView;
import i1.b;
import j1.b0;
import j1.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c extends i {
    public static final int[] A = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    public static final int[] B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    public static final int[] C = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    public static final int[] D = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    public static final int[] E = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    public static final boolean[] F = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* renamed from: y  reason: collision with root package name */
    public static final int[] f16576y = {11, 1, 3, 12, 14, 5, 7, 9};

    /* renamed from: z  reason: collision with root package name */
    public static final int[] f16577z = {0, 4, 8, 12, 16, 20, 24, 28};

    /* renamed from: g  reason: collision with root package name */
    public final b0 f16578g = new b0();

    /* renamed from: h  reason: collision with root package name */
    public final int f16579h;

    /* renamed from: i  reason: collision with root package name */
    public final int f16580i;

    /* renamed from: j  reason: collision with root package name */
    public final int f16581j;

    /* renamed from: k  reason: collision with root package name */
    public final long f16582k = 16000000;

    /* renamed from: l  reason: collision with root package name */
    public final ArrayList f16583l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    public b f16584m = new b(0, 4);

    /* renamed from: n  reason: collision with root package name */
    public List f16585n;

    /* renamed from: o  reason: collision with root package name */
    public List f16586o;

    /* renamed from: p  reason: collision with root package name */
    public int f16587p;

    /* renamed from: q  reason: collision with root package name */
    public int f16588q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f16589r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f16590s;

    /* renamed from: t  reason: collision with root package name */
    public byte f16591t;

    /* renamed from: u  reason: collision with root package name */
    public byte f16592u;

    /* renamed from: v  reason: collision with root package name */
    public int f16593v = 0;

    /* renamed from: w  reason: collision with root package name */
    public boolean f16594w;

    /* renamed from: x  reason: collision with root package name */
    public long f16595x;

    public c(int i10, String str) {
        this.f16579h = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    this.f16581j = 0;
                } else if (i10 != 4) {
                    v.g("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
                } else {
                    this.f16581j = 1;
                }
                this.f16580i = 1;
                l(0);
                k();
                this.f16594w = true;
                this.f16595x = -9223372036854775807L;
            }
            this.f16581j = 1;
            this.f16580i = 0;
            l(0);
            k();
            this.f16594w = true;
            this.f16595x = -9223372036854775807L;
        }
        this.f16581j = 0;
        this.f16580i = 0;
        l(0);
        k();
        this.f16594w = true;
        this.f16595x = -9223372036854775807L;
    }

    public final void a() {
    }

    public final j f() {
        List list = this.f16585n;
        this.f16586o = list;
        list.getClass();
        return new j(list, 0);
    }

    public final void flush() {
        super.flush();
        this.f16585n = null;
        this.f16586o = null;
        l(0);
        this.f16588q = 4;
        this.f16584m.f16575h = 4;
        k();
        this.f16589r = false;
        this.f16590s = false;
        this.f16591t = 0;
        this.f16592u = 0;
        this.f16593v = 0;
        this.f16594w = true;
        this.f16595x = -9223372036854775807L;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x026d, code lost:
        if (r0 != 3) goto L_0x02a0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0014 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0014 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(x2.g r15) {
        /*
            r14 = this;
            java.nio.ByteBuffer r15 = r15.f9515j
            r15.getClass()
            byte[] r0 = r15.array()
            int r15 = r15.limit()
            j1.b0 r1 = r14.f16578g
            r1.E(r15, r0)
            r15 = 0
            r0 = 0
        L_0x0014:
            int r2 = r1.f8416c
            int r3 = r1.f8415b
            int r2 = r2 - r3
            r3 = 3
            r4 = 1
            int r5 = r14.f16579h
            if (r2 < r5) goto L_0x02a3
            r2 = 2
            if (r5 != r2) goto L_0x0024
            r5 = -4
            goto L_0x0028
        L_0x0024:
            int r5 = r1.v()
        L_0x0028:
            int r6 = r1.v()
            int r7 = r1.v()
            r8 = r5 & 2
            if (r8 == 0) goto L_0x0035
            goto L_0x0014
        L_0x0035:
            r8 = r5 & 1
            int r9 = r14.f16580i
            if (r8 == r9) goto L_0x003c
            goto L_0x0014
        L_0x003c:
            r8 = r6 & 127(0x7f, float:1.78E-43)
            byte r8 = (byte) r8
            r9 = r7 & 127(0x7f, float:1.78E-43)
            byte r9 = (byte) r9
            if (r8 != 0) goto L_0x0047
            if (r9 != 0) goto L_0x0047
            goto L_0x0014
        L_0x0047:
            boolean r10 = r14.f16589r
            r5 = r5 & 4
            r11 = 4
            if (r5 != r11) goto L_0x005a
            boolean[] r5 = F
            boolean r6 = r5[r6]
            if (r6 == 0) goto L_0x005a
            boolean r5 = r5[r7]
            if (r5 == 0) goto L_0x005a
            r5 = 1
            goto L_0x005b
        L_0x005a:
            r5 = 0
        L_0x005b:
            r14.f16589r = r5
            r6 = 16
            if (r5 == 0) goto L_0x0081
            r7 = r8 & 240(0xf0, float:3.36E-43)
            if (r7 != r6) goto L_0x0067
            r7 = 1
            goto L_0x0068
        L_0x0067:
            r7 = 0
        L_0x0068:
            if (r7 == 0) goto L_0x0081
            boolean r7 = r14.f16590s
            if (r7 == 0) goto L_0x007a
            byte r7 = r14.f16591t
            if (r7 != r8) goto L_0x007a
            byte r7 = r14.f16592u
            if (r7 != r9) goto L_0x007a
            r14.f16590s = r15
            r7 = 1
            goto L_0x0084
        L_0x007a:
            r14.f16590s = r4
            r14.f16591t = r8
            r14.f16592u = r9
            goto L_0x0083
        L_0x0081:
            r14.f16590s = r15
        L_0x0083:
            r7 = 0
        L_0x0084:
            if (r7 == 0) goto L_0x0087
            goto L_0x0014
        L_0x0087:
            if (r5 != 0) goto L_0x0090
            if (r10 == 0) goto L_0x0014
            r14.k()
            goto L_0x02a0
        L_0x0090:
            if (r4 > r8) goto L_0x0098
            r5 = 15
            if (r8 > r5) goto L_0x0098
            r5 = 1
            goto L_0x0099
        L_0x0098:
            r5 = 0
        L_0x0099:
            r7 = 32
            r10 = 20
            if (r5 == 0) goto L_0x00a0
            goto L_0x00b6
        L_0x00a0:
            r5 = r8 & 246(0xf6, float:3.45E-43)
            if (r5 != r10) goto L_0x00a6
            r5 = 1
            goto L_0x00a7
        L_0x00a6:
            r5 = 0
        L_0x00a7:
            if (r5 == 0) goto L_0x00bb
            if (r9 == r7) goto L_0x00b9
            r5 = 47
            if (r9 == r5) goto L_0x00b9
            switch(r9) {
                case 37: goto L_0x00b9;
                case 38: goto L_0x00b9;
                case 39: goto L_0x00b9;
                default: goto L_0x00b2;
            }
        L_0x00b2:
            switch(r9) {
                case 41: goto L_0x00b9;
                case 42: goto L_0x00b6;
                case 43: goto L_0x00b6;
                default: goto L_0x00b5;
            }
        L_0x00b5:
            goto L_0x00bb
        L_0x00b6:
            r14.f16594w = r15
            goto L_0x00bb
        L_0x00b9:
            r14.f16594w = r4
        L_0x00bb:
            boolean r5 = r14.f16594w
            if (r5 != 0) goto L_0x00c1
            goto L_0x0014
        L_0x00c1:
            r5 = r8 & 224(0xe0, float:3.14E-43)
            if (r5 != 0) goto L_0x00c7
            r12 = 1
            goto L_0x00c8
        L_0x00c7:
            r12 = 0
        L_0x00c8:
            if (r12 == 0) goto L_0x00cf
            int r12 = r8 >> 3
            r12 = r12 & r4
            r14.f16593v = r12
        L_0x00cf:
            int r12 = r14.f16593v
            int r13 = r14.f16581j
            if (r12 != r13) goto L_0x00d7
            r12 = 1
            goto L_0x00d8
        L_0x00d7:
            r12 = 0
        L_0x00d8:
            if (r12 != 0) goto L_0x00dc
            goto L_0x0014
        L_0x00dc:
            if (r5 != 0) goto L_0x00e0
            r0 = 1
            goto L_0x00e1
        L_0x00e0:
            r0 = 0
        L_0x00e1:
            if (r0 == 0) goto L_0x0281
            r0 = r8 & 247(0xf7, float:3.46E-43)
            r5 = 17
            if (r0 != r5) goto L_0x00f1
            r12 = r9 & 240(0xf0, float:3.36E-43)
            r13 = 48
            if (r12 != r13) goto L_0x00f1
            r12 = 1
            goto L_0x00f2
        L_0x00f1:
            r12 = 0
        L_0x00f2:
            if (r12 == 0) goto L_0x00fd
            x2.b r0 = r14.f16584m
            r2 = r9 & 15
            int[] r3 = C
            r2 = r3[r2]
            goto L_0x0124
        L_0x00fd:
            r12 = r8 & 246(0xf6, float:3.45E-43)
            r13 = 18
            if (r12 != r13) goto L_0x0109
            r13 = r9 & 224(0xe0, float:3.14E-43)
            if (r13 != r7) goto L_0x0109
            r13 = 1
            goto L_0x010a
        L_0x0109:
            r13 = 0
        L_0x010a:
            if (r13 == 0) goto L_0x0127
            x2.b r0 = r14.f16584m
            r0.b()
            x2.b r0 = r14.f16584m
            r2 = r8 & 1
            if (r2 != 0) goto L_0x011e
            r2 = r9 & 31
            int[] r3 = D
            r2 = r3[r2]
            goto L_0x0124
        L_0x011e:
            r2 = r9 & 31
            int[] r3 = E
            r2 = r3[r2]
        L_0x0124:
            char r2 = (char) r2
            goto L_0x029d
        L_0x0127:
            if (r0 != r5) goto L_0x012f
            r5 = r9 & 240(0xf0, float:3.36E-43)
            if (r5 != r7) goto L_0x012f
            r5 = 1
            goto L_0x0130
        L_0x012f:
            r5 = 0
        L_0x0130:
            if (r5 == 0) goto L_0x0156
            x2.b r0 = r14.f16584m
            r0.a(r7)
            r0 = r9 & 1
            if (r0 != r4) goto L_0x013d
            r0 = 1
            goto L_0x013e
        L_0x013d:
            r0 = 0
        L_0x013e:
            int r2 = r9 >> 1
            r2 = r2 & 7
            x2.b r3 = r14.f16584m
            java.util.ArrayList r5 = r3.f16568a
            x2.a r6 = new x2.a
            java.lang.StringBuilder r3 = r3.f16570c
            int r3 = r3.length()
            r6.<init>(r2, r3, r0)
            r5.add(r6)
            goto L_0x02a0
        L_0x0156:
            r5 = r8 & 240(0xf0, float:3.36E-43)
            if (r5 != r6) goto L_0x0162
            r5 = r9 & 192(0xc0, float:2.69E-43)
            r13 = 64
            if (r5 != r13) goto L_0x0162
            r5 = 1
            goto L_0x0163
        L_0x0162:
            r5 = 0
        L_0x0163:
            if (r5 == 0) goto L_0x01d0
            int[] r0 = f16576y
            r2 = r8 & 7
            r0 = r0[r2]
            r2 = r9 & 32
            if (r2 == 0) goto L_0x0171
            r2 = 1
            goto L_0x0172
        L_0x0171:
            r2 = 0
        L_0x0172:
            if (r2 == 0) goto L_0x0176
            int r0 = r0 + 1
        L_0x0176:
            x2.b r2 = r14.f16584m
            int r3 = r2.f16571d
            if (r0 == r3) goto L_0x019a
            int r3 = r14.f16587p
            if (r3 == r4) goto L_0x0196
            boolean r2 = r2.e()
            if (r2 != 0) goto L_0x0196
            x2.b r2 = new x2.b
            int r3 = r14.f16587p
            int r5 = r14.f16588q
            r2.<init>(r3, r5)
            r14.f16584m = r2
            java.util.ArrayList r3 = r14.f16583l
            r3.add(r2)
        L_0x0196:
            x2.b r2 = r14.f16584m
            r2.f16571d = r0
        L_0x019a:
            r0 = r9 & 16
            if (r0 != r6) goto L_0x01a0
            r0 = 1
            goto L_0x01a1
        L_0x01a0:
            r0 = 0
        L_0x01a1:
            r2 = r9 & 1
            if (r2 != r4) goto L_0x01a7
            r2 = 1
            goto L_0x01a8
        L_0x01a7:
            r2 = 0
        L_0x01a8:
            int r3 = r9 >> 1
            r3 = r3 & 7
            x2.b r5 = r14.f16584m
            if (r0 == 0) goto L_0x01b3
            r6 = 8
            goto L_0x01b4
        L_0x01b3:
            r6 = r3
        L_0x01b4:
            java.util.ArrayList r7 = r5.f16568a
            x2.a r8 = new x2.a
            java.lang.StringBuilder r5 = r5.f16570c
            int r5 = r5.length()
            r8.<init>(r6, r5, r2)
            r7.add(r8)
            if (r0 == 0) goto L_0x02a0
            x2.b r0 = r14.f16584m
            int[] r2 = f16577z
            r2 = r2[r3]
            r0.f16572e = r2
            goto L_0x02a0
        L_0x01d0:
            r5 = 23
            r6 = 33
            if (r0 != r5) goto L_0x01de
            if (r9 < r6) goto L_0x01de
            r0 = 35
            if (r9 > r0) goto L_0x01de
            r0 = 1
            goto L_0x01df
        L_0x01de:
            r0 = 0
        L_0x01df:
            if (r0 == 0) goto L_0x01e9
            x2.b r0 = r14.f16584m
            int r9 = r9 + -32
            r0.f16573f = r9
            goto L_0x02a0
        L_0x01e9:
            if (r12 != r10) goto L_0x01f1
            r0 = r9 & 240(0xf0, float:3.36E-43)
            if (r0 != r7) goto L_0x01f1
            r0 = 1
            goto L_0x01f2
        L_0x01f1:
            r0 = 0
        L_0x01f2:
            if (r0 == 0) goto L_0x02a0
            if (r9 == r7) goto L_0x027d
            r0 = 41
            if (r9 == r0) goto L_0x0279
            switch(r9) {
                case 37: goto L_0x0219;
                case 38: goto L_0x020e;
                case 39: goto L_0x0203;
                default: goto L_0x01fd;
            }
        L_0x01fd:
            int r0 = r14.f16587p
            if (r0 != 0) goto L_0x0224
            goto L_0x02a0
        L_0x0203:
            r14.l(r4)
            r14.f16588q = r11
            x2.b r0 = r14.f16584m
            r0.f16575h = r11
            goto L_0x02a0
        L_0x020e:
            r14.l(r4)
            r14.f16588q = r3
            x2.b r0 = r14.f16584m
            r0.f16575h = r3
            goto L_0x02a0
        L_0x0219:
            r14.l(r4)
            r14.f16588q = r2
            x2.b r0 = r14.f16584m
            r0.f16575h = r2
            goto L_0x02a0
        L_0x0224:
            if (r9 == r6) goto L_0x0273
            switch(r9) {
                case 44: goto L_0x0263;
                case 45: goto L_0x0232;
                case 46: goto L_0x026f;
                case 47: goto L_0x022b;
                default: goto L_0x0229;
            }
        L_0x0229:
            goto L_0x02a0
        L_0x022b:
            java.util.List r0 = r14.j()
            r14.f16585n = r0
            goto L_0x026f
        L_0x0232:
            if (r0 != r4) goto L_0x02a0
            x2.b r0 = r14.f16584m
            boolean r0 = r0.e()
            if (r0 != 0) goto L_0x02a0
            x2.b r0 = r14.f16584m
            java.util.ArrayList r2 = r0.f16569b
            android.text.SpannableString r3 = r0.d()
            r2.add(r3)
            java.lang.StringBuilder r3 = r0.f16570c
            r3.setLength(r15)
            java.util.ArrayList r3 = r0.f16568a
            r3.clear()
            int r3 = r0.f16575h
            int r0 = r0.f16571d
            int r0 = java.lang.Math.min(r3, r0)
        L_0x0259:
            int r3 = r2.size()
            if (r3 < r0) goto L_0x02a0
            r2.remove(r15)
            goto L_0x0259
        L_0x0263:
            java.util.List r0 = java.util.Collections.emptyList()
            r14.f16585n = r0
            int r0 = r14.f16587p
            if (r0 == r4) goto L_0x026f
            if (r0 != r3) goto L_0x02a0
        L_0x026f:
            r14.k()
            goto L_0x02a0
        L_0x0273:
            x2.b r0 = r14.f16584m
            r0.b()
            goto L_0x02a0
        L_0x0279:
            r14.l(r3)
            goto L_0x02a0
        L_0x027d:
            r14.l(r2)
            goto L_0x02a0
        L_0x0281:
            x2.b r0 = r14.f16584m
            r2 = r8 & 127(0x7f, float:1.78E-43)
            int r2 = r2 + -32
            int[] r3 = B
            r2 = r3[r2]
            char r2 = (char) r2
            r0.a(r2)
            r0 = r9 & 224(0xe0, float:3.14E-43)
            if (r0 == 0) goto L_0x02a0
            x2.b r0 = r14.f16584m
            r2 = r9 & 127(0x7f, float:1.78E-43)
            int r2 = r2 + -32
            r2 = r3[r2]
            goto L_0x0124
        L_0x029d:
            r0.a(r2)
        L_0x02a0:
            r0 = 1
            goto L_0x0014
        L_0x02a3:
            if (r0 == 0) goto L_0x02b5
            int r15 = r14.f16587p
            if (r15 == r4) goto L_0x02ab
            if (r15 != r3) goto L_0x02b5
        L_0x02ab:
            java.util.List r15 = r14.j()
            r14.f16585n = r15
            long r0 = r14.f16641e
            r14.f16595x = r0
        L_0x02b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.c.g(x2.g):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final w2.i d() {
        /*
            r9 = this;
            w2.i r0 = super.d()
            if (r0 == 0) goto L_0x0007
            return r0
        L_0x0007:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r2 = r9.f16582k
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 == 0) goto L_0x0022
            long r4 = r9.f16595x
            int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r6 != 0) goto L_0x0019
            goto L_0x0022
        L_0x0019:
            long r6 = r9.f16641e
            long r6 = r6 - r4
            int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x0022
            r2 = 1
            goto L_0x0023
        L_0x0022:
            r2 = 0
        L_0x0023:
            if (r2 == 0) goto L_0x0047
            java.util.ArrayDeque r2 = r9.f16638b
            java.lang.Object r2 = r2.pollFirst()
            w2.i r2 = (w2.i) r2
            if (r2 == 0) goto L_0x0047
            java.util.List r3 = java.util.Collections.emptyList()
            r9.f16585n = r3
            r9.f16595x = r0
            x2.j r6 = r9.f()
            long r4 = r9.f16641e
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r3 = r2
            r3.i(r4, r6, r7)
            return r2
        L_0x0047:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.c.d():w2.i");
    }

    public final boolean i() {
        return this.f16585n != this.f16586o;
    }

    public final List j() {
        ArrayList arrayList = this.f16583l;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        int i10 = 2;
        for (int i11 = 0; i11 < size; i11++) {
            b c10 = ((b) arrayList.get(i11)).c(RecyclerView.UNDEFINED_DURATION);
            arrayList2.add(c10);
            if (c10 != null) {
                i10 = Math.min(i10, c10.f7980p);
            }
        }
        ArrayList arrayList3 = new ArrayList(size);
        for (int i12 = 0; i12 < size; i12++) {
            b bVar = (b) arrayList2.get(i12);
            if (bVar != null) {
                if (bVar.f7980p != i10) {
                    bVar = ((b) arrayList.get(i12)).c(i10);
                    bVar.getClass();
                }
                arrayList3.add(bVar);
            }
        }
        return arrayList3;
    }

    public final void k() {
        b bVar = this.f16584m;
        bVar.f16574g = this.f16587p;
        bVar.f16568a.clear();
        bVar.f16569b.clear();
        bVar.f16570c.setLength(0);
        bVar.f16571d = 15;
        bVar.f16572e = 0;
        bVar.f16573f = 0;
        ArrayList arrayList = this.f16583l;
        arrayList.clear();
        arrayList.add(this.f16584m);
    }

    public final void l(int i10) {
        int i11 = this.f16587p;
        if (i11 != i10) {
            this.f16587p = i10;
            if (i10 == 3) {
                int i12 = 0;
                while (true) {
                    ArrayList arrayList = this.f16583l;
                    if (i12 < arrayList.size()) {
                        ((b) arrayList.get(i12)).f16574g = i10;
                        i12++;
                    } else {
                        return;
                    }
                }
            } else {
                k();
                if (i11 == 3 || i10 == 1 || i10 == 0) {
                    this.f16585n = Collections.emptyList();
                }
            }
        }
    }
}
