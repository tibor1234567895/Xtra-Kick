package h6;

import android.util.Log;
import androidx.lifecycle.o0;
import com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerViewModel;
import e6.y0;
import hb.f0;
import hb.h0;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class v extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f7691i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7692j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ChannelPagerViewModel f7693k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(int i10, ChannelPagerViewModel channelPagerViewModel, e eVar) {
        super(2, eVar);
        this.f7692j = i10;
        this.f7693k = channelPagerViewModel;
    }

    public final e create(Object obj, e eVar) {
        return new v(this.f7692j, this.f7693k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((v) create((f0) obj, (e) obj2)).invokeSuspend(la.v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z10;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f7691i;
        ChannelPagerViewModel channelPagerViewModel = this.f7693k;
        boolean z11 = true;
        if (i10 == 0) {
            h0.O1(obj);
            int i11 = this.f7692j;
            y0 y0Var = channelPagerViewModel.f3339e;
            this.f7691i = 1;
            obj = y0Var.a(i11, this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            try {
                h0.O1(obj);
            } catch (Exception e10) {
                Log.e("NOP", "error: ", e10);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((LocalFollowChannel) obj) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        o0 o0Var = channelPagerViewModel.f3343i;
        if (!z10) {
            z11 = false;
        }
        o0Var.j(new la.i(Boolean.valueOf(z11), (Object) null));
        return la.v.f9814a;
    }
}
