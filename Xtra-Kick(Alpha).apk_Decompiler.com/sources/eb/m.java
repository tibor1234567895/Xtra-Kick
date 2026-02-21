package eb;

import androidx.lifecycle.p1;
import java.util.Iterator;
import m0.h1;
import wa.l;
import xa.j;

public class m extends l {
    public static final h a(Iterator it) {
        j.f("<this>", it);
        h1 h1Var = new h1(3, it);
        if (h1Var instanceof a) {
            return h1Var;
        }
        return new a(h1Var);
    }

    public static final h b(Object obj, l lVar) {
        j.f("nextFunction", lVar);
        return obj == null ? d.f5333a : new r(new p1(24, obj), lVar);
    }
}
