package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import g.a;

public final class z4 extends a {

    /* renamed from: b  reason: collision with root package name */
    public int f1154b = 0;

    public z4() {
        this.f6019a = 8388627;
    }

    public z4(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public z4(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public z4(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super((ViewGroup.LayoutParams) marginLayoutParams);
        this.leftMargin = marginLayoutParams.leftMargin;
        this.topMargin = marginLayoutParams.topMargin;
        this.rightMargin = marginLayoutParams.rightMargin;
        this.bottomMargin = marginLayoutParams.bottomMargin;
    }

    public z4(z4 z4Var) {
        super((a) z4Var);
        this.f1154b = z4Var.f1154b;
    }

    public z4(a aVar) {
        super(aVar);
    }
}
