package z;

import android.util.Log;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import l8.l;
import t5.h;

public final class f implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f17339h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f17340i;

    public /* synthetic */ f(int i10, Object obj) {
        this.f17339h = i10;
        this.f17340i = obj;
    }

    public final boolean onPreDraw() {
        boolean z10;
        boolean z11;
        boolean z12 = false;
        int i10 = this.f17339h;
        Object obj = this.f17340i;
        switch (i10) {
            case 0:
                ((CoordinatorLayout) obj).q(0);
                return true;
            case 1:
                Log.isLoggable("ViewTarget", 2);
                h hVar = (h) ((WeakReference) obj).get();
                if (hVar != null) {
                    ArrayList arrayList = hVar.f14564b;
                    if (!arrayList.isEmpty()) {
                        int c10 = hVar.c();
                        int b10 = hVar.b();
                        if (c10 > 0 || c10 == Integer.MIN_VALUE) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z10) {
                            if (b10 > 0 || b10 == Integer.MIN_VALUE) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z11) {
                                z12 = true;
                            }
                        }
                        if (z12) {
                            Iterator it = new ArrayList(arrayList).iterator();
                            while (it.hasNext()) {
                                ((s5.h) ((t5.f) it.next())).n(c10, b10);
                            }
                            ViewTreeObserver viewTreeObserver = hVar.f14563a.getViewTreeObserver();
                            if (viewTreeObserver.isAlive()) {
                                viewTreeObserver.removeOnPreDrawListener(hVar.f14565c);
                            }
                            hVar.f14565c = null;
                            arrayList.clear();
                        }
                    }
                }
                return true;
            default:
                l lVar = (l) obj;
                float rotation = lVar.f9748s.getRotation();
                if (lVar.f9744o != rotation) {
                    lVar.f9744o = rotation;
                    lVar.p();
                }
                return true;
        }
    }

    public f(h hVar) {
        this.f17339h = 1;
        this.f17340i = new WeakReference(hVar);
    }
}
