package dc;

import java.util.concurrent.TimeUnit;
import xa.j;

public final class a {
    private a() {
    }

    public /* synthetic */ a(int i10) {
        this();
    }

    public static e a() {
        e eVar = e.f4757m;
        j.c(eVar);
        e eVar2 = eVar.f4759f;
        long nanoTime = System.nanoTime();
        if (eVar2 == null) {
            e.f4754j.await(e.f4755k, TimeUnit.MILLISECONDS);
            e eVar3 = e.f4757m;
            j.c(eVar3);
            if (eVar3.f4759f != null || System.nanoTime() - nanoTime < e.f4756l) {
                return null;
            }
            return e.f4757m;
        }
        long j10 = eVar2.f4760g - nanoTime;
        if (j10 > 0) {
            e.f4754j.await(j10, TimeUnit.NANOSECONDS);
            return null;
        }
        e eVar4 = e.f4757m;
        j.c(eVar4);
        eVar4.f4759f = eVar2.f4759f;
        eVar2.f4759f = null;
        return eVar2;
    }
}
