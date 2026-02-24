package com.google.gson.internal.bind;

import j9.b0;
import j9.c0;
import j9.n;
import o9.a;

final class TypeAdapters$33 implements c0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Class f3994h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Class f3995i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ b0 f3996j;

    public TypeAdapters$33(Class cls, Class cls2, b0 b0Var) {
        this.f3994h = cls;
        this.f3995i = cls2;
        this.f3996j = b0Var;
    }

    public final b0 a(n nVar, a aVar) {
        Class cls = aVar.f12361a;
        if (cls == this.f3994h || cls == this.f3995i) {
            return this.f3996j;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.f3995i.getName() + "+" + this.f3994h.getName() + ",adapter=" + this.f3996j + "]";
    }
}
