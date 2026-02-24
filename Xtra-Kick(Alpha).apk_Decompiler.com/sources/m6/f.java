package m6;

import android.app.Application;
import android.support.v4.media.h;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import com.github.andreyasadchy.xtra.model.offline.Request;
import com.github.andreyasadchy.xtra.model.ui.Clip;
import com.github.andreyasadchy.xtra.ui.download.ClipDownloadViewModel;
import e6.k1;
import e6.l1;
import e6.o1;
import fb.w;
import hb.d1;
import hb.f0;
import hb.h0;
import hb.p0;
import java.io.File;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import s7.d;
import wa.p;
import xa.j;

public final class f extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public Application f10632i;

    /* renamed from: j  reason: collision with root package name */
    public OfflineVideo f10633j;

    /* renamed from: k  reason: collision with root package name */
    public int f10634k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ClipDownloadViewModel f10635l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f10636m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ String f10637n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ String f10638o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(ClipDownloadViewModel clipDownloadViewModel, String str, String str2, String str3, e eVar) {
        super(2, eVar);
        this.f10635l = clipDownloadViewModel;
        this.f10636m = str;
        this.f10637n = str2;
        this.f10638o = str3;
    }

    public final e create(Object obj, e eVar) {
        return new f(this.f10635l, this.f10636m, this.f10637n, this.f10638o, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((f) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Application application;
        OfflineVideo offlineVideo;
        boolean z10;
        Object obj3;
        Long l10;
        Long l11;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f10634k;
        ClipDownloadViewModel clipDownloadViewModel = this.f10635l;
        if (i10 == 0) {
            h0.O1(obj);
            application = clipDownloadViewModel.f1665d;
            j.d("null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication", application);
            String str = File.separator;
            Clip clip = clipDownloadViewModel.f3379g;
            if (clip != null) {
                String uuid = clip.getUuid();
                if (uuid == null || w.h(uuid)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    Clip clip2 = clipDownloadViewModel.f3379g;
                    if (clip2 != null) {
                        StringBuilder q10 = h.q(clip2.getUuid());
                        q10.append(this.f10637n);
                        obj3 = q10.toString();
                    } else {
                        j.l("clip");
                        throw null;
                    }
                } else {
                    obj3 = new Long(System.currentTimeMillis());
                }
                String str2 = this.f10636m + str + obj3;
                Clip clip3 = clipDownloadViewModel.f3379g;
                if (clip3 != null) {
                    Double duration = clip3.getDuration();
                    if (duration != null) {
                        l10 = new Long((long) (duration.doubleValue() * 1000.0d));
                    } else {
                        l10 = null;
                    }
                    d dVar = d.f14369a;
                    Clip clip4 = clipDownloadViewModel.f3379g;
                    if (clip4 != null) {
                        String str3 = this.f10638o;
                        Double duration2 = clip4.getDuration();
                        if (duration2 != null) {
                            l11 = new Long(((long) duration2.doubleValue()) * 1000);
                        } else {
                            l11 = null;
                        }
                        dVar.getClass();
                        OfflineVideo b10 = d.b(application, clip4, str3, str2, l11, l10, (Integer) null, (Integer) null);
                        this.f10632i = application;
                        this.f10633j = b10;
                        this.f10634k = 1;
                        o1 o1Var = clipDownloadViewModel.f3377e;
                        o1Var.getClass();
                        obj2 = h0.c2(p0.f7834b, new l1(o1Var, b10, (e) null), this);
                        if (obj2 == aVar) {
                            return aVar;
                        }
                        offlineVideo = b10;
                    } else {
                        j.l("clip");
                        throw null;
                    }
                } else {
                    j.l("clip");
                    throw null;
                }
            } else {
                j.l("clip");
                throw null;
            }
        } else if (i10 == 1) {
            offlineVideo = this.f10633j;
            application = this.f10632i;
            h0.O1(obj);
            obj2 = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Request request = new Request((int) ((Number) obj2).longValue(), this.f10638o, offlineVideo.getUrl(), (String) null, (String) null, (Integer) null, (Integer) null, 120, (xa.f) null);
        o1 o1Var2 = clipDownloadViewModel.f3377e;
        o1Var2.getClass();
        h0.b1(d1.f7786h, (pa.h) null, 0, new k1(o1Var2, request, (e) null), 3);
        d.f14369a.getClass();
        d.a(application, request);
        return v.f9814a;
    }
}
