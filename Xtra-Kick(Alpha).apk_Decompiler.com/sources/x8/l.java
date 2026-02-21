package x8;

import com.google.android.material.tabs.TabLayout;
import h4.j;
import java.lang.ref.WeakReference;

public final class l extends j {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f16778a;

    /* renamed from: b  reason: collision with root package name */
    public int f16779b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f16780c = 0;

    public l(TabLayout tabLayout) {
        this.f16778a = new WeakReference(tabLayout);
    }

    public final void a(int i10) {
        this.f16779b = this.f16780c;
        this.f16780c = i10;
        TabLayout tabLayout = (TabLayout) this.f16778a.get();
        if (tabLayout != null) {
            tabLayout.W = this.f16780c;
        }
    }

    public final void b(int i10, float f10, int i11) {
        TabLayout tabLayout = (TabLayout) this.f16778a.get();
        if (tabLayout != null) {
            int i12 = this.f16780c;
            tabLayout.k(i10, f10, i12 != 2 || this.f16779b == 1, (i12 == 2 && this.f16779b == 0) ? false : true, false);
        }
    }

    public final void c(int i10) {
        boolean z10;
        h hVar;
        TabLayout tabLayout = (TabLayout) this.f16778a.get();
        if (tabLayout != null && tabLayout.getSelectedTabPosition() != i10 && i10 < tabLayout.getTabCount()) {
            int i11 = this.f16780c;
            if (i11 == 0 || (i11 == 2 && this.f16779b == 0)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (i10 < 0 || i10 >= tabLayout.getTabCount()) {
                hVar = null;
            } else {
                hVar = (h) tabLayout.f3863i.get(i10);
            }
            tabLayout.i(hVar, z10);
        }
    }
}
