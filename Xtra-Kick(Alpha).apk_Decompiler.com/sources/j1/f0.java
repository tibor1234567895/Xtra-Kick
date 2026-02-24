package j1;

import android.os.Handler;
import java.util.ArrayList;

public final class f0 implements n {

    /* renamed from: b  reason: collision with root package name */
    public static final ArrayList f8428b = new ArrayList(50);

    /* renamed from: a  reason: collision with root package name */
    public final Handler f8429a;

    public f0(Handler handler) {
        this.f8429a = handler;
    }

    public static e0 b() {
        e0 e0Var;
        ArrayList arrayList = f8428b;
        synchronized (arrayList) {
            e0Var = arrayList.isEmpty() ? new e0(0) : (e0) arrayList.remove(arrayList.size() - 1);
        }
        return e0Var;
    }

    public final e0 a(int i10, Object obj) {
        e0 b10 = b();
        b10.f8423a = this.f8429a.obtainMessage(i10, obj);
        return b10;
    }

    public final boolean c(Runnable runnable) {
        return this.f8429a.post(runnable);
    }

    public final boolean d(int i10) {
        return this.f8429a.sendEmptyMessage(i10);
    }
}
