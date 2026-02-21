package cc;

import cb.e;
import fb.v;
import fb.w;
import fb.y;
import java.io.IOException;
import pb.i;
import pb.j;
import pb.j1;
import pb.p0;
import pb.r1;
import qb.h;
import tb.g;
import tb.q;

public final class f implements j {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ g f3090h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ j1 f3091i;

    public f(g gVar, j1 j1Var) {
        this.f3090h = gVar;
        this.f3091i = j1Var;
    }

    public final void onFailure(i iVar, IOException iOException) {
        xa.j.f("call", iVar);
        this.f3090h.c(iOException, (r1) null);
    }

    public final void onResponse(i iVar, r1 r1Var) {
        boolean z10;
        String str;
        boolean z11;
        Integer num;
        boolean z12;
        Integer num2;
        r1 r1Var2 = r1Var;
        g gVar = r1Var2.f12973t;
        int i10 = 1;
        try {
            this.f3090h.a(r1Var2, gVar);
            q d10 = gVar.d();
            h hVar = i.f3116g;
            p0 p0Var = r1Var2.f12966m;
            hVar.getClass();
            xa.j.f("responseHeaders", p0Var);
            int i11 = 2;
            int length = p0Var.f12931h.length / 2;
            int i12 = 0;
            int i13 = 0;
            boolean z13 = false;
            boolean z14 = false;
            boolean z15 = false;
            Integer num3 = null;
            Integer num4 = null;
            boolean z16 = false;
            while (i13 < length) {
                if (w.g(p0Var.c(i13), "Sec-WebSocket-Extensions")) {
                    String f10 = p0Var.f(i13);
                    int i14 = 0;
                    while (i14 < f10.length()) {
                        int e10 = qb.f.e(f10, Constants.COMMA_CHAR, i14, i12, 4);
                        char c10 = ';';
                        int d11 = qb.f.d(f10, ';', i14, e10);
                        String o10 = qb.f.o(i14, d11, f10);
                        int i15 = d11 + i10;
                        if (w.g(o10, "permessage-deflate")) {
                            if (z13) {
                                z16 = true;
                            }
                            while (i15 < e10) {
                                int d12 = qb.f.d(f10, c10, i15, e10);
                                int d13 = qb.f.d(f10, '=', i15, d12);
                                String o11 = qb.f.o(i15, d13, f10);
                                if (d13 < d12) {
                                    str = qb.f.o(d13 + 1, d12, f10);
                                    if (str.length() >= i11 && y.H(str, "\"")) {
                                        if (w.f(str, "\"", false)) {
                                            str = str.substring(1, str.length() - 1);
                                            xa.j.e("this as java.lang.String…ing(startIndex, endIndex)", str);
                                        }
                                    }
                                } else {
                                    str = null;
                                }
                                int i16 = d12 + 1;
                                if (w.g(o11, "client_max_window_bits")) {
                                    if (num3 != null) {
                                        z16 = true;
                                    }
                                    if (str != null) {
                                        num2 = v.d(str);
                                    } else {
                                        num2 = null;
                                    }
                                    num3 = num2;
                                    if (num2 != null) {
                                        i15 = i16;
                                        i11 = 2;
                                        c10 = ';';
                                    }
                                } else {
                                    if (w.g(o11, "client_no_context_takeover")) {
                                        if (z14) {
                                            z16 = true;
                                        }
                                        if (str != null) {
                                            z12 = true;
                                        } else {
                                            z12 = z16;
                                        }
                                        z16 = z12;
                                        z14 = true;
                                    } else if (w.g(o11, "server_max_window_bits")) {
                                        if (num4 != null) {
                                            z16 = true;
                                        }
                                        if (str != null) {
                                            num = v.d(str);
                                        } else {
                                            num = null;
                                        }
                                        num4 = num;
                                        if (num != null) {
                                        }
                                    } else if (w.g(o11, "server_no_context_takeover")) {
                                        if (z15) {
                                            z16 = true;
                                        }
                                        if (str != null) {
                                            z11 = true;
                                        } else {
                                            z11 = z16;
                                        }
                                        z16 = z11;
                                        z15 = true;
                                    }
                                    i15 = i16;
                                    i11 = 2;
                                    c10 = ';';
                                }
                                z16 = true;
                                i15 = i16;
                                i11 = 2;
                                c10 = ';';
                            }
                            z13 = true;
                        } else {
                            z16 = true;
                        }
                        i14 = i15;
                        i10 = 1;
                        i11 = 2;
                        i12 = 0;
                    }
                }
                i13++;
                i10 = 1;
                i11 = 2;
                i12 = 0;
            }
            this.f3090h.f3097e = new i(z13, num3, z14, num4, z15, z16);
            if (!z16 && num3 == null && (num4 == null || new e(8, 15).b(num4.intValue()))) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                g gVar2 = this.f3090h;
                synchronized (gVar2) {
                    gVar2.f3108p.clear();
                    gVar2.b(1010, "unexpected Sec-WebSocket-Extensions in response header");
                }
            }
            try {
                this.f3090h.d(h.f13495c + " WebSocket " + this.f3091i.f12884a.g(), d10);
                g gVar3 = this.f3090h;
                gVar3.f3094b.c(gVar3, r1Var2);
                this.f3090h.e();
            } catch (Exception e11) {
                this.f3090h.c(e11, (r1) null);
            }
        } catch (IOException e12) {
            if (gVar != null) {
                gVar.a(true, true, (IOException) null);
            }
            this.f3090h.c(e12, r1Var2);
            qb.f.b(r1Var);
        }
    }
}
