package h6;

import android.content.DialogInterface;
import android.content.Intent;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment;
import com.github.andreyasadchy.xtra.ui.follow.FollowMediaFragment;
import com.github.andreyasadchy.xtra.ui.follow.FollowPagerFragment;
import com.github.andreyasadchy.xtra.ui.games.GameMediaFragment;
import com.github.andreyasadchy.xtra.ui.games.GamePagerFragment;
import com.github.andreyasadchy.xtra.ui.games.GamesFragment;
import com.github.andreyasadchy.xtra.ui.login.LoginActivity;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import com.github.andreyasadchy.xtra.ui.saved.SavedMediaFragment;
import com.github.andreyasadchy.xtra.ui.saved.SavedPagerFragment;
import com.github.andreyasadchy.xtra.ui.top.TopFragment;
import xa.j;

public final /* synthetic */ class h implements DialogInterface.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7660h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MainActivity f7661i;

    public /* synthetic */ h(MainActivity mainActivity, int i10) {
        this.f7660h = i10;
        this.f7661i = mainActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        int i11 = this.f7660h;
        Class<LoginActivity> cls = LoginActivity.class;
        MainActivity mainActivity = this.f7661i;
        switch (i11) {
            case 0:
                int i12 = ChannelPagerFragment.f3334r0;
                j.f("$activity", mainActivity);
                mainActivity.startActivityForResult(new Intent(mainActivity, cls), 2);
                return;
            case 1:
                int i13 = FollowMediaFragment.f3397h0;
                j.f("$activity", mainActivity);
                mainActivity.startActivityForResult(new Intent(mainActivity, cls), 2);
                return;
            case 2:
                int i14 = FollowPagerFragment.f3399k0;
                j.f("$activity", mainActivity);
                mainActivity.startActivityForResult(new Intent(mainActivity, cls), 2);
                return;
            case 3:
                int i15 = GameMediaFragment.f3411t0;
                j.f("$activity", mainActivity);
                mainActivity.startActivityForResult(new Intent(mainActivity, cls), 2);
                return;
            case 4:
                int i16 = GamePagerFragment.f3417s0;
                j.f("$activity", mainActivity);
                mainActivity.startActivityForResult(new Intent(mainActivity, cls), 2);
                return;
            case Constants.MAX_COMPATIBILITY_VERSION:
                int i17 = GamesFragment.f3425t0;
                j.f("$activity", mainActivity);
                mainActivity.startActivityForResult(new Intent(mainActivity, cls), 2);
                return;
            case 6:
                int i18 = SavedMediaFragment.f3452h0;
                j.f("$activity", mainActivity);
                mainActivity.startActivityForResult(new Intent(mainActivity, cls), 2);
                return;
            case 7:
                int i19 = SavedPagerFragment.f3454k0;
                j.f("$activity", mainActivity);
                mainActivity.startActivityForResult(new Intent(mainActivity, cls), 2);
                return;
            default:
                int i20 = TopFragment.f3513h0;
                j.f("$activity", mainActivity);
                mainActivity.startActivityForResult(new Intent(mainActivity, cls), 2);
                return;
        }
    }
}
