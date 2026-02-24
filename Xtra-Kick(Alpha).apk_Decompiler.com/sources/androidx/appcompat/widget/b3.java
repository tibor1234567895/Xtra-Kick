package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView;
import com.woxthebox.draglistview.R;
import f.a;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import m.g0;
import m0.c1;
import m0.l0;
import q0.p;
import q0.s;

public class b3 implements g0 {
    public static final Method H;
    public static final Method I;
    public static final Method J;
    public final z2 A;
    public final u2 B;
    public final Handler C;
    public final Rect D;
    public Rect E;
    public boolean F;
    public final q0 G;

    /* renamed from: h  reason: collision with root package name */
    public final Context f751h;

    /* renamed from: i  reason: collision with root package name */
    public ListAdapter f752i;

    /* renamed from: j  reason: collision with root package name */
    public o2 f753j;

    /* renamed from: k  reason: collision with root package name */
    public final int f754k;

    /* renamed from: l  reason: collision with root package name */
    public int f755l;

    /* renamed from: m  reason: collision with root package name */
    public int f756m;

    /* renamed from: n  reason: collision with root package name */
    public int f757n;

    /* renamed from: o  reason: collision with root package name */
    public final int f758o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f759p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f760q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f761r;

    /* renamed from: s  reason: collision with root package name */
    public int f762s;

    /* renamed from: t  reason: collision with root package name */
    public final int f763t;

    /* renamed from: u  reason: collision with root package name */
    public y2 f764u;

    /* renamed from: v  reason: collision with root package name */
    public View f765v;

    /* renamed from: w  reason: collision with root package name */
    public AdapterView.OnItemClickListener f766w;

    /* renamed from: x  reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f767x;

    /* renamed from: y  reason: collision with root package name */
    public final u2 f768y;

    /* renamed from: z  reason: collision with root package name */
    public final a3 f769z;

