package android.support.v4.media;

import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.WindowInsetsAnimation;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.p0;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.recyclerview.widget.a3;
import androidx.recyclerview.widget.q1;
import androidx.recyclerview.widget.z2;
import b4.u;
import b5.h;
import b5.j;
import com.bumptech.glide.load.data.d;
import d2.k;
import d2.x0;
import d2.y;
import d5.f;
import d5.g;
import d5.t0;
import d9.r0;
import f3.d0;
import f3.e0;
import f3.j0;
import g1.z;
import g2.a;
import h3.y0;
import h5.q0;
import i0.e;
import j1.b0;
import j1.f0;
import j1.h0;
import j1.l0;
import j1.o;
import j1.p;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m1.d1;
import m1.e1;
import m1.f1;
import m1.g1;
import m1.i1;
import m1.j1;
import m1.k0;
import m1.n1;
import o3.t;
import p1.r;
import r3.n0;
import v1.a0;
import v1.g0;
import v1.w;
import w0.b;
import w0.c;

public final class n implements g0, r, a2.r, k, d0, t, e, h, d {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f336h;

    /* renamed from: i  reason: collision with root package name */
    public Object f337i;

    /* renamed from: j  reason: collision with root package name */
    public Object f338j;

    public n() {
        this.f336h = 11;
        this.f337i = new HashSet();
    }

    public final void A(int i10, int i11, int i12, int i13) {
        ((CardView) this.f338j).f1160k.set(i10, i11, i12, i13);
        Object obj = this.f338j;
        n.super.setPadding(i10 + ((CardView) obj).f1159j.left, i11 + ((CardView) obj).f1159j.top, i12 + ((CardView) obj).f1159j.right, i13 + ((CardView) obj).f1159j.bottom);
    }

    public final void C(int i10, a0 a0Var) {
        Pair s10 = s(i10, a0Var);
        if (s10 != null) {
            ((f0) ((j1) this.f338j).f10303i).c(new f1(this, s10, 2));
        }
    }

    public final void E(int i10, a0 a0Var, int i11) {
        Pair s10 = s(i10, a0Var);
        if (s10 != null) {
            ((f0) ((j1) this.f338j).f10303i).c(new p((Object) this, (Object) s10, i11, 1));
        }
    }

    public final void H(int i10, a0 a0Var, Exception exc) {
        Pair s10 = s(i10, a0Var);
        if (s10 != null) {
            ((f0) ((j1) this.f338j).f10303i).c(new androidx.emoji2.text.r(this, s10, exc, 7));
        }
    }

    public final void I(int i10, a0 a0Var, v1.r rVar, w wVar) {
        Pair s10 = s(i10, a0Var);
        if (s10 != null) {
            ((f0) ((j1) this.f338j).f10303i).c(new e1(this, s10, rVar, wVar, 0));
        }
    }

    public final void J(int i10, a0 a0Var, v1.r rVar, w wVar, IOException iOException, boolean z10) {
        Pair s10 = s(i10, a0Var);
        if (s10 != null) {
            ((f0) ((j1) this.f338j).f10303i).c(new g1(this, s10, rVar, wVar, iOException, z10, 0));
        }
    }

    public final void M(int i10, a0 a0Var, v1.r rVar, w wVar) {
        Pair s10 = s(i10, a0Var);
        if (s10 != null) {
            ((f0) ((j1) this.f338j).f10303i).c(new e1(this, s10, rVar, wVar, 1));
        }
    }

    public final void T(int i10, a0 a0Var) {
        Pair s10 = s(i10, a0Var);
        if (s10 != null) {
            ((f0) ((j1) this.f338j).f10303i).c(new f1(this, s10, 1));
        }
    }

    public final void U(int i10, a0 a0Var) {
        Pair s10 = s(i10, a0Var);
        if (s10 != null) {
            ((f0) ((j1) this.f338j).f10303i).c(new f1(this, s10, 3));
        }
    }

