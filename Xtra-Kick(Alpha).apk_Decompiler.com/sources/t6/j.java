package t6;

import androidx.activity.t;
import androidx.activity.y;
import com.github.andreyasadchy.xtra.ui.view.CustomPlayerView;
import hb.f0;
import hb.h0;
import kb.d;
import la.v;
import pa.e;
import pa.l;
import qa.a;
import ra.i;
import wa.p;

public final class j extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f14613i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ l f14614j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(l lVar, e eVar) {
        super(2, eVar);
        this.f14614j = lVar;
    }

    public final e create(Object obj, e eVar) {
        return new j(this.f14614j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((j) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f14613i;
        if (i10 == 0) {
            h0.O1(obj);
            l lVar = this.f14614j;
            androidx.fragment.app.f0 d02 = lVar.d0();
            CustomPlayerView customPlayerView = lVar.f14625l0;
            if (customPlayerView != null) {
                this.f14613i = 1;
                Object b10 = new d(new y(customPlayerView, (e) null), l.f12754h, -2, jb.a.SUSPEND).b(new t(0, d02), this);
                if (b10 != aVar) {
                    b10 = v.f9814a;
                }
                if (b10 == aVar) {
                    return aVar;
                }
            } else {
                xa.j.l("playerView");
                throw null;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return v.f9814a;
    }
}
