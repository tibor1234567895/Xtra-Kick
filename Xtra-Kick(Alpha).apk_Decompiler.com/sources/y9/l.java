package y9;

import android.util.Log;
import xa.j;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public boolean f17265a;

    /* renamed from: b  reason: collision with root package name */
    public String f17266b;

    public l() {
        this(0);
    }

    public final void a(String str) {
        j.g("message", str);
        if (this.f17265a) {
            c();
        }
    }

    public final void b(String str, Exception exc) {
        j.g("message", str);
        if (this.f17265a) {
            Log.e(c(), str, exc);
        }
    }

    public final String c() {
        return this.f17266b.length() > 23 ? "fetch2" : this.f17266b;
    }

    public l(int i10) {
        this.f17265a = false;
        this.f17266b = "fetch2";
    }
}
