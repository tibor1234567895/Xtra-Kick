package p1;

import androidx.emoji2.text.r;
import j1.l0;
import j1.p;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import v1.a0;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public final int f12505a;

    /* renamed from: b  reason: collision with root package name */
    public final a0 f12506b;

    /* renamed from: c  reason: collision with root package name */
    public final CopyOnWriteArrayList f12507c;

    public q() {
        this(new CopyOnWriteArrayList(), 0, (a0) null);
    }

    public final void a() {
        Iterator it = this.f12507c.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            l0.L(pVar.f12503a, new o(this, pVar.f12504b, 3));
        }
    }

    public final void b() {
        Iterator it = this.f12507c.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            l0.L(pVar.f12503a, new o(this, pVar.f12504b, 2));
        }
    }

    public final void c() {
        Iterator it = this.f12507c.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            l0.L(pVar.f12503a, new o(this, pVar.f12504b, 1));
        }
    }

    public final void d(int i10) {
        Iterator it = this.f12507c.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            l0.L(pVar.f12503a, new p((Object) this, (Object) pVar.f12504b, i10, 2));
        }
    }

    public final void e(Exception exc) {
        Iterator it = this.f12507c.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            l0.L(pVar.f12503a, new r(this, pVar.f12504b, exc, 9));
        }
    }

    public final void f() {
        Iterator it = this.f12507c.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            l0.L(pVar.f12503a, new o(this, pVar.f12504b, 0));
        }
    }

    public q(CopyOnWriteArrayList copyOnWriteArrayList, int i10, a0 a0Var) {
        this.f12507c = copyOnWriteArrayList;
        this.f12505a = i10;
        this.f12506b = a0Var;
    }
}
