package k0;

import j1.b0;

public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    public final Object f8956a;

    public /* synthetic */ k(Object obj) {
        this.f8956a = obj;
    }

    public abstract boolean a();

    public final boolean b(CharSequence charSequence, int i10) {
        if (charSequence == null || i10 < 0 || charSequence.length() - i10 < 0) {
            throw new IllegalArgumentException();
        }
        j jVar = (j) this.f8956a;
        if (jVar == null) {
            return a();
        }
        int a10 = jVar.a(charSequence, i10);
        if (a10 == 0) {
            return true;
        }
        if (a10 != 1) {
            return a();
        }
        return false;
    }

    public abstract boolean c(b0 b0Var);

    public abstract boolean d(long j10, b0 b0Var);
}
