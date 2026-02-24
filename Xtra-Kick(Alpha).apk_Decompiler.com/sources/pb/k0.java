package pb;

import androidx.lifecycle.p1;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import ma.b0;
import qb.h;
import xa.j;

public final class k0 {
    private k0() {
    }

    public /* synthetic */ k0(int i10) {
        this();
    }

    public static m0 a(SSLSession sSLSession) {
        boolean z10;
        Object obj;
        List list;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            if (j.a(cipherSuite, "TLS_NULL_WITH_NULL_NULL")) {
                z10 = true;
            } else {
                z10 = j.a(cipherSuite, "SSL_NULL_WITH_NULL_NULL");
            }
            if (!z10) {
                p b10 = p.f12910b.b(cipherSuite);
                String protocol = sSLSession.getProtocol();
                if (protocol == null) {
                    throw new IllegalStateException("tlsVersion == null".toString());
                } else if (!j.a(Constants.NO_CLOSED_CAPTIONS, protocol)) {
                    x1.f13027i.getClass();
                    x1 a10 = w1.a(protocol);
                    try {
                        Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                        if (peerCertificates != null) {
                            obj = h.g(Arrays.copyOf(peerCertificates, peerCertificates.length));
                        } else {
                            obj = b0.f10801h;
                        }
                    } catch (SSLPeerUnverifiedException unused) {
                        obj = b0.f10801h;
                    }
                    Certificate[] localCertificates = sSLSession.getLocalCertificates();
                    if (localCertificates != null) {
                        list = h.g(Arrays.copyOf(localCertificates, localCertificates.length));
                    } else {
                        list = b0.f10801h;
                    }
                    return new m0(a10, b10, list, new p1(25, obj));
                } else {
                    throw new IOException("tlsVersion == NONE");
                }
            } else {
                throw new IOException("cipherSuite == ".concat(cipherSuite));
            }
        } else {
            throw new IllegalStateException("cipherSuite == null".toString());
        }
    }
}
