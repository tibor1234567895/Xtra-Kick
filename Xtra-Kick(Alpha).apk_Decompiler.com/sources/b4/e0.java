package b4;

import a2.j;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.i5;
import b5.n;
import b8.g;
import b8.h;
import c8.a;
import com.bumptech.glide.i;
import com.bumptech.glide.manager.q;
import com.bumptech.glide.manager.u;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButtonToggleGroup;
import d5.b0;
import d5.c0;
import d5.f0;
import d5.o0;
import f5.k;
import h5.e;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.WeakHashMap;
import l0.b;
import m.m;
import m.o;
import m0.c1;
import m0.i0;
import m0.j0;
import m0.q2;
import m0.y;
import m8.v;
import n0.x;
import p5.c;
import x5.d;

public final class e0 implements d, e, b5.d, c, u, y, x, v, a, m {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f2537h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f2538i;

    public /* synthetic */ e0(int i10, Object obj) {
        this.f2537h = i10;
        this.f2538i = obj;
    }

    public static ByteArrayInputStream h(String str) {
        if (str.startsWith("data:image")) {
            int indexOf = str.indexOf(44);
            if (indexOf == -1) {
                throw new IllegalArgumentException("Missing comma in data URL.");
            } else if (str.substring(0, indexOf).endsWith(";base64")) {
                return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
            } else {
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        } else {
            throw new IllegalArgumentException("Not a valid image data URL.");
        }
    }

    public final q2 A(View view, q2 q2Var) {
        boolean z10;
        int i10 = this.f2537h;
        q2 q2Var2 = null;
        Object obj = this.f2538i;
        switch (i10) {
            case 17:
                AppBarLayout appBarLayout = (AppBarLayout) obj;
                appBarLayout.getClass();
                WeakHashMap weakHashMap = c1.f10054a;
                if (i0.b(appBarLayout)) {
                    q2Var2 = q2Var;
                }
                if (!b.a(appBarLayout.f3585n, q2Var2)) {
                    appBarLayout.f3585n = q2Var2;
                    if (appBarLayout.C == null || appBarLayout.getTopInset() <= 0) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    appBarLayout.setWillNotDraw(!z10);
                    appBarLayout.requestLayout();
                }
                return q2Var;
            case 18:
                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) obj;
                collapsingToolbarLayout.getClass();
                WeakHashMap weakHashMap2 = c1.f10054a;
                if (i0.b(collapsingToolbarLayout)) {
                    q2Var2 = q2Var;
                }
                if (!b.a(collapsingToolbarLayout.H, q2Var2)) {
                    collapsingToolbarLayout.H = q2Var2;
                    collapsingToolbarLayout.requestLayout();
                }
                return q2Var.f10131a.c();
            default:
                h hVar = (h) obj;
                g gVar = hVar.f2686s;
                if (gVar != null) {
                    hVar.f2679l.W.remove(gVar);
                }
                g gVar2 = new g(hVar.f2682o, q2Var);
                hVar.f2686s = gVar2;
                gVar2.e(hVar.getWindow());
                BottomSheetBehavior bottomSheetBehavior = hVar.f2679l;
                g gVar3 = hVar.f2686s;
                ArrayList arrayList = bottomSheetBehavior.W;
                if (!arrayList.contains(gVar3)) {
                    arrayList.add(gVar3);
                }
                return q2Var;
        }
    }

    public final q2 a(View view, q2 q2Var, j jVar) {
        int i10;
        jVar.f58d = q2Var.b() + jVar.f58d;
        WeakHashMap weakHashMap = c1.f10054a;
        boolean z10 = true;
        if (j0.d(view) != 1) {
            z10 = false;
        }
        int c10 = q2Var.c();
        int d10 = q2Var.d();
        int i11 = jVar.f55a;
        if (z10) {
            i10 = d10;
        } else {
            i10 = c10;
        }
        int i12 = i11 + i10;
        jVar.f55a = i12;
        int i13 = jVar.f57c;
        if (!z10) {
            c10 = d10;
        }
        int i14 = i13 + c10;
        jVar.f57c = i14;
        j0.k(view, i12, jVar.f56b, i14, jVar.f58d);
        return q2Var;
    }

