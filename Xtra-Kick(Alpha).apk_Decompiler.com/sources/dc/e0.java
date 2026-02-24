package dc;

import ec.l;
import java.io.File;
import xa.j;

public final class e0 {
    private e0() {
    }

    public /* synthetic */ e0(int i10) {
        this();
    }

    public static f0 a(String str, boolean z10) {
        j.f("<this>", str);
        n nVar = l.f5386a;
        j jVar = new j();
        jVar.X0(str);
        return l.d(jVar, z10);
    }

    public static f0 b(e0 e0Var, File file) {
        e0Var.getClass();
        j.f("<this>", file);
        String file2 = file.toString();
        j.e("toString()", file2);
        return a(file2, false);
    }
}
