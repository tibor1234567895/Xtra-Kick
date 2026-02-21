package n3;

import android.support.v4.media.h;
import com.github.andreyasadchy.xtra.model.chat.Emote;
import com.github.andreyasadchy.xtra.ui.view.chat.ChatView;
import i6.e;
import k5.a;
import la.v;
import wa.l;
import xa.i;
import xa.j;

public final /* synthetic */ class o3 extends i implements l {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f11381q = 1;

    public o3(e eVar) {
        super(1, (Object) eVar, e.class, "appendEmote", "appendEmote(Lcom/github/andreyasadchy/xtra/model/chat/Emote;)V");
    }

    public final Object invoke(Object obj) {
        int i10 = this.f11381q;
        Object obj2 = this.f16801i;
        switch (i10) {
            case 0:
                pa.e eVar = (pa.e) obj;
                h.y(obj2);
                throw null;
            default:
                Emote emote = (Emote) obj;
                j.f("p0", emote);
                e eVar2 = (e) obj2;
                eVar2.getClass();
                a aVar = eVar2.f8315o0;
                j.c(aVar);
                ((ChatView) aVar.f9125j).n(emote);
                return v.f9814a;
        }
    }
}
