package m1;

import android.support.v4.media.n;
import android.util.Pair;
import n1.x;
import v1.a0;
import v1.r;
import v1.w;

public final /* synthetic */ class e1 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10211h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ n f10212i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Pair f10213j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ r f10214k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ w f10215l;

    public /* synthetic */ e1(n nVar, Pair pair, r rVar, w wVar, int i10) {
        this.f10211h = i10;
        this.f10212i = nVar;
        this.f10213j = pair;
        this.f10214k = rVar;
        this.f10215l = wVar;
    }

    public final void run() {
        int i10 = this.f10211h;
        w wVar = this.f10215l;
        r rVar = this.f10214k;
        Pair pair = this.f10213j;
        n nVar = this.f10212i;
        switch (i10) {
            case 0:
                ((x) ((j1) nVar.f338j).f10302h).I(((Integer) pair.first).intValue(), (a0) pair.second, rVar, wVar);
                return;
            case 1:
                ((x) ((j1) nVar.f338j).f10302h).M(((Integer) pair.first).intValue(), (a0) pair.second, rVar, wVar);
                return;
            default:
                ((x) ((j1) nVar.f338j).f10302h).w(((Integer) pair.first).intValue(), (a0) pair.second, rVar, wVar);
                return;
        }
    }
}
