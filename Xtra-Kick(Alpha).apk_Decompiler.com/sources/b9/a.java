package b9;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.transformation.ExpandableBehavior;

public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ View f2695h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f2696i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ k8.a f2697j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ExpandableBehavior f2698k;

    public a(ExpandableBehavior expandableBehavior, View view, int i10, k8.a aVar) {
        this.f2698k = expandableBehavior;
        this.f2695h = view;
        this.f2696i = i10;
        this.f2697j = aVar;
    }

    public final boolean onPreDraw() {
        View view = this.f2695h;
        view.getViewTreeObserver().removeOnPreDrawListener(this);
        ExpandableBehavior expandableBehavior = this.f2698k;
        if (expandableBehavior.f3960a == this.f2696i) {
            k8.a aVar = this.f2697j;
            expandableBehavior.s((View) aVar, view, ((FloatingActionButton) aVar).f3824v.f9254b, false);
        }
        return false;
    }
}