    static {
        Class<PopupWindow> cls = PopupWindow.class;
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                H = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                J = cls.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                I = cls.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public b3(Context context) {
        this(context, (AttributeSet) null, R.attr.listPopupWindowStyle, 0);
    }

    public o2 a(Context context, boolean z10) {
        return new o2(context, z10);
    }

    public final boolean b() {
        return this.G.isShowing();
    }

    public final int c() {
        return this.f756m;
    }

    public final void d() {
        int i10;
        boolean z10;
        int i11;
        int i12;
        boolean z11;
        o2 o2Var;
        int i13;
        int i14;
        int i15;
        int i16;
        o2 o2Var2 = this.f753j;
        q0 q0Var = this.G;
        int i17 = 0;
        Context context = this.f751h;
        if (o2Var2 == null) {
            o2 a10 = a(context, !this.F);
            this.f753j = a10;
            a10.setAdapter(this.f752i);
            this.f753j.setOnItemClickListener(this.f766w);
            this.f753j.setFocusable(true);
            this.f753j.setFocusableInTouchMode(true);
            this.f753j.setOnItemSelectedListener(new v2(0, this));
            this.f753j.setOnScrollListener(this.A);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f767x;
            if (onItemSelectedListener != null) {
                this.f753j.setOnItemSelectedListener(onItemSelectedListener);
            }
            q0Var.setContentView(this.f753j);
        } else {
            ViewGroup viewGroup = (ViewGroup) q0Var.getContentView();
        }
        Drawable background = q0Var.getBackground();
        Rect rect = this.D;
        if (background != null) {
            background.getPadding(rect);
            int i18 = rect.top;
            i10 = rect.bottom + i18;
            if (!this.f759p) {
                this.f757n = -i18;
            }
        } else {
            rect.setEmpty();
            i10 = 0;
        }
        if (q0Var.getInputMethodMode() == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        View view = this.f765v;
        int i19 = this.f757n;
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = I;
            if (method != null) {
                try {
                    i11 = ((Integer) method.invoke(q0Var, new Object[]{view, Integer.valueOf(i19), Boolean.valueOf(z10)})).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            i11 = q0Var.getMaxAvailableHeight(view, i19);
        } else {
            i11 = w2.a(q0Var, view, i19, z10);
        }
        int i20 = this.f754k;
        if (i20 == -1) {
            i12 = i11 + i10;
        } else {
            int i21 = this.f755l;
            if (i21 == -2) {
                i15 = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), RecyclerView.UNDEFINED_DURATION);
            } else if (i21 != -1) {
                i15 = View.MeasureSpec.makeMeasureSpec(i21, 1073741824);
            } else {
                i15 = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824);
            }
            int a11 = this.f753j.a(i15, i11 + 0);
            if (a11 > 0) {
                i16 = this.f753j.getPaddingBottom() + this.f753j.getPaddingTop() + i10 + 0;
            } else {
                i16 = 0;
            }
            i12 = a11 + i16;
        }
        if (q0Var.getInputMethodMode() == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        s.b(q0Var, this.f758o);
        if (q0Var.isShowing()) {
            View view2 = this.f765v;
            WeakHashMap weakHashMap = c1.f10054a;
            if (l0.b(view2)) {
                int i22 = this.f755l;
                if (i22 == -1) {
                    i22 = -1;
                } else if (i22 == -2) {
                    i22 = this.f765v.getWidth();
                }
                if (i20 == -1) {
                    if (z11) {
                        i20 = i12;
                    } else {
                        i20 = -1;
                    }
                    int i23 = this.f755l;
                    if (z11) {
                        if (i23 == -1) {
                            i14 = -1;
                        } else {
                            i14 = 0;
                        }
                        q0Var.setWidth(i14);
                        q0Var.setHeight(0);
                    } else {
                        if (i23 == -1) {
                            i17 = -1;
                        }
                        q0Var.setWidth(i17);
                        q0Var.setHeight(-1);
                    }
                } else if (i20 == -2) {
                    i20 = i12;
                }
                q0Var.setOutsideTouchable(true);
                View view3 = this.f765v;
                int i24 = this.f756m;
                int i25 = this.f757n;
                if (i22 < 0) {
                    i22 = -1;
                }
                if (i20 < 0) {
                    i13 = -1;
                } else {
                    i13 = i20;
                }
                q0Var.update(view3, i24, i25, i22, i13);
                return;
            }
            return;
        }
        int i26 = this.f755l;
        if (i26 == -1) {
            i26 = -1;
        } else if (i26 == -2) {
            i26 = this.f765v.getWidth();
        }
        if (i20 == -1) {
            i20 = -1;
        } else if (i20 == -2) {
            i20 = i12;
        }
        q0Var.setWidth(i26);
        q0Var.setHeight(i20);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = H;
            if (method2 != null) {
                try {
                    method2.invoke(q0Var, new Object[]{Boolean.TRUE});
                } catch (Exception unused2) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            x2.b(q0Var, true);
        }
        q0Var.setOutsideTouchable(true);
        q0Var.setTouchInterceptor(this.f769z);
        if (this.f761r) {
            s.a(q0Var, this.f760q);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method3 = J;
            if (method3 != null) {
                try {
                    method3.invoke(q0Var, new Object[]{this.E});
                } catch (Exception e10) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e10);
                }
            }
        } else {
            x2.a(q0Var, this.E);
        }
        p.a(q0Var, this.f765v, this.f756m, this.f757n, this.f762s);
        this.f753j.setSelection(-1);
        if ((!this.F || this.f753j.isInTouchMode()) && (o2Var = this.f753j) != null) {
            o2Var.setListSelectionHidden(true);
            o2Var.requestLayout();
        }
        if (!this.F) {
            this.C.post(this.B);
        }
    }

    public final void dismiss() {
        q0 q0Var = this.G;
        q0Var.dismiss();
        q0Var.setContentView((View) null);
        this.f753j = null;
        this.C.removeCallbacks(this.f768y);
    }

    public final Drawable e() {
        return this.G.getBackground();
    }

    public final o2 f() {
        return this.f753j;
    }

    public final void i(Drawable drawable) {
        this.G.setBackgroundDrawable(drawable);
    }

    public final void j(int i10) {
        this.f757n = i10;
        this.f759p = true;
    }

    public final void l(int i10) {
        this.f756m = i10;
    }

    public final int n() {
        if (!this.f759p) {
            return 0;
        }
        return this.f757n;
    }

    public void p(ListAdapter listAdapter) {
        y2 y2Var = this.f764u;
        if (y2Var == null) {
            this.f764u = new y2(0, this);
        } else {
            ListAdapter listAdapter2 = this.f752i;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(y2Var);
            }
        }
        this.f752i = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f764u);
        }
        o2 o2Var = this.f753j;
        if (o2Var != null) {
            o2Var.setAdapter(this.f752i);
        }
    }

    public final void q(int i10) {
        Drawable background = this.G.getBackground();
        if (background != null) {
            Rect rect = this.D;
            background.getPadding(rect);
            this.f755l = rect.left + rect.right + i10;
            return;
        }
        this.f755l = i10;
    }

    public b3(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f754k = -2;
        this.f755l = -2;
        this.f758o = 1002;
        this.f762s = 0;
        this.f763t = Integer.MAX_VALUE;
        this.f768y = new u2(this, 2);
        this.f769z = new a3(0, this);
        this.A = new z2(this);
        this.B = new u2(this, 1);
        this.D = new Rect();
        this.f751h = context;
        this.C = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f5406p, i10, i11);
        this.f756m = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f757n = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f759p = true;
        }
        obtainStyledAttributes.recycle();
        q0 q0Var = new q0(context, attributeSet, i10, i11);
        this.G = q0Var;
        q0Var.setInputMethodMode(1);
    }
}
