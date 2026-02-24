package e6;

import a6.c0;
import a6.f;
import android.content.Context;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import fb.w;
import hb.f0;
import hb.h0;
import java.io.File;
import la.v;
import pa.e;
import r3.n0;
import ra.i;
import wa.p;

public final class g1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ OfflineVideo f5129i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ o1 f5130j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Context f5131k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g1(OfflineVideo offlineVideo, o1 o1Var, Context context, e eVar) {
        super(2, eVar);
        this.f5129i = offlineVideo;
        this.f5130j = o1Var;
        this.f5131k = context;
    }

    public final e create(Object obj, e eVar) {
        return new g1(this.f5129i, this.f5130j, this.f5131k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((g1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        boolean z10;
        h0.O1(obj);
        OfflineVideo offlineVideo = this.f5129i;
        String videoId = offlineVideo.getVideoId();
        if (videoId == null || w.h(videoId)) {
            z10 = true;
        } else {
            z10 = false;
        }
        Context context = this.f5131k;
        o1 o1Var = this.f5130j;
        if (!z10) {
            if (((f) o1Var.f5210d).b(offlineVideo.getVideoId()) == null) {
                String file = context.getFilesDir().toString();
                String str = File.separator;
                String videoId2 = offlineVideo.getVideoId();
                new File(file + str + "thumbnails" + str + videoId2 + ".png").delete();
            }
        }
        if (offlineVideo.getChannelId() != 0) {
            if (((a6.i) o1Var.f5209c).a(offlineVideo.getChannelId()) == null) {
                if (((f) o1Var.f5210d).a(offlineVideo.getChannelId()).isEmpty()) {
                    String file2 = context.getFilesDir().toString();
                    String str2 = File.separator;
                    int channelId = offlineVideo.getChannelId();
                    new File(file2 + str2 + "profile_pics" + str2 + channelId + ".png").delete();
                }
            }
        }
        c0 c0Var = (c0) o1Var.f5207a;
        n0 n0Var = c0Var.f221a;
        n0Var.b();
        n0Var.c();
        try {
            c0Var.f223c.i(offlineVideo);
            n0Var.r();
            n0Var.g();
            return v.f9814a;
        } catch (Throwable th) {
            n0Var.g();
            throw th;
        }
    }
}
