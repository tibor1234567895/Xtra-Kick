package m1;

import android.support.v4.media.n;
import android.util.Pair;
import java.io.IOException;
import n1.x;
import v1.a0;
import v1.f0;
import v1.g0;
import v1.r;
import v1.w;

public final /* synthetic */ class g1 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10245h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ r f10246i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ w f10247j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ IOException f10248k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f10249l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Object f10250m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Object f10251n;

    public /* synthetic */ g1(Object obj, Object obj2, r rVar, w wVar, IOException iOException, boolean z10, int i10) {
        this.f10245h = i10;
        this.f10250m = obj;
        this.f10251n = obj2;
        this.f10246i = rVar;
        this.f10247j = wVar;
        this.f10248k = iOException;
        this.f10249l = z10;
    }

    public final void run() {
        int i10 = this.f10245h;
        Object obj = this.f10251n;
        Object obj2 = this.f10250m;
        switch (i10) {
            case 0:
                Pair pair = (Pair) obj;
                r rVar = this.f10246i;
                w wVar = this.f10247j;
                IOException iOException = this.f10248k;
                boolean z10 = this.f10249l;
                ((x) ((j1) ((n) obj2).f338j).f10302h).J(((Integer) pair.first).intValue(), (a0) pair.second, rVar, wVar, iOException, z10);
                return;
            default:
                f0 f0Var = (f0) obj2;
                ((g0) obj).J(f0Var.f15618a, f0Var.f15619b, this.f10246i, this.f10247j, this.f10248k, this.f10249l);
                return;
        }
    }
}
