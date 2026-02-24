package h3;

import android.os.RemoteException;
import android.support.v4.media.h;
import com.github.andreyasadchy.xtra.ui.player.PlaybackService;
import com.woxthebox.draglistview.R;
import f3.a;
import fb.w;
import g1.a2;
import g1.b2;
import g1.d1;
import g1.e1;
import g1.g1;
import g1.h1;
import g1.i1;
import g1.j1;
import g1.k1;
import g1.q;
import g1.s0;
import g1.u1;
import g1.v0;
import g1.y1;
import g1.z0;
import i1.d;
import j1.v;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m1.n0;
import m1.u;
import p0.c;
import q1.m;
import r1.n;
import r1.o;
import t6.r;
import xa.j;

public final class l2 implements i1 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7184h = 1;

    /* renamed from: i  reason: collision with root package name */
    public final Object f7185i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f7186j;

    public l2(PlaybackService playbackService, n0 n0Var) {
        this.f7185i = playbackService;
        this.f7186j = n0Var;
    }

    public final void A(float f10) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    w3 w3Var = b10.f7245r;
                    u3 g10 = h.g(w3Var, w3Var);
                    g10.f7352m = f10;
                    b10.f7245r = g10.a();
                    b10.f7230c.a(true, true);
                    try {
                        b10.f7234g.f7439i.getClass();
                        return;
                    } catch (RemoteException e10) {
                        v.d("MSImplBase", "Exception in using media1 API", e10);
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void B(d1 d1Var) {
        int i10 = this.f7184h;
        Object obj = this.f7186j;
        switch (i10) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) obj).get()) != null) {
                        w3 w3Var = b10.f7245r;
                        u3 g10 = h.g(w3Var, w3Var);
                        g10.f7340a = d1Var;
                        b10.f7245r = g10.a();
                        b10.f7230c.a(true, true);
                        try {
                            b10.f7234g.f7439i.j();
                            return;
                        } catch (RemoteException e10) {
                            v.d("MSImplBase", "Exception in using media1 API", e10);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                j.f("error", d1Var);
                if (((PlaybackService) this.f7185i).f3440w) {
                    ((n0) ((u) obj)).e();
                    return;
                }
                return;
        }
    }

    public final void D(y1 y1Var) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        w3 w3Var = b10.f7245r;
                        u3 g10 = h.g(w3Var, w3Var);
                        g10.D = y1Var;
                        b10.f7245r = g10.a();
                        b10.f7230c.a(true, true);
                        b10.d(new m1.v(2, y1Var));
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void F(int i10) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    a4 a4Var = (a4) ((WeakReference) this.f7186j).get();
                    if (a4Var != null) {
                        b10.f7245r = b10.f7245r.l(i10, a4Var.k());
                        b10.f7230c.a(true, true);
                        try {
                            v2 v2Var = b10.f7234g.f7439i;
                            a4Var.k();
                            v2Var.A();
                            return;
                        } catch (RemoteException e10) {
                            v.d("MSImplBase", "Exception in using media1 API", e10);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void G(long j10) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        w3 w3Var = b10.f7245r;
                        u3 g10 = h.g(w3Var, w3Var);
                        g10.B = j10;
                        b10.f7245r = g10.a();
                        b10.f7230c.a(true, true);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final /* synthetic */ void K(int i10, int i11) {
    }

    public final void L(int i10, s0 s0Var) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        w3 w3Var = b10.f7245r;
                        u3 g10 = h.g(w3Var, w3Var);
                        g10.f7341b = i10;
                        b10.f7245r = g10.a();
                        b10.f7230c.a(true, true);
                        try {
                            b10.f7234g.f7439i.h(s0Var);
                            return;
                        } catch (RemoteException e10) {
                            v.d("MSImplBase", "Exception in using media1 API", e10);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void N(e1 e1Var) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        b10.f7245r = b10.f7245r.k(e1Var);
                        b10.f7230c.a(true, true);
                        try {
                            b10.f7234g.f7439i.i();
                            return;
                        } catch (RemoteException e10) {
                            v.d("MSImplBase", "Exception in using media1 API", e10);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void O(g1 g1Var) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        b10.f7230c.a(false, false);
                        b10.d(new m1(g1Var));
                        b10.b(new c(14, b10));
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void P(a2 a2Var) {
        int i10;
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        w3 w3Var = b10.f7245r;
                        u3 g10 = h.g(w3Var, w3Var);
                        g10.C = a2Var;
                        b10.f7245r = g10.a();
                        b10.f7230c.a(true, false);
                        b10.d(new c(15, a2Var));
                        return;
                    }
                    return;
                }
                return;
            default:
                j.f("tracks", a2Var);
                if (!a2Var.f6289h.isEmpty() && PlaybackService.D && (i10 = PlaybackService.I) != -1) {
                    r rVar = PlaybackService.f3434y;
                    if (i10 != r.a(rVar)) {
                        ((PlaybackService) this.f7185i).o(r.c(rVar));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public final void Q(u1 u1Var, int i10) {
        Object obj;
        k1 b10;
        switch (this.f7184h) {
            case 0:
                n2 b11 = b();
                if (b11 != null) {
                    n2.a(b11);
                    a4 a4Var = (a4) ((WeakReference) this.f7186j).get();
                    if (a4Var != null) {
                        w3 w3Var = b11.f7245r;
                        i4 S0 = a4Var.S0();
                        u3 g10 = h.g(w3Var, w3Var);
                        g10.f7349j = u1Var;
                        g10.f7342c = S0;
                        b11.f7245r = g10.a();
                        b11.f7230c.a(false, true);
                        try {
                            b11.f7234g.f7439i.m(u1Var);
                            return;
                        } catch (RemoteException e10) {
                            v.d("MSImplBase", "Exception in using media1 API", e10);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                j.f("timeline", u1Var);
                PlaybackService playbackService = (PlaybackService) this.f7185i;
                g2 g2Var = playbackService.f3438u;
                m mVar = null;
                if (g2Var == null || (b10 = g2Var.b()) == null) {
                    obj = null;
                } else {
                    obj = b10.H0();
                }
                if (obj instanceof m) {
                    mVar = (m) obj;
                }
                if (PlaybackService.G.isEmpty() && mVar != null) {
                    o oVar = mVar.f13187a;
                    List<String> list = oVar.f13622b;
                    j.e("it.tags", list);
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    String string = playbackService.getString(R.string.audio_only);
                    j.e("getString(R.string.audio_only)", string);
                    Pattern compile = Pattern.compile("NAME=\"(.+?)\"");
                    int i11 = 0;
                    for (String str : list) {
                        j.e("tag", str);
                        if (w.m(str, "#EXT-X-MEDIA", false)) {
                            Matcher matcher = compile.matcher(str);
                            if (matcher.find()) {
                                String group = matcher.group(1);
                                j.c(group);
                                int i12 = i11 + 1;
                                String uri = ((n) oVar.f13612e.get(i11)).f13604a.toString();
                                j.e("it.variants[trackIndex++].url.toString()", uri);
                                if (w.m(group, "audio", true)) {
                                    group = string;
                                }
                                linkedHashMap.put(group, uri);
                                i11 = i12;
                            }
                        }
                    }
                    r rVar = PlaybackService.f3434y;
                    if (linkedHashMap.containsKey(string)) {
                        String str2 = (String) linkedHashMap.remove(string);
                        if (str2 != null) {
                            String str3 = (String) linkedHashMap.put(string, str2);
                        }
                    } else {
                        linkedHashMap.put(string, "");
                    }
                    PlaybackService.G = linkedHashMap;
                    LinkedList linkedList = new LinkedList(linkedHashMap.keySet());
                    if (PlaybackService.E) {
                        linkedList.addFirst(playbackService.getString(R.string.auto));
                    }
                    if (PlaybackService.F) {
                        linkedList.add(playbackService.getString(R.string.chat_only));
                    }
                    PlaybackService.H = linkedList;
                    PlaybackService.j(playbackService);
                    return;
                }
                return;
        }
    }

    public final void R(d dVar) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        u3 u3Var = new u3(b10.f7245r);
                        u3Var.f7354o = dVar;
                        b10.f7245r = u3Var.a();
                        b10.f7230c.a(true, true);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final /* synthetic */ void S(z0 z0Var) {
    }

    public final void V(b2 b2Var) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    w3 w3Var = b10.f7245r;
                    u3 g10 = h.g(w3Var, w3Var);
                    g10.f7350k = b2Var;
                    b10.f7245r = g10.a();
                    b10.f7230c.a(true, true);
                    try {
                        b10.f7234g.f7439i.getClass();
                        return;
                    } catch (RemoteException e10) {
                        v.d("MSImplBase", "Exception in using media1 API", e10);
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void X(q qVar) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        w3 w3Var = b10.f7245r;
                        u3 g10 = h.g(w3Var, w3Var);
                        g10.f7355p = qVar;
                        b10.f7245r = g10.a();
                        b10.f7230c.a(true, true);
                        try {
                            b10.f7234g.f7439i.l();
                            return;
                        } catch (RemoteException e10) {
                            v.d("MSImplBase", "Exception in using media1 API", e10);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void Y(boolean z10) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        w3 w3Var = b10.f7245r;
                        u3 g10 = h.g(w3Var, w3Var);
                        g10.f7360u = z10;
                        b10.f7245r = g10.a();
                        b10.f7230c.a(true, true);
                        try {
                            b10.f7234g.f7439i.y();
                        } catch (RemoteException e10) {
                            v.d("MSImplBase", "Exception in using media1 API", e10);
                        }
                        b10.k();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void a(int i10) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        w3 w3Var = b10.f7245r;
                        u3 g10 = h.g(w3Var, w3Var);
                        g10.f7347h = i10;
                        b10.f7245r = g10.a();
                        b10.f7230c.a(true, true);
                        try {
                            b10.f7234g.f7439i.a(i10);
                            return;
                        } catch (RemoteException e10) {
                            v.d("MSImplBase", "Exception in using media1 API", e10);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final n2 b() {
        return (n2) ((WeakReference) this.f7185i).get();
    }

    public final void c(g1.h hVar) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        w3 w3Var = b10.f7245r;
                        u3 g10 = h.g(w3Var, w3Var);
                        g10.f7353n = hVar;
                        b10.f7245r = g10.a();
                        b10.f7230c.a(true, true);
                        b10.b(new c(16, hVar));
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void e(v0 v0Var) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    w3 w3Var = b10.f7245r;
                    u3 g10 = h.g(w3Var, w3Var);
                    g10.f7351l = v0Var;
                    b10.f7245r = g10.a();
                    b10.f7230c.a(true, true);
                    try {
                        b10.f7234g.f7439i.e(v0Var);
                        return;
                    } catch (RemoteException e10) {
                        v.d("MSImplBase", "Exception in using media1 API", e10);
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void f(boolean z10) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        w3 w3Var = b10.f7245r;
                        u3 g10 = h.g(w3Var, w3Var);
                        g10.f7348i = z10;
                        b10.f7245r = g10.a();
                        b10.f7230c.a(true, true);
                        try {
                            b10.f7234g.f7439i.f(z10);
                            return;
                        } catch (RemoteException e10) {
                            v.d("MSImplBase", "Exception in using media1 API", e10);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void g(int i10, boolean z10) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        b10.f7245r = b10.f7245r.i(i10, z10);
                        b10.f7230c.a(true, true);
                        try {
                            b10.f7234g.f7439i.g(i10, z10);
                            return;
                        } catch (RemoteException e10) {
                            v.d("MSImplBase", "Exception in using media1 API", e10);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void h(int i10) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        w3 w3Var = b10.f7245r;
                        b10.f7245r = w3Var.j(w3Var.A, i10, w3Var.f7430z);
                        b10.f7230c.a(true, true);
                        try {
                            b10.f7234g.f7439i.B();
                            return;
                        } catch (RemoteException e10) {
                            v.d("MSImplBase", "Exception in using media1 API", e10);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void i(long j10) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        w3 w3Var = b10.f7245r;
                        u3 g10 = h.g(w3Var, w3Var);
                        g10.f7365z = j10;
                        b10.f7245r = g10.a();
                        b10.f7230c.a(true, true);
                        try {
                            b10.f7234g.f7439i.getClass();
                            return;
                        } catch (RemoteException e10) {
                            v.d("MSImplBase", "Exception in using media1 API", e10);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final /* synthetic */ void j(boolean z10) {
    }

    public final /* synthetic */ void k(int i10) {
    }

    public final /* synthetic */ void l(k1 k1Var, h1 h1Var) {
    }

    public final void m(long j10) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        w3 w3Var = b10.f7245r;
                        u3 g10 = h.g(w3Var, w3Var);
                        g10.A = j10;
                        b10.f7245r = g10.a();
                        b10.f7230c.a(true, true);
                        try {
                            b10.f7234g.f7439i.getClass();
                            return;
                        } catch (RemoteException e10) {
                            v.d("MSImplBase", "Exception in using media1 API", e10);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void n(int i10, j1 j1Var, j1 j1Var2) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        w3 w3Var = b10.f7245r;
                        u3 g10 = h.g(w3Var, w3Var);
                        g10.f7343d = j1Var;
                        g10.f7344e = j1Var2;
                        g10.f7345f = i10;
                        b10.f7245r = g10.a();
                        b10.f7230c.a(true, true);
                        try {
                            b10.f7234g.f7439i.p();
                            return;
                        } catch (RemoteException e10) {
                            v.d("MSImplBase", "Exception in using media1 API", e10);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void q(boolean z10) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        w3 w3Var = b10.f7245r;
                        u3 g10 = h.g(w3Var, w3Var);
                        g10.f7361v = z10;
                        b10.f7245r = g10.a();
                        b10.f7230c.a(true, true);
                        try {
                            b10.f7234g.f7439i.getClass();
                        } catch (RemoteException e10) {
                            v.d("MSImplBase", "Exception in using media1 API", e10);
                        }
                        b10.k();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void r() {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    b10.d(new a(19));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final /* synthetic */ void s() {
    }

    public final void t(v0 v0Var) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        w3 w3Var = b10.f7245r;
                        u3 g10 = h.g(w3Var, w3Var);
                        g10.f7364y = v0Var;
                        b10.f7245r = g10.a();
                        b10.f7230c.a(true, true);
                        try {
                            b10.f7234g.f7439i.C();
                            return;
                        } catch (RemoteException e10) {
                            v.d("MSImplBase", "Exception in using media1 API", e10);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final /* synthetic */ void u(d1 d1Var) {
    }

    public final /* synthetic */ void v(boolean z10) {
    }

    public final /* synthetic */ void x(List list) {
    }

    public final /* synthetic */ void y(int i10, boolean z10) {
    }

    public final void z(int i10, boolean z10) {
        switch (this.f7184h) {
            case 0:
                n2 b10 = b();
                if (b10 != null) {
                    n2.a(b10);
                    if (((a4) ((WeakReference) this.f7186j).get()) != null) {
                        w3 w3Var = b10.f7245r;
                        b10.f7245r = w3Var.j(i10, w3Var.D, z10);
                        b10.f7230c.a(true, true);
                        try {
                            b10.f7234g.f7439i.z();
                            return;
                        } catch (RemoteException e10) {
                            v.d("MSImplBase", "Exception in using media1 API", e10);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public l2(n2 n2Var, a4 a4Var) {
        this.f7185i = new WeakReference(n2Var);
        this.f7186j = new WeakReference(a4Var);
    }
}
