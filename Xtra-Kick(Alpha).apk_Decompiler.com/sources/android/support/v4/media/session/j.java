package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import java.util.List;

public abstract class j implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    public final g f400a = new g(this);

    /* renamed from: b  reason: collision with root package name */
    public h f401b;

    /* renamed from: c  reason: collision with root package name */
    public l f402c;

    public void a(o oVar) {
    }

    public void b(boolean z10) {
    }

    public final void binderDied() {
        m(8, (Object) null, (Bundle) null);
    }

    public void c(Bundle bundle) {
    }

    public void d(MediaMetadataCompat mediaMetadataCompat) {
    }

    public void e(PlaybackStateCompat playbackStateCompat) {
    }

    public void f(List list) {
    }

    public void g(CharSequence charSequence) {
    }

    public void h(int i10) {
    }

    public void i() {
    }

    public void j(String str, Bundle bundle) {
    }

    public void k() {
    }

    public void l(int i10) {
    }

    public final void m(int i10, Object obj, Bundle bundle) {
        h hVar = this.f401b;
        if (hVar != null) {
            Message obtainMessage = hVar.obtainMessage(i10, obj);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    public final void n(Handler handler) {
        if (handler == null) {
            h hVar = this.f401b;
            if (hVar != null) {
                hVar.f395a = false;
                hVar.removeCallbacksAndMessages((Object) null);
                this.f401b = null;
                return;
            }
            return;
        }
        h hVar2 = new h(this, handler.getLooper());
        this.f401b = hVar2;
        hVar2.f395a = true;
    }
}
