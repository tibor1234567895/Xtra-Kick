package i6;

import android.util.Log;
import androidx.lifecycle.o0;
import com.github.andreyasadchy.xtra.model.KickRecentMessages;
import com.github.andreyasadchy.xtra.model.chat.ChatMessage;
import com.github.andreyasadchy.xtra.ui.chat.ChatViewModel;
import e6.r1;
import e6.z1;
import hb.f0;
import hb.h0;
import hb.p0;
import java.util.List;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import s7.l;
import wa.p;

public final class b0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f8301i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f8302j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f8303k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f8304l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b0(ChatViewModel chatViewModel, int i10, String str, e eVar) {
        super(2, eVar);
        this.f8302j = chatViewModel;
        this.f8303k = i10;
        this.f8304l = str;
    }

    public final e create(Object obj, e eVar) {
        return new b0(this.f8302j, this.f8303k, this.f8304l, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((b0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f8301i;
        List list = null;
        int i11 = this.f8303k;
        ChatViewModel chatViewModel = this.f8302j;
        if (i10 == 0) {
            h0.O1(obj);
            z1 z1Var = chatViewModel.f3348e;
            this.f8301i = 1;
            z1Var.getClass();
            obj = h0.c2(p0.f7834b, new r1(z1Var, i11, (e) null), this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            try {
                h0.O1(obj);
            } catch (Exception e10) {
                Log.e("ChatViewModel", "Failed to load recent messages for channel " + i11, e10);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List<ChatMessage> messages = ((KickRecentMessages) obj).getMessages();
        if (!messages.isEmpty()) {
            List list2 = ChatViewModel.A;
            o0 d10 = chatViewModel.d();
            List list3 = (List) chatViewModel.d().d();
            if (list3 != null) {
                list3.addAll(0, messages);
                list = list3;
            }
            d10.j(list);
            Boolean bool = Boolean.TRUE;
            ((l) chatViewModel.f3363t.getValue()).j(bool);
            chatViewModel.f().l(bool);
        }
        return v.f9814a;
    }
}
