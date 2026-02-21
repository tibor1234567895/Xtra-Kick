package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class m implements k {

    /* renamed from: a  reason: collision with root package name */
    public final MediaController f403a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f404b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f405c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final HashMap f406d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final MediaSessionCompat$Token f407e;

    public m(Context context, MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.f407e = mediaSessionCompat$Token;
        MediaController mediaController = new MediaController(context, (MediaSession.Token) mediaSessionCompat$Token.f351i);
        this.f403a = mediaController;
        if (mediaSessionCompat$Token.u() == null) {
            mediaController.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", (Bundle) null, new MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver(this));
        }
    }

    public final boolean a() {
        return this.f407e.u() != null;
    }

    public final void b() {
        MediaSessionCompat$Token mediaSessionCompat$Token = this.f407e;
        if (mediaSessionCompat$Token.u() != null) {
            ArrayList arrayList = this.f405c;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                l lVar = new l(jVar);
                this.f406d.put(jVar, lVar);
                jVar.f402c = lVar;
                try {
                    mediaSessionCompat$Token.u().m(lVar);
                    jVar.m(13, (Object) null, (Bundle) null);
                } catch (RemoteException e10) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e10);
                }
            }
            arrayList.clear();
        }
    }

    public final void c(j jVar) {
        this.f403a.unregisterCallback(jVar.f400a);
        synchronized (this.f404b) {
            if (this.f407e.u() != null) {
                try {
                    l lVar = (l) this.f406d.remove(jVar);
                    if (lVar != null) {
                        jVar.f402c = null;
                        this.f407e.u().T(lVar);
                    }
                } catch (RemoteException e10) {
                    Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", e10);
                }
            } else {
                this.f405c.remove(jVar);
            }
        }
    }
}
