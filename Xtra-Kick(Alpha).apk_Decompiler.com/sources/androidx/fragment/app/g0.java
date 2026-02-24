package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import m0.b0;

public final class g0 extends AnimationSet implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final ViewGroup f1430h;

    /* renamed from: i  reason: collision with root package name */
    public final View f1431i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1432j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1433k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1434l = true;

    public g0(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f1430h = viewGroup;
        this.f1431i = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    public final boolean getTransformation(long j10, Transformation transformation) {
        this.f1434l = true;
        if (this.f1432j) {
            return !this.f1433k;
        }
        if (!super.getTransformation(j10, transformation)) {
            this.f1432j = true;
            b0.a(this.f1430h, this);
        }
        return true;
    }

    public final void run() {
        boolean z10 = this.f1432j;
        ViewGroup viewGroup = this.f1430h;
        if (z10 || !this.f1434l) {
            viewGroup.endViewTransition(this.f1431i);
            this.f1433k = true;
            return;
        }
        this.f1434l = false;
        viewGroup.post(this);
    }

    public final boolean getTransformation(long j10, Transformation transformation, float f10) {
        this.f1434l = true;
        if (this.f1432j) {
            return !this.f1433k;
        }
        if (!super.getTransformation(j10, transformation, f10)) {
            this.f1432j = true;
            b0.a(this.f1430h, this);
        }
        return true;
    }
}
