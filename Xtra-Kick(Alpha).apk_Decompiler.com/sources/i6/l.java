package i6;

import android.util.Log;
import com.github.andreyasadchy.xtra.ui.chat.ChatViewModel;
import e6.q;
import e6.x;
import hb.f0;
import hb.h0;
import hb.p0;
import java.util.List;
import la.v;
import ma.z;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class l extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f8319i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f8320j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ m f8321k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(ChatViewModel chatViewModel, m mVar, e eVar) {
        super(2, eVar);
        this.f8320j = chatViewModel;
        this.f8321k = mVar;
    }

    public final e create(Object obj, e eVar) {
        return new l(this.f8320j, this.f8321k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((l) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f8319i;
        m mVar = this.f8321k;
        ChatViewModel chatViewModel = this.f8320j;
        if (i10 == 0) {
            h0.O1(obj);
            x xVar = chatViewModel.f3347d;
            int i11 = mVar.f8322b;
            this.f8319i = 1;
            xVar.getClass();
            obj = h0.c2(p0.f7834b, new q((e) null), this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            try {
                h0.O1(obj);
            } catch (Exception e10) {
                Log.e("ChatViewModel", "Failed to load user emotes", e10);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List list = (List) obj;
        if (!list.isEmpty()) {
            List F = z.F(list, new j());
            mVar.g(F);
            chatViewModel.f3353j.j(z.F(F, new k(mVar)));
        }
        return v.f9814a;
    }
}
