package h4;

import androidx.viewpager2.widget.ViewPager2;

public final class e extends h {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7532a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f7533b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i10, Object obj) {
        super(0);
        this.f7532a = i10;
        this.f7533b = obj;
    }

    public final void a() {
        int i10 = this.f7532a;
        Object obj = this.f7533b;
        switch (i10) {
            case 0:
                ViewPager2 viewPager2 = (ViewPager2) obj;
                viewPager2.f2317l = true;
                viewPager2.f2324s.f7530l = true;
                return;
            default:
                ((l) obj).k();
                return;
        }
    }
}
