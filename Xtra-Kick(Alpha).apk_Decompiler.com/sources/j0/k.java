package j0;

import android.os.Process;

public final class k extends Thread {

    /* renamed from: h  reason: collision with root package name */
    public final int f8402h;

    public k(Runnable runnable, String str, int i10) {
        super(runnable, str);
        this.f8402h = i10;
    }

    public final void run() {
        Process.setThreadPriority(this.f8402h);
        super.run();
    }
}
