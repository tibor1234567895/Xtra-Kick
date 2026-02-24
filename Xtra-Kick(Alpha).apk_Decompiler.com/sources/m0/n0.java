package m0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

public final class n0 implements View.OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public q2 f10122a = null;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f10123b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ y f10124c;

    public n0(View view, y yVar) {
        this.f10123b = view;
        this.f10124c = yVar;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        q2 h10 = q2.h(view, windowInsets);
        int i10 = Build.VERSION.SDK_INT;
        y yVar = this.f10124c;
        if (i10 < 30) {
            o0.a(windowInsets, this.f10123b);
            if (h10.equals(this.f10122a)) {
                return yVar.A(view, h10).g();
            }
        }
        this.f10122a = h10;
        q2 A = yVar.A(view, h10);
        if (i10 >= 30) {
            return A.g();
        }
        WeakHashMap weakHashMap = c1.f10054a;
        m0.c(view);
        return A.g();
    }
}
