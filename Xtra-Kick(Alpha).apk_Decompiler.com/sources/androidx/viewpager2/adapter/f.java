package androidx.viewpager2.adapter;

import android.view.ViewParent;
import androidx.fragment.app.a;
import androidx.fragment.app.c0;
import androidx.fragment.app.c1;
import androidx.lifecycle.b0;
import androidx.lifecycle.s;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import q.i;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public d f2298a;

    /* renamed from: b  reason: collision with root package name */
    public e f2299b;

    /* renamed from: c  reason: collision with root package name */
    public b0 f2300c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager2 f2301d;

    /* renamed from: e  reason: collision with root package name */
    public long f2302e = -1;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ g f2303f;

    public f(g gVar) {
        this.f2303f = gVar;
    }

    public static ViewPager2 a(RecyclerView recyclerView) {
        ViewParent parent = recyclerView.getParent();
        if (parent instanceof ViewPager2) {
            return (ViewPager2) parent;
        }
        throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
    }

    public final void b(boolean z10) {
        boolean z11;
        int currentItem;
        boolean z12;
        g gVar = this.f2303f;
        if (!gVar.f2305b.N() && this.f2301d.getScrollState() == 0) {
            i iVar = gVar.f2306c;
            if (iVar.i() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11 && gVar.getItemCount() != 0 && (currentItem = this.f2301d.getCurrentItem()) < gVar.getItemCount()) {
                long j10 = (long) currentItem;
                if (j10 != this.f2302e || z10) {
                    c0 c0Var = null;
                    c0 c0Var2 = (c0) iVar.e(j10, (Long) null);
                    if (c0Var2 != null && c0Var2.F()) {
                        this.f2302e = j10;
                        c1 c1Var = gVar.f2305b;
                        c1Var.getClass();
                        a aVar = new a(c1Var);
                        for (int i10 = 0; i10 < iVar.i(); i10++) {
                            long f10 = iVar.f(i10);
                            c0 c0Var3 = (c0) iVar.j(i10);
                            if (c0Var3.F()) {
                                if (f10 != this.f2302e) {
                                    aVar.l(c0Var3, s.STARTED);
                                } else {
                                    c0Var = c0Var3;
                                }
                                if (f10 == this.f2302e) {
                                    z12 = true;
                                } else {
                                    z12 = false;
                                }
                                if (c0Var3.J != z12) {
                                    c0Var3.J = z12;
                                }
                            }
                        }
                        if (c0Var != null) {
                            aVar.l(c0Var, s.RESUMED);
                        }
                        if (!aVar.f1533a.isEmpty()) {
                            aVar.i();
                        }
                    }
                }
            }
        }
    }
}
