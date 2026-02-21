package androidx.fragment.app;

import android.content.Context;
import android.support.v4.media.h;
import java.lang.reflect.InvocationTargetException;

public final class s0 extends j0 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c1 f1560b;

    public s0(c1 c1Var) {
        this.f1560b = c1Var;
    }

    public final c0 a(ClassLoader classLoader, String str) {
        e0 e0Var = this.f1560b.f1392v;
        Context context = e0Var.f1403i;
        e0Var.getClass();
        Object obj = c0.f1349c0;
        try {
            return (c0) j0.c(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
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
