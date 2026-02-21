package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.h;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.a;
import androidx.fragment.app.c0;
import androidx.fragment.app.c1;
import com.woxthebox.draglistview.R;
import g.c;
import java.io.Serializable;
import java.util.ArrayList;
import o3.d0;
import o3.h0;
import o3.i0;
import o3.s;
import o3.t;
import o3.u;
import o3.v;
import o3.z;

public class Preference implements Comparable<Preference> {
    public final Object A;
    public boolean B;
    public boolean C;
    public boolean D;
    public final boolean E;
    public final boolean F;
    public final boolean G;
    public final boolean H;
    public final boolean I;
    public final boolean J;
    public final boolean K;
    public int L;
    public final int M;
    public d0 N;
    public ArrayList O;
    public PreferenceGroup P;
    public boolean Q;
    public u R;
    public v S;
    public final c T;

    /* renamed from: h  reason: collision with root package name */
    public final Context f1887h;

    /* renamed from: i  reason: collision with root package name */
    public i0 f1888i;

    /* renamed from: j  reason: collision with root package name */
    public long f1889j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1890k;

    /* renamed from: l  reason: collision with root package name */
    public s f1891l;

    /* renamed from: m  reason: collision with root package name */
    public t f1892m;

    /* renamed from: n  reason: collision with root package name */
    public int f1893n;

    /* renamed from: o  reason: collision with root package name */
    public CharSequence f1894o;

    /* renamed from: p  reason: collision with root package name */
    public CharSequence f1895p;

    /* renamed from: q  reason: collision with root package name */
    public int f1896q;

    /* renamed from: r  reason: collision with root package name */
    public Drawable f1897r;

    /* renamed from: s  reason: collision with root package name */
    public final String f1898s;

    /* renamed from: t  reason: collision with root package name */
    public Intent f1899t;

    /* renamed from: u  reason: collision with root package name */
    public final String f1900u;

    /* renamed from: v  reason: collision with root package name */
    public Bundle f1901v;

    /* renamed from: w  reason: collision with root package name */
    public final boolean f1902w;

    /* renamed from: x  reason: collision with root package name */
    public final boolean f1903x;

    /* renamed from: y  reason: collision with root package name */
    public final boolean f1904y;

