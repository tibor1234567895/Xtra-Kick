package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import b0.j;
import d4.b;
import java.lang.ref.WeakReference;

class MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver extends ResultReceiver {

    /* renamed from: h  reason: collision with root package name */
    public final WeakReference f345h;

    public MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver(m mVar) {
        super((Handler) null);
        this.f345h = new WeakReference(mVar);
    }

    public final void onReceiveResult(int i10, Bundle bundle) {
        m mVar = (m) this.f345h.get();
        if (mVar != null && bundle != null) {
            synchronized (mVar.f404b) {
                mVar.f407e.v(e.A0(j.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                mVar.f407e.w(b.a(bundle));
                mVar.b();
            }
        }
    }
}
