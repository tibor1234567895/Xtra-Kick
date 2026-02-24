package g;

import android.view.View;
import android.widget.AbsListView;

public final class e implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f6058a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f6059b;

    public e(View view, View view2) {
        this.f6058a = view;
        this.f6059b = view2;
    }

    public final void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        k.b(absListView, this.f6058a, this.f6059b);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i10) {
    }
}
