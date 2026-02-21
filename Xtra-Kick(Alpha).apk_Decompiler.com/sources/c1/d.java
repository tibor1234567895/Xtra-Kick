package c1;

import android.support.v4.media.h;
import android.support.v4.media.session.u;
import androidx.lifecycle.b2;
import androidx.lifecycle.d0;
import androidx.lifecycle.g2;
import java.io.PrintWriter;
import q.l;

public final class d extends a {

    /* renamed from: a  reason: collision with root package name */
    public final d0 f2720a;

    /* renamed from: b  reason: collision with root package name */
    public final c f2721b;

    public d(d0 d0Var, g2 g2Var) {
        this.f2720a = d0Var;
        this.f2721b = (c) new u(g2Var, (b2) c.f2718e).q(c.class);
    }

    public final void b(String str, PrintWriter printWriter) {
        l lVar = this.f2721b.f2719d;
        if (lVar.g() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            if (lVar.g() > 0) {
                h.y(lVar.h(0));
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(lVar.e(0));
                printWriter.print(": ");
                throw null;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0031, code lost:
        r2 = r1.getClass().getName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String toString() {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 128(0x80, float:1.794E-43)
            r0.<init>(r1)
            java.lang.String r1 = "LoaderManager{"
            r0.append(r1)
            int r1 = java.lang.System.identityHashCode(r4)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            r0.append(r1)
            java.lang.String r1 = " in "
            r0.append(r1)
            androidx.lifecycle.d0 r1 = r4.f2720a
            if (r1 != 0) goto L_0x0023
            java.lang.String r1 = "null"
            goto L_0x0057
        L_0x0023:
            java.lang.Class r2 = r1.getClass()
            java.lang.String r2 = r2.getSimpleName()
            int r3 = r2.length()
            if (r3 > 0) goto L_0x0047
            java.lang.Class r2 = r1.getClass()
            java.lang.String r2 = r2.getName()
            r3 = 46
            int r3 = r2.lastIndexOf(r3)
            if (r3 <= 0) goto L_0x0047
            int r3 = r3 + 1
            java.lang.String r2 = r2.substring(r3)
        L_0x0047:
            r0.append(r2)
            r2 = 123(0x7b, float:1.72E-43)
            r0.append(r2)
            int r1 = java.lang.System.identityHashCode(r1)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x0057:
            java.lang.String r2 = "}}"
            java.lang.String r0 = android.support.v4.media.h.p(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.d.toString():java.lang.String");
    }
}
