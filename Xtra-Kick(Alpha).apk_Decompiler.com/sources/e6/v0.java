package e6;

import android.database.Cursor;
import com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel;
import hb.f0;
import hb.h0;
import java.util.ArrayList;
import la.v;
import pa.e;
import r3.n0;
import r3.s0;
import ra.i;
import wa.p;

public final class v0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ y0 f5253i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v0(y0 y0Var, e eVar) {
        super(2, eVar);
        this.f5253i = y0Var;
    }

    public final e create(Object obj, e eVar) {
        return new v0(this.f5253i, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((v0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        h0.O1(obj);
        a6.i iVar = (a6.i) this.f5253i.f5273a;
        iVar.getClass();
        s0 k10 = s0.k(0, "SELECT * FROM local_follows");
        n0 n0Var = iVar.f239a;
        n0Var.b();
        Cursor n12 = h0.n1(n0Var, k10);
        try {
            int c02 = h0.c0(n12, "userId");
            int c03 = h0.c0(n12, "userLogin");
            int c04 = h0.c0(n12, "userName");
            int c05 = h0.c0(n12, "channelLogo");
            int c06 = h0.c0(n12, "id");
            ArrayList arrayList = new ArrayList(n12.getCount());
            while (n12.moveToNext()) {
                int i10 = n12.getInt(c02);
                String str3 = null;
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
                LocalFollowChannel localFollowChannel = new LocalFollowChannel(i10, str, str2, str3);
                localFollowChannel.setId(n12.getInt(c06));
                arrayList.add(localFollowChannel);
            }
            return arrayList;
        } finally {
            n12.close();
            k10.v();
        }
    }
}
