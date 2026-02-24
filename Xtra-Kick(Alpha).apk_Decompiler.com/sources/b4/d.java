package b4;

import android.view.ViewGroup;

public final class d extends v {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2524a = false;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2525b;

    public d(ViewGroup viewGroup) {
        this.f2525b = viewGroup;
    }

    public final void a(u uVar) {
        if (!this.f2524a) {
            f0.a(this.f2525b, false);
        }
        uVar.v(this);
    }

    public final void c() {
        f0.a(this.f2525b, false);
    }

    public final void d() {
        f0.a(this.f2525b, true);
    }

    public final void e() {
        f0.a(this.f2525b, false);
        this.f2524a = true;
    }
}
