package e6;

import a6.c0;
import a6.f;
import android.content.Context;
import com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel;
import hb.f0;
import hb.h0;
import java.io.File;
import la.v;
import pa.e;
import r3.n0;
import ra.i;
import wa.p;

public final class t0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LocalFollowChannel f5237i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ y0 f5238j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Context f5239k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t0(LocalFollowChannel localFollowChannel, y0 y0Var, Context context, e eVar) {
        super(2, eVar);
        this.f5237i = localFollowChannel;
        this.f5238j = y0Var;
        this.f5239k = context;
    }

    public final e create(Object obj, e eVar) {
        return new t0(this.f5237i, this.f5238j, this.f5239k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((t0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        LocalFollowChannel localFollowChannel = this.f5237i;
        int userId = localFollowChannel.getUserId();
        y0 y0Var = this.f5238j;
        if (userId != 0) {
            if (((f) y0Var.f5275c).a(localFollowChannel.getUserId()).isEmpty()) {
                if (((c0) y0Var.f5274b).b(localFollowChannel.getUserId()).isEmpty()) {
                    String file = this.f5239k.getFilesDir().toString();
                    String str = File.separator;
                    int userId2 = localFollowChannel.getUserId();
                    new File(file + str + "profile_pics" + str + userId2 + ".png").delete();
                }
            }
        }
        a6.i iVar = (a6.i) y0Var.f5273a;
        n0 n0Var = iVar.f239a;
        n0Var.b();
        n0Var.c();
        try {
            iVar.f241c.i(localFollowChannel);
            n0Var.r();
            n0Var.g();
            return v.f9814a;
        } catch (Throwable th) {
            n0Var.g();
            throw th;
        }
    }
}
