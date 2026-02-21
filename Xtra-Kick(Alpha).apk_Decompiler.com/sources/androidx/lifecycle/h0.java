package androidx.lifecycle;

import android.support.v4.media.h;
import fb.w;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import ma.q;
import xa.j;

public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    public static final h0 f1697a = new h0();

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap f1698b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap f1699c = new HashMap();

    private h0() {
    }

    public static void a(Constructor constructor, Object obj) {
        try {
            Object newInstance = constructor.newInstance(new Object[]{obj});
            j.e("{\n            constructo…tance(`object`)\n        }", newInstance);
            h.B(newInstance);
            throw null;
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }

    public static int b(Class cls) {
        Constructor<?> constructor;
        List list;
        boolean z10;
        boolean z11;
        boolean z12;
        String str;
        boolean z13;
        boolean z14;
        HashMap hashMap = f1698b;
        Integer num = (Integer) hashMap.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int i10 = 1;
        if (cls.getCanonicalName() != null) {
            ArrayList arrayList = null;
            try {
                Package packageR = cls.getPackage();
                String canonicalName = cls.getCanonicalName();
                if (packageR != null) {
                    str = packageR.getName();
                } else {
                    str = "";
                }
                j.e("fullPackage", str);
                if (str.length() == 0) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (!z13) {
                    j.e("name", canonicalName);
                    canonicalName = canonicalName.substring(str.length() + 1);
                    j.e("this as java.lang.String).substring(startIndex)", canonicalName);
                }
                j.e("if (fullPackage.isEmpty(…g(fullPackage.length + 1)", canonicalName);
                String concat = w.k(canonicalName, ".", "_").concat("_LifecycleAdapter");
                if (str.length() == 0) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (!z14) {
                    concat = str + '.' + concat;
                }
                constructor = Class.forName(concat).getDeclaredConstructor(new Class[]{cls});
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                constructor = null;
            } catch (NoSuchMethodException e10) {
                throw new RuntimeException(e10);
            }
            HashMap hashMap2 = f1699c;
            if (constructor != null) {
                list = q.b(constructor);
            } else {
                f fVar = f.f1679c;
                HashMap hashMap3 = fVar.f1681b;
                Boolean bool = (Boolean) hashMap3.get(cls);
                if (bool != null) {
                    z10 = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i11 = 0;
                        while (true) {
                            if (i11 >= length) {
                                hashMap3.put(cls, Boolean.FALSE);
                                z10 = false;
                                break;
                            } else if (((q0) declaredMethods[i11].getAnnotation(q0.class)) != null) {
                                fVar.a(cls, declaredMethods);
                                z10 = true;
                                break;
                            } else {
                                i11++;
                            }
                        }
                    } catch (NoClassDefFoundError e11) {
                        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e11);
                    }
                }
                if (!z10) {
                    Class superclass = cls.getSuperclass();
                    Class<c0> cls2 = c0.class;
                    if (superclass == null || !cls2.isAssignableFrom(superclass)) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    if (z11) {
                        j.e("superclass", superclass);
                        if (b(superclass) != 1) {
                            Object obj = hashMap2.get(superclass);
                            j.c(obj);
                            arrayList = new ArrayList((Collection) obj);
                        }
                    }
                    Class[] interfaces = cls.getInterfaces();
                    j.e("klass.interfaces", interfaces);
                    int length2 = interfaces.length;
                    int i12 = 0;
                    while (true) {
                        if (i12 < length2) {
                            Class cls3 = interfaces[i12];
                            if (cls3 == null || !cls2.isAssignableFrom(cls3)) {
                                z12 = false;
                            } else {
                                z12 = true;
                            }
                            if (z12) {
                                j.e("intrface", cls3);
                                if (b(cls3) == 1) {
                                    break;
                                }
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                Object obj2 = hashMap2.get(cls3);
                                j.c(obj2);
                                arrayList.addAll((Collection) obj2);
                            }
                            i12++;
                        } else if (arrayList != null) {
                            list = arrayList;
                        }
                    }
                }
            }
            hashMap2.put(cls, list);
            i10 = 2;
        }
        hashMap.put(cls, Integer.valueOf(i10));
        return i10;
    }
}
