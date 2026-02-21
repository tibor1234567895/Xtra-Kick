package v1;

import g1.w0;

public final class a0 extends w0 {
    public a0(int i10, long j10, Object obj) {
        super(obj, -1, -1, j10, i10);
    }

    public final a0 b(Object obj) {
        w0 w0Var;
        if (this.f6678a.equals(obj)) {
            w0Var = this;
        } else {
            w0Var = new w0(obj, this.f6679b, this.f6680c, this.f6681d, this.f6682e);
        }
        return new a0(w0Var);
    }

    public a0(long j10, Object obj) {
        super(j10, obj);
    }

    public a0(w0 w0Var) {
        super(w0Var);
    }

    public a0(Object obj) {
        super(-1, obj);
    }

    public a0(Object obj, int i10, int i11, long j10) {
        super(obj, i10, i11, j10, -1);
    }
}
