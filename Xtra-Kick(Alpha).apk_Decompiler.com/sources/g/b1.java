package g;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.d5;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.f2;
import androidx.appcompat.widget.t3;
import com.woxthebox.draglistview.R;
import e.a;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l.b;
import l.m;
import l.n;
import m0.c1;
import m0.l0;
import m0.m0;
import m0.m1;
import m0.n1;
import m0.o0;

public final class b1 extends b implements f {

    /* renamed from: y  reason: collision with root package name */
    public static final AccelerateInterpolator f6025y = new AccelerateInterpolator();

    /* renamed from: z  reason: collision with root package name */
    public static final DecelerateInterpolator f6026z = new DecelerateInterpolator();

    /* renamed from: a  reason: collision with root package name */
    public Context f6027a;

    /* renamed from: b  reason: collision with root package name */
    public Context f6028b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarOverlayLayout f6029c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarContainer f6030d;

    /* renamed from: e  reason: collision with root package name */
    public f2 f6031e;

    /* renamed from: f  reason: collision with root package name */
    public ActionBarContextView f6032f;

    /* renamed from: g  reason: collision with root package name */
    public final View f6033g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6034h;

    /* renamed from: i  reason: collision with root package name */
    public a1 f6035i;

    /* renamed from: j  reason: collision with root package name */
    public a1 f6036j;

    /* renamed from: k  reason: collision with root package name */
    public b f6037k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f6038l;

    /* renamed from: m  reason: collision with root package name */
    public final ArrayList f6039m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    public int f6040n = 0;

    /* renamed from: o  reason: collision with root package name */
    public boolean f6041o = true;

    /* renamed from: p  reason: collision with root package name */
    public boolean f6042p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f6043q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f6044r = true;

    /* renamed from: s  reason: collision with root package name */
    public n f6045s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f6046t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f6047u;

    /* renamed from: v  reason: collision with root package name */
    public final z0 f6048v = new z0(this, 0);

    /* renamed from: w  reason: collision with root package name */
    public final z0 f6049w = new z0(this, 1);

    /* renamed from: x  reason: collision with root package name */
    public final a f6050x = new a(1, (Object) this);

    public b1(Activity activity, boolean z10) {
        new ArrayList();
        View decorView = activity.getWindow().getDecorView();
        d(decorView);
        if (!z10) {
            this.f6033g = decorView.findViewById(16908290);
        }
    }

    public final void a(boolean z10) {
        n1 n1Var;
        n1 n1Var2;
        long j10;
        if (z10) {
            if (!this.f6043q) {
                this.f6043q = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f6029c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                h(false);
            }
        } else if (this.f6043q) {
            this.f6043q = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f6029c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            h(false);
        }
        ActionBarContainer actionBarContainer = this.f6030d;
        WeakHashMap weakHashMap = c1.f10054a;
        if (l0.c(actionBarContainer)) {
            if (z10) {
                d5 d5Var = (d5) this.f6031e;
                n1Var2 = c1.a(d5Var.f791a);
                n1Var2.a(0.0f);
                n1Var2.c(100);
                n1Var2.d(new m(d5Var, 4));
                n1Var = this.f6032f.l(0, 200);
            } else {
                d5 d5Var2 = (d5) this.f6031e;
                n1 a10 = c1.a(d5Var2.f791a);
                a10.a(1.0f);
                a10.c(200);
                a10.d(new m(d5Var2, 0));
                n1 n1Var3 = a10;
                n1Var2 = this.f6032f.l(8, 100);
                n1Var = n1Var3;
            }
            n nVar = new n();
            ArrayList arrayList = nVar.f9492a;
            arrayList.add(n1Var2);
            View view = (View) n1Var2.f10125a.get();
            if (view != null) {
                j10 = view.animate().getDuration();
            } else {
                j10 = 0;
            }
            View view2 = (View) n1Var.f10125a.get();
            if (view2 != null) {
                view2.animate().setStartDelay(j10);
            }
            arrayList.add(n1Var);
            nVar.b();
        } else if (z10) {
            ((d5) this.f6031e).f791a.setVisibility(4);
            this.f6032f.setVisibility(0);
        } else {
            ((d5) this.f6031e).f791a.setVisibility(0);
            this.f6032f.setVisibility(8);
        }
    }

