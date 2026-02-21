package y5;

import android.os.Bundle;
import android.support.v4.media.h;
import com.woxthebox.draglistview.R;
import j3.d1;
import java.util.Arrays;
import xa.j;

public final class s implements d1 {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f17065a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17066b;

    public s() {
        this((String[]) null);
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putStringArray("tags", this.f17065a);
        return bundle;
    }

    public final int b() {
        return this.f17066b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof s) && j.a(this.f17065a, ((s) obj).f17065a);
    }

    public final int hashCode() {
        String[] strArr = this.f17065a;
        if (strArr == null) {
            return 0;
        }
        return Arrays.hashCode(strArr);
    }

    public final String toString() {
        return h.n("ActionGlobalTopFragment(tags=", Arrays.toString(this.f17065a), ")");
    }

    public s(String[] strArr) {
        this.f17065a = strArr;
        this.f17066b = R.id.action_global_topFragment;
    }
}
