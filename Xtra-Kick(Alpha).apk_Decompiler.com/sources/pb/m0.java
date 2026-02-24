package pb;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import la.f;
import la.o;
import ma.s;
import wa.a;
import xa.j;

public final class m0 {

    /* renamed from: e  reason: collision with root package name */
    public static final k0 f12903e = new k0(0);

    /* renamed from: a  reason: collision with root package name */
    public final x1 f12904a;

    /* renamed from: b  reason: collision with root package name */
    public final p f12905b;

    /* renamed from: c  reason: collision with root package name */
    public final List f12906c;

    /* renamed from: d  reason: collision with root package name */
    public final o f12907d;

    public m0(x1 x1Var, p pVar, List list, a aVar) {
        j.f("tlsVersion", x1Var);
        j.f("cipherSuite", pVar);
        j.f("localCertificates", list);
        this.f12904a = x1Var;
        this.f12905b = pVar;
        this.f12906c = list;
        this.f12907d = f.b(new l0(aVar, 0));
    }

    public final List a() {
        return (List) this.f12907d.getValue();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m0) {
            m0 m0Var = (m0) obj;
            return m0Var.f12904a == this.f12904a && j.a(m0Var.f12905b, this.f12905b) && j.a(m0Var.a(), a()) && j.a(m0Var.f12906c, this.f12906c);
        }
    }

    public final int hashCode() {
        int hashCode = this.f12905b.hashCode();
        int hashCode2 = a().hashCode();
        return this.f12906c.hashCode() + ((hashCode2 + ((hashCode + ((this.f12904a.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String str;
        String str2;
        List<Certificate> a10 = a();
        ArrayList arrayList = new ArrayList(s.i(a10));
        for (Certificate certificate : a10) {
            if (certificate instanceof X509Certificate) {
                str2 = ((X509Certificate) certificate).getSubjectDN().toString();
            } else {
                str2 = certificate.getType();
                j.e("type", str2);
            }
            arrayList.add(str2);
        }
        String obj = arrayList.toString();
        StringBuilder sb2 = new StringBuilder("Handshake{tlsVersion=");
        sb2.append(this.f12904a);
        sb2.append(" cipherSuite=");
        sb2.append(this.f12905b);
        sb2.append(" peerCertificates=");
        sb2.append(obj);
        sb2.append(" localCertificates=");
        List<Certificate> list = this.f12906c;
        ArrayList arrayList2 = new ArrayList(s.i(list));
        for (Certificate certificate2 : list) {
            if (certificate2 instanceof X509Certificate) {
                str = ((X509Certificate) certificate2).getSubjectDN().toString();
            } else {
                str = certificate2.getType();
                j.e("type", str);
            }
            arrayList2.add(str);
        }
        sb2.append(arrayList2);
        sb2.append('}');
        return sb2.toString();
    }
}
