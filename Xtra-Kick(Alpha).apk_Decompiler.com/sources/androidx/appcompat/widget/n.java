package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.media.j;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import com.woxthebox.draglistview.R;
import e.a;
import java.util.ArrayList;
import m.b0;
import m.c0;
import m.d0;
import m.e0;
import m.i0;
import m.o;
import m.q;
import m0.d;

public final class n implements c0 {
    public h A;
    public h B;
    public j C;
    public i D;
    public final a E = new a(4, (Object) this);
    public int F;

    /* renamed from: h  reason: collision with root package name */
    public final Context f944h;

    /* renamed from: i  reason: collision with root package name */
    public Context f945i;

    /* renamed from: j  reason: collision with root package name */
    public o f946j;

    /* renamed from: k  reason: collision with root package name */
    public final LayoutInflater f947k;

    /* renamed from: l  reason: collision with root package name */
    public b0 f948l;

    /* renamed from: m  reason: collision with root package name */
    public final int f949m = R.layout.abc_action_menu_layout;

    /* renamed from: n  reason: collision with root package name */
    public final int f950n = R.layout.abc_action_menu_item_layout;

    /* renamed from: o  reason: collision with root package name */
    public e0 f951o;

    /* renamed from: p  reason: collision with root package name */
    public int f952p;

    /* renamed from: q  reason: collision with root package name */
    public k f953q;

    /* renamed from: r  reason: collision with root package name */
    public Drawable f954r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f955s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f956t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f957u;

    /* renamed from: v  reason: collision with root package name */
    public int f958v;

    /* renamed from: w  reason: collision with root package name */
    public int f959w;

    /* renamed from: x  reason: collision with root package name */
    public int f960x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f961y;

    /* renamed from: z  reason: collision with root package name */
    public final SparseBooleanArray f962z = new SparseBooleanArray();

    public n(Context context) {
        this.f944h = context;
        this.f947k = LayoutInflater.from(context);
    }

    public final void a(o oVar, boolean z10) {
        d();
        h hVar = this.B;
        if (hVar != null && hVar.b()) {
            hVar.f9899j.dismiss();
        }
        b0 b0Var = this.f948l;
        if (b0Var != null) {
            b0Var.a(oVar, z10);
        }
    }

