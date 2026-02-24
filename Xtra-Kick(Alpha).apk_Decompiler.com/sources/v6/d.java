package v6;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.z1;
import androidx.lifecycle.x1;
import androidx.media3.ui.AspectRatioFrameLayout;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import com.github.andreyasadchy.xtra.ui.player.offline.OfflinePlayerViewModel;
import com.github.andreyasadchy.xtra.ui.view.CustomPlayerView;
import com.github.andreyasadchy.xtra.ui.view.SlidingLayout;
import com.woxthebox.draglistview.R;
import e4.a;
import fb.w;
import h3.b0;
import h3.f4;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import la.e;
import la.i;
import t6.i0;
import xa.j;
import xa.v;

public final class d extends a {
    public static final c H0 = new c(0);
    public final x1 E0;
    public OfflineVideo F0;
    public final int G0 = 5000;

    public d() {
        e t10 = h.t(new z1(19, this), 11);
        this.E0 = h0.K(this, v.a(OfflinePlayerViewModel.class), new m(t10, 11), new n(t10, 11), new o(this, t10, 11));
    }

    public final void L0() {
        super.L0();
        b0 s02 = s0();
        if (s02 != null) {
            i[] iVarArr = new i[1];
            OfflineVideo offlineVideo = this.F0;
            if (offlineVideo != null) {
                iVarArr[0] = new i("item", offlineVideo);
                s02.T0(new f4(h0.r(iVarArr), "startOfflineVideo"), Bundle.EMPTY);
                return;
            }
            j.l("video");
            throw null;
        }
    }

    public final void N(Bundle bundle) {
        this.f9595e0 = false;
        super.N(bundle);
        Parcelable parcelable = e0().getParcelable("video");
        j.c(parcelable);
        this.F0 = (OfflineVideo) parcelable;
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        View inflate = layoutInflater.inflate(R.layout.fragment_player_offline, viewGroup, false);
        int i10 = R.id.aspectRatioFrameLayout;
        if (((AspectRatioFrameLayout) a.a(inflate, R.id.aspectRatioFrameLayout)) != null) {
            i10 = R.id.chatFragmentContainer;
            if (((FrameLayout) a.a(inflate, R.id.chatFragmentContainer)) != null) {
                i10 = R.id.playerView;
                if (((CustomPlayerView) a.a(inflate, R.id.playerView)) != null) {
                    SlidingLayout slidingLayout = (SlidingLayout) inflate;
                    j.d("null cannot be cast to non-null type android.widget.LinearLayout", slidingLayout);
                    slidingLayout.setOrientation(this.f14628o0 ? 1 : 0);
                    j.e("binding.root", slidingLayout);
                    return slidingLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public final void Q() {
        super.Q();
    }

    public final void Z(View view, Bundle bundle) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        ImageButton imageButton;
        j.f("view", view);
        super.Z(view, bundle);
        boolean z10 = false;
        if (t0().getBoolean("player_menu", true) && (imageButton = (ImageButton) h0().findViewById(R.id.playerMenu)) != null) {
            h0.b2(imageButton);
            imageButton.setOnClickListener(new b(this, 0));
        }
        if (t0().getBoolean("player_channel", true) && (textView3 = (TextView) h0().findViewById(R.id.playerChannel)) != null) {
            h0.b2(textView3);
            OfflineVideo offlineVideo = this.F0;
            if (offlineVideo != null) {
                textView3.setText(offlineVideo.getChannelName());
                textView3.setOnClickListener(new b(this, 1));
            } else {
                j.l("video");
                throw null;
            }
        }
        OfflineVideo offlineVideo2 = this.F0;
        if (offlineVideo2 != null) {
            String name = offlineVideo2.getName();
            if (!(name == null || w.h(name)) && t0().getBoolean("player_title", true) && (textView2 = (TextView) h0().findViewById(R.id.playerTitle)) != null) {
                h0.b2(textView2);
                OfflineVideo offlineVideo3 = this.F0;
                if (offlineVideo3 != null) {
                    textView2.setText(offlineVideo3.getName());
                } else {
                    j.l("video");
                    throw null;
                }
            }
            OfflineVideo offlineVideo4 = this.F0;
            if (offlineVideo4 != null) {
                String gameName = offlineVideo4.getGameName();
                if (gameName == null || w.h(gameName)) {
                    z10 = true;
                }
                if (!z10 && t0().getBoolean("player_category", true) && (textView = (TextView) h0().findViewById(R.id.playerCategory)) != null) {
                    h0.b2(textView);
                    OfflineVideo offlineVideo5 = this.F0;
                    if (offlineVideo5 != null) {
                        textView.setText(offlineVideo5.getGameName());
                        textView.setOnClickListener(new b(this, 2));
                        return;
                    }
                    j.l("video");
                    throw null;
                }
                return;
            }
            j.l("video");
            throw null;
        }
        j.l("video");
        throw null;
    }

    public final void o0() {
    }

    public final void q() {
        b0 s02;
        if (t0().getBoolean("player_use_videopositions", true) && (s02 = s0()) != null) {
            long j10 = s02.j();
            OfflinePlayerViewModel offlinePlayerViewModel = (OfflinePlayerViewModel) this.E0.getValue();
            OfflineVideo offlineVideo = this.F0;
            if (offlineVideo != null) {
                offlinePlayerViewModel.f3443n.c(offlineVideo.getId(), j10);
            } else {
                j.l("video");
                throw null;
            }
        }
        super.q();
    }

    public final int r0() {
        return this.G0;
    }

    public final i0 v0() {
        return (OfflinePlayerViewModel) this.E0.getValue();
    }
}
