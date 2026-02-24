package m0;

import android.os.Build;

public final class c2 {

    /* renamed from: a  reason: collision with root package name */
    public final g2 f10061a;

    public c2() {
        int i10 = Build.VERSION.SDK_INT;
        this.f10061a = i10 >= 30 ? new f2() : i10 >= 29 ? new e2() : new d2();
    }
}
