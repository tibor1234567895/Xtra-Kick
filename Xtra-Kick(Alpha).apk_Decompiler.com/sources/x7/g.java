package x7;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import v7.a;

public final class g extends LinearLayout.LayoutParams {

    /* renamed from: a  reason: collision with root package name */
    public int f16722a = 1;

    /* renamed from: b  reason: collision with root package name */
    public f f16723b;

    /* renamed from: c  reason: collision with root package name */
    public final Interpolator f16724c;

    public g() {
        super(-1, -2);
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f15933b);
        this.f16722a = obtainStyledAttributes.getInt(1, 0);
        this.f16723b = obtainStyledAttributes.getInt(0, 0) != 1 ? null : new f();
        if (obtainStyledAttributes.hasValue(2)) {
            this.f16724c = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(2, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public g(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public g(LinearLayout.LayoutParams layoutParams) {
        super(layoutParams);
    }
}
