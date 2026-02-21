package m6;

import android.content.Context;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import com.github.andreyasadchy.xtra.model.offline.Request;
import com.github.andreyasadchy.xtra.ui.download.DownloadService;
import e6.o1;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import p9.a;
import p9.b;
import va.k;
import xa.j;

public final class n extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f10653a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DownloadService f10654b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f10655c;

    public n(DownloadService downloadService, CountDownLatch countDownLatch) {
        this.f10654b = downloadService;
        this.f10655c = countDownLatch;
    }

    public final void a(b bVar) {
        j.f("download", bVar);
        DownloadService downloadService = this.f10654b;
        OfflineVideo offlineVideo = downloadService.f3389r;
        if (offlineVideo != null) {
            offlineVideo.setProgress(offlineVideo.getProgress() + 1);
            if (offlineVideo.getProgress() < offlineVideo.getMaxProgress()) {
                offlineVideo.getProgress();
                offlineVideo.getMaxProgress();
                downloadService.g(offlineVideo.getMaxProgress(), offlineVideo.getProgress());
                int i10 = this.f10653a - 1;
                this.f10653a = i10;
                if (i10 == 0) {
                    DownloadService.a(downloadService);
                    return;
                }
                return;
            }
            DownloadService.b(downloadService);
            this.f10655c.countDown();
            return;
        }
        j.l("offlineVideo");
        throw null;
    }

    public final void f(b bVar) {
        j.f("download", bVar);
        this.f10653a++;
    }

    public final void j(b bVar) {
        j.f("download", bVar);
        int i10 = this.f10653a - 1;
        this.f10653a = i10;
        if (i10 == 0) {
            DownloadService downloadService = this.f10654b;
            o1 e10 = downloadService.e();
            Context applicationContext = downloadService.getApplicationContext();
            j.e("applicationContext", applicationContext);
            OfflineVideo offlineVideo = downloadService.f3389r;
            if (offlineVideo != null) {
                e10.a(applicationContext, offlineVideo);
                boolean z10 = true;
                downloadService.f(true);
                Request request = downloadService.f3388q;
                if (request != null) {
                    File file = new File(request.getPath());
                    if (file.exists()) {
                        String[] list = file.list();
                        j.e("directory.list()", list);
                        if (list.length != 0) {
                            z10 = false;
                        }
                        if (z10) {
                            k.a(file);
                        }
                    }
                    this.f10655c.countDown();
                    return;
                }
                j.l("request");
                throw null;
            }
            j.l("offlineVideo");
            throw null;
        }
    }
}
