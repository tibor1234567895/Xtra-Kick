package r;

public final class g extends a {
    public g() {
        super(0);
    }

    public final boolean a(i iVar, e eVar, e eVar2) {
        synchronized (iVar) {
            if (iVar.f13517i != eVar) {
                return false;
            }
            iVar.f13517i = eVar2;
            return true;
        }
    }

    public final boolean b(i iVar, Object obj, Object obj2) {
        synchronized (iVar) {
            if (iVar.f13516h != obj) {
                return false;
            }
            iVar.f13516h = obj2;
            return true;
        }
    }

    public final boolean c(i iVar, h hVar, h hVar2) {
        synchronized (iVar) {
            if (iVar.f13518j != hVar) {
                return false;
            }
            iVar.f13518j = hVar2;
            return true;
        }
    }

    public final void d(h hVar, h hVar2) {
        hVar.f13511b = hVar2;
    }

    public final void e(h hVar, Thread thread) {
        hVar.f13510a = thread;
    }
}
