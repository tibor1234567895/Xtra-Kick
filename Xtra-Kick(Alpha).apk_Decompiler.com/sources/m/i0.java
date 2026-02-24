package m;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.media.h;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public final class i0 extends o implements SubMenu {
    public final q A;

    /* renamed from: z  reason: collision with root package name */
    public final o f9956z;

    public i0(Context context, o oVar, q qVar) {
        super(context);
        this.f9956z = oVar;
        this.A = qVar;
    }

    public final boolean d(q qVar) {
        return this.f9956z.d(qVar);
    }

    public final boolean e(o oVar, MenuItem menuItem) {
        return super.e(oVar, menuItem) || this.f9956z.e(oVar, menuItem);
    }

    public final boolean f(q qVar) {
        return this.f9956z.f(qVar);
    }

    public final MenuItem getItem() {
        return this.A;
    }

    public final String j() {
        int i10;
        q qVar = this.A;
        if (qVar != null) {
            i10 = qVar.f9999a;
        } else {
            i10 = 0;
        }
        if (i10 == 0) {
            return null;
        }
        return h.i("android:menu:actionviewstates:", i10);
    }

    public final o k() {
        return this.f9956z.k();
    }

    public final boolean m() {
        return this.f9956z.m();
    }

    public final boolean n() {
        return this.f9956z.n();
    }

    public final boolean o() {
        return this.f9956z.o();
    }

    public final void setGroupDividerEnabled(boolean z10) {
        this.f9956z.setGroupDividerEnabled(z10);
    }

    public final SubMenu setHeaderIcon(int i10) {
        v(0, (CharSequence) null, i10, (Drawable) null, (View) null);
        return this;
    }

    public final SubMenu setHeaderTitle(int i10) {
        v(i10, (CharSequence) null, 0, (Drawable) null, (View) null);
        return this;
    }

    public final SubMenu setHeaderView(View view) {
        v(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    public final SubMenu setIcon(int i10) {
        this.A.setIcon(i10);
        return this;
    }

    public final void setQwertyMode(boolean z10) {
        this.f9956z.setQwertyMode(z10);
    }

    public final void u(m mVar) {
        throw null;
    }

    public final SubMenu setHeaderIcon(Drawable drawable) {
        v(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        v(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    public final SubMenu setIcon(Drawable drawable) {
        this.A.setIcon(drawable);
        return this;
    }
}
