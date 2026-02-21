package e6;

import a6.e0;
import android.database.Cursor;
import com.github.andreyasadchy.xtra.model.offline.VodBookmarkIgnoredUser;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import r3.n0;
import r3.s0;
import ra.i;
import wa.p;

public final class h2 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ j2 f5143i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f5144j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h2(j2 j2Var, int i10, e eVar) {
        super(2, eVar);
        this.f5143i = j2Var;
        this.f5144j = i10;
    }

    public final e create(Object obj, e eVar) {
        return new h2(this.f5143i, this.f5144j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((h2) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        VodBookmarkIgnoredUser vodBookmarkIgnoredUser;
        h0.O1(obj);
        e0 e0Var = (e0) this.f5143i.f5167a;
        e0Var.getClass();
        s0 k10 = s0.k(1, "SELECT * FROM vod_bookmark_ignored_users WHERE user_id = ? AND user_id != 0");
        k10.g0(1, (long) this.f5144j);
        n0 n0Var = e0Var.f231a;
        n0Var.b();
        Cursor n12 = h0.n1(n0Var, k10);
        try {
            int c02 = h0.c0(n12, "user_id");
            if (n12.moveToFirst()) {
                vodBookmarkIgnoredUser = new VodBookmarkIgnoredUser(n12.getInt(c02));
            } else {
                vodBookmarkIgnoredUser = null;
            }
            return vodBookmarkIgnoredUser;
        } finally {
            n12.close();
            k10.v();
        }
    }
}
