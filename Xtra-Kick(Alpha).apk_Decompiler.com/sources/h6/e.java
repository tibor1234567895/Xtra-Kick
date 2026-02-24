package h6;

import android.view.View;
import com.github.andreyasadchy.xtra.model.ui.Stream;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import xa.j;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7651h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MainActivity f7652i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Stream f7653j;

    public /* synthetic */ e(MainActivity mainActivity, Stream stream, int i10) {
        this.f7651h = i10;
        this.f7652i = mainActivity;
        this.f7653j = stream;
    }

    public final void onClick(View view) {
        int i10 = this.f7651h;
        Stream stream = this.f7653j;
        MainActivity mainActivity = this.f7652i;
        switch (i10) {
            case 0:
                int i11 = ChannelPagerFragment.f3334r0;
                j.f("$activity", mainActivity);
                mainActivity.L(stream);
                return;
            default:
                int i12 = ChannelPagerFragment.f3334r0;
                j.f("$activity", mainActivity);
                mainActivity.L(stream);
                return;
        }
    }
}
