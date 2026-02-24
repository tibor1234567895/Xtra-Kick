package h3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.j;
import android.support.v4.media.session.k;
import android.support.v4.media.session.m;
import android.util.Log;
import androidx.fragment.app.g;
import j1.a;
import j1.o;
import java.util.List;

public final class i1 extends j {

    /* renamed from: d  reason: collision with root package name */
    public final Handler f7100d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l1 f7101e;

    public i1(l1 l1Var, Looper looper) {
        this.f7101e = l1Var;
        this.f7100d = new Handler(looper, new o(2, this));
    }

    public final void a(android.support.v4.media.session.o oVar) {
        l1 l1Var = this.f7101e;
        k1 k1Var = l1Var.f7182l;
        l1Var.f7182l = new k1(oVar, k1Var.f7153b, k1Var.f7154c, k1Var.f7155d, k1Var.f7156e, k1Var.f7157f, k1Var.f7158g);
        o();
    }

    public final void b(boolean z10) {
        boolean z11;
        l1 l1Var = this.f7101e;
        b0 b0Var = l1Var.f7172b;
        b0Var.getClass();
        if (Looper.myLooper() == b0Var.N0()) {
            z11 = true;
        } else {
            z11 = false;
        }
        a.e(z11);
        Bundle bundle = new Bundle();
        bundle.putBoolean("androidx.media3.session.ARGUMENT_CAPTIONING_ENABLED", z10);
        b0Var.f6925d.d(l1Var.f7172b, new f4(Bundle.EMPTY, "androidx.media3.session.SESSION_COMMAND_ON_CAPTIONING_ENABLED_CHANGED"), bundle);
    }

    public final void c(Bundle bundle) {
        this.f7101e.f7172b.R0(new g(this, 23, bundle));
    }

    public final void d(MediaMetadataCompat mediaMetadataCompat) {
        l1 l1Var = this.f7101e;
        k1 k1Var = l1Var.f7182l;
        l1Var.f7182l = new k1(k1Var.f7152a, k1Var.f7153b, mediaMetadataCompat, k1Var.f7155d, k1Var.f7156e, k1Var.f7157f, k1Var.f7158g);
        o();
    }

    public final void e(PlaybackStateCompat playbackStateCompat) {
        l1 l1Var = this.f7101e;
        k1 k1Var = l1Var.f7182l;
        l1Var.f7182l = new k1(k1Var.f7152a, l1.O0(playbackStateCompat), k1Var.f7154c, k1Var.f7155d, k1Var.f7156e, k1Var.f7157f, k1Var.f7158g);
        o();
    }

    public final void f(List list) {
        l1 l1Var = this.f7101e;
        k1 k1Var = l1Var.f7182l;
        l1Var.f7182l = new k1(k1Var.f7152a, k1Var.f7153b, k1Var.f7154c, l1.N0(list), k1Var.f7156e, k1Var.f7157f, k1Var.f7158g);
        o();
    }

    public final void g(CharSequence charSequence) {
        l1 l1Var = this.f7101e;
        k1 k1Var = l1Var.f7182l;
        l1Var.f7182l = new k1(k1Var.f7152a, k1Var.f7153b, k1Var.f7154c, k1Var.f7155d, charSequence, k1Var.f7157f, k1Var.f7158g);
        o();
    }

    public final void h(int i10) {
        l1 l1Var = this.f7101e;
        k1 k1Var = l1Var.f7182l;
        l1Var.f7182l = new k1(k1Var.f7152a, k1Var.f7153b, k1Var.f7154c, k1Var.f7155d, k1Var.f7156e, i10, k1Var.f7158g);
        o();
    }

    public final void i() {
        this.f7101e.f7172b.a();
    }

    public final void j(String str, Bundle bundle) {
        boolean z10;
        l1 l1Var = this.f7101e;
        b0 b0Var = l1Var.f7172b;
        b0Var.getClass();
        if (Looper.myLooper() == b0Var.N0()) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.e(z10);
        b0Var.f6925d.d(l1Var.f7172b, new f4(Bundle.EMPTY, str), bundle);
    }

    public final void k() {
        boolean z10;
        l1 l1Var = this.f7101e;
        if (!l1Var.f7180j) {
            l1Var.V0();
            return;
        }
        k1 k1Var = l1Var.f7182l;
        l1Var.f7182l = new k1(k1Var.f7152a, l1.O0(l1Var.f7177g.w()), k1Var.f7154c, k1Var.f7155d, k1Var.f7156e, l1Var.f7177g.x(), l1Var.f7177g.z());
        MediaSessionCompat$Token mediaSessionCompat$Token = ((m) ((k) l1Var.f7177g.f428i)).f407e;
        if (mediaSessionCompat$Token.u() != null) {
            try {
                z10 = mediaSessionCompat$Token.u().G();
            } catch (RemoteException e10) {
                Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", e10);
            }
            b(z10);
            this.f7100d.removeMessages(1);
            l1Var.R0(false, l1Var.f7182l);
        }
        z10 = false;
        b(z10);
        this.f7100d.removeMessages(1);
        l1Var.R0(false, l1Var.f7182l);
    }

    public final void l(int i10) {
        l1 l1Var = this.f7101e;
        k1 k1Var = l1Var.f7182l;
        l1Var.f7182l = new k1(k1Var.f7152a, k1Var.f7153b, k1Var.f7154c, k1Var.f7155d, k1Var.f7156e, k1Var.f7157f, i10);
        o();
    }

    public final void o() {
        Handler handler = this.f7100d;
        if (!handler.hasMessages(1)) {
            handler.sendEmptyMessageDelayed(1, 500);
        }
    }
}
