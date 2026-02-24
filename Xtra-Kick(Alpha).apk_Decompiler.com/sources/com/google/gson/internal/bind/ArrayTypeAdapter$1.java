package com.google.gson.internal.bind;

import j9.b0;
import j9.c0;
import j9.n;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import l9.e;
import o9.a;

final class ArrayTypeAdapter$1 implements c0 {
    public final b0 a(n nVar, a aVar) {
        Type type;
        Type type2 = aVar.f12362b;
        boolean z10 = type2 instanceof GenericArrayType;
        if (!z10 && (!(type2 instanceof Class) || !((Class) type2).isArray())) {
            return null;
        }
        if (z10) {
            type = ((GenericArrayType) type2).getGenericComponentType();
        } else {
            type = ((Class) type2).getComponentType();
        }
        return new a(nVar, nVar.b(new a(type)), e.e(type));
    }
}
