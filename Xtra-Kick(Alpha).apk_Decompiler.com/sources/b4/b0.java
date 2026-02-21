package b4;

import android.os.Build;

public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f2518a = true;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f2519b = true;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f2520c;

    static {
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = true;
        if (i10 < 28) {
            z10 = false;
        }
        f2520c = z10;
    }

    private b0() {
    }
}
