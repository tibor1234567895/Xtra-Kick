package h6;

import android.view.View;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment;
import com.github.andreyasadchy.xtra.ui.games.GameMediaFragment;
import com.github.andreyasadchy.xtra.ui.games.GamePagerFragment;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import com.github.andreyasadchy.xtra.ui.search.SearchPagerFragment;
import com.github.andreyasadchy.xtra.ui.search.tags.TagSearchFragment;
import xa.j;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7640h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MainActivity f7641i;

    public /* synthetic */ c(MainActivity mainActivity, int i10) {
        this.f7640h = i10;
        this.f7641i = mainActivity;
    }

    public final void onClick(View view) {
        int i10 = this.f7640h;
        MainActivity mainActivity = this.f7641i;
        switch (i10) {
            case 0:
                int i11 = ChannelPagerFragment.f3334r0;
                j.f("$activity", mainActivity);
                mainActivity.H();
                return;
            case 1:
                int i12 = GameMediaFragment.f3411t0;
                j.f("$activity", mainActivity);
                mainActivity.H();
                return;
            case 2:
                int i13 = GamePagerFragment.f3417s0;
                j.f("$activity", mainActivity);
                mainActivity.H();
                return;
            case 3:
                int i14 = SearchPagerFragment.f3468s0;
                j.f("$activity", mainActivity);
                mainActivity.H();
                return;
            default:
                int i15 = TagSearchFragment.f3484t0;
                j.f("$activity", mainActivity);
                mainActivity.H();
                return;
        }
    }
}
