package m;

import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import e.a;

public final class s extends r implements ActionProvider.VisibilityListener {

    /* renamed from: e  reason: collision with root package name */
    public a f10027e;

    public s(w wVar, ActionProvider actionProvider) {
        super(wVar, actionProvider);
    }

    public final boolean b() {
        return this.f10025c.isVisible();
    }

    public final View d(MenuItem menuItem) {
        return this.f10025c.onCreateActionView(menuItem);
    }

    public final boolean g() {
        return this.f10025c.overridesItemVisibility();
    }

    public final void h(a aVar) {
        this.f10027e = aVar;
        this.f10025c.setVisibilityListener(this);
    }

    public final void onActionProviderVisibilityChanged(boolean z10) {
        a aVar = this.f10027e;
        if (aVar != null) {
            o oVar = ((q) aVar.f4852i).f10012n;
            oVar.f9979h = true;
            oVar.p(true);
        }
    }
}
