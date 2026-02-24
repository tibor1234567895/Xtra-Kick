package com.google.gson.internal.bind;

import j9.b0;
import j9.c0;
import j9.n;
import o9.a;

final class TypeAdapters$30 implements c0 {
    public final b0 a(n nVar, a aVar) {
        Class<? super Enum> cls = aVar.f12361a;
        Class<Enum> cls2 = Enum.class;
        if (!cls2.isAssignableFrom(cls) || cls == cls2) {
            return null;
        }
        if (!cls.isEnum()) {
            cls = cls.getSuperclass();
        }
        return new f0(cls);
    }
}
