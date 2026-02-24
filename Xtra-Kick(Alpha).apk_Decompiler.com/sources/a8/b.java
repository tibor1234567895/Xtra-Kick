package a8;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.woxthebox.draglistview.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m.o;
import m0.c1;
import m0.j0;
import o8.f;

public final class b extends f {
    public final int M;
    public final int N;
    public final int O;
    public final int P;
    public boolean Q;
    public final ArrayList R = new ArrayList();

    public b(Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.M = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.N = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.O = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.P = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                WeakHashMap weakHashMap = c1.f10054a;
                if (j0.d(this) == 1) {
                    int i18 = i14 - i16;
                    childAt.layout(i18 - childAt.getMeasuredWidth(), 0, i18, i15);
                } else {
                    childAt.layout(i16, 0, childAt.getMeasuredWidth() + i16, i15);
                }
                i16 += childAt.getMeasuredWidth();
            }
        }
    }

    public final void onMeasure(int i10, int i11) {
        boolean z10;
        int i12;
        int i13;
        int i14;
        o menu = getMenu();
        int size = View.MeasureSpec.getSize(i10);
        int size2 = menu.l().size();
        int childCount = getChildCount();
        ArrayList arrayList = this.R;
        arrayList.clear();
        int size3 = View.MeasureSpec.getSize(i11);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        int labelVisibilityMode = getLabelVisibilityMode();
        int i15 = 1;
        if (labelVisibilityMode != -1 ? labelVisibilityMode != 0 : size2 <= 3) {
            z10 = false;
        } else {
            z10 = true;
        }
        int i16 = this.O;
        if (!z10 || !this.Q) {
            if (size2 != 0) {
                i15 = size2;
            }
            int min = Math.min(size / i15, i16);
            int i17 = size - (size2 * min);
            for (int i18 = 0; i18 < childCount; i18++) {
                if (getChildAt(i18).getVisibility() == 8) {
                    i12 = 0;
                } else if (i17 > 0) {
                    i12 = min + 1;
                    i17--;
                } else {
                    i12 = min;
                }
                arrayList.add(Integer.valueOf(i12));
            }
        } else {
            View childAt = getChildAt(getSelectedItemPosition());
            int visibility = childAt.getVisibility();
            int i19 = this.P;
            if (visibility != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i16, RecyclerView.UNDEFINED_DURATION), makeMeasureSpec);
                i19 = Math.max(i19, childAt.getMeasuredWidth());
            }
            if (childAt.getVisibility() != 8) {
                i13 = 1;
            } else {
                i13 = 0;
            }
            int i20 = size2 - i13;
            int min2 = Math.min(size - (this.N * i20), Math.min(i19, i16));
            int i21 = size - min2;
            if (i20 != 0) {
                i15 = i20;
            }
            int min3 = Math.min(i21 / i15, this.M);
            int i22 = i21 - (i20 * min3);
            for (int i23 = 0; i23 < childCount; i23++) {
                if (getChildAt(i23).getVisibility() != 8) {
                    if (i23 == getSelectedItemPosition()) {
                        i14 = min2;
                    } else {
                        i14 = min3;
                    }
                    if (i22 > 0) {
                        i14++;
                        i22--;
                    }
                } else {
                    i14 = 0;
                }
                arrayList.add(Integer.valueOf(i14));
            }
        }
        int i24 = 0;
        for (int i25 = 0; i25 < childCount; i25++) {
            View childAt2 = getChildAt(i25);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(((Integer) arrayList.get(i25)).intValue(), 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i24 = childAt2.getMeasuredWidth() + i24;
            }
        }
        setMeasuredDimension(i24, size3);
    }

    public void setItemHorizontalTranslationEnabled(boolean z10) {
        this.Q = z10;
    }
}
