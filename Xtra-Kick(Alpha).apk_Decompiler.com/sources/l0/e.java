package l0;

import s.f;

public final class e extends f {

    /* renamed from: k  reason: collision with root package name */
    public final Object f9500k = new Object();

    public e(int i10) {
        super(i10, 1);
    }

    public final boolean e(Object obj) {
        boolean e10;
        synchronized (this.f9500k) {
            e10 = super.e(obj);
        }
        return e10;
    }

    public final Object j() {
        Object j10;
        synchronized (this.f9500k) {
            j10 = super.j();
        }
        return j10;
    }
}
