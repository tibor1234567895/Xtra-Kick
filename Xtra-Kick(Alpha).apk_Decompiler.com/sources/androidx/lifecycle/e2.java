package androidx.lifecycle;

import b1.f;
import xa.j;

public class e2 implements b2 {

    /* renamed from: a  reason: collision with root package name */
    public static final d2 f1676a = new d2(0);

    /* renamed from: b  reason: collision with root package name */
    public static e2 f1677b;

    /* renamed from: c  reason: collision with root package name */
    public static final c2 f1678c = c2.f1671a;

    public w1 a(Class cls) {
        try {
            Object newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            j.e("{\n                modelC…wInstance()\n            }", newInstance);
            return (w1) newInstance;
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException("Cannot create an instance of " + cls, e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException("Cannot create an instance of " + cls, e11);
        } catch (IllegalAccessException e12) {
            throw new RuntimeException("Cannot create an instance of " + cls, e12);
        }
    }

    public w1 b(Class cls, f fVar) {
        return a(cls);
    }
}
