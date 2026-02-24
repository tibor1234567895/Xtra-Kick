package y4;

import android.graphics.Bitmap;
import android.util.Log;
import e5.c;
import e5.k;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import k5.a;

public final class e implements a {

    /* renamed from: a  reason: collision with root package name */
    public int[] f16944a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f16945b = new int[256];

    /* renamed from: c  reason: collision with root package name */
    public final a f16946c;

    /* renamed from: d  reason: collision with root package name */
    public ByteBuffer f16947d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f16948e;

    /* renamed from: f  reason: collision with root package name */
    public short[] f16949f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f16950g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f16951h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f16952i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f16953j;

    /* renamed from: k  reason: collision with root package name */
    public int f16954k;

    /* renamed from: l  reason: collision with root package name */
    public c f16955l;

    /* renamed from: m  reason: collision with root package name */
    public Bitmap f16956m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f16957n;

    /* renamed from: o  reason: collision with root package name */
    public int f16958o;

    /* renamed from: p  reason: collision with root package name */
    public int f16959p;

    /* renamed from: q  reason: collision with root package name */
    public int f16960q;

    /* renamed from: r  reason: collision with root package name */
    public int f16961r;

    /* renamed from: s  reason: collision with root package name */
    public Boolean f16962s;

    /* renamed from: t  reason: collision with root package name */
    public Bitmap.Config f16963t = Bitmap.Config.ARGB_8888;

