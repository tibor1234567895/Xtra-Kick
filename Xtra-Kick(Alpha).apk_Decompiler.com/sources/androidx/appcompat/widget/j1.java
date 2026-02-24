package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import d0.p;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import m0.c1;
import m0.l0;

public final class j1 extends p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f890a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f891b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WeakReference f892c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ q1 f893d;

    public j1(q1 q1Var, int i10, int i11, WeakReference weakReference) {
        this.f893d = q1Var;
        this.f890a = i10;
        this.f891b = i11;
        this.f892c = weakReference;
    }

    public final void c(int i10) {
    }

    public final void d(Typeface typeface) {
        int i10;
        boolean z10;
        if (Build.VERSION.SDK_INT >= 28 && (i10 = this.f890a) != -1) {
            if ((this.f891b & 2) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            typeface = p1.a(typeface, i10, z10);
        }
        q1 q1Var = this.f893d;
        if (q1Var.f1009m) {
            q1Var.f1008l = typeface;
            TextView textView = (TextView) this.f892c.get();
            if (textView != null) {
                WeakHashMap weakHashMap = c1.f10054a;
                if (l0.b(textView)) {
                    textView.post(new k1(textView, typeface, q1Var.f1006j));
                } else {
                    textView.setTypeface(typeface, q1Var.f1006j);
                }
            }
        }
    }
}