    public final /* synthetic */ void W() {
    }

    public final void a(Preference preference) {
        ((PreferenceGroup) this.f337i).B(Integer.MAX_VALUE);
        o3.d0 d0Var = (o3.d0) this.f338j;
        Handler handler = d0Var.f12116e;
        androidx.activity.h hVar = d0Var.f12117f;
        handler.removeCallbacks(hVar);
        handler.post(hVar);
        ((PreferenceGroup) this.f337i).getClass();
    }

    public final void b(h0 h0Var, y yVar, j0 j0Var) {
    }

    public final void c(b0 b0Var) {
        if (b0Var.v() == 0 && (b0Var.v() & 128) != 0) {
            b0Var.H(6);
            int i10 = (b0Var.f8416c - b0Var.f8415b) / 4;
            for (int i11 = 0; i11 < i10; i11++) {
                j1.a0 a0Var = (j1.a0) this.f337i;
                b0Var.d(a0Var.f8405a, 0, 4);
                a0Var.k(0);
                int g10 = ((j1.a0) this.f337i).g(16);
                ((j1.a0) this.f337i).m(3);
                if (g10 == 0) {
                    ((j1.a0) this.f337i).m(13);
                } else {
                    int g11 = ((j1.a0) this.f337i).g(13);
                    if (((f3.h0) this.f338j).f5595g.get(g11) == null) {
                        f3.h0 h0Var = (f3.h0) this.f338j;
                        h0Var.f5595g.put(g11, new e0(new f3.g0(h0Var, g11)));
                        ((f3.h0) this.f338j).f5601m++;
                    }
                }
            }
            f3.h0 h0Var2 = (f3.h0) this.f338j;
            if (h0Var2.f5589a != 2) {
                h0Var2.f5595g.remove(0);
            }
        }
    }

    public final void d(int i10, a0 a0Var, w wVar) {
        Pair s10 = s(i10, a0Var);
        if (s10 != null) {
            ((f0) ((j1) this.f338j).f10303i).c(new d1(this, s10, wVar, 1));
        }
    }

