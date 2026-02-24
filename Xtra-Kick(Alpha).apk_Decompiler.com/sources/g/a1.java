package g;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.n;
import java.lang.ref.WeakReference;
import l.b;
import l.c;
import l.l;
import m.m;
import m.o;

public final class a1 extends c implements m {

    /* renamed from: j  reason: collision with root package name */
    public final Context f6020j;

    /* renamed from: k  reason: collision with root package name */
    public final o f6021k;

    /* renamed from: l  reason: collision with root package name */
    public b f6022l;

    /* renamed from: m  reason: collision with root package name */
    public WeakReference f6023m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ b1 f6024n;

    public a1(b1 b1Var, Context context, x xVar) {
        this.f6024n = b1Var;
        this.f6020j = context;
        this.f6022l = xVar;
        o oVar = new o(context);
        oVar.f9983l = 1;
        this.f6021k = oVar;
        oVar.f9976e = this;
    }

    public final void a() {
        b1 b1Var = this.f6024n;
        if (b1Var.f6035i == this) {
            if (!(!b1Var.f6042p)) {
                b1Var.f6036j = this;
                b1Var.f6037k = this.f6022l;
            } else {
                this.f6022l.h(this);
            }
            this.f6022l = null;
            b1Var.a(false);
            ActionBarContextView actionBarContextView = b1Var.f6032f;
            if (actionBarContextView.f595r == null) {
                actionBarContextView.e();
            }
            b1Var.f6029c.setHideOnContentScrollEnabled(b1Var.f6047u);
            b1Var.f6035i = null;
        }
    }

    public final View b() {
        WeakReference weakReference = this.f6023m;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public final o c() {
        return this.f6021k;
    }

    public final MenuInflater d() {
        return new l(this.f6020j);
    }

    public final boolean e(o oVar, MenuItem menuItem) {
        b bVar = this.f6022l;
        if (bVar != null) {
            return bVar.f(this, menuItem);
        }
        return false;
    }

    public final CharSequence f() {
        return this.f6024n.f6032f.getSubtitle();
    }

    public final CharSequence g() {
        return this.f6024n.f6032f.getTitle();
    }

    public final void h() {
        if (this.f6024n.f6035i == this) {
            o oVar = this.f6021k;
            oVar.x();
            try {
                this.f6022l.e(this, oVar);
            } finally {
                oVar.w();
            }
        }
    }

    public final boolean i() {
        return this.f6024n.f6032f.f603z;
    }

    public final void j(View view) {
        this.f6024n.f6032f.setCustomView(view);
        this.f6023m = new WeakReference(view);
    }

    public final void k(int i10) {
        m(this.f6024n.f6027a.getResources().getString(i10));
    }

    public final void l(o oVar) {
        if (this.f6022l != null) {
            h();
            n nVar = this.f6024n.f6032f.f588k;
            if (nVar != null) {
                nVar.n();
            }
        }
    }

    public final void m(CharSequence charSequence) {
        this.f6024n.f6032f.setSubtitle(charSequence);
    }

    public final void n(int i10) {
        o(this.f6024n.f6027a.getResources().getString(i10));
    }

    public final void o(CharSequence charSequence) {
        this.f6024n.f6032f.setTitle(charSequence);
    }

    public final void p(boolean z10) {
        this.f9433i = z10;
        this.f6024n.f6032f.setTitleOptional(z10);
    }
}
