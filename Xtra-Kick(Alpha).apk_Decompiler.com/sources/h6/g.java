package h6;

import android.content.DialogInterface;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment;
import com.github.andreyasadchy.xtra.ui.follow.FollowMediaFragment;
import com.github.andreyasadchy.xtra.ui.follow.FollowPagerFragment;
import com.github.andreyasadchy.xtra.ui.games.GameMediaFragment;
import com.github.andreyasadchy.xtra.ui.games.GamePagerFragment;
import com.github.andreyasadchy.xtra.ui.games.GamesFragment;
import com.github.andreyasadchy.xtra.ui.saved.SavedMediaFragment;
import com.github.andreyasadchy.xtra.ui.saved.SavedPagerFragment;
import com.github.andreyasadchy.xtra.ui.top.TopFragment;
import w6.d;
import w6.f;

public final /* synthetic */ class g implements DialogInterface.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7659h;

    public /* synthetic */ g(int i10) {
        this.f7659h = i10;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        switch (this.f7659h) {
            case 0:
                int i11 = ChannelPagerFragment.f3334r0;
                dialogInterface.dismiss();
                return;
            case 1:
                int i12 = FollowMediaFragment.f3397h0;
                dialogInterface.dismiss();
                return;
            case 2:
                int i13 = FollowPagerFragment.f3399k0;
                dialogInterface.dismiss();
                return;
            case 3:
                int i14 = GameMediaFragment.f3411t0;
                dialogInterface.dismiss();
                return;
            case 4:
                int i15 = GamePagerFragment.f3417s0;
                dialogInterface.dismiss();
                return;
            case Constants.MAX_COMPATIBILITY_VERSION:
                int i16 = GamesFragment.f3425t0;
                dialogInterface.dismiss();
                return;
            case 6:
                d dVar = f.H0;
                dialogInterface.dismiss();
                return;
            case 7:
                int i17 = SavedMediaFragment.f3452h0;
                dialogInterface.dismiss();
                return;
            case 8:
                int i18 = SavedPagerFragment.f3454k0;
                dialogInterface.dismiss();
                return;
            case 9:
                int i19 = TopFragment.f3513h0;
                dialogInterface.dismiss();
                return;
            default:
                s7.g gVar = s7.g.f14374a;
                return;
        }
    }
}
