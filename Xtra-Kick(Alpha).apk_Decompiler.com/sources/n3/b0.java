package n3;

import androidx.fragment.app.p0;
import androidx.recyclerview.widget.RecyclerView;
import kb.e1;
import kb.f1;
import la.i;
import xa.j;

public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    public final e1 f11056a;

    /* renamed from: b  reason: collision with root package name */
    public final p0 f11057b;

    public b0() {
        this(0);
    }

    public final void a(Object obj) {
        j.f("data", obj);
        e1 e1Var = this.f11056a;
        e1Var.k(new i(Integer.valueOf(((Number) ((i) e1Var.getValue()).f9799h).intValue() + 1), obj));
    }

    public b0(int i10) {
        e1 a10 = f1.a(new i(Integer.valueOf(RecyclerView.UNDEFINED_DURATION), (Object) null));
        this.f11056a = a10;
        this.f11057b = new p0(1, a10);
    }
}
