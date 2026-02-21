package x6;

import android.view.View;
import androidx.fragment.app.c1;
import com.github.andreyasadchy.xtra.model.ui.Video;
import g1.e1;
import h3.b0;
import h6.r;
import h6.s;
import hb.h0;
import j3.d1;
import j3.k0;
import java.util.Collection;
import java.util.List;
import ma.z;
import q6.a;
import q6.h;
import s7.g;
import t6.l;
import xa.j;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f16683h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ h f16684i;

    public /* synthetic */ b(h hVar, int i10) {
        this.f16683h = i10;
        this.f16684i = hVar;
    }

    public final void onClick(View view) {
        Float f10;
        boolean z10;
        e1 i10;
        d1 d1Var;
        int i11 = this.f16683h;
        h hVar = this.f16684i;
        String str = null;
        switch (i11) {
            case 0:
                d dVar = h.H0;
                j.f("this$0", hVar);
                g gVar = g.f14374a;
                c1 u10 = hVar.u();
                j.e("childFragmentManager", u10);
                l.f14620w0.getClass();
                b0 s02 = hVar.s0();
                if (s02 == null || (i10 = s02.i()) == null) {
                    f10 = null;
                } else {
                    f10 = Float.valueOf(i10.f6355h);
                }
                List list = l.f14621x0;
                j.f("<this>", list);
                Integer num = (Integer) z.v(l.f14622y0, list.indexOf(f10));
                if (num != null) {
                    str = hVar.f0().getString(num.intValue());
                }
                Collection collection = (Collection) hVar.v0().f3451r.d();
                if (collection == null || collection.isEmpty()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                gVar.getClass();
                g.a(u10, str, true ^ z10);
                return;
            case 1:
                d dVar2 = h.H0;
                j.f("this$0", hVar);
                hVar.b();
                return;
            case 2:
                d dVar3 = h.H0;
                j.f("this$0", hVar);
                k0 V = h0.V(hVar);
                r rVar = s.f7686a;
                Video video = hVar.F0;
                if (video != null) {
                    int channelId = video.getChannelId();
                    Video video2 = hVar.F0;
                    if (video2 != null) {
                        String channelSlug = video2.getChannelSlug();
                        Video video3 = hVar.F0;
                        if (video3 != null) {
                            String channelName = video3.getChannelName();
                            Video video4 = hVar.F0;
                            if (video4 != null) {
                                V.m(r.a(rVar, channelId, channelSlug, channelName, video4.getChannelLogo(), false, 0, 48));
                                hVar.u0().g();
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
            case 3:
                d dVar4 = h.H0;
                j.f("this$0", hVar);
                k0 V2 = h0.V(hVar);
                if (hVar.t0().getBoolean("ui_gamepager", true)) {
                    q6.g gVar2 = h.f13361a;
                    Video video5 = hVar.F0;
                    if (video5 != null) {
                        int gameId = video5.getGameId();
                        Video video6 = hVar.F0;
                        if (video6 != null) {
                            String gameSlug = video6.getGameSlug();
                            Video video7 = hVar.F0;
                            if (video7 != null) {
                                String gameName = video7.getGameName();
                                Video video8 = hVar.F0;
                                if (video8 != null) {
                                    d1Var = q6.g.a(gVar2, gameId, gameSlug, gameName, video8.getBoxArtUrl(), (String[]) null, false, 240);
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
                    Video video9 = hVar.F0;
                    if (video9 != null) {
                        int gameId2 = video9.getGameId();
                        Video video10 = hVar.F0;
                        if (video10 != null) {
                            String gameSlug2 = video10.getGameSlug();
                            Video video11 = hVar.F0;
                            if (video11 != null) {
                                String gameName2 = video11.getGameName();
                                Video video12 = hVar.F0;
                                if (video12 != null) {
                                    d1Var = a.a(aVar, gameId2, gameSlug2, gameName2, video12.getBoxArtUrl(), (String[]) null, false, 240);
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
                hVar.u0().g();
                return;
            default:
                j.f("this$0", hVar);
                hVar.P0();
                return;
        }
    }
}
