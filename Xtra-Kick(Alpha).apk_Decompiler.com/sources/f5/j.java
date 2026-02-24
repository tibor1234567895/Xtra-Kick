package f5;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import b4.e0;

public final class j {

    /* renamed from: e  reason: collision with root package name */
    public static final int f5824e = (Build.VERSION.SDK_INT < 26 ? 4 : 1);

    /* renamed from: a  reason: collision with root package name */
    public final Context f5825a;

    /* renamed from: b  reason: collision with root package name */
    public final ActivityManager f5826b;

    /* renamed from: c  reason: collision with root package name */
    public final e0 f5827c;

    /* renamed from: d  reason: collision with root package name */
    public final float f5828d = ((float) f5824e);

    public j(Context context) {
        this.f5825a = context;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this.f5826b = activityManager;
        this.f5827c = new e0(6, context.getResources().getDisplayMetrics());
        if (Build.VERSION.SDK_INT >= 26 && activityManager.isLowRamDevice()) {
            this.f5828d = 0.0f;
        }
    }
}
