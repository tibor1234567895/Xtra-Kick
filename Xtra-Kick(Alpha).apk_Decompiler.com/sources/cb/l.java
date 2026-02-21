package cb;

import xa.j;

public class l extends k {
    public static final long a(long j10, long j11, long j12) {
        if (j11 <= j12) {
            return j10 < j11 ? j11 : j10 > j12 ? j12 : j10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j12 + " is less than minimum " + j11 + '.');
    }

    public static final b b(e eVar, int i10) {
        boolean z10;
        j.f("<this>", eVar);
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Integer valueOf = Integer.valueOf(i10);
        j.f("step", valueOf);
        if (z10) {
            a aVar = b.f3062k;
            if (eVar.f3065j <= 0) {
                i10 = -i10;
            }
            aVar.getClass();
            return new b(eVar.f3063h, eVar.f3064i, i10);
        }
        throw new IllegalArgumentException("Step must be positive, was: " + valueOf + '.');
    }

    public static final e c(int i10, int i11) {
        if (i11 > Integer.MIN_VALUE) {
            return new e(i10, i11 - 1);
        }
        e.f3070l.getClass();
        return e.f3071m;
    }
}
