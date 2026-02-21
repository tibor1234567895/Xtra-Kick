package p3;

import android.content.Context;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import n.a;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f12546h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Context f12547i;

    public /* synthetic */ i(Context context, int i10) {
        this.f12546h = i10;
        this.f12547i = context;
    }

    public final void run() {
        int i10 = this.f12546h;
        Context context = this.f12547i;
        switch (i10) {
            case 0:
                new ThreadPoolExecutor(0, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new i(context, 1));
                return;
            default:
                h.b(context, new a(5), h.f12544a, false);
                return;
        }
    }
}
