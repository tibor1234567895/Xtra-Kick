package h9;

public final class g extends a {
    private g() {
        super(0);
    }

    public final boolean a(n nVar, d dVar, d dVar2) {
        synchronized (nVar) {
            if (nVar.f7763i != dVar) {
                return false;
            }
            nVar.f7763i = dVar2;
            return true;
        }
    }

    public final boolean b(n nVar, Object obj, Object obj2) {
        synchronized (nVar) {
            if (nVar.f7762h != obj) {
                return false;
            }
            nVar.f7762h = obj2;
            return true;
        }
    }

    public final boolean c(n nVar, m mVar, m mVar2) {
        synchronized (nVar) {
            if (nVar.f7764j != mVar) {
                return false;
            }
            nVar.f7764j = mVar2;
            return true;
        }
    }

    public final void d(m mVar, m mVar2) {
        mVar.f7756b = mVar2;
    }

    public final void e(m mVar, Thread thread) {
        mVar.f7755a = thread;
    }

    public /* synthetic */ g(int i10) {
        this();
    }
}
