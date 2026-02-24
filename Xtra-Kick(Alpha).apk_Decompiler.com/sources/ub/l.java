package ub;

import hb.h0;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import la.v;
import ma.b0;
import ma.z;
import pb.a;
import pb.f1;
import pb.i1;
import pb.j1;
import pb.m;
import pb.o1;
import pb.q1;
import pb.r1;
import pb.t0;
import pb.u0;
import pb.v1;
import qb.f;
import tb.c0;
import tb.g;
import tb.h;
import tb.k;
import tb.o;
import tb.r;
import xa.j;

public final class l implements u0 {

    /* renamed from: a  reason: collision with root package name */
    public final f1 f15482a;

    static {
        new k(0);
    }

    public l(f1 f1Var) {
        j.f("client", f1Var);
        this.f15482a = f1Var;
    }

    public static int d(r1 r1Var, int i10) {
        String e10 = r1.e(r1Var, "Retry-After");
        if (e10 == null) {
            return i10;
        }
        if (!new fb.l("\\d+").b(e10)) {
            return Integer.MAX_VALUE;
        }
        Integer valueOf = Integer.valueOf(e10);
        j.e("valueOf(header)", valueOf);
        return valueOf.intValue();
    }

    public final r1 a(i iVar) {
        boolean z10;
        r1 r1Var;
        int i10;
        List list;
        boolean z11;
        r1 r1Var2;
        m mVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        h hVar;
        i iVar2 = iVar;
        j1 j1Var = iVar2.f15476e;
        o oVar = iVar2.f15472a;
        boolean z12 = true;
        List list2 = b0.f10801h;
        r1 r1Var3 = null;
        int i11 = 0;
        j1 j1Var2 = j1Var;
        boolean z13 = true;
        while (true) {
            oVar.getClass();
            j.f("request", j1Var2);
            if (oVar.f14991s == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                synchronized (oVar) {
                    if (!(oVar.f14993u ^ z12)) {
                        throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                    } else if (oVar.f14992t ^ z12) {
                        v vVar = v.f9814a;
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                }
                if (z13) {
                    f1 f1Var = oVar.f14980h;
                    t0 t0Var = j1Var2.f12884a;
                    if (t0Var.f12998j) {
                        SSLSocketFactory sSLSocketFactory2 = f1Var.f12836q;
                        if (sSLSocketFactory2 != null) {
                            sSLSocketFactory = sSLSocketFactory2;
                            hostnameVerifier = f1Var.f12840u;
                            mVar = f1Var.f12841v;
                        } else {
                            throw new IllegalStateException("CLEARTEXT-only client");
                        }
                    } else {
                        sSLSocketFactory = null;
                        hostnameVerifier = null;
                        mVar = null;
                    }
                    list = list2;
                    i10 = i11;
                    r1Var = r1Var3;
                    a aVar = r12;
                    a aVar2 = new a(t0Var.f12992d, t0Var.f12993e, f1Var.f12831l, f1Var.f12835p, sSLSocketFactory, hostnameVerifier, mVar, f1Var.f12834o, f1Var.f12832m, f1Var.f12839t, f1Var.f12838s, f1Var.f12833n);
                    tb.v vVar2 = new tb.v(f1Var, aVar, oVar, iVar2);
                    f1 f1Var2 = oVar.f14980h;
                    if (f1Var2.f12826g) {
                        hVar = new k(vVar2, f1Var2.E);
                    } else {
                        hVar = new c0(vVar2);
                    }
                    oVar.f14988p = hVar;
                } else {
                    list = list2;
                    r1Var = r1Var3;
                    i10 = i11;
                }
                try {
                    if (!oVar.f14995w) {
                        try {
                            q1 q1Var = new q1(iVar2.b(j1Var2));
                            q1Var.e(j1Var2);
                            if (r1Var != null) {
                                r1Var2 = h0.L1(r1Var);
                            } else {
                                r1Var2 = null;
                            }
                            q1Var.f12943j = r1Var2;
                            r1Var3 = q1Var.a();
                            g gVar = oVar.f14991s;
                            j1Var2 = b(r1Var3, gVar);
                            if (j1Var2 == null) {
                                if (gVar != null && gVar.f14964e) {
                                    if (!oVar.f14990r) {
                                        oVar.f14990r = true;
                                        oVar.f14985m.j();
                                    } else {
                                        throw new IllegalStateException("Check failed.".toString());
                                    }
                                }
                                oVar.f(false);
                                return r1Var3;
                            }
                            o1 o1Var = j1Var2.f12887d;
                            if (o1Var == null || !o1Var.isOneShot()) {
                                f.b(r1Var3.f12967n);
                                i11 = i10 + 1;
                                if (i11 <= 20) {
                                    oVar.f(true);
                                    list2 = list;
                                    z13 = true;
                                    z12 = true;
                                } else {
                                    throw new ProtocolException("Too many follow-up requests: " + i11);
                                }
                            } else {
                                oVar.f(false);
                                return r1Var3;
                            }
                        } catch (IOException e10) {
                            IOException iOException = e10;
                            if (!(iOException instanceof wb.a)) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (!c(iOException, oVar, j1Var2, z11)) {
                                List<Exception> list3 = list;
                                j.f("suppressed", list3);
                                for (Exception a10 : list3) {
                                    la.a.a(iOException, a10);
                                }
                                throw iOException;
                            }
                            List D = z.D(iOException, list);
                            oVar.f(true);
                            list2 = D;
                            i11 = i10;
                            r1Var3 = r1Var;
                            z13 = false;
                        } catch (Throwable th) {
                            th = th;
                            oVar.f(true);
                            throw th;
                        }
                    } else {
                        throw new IOException("Canceled");
                    }
                } catch (Throwable th2) {
                    th = th2;
                    oVar.f(true);
                    throw th;
                }
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
    }

    public final j1 b(r1 r1Var, g gVar) {
        v1 v1Var;
        String e10;
        o1 o1Var = null;
        if (gVar != null) {
            v1Var = gVar.c().f15003c;
        } else {
            v1Var = null;
        }
        int i10 = r1Var.f12964k;
        j1 j1Var = r1Var.f12961h;
        String str = j1Var.f12885b;
        boolean z10 = false;
        if (!(i10 == 307 || i10 == 308)) {
            if (i10 == 401) {
                return this.f15482a.f12827h.a(v1Var, r1Var);
            }
            if (i10 == 421) {
                o1 o1Var2 = j1Var.f12887d;
                if ((o1Var2 != null && o1Var2.isOneShot()) || gVar == null || !(!j.a(gVar.f14962c.b().f15028b.f12763i.f12992d, gVar.f14963d.e().e().f13006a.f12763i.f12992d))) {
                    return null;
                }
                r c10 = gVar.c();
                synchronized (c10) {
                    c10.f15013m = true;
                }
                return r1Var.f12961h;
            } else if (i10 == 503) {
                r1 r1Var2 = r1Var.f12970q;
                if ((r1Var2 == null || r1Var2.f12964k != 503) && d(r1Var, Integer.MAX_VALUE) == 0) {
                    return r1Var.f12961h;
                }
                return null;
            } else if (i10 == 407) {
                j.c(v1Var);
                if (v1Var.f13007b.type() == Proxy.Type.HTTP) {
                    return this.f15482a.f12834o.a(v1Var, r1Var);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            } else if (i10 != 408) {
                switch (i10) {
                    case 300:
                    case 301:
                    case 302:
                    case 303:
                        break;
                    default:
                        return null;
                }
            } else if (!this.f15482a.f12825f) {
                return null;
            } else {
                o1 o1Var3 = j1Var.f12887d;
                if (o1Var3 != null && o1Var3.isOneShot()) {
                    return null;
                }
                r1 r1Var3 = r1Var.f12970q;
                if ((r1Var3 == null || r1Var3.f12964k != 408) && d(r1Var, 0) <= 0) {
                    return r1Var.f12961h;
                }
                return null;
            }
        }
        f1 f1Var = this.f15482a;
        if (!f1Var.f12828i || (e10 = r1.e(r1Var, "Location")) == null) {
            return null;
        }
        j1 j1Var2 = r1Var.f12961h;
        t0 h10 = j1Var2.f12884a.h(e10);
        if (h10 == null) {
            return null;
        }
        if (!j.a(h10.f12989a, j1Var2.f12884a.f12989a) && !f1Var.f12829j) {
            return null;
        }
        i1 i1Var = new i1(j1Var2);
        if (h.a(str)) {
            h.f15471a.getClass();
            boolean a10 = j.a(str, "PROPFIND");
            int i11 = r1Var.f12964k;
            if (a10 || i11 == 308 || i11 == 307) {
                z10 = true;
            }
            if ((!j.a(str, "PROPFIND")) && i11 != 308 && i11 != 307) {
                str = "GET";
            } else if (z10) {
                o1Var = j1Var2.f12887d;
            }
            i1Var.d(str, o1Var);
            if (!z10) {
                i1Var.e("Transfer-Encoding");
                i1Var.e("Content-Length");
                i1Var.e("Content-Type");
            }
        }
        if (!qb.h.a(j1Var2.f12884a, h10)) {
            i1Var.e("Authorization");
        }
        i1Var.f12876a = h10;
        return new j1(i1Var);
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0071 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0072 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(java.io.IOException r3, tb.o r4, pb.j1 r5, boolean r6) {
        /*
            r2 = this;
            pb.f1 r0 = r2.f15482a
            boolean r0 = r0.f12825f
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            r0 = 1
            if (r6 == 0) goto L_0x001f
            pb.o1 r5 = r5.f12887d
            if (r5 == 0) goto L_0x0015
            boolean r5 = r5.isOneShot()
            if (r5 != 0) goto L_0x0019
        L_0x0015:
            boolean r5 = r3 instanceof java.io.FileNotFoundException
            if (r5 == 0) goto L_0x001b
        L_0x0019:
            r5 = 1
            goto L_0x001c
        L_0x001b:
            r5 = 0
        L_0x001c:
            if (r5 == 0) goto L_0x001f
            return r1
        L_0x001f:
            boolean r5 = r3 instanceof java.net.ProtocolException
            if (r5 == 0) goto L_0x0024
            goto L_0x0040
        L_0x0024:
            boolean r5 = r3 instanceof java.io.InterruptedIOException
            if (r5 == 0) goto L_0x002f
            boolean r3 = r3 instanceof java.net.SocketTimeoutException
            if (r3 == 0) goto L_0x0040
            if (r6 != 0) goto L_0x0040
            goto L_0x0042
        L_0x002f:
            boolean r5 = r3 instanceof javax.net.ssl.SSLHandshakeException
            if (r5 == 0) goto L_0x003c
            java.lang.Throwable r5 = r3.getCause()
            boolean r5 = r5 instanceof java.security.cert.CertificateException
            if (r5 == 0) goto L_0x003c
            goto L_0x0040
        L_0x003c:
            boolean r3 = r3 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r3 == 0) goto L_0x0042
        L_0x0040:
            r3 = 0
            goto L_0x0043
        L_0x0042:
            r3 = 1
        L_0x0043:
            if (r3 != 0) goto L_0x0046
            return r1
        L_0x0046:
            tb.g r3 = r4.f14996x
            if (r3 == 0) goto L_0x0050
            boolean r3 = r3.f14965f
            if (r3 != r0) goto L_0x0050
            r3 = 1
            goto L_0x0051
        L_0x0050:
            r3 = 0
        L_0x0051:
            if (r3 == 0) goto L_0x006e
            tb.h r3 = r4.f14988p
            xa.j.c(r3)
            tb.v r3 = r3.b()
            tb.g r4 = r4.f14996x
            if (r4 == 0) goto L_0x0065
            tb.r r4 = r4.c()
            goto L_0x0066
        L_0x0065:
            r4 = 0
        L_0x0066:
            boolean r3 = r3.a(r4)
            if (r3 == 0) goto L_0x006e
            r3 = 1
            goto L_0x006f
        L_0x006e:
            r3 = 0
        L_0x006f:
            if (r3 != 0) goto L_0x0072
            return r1
        L_0x0072:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ub.l.c(java.io.IOException, tb.o, pb.j1, boolean):boolean");
    }
}
