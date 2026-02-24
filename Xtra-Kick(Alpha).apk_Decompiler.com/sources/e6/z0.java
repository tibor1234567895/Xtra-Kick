package e6;

import a6.l;
import android.content.Context;
import com.github.andreyasadchy.xtra.model.offline.LocalFollowGame;
import hb.f0;
import hb.h0;
import java.io.File;
import la.v;
import pa.e;
import r3.n0;
import ra.i;
import wa.p;

public final class z0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LocalFollowGame f5280i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Context f5281j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ e1 f5282k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z0(LocalFollowGame localFollowGame, Context context, e1 e1Var, e eVar) {
        super(2, eVar);
        this.f5280i = localFollowGame;
        this.f5281j = context;
        this.f5282k = e1Var;
    }

    public final e create(Object obj, e eVar) {
        return new z0(this.f5280i, this.f5281j, this.f5282k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((z0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        LocalFollowGame localFollowGame = this.f5280i;
        Integer gameId = localFollowGame.getGameId();
        if (gameId == null || gameId.intValue() != 0) {
            String file = this.f5281j.getFilesDir().toString();
            String str = File.separator;
            Integer gameId2 = localFollowGame.getGameId();
            new File(file + str + "box_art" + str + gameId2 + ".png").delete();
        }
        l lVar = (l) this.f5282k.f5108a;
        n0 n0Var = lVar.f244a;
        n0Var.b();
        n0Var.c();
        try {
            lVar.f246c.i(localFollowGame);
            n0Var.r();
            n0Var.g();
            return v.f9814a;
        } catch (Throwable th) {
            n0Var.g();
            throw th;
        }
    }
}
