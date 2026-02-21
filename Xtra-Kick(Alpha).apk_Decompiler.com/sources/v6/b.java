package v6;

import android.view.View;
import androidx.fragment.app.c1;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import g1.e1;
import h3.b0;
import h6.r;
import h6.s;
import hb.h0;
import j3.d1;
import j3.k0;
import java.util.List;
import ma.z;
import q6.a;
import q6.h;
import s7.g;
import t6.l;
import xa.j;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f15930h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ d f15931i;

    public /* synthetic */ b(d dVar, int i10) {
        this.f15930h = i10;
        this.f15931i = dVar;
    }

    public final void onClick(View view) {
        d1 d1Var;
        Float f10;
        e1 i10;
        int i11 = this.f15930h;
        d dVar = this.f15931i;
        String str = null;
        switch (i11) {
            case 0:
                c cVar = d.H0;
                j.f("this$0", dVar);
                g gVar = g.f14374a;
                c1 u10 = dVar.u();
                j.e("childFragmentManager", u10);
                l.f14620w0.getClass();
                b0 s02 = dVar.s0();
                if (s02 == null || (i10 = s02.i()) == null) {
                    f10 = null;
                } else {
                    f10 = Float.valueOf(i10.f6355h);
                }
                List list = l.f14621x0;
                j.f("<this>", list);
                Integer num = (Integer) z.v(l.f14622y0, list.indexOf(f10));
                if (num != null) {
                    str = dVar.f0().getString(num.intValue());
                }
                gVar.getClass();
                g.a(u10, str, false);
                return;
            case 1:
                c cVar2 = d.H0;
                j.f("this$0", dVar);
                k0 V = h0.V(dVar);
                r rVar = s.f7686a;
                OfflineVideo offlineVideo = dVar.F0;
                if (offlineVideo != null) {
                    int channelId = offlineVideo.getChannelId();
                    OfflineVideo offlineVideo2 = dVar.F0;
                    if (offlineVideo2 != null) {
                        String channelLogin = offlineVideo2.getChannelLogin();
                        OfflineVideo offlineVideo3 = dVar.F0;
                        if (offlineVideo3 != null) {
                            String channelName = offlineVideo3.getChannelName();
                            OfflineVideo offlineVideo4 = dVar.F0;
                            if (offlineVideo4 != null) {
                                V.m(r.a(rVar, channelId, channelLogin, channelName, offlineVideo4.getChannelLogo(), false, 0, 48));
                                dVar.u0().g();
                                return;
                            }
                            j.l("video");
                            throw null;
                        }
                        j.l("video");
                        throw null;
                    }
                    j.l("video");
                    throw null;
                }
                j.l("video");
                throw null;
            default:
                c cVar3 = d.H0;
                j.f("this$0", dVar);
                k0 V2 = h0.V(dVar);
                if (dVar.t0().getBoolean("ui_gamepager", true)) {
                    q6.g gVar2 = h.f13361a;
                    OfflineVideo offlineVideo5 = dVar.F0;
                    if (offlineVideo5 != null) {
                        int gameId = offlineVideo5.getGameId();
                        OfflineVideo offlineVideo6 = dVar.F0;
                        if (offlineVideo6 != null) {
                            String gameSlug = offlineVideo6.getGameSlug();
                            OfflineVideo offlineVideo7 = dVar.F0;
                            if (offlineVideo7 != null) {
                                String gameName = offlineVideo7.getGameName();
                                OfflineVideo offlineVideo8 = dVar.F0;
                                if (offlineVideo8 != null) {
                                    d1Var = q6.g.a(gVar2, gameId, gameSlug, gameName, offlineVideo8.getBoxArtUrl(), (String[]) null, false, 240);
                                } else {
                                    j.l("video");
                                    throw null;
                                }
                            } else {
                                j.l("video");
                                throw null;
                            }
                        } else {
                            j.l("video");
                            throw null;
                        }
                    } else {
                        j.l("video");
                        throw null;
                    }
                } else {
                    a aVar = q6.b.f13350a;
                    OfflineVideo offlineVideo9 = dVar.F0;
                    if (offlineVideo9 != null) {
                        int gameId2 = offlineVideo9.getGameId();
                        OfflineVideo offlineVideo10 = dVar.F0;
                        if (offlineVideo10 != null) {
                            String gameSlug2 = offlineVideo10.getGameSlug();
                            OfflineVideo offlineVideo11 = dVar.F0;
                            if (offlineVideo11 != null) {
                                String gameName2 = offlineVideo11.getGameName();
                                OfflineVideo offlineVideo12 = dVar.F0;
                                if (offlineVideo12 != null) {
                                    d1Var = a.a(aVar, gameId2, gameSlug2, gameName2, offlineVideo12.getBoxArtUrl(), (String[]) null, false, 240);
                                } else {
                                    j.l("video");
                                    throw null;
                                }
                            } else {
                                j.l("video");
                                throw null;
                            }
                        } else {
                            j.l("video");
                            throw null;
                        }
                    } else {
                        j.l("video");
                        throw null;
                    }
                }
                V2.m(d1Var);
                dVar.u0().g();
                return;
        }
    }
}
