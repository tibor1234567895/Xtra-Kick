package e5;

import java.util.ArrayDeque;
import w5.p;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayDeque f5041a = new ArrayDeque(20);

    public b() {
        char[] cArr = p.f16126a;
    }

    public abstract o a();

    public final o b() {
        o oVar = (o) this.f5041a.poll();
        return oVar == null ? a() : oVar;
    }

    public final void c(o oVar) {
        ArrayDeque arrayDeque = this.f5041a;
        if (arrayDeque.size() < 20) {
            arrayDeque.offer(oVar);
        }
    }
}
