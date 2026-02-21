package i6;

import android.util.Log;
import com.github.andreyasadchy.xtra.ui.chat.ChatViewModel;
import e6.l;
import e6.x;
import hb.f0;
import hb.h0;
import hb.p0;
import java.util.List;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class u extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f8342i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f8343j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f8344k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(ChatViewModel chatViewModel, String str, e eVar) {
        super(2, eVar);
        this.f8343j = chatViewModel;
        this.f8344k = str;
    }

    public final e create(Object obj, e eVar) {
        return new u(this.f8343j, this.f8344k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((u) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f8342i;
        ChatViewModel chatViewModel = this.f8343j;
        if (i10 == 0) {
            h0.O1(obj);
            x xVar = chatViewModel.f3347d;
            this.f8342i = 1;
            xVar.getClass();
            obj = h0.c2(p0.f7834b, new l((e) null), this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            try {
                h0.O1(obj);
            } catch (Exception e10) {
                Log.e("ChatViewModel", "Failed to load global badges", e10);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List list = (List) obj;
        if (!list.isEmpty()) {
            ChatViewModel.A = list;
            chatViewModel.f3357n.l(list);
            chatViewModel.f().l(Boolean.TRUE);
        }
        return v.f9814a;
    }
}
