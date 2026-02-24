package com.google.android.material.bottomnavigation;

import a8.b;
import a8.c;
import a8.d;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.u4;
import b4.e0;
import com.woxthebox.draglistview.R;
import m8.r;
import m8.w;
import o8.n;
import v7.a;

public class BottomNavigationView extends n {
    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        u4 e10 = r.e(getContext(), attributeSet, a.f15935d, R.attr.bottomNavigationStyle, 2132018096, new int[0]);
        setItemHorizontalTranslationEnabled(e10.a(2, true));
        if (e10.l(0)) {
            setMinimumHeight(e10.d(0, 0));
        }
        e10.a(1, true);
        e10.n();
        w.a(this, new e0(20, this));
    }

    public int getMaxItemCount() {
        return 5;
    }

    public final void onMeasure(int i10, int i11) {
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i11) != 1073741824 && suggestedMinimumHeight > 0) {
            int paddingTop = getPaddingTop();
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i11), getPaddingBottom() + paddingTop + suggestedMinimumHeight), 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    public void setItemHorizontalTranslationEnabled(boolean z10) {
        b bVar = (b) getMenuView();
        if (bVar.Q != z10) {
            bVar.setItemHorizontalTranslationEnabled(z10);
            getPresenter().e(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(c cVar) {
        setOnItemReselectedListener(cVar);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(d dVar) {
        setOnItemSelectedListener(dVar);
    }
}
