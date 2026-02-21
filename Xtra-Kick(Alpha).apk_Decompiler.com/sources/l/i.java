package l;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import m.f0;

public final class i extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    public final Context f9451a;

    /* renamed from: b  reason: collision with root package name */
    public final c f9452b;

    public i(Context context, c cVar) {
        this.f9451a = context;
        this.f9452b = cVar;
    }

    public final void finish() {
        this.f9452b.a();
    }

    public final View getCustomView() {
        return this.f9452b.b();
    }

    public final Menu getMenu() {
        return new f0(this.f9451a, this.f9452b.c());
    }

    public final MenuInflater getMenuInflater() {
        return this.f9452b.d();
    }

    public final CharSequence getSubtitle() {
        return this.f9452b.f();
    }

    public final Object getTag() {
        return this.f9452b.f9432h;
    }

    public final CharSequence getTitle() {
        return this.f9452b.g();
    }

    public final boolean getTitleOptionalHint() {
        return this.f9452b.f9433i;
    }

    public final void invalidate() {
        this.f9452b.h();
    }

    public final boolean isTitleOptional() {
        return this.f9452b.i();
    }

    public final void setCustomView(View view) {
        this.f9452b.j(view);
    }

    public final void setSubtitle(int i10) {
        this.f9452b.k(i10);
    }

    public final void setTag(Object obj) {
        this.f9452b.f9432h = obj;
    }

    public final void setTitle(int i10) {
        this.f9452b.n(i10);
    }

    public final void setTitleOptionalHint(boolean z10) {
        this.f9452b.p(z10);
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.f9452b.m(charSequence);
    }

    public final void setTitle(CharSequence charSequence) {
        this.f9452b.o(charSequence);
    }
}
