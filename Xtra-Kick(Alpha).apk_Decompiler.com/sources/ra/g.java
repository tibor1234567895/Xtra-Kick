package ra;

import pa.e;
import pa.k;
import pa.l;

public abstract class g extends a {
    public g(e eVar) {
        super(eVar);
        if (eVar != null) {
            if (!(eVar.getContext() == l.f12754h)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    public final k getContext() {
        return l.f12754h;
    }
}