    public final int b() {
        return ((d5) this.f6031e).f792b;
    }

    public final Context c() {
        if (this.f6028b == null) {
            TypedValue typedValue = new TypedValue();
            this.f6027a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f6028b = new ContextThemeWrapper(this.f6027a, i10);
            } else {
                this.f6028b = this.f6027a;
            }
        }
        return this.f6028b;
    }

    public final void d(View view) {
        f2 f2Var;
        boolean z10;
        String str;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        this.f6029c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(R.id.action_bar);
        if (findViewById instanceof f2) {
            f2Var = (f2) findViewById;
        } else if (findViewById instanceof Toolbar) {
            f2Var = ((Toolbar) findViewById).getWrapper();
        } else {
            if (findViewById != null) {
                str = findViewById.getClass().getSimpleName();
            } else {
                str = "null";
            }
            throw new IllegalStateException("Can't make a decor toolbar out of ".concat(str));
        }
        this.f6031e = f2Var;
        this.f6032f = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        this.f6030d = actionBarContainer;
        f2 f2Var2 = this.f6031e;
        if (f2Var2 == null || this.f6032f == null || actionBarContainer == null) {
            throw new IllegalStateException(b1.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        Context context = ((d5) f2Var2).f791a.getContext();
        this.f6027a = context;
        if ((((d5) this.f6031e).f792b & 4) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f6034h = true;
        }
        int i10 = context.getApplicationInfo().targetSdkVersion;
        this.f6031e.getClass();
        f(context.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs));
        TypedArray obtainStyledAttributes = this.f6027a.obtainStyledAttributes((AttributeSet) null, f.a.f5391a, R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f6029c;
            if (actionBarOverlayLayout2.f611o) {
                this.f6047u = true;
                actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
            } else {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f6030d;
            WeakHashMap weakHashMap = c1.f10054a;
            o0.s(actionBarContainer2, (float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public final void e(boolean z10) {
        int i10;
        if (!this.f6034h) {
            if (z10) {
                i10 = 4;
            } else {
                i10 = 0;
            }
            d5 d5Var = (d5) this.f6031e;
            int i11 = d5Var.f792b;
            this.f6034h = true;
            d5Var.a((i10 & 4) | (i11 & -5));
        }
    }

    public final void f(boolean z10) {
        if (!z10) {
            ((d5) this.f6031e).getClass();
            this.f6030d.setTabContainer((t3) null);
        } else {
            this.f6030d.setTabContainer((t3) null);
            ((d5) this.f6031e).getClass();
        }
        this.f6031e.getClass();
        ((d5) this.f6031e).f791a.setCollapsible(false);
        this.f6029c.setHasNonEmbeddedTabs(false);
    }

    public final void g(CharSequence charSequence) {
        d5 d5Var = (d5) this.f6031e;
        if (!d5Var.f797g) {
            d5Var.f798h = charSequence;
            if ((d5Var.f792b & 8) != 0) {
                Toolbar toolbar = d5Var.f791a;
                toolbar.setTitle(charSequence);
                if (d5Var.f797g) {
                    c1.q(toolbar.getRootView(), charSequence);
                }
            }
        }
    }

    public final void h(boolean z10) {
        boolean z11;
        boolean z12 = this.f6042p;
        if (!this.f6043q && z12) {
            z11 = false;
        } else {
            z11 = true;
        }
        a aVar = this.f6050x;
        x7.a aVar2 = null;
        View view = this.f6033g;
        if (z11) {
            if (!this.f6044r) {
                this.f6044r = true;
                n nVar = this.f6045s;
                if (nVar != null) {
                    nVar.a();
                }
                this.f6030d.setVisibility(0);
                int i10 = this.f6040n;
                z0 z0Var = this.f6049w;
                if (i10 != 0 || (!this.f6046t && !z10)) {
                    this.f6030d.setAlpha(1.0f);
                    this.f6030d.setTranslationY(0.0f);
                    if (this.f6041o && view != null) {
                        view.setTranslationY(0.0f);
                    }
                    z0Var.a();
                } else {
                    this.f6030d.setTranslationY(0.0f);
                    float f10 = (float) (-this.f6030d.getHeight());
                    if (z10) {
                        int[] iArr = {0, 0};
                        this.f6030d.getLocationInWindow(iArr);
                        f10 -= (float) iArr[1];
                    }
                    this.f6030d.setTranslationY(f10);
                    n nVar2 = new n();
                    n1 a10 = c1.a(this.f6030d);
                    a10.e(0.0f);
                    View view2 = (View) a10.f10125a.get();
                    if (view2 != null) {
                        if (aVar != null) {
                            aVar2 = new x7.a(aVar, 2, view2);
                        }
                        m1.a(view2.animate(), aVar2);
                    }
                    boolean z13 = nVar2.f9496e;
                    ArrayList arrayList = nVar2.f9492a;
                    if (!z13) {
                        arrayList.add(a10);
                    }
                    if (this.f6041o && view != null) {
                        view.setTranslationY(f10);
                        n1 a11 = c1.a(view);
                        a11.e(0.0f);
                        if (!nVar2.f9496e) {
                            arrayList.add(a11);
                        }
                    }
                    DecelerateInterpolator decelerateInterpolator = f6026z;
                    boolean z14 = nVar2.f9496e;
                    if (!z14) {
                        nVar2.f9494c = decelerateInterpolator;
                    }
                    if (!z14) {
                        nVar2.f9493b = 250;
                    }
                    if (!z14) {
                        nVar2.f9495d = z0Var;
                    }
                    this.f6045s = nVar2;
                    nVar2.b();
                }
                ActionBarOverlayLayout actionBarOverlayLayout = this.f6029c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = c1.f10054a;
                    m0.c(actionBarOverlayLayout);
                }
            }
        } else if (this.f6044r) {
            this.f6044r = false;
            n nVar3 = this.f6045s;
            if (nVar3 != null) {
                nVar3.a();
            }
            int i11 = this.f6040n;
            z0 z0Var2 = this.f6048v;
            if (i11 != 0 || (!this.f6046t && !z10)) {
                z0Var2.a();
                return;
            }
            this.f6030d.setAlpha(1.0f);
            this.f6030d.setTransitioning(true);
            n nVar4 = new n();
            float f11 = (float) (-this.f6030d.getHeight());
            if (z10) {
                int[] iArr2 = {0, 0};
                this.f6030d.getLocationInWindow(iArr2);
                f11 -= (float) iArr2[1];
            }
            n1 a12 = c1.a(this.f6030d);
            a12.e(f11);
            View view3 = (View) a12.f10125a.get();
            if (view3 != null) {
                if (aVar != null) {
                    aVar2 = new x7.a(aVar, 2, view3);
                }
                m1.a(view3.animate(), aVar2);
            }
            boolean z15 = nVar4.f9496e;
            ArrayList arrayList2 = nVar4.f9492a;
            if (!z15) {
                arrayList2.add(a12);
            }
            if (this.f6041o && view != null) {
                n1 a13 = c1.a(view);
                a13.e(f11);
                if (!nVar4.f9496e) {
                    arrayList2.add(a13);
                }
            }
            AccelerateInterpolator accelerateInterpolator = f6025y;
            boolean z16 = nVar4.f9496e;
            if (!z16) {
                nVar4.f9494c = accelerateInterpolator;
            }
            if (!z16) {
                nVar4.f9493b = 250;
            }
            if (!z16) {
                nVar4.f9495d = z0Var2;
            }
            this.f6045s = nVar4;
            nVar4.b();
        }
    }

    public b1(Dialog dialog) {
        new ArrayList();
        d(dialog.getWindow().getDecorView());
    }
}
