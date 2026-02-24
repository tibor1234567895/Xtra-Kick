package o3;

import android.os.Bundle;
import android.os.Looper;
import android.support.v4.media.session.w;
import android.util.TypedValue;
import android.view.View;
import androidx.activity.h;
import androidx.fragment.app.c0;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g1;
import com.woxthebox.draglistview.R;

public abstract class z extends c0 implements h0, f0, g0, b {

    /* renamed from: d0  reason: collision with root package name */
    public final y f12183d0 = new y(this);

    /* renamed from: e0  reason: collision with root package name */
    public i0 f12184e0;

    /* renamed from: f0  reason: collision with root package name */
    public RecyclerView f12185f0;

    /* renamed from: g0  reason: collision with root package name */
    public boolean f12186g0;

    /* renamed from: h0  reason: collision with root package name */
    public boolean f12187h0;

    /* renamed from: i0  reason: collision with root package name */
    public int f12188i0 = R.layout.preference_list_fragment;

    /* renamed from: j0  reason: collision with root package name */
    public final w f12189j0 = new w(this, Looper.getMainLooper(), 7);

    /* renamed from: k0  reason: collision with root package name */
    public final h f12190k0 = new h(9, this);

    public void N(Bundle bundle) {
        String str;
        super.N(bundle);
        TypedValue typedValue = new TypedValue();
        f0().getTheme().resolveAttribute(R.attr.preferenceTheme, typedValue, true);
        int i10 = typedValue.resourceId;
        if (i10 == 0) {
            i10 = R.style.PreferenceThemeOverlay;
        }
        f0().getTheme().applyStyle(i10, false);
        i0 i0Var = new i0(f0());
        this.f12184e0 = i0Var;
        i0Var.f12136k = this;
        Bundle bundle2 = this.f1357m;
        if (bundle2 != null) {
            str = bundle2.getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT");
        } else {
            str = null;
        }
        m0(str);
    }

