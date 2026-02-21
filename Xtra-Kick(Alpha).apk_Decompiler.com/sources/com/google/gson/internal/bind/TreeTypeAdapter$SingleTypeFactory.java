package com.google.gson.internal.bind;

import j9.b0;
import j9.c0;
import j9.n;
import j9.r;
import o9.a;

final class TreeTypeAdapter$SingleTypeFactory implements c0 {

    /* renamed from: h  reason: collision with root package name */
    public final a f3986h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f3987i;

    /* renamed from: j  reason: collision with root package name */
    public final Class f3988j = null;

    /* renamed from: k  reason: collision with root package name */
    public final r f3989k;

    public TreeTypeAdapter$SingleTypeFactory(r rVar, a aVar, boolean z10) {
        this.f3989k = rVar;
        this.f3986h = aVar;
        this.f3987i = z10;
    }

    public final b0 a(n nVar, a aVar) {
        boolean z10;
        a aVar2 = this.f3986h;
        if (aVar2 == null) {
            z10 = this.f3988j.isAssignableFrom(aVar.f12361a);
        } else if (aVar2.equals(aVar) || (this.f3987i && aVar2.f12362b == aVar.f12361a)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return new m(this.f3989k, nVar, aVar, this);
        }
        return null;
    }
}