    public final View b(q qVar, View view, ViewGroup viewGroup) {
        d0 d0Var;
        View actionView = qVar.getActionView();
        int i10 = 0;
        if (actionView == null || qVar.e()) {
            if (view instanceof d0) {
                d0Var = (d0) view;
            } else {
                d0Var = (d0) this.f947k.inflate(this.f950n, viewGroup, false);
            }
            d0Var.b(qVar);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) d0Var;
            actionMenuItemView.setItemInvoker((ActionMenuView) this.f951o);
            if (this.D == null) {
                this.D = new i(this);
            }
            actionMenuItemView.setPopupCallback(this.D);
            actionView = (View) d0Var;
        }
        if (qVar.C) {
            i10 = 8;
        }
        actionView.setVisibility(i10);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!((ActionMenuView) viewGroup).checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.l(layoutParams));
        }
        return actionView;
    }

    public final void c(Parcelable parcelable) {
        int i10;
        MenuItem findItem;
        if ((parcelable instanceof m) && (i10 = ((m) parcelable).f926h) > 0 && (findItem = this.f946j.findItem(i10)) != null) {
            k((i0) findItem.getSubMenu());
        }
    }

    public final boolean d() {
        e0 e0Var;
        j jVar = this.C;
        if (jVar == null || (e0Var = this.f951o) == null) {
            h hVar = this.A;
            if (hVar == null) {
                return false;
            }
            if (hVar.b()) {
                hVar.f9899j.dismiss();
            }
            return true;
        }
        ((View) e0Var).removeCallbacks(jVar);
        this.C = null;
        return true;
    }

    public final void e(boolean z10) {
        e0 e0Var;
        int i10;
        boolean z11;
        q qVar;
        ViewGroup viewGroup = (ViewGroup) this.f951o;
        ArrayList arrayList = null;
        boolean z12 = false;
        if (viewGroup != null) {
            o oVar = this.f946j;
            if (oVar != null) {
                oVar.i();
                ArrayList l10 = this.f946j.l();
                int size = l10.size();
                i10 = 0;
                for (int i11 = 0; i11 < size; i11++) {
                    q qVar2 = (q) l10.get(i11);
                    if (qVar2.f()) {
                        View childAt = viewGroup.getChildAt(i10);
                        if (childAt instanceof d0) {
                            qVar = ((d0) childAt).getItemData();
                        } else {
                            qVar = null;
                        }
                        View b10 = b(qVar2, childAt, viewGroup);
                        if (qVar2 != qVar) {
                            b10.setPressed(false);
                            b10.jumpDrawablesToCurrentState();
                        }
                        if (b10 != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) b10.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(b10);
                            }
                            ((ViewGroup) this.f951o).addView(b10, i10);
                        }
                        i10++;
                    }
                }
            } else {
                i10 = 0;
            }
            while (i10 < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i10) == this.f953q) {
                    z11 = false;
                } else {
                    viewGroup.removeViewAt(i10);
                    z11 = true;
                }
                if (!z11) {
                    i10++;
                }
            }
        }
        ((View) this.f951o).requestLayout();
        o oVar2 = this.f946j;
        if (oVar2 != null) {
            oVar2.i();
            ArrayList arrayList2 = oVar2.f9980i;
            int size2 = arrayList2.size();
            for (int i12 = 0; i12 < size2; i12++) {
                d dVar = ((q) arrayList2.get(i12)).A;
                if (dVar != null) {
                    dVar.f10062a = this;
                }
            }
        }
        o oVar3 = this.f946j;
        if (oVar3 != null) {
            oVar3.i();
            arrayList = oVar3.f9981j;
        }
        if (this.f956t && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z12 = !((q) arrayList.get(0)).C;
            } else if (size3 > 0) {
                z12 = true;
            }
        }
        k kVar = this.f953q;
        if (z12) {
            if (kVar == null) {
                this.f953q = new k(this, this.f944h);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f953q.getParent();
            if (viewGroup3 != this.f951o) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.f953q);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f951o;
                k kVar2 = this.f953q;
                actionMenuView.getClass();
                q qVar3 = new q();
                qVar3.gravity = 16;
                qVar3.f991a = true;
                actionMenuView.addView(kVar2, qVar3);
            }
        } else if (kVar != null && kVar.getParent() == (e0Var = this.f951o)) {
            ((ViewGroup) e0Var).removeView(this.f953q);
        }
        ((ActionMenuView) this.f951o).setOverflowReserved(this.f956t);
    }

    public final boolean f() {
        h hVar = this.A;
        return hVar != null && hVar.b();
    }

    public final /* bridge */ /* synthetic */ boolean g(q qVar) {
        return false;
    }

    public final int getId() {
        return this.f952p;
    }

    public final void h(Context context, o oVar) {
        this.f945i = context;
        LayoutInflater.from(context);
        this.f946j = oVar;
        Resources resources = context.getResources();
        if (!this.f957u) {
            this.f956t = true;
        }
        int i10 = 2;
        this.f958v = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i11 = configuration.screenWidthDp;
        int i12 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i11 > 600 || ((i11 > 960 && i12 > 720) || (i11 > 720 && i12 > 960))) {
            i10 = 5;
        } else if (i11 >= 500 || ((i11 > 640 && i12 > 480) || (i11 > 480 && i12 > 640))) {
            i10 = 4;
        } else if (i11 >= 360) {
            i10 = 3;
        }
        this.f960x = i10;
        int i13 = this.f958v;
        if (this.f956t) {
            if (this.f953q == null) {
                k kVar = new k(this, this.f944h);
                this.f953q = kVar;
                if (this.f955s) {
                    kVar.setImageDrawable(this.f954r);
                    this.f954r = null;
                    this.f955s = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f953q.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i13 -= this.f953q.getMeasuredWidth();
        } else {
            this.f953q = null;
        }
        this.f959w = i13;
        float f10 = resources.getDisplayMetrics().density;
    }

    public final boolean i() {
        int i10;
        ArrayList arrayList;
        int i11;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        o oVar = this.f946j;
        if (oVar != null) {
            arrayList = oVar.l();
            i10 = arrayList.size();
        } else {
            arrayList = null;
            i10 = 0;
        }
        int i12 = this.f960x;
        int i13 = this.f959w;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f951o;
        int i14 = 0;
        boolean z17 = false;
        int i15 = 0;
        int i16 = 0;
        while (true) {
            i11 = 2;
            z10 = true;
            if (i14 >= i10) {
                break;
            }
            q qVar = (q) arrayList.get(i14);
            int i17 = qVar.f10023y;
            if ((i17 & 2) == 2) {
                z15 = true;
            } else {
                z15 = false;
            }
            if (z15) {
                i15++;
            } else {
                if ((i17 & 1) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    i16++;
                } else {
                    z17 = true;
                }
            }
            if (this.f961y && qVar.C) {
                i12 = 0;
            }
            i14++;
        }
        if (this.f956t && (z17 || i16 + i15 > i12)) {
            i12--;
        }
        int i18 = i12 - i15;
        SparseBooleanArray sparseBooleanArray = this.f962z;
        sparseBooleanArray.clear();
        int i19 = 0;
        int i20 = 0;
        while (i19 < i10) {
            q qVar2 = (q) arrayList.get(i19);
            int i21 = qVar2.f10023y;
            if ((i21 & 2) == i11) {
                z11 = true;
            } else {
                z11 = false;
            }
            int i22 = qVar2.f10000b;
            if (z11) {
                View b10 = b(qVar2, (View) null, viewGroup);
                b10.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = b10.getMeasuredWidth();
                i13 -= measuredWidth;
                if (i20 == 0) {
                    i20 = measuredWidth;
                }
                if (i22 != 0) {
                    sparseBooleanArray.put(i22, z10);
                }
                qVar2.g(z10);
            } else {
                if ((i21 & true) == z10) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    boolean z18 = sparseBooleanArray.get(i22);
                    if ((i18 > 0 || z18) && i13 > 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (z13) {
                        View b11 = b(qVar2, (View) null, viewGroup);
                        b11.measure(makeMeasureSpec, makeMeasureSpec);
                        int measuredWidth2 = b11.getMeasuredWidth();
                        i13 -= measuredWidth2;
                        if (i20 == 0) {
                            i20 = measuredWidth2;
                        }
                        if (i13 + i20 > 0) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        z13 &= z14;
                    }
                    if (z13 && i22 != 0) {
                        sparseBooleanArray.put(i22, true);
                    } else if (z18) {
                        sparseBooleanArray.put(i22, false);
                        for (int i23 = 0; i23 < i19; i23++) {
                            q qVar3 = (q) arrayList.get(i23);
                            if (qVar3.f10000b == i22) {
                                if (qVar3.f()) {
                                    i18++;
                                }
                                qVar3.g(false);
                            }
                        }
                    }
                    if (z13) {
                        i18--;
                    }
                    qVar2.g(z13);
                } else {
                    qVar2.g(false);
                    i19++;
                    i11 = 2;
                    z10 = true;
                }
            }
            i19++;
            i11 = 2;
            z10 = true;
        }
        return true;
    }

    public final Parcelable j() {
        m mVar = new m();
        mVar.f926h = this.F;
        return mVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(m.i0 r9) {
        /*
            r8 = this;
            boolean r0 = r9.hasVisibleItems()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            r0 = r9
        L_0x0009:
            m.o r2 = r0.f9956z
            m.o r3 = r8.f946j
            if (r2 == r3) goto L_0x0013
            r0 = r2
            m.i0 r0 = (m.i0) r0
            goto L_0x0009
        L_0x0013:
            m.e0 r2 = r8.f951o
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            if (r2 != 0) goto L_0x001a
            goto L_0x0038
        L_0x001a:
            int r3 = r2.getChildCount()
            r4 = 0
        L_0x001f:
            if (r4 >= r3) goto L_0x0038
            android.view.View r5 = r2.getChildAt(r4)
            boolean r6 = r5 instanceof m.d0
            if (r6 == 0) goto L_0x0035
            r6 = r5
            m.d0 r6 = (m.d0) r6
            m.q r6 = r6.getItemData()
            m.q r7 = r0.A
            if (r6 != r7) goto L_0x0035
            goto L_0x0039
        L_0x0035:
            int r4 = r4 + 1
            goto L_0x001f
        L_0x0038:
            r5 = 0
        L_0x0039:
            if (r5 != 0) goto L_0x003c
            return r1
        L_0x003c:
            m.q r0 = r9.A
            int r0 = r0.f9999a
            r8.F = r0
            int r0 = r9.size()
            r2 = 0
        L_0x0047:
            r3 = 1
            if (r2 >= r0) goto L_0x005f
            android.view.MenuItem r4 = r9.getItem(r2)
            boolean r6 = r4.isVisible()
            if (r6 == 0) goto L_0x005c
            android.graphics.drawable.Drawable r4 = r4.getIcon()
            if (r4 == 0) goto L_0x005c
            r0 = 1
            goto L_0x0060
        L_0x005c:
            int r2 = r2 + 1
            goto L_0x0047
        L_0x005f:
            r0 = 0
        L_0x0060:
            androidx.appcompat.widget.h r2 = new androidx.appcompat.widget.h
            android.content.Context r4 = r8.f945i
            r2.<init>((androidx.appcompat.widget.n) r8, (android.content.Context) r4, (m.i0) r9, (android.view.View) r5)
            r8.B = r2
            r2.f9897h = r0
            m.x r2 = r2.f9899j
            if (r2 == 0) goto L_0x0072
            r2.q(r0)
        L_0x0072:
            androidx.appcompat.widget.h r0 = r8.B
            boolean r2 = r0.b()
            if (r2 == 0) goto L_0x007b
            goto L_0x0083
        L_0x007b:
            android.view.View r2 = r0.f9895f
            if (r2 != 0) goto L_0x0080
            goto L_0x0084
        L_0x0080:
            r0.d(r1, r1, r1, r1)
        L_0x0083:
            r1 = 1
        L_0x0084:
            if (r1 == 0) goto L_0x008e
            m.b0 r0 = r8.f948l
            if (r0 == 0) goto L_0x008d
            r0.n(r9)
        L_0x008d:
            return r3
        L_0x008e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "MenuPopupHelper cannot be used without an anchor"
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.n.k(m.i0):boolean");
    }

    public final void l(b0 b0Var) {
        this.f948l = b0Var;
    }

    public final /* bridge */ /* synthetic */ boolean m(q qVar) {
        return false;
    }

    public final boolean n() {
        o oVar;
        if (!this.f956t || f() || (oVar = this.f946j) == null || this.f951o == null || this.C != null) {
            return false;
        }
        oVar.i();
        if (oVar.f9981j.isEmpty()) {
            return false;
        }
        j jVar = new j((Object) this, 1, (Object) new h(this, this.f945i, this.f946j, this.f953q));
        this.C = jVar;
        ((View) this.f951o).post(jVar);
        return true;
    }
}
