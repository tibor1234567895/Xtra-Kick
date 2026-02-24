package m1;

import android.support.v4.media.n;
import android.util.Pair;
import n1.a;
import n1.x;
import v1.a0;
import v1.w;

public final /* synthetic */ class d1 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10197h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ n f10198i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Pair f10199j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ w f10200k;

    public /* synthetic */ d1(n nVar, Pair pair, w wVar, int i10) {
        this.f10197h = i10;
        this.f10198i = nVar;
        this.f10199j = pair;
        this.f10200k = wVar;
    }

    public final void run() {
        int i10 = this.f10197h;
        w wVar = this.f10200k;
        Pair pair = this.f10199j;
        n nVar = this.f10198i;
        switch (i10) {
            case 0:
                a aVar = ((j1) nVar.f338j).f10302h;
                int intValue = ((Integer) pair.first).intValue();
                a0 a0Var = (a0) pair.second;
                a0Var.getClass();
                ((x) aVar).o(intValue, a0Var, wVar);
                return;
            default:
                ((x) ((j1) nVar.f338j).f10302h).d(((Integer) pair.first).intValue(), (a0) pair.second, wVar);
                return;
        }
    }
}
