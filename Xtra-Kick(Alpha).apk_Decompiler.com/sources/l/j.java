package l;

import android.support.v4.media.h;
import android.view.InflateException;
import android.view.MenuItem;
import java.lang.reflect.Method;

public final class j implements MenuItem.OnMenuItemClickListener {

    /* renamed from: j  reason: collision with root package name */
    public static final Class[] f9453j = {MenuItem.class};

    /* renamed from: h  reason: collision with root package name */
    public final Object f9454h;

    /* renamed from: i  reason: collision with root package name */
    public final Method f9455i;

    public j(String str, Object obj) {
        this.f9454h = obj;
        Class<?> cls = obj.getClass();
        try {
            this.f9455i = cls.getMethod(str, f9453j);
        } catch (Exception e10) {
            StringBuilder s10 = h.s("Couldn't resolve menu item onClick handler ", str, " in class ");
            s10.append(cls.getName());
            InflateException inflateException = new InflateException(s10.toString());
            inflateException.initCause(e10);
            throw inflateException;
        }
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Method method = this.f9455i;
        try {
            Class<?> returnType = method.getReturnType();
            Class<?> cls = Boolean.TYPE;
            Object obj = this.f9454h;
            if (returnType == cls) {
                return ((Boolean) method.invoke(obj, new Object[]{menuItem})).booleanValue();
            }
            method.invoke(obj, new Object[]{menuItem});
            return true;
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }
}
