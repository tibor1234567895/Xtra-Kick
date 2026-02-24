package i6;

import android.util.Log;
import com.github.andreyasadchy.xtra.ui.chat.ChatViewModel;
import e6.k;
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

public final class z extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f8353i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f8354j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f8355k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f8356l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f8357m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(ChatViewModel chatViewModel, int i10, String str, String str2, e eVar) {
        super(2, eVar);
        this.f8354j = chatViewModel;
        this.f8355k = i10;
        this.f8356l = str;
        this.f8357m = str2;
    }

    public final e create(Object obj, e eVar) {
        return new z(this.f8354j, this.f8355k, this.f8356l, this.f8357m, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((z) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f8353i;
        ChatViewModel chatViewModel = this.f8354j;
        if (i10 == 0) {
            h0.O1(obj);
            x xVar = chatViewModel.f3347d;
            this.f8353i = 1;
            xVar.getClass();
            obj = h0.c2(p0.f7834b, new k((e) null), this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            try {
                h0.O1(obj);
            } catch (Exception e10) {
                Log.e("ChatViewModel", "Failed to load badges for channel " + this.f8355k, e10);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List list = (List) obj;
        if (!list.isEmpty()) {
            chatViewModel.f3358o.j(list);
            chatViewModel.f().l(Boolean.TRUE);
        }
        return v.f9814a;
    }
}
