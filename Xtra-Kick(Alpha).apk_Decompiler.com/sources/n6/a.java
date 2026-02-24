package n6;

import androidx.fragment.app.c0;
import androidx.viewpager2.adapter.g;
import o6.e;
import o7.c;
import xa.j;

public final class a extends g {

    /* renamed from: i  reason: collision with root package name */
    public final boolean f11704i = false;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(c0 c0Var) {
        super(c0Var);
        j.f("fragment", c0Var);
    }

    public final c0 c(int i10) {
        return this.f11704i ? i10 != 0 ? i10 != 1 ? i10 != 2 ? new e() : new c() : new k7.a() : new p6.c() : i10 != 0 ? i10 != 1 ? new e() : new k7.a() : new p6.c();
    }

    public final int getItemCount() {
        return this.f11704i ? 4 : 3;
    }
}
