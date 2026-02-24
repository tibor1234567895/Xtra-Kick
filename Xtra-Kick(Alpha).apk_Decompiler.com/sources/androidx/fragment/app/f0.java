package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.h;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.f;
import androidx.activity.g;
import androidx.lifecycle.g0;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import b0.c;
import b0.d;

public class f0 extends ComponentActivity implements c, d {
    public static final /* synthetic */ int C = 0;
    public boolean A;
    public boolean B = true;

    /* renamed from: x  reason: collision with root package name */
    public final p0 f1416x = new p0(4, new e0(this));

    /* renamed from: y  reason: collision with root package name */
    public final g0 f1417y = new g0(this);

    /* renamed from: z  reason: collision with root package name */
    public boolean f1418z;

    public f0() {
        this.f451l.f14540b.c("android:support:lifecycle", new f(1, this));
        n(new d0(0, this));
        this.f458s.add(new d0(1, this));
        p(new g(this, 1));
    }

    public static boolean B(c1 c1Var) {
        f0 f0Var;
        s sVar = s.CREATED;
        boolean z10 = false;
        for (c0 c0Var : c1Var.f1373c.f()) {
            if (c0Var != null) {
                e0 e0Var = c0Var.A;
                if (e0Var == null) {
                    f0Var = null;
                } else {
                    f0Var = e0Var.f1406l;
                }
                if (f0Var != null) {
                    z10 |= B(c0Var.u());
                }
                y1 y1Var = c0Var.W;
                s sVar2 = s.STARTED;
                if (y1Var != null) {
                    y1Var.c();
                    if (y1Var.f1619l.f1688d.a(sVar2)) {
                        c0Var.W.f1619l.h(sVar);
                        z10 = true;
                    }
                }
                if (c0Var.V.f1688d.a(sVar2)) {
                    c0Var.V.h(sVar);
                    z10 = true;
                }
            }
        }
        return z10;
    }

    public final d1 A() {
        return ((e0) this.f1416x.f1532i).f1405k;
    }

