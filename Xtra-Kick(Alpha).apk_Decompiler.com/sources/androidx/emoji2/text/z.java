package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import androidx.appcompat.widget.b0;
import j0.c;
import j0.h;
import j0.i;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import r0.a;

public final class z implements m {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1301a;

    /* renamed from: b  reason: collision with root package name */
    public final b0 f1302b;

    /* renamed from: c  reason: collision with root package name */
    public final x f1303c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f1304d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public Handler f1305e;

    /* renamed from: f  reason: collision with root package name */
    public Executor f1306f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadPoolExecutor f1307g;

    /* renamed from: h  reason: collision with root package name */
    public n f1308h;

    /* renamed from: i  reason: collision with root package name */
    public a f1309i;

    public z(Context context, b0 b0Var, x xVar) {
        if (context != null) {
            this.f1301a = context.getApplicationContext();
            this.f1302b = b0Var;
            this.f1303c = xVar;
            return;
        }
        throw new NullPointerException("Context cannot be null");
    }

    public final void a(n nVar) {
        synchronized (this.f1304d) {
            this.f1308h = nVar;
        }
        c();
    }

    public final void b() {
        synchronized (this.f1304d) {
            this.f1308h = null;
            a aVar = this.f1309i;
            if (aVar != null) {
                x xVar = this.f1303c;
                Context context = this.f1301a;
                xVar.getClass();
                context.getContentResolver().unregisterContentObserver(aVar);
                this.f1309i = null;
            }
            Handler handler = this.f1305e;
            if (handler != null) {
                handler.removeCallbacks((Runnable) null);
            }
            this.f1305e = null;
            ThreadPoolExecutor threadPoolExecutor = this.f1307g;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.shutdown();
            }
            this.f1306f = null;
            this.f1307g = null;
        }
    }

    public final void c() {
        synchronized (this.f1304d) {
            if (this.f1308h != null) {
                if (this.f1306f == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a("emojiCompat", 0));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.f1307g = threadPoolExecutor;
                    this.f1306f = threadPoolExecutor;
                }
                this.f1306f.execute(new y(this, 0));
            }
        }
    }

    public final i d() {
        try {
            x xVar = this.f1303c;
            Context context = this.f1301a;
            b0 b0Var = this.f1302b;
            xVar.getClass();
            h a10 = c.a(context, b0Var);
            if (a10.f8395h == 0) {
                i[] iVarArr = (i[]) a10.f8396i;
                if (iVarArr != null && iVarArr.length != 0) {
                    return iVarArr[0];
                }
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            throw new RuntimeException(android.support.v4.media.h.o(new StringBuilder("fetchFonts failed ("), a10.f8395h, ")"));
        } catch (PackageManager.NameNotFoundException e10) {
            throw new RuntimeException("provider not found", e10);
        }
    }
}
