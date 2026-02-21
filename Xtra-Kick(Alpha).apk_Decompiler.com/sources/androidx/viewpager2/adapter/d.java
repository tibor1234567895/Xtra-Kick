package androidx.viewpager2.adapter;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.i5;
import androidx.fragment.app.c0;
import b7.i;
import com.github.andreyasadchy.xtra.ui.search.SearchPagerFragment;
import h4.j;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public final class d extends j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2295a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f2296b;

    public d() {
        this.f2295a = 1;
        this.f2296b = new ArrayList(3);
    }

    public final void a(int i10) {
        int i11 = this.f2295a;
        Object obj = this.f2296b;
        switch (i11) {
            case 0:
                ((f) obj).b(false);
                return;
            case 1:
                try {
                    for (j a10 : (List) obj) {
                        a10.a(i10);
                    }
                    return;
                } catch (ConcurrentModificationException e10) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e10);
                }
            default:
                return;
        }
    }

    public final void b(int i10, float f10, int i11) {
        switch (this.f2295a) {
            case 1:
                try {
                    for (j b10 : (List) this.f2296b) {
                        b10.b(i10, f10, i11);
                    }
                    return;
                } catch (ConcurrentModificationException e10) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e10);
                }
            default:
                return;
        }
    }

    public final void c(int i10) {
        i iVar;
        int i11 = this.f2295a;
        Object obj = this.f2296b;
        switch (i11) {
            case 0:
                ((f) obj).b(false);
                return;
            case 1:
                try {
                    for (j c10 : (List) obj) {
                        c10.c(i10);
                    }
                    return;
                } catch (ConcurrentModificationException e10) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e10);
                }
            default:
                SearchPagerFragment searchPagerFragment = (SearchPagerFragment) obj;
                c0 q02 = searchPagerFragment.q0();
                if (q02 instanceof i) {
                    iVar = (i) q02;
                } else {
                    iVar = null;
                }
                if (iVar != null) {
                    i5 i5Var = searchPagerFragment.f3469o0;
                    xa.j.c(i5Var);
                    iVar.k(((SearchView) i5Var.f879g).getQuery().toString());
                    return;
                }
                return;
        }
    }

    public /* synthetic */ d(int i10, Object obj) {
        this.f2295a = i10;
        this.f2296b = obj;
    }
}
