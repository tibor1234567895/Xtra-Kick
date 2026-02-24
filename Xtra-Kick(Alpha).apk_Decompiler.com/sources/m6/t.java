package m6;

import android.app.IntentService;
import com.github.andreyasadchy.xtra.ui.download.DownloadService;
import dagger.hilt.android.internal.managers.k;
import e6.o1;
import e6.z1;
import ja.b;
import y5.f;
import y5.h;

public abstract class t extends IntentService implements b {

    /* renamed from: h  reason: collision with root package name */
    public volatile k f10663h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f10664i = new Object();

    /* renamed from: j  reason: collision with root package name */
    public boolean f10665j = false;

    public t() {
        super("DownloadService");
    }

    public final Object c() {
        if (this.f10663h == null) {
            synchronized (this.f10664i) {
                if (this.f10663h == null) {
                    this.f10663h = new k(this);
                }
            }
        }
        return this.f10663h.c();
    }

    public void onCreate() {
        if (!this.f10665j) {
            this.f10665j = true;
            DownloadService downloadService = (DownloadService) this;
            h hVar = ((f) ((q) c())).f16974a;
            downloadService.f3382k = (z1) hVar.f16996t.get();
            downloadService.f3383l = (o1) hVar.f17001y.get();
            downloadService.f3384m = (s7.f) hVar.E.get();
        }
        super.onCreate();
    }
}
