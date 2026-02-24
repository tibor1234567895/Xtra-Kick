package androidx.fragment.app;

import android.support.v4.media.h;
import java.lang.reflect.InvocationTargetException;
import q.k;

public class j0 {

    /* renamed from: a  reason: collision with root package name */
    public static final k f1468a = new k();

    public static Class b(ClassLoader classLoader, String str) {
        k kVar = f1468a;
        k kVar2 = (k) kVar.getOrDefault(classLoader, (Object) null);
        if (kVar2 == null) {
            kVar2 = new k();
            kVar.put(classLoader, kVar2);
        }
        Class cls = (Class) kVar2.getOrDefault(str, (Object) null);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        kVar2.put(str, cls2);
        return cls2;
    }

    public static Class c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassNotFoundException e10) {
            throw new y(h.n("Unable to instantiate fragment ", str, ": make sure class name exists"), (Throwable) e10);
        } catch (ClassCastException e11) {
            throw new y(h.n("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), (Throwable) e11);
        }
    }

    public c0 a(ClassLoader classLoader, String str) {
        try {
            return (c0) c(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (InstantiationException e10) {
            throw new y(h.n("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), (Throwable) e10);
        } catch (IllegalAccessException e11) {
            throw new y(h.n("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), (Throwable) e11);
        } catch (NoSuchMethodException e12) {
            throw new y(h.n("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), (Throwable) e12);
        } catch (InvocationTargetException e13) {
            throw new y(h.n("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), (Throwable) e13);
        }
    }
}
