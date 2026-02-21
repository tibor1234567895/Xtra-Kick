package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.v4.media.h;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.appcompat.widget.d;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.woxthebox.draglistview.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
import n8.a;
import z.b;

public class HideBottomViewOnScrollBehavior<V extends View> extends b {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashSet f3645a = new LinkedHashSet();

    /* renamed from: b  reason: collision with root package name */
    public int f3646b;

    /* renamed from: c  reason: collision with root package name */
    public int f3647c;

    /* renamed from: d  reason: collision with root package name */
    public TimeInterpolator f3648d;

    /* renamed from: e  reason: collision with root package name */
    public TimeInterpolator f3649e;

    /* renamed from: f  reason: collision with root package name */
    public int f3650f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f3651g = 2;

    /* renamed from: h  reason: collision with root package name */
    public ViewPropertyAnimator f3652h;

    public HideBottomViewOnScrollBehavior() {
    }

    public boolean h(CoordinatorLayout coordinatorLayout, View view, int i10) {
        this.f3650f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f3646b = a.c(view.getContext(), R.attr.motionDurationLong2, 225);
        this.f3647c = a.c(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.f3648d = a.d(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, w7.a.f16156d);
        this.f3649e = a.d(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, w7.a.f16155c);
        return false;
    }

    public final void l(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int[] iArr) {
        boolean z10;
        LinkedHashSet linkedHashSet = this.f3645a;
        boolean z11 = false;
        if (i10 > 0) {
            if (this.f3651g == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                ViewPropertyAnimator viewPropertyAnimator = this.f3652h;
                if (viewPropertyAnimator != null) {
                    viewPropertyAnimator.cancel();
                    view.clearAnimation();
                }
                this.f3651g = 1;
                Iterator it = linkedHashSet.iterator();
                if (!it.hasNext()) {
                    s(view, this.f3650f + 0, (long) this.f3647c, this.f3649e);
                    return;
                }
                h.y(it.next());
                throw null;
            }
        } else if (i10 < 0) {
            if (this.f3651g == 2) {
                z11 = true;
            }
            if (!z11) {
                ViewPropertyAnimator viewPropertyAnimator2 = this.f3652h;
                if (viewPropertyAnimator2 != null) {
                    viewPropertyAnimator2.cancel();
                    view.clearAnimation();
                }
                this.f3651g = 2;
                Iterator it2 = linkedHashSet.iterator();
                if (!it2.hasNext()) {
                    s(view, 0, (long) this.f3646b, this.f3648d);
                    return;
                }
                h.y(it2.next());
                throw null;
            }
        }
    }

    public boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11) {
        return i10 == 2;
    }

    public final void s(View view, int i10, long j10, TimeInterpolator timeInterpolator) {
        this.f3652h = view.animate().translationY((float) i10).setInterpolator(timeInterpolator).setDuration(j10).setListener(new d(3, this));
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(0);
    }
}
