package bc;

import android.support.v4.media.h;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import ma.b0;
import xa.j;

public final class f implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public static final f f2706a = new f();

    private f() {
    }

    public static List a(X509Certificate x509Certificate, int i10) {
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return b0.f10801h;
            }
            ArrayList arrayList = new ArrayList();
            for (List next : subjectAlternativeNames) {
                if (next != null) {
                    if (next.size() >= 2) {
                        if (j.a(next.get(0), Integer.valueOf(i10))) {
                            Object obj = next.get(1);
                            if (obj != null) {
                                arrayList.add((String) obj);
                            }
                        }
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return b0.f10801h;
        }
    }

    public static boolean b(String str) {
        boolean z10;
        boolean z11;
        int i10;
        char c10;
        int length = str.length();
        int length2 = str.length();
        if (length2 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (length2 <= str.length()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                long j10 = 0;
                int i11 = 0;
                while (i11 < length2) {
                    char charAt = str.charAt(i11);
                    if (charAt < 128) {
                        j10++;
                    } else {
                        if (charAt < 2048) {
                            i10 = 2;
                        } else if (charAt < 55296 || charAt > 57343) {
                            i10 = 3;
                        } else {
                            int i12 = i11 + 1;
                            if (i12 < length2) {
                                c10 = str.charAt(i12);
                            } else {
                                c10 = 0;
                            }
                            if (charAt > 56319 || c10 < 56320 || c10 > 57343) {
                                j10++;
                                i11 = i12;
                            } else {
                                j10 += (long) 4;
                                i11 += 2;
                            }
                        }
                        j10 += (long) i10;
                    }
                    i11++;
                }
                if (length == ((int) j10)) {
                    return true;
                }
                return false;
            }
            StringBuilder r10 = h.r("endIndex > string.length: ", length2, " > ");
            r10.append(str.length());
            throw new IllegalArgumentException(r10.toString().toString());
        }
        throw new IllegalArgumentException(h.j("endIndex < beginIndex: ", length2, " < 0").toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x013e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(java.lang.String r11, java.security.cert.X509Certificate r12) {
        /*
            java.lang.String r0 = "host"
            xa.j.f(r0, r11)
            fb.l r0 = qb.b.f13476a
            fb.l r0 = qb.b.f13476a
            boolean r0 = r0.b(r11)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0042
            java.lang.String r11 = hb.h0.R1(r11)
            r0 = 7
            java.util.List r12 = a(r12, r0)
            boolean r0 = r12 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0026
            boolean r0 = r12.isEmpty()
            if (r0 == 0) goto L_0x0026
            goto L_0x013d
        L_0x0026:
            java.util.Iterator r12 = r12.iterator()
        L_0x002a:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x013d
            java.lang.Object r0 = r12.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = hb.h0.R1(r0)
            boolean r0 = xa.j.a(r11, r0)
            if (r0 == 0) goto L_0x002a
            goto L_0x013e
        L_0x0042:
            boolean r0 = b(r11)
            java.lang.String r3 = "this as java.lang.String).toLowerCase(locale)"
            java.lang.String r4 = "US"
            if (r0 == 0) goto L_0x0058
            java.util.Locale r0 = java.util.Locale.US
            xa.j.e(r4, r0)
            java.lang.String r11 = r11.toLowerCase(r0)
            xa.j.e(r3, r11)
        L_0x0058:
            r0 = 2
            java.util.List r12 = a(r12, r0)
            boolean r0 = r12 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0069
            boolean r0 = r12.isEmpty()
            if (r0 == 0) goto L_0x0069
            goto L_0x013d
        L_0x0069:
            java.util.Iterator r12 = r12.iterator()
        L_0x006d:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x013d
            java.lang.Object r0 = r12.next()
            java.lang.String r0 = (java.lang.String) r0
            bc.f r5 = f2706a
            r5.getClass()
            int r5 = r11.length()
            if (r5 != 0) goto L_0x0086
            r5 = 1
            goto L_0x0087
        L_0x0086:
            r5 = 0
        L_0x0087:
            if (r5 != 0) goto L_0x0139
            java.lang.String r5 = "."
            boolean r6 = fb.w.m(r11, r5, r2)
            if (r6 != 0) goto L_0x0139
            java.lang.String r6 = ".."
            boolean r7 = fb.w.f(r11, r6, r2)
            if (r7 == 0) goto L_0x009b
            goto L_0x0139
        L_0x009b:
            if (r0 == 0) goto L_0x00a6
            int r7 = r0.length()
            if (r7 != 0) goto L_0x00a4
            goto L_0x00a6
        L_0x00a4:
            r7 = 0
            goto L_0x00a7
        L_0x00a6:
            r7 = 1
        L_0x00a7:
            if (r7 != 0) goto L_0x0139
            boolean r7 = fb.w.m(r0, r5, r2)
            if (r7 != 0) goto L_0x0139
            boolean r6 = fb.w.f(r0, r6, r2)
            if (r6 == 0) goto L_0x00b7
            goto L_0x0139
        L_0x00b7:
            boolean r6 = fb.w.f(r11, r5, r2)
            if (r6 != 0) goto L_0x00c2
            java.lang.String r6 = r11.concat(r5)
            goto L_0x00c3
        L_0x00c2:
            r6 = r11
        L_0x00c3:
            boolean r7 = fb.w.f(r0, r5, r2)
            if (r7 != 0) goto L_0x00cd
            java.lang.String r0 = r0.concat(r5)
        L_0x00cd:
            boolean r5 = b(r0)
            if (r5 == 0) goto L_0x00df
            java.util.Locale r5 = java.util.Locale.US
            xa.j.e(r4, r5)
            java.lang.String r0 = r0.toLowerCase(r5)
            xa.j.e(r3, r0)
        L_0x00df:
            java.lang.String r5 = "*"
            boolean r5 = fb.y.n(r0, r5, r2)
            if (r5 != 0) goto L_0x00ec
            boolean r0 = xa.j.a(r6, r0)
            goto L_0x013a
        L_0x00ec:
            java.lang.String r5 = "*."
            boolean r7 = fb.w.m(r0, r5, r2)
            if (r7 == 0) goto L_0x0139
            r7 = 42
            r8 = 4
            int r7 = fb.y.t(r0, r7, r1, r2, r8)
            r9 = -1
            if (r7 == r9) goto L_0x00ff
            goto L_0x0139
        L_0x00ff:
            int r7 = r6.length()
            int r10 = r0.length()
            if (r7 >= r10) goto L_0x010a
            goto L_0x0139
        L_0x010a:
            boolean r5 = xa.j.a(r5, r0)
            if (r5 == 0) goto L_0x0111
            goto L_0x0139
        L_0x0111:
            java.lang.String r0 = r0.substring(r1)
            java.lang.String r5 = "this as java.lang.String).substring(startIndex)"
            xa.j.e(r5, r0)
            boolean r5 = fb.w.f(r6, r0, r2)
            if (r5 != 0) goto L_0x0121
            goto L_0x0139
        L_0x0121:
            int r5 = r6.length()
            int r0 = r0.length()
            int r5 = r5 - r0
            if (r5 <= 0) goto L_0x0137
            int r5 = r5 + -1
            r0 = 46
            int r0 = fb.y.w(r6, r0, r5, r8)
            if (r0 == r9) goto L_0x0137
            goto L_0x0139
        L_0x0137:
            r0 = 1
            goto L_0x013a
        L_0x0139:
            r0 = 0
        L_0x013a:
            if (r0 == 0) goto L_0x006d
            goto L_0x013e
        L_0x013d:
            r1 = 0
        L_0x013e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bc.f.c(java.lang.String, java.security.cert.X509Certificate):boolean");
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        j.f("host", str);
        j.f("session", sSLSession);
        if (!b(str)) {
            return false;
        }
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            j.d("null cannot be cast to non-null type java.security.cert.X509Certificate", certificate);
            return c(str, (X509Certificate) certificate);
        } catch (SSLException unused) {
            return false;
        }
    }
}
