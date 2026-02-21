package e1;

import android.content.Context;
import android.os.Build;
import android.util.Log;

public final class d0 {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f4896b = Log.isLoggable("MediaSessionManager", 3);

    /* renamed from: c  reason: collision with root package name */
    public static final Object f4897c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static volatile d0 f4898d;

    /* renamed from: a  reason: collision with root package name */
    public final e0 f4899a;

    public d0(Context context) {
        this.f4899a = Build.VERSION.SDK_INT >= 28 ? new g0(context) : new e0(context);
    }

    public static d0 a(Context context) {
        d0 d0Var;
        if (context != null) {
            synchronized (f4897c) {
                if (f4898d == null) {
                    f4898d = new d0(context.getApplicationContext());
                }
                d0Var = f4898d;
            }
            return d0Var;
        }
        throw new IllegalArgumentException("context cannot be null");
    }

    public final boolean b(c0 c0Var) {
        if (c0Var != null) {
            return this.f4899a.a(c0Var.f4895a);
        }
        throw new IllegalArgumentException("userInfo should not be null");
    }
}
