package android.support.v4.media.session;

import android.os.Bundle;
import java.lang.ref.WeakReference;

public abstract class i extends b {

    /* renamed from: d  reason: collision with root package name */
    public final WeakReference f399d;

    public i(j jVar) {
        this.f399d = new WeakReference(jVar);
    }

    public final void I(int i10) {
        j jVar = (j) this.f399d.get();
        if (jVar != null) {
            jVar.m(12, Integer.valueOf(i10), (Bundle) null);
        }
    }

    public final void a(int i10) {
        j jVar = (j) this.f399d.get();
        if (jVar != null) {
            jVar.m(9, Integer.valueOf(i10), (Bundle) null);
        }
    }

    public final void o0(PlaybackStateCompat playbackStateCompat) {
        j jVar = (j) this.f399d.get();
        if (jVar != null) {
            jVar.m(2, playbackStateCompat, (Bundle) null);
        }
    }
}
