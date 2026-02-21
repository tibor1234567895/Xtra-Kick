package x7;

import android.view.KeyEvent;
import android.view.View;
import com.google.android.material.appbar.AppBarLayout;

public final /* synthetic */ class b implements View.OnUnhandledKeyEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f16714a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f16715b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f16716c;

    public /* synthetic */ b(AppBarLayout.BaseBehavior baseBehavior, View view, AppBarLayout appBarLayout) {
        this.f16714a = baseBehavior;
        this.f16715b = view;
        this.f16716c = appBarLayout;
    }

    public final boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        AppBarLayout.BaseBehavior baseBehavior = this.f16714a;
        View view2 = this.f16715b;
        AppBarLayout appBarLayout = this.f16716c;
        baseBehavior.getClass();
        AppBarLayout.BaseBehavior.C(keyEvent, view2, appBarLayout);
        return false;
    }
}
