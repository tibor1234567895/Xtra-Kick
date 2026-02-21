package androidx.activity;

import android.app.Activity;
import androidx.lifecycle.b0;
import java.lang.reflect.Field;

final class ImmLeaksCleaner implements b0 {

    /* renamed from: i  reason: collision with root package name */
    public static int f466i;

    /* renamed from: j  reason: collision with root package name */
    public static Field f467j;

    /* renamed from: k  reason: collision with root package name */
    public static Field f468k;

    /* renamed from: l  reason: collision with root package name */
    public static Field f469l;

    /* renamed from: h  reason: collision with root package name */
    public final Activity f470h;

    public ImmLeaksCleaner(Activity activity) {
        this.f470h = activity;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:32|33|34) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006c, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x006b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(androidx.lifecycle.d0 r3, androidx.lifecycle.r r4) {
        /*
            r2 = this;
            androidx.lifecycle.r r3 = androidx.lifecycle.r.ON_DESTROY
            if (r4 == r3) goto L_0x0005
            return
        L_0x0005:
            int r3 = f466i
            r4 = 1
            if (r3 != 0) goto L_0x0034
            java.lang.Class<android.view.inputmethod.InputMethodManager> r3 = android.view.inputmethod.InputMethodManager.class
            r0 = 2
            f466i = r0     // Catch:{ NoSuchFieldException -> 0x0033 }
            java.lang.String r0 = "mServedView"
            java.lang.reflect.Field r0 = r3.getDeclaredField(r0)     // Catch:{ NoSuchFieldException -> 0x0033 }
            f468k = r0     // Catch:{ NoSuchFieldException -> 0x0033 }
            r0.setAccessible(r4)     // Catch:{ NoSuchFieldException -> 0x0033 }
            java.lang.String r0 = "mNextServedView"
            java.lang.reflect.Field r0 = r3.getDeclaredField(r0)     // Catch:{ NoSuchFieldException -> 0x0033 }
            f469l = r0     // Catch:{ NoSuchFieldException -> 0x0033 }
            r0.setAccessible(r4)     // Catch:{ NoSuchFieldException -> 0x0033 }
            java.lang.String r0 = "mH"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r0)     // Catch:{ NoSuchFieldException -> 0x0033 }
            f467j = r3     // Catch:{ NoSuchFieldException -> 0x0033 }
            r3.setAccessible(r4)     // Catch:{ NoSuchFieldException -> 0x0033 }
            f466i = r4     // Catch:{ NoSuchFieldException -> 0x0033 }
            goto L_0x0034
        L_0x0033:
        L_0x0034:
            int r3 = f466i
            if (r3 != r4) goto L_0x0075
            android.app.Activity r3 = r2.f470h
            java.lang.String r4 = "input_method"
            java.lang.Object r3 = r3.getSystemService(r4)
            android.view.inputmethod.InputMethodManager r3 = (android.view.inputmethod.InputMethodManager) r3
            java.lang.reflect.Field r4 = f467j     // Catch:{ IllegalAccessException -> 0x0075 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ IllegalAccessException -> 0x0075 }
            if (r4 != 0) goto L_0x004b
            return
        L_0x004b:
            monitor-enter(r4)
            java.lang.reflect.Field r0 = f468k     // Catch:{ IllegalAccessException -> 0x0071, ClassCastException -> 0x006f }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ IllegalAccessException -> 0x0071, ClassCastException -> 0x006f }
            android.view.View r0 = (android.view.View) r0     // Catch:{ IllegalAccessException -> 0x0071, ClassCastException -> 0x006f }
            if (r0 != 0) goto L_0x0058
            monitor-exit(r4)     // Catch:{ all -> 0x006d }
            return
        L_0x0058:
            boolean r0 = r0.isAttachedToWindow()     // Catch:{ all -> 0x006d }
            if (r0 == 0) goto L_0x0060
            monitor-exit(r4)     // Catch:{ all -> 0x006d }
            return
        L_0x0060:
            java.lang.reflect.Field r0 = f469l     // Catch:{ IllegalAccessException -> 0x006b }
            r1 = 0
            r0.set(r3, r1)     // Catch:{ IllegalAccessException -> 0x006b }
            monitor-exit(r4)     // Catch:{ all -> 0x006d }
            r3.isActive()
            goto L_0x0075
        L_0x006b:
            monitor-exit(r4)     // Catch:{ all -> 0x006d }
            return
        L_0x006d:
            r3 = move-exception
            goto L_0x0073
        L_0x006f:
            monitor-exit(r4)     // Catch:{ all -> 0x006d }
            return
        L_0x0071:
            monitor-exit(r4)     // Catch:{ all -> 0x006d }
            return
        L_0x0073:
            monitor-exit(r4)     // Catch:{ all -> 0x006d }
            throw r3
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.ImmLeaksCleaner.d(androidx.lifecycle.d0, androidx.lifecycle.r):void");
    }
}
