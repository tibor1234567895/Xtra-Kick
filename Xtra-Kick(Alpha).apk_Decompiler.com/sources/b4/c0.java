package b4;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import q0.f;

public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f2521a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final View f2522b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f2523c = new ArrayList();

    @Deprecated
    public c0() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r3 = (b4.c0) r3;
        r0 = r3.f2522b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof b4.c0
            if (r0 == 0) goto L_0x0018
            b4.c0 r3 = (b4.c0) r3
            android.view.View r0 = r3.f2522b
            android.view.View r1 = r2.f2522b
            if (r1 != r0) goto L_0x0018
            java.util.HashMap r0 = r2.f2521a
            java.util.HashMap r3 = r3.f2521a
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0018
            r3 = 1
            return r3
        L_0x0018:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.c0.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return this.f2521a.hashCode() + (this.f2522b.hashCode() * 31);
    }

    public final String toString() {
        String g10 = f.g(("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f2522b + Constants.WRITE_NEW_LINE, "    values:");
        HashMap hashMap = this.f2521a;
        for (String str : hashMap.keySet()) {
            g10 = g10 + "    " + str + ": " + hashMap.get(str) + Constants.WRITE_NEW_LINE;
        }
        return g10;
    }

    public c0(View view) {
        this.f2522b = view;
    }
}
