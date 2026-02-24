package q6;

import androidx.lifecycle.o0;
import com.github.andreyasadchy.xtra.model.offline.LocalFollowGame;
import com.github.andreyasadchy.xtra.ui.games.GamePagerViewModel;
import e6.a1;
import e6.e1;
import hb.f0;
import hb.h0;
import hb.p0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class k extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f13366i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f13367j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ GamePagerViewModel f13368k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(int i10, GamePagerViewModel gamePagerViewModel, e eVar) {
        super(2, eVar);
        this.f13367j = i10;
        this.f13368k = gamePagerViewModel;
    }

    public final e create(Object obj, e eVar) {
        return new k(this.f13367j, this.f13368k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((k) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z10;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f13366i;
        GamePagerViewModel gamePagerViewModel = this.f13368k;
        boolean z11 = true;
        if (i10 == 0) {
            h0.O1(obj);
            int i11 = this.f13367j;
            e1 e1Var = gamePagerViewModel.f3422d;
            this.f13366i = 1;
            e1Var.getClass();
            obj = h0.c2(p0.f7834b, new a1(e1Var, i11, (e) null), this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            try {
                h0.O1(obj);
            } catch (Exception unused) {
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((LocalFollowGame) obj) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        o0 o0Var = gamePagerViewModel.f3423e;
        if (!z10) {
            z11 = false;
        }
        o0Var.j(new la.i(Boolean.valueOf(z11), (Object) null));
        return v.f9814a;
    }
}
