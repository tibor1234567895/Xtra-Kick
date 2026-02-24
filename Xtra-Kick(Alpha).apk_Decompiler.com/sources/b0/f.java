package b0;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public final class f implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public Object f2340a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f2341b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2342c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2343d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2344e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2345f = false;

    public f(Activity activity) {
        this.f2341b = activity;
        this.f2342c = activity.hashCode();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        if (this.f2341b == activity) {
            this.f2341b = null;
            this.f2344e = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityPaused(android.app.Activity r6) {
        /*
            r5 = this;
            boolean r0 = r5.f2344e
            if (r0 == 0) goto L_0x0043
            boolean r0 = r5.f2345f
            if (r0 != 0) goto L_0x0043
            boolean r0 = r5.f2343d
            if (r0 != 0) goto L_0x0043
            java.lang.Object r0 = r5.f2340a
            r1 = 1
            java.lang.reflect.Field r2 = b0.g.f2348c     // Catch:{ all -> 0x0033 }
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x0033 }
            if (r2 != r0) goto L_0x003b
            int r0 = r6.hashCode()     // Catch:{ all -> 0x0033 }
            int r3 = r5.f2342c
            if (r0 == r3) goto L_0x0020
            goto L_0x003b
        L_0x0020:
            java.lang.reflect.Field r0 = b0.g.f2347b     // Catch:{ all -> 0x0033 }
            java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x0033 }
            android.os.Handler r0 = b0.g.f2352g     // Catch:{ all -> 0x0033 }
            android.support.v4.media.j r3 = new android.support.v4.media.j     // Catch:{ all -> 0x0033 }
            r4 = 4
            r3.<init>((java.lang.Object) r6, (java.lang.Object) r2, (int) r4)     // Catch:{ all -> 0x0033 }
            r0.postAtFrontOfQueue(r3)     // Catch:{ all -> 0x0033 }
            r6 = 1
            goto L_0x003c
        L_0x0033:
            r6 = move-exception
            java.lang.String r0 = "ActivityRecreator"
            java.lang.String r2 = "Exception while fetching field values"
            android.util.Log.e(r0, r2, r6)
        L_0x003b:
            r6 = 0
        L_0x003c:
            if (r6 == 0) goto L_0x0043
            r5.f2345f = r1
            r6 = 0
            r5.f2340a = r6
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.f.onActivityPaused(android.app.Activity):void");
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        if (this.f2341b == activity) {
            this.f2343d = true;
        }
    }

    public final void onActivityStopped(Activity activity) {
    }
}
