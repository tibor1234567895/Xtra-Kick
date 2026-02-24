package i6;

import com.github.andreyasadchy.xtra.model.chat.ChatMessage;
import com.github.andreyasadchy.xtra.model.chat.Chatter;
import com.github.andreyasadchy.xtra.ui.view.chat.ChatView;
import java.util.List;
import k5.a;
import la.v;
import ma.q;
import t7.n;
import wa.l;
import xa.j;
import xa.k;

public final class d extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8307h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ a f8308i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(a aVar, int i10) {
        super(1);
        this.f8307h = i10;
        this.f8308i = aVar;
    }

    public final void a(Boolean bool) {
        int i10 = this.f8307h;
        a aVar = this.f8308i;
        switch (i10) {
            case 2:
                ChatView chatView = (ChatView) aVar.f9125j;
                l6.l lVar = chatView.f3552y;
                if (lVar != null) {
                    List list = lVar.f9640o;
                    if (list != null) {
                        int size = list.size();
                        l6.l lVar2 = chatView.f3552y;
                        if (lVar2 != null) {
                            lVar2.notifyItemRangeChanged(size - 40, 40);
                            return;
                        } else {
                            j.l("adapter");
                            throw null;
                        }
                    } else {
                        return;
                    }
                } else {
                    j.l("adapter");
                    throw null;
                }
            default:
                ((ChatView) aVar.f9125j).v();
                return;
        }
    }

    public final Object invoke(Object obj) {
        int i10 = this.f8307h;
        a aVar = this.f8308i;
        switch (i10) {
            case 0:
                ChatMessage chatMessage = (ChatMessage) obj;
                ((ChatView) aVar.f9125j).s();
                return v.f9814a;
            case 1:
                n nVar = (n) obj;
                j.e("it", nVar);
                ((ChatView) aVar.f9125j).t(nVar);
                return v.f9814a;
            case 2:
                a((Boolean) obj);
                return v.f9814a;
            case 3:
                a((Boolean) obj);
                return v.f9814a;
            default:
                ((ChatView) aVar.f9125j).m(q.b((Chatter) obj));
                return v.f9814a;
        }
    }
}
