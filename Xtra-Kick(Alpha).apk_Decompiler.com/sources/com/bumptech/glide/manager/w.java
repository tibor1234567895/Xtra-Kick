package com.bumptech.glide.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import w5.p;

public final class w implements c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b0 f3287a;

    public w(b0 b0Var) {
        this.f3287a = b0Var;
    }

    public final void a(boolean z10) {
        ArrayList arrayList;
        p.a();
        synchronized (this.f3287a) {
            arrayList = new ArrayList((Set) this.f3287a.f3258c);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(z10);
        }
    }
}
