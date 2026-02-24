package d9;

import java.util.Collection;
import java.util.List;

public final class o0 extends k0 {
    public final void c(Object obj) {
        obj.getClass();
        b(this.f4627b + 1);
        Object[] objArr = this.f4626a;
        int i10 = this.f4627b;
        this.f4627b = i10 + 1;
        objArr[i10] = obj;
    }

    public final void d(List list) {
        if (list instanceof Collection) {
            b(list.size() + this.f4627b);
            if (list instanceof m0) {
                this.f4627b = ((m0) list).b(this.f4627b, this.f4626a);
                return;
            }
        }
        for (Object c10 : list) {
            c(c10);
        }
    }

    public final r1 e() {
        this.f4628c = true;
        return r0.h(this.f4627b, this.f4626a);
    }
}
