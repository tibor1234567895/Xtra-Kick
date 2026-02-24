package g1;

import android.util.SparseBooleanArray;
import j1.a;
import j1.l0;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public final SparseBooleanArray f6716a;

    public y(SparseBooleanArray sparseBooleanArray) {
        this.f6716a = sparseBooleanArray;
    }

    public final boolean a(int... iArr) {
        for (int i10 : iArr) {
            if (this.f6716a.get(i10)) {
                return true;
            }
        }
        return false;
    }

    public final int b(int i10) {
        a.c(i10, c());
        return this.f6716a.keyAt(i10);
    }

    public final int c() {
        return this.f6716a.size();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        if (l0.f8453a >= 24) {
            return this.f6716a.equals(yVar.f6716a);
        }
        if (c() != yVar.c()) {
            return false;
        }
        for (int i10 = 0; i10 < c(); i10++) {
            if (b(i10) != yVar.b(i10)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        if (l0.f8453a >= 24) {
            return this.f6716a.hashCode();
        }
        int c10 = c();
        for (int i10 = 0; i10 < c(); i10++) {
            c10 = (c10 * 31) + b(i10);
        }
        return c10;
    }
}