    public e(a aVar, c cVar, ByteBuffer byteBuffer, int i10) {
        int[] iArr;
        this.f16946c = aVar;
        this.f16955l = new c();
        synchronized (this) {
            if (i10 > 0) {
                int highestOneBit = Integer.highestOneBit(i10);
                this.f16958o = 0;
                this.f16955l = cVar;
                this.f16954k = -1;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.f16947d = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.f16947d.order(ByteOrder.LITTLE_ENDIAN);
                this.f16957n = false;
                Iterator it = cVar.f16933e.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((b) it.next()).f16924g == 3) {
                            this.f16957n = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.f16959p = highestOneBit;
                int i11 = cVar.f16934f;
                this.f16961r = i11 / highestOneBit;
                int i12 = cVar.f16935g;
                this.f16960q = i12 / highestOneBit;
                this.f16952i = this.f16946c.h(i11 * i12);
                a aVar2 = this.f16946c;
                int i13 = this.f16961r * this.f16960q;
                Object obj = aVar2.f9125j;
                if (((k) obj) == null) {
                    iArr = new int[i13];
                } else {
                    iArr = (int[]) ((k) obj).d(i13, int[].class);
                }
                this.f16953j = iArr;
            } else {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i10);
            }
        }
    }

    public final int a() {
        return this.f16954k;
    }

    public final synchronized Bitmap b() {
        if (this.f16955l.f16931c <= 0 || this.f16954k < 0) {
            if (Log.isLoggable("e", 3)) {
                int i10 = this.f16955l.f16931c;
            }
            this.f16958o = 1;
        }
        int i11 = this.f16958o;
        if (i11 != 1) {
            if (i11 != 2) {
                this.f16958o = 0;
                if (this.f16948e == null) {
                    this.f16948e = this.f16946c.h(255);
                }
                b bVar = (b) this.f16955l.f16933e.get(this.f16954k);
                int i12 = this.f16954k - 1;
                b bVar2 = i12 >= 0 ? (b) this.f16955l.f16933e.get(i12) : null;
                int[] iArr = bVar.f16928k;
                if (iArr == null) {
                    iArr = this.f16955l.f16929a;
                }
                this.f16944a = iArr;
                if (iArr == null) {
                    Log.isLoggable("e", 3);
                    this.f16958o = 1;
                    return null;
                }
                if (bVar.f16923f) {
                    System.arraycopy(iArr, 0, this.f16945b, 0, iArr.length);
                    int[] iArr2 = this.f16945b;
                    this.f16944a = iArr2;
                    iArr2[bVar.f16925h] = 0;
                    if (bVar.f16924g == 2 && this.f16954k == 0) {
                        this.f16962s = Boolean.TRUE;
                    }
                }
                return i(bVar, bVar2);
            }
        }
        Log.isLoggable("e", 3);
        return null;
    }

    public final void c() {
        this.f16954k = (this.f16954k + 1) % this.f16955l.f16931c;
    }

    public final void clear() {
        k kVar;
        k kVar2;
        k kVar3;
        this.f16955l = null;
        byte[] bArr = this.f16952i;
        a aVar = this.f16946c;
        if (!(bArr == null || (kVar3 = (k) aVar.f9125j) == null)) {
            kVar3.h(bArr);
        }
        int[] iArr = this.f16953j;
        if (!(iArr == null || (kVar2 = (k) aVar.f9125j) == null)) {
            kVar2.h(iArr);
        }
        Bitmap bitmap = this.f16956m;
        if (bitmap != null) {
            ((c) aVar.f9124i).c(bitmap);
        }
        this.f16956m = null;
        this.f16947d = null;
        this.f16962s = null;
        byte[] bArr2 = this.f16948e;
        if (bArr2 != null && (kVar = (k) aVar.f9125j) != null) {
            kVar.h(bArr2);
        }
    }

    public final int d() {
        return this.f16955l.f16931c;
    }

    public final int e() {
        int i10;
        c cVar = this.f16955l;
        int i11 = cVar.f16931c;
        if (i11 <= 0 || (i10 = this.f16954k) < 0) {
            return 0;
        }
        if (i10 < 0 || i10 >= i11) {
            return -1;
        }
        return ((b) cVar.f16933e.get(i10)).f16926i;
    }

    public final int f() {
        return (this.f16953j.length * 4) + this.f16947d.limit() + this.f16952i.length;
    }

    public final Bitmap g() {
        Bitmap.Config config;
        Boolean bool = this.f16962s;
        if (bool == null || bool.booleanValue()) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = this.f16963t;
        }
        Bitmap d10 = ((c) this.f16946c.f9124i).d(this.f16961r, this.f16960q, config);
        d10.setHasAlpha(true);
        return d10;
    }

    public final ByteBuffer getData() {
        return this.f16947d;
    }

    public final void h(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.f16963t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v6, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        if (r3.f16938j == r1.f16925h) goto L_0x0047;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r5v30, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap i(y4.b r36, y4.b r37) {
        /*
            r35 = this;
            r0 = r35
            r1 = r36
            r2 = r37
            int[] r10 = r0.f16953j
            k5.a r11 = r0.f16946c
            r12 = 0
            if (r2 != 0) goto L_0x001e
            android.graphics.Bitmap r3 = r0.f16956m
            if (r3 == 0) goto L_0x0018
            java.lang.Object r4 = r11.f9124i
            e5.c r4 = (e5.c) r4
            r4.c(r3)
        L_0x0018:
            r3 = 0
            r0.f16956m = r3
            java.util.Arrays.fill(r10, r12)
        L_0x001e:
            r13 = 3
            if (r2 == 0) goto L_0x002c
            int r3 = r2.f16924g
            if (r3 != r13) goto L_0x002c
            android.graphics.Bitmap r3 = r0.f16956m
            if (r3 != 0) goto L_0x002c
            java.util.Arrays.fill(r10, r12)
        L_0x002c:
            r14 = 2
            if (r2 == 0) goto L_0x0080
            int r3 = r2.f16924g
            if (r3 <= 0) goto L_0x0080
            if (r3 != r14) goto L_0x006e
            boolean r3 = r1.f16923f
            if (r3 != 0) goto L_0x0047
            y4.c r3 = r0.f16955l
            int r4 = r3.f16939k
            int[] r5 = r1.f16928k
            if (r5 == 0) goto L_0x0048
            int r3 = r3.f16938j
            int r5 = r1.f16925h
            if (r3 != r5) goto L_0x0048
        L_0x0047:
            r4 = 0
        L_0x0048:
            int r3 = r2.f16921d
            int r5 = r0.f16959p
            int r3 = r3 / r5
            int r6 = r2.f16919b
            int r6 = r6 / r5
            int r7 = r2.f16920c
            int r7 = r7 / r5
            int r2 = r2.f16918a
            int r2 = r2 / r5
            int r5 = r0.f16961r
            int r6 = r6 * r5
            int r6 = r6 + r2
            int r3 = r3 * r5
            int r3 = r3 + r6
        L_0x005e:
            if (r6 >= r3) goto L_0x0080
            int r2 = r6 + r7
            r5 = r6
        L_0x0063:
            if (r5 >= r2) goto L_0x006a
            r10[r5] = r4
            int r5 = r5 + 1
            goto L_0x0063
        L_0x006a:
            int r2 = r0.f16961r
            int r6 = r6 + r2
            goto L_0x005e
        L_0x006e:
            if (r3 != r13) goto L_0x0080
            android.graphics.Bitmap r2 = r0.f16956m
            if (r2 == 0) goto L_0x0080
            r4 = 0
            int r8 = r0.f16961r
            r6 = 0
            r7 = 0
            int r9 = r0.f16960q
            r3 = r10
            r5 = r8
            r2.getPixels(r3, r4, r5, r6, r7, r8, r9)
        L_0x0080:
            java.nio.ByteBuffer r2 = r0.f16947d
            int r3 = r1.f16927j
            r2.position(r3)
            int r2 = r1.f16920c
            int r3 = r1.f16921d
            int r2 = r2 * r3
            byte[] r3 = r0.f16952i
            if (r3 == 0) goto L_0x0094
            int r3 = r3.length
            if (r3 >= r2) goto L_0x009a
        L_0x0094:
            byte[] r3 = r11.h(r2)
            r0.f16952i = r3
        L_0x009a:
            byte[] r3 = r0.f16952i
            short[] r4 = r0.f16949f
            r5 = 4096(0x1000, float:5.74E-42)
            if (r4 != 0) goto L_0x00a6
            short[] r4 = new short[r5]
            r0.f16949f = r4
        L_0x00a6:
            short[] r4 = r0.f16949f
            byte[] r6 = r0.f16950g
            if (r6 != 0) goto L_0x00b0
            byte[] r6 = new byte[r5]
            r0.f16950g = r6
        L_0x00b0:
            byte[] r6 = r0.f16950g
            byte[] r7 = r0.f16951h
            if (r7 != 0) goto L_0x00bc
            r7 = 4097(0x1001, float:5.741E-42)
            byte[] r7 = new byte[r7]
            r0.f16951h = r7
        L_0x00bc:
            byte[] r7 = r0.f16951h
            java.nio.ByteBuffer r8 = r0.f16947d
            byte r8 = r8.get()
            r8 = r8 & 255(0xff, float:3.57E-43)
            r9 = 1
            int r11 = r9 << r8
            int r15 = r11 + 1
            int r16 = r11 + 2
            int r8 = r8 + r9
            int r17 = r9 << r8
            r14 = -1
            int r17 = r17 + -1
            r5 = 0
        L_0x00d4:
            if (r5 >= r11) goto L_0x00df
            r4[r5] = r12
            byte r14 = (byte) r5
            r6[r5] = r14
            int r5 = r5 + 1
            r14 = -1
            goto L_0x00d4
        L_0x00df:
            byte[] r5 = r0.f16948e
            r13 = r0
            r25 = r8
            r24 = r16
            r28 = r17
            r9 = 0
            r14 = -1
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r26 = 0
            r27 = 0
            r29 = 0
        L_0x00f8:
            r30 = 8
            if (r9 >= r2) goto L_0x01f1
            if (r20 != 0) goto L_0x0133
            java.nio.ByteBuffer r12 = r0.f16947d
            byte r12 = r12.get()
            r12 = r12 & 255(0xff, float:3.57E-43)
            r31 = r8
            if (r12 > 0) goto L_0x0111
            r32 = r9
            r34 = r10
            r33 = r14
            goto L_0x0127
        L_0x0111:
            java.nio.ByteBuffer r8 = r13.f16947d
            r32 = r9
            byte[] r9 = r13.f16948e
            r33 = r14
            int r14 = r8.remaining()
            int r14 = java.lang.Math.min(r12, r14)
            r34 = r10
            r10 = 0
            r8.get(r9, r10, r14)
        L_0x0127:
            if (r12 > 0) goto L_0x012e
            r8 = 3
            r13.f16958o = r8
            goto L_0x01f3
        L_0x012e:
            r20 = r12
            r21 = 0
            goto L_0x013b
        L_0x0133:
            r31 = r8
            r32 = r9
            r34 = r10
            r33 = r14
        L_0x013b:
            byte r8 = r5[r21]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r8 = r8 << r22
            int r23 = r23 + r8
            int r22 = r22 + 8
            r8 = 1
            int r21 = r21 + 1
            r8 = -1
            int r20 = r20 + -1
            r10 = r22
            r12 = r24
            r8 = r25
            r9 = r32
            r14 = r33
            r22 = r5
            r5 = r26
        L_0x0159:
            if (r10 < r8) goto L_0x01db
            r24 = r13
            r13 = r23 & r28
            int r23 = r23 >> r8
            int r10 = r10 - r8
            if (r13 != r11) goto L_0x0175
            r25 = r10
            r12 = r16
            r28 = r17
            r13 = r24
            r8 = r31
            r14 = -1
            r24 = r5
            r5 = 4096(0x1000, float:5.74E-42)
            goto L_0x01d5
        L_0x0175:
            if (r13 != r15) goto L_0x017f
            r13 = r24
            r24 = r5
            r5 = 4096(0x1000, float:5.74E-42)
            goto L_0x01e0
        L_0x017f:
            r25 = r10
            r10 = -1
            if (r14 != r10) goto L_0x0191
            byte r5 = r6[r13]
            r3[r27] = r5
            int r27 = r27 + 1
            int r9 = r9 + 1
            r24 = r13
            r5 = 4096(0x1000, float:5.74E-42)
            goto L_0x01d3
        L_0x0191:
            if (r13 < r12) goto L_0x019a
            byte r5 = (byte) r5
            r7[r29] = r5
            int r29 = r29 + 1
            r5 = r14
            goto L_0x019b
        L_0x019a:
            r5 = r13
        L_0x019b:
            if (r5 < r11) goto L_0x01a6
            byte r10 = r6[r5]
            r7[r29] = r10
            int r29 = r29 + 1
            short r5 = r4[r5]
            goto L_0x019b
        L_0x01a6:
            byte r5 = r6[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r10 = (byte) r5
            r3[r27] = r10
        L_0x01ad:
            r19 = 1
            int r27 = r27 + 1
            int r9 = r9 + 1
            if (r29 <= 0) goto L_0x01bc
            int r29 = r29 + -1
            byte r24 = r7[r29]
            r3[r27] = r24
            goto L_0x01ad
        L_0x01bc:
            r24 = r5
            r5 = 4096(0x1000, float:5.74E-42)
            if (r12 >= r5) goto L_0x01d3
            short r14 = (short) r14
            r4[r12] = r14
            r6[r12] = r10
            int r12 = r12 + 1
            r10 = r12 & r28
            if (r10 != 0) goto L_0x01d3
            if (r12 >= r5) goto L_0x01d3
            int r8 = r8 + 1
            int r28 = r28 + r12
        L_0x01d3:
            r14 = r13
            r13 = r0
        L_0x01d5:
            r5 = r24
            r10 = r25
            goto L_0x0159
        L_0x01db:
            r24 = r5
            r5 = 4096(0x1000, float:5.74E-42)
            r13 = r0
        L_0x01e0:
            r25 = r8
            r5 = r22
            r26 = r24
            r8 = r31
            r22 = r10
            r24 = r12
            r10 = r34
            r12 = 0
            goto L_0x00f8
        L_0x01f1:
            r34 = r10
        L_0x01f3:
            r12 = r27
            r10 = 0
            java.util.Arrays.fill(r3, r12, r2, r10)
            boolean r2 = r1.f16922e
            if (r2 != 0) goto L_0x0270
            int r2 = r0.f16959p
            r3 = 1
            if (r2 == r3) goto L_0x0204
            goto L_0x0270
        L_0x0204:
            int[] r2 = r0.f16953j
            int r3 = r1.f16921d
            int r4 = r1.f16919b
            int r5 = r1.f16920c
            int r6 = r1.f16918a
            int r7 = r0.f16954k
            if (r7 != 0) goto L_0x0214
            r7 = 1
            goto L_0x0215
        L_0x0214:
            r7 = 0
        L_0x0215:
            int r8 = r0.f16961r
            byte[] r9 = r0.f16952i
            int[] r11 = r0.f16944a
            r12 = -1
            r13 = 0
        L_0x021d:
            if (r13 >= r3) goto L_0x0252
            int r14 = r13 + r4
            int r14 = r14 * r8
            int r15 = r14 + r6
            int r10 = r15 + r5
            int r14 = r14 + r8
            if (r14 >= r10) goto L_0x022b
            r10 = r14
        L_0x022b:
            int r14 = r1.f16920c
            int r14 = r14 * r13
        L_0x022f:
            r16 = r3
            if (r15 >= r10) goto L_0x024c
            byte r3 = r9[r14]
            r17 = r4
            r4 = r3 & 255(0xff, float:3.57E-43)
            if (r4 == r12) goto L_0x0243
            r4 = r11[r4]
            if (r4 == 0) goto L_0x0242
            r2[r15] = r4
            goto L_0x0243
        L_0x0242:
            r12 = r3
        L_0x0243:
            int r14 = r14 + 1
            int r15 = r15 + 1
            r3 = r16
            r4 = r17
            goto L_0x022f
        L_0x024c:
            r17 = r4
            int r13 = r13 + 1
            r10 = 0
            goto L_0x021d
        L_0x0252:
            java.lang.Boolean r2 = r0.f16962s
            if (r2 == 0) goto L_0x025c
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0265
        L_0x025c:
            java.lang.Boolean r2 = r0.f16962s
            if (r2 != 0) goto L_0x0267
            if (r7 == 0) goto L_0x0267
            r2 = -1
            if (r12 == r2) goto L_0x0267
        L_0x0265:
            r12 = 1
            goto L_0x0268
        L_0x0267:
            r12 = 0
        L_0x0268:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r12)
            r0.f16962s = r2
            goto L_0x03fc
        L_0x0270:
            int[] r2 = r0.f16953j
            int r3 = r1.f16921d
            int r4 = r0.f16959p
            int r3 = r3 / r4
            int r5 = r1.f16919b
            int r5 = r5 / r4
            int r6 = r1.f16920c
            int r6 = r6 / r4
            int r7 = r1.f16918a
            int r7 = r7 / r4
            int r8 = r0.f16954k
            if (r8 != 0) goto L_0x0286
            r10 = 1
            goto L_0x0287
        L_0x0286:
            r10 = 0
        L_0x0287:
            int r8 = r0.f16961r
            int r9 = r0.f16960q
            byte[] r11 = r0.f16952i
            int[] r12 = r0.f16944a
            java.lang.Boolean r13 = r0.f16962s
            r14 = r13
            r13 = 0
            r15 = 0
            r16 = 1
            r17 = 8
        L_0x0298:
            r37 = r14
            if (r13 >= r3) goto L_0x03ea
            boolean r14 = r1.f16922e
            if (r14 == 0) goto L_0x02c7
            if (r15 < r3) goto L_0x02c2
            int r14 = r16 + 1
            r18 = r3
            r3 = 2
            if (r14 == r3) goto L_0x02bd
            r3 = 3
            if (r14 == r3) goto L_0x02b6
            r3 = 4
            r16 = r14
            if (r14 == r3) goto L_0x02b2
            goto L_0x02c4
        L_0x02b2:
            r15 = 1
            r17 = 2
            goto L_0x02c4
        L_0x02b6:
            r3 = 4
            r16 = r14
            r15 = 2
            r17 = 4
            goto L_0x02c4
        L_0x02bd:
            r3 = 4
            r16 = r14
            r15 = 4
            goto L_0x02c4
        L_0x02c2:
            r18 = r3
        L_0x02c4:
            int r3 = r15 + r17
            goto L_0x02cb
        L_0x02c7:
            r18 = r3
            r3 = r15
            r15 = r13
        L_0x02cb:
            int r15 = r15 + r5
            r14 = 1
            if (r4 != r14) goto L_0x02d1
            r14 = 1
            goto L_0x02d2
        L_0x02d1:
            r14 = 0
        L_0x02d2:
            if (r15 >= r9) goto L_0x03ca
            int r15 = r15 * r8
            int r20 = r15 + r7
            r21 = r3
            int r3 = r20 + r6
            int r15 = r15 + r8
            if (r15 >= r3) goto L_0x02e0
            r3 = r15
        L_0x02e0:
            int r15 = r13 * r4
            r22 = r5
            int r5 = r1.f16920c
            int r15 = r15 * r5
            if (r14 == 0) goto L_0x030a
            r14 = r37
            r5 = r20
        L_0x02ee:
            r23 = r6
            if (r5 >= r3) goto L_0x03c3
            byte r6 = r11[r15]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r6 = r12[r6]
            if (r6 == 0) goto L_0x02fd
            r2[r5] = r6
            goto L_0x0304
        L_0x02fd:
            if (r10 == 0) goto L_0x0304
            if (r14 != 0) goto L_0x0304
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r14 = r6
        L_0x0304:
            int r15 = r15 + r4
            int r5 = r5 + 1
            r6 = r23
            goto L_0x02ee
        L_0x030a:
            r23 = r6
            int r5 = r3 - r20
            int r5 = r5 * r4
            int r5 = r5 + r15
            r14 = r37
            r6 = r20
        L_0x0315:
            if (r6 >= r3) goto L_0x03c3
            r20 = r3
            int r3 = r1.f16920c
            r29 = r7
            r31 = r8
            r7 = r15
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
        L_0x032a:
            int r8 = r0.f16959p
            int r8 = r8 + r15
            if (r7 >= r8) goto L_0x035f
            byte[] r8 = r0.f16952i
            r32 = r9
            int r9 = r8.length
            if (r7 >= r9) goto L_0x0361
            if (r7 >= r5) goto L_0x0361
            byte r8 = r8[r7]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int[] r9 = r0.f16944a
            r8 = r9[r8]
            if (r8 == 0) goto L_0x035a
            int r9 = r8 >> 24
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r24 = r24 + r9
            int r9 = r8 >> 16
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r25 = r25 + r9
            int r9 = r8 >> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r26 = r26 + r9
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r27 = r27 + r8
            int r28 = r28 + 1
        L_0x035a:
            int r7 = r7 + 1
            r9 = r32
            goto L_0x032a
        L_0x035f:
            r32 = r9
        L_0x0361:
            int r3 = r3 + r15
            r7 = r3
        L_0x0363:
            int r8 = r0.f16959p
            int r8 = r8 + r3
            if (r7 >= r8) goto L_0x0394
            byte[] r8 = r0.f16952i
            int r9 = r8.length
            if (r7 >= r9) goto L_0x0394
            if (r7 >= r5) goto L_0x0394
            byte r8 = r8[r7]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int[] r9 = r0.f16944a
            r8 = r9[r8]
            if (r8 == 0) goto L_0x0391
            int r9 = r8 >> 24
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r24 = r24 + r9
            int r9 = r8 >> 16
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r25 = r25 + r9
            int r9 = r8 >> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r26 = r26 + r9
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r27 = r27 + r8
            int r28 = r28 + 1
        L_0x0391:
            int r7 = r7 + 1
            goto L_0x0363
        L_0x0394:
            if (r28 != 0) goto L_0x0398
            r3 = 0
            goto L_0x03aa
        L_0x0398:
            int r24 = r24 / r28
            int r3 = r24 << 24
            int r25 = r25 / r28
            int r7 = r25 << 16
            r3 = r3 | r7
            int r26 = r26 / r28
            int r7 = r26 << 8
            r3 = r3 | r7
            int r27 = r27 / r28
            r3 = r3 | r27
        L_0x03aa:
            if (r3 == 0) goto L_0x03af
            r2[r6] = r3
            goto L_0x03b6
        L_0x03af:
            if (r10 == 0) goto L_0x03b6
            if (r14 != 0) goto L_0x03b6
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r14 = r3
        L_0x03b6:
            int r15 = r15 + r4
            int r6 = r6 + 1
            r3 = r20
            r7 = r29
            r8 = r31
            r9 = r32
            goto L_0x0315
        L_0x03c3:
            r29 = r7
            r31 = r8
            r32 = r9
            goto L_0x03d8
        L_0x03ca:
            r21 = r3
            r22 = r5
            r23 = r6
            r29 = r7
            r31 = r8
            r32 = r9
            r14 = r37
        L_0x03d8:
            int r13 = r13 + 1
            r3 = r18
            r15 = r21
            r5 = r22
            r6 = r23
            r7 = r29
            r8 = r31
            r9 = r32
            goto L_0x0298
        L_0x03ea:
            java.lang.Boolean r2 = r0.f16962s
            if (r2 != 0) goto L_0x03fc
            if (r37 != 0) goto L_0x03f2
            r12 = 0
            goto L_0x03f6
        L_0x03f2:
            boolean r12 = r37.booleanValue()
        L_0x03f6:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r12)
            r0.f16962s = r2
        L_0x03fc:
            boolean r2 = r0.f16957n
            if (r2 == 0) goto L_0x0420
            int r1 = r1.f16924g
            if (r1 == 0) goto L_0x0407
            r2 = 1
            if (r1 != r2) goto L_0x0420
        L_0x0407:
            android.graphics.Bitmap r1 = r0.f16956m
            if (r1 != 0) goto L_0x0411
            android.graphics.Bitmap r1 = r35.g()
            r0.f16956m = r1
        L_0x0411:
            android.graphics.Bitmap r1 = r0.f16956m
            r3 = 0
            int r7 = r0.f16961r
            r5 = 0
            r6 = 0
            int r8 = r0.f16960q
            r2 = r34
            r4 = r7
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)
        L_0x0420:
            android.graphics.Bitmap r9 = r35.g()
            r3 = 0
            int r7 = r0.f16961r
            r5 = 0
            r6 = 0
            int r8 = r0.f16960q
            r1 = r9
            r2 = r34
            r4 = r7
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.e.i(y4.b, y4.b):android.graphics.Bitmap");
    }
}
