package h6;

import android.content.Context;
import android.util.Log;
import com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerViewModel;
import e6.t0;
import e6.y0;
import hb.d1;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import pa.h;
import qa.a;
import ra.i;
import wa.p;
import xa.j;

public final class u extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f7687i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7688j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ChannelPagerViewModel f7689k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Context f7690l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(int i10, ChannelPagerViewModel channelPagerViewModel, Context context, e eVar) {
        super(2, eVar);
        this.f7688j = i10;
        this.f7689k = channelPagerViewModel;
        this.f7690l = context;
    }

    public final e create(Object obj, e eVar) {
        return new u(this.f7688j, this.f7689k, this.f7690l, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((u) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f7687i;
        ChannelPagerViewModel channelPagerViewModel = this.f7689k;
        if (i10 == 0) {
            h0.O1(obj);
            int i11 = this.f7688j;
            if (i11 != 0) {
                y0 y0Var = channelPagerViewModel.f3339e;
                this.f7687i = 1;
                obj = y0Var.a(i11, this);
                if (obj == aVar) {
                    return aVar;
                }
            }
            return v.f9814a;
        } else if (i10 == 1) {
            try {
                h0.O1(obj);
            } catch (Exception e10) {
                Log.e("NOP", "error: ", e10);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LocalFollowChannel localFollowChannel = (LocalFollowChannel) obj;
        if (localFollowChannel != null) {
            Context context = this.f7690l;
            y0 y0Var2 = channelPagerViewModel.f3339e;
            y0Var2.getClass();
            j.f("context", context);
            h0.b1(d1.f7786h, (h) null, 0, new t0(localFollowChannel, y0Var2, context, (e) null), 3);
        }
        channelPagerViewModel.f3343i.j(new la.i(Boolean.FALSE, (Object) null));
        return v.f9814a;
    }
}
