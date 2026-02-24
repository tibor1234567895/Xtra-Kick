package f5;

import java.util.ArrayDeque;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayDeque f5817a = new ArrayDeque();

    public final c a() {
        c cVar;
        synchronized (this.f5817a) {
            cVar = (c) this.f5817a.poll();
        }
        return cVar == null ? new c() : cVar;
    }

    public final void b(c cVar) {
        synchronized (this.f5817a) {
            if (this.f5817a.size() < 10) {
                this.f5817a.offer(cVar);
            }
        }
    }
}
