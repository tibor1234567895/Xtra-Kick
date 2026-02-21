package com.google.gson.internal.bind;

import j9.b0;
import j9.c0;
import j9.n;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import k5.a;
import l9.e;

public final class CollectionTypeAdapterFactory implements c0 {

    /* renamed from: h  reason: collision with root package name */
    public final a f3977h;

    public CollectionTypeAdapterFactory(a aVar) {
        this.f3977h = aVar;
    }

    public final b0 a(n nVar, o9.a aVar) {
        Type type;
        Type type2 = aVar.f12362b;
        Class<Collection> cls = Collection.class;
        Class cls2 = aVar.f12361a;
        if (!cls.isAssignableFrom(cls2)) {
            return null;
        }
        Type f10 = e.f(type2, cls2, cls);
        if (f10 instanceof WildcardType) {
            f10 = ((WildcardType) f10).getUpperBounds()[0];
        }
        if (f10 instanceof ParameterizedType) {
            type = ((ParameterizedType) f10).getActualTypeArguments()[0];
        } else {
            type = Object.class;
        }
        return new f0(nVar, type, nVar.b(new o9.a(type)), this.f3977h.f(aVar));
    }
}
