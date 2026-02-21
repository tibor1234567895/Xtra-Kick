package h5;

import android.net.Uri;
import android.text.TextUtils;
import b5.j;
import java.net.URL;
import java.security.MessageDigest;
import w5.n;

public final class x implements j {

    /* renamed from: b  reason: collision with root package name */
    public final z f7619b;

    /* renamed from: c  reason: collision with root package name */
    public final URL f7620c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7621d;

    /* renamed from: e  reason: collision with root package name */
    public String f7622e;

    /* renamed from: f  reason: collision with root package name */
    public URL f7623f;

    /* renamed from: g  reason: collision with root package name */
    public volatile byte[] f7624g;

    /* renamed from: h  reason: collision with root package name */
    public int f7625h;

    public x(String str) {
        c0 c0Var = z.f7629a;
        this.f7620c = null;
        if (!TextUtils.isEmpty(str)) {
            this.f7621d = str;
            n.b(c0Var);
            this.f7619b = c0Var;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public final void b(MessageDigest messageDigest) {
        if (this.f7624g == null) {
            this.f7624g = c().getBytes(j.f2629a);
        }
        messageDigest.update(this.f7624g);
    }

    public final String c() {
        String str = this.f7621d;
        if (str != null) {
            return str;
        }
        URL url = this.f7620c;
        n.b(url);
        return url.toString();
    }

    public final String d() {
        if (TextUtils.isEmpty(this.f7622e)) {
            String str = this.f7621d;
            if (TextUtils.isEmpty(str)) {
                URL url = this.f7620c;
                n.b(url);
                str = url.toString();
            }
            this.f7622e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f7622e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return c().equals(xVar.c()) && this.f7619b.equals(xVar.f7619b);
    }

    public final int hashCode() {
        if (this.f7625h == 0) {
            int hashCode = c().hashCode();
            this.f7625h = hashCode;
            this.f7625h = this.f7619b.hashCode() + (hashCode * 31);
        }
        return this.f7625h;
    }

    public final String toString() {
        return c();
    }

    public x(URL url) {
        c0 c0Var = z.f7629a;
        n.b(url);
        this.f7620c = url;
        this.f7621d = null;
        n.b(c0Var);
        this.f7619b = c0Var;
    }
}
