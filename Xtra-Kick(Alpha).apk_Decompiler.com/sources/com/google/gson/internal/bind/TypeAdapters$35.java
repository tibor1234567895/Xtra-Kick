package com.google.gson.internal.bind;

import j9.b0;
import j9.c0;
import j9.n;
import o9.a;

final class TypeAdapters$35 implements c0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Class f4000h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ b0 f4001i;

    public TypeAdapters$35(Class cls, b0 b0Var) {
        this.f4000h = cls;
        this.f4001i = b0Var;
    }

    public final b0 a(n nVar, a aVar) {
        Class cls = aVar.f12361a;
        if (!this.f4000h.isAssignableFrom(cls)) {
            return null;
        }
        return new f0(this, cls, 1);
    }

    public final String toString() {
        return "Factory[typeHierarchy=" + this.f4000h.getName() + ",adapter=" + this.f4001i + "]";
    }
}
