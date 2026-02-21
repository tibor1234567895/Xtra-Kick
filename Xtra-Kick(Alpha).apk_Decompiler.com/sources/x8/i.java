package x8;

import android.view.View;

public final class i implements View.OnLayoutChangeListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ View f16764h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ j f16765i;

    public i(j jVar, View view) {
        this.f16765i = jVar;
        this.f16764h = view;
    }

    public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        View view2 = this.f16764h;
        if (view2.getVisibility() == 0) {
            this.f16765i.d(view2);
        }
    }
}
