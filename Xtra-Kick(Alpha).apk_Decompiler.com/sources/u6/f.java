package u6;

import com.github.andreyasadchy.xtra.ui.player.clip.ClipPlayerViewModel;
import hb.f0;
import hb.h0;
import la.v;
import ma.c0;
import ma.j0;
import pa.e;
import ra.i;
import wa.p;

public final class f extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ClipPlayerViewModel f15368i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(ClipPlayerViewModel clipPlayerViewModel, e eVar) {
        super(2, eVar);
        this.f15368i = clipPlayerViewModel;
    }

    public final e create(Object obj, e eVar) {
        return new f(this.f15368i, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((f) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        c0 c0Var;
        h0.O1(obj);
        try {
            c0Var = j0.d();
        } catch (Exception unused) {
            c0Var = null;
        }
        this.f15368i.f3442n.j(c0Var);
        return v.f9814a;
    }
}
