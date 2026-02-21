package h4;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import n0.x;

public final class k implements x {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7536h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l f7537i;

    public /* synthetic */ k(l lVar, int i10) {
        this.f7536h = i10;
        this.f7537i = lVar;
    }

    public final boolean b(View view) {
        int i10 = this.f7536h;
        l lVar = this.f7537i;
        switch (i10) {
            case 0:
                int currentItem = ((ViewPager2) view).getCurrentItem() + 1;
                ViewPager2 viewPager2 = lVar.f7541e;
                if (viewPager2.f2330y) {
                    viewPager2.c(currentItem, true);
                }
                return true;
            default:
                int currentItem2 = ((ViewPager2) view).getCurrentItem() - 1;
                ViewPager2 viewPager22 = lVar.f7541e;
                if (viewPager22.f2330y) {
                    viewPager22.c(currentItem2, true);
                }
                return true;
        }
    }
}
