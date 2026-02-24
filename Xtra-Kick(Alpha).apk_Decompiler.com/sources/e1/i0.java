package e1;

import android.content.ContentResolver;
import android.content.Context;

public abstract class i0 implements b0 {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f4913c = d0.f4896b;

    /* renamed from: a  reason: collision with root package name */
    public Context f4914a;

    /* renamed from: b  reason: collision with root package name */
    public final ContentResolver f4915b;

    public i0(Context context) {
        this.f4914a = context;
        this.f4915b = context.getContentResolver();
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(e1.h0 r7) {
        /*
            r6 = this;
            r0 = 0
            android.content.Context r1 = r6.f4914a     // Catch:{ NameNotFoundException -> 0x0059 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0059 }
            java.lang.String r2 = r7.f4909a     // Catch:{ NameNotFoundException -> 0x0059 }
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo(r2, r0)     // Catch:{ NameNotFoundException -> 0x0059 }
            if (r1 != 0) goto L_0x0010
            return r0
        L_0x0010:
            java.lang.String r1 = "android.permission.STATUS_BAR_SERVICE"
            boolean r1 = r6.b(r7, r1)
            r2 = 1
            if (r1 != 0) goto L_0x0057
            java.lang.String r1 = "android.permission.MEDIA_CONTENT_CONTROL"
            boolean r1 = r6.b(r7, r1)
            if (r1 != 0) goto L_0x0057
            r1 = 1000(0x3e8, float:1.401E-42)
            int r3 = r7.f4911c
            if (r3 == r1) goto L_0x0057
            android.content.ContentResolver r1 = r6.f4915b
            java.lang.String r3 = "enabled_notification_listeners"
            java.lang.String r1 = android.provider.Settings.Secure.getString(r1, r3)
            if (r1 == 0) goto L_0x0054
            java.lang.String r3 = ":"
            java.lang.String[] r1 = r1.split(r3)
            r3 = 0
        L_0x0038:
            int r4 = r1.length
            if (r3 >= r4) goto L_0x0054
            r4 = r1[r3]
            android.content.ComponentName r4 = android.content.ComponentName.unflattenFromString(r4)
            if (r4 == 0) goto L_0x0051
            java.lang.String r4 = r4.getPackageName()
            java.lang.String r5 = r7.f4909a
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0051
            r7 = 1
            goto L_0x0055
        L_0x0051:
            int r3 = r3 + 1
            goto L_0x0038
        L_0x0054:
            r7 = 0
        L_0x0055:
            if (r7 == 0) goto L_0x0058
        L_0x0057:
            r0 = 1
        L_0x0058:
            return r0
        L_0x0059:
            boolean r1 = f4913c
            if (r1 == 0) goto L_0x0060
            java.lang.String r7 = r7.f4909a
        L_0x0060:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.i0.a(e1.h0):boolean");
    }

    public final boolean b(h0 h0Var, String str) {
        int i10 = h0Var.f4910b;
        if (i10 < 0) {
            if (this.f4914a.getPackageManager().checkPermission(str, h0Var.f4909a) == 0) {
                return true;
            }
            return false;
        } else if (this.f4914a.checkPermission(str, i10, h0Var.f4911c) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
