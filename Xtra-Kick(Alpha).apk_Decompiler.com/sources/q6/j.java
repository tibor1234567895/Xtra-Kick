package q6;

import android.content.Context;
import com.github.andreyasadchy.xtra.model.offline.LocalFollowGame;
import com.github.andreyasadchy.xtra.ui.games.GamePagerViewModel;
import e6.a1;
import e6.e1;
import e6.z0;
import hb.d1;
import hb.f0;
import hb.h0;
import hb.p0;
import la.v;
import pa.e;
import pa.h;
import qa.a;
import ra.i;
import wa.p;

public final class j extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f13362i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f13363j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ GamePagerViewModel f13364k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Context f13365l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(int i10, GamePagerViewModel gamePagerViewModel, Context context, e eVar) {
        super(2, eVar);
        this.f13363j = i10;
        this.f13364k = gamePagerViewModel;
        this.f13365l = context;
    }

    public final e create(Object obj, e eVar) {
        return new j(this.f13363j, this.f13364k, this.f13365l, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((j) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f13362i;
        GamePagerViewModel gamePagerViewModel = this.f13364k;
        if (i10 == 0) {
            h0.O1(obj);
            int i11 = this.f13363j;
            if (i11 != 0) {
                e1 e1Var = gamePagerViewModel.f3422d;
                this.f13362i = 1;
                e1Var.getClass();
                obj = h0.c2(p0.f7834b, new a1(e1Var, i11, (e) null), this);
                if (obj == aVar) {
                    return aVar;
                }
            }
            return v.f9814a;
        } else if (i10 == 1) {
            try {
                h0.O1(obj);
            } catch (Exception unused) {
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LocalFollowGame localFollowGame = (LocalFollowGame) obj;
        if (localFollowGame != null) {
            Context context = this.f13365l;
            e1 e1Var2 = gamePagerViewModel.f3422d;
            e1Var2.getClass();
            xa.j.f("context", context);
            h0.b1(d1.f7786h, (h) null, 0, new z0(localFollowGame, context, e1Var2, (e) null), 3);
        }
        gamePagerViewModel.f3423e.j(new la.i(Boolean.FALSE, (Object) null));
        return v.f9814a;
    }
}
