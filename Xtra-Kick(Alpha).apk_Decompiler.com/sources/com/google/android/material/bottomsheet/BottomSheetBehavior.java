package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import b8.a;
import b8.d;
import b8.e;
import com.woxthebox.draglistview.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import m0.c;
import m0.c1;
import m0.o0;
import n0.g;
import t8.i;
import t8.n;
import u0.h;
import z.b;

public class BottomSheetBehavior<V extends View> extends b {
    public final e A = new e(this, 0);
    public ValueAnimator B;
    public int C;
    public int D;
    public int E;
    public float F = 0.5f;
    public int G;
    public final float H = -1.0f;
    public boolean I;
    public boolean J;
    public boolean K = true;
    public int L = 4;
    public h M;
    public boolean N;
    public int O;
    public boolean P;
    public final float Q = 0.1f;
    public int R;
    public int S;
    public int T;
    public WeakReference U;
    public WeakReference V;
    public final ArrayList W = new ArrayList();
    public VelocityTracker X;
    public int Y;
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    public int f3661a = 0;

    /* renamed from: a0  reason: collision with root package name */
    public boolean f3662a0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3663b = true;

    /* renamed from: b0  reason: collision with root package name */
    public HashMap f3664b0;

    /* renamed from: c  reason: collision with root package name */
    public final float f3665c;

    /* renamed from: c0  reason: collision with root package name */
    public final SparseIntArray f3666c0 = new SparseIntArray();

    /* renamed from: d  reason: collision with root package name */
    public int f3667d;

    /* renamed from: d0  reason: collision with root package name */
    public final a f3668d0 = new a(this);

    /* renamed from: e  reason: collision with root package name */
    public int f3669e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3670f;

    /* renamed from: g  reason: collision with root package name */
    public int f3671g;

    /* renamed from: h  reason: collision with root package name */
    public final int f3672h;

    /* renamed from: i  reason: collision with root package name */
    public i f3673i;

    /* renamed from: j  reason: collision with root package name */
    public final ColorStateList f3674j;

    /* renamed from: k  reason: collision with root package name */
    public int f3675k = -1;

    /* renamed from: l  reason: collision with root package name */
    public int f3676l = -1;

    /* renamed from: m  reason: collision with root package name */
    public int f3677m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f3678n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f3679o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f3680p;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f3681q;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f3682r;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f3683s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f3684t;

    /* renamed from: u  reason: collision with root package name */
    public final boolean f3685u;

    /* renamed from: v  reason: collision with root package name */
    public int f3686v;

    /* renamed from: w  reason: collision with root package name */
    public int f3687w;

    /* renamed from: x  reason: collision with root package name */
    public final boolean f3688x;

    /* renamed from: y  reason: collision with root package name */
    public final n f3689y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f3690z;

    public BottomSheetBehavior() {
    }

    public static View v(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        WeakHashMap weakHashMap = c1.f10054a;
        if (o0.p(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View v10 = v(viewGroup.getChildAt(i10));
                if (v10 != null) {
                    return v10;
                }
            }
        }
        return null;
    }

