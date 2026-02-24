package b8;

import android.view.View;
import androidx.activity.h;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import z.b;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2668a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f2669b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2670c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f2671d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ b f2672e;

    public e(BottomSheetBehavior bottomSheetBehavior) {
        this.f2672e = bottomSheetBehavior;
        this.f2671d = new h(17, this);
    }

    public final void a(int i10) {
        int i11 = this.f2668a;
        Runnable runnable = this.f2671d;
        b bVar = this.f2672e;
        switch (i11) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) bVar;
                WeakReference weakReference = bottomSheetBehavior.U;
                if (weakReference != null && weakReference.get() != null) {
                    this.f2669b = i10;
                    if (!this.f2670c) {
                        WeakHashMap weakHashMap = c1.f10054a;
                        i0.m((View) bottomSheetBehavior.U.get(), runnable);
                        this.f2670c = true;
                        return;
                    }
                    return;
                }
                return;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) bVar;
                WeakReference weakReference2 = sideSheetBehavior.f3849o;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.f2669b = i10;
                    if (!this.f2670c) {
                        WeakHashMap weakHashMap2 = c1.f10054a;
                        i0.m((View) sideSheetBehavior.f3849o.get(), runnable);
                        this.f2670c = true;
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public /* synthetic */ e(BottomSheetBehavior bottomSheetBehavior, int i10) {
        this(bottomSheetBehavior);
    }

    public e(SideSheetBehavior sideSheetBehavior) {
        this.f2672e = sideSheetBehavior;
        this.f2671d = new androidx.activity.e(22, this);
    }
}