    public final void C(c0 c0Var, Intent intent) {
        if (c0Var.A != null) {
            c1 x10 = c0Var.x();
            if (x10.B != null) {
                x10.E.addLast(new x0(c0Var.f1356l));
                x10.B.a(intent);
                return;
            }
            x10.f1392v.getClass();
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        throw new IllegalStateException(h.l("Fragment ", c0Var, " not attached to Activity"));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0056, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 26) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005d, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 29) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0069, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 31) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006b, code lost:
        r0 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dump(java.lang.String r6, java.io.FileDescriptor r7, java.io.PrintWriter r8, java.lang.String[] r9) {
        /*
            r5 = this;
            super.dump(r6, r7, r8, r9)
            r0 = 0
            r1 = 1
            if (r9 == 0) goto L_0x006c
            int r2 = r9.length
            if (r2 <= 0) goto L_0x006c
            r2 = r9[r0]
            r2.getClass()
            int r3 = r2.hashCode()
            r4 = -1
            switch(r3) {
                case -645125871: goto L_0x0044;
                case 100470631: goto L_0x0039;
                case 472614934: goto L_0x002e;
                case 1159329357: goto L_0x0023;
                case 1455016274: goto L_0x0018;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x004e
        L_0x0018:
            java.lang.String r3 = "--autofill"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0021
            goto L_0x004e
        L_0x0021:
            r4 = 4
            goto L_0x004e
        L_0x0023:
            java.lang.String r3 = "--contentcapture"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x002c
            goto L_0x004e
        L_0x002c:
            r4 = 3
            goto L_0x004e
        L_0x002e:
            java.lang.String r3 = "--list-dumpables"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0037
            goto L_0x004e
        L_0x0037:
            r4 = 2
            goto L_0x004e
        L_0x0039:
            java.lang.String r3 = "--dump-dumpable"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0042
            goto L_0x004e
        L_0x0042:
            r4 = 1
            goto L_0x004e
        L_0x0044:
            java.lang.String r3 = "--translation"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r4 = 0
        L_0x004e:
            switch(r4) {
                case 0: goto L_0x0065;
                case 1: goto L_0x0060;
                case 2: goto L_0x0060;
                case 3: goto L_0x0059;
                case 4: goto L_0x0052;
                default: goto L_0x0051;
            }
        L_0x0051:
            goto L_0x006c
        L_0x0052:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r2 < r3) goto L_0x006c
            goto L_0x006b
        L_0x0059:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 29
            if (r2 < r3) goto L_0x006c
            goto L_0x006b
        L_0x0060:
            boolean r0 = i0.b.a()
            goto L_0x006c
        L_0x0065:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 31
            if (r2 < r3) goto L_0x006c
        L_0x006b:
            r0 = 1
        L_0x006c:
            r0 = r0 ^ r1
            if (r0 != 0) goto L_0x0070
            return
        L_0x0070:
            r8.print(r6)
            java.lang.String r0 = "Local FragmentActivity "
            r8.print(r0)
            int r0 = java.lang.System.identityHashCode(r5)
            java.lang.String r0 = java.lang.Integer.toHexString(r0)
            r8.print(r0)
            java.lang.String r0 = " State:"
            r8.println(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            java.lang.String r1 = "  "
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.print(r0)
            java.lang.String r1 = "mCreated="
            r8.print(r1)
            boolean r1 = r5.f1418z
            r8.print(r1)
            java.lang.String r1 = " mResumed="
            r8.print(r1)
            boolean r1 = r5.A
            r8.print(r1)
            java.lang.String r1 = " mStopped="
            r8.print(r1)
            boolean r1 = r5.B
            r8.print(r1)
            android.app.Application r1 = r5.getApplication()
            if (r1 == 0) goto L_0x00cc
            c1.d r1 = new c1.d
            androidx.lifecycle.g2 r2 = r5.m()
            r1.<init>(r5, r2)
            r1.b(r0, r8)
        L_0x00cc:
            androidx.fragment.app.p0 r0 = r5.f1416x
            java.lang.Object r0 = r0.f1532i
            androidx.fragment.app.e0 r0 = (androidx.fragment.app.e0) r0
            androidx.fragment.app.d1 r0 = r0.f1405k
            r0.v(r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.f0.dump(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void");
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        this.f1416x.i();
        super.onActivityResult(i10, i11, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1417y.f(r.ON_CREATE);
        d1 d1Var = ((e0) this.f1416x.f1532i).f1405k;
        d1Var.G = false;
        d1Var.H = false;
        d1Var.N.f1452i = false;
        d1Var.t(1);
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView = ((e0) this.f1416x.f1532i).f1405k.f1376f.onCreateView(view, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(view, str, context, attributeSet) : onCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        ((e0) this.f1416x.f1532i).f1405k.k();
        this.f1417y.f(r.ON_DESTROY);
    }

    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 6) {
            return ((e0) this.f1416x.f1532i).f1405k.i();
        }
        return false;
    }

    public final void onPause() {
        super.onPause();
        this.A = false;
        ((e0) this.f1416x.f1532i).f1405k.t(5);
        this.f1417y.f(r.ON_PAUSE);
    }

    public void onPostResume() {
        super.onPostResume();
        this.f1417y.f(r.ON_RESUME);
        d1 d1Var = ((e0) this.f1416x.f1532i).f1405k;
        d1Var.G = false;
        d1Var.H = false;
        d1Var.N.f1452i = false;
        d1Var.t(7);
    }

    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        this.f1416x.i();
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    public void onResume() {
        p0 p0Var = this.f1416x;
        p0Var.i();
        super.onResume();
        this.A = true;
        ((e0) p0Var.f1532i).f1405k.y(true);
    }

    public void onStart() {
        p0 p0Var = this.f1416x;
        p0Var.i();
        super.onStart();
        this.B = false;
        boolean z10 = this.f1418z;
        Object obj = p0Var.f1532i;
        if (!z10) {
            this.f1418z = true;
            d1 d1Var = ((e0) obj).f1405k;
            d1Var.G = false;
            d1Var.H = false;
            d1Var.N.f1452i = false;
            d1Var.t(4);
        }
        ((e0) obj).f1405k.y(true);
        this.f1417y.f(r.ON_START);
        d1 d1Var2 = ((e0) obj).f1405k;
        d1Var2.G = false;
        d1Var2.H = false;
        d1Var2.N.f1452i = false;
        d1Var2.t(5);
    }

    public final void onStateNotSaved() {
        this.f1416x.i();
    }

    public void onStop() {
        super.onStop();
        this.B = true;
        do {
        } while (B(A()));
        d1 d1Var = ((e0) this.f1416x.f1532i).f1405k;
        d1Var.H = true;
        d1Var.N.f1452i = true;
        d1Var.t(4);
        this.f1417y.f(r.ON_STOP);
    }

    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView = ((e0) this.f1416x.f1532i).f1405k.f1376f.onCreateView((View) null, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(str, context, attributeSet) : onCreateView;
    }
}