    /* renamed from: z  reason: collision with root package name */
    public final String f1905z;

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d0.t.a(context, R.attr.preferenceStyle, 16842894));
    }

    public static void u(View view, boolean z10) {
        view.setEnabled(z10);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            while (true) {
                childCount--;
                if (childCount >= 0) {
                    u(viewGroup.getChildAt(childCount), z10);
                } else {
                    return;
                }
            }
        }
    }

    public final boolean a(Serializable serializable) {
        s sVar = this.f1891l;
        if (sVar == null) {
            return true;
        }
        sVar.c(this, serializable);
        return true;
    }

    public void b(Bundle bundle) {
        Parcelable parcelable;
        String str = this.f1898s;
        if ((!TextUtils.isEmpty(str)) && (parcelable = bundle.getParcelable(str)) != null) {
            this.Q = false;
            p(parcelable);
            if (!this.Q) {
                throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
            }
        }
    }

    public void c(Bundle bundle) {
        String str = this.f1898s;
        if (!TextUtils.isEmpty(str)) {
            this.Q = false;
            Parcelable q10 = q();
            if (!this.Q) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            } else if (q10 != null) {
                bundle.putParcelable(str, q10);
            }
        }
    }

    public final int compareTo(Object obj) {
        Preference preference = (Preference) obj;
        int i10 = this.f1893n;
        int i11 = preference.f1893n;
        if (i10 != i11) {
            return i10 - i11;
        }
        CharSequence charSequence = this.f1894o;
        CharSequence charSequence2 = preference.f1894o;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.f1894o.toString());
    }

    public long d() {
        return this.f1889j;
    }

    public final String e(String str) {
        return !x() ? str : this.f1888i.d().getString(this.f1898s, str);
    }

    public CharSequence f() {
        v vVar = this.S;
        if (vVar != null) {
            return vVar.a(this);
        }
        return this.f1895p;
    }

    public boolean g() {
        return this.f1902w && this.B && this.C;
    }

    public void h() {
        int indexOf;
        d0 d0Var = this.N;
        if (d0Var != null && (indexOf = d0Var.f12114c.indexOf(this)) != -1) {
            d0Var.notifyItemChanged(indexOf, this);
        }
    }

    public void i(boolean z10) {
        ArrayList arrayList = this.O;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                Preference preference = (Preference) arrayList.get(i10);
                if (preference.B == z10) {
                    preference.B = !z10;
                    preference.i(preference.w());
                    preference.h();
                }
            }
        }
    }

    public void j() {
        PreferenceScreen preferenceScreen;
        String str = this.f1905z;
        if (!TextUtils.isEmpty(str)) {
            i0 i0Var = this.f1888i;
            Preference preference = null;
            if (!(i0Var == null || (preferenceScreen = i0Var.f12133h) == null)) {
                preference = preferenceScreen.y(str);
            }
            if (preference != null) {
                if (preference.O == null) {
                    preference.O = new ArrayList();
                }
                preference.O.add(this);
                boolean w10 = preference.w();
                if (this.B == w10) {
                    this.B = !w10;
                    i(w());
                    h();
                    return;
                }
                return;
            }
            StringBuilder s10 = h.s("Dependency \"", str, "\" not found for preference \"");
            s10.append(this.f1898s);
            s10.append("\" (title: \"");
            s10.append(this.f1894o);
            s10.append("\"");
            throw new IllegalStateException(s10.toString());
        }
    }

    public final void k(i0 i0Var) {
        SharedPreferences sharedPreferences;
        this.f1888i = i0Var;
        if (!this.f1890k) {
            this.f1889j = i0Var.c();
        }
        if (x()) {
            i0 i0Var2 = this.f1888i;
            if (i0Var2 != null) {
                sharedPreferences = i0Var2.d();
            } else {
                sharedPreferences = null;
            }
            if (sharedPreferences.contains(this.f1898s)) {
                r((Object) null);
                return;
            }
        }
        Object obj = this.A;
        if (obj != null) {
            r(obj);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void l(o3.l0 r11) {
        /*
            r10 = this;
            android.view.View r0 = r11.itemView
            g.c r1 = r10.T
            r0.setOnClickListener(r1)
            r1 = 0
            r0.setId(r1)
            r2 = 16908304(0x1020010, float:2.3877274E-38)
            android.view.View r2 = r11.a(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r3 = 8
            r4 = 0
            if (r2 == 0) goto L_0x0035
            java.lang.CharSequence r5 = r10.f()
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x0032
            r2.setText(r5)
            r2.setVisibility(r1)
            int r2 = r2.getCurrentTextColor()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0036
        L_0x0032:
            r2.setVisibility(r3)
        L_0x0035:
            r2 = r4
        L_0x0036:
            r5 = 16908310(0x1020016, float:2.387729E-38)
            android.view.View r5 = r11.a(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            boolean r6 = r10.f1903x
            if (r5 == 0) goto L_0x006f
            java.lang.CharSequence r7 = r10.f1894o
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L_0x006c
            r5.setText(r7)
            r5.setVisibility(r1)
            boolean r7 = r10.G
            if (r7 == 0) goto L_0x005a
            boolean r7 = r10.H
            r5.setSingleLine(r7)
        L_0x005a:
            if (r6 != 0) goto L_0x006f
            boolean r7 = r10.g()
            if (r7 == 0) goto L_0x006f
            if (r2 == 0) goto L_0x006f
            int r2 = r2.intValue()
            r5.setTextColor(r2)
            goto L_0x006f
        L_0x006c:
            r5.setVisibility(r3)
        L_0x006f:
            r2 = 16908294(0x1020006, float:2.3877246E-38)
            android.view.View r2 = r11.a(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r5 = 4
            boolean r7 = r10.I
            if (r2 == 0) goto L_0x00a9
            int r8 = r10.f1896q
            if (r8 != 0) goto L_0x0085
            android.graphics.drawable.Drawable r9 = r10.f1897r
            if (r9 == 0) goto L_0x0098
        L_0x0085:
            android.graphics.drawable.Drawable r9 = r10.f1897r
            if (r9 != 0) goto L_0x0091
            android.content.Context r9 = r10.f1887h
            android.graphics.drawable.Drawable r8 = h.a.a(r9, r8)
            r10.f1897r = r8
        L_0x0091:
            android.graphics.drawable.Drawable r8 = r10.f1897r
            if (r8 == 0) goto L_0x0098
            r2.setImageDrawable(r8)
        L_0x0098:
            android.graphics.drawable.Drawable r8 = r10.f1897r
            if (r8 == 0) goto L_0x00a0
            r2.setVisibility(r1)
            goto L_0x00a9
        L_0x00a0:
            if (r7 == 0) goto L_0x00a4
            r8 = 4
            goto L_0x00a6
        L_0x00a4:
            r8 = 8
        L_0x00a6:
            r2.setVisibility(r8)
        L_0x00a9:
            r2 = 2131362152(0x7f0a0168, float:1.8344077E38)
            android.view.View r2 = r11.a(r2)
            if (r2 != 0) goto L_0x00b9
            r2 = 16908350(0x102003e, float:2.3877403E-38)
            android.view.View r2 = r11.a(r2)
        L_0x00b9:
            if (r2 == 0) goto L_0x00c9
            android.graphics.drawable.Drawable r8 = r10.f1897r
            if (r8 == 0) goto L_0x00c3
            r2.setVisibility(r1)
            goto L_0x00c9
        L_0x00c3:
            if (r7 == 0) goto L_0x00c6
            r3 = 4
        L_0x00c6:
            r2.setVisibility(r3)
        L_0x00c9:
            boolean r1 = r10.K
            if (r1 == 0) goto L_0x00d2
            boolean r1 = r10.g()
            goto L_0x00d3
        L_0x00d2:
            r1 = 1
        L_0x00d3:
            u(r0, r1)
            r0.setFocusable(r6)
            r0.setClickable(r6)
            boolean r1 = r10.E
            r11.f12147k = r1
            boolean r1 = r10.F
            r11.f12148l = r1
            boolean r11 = r10.J
            if (r11 == 0) goto L_0x00f3
            o3.u r1 = r10.R
            if (r1 != 0) goto L_0x00f3
            o3.u r1 = new o3.u
            r1.<init>(r10)
            r10.R = r1
        L_0x00f3:
            if (r11 == 0) goto L_0x00f8
            o3.u r1 = r10.R
            goto L_0x00f9
        L_0x00f8:
            r1 = r4
        L_0x00f9:
            r0.setOnCreateContextMenuListener(r1)
            r0.setLongClickable(r11)
            if (r11 == 0) goto L_0x0108
            if (r6 != 0) goto L_0x0108
            java.util.WeakHashMap r11 = m0.c1.f10054a
            m0.i0.q(r0, r4)
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.Preference.l(o3.l0):void");
    }

    public void m() {
    }

    public void n() {
        ArrayList arrayList;
        PreferenceScreen preferenceScreen;
        String str = this.f1905z;
        if (str != null) {
            i0 i0Var = this.f1888i;
            Preference preference = null;
            if (!(i0Var == null || (preferenceScreen = i0Var.f12133h) == null)) {
                preference = preferenceScreen.y(str);
            }
            if (preference != null && (arrayList = preference.O) != null) {
                arrayList.remove(this);
            }
        }
    }

    public Object o(TypedArray typedArray, int i10) {
        return null;
    }

    public void p(Parcelable parcelable) {
        this.Q = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    public Parcelable q() {
        this.Q = true;
        return AbsSavedState.EMPTY_STATE;
    }

    public void r(Object obj) {
    }

    public void s(View view) {
        h0 h0Var;
        boolean z10;
        if (g() && this.f1903x) {
            m();
            t tVar = this.f1892m;
            if (tVar != null) {
                tVar.a(this);
                return;
            }
            i0 i0Var = this.f1888i;
            if (!(i0Var == null || (h0Var = i0Var.f12134i) == null)) {
                z zVar = (z) h0Var;
                String str = this.f1900u;
                if (str != null) {
                    for (c0 c0Var = zVar; c0Var != null; c0Var = c0Var.C) {
                    }
                    zVar.v();
                    zVar.t();
                    Log.w("PreferenceFragment", "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
                    c1 x10 = zVar.x();
                    if (this.f1901v == null) {
                        this.f1901v = new Bundle();
                    }
                    Bundle bundle = this.f1901v;
                    c0 a10 = x10.G().a(zVar.d0().getClassLoader(), str);
                    a10.j0(bundle);
                    a10.k0(zVar);
                    a aVar = new a(x10);
                    aVar.e(((View) zVar.h0().getParent()).getId(), a10, (String) null);
                    aVar.c((String) null);
                    aVar.g();
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    return;
                }
            }
            Intent intent = this.f1899t;
            if (intent != null) {
                this.f1887h.startActivity(intent);
            }
        }
    }

    public final void t(String str) {
        if (x() && !TextUtils.equals(str, e((String) null))) {
            SharedPreferences.Editor b10 = this.f1888i.b();
            b10.putString(this.f1898s, str);
            if (!this.f1888i.f12130e) {
                b10.apply();
            }
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        CharSequence charSequence = this.f1894o;
        if (!TextUtils.isEmpty(charSequence)) {
            sb2.append(charSequence);
            sb2.append(' ');
        }
        CharSequence f10 = f();
        if (!TextUtils.isEmpty(f10)) {
            sb2.append(f10);
            sb2.append(' ');
        }
        if (sb2.length() > 0) {
            sb2.setLength(sb2.length() - 1);
        }
        return sb2.toString();
    }

    public final void v(CharSequence charSequence) {
        if (this.S != null) {
            throw new IllegalStateException("Preference already has a SummaryProvider set.");
        } else if (!TextUtils.equals(this.f1895p, charSequence)) {
            this.f1895p = charSequence;
            h();
        }
    }

    public boolean w() {
        return !g();
    }

    public final boolean x() {
        if (this.f1888i == null || !this.f1904y || !(!TextUtils.isEmpty(this.f1898s))) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x00ef, code lost:
        if (r7.hasValue(11) != false) goto L_0x00f1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Preference(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            r6.<init>()
            r0 = 2147483647(0x7fffffff, float:NaN)
            r6.f1893n = r0
            r1 = 1
            r6.f1902w = r1
            r6.f1903x = r1
            r6.f1904y = r1
            r6.B = r1
            r6.C = r1
            r6.D = r1
            r6.E = r1
            r6.F = r1
            r6.H = r1
            r6.K = r1
            r2 = 2131558574(0x7f0d00ae, float:1.8742468E38)
            r6.L = r2
            g.c r3 = new g.c
            r4 = 3
            r3.<init>(r4, r6)
            r6.T = r3
            r6.f1887h = r7
            int[] r3 = o3.m0.f12155g
            r5 = 0
            android.content.res.TypedArray r7 = r7.obtainStyledAttributes(r8, r3, r9, r5)
            int r8 = r7.getResourceId(r5, r5)
            r9 = 23
            int r8 = r7.getResourceId(r9, r8)
            r6.f1896q = r8
            r8 = 26
            r9 = 6
            java.lang.String r8 = d0.t.f(r7, r8, r9)
            r6.f1898s = r8
            r8 = 34
            java.lang.CharSequence r8 = r7.getText(r8)
            if (r8 != 0) goto L_0x0055
            r8 = 4
            java.lang.CharSequence r8 = r7.getText(r8)
        L_0x0055:
            r6.f1894o = r8
            r8 = 33
            java.lang.CharSequence r8 = r7.getText(r8)
            if (r8 != 0) goto L_0x0064
            r8 = 7
            java.lang.CharSequence r8 = r7.getText(r8)
        L_0x0064:
            r6.f1895p = r8
            r8 = 8
            int r8 = r7.getInt(r8, r0)
            r9 = 28
            int r8 = r7.getInt(r9, r8)
            r6.f1893n = r8
            r8 = 22
            r9 = 13
            java.lang.String r8 = d0.t.f(r7, r8, r9)
            r6.f1900u = r8
            int r8 = r7.getResourceId(r4, r2)
            r9 = 27
            int r8 = r7.getResourceId(r9, r8)
            r6.L = r8
            r8 = 9
            int r8 = r7.getResourceId(r8, r5)
            r9 = 35
            int r8 = r7.getResourceId(r9, r8)
            r6.M = r8
            r8 = 2
            boolean r8 = r7.getBoolean(r8, r1)
            r9 = 21
            boolean r8 = r7.getBoolean(r9, r8)
            r6.f1902w = r8
            r8 = 5
            boolean r8 = r7.getBoolean(r8, r1)
            r9 = 30
            boolean r8 = r7.getBoolean(r9, r8)
            r6.f1903x = r8
            boolean r9 = r7.getBoolean(r1, r1)
            r0 = 29
            boolean r9 = r7.getBoolean(r0, r9)
            r6.f1904y = r9
            r9 = 19
            r0 = 10
            java.lang.String r9 = d0.t.f(r7, r9, r0)
            r6.f1905z = r9
            r9 = 16
            boolean r0 = r7.getBoolean(r9, r8)
            boolean r9 = r7.getBoolean(r9, r0)
            r6.E = r9
            r9 = 17
            boolean r8 = r7.getBoolean(r9, r8)
            boolean r8 = r7.getBoolean(r9, r8)
            r6.F = r8
            r8 = 18
            boolean r9 = r7.hasValue(r8)
            if (r9 == 0) goto L_0x00e9
            goto L_0x00f1
        L_0x00e9:
            r8 = 11
            boolean r9 = r7.hasValue(r8)
            if (r9 == 0) goto L_0x00f7
        L_0x00f1:
            java.lang.Object r8 = r6.o(r7, r8)
            r6.A = r8
        L_0x00f7:
            r8 = 12
            boolean r8 = r7.getBoolean(r8, r1)
            r9 = 31
            boolean r8 = r7.getBoolean(r9, r8)
            r6.K = r8
            r8 = 32
            boolean r9 = r7.hasValue(r8)
            r6.G = r9
            if (r9 == 0) goto L_0x011b
            r9 = 14
            boolean r9 = r7.getBoolean(r9, r1)
            boolean r8 = r7.getBoolean(r8, r9)
            r6.H = r8
        L_0x011b:
            r8 = 15
            boolean r8 = r7.getBoolean(r8, r5)
            r9 = 24
            boolean r8 = r7.getBoolean(r9, r8)
            r6.I = r8
            r8 = 25
            boolean r9 = r7.getBoolean(r8, r1)
            boolean r8 = r7.getBoolean(r8, r9)
            r6.D = r8
            r8 = 20
            boolean r9 = r7.getBoolean(r8, r5)
            boolean r8 = r7.getBoolean(r8, r9)
            r6.J = r8
            r7.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.Preference.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
