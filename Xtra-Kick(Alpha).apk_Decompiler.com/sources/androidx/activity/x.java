package androidx.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import jb.q;
import jb.r;
import xa.j;

public final class x implements View.OnAttachStateChangeListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ r f536h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ View f537i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserver.OnScrollChangedListener f538j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ View.OnLayoutChangeListener f539k;

    public x(r rVar, View view, v vVar, u uVar) {
        this.f536h = rVar;
        this.f537i = view;
        this.f538j = vVar;
        this.f539k = uVar;
    }

    public final void onViewAttachedToWindow(View view) {
        j.f("v", view);
        Rect rect = new Rect();
        View view2 = this.f537i;
        view2.getGlobalVisibleRect(rect);
        ((q) this.f536h).h(rect);
        view2.getViewTreeObserver().addOnScrollChangedListener(this.f538j);
        view2.addOnLayoutChangeListener(this.f539k);
    }

    public final void onViewDetachedFromWindow(View view) {
        j.f("v", view);
        view.getViewTreeObserver().removeOnScrollChangedListener(this.f538j);
        view.removeOnLayoutChangeListener(this.f539k);
    }
}
