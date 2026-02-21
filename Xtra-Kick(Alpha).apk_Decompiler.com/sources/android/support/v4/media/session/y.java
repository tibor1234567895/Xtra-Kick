package android.support.v4.media.session;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.RatingCompat;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import e1.c0;
import java.lang.ref.WeakReference;

public abstract class y {

    /* renamed from: a  reason: collision with root package name */
    public final Object f434a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final x f435b = new x(this);

    /* renamed from: c  reason: collision with root package name */
    public boolean f436c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference f437d = new WeakReference((Object) null);

    /* renamed from: e  reason: collision with root package name */
    public w f438e;

    public void A() {
    }

    public void B(long j10) {
    }

    public void C() {
    }

    public final void D(z zVar, Handler handler) {
        synchronized (this.f434a) {
            this.f437d = new WeakReference(zVar);
            w wVar = this.f438e;
            w wVar2 = null;
            if (wVar != null) {
                wVar.removeCallbacksAndMessages((Object) null);
            }
            if (zVar != null) {
                if (handler != null) {
                    wVar2 = new w(this, handler.getLooper(), 0);
                }
            }
            this.f438e = wVar2;
        }
    }

    public final void a(z zVar, w wVar) {
        if (this.f436c) {
            boolean z10 = false;
            this.f436c = false;
            wVar.removeMessages(1);
            PlaybackStateCompat b10 = zVar.b();
            long j10 = b10 == null ? 0 : b10.f363l;
            boolean z11 = b10 != null && b10.f359h == 3;
            boolean z12 = (516 & j10) != 0;
            if ((j10 & 514) != 0) {
                z10 = true;
            }
            if (z11 && z10) {
                h();
            } else if (!z11 && z12) {
                i();
            }
        }
    }

    public void b(MediaDescriptionCompat mediaDescriptionCompat) {
    }

    public void c(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
    }

    public void d(String str, Bundle bundle, ResultReceiver resultReceiver) {
    }

    public void e(String str, Bundle bundle) {
    }

    public void f() {
    }

    public boolean g(Intent intent) {
        z zVar;
        w wVar;
        KeyEvent keyEvent;
        long j10;
        if (Build.VERSION.SDK_INT >= 27) {
            return false;
        }
        synchronized (this.f434a) {
            zVar = (z) this.f437d.get();
            wVar = this.f438e;
        }
        if (zVar == null || wVar == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
            return false;
        }
        c0 u10 = zVar.u();
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 85) {
            if (keyEvent.getRepeatCount() != 0) {
                a(zVar, wVar);
            } else if (this.f436c) {
                wVar.removeMessages(1);
                this.f436c = false;
                PlaybackStateCompat b10 = zVar.b();
                if (b10 == null) {
                    j10 = 0;
                } else {
                    j10 = b10.f363l;
                }
                if ((j10 & 32) != 0) {
                    z();
                }
            } else {
                this.f436c = true;
                wVar.sendMessageDelayed(wVar.obtainMessage(1, u10), (long) ViewConfiguration.getDoubleTapTimeout());
            }
            return true;
        }
        a(zVar, wVar);
        return false;
    }

    public void h() {
    }

    public void i() {
    }

    public void j(String str, Bundle bundle) {
    }

    public void k(String str, Bundle bundle) {
    }

    public void l(Uri uri, Bundle bundle) {
    }

    public void m() {
    }

    public void n(String str, Bundle bundle) {
    }

    public void o(String str, Bundle bundle) {
    }

    public void p(Uri uri, Bundle bundle) {
    }

    public void q(MediaDescriptionCompat mediaDescriptionCompat) {
    }

    public void r() {
    }

    public void s(long j10) {
    }

    public void t() {
    }

    public void u(float f10) {
    }

    public void v(RatingCompat ratingCompat) {
    }

    public void w(RatingCompat ratingCompat) {
    }

    public void x(int i10) {
    }

    public void y(int i10) {
    }

    public void z() {
    }
}
