package t6;

import com.github.andreyasadchy.xtra.ui.player.PlaybackService;
import dagger.hilt.android.internal.managers.k;
import e6.o1;
import e6.z1;
import h3.b3;
import ja.b;
import y5.f;
import y5.h;

public abstract class p extends b3 implements b {

    /* renamed from: p  reason: collision with root package name */
    public volatile k f14647p;

    /* renamed from: q  reason: collision with root package name */
    public final Object f14648q = new Object();

    /* renamed from: r  reason: collision with root package name */
    public boolean f14649r = false;

    public final Object c() {
        if (this.f14647p == null) {
            synchronized (this.f14648q) {
                if (this.f14647p == null) {
                    this.f14647p = new k(this);
                }
            }
        }
        return this.f14647p.c();
    }

    public void onCreate() {
        if (!this.f14649r) {
            this.f14649r = true;
            PlaybackService playbackService = (PlaybackService) this;
            h hVar = ((f) ((t) c())).f16974a;
            playbackService.f3436s = (z1) hVar.f16996t.get();
            playbackService.f3437t = (o1) hVar.f17001y.get();
        }
        super.onCreate();
    }
}
