package m;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.widget.d3;
import androidx.appcompat.widget.h3;
import androidx.appcompat.widget.o2;
import com.woxthebox.draglistview.R;
import e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import m0.c1;
import m0.j0;

public final class i extends x implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public b0 E;
    public ViewTreeObserver F;
    public PopupWindow.OnDismissListener G;
    public boolean H;

    /* renamed from: i  reason: collision with root package name */
    public final Context f9938i;

    /* renamed from: j  reason: collision with root package name */
    public final int f9939j;

    /* renamed from: k  reason: collision with root package name */
    public final int f9940k;

    /* renamed from: l  reason: collision with root package name */
    public final int f9941l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f9942m;

    /* renamed from: n  reason: collision with root package name */
    public final Handler f9943n;

    /* renamed from: o  reason: collision with root package name */
    public final ArrayList f9944o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public final ArrayList f9945p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    public final e f9946q;

    /* renamed from: r  reason: collision with root package name */
    public final f f9947r;

    /* renamed from: s  reason: collision with root package name */
    public final a f9948s;

    /* renamed from: t  reason: collision with root package name */
    public int f9949t;

    /* renamed from: u  reason: collision with root package name */
    public int f9950u;

    /* renamed from: v  reason: collision with root package name */
    public View f9951v;

    /* renamed from: w  reason: collision with root package name */
    public View f9952w;

    /* renamed from: x  reason: collision with root package name */
    public int f9953x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f9954y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f9955z;

    public i(Context context, View view, int i10, int i11, boolean z10) {
        int i12 = 0;
        this.f9946q = new e(0, this);
        this.f9947r = new f(0, this);
        this.f9948s = new a(2, (Object) this);
        this.f9949t = 0;
        this.f9950u = 0;
        this.f9938i = context;
        this.f9951v = view;
        this.f9940k = i10;
        this.f9941l = i11;
        this.f9942m = z10;
        this.C = false;
        WeakHashMap weakHashMap = c1.f10054a;
        this.f9953x = j0.d(view) != 1 ? 1 : i12;
        Resources resources = context.getResources();
        this.f9939j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f9943n = new Handler();
    }

    public final void a(o oVar, boolean z10) {
        int i10;
        ArrayList arrayList = this.f9945p;
        int size = arrayList.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                i11 = -1;
                break;
            } else if (oVar == ((h) arrayList.get(i11)).f9918b) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 >= 0) {
            int i12 = i11 + 1;
            if (i12 < arrayList.size()) {
                ((h) arrayList.get(i12)).f9918b.c(false);
            }
            h hVar = (h) arrayList.remove(i11);
            hVar.f9918b.r(this);
            boolean z11 = this.H;
            h3 h3Var = hVar.f9917a;
            if (z11) {
                if (Build.VERSION.SDK_INT >= 23) {
                    d3.b(h3Var.G, (Transition) null);
                } else {
                    h3Var.getClass();
                }
                h3Var.G.setAnimationStyle(0);
            }
            h3Var.dismiss();
            int size2 = arrayList.size();
            if (size2 > 0) {
                i10 = ((h) arrayList.get(size2 - 1)).f9919c;
            } else {
                View view = this.f9951v;
                WeakHashMap weakHashMap = c1.f10054a;
                if (j0.d(view) == 1) {
                    i10 = 0;
                } else {
                    i10 = 1;
                }
            }
            this.f9953x = i10;
            if (size2 == 0) {
                dismiss();
                b0 b0Var = this.E;
                if (b0Var != null) {
                    b0Var.a(oVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.F;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.F.removeGlobalOnLayoutListener(this.f9946q);
                    }
                    this.F = null;
                }
                this.f9952w.removeOnAttachStateChangeListener(this.f9947r);
                this.G.onDismiss();
            } else if (z10) {
                ((h) arrayList.get(0)).f9918b.c(false);
            }
        }
    }

    public final boolean b() {
        ArrayList arrayList = this.f9945p;
        return arrayList.size() > 0 && ((h) arrayList.get(0)).f9917a.b();
    }

    public final void c(Parcelable parcelable) {
    }

    public final void d() {
        if (!b()) {
            ArrayList arrayList = this.f9944o;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                x((o) it.next());
            }
            arrayList.clear();
            View view = this.f9951v;
            this.f9952w = view;
            if (view != null) {
                boolean z10 = this.F == null;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.F = viewTreeObserver;
                if (z10) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f9946q);
                }
                this.f9952w.addOnAttachStateChangeListener(this.f9947r);
            }
        }
    }

    public final void dismiss() {
        ArrayList arrayList = this.f9945p;
        int size = arrayList.size();
        if (size > 0) {
            h[] hVarArr = (h[]) arrayList.toArray(new h[size]);
            while (true) {
                size--;
                if (size >= 0) {
                    h hVar = hVarArr[size];
                    if (hVar.f9917a.b()) {
                        hVar.f9917a.dismiss();
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final void e(boolean z10) {
        Iterator it = this.f9945p.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((h) it.next()).f9917a.f753j.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((l) adapter).notifyDataSetChanged();
        }
    }

    public final o2 f() {
        ArrayList arrayList = this.f9945p;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((h) arrayList.get(arrayList.size() - 1)).f9917a.f753j;
    }

    public final boolean i() {
        return false;
    }

    public final Parcelable j() {
        return null;
    }

    public final boolean k(i0 i0Var) {
        Iterator it = this.f9945p.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (i0Var == hVar.f9918b) {
                hVar.f9917a.f753j.requestFocus();
                return true;
            }
        }
        if (!i0Var.hasVisibleItems()) {
            return false;
        }
        n(i0Var);
        b0 b0Var = this.E;
        if (b0Var != null) {
            b0Var.n(i0Var);
        }
        return true;
    }

    public final void l(b0 b0Var) {
        this.E = b0Var;
    }

    public final void n(o oVar) {
        oVar.b(this, this.f9938i);
        if (b()) {
            x(oVar);
        } else {
            this.f9944o.add(oVar);
        }
    }

    public final void onDismiss() {
        h hVar;
        ArrayList arrayList = this.f9945p;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                hVar = null;
                break;
            }
            hVar = (h) arrayList.get(i10);
            if (!hVar.f9917a.b()) {
                break;
            }
            i10++;
        }
        if (hVar != null) {
            hVar.f9918b.c(false);
        }
    }

    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public final void p(View view) {
        if (this.f9951v != view) {
            this.f9951v = view;
            int i10 = this.f9949t;
            WeakHashMap weakHashMap = c1.f10054a;
            this.f9950u = Gravity.getAbsoluteGravity(i10, j0.d(view));
        }
    }

    public final void q(boolean z10) {
        this.C = z10;
    }

    public final void r(int i10) {
        if (this.f9949t != i10) {
            this.f9949t = i10;
            View view = this.f9951v;
            WeakHashMap weakHashMap = c1.f10054a;
            this.f9950u = Gravity.getAbsoluteGravity(i10, j0.d(view));
        }
    }

    public final void s(int i10) {
        this.f9954y = true;
        this.A = i10;
    }

    public final void t(PopupWindow.OnDismissListener onDismissListener) {
        this.G = onDismissListener;
    }

    public final void u(boolean z10) {
        this.D = z10;
    }

    public final void v(int i10) {
        this.f9955z = true;
        this.B = i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0140, code lost:
        if (((r2.getWidth() + r11[0]) + r5) > r10.right) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0147, code lost:
        if ((r11[0] - r5) < 0) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x014c, code lost:
        r2 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void x(m.o r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            android.content.Context r2 = r0.f9938i
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r2)
            m.l r4 = new m.l
            boolean r5 = r0.f9942m
            r6 = 2131558411(0x7f0d000b, float:1.8742137E38)
            r4.<init>(r1, r3, r5, r6)
            boolean r5 = r17.b()
            r6 = 1
            if (r5 != 0) goto L_0x0022
            boolean r5 = r0.C
            if (r5 == 0) goto L_0x0022
            r4.f9967j = r6
            goto L_0x002e
        L_0x0022:
            boolean r5 = r17.b()
            if (r5 == 0) goto L_0x002e
            boolean r5 = m.x.w(r18)
            r4.f9967j = r5
        L_0x002e:
            int r5 = r0.f9939j
            int r5 = m.x.o(r4, r2, r5)
            androidx.appcompat.widget.h3 r7 = new androidx.appcompat.widget.h3
            int r8 = r0.f9940k
            int r9 = r0.f9941l
            r7.<init>(r2, r8, r9)
            e.a r2 = r0.f9948s
            r7.K = r2
            r7.f766w = r0
            androidx.appcompat.widget.q0 r2 = r7.G
            r2.setOnDismissListener(r0)
            android.view.View r8 = r0.f9951v
            r7.f765v = r8
            int r8 = r0.f9950u
            r7.f762s = r8
            r7.F = r6
            r2.setFocusable(r6)
            r8 = 2
            r2.setInputMethodMode(r8)
            r7.p(r4)
            r7.q(r5)
            int r4 = r0.f9950u
            r7.f762s = r4
            java.util.ArrayList r4 = r0.f9945p
            int r9 = r4.size()
            if (r9 <= 0) goto L_0x00e0
            int r9 = r4.size()
            int r9 = r9 - r6
            java.lang.Object r9 = r4.get(r9)
            m.h r9 = (m.h) r9
            m.o r12 = r9.f9918b
            int r13 = r12.size()
            r14 = 0
        L_0x007d:
            if (r14 >= r13) goto L_0x0094
            android.view.MenuItem r15 = r12.getItem(r14)
            boolean r16 = r15.hasSubMenu()
            if (r16 == 0) goto L_0x0090
            android.view.SubMenu r8 = r15.getSubMenu()
            if (r1 != r8) goto L_0x0090
            goto L_0x0095
        L_0x0090:
            int r14 = r14 + 1
            r8 = 2
            goto L_0x007d
        L_0x0094:
            r15 = 0
        L_0x0095:
            if (r15 != 0) goto L_0x0099
        L_0x0097:
            r6 = 0
            goto L_0x00e2
        L_0x0099:
            androidx.appcompat.widget.h3 r8 = r9.f9917a
            androidx.appcompat.widget.o2 r8 = r8.f753j
            android.widget.ListAdapter r12 = r8.getAdapter()
            boolean r13 = r12 instanceof android.widget.HeaderViewListAdapter
            if (r13 == 0) goto L_0x00b2
            android.widget.HeaderViewListAdapter r12 = (android.widget.HeaderViewListAdapter) r12
            int r13 = r12.getHeadersCount()
            android.widget.ListAdapter r12 = r12.getWrappedAdapter()
            m.l r12 = (m.l) r12
            goto L_0x00b5
        L_0x00b2:
            m.l r12 = (m.l) r12
            r13 = 0
        L_0x00b5:
            int r14 = r12.getCount()
            r10 = 0
        L_0x00ba:
            r11 = -1
            if (r10 >= r14) goto L_0x00c8
            m.q r6 = r12.getItem(r10)
            if (r15 != r6) goto L_0x00c4
            goto L_0x00c9
        L_0x00c4:
            int r10 = r10 + 1
            r6 = 1
            goto L_0x00ba
        L_0x00c8:
            r10 = -1
        L_0x00c9:
            if (r10 != r11) goto L_0x00cc
            goto L_0x0097
        L_0x00cc:
            int r10 = r10 + r13
            int r6 = r8.getFirstVisiblePosition()
            int r10 = r10 - r6
            if (r10 < 0) goto L_0x0097
            int r6 = r8.getChildCount()
            if (r10 < r6) goto L_0x00db
            goto L_0x0097
        L_0x00db:
            android.view.View r6 = r8.getChildAt(r10)
            goto L_0x00e2
        L_0x00e0:
            r6 = 0
            r9 = 0
        L_0x00e2:
            if (r6 == 0) goto L_0x01b7
            int r8 = android.os.Build.VERSION.SDK_INT
            r10 = 28
            if (r8 > r10) goto L_0x0102
            java.lang.reflect.Method r8 = androidx.appcompat.widget.h3.L
            if (r8 == 0) goto L_0x0106
            r10 = 1
            java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x00fa }
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x00fa }
            r12 = 0
            r11[r12] = r10     // Catch:{ Exception -> 0x00fa }
            r8.invoke(r2, r11)     // Catch:{ Exception -> 0x00fa }
            goto L_0x0106
        L_0x00fa:
            java.lang.String r8 = "MenuPopupWindow"
            java.lang.String r10 = "Could not invoke setTouchModal() on PopupWindow. Oh well."
            android.util.Log.i(r8, r10)
            goto L_0x0106
        L_0x0102:
            r8 = 0
            androidx.appcompat.widget.e3.a(r2, r8)
        L_0x0106:
            int r8 = android.os.Build.VERSION.SDK_INT
            r10 = 23
            if (r8 < r10) goto L_0x0110
            r10 = 0
            androidx.appcompat.widget.d3.a(r2, r10)
        L_0x0110:
            int r2 = r4.size()
            r10 = 1
            int r2 = r2 - r10
            java.lang.Object r2 = r4.get(r2)
            m.h r2 = (m.h) r2
            androidx.appcompat.widget.h3 r2 = r2.f9917a
            androidx.appcompat.widget.o2 r2 = r2.f753j
            r10 = 2
            int[] r11 = new int[r10]
            r2.getLocationOnScreen(r11)
            android.graphics.Rect r10 = new android.graphics.Rect
            r10.<init>()
            android.view.View r12 = r0.f9952w
            r12.getWindowVisibleDisplayFrame(r10)
            int r12 = r0.f9953x
            r13 = 1
            if (r12 != r13) goto L_0x0143
            r12 = 0
            r11 = r11[r12]
            int r2 = r2.getWidth()
            int r2 = r2 + r11
            int r2 = r2 + r5
            int r10 = r10.right
            if (r2 <= r10) goto L_0x0149
            goto L_0x014c
        L_0x0143:
            r12 = 0
            r2 = r11[r12]
            int r2 = r2 - r5
            if (r2 >= 0) goto L_0x014c
        L_0x0149:
            r2 = 1
        L_0x014a:
            r10 = 1
            goto L_0x014e
        L_0x014c:
            r2 = 0
            goto L_0x014a
        L_0x014e:
            if (r2 != r10) goto L_0x0152
            r10 = 1
            goto L_0x0153
        L_0x0152:
            r10 = 0
        L_0x0153:
            r0.f9953x = r2
            r2 = 26
            r11 = 5
            if (r8 < r2) goto L_0x015f
            r7.f765v = r6
            r2 = 0
            r12 = 0
            goto L_0x0195
        L_0x015f:
            r2 = 2
            int[] r8 = new int[r2]
            android.view.View r12 = r0.f9951v
            r12.getLocationOnScreen(r8)
            int[] r2 = new int[r2]
            r6.getLocationOnScreen(r2)
            int r12 = r0.f9950u
            r12 = r12 & 7
            if (r12 != r11) goto L_0x0188
            r12 = 0
            r13 = r8[r12]
            android.view.View r14 = r0.f9951v
            int r14 = r14.getWidth()
            int r14 = r14 + r13
            r8[r12] = r14
            r13 = r2[r12]
            int r14 = r6.getWidth()
            int r14 = r14 + r13
            r2[r12] = r14
            goto L_0x0189
        L_0x0188:
            r12 = 0
        L_0x0189:
            r13 = r2[r12]
            r14 = r8[r12]
            int r12 = r13 - r14
            r13 = 1
            r2 = r2[r13]
            r8 = r8[r13]
            int r2 = r2 - r8
        L_0x0195:
            int r8 = r0.f9950u
            r8 = r8 & r11
            if (r8 != r11) goto L_0x01a3
            if (r10 == 0) goto L_0x019e
            int r12 = r12 + r5
            goto L_0x01ac
        L_0x019e:
            int r5 = r6.getWidth()
            goto L_0x01ab
        L_0x01a3:
            if (r10 == 0) goto L_0x01ab
            int r5 = r6.getWidth()
            int r12 = r12 + r5
            goto L_0x01ac
        L_0x01ab:
            int r12 = r12 - r5
        L_0x01ac:
            r7.f756m = r12
            r5 = 1
            r7.f761r = r5
            r7.f760q = r5
            r7.j(r2)
            goto L_0x01d5
        L_0x01b7:
            boolean r2 = r0.f9954y
            if (r2 == 0) goto L_0x01bf
            int r2 = r0.A
            r7.f756m = r2
        L_0x01bf:
            boolean r2 = r0.f9955z
            if (r2 == 0) goto L_0x01c8
            int r2 = r0.B
            r7.j(r2)
        L_0x01c8:
            android.graphics.Rect r2 = r0.f10035h
            if (r2 == 0) goto L_0x01d2
            android.graphics.Rect r10 = new android.graphics.Rect
            r10.<init>(r2)
            goto L_0x01d3
        L_0x01d2:
            r10 = 0
        L_0x01d3:
            r7.E = r10
        L_0x01d5:
            m.h r2 = new m.h
            int r5 = r0.f9953x
            r2.<init>(r7, r1, r5)
            r4.add(r2)
            r7.d()
            androidx.appcompat.widget.o2 r2 = r7.f753j
            r2.setOnKeyListener(r0)
            if (r9 != 0) goto L_0x0213
            boolean r4 = r0.D
            if (r4 == 0) goto L_0x0213
            java.lang.CharSequence r4 = r1.f9984m
            if (r4 == 0) goto L_0x0213
            r4 = 2131558418(0x7f0d0012, float:1.8742151E38)
            r5 = 0
            android.view.View r3 = r3.inflate(r4, r2, r5)
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            r4 = 16908310(0x1020016, float:2.387729E-38)
            android.view.View r4 = r3.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r3.setEnabled(r5)
            java.lang.CharSequence r1 = r1.f9984m
            r4.setText(r1)
            r1 = 0
            r2.addHeaderView(r3, r1, r5)
            r7.d()
        L_0x0213:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m.i.x(m.o):void");
    }
}
