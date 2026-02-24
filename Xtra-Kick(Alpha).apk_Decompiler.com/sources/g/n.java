package g;

import android.os.Bundle;
import androidx.appcompat.app.a;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import t3.d;
import t3.e;
import xa.j;

public final class n implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6182a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final Object f6183b;

    public n(a aVar) {
        this.f6183b = aVar;
    }

    public final Bundle a() {
        int i10 = this.f6182a;
        Object obj = this.f6183b;
        switch (i10) {
            case 0:
                Bundle bundle = new Bundle();
                ((a) obj).D().getClass();
                return bundle;
            default:
                Bundle bundle2 = new Bundle();
                bundle2.putStringArrayList("classes_to_restore", new ArrayList((Set) obj));
                return bundle2;
        }
    }

    public n(e eVar) {
        j.f("registry", eVar);
        this.f6183b = new LinkedHashSet();
        eVar.c("androidx.savedstate.Restarter", this);
    }
}
