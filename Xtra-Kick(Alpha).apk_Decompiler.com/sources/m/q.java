package m;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.LinearLayout;
import e.a;
import g0.b;
import java.util.ArrayList;
import m0.d;

public final class q implements b {
    public d A;
    public MenuItem.OnActionExpandListener B;
    public boolean C = false;

    /* renamed from: a  reason: collision with root package name */
    public final int f9999a;

    /* renamed from: b  reason: collision with root package name */
    public final int f10000b;

    /* renamed from: c  reason: collision with root package name */
    public final int f10001c;

    /* renamed from: d  reason: collision with root package name */
    public final int f10002d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f10003e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f10004f;

    /* renamed from: g  reason: collision with root package name */
    public Intent f10005g;

    /* renamed from: h  reason: collision with root package name */
    public char f10006h;

    /* renamed from: i  reason: collision with root package name */
    public int f10007i = 4096;

    /* renamed from: j  reason: collision with root package name */
    public char f10008j;

    /* renamed from: k  reason: collision with root package name */
    public int f10009k = 4096;

    /* renamed from: l  reason: collision with root package name */
    public Drawable f10010l;

    /* renamed from: m  reason: collision with root package name */
    public int f10011m = 0;

    /* renamed from: n  reason: collision with root package name */
    public final o f10012n;

    /* renamed from: o  reason: collision with root package name */
    public i0 f10013o;

    /* renamed from: p  reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f10014p;

    /* renamed from: q  reason: collision with root package name */
    public CharSequence f10015q;

    /* renamed from: r  reason: collision with root package name */
    public CharSequence f10016r;

    /* renamed from: s  reason: collision with root package name */
    public ColorStateList f10017s = null;

    /* renamed from: t  reason: collision with root package name */
    public PorterDuff.Mode f10018t = null;

    /* renamed from: u  reason: collision with root package name */
    public boolean f10019u = false;

    /* renamed from: v  reason: collision with root package name */
    public boolean f10020v = false;

    /* renamed from: w  reason: collision with root package name */
    public boolean f10021w = false;

    /* renamed from: x  reason: collision with root package name */
    public int f10022x = 16;

    /* renamed from: y  reason: collision with root package name */
    public int f10023y;

    /* renamed from: z  reason: collision with root package name */
    public View f10024z;

    public q(o oVar, int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        this.f10012n = oVar;
        this.f9999a = i11;
        this.f10000b = i10;
        this.f10001c = i12;
        this.f10002d = i13;
        this.f10003e = charSequence;
        this.f10023y = i14;
    }

    public static void c(int i10, int i11, String str, StringBuilder sb2) {
        if ((i10 & i11) == i11) {
            sb2.append(str);
        }
    }

    public final d a() {
        return this.A;
    }

    public final b b(d dVar) {
        d dVar2 = this.A;
        if (dVar2 != null) {
            dVar2.f10063b = null;
            dVar2.f10062a = null;
        }
        this.f10024z = null;
        this.A = dVar;
        this.f10012n.p(true);
        d dVar3 = this.A;
        if (dVar3 != null) {
            dVar3.h(new a(3, (Object) this));
        }
        return this;
    }

