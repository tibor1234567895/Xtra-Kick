package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.woxthebox.draglistview.R;
import f.a;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;

public class ActionBarContainer extends FrameLayout {

    /* renamed from: h  reason: collision with root package name */
    public boolean f576h;

    /* renamed from: i  reason: collision with root package name */
    public View f577i;

    /* renamed from: j  reason: collision with root package name */
    public View f578j;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f579k;

    /* renamed from: l  reason: collision with root package name */
    public Drawable f580l;

    /* renamed from: m  reason: collision with root package name */
    public Drawable f581m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f582n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f583o;

    /* renamed from: p  reason: collision with root package name */
    public final int f584p;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b bVar = new b(this);
        WeakHashMap weakHashMap = c1.f10054a;
        i0.q(this, bVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f5391a);
        boolean z10 = false;
        this.f579k = obtainStyledAttributes.getDrawable(0);
        this.f580l = obtainStyledAttributes.getDrawable(2);
        this.f584p = obtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.f582n = true;
            this.f581m = obtainStyledAttributes.getDrawable(1);
        }
        obtainStyledAttributes.recycle();
        if (!this.f582n ? this.f579k == null && this.f580l == null : this.f581m == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f579k;
        if (drawable != null && drawable.isStateful()) {
            this.f579k.setState(getDrawableState());
        }
        Drawable drawable2 = this.f580l;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f580l.setState(getDrawableState());
        }
        Drawable drawable3 = this.f581m;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f581m.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return null;
    }

    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f579k;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f580l;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f581m;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f577i = findViewById(R.id.action_bar);
        this.f578j = findViewById(R.id.action_context_bar);
    }

    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f576h || super.onInterceptTouchEvent(motionEvent);
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        Drawable drawable;
        View view;
        int i16;
        super.onLayout(z10, i10, i11, i12, i13);
        boolean z11 = true;
        if (this.f582n) {
            Drawable drawable2 = this.f581m;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z11 = false;
            }
        } else {
            if (this.f579k != null) {
                if (this.f577i.getVisibility() == 0) {
                    drawable = this.f579k;
                    i15 = this.f577i.getLeft();
                    i14 = this.f577i.getTop();
                    i16 = this.f577i.getRight();
                    view = this.f577i;
                } else {
                    View view2 = this.f578j;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f579k.setBounds(0, 0, 0, 0);
                    } else {
                        drawable = this.f579k;
                        i15 = this.f578j.getLeft();
                        i14 = this.f578j.getTop();
                        i16 = this.f578j.getRight();
                        view = this.f578j;
                    }
                }
                drawable.setBounds(i15, i14, i16, view.getBottom());
            } else {
                z11 = false;
            }
            this.f583o = false;
        }
        if (z11) {
            invalidate();
        }
    }

    public final void onMeasure(int i10, int i11) {
        int i12;
        if (this.f577i == null && View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE && (i12 = this.f584p) >= 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(i12, View.MeasureSpec.getSize(i11)), RecyclerView.UNDEFINED_DURATION);
        }
        super.onMeasure(i10, i11);
        if (this.f577i != null) {
            View.MeasureSpec.getMode(i11);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f579k;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f579k);
        }
        this.f579k = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f577i;
            if (view != null) {
                this.f579k.setBounds(view.getLeft(), this.f577i.getTop(), this.f577i.getRight(), this.f577i.getBottom());
            }
        }
        boolean z10 = true;
        if (!this.f582n ? !(this.f579k == null && this.f580l == null) : this.f581m != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f581m;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f581m);
        }
        this.f581m = drawable;
        boolean z10 = this.f582n;
        boolean z11 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z10 && (drawable2 = this.f581m) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z10 ? this.f579k == null && this.f580l == null : this.f581m == null) {
            z11 = true;
        }
        setWillNotDraw(z11);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z10;
        Drawable drawable2 = this.f580l;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f580l);
        }
        this.f580l = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f583o && this.f580l != null) {
                throw null;
            }
        }
        if (!this.f582n ? !(this.f579k == null && this.f580l == null) : this.f581m != null) {
            z10 = false;
        } else {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(t3 t3Var) {
    }

    public void setTransitioning(boolean z10) {
        this.f576h = z10;
        setDescendantFocusability(z10 ? 393216 : 262144);
    }

    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f579k;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
        Drawable drawable2 = this.f580l;
        if (drawable2 != null) {
            drawable2.setVisible(z10, false);
        }
        Drawable drawable3 = this.f581m;
        if (drawable3 != null) {
            drawable3.setVisible(z10, false);
        }
    }

    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f579k;
        boolean z10 = this.f582n;
        return (drawable == drawable2 && !z10) || (drawable == this.f580l && this.f583o) || ((drawable == this.f581m && z10) || super.verifyDrawable(drawable));
    }

    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i10) {
        if (i10 != 0) {
            return super.startActionModeForChild(view, callback, i10);
        }
        return null;
    }
}
