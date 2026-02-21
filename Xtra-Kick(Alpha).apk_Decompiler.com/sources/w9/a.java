package w9;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import androidx.lifecycle.p1;
import g.g0;
import hb.h0;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Iterator;
import la.q;
import la.v;
import r4.i;
import u9.e;
import xa.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final Object f16171a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final HashSet f16172b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final ConnectivityManager f16173c;

    /* renamed from: d  reason: collision with root package name */
    public final g0 f16174d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f16175e;

    /* renamed from: f  reason: collision with root package name */
    public final i f16176f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f16177g;

    /* renamed from: h  reason: collision with root package name */
    public final String f16178h = null;

    public a(Context context) {
        j.g("context", context);
        this.f16177g = context;
        ConnectivityManager connectivityManager = null;
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager2 = systemService instanceof ConnectivityManager ? systemService : connectivityManager;
        this.f16173c = connectivityManager2;
        g0 g0Var = new g0(8, this);
        this.f16174d = g0Var;
        if (connectivityManager2 != null) {
            NetworkRequest build = new NetworkRequest.Builder().addTransportType(0).addTransportType(1).addTransportType(3).build();
            i iVar = new i(2, this);
            this.f16176f = iVar;
            connectivityManager2.registerNetworkCallback(build, iVar);
            return;
        }
        try {
            context.registerReceiver(g0Var, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f16175e = true;
        } catch (Exception unused) {
        }
    }

    public static final void a(a aVar) {
        synchronized (aVar.f16171a) {
            Iterator it = aVar.f16172b.iterator();
            j.b("networkChangeListenerSet.iterator()", it);
            while (it.hasNext()) {
                e eVar = (e) it.next();
                eVar.f15446a.f15455p.d(new p1(22, eVar));
            }
            v vVar = v.f9814a;
        }
    }

    public final boolean b() {
        String str = this.f16178h;
        if (str == null) {
            return h0.Y0(this.f16177g);
        }
        boolean z10 = false;
        try {
            URLConnection openConnection = new URL(str).openConnection();
            if (openConnection != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDefaultUseCaches(false);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() != -1) {
                    z10 = true;
                }
                httpURLConnection.disconnect();
                return z10;
            }
            throw new q("null cannot be cast to non-null type java.net.HttpURLConnection");
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|(2:5|6)|7|8|(2:10|(1:12))|13|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0013 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f16171a
            monitor-enter(r0)
            java.util.HashSet r1 = r4.f16172b     // Catch:{ all -> 0x0024 }
            r1.clear()     // Catch:{ all -> 0x0024 }
            boolean r1 = r4.f16175e     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x0013
            android.content.Context r1 = r4.f16177g     // Catch:{ Exception -> 0x0013 }
            g.g0 r2 = r4.f16174d     // Catch:{ Exception -> 0x0013 }
            r1.unregisterReceiver(r2)     // Catch:{ Exception -> 0x0013 }
        L_0x0013:
            android.net.ConnectivityManager r1 = r4.f16173c     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x0020
            r4.i r2 = r4.f16176f     // Catch:{ all -> 0x0024 }
            boolean r3 = r2 instanceof android.net.ConnectivityManager.NetworkCallback     // Catch:{ all -> 0x0024 }
            if (r3 == 0) goto L_0x0020
            r1.unregisterNetworkCallback(r2)     // Catch:{ all -> 0x0024 }
        L_0x0020:
            la.v r1 = la.v.f9814a     // Catch:{ all -> 0x0024 }
            monitor-exit(r0)
            return
        L_0x0024:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: w9.a.c():void");
    }

    public final void d(e eVar) {
        j.g("networkChangeListener", eVar);
        synchronized (this.f16171a) {
            this.f16172b.remove(eVar);
        }
    }
}
