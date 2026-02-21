package x7;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import v7.a;

public final class i extends FrameLayout.LayoutParams {

    /* renamed from: a  reason: collision with root package name */
    public final int f16727a = 0;

    /* renamed from: b  reason: collision with root package name */
    public float f16728b = 0.5f;

    public i() {
        super(-1, -1);
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f15941j);
        this.f16727a = obtainStyledAttributes.getInt(0, 0);
        this.f16728b = obtainStyledAttributes.getFloat(1, 0.5f);
        obtainStyledAttributes.recycle();
    }

    public i(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }
}
