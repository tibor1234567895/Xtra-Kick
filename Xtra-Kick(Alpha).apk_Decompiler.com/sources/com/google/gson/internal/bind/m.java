package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import j9.c0;
import j9.n;
import j9.r;
import j9.s;
import j9.u;
import o9.a;

public final class m extends b0 {

    /* renamed from: a  reason: collision with root package name */
    public final r f4039a;

    /* renamed from: b  reason: collision with root package name */
    public final n f4040b;

    /* renamed from: c  reason: collision with root package name */
    public final a f4041c;

    /* renamed from: d  reason: collision with root package name */
    public final c0 f4042d;

    /* renamed from: e  reason: collision with root package name */
    public final l f4043e = new l(this);

    /* renamed from: f  reason: collision with root package name */
    public b0 f4044f;

    public m(r rVar, n nVar, a aVar, c0 c0Var) {
        this.f4039a = rVar;
        this.f4040b = nVar;
        this.f4041c = aVar;
        this.f4042d = c0Var;
    }

    public static c0 d(a aVar, r rVar) {
        boolean z10;
        if (aVar.f12362b == aVar.f12361a) {
            z10 = true;
        } else {
            z10 = false;
        }
        return new TreeTypeAdapter$SingleTypeFactory(rVar, aVar, z10);
    }

    public final Object b(JsonReader jsonReader) {
        a aVar = this.f4041c;
        r rVar = this.f4039a;
        if (rVar == null) {
            b0 b0Var = this.f4044f;
            if (b0Var == null) {
                b0Var = this.f4040b.c(this.f4042d, aVar);
                this.f4044f = b0Var;
            }
            return b0Var.b(jsonReader);
        }
        s a10 = l9.s.a(jsonReader);
        a10.getClass();
        if (a10 instanceof u) {
            return null;
        }
        return rVar.deserialize(a10, aVar.f12362b, this.f4043e);
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        b0 b0Var = this.f4044f;
        if (b0Var == null) {
            b0Var = this.f4040b.c(this.f4042d, this.f4041c);
            this.f4044f = b0Var;
        }
        b0Var.c(jsonWriter, obj);
    }
}