    public final boolean b(View view) {
        boolean z10;
        SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.f2538i;
        boolean z11 = false;
        if (!swipeDismissBehavior.s(view)) {
            return false;
        }
        WeakHashMap weakHashMap = c1.f10054a;
        if (j0.d(view) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i10 = swipeDismissBehavior.f3656d;
        if ((i10 == 0 && z10) || (i10 == 1 && !z10)) {
            z11 = true;
        }
        int width = view.getWidth();
        if (z11) {
            width = -width;
        }
        c1.j(view, width);
        view.setAlpha(0.0f);
        swipeDismissBehavior.getClass();
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b A[SYNTHETIC, Splitter:B:21:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0045 A[SYNTHETIC, Splitter:B:27:0x0045] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(java.lang.Object r5, java.io.File r6, b5.n r7) {
        /*
            r4 = this;
            java.io.InputStream r5 = (java.io.InputStream) r5
            java.lang.Object r7 = r4.f2538i
            e5.k r7 = (e5.k) r7
            r0 = 65536(0x10000, float:9.18355E-41)
            java.lang.Class<byte[]> r1 = byte[].class
            java.lang.Object r0 = r7.d(r0, r1)
            byte[] r0 = (byte[]) r0
            r1 = 0
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0033 }
            r3.<init>(r6)     // Catch:{ IOException -> 0x0033 }
        L_0x0017:
            int r6 = r5.read(r0)     // Catch:{ IOException -> 0x002f, all -> 0x002d }
            r2 = -1
            if (r6 == r2) goto L_0x0022
            r3.write(r0, r1, r6)     // Catch:{ IOException -> 0x002f, all -> 0x002d }
            goto L_0x0017
        L_0x0022:
            r3.close()     // Catch:{ IOException -> 0x002f, all -> 0x002d }
            r3.close()     // Catch:{ IOException -> 0x0028 }
        L_0x0028:
            r7.h(r0)
            r1 = 1
            goto L_0x0041
        L_0x002d:
            r5 = move-exception
            goto L_0x0043
        L_0x002f:
            r2 = r3
            goto L_0x0033
        L_0x0031:
            r5 = move-exception
            goto L_0x0042
        L_0x0033:
            java.lang.String r5 = "StreamEncoder"
            r6 = 3
            android.util.Log.isLoggable(r5, r6)     // Catch:{ all -> 0x0031 }
            if (r2 == 0) goto L_0x003e
            r2.close()     // Catch:{ IOException -> 0x003e }
        L_0x003e:
            r7.h(r0)
        L_0x0041:
            return r1
        L_0x0042:
            r3 = r2
        L_0x0043:
            if (r3 == 0) goto L_0x0048
            r3.close()     // Catch:{ IOException -> 0x0048 }
        L_0x0048:
            r7.h(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.e0.c(java.lang.Object, java.io.File, b5.n):boolean");
    }

    public final o0 d(o0 o0Var, n nVar) {
        Resources resources = (Resources) this.f2538i;
        if (o0Var == null) {
            return null;
        }
        return new k5.d(resources, o0Var);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: androidx.fragment.app.c0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e(m.o r5, android.view.MenuItem r6) {
        /*
            r4 = this;
            java.lang.Object r5 = r4.f2538i
            o8.n r5 = (o8.n) r5
            o8.j r0 = r5.f12360m
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0070
            int r0 = r6.getItemId()
            int r3 = r5.getSelectedItemId()
            if (r0 != r3) goto L_0x0070
            o8.j r5 = r5.f12360m
            s6.b r5 = (s6.b) r5
            r5.getClass()
            int r0 = com.github.andreyasadchy.xtra.ui.main.MainActivity.N
            java.lang.String r0 = "this$0"
            com.github.andreyasadchy.xtra.ui.main.MainActivity r5 = r5.f14362h
            xa.j.f(r0, r5)
            j3.j1 r0 = r5.J
            r3 = 0
            if (r0 == 0) goto L_0x006a
            int r6 = r6.getItemId()
            boolean r6 = r0.n(r6, r2, r2)
            if (r6 == 0) goto L_0x003b
            boolean r6 = r0.b()
            if (r6 == 0) goto L_0x003b
            r6 = 1
            goto L_0x003c
        L_0x003b:
            r6 = 0
        L_0x003c:
            if (r6 != 0) goto L_0x0069
            androidx.fragment.app.d1 r5 = r5.A()
            r6 = 2131362277(0x7f0a01e5, float:1.834433E38)
            androidx.fragment.app.c0 r5 = r5.D(r6)
            if (r5 == 0) goto L_0x0060
            androidx.fragment.app.c1 r5 = r5.u()
            if (r5 == 0) goto L_0x0060
            androidx.fragment.app.n1 r5 = r5.f1373c
            java.util.List r5 = r5.f()
            if (r5 == 0) goto L_0x0060
            java.lang.Object r5 = ma.z.v(r5, r2)
            r3 = r5
            androidx.fragment.app.c0 r3 = (androidx.fragment.app.c0) r3
        L_0x0060:
            boolean r5 = r3 instanceof l6.c0
            if (r5 == 0) goto L_0x0069
            l6.c0 r3 = (l6.c0) r3
            r3.n()
        L_0x0069:
            return r1
        L_0x006a:
            java.lang.String r5 = "navController"
            xa.j.l(r5)
            throw r3
        L_0x0070:
            o8.k r5 = r5.f12359l
            if (r5 == 0) goto L_0x007b
            boolean r5 = r5.a(r6)
            if (r5 != 0) goto L_0x007b
            goto L_0x007c
        L_0x007b:
            r1 = 0
        L_0x007c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.e0.e(m.o, android.view.MenuItem):boolean");
    }

    public final Object f() {
        int i10 = this.f2537h;
        Object obj = this.f2538i;
        switch (i10) {
            case 4:
                d0.d dVar = (d0.d) obj;
                return new d5.n((d5.v) dVar.f4091i, (l0.d) dVar.f4092j);
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                i5 i5Var = (i5) obj;
                return new b0((g5.g) i5Var.f874b, (g5.g) i5Var.f875c, (g5.g) i5Var.f876d, (g5.g) i5Var.f877e, (c0) i5Var.f878f, (f0) i5Var.f879g, (l0.d) i5Var.f880h);
            default:
                try {
                    return new k(MessageDigest.getInstance("SHA-256"));
                } catch (NoSuchAlgorithmException e10) {
                    throw new RuntimeException(e10);
                }
        }
    }

    public final Object i() {
        y5.d dVar = new y5.d(0);
        dVar.f16970a = new ia.a((y5.n) this.f2538i);
        if (dVar.f16971b == null) {
            dVar.f16971b = new b6.e();
        }
        if (dVar.f16972c == null) {
            dVar.f16972c = new b6.g();
        }
        return new y5.h(dVar.f16970a, dVar.f16971b, dVar.f16972c);
    }

    public final void j(Drawable drawable) {
        if (drawable != null) {
            e0.super.setBackgroundDrawable(drawable);
        }
    }

    public final void l(o oVar) {
    }

    public final String toString() {
        int i10 = this.f2537h;
        Object obj = this.f2538i;
        switch (i10) {
            case 13:
                return super.toString() + "{fragment=" + ((q) obj) + "}";
            case 14:
                return super.toString() + "{fragment=" + ((com.bumptech.glide.manager.c0) obj) + "}";
            default:
                return super.toString();
        }
    }

    public e0(Resources resources) {
        this.f2537h = 12;
        this.f2538i = resources;
    }

    public e0(ViewGroup viewGroup) {
        this.f2537h = 0;
        this.f2538i = viewGroup.getOverlay();
    }

    public e0(i iVar) {
        this.f2537h = 3;
        this.f2538i = Collections.unmodifiableMap(new HashMap(iVar.f3198a));
    }

    public e0(SwipeDismissBehavior swipeDismissBehavior) {
        this.f2537h = 27;
        swipeDismissBehavior.getClass();
        swipeDismissBehavior.f3658f = Math.min(Math.max(0.0f, 0.1f), 1.0f);
        swipeDismissBehavior.f3659g = Math.min(Math.max(0.0f, 0.6f), 1.0f);
        swipeDismissBehavior.f3656d = 0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e0(MaterialButtonToggleGroup materialButtonToggleGroup) {
        this(22, materialButtonToggleGroup);
        this.f2537h = 22;
    }

    public e0(Field field) {
        this.f2537h = 29;
        field.getClass();
        this.f2538i = field;
    }
}
