package h4;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.v1;
import androidx.viewpager2.widget.ViewPager2;

public final class d extends v1 {

    /* renamed from: a  reason: collision with root package name */
    public j f7519a;

    /* renamed from: b  reason: collision with root package name */
    public final ViewPager2 f7520b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f7521c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayoutManager f7522d;

    /* renamed from: e  reason: collision with root package name */
    public int f7523e;

    /* renamed from: f  reason: collision with root package name */
    public int f7524f;

    /* renamed from: g  reason: collision with root package name */
    public final c f7525g = new c();

    /* renamed from: h  reason: collision with root package name */
    public int f7526h;

    /* renamed from: i  reason: collision with root package name */
    public int f7527i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f7528j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f7529k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f7530l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f7531m;

    public d(ViewPager2 viewPager2) {
        this.f7520b = viewPager2;
        RecyclerView recyclerView = viewPager2.f2322q;
        this.f7521c = recyclerView;
        this.f7522d = (LinearLayoutManager) recyclerView.getLayoutManager();
        c();
    }

    public final void a(int i10) {
        j jVar = this.f7519a;
        if (jVar != null) {
            jVar.c(i10);
        }
    }

    public final void b(int i10) {
        if ((this.f7523e != 3 || this.f7524f != 0) && this.f7524f != i10) {
            this.f7524f = i10;
            j jVar = this.f7519a;
            if (jVar != null) {
                jVar.a(i10);
            }
        }
    }

