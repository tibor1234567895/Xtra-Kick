package a8;

import android.content.Context;
import com.woxthebox.draglistview.R;
import o8.d;

public final class a extends d {
    public a(Context context) {
        super(context);
    }

    public int getItemDefaultMarginResId() {
        return R.dimen.design_bottom_navigation_margin;
    }

    public int getItemLayoutResId() {
        return R.layout.design_bottom_navigation_item;
    }
}
