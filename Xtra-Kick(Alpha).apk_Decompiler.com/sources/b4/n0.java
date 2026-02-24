package b4;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import com.woxthebox.draglistview.R;

public final class n0 extends v {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2564a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f2565b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f2566c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ q0 f2567d;

    public n0(q0 q0Var, ViewGroup viewGroup, View view, View view2) {
        this.f2567d = q0Var;
        this.f2564a = viewGroup;
        this.f2565b = view;
        this.f2566c = view2;
    }

    public final void a(u uVar) {
        this.f2566c.setTag(R.id.save_overlay_view, (Object) null);
        ((ViewGroupOverlay) new e0(this.f2564a).f2538i).remove(this.f2565b);
        uVar.v(this);
    }

    public final void c() {
        ((ViewGroupOverlay) new e0(this.f2564a).f2538i).remove(this.f2565b);
    }

    public final void d() {
        View view = this.f2565b;
        if (view.getParent() == null) {
            ((ViewGroupOverlay) new e0(this.f2564a).f2538i).add(view);
        } else {
            this.f2567d.cancel();
        }
    }
}
