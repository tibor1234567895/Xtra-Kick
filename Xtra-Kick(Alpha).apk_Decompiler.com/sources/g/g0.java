package g;

import android.content.BroadcastReceiver;
import h3.x2;
import j1.z;
import m1.s1;

public final class g0 extends BroadcastReceiver {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f6073c = 0;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6074a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f6075b;

    public /* synthetic */ g0(int i10, Object obj) {
        this.f6074a = i10;
        this.f6075b = obj;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02a7 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceive(android.content.Context r11, android.content.Intent r12) {
        /*
            r10 = this;
            int r0 = r10.f6074a
            r1 = 3
            r2 = 8
            r3 = 2
            r4 = 1
            r5 = 0
            switch(r0) {
                case 0: goto L_0x02d0;
                case 1: goto L_0x0251;
                case 2: goto L_0x0242;
                case 3: goto L_0x0211;
                case 4: goto L_0x01ff;
                case 5: goto L_0x0091;
                case 6: goto L_0x0054;
                case 7: goto L_0x000d;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x02d8
        L_0x000d:
            if (r11 == 0) goto L_0x0053
            if (r12 == 0) goto L_0x0053
            java.lang.String r11 = r12.getAction()
            if (r11 != 0) goto L_0x0018
            goto L_0x0053
        L_0x0018:
            int r0 = r11.hashCode()
            r1 = -1500940653(0xffffffffa6897693, float:-9.538424E-16)
            if (r0 == r1) goto L_0x0022
            goto L_0x0053
        L_0x0022:
            java.lang.String r0 = "com.tonyodev.fetch2.action.QUEUE_BACKOFF_RESET"
            boolean r11 = r11.equals(r0)
            if (r11 == 0) goto L_0x0053
            java.lang.Object r11 = r10.f6075b
            u9.f r11 = (u9.f) r11
            boolean r11 = r11.f15450k
            if (r11 != 0) goto L_0x0053
            java.lang.Object r11 = r10.f6075b
            u9.f r11 = (u9.f) r11
            boolean r11 = r11.f15449j
            if (r11 != 0) goto L_0x0053
            java.lang.Object r11 = r10.f6075b
            u9.f r11 = (u9.f) r11
            java.lang.String r11 = r11.f15463x
            java.lang.String r0 = "com.tonyodev.fetch2.extra.NAMESPACE"
            java.lang.String r12 = r12.getStringExtra(r0)
            boolean r11 = xa.j.a(r11, r12)
            if (r11 == 0) goto L_0x0053
            java.lang.Object r11 = r10.f6075b
            u9.f r11 = (u9.f) r11
            r11.k()
        L_0x0053:
            return
        L_0x0054:
            java.lang.String r0 = "context"
            xa.j.f(r0, r11)
            java.lang.String r11 = "intent"
            xa.j.f(r11, r12)
            java.lang.Object r11 = r10.f6075b
            com.github.andreyasadchy.xtra.ui.main.MainActivity r11 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r11
            int r12 = com.github.andreyasadchy.xtra.ui.main.MainActivity.N
            com.github.andreyasadchy.xtra.ui.main.MainViewModel r12 = r11.F()
            boolean r11 = hb.h0.X0(r11)
            androidx.lifecycle.o0 r12 = r12.f3432d
            java.lang.Object r0 = r12.d()
            s7.e r0 = (s7.e) r0
            if (r0 == 0) goto L_0x0081
            java.lang.Object r0 = r0.f14370a
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != r11) goto L_0x0081
            goto L_0x0082
        L_0x0081:
            r4 = 0
        L_0x0082:
            if (r4 != 0) goto L_0x0090
            s7.e r0 = new s7.e
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)
            r0.<init>(r11)
            r12.l(r0)
        L_0x0090:
            return
        L_0x0091:
            java.lang.String r0 = "context"
            xa.j.f(r0, r11)
            java.lang.String r11 = "intent"
            xa.j.f(r11, r12)
            java.lang.String r11 = r12.getAction()
            if (r11 == 0) goto L_0x01fe
            int r12 = r11.hashCode()
            r0 = 1448038017(0x564f4e81, float:5.698402E13)
            r2 = 0
            if (r12 == r0) goto L_0x0165
            r0 = 1567102767(0x5d68172f, float:1.04524296E18)
            if (r12 == r0) goto L_0x013a
            r0 = 2000400610(0x773bb0e2, float:3.8068247E33)
            if (r12 == r0) goto L_0x00b7
            goto L_0x01fe
        L_0x00b7:
            java.lang.String r12 = "com.github.andreyasadchy.xtra.ACTION_DOWNLOAD_RESUME"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x00c1
            goto L_0x01fe
        L_0x00c1:
            java.lang.Object r11 = r10.f6075b
            com.github.andreyasadchy.xtra.ui.download.DownloadService r11 = (com.github.andreyasadchy.xtra.ui.download.DownloadService) r11
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r11 = r11.f3389r
            if (r11 == 0) goto L_0x0134
            r11.getId()
            java.lang.Object r11 = r10.f6075b
            com.github.andreyasadchy.xtra.ui.download.DownloadService r11 = (com.github.andreyasadchy.xtra.ui.download.DownloadService) r11
            b0.l0 r12 = r11.f3387p
            if (r12 == 0) goto L_0x012e
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r11 = r11.f3389r
            if (r11 == 0) goto L_0x0128
            int r11 = r11.getId()
            java.lang.Object r0 = r10.f6075b
            com.github.andreyasadchy.xtra.ui.download.DownloadService r0 = (com.github.andreyasadchy.xtra.ui.download.DownloadService) r0
            b0.p r1 = r0.f3386o
            if (r1 == 0) goto L_0x0122
            java.util.ArrayList r3 = r1.f2386b
            r3.remove(r5)
            java.util.ArrayList r3 = r1.f2386b
            b0.o r0 = r0.f3392u
            if (r0 == 0) goto L_0x011c
            r3.add(r0)
            android.app.Notification r0 = r1.a()
            r12.a(r11, r0)
            java.lang.Object r11 = r10.f6075b
            com.github.andreyasadchy.xtra.ui.download.DownloadService r11 = (com.github.andreyasadchy.xtra.ui.download.DownloadService) r11
            p9.h r12 = r11.f3385n
            if (r12 == 0) goto L_0x0116
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r11 = r11.f3389r
            if (r11 == 0) goto L_0x0110
            int r11 = r11.getId()
            t9.m r12 = (t9.m) r12
            r12.d(r11)
            goto L_0x01fe
        L_0x0110:
            java.lang.String r11 = "offlineVideo"
            xa.j.l(r11)
            throw r2
        L_0x0116:
            java.lang.String r11 = "fetch"
            xa.j.l(r11)
            throw r2
        L_0x011c:
            java.lang.String r11 = "pauseAction"
            xa.j.l(r11)
            throw r2
        L_0x0122:
            java.lang.String r11 = "notificationBuilder"
            xa.j.l(r11)
            throw r2
        L_0x0128:
            java.lang.String r11 = "offlineVideo"
            xa.j.l(r11)
            throw r2
        L_0x012e:
            java.lang.String r11 = "notificationManager"
            xa.j.l(r11)
            throw r2
        L_0x0134:
            java.lang.String r11 = "offlineVideo"
            xa.j.l(r11)
            throw r2
        L_0x013a:
            java.lang.String r12 = "com.github.andreyasadchy.xtra.ACTION_DOWNLOAD_CANCEL"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0144
            goto L_0x01fe
        L_0x0144:
            java.lang.Object r11 = r10.f6075b
            com.github.andreyasadchy.xtra.ui.download.DownloadService r11 = (com.github.andreyasadchy.xtra.ui.download.DownloadService) r11
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r11 = r11.f3389r
            if (r11 == 0) goto L_0x015f
            r11.getId()
            hb.d1 r11 = hb.d1.f7786h
            m6.j r12 = new m6.j
            java.lang.Object r0 = r10.f6075b
            com.github.andreyasadchy.xtra.ui.download.DownloadService r0 = (com.github.andreyasadchy.xtra.ui.download.DownloadService) r0
            r12.<init>(r0, r2)
            hb.h0.b1(r11, r2, r5, r12, r1)
            goto L_0x01fe
        L_0x015f:
            java.lang.String r11 = "offlineVideo"
            xa.j.l(r11)
            throw r2
        L_0x0165:
            java.lang.String r12 = "com.github.andreyasadchy.xtra.ACTION_DOWNLOAD_PAUSE"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x016f
            goto L_0x01fe
        L_0x016f:
            java.lang.Object r11 = r10.f6075b
            com.github.andreyasadchy.xtra.ui.download.DownloadService r11 = (com.github.andreyasadchy.xtra.ui.download.DownloadService) r11
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r11 = r11.f3389r
            if (r11 == 0) goto L_0x01f8
            r11.getId()
            java.lang.Object r11 = r10.f6075b
            com.github.andreyasadchy.xtra.ui.download.DownloadService r11 = (com.github.andreyasadchy.xtra.ui.download.DownloadService) r11
            b0.l0 r12 = r11.f3387p
            if (r12 == 0) goto L_0x01f2
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r11 = r11.f3389r
            if (r11 == 0) goto L_0x01ec
            int r11 = r11.getId()
            java.lang.Object r0 = r10.f6075b
            com.github.andreyasadchy.xtra.ui.download.DownloadService r0 = (com.github.andreyasadchy.xtra.ui.download.DownloadService) r0
            b0.p r1 = r0.f3386o
            if (r1 == 0) goto L_0x01e6
            java.util.ArrayList r3 = r1.f2386b
            r3.remove(r5)
            java.util.ArrayList r3 = r1.f2386b
            b0.o r0 = r0.f3393v
            if (r0 == 0) goto L_0x01e0
            r3.add(r0)
            android.app.Notification r0 = r1.a()
            r12.a(r11, r0)
            java.lang.Object r11 = r10.f6075b
            com.github.andreyasadchy.xtra.ui.download.DownloadService r11 = (com.github.andreyasadchy.xtra.ui.download.DownloadService) r11
            p9.h r12 = r11.f3385n
            if (r12 == 0) goto L_0x01da
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r11 = r11.f3389r
            if (r11 == 0) goto L_0x01d4
            int r11 = r11.getId()
            t9.m r12 = (t9.m) r12
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            java.lang.Object r0 = r12.f14875b
            monitor-enter(r0)
            r12.e()     // Catch:{ all -> 0x01d1 }
            y9.p r1 = r12.f14881h     // Catch:{ all -> 0x01d1 }
            t9.l r2 = new t9.l     // Catch:{ all -> 0x01d1 }
            r2.<init>(r12, r11, r5)     // Catch:{ all -> 0x01d1 }
            r1.d(r2)     // Catch:{ all -> 0x01d1 }
            la.v r11 = la.v.f9814a     // Catch:{ all -> 0x01d1 }
            monitor-exit(r0)
            goto L_0x01fe
        L_0x01d1:
            r11 = move-exception
            monitor-exit(r0)
            throw r11
        L_0x01d4:
            java.lang.String r11 = "offlineVideo"
            xa.j.l(r11)
            throw r2
        L_0x01da:
            java.lang.String r11 = "fetch"
            xa.j.l(r11)
            throw r2
        L_0x01e0:
            java.lang.String r11 = "resumeAction"
            xa.j.l(r11)
            throw r2
        L_0x01e6:
            java.lang.String r11 = "notificationBuilder"
            xa.j.l(r11)
            throw r2
        L_0x01ec:
            java.lang.String r11 = "offlineVideo"
            xa.j.l(r11)
            throw r2
        L_0x01f2:
            java.lang.String r11 = "notificationManager"
            xa.j.l(r11)
            throw r2
        L_0x01f8:
            java.lang.String r11 = "offlineVideo"
            xa.j.l(r11)
            throw r2
        L_0x01fe:
            return
        L_0x01ff:
            java.lang.Object r11 = r10.f6075b
            com.bumptech.glide.manager.a0 r11 = (com.bumptech.glide.manager.a0) r11
            r11.getClass()
            com.bumptech.glide.manager.z r12 = new com.bumptech.glide.manager.z
            r12.<init>(r11, r3)
            java.util.concurrent.Executor r11 = com.bumptech.glide.manager.a0.f3248n
            r11.execute(r12)
            return
        L_0x0211:
            java.lang.String r11 = r12.getAction()
            java.lang.String r0 = "android.intent.action.MEDIA_BUTTON"
            boolean r11 = j1.l0.a(r11, r0)
            if (r11 != 0) goto L_0x021e
            goto L_0x0241
        L_0x021e:
            android.net.Uri r11 = r12.getData()
            boolean r11 = j1.l0.a(r11, r11)
            if (r11 != 0) goto L_0x0229
            goto L_0x0241
        L_0x0229:
            java.lang.String r11 = "android.intent.extra.KEY_EVENT"
            android.os.Parcelable r11 = r12.getParcelableExtra(r11)
            android.view.KeyEvent r11 = (android.view.KeyEvent) r11
            if (r11 != 0) goto L_0x0234
            goto L_0x0241
        L_0x0234:
            java.lang.Object r12 = r10.f6075b
            h3.x2 r12 = (h3.x2) r12
            android.support.v4.media.session.u r12 = r12.f7442l
            java.lang.Object r12 = r12.f429j
            android.support.v4.media.session.u r12 = (android.support.v4.media.session.u) r12
            r12.o(r11)
        L_0x0241:
            return
        L_0x0242:
            java.lang.Object r11 = r10.f6075b
            m1.s1 r11 = (m1.s1) r11
            android.os.Handler r12 = r11.f10466b
            androidx.activity.e r0 = new androidx.activity.e
            r0.<init>(r2, r11)
            r12.post(r0)
            return
        L_0x0251:
            java.lang.String r12 = "connectivity"
            java.lang.Object r12 = r11.getSystemService(r12)
            android.net.ConnectivityManager r12 = (android.net.ConnectivityManager) r12
            r0 = 5
            if (r12 != 0) goto L_0x025d
            goto L_0x029e
        L_0x025d:
            android.net.NetworkInfo r12 = r12.getActiveNetworkInfo()     // Catch:{ SecurityException -> 0x029d }
            if (r12 == 0) goto L_0x029b
            boolean r6 = r12.isConnected()
            if (r6 != 0) goto L_0x026a
            goto L_0x029b
        L_0x026a:
            int r6 = r12.getType()
            r7 = 9
            r8 = 6
            r9 = 4
            if (r6 == 0) goto L_0x0283
            if (r6 == r4) goto L_0x0295
            if (r6 == r9) goto L_0x0283
            if (r6 == r0) goto L_0x0283
            if (r6 == r8) goto L_0x0297
            if (r6 == r7) goto L_0x0281
            r1 = 8
            goto L_0x029f
        L_0x0281:
            r1 = 7
            goto L_0x029f
        L_0x0283:
            int r12 = r12.getSubtype()
            switch(r12) {
                case 1: goto L_0x029f;
                case 2: goto L_0x029f;
                case 3: goto L_0x0299;
                case 4: goto L_0x0299;
                case 5: goto L_0x0299;
                case 6: goto L_0x0299;
                case 7: goto L_0x0299;
                case 8: goto L_0x0299;
                case 9: goto L_0x0299;
                case 10: goto L_0x0299;
                case 11: goto L_0x0299;
                case 12: goto L_0x0299;
                case 13: goto L_0x0297;
                case 14: goto L_0x0299;
                case 15: goto L_0x0299;
                case 16: goto L_0x028a;
                case 17: goto L_0x0299;
                case 18: goto L_0x0295;
                case 19: goto L_0x028a;
                case 20: goto L_0x028c;
                default: goto L_0x028a;
            }
        L_0x028a:
            r1 = 6
            goto L_0x029f
        L_0x028c:
            int r12 = j1.l0.f8453a
            r1 = 29
            if (r12 < r1) goto L_0x029e
            r1 = 9
            goto L_0x029f
        L_0x0295:
            r1 = 2
            goto L_0x029f
        L_0x0297:
            r1 = 5
            goto L_0x029f
        L_0x0299:
            r1 = 4
            goto L_0x029f
        L_0x029b:
            r1 = 1
            goto L_0x029f
        L_0x029d:
        L_0x029e:
            r1 = 0
        L_0x029f:
            int r12 = j1.l0.f8453a
            java.lang.Object r2 = r10.f6075b
            r3 = 31
            if (r12 < r3) goto L_0x02ca
            if (r1 != r0) goto L_0x02ca
            j1.z r2 = (j1.z) r2
            java.lang.String r12 = "phone"
            java.lang.Object r12 = r11.getSystemService(r12)     // Catch:{ RuntimeException -> 0x02c6 }
            android.telephony.TelephonyManager r12 = (android.telephony.TelephonyManager) r12     // Catch:{ RuntimeException -> 0x02c6 }
            r12.getClass()     // Catch:{ RuntimeException -> 0x02c6 }
            j1.y r1 = new j1.y     // Catch:{ RuntimeException -> 0x02c6 }
            r1.<init>(r2)     // Catch:{ RuntimeException -> 0x02c6 }
            java.util.concurrent.Executor r11 = r11.getMainExecutor()     // Catch:{ RuntimeException -> 0x02c6 }
            r12.registerTelephonyCallback(r11, r1)     // Catch:{ RuntimeException -> 0x02c6 }
            r12.unregisterTelephonyCallback(r1)     // Catch:{ RuntimeException -> 0x02c6 }
            goto L_0x02cf
        L_0x02c6:
            j1.z.a(r0, r2)
            goto L_0x02cf
        L_0x02ca:
            j1.z r2 = (j1.z) r2
            j1.z.a(r1, r2)
        L_0x02cf:
            return
        L_0x02d0:
            java.lang.Object r11 = r10.f6075b
            g.h0 r11 = (g.h0) r11
            r11.f()
            return
        L_0x02d8:
            java.lang.Object r11 = r10.f6075b
            w9.a r11 = (w9.a) r11
            w9.a.a(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g.g0.onReceive(android.content.Context, android.content.Intent):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g0(x2 x2Var) {
        this(3, x2Var);
        this.f6074a = 3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g0(z zVar) {
        this(1, zVar);
        this.f6074a = 1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g0(s1 s1Var) {
        this(2, s1Var);
        this.f6074a = 2;
    }
}
