package com.google.gson.internal.bind;

import j9.b0;
import j9.c0;
import j9.n;
import o9.a;

final class TypeAdapters$31 implements c0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ a f3990h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ b0 f3991i;

    public TypeAdapters$31(a aVar, b0 b0Var) {
        this.f3990h = aVar;
        this.f3991i = b0Var;
    }

    public final b0 a(n nVar, a aVar) {
        if (aVar.equals(this.f3990h)) {
            return this.f3991i;
        }
        return null;
    }
}