    public final void c() {
        this.f7523e = 0;
        this.f7524f = 0;
        c cVar = this.f7525g;
        cVar.f7516a = -1;
        cVar.f7517b = 0.0f;
        cVar.f7518c = 0;
        this.f7526h = -1;
        this.f7527i = -1;
        this.f7528j = false;
        this.f7529k = false;
        this.f7531m = false;
        this.f7530l = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0121, code lost:
        if (r6[r3 - 1][1] >= r5) goto L_0x0124;
     */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0145 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r14 = this;
            androidx.recyclerview.widget.LinearLayoutManager r0 = r14.f7522d
            int r1 = r0.X0()
            h4.c r2 = r14.f7525g
            r2.f7516a = r1
            r3 = 0
            r4 = 0
            r5 = -1
            if (r1 != r5) goto L_0x0016
            r2.f7516a = r5
            r2.f7517b = r3
            r2.f7518c = r4
            return
        L_0x0016:
            android.view.View r1 = r0.B(r1)
            if (r1 != 0) goto L_0x0023
            r2.f7516a = r5
            r2.f7517b = r3
            r2.f7518c = r4
            return
        L_0x0023:
            int r5 = androidx.recyclerview.widget.q1.N(r1)
            int r6 = androidx.recyclerview.widget.q1.Q(r1)
            int r7 = androidx.recyclerview.widget.q1.S(r1)
            int r8 = androidx.recyclerview.widget.q1.F(r1)
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            boolean r10 = r9 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r10 == 0) goto L_0x0049
            android.view.ViewGroup$MarginLayoutParams r9 = (android.view.ViewGroup.MarginLayoutParams) r9
            int r10 = r9.leftMargin
            int r5 = r5 + r10
            int r10 = r9.rightMargin
            int r6 = r6 + r10
            int r10 = r9.topMargin
            int r7 = r7 + r10
            int r9 = r9.bottomMargin
            int r8 = r8 + r9
        L_0x0049:
            int r9 = r1.getHeight()
            int r9 = r9 + r7
            int r9 = r9 + r8
            int r8 = r1.getWidth()
            int r8 = r8 + r5
            int r8 = r8 + r6
            int r6 = r0.f1917w
            r10 = 1
            if (r6 != 0) goto L_0x005c
            r6 = 1
            goto L_0x005d
        L_0x005c:
            r6 = 0
        L_0x005d:
            androidx.recyclerview.widget.RecyclerView r11 = r14.f7521c
            if (r6 == 0) goto L_0x007d
            int r1 = r1.getLeft()
            int r1 = r1 - r5
            int r5 = r11.getPaddingLeft()
            int r1 = r1 - r5
            androidx.viewpager2.widget.ViewPager2 r5 = r14.f7520b
            h4.i r5 = r5.f2319n
            int r5 = r5.M()
            if (r5 != r10) goto L_0x0077
            r5 = 1
            goto L_0x0078
        L_0x0077:
            r5 = 0
        L_0x0078:
            if (r5 == 0) goto L_0x007b
            int r1 = -r1
        L_0x007b:
            r9 = r8
            goto L_0x0087
        L_0x007d:
            int r1 = r1.getTop()
            int r1 = r1 - r7
            int r5 = r11.getPaddingTop()
            int r1 = r1 - r5
        L_0x0087:
            int r1 = -r1
            r2.f7518c = r1
            if (r1 >= 0) goto L_0x016d
            h4.a r1 = new h4.a
            r1.<init>(r0)
            int r3 = r0.H()
            if (r3 != 0) goto L_0x0099
            goto L_0x0124
        L_0x0099:
            int r5 = r0.f1917w
            if (r5 != 0) goto L_0x009f
            r5 = 1
            goto L_0x00a0
        L_0x009f:
            r5 = 0
        L_0x00a0:
            r6 = 2
            int[] r7 = new int[r6]
            r7[r10] = r6
            r7[r4] = r3
            java.lang.Class r6 = java.lang.Integer.TYPE
            java.lang.Object r6 = java.lang.reflect.Array.newInstance(r6, r7)
            int[][] r6 = (int[][]) r6
            r7 = 0
        L_0x00b0:
            if (r7 >= r3) goto L_0x00f8
            android.view.View r8 = r0.G(r7)
            if (r8 == 0) goto L_0x00f0
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            boolean r11 = r9 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r11 == 0) goto L_0x00c3
            android.view.ViewGroup$MarginLayoutParams r9 = (android.view.ViewGroup.MarginLayoutParams) r9
            goto L_0x00c5
        L_0x00c3:
            android.view.ViewGroup$MarginLayoutParams r9 = h4.a.f7515a
        L_0x00c5:
            r11 = r6[r7]
            if (r5 == 0) goto L_0x00d0
            int r12 = r8.getLeft()
            int r13 = r9.leftMargin
            goto L_0x00d6
        L_0x00d0:
            int r12 = r8.getTop()
            int r13 = r9.topMargin
        L_0x00d6:
            int r12 = r12 - r13
            r11[r4] = r12
            r11 = r6[r7]
            if (r5 == 0) goto L_0x00e4
            int r8 = r8.getRight()
            int r9 = r9.rightMargin
            goto L_0x00ea
        L_0x00e4:
            int r8 = r8.getBottom()
            int r9 = r9.bottomMargin
        L_0x00ea:
            int r8 = r8 + r9
            r11[r10] = r8
            int r7 = r7 + 1
            goto L_0x00b0
        L_0x00f0:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "null view contained in the view hierarchy"
            r0.<init>(r1)
            throw r0
        L_0x00f8:
            s.g r5 = new s.g
            r5.<init>(r10, r1)
            java.util.Arrays.sort(r6, r5)
            r1 = 1
        L_0x0101:
            if (r1 >= r3) goto L_0x0113
            int r5 = r1 + -1
            r5 = r6[r5]
            r5 = r5[r10]
            r7 = r6[r1]
            r7 = r7[r4]
            if (r5 == r7) goto L_0x0110
            goto L_0x0126
        L_0x0110:
            int r1 = r1 + 1
            goto L_0x0101
        L_0x0113:
            r1 = r6[r4]
            r5 = r1[r10]
            r1 = r1[r4]
            int r5 = r5 - r1
            if (r1 > 0) goto L_0x0126
            int r3 = r3 - r10
            r1 = r6[r3]
            r1 = r1[r10]
            if (r1 >= r5) goto L_0x0124
            goto L_0x0126
        L_0x0124:
            r1 = 1
            goto L_0x0127
        L_0x0126:
            r1 = 0
        L_0x0127:
            if (r1 == 0) goto L_0x012f
            int r1 = r0.H()
            if (r1 > r10) goto L_0x014a
        L_0x012f:
            int r1 = r0.H()
            r3 = 0
        L_0x0134:
            if (r3 >= r1) goto L_0x0145
            android.view.View r5 = r0.G(r3)
            boolean r5 = h4.a.a(r5)
            if (r5 == 0) goto L_0x0142
            r0 = 1
            goto L_0x0146
        L_0x0142:
            int r3 = r3 + 1
            goto L_0x0134
        L_0x0145:
            r0 = 0
        L_0x0146:
            if (r0 == 0) goto L_0x014a
            r0 = 1
            goto L_0x014b
        L_0x014a:
            r0 = 0
        L_0x014b:
            if (r0 == 0) goto L_0x0155
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started."
            r0.<init>(r1)
            throw r0
        L_0x0155:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.util.Locale r1 = java.util.Locale.US
            java.lang.Object[] r3 = new java.lang.Object[r10]
            int r2 = r2.f7518c
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3[r4] = r2
            java.lang.String r2 = "Page can only be offset by a positive amount, not by %d"
            java.lang.String r1 = java.lang.String.format(r1, r2, r3)
            r0.<init>(r1)
            throw r0
        L_0x016d:
            if (r9 != 0) goto L_0x0170
            goto L_0x0174
        L_0x0170:
            float r0 = (float) r1
            float r1 = (float) r9
            float r3 = r0 / r1
        L_0x0174:
            r2.f7517b = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.d.d():void");
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i10) {
        boolean z10;
        boolean z11;
        j jVar;
        int i11 = this.f7523e;
        boolean z12 = true;
        if (!(i11 == 1 && this.f7524f == 1) && i10 == 1) {
            this.f7531m = false;
            this.f7523e = 1;
            int i12 = this.f7527i;
            if (i12 != -1) {
                this.f7526h = i12;
                this.f7527i = -1;
            } else if (this.f7526h == -1) {
                this.f7526h = this.f7522d.X0();
            }
            b(1);
            return;
        }
        if (i11 == 1 || i11 == 4) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 || i10 != 2) {
            if (i11 == 1 || i11 == 4) {
                z11 = true;
            } else {
                z11 = false;
            }
            c cVar = this.f7525g;
            if (z11 && i10 == 0) {
                d();
                if (!this.f7529k) {
                    int i13 = cVar.f7516a;
                    if (!(i13 == -1 || (jVar = this.f7519a) == null)) {
                        jVar.b(i13, 0.0f, 0);
                    }
                } else if (cVar.f7518c == 0) {
                    int i14 = this.f7526h;
                    int i15 = cVar.f7516a;
                    if (i14 != i15) {
                        a(i15);
                    }
                } else {
                    z12 = false;
                }
                if (z12) {
                    b(0);
                    c();
                }
            }
            if (this.f7523e == 2 && i10 == 0 && this.f7530l) {
                d();
                if (cVar.f7518c == 0) {
                    int i16 = this.f7527i;
                    int i17 = cVar.f7516a;
                    if (i16 != i17) {
                        if (i17 == -1) {
                            i17 = 0;
                        }
                        a(i17);
                    }
                    b(0);
                    c();
                }
            }
        } else if (this.f7529k) {
            b(2);
            this.f7528j = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        if (r7 == r8) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        if (r5.f7526h == r7) goto L_0x004b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onScrolled(androidx.recyclerview.widget.RecyclerView r6, int r7, int r8) {
        /*
            r5 = this;
            r6 = 1
            r5.f7529k = r6
            r5.d()
            boolean r0 = r5.f7528j
            r1 = -1
            h4.c r2 = r5.f7525g
            r3 = 0
            if (r0 == 0) goto L_0x003f
            r5.f7528j = r3
            if (r8 > 0) goto L_0x002b
            if (r8 != 0) goto L_0x0029
            if (r7 >= 0) goto L_0x0018
            r7 = 1
            goto L_0x0019
        L_0x0018:
            r7 = 0
        L_0x0019:
            androidx.viewpager2.widget.ViewPager2 r8 = r5.f7520b
            h4.i r8 = r8.f2319n
            int r8 = r8.M()
            if (r8 != r6) goto L_0x0025
            r8 = 1
            goto L_0x0026
        L_0x0025:
            r8 = 0
        L_0x0026:
            if (r7 != r8) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r7 = 0
            goto L_0x002c
        L_0x002b:
            r7 = 1
        L_0x002c:
            if (r7 == 0) goto L_0x0036
            int r7 = r2.f7518c
            if (r7 == 0) goto L_0x0036
            int r7 = r2.f7516a
            int r7 = r7 + r6
            goto L_0x0038
        L_0x0036:
            int r7 = r2.f7516a
        L_0x0038:
            r5.f7527i = r7
            int r8 = r5.f7526h
            if (r8 == r7) goto L_0x004b
            goto L_0x0048
        L_0x003f:
            int r7 = r5.f7523e
            if (r7 != 0) goto L_0x004b
            int r7 = r2.f7516a
            if (r7 != r1) goto L_0x0048
            r7 = 0
        L_0x0048:
            r5.a(r7)
        L_0x004b:
            int r7 = r2.f7516a
            if (r7 != r1) goto L_0x0050
            r7 = 0
        L_0x0050:
            float r8 = r2.f7517b
            int r0 = r2.f7518c
            h4.j r4 = r5.f7519a
            if (r4 == 0) goto L_0x005b
            r4.b(r7, r8, r0)
        L_0x005b:
            int r7 = r2.f7516a
            int r8 = r5.f7527i
            if (r7 == r8) goto L_0x0063
            if (r8 != r1) goto L_0x0071
        L_0x0063:
            int r7 = r2.f7518c
            if (r7 != 0) goto L_0x0071
            int r7 = r5.f7524f
            if (r7 == r6) goto L_0x0071
            r5.b(r3)
            r5.c()
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.d.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }
}
