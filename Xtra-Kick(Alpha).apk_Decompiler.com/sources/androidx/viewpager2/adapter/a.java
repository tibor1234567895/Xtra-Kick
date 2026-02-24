package androidx.viewpager2.adapter;

import android.view.View;
import android.widget.FrameLayout;

public final class a implements View.OnLayoutChangeListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ FrameLayout f2289h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ h f2290i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ g f2291j;

    public a(g gVar, FrameLayout frameLayout, h hVar) {
        this.f2291j = gVar;
        this.f2289h = frameLayout;
        this.f2290i = hVar;
    }

    public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        FrameLayout frameLayout = this.f2289h;
        if (frameLayout.getParent() != null) {
            frameLayout.removeOnLayoutChangeListener(this);
            this.f2291j.f(this.f2290i);
        }
    }
}
