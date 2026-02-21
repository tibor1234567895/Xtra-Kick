package l;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import g0.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import m.q;
import m.w;
import m0.d;
import m0.s;

public final class k {
    public CharSequence A;
    public CharSequence B;
    public ColorStateList C = null;
    public PorterDuff.Mode D = null;
    public final /* synthetic */ l E;

    /* renamed from: a  reason: collision with root package name */
    public final Menu f9456a;

    /* renamed from: b  reason: collision with root package name */
    public int f9457b;

    /* renamed from: c  reason: collision with root package name */
    public int f9458c;

    /* renamed from: d  reason: collision with root package name */
    public int f9459d;

    /* renamed from: e  reason: collision with root package name */
    public int f9460e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9461f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9462g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f9463h;

    /* renamed from: i  reason: collision with root package name */
    public int f9464i;

    /* renamed from: j  reason: collision with root package name */
    public int f9465j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f9466k;

    /* renamed from: l  reason: collision with root package name */
    public CharSequence f9467l;

    /* renamed from: m  reason: collision with root package name */
    public int f9468m;

    /* renamed from: n  reason: collision with root package name */
    public char f9469n;

    /* renamed from: o  reason: collision with root package name */
    public int f9470o;

    /* renamed from: p  reason: collision with root package name */
    public char f9471p;

    /* renamed from: q  reason: collision with root package name */
    public int f9472q;

    /* renamed from: r  reason: collision with root package name */
    public int f9473r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f9474s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f9475t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f9476u;

    /* renamed from: v  reason: collision with root package name */
    public int f9477v;

    /* renamed from: w  reason: collision with root package name */
    public int f9478w;

    /* renamed from: x  reason: collision with root package name */
    public String f9479x;

    /* renamed from: y  reason: collision with root package name */
    public String f9480y;

    /* renamed from: z  reason: collision with root package name */
    public d f9481z;

    public k(l lVar, Menu menu) {
        this.E = lVar;
        this.f9456a = menu;
        this.f9457b = 0;
        this.f9458c = 0;
        this.f9459d = 0;
        this.f9460e = 0;
        this.f9461f = true;
        this.f9462g = true;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.E.f9486c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e10) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e10);
            return null;
        }
    }

    public final void b(MenuItem menuItem) {
        boolean z10;
        MenuItem enabled = menuItem.setChecked(this.f9474s).setVisible(this.f9475t).setEnabled(this.f9476u);
        boolean z11 = false;
        if (this.f9473r >= 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        enabled.setCheckable(z10).setTitleCondensed(this.f9467l).setIcon(this.f9468m);
        int i10 = this.f9477v;
        if (i10 >= 0) {
            menuItem.setShowAsAction(i10);
        }
        String str = this.f9480y;
        l lVar = this.E;
        if (str != null) {
            if (!lVar.f9486c.isRestricted()) {
                if (lVar.f9487d == null) {
                    lVar.f9487d = l.a(lVar.f9486c);
                }
                menuItem.setOnMenuItemClickListener(new j(this.f9480y, lVar.f9487d));
            } else {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
        }
        if (this.f9473r >= 2) {
            if (menuItem instanceof q) {
                q qVar = (q) menuItem;
                qVar.f10022x = (qVar.f10022x & -5) | 4;
            } else if (menuItem instanceof w) {
                w wVar = (w) menuItem;
                try {
                    Method method = wVar.f10034e;
                    b bVar = wVar.f10033d;
                    if (method == null) {
                        wVar.f10034e = bVar.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
                    }
                    wVar.f10034e.invoke(bVar, new Object[]{Boolean.TRUE});
                } catch (Exception e10) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e10);
                }
            }
        }
        String str2 = this.f9479x;
        if (str2 != null) {
            menuItem.setActionView((View) a(str2, l.f9482e, lVar.f9484a));
            z11 = true;
        }
        int i11 = this.f9478w;
        if (i11 > 0) {
            if (!z11) {
                menuItem.setActionView(i11);
            } else {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            }
        }
        d dVar = this.f9481z;
        if (dVar != null) {
            if (menuItem instanceof b) {
                ((b) menuItem).b(dVar);
            } else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
        CharSequence charSequence = this.A;
        boolean z12 = menuItem instanceof b;
        if (z12) {
            ((b) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            s.h(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.B;
        if (z12) {
            ((b) menuItem).setTooltipText(charSequence2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            s.m(menuItem, charSequence2);
        }
        char c10 = this.f9469n;
        int i12 = this.f9470o;
        if (z12) {
            ((b) menuItem).setAlphabeticShortcut(c10, i12);
        } else if (Build.VERSION.SDK_INT >= 26) {
            s.g(menuItem, c10, i12);
        }
        char c11 = this.f9471p;
        int i13 = this.f9472q;
        if (z12) {
            ((b) menuItem).setNumericShortcut(c11, i13);
        } else if (Build.VERSION.SDK_INT >= 26) {
            s.k(menuItem, c11, i13);
        }
        PorterDuff.Mode mode = this.D;
        if (mode != null) {
            if (z12) {
                ((b) menuItem).setIconTintMode(mode);
            } else if (Build.VERSION.SDK_INT >= 26) {
                s.j(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.C;
        if (colorStateList == null) {
            return;
        }
        if (z12) {
            ((b) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            s.i(menuItem, colorStateList);
        }
    }
}