    public final void e(Exception exc) {
        boolean z10;
        h5.h0 h0Var = (h5.h0) this.f337i;
        h5.h0 h0Var2 = ((t0) this.f338j).f4489m;
        if (h0Var2 == null || h0Var2 != h0Var) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            t0 t0Var = (t0) this.f338j;
            g gVar = t0Var.f4485i;
            f fVar = t0Var.f4490n;
            com.bumptech.glide.load.data.e eVar = ((h5.h0) this.f337i).f7577c;
            gVar.d(fVar, exc, eVar, eVar.d());
        }
    }

    public final void f() {
        ((u) this.f337i).cancel();
    }

    public final void g(Object obj) {
        boolean z10;
        h5.h0 h0Var = (h5.h0) this.f337i;
        h5.h0 h0Var2 = ((t0) this.f338j).f4489m;
        if (h0Var2 == null || h0Var2 != h0Var) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            t0 t0Var = (t0) this.f338j;
            h5.h0 h0Var3 = (h5.h0) this.f337i;
            d5.u uVar = t0Var.f4484h.f4407p;
            if (obj == null || !uVar.c(h0Var3.f7577c.d())) {
                g gVar = t0Var.f4485i;
                j jVar = h0Var3.f7575a;
                com.bumptech.glide.load.data.e eVar = h0Var3.f7577c;
                gVar.a(jVar, obj, eVar, eVar.d(), t0Var.f4490n);
                return;
            }
            t0Var.f4488l = obj;
            t0Var.f4485i.b();
        }
    }

    public final d2.j h(d2.w wVar, long j10) {
        int d10;
        long j11;
        long p10 = wVar.p();
        int min = (int) Math.min(20000, wVar.c() - p10);
        ((b0) this.f338j).D(min);
        wVar.m(((b0) this.f338j).f8414a, 0, min);
        b0 b0Var = (b0) this.f338j;
        int i10 = -1;
        long j12 = -9223372036854775807L;
        int i11 = -1;
        while (true) {
            int i12 = b0Var.f8416c;
            int i13 = b0Var.f8415b;
            if (i12 - i13 >= 4) {
                if (a.d(i13, b0Var.f8414a) != 442) {
                    b0Var.H(1);
                } else {
                    b0Var.H(4);
                    long c10 = f3.a0.c(b0Var);
                    if (c10 != -9223372036854775807L) {
                        long b10 = ((h0) this.f337i).b(c10);
                        if (b10 > j10) {
                            if (j12 == -9223372036854775807L) {
                                return new d2.j(-1, b10, p10);
                            }
                            j11 = (long) i11;
                        } else if (100000 + b10 > j10) {
                            j11 = (long) b0Var.f8415b;
                            break;
                        } else {
                            i11 = b0Var.f8415b;
                            j12 = b10;
                        }
                    }
                    int i14 = b0Var.f8416c;
                    if (i14 - b0Var.f8415b >= 10) {
                        b0Var.H(9);
                        int v10 = b0Var.v() & 7;
                        if (b0Var.f8416c - b0Var.f8415b >= v10) {
                            b0Var.H(v10);
                            int i15 = b0Var.f8416c;
                            int i16 = b0Var.f8415b;
                            if (i15 - i16 >= 4) {
                                if (a.d(i16, b0Var.f8414a) == 443) {
                                    b0Var.H(4);
                                    int A = b0Var.A();
                                    if (b0Var.f8416c - b0Var.f8415b >= A) {
                                        b0Var.H(A);
                                    }
                                }
                                while (true) {
                                    int i17 = b0Var.f8416c;
                                    int i18 = b0Var.f8415b;
                                    if (i17 - i18 < 4 || (d10 = a.d(i18, b0Var.f8414a)) == 442 || d10 == 441 || (d10 >>> 8) != 1) {
                                        break;
                                    }
                                    b0Var.H(4);
                                    if (b0Var.f8416c - b0Var.f8415b < 2) {
                                        break;
                                    }
                                    b0Var.G(Math.min(b0Var.f8416c, b0Var.f8415b + b0Var.A()));
                                }
                                i10 = b0Var.f8415b;
                            }
                        }
                    }
                    b0Var.G(i14);
                    i10 = b0Var.f8415b;
                }
            } else if (j12 != -9223372036854775807L) {
                return new d2.j(-2, j12, p10 + ((long) i10));
            } else {
                return d2.j.f4204d;
            }
        }
        return d2.j.a(p10 + j11);
    }

    public final void i() {
        b0 b0Var = (b0) this.f338j;
        byte[] bArr = l0.f8458f;
        b0Var.getClass();
        b0Var.E(bArr.length, bArr);
    }

    public final Object j(Uri uri, k1.j jVar) {
        u1.a aVar = (u1.a) ((a2.r) this.f337i).j(uri, jVar);
        List list = (List) this.f338j;
        return (list == null || list.isEmpty()) ? aVar : (u1.a) aVar.a((List) this.f338j);
    }

    public final int k(b5.f fVar) {
        switch (this.f336h) {
            case 24:
                try {
                    return fVar.d((ByteBuffer) this.f337i, (e5.k) this.f338j);
                } finally {
                    w5.a.c((ByteBuffer) this.f337i);
                }
            default:
                try {
                    return fVar.b((InputStream) this.f337i, (e5.k) this.f338j);
                } finally {
                    ((InputStream) this.f337i).reset();
                }
        }
    }

    public final boolean l(int i10) {
        return ((g1.y) this.f337i).f6716a.get(i10);
    }

    public final void m(y yVar, j0 j0Var) {
        boolean z10;
        for (int i10 = 0; i10 < ((x0[]) this.f338j).length; i10++) {
            j0Var.a();
            j0Var.b();
            x0 d10 = yVar.d(j0Var.f5630d, 3);
            g1.a0 a0Var = (g1.a0) ((List) this.f337i).get(i10);
            String str = a0Var.f6276s;
            if ("application/cea-608".equals(str) || "application/cea-708".equals(str)) {
                z10 = true;
            } else {
                z10 = false;
            }
            j1.a.a("Invalid closed caption mime type provided: " + str, z10);
            String str2 = a0Var.f6265h;
            if (str2 == null) {
                j0Var.b();
                str2 = j0Var.f5631e;
            }
            z zVar = new z();
            zVar.f6744a = str2;
            zVar.f6754k = str;
            zVar.f6747d = a0Var.f6268k;
            zVar.f6746c = a0Var.f6267j;
            zVar.C = a0Var.K;
            zVar.f6756m = a0Var.f6278u;
            d10.a(new g1.a0(zVar));
            ((x0[]) this.f338j)[i10] = d10;
        }
    }

    public final void n(m1.g gVar) {
        synchronized (gVar) {
        }
        Object obj = this.f337i;
        if (((Handler) obj) != null) {
            ((Handler) obj).post(new o1.d(this, gVar, 0));
        }
    }

    public final void o(int i10, a0 a0Var, w wVar) {
        Pair s10 = s(i10, a0Var);
        if (s10 != null) {
            ((f0) ((j1) this.f338j).f10303i).c(new d1(this, s10, wVar, 0));
        }
    }

    public final void p(int i10, a0 a0Var) {
        Pair s10 = s(i10, a0Var);
        if (s10 != null) {
            ((f0) ((j1) this.f338j).f10303i).c(new f1(this, s10, 0));
        }
    }

    public final View q(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        View view;
        p0 p0Var = (p0) ((a3) this.f337i);
        int i16 = p0Var.f1531h;
        Object obj = p0Var.f1532i;
        switch (i16) {
            case 0:
                i14 = ((q1) obj).getPaddingLeft();
                break;
            default:
                i14 = ((q1) obj).getPaddingTop();
                break;
        }
        int g10 = ((p0) ((a3) this.f337i)).g();
        if (i11 > i10) {
            i15 = 1;
        } else {
            i15 = -1;
        }
        View view2 = null;
        while (i10 != i11) {
            p0 p0Var2 = (p0) ((a3) this.f337i);
            int i17 = p0Var2.f1531h;
            Object obj2 = p0Var2.f1532i;
            switch (i17) {
                case 0:
                    view = ((q1) obj2).G(i10);
                    break;
                default:
                    view = ((q1) obj2).G(i10);
                    break;
            }
            int f10 = ((p0) ((a3) this.f337i)).f(view);
            int e10 = ((p0) ((a3) this.f337i)).e(view);
            Object obj3 = this.f338j;
            z2 z2Var = (z2) obj3;
            z2Var.f2274b = i14;
            z2Var.f2275c = g10;
            z2Var.f2276d = f10;
            z2Var.f2277e = e10;
            if (i12 != 0) {
                ((z2) obj3).f2273a = i12 | 0;
                if (((z2) obj3).a()) {
                    return view;
                }
            }
            if (i13 != 0) {
                Object obj4 = this.f338j;
                ((z2) obj4).f2273a = i13 | 0;
                if (((z2) obj4).a()) {
                    view2 = view;
                }
            }
            i10 += i15;
        }
        return view2;
    }

    public final synchronized ArrayList r(Class cls) {
        return ((q0) this.f337i).e(cls);
    }

    public final Pair s(int i10, a0 a0Var) {
        a0 a0Var2;
        a0 a0Var3 = null;
        if (a0Var != null) {
            i1 i1Var = (i1) this.f337i;
            int i11 = 0;
            while (true) {
                if (i11 >= i1Var.f10272c.size()) {
                    a0Var2 = null;
                    break;
                } else if (((a0) i1Var.f10272c.get(i11)).f6681d == a0Var.f6681d) {
                    Object obj = i1Var.f10271b;
                    int i12 = n1.f10403v;
                    a0Var2 = a0Var.b(Pair.create(obj, a0Var.f6678a));
                    break;
                } else {
                    i11++;
                }
            }
            if (a0Var2 == null) {
                return null;
            }
            a0Var3 = a0Var2;
        }
        return Pair.create(Integer.valueOf(i10 + ((i1) this.f337i).f10273d), a0Var3);
    }

    public final KeyListener t(KeyListener keyListener) {
        if (!(keyListener instanceof NumberKeyListener)) {
            return ((b) ((c) this.f338j).f16019c).a(keyListener);
        }
        return keyListener;
    }

    public final String toString() {
        switch (this.f336h) {
            case 6:
                return "Bounds{lower=" + ((e0.d) this.f337i) + " upper=" + ((e0.d) this.f338j) + "}";
            default:
                return super.toString();
        }
    }

    public final boolean u(View view) {
        int i10;
        z2 z2Var = (z2) this.f338j;
        p0 p0Var = (p0) ((a3) this.f337i);
        int i11 = p0Var.f1531h;
        Object obj = p0Var.f1532i;
        switch (i11) {
            case 0:
                i10 = ((q1) obj).getPaddingLeft();
                break;
            default:
                i10 = ((q1) obj).getPaddingTop();
                break;
        }
        int g10 = ((p0) ((a3) this.f337i)).g();
        int f10 = ((p0) ((a3) this.f337i)).f(view);
        int e10 = ((p0) ((a3) this.f337i)).e(view);
        z2Var.f2274b = i10;
        z2Var.f2275c = g10;
        z2Var.f2276d = f10;
        z2Var.f2277e = e10;
        Object obj2 = this.f338j;
        ((z2) obj2).f2273a = 24579 | 0;
        return ((z2) obj2).a();
    }

    /* JADX INFO: finally extract failed */
    public final void v(AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = ((EditText) this.f337i).getContext().obtainStyledAttributes(attributeSet, f.a.f5400j, i10, 0);
        try {
            boolean z10 = true;
            if (obtainStyledAttributes.hasValue(14)) {
                z10 = obtainStyledAttributes.getBoolean(14, true);
            }
            obtainStyledAttributes.recycle();
            ((b) ((c) this.f338j).f16019c).c(z10);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void w(int i10, a0 a0Var, v1.r rVar, w wVar) {
        Pair s10 = s(i10, a0Var);
        if (s10 != null) {
            ((f0) ((j1) this.f338j).f10303i).c(new e1(this, s10, rVar, wVar, 2));
        }
    }

    public final InputConnection x(InputConnection inputConnection, EditorInfo editorInfo) {
        c cVar = (c) this.f338j;
        if (inputConnection != null) {
            return ((b) cVar.f16019c).b(inputConnection, editorInfo);
        }
        cVar.getClass();
        return null;
    }

    public final void y(Exception exc, boolean z10) {
        int i10;
        this.f338j = null;
        r0 j10 = r0.j((Set) this.f337i);
        ((Set) this.f337i).clear();
        d9.p0 l10 = j10.listIterator(0);
        while (l10.hasNext()) {
            p1.e eVar = (p1.e) l10.next();
            eVar.getClass();
            if (z10) {
                i10 = 1;
            } else {
                i10 = 3;
            }
            eVar.k(i10, exc);
        }
    }

    public final void z(j0.f fVar) {
        boolean z10;
        int i10 = fVar.f8390b;
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            ((Handler) this.f338j).post(new i(this, (j0.j) this.f337i, fVar.f8389a, 1));
        } else {
            ((Handler) this.f338j).post(new c.f((Object) this, (Object) (j0.j) this.f337i, i10, 4));
        }
    }

    public n(int i10, int i11) {
        this.f336h = 4;
        this.f337i = new int[]{i10, i11};
        this.f338j = new float[]{0.0f, 1.0f};
    }

    public n(int i10, int i11, int i12) {
        this.f336h = 4;
        this.f337i = new int[]{i10, i11, i12};
        this.f338j = new float[]{0.0f, 0.5f, 1.0f};
    }

    public n(Handler handler, k0 k0Var) {
        this.f336h = 10;
        this.f337i = handler;
        this.f338j = k0Var;
    }

    public n(IBinder iBinder, Bundle bundle) {
        this.f336h = 0;
        this.f337i = new Messenger(iBinder);
        this.f338j = bundle;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public n(android.support.v4.media.session.u uVar) {
        this(new q0(uVar));
        this.f336h = 29;
    }

    public n(WindowInsetsAnimation.Bounds bounds) {
        this.f336h = 6;
        this.f337i = e0.d.c(bounds.getLowerBound());
        this.f338j = e0.d.c(bounds.getUpperBound());
    }

    public n(EditText editText) {
        this.f336h = 1;
        this.f337i = editText;
        this.f338j = new c(editText);
    }

    public n(TextView textView) {
        this.f336h = 2;
        textView.getClass();
        this.f337i = textView;
    }

    public n(CardView cardView) {
        this.f336h = 3;
        this.f338j = cardView;
    }

    public n(p0 p0Var) {
        this.f336h = 21;
        this.f337i = p0Var;
        this.f338j = new z2();
    }

    public n(f3.h0 h0Var) {
        this.f336h = 17;
        this.f338j = h0Var;
        this.f337i = new j1.a0(4, new byte[4]);
    }

    public n(g1.y yVar, SparseArray sparseArray) {
        this.f336h = 9;
        this.f337i = yVar;
        SparseArray sparseArray2 = new SparseArray(yVar.c());
        for (int i10 = 0; i10 < yVar.c(); i10++) {
            int b10 = yVar.b(i10);
            n1.b bVar = (n1.b) sparseArray.get(b10);
            bVar.getClass();
            sparseArray2.append(b10, bVar);
        }
        this.f338j = sparseArray2;
    }

    public n(y0 y0Var, Looper looper) {
        this.f336h = 18;
        this.f338j = y0Var;
        this.f337i = new Handler(looper, new o(1, this));
    }

    public n(q0 q0Var) {
        this.f336h = 29;
        this.f338j = new h5.l0();
        this.f337i = q0Var;
    }

    public n(h0 h0Var) {
        this.f336h = 15;
        this.f337i = h0Var;
        this.f338j = new b0();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(h0 h0Var, int i10) {
        this(h0Var);
        this.f336h = 15;
    }

    public /* synthetic */ n(Object obj, int i10, Object obj2) {
        this.f336h = i10;
        this.f337i = obj;
        this.f338j = obj2;
    }

    public /* synthetic */ n(Object obj, Object obj2, int i10) {
        this.f336h = i10;
        this.f338j = obj;
        this.f337i = obj2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(String str, Map map) {
        this((Object) str, 19, (Object) map);
        this.f336h = 19;
    }

    public n(ArrayList arrayList, ArrayList arrayList2) {
        this.f336h = 4;
        int size = arrayList.size();
        this.f337i = new int[size];
        this.f338j = new float[size];
        for (int i10 = 0; i10 < size; i10++) {
            ((int[]) this.f337i)[i10] = ((Integer) arrayList.get(i10)).intValue();
            ((float[]) this.f338j)[i10] = ((Float) arrayList2.get(i10)).floatValue();
        }
    }

    public n(List list) {
        this.f336h = 16;
        this.f337i = list;
        this.f338j = new x0[list.size()];
    }

    public n(n0 n0Var) {
        this.f336h = 22;
        xa.j.f("database", n0Var);
        this.f337i = n0Var;
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        xa.j.e("newSetFromMap(IdentityHashMap())", newSetFromMap);
        this.f338j = newSetFromMap;
    }
}
