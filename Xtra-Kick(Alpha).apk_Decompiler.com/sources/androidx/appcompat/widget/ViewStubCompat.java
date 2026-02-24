package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import f.a;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {

    /* renamed from: h  reason: collision with root package name */
    public int f710h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f711i;

    /* renamed from: j  reason: collision with root package name */
    public WeakReference f712j;

    /* renamed from: k  reason: collision with root package name */
    public LayoutInflater f713k;

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C, 0, 0);
        this.f711i = obtainStyledAttributes.getResourceId(2, -1);
        this.f710h = obtainStyledAttributes.getResourceId(1, 0);
        setId(obtainStyledAttributes.getResourceId(0, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public final View a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f710h != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            LayoutInflater layoutInflater = this.f713k;
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.f710h, viewGroup, false);
            int i10 = this.f711i;
            if (i10 != -1) {
                inflate.setId(i10);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f712j = new WeakReference(inflate);
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    public final void dispatchDraw(Canvas canvas) {
    }

    public final void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f711i;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f713k;
    }

    public int getLayoutResource() {
        return this.f710h;
    }

    public final void onMeasure(int i10, int i11) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i10) {
        this.f711i = i10;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f713k = layoutInflater;
    }

    public void setLayoutResource(int i10) {
        this.f710h = i10;
    }

    public void setOnInflateListener(k5 k5Var) {
    }

    public void setVisibility(int i10) {
        WeakReference weakReference = this.f712j;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view != null) {
                view.setVisibility(i10);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i10);
        if (i10 == 0 || i10 == 4) {
            a();
        }
    }
}
