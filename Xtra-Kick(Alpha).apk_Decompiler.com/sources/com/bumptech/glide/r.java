package com.bumptech.glide;

import com.bumptech.glide.manager.c;
import com.bumptech.glide.manager.v;

public final class r implements c {

    /* renamed from: a  reason: collision with root package name */
    public final v f3305a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s f3306b;

    public r(s sVar, v vVar) {
        this.f3306b = sVar;
        this.f3305a = vVar;
    }

    public final void a(boolean z10) {
        if (z10) {
            synchronized (this.f3306b) {
                this.f3305a.b();
            }
        }
    }
}
