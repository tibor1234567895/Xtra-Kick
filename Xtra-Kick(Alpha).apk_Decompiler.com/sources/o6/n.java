package o6;

import android.content.Context;
import com.github.andreyasadchy.xtra.model.Account;
import com.github.andreyasadchy.xtra.ui.follow.channels.FollowedChannelsViewModel;
import e6.e0;
import e6.o1;
import e6.y0;
import f6.h;
import wa.a;
import xa.k;

public final class n extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ FollowedChannelsViewModel f12269h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Context f12270i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ l f12271j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(FollowedChannelsViewModel followedChannelsViewModel, Context context, l lVar) {
        super(0);
        this.f12269h = followedChannelsViewModel;
        this.f12270i = context;
        this.f12271j = lVar;
    }

    public final Object b() {
        FollowedChannelsViewModel followedChannelsViewModel = this.f12269h;
        y0 y0Var = followedChannelsViewModel.f3403e;
        o1 o1Var = followedChannelsViewModel.f3404f;
        e0 e0Var = followedChannelsViewModel.f3405g;
        Account.Companion.get(this.f12270i).getId();
        l lVar = this.f12271j;
        return new h(y0Var, o1Var, e0Var, lVar.f12263a, lVar.f12264b);
    }
}
