package com.google.gson.internal.bind;

import j9.b0;
import j9.c0;
import j9.n;
import j9.r;
import k5.a;

public final class JsonAdapterAnnotationTypeAdapterFactory implements c0 {

    /* renamed from: h  reason: collision with root package name */
    public final a f3978h;

    public JsonAdapterAnnotationTypeAdapterFactory(a aVar) {
        this.f3978h = aVar;
    }

    public static b0 b(a aVar, n nVar, o9.a aVar2, k9.a aVar3) {
        b0 b0Var;
        r rVar;
        Object i10 = aVar.f(new o9.a(aVar3.value())).i();
        if (i10 instanceof b0) {
            b0Var = (b0) i10;
        } else if (i10 instanceof c0) {
            b0Var = ((c0) i10).a(nVar, aVar2);
        } else {
            boolean z10 = i10 instanceof r;
            if (z10) {
                if (z10) {
                    rVar = (r) i10;
                } else {
                    rVar = null;
                }
                b0Var = new m(rVar, nVar, aVar2, (c0) null);
            } else {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + i10.getClass().getName() + " as a @JsonAdapter for " + aVar2.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
        }
        if (b0Var == null || !aVar3.nullSafe()) {
            return b0Var;
        }
        return b0Var.a();
    }

    public final b0 a(n nVar, o9.a aVar) {
        k9.a aVar2 = (k9.a) aVar.f12361a.getAnnotation(k9.a.class);
        if (aVar2 == null) {
            return null;
        }
        return b(this.f3978h, nVar, aVar, aVar2);
    }
}
