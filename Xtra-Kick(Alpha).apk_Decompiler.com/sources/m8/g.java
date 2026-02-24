package m8;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.t2;
import v7.a;

public abstract class g extends t2 {
    public final boolean A = true;
    public boolean B = false;

    /* renamed from: w  reason: collision with root package name */
    public Drawable f10764w;

    /* renamed from: x  reason: collision with root package name */
    public final Rect f10765x = new Rect();

    /* renamed from: y  reason: collision with root package name */
    public final Rect f10766y = new Rect();

    /* renamed from: z  reason: collision with root package name */
    public int f10767z = 119;

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        TypedArray d10 = r.d(context, attributeSet, a.f15945n, 0, 0, new int[0]);
        this.f10767z = d10.getInt(1, this.f10767z);
        Drawable drawable = d10.getDrawable(0);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.A = d10.getBoolean(2, true);
        d10.recycle();
    }

    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f10764w;
        if (drawable != null) {
            if (this.B) {
                this.B = false;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                boolean z10 = this.A;
                Rect rect = this.f10765x;
                if (z10) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                int i10 = this.f10767z;
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Rect rect2 = this.f10766y;
                Gravity.apply(i10, intrinsicWidth, intrinsicHeight, rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    public final void drawableHotspotChanged(float f10, float f11) {
        super.drawableHotspotChanged(f10, f11);
        Drawable drawable = this.f10764w;
        if (drawable != null) {
            drawable.setHotspot(f10, f11);
        }
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f10764w;
        if (drawable != null && drawable.isStateful()) {
            this.f10764w.setState(getDrawableState());
        }
    }

    public Drawable getForeground() {
        return this.f10764w;
    }

    public int getForegroundGravity() {
        return this.f10767z;
    }

    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f10764w;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.B = z10 | this.B;
    }

    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.B = true;
    }

    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f10764w;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.f10764w);
            }
            this.f10764w = drawable;
            this.B = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f10767z == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setForegroundGravity(int i10) {
        if (this.f10767z != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.f10767z = i10;
            if (i10 == 119 && this.f10764w != null) {
                this.f10764w.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f10764w;
    }
}
