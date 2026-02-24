package h3;

import android.support.v4.media.s;
import android.support.v4.media.session.k;
import android.support.v4.media.session.m;

public final /* synthetic */ class e1 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6994h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l1 f6995i;

    public /* synthetic */ e1(l1 l1Var, int i10) {
        this.f6994h = i10;
        this.f6995i = l1Var;
    }

    public final void run() {
        int i10 = this.f6994h;
        l1 l1Var = this.f6995i;
        switch (i10) {
            case 0:
                if (!((m) ((k) l1Var.f7177g.f428i)).a()) {
                    l1Var.V0();
                    return;
                }
                return;
            default:
                l1Var.getClass();
                s sVar = new s(l1Var.f7171a, l1Var.f7173c.f7191h.c(), new g1(l1Var));
                l1Var.f7178h = sVar;
                sVar.f344a.f321b.connect();
                return;
        }
    }
}
