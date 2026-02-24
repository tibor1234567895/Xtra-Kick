package u6;

import android.view.View;
import androidx.fragment.app.c1;
import com.github.andreyasadchy.xtra.model.ui.Clip;
import com.github.andreyasadchy.xtra.model.ui.Video;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import g1.e1;
import h3.b0;
import h6.r;
import h6.s;
import hb.h0;
import j3.d1;
import j3.k0;
import java.util.List;
import ma.z;
import q6.b;
import q6.h;
import s7.g;
import t6.l;
import xa.f;
import xa.j;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f15365h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ d f15366i;

    public /* synthetic */ a(d dVar, int i10) {
        this.f15365h = i10;
        this.f15366i = dVar;
    }

    public final void onClick(View view) {
        d1 d1Var;
        Float f10;
        e1 i10;
        long j10;
        int i11 = this.f15365h;
        d dVar = this.f15366i;
        String str = null;
        switch (i11) {
            case 0:
                b bVar = d.I0;
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
                b bVar2 = d.I0;
                j.f("this$0", dVar);
                dVar.b();
                return;
            case 2:
                b bVar3 = d.I0;
                j.f("this$0", dVar);
                MainActivity mainActivity = (MainActivity) dVar.d0();
                Clip clip = dVar.G0;
                if (clip != null) {
                    String videoUrl = clip.getVideoUrl();
                    Clip clip2 = dVar.G0;
                    if (clip2 != null) {
                        String videoId = clip2.getVideoId();
                        Clip clip3 = dVar.G0;
                        if (clip3 != null) {
                            int channelId = clip3.getChannelId();
                            Clip clip4 = dVar.G0;
                            if (clip4 != null) {
                                String channelSlug = clip4.getChannelSlug();
                                Clip clip5 = dVar.G0;
                                if (clip5 != null) {
                                    String channelName = clip5.getChannelName();
                                    Clip clip6 = dVar.G0;
                                    if (clip6 != null) {
                                        String profileImageUrl = clip6.getProfileImageUrl();
                                        Clip clip7 = dVar.G0;
                                        if (clip7 != null) {
                                            Video video = new Video(videoId, channelId, channelSlug, channelName, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, videoUrl, 0, (String) null, (String) null, (String) null, profileImageUrl, (List) null, clip7.getVideoAnimatedPreviewURL(), 97264, (f) null);
                                            Clip clip8 = dVar.G0;
                                            if (clip8 != null) {
                                                double d10 = 0.0d;
                                                if (clip8.getVodOffset() != null) {
                                                    Clip clip9 = dVar.G0;
                                                    if (clip9 != null) {
                                                        Integer vodOffset = clip9.getVodOffset();
                                                        if (vodOffset != null) {
                                                            d10 = (double) vodOffset.intValue();
                                                        }
                                                        double d11 = d10 * 1000.0d;
                                                        b0 s03 = dVar.s0();
                                                        if (s03 != null) {
                                                            j10 = s03.j();
                                                        } else {
                                                            j10 = 0;
                                                        }
                                                        d10 = d11 + ((double) j10);
                                                    } else {
                                                        j.l("clip");
                                                        throw null;
                                                    }
                                                }
                                                mainActivity.M(video, Double.valueOf(d10));
                                                return;
                                            }
                                            j.l("clip");
                                            throw null;
                                        }
                                        j.l("clip");
                                        throw null;
                                    }
                                    j.l("clip");
                                    throw null;
                                }
                                j.l("clip");
                                throw null;
                            }
                            j.l("clip");
                            throw null;
                        }
                        j.l("clip");
                        throw null;
                    }
                    j.l("clip");
                    throw null;
                }
                j.l("clip");
                throw null;
            case 3:
                b bVar4 = d.I0;
                j.f("this$0", dVar);
                k0 V = h0.V(dVar);
                r rVar = s.f7686a;
                Clip clip10 = dVar.G0;
                if (clip10 != null) {
                    int channelId2 = clip10.getChannelId();
                    Clip clip11 = dVar.G0;
                    if (clip11 != null) {
                        String channelSlug2 = clip11.getChannelSlug();
                        Clip clip12 = dVar.G0;
                        if (clip12 != null) {
                            String channelName2 = clip12.getChannelName();
                            Clip clip13 = dVar.G0;
                            if (clip13 != null) {
                                V.m(r.a(rVar, channelId2, channelSlug2, channelName2, clip13.getChannelLogo(), false, 0, 48));
                                dVar.u0().g();
                                return;
                            }
                            j.l("clip");
                            throw null;
                        }
                        j.l("clip");
                        throw null;
                    }
                    j.l("clip");
                    throw null;
                }
                j.l("clip");
                throw null;
            default:
                b bVar5 = d.I0;
                j.f("this$0", dVar);
                k0 V2 = h0.V(dVar);
                if (dVar.t0().getBoolean("ui_gamepager", true)) {
                    q6.g gVar2 = h.f13361a;
                    Clip clip14 = dVar.G0;
                    if (clip14 != null) {
                        int gameId = clip14.getGameId();
                        Clip clip15 = dVar.G0;
                        if (clip15 != null) {
                            String gameSlug = clip15.getGameSlug();
                            Clip clip16 = dVar.G0;
                            if (clip16 != null) {
                                String gameName = clip16.getGameName();
                                Clip clip17 = dVar.G0;
                                if (clip17 != null) {
                                    d1Var = q6.g.a(gVar2, gameId, gameSlug, gameName, clip17.getBoxArtUrl(), (String[]) null, false, 240);
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
                    } else {
                        j.l("clip");
                        throw null;
                    }
                } else {
                    q6.a aVar = b.f13350a;
                    Clip clip18 = dVar.G0;
                    if (clip18 != null) {
                        int gameId2 = clip18.getGameId();
                        Clip clip19 = dVar.G0;
                        if (clip19 != null) {
                            String gameSlug2 = clip19.getGameSlug();
                            Clip clip20 = dVar.G0;
                            if (clip20 != null) {
                                String gameName2 = clip20.getGameName();
                                Clip clip21 = dVar.G0;
                                if (clip21 != null) {
                                    d1Var = q6.a.a(aVar, gameId2, gameSlug2, gameName2, clip21.getBoxArtUrl(), (String[]) null, false, 240);
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
                    } else {
                        j.l("clip");
                        throw null;
                    }
                }
                V2.m(d1Var);
                dVar.u0().g();
                return;
        }
    }
}
