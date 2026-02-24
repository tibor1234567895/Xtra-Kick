package l;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.n;
import java.lang.ref.WeakReference;
import m.m;
import m.o;

public final class g extends c implements m {

    /* renamed from: j  reason: collision with root package name */
    public final Context f9440j;

    /* renamed from: k  reason: collision with root package name */
    public final ActionBarContextView f9441k;

    /* renamed from: l  reason: collision with root package name */
    public final b f9442l;

    /* renamed from: m  reason: collision with root package name */
    public WeakReference f9443m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f9444n;

    /* renamed from: o  reason: collision with root package name */
    public final o f9445o;

    public g(Context context, ActionBarContextView actionBarContextView, b bVar) {
        this.f9440j = context;
        this.f9441k = actionBarContextView;
        this.f9442l = bVar;
        o oVar = new o(actionBarContextView.getContext());
        oVar.f9983l = 1;
        this.f9445o = oVar;
        oVar.f9976e = this;
    }

    public final void a() {
        if (!this.f9444n) {
            this.f9444n = true;
            this.f9442l.h(this);
        }
    }

    public final View b() {
        WeakReference weakReference = this.f9443m;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public final o c() {
        return this.f9445o;
    }

    public final MenuInflater d() {
        return new l(this.f9441k.getContext());
    }

    public final boolean e(o oVar, MenuItem menuItem) {
        return this.f9442l.f(this, menuItem);
    }

    public final CharSequence f() {
        return this.f9441k.getSubtitle();
    }

    public final CharSequence g() {
        return this.f9441k.getTitle();
    }

    public final void h() {
        this.f9442l.e(this, this.f9445o);
    }

    public final boolean i() {
        return this.f9441k.f603z;
    }

    public final void j(View view) {
        this.f9441k.setCustomView(view);
        this.f9443m = view != null ? new WeakReference(view) : null;
    }

    public final void k(int i10) {
        m(this.f9440j.getString(i10));
    }

    public final void l(o oVar) {
        h();
        n nVar = this.f9441k.f588k;
        if (nVar != null) {
            nVar.n();
        }
    }

    public final void m(CharSequence charSequence) {
        this.f9441k.setSubtitle(charSequence);
    }

    public final void n(int i10) {
        o(this.f9440j.getString(i10));
    }

    public final void o(CharSequence charSequence) {
        this.f9441k.setTitle(charSequence);
    }

    public final void p(boolean z10) {
        this.f9433i = z10;
        this.f9441k.setTitleOptional(z10);
    }
}
