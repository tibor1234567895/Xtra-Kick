package g;

import android.content.Context;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.support.v4.media.session.u;

public final class f0 extends h0 {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f6067c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ k0 f6068d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f6069e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f0(k0 k0Var, Context context) {
        super(k0Var);
        this.f6068d = k0Var;
        this.f6069e = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    public final IntentFilter c() {
        switch (this.f6067c) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            default:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.TIME_SET");
                intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter2.addAction("android.intent.action.TIME_TICK");
                return intentFilter2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0128 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d() {
        /*
            r25 = this;
            r0 = r25
            int r1 = r0.f6067c
            r2 = 2
            java.lang.Object r3 = r0.f6069e
            r4 = 1
            switch(r1) {
                case 0: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0017
        L_0x000c:
            android.os.PowerManager r3 = (android.os.PowerManager) r3
            boolean r1 = g.z.a(r3)
            if (r1 == 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r2 = 1
        L_0x0016:
            return r2
        L_0x0017:
            android.support.v4.media.session.u r3 = (android.support.v4.media.session.u) r3
            java.lang.Object r1 = r3.f430k
            g.y0 r1 = (g.y0) r1
            long r5 = r1.f6238b
            long r7 = java.lang.System.currentTimeMillis()
            r9 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 <= 0) goto L_0x002a
            r5 = 1
            goto L_0x002b
        L_0x002a:
            r5 = 0
        L_0x002b:
            if (r5 == 0) goto L_0x002f
            goto L_0x0108
        L_0x002f:
            java.lang.Object r5 = r3.f428i
            android.content.Context r5 = (android.content.Context) r5
            java.lang.String r6 = "android.permission.ACCESS_COARSE_LOCATION"
            int r5 = c0.j.a(r5, r6)
            r6 = 0
            if (r5 != 0) goto L_0x0052
            java.lang.String r5 = "network"
            java.lang.Object r7 = r3.f429j     // Catch:{ Exception -> 0x0051 }
            android.location.LocationManager r7 = (android.location.LocationManager) r7     // Catch:{ Exception -> 0x0051 }
            boolean r7 = r7.isProviderEnabled(r5)     // Catch:{ Exception -> 0x0051 }
            if (r7 == 0) goto L_0x0052
            java.lang.Object r7 = r3.f429j     // Catch:{ Exception -> 0x0051 }
            android.location.LocationManager r7 = (android.location.LocationManager) r7     // Catch:{ Exception -> 0x0051 }
            android.location.Location r5 = r7.getLastKnownLocation(r5)     // Catch:{ Exception -> 0x0051 }
            goto L_0x0053
        L_0x0051:
        L_0x0052:
            r5 = r6
        L_0x0053:
            java.lang.Object r7 = r3.f428i
            android.content.Context r7 = (android.content.Context) r7
            java.lang.String r8 = "android.permission.ACCESS_FINE_LOCATION"
            int r7 = c0.j.a(r7, r8)
            if (r7 != 0) goto L_0x0075
            java.lang.String r7 = "gps"
            java.lang.Object r8 = r3.f429j     // Catch:{ Exception -> 0x0074 }
            android.location.LocationManager r8 = (android.location.LocationManager) r8     // Catch:{ Exception -> 0x0074 }
            boolean r8 = r8.isProviderEnabled(r7)     // Catch:{ Exception -> 0x0074 }
            if (r8 == 0) goto L_0x0075
            java.lang.Object r8 = r3.f429j     // Catch:{ Exception -> 0x0074 }
            android.location.LocationManager r8 = (android.location.LocationManager) r8     // Catch:{ Exception -> 0x0074 }
            android.location.Location r6 = r8.getLastKnownLocation(r7)     // Catch:{ Exception -> 0x0074 }
            goto L_0x0075
        L_0x0074:
        L_0x0075:
            if (r6 == 0) goto L_0x0086
            if (r5 == 0) goto L_0x0086
            long r7 = r6.getTime()
            long r10 = r5.getTime()
            int r12 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x0089
            goto L_0x0088
        L_0x0086:
            if (r6 == 0) goto L_0x0089
        L_0x0088:
            r5 = r6
        L_0x0089:
            if (r5 == 0) goto L_0x010b
            java.lang.Object r3 = r3.f430k
            g.y0 r3 = (g.y0) r3
            long r6 = java.lang.System.currentTimeMillis()
            g.x0 r8 = g.x0.f6233d
            if (r8 != 0) goto L_0x009e
            g.x0 r8 = new g.x0
            r8.<init>()
            g.x0.f6233d = r8
        L_0x009e:
            g.x0 r8 = g.x0.f6233d
            r17 = 86400000(0x5265c00, double:4.2687272E-316)
            long r11 = r6 - r17
            double r13 = r5.getLatitude()
            double r15 = r5.getLongitude()
            r10 = r8
            r10.a(r11, r13, r15)
            double r13 = r5.getLatitude()
            double r15 = r5.getLongitude()
            r11 = r6
            r10.a(r11, r13, r15)
            int r10 = r8.f6236c
            if (r10 != r4) goto L_0x00c2
            r9 = 1
        L_0x00c2:
            long r13 = r8.f6235b
            long r11 = r8.f6234a
            long r15 = r6 + r17
            double r17 = r5.getLatitude()
            double r19 = r5.getLongitude()
            r10 = r8
            r21 = r11
            r11 = r15
            r23 = r13
            r13 = r17
            r15 = r19
            r10.a(r11, r13, r15)
            long r10 = r8.f6235b
            r12 = -1
            int r5 = (r23 > r12 ? 1 : (r23 == r12 ? 0 : -1))
            if (r5 == 0) goto L_0x0100
            int r5 = (r21 > r12 ? 1 : (r21 == r12 ? 0 : -1))
            if (r5 != 0) goto L_0x00ea
            goto L_0x0100
        L_0x00ea:
            r12 = 0
            int r5 = (r6 > r21 ? 1 : (r6 == r21 ? 0 : -1))
            if (r5 <= 0) goto L_0x00f2
            long r10 = r10 + r12
            goto L_0x00fb
        L_0x00f2:
            int r5 = (r6 > r23 ? 1 : (r6 == r23 ? 0 : -1))
            if (r5 <= 0) goto L_0x00f9
            long r10 = r21 + r12
            goto L_0x00fb
        L_0x00f9:
            long r10 = r23 + r12
        L_0x00fb:
            r5 = 60000(0xea60, double:2.9644E-319)
            long r10 = r10 + r5
            goto L_0x0104
        L_0x0100:
            r10 = 43200000(0x2932e00, double:2.1343636E-316)
            long r10 = r10 + r6
        L_0x0104:
            r3.f6237a = r9
            r3.f6238b = r10
        L_0x0108:
            boolean r1 = r1.f6237a
            goto L_0x0125
        L_0x010b:
            java.lang.String r1 = "TwilightManager"
            java.lang.String r3 = "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values."
            android.util.Log.i(r1, r3)
            java.util.Calendar r1 = java.util.Calendar.getInstance()
            r3 = 11
            int r1 = r1.get(r3)
            r3 = 6
            if (r1 < r3) goto L_0x0123
            r3 = 22
            if (r1 < r3) goto L_0x0124
        L_0x0123:
            r9 = 1
        L_0x0124:
            r1 = r9
        L_0x0125:
            if (r1 == 0) goto L_0x0128
            goto L_0x0129
        L_0x0128:
            r2 = 1
        L_0x0129:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: g.f0.d():int");
    }

    public final void f() {
        int i10 = this.f6067c;
        k0 k0Var = this.f6068d;
        switch (i10) {
            case 0:
                k0Var.D(true, true);
                return;
            default:
                k0Var.D(true, true);
                return;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f0(k0 k0Var, u uVar) {
        super(k0Var);
        this.f6068d = k0Var;
        this.f6069e = uVar;
    }
}
