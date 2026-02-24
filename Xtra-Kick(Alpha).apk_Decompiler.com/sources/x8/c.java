package x8;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;
import m8.w;
import w7.a;

public class c {
    public static RectF a(TabLayout tabLayout, View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.L || !(view instanceof j)) {
            return new RectF((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
        }
        j jVar = (j) view;
        int contentWidth = jVar.getContentWidth();
        int contentHeight = jVar.getContentHeight();
        int b10 = (int) w.b(jVar.getContext(), 24);
        if (contentWidth < b10) {
            contentWidth = b10;
        }
        int right = (jVar.getRight() + jVar.getLeft()) / 2;
        int bottom = (jVar.getBottom() + jVar.getTop()) / 2;
        int i10 = contentWidth / 2;
        return new RectF((float) (right - i10), (float) (bottom - (contentHeight / 2)), (float) (i10 + right), (float) ((right / 2) + bottom));
    }

    public void b(TabLayout tabLayout, View view, View view2, float f10, Drawable drawable) {
        RectF a10 = a(tabLayout, view);
        RectF a11 = a(tabLayout, view2);
        drawable.setBounds(a.b((int) a10.left, f10, (int) a11.left), drawable.getBounds().top, a.b((int) a10.right, f10, (int) a11.right), drawable.getBounds().bottom);
    }
}
