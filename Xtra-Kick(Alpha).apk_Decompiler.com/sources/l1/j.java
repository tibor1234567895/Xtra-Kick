package l1;

import android.os.Process;
import g5.a;
import w2.c;

public final class j extends Thread {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9522h = 1;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f9523i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(a aVar, Runnable runnable) {
        super(runnable);
        this.f9523i = aVar;
    }

    public final void run() {
        switch (this.f9522h) {
            case 0:
                c cVar = (c) this.f9523i;
                cVar.getClass();
                do {
                    try {
                    } catch (InterruptedException e10) {
                        throw new IllegalStateException(e10);
                    }
                } while (cVar.h());
                return;
            default:
                Process.setThreadPriority(9);
                super.run();
                return;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(c cVar) {
        super("ExoPlayer:SimpleDecoder");
        this.f9523i = cVar;
    }
}
