package j3;

import eb.h;
import eb.m;
import java.util.Iterator;
import java.util.NoSuchElementException;
import xa.j;

public final class f1 {
    private f1() {
    }

    public /* synthetic */ f1(int i10) {
        this();
    }

    public static c1 a(h1 h1Var) {
        Object next;
        j.f("<this>", h1Var);
        h b10 = m.b(h1Var.i(h1Var.f8558s, true), e1.f8523h);
        j.f("<this>", b10);
        Iterator it = b10.iterator();
        if (it.hasNext()) {
            do {
                next = it.next();
            } while (it.hasNext());
            return (c1) next;
        }
        throw new NoSuchElementException("Sequence is empty.");
    }
}
