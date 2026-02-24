package pb;

import fb.w;
import hb.h0;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import qb.h;
import xa.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final d0 f12755a;

    /* renamed from: b  reason: collision with root package name */
    public final SocketFactory f12756b;

    /* renamed from: c  reason: collision with root package name */
    public final SSLSocketFactory f12757c;

    /* renamed from: d  reason: collision with root package name */
    public final HostnameVerifier f12758d;

    /* renamed from: e  reason: collision with root package name */
    public final m f12759e;

    /* renamed from: f  reason: collision with root package name */
    public final d f12760f;

    /* renamed from: g  reason: collision with root package name */
    public final Proxy f12761g;

    /* renamed from: h  reason: collision with root package name */
    public final ProxySelector f12762h;

    /* renamed from: i  reason: collision with root package name */
    public final t0 f12763i;

    /* renamed from: j  reason: collision with root package name */
    public final List f12764j;

    /* renamed from: k  reason: collision with root package name */
    public final List f12765k;

    public a(String str, int i10, d0 d0Var, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, m mVar, d dVar, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        String str2 = str;
        int i11 = i10;
        SSLSocketFactory sSLSocketFactory2 = sSLSocketFactory;
        d dVar2 = dVar;
        ProxySelector proxySelector2 = proxySelector;
        j.f("uriHost", str);
        j.f("dns", d0Var);
        j.f("socketFactory", socketFactory);
        j.f("proxyAuthenticator", dVar2);
        j.f("protocols", list);
        j.f("connectionSpecs", list2);
        j.f("proxySelector", proxySelector2);
        this.f12755a = d0Var;
        this.f12756b = socketFactory;
        this.f12757c = sSLSocketFactory2;
        this.f12758d = hostnameVerifier;
        this.f12759e = mVar;
        this.f12760f = dVar2;
        this.f12761g = proxy;
        this.f12762h = proxySelector2;
        r0 r0Var = new r0();
        String str3 = "https";
        String str4 = sSLSocketFactory2 != null ? str3 : "http";
        if (w.g(str4, "http")) {
            str3 = "http";
        } else if (!w.g(str4, str3)) {
            throw new IllegalArgumentException("unexpected scheme: ".concat(str4));
        }
        r0Var.f12953a = str3;
        String R1 = h0.R1(s0.d(t0.f12987k, str, 0, 0, false, 7));
        if (R1 != null) {
            r0Var.f12956d = R1;
            boolean z10 = true;
            if ((1 > i11 || i11 >= 65536) ? false : z10) {
                r0Var.f12957e = i11;
                this.f12763i = r0Var.a();
                this.f12764j = h.l(list);
                this.f12765k = h.l(list2);
                return;
            }
            throw new IllegalArgumentException(android.support.v4.media.h.i("unexpected port: ", i10).toString());
        }
        throw new IllegalArgumentException("unexpected host: ".concat(str));
    }

    public final boolean a(a aVar) {
        j.f("that", aVar);
        if (!j.a(this.f12755a, aVar.f12755a) || !j.a(this.f12760f, aVar.f12760f) || !j.a(this.f12764j, aVar.f12764j) || !j.a(this.f12765k, aVar.f12765k) || !j.a(this.f12762h, aVar.f12762h) || !j.a(this.f12761g, aVar.f12761g) || !j.a(this.f12757c, aVar.f12757c) || !j.a(this.f12758d, aVar.f12758d) || !j.a(this.f12759e, aVar.f12759e) || this.f12763i.f12993e != aVar.f12763i.f12993e) {
            return false;
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return j.a(this.f12763i, aVar.f12763i) && a(aVar);
        }
    }

    public final int hashCode() {
        int hashCode = this.f12755a.hashCode();
        int hashCode2 = this.f12760f.hashCode();
        int hashCode3 = this.f12764j.hashCode();
        int hashCode4 = this.f12765k.hashCode();
        int hashCode5 = this.f12762h.hashCode();
        int hashCode6 = Objects.hashCode(this.f12761g);
        int hashCode7 = Objects.hashCode(this.f12757c);
        int hashCode8 = Objects.hashCode(this.f12758d);
        return Objects.hashCode(this.f12759e) + ((hashCode8 + ((hashCode7 + ((hashCode6 + ((hashCode5 + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + ((this.f12763i.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("Address{");
        t0 t0Var = this.f12763i;
        sb2.append(t0Var.f12992d);
        sb2.append(':');
        sb2.append(t0Var.f12993e);
        sb2.append(", ");
        Proxy proxy = this.f12761g;
        if (proxy != null) {
            str = "proxy=" + proxy;
        } else {
            str = "proxySelector=" + this.f12762h;
        }
        sb2.append(str);
        sb2.append('}');
        return sb2.toString();
    }
}
