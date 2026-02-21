package i3;

import android.view.View;
import com.github.andreyasadchy.xtra.model.VideoDownloadInfo;
import d9.r0;
import g1.k1;
import g1.v1;
import g1.w1;
import java.util.List;
import m6.w;
import m6.z;
import xa.j;
import z5.c;

public final /* synthetic */ class t implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8165h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f8166i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f8167j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f8168k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f8169l;

    public /* synthetic */ t(Object obj, Object obj2, Object obj3, Object obj4, int i10) {
        this.f8165h = i10;
        this.f8166i = obj;
        this.f8167j = obj2;
        this.f8168k = obj3;
        this.f8169l = obj4;
    }

    public final void onClick(View view) {
        int i10 = this.f8165h;
        Object obj = this.f8169l;
        Object obj2 = this.f8168k;
        Object obj3 = this.f8167j;
        Object obj4 = this.f8166i;
        switch (i10) {
            case 0:
                u uVar = (u) obj4;
                k1 k1Var = (k1) obj3;
                v1 v1Var = (v1) obj2;
                s sVar = (s) obj;
                uVar.getClass();
                if (k1Var.L0(29)) {
                    k1Var.r(k1Var.p0().i().h(new w1(v1Var, (List) r0.n(Integer.valueOf(sVar.f8162b)))).i(sVar.f8161a.f6778i.f6675j, false).b());
                    j jVar = (j) uVar;
                    switch (jVar.f8110c) {
                        case 0:
                            jVar.f8111d.f8196m.f8154b[1] = sVar.f8163c;
                            break;
                    }
                    uVar.f8178b.f8206r.dismiss();
                    return;
                }
                return;
            default:
                z zVar = (z) obj4;
                c cVar = (c) obj3;
                VideoDownloadInfo videoDownloadInfo = (VideoDownloadInfo) obj2;
                VideoDownloadInfo videoDownloadInfo2 = (VideoDownloadInfo) obj;
                w wVar = z.D0;
                j.f("this$0", zVar);
                j.f("$this_with", cVar);
                j.f("$this_with$1", videoDownloadInfo);
                j.f("$videoInfo", videoDownloadInfo2);
                z.u0(zVar, cVar, videoDownloadInfo, videoDownloadInfo2);
                return;
        }
    }
}
