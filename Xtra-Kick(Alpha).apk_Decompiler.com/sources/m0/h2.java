package m0;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import e0.d;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public abstract class h2 extends m2 {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f10089h = false;

    /* renamed from: i  reason: collision with root package name */
    public static Method f10090i;

    /* renamed from: j  reason: collision with root package name */
    public static Class f10091j;

    /* renamed from: k  reason: collision with root package name */
    public static Field f10092k;

    /* renamed from: l  reason: collision with root package name */
    public static Field f10093l;

    /* renamed from: c  reason: collision with root package name */
    public final WindowInsets f10094c;

    /* renamed from: d  reason: collision with root package name */
    public d[] f10095d;

    /* renamed from: e  reason: collision with root package name */
    public d f10096e = null;

    /* renamed from: f  reason: collision with root package name */
    public q2 f10097f;

    /* renamed from: g  reason: collision with root package name */
    public d f10098g;

    public h2(q2 q2Var, WindowInsets windowInsets) {
        super(q2Var);
        this.f10094c = windowInsets;
    }

    @SuppressLint({"WrongConstant"})
    private d r(int i10, boolean z10) {
        d dVar = d.f4855e;
        for (int i11 = 1; i11 <= 256; i11 <<= 1) {
            if ((i10 & i11) != 0) {
                dVar = d.a(dVar, s(i11, z10));
            }
        }
        return dVar;
    }

    private d t() {
        q2 q2Var = this.f10097f;
        if (q2Var != null) {
            return q2Var.f10131a.h();
        }
        return d.f4855e;
    }

    private d u(View view) {
        if (Build.VERSION.SDK_INT < 30) {
            if (!f10089h) {
                v();
            }
            Method method = f10090i;
            if (!(method == null || f10091j == null || f10092k == null)) {
                try {
                    Object invoke = method.invoke(view, new Object[0]);
                    if (invoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f10092k.get(f10093l.get(invoke));
                    if (rect != null) {
                        return d.b(rect.left, rect.top, rect.right, rect.bottom);
                    }
                    return null;
                } catch (ReflectiveOperationException e10) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
                }
            }
            return null;
        }
        throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
    }

    @SuppressLint({"PrivateApi"})
    private static void v() {
        try {
            f10090i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f10091j = cls;
            f10092k = cls.getDeclaredField("mVisibleInsets");
            f10093l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            f10092k.setAccessible(true);
            f10093l.setAccessible(true);
        } catch (ReflectiveOperationException e10) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
        }
        f10089h = true;
    }

    public void d(View view) {
        d u10 = u(view);
        if (u10 == null) {
            u10 = d.f4855e;
        }
        w(u10);
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        return Objects.equals(this.f10098g, ((h2) obj).f10098g);
    }

    public d f(int i10) {
        return r(i10, false);
    }

    public final d j() {
        if (this.f10096e == null) {
            WindowInsets windowInsets = this.f10094c;
            this.f10096e = d.b(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f10096e;
    }

    public q2 l(int i10, int i11, int i12, int i13) {
        g2 g2Var;
        q2 h10 = q2.h((View) null, this.f10094c);
        int i14 = Build.VERSION.SDK_INT;
        if (i14 >= 30) {
            g2Var = new f2(h10);
        } else if (i14 >= 29) {
            g2Var = new e2(h10);
        } else {
            g2Var = new d2(h10);
        }
        g2Var.g(q2.f(j(), i10, i11, i12, i13));
        g2Var.e(q2.f(h(), i10, i11, i12, i13));
        return g2Var.b();
    }

    public boolean n() {
        return this.f10094c.isRound();
    }

    public void o(d[] dVarArr) {
        this.f10095d = dVarArr;
    }

    public void p(q2 q2Var) {
        this.f10097f = q2Var;
    }

    public d s(int i10, boolean z10) {
        int i11;
        l lVar;
        int i12;
        int i13;
        int i14;
        int i15 = 0;
        if (i10 != 1) {
            d dVar = null;
            if (i10 != 2) {
                d dVar2 = d.f4855e;
                if (i10 == 8) {
                    d[] dVarArr = this.f10095d;
                    if (dVarArr != null) {
                        dVar = dVarArr[n2.a(8)];
                    }
                    if (dVar != null) {
                        return dVar;
                    }
                    d j10 = j();
                    d t10 = t();
                    int i16 = j10.f4859d;
                    if (i16 > t10.f4859d) {
                        return d.b(0, 0, 0, i16);
                    }
                    d dVar3 = this.f10098g;
                    if (dVar3 == null || dVar3.equals(dVar2) || (i11 = this.f10098g.f4859d) <= t10.f4859d) {
                        return dVar2;
                    }
                    return d.b(0, 0, 0, i11);
                } else if (i10 == 16) {
                    return i();
                } else {
                    if (i10 == 32) {
                        return g();
                    }
                    if (i10 == 64) {
                        return k();
                    }
                    if (i10 != 128) {
                        return dVar2;
                    }
                    q2 q2Var = this.f10097f;
                    if (q2Var != null) {
                        lVar = q2Var.f10131a.e();
                    } else {
                        lVar = e();
                    }
                    if (lVar == null) {
                        return dVar2;
                    }
                    int i17 = Build.VERSION.SDK_INT;
                    DisplayCutout displayCutout = lVar.f10114a;
                    if (i17 >= 28) {
                        i12 = k.d(displayCutout);
                    } else {
                        i12 = 0;
                    }
                    if (i17 >= 28) {
                        i13 = k.f(displayCutout);
                    } else {
                        i13 = 0;
                    }
                    if (i17 >= 28) {
                        i14 = k.e(displayCutout);
                    } else {
                        i14 = 0;
                    }
                    if (i17 >= 28) {
                        i15 = k.c(displayCutout);
                    }
                    return d.b(i12, i13, i14, i15);
                }
            } else if (z10) {
                d t11 = t();
                d h10 = h();
                return d.b(Math.max(t11.f4856a, h10.f4856a), 0, Math.max(t11.f4858c, h10.f4858c), Math.max(t11.f4859d, h10.f4859d));
            } else {
                d j11 = j();
                q2 q2Var2 = this.f10097f;
                if (q2Var2 != null) {
                    dVar = q2Var2.f10131a.h();
                }
                int i18 = j11.f4859d;
                if (dVar != null) {
                    i18 = Math.min(i18, dVar.f4859d);
                }
                return d.b(j11.f4856a, 0, j11.f4858c, i18);
            }
        } else if (z10) {
            return d.b(0, Math.max(t().f4857b, j().f4857b), 0, 0);
        } else {
            return d.b(0, j().f4857b, 0, 0);
        }
    }

    public void w(d dVar) {
        this.f10098g = dVar;
    }
}
