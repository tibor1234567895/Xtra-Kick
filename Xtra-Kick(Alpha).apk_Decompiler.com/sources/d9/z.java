package d9;

import c9.n;
import g9.b;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class z extends AbstractMap implements Serializable {

    /* renamed from: q  reason: collision with root package name */
    public static final Object f4714q = new Object();

    /* renamed from: h  reason: collision with root package name */
    public transient Object f4715h;

    /* renamed from: i  reason: collision with root package name */
    public transient int[] f4716i;

    /* renamed from: j  reason: collision with root package name */
    public transient Object[] f4717j;

    /* renamed from: k  reason: collision with root package name */
    public transient Object[] f4718k;

    /* renamed from: l  reason: collision with root package name */
    public transient int f4719l;

    /* renamed from: m  reason: collision with root package name */
    public transient int f4720m;

    /* renamed from: n  reason: collision with root package name */
    public transient w f4721n;

    /* renamed from: o  reason: collision with root package name */
    public transient w f4722o;

    /* renamed from: p  reason: collision with root package name */
    public transient s f4723p;

    public z() {
        this.f4719l = b.b(3, 1);
    }

    public final Map a() {
        Object obj = this.f4715h;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final int b(Object obj) {
        if (e()) {
            return -1;
        }
        int b10 = h0.b(obj);
        int i10 = (1 << (this.f4719l & 31)) - 1;
        Object obj2 = this.f4715h;
        Objects.requireNonNull(obj2);
        int d10 = a0.d(b10 & i10, obj2);
        if (d10 == 0) {
            return -1;
        }
        int i11 = ~i10;
        int i12 = b10 & i11;
        do {
            int i13 = d10 - 1;
            int i14 = g()[i13];
            if ((i14 & i11) == i12 && n.a(obj, c(i13))) {
                return i13;
            }
            d10 = i14 & i10;
        } while (d10 != 0);
        return -1;
    }

    public final Object c(int i10) {
        return h()[i10];
    }

    public final void clear() {
        if (!e()) {
            this.f4719l += 32;
            Map a10 = a();
            if (a10 != null) {
                this.f4719l = b.b(size(), 3);
                a10.clear();
                this.f4715h = null;
            } else {
                Arrays.fill(h(), 0, this.f4720m, (Object) null);
                Arrays.fill(i(), 0, this.f4720m, (Object) null);
                Object obj = this.f4715h;
                Objects.requireNonNull(obj);
                if (obj instanceof byte[]) {
                    Arrays.fill((byte[]) obj, (byte) 0);
                } else if (obj instanceof short[]) {
                    Arrays.fill((short[]) obj, 0);
                } else {
                    Arrays.fill((int[]) obj, 0);
                }
                Arrays.fill(g(), 0, this.f4720m, 0);
            }
            this.f4720m = 0;
        }
    }

    public final boolean containsKey(Object obj) {
        Map a10 = a();
        return a10 != null ? a10.containsKey(obj) : b(obj) != -1;
    }

    public final boolean containsValue(Object obj) {
        Map a10 = a();
        if (a10 != null) {
            return a10.containsValue(obj);
        }
        for (int i10 = 0; i10 < this.f4720m; i10++) {
            if (n.a(obj, k(i10))) {
                return true;
            }
        }
        return false;
    }

    public final void d(int i10, int i11) {
        Object obj = this.f4715h;
        Objects.requireNonNull(obj);
        int[] g10 = g();
        Object[] h10 = h();
        Object[] i12 = i();
        int size = size() - 1;
        if (i10 < size) {
            Object obj2 = h10[size];
            h10[i10] = obj2;
            i12[i10] = i12[size];
            h10[size] = null;
            i12[size] = null;
            g10[i10] = g10[size];
            g10[size] = 0;
            int b10 = h0.b(obj2) & i11;
            int d10 = a0.d(b10, obj);
            int i13 = size + 1;
            if (d10 == i13) {
                a0.e(b10, i10 + 1, obj);
                return;
            }
            while (true) {
                int i14 = d10 - 1;
                int i15 = g10[i14];
                int i16 = i15 & i11;
                if (i16 == i13) {
                    g10[i14] = ((i10 + 1) & i11) | (i15 & (~i11));
                    return;
                }
                d10 = i16;
            }
        } else {
            h10[i10] = null;
            i12[i10] = null;
            g10[i10] = 0;
        }
    }

    public final boolean e() {
        return this.f4715h == null;
    }

    public final Set entrySet() {
        w wVar = this.f4722o;
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = new w(0, this);
        this.f4722o = wVar2;
        return wVar2;
    }

    public final Object f(Object obj) {
        boolean e10 = e();
        Object obj2 = f4714q;
        if (e10) {
            return obj2;
        }
        int i10 = (1 << (this.f4719l & 31)) - 1;
        Object obj3 = this.f4715h;
        Objects.requireNonNull(obj3);
        int c10 = a0.c(obj, (Object) null, i10, obj3, g(), h(), (Object[]) null);
        if (c10 == -1) {
            return obj2;
        }
        Object k10 = k(c10);
        d(c10, i10);
        this.f4720m--;
        this.f4719l += 32;
        return k10;
    }

    public final int[] g() {
        int[] iArr = this.f4716i;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object get(Object obj) {
        Map a10 = a();
        if (a10 != null) {
            return a10.get(obj);
        }
        int b10 = b(obj);
        if (b10 == -1) {
            return null;
        }
        return k(b10);
    }

    public final Object[] h() {
        Object[] objArr = this.f4717j;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final Object[] i() {
        Object[] objArr = this.f4718k;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final int j(int i10, int i11, int i12, int i13) {
        Object a10 = a0.a(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            a0.e(i12 & i14, i13 + 1, a10);
        }
        Object obj = this.f4715h;
        Objects.requireNonNull(obj);
        int[] g10 = g();
        for (int i15 = 0; i15 <= i10; i15++) {
            int d10 = a0.d(i15, obj);
            while (d10 != 0) {
                int i16 = d10 - 1;
                int i17 = g10[i16];
                int i18 = ((~i10) & i17) | i15;
                int i19 = i18 & i14;
                int d11 = a0.d(i19, a10);
                a0.e(i19, d10, a10);
                g10[i16] = ((~i14) & i18) | (d11 & i14);
                d10 = i17 & i10;
            }
        }
        this.f4715h = a10;
        this.f4719l = ((32 - Integer.numberOfLeadingZeros(i14)) & 31) | (this.f4719l & -32);
        return i14;
    }

    public final Object k(int i10) {
        return i()[i10];
    }

    public final Set keySet() {
        w wVar = this.f4721n;
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = new w(1, this);
        this.f4721n = wVar2;
        return wVar2;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ec A[SYNTHETIC] */
    public final java.lang.Object put(java.lang.Object r19, java.lang.Object r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r18.e()
            r4 = -1
            if (r3 == 0) goto L_0x0059
            boolean r3 = r18.e()
            java.lang.String r5 = "Arrays already allocated"
            c9.q.f(r5, r3)
            int r3 = r0.f4719l
            int r5 = r3 + 1
            r6 = 2
            int r5 = java.lang.Math.max(r5, r6)
            int r6 = java.lang.Integer.highestOneBit(r5)
            double r7 = (double) r6
            r9 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r7 = r7 * r9
            int r7 = (int) r7
            if (r5 <= r7) goto L_0x0032
            int r6 = r6 << 1
            if (r6 <= 0) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r6 = 1073741824(0x40000000, float:2.0)
        L_0x0032:
            r5 = 4
            int r5 = java.lang.Math.max(r5, r6)
            java.lang.Object r6 = d9.a0.a(r5)
            r0.f4715h = r6
            int r5 = r5 + r4
            int r5 = java.lang.Integer.numberOfLeadingZeros(r5)
            int r5 = 32 - r5
            int r6 = r0.f4719l
            r6 = r6 & -32
            r5 = r5 & 31
            r5 = r5 | r6
            r0.f4719l = r5
            int[] r5 = new int[r3]
            r0.f4716i = r5
            java.lang.Object[] r5 = new java.lang.Object[r3]
            r0.f4717j = r5
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r0.f4718k = r3
        L_0x0059:
            java.util.Map r3 = r18.a()
            if (r3 == 0) goto L_0x0064
            java.lang.Object r1 = r3.put(r1, r2)
            return r1
        L_0x0064:
            int[] r3 = r18.g()
            java.lang.Object[] r5 = r18.h()
            java.lang.Object[] r6 = r18.i()
            int r7 = r0.f4720m
            int r8 = r7 + 1
            int r9 = d9.h0.b(r19)
            int r10 = r0.f4719l
            r10 = r10 & 31
            r11 = 1
            int r10 = r11 << r10
            int r10 = r10 - r11
            r12 = r9 & r10
            java.lang.Object r13 = r0.f4715h
            java.util.Objects.requireNonNull(r13)
            int r13 = d9.a0.d(r12, r13)
            if (r13 != 0) goto L_0x009b
            if (r8 <= r10) goto L_0x0091
            goto L_0x0102
        L_0x0091:
            java.lang.Object r3 = r0.f4715h
            java.util.Objects.requireNonNull(r3)
            d9.a0.e(r12, r8, r3)
            goto L_0x0110
        L_0x009b:
            int r12 = ~r10
            r4 = r9 & r12
            r16 = 0
        L_0x00a0:
            int r13 = r13 - r11
            r17 = r3[r13]
            r15 = r17 & r12
            if (r15 != r4) goto L_0x00b4
            r14 = r5[r13]
            boolean r14 = c9.n.a(r1, r14)
            if (r14 == 0) goto L_0x00b4
            r1 = r6[r13]
            r6[r13] = r2
            return r1
        L_0x00b4:
            r14 = r17 & r10
            r17 = r4
            int r4 = r16 + 1
            if (r14 != 0) goto L_0x0168
            r5 = 9
            if (r4 < r5) goto L_0x0100
            int r3 = r0.f4719l
            r3 = r3 & 31
            int r3 = r11 << r3
            int r3 = r3 - r11
            int r3 = r3 + r11
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r5 = 1065353216(0x3f800000, float:1.0)
            r4.<init>(r3, r5)
            boolean r3 = r18.isEmpty()
            if (r3 == 0) goto L_0x00d7
        L_0x00d5:
            r15 = -1
            goto L_0x00d8
        L_0x00d7:
            r15 = 0
        L_0x00d8:
            if (r15 < 0) goto L_0x00ec
            java.lang.Object r3 = r0.c(r15)
            java.lang.Object r5 = r0.k(r15)
            r4.put(r3, r5)
            int r15 = r15 + 1
            int r3 = r0.f4720m
            if (r15 >= r3) goto L_0x00d5
            goto L_0x00d8
        L_0x00ec:
            r0.f4715h = r4
            r3 = 0
            r0.f4716i = r3
            r0.f4717j = r3
            r0.f4718k = r3
            int r3 = r0.f4719l
            int r3 = r3 + 32
            r0.f4719l = r3
            java.lang.Object r1 = r4.put(r1, r2)
            return r1
        L_0x0100:
            if (r8 <= r10) goto L_0x010b
        L_0x0102:
            int r3 = d9.a0.b(r10)
            int r10 = r0.j(r10, r3, r9, r7)
            goto L_0x0110
        L_0x010b:
            r4 = r8 & r10
            r4 = r4 | r15
            r3[r13] = r4
        L_0x0110:
            int[] r3 = r18.g()
            int r3 = r3.length
            if (r8 <= r3) goto L_0x0146
            int r4 = r3 >>> 1
            int r4 = java.lang.Math.max(r11, r4)
            int r4 = r4 + r3
            r4 = r4 | r11
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            int r4 = java.lang.Math.min(r5, r4)
            if (r4 == r3) goto L_0x0146
            int[] r3 = r18.g()
            int[] r3 = java.util.Arrays.copyOf(r3, r4)
            r0.f4716i = r3
            java.lang.Object[] r3 = r18.h()
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r4)
            r0.f4717j = r3
            java.lang.Object[] r3 = r18.i()
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r4)
            r0.f4718k = r3
        L_0x0146:
            int r3 = ~r10
            r3 = r3 & r9
            r13 = 0
            r4 = r10 & 0
            r3 = r3 | r4
            int[] r4 = r18.g()
            r4[r7] = r3
            java.lang.Object[] r3 = r18.h()
            r3[r7] = r1
            java.lang.Object[] r1 = r18.i()
            r1[r7] = r2
            r0.f4720m = r8
            int r1 = r0.f4719l
            int r1 = r1 + 32
            r0.f4719l = r1
            r15 = 0
            return r15
        L_0x0168:
            r16 = r4
            r13 = r14
            r4 = r17
            goto L_0x00a0
        */
        throw new UnsupportedOperationException("Method not decompiled: d9.z.put(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final Object remove(Object obj) {
        Map a10 = a();
        if (a10 != null) {
            return a10.remove(obj);
        }
        Object f10 = f(obj);
        if (f10 == f4714q) {
            return null;
        }
        return f10;
    }

    public final int size() {
        Map a10 = a();
        return a10 != null ? a10.size() : this.f4720m;
    }

    public final Collection values() {
        s sVar = this.f4723p;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(1, this);
        this.f4723p = sVar2;
        return sVar2;
    }

    public z(int i10) {
        if (i10 >= 0) {
            this.f4719l = b.b(i10, 1);
            return;
        }
        throw new IllegalArgumentException("Expected size must be >= 0");
    }
}
