package h3;

import android.os.RemoteException;
import android.os.SystemClock;
import h9.e0;
import j1.a;
import j1.h;
import j1.v;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public final /* synthetic */ class f3 implements h {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7026h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ e2 f7027i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7028j;

    public /* synthetic */ f3(e2 e2Var, int i10, int i11) {
        this.f7026h = i11;
        this.f7027i = e2Var;
        this.f7028j = i10;
    }

    public final void b(Object obj) {
        j4 j4Var;
        v vVar;
        int i10;
        int i11 = this.f7026h;
        int i12 = -1;
        boolean z10 = true;
        int i13 = this.f7028j;
        e2 e2Var = this.f7027i;
        switch (i11) {
            case 0:
                try {
                    vVar = (v) ((e0) obj).get();
                    a.d(vVar, "LibraryResult must not be null");
                } catch (CancellationException unused) {
                    i10 = 1;
                    break;
                } catch (InterruptedException | ExecutionException unused2) {
                    i10 = -1;
                    break;
                }
                try {
                    d2 d2Var = e2Var.f6998c;
                    a.f(d2Var);
                    d2Var.k(i13, vVar);
                } catch (RemoteException e10) {
                    v.h("MediaSessionStub", "Failed to send result to browser " + e2Var, e10);
                    return;
                }
            default:
                try {
                    j4Var = (j4) ((e0) obj).get();
                    a.d(j4Var, "SessionResult must not be null");
                } catch (CancellationException unused3) {
                    j4Var = new j4(1);
                } catch (InterruptedException | ExecutionException e11) {
                    if (e11.getCause() instanceof UnsupportedOperationException) {
                        i12 = -6;
                    }
                    j4Var = new j4(i12);
                }
                s3.I0(e2Var, i13, j4Var);
                return;
        }
        String str = v.f7366m;
        if (i10 == 0) {
            z10 = false;
        }
        a.b(z10);
        vVar = new v(i10, SystemClock.elapsedRealtime(), (p1) null, (Object) null, 4);
        d2 d2Var2 = e2Var.f6998c;
        a.f(d2Var2);
        d2Var2.k(i13, vVar);
    }
}
