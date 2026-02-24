package h6;

import android.view.ViewGroup;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment;
import h4.j;
import x7.g;
import z5.e;

public final class k extends j {

    /* renamed from: a  reason: collision with root package name */
    public final g f7667a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7668b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ChannelPagerFragment f7669c;

    public k(ChannelPagerFragment channelPagerFragment) {
        this.f7669c = channelPagerFragment;
        e eVar = channelPagerFragment.f3335o0;
        xa.j.c(eVar);
        ViewGroup.LayoutParams layoutParams = eVar.f17618c.getLayoutParams();
        xa.j.d("null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams", layoutParams);
        g gVar = (g) layoutParams;
        this.f7667a = gVar;
        this.f7668b = gVar.f16722a;
    }

    public final void c(int i10) {
        int i11;
        if (i10 != 2) {
            i11 = this.f7668b;
        } else {
            ChannelPagerFragment channelPagerFragment = this.f7669c;
            e eVar = channelPagerFragment.f3335o0;
            xa.j.c(eVar);
            eVar.f17616a.d(false, channelPagerFragment.I(), true);
            i11 = 1;
        }
        this.f7667a.f16722a = i11;
    }
}
