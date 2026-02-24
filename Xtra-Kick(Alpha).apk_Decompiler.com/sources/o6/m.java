package o6;

import com.github.andreyasadchy.xtra.model.offline.SortChannel;
import com.github.andreyasadchy.xtra.model.ui.FollowOrderEnum;
import com.github.andreyasadchy.xtra.model.ui.FollowSortEnum;
import com.github.andreyasadchy.xtra.ui.follow.channels.FollowedChannelsViewModel;
import e6.c2;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import xa.f;

public final class m extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f12265i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FollowedChannelsViewModel f12266j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ FollowSortEnum f12267k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ FollowOrderEnum f12268l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(FollowedChannelsViewModel followedChannelsViewModel, FollowSortEnum followSortEnum, FollowOrderEnum followOrderEnum, e eVar) {
        super(2, eVar);
        this.f12266j = followedChannelsViewModel;
        this.f12267k = followSortEnum;
        this.f12268l = followOrderEnum;
    }

    public final e create(Object obj, e eVar) {
        return new m(this.f12266j, this.f12267k, this.f12268l, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((m) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f12265i;
        FollowedChannelsViewModel followedChannelsViewModel = this.f12266j;
        if (i10 == 0) {
            h0.O1(obj);
            c2 c2Var = followedChannelsViewModel.f3402d;
            this.f12265i = 1;
            obj = c2Var.a("followed_channels", this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else if (i10 == 2) {
            h0.O1(obj);
            return v.f9814a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SortChannel sortChannel = (SortChannel) obj;
        FollowOrderEnum followOrderEnum = this.f12268l;
        FollowSortEnum followSortEnum = this.f12267k;
        if (sortChannel != null) {
            sortChannel.setVideoSort(followSortEnum.getValue());
            sortChannel.setVideoType(followOrderEnum.getValue());
        } else {
            sortChannel = new SortChannel("followed_channels", (Boolean) null, followSortEnum.getValue(), followOrderEnum.getValue(), (String) null, 18, (f) null);
        }
        c2 c2Var2 = followedChannelsViewModel.f3402d;
        this.f12265i = 2;
        if (c2Var2.b(sortChannel, this) == aVar) {
            return aVar;
        }
        return v.f9814a;
    }
}
