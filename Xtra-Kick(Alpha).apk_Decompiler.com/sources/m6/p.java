package m6;

import android.content.Context;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import com.github.andreyasadchy.xtra.ui.download.DownloadService;
import e6.o1;
import java.util.concurrent.CountDownLatch;
import p9.a;
import p9.b;
import q9.e;
import xa.j;

public final class p extends a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DownloadService f10657a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f10658b;

    public p(DownloadService downloadService, CountDownLatch countDownLatch) {
        this.f10657a = downloadService;
        this.f10658b = countDownLatch;
    }

    public final void a(b bVar) {
        j.f("download", bVar);
        DownloadService.b(this.f10657a);
        this.f10658b.countDown();
    }

    public final void d(b bVar, long j10, long j11) {
        j.f("download", bVar);
        DownloadService downloadService = this.f10657a;
        OfflineVideo offlineVideo = downloadService.f3389r;
        if (offlineVideo != null) {
            e eVar = (e) bVar;
            offlineVideo.setProgress(eVar.y());
            downloadService.g(100, eVar.y());
            return;
        }
        j.l("offlineVideo");
        throw null;
    }

    public final void j(b bVar) {
        j.f("download", bVar);
        DownloadService downloadService = this.f10657a;
        o1 e10 = downloadService.e();
        Context applicationContext = downloadService.getApplicationContext();
        j.e("applicationContext", applicationContext);
        OfflineVideo offlineVideo = downloadService.f3389r;
        if (offlineVideo != null) {
            e10.a(applicationContext, offlineVideo);
            downloadService.f(true);
            this.f10658b.countDown();
            return;
        }
        j.l("offlineVideo");
        throw null;
    }
}
