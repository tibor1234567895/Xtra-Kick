package dc;

import ec.f;
import java.io.FileNotFoundException;
import java.util.List;
import xa.j;

public abstract class r {

    /* renamed from: a  reason: collision with root package name */
    public static final z f4819a;

    static {
        z zVar;
        new q(0);
        try {
            Class.forName("java.nio.file.Files");
            zVar = new a0();
        } catch (ClassNotFoundException unused) {
            zVar = new z();
        }
        f4819a = zVar;
        e0 e0Var = f0.f4761i;
        String property = System.getProperty("java.io.tmpdir");
        j.e("getProperty(\"java.io.tmpdir\")", property);
        f0 unused2 = e0Var.getClass();
        ClassLoader classLoader = f.class.getClassLoader();
        j.e("ResourceFileSystem::class.java.classLoader", classLoader);
        new f(classLoader);
    }

    public abstract n0 a(f0 f0Var);

    public abstract void b(f0 f0Var, f0 f0Var2);

    public abstract void c(f0 f0Var);

    public abstract void d(f0 f0Var);

    public final void e(f0 f0Var) {
        j.f("path", f0Var);
        d(f0Var);
    }

    public final boolean f(f0 f0Var) {
        j.f("path", f0Var);
        if (i(f0Var) != null) {
            return true;
        }
        return false;
    }

    public abstract List g(f0 f0Var);

    public final p h(f0 f0Var) {
        j.f("path", f0Var);
        p i10 = i(f0Var);
        if (i10 != null) {
            return i10;
        }
        throw new FileNotFoundException("no such file: " + f0Var);
    }

    public abstract p i(f0 f0Var);

    public abstract y j(f0 f0Var);

    public abstract n0 k(f0 f0Var);

    public abstract p0 l(f0 f0Var);
}