    public static BottomSheetBehavior w(FrameLayout frameLayout) {
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams instanceof z.e) {
            b bVar = ((z.e) layoutParams).f17322a;
            if (bVar instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) bVar;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public final void A(View view, g gVar, int i10) {
        c1.n(view, gVar, new j0.h(i10, (Object) this));
    }

    public final void B(int i10) {
        if (i10 >= 0) {
            this.C = i10;
            J(this.L, true);
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public final void C(boolean z10) {
        if (this.I != z10) {
            this.I = z10;
            if (!z10 && this.L == 5) {
                E(4);
            }
            I();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void D(int r4) {
        /*
            r3 = this;
            r0 = 0
            r1 = -1
            r2 = 1
            if (r4 != r1) goto L_0x000c
            boolean r4 = r3.f3670f
            if (r4 != 0) goto L_0x001d
            r3.f3670f = r2
            goto L_0x001c
        L_0x000c:
            boolean r1 = r3.f3670f
            if (r1 != 0) goto L_0x0014
            int r1 = r3.f3669e
            if (r1 == r4) goto L_0x001d
        L_0x0014:
            r3.f3670f = r0
            int r4 = java.lang.Math.max(r0, r4)
            r3.f3669e = r4
        L_0x001c:
            r0 = 1
        L_0x001d:
            if (r0 == 0) goto L_0x0022
            r3.L()
        L_0x0022:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.D(int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005f, code lost:
        if (m0.l0.b(r5) != false) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void E(int r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 == r0) goto L_0x0071
            r1 = 2
            if (r5 != r1) goto L_0x0008
            goto L_0x0071
        L_0x0008:
            boolean r1 = r4.I
            if (r1 != 0) goto L_0x0023
            r1 = 5
            if (r5 != r1) goto L_0x0023
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Cannot set state: "
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "BottomSheetBehavior"
            android.util.Log.w(r0, r5)
            return
        L_0x0023:
            r1 = 6
            if (r5 != r1) goto L_0x0034
            boolean r2 = r4.f3663b
            if (r2 == 0) goto L_0x0034
            int r2 = r4.z(r5)
            int r3 = r4.D
            if (r2 > r3) goto L_0x0034
            r2 = 3
            goto L_0x0035
        L_0x0034:
            r2 = r5
        L_0x0035:
            java.lang.ref.WeakReference r3 = r4.U
            if (r3 == 0) goto L_0x006d
            java.lang.Object r3 = r3.get()
            if (r3 != 0) goto L_0x0040
            goto L_0x006d
        L_0x0040:
            java.lang.ref.WeakReference r5 = r4.U
            java.lang.Object r5 = r5.get()
            android.view.View r5 = (android.view.View) r5
            c.f r3 = new c.f
            r3.<init>((java.lang.Object) r4, (java.lang.Object) r5, (int) r2, (int) r1)
            android.view.ViewParent r1 = r5.getParent()
            if (r1 == 0) goto L_0x0062
            boolean r1 = r1.isLayoutRequested()
            if (r1 == 0) goto L_0x0062
            java.util.WeakHashMap r1 = m0.c1.f10054a
            boolean r1 = m0.l0.b(r5)
            if (r1 == 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r0 = 0
        L_0x0063:
            if (r0 == 0) goto L_0x0069
            r5.post(r3)
            goto L_0x0070
        L_0x0069:
            r3.run()
            goto L_0x0070
        L_0x006d:
            r4.F(r5)
        L_0x0070:
            return
        L_0x0071:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "STATE_"
            r2.<init>(r3)
            if (r5 != r0) goto L_0x007f
            java.lang.String r5 = "DRAGGING"
            goto L_0x0081
        L_0x007f:
            java.lang.String r5 = "SETTLING"
        L_0x0081:
            java.lang.String r0 = " should not be set externally."
            java.lang.String r5 = android.support.v4.media.h.p(r2, r5, r0)
            r1.<init>(r5)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.E(int):void");
    }

    public final void F(int i10) {
        View view;
        if (this.L != i10) {
            this.L = i10;
            WeakReference weakReference = this.U;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                int i11 = 0;
                if (i10 == 3) {
                    K(true);
                } else if (i10 == 6 || i10 == 5 || i10 == 4) {
                    K(false);
                }
                J(i10, true);
                while (true) {
                    ArrayList arrayList = this.W;
                    if (i11 < arrayList.size()) {
                        ((b8.b) arrayList.get(i11)).c(view, i10);
                        i11++;
                    } else {
                        I();
                        return;
                    }
                }
            }
        }
    }

    public final boolean G(View view, float f10) {
        if (this.J) {
            return true;
        }
        if (view.getTop() < this.G) {
            return false;
        }
        return Math.abs(((f10 * this.Q) + ((float) view.getTop())) - ((float) this.G)) / ((float) t()) > 0.5f;
    }

    public final void H(View view, int i10, boolean z10) {
        int z11 = z(i10);
        h hVar = this.M;
        if (hVar != null && (!z10 ? hVar.t(view, view.getLeft(), z11) : hVar.r(view.getLeft(), z11))) {
            F(2);
            J(i10, true);
            this.A.a(i10);
            return;
        }
        F(i10);
    }

    public final void I() {
        View view;
        g gVar;
        int i10;
        boolean z10;
        c cVar;
        WeakReference weakReference = this.U;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            c1.m(view, 524288);
            c1.i(view, 0);
            c1.m(view, 262144);
            c1.i(view, 0);
            c1.m(view, 1048576);
            c1.i(view, 0);
            SparseIntArray sparseIntArray = this.f3666c0;
            int i11 = sparseIntArray.get(0, -1);
            if (i11 != -1) {
                c1.m(view, i11);
                c1.i(view, 0);
                sparseIntArray.delete(0);
            }
            int i12 = 6;
            if (!this.f3663b && this.L != 6) {
                String string = view.getResources().getString(R.string.bottomsheet_action_expand_halfway);
                j0.h hVar = new j0.h(6, (Object) this);
                ArrayList e10 = c1.e(view);
                int i13 = 0;
                while (true) {
                    if (i13 >= e10.size()) {
                        int i14 = -1;
                        int i15 = 0;
                        while (true) {
                            int[] iArr = c1.f10058e;
                            if (i15 >= iArr.length || i14 != -1) {
                                i10 = i14;
                            } else {
                                int i16 = iArr[i15];
                                boolean z11 = true;
                                for (int i17 = 0; i17 < e10.size(); i17++) {
                                    if (((g) e10.get(i17)).a() != i16) {
                                        z10 = true;
                                    } else {
                                        z10 = false;
                                    }
                                    z11 &= z10;
                                }
                                if (z11) {
                                    i14 = i16;
                                }
                                i15++;
                            }
                        }
                        i10 = i14;
                    } else if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((g) e10.get(i13)).f10911a).getLabel())) {
                        i10 = ((g) e10.get(i13)).a();
                        break;
                    } else {
                        i13++;
                    }
                }
                if (i10 != -1) {
                    g gVar2 = new g((Object) null, i10, string, hVar, (Class) null);
                    View.AccessibilityDelegate c10 = c1.c(view);
                    if (c10 == null) {
                        cVar = null;
                    } else if (c10 instanceof m0.a) {
                        cVar = ((m0.a) c10).f10038a;
                    } else {
                        cVar = new c(c10);
                    }
                    if (cVar == null) {
                        cVar = new c();
                    }
                    c1.p(view, cVar);
                    c1.m(view, gVar2.a());
                    c1.e(view).add(gVar2);
                    c1.i(view, 0);
                }
                sparseIntArray.put(0, i10);
            }
            if (this.I && this.L != 5) {
                A(view, g.f10908j, 5);
            }
            int i18 = this.L;
            if (i18 == 3) {
                if (this.f3663b) {
                    i12 = 4;
                }
                gVar = g.f10907i;
            } else if (i18 == 4) {
                if (this.f3663b) {
                    i12 = 3;
                }
                gVar = g.f10906h;
            } else if (i18 == 6) {
                A(view, g.f10907i, 4);
                A(view, g.f10906h, 3);
                return;
            } else {
                return;
            }
            A(view, gVar, i12);
        }
    }

    public final void J(int i10, boolean z10) {
        boolean z11;
        ValueAnimator valueAnimator;
        if (i10 != 2) {
            if (this.L != 3 || (!this.f3688x && y() != 0)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (this.f3690z != z11 && this.f3673i != null) {
                this.f3690z = z11;
                float f10 = 1.0f;
                float f11 = 0.0f;
                if (!z10 || (valueAnimator = this.B) == null) {
                    ValueAnimator valueAnimator2 = this.B;
                    if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                        this.B.cancel();
                    }
                    i iVar = this.f3673i;
                    if (this.f3690z) {
                        f10 = 0.0f;
                    }
                    t8.h hVar = iVar.f14744h;
                    if (hVar.f14732j != f10) {
                        hVar.f14732j = f10;
                        iVar.f14748l = true;
                        iVar.invalidateSelf();
                    }
                } else if (valueAnimator.isRunning()) {
                    this.B.reverse();
                } else {
                    if (!z11) {
                        f11 = 1.0f;
                    }
                    this.B.setFloatValues(new float[]{1.0f - f11, f11});
                    this.B.start();
                }
            }
        }
    }

    public final void K(boolean z10) {
        WeakReference weakReference = this.U;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (z10) {
                    if (this.f3664b0 == null) {
                        this.f3664b0 = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = coordinatorLayout.getChildAt(i10);
                    if (childAt != this.U.get() && z10) {
                        this.f3664b0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    }
                }
                if (!z10) {
                    this.f3664b0 = null;
                }
            }
        }
    }

    public final void L() {
        View view;
        if (this.U != null) {
            s();
            if (this.L == 4 && (view = (View) this.U.get()) != null) {
                view.requestLayout();
            }
        }
    }

    public final void c(z.e eVar) {
        this.U = null;
        this.M = null;
    }

    public final void f() {
        this.U = null;
        this.M = null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean g(androidx.coordinatorlayout.widget.CoordinatorLayout r10, android.view.View r11, android.view.MotionEvent r12) {
        /*
            r9 = this;
            boolean r0 = r11.isShown()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00d8
            boolean r0 = r9.K
            if (r0 != 0) goto L_0x000e
            goto L_0x00d8
        L_0x000e:
            int r0 = r12.getActionMasked()
            r3 = 0
            r4 = -1
            if (r0 != 0) goto L_0x0021
            r9.Y = r4
            android.view.VelocityTracker r5 = r9.X
            if (r5 == 0) goto L_0x0021
            r5.recycle()
            r9.X = r3
        L_0x0021:
            android.view.VelocityTracker r5 = r9.X
            if (r5 != 0) goto L_0x002b
            android.view.VelocityTracker r5 = android.view.VelocityTracker.obtain()
            r9.X = r5
        L_0x002b:
            android.view.VelocityTracker r5 = r9.X
            r5.addMovement(r12)
            r5 = 2
            if (r0 == 0) goto L_0x0044
            if (r0 == r2) goto L_0x0039
            r11 = 3
            if (r0 == r11) goto L_0x0039
            goto L_0x0087
        L_0x0039:
            r9.f3662a0 = r1
            r9.Y = r4
            boolean r11 = r9.N
            if (r11 == 0) goto L_0x0087
            r9.N = r1
            return r1
        L_0x0044:
            float r6 = r12.getX()
            int r6 = (int) r6
            float r7 = r12.getY()
            int r7 = (int) r7
            r9.Z = r7
            int r7 = r9.L
            if (r7 == r5) goto L_0x0076
            java.lang.ref.WeakReference r7 = r9.V
            if (r7 == 0) goto L_0x005f
            java.lang.Object r7 = r7.get()
            android.view.View r7 = (android.view.View) r7
            goto L_0x0060
        L_0x005f:
            r7 = r3
        L_0x0060:
            if (r7 == 0) goto L_0x0076
            int r8 = r9.Z
            boolean r7 = r10.p(r7, r6, r8)
            if (r7 == 0) goto L_0x0076
            int r7 = r12.getActionIndex()
            int r7 = r12.getPointerId(r7)
            r9.Y = r7
            r9.f3662a0 = r2
        L_0x0076:
            int r7 = r9.Y
            if (r7 != r4) goto L_0x0084
            int r4 = r9.Z
            boolean r11 = r10.p(r11, r6, r4)
            if (r11 != 0) goto L_0x0084
            r11 = 1
            goto L_0x0085
        L_0x0084:
            r11 = 0
        L_0x0085:
            r9.N = r11
        L_0x0087:
            boolean r11 = r9.N
            if (r11 != 0) goto L_0x0096
            u0.h r11 = r9.M
            if (r11 == 0) goto L_0x0096
            boolean r11 = r11.s(r12)
            if (r11 == 0) goto L_0x0096
            return r2
        L_0x0096:
            java.lang.ref.WeakReference r11 = r9.V
            if (r11 == 0) goto L_0x00a1
            java.lang.Object r11 = r11.get()
            r3 = r11
            android.view.View r3 = (android.view.View) r3
        L_0x00a1:
            if (r0 != r5) goto L_0x00d7
            if (r3 == 0) goto L_0x00d7
            boolean r11 = r9.N
            if (r11 != 0) goto L_0x00d7
            int r11 = r9.L
            if (r11 == r2) goto L_0x00d7
            float r11 = r12.getX()
            int r11 = (int) r11
            float r0 = r12.getY()
            int r0 = (int) r0
            boolean r10 = r10.p(r3, r11, r0)
            if (r10 != 0) goto L_0x00d7
            u0.h r10 = r9.M
            if (r10 == 0) goto L_0x00d7
            int r10 = r9.Z
            float r10 = (float) r10
            float r11 = r12.getY()
            float r10 = r10 - r11
            float r10 = java.lang.Math.abs(r10)
            u0.h r11 = r9.M
            int r11 = r11.f15176b
            float r11 = (float) r11
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 <= 0) goto L_0x00d7
            r1 = 1
        L_0x00d7:
            return r1
        L_0x00d8:
            r9.N = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.g(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:78:0x0154 A[LOOP:0: B:76:0x014c->B:78:0x0154, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0160 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h(androidx.coordinatorlayout.widget.CoordinatorLayout r6, android.view.View r7, int r8) {
        /*
            r5 = this;
            java.util.WeakHashMap r0 = m0.c1.f10054a
            boolean r0 = m0.i0.b(r6)
            r1 = 1
            if (r0 == 0) goto L_0x0012
            boolean r0 = m0.i0.b(r7)
            if (r0 != 0) goto L_0x0012
            r7.setFitsSystemWindows(r1)
        L_0x0012:
            java.lang.ref.WeakReference r0 = r5.U
            r2 = 0
            if (r0 != 0) goto L_0x00b6
            android.content.res.Resources r0 = r6.getResources()
            r3 = 2131165293(0x7f07006d, float:1.79448E38)
            int r0 = r0.getDimensionPixelSize(r3)
            r5.f3671g = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 29
            if (r0 < r3) goto L_0x0034
            boolean r3 = r5.f3678n
            if (r3 != 0) goto L_0x0034
            boolean r3 = r5.f3670f
            if (r3 != 0) goto L_0x0034
            r3 = 1
            goto L_0x0035
        L_0x0034:
            r3 = 0
        L_0x0035:
            boolean r4 = r5.f3679o
            if (r4 != 0) goto L_0x0050
            boolean r4 = r5.f3680p
            if (r4 != 0) goto L_0x0050
            boolean r4 = r5.f3681q
            if (r4 != 0) goto L_0x0050
            boolean r4 = r5.f3683s
            if (r4 != 0) goto L_0x0050
            boolean r4 = r5.f3684t
            if (r4 != 0) goto L_0x0050
            boolean r4 = r5.f3685u
            if (r4 != 0) goto L_0x0050
            if (r3 != 0) goto L_0x0050
            goto L_0x0058
        L_0x0050:
            h3.s2 r4 = new h3.s2
            r4.<init>((java.lang.Object) r5, (boolean) r3)
            m8.w.a(r7, r4)
        L_0x0058:
            b8.j r3 = new b8.j
            r3.<init>(r7)
            r4 = 30
            if (r0 < r4) goto L_0x006a
            m0.x1 r0 = new m0.x1
            r0.<init>(r3)
            r7.setWindowInsetsAnimationCallback(r0)
            goto L_0x0083
        L_0x006a:
            android.view.animation.PathInterpolator r0 = m0.w1.f10154e
            r0 = 2131362511(0x7f0a02cf, float:1.8344805E38)
            java.lang.Object r0 = r7.getTag(r0)
            m0.v1 r4 = new m0.v1
            r4.<init>(r7, r3)
            r3 = 2131362519(0x7f0a02d7, float:1.834482E38)
            r7.setTag(r3, r4)
            if (r0 != 0) goto L_0x0083
            r7.setOnApplyWindowInsetsListener(r4)
        L_0x0083:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r7)
            r5.U = r0
            t8.i r0 = r5.f3673i
            if (r0 == 0) goto L_0x00a3
            m0.i0.q(r7, r0)
            t8.i r0 = r5.f3673i
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r4 = r5.H
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x009f
            float r4 = m0.o0.i(r7)
        L_0x009f:
            r0.j(r4)
            goto L_0x00aa
        L_0x00a3:
            android.content.res.ColorStateList r0 = r5.f3674j
            if (r0 == 0) goto L_0x00aa
            m0.c1.r(r7, r0)
        L_0x00aa:
            r5.I()
            int r0 = m0.i0.c(r7)
            if (r0 != 0) goto L_0x00b6
            m0.i0.s(r7, r1)
        L_0x00b6:
            u0.h r0 = r5.M
            if (r0 != 0) goto L_0x00c7
            u0.h r0 = new u0.h
            android.content.Context r3 = r6.getContext()
            b8.a r4 = r5.f3668d0
            r0.<init>(r3, r6, r4)
            r5.M = r0
        L_0x00c7:
            int r0 = r7.getTop()
            r6.r(r7, r8)
            int r8 = r6.getWidth()
            r5.S = r8
            int r6 = r6.getHeight()
            r5.T = r6
            int r6 = r7.getHeight()
            r5.R = r6
            int r8 = r5.T
            int r6 = r8 - r6
            int r3 = r5.f3687w
            if (r6 >= r3) goto L_0x00f3
            boolean r6 = r5.f3682r
            if (r6 == 0) goto L_0x00ef
            r5.R = r8
            goto L_0x00f3
        L_0x00ef:
            int r6 = r8 - r3
            r5.R = r6
        L_0x00f3:
            int r6 = r5.R
            int r8 = r8 - r6
            int r6 = java.lang.Math.max(r2, r8)
            r5.D = r6
            int r6 = r5.T
            float r6 = (float) r6
            r8 = 1065353216(0x3f800000, float:1.0)
            float r3 = r5.F
            float r8 = r8 - r3
            float r8 = r8 * r6
            int r6 = (int) r8
            r5.E = r6
            r5.s()
            int r6 = r5.L
            r8 = 3
            if (r6 != r8) goto L_0x0116
            int r6 = r5.y()
            goto L_0x012b
        L_0x0116:
            r8 = 6
            if (r6 != r8) goto L_0x011c
            int r6 = r5.E
            goto L_0x012b
        L_0x011c:
            boolean r8 = r5.I
            if (r8 == 0) goto L_0x0126
            r8 = 5
            if (r6 != r8) goto L_0x0126
            int r6 = r5.T
            goto L_0x012b
        L_0x0126:
            r8 = 4
            if (r6 != r8) goto L_0x012f
            int r6 = r5.G
        L_0x012b:
            m0.c1.k(r7, r6)
            goto L_0x013c
        L_0x012f:
            if (r6 == r1) goto L_0x0134
            r8 = 2
            if (r6 != r8) goto L_0x013c
        L_0x0134:
            int r6 = r7.getTop()
            int r0 = r0 - r6
            m0.c1.k(r7, r0)
        L_0x013c:
            int r6 = r5.L
            r5.J(r6, r2)
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference
            android.view.View r8 = v(r7)
            r6.<init>(r8)
            r5.V = r6
        L_0x014c:
            java.util.ArrayList r6 = r5.W
            int r8 = r6.size()
            if (r2 >= r8) goto L_0x0160
            java.lang.Object r6 = r6.get(r2)
            b8.b r6 = (b8.b) r6
            r6.a(r7)
            int r2 = r2 + 1
            goto L_0x014c
        L_0x0160:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.h(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(x(i10, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, this.f3675k, marginLayoutParams.width), x(i12, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + 0, this.f3676l, marginLayoutParams.height));
        return true;
    }

    public final boolean j(View view) {
        WeakReference weakReference = this.V;
        return (weakReference == null || view != weakReference.get() || this.L == 3) ? false : true;
    }

    public final void k(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11, int[] iArr, int i12) {
        View view3;
        int i13;
        if (i12 != 1) {
            WeakReference weakReference = this.V;
            if (weakReference != null) {
                view3 = (View) weakReference.get();
            } else {
                view3 = null;
            }
            if (view2 == view3) {
                int top = view.getTop();
                int i14 = top - i11;
                if (i11 <= 0) {
                    if (i11 < 0 && !view2.canScrollVertically(-1)) {
                        int i15 = this.G;
                        if (i14 > i15 && !this.I) {
                            int i16 = top - i15;
                            iArr[1] = i16;
                            c1.k(view, -i16);
                            i13 = 4;
                        } else if (this.K) {
                            iArr[1] = i11;
                            c1.k(view, -i11);
                            F(1);
                        } else {
                            return;
                        }
                    }
                    u(view.getTop());
                    this.O = i11;
                    this.P = true;
                } else if (i14 < y()) {
                    int y10 = top - y();
                    iArr[1] = y10;
                    c1.k(view, -y10);
                    i13 = 3;
                } else if (this.K) {
                    iArr[1] = i11;
                    c1.k(view, -i11);
                    F(1);
                    u(view.getTop());
                    this.O = i11;
                    this.P = true;
                } else {
                    return;
                }
                F(i13);
                u(view.getTop());
                this.O = i11;
                this.P = true;
            }
        }
    }

    public final void l(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int[] iArr) {
    }

    public final void n(View view, Parcelable parcelable) {
        d dVar = (d) parcelable;
        int i10 = this.f3661a;
        if (i10 != 0) {
            if (i10 == -1 || (i10 & 1) == 1) {
                this.f3669e = dVar.f2664k;
            }
            if (i10 == -1 || (i10 & 2) == 2) {
                this.f3663b = dVar.f2665l;
            }
            if (i10 == -1 || (i10 & 4) == 4) {
                this.I = dVar.f2666m;
            }
            if (i10 == -1 || (i10 & 8) == 8) {
                this.J = dVar.f2667n;
            }
        }
        int i11 = dVar.f2663j;
        if (i11 == 1 || i11 == 2) {
            this.L = 4;
        } else {
            this.L = i11;
        }
    }

    public final Parcelable o(View view) {
        return new d(View.BaseSavedState.EMPTY_STATE, this);
    }

    public final boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11) {
        this.O = 0;
        this.P = false;
        return (i10 & 2) != 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        if (r3.getTop() <= r1.E) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006f, code lost:
        if (java.lang.Math.abs(r2 - r1.D) < java.lang.Math.abs(r2 - r1.G)) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007e, code lost:
        if (r2 < java.lang.Math.abs(r2 - r1.G)) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008e, code lost:
        if (java.lang.Math.abs(r2 - r4) < java.lang.Math.abs(r2 - r1.G)) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a9, code lost:
        if (java.lang.Math.abs(r2 - r1.E) < java.lang.Math.abs(r2 - r1.G)) goto L_0x00ab;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q(androidx.coordinatorlayout.widget.CoordinatorLayout r2, android.view.View r3, android.view.View r4, int r5) {
        /*
            r1 = this;
            int r2 = r3.getTop()
            int r5 = r1.y()
            r0 = 3
            if (r2 != r5) goto L_0x000f
            r1.F(r0)
            return
        L_0x000f:
            java.lang.ref.WeakReference r2 = r1.V
            if (r2 == 0) goto L_0x00b4
            java.lang.Object r2 = r2.get()
            if (r4 != r2) goto L_0x00b4
            boolean r2 = r1.P
            if (r2 != 0) goto L_0x001f
            goto L_0x00b4
        L_0x001f:
            int r2 = r1.O
            if (r2 <= 0) goto L_0x0033
            boolean r2 = r1.f3663b
            if (r2 == 0) goto L_0x0029
            goto L_0x00ae
        L_0x0029:
            int r2 = r3.getTop()
            int r4 = r1.E
            if (r2 <= r4) goto L_0x00ae
            goto L_0x00ab
        L_0x0033:
            boolean r2 = r1.I
            if (r2 == 0) goto L_0x0054
            android.view.VelocityTracker r2 = r1.X
            if (r2 != 0) goto L_0x003d
            r2 = 0
            goto L_0x004c
        L_0x003d:
            r4 = 1000(0x3e8, float:1.401E-42)
            float r5 = r1.f3665c
            r2.computeCurrentVelocity(r4, r5)
            android.view.VelocityTracker r2 = r1.X
            int r4 = r1.Y
            float r2 = r2.getYVelocity(r4)
        L_0x004c:
            boolean r2 = r1.G(r3, r2)
            if (r2 == 0) goto L_0x0054
            r0 = 5
            goto L_0x00ae
        L_0x0054:
            int r2 = r1.O
            if (r2 != 0) goto L_0x0091
            int r2 = r3.getTop()
            boolean r4 = r1.f3663b
            if (r4 == 0) goto L_0x0072
            int r4 = r1.D
            int r4 = r2 - r4
            int r4 = java.lang.Math.abs(r4)
            int r5 = r1.G
            int r2 = r2 - r5
            int r2 = java.lang.Math.abs(r2)
            if (r4 >= r2) goto L_0x00ad
            goto L_0x00ae
        L_0x0072:
            int r4 = r1.E
            if (r2 >= r4) goto L_0x0081
            int r4 = r1.G
            int r4 = r2 - r4
            int r4 = java.lang.Math.abs(r4)
            if (r2 >= r4) goto L_0x00ab
            goto L_0x00ae
        L_0x0081:
            int r4 = r2 - r4
            int r4 = java.lang.Math.abs(r4)
            int r5 = r1.G
            int r2 = r2 - r5
            int r2 = java.lang.Math.abs(r2)
            if (r4 >= r2) goto L_0x00ad
            goto L_0x00ab
        L_0x0091:
            boolean r2 = r1.f3663b
            if (r2 == 0) goto L_0x0096
            goto L_0x00ad
        L_0x0096:
            int r2 = r3.getTop()
            int r4 = r1.E
            int r4 = r2 - r4
            int r4 = java.lang.Math.abs(r4)
            int r5 = r1.G
            int r2 = r2 - r5
            int r2 = java.lang.Math.abs(r2)
            if (r4 >= r2) goto L_0x00ad
        L_0x00ab:
            r0 = 6
            goto L_0x00ae
        L_0x00ad:
            r0 = 4
        L_0x00ae:
            r2 = 0
            r1.H(r3, r0, r2)
            r1.P = r2
        L_0x00b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.q(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    public final boolean r(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z10;
        boolean z11 = false;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i10 = this.L;
        if (i10 == 1 && actionMasked == 0) {
            return true;
        }
        h hVar = this.M;
        if (hVar == null || (!this.K && i10 != 1)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            hVar.l(motionEvent);
        }
        if (actionMasked == 0) {
            this.Y = -1;
            VelocityTracker velocityTracker = this.X;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.X = null;
            }
        }
        if (this.X == null) {
            this.X = VelocityTracker.obtain();
        }
        this.X.addMovement(motionEvent);
        if (this.M != null && (this.K || this.L == 1)) {
            z11 = true;
        }
        if (z11 && actionMasked == 2 && !this.N) {
            float abs = Math.abs(((float) this.Z) - motionEvent.getY());
            h hVar2 = this.M;
            if (abs > ((float) hVar2.f15176b)) {
                hVar2.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.N;
    }

    public final void s() {
        int t10 = t();
        if (this.f3663b) {
            this.G = Math.max(this.T - t10, this.D);
        } else {
            this.G = this.T - t10;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        r0 = r3.f3677m;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int t() {
        /*
            r3 = this;
            boolean r0 = r3.f3670f
            if (r0 == 0) goto L_0x001d
            int r0 = r3.f3671g
            int r1 = r3.T
            int r2 = r3.S
            int r2 = r2 * 9
            int r2 = r2 / 16
            int r1 = r1 - r2
            int r0 = java.lang.Math.max(r0, r1)
            int r1 = r3.R
            int r0 = java.lang.Math.min(r0, r1)
            int r1 = r3.f3686v
            int r0 = r0 + r1
            return r0
        L_0x001d:
            boolean r0 = r3.f3678n
            if (r0 != 0) goto L_0x0033
            boolean r0 = r3.f3679o
            if (r0 != 0) goto L_0x0033
            int r0 = r3.f3677m
            if (r0 <= 0) goto L_0x0033
            int r1 = r3.f3669e
            int r2 = r3.f3672h
            int r0 = r0 + r2
            int r0 = java.lang.Math.max(r1, r0)
            return r0
        L_0x0033:
            int r0 = r3.f3669e
            int r1 = r3.f3686v
            int r0 = r0 + r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.t():int");
    }

    public final void u(int i10) {
        View view = (View) this.U.get();
        if (view != null) {
            ArrayList arrayList = this.W;
            if (!arrayList.isEmpty()) {
                int i11 = this.G;
                if (i10 <= i11 && i11 != y()) {
                    y();
                }
                for (int i12 = 0; i12 < arrayList.size(); i12++) {
                    ((b8.b) arrayList.get(i12)).b(view);
                }
            }
        }
    }

    public final int x(int i10, int i11, int i12, int i13) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, i11, i13);
        if (i12 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i12), 1073741824);
        }
        if (size != 0) {
            i12 = Math.min(size, i12);
        }
        return View.MeasureSpec.makeMeasureSpec(i12, RecyclerView.UNDEFINED_DURATION);
    }

    public final int y() {
        if (this.f3663b) {
            return this.D;
        }
        return Math.max(this.C, this.f3682r ? 0 : this.f3687w);
    }

    public final int z(int i10) {
        if (i10 == 3) {
            return y();
        }
        if (i10 == 4) {
            return this.G;
        }
        if (i10 == 5) {
            return this.T;
        }
        if (i10 == 6) {
            return this.E;
        }
        throw new IllegalArgumentException(android.support.v4.media.h.i("Invalid state to get top offset: ", i10));
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(0);
        int i10;
        this.f3672h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v7.a.f15936e);
        int i11 = 3;
        if (obtainStyledAttributes.hasValue(3)) {
            this.f3674j = q8.d.a(context, obtainStyledAttributes, 3);
        }
        if (obtainStyledAttributes.hasValue(21)) {
            this.f3689y = new n(n.b(context, attributeSet, R.attr.bottomSheetStyle, 2132018097));
        }
        n nVar = this.f3689y;
        if (nVar != null) {
            i iVar = new i(nVar);
            this.f3673i = iVar;
            iVar.i(context);
            ColorStateList colorStateList = this.f3674j;
            if (colorStateList != null) {
                this.f3673i.k(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.f3673i.setTint(typedValue.data);
            }
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.B = ofFloat;
        ofFloat.setDuration(500);
        this.B.addUpdateListener(new x7.h(1, this));
        this.H = obtainStyledAttributes.getDimension(2, -1.0f);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f3675k = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f3676l = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(9);
        if (peekValue == null || (i10 = peekValue.data) != -1) {
            D(obtainStyledAttributes.getDimensionPixelSize(9, -1));
        } else {
            D(i10);
        }
        C(obtainStyledAttributes.getBoolean(8, false));
        this.f3678n = obtainStyledAttributes.getBoolean(13, false);
        boolean z10 = obtainStyledAttributes.getBoolean(6, true);
        if (this.f3663b != z10) {
            this.f3663b = z10;
            if (this.U != null) {
                s();
            }
            F((!this.f3663b || this.L != 6) ? this.L : i11);
            J(this.L, true);
            I();
        }
        this.J = obtainStyledAttributes.getBoolean(12, false);
        this.K = obtainStyledAttributes.getBoolean(4, true);
        this.f3661a = obtainStyledAttributes.getInt(10, 0);
        float f10 = obtainStyledAttributes.getFloat(7, 0.5f);
        if (f10 <= 0.0f || f10 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.F = f10;
        if (this.U != null) {
            this.E = (int) ((1.0f - f10) * ((float) this.T));
        }
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(5);
        B((peekValue2 == null || peekValue2.type != 16) ? obtainStyledAttributes.getDimensionPixelOffset(5, 0) : peekValue2.data);
        this.f3667d = obtainStyledAttributes.getInt(11, 500);
        this.f3679o = obtainStyledAttributes.getBoolean(17, false);
        this.f3680p = obtainStyledAttributes.getBoolean(18, false);
        this.f3681q = obtainStyledAttributes.getBoolean(19, false);
        this.f3682r = obtainStyledAttributes.getBoolean(20, true);
        this.f3683s = obtainStyledAttributes.getBoolean(14, false);
        this.f3684t = obtainStyledAttributes.getBoolean(15, false);
        this.f3685u = obtainStyledAttributes.getBoolean(16, false);
        this.f3688x = obtainStyledAttributes.getBoolean(23, true);
        obtainStyledAttributes.recycle();
        this.f3665c = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