    public final boolean collapseActionView() {
        if ((this.f10023y & 8) == 0) {
            return false;
        }
        if (this.f10024z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f10012n.d(this);
        }
        return false;
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.f10021w && (this.f10019u || this.f10020v)) {
            drawable = f0.d.g(drawable).mutate();
            if (this.f10019u) {
                f0.b.h(drawable, this.f10017s);
            }
            if (this.f10020v) {
                f0.b.i(drawable, this.f10018t);
            }
            this.f10021w = false;
        }
        return drawable;
    }

    public final boolean e() {
        d dVar;
        if ((this.f10023y & 8) == 0) {
            return false;
        }
        if (this.f10024z == null && (dVar = this.A) != null) {
            this.f10024z = dVar.d(this);
        }
        return this.f10024z != null;
    }

    public final boolean expandActionView() {
        if (!e()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f10012n.f(this);
        }
        return false;
    }

    public final boolean f() {
        return (this.f10022x & 32) == 32;
    }

    public final void g(boolean z10) {
        this.f10022x = z10 ? this.f10022x | 32 : this.f10022x & -33;
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public final View getActionView() {
        View view = this.f10024z;
        if (view != null) {
            return view;
        }
        d dVar = this.A;
        if (dVar == null) {
            return null;
        }
        View d10 = dVar.d(this);
        this.f10024z = d10;
        return d10;
    }

    public final int getAlphabeticModifiers() {
        return this.f10009k;
    }

    public final char getAlphabeticShortcut() {
        return this.f10008j;
    }

    public final CharSequence getContentDescription() {
        return this.f10015q;
    }

    public final int getGroupId() {
        return this.f10000b;
    }

    public final Drawable getIcon() {
        Drawable drawable = this.f10010l;
        if (drawable != null) {
            return d(drawable);
        }
        int i10 = this.f10011m;
        if (i10 == 0) {
            return null;
        }
        Drawable a10 = h.a.a(this.f10012n.f9972a, i10);
        this.f10011m = 0;
        this.f10010l = a10;
        return d(a10);
    }

    public final ColorStateList getIconTintList() {
        return this.f10017s;
    }

    public final PorterDuff.Mode getIconTintMode() {
        return this.f10018t;
    }

    public final Intent getIntent() {
        return this.f10005g;
    }

    public final int getItemId() {
        return this.f9999a;
    }

    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public final int getNumericModifiers() {
        return this.f10007i;
    }

    public final char getNumericShortcut() {
        return this.f10006h;
    }

    public final int getOrder() {
        return this.f10001c;
    }

    public final SubMenu getSubMenu() {
        return this.f10013o;
    }

    public final CharSequence getTitle() {
        return this.f10003e;
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f10004f;
        return charSequence != null ? charSequence : this.f10003e;
    }

    public final CharSequence getTooltipText() {
        return this.f10016r;
    }

    public final boolean hasSubMenu() {
        return this.f10013o != null;
    }

    public final boolean isActionViewExpanded() {
        return this.C;
    }

    public final boolean isCheckable() {
        return (this.f10022x & 1) == 1;
    }

    public final boolean isChecked() {
        return (this.f10022x & 2) == 2;
    }

    public final boolean isEnabled() {
        return (this.f10022x & 16) != 0;
    }

    public final boolean isVisible() {
        d dVar = this.A;
        return (dVar == null || !dVar.g()) ? (this.f10022x & 8) == 0 : (this.f10022x & 8) == 0 && this.A.b();
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final MenuItem setActionView(int i10) {
        int i11;
        o oVar = this.f10012n;
        Context context = oVar.f9972a;
        View inflate = LayoutInflater.from(context).inflate(i10, new LinearLayout(context), false);
        this.f10024z = inflate;
        this.A = null;
        if (inflate != null && inflate.getId() == -1 && (i11 = this.f9999a) > 0) {
            inflate.setId(i11);
        }
        oVar.f9982k = true;
        oVar.p(true);
        return this;
    }

    public final MenuItem setAlphabeticShortcut(char c10) {
        if (this.f10008j == c10) {
            return this;
        }
        this.f10008j = Character.toLowerCase(c10);
        this.f10012n.p(false);
        return this;
    }

    public final MenuItem setCheckable(boolean z10) {
        int i10 = this.f10022x;
        boolean z11 = z10 | (i10 & true);
        this.f10022x = z11 ? 1 : 0;
        if (i10 != z11) {
            this.f10012n.p(false);
        }
        return this;
    }

    public final MenuItem setChecked(boolean z10) {
        boolean z11;
        int i10;
        int i11 = this.f10022x;
        int i12 = i11 & 4;
        o oVar = this.f10012n;
        int i13 = 2;
        if (i12 != 0) {
            oVar.getClass();
            ArrayList arrayList = oVar.f9977f;
            int size = arrayList.size();
            oVar.x();
            for (int i14 = 0; i14 < size; i14++) {
                q qVar = (q) arrayList.get(i14);
                if (qVar.f10000b == this.f10000b) {
                    boolean z12 = true;
                    if ((qVar.f10022x & 4) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11 && qVar.isCheckable()) {
                        if (qVar != this) {
                            z12 = false;
                        }
                        int i15 = qVar.f10022x;
                        int i16 = i15 & -3;
                        if (z12) {
                            i10 = 2;
                        } else {
                            i10 = 0;
                        }
                        int i17 = i10 | i16;
                        qVar.f10022x = i17;
                        if (i15 != i17) {
                            qVar.f10012n.p(false);
                        }
                    }
                }
            }
            oVar.w();
        } else {
            int i18 = i11 & -3;
            if (!z10) {
                i13 = 0;
            }
            int i19 = i13 | i18;
            this.f10022x = i19;
            if (i11 != i19) {
                oVar.p(false);
            }
        }
        return this;
    }

    public final MenuItem setEnabled(boolean z10) {
        this.f10022x = z10 ? this.f10022x | 16 : this.f10022x & -17;
        this.f10012n.p(false);
        return this;
    }

    public final MenuItem setIcon(int i10) {
        this.f10010l = null;
        this.f10011m = i10;
        this.f10021w = true;
        this.f10012n.p(false);
        return this;
    }

    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f10017s = colorStateList;
        this.f10019u = true;
        this.f10021w = true;
        this.f10012n.p(false);
        return this;
    }

    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f10018t = mode;
        this.f10020v = true;
        this.f10021w = true;
        this.f10012n.p(false);
        return this;
    }

    public final MenuItem setIntent(Intent intent) {
        this.f10005g = intent;
        return this;
    }

    public final MenuItem setNumericShortcut(char c10) {
        if (this.f10006h == c10) {
            return this;
        }
        this.f10006h = c10;
        this.f10012n.p(false);
        return this;
    }

    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.B = onActionExpandListener;
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f10014p = onMenuItemClickListener;
        return this;
    }

    public final MenuItem setShortcut(char c10, char c11) {
        this.f10006h = c10;
        this.f10008j = Character.toLowerCase(c11);
        this.f10012n.p(false);
        return this;
    }

    public final void setShowAsAction(int i10) {
        int i11 = i10 & 3;
        if (i11 == 0 || i11 == 1 || i11 == 2) {
            this.f10023y = i10;
            o oVar = this.f10012n;
            oVar.f9982k = true;
            oVar.p(true);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public final MenuItem setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    public final MenuItem setTitle(int i10) {
        setTitle((CharSequence) this.f10012n.f9972a.getString(i10));
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f10004f = charSequence;
        this.f10012n.p(false);
        return this;
    }

    public final MenuItem setVisible(boolean z10) {
        int i10;
        int i11 = this.f10022x;
        int i12 = i11 & -9;
        boolean z11 = false;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        int i13 = i10 | i12;
        this.f10022x = i13;
        if (i11 != i13) {
            z11 = true;
        }
        if (z11) {
            o oVar = this.f10012n;
            oVar.f9979h = true;
            oVar.p(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f10003e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public final MenuItem setAlphabeticShortcut(char c10, int i10) {
        if (this.f10008j == c10 && this.f10009k == i10) {
            return this;
        }
        this.f10008j = Character.toLowerCase(c10);
        this.f10009k = KeyEvent.normalizeMetaState(i10);
        this.f10012n.p(false);
        return this;
    }

    public final b setContentDescription(CharSequence charSequence) {
        this.f10015q = charSequence;
        this.f10012n.p(false);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.f10011m = 0;
        this.f10010l = drawable;
        this.f10021w = true;
        this.f10012n.p(false);
        return this;
    }

    public final MenuItem setNumericShortcut(char c10, int i10) {
        if (this.f10006h == c10 && this.f10007i == i10) {
            return this;
        }
        this.f10006h = c10;
        this.f10007i = KeyEvent.normalizeMetaState(i10);
        this.f10012n.p(false);
        return this;
    }

    public final MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f10006h = c10;
        this.f10007i = KeyEvent.normalizeMetaState(i10);
        this.f10008j = Character.toLowerCase(c11);
        this.f10009k = KeyEvent.normalizeMetaState(i11);
        this.f10012n.p(false);
        return this;
    }

    public final b setTooltipText(CharSequence charSequence) {
        this.f10016r = charSequence;
        this.f10012n.p(false);
        return this;
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.f10003e = charSequence;
        this.f10012n.p(false);
        i0 i0Var = this.f10013o;
        if (i0Var != null) {
            i0Var.setHeaderTitle(charSequence);
        }
        return this;
    }

    public final MenuItem setActionView(View view) {
        int i10;
        this.f10024z = view;
        this.A = null;
        if (view != null && view.getId() == -1 && (i10 = this.f9999a) > 0) {
            view.setId(i10);
        }
        o oVar = this.f10012n;
        oVar.f9982k = true;
        oVar.p(true);
        return this;
    }
}
