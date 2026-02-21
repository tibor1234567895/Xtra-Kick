package m;

import android.view.MenuItem;

public final class v implements MenuItem.OnMenuItemClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final MenuItem.OnMenuItemClickListener f10031h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ w f10032i;

    public v(w wVar, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f10032i = wVar;
        this.f10031h = onMenuItemClickListener;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return this.f10031h.onMenuItemClick(this.f10032i.f(menuItem));
    }
}
