package ib;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import hb.h0;
import java.lang.reflect.Constructor;
import la.k;
import la.l;
import xa.j;

public abstract class c {
    private static volatile Choreographer choreographer;

    static {
        Object obj;
        try {
            int i10 = l.f9802h;
            obj = new a(a(Looper.getMainLooper()));
        } catch (Throwable th) {
            int i11 = l.f9802h;
            obj = h0.I(th);
        }
        if (obj instanceof k) {
            obj = null;
        }
        b bVar = (b) obj;
    }

    public static final Handler a(Looper looper) {
        Object obj;
        Class<Looper> cls = Looper.class;
        Class cls2 = Handler.class;
        if (Build.VERSION.SDK_INT >= 28) {
            obj = cls2.getDeclaredMethod("createAsync", new Class[]{cls}).invoke((Object) null, new Object[]{looper});
            j.d("null cannot be cast to non-null type android.os.Handler", obj);
        } else {
            try {
                Constructor declaredConstructor = cls2.getDeclaredConstructor(new Class[]{cls, Handler.Callback.class, Boolean.TYPE});
                obj = declaredConstructor.newInstance(new Object[]{looper, null, Boolean.TRUE});
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        return (Handler) obj;
    }
}
