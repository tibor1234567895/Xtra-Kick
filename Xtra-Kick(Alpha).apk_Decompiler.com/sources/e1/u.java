package e1;

import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.f;
import android.util.Log;
import b0.j;
import com.google.gson.internal.bind.l;
import java.util.ArrayList;
import java.util.Iterator;
import q.d;
import q.h;

public final class u implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4939h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MediaSessionCompat$Token f4940i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ k f4941j;

    public /* synthetic */ u(n nVar, MediaSessionCompat$Token mediaSessionCompat$Token, int i10) {
        this.f4939h = i10;
        this.f4941j = nVar;
        this.f4940i = mediaSessionCompat$Token;
    }

    public final void run() {
        int i10 = this.f4939h;
        MediaSessionCompat$Token mediaSessionCompat$Token = this.f4940i;
        k kVar = this.f4941j;
        switch (i10) {
            case 0:
                Iterator it = ((d) ((a0) ((h) kVar).f4908b).f4890k.values()).iterator();
                while (true) {
                    h hVar = (h) it;
                    if (hVar.hasNext()) {
                        j jVar = (j) hVar.next();
                        try {
                            l lVar = jVar.f4920e;
                            h hVar2 = jVar.f4922g;
                            lVar.d((String) hVar2.f4907a, mediaSessionCompat$Token, (Bundle) hVar2.f4908b);
                        } catch (RemoteException unused) {
                            Log.w("MBServiceCompat", "Connection for " + jVar.f4916a + " is no longer valid.");
                            hVar.remove();
                        }
                    } else {
                        return;
                    }
                }
            default:
                n nVar = (n) kVar;
                ArrayList arrayList = nVar.f4929a;
                if (!arrayList.isEmpty()) {
                    f u10 = mediaSessionCompat$Token.u();
                    if (u10 != null) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            j.b((Bundle) it2.next(), "extra_session_binder", u10.asBinder());
                        }
                    }
                    arrayList.clear();
                }
                nVar.f4930b.setSessionToken((MediaSession.Token) mediaSessionCompat$Token.f351i);
                return;
        }
    }
}
