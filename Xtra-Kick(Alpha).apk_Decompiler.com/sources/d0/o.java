package d0;

import android.view.View;
import com.google.android.material.sidesheet.SideSheetBehavior;
import g1.h;
import h3.y0;
import m1.c;
import m1.e;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4109h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f4110i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f4111j;

    public /* synthetic */ o(Object obj, int i10, int i11) {
        this.f4109h = i11;
        this.f4111j = obj;
        this.f4110i = i10;
    }

    public final void run() {
        int i10;
        int i11 = this.f4109h;
        int i12 = this.f4110i;
        Object obj = this.f4111j;
        switch (i11) {
            case 0:
                ((p) obj).c(i12);
                return;
            case 1:
                e eVar = ((c) obj).f10191b;
                eVar.getClass();
                boolean z10 = true;
                if (i12 == -3 || i12 == -2) {
                    if (i12 != -2) {
                        h hVar = eVar.f10204d;
                        if (hVar == null || hVar.f6393h != 1) {
                            z10 = false;
                        }
                        if (!z10) {
                            i10 = 3;
                            eVar.d(i10);
                            return;
                        }
                    }
                    eVar.b(0);
                    i10 = 2;
                    eVar.d(i10);
                    return;
                } else if (i12 == -1) {
                    eVar.b(-1);
                    eVar.a();
                    return;
                } else if (i12 != 1) {
                    android.support.v4.media.h.z("Unknown focus change type: ", i12, "AudioFocusManager");
                    return;
                } else {
                    eVar.d(1);
                    eVar.b(1);
                    return;
                }
            case 2:
                ((y0) obj).f7463k.remove(Integer.valueOf(i12));
                return;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                View view = (View) sideSheetBehavior.f3849o.get();
                if (view != null) {
                    sideSheetBehavior.t(view, i12, false);
                    return;
                }
                return;
        }
    }
}
