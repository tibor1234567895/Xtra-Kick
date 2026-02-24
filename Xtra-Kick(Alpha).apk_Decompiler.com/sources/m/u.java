package m;

import android.view.MenuItem;

public final class u implements MenuItem.OnActionExpandListener {

    /* renamed from: a  reason: collision with root package name */
    public final MenuItem.OnActionExpandListener f10029a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ w f10030b;

    public u(w wVar, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f10030b = wVar;
        this.f10029a = onActionExpandListener;
    }

    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f10029a.onMenuItemActionCollapse(this.f10030b.f(menuItem));
    }

    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f10029a.onMenuItemActionExpand(this.f10030b.f(menuItem));
    }
}
