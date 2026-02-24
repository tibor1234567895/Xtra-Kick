package h4;

import androidx.viewpager2.widget.ViewPager2;

public final class f extends j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7534a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f7535b;

    public /* synthetic */ f(ViewPager2 viewPager2, int i10) {
        this.f7534a = i10;
        this.f7535b = viewPager2;
    }

    public final void a(int i10) {
        switch (this.f7534a) {
            case 0:
                if (i10 == 0) {
                    this.f7535b.d();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void c(int i10) {
        int i11 = this.f7534a;
        ViewPager2 viewPager2 = this.f7535b;
        switch (i11) {
            case 0:
                if (viewPager2.f2316k != i10) {
                    viewPager2.f2316k = i10;
                    viewPager2.A.k();
                    return;
                }
                return;
            default:
                viewPager2.clearFocus();
                if (viewPager2.hasFocus()) {
                    viewPager2.f2322q.requestFocus(2);
                    return;
                }
                return;
        }
    }
}
