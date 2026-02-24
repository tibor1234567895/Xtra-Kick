package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import d4.e;
import e1.c0;
import h3.y3;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a0 implements z {

    /* renamed from: a  reason: collision with root package name */
    public final MediaSession f377a;

    /* renamed from: b  reason: collision with root package name */
    public final MediaSessionCompat$Token f378b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f379c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f380d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f381e = false;

    /* renamed from: f  reason: collision with root package name */
    public final RemoteCallbackList f382f = new RemoteCallbackList();

    /* renamed from: g  reason: collision with root package name */
    public PlaybackStateCompat f383g;

    /* renamed from: h  reason: collision with root package name */
    public List f384h;

    /* renamed from: i  reason: collision with root package name */
    public MediaMetadataCompat f385i;

    /* renamed from: j  reason: collision with root package name */
    public int f386j;

    /* renamed from: k  reason: collision with root package name */
    public int f387k;

    /* renamed from: l  reason: collision with root package name */
    public int f388l;

    /* renamed from: m  reason: collision with root package name */
    public y f389m;

    /* renamed from: n  reason: collision with root package name */
    public c0 f390n;

    public a0(Context context, String str, Bundle bundle) {
        MediaSession d10 = d(context, str, bundle);
        this.f377a = d10;
        this.f378b = new MediaSessionCompat$Token(d10.getSessionToken(), new h0(this, 1), (e) null);
        this.f380d = bundle;
        g(3);
    }

    public final void a() {
        this.f381e = true;
        this.f382f.kill();
        int i10 = Build.VERSION.SDK_INT;
        MediaSession mediaSession = this.f377a;
        if (i10 == 27) {
            try {
                Field declaredField = mediaSession.getClass().getDeclaredField("mCallback");
                declaredField.setAccessible(true);
                Handler handler = (Handler) declaredField.get(mediaSession);
                if (handler != null) {
                    handler.removeCallbacksAndMessages((Object) null);
                }
            } catch (Exception e10) {
                Log.w("MediaSessionCompat", "Exception happened while accessing MediaSession.mCallback.", e10);
            }
        }
        mediaSession.setCallback((MediaSession.Callback) null);
        mediaSession.release();
    }

    public final PlaybackStateCompat b() {
        return this.f383g;
    }

    public final boolean c() {
        return this.f377a.isActive();
    }

    public MediaSession d(Context context, String str, Bundle bundle) {
        return new MediaSession(context, str);
    }

    public final String e() {
        MediaSession mediaSession = this.f377a;
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        try {
            return (String) mediaSession.getClass().getMethod("getCallingPackage", new Class[0]).invoke(mediaSession, new Object[0]);
        } catch (Exception e10) {
            Log.e("MediaSessionCompat", "Cannot execute MediaSession.getCallingPackage()", e10);
            return null;
        }
    }

    public final void f(int i10) {
        if (this.f387k != i10) {
            this.f387k = i10;
            synchronized (this.f379c) {
                int beginBroadcast = this.f382f.beginBroadcast();
                while (true) {
                    beginBroadcast--;
                    if (beginBroadcast >= 0) {
                        try {
                            ((c) this.f382f.getBroadcastItem(beginBroadcast)).a(i10);
                        } catch (RemoteException unused) {
                        }
                    } else {
                        this.f382f.finishBroadcast();
                    }
                }
            }
        }
    }

    public final void g(int i10) {
        this.f377a.setFlags(i10 | 1 | 2);
    }

    public final MediaSessionCompat$Token h() {
        return this.f378b;
    }

    public final void i(PendingIntent pendingIntent) {
        this.f377a.setSessionActivity(pendingIntent);
    }

    public final void j(PlaybackStateCompat playbackStateCompat) {
        this.f383g = playbackStateCompat;
        synchronized (this.f379c) {
            int beginBroadcast = this.f382f.beginBroadcast();
            while (true) {
                beginBroadcast--;
                if (beginBroadcast < 0) {
                    break;
                }
                try {
                    ((c) this.f382f.getBroadcastItem(beginBroadcast)).o0(playbackStateCompat);
                } catch (RemoteException unused) {
                }
            }
            this.f382f.finishBroadcast();
        }
        MediaSession mediaSession = this.f377a;
        if (playbackStateCompat.f370s == null) {
            PlaybackState.Builder d10 = p0.d();
            p0.x(d10, playbackStateCompat.f359h, playbackStateCompat.f360i, playbackStateCompat.f362k, playbackStateCompat.f366o);
            p0.u(d10, playbackStateCompat.f361j);
            p0.s(d10, playbackStateCompat.f363l);
            p0.v(d10, playbackStateCompat.f365n);
            for (PlaybackStateCompat.CustomAction customAction : playbackStateCompat.f367p) {
                PlaybackState.CustomAction customAction2 = customAction.f375l;
                if (customAction2 == null) {
                    PlaybackState.CustomAction.Builder e10 = p0.e(customAction.f371h, customAction.f372i, customAction.f373j);
                    p0.w(e10, customAction.f374k);
                    customAction2 = p0.b(e10);
                }
                p0.a(d10, customAction2);
            }
            p0.t(d10, playbackStateCompat.f368q);
            if (Build.VERSION.SDK_INT >= 22) {
                q0.b(d10, playbackStateCompat.f369r);
            }
            playbackStateCompat.f370s = p0.c(d10);
        }
        mediaSession.setPlaybackState(playbackStateCompat.f370s);
    }

    public final void k(y yVar, Handler handler) {
        synchronized (this.f379c) {
            this.f389m = yVar;
            this.f377a.setCallback(yVar == null ? null : yVar.f435b, handler);
            if (yVar != null) {
                yVar.D(this, handler);
            }
        }
    }

    public final void l(ArrayList arrayList) {
        this.f384h = arrayList;
        MediaSession mediaSession = this.f377a;
        if (arrayList == null) {
            mediaSession.setQueue((List) null);
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            MediaSessionCompat$QueueItem mediaSessionCompat$QueueItem = (MediaSessionCompat$QueueItem) it.next();
            MediaSession.QueueItem queueItem = mediaSessionCompat$QueueItem.f348j;
            if (queueItem == null) {
                queueItem = k0.a(mediaSessionCompat$QueueItem.f346h.v(), mediaSessionCompat$QueueItem.f347i);
                mediaSessionCompat$QueueItem.f348j = queueItem;
            }
            arrayList2.add(queueItem);
        }
        mediaSession.setQueue(arrayList2);
    }

    public void m(c0 c0Var) {
        synchronized (this.f379c) {
            this.f390n = c0Var;
        }
    }

    public final void n(int i10) {
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(i10);
        this.f377a.setPlaybackToLocal(builder.build());
    }

    public final void o(CharSequence charSequence) {
        this.f377a.setQueueTitle(charSequence);
    }

    public final void p() {
        this.f377a.setActive(true);
    }

    public final y q() {
        y yVar;
        synchronized (this.f379c) {
            yVar = this.f389m;
        }
        return yVar;
    }

    public final void r(MediaMetadataCompat mediaMetadataCompat) {
        this.f385i = mediaMetadataCompat;
        if (mediaMetadataCompat.f310i == null) {
            Parcel obtain = Parcel.obtain();
            mediaMetadataCompat.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            mediaMetadataCompat.f310i = (MediaMetadata) MediaMetadata.CREATOR.createFromParcel(obtain);
            obtain.recycle();
        }
        this.f377a.setMetadata(mediaMetadataCompat.f310i);
    }

    public final void s(PendingIntent pendingIntent) {
        this.f377a.setMediaButtonReceiver(pendingIntent);
    }

    public void t(int i10) {
        this.f386j = i10;
    }

    public c0 u() {
        c0 c0Var;
        synchronized (this.f379c) {
            c0Var = this.f390n;
        }
        return c0Var;
    }

    public final void v(int i10) {
        if (this.f388l != i10) {
            this.f388l = i10;
            synchronized (this.f379c) {
                int beginBroadcast = this.f382f.beginBroadcast();
                while (true) {
                    beginBroadcast--;
                    if (beginBroadcast >= 0) {
                        try {
                            ((c) this.f382f.getBroadcastItem(beginBroadcast)).I(i10);
                        } catch (RemoteException unused) {
                        }
                    } else {
                        this.f382f.finishBroadcast();
                    }
                }
            }
        }
    }

    public final void w(y3 y3Var) {
        this.f377a.setPlaybackToRemote(y3Var.a());
    }
}
