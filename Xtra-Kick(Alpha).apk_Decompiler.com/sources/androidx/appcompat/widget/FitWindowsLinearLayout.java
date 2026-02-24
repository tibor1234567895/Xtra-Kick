package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import g.v;
import m0.q2;

public class FitWindowsLinearLayout extends LinearLayout {

    /* renamed from: h  reason: collision with root package name */
    public p2 f640h;

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final boolean fitSystemWindows(Rect rect) {
        p2 p2Var = this.f640h;
        if (p2Var != null) {
            rect.top = ((v) p2Var).f6220i.a0((q2) null, rect);
        }
        return super.fitSystemWindows(rect);
    }

    public void setOnFitSystemWindowsListener(p2 p2Var) {
        this.f640h = p2Var;
    }
}
