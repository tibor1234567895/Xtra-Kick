package h3;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import java.util.Objects;

public final class v0 implements ServiceConnection {

    /* renamed from: h  reason: collision with root package name */
    public final Bundle f7377h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ y0 f7378i;

    public v0(Bundle bundle, y0 y0Var) {
        this.f7378i = y0Var;
        this.f7377h = bundle;
    }

    public final void onBindingDied(ComponentName componentName) {
        b0 b0Var = this.f7378i.f7453a;
        Objects.requireNonNull(b0Var);
        b0Var.S0(new r0(b0Var, 2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0092 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r8, android.os.IBinder r9) {
        /*
            r7 = this;
            java.lang.String r0 = "MCImplBase"
            h3.y0 r1 = r7.f7378i
            java.lang.String r2 = "Expected connection to "
            java.lang.String r3 = "Service "
            h3.l4 r4 = r1.f7457e     // Catch:{ RemoteException -> 0x0092 }
            h3.k4 r4 = r4.f7191h     // Catch:{ RemoteException -> 0x0092 }
            java.lang.String r4 = r4.g()     // Catch:{ RemoteException -> 0x0092 }
            java.lang.String r5 = r8.getPackageName()     // Catch:{ RemoteException -> 0x0092 }
            boolean r4 = r4.equals(r5)     // Catch:{ RemoteException -> 0x0092 }
            h3.b0 r5 = r1.f7453a
            if (r4 != 0) goto L_0x004a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x0092 }
            r9.<init>(r2)     // Catch:{ RemoteException -> 0x0092 }
            h3.l4 r2 = r1.f7457e     // Catch:{ RemoteException -> 0x0092 }
            h3.k4 r2 = r2.f7191h     // Catch:{ RemoteException -> 0x0092 }
            java.lang.String r2 = r2.g()     // Catch:{ RemoteException -> 0x0092 }
            r9.append(r2)     // Catch:{ RemoteException -> 0x0092 }
            java.lang.String r2 = " but is connected to "
            r9.append(r2)     // Catch:{ RemoteException -> 0x0092 }
            r9.append(r8)     // Catch:{ RemoteException -> 0x0092 }
            java.lang.String r9 = r9.toString()     // Catch:{ RemoteException -> 0x0092 }
            j1.v.c(r0, r9)     // Catch:{ RemoteException -> 0x0092 }
            java.util.Objects.requireNonNull(r5)
            h3.r0 r8 = new h3.r0
            r9 = 4
            r8.<init>(r5, r9)
        L_0x0044:
            r5.S0(r8)
            return
        L_0x0048:
            r8 = move-exception
            goto L_0x00b5
        L_0x004a:
            int r2 = h3.t.f7323c     // Catch:{ RemoteException -> 0x0092 }
            if (r9 != 0) goto L_0x0050
            r9 = 0
            goto L_0x0066
        L_0x0050:
            java.lang.String r2 = "androidx.media3.session.IMediaSessionService"
            android.os.IInterface r2 = r9.queryLocalInterface(r2)     // Catch:{ RemoteException -> 0x0092 }
            if (r2 == 0) goto L_0x0060
            boolean r4 = r2 instanceof h3.u     // Catch:{ RemoteException -> 0x0092 }
            if (r4 == 0) goto L_0x0060
            r9 = r2
            h3.u r9 = (h3.u) r9     // Catch:{ RemoteException -> 0x0092 }
            goto L_0x0066
        L_0x0060:
            h3.s r2 = new h3.s     // Catch:{ RemoteException -> 0x0092 }
            r2.<init>(r9)     // Catch:{ RemoteException -> 0x0092 }
            r9 = r2
        L_0x0066:
            if (r9 != 0) goto L_0x0077
            java.lang.String r9 = "Service interface is missing."
            j1.v.c(r0, r9)     // Catch:{ RemoteException -> 0x0092 }
            java.util.Objects.requireNonNull(r5)
            h3.r0 r8 = new h3.r0
            r9 = 5
            r8.<init>(r5, r9)
            goto L_0x0044
        L_0x0077:
            h3.h r2 = new h3.h     // Catch:{ RemoteException -> 0x0092 }
            android.content.Context r4 = r1.f7456d     // Catch:{ RemoteException -> 0x0092 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ RemoteException -> 0x0092 }
            int r5 = android.os.Process.myPid()     // Catch:{ RemoteException -> 0x0092 }
            android.os.Bundle r6 = r7.f7377h     // Catch:{ RemoteException -> 0x0092 }
            r2.<init>(r4, r5, r6)     // Catch:{ RemoteException -> 0x0092 }
            h3.o1 r4 = r1.f7455c     // Catch:{ RemoteException -> 0x0092 }
            android.os.Bundle r2 = r2.h()     // Catch:{ RemoteException -> 0x0092 }
            r9.r(r4, r2)     // Catch:{ RemoteException -> 0x0092 }
            goto L_0x00b4
        L_0x0092:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
            r9.<init>(r3)     // Catch:{ all -> 0x0048 }
            r9.append(r8)     // Catch:{ all -> 0x0048 }
            java.lang.String r8 = " has died prematurely"
            r9.append(r8)     // Catch:{ all -> 0x0048 }
            java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x0048 }
            j1.v.g(r0, r8)     // Catch:{ all -> 0x0048 }
            h3.b0 r8 = r1.f7453a
            java.util.Objects.requireNonNull(r8)
            h3.r0 r9 = new h3.r0
            r0 = 7
            r9.<init>(r8, r0)
            r8.S0(r9)
        L_0x00b4:
            return
        L_0x00b5:
            h3.b0 r9 = r1.f7453a
            java.util.Objects.requireNonNull(r9)
            h3.r0 r0 = new h3.r0
            r1 = 8
            r0.<init>(r9, r1)
            r9.S0(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.v0.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        b0 b0Var = this.f7378i.f7453a;
        Objects.requireNonNull(b0Var);
        b0Var.S0(new r0(b0Var, 3));
    }
}
