package com.google.gson.internal.bind;

import j9.b0;
import j9.c0;
import j9.n;
import o9.a;

final class TypeAdapters$32 implements c0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Class f3992h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ b0 f3993i;

    public TypeAdapters$32(Class cls, b0 b0Var) {
        this.f3992h = cls;
        this.f3993i = b0Var;
    }

    public final b0 a(n nVar, a aVar) {
        if (aVar.f12361a == this.f3992h) {
            return this.f3993i;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.f3992h.getName() + ",adapter=" + this.f3993i + "]";
    }
}
