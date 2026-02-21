package t7;

import cc.f;
import cc.g;
import dc.m;
import e6.s0;
import e7.b;
import hb.f0;
import hb.h0;
import j9.v;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import kb.n;
import kb.o0;
import kb.t;
import ma.z;
import pa.e;
import pa.h;
import pb.d1;
import pb.e0;
import pb.f1;
import pb.g0;
import pb.h1;
import pb.i1;
import pb.j1;
import pb.r1;
import tb.o;
import xa.j;

public final class k {

    /* renamed from: k  reason: collision with root package name */
    public static final c f14701k = new c(0);

    /* renamed from: a  reason: collision with root package name */
    public final String f14702a;

    /* renamed from: b  reason: collision with root package name */
    public final String f14703b;

    /* renamed from: c  reason: collision with root package name */
    public final f1 f14704c;

    /* renamed from: d  reason: collision with root package name */
    public final f0 f14705d;

    /* renamed from: e  reason: collision with root package name */
    public final s0 f14706e;

    /* renamed from: f  reason: collision with root package name */
    public final b f14707f;

    /* renamed from: g  reason: collision with root package name */
    public g f14708g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14709h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14710i;

    /* renamed from: j  reason: collision with root package name */
    public int f14711j = 30;

    public k(String str, String str2, f1 f1Var, f0 f0Var, s0 s0Var, b bVar) {
        this.f14702a = str;
        this.f14703b = str2;
        this.f14704c = f1Var;
        this.f14705d = f0Var;
        this.f14706e = s0Var;
        this.f14707f = bVar;
    }

    public static final void a(k kVar) {
        if (kVar.f14709h) {
            kVar.c(2, new v());
            h0.b1(kVar.f14705d, (h) null, 0, new n(new t(new o0(new j(kVar, (e) null)), new g(0, kVar, (e) null)), (e) null), 3);
        }
    }

    public final void b() {
        boolean z10;
        i1 i1Var = new i1();
        i1Var.g("wss://ws-us2.pusher.com/app/" + this.f14703b + "?protocol=7&client=js&version=7.6.0&flash=false");
        j1 j1Var = new j1(i1Var);
        f fVar = new f(this);
        f1 f1Var = this.f14704c;
        f1Var.getClass();
        g gVar = new g(f1Var.E, j1Var, fVar, new Random(), (long) f1Var.B, f1Var.C);
        j1 j1Var2 = gVar.f3093a;
        if (j1Var2.b("Sec-WebSocket-Extensions") != null) {
            gVar.c(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), (r1) null);
        } else {
            d1 d1Var = new d1(f1Var);
            e0 e0Var = g0.f12862a;
            j.f("eventListener", e0Var);
            d1Var.f12792e = new b(5, (Object) e0Var);
            List list = g.f3092x;
            j.f("protocols", list);
            ArrayList K = z.K(list);
            h1 h1Var = h1.H2_PRIOR_KNOWLEDGE;
            boolean z11 = false;
            if (K.contains(h1Var) || K.contains(h1.HTTP_1_1)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                if (!K.contains(h1Var) || K.size() <= 1) {
                    z11 = true;
                }
                if (!z11) {
                    throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + K).toString());
                } else if (!(!K.contains(h1.HTTP_1_0))) {
                    throw new IllegalArgumentException(("protocols must not contain http/1.0: " + K).toString());
                } else if (!K.contains((Object) null)) {
                    K.remove(h1.SPDY_3);
                    if (!j.a(K, d1Var.f12807t)) {
                        d1Var.D = null;
                    }
                    List unmodifiableList = Collections.unmodifiableList(K);
                    j.e("unmodifiableList(protocolsCopy)", unmodifiableList);
                    d1Var.f12807t = unmodifiableList;
                    f1 f1Var2 = new f1(d1Var);
                    i1 i1Var2 = new i1(j1Var2);
                    i1Var2.c("Upgrade", "websocket");
                    i1Var2.c("Connection", "Upgrade");
                    i1Var2.c("Sec-WebSocket-Key", gVar.f3099g);
                    i1Var2.c("Sec-WebSocket-Version", "13");
                    i1Var2.c("Sec-WebSocket-Extensions", "permessage-deflate");
                    j1 j1Var3 = new j1(i1Var2);
                    o oVar = new o(f1Var2, j1Var3, true);
                    gVar.f3100h = oVar;
                    oVar.d(new f(gVar, j1Var3));
                } else {
                    throw new IllegalArgumentException("protocols must not contain null".toString());
                }
            } else {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + K).toString());
            }
        }
        this.f14708g = gVar;
    }

    public final void c(int i10, v vVar) {
        q0.f.j("eventType", i10);
        String str = "{\"event\":\"" + q0.f.c(i10) + "\", \"data\":" + vVar + "}";
        g gVar = this.f14708g;
        if (gVar != null) {
            String str2 = str + System.getProperty("line.separator");
            j.f("text", str2);
            dc.n.f4802k.getClass();
            dc.n b10 = m.b(str2);
            synchronized (gVar) {
                if (!gVar.f3113u) {
                    if (!gVar.f3110r) {
                        long j10 = gVar.f3109q;
                        byte[] bArr = b10.f4804h;
                        if (((long) bArr.length) + j10 > 16777216) {
                            gVar.b(1001, (String) null);
                        } else {
                            gVar.f3109q = j10 + ((long) bArr.length);
                            gVar.f3108p.add(new cc.e(b10));
                            gVar.h();
                        }
                    }
                }
            }
        }
    }
}
