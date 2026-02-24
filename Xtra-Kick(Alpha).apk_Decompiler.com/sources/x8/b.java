package x8;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;
import w7.a;

public final class b extends c {
    public final void b(TabLayout tabLayout, View view, View view2, float f10, Drawable drawable) {
        int i10 = (f10 > 0.5f ? 1 : (f10 == 0.5f ? 0 : -1));
        if (i10 >= 0) {
            view = view2;
        }
        RectF a10 = c.a(tabLayout, view);
        float a11 = i10 < 0 ? a.a(1.0f, 0.0f, 0.0f, 0.5f, f10) : a.a(0.0f, 1.0f, 0.5f, 1.0f, f10);
        drawable.setBounds((int) a10.left, drawable.getBounds().top, (int) a10.right, drawable.getBounds().bottom);
        drawable.setAlpha((int) (a11 * 255.0f));
    }
}
