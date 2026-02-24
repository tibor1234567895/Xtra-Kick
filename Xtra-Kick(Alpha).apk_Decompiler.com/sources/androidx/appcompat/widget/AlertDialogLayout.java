package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.woxthebox.draglistview.R;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;

public class AlertDialogLayout extends t2 {
    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public static int l(View view) {
        WeakHashMap weakHashMap = c1.f10054a;
        int d10 = i0.d(view);
        if (d10 > 0) {
            return d10;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return l(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        /*
            r9 = this;
            int r10 = r9.getPaddingLeft()
            int r13 = r13 - r11
            int r11 = r9.getPaddingRight()
            int r11 = r13 - r11
            int r13 = r13 - r10
            int r0 = r9.getPaddingRight()
            int r13 = r13 - r0
            int r0 = r9.getMeasuredHeight()
            int r1 = r9.getChildCount()
            int r2 = r9.getGravity()
            r3 = r2 & 112(0x70, float:1.57E-43)
            r4 = 8388615(0x800007, float:1.1754953E-38)
            r2 = r2 & r4
            r4 = 16
            if (r3 == r4) goto L_0x0039
            r4 = 80
            if (r3 == r4) goto L_0x0030
            int r12 = r9.getPaddingTop()
            goto L_0x0043
        L_0x0030:
            int r3 = r9.getPaddingTop()
            int r3 = r3 + r14
            int r3 = r3 - r12
            int r12 = r3 - r0
            goto L_0x0043
        L_0x0039:
            int r3 = r9.getPaddingTop()
            int r14 = r14 - r12
            int r14 = r14 - r0
            int r14 = r14 / 2
            int r12 = r14 + r3
        L_0x0043:
            android.graphics.drawable.Drawable r14 = r9.getDividerDrawable()
            r0 = 0
            if (r14 != 0) goto L_0x004c
            r14 = 0
            goto L_0x0050
        L_0x004c:
            int r14 = r14.getIntrinsicHeight()
        L_0x0050:
            if (r0 >= r1) goto L_0x00af
            android.view.View r3 = r9.getChildAt(r0)
            if (r3 == 0) goto L_0x00ac
            int r4 = r3.getVisibility()
            r5 = 8
            if (r4 == r5) goto L_0x00ac
            int r4 = r3.getMeasuredWidth()
            int r5 = r3.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r6 = r3.getLayoutParams()
            androidx.appcompat.widget.s2 r6 = (androidx.appcompat.widget.s2) r6
            int r7 = r6.gravity
            if (r7 >= 0) goto L_0x0073
            r7 = r2
        L_0x0073:
            java.util.WeakHashMap r8 = m0.c1.f10054a
            int r8 = m0.j0.d(r9)
            int r7 = android.view.Gravity.getAbsoluteGravity(r7, r8)
            r7 = r7 & 7
            r8 = 1
            if (r7 == r8) goto L_0x008c
            r8 = 5
            if (r7 == r8) goto L_0x0089
            int r7 = r6.leftMargin
            int r7 = r7 + r10
            goto L_0x0097
        L_0x0089:
            int r7 = r11 - r4
            goto L_0x0094
        L_0x008c:
            int r7 = r13 - r4
            int r7 = r7 / 2
            int r7 = r7 + r10
            int r8 = r6.leftMargin
            int r7 = r7 + r8
        L_0x0094:
            int r8 = r6.rightMargin
            int r7 = r7 - r8
        L_0x0097:
            boolean r8 = r9.k(r0)
            if (r8 == 0) goto L_0x009e
            int r12 = r12 + r14
        L_0x009e:
            int r8 = r6.topMargin
            int r12 = r12 + r8
            int r4 = r4 + r7
            int r8 = r5 + r12
            r3.layout(r7, r12, r4, r8)
            int r3 = r6.bottomMargin
            int r5 = r5 + r3
            int r5 = r5 + r12
            r12 = r5
        L_0x00ac:
            int r0 = r0 + 1
            goto L_0x0050
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AlertDialogLayout.onLayout(boolean, int, int, int, int):void");
    }

    public final void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = i10;
        int childCount = getChildCount();
        boolean z10 = false;
        View view = null;
        View view2 = null;
        View view3 = null;
        int i18 = 0;
        while (true) {
            if (i18 < childCount) {
                View childAt = getChildAt(i18);
                if (childAt.getVisibility() != 8) {
                    int id = childAt.getId();
                    if (id == R.id.topPanel) {
                        view = childAt;
                    } else if (id == R.id.buttonPanel) {
                        view2 = childAt;
                    } else if ((id == R.id.contentPanel || id == R.id.customPanel) && view3 == null) {
                        view3 = childAt;
                    }
                }
                i18++;
            } else {
                int mode = View.MeasureSpec.getMode(i11);
                int size = View.MeasureSpec.getSize(i11);
                int mode2 = View.MeasureSpec.getMode(i10);
                int paddingBottom = getPaddingBottom() + getPaddingTop();
                if (view != null) {
                    view.measure(i17, 0);
                    paddingBottom += view.getMeasuredHeight();
                    i12 = View.combineMeasuredStates(0, view.getMeasuredState());
                } else {
                    i12 = 0;
                }
                if (view2 != null) {
                    view2.measure(i17, 0);
                    i14 = l(view2);
                    i13 = view2.getMeasuredHeight() - i14;
                    paddingBottom += i14;
                    i12 = View.combineMeasuredStates(i12, view2.getMeasuredState());
                } else {
                    i14 = 0;
                    i13 = 0;
                }
                if (view3 != null) {
                    if (mode == 0) {
                        i16 = 0;
                    } else {
                        i16 = View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingBottom), mode);
                    }
                    view3.measure(i17, i16);
                    i15 = view3.getMeasuredHeight();
                    paddingBottom += i15;
                    i12 = View.combineMeasuredStates(i12, view3.getMeasuredState());
                } else {
                    i15 = 0;
                }
                int i19 = size - paddingBottom;
                if (view2 != null) {
                    int i20 = paddingBottom - i14;
                    int min = Math.min(i19, i13);
                    if (min > 0) {
                        i19 -= min;
                        i14 += min;
                    }
                    view2.measure(i17, View.MeasureSpec.makeMeasureSpec(i14, 1073741824));
                    paddingBottom = i20 + view2.getMeasuredHeight();
                    i12 = View.combineMeasuredStates(i12, view2.getMeasuredState());
                }
                if (view3 != null && i19 > 0) {
                    view3.measure(i17, View.MeasureSpec.makeMeasureSpec(i15 + i19, mode));
                    paddingBottom = (paddingBottom - i15) + view3.getMeasuredHeight();
                    i12 = View.combineMeasuredStates(i12, view3.getMeasuredState());
                }
                int i21 = 0;
                for (int i22 = 0; i22 < childCount; i22++) {
                    View childAt2 = getChildAt(i22);
                    if (childAt2.getVisibility() != 8) {
                        i21 = Math.max(i21, childAt2.getMeasuredWidth());
                    }
                }
                setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + i21, i17, i12), View.resolveSizeAndState(paddingBottom, i11, 0));
                if (mode2 != 1073741824) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
                    for (int i23 = 0; i23 < childCount; i23++) {
                        View childAt3 = getChildAt(i23);
                        if (childAt3.getVisibility() != 8) {
                            s2 s2Var = (s2) childAt3.getLayoutParams();
                            if (s2Var.width == -1) {
                                int i24 = s2Var.height;
                                s2Var.height = childAt3.getMeasuredHeight();
                                measureChildWithMargins(childAt3, makeMeasureSpec, 0, i11, 0);
                                s2Var.height = i24;
                            }
                        }
                    }
                }
                z10 = true;
            }
        }
        int i25 = i11;
        if (!z10) {
            super.onMeasure(i10, i11);
        }
    }
}
