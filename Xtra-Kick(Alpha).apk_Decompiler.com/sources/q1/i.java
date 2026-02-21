package q1;

import android.os.SystemClock;
import g1.a0;
import g1.v1;
import java.util.List;
import z1.d;

public final class i extends d {

    /* renamed from: g  reason: collision with root package name */
    public int f13162g;

    public i(v1 v1Var, int[] iArr) {
        super(v1Var, iArr);
        int i10 = 0;
        a0 a0Var = v1Var.f6676k[iArr[0]];
        while (true) {
            if (i10 >= this.f17388b) {
                i10 = -1;
                break;
            } else if (this.f17390d[i10] == a0Var) {
                break;
            } else {
                i10++;
            }
        }
        this.f13162g = i10;
    }

    public final void c(long j10, long j11, long j12, List list, x1.d[] dVarArr) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (b(this.f13162g, elapsedRealtime)) {
            int i10 = this.f17388b;
            do {
                i10--;
                if (i10 < 0) {
                    throw new IllegalStateException();
                }
            } while (b(i10, elapsedRealtime));
            this.f13162g = i10;
        }
    }

    public final int n() {
        return 0;
    }

    public final int o() {
        return this.f13162g;
    }

    public final Object q() {
        return null;
    }
}
