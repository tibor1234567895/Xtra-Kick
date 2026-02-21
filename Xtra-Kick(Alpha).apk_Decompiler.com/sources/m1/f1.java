package m1;

import android.support.v4.media.n;
import android.util.Pair;
import n1.x;
import v1.a0;

public final /* synthetic */ class f1 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10228h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ n f10229i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Pair f10230j;

    public /* synthetic */ f1(n nVar, Pair pair, int i10) {
        this.f10228h = i10;
        this.f10229i = nVar;
        this.f10230j = pair;
    }

    public final void run() {
        int i10 = this.f10228h;
        Pair pair = this.f10230j;
        n nVar = this.f10229i;
        switch (i10) {
            case 0:
                ((x) ((j1) nVar.f338j).f10302h).p(((Integer) pair.first).intValue(), (a0) pair.second);
                return;
            case 1:
                ((x) ((j1) nVar.f338j).f10302h).T(((Integer) pair.first).intValue(), (a0) pair.second);
                return;
            case 2:
                ((x) ((j1) nVar.f338j).f10302h).C(((Integer) pair.first).intValue(), (a0) pair.second);
                return;
            default:
                ((x) ((j1) nVar.f338j).f10302h).U(((Integer) pair.first).intValue(), (a0) pair.second);
                return;
        }
    }
}
