package z7;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import u0.h;

public final class b implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final View f17784h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f17785i;

    public b(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z10) {
        this.f17785i = swipeDismissBehavior;
        this.f17784h = view;
    }

    public final void run() {
        h hVar = this.f17785i.f3653a;
        if (hVar != null && hVar.g()) {
            WeakHashMap weakHashMap = c1.f10054a;
            i0.m(this.f17784h, this);
        }
    }
}
