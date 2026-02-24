package bc;

import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import xa.j;

public final class b extends e {

    /* renamed from: b  reason: collision with root package name */
    public final g f2703b;

    static {
        new a(0);
    }

    public b(g gVar) {
        j.f("trustRootIndex", gVar);
        this.f2703b = gVar;
    }

    public static boolean b(X509Certificate x509Certificate, X509Certificate x509Certificate2, int i10) {
        if (!j.a(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN()) || x509Certificate2.getBasicConstraints() < i10) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public final List a(String str, List list) {
        j.f("chain", list);
        j.f("hostname", str);
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        Object removeFirst = arrayDeque.removeFirst();
        j.e("queue.removeFirst()", removeFirst);
        arrayList.add(removeFirst);
        boolean z10 = false;
        for (int i10 = 0; i10 < 9; i10++) {
            Object obj = arrayList.get(arrayList.size() - 1);
            j.d("null cannot be cast to non-null type java.security.cert.X509Certificate", obj);
            X509Certificate x509Certificate = (X509Certificate) obj;
            X509Certificate a10 = this.f2703b.a(x509Certificate);
            if (a10 != null) {
                if (arrayList.size() > 1 || !j.a(x509Certificate, a10)) {
                    arrayList.add(a10);
                }
                if (b(a10, a10, arrayList.size() - 2)) {
                    return arrayList;
                }
                z10 = true;
            } else {
                Iterator it = arrayDeque.iterator();
                j.e("queue.iterator()", it);
                while (it.hasNext()) {
                    Object next = it.next();
                    j.d("null cannot be cast to non-null type java.security.cert.X509Certificate", next);
                    X509Certificate x509Certificate2 = (X509Certificate) next;
                    if (b(x509Certificate, x509Certificate2, arrayList.size() - 1)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z10) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof b) && j.a(((b) obj).f2703b, this.f2703b);
    }

    public final int hashCode() {
        return this.f2703b.hashCode();
    }
}
