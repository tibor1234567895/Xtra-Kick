package androidx.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public final class f {

    /* renamed from: c  reason: collision with root package name */
    public static final f f1679c = new f();

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1680a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f1681b = new HashMap();

    public static void c(HashMap hashMap, e eVar, r rVar, Class cls) {
        r rVar2 = (r) hashMap.get(eVar);
        if (rVar2 != null && rVar != rVar2) {
            Method method = eVar.f1675b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + rVar2 + ", new value " + rVar);
        } else if (rVar2 == null) {
            hashMap.put(eVar, rVar);
        }
    }

    public final d a(Class cls, Method[] methodArr) {
        int i10;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null) {
            hashMap.putAll(b(superclass).f1673b);
        }
        for (Class b10 : cls.getInterfaces()) {
            for (Map.Entry entry : b(b10).f1673b.entrySet()) {
                c(hashMap, (e) entry.getKey(), (r) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e10) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e10);
            }
        }
        boolean z10 = false;
        for (Method method : methodArr) {
            q0 q0Var = (q0) method.getAnnotation(q0.class);
            if (q0Var != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i10 = 0;
                } else if (d0.class.isAssignableFrom(parameterTypes[0])) {
                    i10 = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                r value = q0Var.value();
                if (parameterTypes.length > 1) {
                    if (!r.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == r.ON_ANY) {
                        i10 = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    c(hashMap, new e(method, i10), value, cls);
                    z10 = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        d dVar = new d(hashMap);
        this.f1680a.put(cls, dVar);
        this.f1681b.put(cls, Boolean.valueOf(z10));
        return dVar;
    }

    public final d b(Class cls) {
        d dVar = (d) this.f1680a.get(cls);
        return dVar != null ? dVar : a(cls, (Method[]) null);
    }
}
