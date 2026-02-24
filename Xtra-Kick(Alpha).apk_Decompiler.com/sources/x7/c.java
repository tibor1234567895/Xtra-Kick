package x7;

import android.view.KeyEvent;
import android.view.View;
import com.google.android.material.appbar.AppBarLayout;

public final /* synthetic */ class c implements View.OnKeyListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f16717h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ View f16718i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f16719j;

    public /* synthetic */ c(AppBarLayout.BaseBehavior baseBehavior, View view, AppBarLayout appBarLayout) {
        this.f16717h = baseBehavior;
        this.f16718i = view;
        this.f16719j = appBarLayout;
    }

    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        this.f16717h.getClass();
        AppBarLayout.BaseBehavior.C(keyEvent, this.f16718i, this.f16719j);
        return false;
    }
}
