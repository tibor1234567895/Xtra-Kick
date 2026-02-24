package androidx.lifecycle;

import android.app.Application;
import b1.f;
import java.lang.reflect.InvocationTargetException;
import xa.j;

public final class a2 extends e2 {

    /* renamed from: e  reason: collision with root package name */
    public static final z1 f1651e = new z1(0);

    /* renamed from: f  reason: collision with root package name */
    public static a2 f1652f;

    /* renamed from: g  reason: collision with root package name */
    public static final y1 f1653g = y1.f1802a;

    /* renamed from: d  reason: collision with root package name */
    public final Application f1654d;

    public a2() {
        this((Application) null);
    }

    public final w1 a(Class cls) {
        Application application = this.f1654d;
        if (application != null) {
            return c(cls, application);
        }
        throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
    }

    public final w1 b(Class cls, f fVar) {
        if (this.f1654d != null) {
            return a(cls);
        }
        Application application = (Application) fVar.a(f1653g);
        if (application != null) {
            return c(cls, application);
        }
        if (!c.class.isAssignableFrom(cls)) {
            return super.a(cls);
        }
        throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
    }

    public final w1 c(Class cls, Application application) {
        if (!c.class.isAssignableFrom(cls)) {
            return super.a(cls);
        }
        try {
            w1 w1Var = (w1) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{application});
            j.e("{\n                try {\n…          }\n            }", w1Var);
            return w1Var;
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException("Cannot create an instance of " + cls, e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("Cannot create an instance of " + cls, e11);
        } catch (InstantiationException e12) {
            throw new RuntimeException("Cannot create an instance of " + cls, e12);
        } catch (InvocationTargetException e13) {
            throw new RuntimeException("Cannot create an instance of " + cls, e13);
        }
    }

    public a2(Application application) {
        this.f1654d = application;
    }
}
