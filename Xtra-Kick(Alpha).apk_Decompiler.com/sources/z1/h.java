package z1;

import d9.e0;
import g1.a0;

public final class h implements Comparable {

    /* renamed from: h  reason: collision with root package name */
    public final boolean f17413h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f17414i;

    public h(a0 a0Var, int i10) {
        this.f17413h = (a0Var.f6268k & 1) == 0 ? false : true;
        this.f17414i = q.j(i10, false);
    }

    public final int compareTo(Object obj) {
        h hVar = (h) obj;
        return e0.f4608a.c(this.f17414i, hVar.f17414i).c(this.f17413h, hVar.f17413h).e();
    }
}
