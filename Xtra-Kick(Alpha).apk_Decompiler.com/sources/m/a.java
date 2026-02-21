package m;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import c0.c;
import c0.g;
import g0.b;
import m0.d;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f9874a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f9875b;

    /* renamed from: c  reason: collision with root package name */
    public Intent f9876c;

    /* renamed from: d  reason: collision with root package name */
    public char f9877d;

    /* renamed from: e  reason: collision with root package name */
    public int f9878e = 4096;

    /* renamed from: f  reason: collision with root package name */
    public char f9879f;

    /* renamed from: g  reason: collision with root package name */
    public int f9880g = 4096;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f9881h;

    /* renamed from: i  reason: collision with root package name */
    public final Context f9882i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f9883j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f9884k;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f9885l = null;

    /* renamed from: m  reason: collision with root package name */
    public PorterDuff.Mode f9886m = null;

    /* renamed from: n  reason: collision with root package name */
    public boolean f9887n = false;

    /* renamed from: o  reason: collision with root package name */
    public boolean f9888o = false;

    /* renamed from: p  reason: collision with root package name */
    public int f9889p = 16;

    public a(Context context, CharSequence charSequence) {
        this.f9882i = context;
        this.f9874a = charSequence;
    }

    public final d a() {
        return null;
    }

    public final b b(d dVar) {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        Drawable drawable = this.f9881h;
        if (drawable == null) {
            return;
        }
        if (this.f9887n || this.f9888o) {
            Drawable g10 = f0.d.g(drawable);
            this.f9881h = g10;
            Drawable mutate = g10.mutate();
            this.f9881h = mutate;
            if (this.f9887n) {
                f0.b.h(mutate, this.f9885l);
            }
            if (this.f9888o) {
                f0.b.i(this.f9881h, this.f9886m);
            }
        }
    }

    public final boolean collapseActionView() {
        return false;
    }

    public final boolean expandActionView() {
        return false;
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public final View getActionView() {
        return null;
    }

    public final int getAlphabeticModifiers() {
        return this.f9880g;
    }

    public final char getAlphabeticShortcut() {
        return this.f9879f;
    }

    public final CharSequence getContentDescription() {
        return this.f9883j;
    }

    public final int getGroupId() {
        return 0;
    }

    public final Drawable getIcon() {
        return this.f9881h;
    }

    public final ColorStateList getIconTintList() {
        return this.f9885l;
    }

    public final PorterDuff.Mode getIconTintMode() {
        return this.f9886m;
    }

    public final Intent getIntent() {
        return this.f9876c;
    }

    public final int getItemId() {
        return 16908332;
    }

    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public final int getNumericModifiers() {
        return this.f9878e;
    }

    public final char getNumericShortcut() {
        return this.f9877d;
    }

    public final int getOrder() {
        return 0;
    }

    public final SubMenu getSubMenu() {
        return null;
    }

    public final CharSequence getTitle() {
        return this.f9874a;
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f9875b;
        return charSequence != null ? charSequence : this.f9874a;
    }

    public final CharSequence getTooltipText() {
        return this.f9884k;
    }

    public final boolean hasSubMenu() {
        return false;
    }

    public final boolean isActionViewExpanded() {
        return false;
    }

    public final boolean isCheckable() {
        return (this.f9889p & 1) != 0;
    }

    public final boolean isChecked() {
        return (this.f9889p & 2) != 0;
    }

    public final boolean isEnabled() {
        return (this.f9889p & 16) != 0;
    }

    public final boolean isVisible() {
        return (this.f9889p & 8) == 0;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public final MenuItem setActionView(int i10) {
        throw new UnsupportedOperationException();
    }

    public final MenuItem setAlphabeticShortcut(char c10) {
        this.f9879f = Character.toLowerCase(c10);
        return this;
    }

    public final MenuItem setCheckable(boolean z10) {
        this.f9889p = z10 | (this.f9889p & true) ? 1 : 0;
        return this;
    }

    public final MenuItem setChecked(boolean z10) {
        this.f9889p = (z10 ? 2 : 0) | (this.f9889p & -3);
        return this;
    }

    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f9883j = charSequence;
        return this;
    }

    public final MenuItem setEnabled(boolean z10) {
        this.f9889p = (z10 ? 16 : 0) | (this.f9889p & -17);
        return this;
    }

    public final MenuItem setIcon(int i10) {
        Object obj = g.f2717a;
        this.f9881h = c.b(this.f9882i, i10);
        c();
        return this;
    }

    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f9885l = colorStateList;
        this.f9887n = true;
        c();
        return this;
    }

    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f9886m = mode;
        this.f9888o = true;
        c();
        return this;
    }

    public final MenuItem setIntent(Intent intent) {
        this.f9876c = intent;
        return this;
    }

    public final MenuItem setNumericShortcut(char c10) {
        this.f9877d = c10;
        return this;
    }

    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    public final MenuItem setShortcut(char c10, char c11) {
        this.f9877d = c10;
        this.f9879f = Character.toLowerCase(c11);
        return this;
    }

    public final void setShowAsAction(int i10) {
    }

    public final MenuItem setShowAsActionFlags(int i10) {
        return this;
    }

    public final MenuItem setTitle(int i10) {
        this.f9874a = this.f9882i.getResources().getString(i10);
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f9875b = charSequence;
        return this;
    }

    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f9884k = charSequence;
        return this;
    }

    public final MenuItem setVisible(boolean z10) {
        int i10 = 8;
        int i11 = this.f9889p & 8;
        if (z10) {
            i10 = 0;
        }
        this.f9889p = i11 | i10;
        return this;
    }

    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public final MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f9879f = Character.toLowerCase(c10);
        this.f9880g = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    /* renamed from: setContentDescription  reason: collision with other method in class */
    public final b m13setContentDescription(CharSequence charSequence) {
        this.f9883j = charSequence;
        return this;
    }

    public final MenuItem setNumericShortcut(char c10, int i10) {
        this.f9877d = c10;
        this.f9878e = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    public final MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f9877d = c10;
        this.f9878e = KeyEvent.normalizeMetaState(i10);
        this.f9879f = Character.toLowerCase(c11);
        this.f9880g = KeyEvent.normalizeMetaState(i11);
        return this;
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.f9874a = charSequence;
        return this;
    }

    /* renamed from: setTooltipText  reason: collision with other method in class */
    public final b m14setTooltipText(CharSequence charSequence) {
        this.f9884k = charSequence;
        return this;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.f9881h = drawable;
        c();
        return this;
    }
}
