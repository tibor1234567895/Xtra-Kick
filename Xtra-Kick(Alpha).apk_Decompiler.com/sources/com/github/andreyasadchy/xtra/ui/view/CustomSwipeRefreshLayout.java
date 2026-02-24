package com.github.andreyasadchy.xtra.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.woxthebox.draglistview.R;
import xa.j;
import z3.m;

public final class CustomSwipeRefreshLayout extends m {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.f("context", context);
        j.f("attrs", attributeSet);
        Resources.Theme theme = getContext().getTheme();
        TypedValue typedValue = new TypedValue();
        theme.resolveAttribute(R.attr.primaryColor, typedValue, true);
        setProgressBackgroundColorSchemeColor(typedValue.data);
        theme.resolveAttribute(R.attr.textColor, typedValue, true);
        setColorSchemeColors(typedValue.data);
    }
}
