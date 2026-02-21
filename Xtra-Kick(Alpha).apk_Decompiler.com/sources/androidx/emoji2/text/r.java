package androidx.emoji2.text;

import android.content.ContextWrapper;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import androidx.appcompat.widget.j3;
import androidx.fragment.app.c2;
import androidx.fragment.app.g2;
import androidx.fragment.app.h2;
import androidx.fragment.app.i;
import androidx.fragment.app.n;
import androidx.fragment.app.x1;
import b2.y;
import d9.i2;
import d9.o0;
import d9.p0;
import d9.r0;
import d9.r1;
import g1.k1;
import h3.b0;
import h3.b3;
import h3.c0;
import h3.f2;
import h3.f4;
import h3.h4;
import h3.n2;
import h3.q3;
import h3.s3;
import h3.u1;
import h3.y1;
import h9.b;
import h9.e0;
import h9.k0;
import h9.p;
import h9.w;
import j1.l0;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import l.a;
import m1.a1;
import m1.h;
import m1.j1;
import m1.n0;
import n1.u;
import n1.x;
import p1.q;
import v1.a0;
import v1.f0;
import v1.g0;
import xa.j;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1276h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1277i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f1278j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f1279k;

    public /* synthetic */ r(Object obj, Object obj2, Object obj3, int i10) {
        this.f1276h = i10;
        this.f1277i = obj;
        this.f1278j = obj2;
        this.f1279k = obj3;
    }

    public final void run() {
        h4 h4Var;
        h4 h4Var2;
        f4 f4Var = null;
        switch (this.f1276h) {
            case 0:
                a aVar = (a) this.f1277i;
                n nVar = (n) this.f1278j;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f1279k;
                aVar.getClass();
                try {
                    a0 a10 = f.a(aVar.f9431a);
                    if (a10 != null) {
                        z zVar = (z) a10.f1261a;
                        synchronized (zVar.f1304d) {
                            zVar.f1306f = threadPoolExecutor;
                        }
                        a10.f1261a.a(new s(nVar, threadPoolExecutor));
                        return;
                    }
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                } catch (Throwable th) {
                    nVar.a(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 1:
                List list = (List) this.f1277i;
                h2 h2Var = (h2) this.f1278j;
                c2 c2Var = n.f1505f;
                j.f("$awaitingContainerChanges", list);
                j.f("$operation", h2Var);
                j.f("this$0", (n) this.f1279k);
                if (list.contains(h2Var)) {
                    list.remove(h2Var);
                    View view = h2Var.f1455c.M;
                    g2 g2Var = h2Var.f1453a;
                    j.e("view", view);
                    g2Var.a(view);
                    return;
                }
                return;
            case 2:
                Rect rect = (Rect) this.f1279k;
                c2 c2Var2 = n.f1505f;
                j.f("$impl", (x1) this.f1277i);
                j.f("$lastInEpicenterRect", rect);
                x1.g((View) this.f1278j, rect);
                return;
            case 3:
                n nVar2 = (n) this.f1277i;
                i iVar = (i) this.f1279k;
                j.f("this$0", nVar2);
                j.f("$animationInfo", iVar);
                nVar2.f1506a.endViewTransition((View) this.f1278j);
                iVar.b();
                return;
            case 4:
                e0 e0Var = (e0) this.f1277i;
                k0 k0Var = (k0) this.f1278j;
                p pVar = (p) this.f1279k;
                int i10 = l0.f8453a;
                try {
                    try {
                        k0Var.o(pVar.apply(w.b(e0Var)));
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (CancellationException unused) {
                    k0Var.cancel(false);
                    return;
                } catch (ExecutionException e10) {
                    th = e10;
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        th = cause;
                    }
                    k0Var.m(th);
                    return;
                } catch (Error | RuntimeException e11) {
                    th = e11;
                    k0Var.m(th);
                    return;
                }
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                k0 k0Var2 = (k0) this.f1277i;
                Runnable runnable = (Runnable) this.f1278j;
                Object obj = this.f1279k;
                int i11 = l0.f8453a;
                try {
                    if (!(k0Var2.f7762h instanceof b)) {
                        runnable.run();
                        k0Var2.l(obj);
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    k0Var2.m(th3);
                    return;
                }
            case 6:
                a1 a1Var = (a1) this.f1277i;
                a0 a0Var = (a0) this.f1279k;
                a1Var.getClass();
                r1 e12 = ((o0) this.f1278j).e();
                x xVar = (x) a1Var.f10176c;
                k1 k1Var = xVar.f11003n;
                k1Var.getClass();
                j3 j3Var = xVar.f11000k;
                j3Var.getClass();
                j3Var.f895b = r0.j(e12);
                if (!e12.isEmpty()) {
                    j3Var.f898e = (a0) e12.get(0);
                    a0Var.getClass();
                    j3Var.f899f = a0Var;
                }
                if (((a0) j3Var.f897d) == null) {
                    j3Var.f897d = j3.d(k1Var, (r0) j3Var.f895b, (a0) j3Var.f898e, (g1.r1) j3Var.f894a);
                }
                j3Var.i(k1Var.j0());
                return;
            case 7:
                Pair pair = (Pair) this.f1278j;
                n1.a aVar2 = ((j1) ((android.support.v4.media.n) this.f1277i).f338j).f10302h;
                x xVar2 = (x) aVar2;
                xVar2.H(((Integer) pair.first).intValue(), (a0) pair.second, (Exception) this.f1279k);
                return;
            case 8:
                android.support.v4.media.n nVar3 = (android.support.v4.media.n) this.f1277i;
                int i12 = l0.f8453a;
                ((m1.k0) nVar3.f338j).getClass();
                n0 n0Var = ((m1.k0) nVar3.f338j).f10314h;
                n0Var.getClass();
                x xVar3 = (x) n0Var.f10394r;
                n1.b c02 = xVar3.c0();
                xVar3.d0(c02, 1009, new u(c02, (g1.a0) this.f1278j, (h) this.f1279k, 1));
                return;
            case 9:
                q qVar = (q) this.f1277i;
                ((p1.r) this.f1278j).H(qVar.f12505a, qVar.f12506b, (Exception) this.f1279k);
                return;
            case 10:
                f0 f0Var = (f0) this.f1277i;
                ((g0) this.f1278j).d(f0Var.f15618a, f0Var.f15619b, (v1.w) this.f1279k);
                return;
            case 11:
                android.support.v4.media.h.y(((android.support.v4.media.n) this.f1277i).f338j);
                int i13 = w1.a.f16040k;
                throw null;
            case 12:
                b2.x xVar4 = (b2.x) this.f1277i;
                xVar4.getClass();
                int i14 = l0.f8453a;
                y yVar = xVar4.f2512b;
                yVar.getClass();
                n0 n0Var2 = ((m1.k0) yVar).f10314h;
                n0Var2.getClass();
                x xVar5 = (x) n0Var2.f10394r;
                n1.b c03 = xVar5.c0();
                xVar5.d0(c03, 1017, new u(c03, (g1.a0) this.f1278j, (h) this.f1279k, 0));
                return;
            case 13:
                b0 b0Var = (b0) this.f1278j;
                String str = (String) this.f1279k;
                ((y1) this.f1277i).getClass();
                b0Var.U0();
                if (!b0Var.P0()) {
                    h4Var = h4.f7075i;
                } else {
                    h4Var = b0Var.f6924c.I0();
                }
                i2 g10 = h4Var.f7078h.iterator();
                while (true) {
                    if (g10.hasNext()) {
                        f4 f4Var2 = (f4) g10.next();
                        if (f4Var2.f7034h == 0 && f4Var2.f7035i.equals(str)) {
                            f4Var = f4Var2;
                        }
                    }
                }
                if (f4Var != null) {
                    b0Var.U0();
                    if (!b0Var.P0()) {
                        h4Var2 = h4.f7075i;
                    } else {
                        h4Var2 = b0Var.f6924c.I0();
                    }
                    h4Var2.getClass();
                    if (h4Var2.f7078h.contains(f4Var)) {
                        w.a(b0Var.T0(f4Var, Bundle.EMPTY), new u1(str), h9.q.f7765h);
                        return;
                    }
                    return;
                }
                return;
            case 14:
                b3 b3Var = (b3) this.f1277i;
                y1 y1Var = (y1) this.f1278j;
                h3.g2 g2Var2 = (h3.g2) this.f1279k;
                int i15 = b3.f6933o;
                b3Var.getClass();
                HashMap hashMap = y1Var.f7485g;
                if (!hashMap.containsKey(g2Var2)) {
                    HashMap hashMap2 = y1Var.f7486h;
                    p0 p0Var = r0.f4657i;
                    hashMap2.put(g2Var2, r1.f4658l);
                    b3 b3Var2 = y1Var.f7479a;
                    h3.x1 x1Var = new h3.x1(b3Var2, g2Var2, hashMap2);
                    j3 j3Var2 = new j3((ContextWrapper) b3Var2, g2Var2.f7047a.f7236i);
                    j3Var2.f897d = x1Var;
                    Looper mainLooper = Looper.getMainLooper();
                    mainLooper.getClass();
                    j3Var2.f898e = mainLooper;
                    c0 c10 = j3Var2.c();
                    hashMap.put(g2Var2, c10);
                    c10.a(new v1.c0(y1Var, c10, x1Var, g2Var2, 2), y1Var.f7483e);
                }
                g2Var2.f7047a.f7244q = new e.a(b3Var);
                return;
            case 15:
                n2 n2Var = (n2) this.f1277i;
                q3 q3Var = (q3) this.f1278j;
                f2 f2Var = (f2) this.f1279k;
                int i16 = s3.f7316j;
                if (!n2Var.f()) {
                    q3Var.d(n2Var.f7246s, f2Var);
                    return;
                }
                return;
            default:
                j.f("this$0", (r3.g0) this.f1277i);
                j.f("$sql", (String) this.f1278j);
                j.f("$inputArguments", (List) this.f1279k);
                throw null;
        }
    }
}
