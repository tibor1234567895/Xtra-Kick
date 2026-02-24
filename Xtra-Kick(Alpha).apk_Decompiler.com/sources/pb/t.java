package pb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import ma.z;
import oa.b;
import qb.f;
import xa.j;

public final class t {

    /* renamed from: e  reason: collision with root package name */
    public static final t f12981e;

    /* renamed from: f  reason: collision with root package name */
    public static final t f12982f = new t(false, false, (String[]) null, (String[]) null);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f12983a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f12984b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f12985c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f12986d;

    static {
        new s(0);
        p pVar = p.f12926r;
        p pVar2 = p.f12927s;
        p pVar3 = p.f12928t;
        p pVar4 = p.f12920l;
        p pVar5 = p.f12922n;
        p pVar6 = p.f12921m;
        p pVar7 = p.f12923o;
        p pVar8 = p.f12925q;
        p pVar9 = p.f12924p;
        p[] pVarArr = {pVar, pVar2, pVar3, pVar4, pVar5, pVar6, pVar7, pVar8, pVar9};
        p[] pVarArr2 = {pVar, pVar2, pVar3, pVar4, pVar5, pVar6, pVar7, pVar8, pVar9, p.f12918j, p.f12919k, p.f12916h, p.f12917i, p.f12914f, p.f12915g, p.f12913e};
        r rVar = new r();
        rVar.c((p[]) Arrays.copyOf(pVarArr, 9));
        x1 x1Var = x1.TLS_1_3;
        x1 x1Var2 = x1.TLS_1_2;
        rVar.f(x1Var, x1Var2);
        rVar.d();
        rVar.a();
        r rVar2 = new r();
        rVar2.c((p[]) Arrays.copyOf(pVarArr2, 16));
        rVar2.f(x1Var, x1Var2);
        rVar2.d();
        f12981e = rVar2.a();
        r rVar3 = new r();
        rVar3.c((p[]) Arrays.copyOf(pVarArr2, 16));
        rVar3.f(x1Var, x1Var2, x1.TLS_1_1, x1.TLS_1_0);
        rVar3.d();
        rVar3.a();
    }

    public t(boolean z10, boolean z11, String[] strArr, String[] strArr2) {
        this.f12983a = z10;
        this.f12984b = z11;
        this.f12985c = strArr;
        this.f12986d = strArr2;
    }

    public final void a(SSLSocket sSLSocket, boolean z10) {
        String[] strArr;
        boolean z11;
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        j.e("socketEnabledCipherSuites", enabledCipherSuites);
        String[] strArr2 = this.f12985c;
        if (strArr2 != null) {
            p.f12910b.getClass();
            enabledCipherSuites = f.j(enabledCipherSuites, strArr2, p.f12911c);
        }
        String[] strArr3 = this.f12986d;
        if (strArr3 != null) {
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            j.e("sslSocket.enabledProtocols", enabledProtocols);
            strArr = f.j(enabledProtocols, strArr3, b.b());
        } else {
            strArr = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        j.e("supportedCipherSuites", supportedCipherSuites);
        p.f12910b.getClass();
        n nVar = p.f12911c;
        byte[] bArr = f.f13487a;
        j.f("comparator", nVar);
        int length = supportedCipherSuites.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            if (nVar.compare(supportedCipherSuites[i10], "TLS_FALLBACK_SCSV") == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                break;
            }
            i10++;
        }
        if (z10 && i10 != -1) {
            String str = supportedCipherSuites[i10];
            j.e("supportedCipherSuites[indexOfFallbackScsv]", str);
            Object[] copyOf = Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length + 1);
            j.e("copyOf(this, newSize)", copyOf);
            enabledCipherSuites = (String[]) copyOf;
            enabledCipherSuites[enabledCipherSuites.length - 1] = str;
        }
        r rVar = new r(this);
        rVar.b((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        j.e("tlsVersionsIntersection", strArr);
        rVar.e((String[]) Arrays.copyOf(strArr, strArr.length));
        t a10 = rVar.a();
        if (a10.c() != null) {
            sSLSocket.setEnabledProtocols(a10.f12986d);
        }
        if (a10.b() != null) {
            sSLSocket.setEnabledCipherSuites(a10.f12985c);
        }
    }

    public final List b() {
        String[] strArr = this.f12985c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String b10 : strArr) {
            arrayList.add(p.f12910b.b(b10));
        }
        return z.J(arrayList);
    }

    public final List c() {
        String[] strArr = this.f12986d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String a10 : strArr) {
            x1.f13027i.getClass();
            arrayList.add(w1.a(a10));
        }
        return z.J(arrayList);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        t tVar = (t) obj;
        boolean z10 = tVar.f12983a;
        boolean z11 = this.f12983a;
        if (z11 != z10) {
            return false;
        }
        return !z11 || (Arrays.equals(this.f12985c, tVar.f12985c) && Arrays.equals(this.f12986d, tVar.f12986d) && this.f12984b == tVar.f12984b);
    }

    public final int hashCode() {
        if (!this.f12983a) {
            return 17;
        }
        int i10 = 0;
        String[] strArr = this.f12985c;
        int hashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.f12986d;
        if (strArr2 != null) {
            i10 = Arrays.hashCode(strArr2);
        }
        return ((hashCode + i10) * 31) + (this.f12984b ^ true ? 1 : 0);
    }

    public final String toString() {
        if (!this.f12983a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(b(), "[all enabled]") + ", tlsVersions=" + Objects.toString(c(), "[all enabled]") + ", supportsTlsExtensions=" + this.f12984b + ')';
    }
}
