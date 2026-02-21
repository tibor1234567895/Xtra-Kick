package com.google.android.material.transformation;

import android.content.Context;
import android.support.v4.media.session.g0;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b9.b;
import com.woxthebox.draglistview.R;
import java.util.HashMap;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import w7.f;
import z.e;

@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: i  reason: collision with root package name */
    public HashMap f3970i;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void s(View view, View view2, boolean z10, boolean z11) {
        boolean z12;
        int i10;
        ViewParent parent = view2.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z10) {
                this.f3970i = new HashMap(childCount);
            }
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = coordinatorLayout.getChildAt(i11);
                if (!(childAt.getLayoutParams() instanceof e) || !(((e) childAt.getLayoutParams()).f17322a instanceof FabTransformationScrimBehavior)) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (childAt != view2 && !z12) {
                    HashMap hashMap = this.f3970i;
                    if (z10) {
                        hashMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        WeakHashMap weakHashMap = c1.f10054a;
                        i10 = 4;
                    } else if (hashMap != null && hashMap.containsKey(childAt)) {
                        i10 = ((Integer) this.f3970i.get(childAt)).intValue();
                        WeakHashMap weakHashMap2 = c1.f10054a;
                    }
                    i0.s(childAt, i10);
                }
            }
            if (!z10) {
                this.f3970i = null;
            }
        }
        super.s(view, view2, z10, z11);
    }

    public final b z(Context context, boolean z10) {
        int i10 = z10 ? R.animator.mtrl_fab_transformation_sheet_expand_spec : R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        b bVar = new b();
        bVar.f2699a = f.b(context, i10);
        bVar.f2700b = new g0();
        return bVar;
    }
}