    /* JADX WARNING: type inference failed for: r10v8, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View O(android.view.LayoutInflater r10, android.view.ViewGroup r11) {
        /*
            r9 = this;
            android.content.Context r0 = r9.f0()
            int[] r1 = o3.m0.f12156h
            r2 = 0
            r3 = 2130969554(0x7f0403d2, float:1.7547793E38)
            r4 = 0
            android.content.res.TypedArray r0 = r0.obtainStyledAttributes(r2, r1, r3, r4)
            int r1 = r9.f12188i0
            int r1 = r0.getResourceId(r4, r1)
            r9.f12188i0 = r1
            r1 = 1
            android.graphics.drawable.Drawable r2 = r0.getDrawable(r1)
            r3 = 2
            r5 = -1
            int r3 = r0.getDimensionPixelSize(r3, r5)
            r6 = 3
            boolean r6 = r0.getBoolean(r6, r1)
            r0.recycle()
            android.content.Context r0 = r9.f0()
            android.view.LayoutInflater r10 = r10.cloneInContext(r0)
            int r0 = r9.f12188i0
            android.view.View r11 = r10.inflate(r0, r11, r4)
            r0 = 16908351(0x102003f, float:2.3877406E-38)
            android.view.View r0 = r11.findViewById(r0)
            boolean r7 = r0 instanceof android.view.ViewGroup
            if (r7 == 0) goto L_0x00b9
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.content.Context r7 = r9.f0()
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            java.lang.String r8 = "android.hardware.type.automotive"
            boolean r7 = r7.hasSystemFeature(r8)
            if (r7 == 0) goto L_0x0061
            r7 = 2131362373(0x7f0a0245, float:1.8344525E38)
            android.view.View r7 = r0.findViewById(r7)
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            if (r7 == 0) goto L_0x0061
            goto L_0x007e
        L_0x0061:
            r7 = 2131558584(0x7f0d00b8, float:1.8742488E38)
            android.view.View r10 = r10.inflate(r7, r0, r4)
            r7 = r10
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            androidx.recyclerview.widget.LinearLayoutManager r10 = new androidx.recyclerview.widget.LinearLayoutManager
            r9.f0()
            r10.<init>(r1)
            r7.setLayoutManager(r10)
            o3.k0 r10 = new o3.k0
            r10.<init>(r7)
            r7.setAccessibilityDelegateCompat(r10)
        L_0x007e:
            r9.f12185f0 = r7
            o3.y r10 = r9.f12183d0
            r7.addItemDecoration(r10)
            if (r2 == 0) goto L_0x008e
            r10.getClass()
            int r4 = r2.getIntrinsicHeight()
        L_0x008e:
            r10.f12180b = r4
            r10.f12179a = r2
            o3.z r1 = r10.f12182d
            androidx.recyclerview.widget.RecyclerView r2 = r1.f12185f0
            r2.invalidateItemDecorations()
            if (r3 == r5) goto L_0x00a2
            r10.f12180b = r3
            androidx.recyclerview.widget.RecyclerView r1 = r1.f12185f0
            r1.invalidateItemDecorations()
        L_0x00a2:
            r10.f12181c = r6
            androidx.recyclerview.widget.RecyclerView r10 = r9.f12185f0
            android.view.ViewParent r10 = r10.getParent()
            if (r10 != 0) goto L_0x00b1
            androidx.recyclerview.widget.RecyclerView r10 = r9.f12185f0
            r0.addView(r10)
        L_0x00b1:
            android.support.v4.media.session.w r10 = r9.f12189j0
            androidx.activity.h r0 = r9.f12190k0
            r10.post(r0)
            return r11
        L_0x00b9:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.z.O(android.view.LayoutInflater, android.view.ViewGroup):android.view.View");
    }

    public final void Q() {
        h hVar = this.f12190k0;
        w wVar = this.f12189j0;
        wVar.removeCallbacks(hVar);
        wVar.removeMessages(1);
        if (this.f12186g0) {
            this.f12185f0.setAdapter((g1) null);
            PreferenceScreen preferenceScreen = this.f12184e0.f12133h;
            if (preferenceScreen != null) {
                preferenceScreen.n();
            }
        }
        this.f12185f0 = null;
        this.K = true;
    }

    public void W(Bundle bundle) {
        PreferenceScreen preferenceScreen = this.f12184e0.f12133h;
        if (preferenceScreen != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreen.c(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    public final void X() {
        this.K = true;
        i0 i0Var = this.f12184e0;
        i0Var.f12134i = this;
        i0Var.f12135j = this;
    }

    public final void Y() {
        this.K = true;
        i0 i0Var = this.f12184e0;
        i0Var.f12134i = null;
        i0Var.f12135j = null;
    }

    public final void Z(View view, Bundle bundle) {
        PreferenceScreen preferenceScreen;
        Bundle bundle2;
        PreferenceScreen preferenceScreen2;
        if (!(bundle == null || (bundle2 = bundle.getBundle("android:preferences")) == null || (preferenceScreen2 = this.f12184e0.f12133h) == null)) {
            preferenceScreen2.b(bundle2);
        }
        if (this.f12186g0 && (preferenceScreen = this.f12184e0.f12133h) != null) {
            this.f12185f0.setAdapter(new d0(preferenceScreen));
            preferenceScreen.j();
        }
        this.f12187h0 = true;
    }

    public final Preference l0(String str) {
        PreferenceScreen preferenceScreen;
        i0 i0Var = this.f12184e0;
        if (i0Var == null || (preferenceScreen = i0Var.f12133h) == null) {
            return null;
        }
        return preferenceScreen.y(str);
    }

    public abstract void m0(String str);

    public final void n0(int i10, String str) {
        boolean z10;
        i0 i0Var = this.f12184e0;
        if (i0Var != null) {
            PreferenceScreen e10 = i0Var.e(f0(), i10);
            Object obj = e10;
            if (str != null) {
                Object y10 = e10.y(str);
                boolean z11 = y10 instanceof PreferenceScreen;
                obj = y10;
                if (!z11) {
                    throw new IllegalArgumentException(android.support.v4.media.h.n("Preference object with key ", str, " is not a PreferenceScreen"));
                }
            }
            PreferenceScreen preferenceScreen = (PreferenceScreen) obj;
            i0 i0Var2 = this.f12184e0;
            PreferenceScreen preferenceScreen2 = i0Var2.f12133h;
            if (preferenceScreen != preferenceScreen2) {
                if (preferenceScreen2 != null) {
                    preferenceScreen2.n();
                }
                i0Var2.f12133h = preferenceScreen;
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10 && preferenceScreen != null) {
                this.f12186g0 = true;
                if (this.f12187h0) {
                    w wVar = this.f12189j0;
                    if (!wVar.hasMessages(1)) {
                        wVar.obtainMessage(1).sendToTarget();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new RuntimeException("This should be called after super.onCreate.");
    }
}
