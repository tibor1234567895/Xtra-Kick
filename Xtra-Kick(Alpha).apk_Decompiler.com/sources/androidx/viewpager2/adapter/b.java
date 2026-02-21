package androidx.viewpager2.adapter;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.c0;
import androidx.fragment.app.c1;
import androidx.fragment.app.m0;
import androidx.fragment.app.n0;
import androidx.fragment.app.v0;
import java.util.concurrent.CopyOnWriteArrayList;

public final class b extends v0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c0 f2292a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FrameLayout f2293b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f2294c;

    public b(g gVar, c0 c0Var, FrameLayout frameLayout) {
        this.f2294c = gVar;
        this.f2292a = c0Var;
        this.f2293b = frameLayout;
    }

    public final void c(c1 c1Var, c0 c0Var, View view) {
        if (c0Var == this.f2292a) {
            n0 n0Var = c1Var.f1384n;
            synchronized (((CopyOnWriteArrayList) n0Var.f1511a)) {
                int size = ((CopyOnWriteArrayList) n0Var.f1511a).size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        break;
                    } else if (((m0) ((CopyOnWriteArrayList) n0Var.f1511a).get(i10)).f1498a == this) {
                        ((CopyOnWriteArrayList) n0Var.f1511a).remove(i10);
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            g gVar = this.f2294c;
            FrameLayout frameLayout = this.f2293b;
            gVar.getClass();
            g.a(view, frameLayout);
        }
    }
}
