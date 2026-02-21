package com.google.gson.internal.bind;

import j9.b0;
import j9.c0;
import j9.n;
import java.util.Calendar;
import java.util.GregorianCalendar;
import o9.a;

final class TypeAdapters$34 implements c0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Class f3997h = Calendar.class;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Class f3998i = GregorianCalendar.class;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ b0 f3999j;

    public TypeAdapters$34(g0 g0Var) {
        this.f3999j = g0Var;
    }

    public final b0 a(n nVar, a aVar) {
        Class cls = aVar.f12361a;
        if (cls == this.f3997h || cls == this.f3998i) {
            return this.f3999j;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.f3997h.getName() + "+" + this.f3998i.getName() + ",adapter=" + this.f3999j + "]";
    }
}
