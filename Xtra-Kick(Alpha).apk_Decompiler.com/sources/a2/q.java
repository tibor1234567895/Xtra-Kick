package a2;

import android.os.Looper;
import android.os.SystemClock;
import androidx.activity.h;
import androidx.emoji2.text.a;
import j1.l0;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class q {

    /* renamed from: d  reason: collision with root package name */
    public static final k f71d = b(-9223372036854775807L, false);

    /* renamed from: e  reason: collision with root package name */
    public static final k f72e = new k(2, -9223372036854775807L, 0);

    /* renamed from: f  reason: collision with root package name */
    public static final k f73f = new k(3, -9223372036854775807L, 0);

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f74a;

    /* renamed from: b  reason: collision with root package name */
    public m f75b;

    /* renamed from: c  reason: collision with root package name */
    public IOException f76c;

    public q(String str) {
        String concat = "ExoPlayer:Loader:".concat(str);
        int i10 = l0.f8453a;
        this.f74a = Executors.newSingleThreadExecutor(new a(concat, 1));
    }

    public static k b(long j10, boolean z10) {
        return new k(z10 ? 1 : 0, j10, 0);
    }

    public final void a() {
        m mVar = this.f75b;
        j1.a.f(mVar);
        mVar.a(false);
    }

    public final boolean c() {
        return this.f76c != null;
    }

    public final boolean d() {
        return this.f75b != null;
    }

    public final void e() {
        IOException iOException;
        IOException iOException2 = this.f76c;
        if (iOException2 == null) {
            m mVar = this.f75b;
            if (mVar != null && (iOException = mVar.f65l) != null && mVar.f66m > mVar.f61h) {
                throw iOException;
            }
            return;
        }
        throw iOException2;
    }

    public final void f(o oVar) {
        m mVar = this.f75b;
        if (mVar != null) {
            mVar.a(true);
        }
        ExecutorService executorService = this.f74a;
        if (oVar != null) {
            executorService.execute(new h(7, oVar));
        }
        executorService.shutdown();
    }

    public final long g(n nVar, l lVar, int i10) {
        Looper myLooper = Looper.myLooper();
        j1.a.f(myLooper);
        this.f76c = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new m(this, myLooper, nVar, lVar, i10, elapsedRealtime).b(0);
        return elapsedRealtime;
    }
}
