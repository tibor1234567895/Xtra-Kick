package n1;

import c9.n;
import g1.u1;
import java.util.Arrays;
import v1.a0;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final long f10921a;

    /* renamed from: b  reason: collision with root package name */
    public final u1 f10922b;

    /* renamed from: c  reason: collision with root package name */
    public final int f10923c;

    /* renamed from: d  reason: collision with root package name */
    public final a0 f10924d;

    /* renamed from: e  reason: collision with root package name */
    public final long f10925e;

    /* renamed from: f  reason: collision with root package name */
    public final u1 f10926f;

    /* renamed from: g  reason: collision with root package name */
    public final int f10927g;

    /* renamed from: h  reason: collision with root package name */
    public final a0 f10928h;

    /* renamed from: i  reason: collision with root package name */
    public final long f10929i;

    /* renamed from: j  reason: collision with root package name */
    public final long f10930j;

    public b(long j10, u1 u1Var, int i10, a0 a0Var, long j11, u1 u1Var2, int i11, a0 a0Var2, long j12, long j13) {
        this.f10921a = j10;
        this.f10922b = u1Var;
        this.f10923c = i10;
        this.f10924d = a0Var;
        this.f10925e = j11;
        this.f10926f = u1Var2;
        this.f10927g = i11;
        this.f10928h = a0Var2;
        this.f10929i = j12;
        this.f10930j = j13;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f10921a == bVar.f10921a && this.f10923c == bVar.f10923c && this.f10925e == bVar.f10925e && this.f10927g == bVar.f10927g && this.f10929i == bVar.f10929i && this.f10930j == bVar.f10930j && n.a(this.f10922b, bVar.f10922b) && n.a(this.f10924d, bVar.f10924d) && n.a(this.f10926f, bVar.f10926f) && n.a(this.f10928h, bVar.f10928h);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f10921a), this.f10922b, Integer.valueOf(this.f10923c), this.f10924d, Long.valueOf(this.f10925e), this.f10926f, Integer.valueOf(this.f10927g), this.f10928h, Long.valueOf(this.f10929i), Long.valueOf(this.f10930j)});
    }
}
