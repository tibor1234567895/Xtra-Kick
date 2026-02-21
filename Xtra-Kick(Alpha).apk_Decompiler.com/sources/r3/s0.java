package r3;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import la.v;
import u3.m;
import u3.n;
import xa.j;

public final class s0 implements n, m {

    /* renamed from: p  reason: collision with root package name */
    public static final r0 f13739p = new r0(0);

    /* renamed from: q  reason: collision with root package name */
    public static final TreeMap f13740q = new TreeMap();

    /* renamed from: h  reason: collision with root package name */
    public final int f13741h;

    /* renamed from: i  reason: collision with root package name */
    public volatile String f13742i;

    /* renamed from: j  reason: collision with root package name */
    public final long[] f13743j;

    /* renamed from: k  reason: collision with root package name */
    public final double[] f13744k;

    /* renamed from: l  reason: collision with root package name */
    public final String[] f13745l;

    /* renamed from: m  reason: collision with root package name */
    public final byte[][] f13746m;

    /* renamed from: n  reason: collision with root package name */
    public final int[] f13747n;

    /* renamed from: o  reason: collision with root package name */
    public int f13748o;

    public s0(int i10) {
        this.f13741h = i10;
        int i11 = i10 + 1;
        this.f13747n = new int[i11];
        this.f13743j = new long[i11];
        this.f13744k = new double[i11];
        this.f13745l = new String[i11];
        this.f13746m = new byte[i11][];
    }

    public static final s0 k(int i10, String str) {
        f13739p.getClass();
        j.f("query", str);
        TreeMap treeMap = f13740q;
        synchronized (treeMap) {
            Map.Entry ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i10));
            if (ceilingEntry != null) {
                treeMap.remove(ceilingEntry.getKey());
                s0 s0Var = (s0) ceilingEntry.getValue();
                s0Var.getClass();
                s0Var.f13742i = str;
                s0Var.f13748o = i10;
                return s0Var;
            }
            v vVar = v.f9814a;
            s0 s0Var2 = new s0(i10);
            s0Var2.f13742i = str;
            s0Var2.f13748o = i10;
            return s0Var2;
        }
    }

    public final void F(int i10) {
        this.f13747n[i10] = 1;
    }

    public final void L(int i10, double d10) {
        this.f13747n[i10] = 3;
        this.f13744k[i10] = d10;
    }

    public final String c() {
        String str = this.f13742i;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void close() {
    }

    public final void e(m mVar) {
        int i10 = this.f13748o;
        if (1 <= i10) {
            int i11 = 1;
            while (true) {
                int i12 = this.f13747n[i11];
                if (i12 == 1) {
                    mVar.F(i11);
                } else if (i12 == 2) {
                    mVar.g0(i11, this.f13743j[i11]);
                } else if (i12 == 3) {
                    mVar.L(i11, this.f13744k[i11]);
                } else if (i12 == 4) {
                    String str = this.f13745l[i11];
                    if (str != null) {
                        mVar.q(i11, str);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else if (i12 == 5) {
                    byte[] bArr = this.f13746m[i11];
                    if (bArr != null) {
                        mVar.r0(i11, bArr);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
                if (i11 != i10) {
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public final void g0(int i10, long j10) {
        this.f13747n[i10] = 2;
        this.f13743j[i10] = j10;
    }

    public final void q(int i10, String str) {
        j.f("value", str);
        this.f13747n[i10] = 4;
        this.f13745l[i10] = str;
    }

    public final void r0(int i10, byte[] bArr) {
        this.f13747n[i10] = 5;
        this.f13746m[i10] = bArr;
    }

    public final void v() {
        TreeMap treeMap = f13740q;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f13741h), this);
            f13739p.getClass();
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator it = treeMap.descendingKeySet().iterator();
                j.e("queryPool.descendingKeySet().iterator()", it);
                while (true) {
                    int i10 = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i10;
                }
            }
            v vVar = v.f9814a;
        }
    }
}
