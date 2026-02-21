package x8;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;

public final class a extends c {
    public final void b(TabLayout tabLayout, View view, View view2, float f10, Drawable drawable) {
        boolean z10;
        float f11;
        float f12;
        RectF a10 = c.a(tabLayout, view);
        RectF a11 = c.a(tabLayout, view2);
        if (a10.left < a11.left) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            double d10 = (((double) f10) * 3.141592653589793d) / 2.0d;
            f12 = (float) (1.0d - Math.cos(d10));
            f11 = (float) Math.sin(d10);
        } else {
            double d11 = (((double) f10) * 3.141592653589793d) / 2.0d;
            f11 = (float) (1.0d - Math.cos(d11));
            f12 = (float) Math.sin(d11);
        }
        drawable.setBounds(w7.a.b((int) a10.left, f12, (int) a11.left), drawable.getBounds().top, w7.a.b((int) a10.right, f11, (int) a11.right), drawable.getBounds().bottom);
    }
}
