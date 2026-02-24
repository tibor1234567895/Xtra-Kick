package android.support.v4.media.session;

import android.content.Intent;
import android.media.Rating;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.ParcelImpl;
import b0.j;
import d4.e;
import e1.c0;

public final class x extends MediaSession.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y f433a;

    public x(y yVar) {
        this.f433a = yVar;
    }

    public static void b(a0 a0Var) {
        if (Build.VERSION.SDK_INT < 28) {
            String e10 = a0Var.e();
            if (TextUtils.isEmpty(e10)) {
                e10 = "android.media.session.MediaController";
            }
            a0Var.m(new c0(e10, -1, -1));
        }
    }

    public final a0 a() {
        a0 a0Var;
        synchronized (this.f433a.f434a) {
            a0Var = (a0) this.f433a.f437d.get();
        }
        if (a0Var == null || this.f433a != a0Var.q()) {
            return null;
        }
        return a0Var;
    }

    public final void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        MediaSessionCompat$QueueItem mediaSessionCompat$QueueItem;
        IBinder iBinder;
        e eVar;
        a0 a10 = a();
        if (a10 != null) {
            u.p(bundle);
            b(a10);
            try {
                if (str.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                    Bundle bundle2 = new Bundle();
                    MediaSessionCompat$Token mediaSessionCompat$Token = a10.f378b;
                    f u10 = mediaSessionCompat$Token.u();
                    if (u10 == null) {
                        iBinder = null;
                    } else {
                        iBinder = u10.asBinder();
                    }
                    j.b(bundle2, "android.support.v4.media.session.EXTRA_BINDER", iBinder);
                    synchronized (mediaSessionCompat$Token.f350h) {
                        eVar = mediaSessionCompat$Token.f353k;
                    }
                    if (eVar != null) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putParcelable("a", new ParcelImpl(eVar));
                        bundle2.putParcelable("android.support.v4.media.session.SESSION_TOKEN2", bundle3);
                    }
                    resultReceiver.send(0, bundle2);
                } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                    this.f433a.b((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                    this.f433a.c((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
                } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                    this.f433a.q((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                } else if (!str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                    this.f433a.d(str, bundle, resultReceiver);
                } else if (a10.f384h != null) {
                    int i10 = bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                    if (i10 < 0 || i10 >= a10.f384h.size()) {
                        mediaSessionCompat$QueueItem = null;
                    } else {
                        mediaSessionCompat$QueueItem = (MediaSessionCompat$QueueItem) a10.f384h.get(i10);
                    }
                    if (mediaSessionCompat$QueueItem != null) {
                        this.f433a.q(mediaSessionCompat$QueueItem.f346h);
                    }
                }
            } catch (BadParcelableException unused) {
                Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
            }
            a10.m((c0) null);
        }
    }

    public final void onCustomAction(String str, Bundle bundle) {
        a0 a10 = a();
        if (a10 != null) {
            u.p(bundle);
            b(a10);
            try {
                boolean equals = str.equals("android.support.v4.media.session.action.PLAY_FROM_URI");
                y yVar = this.f433a;
                if (equals) {
                    Bundle bundle2 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                    u.p(bundle2);
                    yVar.l((Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), bundle2);
                } else if (str.equals("android.support.v4.media.session.action.PREPARE")) {
                    yVar.m();
                } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                    String string = bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
                    Bundle bundle3 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                    u.p(bundle3);
                    yVar.n(string, bundle3);
                } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                    String string2 = bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
                    Bundle bundle4 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                    u.p(bundle4);
                    yVar.o(string2, bundle4);
                } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                    Bundle bundle5 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                    u.p(bundle5);
                    yVar.p((Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), bundle5);
                } else if (str.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                    bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED");
                    yVar.t();
                } else if (str.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                    yVar.x(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE"));
                } else if (str.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                    yVar.y(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE"));
                } else if (str.equals("android.support.v4.media.session.action.SET_RATING")) {
                    u.p(bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                    yVar.w((RatingCompat) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING"));
                } else if (str.equals("android.support.v4.media.session.action.SET_PLAYBACK_SPEED")) {
                    yVar.u(bundle.getFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", 1.0f));
                } else {
                    yVar.e(str, bundle);
                }
            } catch (BadParcelableException unused) {
                Log.e("MediaSessionCompat", "Could not unparcel the data.");
            }
            a10.m((c0) null);
        }
    }

    public final void onFastForward() {
        a0 a10 = a();
        if (a10 != null) {
            b(a10);
            this.f433a.f();
            a10.m((c0) null);
        }
    }

    public final boolean onMediaButtonEvent(Intent intent) {
        a0 a10 = a();
        if (a10 == null) {
            return false;
        }
        b(a10);
        boolean g10 = this.f433a.g(intent);
        a10.m((c0) null);
        if (g10 || super.onMediaButtonEvent(intent)) {
            return true;
        }
        return false;
    }

    public final void onPause() {
        a0 a10 = a();
        if (a10 != null) {
            b(a10);
            this.f433a.h();
            a10.m((c0) null);
        }
    }

    public final void onPlay() {
        a0 a10 = a();
        if (a10 != null) {
            b(a10);
            this.f433a.i();
            a10.m((c0) null);
        }
    }

    public final void onPlayFromMediaId(String str, Bundle bundle) {
        a0 a10 = a();
        if (a10 != null) {
            u.p(bundle);
            b(a10);
            this.f433a.j(str, bundle);
            a10.m((c0) null);
        }
    }

    public final void onPlayFromSearch(String str, Bundle bundle) {
        a0 a10 = a();
        if (a10 != null) {
            u.p(bundle);
            b(a10);
            this.f433a.k(str, bundle);
            a10.m((c0) null);
        }
    }

    public final void onPlayFromUri(Uri uri, Bundle bundle) {
        a0 a10 = a();
        if (a10 != null) {
            u.p(bundle);
            b(a10);
            this.f433a.l(uri, bundle);
            a10.m((c0) null);
        }
    }

    public final void onPrepare() {
        a0 a10 = a();
        if (a10 != null) {
            b(a10);
            this.f433a.m();
            a10.m((c0) null);
        }
    }

    public final void onPrepareFromMediaId(String str, Bundle bundle) {
        a0 a10 = a();
        if (a10 != null) {
            u.p(bundle);
            b(a10);
            this.f433a.n(str, bundle);
            a10.m((c0) null);
        }
    }

    public final void onPrepareFromSearch(String str, Bundle bundle) {
        a0 a10 = a();
        if (a10 != null) {
            u.p(bundle);
            b(a10);
            this.f433a.o(str, bundle);
            a10.m((c0) null);
        }
    }

    public final void onPrepareFromUri(Uri uri, Bundle bundle) {
        a0 a10 = a();
        if (a10 != null) {
            u.p(bundle);
            b(a10);
            this.f433a.p(uri, bundle);
            a10.m((c0) null);
        }
    }

    public final void onRewind() {
        a0 a10 = a();
        if (a10 != null) {
            b(a10);
            this.f433a.r();
            a10.m((c0) null);
        }
    }

    public final void onSeekTo(long j10) {
        a0 a10 = a();
        if (a10 != null) {
            b(a10);
            this.f433a.s(j10);
            a10.m((c0) null);
        }
    }

    public final void onSetPlaybackSpeed(float f10) {
        a0 a10 = a();
        if (a10 != null) {
            b(a10);
            this.f433a.u(f10);
            a10.m((c0) null);
        }
    }

    public final void onSetRating(Rating rating) {
        a0 a10 = a();
        if (a10 != null) {
            b(a10);
            this.f433a.v(RatingCompat.u(rating));
            a10.m((c0) null);
        }
    }

    public final void onSkipToNext() {
        a0 a10 = a();
        if (a10 != null) {
            b(a10);
            this.f433a.z();
            a10.m((c0) null);
        }
    }

    public final void onSkipToPrevious() {
        a0 a10 = a();
        if (a10 != null) {
            b(a10);
            this.f433a.A();
            a10.m((c0) null);
        }
    }

    public final void onSkipToQueueItem(long j10) {
        a0 a10 = a();
        if (a10 != null) {
            b(a10);
            this.f433a.B(j10);
            a10.m((c0) null);
        }
    }

    public final void onStop() {
        a0 a10 = a();
        if (a10 != null) {
            b(a10);
            this.f433a.C();
            a10.m((c0) null);
        }
    }
}
