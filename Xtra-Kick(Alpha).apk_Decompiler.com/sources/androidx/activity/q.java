package androidx.activity;

import i0.b;
import java.util.ArrayDeque;

public final class q implements d {

    /* renamed from: h  reason: collision with root package name */
    public final n f494h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ r f495i;

    public q(r rVar, n nVar) {
        this.f495i = rVar;
        this.f494h = nVar;
    }

    public final void cancel() {
        r rVar = this.f495i;
        ArrayDeque arrayDeque = rVar.f497b;
        n nVar = this.f494h;
        arrayDeque.remove(nVar);
        nVar.f490b.remove(this);
        if (b.a()) {
            nVar.f491c = null;
            rVar.c();
        }
    }
}
