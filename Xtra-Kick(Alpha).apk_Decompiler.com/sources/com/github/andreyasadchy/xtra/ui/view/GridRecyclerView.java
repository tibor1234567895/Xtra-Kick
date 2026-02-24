package com.github.andreyasadchy.xtra.ui.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.b0;
import com.woxthebox.draglistview.R;
import hb.h0;
import l6.o;
import xa.j;

public final class GridRecyclerView extends RecyclerView {

    /* renamed from: h  reason: collision with root package name */
    public final int f3529h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3530i;

    /* renamed from: j  reason: collision with root package name */
    public final GridLayoutManager f3531j;

    public GridRecyclerView(Context context) {
        super(context, (AttributeSet) null);
        Context context2 = getContext();
        j.e("context", context2);
        SharedPreferences l12 = h0.l1(context2);
        String string = l12.getString("columnsPortrait", "1");
        j.c(string);
        int parseInt = Integer.parseInt(string);
        this.f3529h = parseInt;
        String string2 = l12.getString("columnsLandscape", "2");
        j.c(string2);
        int parseInt2 = Integer.parseInt(string2);
        this.f3530i = parseInt2;
        Configuration configuration = getResources().getConfiguration();
        j.e("resources.configuration", configuration);
        parseInt = configuration.orientation != 1 ? parseInt2 : parseInt;
        getContext();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(parseInt);
        this.f3531j = gridLayoutManager;
        setLayoutManager(gridLayoutManager);
        q(parseInt);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        int i10;
        j.f("newConfig", configuration);
        super.onConfigurationChanged(configuration);
        removeItemDecorationAt(0);
        if (configuration.orientation == 1) {
            i10 = this.f3529h;
        } else {
            i10 = this.f3530i;
        }
        this.f3531j.z1(i10);
        q(i10);
    }

    public final void q(int i10) {
        addItemDecoration(i10 <= 1 ? new b0(getContext()) : new o((int) getContext().getResources().getDimension(R.dimen.divider_margin), i10));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GridRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.f("context", context);
        j.f("attrs", attributeSet);
        Context context2 = getContext();
        j.e("context", context2);
        SharedPreferences l12 = h0.l1(context2);
        String string = l12.getString("columnsPortrait", "1");
        j.c(string);
        int parseInt = Integer.parseInt(string);
        this.f3529h = parseInt;
        String string2 = l12.getString("columnsLandscape", "2");
        j.c(string2);
        int parseInt2 = Integer.parseInt(string2);
        this.f3530i = parseInt2;
        Configuration configuration = getResources().getConfiguration();
        j.e("resources.configuration", configuration);
        parseInt = configuration.orientation != 1 ? parseInt2 : parseInt;
        getContext();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(parseInt);
        this.f3531j = gridLayoutManager;
        setLayoutManager(gridLayoutManager);
        q(parseInt);
    }
}
