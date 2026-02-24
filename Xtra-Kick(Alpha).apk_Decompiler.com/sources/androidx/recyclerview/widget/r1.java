package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class r1 extends ViewGroup.MarginLayoutParams {

    /* renamed from: h  reason: collision with root package name */
    public k2 f2184h;

    /* renamed from: i  reason: collision with root package name */
    public final Rect f2185i = new Rect();

    /* renamed from: j  reason: collision with root package name */
    public boolean f2186j = true;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2187k = false;

    public r1(int i10, int i11) {
        super(i10, i11);
    }

    public final int u() {
        return this.f2184h.getLayoutPosition();
    }

    public final boolean v() {
        return this.f2184h.isUpdated();
    }

    public final boolean w() {
        return this.f2184h.isRemoved();
    }

    public r1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public r1(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public r1(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public r1(r1 r1Var) {
        super(r1Var);
    }
}
