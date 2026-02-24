package android.support.v4.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.e;
import android.support.v4.media.session.f;
import android.util.Log;
import b0.j;
import java.lang.ref.WeakReference;

public final class c extends MediaBrowser.ConnectionCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f317a;

    public c(d dVar) {
        this.f317a = dVar;
    }

    public final void onConnected() {
        d dVar = this.f317a;
        e eVar = dVar.f319b;
        if (eVar != null) {
            MediaBrowser mediaBrowser = eVar.f321b;
            try {
                Bundle extras = mediaBrowser.getExtras();
                if (extras != null) {
                    extras.getInt("extra_service_version", 0);
                    IBinder a10 = j.a(extras, "extra_messenger");
                    if (a10 != null) {
                        eVar.f325f = new n(a10, eVar.f322c);
                        b bVar = eVar.f323d;
                        Messenger messenger = new Messenger(bVar);
                        eVar.f326g = messenger;
                        bVar.getClass();
                        bVar.f316c = new WeakReference(messenger);
                        try {
                            n nVar = eVar.f325f;
                            Context context = eVar.f320a;
                            Messenger messenger2 = eVar.f326g;
                            nVar.getClass();
                            Bundle bundle = new Bundle();
                            bundle.putString("data_package_name", context.getPackageName());
                            bundle.putInt("data_calling_pid", Process.myPid());
                            bundle.putBundle("data_root_hints", (Bundle) nVar.f338j);
                            Message obtain = Message.obtain();
                            obtain.what = 6;
                            obtain.arg1 = 1;
                            obtain.setData(bundle);
                            obtain.replyTo = messenger2;
                            ((Messenger) nVar.f337i).send(obtain);
                        } catch (RemoteException unused) {
                            Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                        }
                    }
                    f A0 = e.A0(j.a(extras, "extra_session_binder"));
                    if (A0 != null) {
                        MediaSession.Token sessionToken = mediaBrowser.getSessionToken();
                        MediaSessionCompat$Token mediaSessionCompat$Token = null;
                        if (sessionToken != null) {
                            mediaSessionCompat$Token = new MediaSessionCompat$Token(sessionToken, A0, (d4.e) null);
                        } else {
                            Parcelable.Creator<MediaSessionCompat$Token> creator = MediaSessionCompat$Token.CREATOR;
                        }
                        eVar.f327h = mediaSessionCompat$Token;
                    }
                }
            } catch (IllegalStateException e10) {
                Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", e10);
            }
        }
        dVar.a();
    }

    public final void onConnectionFailed() {
        d dVar = this.f317a;
        e eVar = dVar.f319b;
        if (eVar != null) {
            eVar.getClass();
        }
        dVar.b();
    }

    public final void onConnectionSuspended() {
        d dVar = this.f317a;
        e eVar = dVar.f319b;
        if (eVar != null) {
            eVar.f325f = null;
            eVar.f326g = null;
            eVar.f327h = null;
            b bVar = eVar.f323d;
            bVar.getClass();
            bVar.f316c = new WeakReference((Object) null);
        }
        dVar.c();
    }
}
