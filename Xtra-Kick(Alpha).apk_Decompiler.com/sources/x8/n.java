package x8;

import androidx.recyclerview.widget.g1;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import n3.v3;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final TabLayout f16783a;

    /* renamed from: b  reason: collision with root package name */
    public final ViewPager2 f16784b;

    /* renamed from: c  reason: collision with root package name */
    public final k f16785c;

    /* renamed from: d  reason: collision with root package name */
    public g1 f16786d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16787e;

    public n(TabLayout tabLayout, ViewPager2 viewPager2, k kVar) {
        this.f16783a = tabLayout;
        this.f16784b = viewPager2;
        this.f16785c = kVar;
    }

    public final void a() {
        if (!this.f16787e) {
            ViewPager2 viewPager2 = this.f16784b;
            g1 adapter = viewPager2.getAdapter();
            this.f16786d = adapter;
            if (adapter != null) {
                this.f16787e = true;
                TabLayout tabLayout = this.f16783a;
                ((List) viewPager2.f2315j.f2296b).add(new l(tabLayout));
                m mVar = new m(viewPager2, true);
                ArrayList arrayList = tabLayout.S;
                if (!arrayList.contains(mVar)) {
                    arrayList.add(mVar);
                }
                this.f16786d.registerAdapterDataObserver(new v3(2, this));
                b();
                tabLayout.k(viewPager2.getCurrentItem(), 0.0f, true, true, true);
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    public final void b() {
        int min;
        h hVar;
        TabLayout tabLayout = this.f16783a;
        tabLayout.h();
        g1 g1Var = this.f16786d;
        if (g1Var != null) {
            int itemCount = g1Var.getItemCount();
            for (int i10 = 0; i10 < itemCount; i10++) {
                h f10 = tabLayout.f();
                this.f16785c.e(f10, i10);
                tabLayout.a(f10, false);
            }
            if (itemCount > 0 && (min = Math.min(this.f16784b.getCurrentItem(), tabLayout.getTabCount() - 1)) != tabLayout.getSelectedTabPosition()) {
                if (min < 0 || min >= tabLayout.getTabCount()) {
                    hVar = null;
                } else {
                    hVar = (h) tabLayout.f3863i.get(min);
                }
                tabLayout.i(hVar, true);
            }
        }
    }
}
