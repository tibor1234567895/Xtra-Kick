package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import ma.p;
import ma.q;
import ma.r;
import xa.j;

public abstract class t1 {

    /* renamed from: a  reason: collision with root package name */
    public static final List f1764a;

    /* renamed from: b  reason: collision with root package name */
    public static final List f1765b;

    static {
        Class<j1> cls = j1.class;
        f1764a = r.e(Application.class, cls);
        f1765b = q.b(cls);
    }

    public static final Constructor a(Class cls, List list) {
        j.f("signature", list);
        Constructor[] constructors = cls.getConstructors();
        j.e("modelClass.constructors", constructors);
        int length = constructors.length;
        int i10 = 0;
        while (i10 < length) {
            Constructor constructor = constructors[i10];
            Class[] parameterTypes = constructor.getParameterTypes();
            j.e("constructor.parameterTypes", parameterTypes);
            List j10 = p.j(parameterTypes);
            if (j.a(list, j10)) {
                return constructor;
            }
            if (list.size() != j10.size() || !j10.containsAll(list)) {
                i10++;
            } else {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final w1 b(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (w1) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Failed to access " + cls, e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e12.getCause());
        }
    }
}
