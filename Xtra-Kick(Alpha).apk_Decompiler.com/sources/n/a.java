package n;

import java.util.concurrent.Executor;

public final /* synthetic */ class a implements Executor {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10891h;

    public /* synthetic */ a(int i10) {
        this.f10891h = i10;
    }

    public final void execute(Runnable runnable) {
        switch (this.f10891h) {
            case 1:
                b.a().f10894a.f10897b.execute(runnable);
                return;
            case 2:
                runnable.run();
                return;
            case 3:
                runnable.run();
                return;
            case 4:
                runnable.run();
                return;
            default:
                runnable.run();
                return;
        }
    }
}
