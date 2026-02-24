package xa;

import db.b;
import fb.y;
import hb.h0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ma.i0;
import ma.j0;
import ma.r;
import wa.a;
import wa.c;
import wa.d;
import wa.f;
import wa.g;
import wa.h;
import wa.i;
import wa.j;
import wa.k;
import wa.l;
import wa.m;
import wa.n;
import wa.o;
import wa.p;
import wa.q;
import wa.s;
import wa.t;
import wa.u;
import wa.v;

public final class e implements b, c {

    /* renamed from: b  reason: collision with root package name */
    public static final d f16806b = new d(0);

    /* renamed from: c  reason: collision with root package name */
    public static final Map f16807c;

    /* renamed from: d  reason: collision with root package name */
    public static final LinkedHashMap f16808d;

    /* renamed from: a  reason: collision with root package name */
    public final Class f16809a;

    static {
        int i10 = 0;
        List e10 = r.e(a.class, l.class, p.class, q.class, wa.r.class, r7.l.class, s.class, t.class, u.class, v.class, wa.b.class, c.class, d.class, wa.e.class, f.class, g.class, h.class, i.class, j.class, k.class, m.class, n.class, o.class);
        ArrayList arrayList = new ArrayList(ma.s.i(e10));
        for (Object next : e10) {
            int i11 = i10 + 1;
            if (i10 >= 0) {
                arrayList.add(new la.i((Class) next, Integer.valueOf(i10)));
                i10 = i11;
            } else {
                r.h();
                throw null;
            }
        }
        f16807c = j0.f(arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        j.e("primitiveFqNames.values", values);
        for (String str : values) {
            StringBuilder sb2 = new StringBuilder("kotlin.jvm.internal.");
            j.e("kotlinName", str);
            sb2.append(y.K(str, '.', str));
            sb2.append("CompanionObject");
            hashMap3.put(sb2.toString(), str.concat(".Companion"));
        }
        for (Map.Entry entry : f16807c.entrySet()) {
            int intValue = ((Number) entry.getValue()).intValue();
            String name = ((Class) entry.getKey()).getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(i0.a(hashMap3.size()));
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key = entry2.getKey();
            String str2 = (String) entry2.getValue();
            linkedHashMap.put(key, y.K(str2, '.', str2));
        }
        f16808d = linkedHashMap;
    }

    public e(Class cls) {
        j.f("jClass", cls);
        this.f16809a = cls;
    }

    public final Class a() {
        return this.f16809a;
    }

    public final String b() {
        String str;
        StringBuilder sb2;
        String name;
        f16806b.getClass();
        Class cls = this.f16809a;
        j.f("jClass", cls);
        String str2 = null;
        if (cls.isAnonymousClass()) {
            return null;
        }
        if (cls.isLocalClass()) {
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                sb2 = new StringBuilder();
                name = enclosingMethod.getName();
            } else {
                Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
                if (enclosingConstructor != null) {
                    sb2 = new StringBuilder();
                    name = enclosingConstructor.getName();
                } else {
                    int t10 = y.t(simpleName, '$', 0, false, 6);
                    if (t10 == -1) {
                        return simpleName;
                    }
                    String substring = simpleName.substring(t10 + 1, simpleName.length());
                    j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
                    return substring;
                }
            }
            sb2.append(name);
            sb2.append('$');
            return y.J(simpleName, sb2.toString(), simpleName);
        }
        boolean isArray = cls.isArray();
        LinkedHashMap linkedHashMap = f16808d;
        if (isArray) {
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (str = (String) linkedHashMap.get(componentType.getName())) != null) {
                str2 = str.concat("Array");
            }
            if (str2 == null) {
                return "Array";
            }
            return str2;
        }
        String str3 = (String) linkedHashMap.get(cls.getName());
        if (str3 == null) {
            return cls.getSimpleName();
        }
        return str3;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof e) && j.a(h0.t0(this), h0.t0((b) obj));
    }

    public final int hashCode() {
        return h0.t0(this).hashCode();
    }

    public final String toString() {
        return this.f16809a.toString() + " (Kotlin reflection is not available)";
    }
}
