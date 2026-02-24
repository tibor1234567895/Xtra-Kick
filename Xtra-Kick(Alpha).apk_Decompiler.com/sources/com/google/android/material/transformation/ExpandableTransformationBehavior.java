package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.d;

@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* renamed from: b  reason: collision with root package name */
    public AnimatorSet f3961b;

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void s(View view, View view2, boolean z10, boolean z11) {
        AnimatorSet animatorSet = this.f3961b;
        boolean z12 = animatorSet != null;
        if (z12) {
            animatorSet.cancel();
        }
        AnimatorSet t10 = t(view, view2, z10, z12);
        this.f3961b = t10;
        t10.addListener(new d(8, this));
        this.f3961b.start();
        if (!z11) {
            this.f3961b.end();
        }
    }

    public abstract AnimatorSet t(View view, View view2, boolean z10, boolean z11);
}
