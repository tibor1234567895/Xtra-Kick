package r4;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import i4.t;
import la.v;
import w4.o;

public final class j implements h {

    /* renamed from: a  reason: collision with root package name */
    public final ConnectivityManager f13817a;

    /* renamed from: b  reason: collision with root package name */
    public final g f13818b;

    /* renamed from: c  reason: collision with root package name */
    public final i f13819c;

    public j(ConnectivityManager connectivityManager, g gVar) {
        this.f13817a = connectivityManager;
        this.f13818b = gVar;
        i iVar = new i(0, this);
        this.f13819c = iVar;
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), iVar);
    }

    public static final void b(j jVar, Network network, boolean z10) {
        v vVar;
        boolean z11;
        Network[] allNetworks = jVar.f13817a.getAllNetworks();
        int length = allNetworks.length;
        boolean z12 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            Network network2 = allNetworks[i10];
            if (xa.j.a(network2, network)) {
                z11 = z10;
            } else {
                NetworkCapabilities networkCapabilities = jVar.f13817a.getNetworkCapabilities(network2);
                if (networkCapabilities == null || !networkCapabilities.hasCapability(12)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
            }
            if (z11) {
                z12 = true;
                break;
            }
            i10++;
        }
        o oVar = (o) jVar.f13818b;
        if (((t) oVar.f16099i.get()) != null) {
            oVar.f16101k = z12;
            vVar = v.f9814a;
        } else {
            vVar = null;
        }
        if (vVar == null) {
            oVar.a();
        }
    }

    public final boolean a() {
        boolean z10;
        ConnectivityManager connectivityManager = this.f13817a;
        for (Network networkCapabilities : connectivityManager.getAllNetworks()) {
            NetworkCapabilities networkCapabilities2 = connectivityManager.getNetworkCapabilities(networkCapabilities);
            if (networkCapabilities2 == null || !networkCapabilities2.hasCapability(12)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                return true;
            }
        }
        return false;
    }

    public final void shutdown() {
        this.f13817a.unregisterNetworkCallback(this.f13819c);
    }
}
