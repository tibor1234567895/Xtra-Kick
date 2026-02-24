package h6;

import android.util.Log;
import com.github.andreyasadchy.xtra.model.ui.Stream;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerViewModel;
import e6.x;
import hb.f0;
import hb.h0;
import hb.p0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class w extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f7694i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ChannelPagerViewModel f7695j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(ChannelPagerViewModel channelPagerViewModel, e eVar) {
        super(2, eVar);
        this.f7695j = channelPagerViewModel;
    }

    public final e create(Object obj, e eVar) {
        return new w(this.f7695j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((w) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f7694i;
        ChannelPagerViewModel channelPagerViewModel = this.f7695j;
        if (i10 == 0) {
            h0.O1(obj);
            x xVar = channelPagerViewModel.f3338d;
            String str = channelPagerViewModel.f3342h.f7681b;
            this.f7694i = 1;
            xVar.getClass();
            obj = h0.c2(p0.f7834b, new e6.p(xVar, str, (e) null), this);
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
        Stream stream = (Stream) obj;
        if (stream != null) {
            channelPagerViewModel.f3345k.j(stream);
        }
        return v.f9814a;
    }
}
