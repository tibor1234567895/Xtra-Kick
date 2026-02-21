package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import o9.a;

public final class n extends b0 {

    /* renamed from: a  reason: collision with root package name */
    public final j9.n f4045a;

    /* renamed from: b  reason: collision with root package name */
    public final b0 f4046b;

    /* renamed from: c  reason: collision with root package name */
    public final Type f4047c;

    public n(j9.n nVar, b0 b0Var, Type type) {
        this.f4045a = nVar;
        this.f4046b = b0Var;
        this.f4047c = type;
    }

    public final Object b(JsonReader jsonReader) {
        return this.f4046b.b(jsonReader);
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        Type type;
        Type type2 = this.f4047c;
        if (obj == null || (type2 != Object.class && !(type2 instanceof TypeVariable) && !(type2 instanceof Class))) {
            type = type2;
        } else {
            type = obj.getClass();
        }
        b0 b0Var = this.f4046b;
        if (type != type2) {
            b0 b10 = this.f4045a.b(new a(type));
            if (!(b10 instanceof i) || (b0Var instanceof i)) {
                b0Var = b10;
            }
        }
        b0Var.c(jsonWriter, obj);
    }
}
