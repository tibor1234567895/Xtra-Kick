package tb;

import j0.h;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import ma.l;
import ma.q;
import ma.w;
import na.c;
import pb.a;
import pb.b0;
import pb.f1;
import pb.t0;
import pb.v1;
import qb.b;
import qb.f;
import ub.i;
import xa.j;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public final f1 f15027a;

    /* renamed from: b  reason: collision with root package name */
    public final a f15028b;

    /* renamed from: c  reason: collision with root package name */
    public final o f15029c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f15030d;

    /* renamed from: e  reason: collision with root package name */
    public h f15031e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f15032f;

    /* renamed from: g  reason: collision with root package name */
    public v1 f15033g;

    /* renamed from: h  reason: collision with root package name */
    public final l f15034h = new l();

    public v(f1 f1Var, a aVar, o oVar, i iVar) {
        j.f("client", f1Var);
        this.f15027a = f1Var;
        this.f15028b = aVar;
        this.f15029c = oVar;
        this.f15030d = !j.a(iVar.f15476e.f12885b, "GET");
    }

    public final boolean a(r rVar) {
        b0 b0Var;
        boolean z10;
        v1 v1Var;
        if ((!this.f15034h.isEmpty()) || this.f15033g != null) {
            return true;
        }
        if (rVar != null) {
            synchronized (rVar) {
                if (rVar.f15014n == 0) {
                    if (rVar.f15012l) {
                        if (qb.h.a(rVar.f15003c.f13006a.f12763i, this.f15028b.f12763i)) {
                            v1Var = rVar.f15003c;
                        }
                    }
                }
                v1Var = null;
            }
            if (v1Var != null) {
                this.f15033g = v1Var;
                return true;
            }
        }
        h hVar = this.f15031e;
        boolean z11 = false;
        if (hVar != null) {
            if (hVar.f8395h < ((List) hVar.f8396i).size()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                z11 = true;
            }
        }
        if (!z11 && (b0Var = this.f15032f) != null) {
            return b0Var.a();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final tb.z b() {
        /*
            r5 = this;
            tb.o r0 = r5.f15029c
            tb.r r0 = r0.f14989q
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0009
            goto L_0x005a
        L_0x0009:
            boolean r3 = r5.f15030d
            boolean r3 = r0.i(r3)
            monitor-enter(r0)
            if (r3 != 0) goto L_0x0015
            r0.f15012l = r1     // Catch:{ all -> 0x0085 }
            goto L_0x0028
        L_0x0015:
            boolean r3 = r0.f15012l     // Catch:{ all -> 0x0085 }
            if (r3 != 0) goto L_0x0028
            pb.v1 r3 = r0.f15003c     // Catch:{ all -> 0x0085 }
            pb.a r3 = r3.f13006a     // Catch:{ all -> 0x0085 }
            pb.t0 r3 = r3.f12763i     // Catch:{ all -> 0x0085 }
            boolean r3 = r5.f(r3)     // Catch:{ all -> 0x0085 }
            if (r3 != 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r3 = r2
            goto L_0x002e
        L_0x0028:
            tb.o r3 = r5.f15029c     // Catch:{ all -> 0x0085 }
            java.net.Socket r3 = r3.j()     // Catch:{ all -> 0x0085 }
        L_0x002e:
            monitor-exit(r0)
            tb.o r4 = r5.f15029c
            tb.r r4 = r4.f14989q
            if (r4 == 0) goto L_0x004e
            if (r3 != 0) goto L_0x0039
            r3 = 1
            goto L_0x003a
        L_0x0039:
            r3 = 0
        L_0x003a:
            if (r3 == 0) goto L_0x0042
            tb.w r3 = new tb.w
            r3.<init>(r0)
            goto L_0x005b
        L_0x0042:
            java.lang.String r0 = "Check failed."
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x004e:
            if (r3 == 0) goto L_0x0053
            qb.h.c(r3)
        L_0x0053:
            tb.o r0 = r5.f15029c
            pb.g0 r0 = r0.f14984l
            r0.getClass()
        L_0x005a:
            r3 = r2
        L_0x005b:
            if (r3 == 0) goto L_0x005e
            return r3
        L_0x005e:
            tb.w r0 = r5.e(r2, r2)
            if (r0 == 0) goto L_0x0065
            return r0
        L_0x0065:
            ma.l r0 = r5.f15034h
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x0077
            ma.l r0 = r5.f15034h
            java.lang.Object r0 = r0.j()
            tb.z r0 = (tb.z) r0
            return r0
        L_0x0077:
            tb.d r0 = r5.c()
            java.util.List r1 = r0.f14935e
            tb.w r1 = r5.e(r0, r1)
            if (r1 == 0) goto L_0x0084
            return r1
        L_0x0084:
            return r0
        L_0x0085:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.v.b():tb.z");
    }

    public final d c() {
        boolean z10;
        boolean z11;
        String str;
        int i10;
        boolean z12;
        boolean contains;
        List<InetAddress> list;
        String str2;
        boolean z13;
        v1 v1Var = this.f15033g;
        if (v1Var != null) {
            this.f15033g = null;
            return d(v1Var, (List) null);
        }
        h hVar = this.f15031e;
        if (hVar != null) {
            if (hVar.f8395h < ((List) hVar.f8396i).size()) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z13) {
                return d(hVar.k(), (List) null);
            }
        }
        b0 b0Var = this.f15032f;
        if (b0Var == null) {
            a aVar = this.f15028b;
            o oVar = this.f15029c;
            b0Var = new b0(aVar, oVar.f14980h.D, oVar, this.f15027a.f12826g, oVar.f14984l);
            this.f15032f = b0Var;
        }
        if (!b0Var.a()) {
            throw new IOException("exhausted all routes");
        } else if (b0Var.a()) {
            ArrayList arrayList = new ArrayList();
            do {
                if (b0Var.f14926g < b0Var.f14925f.size()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    break;
                }
                if (b0Var.f14926g < b0Var.f14925f.size()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                a aVar2 = b0Var.f14920a;
                if (z11) {
                    List list2 = b0Var.f14925f;
                    int i11 = b0Var.f14926g;
                    b0Var.f14926g = i11 + 1;
                    Proxy proxy = (Proxy) list2.get(i11);
                    ArrayList arrayList2 = new ArrayList();
                    b0Var.f14927h = arrayList2;
                    if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                        t0 t0Var = aVar2.f12763i;
                        str = t0Var.f12992d;
                        i10 = t0Var.f12993e;
                    } else {
                        SocketAddress address = proxy.address();
                        if (address instanceof InetSocketAddress) {
                            j.e("proxyAddress", address);
                            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                            b0.f14919j.getClass();
                            InetAddress address2 = inetSocketAddress.getAddress();
                            if (address2 == null) {
                                str = inetSocketAddress.getHostName();
                                str2 = "hostName";
                            } else {
                                str = address2.getHostAddress();
                                str2 = "address.hostAddress";
                            }
                            j.e(str2, str);
                            i10 = inetSocketAddress.getPort();
                        } else {
                            throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + address.getClass()).toString());
                        }
                    }
                    if (1 > i10 || i10 >= 65536) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    if (z12) {
                        if (proxy.type() == Proxy.Type.SOCKS) {
                            arrayList2.add(InetSocketAddress.createUnresolved(str, i10));
                        } else {
                            fb.l lVar = b.f13476a;
                            j.f("<this>", str);
                            if (b.f13476a.b(str)) {
                                list = q.b(InetAddress.getByName(str));
                            } else {
                                b0Var.f14924e.getClass();
                                j.f("call", b0Var.f14922c);
                                list = ((b0) aVar2.f12755a).a(str);
                                if (list.isEmpty()) {
                                    throw new UnknownHostException(aVar2.f12755a + " returned no addresses for " + str);
                                }
                            }
                            if (b0Var.f14923d && list.size() >= 2) {
                                ArrayList arrayList3 = new ArrayList();
                                ArrayList arrayList4 = new ArrayList();
                                for (Object next : list) {
                                    if (((InetAddress) next) instanceof Inet6Address) {
                                        arrayList3.add(next);
                                    } else {
                                        arrayList4.add(next);
                                    }
                                }
                                if (!arrayList3.isEmpty() && !arrayList4.isEmpty()) {
                                    byte[] bArr = f.f13487a;
                                    Iterator it = arrayList3.iterator();
                                    Iterator it2 = arrayList4.iterator();
                                    c cVar = new c();
                                    while (true) {
                                        if (!it.hasNext() && !it2.hasNext()) {
                                            break;
                                        }
                                        if (it.hasNext()) {
                                            cVar.add(it.next());
                                        }
                                        if (it2.hasNext()) {
                                            cVar.add(it2.next());
                                        }
                                    }
                                    q.a(cVar);
                                    list = cVar;
                                }
                            }
                            for (InetAddress inetSocketAddress2 : list) {
                                arrayList2.add(new InetSocketAddress(inetSocketAddress2, i10));
                            }
                        }
                        for (InetSocketAddress v1Var2 : b0Var.f14927h) {
                            v1 v1Var3 = new v1(b0Var.f14920a, proxy, v1Var2);
                            x xVar = b0Var.f14921b;
                            synchronized (xVar) {
                                contains = xVar.f15037a.contains(v1Var3);
                            }
                            if (contains) {
                                b0Var.f14928i.add(v1Var3);
                            } else {
                                arrayList.add(v1Var3);
                            }
                        }
                    } else {
                        throw new SocketException("No route to " + str + ':' + i10 + "; port is out of range");
                    }
                } else {
                    throw new SocketException("No route to " + aVar2.f12763i.f12992d + "; exhausted proxy configurations: " + b0Var.f14925f);
                }
            } while (!(!arrayList.isEmpty()));
            if (arrayList.isEmpty()) {
                w.k(b0Var.f14928i, arrayList);
                b0Var.f14928i.clear();
            }
            h hVar2 = new h(arrayList);
            this.f15031e = hVar2;
            if (!this.f15029c.f14995w) {
                return d(hVar2.k(), (List) hVar2.f8396i);
            }
            throw new IOException("Canceled");
        } else {
            throw new NoSuchElementException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final tb.d d(pb.v1 r13, java.util.List r14) {
        /*
            r12 = this;
            java.lang.String r0 = "route"
            xa.j.f(r0, r13)
            pb.a r0 = r13.f13006a
            javax.net.ssl.SSLSocketFactory r1 = r0.f12757c
            if (r1 != 0) goto L_0x003f
            java.util.List r0 = r0.f12765k
            pb.t r1 = pb.t.f12982f
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0037
            pb.a r0 = r13.f13006a
            pb.t0 r0 = r0.f12763i
            java.lang.String r0 = r0.f12992d
            xb.r r1 = xb.s.f16851a
            r1.getClass()
            xb.s r1 = xb.s.f16852b
            boolean r1 = r1.h(r0)
            if (r1 == 0) goto L_0x0029
            goto L_0x0049
        L_0x0029:
            java.net.UnknownServiceException r13 = new java.net.UnknownServiceException
            java.lang.String r14 = "CLEARTEXT communication to "
            java.lang.String r1 = " not permitted by network security policy"
            java.lang.String r14 = android.support.v4.media.h.n(r14, r0, r1)
            r13.<init>(r14)
            throw r13
        L_0x0037:
            java.net.UnknownServiceException r13 = new java.net.UnknownServiceException
            java.lang.String r14 = "CLEARTEXT communication not enabled for client"
            r13.<init>(r14)
            throw r13
        L_0x003f:
            java.util.List r0 = r0.f12764j
            pb.h1 r1 = pb.h1.H2_PRIOR_KNOWLEDGE
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x00f2
        L_0x0049:
            java.net.Proxy r0 = r13.f13007b
            java.net.Proxy$Type r0 = r0.type()
            java.net.Proxy$Type r1 = java.net.Proxy.Type.HTTP
            r2 = 1
            if (r0 == r1) goto L_0x0055
            goto L_0x0066
        L_0x0055:
            pb.a r0 = r13.f13006a
            javax.net.ssl.SSLSocketFactory r1 = r0.f12757c
            if (r1 != 0) goto L_0x0068
            java.util.List r0 = r0.f12764j
            pb.h1 r1 = pb.h1.H2_PRIOR_KNOWLEDGE
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            r0 = 0
            goto L_0x0069
        L_0x0068:
            r0 = 1
        L_0x0069:
            r1 = 0
            if (r0 == 0) goto L_0x00e0
            pb.i1 r0 = new pb.i1
            r0.<init>()
            pb.a r3 = r13.f13006a
            pb.t0 r3 = r3.f12763i
            java.lang.String r4 = "url"
            xa.j.f(r4, r3)
            r0.f12876a = r3
            java.lang.String r3 = "CONNECT"
            r0.d(r3, r1)
            pb.a r1 = r13.f13006a
            pb.t0 r3 = r1.f12763i
            java.lang.String r2 = qb.h.k(r3, r2)
            java.lang.String r3 = "Host"
            r0.c(r3, r2)
            java.lang.String r2 = "Proxy-Connection"
            java.lang.String r3 = "Keep-Alive"
            r0.c(r2, r3)
            java.lang.String r2 = "User-Agent"
            java.lang.String r3 = "okhttp/5.0.0-alpha.11"
            r0.c(r2, r3)
            pb.j1 r2 = new pb.j1
            r2.<init>(r0)
            pb.q1 r0 = new pb.q1
            r0.<init>()
            r0.e(r2)
            pb.h1 r3 = pb.h1.HTTP_1_1
            r0.d(r3)
            r3 = 407(0x197, float:5.7E-43)
            r0.f12936c = r3
            java.lang.String r3 = "Preemptive Authenticate"
            r0.c(r3)
            r3 = -1
            r0.f12944k = r3
            r0.f12945l = r3
            pb.n0 r3 = r0.f12939f
            r3.getClass()
            java.lang.String r4 = "Proxy-Authenticate"
            hb.h0.N0(r4)
            java.lang.String r5 = "OkHttp-Preemptive"
            hb.h0.O0(r5, r4)
            r3.c(r4)
            hb.h0.C(r3, r4, r5)
            pb.r1 r0 = r0.a()
            pb.d r1 = r1.f12760f
            pb.j1 r1 = r1.a(r13, r0)
            if (r1 != 0) goto L_0x00e0
            r9 = r2
            goto L_0x00e1
        L_0x00e0:
            r9 = r1
        L_0x00e1:
            tb.d r0 = new tb.d
            pb.f1 r3 = r12.f15027a
            tb.o r4 = r12.f15029c
            r8 = 0
            r10 = -1
            r11 = 0
            r2 = r0
            r5 = r12
            r6 = r13
            r7 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x00f2:
            java.net.UnknownServiceException r13 = new java.net.UnknownServiceException
            java.lang.String r14 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.v.d(pb.v1, java.util.List):tb.d");
    }

    public final w e(d dVar, List list) {
        boolean z10;
        r rVar;
        boolean z11;
        Socket j10;
        boolean z12;
        u uVar = this.f15027a.f12821b.f12933a;
        boolean z13 = this.f15030d;
        a aVar = this.f15028b;
        o oVar = this.f15029c;
        if (dVar == null || !dVar.b()) {
            z10 = false;
        } else {
            z10 = true;
        }
        uVar.getClass();
        j.f("address", aVar);
        j.f("call", oVar);
        Iterator it = uVar.f15026e.iterator();
        while (true) {
            if (!it.hasNext()) {
                rVar = null;
                break;
            }
            rVar = (r) it.next();
            j.e("connection", rVar);
            synchronized (rVar) {
                if (z10) {
                    if (rVar.f15011k != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (!z12) {
                        z11 = false;
                    }
                }
                if (rVar.f(aVar, list)) {
                    oVar.b(rVar);
                    z11 = true;
                }
                z11 = false;
            }
            if (z11) {
                if (rVar.i(z13)) {
                    break;
                }
                synchronized (rVar) {
                    rVar.f15012l = true;
                    j10 = oVar.j();
                }
                if (j10 != null) {
                    qb.h.c(j10);
                }
            }
        }
        if (rVar == null) {
            return null;
        }
        if (dVar != null) {
            this.f15033g = dVar.f14934d;
            Socket socket = dVar.f14943m;
            if (socket != null) {
                qb.h.c(socket);
            }
        }
        this.f15029c.f14984l.getClass();
        return new w(rVar);
    }

    public final boolean f(t0 t0Var) {
        j.f("url", t0Var);
        t0 t0Var2 = this.f15028b.f12763i;
        if (t0Var.f12993e != t0Var2.f12993e || !j.a(t0Var.f12992d, t0Var2.f12992d)) {
            return false;
        }
        return true;
    }
}
