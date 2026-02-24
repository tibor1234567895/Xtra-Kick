package r4;

import android.net.ConnectivityManager;
import android.net.Network;
import com.bumptech.glide.manager.y;
import w5.p;
import w9.a;
import xa.j;

public final class i extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f13815a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f13816b;

    public /* synthetic */ i(int i10, Object obj) {
        this.f13815a = i10;
        this.f13816b = obj;
    }

    public final void onAvailable(Network network) {
        int i10 = this.f13815a;
        Object obj = this.f13816b;
        switch (i10) {
            case 0:
                j.b((j) obj, network, true);
                return;
            case 1:
                p.e().post(new y(0, this, true));
                return;
            default:
                j.g("network", network);
                a.a((a) obj);
                return;
        }
    }

    public final void onLost(Network network) {
        int i10 = this.f13815a;
        Object obj = this.f13816b;
        switch (i10) {
            case 0:
                j.b((j) obj, network, false);
                return;
            case 1:
                p.e().post(new y(0, this, false));
                return;
            default:
                j.g("network", network);
                a.a((a) obj);
                return;
        }
    }
}
