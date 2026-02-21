package j3;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.s;
import java.util.UUID;
import xa.j;

public final class n {
    private n() {
    }

    public /* synthetic */ n(int i10) {
        this();
    }

    public static r a(Context context, c1 c1Var, Bundle bundle, s sVar, h2 h2Var, String str, Bundle bundle2) {
        j.f("hostLifecycleState", sVar);
        j.f("id", str);
        return new r(context, c1Var, bundle, sVar, h2Var, str, bundle2);
    }

    public static /* synthetic */ r b(n nVar, Context context, c1 c1Var, Bundle bundle, s sVar, n0 n0Var) {
        String uuid = UUID.randomUUID().toString();
        j.e("randomUUID().toString()", uuid);
        nVar.getClass();
        return a(context, c1Var, bundle, sVar, n0Var, uuid, (Bundle) null);
    }
}
