package m4;

import android.net.Uri;
import la.e;
import s4.m;
import xa.j;

public final class o implements j {

    /* renamed from: a  reason: collision with root package name */
    public final e f10579a;

    /* renamed from: b  reason: collision with root package name */
    public final e f10580b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f10581c;

    public o(la.o oVar, la.o oVar2, boolean z10) {
        this.f10579a = oVar;
        this.f10580b = oVar2;
        this.f10581c = z10;
    }

    public final k a(Object obj, m mVar) {
        boolean z10;
        Uri uri = (Uri) obj;
        if (j.a(uri.getScheme(), "http") || j.a(uri.getScheme(), "https")) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return null;
        }
        return new r(uri.toString(), mVar, this.f10579a, this.f10580b, this.f10581c);
    }
}
