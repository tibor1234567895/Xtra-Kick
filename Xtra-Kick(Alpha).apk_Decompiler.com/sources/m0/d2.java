package m0;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import e0.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public final class d2 extends g2 {

    /* renamed from: e  reason: collision with root package name */
    public static Field f10064e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f10065f = false;

    /* renamed from: g  reason: collision with root package name */
    public static Constructor f10066g = null;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f10067h = false;

    /* renamed from: c  reason: collision with root package name */
    public WindowInsets f10068c;

    /* renamed from: d  reason: collision with root package name */
    public d f10069d;

    public d2() {
        this.f10068c = i();
    }

    private static WindowInsets i() {
        Class<WindowInsets> cls = WindowInsets.class;
        if (!f10065f) {
            try {
                f10064e = cls.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e10) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e10);
            }
            f10065f = true;
        }
        Field field = f10064e;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get((Object) null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e11) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e11);
            }
        }
        if (!f10067h) {
            try {
                f10066g = cls.getConstructor(new Class[]{Rect.class});
            } catch (ReflectiveOperationException e12) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e12);
            }
            f10067h = true;
        }
        Constructor constructor = f10066g;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Object[]{new Rect()});
            } catch (ReflectiveOperationException e13) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e13);
            }
        }
        return null;
    }

    public q2 b() {
        a();
        q2 h10 = q2.h((View) null, this.f10068c);
        d[] dVarArr = this.f10086b;
        m2 m2Var = h10.f10131a;
        m2Var.o(dVarArr);
        m2Var.q(this.f10069d);
        return h10;
    }

    public void e(d dVar) {
        this.f10069d = dVar;
    }

    public void g(d dVar) {
        WindowInsets windowInsets = this.f10068c;
        if (windowInsets != null) {
            this.f10068c = windowInsets.replaceSystemWindowInsets(dVar.f4856a, dVar.f4857b, dVar.f4858c, dVar.f4859d);
        }
    }

    public d2(q2 q2Var) {
        super(q2Var);
        this.f10068c = q2Var.g();
    }
}
