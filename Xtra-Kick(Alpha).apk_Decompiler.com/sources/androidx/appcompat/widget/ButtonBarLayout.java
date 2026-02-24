package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.woxthebox.draglistview.R;
import f.a;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;

public class ButtonBarLayout extends LinearLayout {

    /* renamed from: h  reason: collision with root package name */
    public boolean f628h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f629i;

    /* renamed from: j  reason: collision with root package name */
    public int f630j = -1;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int[] iArr = a.f5402l;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        c1.o(this, context, iArr, attributeSet, obtainStyledAttributes, 0);
        this.f628h = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f628h);
        }
    }

    private void setStacked(boolean z10) {
        if (this.f629i == z10) {
            return;
        }
        if (!z10 || this.f628h) {
            this.f629i = z10;
            setOrientation(z10 ? 1 : 0);
            setGravity(z10 ? 8388613 : 80);
            View findViewById = findViewById(R.id.spacer);
            if (findViewById != null) {
                findViewById.setVisibility(z10 ? 8 : 4);
            }
            for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                bringChildToFront(getChildAt(childCount));
            }
        }
    }

    public final void onMeasure(int i10, int i11) {
        boolean z10;
        int i12;
        int i13;
        int i14;
        boolean z11;
        int size = View.MeasureSpec.getSize(i10);
        int i15 = 0;
        if (this.f628h) {
            if (size > this.f630j && this.f629i) {
                setStacked(false);
            }
            this.f630j = size;
        }
        if (this.f629i || View.MeasureSpec.getMode(i10) != 1073741824) {
            i12 = i10;
            z10 = false;
        } else {
            i12 = View.MeasureSpec.makeMeasureSpec(size, RecyclerView.UNDEFINED_DURATION);
            z10 = true;
        }
        super.onMeasure(i12, i11);
        if (this.f628h && !this.f629i) {
            if ((getMeasuredWidthAndState() & -16777216) == 16777216) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                setStacked(true);
                z10 = true;
            }
        }
        if (z10) {
            super.onMeasure(i10, i11);
        }
        int childCount = getChildCount();
        int i16 = 0;
        while (true) {
            i13 = -1;
            if (i16 >= childCount) {
                i16 = -1;
                break;
            } else if (getChildAt(i16).getVisibility() == 0) {
                break;
            } else {
                i16++;
            }
        }
        if (i16 >= 0) {
            View childAt = getChildAt(i16);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            i15 = 0 + childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (this.f629i) {
                int i17 = i16 + 1;
                int childCount2 = getChildCount();
                while (true) {
                    if (i17 >= childCount2) {
                        break;
                    } else if (getChildAt(i17).getVisibility() == 0) {
                        i13 = i17;
                        break;
                    } else {
                        i17++;
                    }
                }
                if (i13 >= 0) {
                    i14 = getChildAt(i13).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
            } else {
                i14 = getPaddingBottom();
            }
            i15 += i14;
        }
        WeakHashMap weakHashMap = c1.f10054a;
        if (i0.d(this) != i15) {
            setMinimumHeight(i15);
            if (i11 == 0) {
                super.onMeasure(i10, i11);
            }
        }
    }

    public void setAllowStacking(boolean z10) {
        if (this.f628h != z10) {
            this.f628h = z10;
            if (!z10 && this.f629i) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
