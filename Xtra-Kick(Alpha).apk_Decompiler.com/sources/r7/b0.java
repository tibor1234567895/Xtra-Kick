package r7;

import com.github.andreyasadchy.xtra.model.ui.User;
import com.github.andreyasadchy.xtra.ui.view.chat.MessageClickedViewModel;
import e6.r;
import e6.x;
import hb.f0;
import hb.h0;
import hb.p0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class b0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f13839i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MessageClickedViewModel f13840j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f13841k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Integer f13842l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b0(MessageClickedViewModel messageClickedViewModel, int i10, Integer num, e eVar) {
        super(2, eVar);
        this.f13840j = messageClickedViewModel;
        this.f13841k = i10;
        this.f13842l = num;
    }

    public final e create(Object obj, e eVar) {
        return new b0(this.f13840j, this.f13841k, this.f13842l, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((b0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f13839i;
        MessageClickedViewModel messageClickedViewModel = this.f13840j;
        if (i10 == 0) {
            h0.O1(obj);
            x xVar = messageClickedViewModel.f3554d;
            new Integer(this.f13841k);
            this.f13839i = 1;
            xVar.getClass();
            obj = h0.c2(p0.f7834b, new r((e) null), this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            try {
                h0.O1(obj);
            } catch (Exception unused) {
            } catch (Throwable th) {
                messageClickedViewModel.f3556f = false;
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        messageClickedViewModel.f3555e.j((User) obj);
        messageClickedViewModel.f3556f = false;
        return v.f9814a;
    }
}
