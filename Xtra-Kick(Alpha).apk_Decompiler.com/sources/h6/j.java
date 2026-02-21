package h6;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.p1;
import com.github.andreyasadchy.xtra.model.ui.Clip;
import com.github.andreyasadchy.xtra.model.ui.Stream;
import com.github.andreyasadchy.xtra.model.ui.Video;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerViewModel;
import com.github.andreyasadchy.xtra.ui.games.GameMediaFragment;
import com.github.andreyasadchy.xtra.ui.games.GamePagerFragment;
import com.github.andreyasadchy.xtra.ui.player.clip.ClipPlayerViewModel;
import com.github.andreyasadchy.xtra.ui.player.stream.StreamPlayerViewModel;
import com.github.andreyasadchy.xtra.ui.player.video.VideoPlayerViewModel;
import hb.d1;
import hb.h0;
import l6.f;
import pa.e;
import pa.h;
import s7.g;
import u6.d;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7664h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f7665i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ f f7666j;

    public /* synthetic */ j(boolean z10, f fVar, int i10) {
        this.f7664h = i10;
        this.f7665i = z10;
        this.f7666j = fVar;
    }

    public final void onClick(View view) {
        int i10 = this.f7664h;
        boolean z10 = this.f7665i;
        f fVar = this.f7666j;
        switch (i10) {
            case 0:
                ChannelPagerFragment channelPagerFragment = (ChannelPagerFragment) fVar;
                xa.j.f("this$0", channelPagerFragment);
                if (!z10) {
                    int i11 = ChannelPagerFragment.f3334r0;
                    ChannelPagerViewModel s02 = channelPagerFragment.s0();
                    Context f02 = channelPagerFragment.f0();
                    int i12 = channelPagerFragment.r0().f7680a;
                    String str = channelPagerFragment.r0().f7681b;
                    String str2 = channelPagerFragment.r0().f7682c;
                    h0.b1(d1.f7786h, (h) null, 0, new z(i12, f02, channelPagerFragment.r0().f7683d, s02, str, str2, (e) null), 3);
                    return;
                }
                g gVar = g.f14374a;
                Context f03 = channelPagerFragment.f0();
                String str3 = channelPagerFragment.r0().f7682c;
                p1 p1Var = new p1(9, channelPagerFragment);
                gVar.getClass();
                g.b(f03, str3, p1Var);
                return;
            case 1:
                GameMediaFragment gameMediaFragment = (GameMediaFragment) fVar;
                xa.j.f("this$0", gameMediaFragment);
                int i13 = GameMediaFragment.f3411t0;
                if (!z10) {
                    String str4 = gameMediaFragment.q0().f13354b;
                    if (str4 != null) {
                        gameMediaFragment.r0().d(gameMediaFragment.f0(), gameMediaFragment.q0().f13353a, gameMediaFragment.q0().f13355c, str4, gameMediaFragment.q0().f13356d);
                        return;
                    }
                    return;
                } else if (gameMediaFragment.q0().f13354b != null) {
                    g gVar2 = g.f14374a;
                    Context f04 = gameMediaFragment.f0();
                    String str5 = gameMediaFragment.q0().f13355c;
                    p1 p1Var2 = new p1(11, gameMediaFragment);
                    gVar2.getClass();
                    g.b(f04, str5, p1Var2);
                    return;
                } else {
                    return;
                }
            case 2:
                GamePagerFragment gamePagerFragment = (GamePagerFragment) fVar;
                xa.j.f("this$0", gamePagerFragment);
                if (!z10) {
                    int i14 = GamePagerFragment.f3417s0;
                    gamePagerFragment.s0().d(gamePagerFragment.f0(), gamePagerFragment.q0().f13353a, gamePagerFragment.q0().f13355c, gamePagerFragment.q0().f13354b, gamePagerFragment.q0().f13356d);
                    return;
                }
                g gVar3 = g.f14374a;
                Context f05 = gamePagerFragment.f0();
                String str6 = gamePagerFragment.q0().f13355c;
                p1 p1Var3 = new p1(12, gamePagerFragment);
                gVar3.getClass();
                g.b(f05, str6, p1Var3);
                return;
            case 3:
                d dVar = (d) fVar;
                xa.j.f("this$0", dVar);
                if (!z10) {
                    ClipPlayerViewModel O0 = dVar.v0();
                    Context f06 = dVar.f0();
                    Clip clip = dVar.G0;
                    if (clip != null) {
                        int channelId = clip.getChannelId();
                        Clip clip2 = dVar.G0;
                        if (clip2 != null) {
                            String channelSlug = clip2.getChannelSlug();
                            Clip clip3 = dVar.G0;
                            if (clip3 != null) {
                                String channelName = clip3.getChannelName();
                                Clip clip4 = dVar.G0;
                                if (clip4 != null) {
                                    O0.f(f06, channelId, channelSlug, channelName, clip4.getChannelLogo());
                                    return;
                                } else {
                                    xa.j.l("clip");
                                    throw null;
                                }
                            } else {
                                xa.j.l("clip");
                                throw null;
                            }
                        } else {
                            xa.j.l("clip");
                            throw null;
                        }
                    } else {
                        xa.j.l("clip");
                        throw null;
                    }
                } else {
                    g gVar4 = g.f14374a;
                    Context f07 = dVar.f0();
                    Clip clip5 = dVar.G0;
                    if (clip5 != null) {
                        String channelName2 = clip5.getChannelName();
                        p1 p1Var4 = new p1(15, dVar);
                        gVar4.getClass();
                        g.b(f07, channelName2, p1Var4);
                        return;
                    }
                    xa.j.l("clip");
                    throw null;
                }
            case 4:
                w6.f fVar2 = (w6.f) fVar;
                xa.j.f("this$0", fVar2);
                if (!z10) {
                    StreamPlayerViewModel Q0 = fVar2.v0();
                    Context f08 = fVar2.f0();
                    Stream stream = fVar2.G0;
                    if (stream != null) {
                        int channelId2 = stream.getChannelId();
                        Stream stream2 = fVar2.G0;
                        if (stream2 != null) {
                            String channelSlug2 = stream2.getChannelSlug();
                            Stream stream3 = fVar2.G0;
                            if (stream3 != null) {
                                String channelName3 = stream3.getChannelName();
                                Stream stream4 = fVar2.G0;
                                if (stream4 != null) {
                                    Q0.f(f08, channelId2, channelSlug2, channelName3, stream4.getChannelLogo());
                                    return;
                                } else {
                                    xa.j.l("stream");
                                    throw null;
                                }
                            } else {
                                xa.j.l("stream");
                                throw null;
                            }
                        } else {
                            xa.j.l("stream");
                            throw null;
                        }
                    } else {
                        xa.j.l("stream");
                        throw null;
                    }
                } else {
                    g gVar5 = g.f14374a;
                    Context f09 = fVar2.f0();
                    Stream stream5 = fVar2.G0;
                    if (stream5 != null) {
                        String channelName4 = stream5.getChannelName();
                        p1 p1Var5 = new p1(16, fVar2);
                        gVar5.getClass();
                        g.b(f09, channelName4, p1Var5);
                        return;
                    }
                    xa.j.l("stream");
                    throw null;
                }
            default:
                x6.h hVar = (x6.h) fVar;
                xa.j.f("this$0", hVar);
                if (!z10) {
                    VideoPlayerViewModel O02 = hVar.v0();
                    Context f010 = hVar.f0();
                    Video video = hVar.F0;
                    if (video != null) {
                        int channelId3 = video.getChannelId();
                        Video video2 = hVar.F0;
                        if (video2 != null) {
                            String channelSlug3 = video2.getChannelSlug();
                            Video video3 = hVar.F0;
                            if (video3 != null) {
                                String channelName5 = video3.getChannelName();
                                Video video4 = hVar.F0;
                                if (video4 != null) {
                                    O02.f(f010, channelId3, channelSlug3, channelName5, video4.getChannelLogo());
                                    return;
                                } else {
                                    xa.j.l("video");
                                    throw null;
                                }
                            } else {
                                xa.j.l("video");
                                throw null;
                            }
                        } else {
                            xa.j.l("video");
                            throw null;
                        }
                    } else {
                        xa.j.l("video");
                        throw null;
                    }
                } else {
                    g gVar6 = g.f14374a;
                    Context f011 = hVar.f0();
                    Video video5 = hVar.F0;
                    if (video5 != null) {
                        String channelName6 = video5.getChannelName();
                        p1 p1Var6 = new p1(17, hVar);
                        gVar6.getClass();
                        g.b(f011, channelName6, p1Var6);
                        return;
                    }
                    xa.j.l("video");
                    throw null;
                }
        }
    }
}
