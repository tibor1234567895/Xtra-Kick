package i5;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import b5.n;
import h5.h0;
import h5.i0;
import v5.b;

public final class f implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f8295a;

    /* renamed from: b  reason: collision with root package name */
    public final i0 f8296b;

    /* renamed from: c  reason: collision with root package name */
    public final i0 f8297c;

    /* renamed from: d  reason: collision with root package name */
    public final Class f8298d;

    public f(Context context, i0 i0Var, i0 i0Var2, Class cls) {
        this.f8295a = context.getApplicationContext();
        this.f8296b = i0Var;
        this.f8297c = i0Var2;
        this.f8298d = cls;
    }

    public final h0 a(Object obj, int i10, int i11, n nVar) {
        Uri uri = (Uri) obj;
        return new h0(new b(uri), new e(this.f8295a, this.f8296b, this.f8297c, uri, i10, i11, nVar, this.f8298d));
    }

    public final boolean b(Object obj) {
        Uri uri = (Uri) obj;
        if (Build.VERSION.SDK_INT < 29 || !c5.b.a(uri)) {
            return false;
        }
        return true;
    }
}
