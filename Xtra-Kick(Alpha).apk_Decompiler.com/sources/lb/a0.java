package lb;

import jb.a;
import kb.c1;
import kb.s0;
import xa.j;

public final class a0 extends s0 implements c1 {
    public a0(int i10) {
        super(1, Integer.MAX_VALUE, a.DROP_OLDEST);
        h(Integer.valueOf(i10));
    }

    public final Object getValue() {
        Integer valueOf;
        synchronized (this) {
            Object[] objArr = this.f9388o;
            j.c(objArr);
            valueOf = Integer.valueOf(((Number) objArr[(objArr.length - 1) & ((int) ((this.f9389p + ((long) ((int) ((q() + ((long) this.f9391r)) - this.f9389p)))) - 1))]).intValue());
        }
        return valueOf;
    }

    public final void x(int i10) {
        synchronized (this) {
            Object[] objArr = this.f9388o;
            j.c(objArr);
            h(Integer.valueOf(((Number) objArr[(objArr.length - 1) & ((int) ((this.f9389p + ((long) ((int) ((q() + ((long) this.f9391r)) - this.f9389p)))) - 1))]).intValue() + i10));
        }
    }
}
