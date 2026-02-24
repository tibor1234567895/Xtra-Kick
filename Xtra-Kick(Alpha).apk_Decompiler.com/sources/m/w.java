package m;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import g0.b;
import java.lang.reflect.Method;
import m0.d;

public final class w extends d implements MenuItem {

    /* renamed from: d  reason: collision with root package name */
    public final b f10033d;

    /* renamed from: e  reason: collision with root package name */
    public Method f10034e;

    public w(Context context, b bVar) {
        super(context);
        if (bVar != null) {
            this.f10033d = bVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public final boolean collapseActionView() {
        return this.f10033d.collapseActionView();
    }

    public final boolean expandActionView() {
        return this.f10033d.expandActionView();
    }

    public final ActionProvider getActionProvider() {
        d a10 = this.f10033d.a();
        if (a10 instanceof r) {
            return ((r) a10).f10025c;
        }
        return null;
    }

    public final View getActionView() {
        View actionView = this.f10033d.getActionView();
        if (actionView instanceof t) {
            return (View) ((t) actionView).f10028h;
        }
        return actionView;
    }

    public final int getAlphabeticModifiers() {
        return this.f10033d.getAlphabeticModifiers();
    }

    public final char getAlphabeticShortcut() {
        return this.f10033d.getAlphabeticShortcut();
    }

    public final CharSequence getContentDescription() {
        return this.f10033d.getContentDescription();
    }

    public final int getGroupId() {
        return this.f10033d.getGroupId();
    }

    public final Drawable getIcon() {
        return this.f10033d.getIcon();
    }

    public final ColorStateList getIconTintList() {
        return this.f10033d.getIconTintList();
    }

    public final PorterDuff.Mode getIconTintMode() {
        return this.f10033d.getIconTintMode();
    }

    public final Intent getIntent() {
        return this.f10033d.getIntent();
    }

    public final int getItemId() {
        return this.f10033d.getItemId();
    }

    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f10033d.getMenuInfo();
    }

    public final int getNumericModifiers() {
        return this.f10033d.getNumericModifiers();
    }

    public final char getNumericShortcut() {
        return this.f10033d.getNumericShortcut();
    }

    public final int getOrder() {
        return this.f10033d.getOrder();
    }

    public final SubMenu getSubMenu() {
        return this.f10033d.getSubMenu();
    }

    public final CharSequence getTitle() {
        return this.f10033d.getTitle();
    }

    public final CharSequence getTitleCondensed() {
        return this.f10033d.getTitleCondensed();
    }

    public final CharSequence getTooltipText() {
        return this.f10033d.getTooltipText();
    }

    public final boolean hasSubMenu() {
        return this.f10033d.hasSubMenu();
    }

    public final boolean isActionViewExpanded() {
        return this.f10033d.isActionViewExpanded();
    }

    public final boolean isCheckable() {
        return this.f10033d.isCheckable();
    }

    public final boolean isChecked() {
        return this.f10033d.isChecked();
    }

    public final boolean isEnabled() {
        return this.f10033d.isEnabled();
    }

    public final boolean isVisible() {
        return this.f10033d.isVisible();
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        s sVar = new s(this, actionProvider);
        if (actionProvider == null) {
            sVar = null;
        }
        this.f10033d.b(sVar);
        return this;
    }

    public final MenuItem setActionView(int i10) {
        b bVar = this.f10033d;
        bVar.setActionView(i10);
        View actionView = bVar.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            bVar.setActionView(new t(actionView));
        }
        return this;
    }

    public final MenuItem setAlphabeticShortcut(char c10) {
        this.f10033d.setAlphabeticShortcut(c10);
        return this;
    }

    public final MenuItem setCheckable(boolean z10) {
        this.f10033d.setCheckable(z10);
        return this;
    }

    public final MenuItem setChecked(boolean z10) {
        this.f10033d.setChecked(z10);
        return this;
    }

    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f10033d.setContentDescription(charSequence);
        return this;
    }

    public final MenuItem setEnabled(boolean z10) {
        this.f10033d.setEnabled(z10);
        return this;
    }

    public final MenuItem setIcon(int i10) {
        this.f10033d.setIcon(i10);
        return this;
    }

    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f10033d.setIconTintList(colorStateList);
        return this;
    }

    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f10033d.setIconTintMode(mode);
        return this;
    }

    public final MenuItem setIntent(Intent intent) {
        this.f10033d.setIntent(intent);
        return this;
    }

    public final MenuItem setNumericShortcut(char c10) {
        this.f10033d.setNumericShortcut(c10);
        return this;
    }

    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f10033d.setOnActionExpandListener(onActionExpandListener != null ? new u(this, onActionExpandListener) : null);
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f10033d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new v(this, onMenuItemClickListener) : null);
        return this;
    }

    public final MenuItem setShortcut(char c10, char c11) {
        this.f10033d.setShortcut(c10, c11);
        return this;
    }

    public final void setShowAsAction(int i10) {
        this.f10033d.setShowAsAction(i10);
    }

    public final MenuItem setShowAsActionFlags(int i10) {
        this.f10033d.setShowAsActionFlags(i10);
        return this;
    }

    public final MenuItem setTitle(int i10) {
        this.f10033d.setTitle(i10);
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f10033d.setTitleCondensed(charSequence);
        return this;
    }

    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f10033d.setTooltipText(charSequence);
        return this;
    }

    public final MenuItem setVisible(boolean z10) {
        return this.f10033d.setVisible(z10);
    }

    public final MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new t(view);
        }
        this.f10033d.setActionView(view);
        return this;
    }

    public final MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f10033d.setAlphabeticShortcut(c10, i10);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.f10033d.setIcon(drawable);
        return this;
    }

    public final MenuItem setNumericShortcut(char c10, int i10) {
        this.f10033d.setNumericShortcut(c10, i10);
        return this;
    }

    public final MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f10033d.setShortcut(c10, c11, i10, i11);
        return this;
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.f10033d.setTitle(charSequence);
        return this;
    }
}
