package g5;

import java.util.concurrent.ThreadFactory;
import l1.j;

public final class a implements ThreadFactory {
    private a() {
    }

    public /* synthetic */ a(int i10) {
        this();
    }

    public final Thread newThread(Runnable runnable) {
        return new j(this, runnable);
    }
}
