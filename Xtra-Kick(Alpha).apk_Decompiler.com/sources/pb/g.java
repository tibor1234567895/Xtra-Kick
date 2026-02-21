package pb;

import cb.l;
import gb.b;
import gb.c;
import gb.d;
import gb.e;
import java.util.concurrent.TimeUnit;
import xa.j;

public final class g {

    /* renamed from: n  reason: collision with root package name */
    public static final f f12846n = new f(0);

    /* renamed from: o  reason: collision with root package name */
    public static final g f12847o;

    /* renamed from: p  reason: collision with root package name */
    public static final g f12848p;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f12849a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f12850b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12851c;

    /* renamed from: d  reason: collision with root package name */
    public final int f12852d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f12853e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f12854f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f12855g;

    /* renamed from: h  reason: collision with root package name */
    public final int f12856h;

    /* renamed from: i  reason: collision with root package name */
    public final int f12857i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f12858j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f12859k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f12860l;

    /* renamed from: m  reason: collision with root package name */
    public String f12861m;

    static {
        long j10;
        long j11;
        d dVar;
        boolean z10;
        boolean z11 = false;
        e eVar = new e();
        eVar.f12814a = true;
        f12847o = eVar.a();
        e eVar2 = new e();
        eVar2.f12819f = true;
        d dVar2 = d.SECONDS;
        j.f("timeUnit", dVar2);
        int compareTo = dVar2.compareTo(dVar2);
        TimeUnit timeUnit = dVar2.f6876h;
        int i10 = Integer.MAX_VALUE;
        long j12 = (long) Integer.MAX_VALUE;
        if (compareTo <= 0) {
            j10 = e.a(j12, dVar2, d.NANOSECONDS) << 1;
            int i11 = b.f6870j;
            int i12 = c.f6871a;
        } else {
            d dVar3 = d.NANOSECONDS;
            long a10 = e.a(4611686018426999999L, dVar3, dVar2);
            long j13 = -a10;
            cb.j jVar = new cb.j(j13, a10);
            if (j13 > j12 || j12 > jVar.f3073i) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                j10 = e.a(j12, dVar2, dVar3) << 1;
                int i13 = b.f6870j;
                int i14 = c.f6871a;
            } else {
                d dVar4 = d.MILLISECONDS;
                j.f("targetUnit", dVar4);
                j10 = (l.a(dVar4.f6876h.convert(j12, timeUnit), -4611686018427387903L, 4611686018427387903L) << 1) + 1;
                int i15 = b.f6870j;
                int i16 = c.f6871a;
            }
        }
        if (j10 == b.f6868h) {
            j11 = Long.MAX_VALUE;
        } else if (j10 == b.f6869i) {
            j11 = Long.MIN_VALUE;
        } else {
            long j14 = j10 >> 1;
            if ((((int) j10) & 1) == 0) {
                z11 = true;
            }
            if (z11) {
                dVar = d.NANOSECONDS;
            } else {
                dVar = d.MILLISECONDS;
            }
            j.f("sourceUnit", dVar);
            j11 = timeUnit.convert(j14, dVar.f6876h);
        }
        if (j11 <= 2147483647L) {
            i10 = (int) j11;
        }
        eVar2.f12817d = i10;
        f12848p = eVar2.a();
    }

    public g(boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, int i12, int i13, boolean z15, boolean z16, boolean z17, String str) {
        this.f12849a = z10;
        this.f12850b = z11;
        this.f12851c = i10;
        this.f12852d = i11;
        this.f12853e = z12;
        this.f12854f = z13;
        this.f12855g = z14;
        this.f12856h = i12;
        this.f12857i = i13;
        this.f12858j = z15;
        this.f12859k = z16;
        this.f12860l = z17;
        this.f12861m = str;
    }

    public final String toString() {
        boolean z10;
        String str = this.f12861m;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f12849a) {
            sb2.append("no-cache, ");
        }
        if (this.f12850b) {
            sb2.append("no-store, ");
        }
        int i10 = this.f12851c;
        if (i10 != -1) {
            sb2.append("max-age=");
            sb2.append(i10);
            sb2.append(", ");
        }
        int i11 = this.f12852d;
        if (i11 != -1) {
            sb2.append("s-maxage=");
            sb2.append(i11);
            sb2.append(", ");
        }
        if (this.f12853e) {
            sb2.append("private, ");
        }
        if (this.f12854f) {
            sb2.append("public, ");
        }
        if (this.f12855g) {
            sb2.append("must-revalidate, ");
        }
        int i12 = this.f12856h;
        if (i12 != -1) {
            sb2.append("max-stale=");
            sb2.append(i12);
            sb2.append(", ");
        }
        int i13 = this.f12857i;
        if (i13 != -1) {
            sb2.append("min-fresh=");
            sb2.append(i13);
            sb2.append(", ");
        }
        if (this.f12858j) {
            sb2.append("only-if-cached, ");
        }
        if (this.f12859k) {
            sb2.append("no-transform, ");
        }
        if (this.f12860l) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return "";
        }
        j.e("this.delete(startIndex, endIndex)", sb2.delete(sb2.length() - 2, sb2.length()));
        String sb3 = sb2.toString();
        j.e("StringBuilder().apply(builderAction).toString()", sb3);
        this.f12861m = sb3;
        return sb3;
    }
}
