package com.bumptech.glide.manager;

import p1.i0;
import r4.i;
import w5.p;

public final class y implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f3288h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f3289i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f3290j;

    public /* synthetic */ y(int i10, Object obj, boolean z10) {
        this.f3288h = i10;
        this.f3290j = obj;
        this.f3289i = z10;
    }

    public final void run() {
        int i10 = this.f3288h;
        boolean z10 = this.f3289i;
        Object obj = this.f3290j;
        switch (i10) {
            case 0:
                i iVar = (i) obj;
                iVar.getClass();
                p.a();
                i0 i0Var = (i0) iVar.f13816b;
                boolean z11 = i0Var.f12464i;
                i0Var.f12464i = z10;
                if (z11 != z10) {
                    ((c) i0Var.f12465j).a(z10);
                    return;
                }
                return;
            default:
                ((a0) obj).f3250i.a(z10);
                return;
        }
    }
}
