package x;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import u.n;

public abstract class r extends b {

    /* renamed from: o  reason: collision with root package name */
    public boolean f16508o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f16509p;

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void e(ConstraintLayout constraintLayout) {
        d(constraintLayout);
    }

    public void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, p.f16499b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == 6) {
                    this.f16508o = true;
                } else if (index == 22) {
                    this.f16509p = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public abstract void j(n nVar, int i10, int i11);

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f16508o || this.f16509p) {
            ViewParent parent = getParent();
            if (parent instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) parent;
                int visibility = getVisibility();
                float elevation = getElevation();
                for (int i10 = 0; i10 < this.f16348i; i10++) {
                    View view = (View) constraintLayout.f1169h.get(this.f16347h[i10]);
                    if (view != null) {
                        if (this.f16508o) {
                            view.setVisibility(visibility);
                        }
                        if (this.f16509p && elevation > 0.0f) {
                            view.setTranslationZ(view.getTranslationZ() + elevation);
                        }
                    }
                }
            }
        }
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            d((ConstraintLayout) parent);
        }
    }

    public void setVisibility(int i10) {
        super.setVisibility(i10);
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            d((ConstraintLayout) parent);
        }
    }
}
