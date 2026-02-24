package androidx.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import jb.q;
import jb.r;

public final /* synthetic */ class v implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f529a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f530b;

    public /* synthetic */ v(r rVar, View view) {
        this.f529a = rVar;
        this.f530b = view;
    }

    public final void onScrollChanged() {
        Rect rect = new Rect();
        this.f530b.getGlobalVisibleRect(rect);
        ((q) this.f529a).h(rect);
    }
}
