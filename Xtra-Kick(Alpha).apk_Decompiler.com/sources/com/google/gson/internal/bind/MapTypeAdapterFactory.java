package com.google.gson.internal.bind;

import j9.b0;
import j9.c0;
import j9.n;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Properties;
import k5.a;
import l9.e;

public final class MapTypeAdapterFactory implements c0 {

    /* renamed from: h  reason: collision with root package name */
    public final a f3979h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f3980i = false;

    public MapTypeAdapterFactory(a aVar) {
        this.f3979h = aVar;
    }

    public final b0 a(n nVar, o9.a aVar) {
        Type[] typeArr;
        b0 b0Var;
        Type type = aVar.f12362b;
        Class<Map> cls = Map.class;
        if (!cls.isAssignableFrom(aVar.f12361a)) {
            return null;
        }
        Class e10 = e.e(type);
        if (type == Properties.class) {
            Class<String> cls2 = String.class;
            typeArr = new Type[]{cls2, cls2};
        } else {
            Type f10 = e.f(type, e10, cls);
            if (f10 instanceof ParameterizedType) {
                typeArr = ((ParameterizedType) f10).getActualTypeArguments();
            } else {
                Class<Object> cls3 = Object.class;
                typeArr = new Type[]{cls3, cls3};
            }
        }
        Type type2 = typeArr[0];
        if (type2 == Boolean.TYPE || type2 == Boolean.class) {
            b0Var = s0.f4050c;
        } else {
            b0Var = nVar.b(new o9.a(type2));
        }
        return new e(this, nVar, typeArr[0], b0Var, typeArr[1], nVar.b(new o9.a(typeArr[1])), this.f3979h.f(aVar));
    }
}
