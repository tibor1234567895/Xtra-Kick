package o5;

import java.util.ArrayDeque;
import w5.p;
import y4.d;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayDeque f12192a = new ArrayDeque(0);

    public b() {
        char[] cArr = p.f16126a;
    }

    public final synchronized void a(d dVar) {
        dVar.f16941b = null;
        dVar.f16942c = null;
        this.f12192a.offer(dVar);
    }
}
