package e6;

import a6.l;
import android.database.Cursor;
import com.github.andreyasadchy.xtra.model.offline.LocalFollowGame;
import hb.f0;
import hb.h0;
import java.util.ArrayList;
import la.v;
import pa.e;
import r3.n0;
import r3.s0;
import ra.i;
import wa.p;

public final class b1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ e1 f5083i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b1(e1 e1Var, e eVar) {
        super(2, eVar);
        this.f5083i = e1Var;
    }

    public final e create(Object obj, e eVar) {
        return new b1(this.f5083i, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((b1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        Integer num;
        String str;
        String str2;
        h0.O1(obj);
        l lVar = (l) this.f5083i.f5108a;
        lVar.getClass();
        s0 k10 = s0.k(0, "SELECT * FROM local_follows_games");
        n0 n0Var = lVar.f244a;
        n0Var.b();
        Cursor n12 = h0.n1(n0Var, k10);
        try {
            int c02 = h0.c0(n12, "gameId");
            int c03 = h0.c0(n12, "gameSlug");
            int c04 = h0.c0(n12, "gameName");
            int c05 = h0.c0(n12, "boxArt");
            int c06 = h0.c0(n12, "id");
            ArrayList arrayList = new ArrayList(n12.getCount());
            while (n12.moveToNext()) {
                String str3 = null;
                if (n12.isNull(c02)) {
                    num = null;
                } else {
                    num = Integer.valueOf(n12.getInt(c02));
                }
                if (n12.isNull(c03)) {
                    str = null;
                } else {
                    str = n12.getString(c03);
                }
                if (n12.isNull(c04)) {
                    str2 = null;
                } else {
                    str2 = n12.getString(c04);
                }
                if (!n12.isNull(c05)) {
                    str3 = n12.getString(c05);
                }
                LocalFollowGame localFollowGame = new LocalFollowGame(num, str, str2, str3);
                localFollowGame.setId(n12.getInt(c06));
                arrayList.add(localFollowGame);
            }
            return arrayList;
        } finally {
            n12.close();
            k10.v();
        }
    }
}
