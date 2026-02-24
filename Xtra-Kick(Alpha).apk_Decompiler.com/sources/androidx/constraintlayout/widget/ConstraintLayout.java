package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import s.e;
import u.g;
import u.j;
import v.o;
import x.b;
import x.d;
import x.f;
import x.m;
import x.n;
import x.p;
import x.q;

public class ConstraintLayout extends ViewGroup {

    /* renamed from: w  reason: collision with root package name */
    public static q f1168w;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray f1169h = new SparseArray();

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f1170i = new ArrayList(4);

    /* renamed from: j  reason: collision with root package name */
    public final g f1171j = new g();

    /* renamed from: k  reason: collision with root package name */
    public int f1172k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f1173l = 0;

    /* renamed from: m  reason: collision with root package name */
    public int f1174m = Integer.MAX_VALUE;

    /* renamed from: n  reason: collision with root package name */
    public int f1175n = Integer.MAX_VALUE;

    /* renamed from: o  reason: collision with root package name */
    public boolean f1176o = true;

    /* renamed from: p  reason: collision with root package name */
    public int f1177p = 257;

    /* renamed from: q  reason: collision with root package name */
    public m f1178q = null;

    /* renamed from: r  reason: collision with root package name */
    public f f1179r = null;

    /* renamed from: s  reason: collision with root package name */
    public int f1180s = -1;

    /* renamed from: t  reason: collision with root package name */
    public HashMap f1181t = new HashMap();

    /* renamed from: u  reason: collision with root package name */
    public final SparseArray f1182u = new SparseArray();

    /* renamed from: v  reason: collision with root package name */
    public final o f1183v = new o(this, this);

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h(attributeSet, 0);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int max2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return max2 > 0 ? max2 : max;
    }

    public static q getSharedValues() {
        if (f1168w == null) {
            f1168w = new q();
        }
        return f1168w;
    }

    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof d;
    }

    public final void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.f1170i;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                ((b) arrayList.get(i10)).getClass();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = (float) getWidth();
            float height = (float) getHeight();
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i12 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i13 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f10 = (float) i12;
                        float f11 = (float) i13;
                        float f12 = (float) (i12 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        float f13 = f11;
                        float f14 = f11;
                        float f15 = f12;
                        float f16 = f10;
                        Paint paint2 = paint;
                        canvas2.drawLine(f10, f13, f15, f14, paint);
                        float parseInt4 = (float) (i13 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f17 = f12;
                        float f18 = parseInt4;
                        canvas2.drawLine(f17, f14, f15, f18, paint);
                        float f19 = parseInt4;
                        float f20 = f16;
                        canvas2.drawLine(f17, f19, f20, f18, paint);
                        float f21 = f16;
                        canvas2.drawLine(f21, f19, f20, f14, paint);
                        paint.setColor(-16711936);
                        float f22 = f12;
                        Paint paint3 = paint;
                        canvas2.drawLine(f21, f14, f22, parseInt4, paint);
                        canvas2.drawLine(f21, parseInt4, f22, f14, paint);
                    }
                }
            }
        }
    }

    public final void forceLayout() {
        this.f1176o = true;
        super.forceLayout();
    }

    public final u.f g(View view) {
        if (view == this) {
            return this.f1171j;
        }
        if (view == null) {
            return null;
        }
        if (!(view.getLayoutParams() instanceof d)) {
            view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
            if (!(view.getLayoutParams() instanceof d)) {
                return null;
            }
        }
        return ((d) view.getLayoutParams()).f16386p0;
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d();
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    public int getMaxHeight() {
        return this.f1175n;
    }

    public int getMaxWidth() {
        return this.f1174m;
    }

    public int getMinHeight() {
        return this.f1173l;
    }

    public int getMinWidth() {
        return this.f1172k;
    }

    public int getOptimizationLevel() {
        return this.f1171j.E0;
    }

    public String getSceneString() {
        int id;
        String str;
        StringBuilder sb2 = new StringBuilder();
        g gVar = this.f1171j;
        if (gVar.f15100k == null) {
            int id2 = getId();
            if (id2 != -1) {
                str = getContext().getResources().getResourceEntryName(id2);
            } else {
                str = "parent";
            }
            gVar.f15100k = str;
        }
        if (gVar.f15097i0 == null) {
            gVar.f15097i0 = gVar.f15100k;
        }
        Iterator it = gVar.f15168r0.iterator();
        while (it.hasNext()) {
            u.f fVar = (u.f) it.next();
            View view = (View) fVar.f15093g0;
            if (view != null) {
                if (fVar.f15100k == null && (id = view.getId()) != -1) {
                    fVar.f15100k = getContext().getResources().getResourceEntryName(id);
                }
                if (fVar.f15097i0 == null) {
                    fVar.f15097i0 = fVar.f15100k;
                }
            }
        }
        gVar.n(sb2);
        return sb2.toString();
    }

    public final void h(AttributeSet attributeSet, int i10) {
        g gVar = this.f1171j;
        gVar.f15093g0 = this;
        o oVar = this.f1183v;
        gVar.f15126v0 = oVar;
        gVar.f15124t0.f15506h = oVar;
        this.f1169h.put(getId(), this);
        this.f1178q = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, p.f16499b, i10, 0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == 16) {
                    this.f1172k = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1172k);
                } else if (index == 17) {
                    this.f1173l = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1173l);
                } else if (index == 14) {
                    this.f1174m = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1174m);
                } else if (index == 15) {
                    this.f1175n = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1175n);
                } else if (index == 113) {
                    this.f1177p = obtainStyledAttributes.getInt(index, this.f1177p);
                } else if (index == 56) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            this.f1179r = new f(getContext(), resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f1179r = null;
                        }
                    }
                } else if (index == 34) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        m mVar = new m();
                        this.f1178q = mVar;
                        mVar.e(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f1178q = null;
                    }
                    this.f1180s = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        gVar.E0 = this.f1177p;
        e.f13932p = gVar.V(512);
    }

    public final boolean i() {
        return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
    }

    public final void j(String str, Integer num) {
        if ((str instanceof String) && (num instanceof Integer)) {
            if (this.f1181t == null) {
                this.f1181t = new HashMap();
            }
            int indexOf = str.indexOf(Constants.LIST_SEPARATOR);
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.f1181t.put(str, Integer.valueOf(num.intValue()));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x029d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02c9  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02e7  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02f8  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0372  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x037c  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x04a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k() {
        /*
            r25 = this;
            r0 = r25
            int r1 = r25.getChildCount()
            r2 = 0
            r3 = 0
        L_0x0008:
            r4 = 1
            if (r3 >= r1) goto L_0x001a
            android.view.View r5 = r0.getChildAt(r3)
            boolean r5 = r5.isLayoutRequested()
            if (r5 == 0) goto L_0x0017
            r1 = 1
            goto L_0x001b
        L_0x0017:
            int r3 = r3 + 1
            goto L_0x0008
        L_0x001a:
            r1 = 0
        L_0x001b:
            if (r1 == 0) goto L_0x051f
            boolean r3 = r25.isInEditMode()
            int r5 = r25.getChildCount()
            r6 = 0
        L_0x0026:
            if (r6 >= r5) goto L_0x0039
            android.view.View r7 = r0.getChildAt(r6)
            u.f r7 = r0.g(r7)
            if (r7 != 0) goto L_0x0033
            goto L_0x0036
        L_0x0033:
            r7.C()
        L_0x0036:
            int r6 = r6 + 1
            goto L_0x0026
        L_0x0039:
            r6 = 0
            android.util.SparseArray r7 = r0.f1169h
            r8 = -1
            u.g r9 = r0.f1171j
            if (r3 == 0) goto L_0x00a2
            r10 = 0
        L_0x0042:
            if (r10 >= r5) goto L_0x00a2
            android.view.View r11 = r0.getChildAt(r10)
            android.content.res.Resources r12 = r25.getResources()     // Catch:{ NotFoundException -> 0x009f }
            int r13 = r11.getId()     // Catch:{ NotFoundException -> 0x009f }
            java.lang.String r12 = r12.getResourceName(r13)     // Catch:{ NotFoundException -> 0x009f }
            int r13 = r11.getId()     // Catch:{ NotFoundException -> 0x009f }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ NotFoundException -> 0x009f }
            r0.j(r12, r13)     // Catch:{ NotFoundException -> 0x009f }
            r13 = 47
            int r13 = r12.indexOf(r13)     // Catch:{ NotFoundException -> 0x009f }
            if (r13 == r8) goto L_0x006d
            int r13 = r13 + 1
            java.lang.String r12 = r12.substring(r13)     // Catch:{ NotFoundException -> 0x009f }
        L_0x006d:
            int r11 = r11.getId()     // Catch:{ NotFoundException -> 0x009f }
            if (r11 != 0) goto L_0x0074
            goto L_0x008f
        L_0x0074:
            java.lang.Object r13 = r7.get(r11)     // Catch:{ NotFoundException -> 0x009f }
            android.view.View r13 = (android.view.View) r13     // Catch:{ NotFoundException -> 0x009f }
            if (r13 != 0) goto L_0x008d
            android.view.View r13 = r0.findViewById(r11)     // Catch:{ NotFoundException -> 0x009f }
            if (r13 == 0) goto L_0x008d
            if (r13 == r0) goto L_0x008d
            android.view.ViewParent r11 = r13.getParent()     // Catch:{ NotFoundException -> 0x009f }
            if (r11 != r0) goto L_0x008d
            r0.onViewAdded(r13)     // Catch:{ NotFoundException -> 0x009f }
        L_0x008d:
            if (r13 != r0) goto L_0x0091
        L_0x008f:
            r11 = r9
            goto L_0x009d
        L_0x0091:
            if (r13 != 0) goto L_0x0095
            r11 = r6
            goto L_0x009d
        L_0x0095:
            android.view.ViewGroup$LayoutParams r11 = r13.getLayoutParams()     // Catch:{ NotFoundException -> 0x009f }
            x.d r11 = (x.d) r11     // Catch:{ NotFoundException -> 0x009f }
            u.f r11 = r11.f16386p0     // Catch:{ NotFoundException -> 0x009f }
        L_0x009d:
            r11.f15097i0 = r12     // Catch:{ NotFoundException -> 0x009f }
        L_0x009f:
            int r10 = r10 + 1
            goto L_0x0042
        L_0x00a2:
            int r10 = r0.f1180s
            if (r10 == r8) goto L_0x00b3
            r10 = 0
        L_0x00a7:
            if (r10 >= r5) goto L_0x00b3
            android.view.View r11 = r0.getChildAt(r10)
            r11.getId()
            int r10 = r10 + 1
            goto L_0x00a7
        L_0x00b3:
            x.m r10 = r0.f1178q
            if (r10 == 0) goto L_0x00ba
            r10.a(r0)
        L_0x00ba:
            java.util.ArrayList r10 = r9.f15168r0
            r10.clear()
            java.util.ArrayList r10 = r0.f1170i
            int r11 = r10.size()
            if (r11 <= 0) goto L_0x0161
            r13 = 0
        L_0x00c8:
            if (r13 >= r11) goto L_0x0161
            java.lang.Object r14 = r10.get(r13)
            x.b r14 = (x.b) r14
            boolean r15 = r14.isInEditMode()
            if (r15 == 0) goto L_0x00db
            java.lang.String r15 = r14.f16351l
            r14.setIds(r15)
        L_0x00db:
            u.l r15 = r14.f16350k
            if (r15 != 0) goto L_0x00e1
            goto L_0x0159
        L_0x00e1:
            r15.f15159s0 = r2
            u.f[] r15 = r15.f15158r0
            java.util.Arrays.fill(r15, r6)
            r15 = 0
        L_0x00e9:
            int r6 = r14.f16348i
            if (r15 >= r6) goto L_0x0154
            int[] r6 = r14.f16347h
            r6 = r6[r15]
            java.lang.Object r17 = r7.get(r6)
            android.view.View r17 = (android.view.View) r17
            if (r17 != 0) goto L_0x011e
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.util.HashMap r8 = r14.f16353n
            java.lang.Object r6 = r8.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            int r2 = r14.f(r0, r6)
            if (r2 == 0) goto L_0x011e
            int[] r12 = r14.f16347h
            r12[r15] = r2
            java.lang.Integer r12 = java.lang.Integer.valueOf(r2)
            r8.put(r12, r6)
            java.lang.Object r2 = r7.get(r2)
            r17 = r2
            android.view.View r17 = (android.view.View) r17
        L_0x011e:
            r2 = r17
            if (r2 == 0) goto L_0x014e
            u.l r6 = r14.f16350k
            u.f r2 = r0.g(r2)
            r6.getClass()
            if (r2 == r6) goto L_0x014e
            if (r2 != 0) goto L_0x0130
            goto L_0x014e
        L_0x0130:
            int r8 = r6.f15159s0
            int r8 = r8 + r4
            u.f[] r12 = r6.f15158r0
            int r4 = r12.length
            if (r8 <= r4) goto L_0x0144
            int r4 = r12.length
            r8 = 2
            int r4 = r4 * 2
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r12, r4)
            u.f[] r4 = (u.f[]) r4
            r6.f15158r0 = r4
        L_0x0144:
            u.f[] r4 = r6.f15158r0
            int r8 = r6.f15159s0
            r4[r8] = r2
            r2 = 1
            int r8 = r8 + r2
            r6.f15159s0 = r8
        L_0x014e:
            int r15 = r15 + 1
            r2 = 0
            r4 = 1
            r8 = -1
            goto L_0x00e9
        L_0x0154:
            u.l r2 = r14.f16350k
            r2.a()
        L_0x0159:
            int r13 = r13 + 1
            r2 = 0
            r4 = 1
            r6 = 0
            r8 = -1
            goto L_0x00c8
        L_0x0161:
            r2 = 0
        L_0x0162:
            if (r2 >= r5) goto L_0x016a
            r0.getChildAt(r2)
            int r2 = r2 + 1
            goto L_0x0162
        L_0x016a:
            android.util.SparseArray r2 = r0.f1182u
            r2.clear()
            r4 = 0
            r2.put(r4, r9)
            int r4 = r25.getId()
            r2.put(r4, r9)
            r4 = 0
        L_0x017b:
            if (r4 >= r5) goto L_0x018f
            android.view.View r6 = r0.getChildAt(r4)
            u.f r8 = r0.g(r6)
            int r6 = r6.getId()
            r2.put(r6, r8)
            int r4 = r4 + 1
            goto L_0x017b
        L_0x018f:
            r4 = 0
        L_0x0190:
            if (r4 >= r5) goto L_0x051f
            android.view.View r6 = r0.getChildAt(r4)
            u.f r8 = r0.g(r6)
            if (r8 != 0) goto L_0x019d
            goto L_0x0201
        L_0x019d:
            android.view.ViewGroup$LayoutParams r10 = r6.getLayoutParams()
            r15 = r10
            x.d r15 = (x.d) r15
            java.util.ArrayList r10 = r9.f15168r0
            r10.add(r8)
            u.f r10 = r8.U
            if (r10 == 0) goto L_0x01b7
            u.o r10 = (u.o) r10
            java.util.ArrayList r10 = r10.f15168r0
            r10.remove(r8)
            r8.C()
        L_0x01b7:
            r8.U = r9
            r15.a()
            int r10 = r6.getVisibility()
            r8.f15095h0 = r10
            r8.f15093g0 = r6
            boolean r10 = r6 instanceof x.b
            if (r10 == 0) goto L_0x01cf
            x.b r6 = (x.b) r6
            boolean r10 = r9.f15127w0
            r6.h(r8, r10)
        L_0x01cf:
            boolean r6 = r15.f16362d0
            if (r6 == 0) goto L_0x0211
            u.j r8 = (u.j) r8
            int r6 = r15.f16380m0
            int r10 = r15.f16382n0
            float r11 = r15.f16384o0
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r13 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r13 == 0) goto L_0x01eb
            if (r13 <= 0) goto L_0x0201
            r8.f15152r0 = r11
            r11 = -1
            r8.f15153s0 = r11
            r8.f15154t0 = r11
            goto L_0x0201
        L_0x01eb:
            r11 = -1
            if (r6 == r11) goto L_0x01f7
            if (r6 <= r11) goto L_0x0201
            r8.f15152r0 = r12
            r8.f15153s0 = r6
            r8.f15154t0 = r11
            goto L_0x0201
        L_0x01f7:
            if (r10 == r11) goto L_0x0201
            if (r10 <= r11) goto L_0x0201
            r8.f15152r0 = r12
            r8.f15153s0 = r11
            r8.f15154t0 = r10
        L_0x0201:
            r19 = r1
            r21 = r3
            r20 = r4
            r16 = r5
            r18 = r9
            r0 = 2
            r4 = 0
            r5 = -1
            r9 = 1
            goto L_0x0510
        L_0x0211:
            int r6 = r15.f16366f0
            int r10 = r15.f16368g0
            int r14 = r15.f16370h0
            int r13 = r15.f16372i0
            int r12 = r15.f16374j0
            int r11 = r15.f16376k0
            float r0 = r15.f16378l0
            r16 = r5
            int r5 = r15.f16385p
            r18 = r9
            u.d r9 = u.d.RIGHT
            r19 = r1
            u.d r1 = u.d.LEFT
            r20 = r4
            u.d r4 = u.d.BOTTOM
            r21 = r3
            u.d r3 = u.d.TOP
            r22 = r0
            r0 = -1
            if (r5 == r0) goto L_0x0257
            java.lang.Object r0 = r2.get(r5)
            r12 = r0
            u.f r12 = (u.f) r12
            if (r12 == 0) goto L_0x0254
            float r0 = r15.f16388r
            int r14 = r15.f16387q
            u.d r13 = u.d.CENTER
            r5 = 0
            r10 = r8
            r11 = r13
            r6 = r15
            r15 = r5
            r10.v(r11, r12, r13, r14, r15)
            r8.E = r0
            r0 = r6
            goto L_0x037e
        L_0x0254:
            r0 = r15
            goto L_0x037e
        L_0x0257:
            r0 = r15
            r5 = -1
            if (r6 == r5) goto L_0x0269
            java.lang.Object r6 = r2.get(r6)
            u.f r6 = (u.f) r6
            if (r6 == 0) goto L_0x0288
            int r10 = r0.leftMargin
            r5 = r6
            r15 = r10
            r6 = r1
            goto L_0x0277
        L_0x0269:
            if (r10 == r5) goto L_0x0288
            java.lang.Object r5 = r2.get(r10)
            u.f r5 = (u.f) r5
            if (r5 == 0) goto L_0x0288
            int r6 = r0.leftMargin
            r15 = r6
            r6 = r9
        L_0x0277:
            r10 = r8
            r23 = r11
            r11 = r1
            r24 = r12
            r12 = r5
            r5 = r13
            r13 = r6
            r6 = r14
            r14 = r15
            r15 = r24
            r10.v(r11, r12, r13, r14, r15)
            goto L_0x028c
        L_0x0288:
            r23 = r11
            r5 = r13
            r6 = r14
        L_0x028c:
            r10 = -1
            if (r6 == r10) goto L_0x029d
            java.lang.Object r5 = r2.get(r6)
            u.f r5 = (u.f) r5
            if (r5 == 0) goto L_0x02b3
            int r6 = r0.rightMargin
            r13 = r1
            r12 = r5
            r14 = r6
            goto L_0x02ac
        L_0x029d:
            if (r5 == r10) goto L_0x02b3
            java.lang.Object r5 = r2.get(r5)
            u.f r5 = (u.f) r5
            if (r5 == 0) goto L_0x02b3
            int r6 = r0.rightMargin
            r12 = r5
            r14 = r6
            r13 = r9
        L_0x02ac:
            r10 = r8
            r11 = r9
            r15 = r23
            r10.v(r11, r12, r13, r14, r15)
        L_0x02b3:
            int r5 = r0.f16371i
            r6 = -1
            if (r5 == r6) goto L_0x02c9
            java.lang.Object r5 = r2.get(r5)
            u.f r5 = (u.f) r5
            if (r5 == 0) goto L_0x02e2
            int r10 = r0.topMargin
            int r11 = r0.f16394x
            r13 = r3
            r12 = r5
            r14 = r10
            r15 = r11
            goto L_0x02dd
        L_0x02c9:
            int r5 = r0.f16373j
            if (r5 == r6) goto L_0x02e2
            java.lang.Object r5 = r2.get(r5)
            u.f r5 = (u.f) r5
            if (r5 == 0) goto L_0x02e2
            int r6 = r0.topMargin
            int r10 = r0.f16394x
            r13 = r4
            r12 = r5
            r14 = r6
            r15 = r10
        L_0x02dd:
            r10 = r8
            r11 = r3
            r10.v(r11, r12, r13, r14, r15)
        L_0x02e2:
            int r5 = r0.f16375k
            r6 = -1
            if (r5 == r6) goto L_0x02f8
            java.lang.Object r5 = r2.get(r5)
            u.f r5 = (u.f) r5
            if (r5 == 0) goto L_0x0311
            int r10 = r0.bottomMargin
            int r11 = r0.f16396z
            r13 = r3
            r12 = r5
            r14 = r10
            r15 = r11
            goto L_0x030c
        L_0x02f8:
            int r5 = r0.f16377l
            if (r5 == r6) goto L_0x0311
            java.lang.Object r5 = r2.get(r5)
            u.f r5 = (u.f) r5
            if (r5 == 0) goto L_0x0311
            int r6 = r0.bottomMargin
            int r10 = r0.f16396z
            r13 = r4
            r12 = r5
            r14 = r6
            r15 = r10
        L_0x030c:
            r10 = r8
            r11 = r4
            r10.v(r11, r12, r13, r14, r15)
        L_0x0311:
            int r5 = r0.f16379m
            u.d r6 = u.d.BASELINE
            r10 = -1
            if (r5 == r10) goto L_0x031a
            r10 = r6
            goto L_0x0325
        L_0x031a:
            int r5 = r0.f16381n
            if (r5 == r10) goto L_0x0320
            r10 = r3
            goto L_0x0325
        L_0x0320:
            int r5 = r0.f16383o
            if (r5 == r10) goto L_0x036d
            r10 = r4
        L_0x0325:
            java.lang.Object r11 = r7.get(r5)
            android.view.View r11 = (android.view.View) r11
            java.lang.Object r5 = r2.get(r5)
            u.f r5 = (u.f) r5
            if (r5 == 0) goto L_0x036d
            if (r11 == 0) goto L_0x036d
            android.view.ViewGroup$LayoutParams r12 = r11.getLayoutParams()
            boolean r12 = r12 instanceof x.d
            if (r12 == 0) goto L_0x036d
            r12 = 1
            r0.f16360c0 = r12
            if (r10 != r6) goto L_0x034e
            android.view.ViewGroup$LayoutParams r11 = r11.getLayoutParams()
            x.d r11 = (x.d) r11
            r11.f16360c0 = r12
            u.f r11 = r11.f16386p0
            r11.F = r12
        L_0x034e:
            u.e r6 = r8.j(r6)
            u.e r5 = r5.j(r10)
            int r10 = r0.D
            int r11 = r0.C
            r6.b(r5, r10, r11, r12)
            r8.F = r12
            u.e r5 = r8.j(r3)
            r5.j()
            u.e r5 = r8.j(r4)
            r5.j()
        L_0x036d:
            r5 = 0
            int r6 = (r22 > r5 ? 1 : (r22 == r5 ? 0 : -1))
            if (r6 < 0) goto L_0x0376
            r6 = r22
            r8.f15089e0 = r6
        L_0x0376:
            float r6 = r0.F
            int r10 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r10 < 0) goto L_0x037e
            r8.f15091f0 = r6
        L_0x037e:
            if (r21 == 0) goto L_0x038f
            int r5 = r0.T
            r6 = -1
            if (r5 != r6) goto L_0x0389
            int r10 = r0.U
            if (r10 == r6) goto L_0x038f
        L_0x0389:
            int r6 = r0.U
            r8.Z = r5
            r8.f15081a0 = r6
        L_0x038f:
            boolean r5 = r0.f16356a0
            r6 = 3
            r10 = 4
            r11 = -2
            if (r5 != 0) goto L_0x03bf
            int r5 = r0.width
            r12 = -1
            if (r5 != r12) goto L_0x03b7
            boolean r5 = r0.W
            if (r5 == 0) goto L_0x03a3
            r8.L(r6)
            goto L_0x03a6
        L_0x03a3:
            r8.L(r10)
        L_0x03a6:
            u.e r1 = r8.j(r1)
            int r5 = r0.leftMargin
            r1.f15077g = r5
            u.e r1 = r8.j(r9)
            int r5 = r0.rightMargin
            r1.f15077g = r5
            goto L_0x03d0
        L_0x03b7:
            r8.L(r6)
            r1 = 0
            r8.N(r1)
            goto L_0x03d0
        L_0x03bf:
            r1 = 1
            r8.L(r1)
            int r1 = r0.width
            r8.N(r1)
            int r1 = r0.width
            if (r1 != r11) goto L_0x03d0
            r1 = 2
            r8.L(r1)
        L_0x03d0:
            boolean r1 = r0.f16358b0
            if (r1 != 0) goto L_0x03fd
            int r1 = r0.height
            r5 = -1
            if (r1 != r5) goto L_0x03f5
            boolean r1 = r0.X
            if (r1 == 0) goto L_0x03e1
            r8.M(r6)
            goto L_0x03e4
        L_0x03e1:
            r8.M(r10)
        L_0x03e4:
            u.e r1 = r8.j(r3)
            int r3 = r0.topMargin
            r1.f15077g = r3
            u.e r1 = r8.j(r4)
            int r3 = r0.bottomMargin
            r1.f15077g = r3
            goto L_0x040f
        L_0x03f5:
            r8.M(r6)
            r1 = 0
            r8.K(r1)
            goto L_0x040f
        L_0x03fd:
            r1 = 1
            r5 = -1
            r8.M(r1)
            int r1 = r0.height
            r8.K(r1)
            int r1 = r0.height
            if (r1 != r11) goto L_0x040f
            r1 = 2
            r8.M(r1)
        L_0x040f:
            java.lang.String r1 = r0.G
            if (r1 == 0) goto L_0x04a8
            int r3 = r1.length()
            if (r3 != 0) goto L_0x041b
            goto L_0x04a8
        L_0x041b:
            int r3 = r1.length()
            r4 = 44
            int r4 = r1.indexOf(r4)
            if (r4 <= 0) goto L_0x0449
            int r9 = r3 + -1
            if (r4 >= r9) goto L_0x0449
            r9 = 0
            java.lang.String r10 = r1.substring(r9, r4)
            java.lang.String r9 = "W"
            boolean r9 = r10.equalsIgnoreCase(r9)
            if (r9 == 0) goto L_0x043a
            r9 = 0
            goto L_0x0445
        L_0x043a:
            java.lang.String r9 = "H"
            boolean r9 = r10.equalsIgnoreCase(r9)
            if (r9 == 0) goto L_0x0444
            r9 = 1
            goto L_0x0445
        L_0x0444:
            r9 = -1
        L_0x0445:
            int r4 = r4 + 1
            r11 = r9
            goto L_0x044b
        L_0x0449:
            r4 = 0
            r11 = -1
        L_0x044b:
            r9 = 58
            int r9 = r1.indexOf(r9)
            if (r9 < 0) goto L_0x048d
            int r3 = r3 + -1
            if (r9 >= r3) goto L_0x048d
            java.lang.String r3 = r1.substring(r4, r9)
            int r9 = r9 + 1
            java.lang.String r1 = r1.substring(r9)
            int r4 = r3.length()
            if (r4 <= 0) goto L_0x049d
            int r4 = r1.length()
            if (r4 <= 0) goto L_0x049d
            float r3 = java.lang.Float.parseFloat(r3)     // Catch:{ NumberFormatException -> 0x049c }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x049c }
            r4 = 0
            int r9 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r9 <= 0) goto L_0x049d
            int r9 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r9 <= 0) goto L_0x049d
            r4 = 1
            if (r11 != r4) goto L_0x0487
            float r1 = r1 / r3
            float r1 = java.lang.Math.abs(r1)     // Catch:{ NumberFormatException -> 0x049c }
            goto L_0x049e
        L_0x0487:
            float r3 = r3 / r1
            float r1 = java.lang.Math.abs(r3)     // Catch:{ NumberFormatException -> 0x049c }
            goto L_0x049e
        L_0x048d:
            java.lang.String r1 = r1.substring(r4)
            int r3 = r1.length()
            if (r3 <= 0) goto L_0x049d
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x049c }
            goto L_0x049e
        L_0x049c:
        L_0x049d:
            r1 = 0
        L_0x049e:
            r3 = 0
            int r4 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x04ab
            r8.X = r1
            r8.Y = r11
            goto L_0x04ab
        L_0x04a8:
            r3 = 0
            r8.X = r3
        L_0x04ab:
            float r1 = r0.H
            float[] r3 = r8.f15103l0
            r4 = 0
            r3[r4] = r1
            float r1 = r0.I
            r9 = 1
            r3[r9] = r1
            int r1 = r0.J
            r8.f15099j0 = r1
            int r1 = r0.K
            r8.f15101k0 = r1
            int r1 = r0.Z
            if (r1 < 0) goto L_0x04c7
            if (r1 > r6) goto L_0x04c7
            r8.f15114r = r1
        L_0x04c7:
            int r1 = r0.L
            int r3 = r0.N
            int r6 = r0.P
            float r10 = r0.R
            r8.f15115s = r1
            r8.f15118v = r3
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r6 != r3) goto L_0x04d9
            r6 = 0
        L_0x04d9:
            r8.f15119w = r6
            r8.f15120x = r10
            r6 = 1065353216(0x3f800000, float:1.0)
            r11 = 0
            int r12 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r12 <= 0) goto L_0x04ed
            int r10 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r10 >= 0) goto L_0x04ed
            if (r1 != 0) goto L_0x04ed
            r1 = 2
            r8.f15115s = r1
        L_0x04ed:
            int r1 = r0.M
            int r10 = r0.O
            int r11 = r0.Q
            float r0 = r0.S
            r8.f15116t = r1
            r8.f15121y = r10
            if (r11 != r3) goto L_0x04fc
            r11 = 0
        L_0x04fc:
            r8.f15122z = r11
            r8.A = r0
            r3 = 0
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x050f
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x050f
            if (r1 != 0) goto L_0x050f
            r0 = 2
            r8.f15116t = r0
            goto L_0x0510
        L_0x050f:
            r0 = 2
        L_0x0510:
            int r1 = r20 + 1
            r0 = r25
            r4 = r1
            r5 = r16
            r9 = r18
            r1 = r19
            r3 = r21
            goto L_0x0190
        L_0x051f:
            r19 = r1
            return r19
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.k():boolean");
    }

    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            d dVar = (d) childAt.getLayoutParams();
            u.f fVar = dVar.f16386p0;
            if (childAt.getVisibility() != 8 || dVar.f16362d0 || dVar.f16364e0 || isInEditMode) {
                int r10 = fVar.r();
                int s10 = fVar.s();
                childAt.layout(r10, s10, fVar.q() + r10, fVar.l() + s10);
            }
        }
        ArrayList arrayList = this.f1170i;
        int size = arrayList.size();
        if (size > 0) {
            for (int i15 = 0; i15 < size; i15++) {
                ((b) arrayList.get(i15)).getClass();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0447  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0457  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x045a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x0744  */
    /* JADX WARNING: Removed duplicated region for block: B:373:0x0747  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01cc A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r25, int r26) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            boolean r3 = r0.f1176o
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0023
            int r3 = r24.getChildCount()
            r6 = 0
        L_0x0011:
            if (r6 >= r3) goto L_0x0023
            android.view.View r7 = r0.getChildAt(r6)
            boolean r7 = r7.isLayoutRequested()
            if (r7 == 0) goto L_0x0020
            r0.f1176o = r4
            goto L_0x0023
        L_0x0020:
            int r6 = r6 + 1
            goto L_0x0011
        L_0x0023:
            boolean r3 = r24.i()
            u.g r4 = r0.f1171j
            r4.f15127w0 = r3
            boolean r3 = r0.f1176o
            android.support.v4.media.session.u r6 = r4.f15123s0
            if (r3 == 0) goto L_0x003c
            r0.f1176o = r5
            boolean r3 = r24.k()
            if (r3 == 0) goto L_0x003c
            r6.P(r4)
        L_0x003c:
            int r3 = r0.f1177p
            int r7 = android.view.View.MeasureSpec.getMode(r25)
            int r8 = android.view.View.MeasureSpec.getSize(r25)
            int r9 = android.view.View.MeasureSpec.getMode(r26)
            int r10 = android.view.View.MeasureSpec.getSize(r26)
            int r11 = r24.getPaddingTop()
            int r11 = java.lang.Math.max(r5, r11)
            int r12 = r24.getPaddingBottom()
            int r12 = java.lang.Math.max(r5, r12)
            int r13 = r11 + r12
            int r14 = r24.getPaddingWidth()
            v.o r15 = r0.f1183v
            r15.f15527a = r11
            r15.f15528b = r12
            r15.f15529c = r14
            r15.f15530d = r13
            r15.f15531e = r1
            r15.f15532f = r2
            int r12 = r24.getPaddingStart()
            int r12 = java.lang.Math.max(r5, r12)
            int r2 = r24.getPaddingEnd()
            int r2 = java.lang.Math.max(r5, r2)
            if (r12 > 0) goto L_0x0090
            if (r2 <= 0) goto L_0x0087
            goto L_0x0090
        L_0x0087:
            int r2 = r24.getPaddingLeft()
            int r12 = java.lang.Math.max(r5, r2)
            goto L_0x0097
        L_0x0090:
            boolean r5 = r24.i()
            if (r5 == 0) goto L_0x0097
            r12 = r2
        L_0x0097:
            int r8 = r8 - r14
            int r10 = r10 - r13
            int r2 = r15.f15530d
            int r5 = r15.f15529c
            int r13 = r24.getChildCount()
            r14 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = 1073741824(0x40000000, float:2.0)
            if (r7 == r14) goto L_0x00be
            if (r7 == 0) goto L_0x00b6
            if (r7 == r1) goto L_0x00ad
            r1 = 1
            goto L_0x00ba
        L_0x00ad:
            int r1 = r0.f1174m
            int r1 = r1 - r5
            int r1 = java.lang.Math.min(r1, r8)
            r14 = 1
            goto L_0x00ca
        L_0x00b6:
            if (r13 != 0) goto L_0x00b9
            goto L_0x00c0
        L_0x00b9:
            r1 = 2
        L_0x00ba:
            r14 = 0
            r14 = r1
            r1 = 0
            goto L_0x00ca
        L_0x00be:
            if (r13 != 0) goto L_0x00c8
        L_0x00c0:
            int r1 = r0.f1172k
            r14 = 0
            int r1 = java.lang.Math.max(r14, r1)
            goto L_0x00c9
        L_0x00c8:
            r1 = r8
        L_0x00c9:
            r14 = 2
        L_0x00ca:
            r16 = r15
            r15 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r9 == r15) goto L_0x00eb
            if (r9 == 0) goto L_0x00e1
            r13 = 1073741824(0x40000000, float:2.0)
            if (r9 == r13) goto L_0x00d8
            r13 = 1
            goto L_0x00e5
        L_0x00d8:
            int r13 = r0.f1175n
            int r13 = r13 - r2
            int r13 = java.lang.Math.min(r13, r10)
            r15 = 1
            goto L_0x00f7
        L_0x00e1:
            if (r13 != 0) goto L_0x00e4
            goto L_0x00ed
        L_0x00e4:
            r13 = 2
        L_0x00e5:
            r15 = 0
            r17 = r10
            r15 = r13
            r13 = 0
            goto L_0x00f9
        L_0x00eb:
            if (r13 != 0) goto L_0x00f5
        L_0x00ed:
            int r13 = r0.f1173l
            r15 = 0
            int r13 = java.lang.Math.max(r15, r13)
            goto L_0x00f6
        L_0x00f5:
            r13 = r10
        L_0x00f6:
            r15 = 2
        L_0x00f7:
            r17 = r10
        L_0x00f9:
            int r10 = r4.q()
            r18 = r8
            v.e r8 = r4.f15124t0
            if (r1 != r10) goto L_0x0109
            int r10 = r4.l()
            if (r13 == r10) goto L_0x010c
        L_0x0109:
            r10 = 1
            r8.f15500b = r10
        L_0x010c:
            r10 = 0
            r4.Z = r10
            r4.f15081a0 = r10
            int r10 = r0.f1174m
            int r10 = r10 - r5
            r19 = r8
            int[] r8 = r4.D
            r20 = r9
            r9 = 0
            r8[r9] = r10
            int r10 = r0.f1175n
            int r10 = r10 - r2
            r21 = 1
            r8[r21] = r10
            r4.f15085c0 = r9
            r4.f15087d0 = r9
            r4.L(r14)
            r4.N(r1)
            r4.M(r15)
            r4.K(r13)
            int r1 = r0.f1172k
            int r1 = r1 - r5
            if (r1 >= 0) goto L_0x013a
            r1 = 0
        L_0x013a:
            r4.f15085c0 = r1
            int r1 = r0.f1173l
            int r1 = r1 - r2
            if (r1 >= 0) goto L_0x0142
            r1 = 0
        L_0x0142:
            r4.f15087d0 = r1
            r4.f15129y0 = r12
            r4.f15130z0 = r11
            r6.getClass()
            v.o r1 = r4.f15126v0
            java.util.ArrayList r2 = r4.f15168r0
            int r2 = r2.size()
            int r5 = r4.q()
            int r9 = r4.l()
            r10 = 128(0x80, float:1.794E-43)
            boolean r10 = u.m.b(r3, r10)
            r11 = 64
            if (r10 != 0) goto L_0x016e
            boolean r3 = u.m.b(r3, r11)
            if (r3 == 0) goto L_0x016c
            goto L_0x016e
        L_0x016c:
            r3 = 0
            goto L_0x016f
        L_0x016e:
            r3 = 1
        L_0x016f:
            r11 = 3
            if (r3 == 0) goto L_0x01c6
            r12 = 0
        L_0x0173:
            if (r12 >= r2) goto L_0x01c6
            java.util.ArrayList r13 = r4.f15168r0
            java.lang.Object r13 = r13.get(r12)
            u.f r13 = (u.f) r13
            int[] r14 = r13.f15113q0
            r15 = 0
            r15 = r14[r15]
            if (r15 != r11) goto L_0x0186
            r15 = 1
            goto L_0x0187
        L_0x0186:
            r15 = 0
        L_0x0187:
            r21 = 1
            r14 = r14[r21]
            if (r14 != r11) goto L_0x018f
            r14 = 1
            goto L_0x0190
        L_0x018f:
            r14 = 0
        L_0x0190:
            if (r15 == 0) goto L_0x019d
            if (r14 == 0) goto L_0x019d
            float r14 = r13.X
            r15 = 0
            int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r14 <= 0) goto L_0x019d
            r14 = 1
            goto L_0x019e
        L_0x019d:
            r14 = 0
        L_0x019e:
            boolean r15 = r13.x()
            if (r15 == 0) goto L_0x01a7
            if (r14 == 0) goto L_0x01a7
            goto L_0x01c5
        L_0x01a7:
            boolean r15 = r13.y()
            if (r15 == 0) goto L_0x01b0
            if (r14 == 0) goto L_0x01b0
            goto L_0x01c5
        L_0x01b0:
            boolean r14 = r13 instanceof u.n
            if (r14 == 0) goto L_0x01b5
            goto L_0x01c5
        L_0x01b5:
            boolean r14 = r13.x()
            if (r14 != 0) goto L_0x01c5
            boolean r13 = r13.y()
            if (r13 == 0) goto L_0x01c2
            goto L_0x01c5
        L_0x01c2:
            int r12 = r12 + 1
            goto L_0x0173
        L_0x01c5:
            r3 = 0
        L_0x01c6:
            r11 = 1073741824(0x40000000, float:2.0)
            r12 = r20
            if (r7 != r11) goto L_0x01ce
            if (r12 == r11) goto L_0x01d0
        L_0x01ce:
            if (r10 == 0) goto L_0x01d2
        L_0x01d0:
            r11 = 1
            goto L_0x01d3
        L_0x01d2:
            r11 = 0
        L_0x01d3:
            r3 = r3 & r11
            if (r3 == 0) goto L_0x0447
            r11 = 0
            r11 = r8[r11]
            r13 = r18
            int r11 = java.lang.Math.min(r11, r13)
            r13 = 1
            r8 = r8[r13]
            r14 = r17
            int r8 = java.lang.Math.min(r8, r14)
            r14 = 1073741824(0x40000000, float:2.0)
            if (r7 != r14) goto L_0x01fa
            int r15 = r4.q()
            if (r15 == r11) goto L_0x01fa
            r4.N(r11)
            r11 = r19
            r11.f15499a = r13
            goto L_0x01fc
        L_0x01fa:
            r11 = r19
        L_0x01fc:
            if (r12 != r14) goto L_0x0209
            int r15 = r4.l()
            if (r15 == r8) goto L_0x0209
            r4.K(r8)
            r11.f15499a = r13
        L_0x0209:
            if (r7 != r14) goto L_0x03a0
            if (r12 != r14) goto L_0x03a0
            r8 = r10 & 1
            boolean r10 = r11.f15499a
            java.lang.Object r13 = r11.f15501c
            if (r10 != 0) goto L_0x021c
            boolean r10 = r11.f15500b
            if (r10 == 0) goto L_0x021a
            goto L_0x021c
        L_0x021a:
            r10 = 0
            goto L_0x0259
        L_0x021c:
            r10 = r13
            u.g r10 = (u.g) r10
            java.util.ArrayList r14 = r10.f15168r0
            java.util.Iterator r14 = r14.iterator()
        L_0x0225:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x0246
            java.lang.Object r15 = r14.next()
            u.f r15 = (u.f) r15
            r15.i()
            r17 = r14
            r14 = 0
            r15.f15080a = r14
            v.l r14 = r15.f15086d
            r14.n()
            v.n r14 = r15.f15088e
            r14.m()
            r14 = r17
            goto L_0x0225
        L_0x0246:
            r10.i()
            r14 = 0
            r10.f15080a = r14
            v.l r15 = r10.f15086d
            r15.n()
            v.n r10 = r10.f15088e
            r10.m()
            r11.f15500b = r14
            goto L_0x021a
        L_0x0259:
            java.lang.Object r14 = r11.f15502d
            u.g r14 = (u.g) r14
            r11.c(r14)
            u.g r13 = (u.g) r13
            r13.Z = r10
            r13.f15081a0 = r10
            int r10 = r13.k(r10)
            r14 = 1
            int r14 = r13.k(r14)
            boolean r15 = r11.f15499a
            if (r15 == 0) goto L_0x0276
            r11.d()
        L_0x0276:
            int r15 = r13.r()
            int r0 = r13.s()
            r17 = r3
            v.l r3 = r13.f15086d
            v.f r3 = r3.f15548h
            r3.d(r15)
            v.n r3 = r13.f15088e
            v.f r3 = r3.f15548h
            r3.d(r0)
            r11.i()
            java.lang.Object r3 = r11.f15503e
            r18 = r1
            r1 = 2
            if (r10 == r1) goto L_0x029e
            if (r14 != r1) goto L_0x029b
            goto L_0x029e
        L_0x029b:
            r19 = r5
            goto L_0x02f6
        L_0x029e:
            if (r8 == 0) goto L_0x02ba
            r1 = r3
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x02a7:
            boolean r19 = r1.hasNext()
            if (r19 == 0) goto L_0x02ba
            java.lang.Object r19 = r1.next()
            v.q r19 = (v.q) r19
            boolean r19 = r19.k()
            if (r19 != 0) goto L_0x02a7
            r8 = 0
        L_0x02ba:
            if (r8 == 0) goto L_0x02d9
            r1 = 2
            if (r10 != r1) goto L_0x02d9
            r1 = 1
            r13.L(r1)
            r1 = 0
            int r1 = r11.e(r13, r1)
            r13.N(r1)
            v.l r1 = r13.f15086d
            v.g r1 = r1.f15545e
            r19 = r5
            int r5 = r13.q()
            r1.d(r5)
            goto L_0x02db
        L_0x02d9:
            r19 = r5
        L_0x02db:
            if (r8 == 0) goto L_0x02f6
            r1 = 2
            if (r14 != r1) goto L_0x02f6
            r1 = 1
            r13.M(r1)
            int r1 = r11.e(r13, r1)
            r13.K(r1)
            v.n r1 = r13.f15088e
            v.g r1 = r1.f15545e
            int r5 = r13.l()
            r1.d(r5)
        L_0x02f6:
            int[] r1 = r13.f15113q0
            r5 = 0
            r5 = r1[r5]
            r8 = 4
            r20 = r9
            r9 = 1
            if (r5 == r9) goto L_0x0306
            if (r5 != r8) goto L_0x0304
            goto L_0x0306
        L_0x0304:
            r0 = 0
            goto L_0x033c
        L_0x0306:
            int r5 = r13.q()
            int r5 = r5 + r15
            v.l r9 = r13.f15086d
            v.f r9 = r9.f15549i
            r9.d(r5)
            v.l r9 = r13.f15086d
            v.g r9 = r9.f15545e
            int r5 = r5 - r15
            r9.d(r5)
            r11.i()
            r5 = 1
            r1 = r1[r5]
            if (r1 == r5) goto L_0x0324
            if (r1 != r8) goto L_0x0338
        L_0x0324:
            int r1 = r13.l()
            int r1 = r1 + r0
            v.n r5 = r13.f15088e
            v.f r5 = r5.f15549i
            r5.d(r1)
            v.n r5 = r13.f15088e
            v.g r5 = r5.f15545e
            int r1 = r1 - r0
            r5.d(r1)
        L_0x0338:
            r11.i()
            r0 = 1
        L_0x033c:
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.util.Iterator r1 = r3.iterator()
        L_0x0342:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x035b
            java.lang.Object r5 = r1.next()
            v.q r5 = (v.q) r5
            u.f r8 = r5.f15542b
            if (r8 != r13) goto L_0x0357
            boolean r8 = r5.f15547g
            if (r8 != 0) goto L_0x0357
            goto L_0x0342
        L_0x0357:
            r5.e()
            goto L_0x0342
        L_0x035b:
            java.util.Iterator r1 = r3.iterator()
        L_0x035f:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0394
            java.lang.Object r3 = r1.next()
            v.q r3 = (v.q) r3
            if (r0 != 0) goto L_0x0372
            u.f r5 = r3.f15542b
            if (r5 != r13) goto L_0x0372
            goto L_0x035f
        L_0x0372:
            v.f r5 = r3.f15548h
            boolean r5 = r5.f15517j
            if (r5 != 0) goto L_0x0379
            goto L_0x0392
        L_0x0379:
            v.f r5 = r3.f15549i
            boolean r5 = r5.f15517j
            if (r5 != 0) goto L_0x0384
            boolean r5 = r3 instanceof v.j
            if (r5 != 0) goto L_0x0384
            goto L_0x0392
        L_0x0384:
            v.g r5 = r3.f15545e
            boolean r5 = r5.f15517j
            if (r5 != 0) goto L_0x035f
            boolean r5 = r3 instanceof v.c
            if (r5 != 0) goto L_0x035f
            boolean r3 = r3 instanceof v.j
            if (r3 != 0) goto L_0x035f
        L_0x0392:
            r0 = 0
            goto L_0x0395
        L_0x0394:
            r0 = 1
        L_0x0395:
            r13.L(r10)
            r13.M(r14)
            r1 = 1073741824(0x40000000, float:2.0)
            r3 = 2
            goto L_0x0437
        L_0x03a0:
            r18 = r1
            r17 = r3
            r19 = r5
            r20 = r9
            boolean r0 = r11.f15499a
            java.lang.Object r1 = r11.f15501c
            if (r0 == 0) goto L_0x0400
            r0 = r1
            u.g r0 = (u.g) r0
            java.util.ArrayList r3 = r0.f15168r0
            java.util.Iterator r3 = r3.iterator()
        L_0x03b7:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x03e0
            java.lang.Object r5 = r3.next()
            u.f r5 = (u.f) r5
            r5.i()
            r8 = 0
            r5.f15080a = r8
            v.l r9 = r5.f15086d
            v.g r13 = r9.f15545e
            r13.f15517j = r8
            r9.f15547g = r8
            r9.n()
            v.n r5 = r5.f15088e
            v.g r9 = r5.f15545e
            r9.f15517j = r8
            r5.f15547g = r8
            r5.m()
            goto L_0x03b7
        L_0x03e0:
            r3 = 0
            r0.i()
            r0.f15080a = r3
            v.l r5 = r0.f15086d
            v.g r8 = r5.f15545e
            r8.f15517j = r3
            r5.f15547g = r3
            r5.n()
            v.n r0 = r0.f15088e
            v.g r5 = r0.f15545e
            r5.f15517j = r3
            r0.f15547g = r3
            r0.m()
            r11.d()
            goto L_0x0401
        L_0x0400:
            r3 = 0
        L_0x0401:
            java.lang.Object r0 = r11.f15502d
            u.g r0 = (u.g) r0
            r11.c(r0)
            u.g r1 = (u.g) r1
            r1.Z = r3
            r1.f15081a0 = r3
            v.l r0 = r1.f15086d
            v.f r0 = r0.f15548h
            r0.d(r3)
            v.n r0 = r1.f15088e
            v.f r0 = r0.f15548h
            r0.d(r3)
            r1 = 1073741824(0x40000000, float:2.0)
            if (r7 != r1) goto L_0x0429
            boolean r0 = r4.T(r3, r10)
            r3 = 1
            r0 = r0 & 1
            r5 = 1
            goto L_0x042c
        L_0x0429:
            r3 = 1
            r0 = 1
            r5 = 0
        L_0x042c:
            if (r12 != r1) goto L_0x0436
            boolean r3 = r4.T(r3, r10)
            r0 = r0 & r3
            int r3 = r5 + 1
            goto L_0x0437
        L_0x0436:
            r3 = r5
        L_0x0437:
            if (r0 == 0) goto L_0x0451
            if (r7 != r1) goto L_0x043d
            r5 = 1
            goto L_0x043e
        L_0x043d:
            r5 = 0
        L_0x043e:
            if (r12 != r1) goto L_0x0442
            r1 = 1
            goto L_0x0443
        L_0x0442:
            r1 = 0
        L_0x0443:
            r4.O(r5, r1)
            goto L_0x0451
        L_0x0447:
            r18 = r1
            r17 = r3
            r19 = r5
            r20 = r9
            r0 = 0
            r3 = 0
        L_0x0451:
            if (r0 == 0) goto L_0x045a
            r0 = 2
            if (r3 == r0) goto L_0x0457
            goto L_0x045a
        L_0x0457:
            r1 = r4
            goto L_0x070c
        L_0x045a:
            int r0 = r4.E0
            if (r2 <= 0) goto L_0x0524
            java.util.ArrayList r1 = r4.f15168r0
            int r1 = r1.size()
            r3 = 64
            boolean r3 = r4.V(r3)
            v.o r5 = r4.f15126v0
            r7 = 0
        L_0x046d:
            if (r7 >= r1) goto L_0x04fc
            java.util.ArrayList r8 = r4.f15168r0
            java.lang.Object r8 = r8.get(r7)
            u.f r8 = (u.f) r8
            boolean r9 = r8 instanceof u.j
            if (r9 == 0) goto L_0x047d
            goto L_0x04f8
        L_0x047d:
            boolean r9 = r8 instanceof u.a
            if (r9 == 0) goto L_0x0483
            goto L_0x04f8
        L_0x0483:
            boolean r9 = r8.G
            if (r9 == 0) goto L_0x0489
            goto L_0x04f8
        L_0x0489:
            if (r3 == 0) goto L_0x04a0
            v.l r9 = r8.f15086d
            if (r9 == 0) goto L_0x04a0
            v.n r10 = r8.f15088e
            if (r10 == 0) goto L_0x04a0
            v.g r9 = r9.f15545e
            boolean r9 = r9.f15517j
            if (r9 == 0) goto L_0x04a0
            v.g r9 = r10.f15545e
            boolean r9 = r9.f15517j
            if (r9 == 0) goto L_0x04a0
            goto L_0x04f8
        L_0x04a0:
            r9 = 0
            int r9 = r8.k(r9)
            r10 = 1
            int r11 = r8.k(r10)
            r12 = 3
            if (r9 != r12) goto L_0x04b9
            int r13 = r8.f15115s
            if (r13 == r10) goto L_0x04b9
            if (r11 != r12) goto L_0x04b9
            int r12 = r8.f15116t
            if (r12 == r10) goto L_0x04b9
            r12 = 1
            goto L_0x04ba
        L_0x04b9:
            r12 = 0
        L_0x04ba:
            if (r12 != 0) goto L_0x04f1
            boolean r10 = r4.V(r10)
            if (r10 == 0) goto L_0x04f1
            boolean r10 = r8 instanceof u.n
            if (r10 != 0) goto L_0x04f1
            r10 = 3
            if (r9 != r10) goto L_0x04d6
            int r13 = r8.f15115s
            if (r13 != 0) goto L_0x04d6
            if (r11 == r10) goto L_0x04d6
            boolean r13 = r8.x()
            if (r13 != 0) goto L_0x04d6
            r12 = 1
        L_0x04d6:
            if (r11 != r10) goto L_0x04e5
            int r13 = r8.f15116t
            if (r13 != 0) goto L_0x04e5
            if (r9 == r10) goto L_0x04e5
            boolean r13 = r8.x()
            if (r13 != 0) goto L_0x04e5
            r12 = 1
        L_0x04e5:
            if (r9 == r10) goto L_0x04e9
            if (r11 != r10) goto L_0x04f1
        L_0x04e9:
            float r9 = r8.X
            r10 = 0
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x04f1
            r12 = 1
        L_0x04f1:
            if (r12 == 0) goto L_0x04f4
            goto L_0x04f8
        L_0x04f4:
            r9 = 0
            r6.F(r9, r8, r5)
        L_0x04f8:
            int r7 = r7 + 1
            goto L_0x046d
        L_0x04fc:
            java.lang.Object r1 = r5.f15533g
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            int r3 = r1.getChildCount()
            r5 = 0
        L_0x0505:
            if (r5 >= r3) goto L_0x050d
            r1.getChildAt(r5)
            int r5 = r5 + 1
            goto L_0x0505
        L_0x050d:
            java.util.ArrayList r1 = r1.f1170i
            int r3 = r1.size()
            if (r3 <= 0) goto L_0x0524
            r5 = 0
        L_0x0516:
            if (r5 >= r3) goto L_0x0524
            java.lang.Object r7 = r1.get(r5)
            x.b r7 = (x.b) r7
            r7.getClass()
            int r5 = r5 + 1
            goto L_0x0516
        L_0x0524:
            r6.P(r4)
            java.lang.Object r1 = r6.f428i
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            int r1 = r1.size()
            if (r2 <= 0) goto L_0x053a
            r2 = 0
            r3 = r19
            r5 = r20
            r6.N(r4, r2, r3, r5)
            goto L_0x053f
        L_0x053a:
            r3 = r19
            r5 = r20
            r2 = 0
        L_0x053f:
            if (r1 <= 0) goto L_0x06fd
            int[] r7 = r4.f15113q0
            r2 = r7[r2]
            r8 = 2
            if (r2 != r8) goto L_0x054a
            r2 = 1
            goto L_0x054b
        L_0x054a:
            r2 = 0
        L_0x054b:
            r9 = 1
            r7 = r7[r9]
            if (r7 != r8) goto L_0x0552
            r7 = 1
            goto L_0x0553
        L_0x0552:
            r7 = 0
        L_0x0553:
            int r8 = r4.q()
            java.lang.Object r9 = r6.f430k
            u.g r9 = (u.g) r9
            int r9 = r9.f15085c0
            int r8 = java.lang.Math.max(r8, r9)
            int r9 = r4.l()
            java.lang.Object r10 = r6.f430k
            u.g r10 = (u.g) r10
            int r10 = r10.f15087d0
            int r9 = java.lang.Math.max(r9, r10)
            r10 = 0
            r11 = 0
        L_0x0571:
            u.d r12 = u.d.BOTTOM
            u.d r13 = u.d.RIGHT
            if (r10 >= r1) goto L_0x0610
            java.lang.Object r14 = r6.f428i
            java.util.ArrayList r14 = (java.util.ArrayList) r14
            java.lang.Object r14 = r14.get(r10)
            u.f r14 = (u.f) r14
            boolean r15 = r14 instanceof u.n
            if (r15 != 0) goto L_0x058f
            r19 = r0
            r20 = r3
            r21 = r4
            r4 = r18
            goto L_0x0604
        L_0x058f:
            int r15 = r14.q()
            r19 = r0
            int r0 = r14.l()
            r20 = r3
            r3 = 1
            r21 = r4
            r4 = r18
            boolean r3 = r6.F(r3, r14, r4)
            r3 = r3 | r11
            int r11 = r14.q()
            r18 = r3
            int r3 = r14.l()
            if (r11 == r15) goto L_0x05d6
            r14.N(r11)
            if (r2 == 0) goto L_0x05d3
            int r11 = r14.r()
            int r15 = r14.V
            int r11 = r11 + r15
            if (r11 <= r8) goto L_0x05d3
            int r11 = r14.r()
            int r15 = r14.V
            int r11 = r11 + r15
            u.e r13 = r14.j(r13)
            int r13 = r13.e()
            int r13 = r13 + r11
            int r8 = java.lang.Math.max(r8, r13)
        L_0x05d3:
            r11 = 1
            r18 = 1
        L_0x05d6:
            if (r3 == r0) goto L_0x05fd
            r14.K(r3)
            if (r7 == 0) goto L_0x05fb
            int r0 = r14.s()
            int r3 = r14.W
            int r0 = r0 + r3
            if (r0 <= r9) goto L_0x05fb
            int r0 = r14.s()
            int r3 = r14.W
            int r0 = r0 + r3
            u.e r3 = r14.j(r12)
            int r3 = r3.e()
            int r3 = r3 + r0
            int r0 = java.lang.Math.max(r9, r3)
            r9 = r0
        L_0x05fb:
            r18 = 1
        L_0x05fd:
            u.n r14 = (u.n) r14
            boolean r0 = r14.f15167z0
            r0 = r0 | r18
            r11 = r0
        L_0x0604:
            int r10 = r10 + 1
            r18 = r4
            r0 = r19
            r3 = r20
            r4 = r21
            goto L_0x0571
        L_0x0610:
            r19 = r0
            r20 = r3
            r21 = r4
            r4 = r18
            r0 = 0
        L_0x0619:
            r3 = 2
            if (r0 >= r3) goto L_0x06fa
            r3 = 0
        L_0x061d:
            if (r3 >= r1) goto L_0x06de
            java.lang.Object r10 = r6.f428i
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            java.lang.Object r10 = r10.get(r3)
            u.f r10 = (u.f) r10
            boolean r14 = r10 instanceof u.k
            if (r14 == 0) goto L_0x0631
            boolean r14 = r10 instanceof u.n
            if (r14 == 0) goto L_0x0654
        L_0x0631:
            boolean r14 = r10 instanceof u.j
            if (r14 == 0) goto L_0x0636
            goto L_0x0654
        L_0x0636:
            int r14 = r10.f15095h0
            r15 = 8
            if (r14 != r15) goto L_0x063d
            goto L_0x0654
        L_0x063d:
            if (r17 == 0) goto L_0x0650
            v.l r14 = r10.f15086d
            v.g r14 = r14.f15545e
            boolean r14 = r14.f15517j
            if (r14 == 0) goto L_0x0650
            v.n r14 = r10.f15088e
            v.g r14 = r14.f15545e
            boolean r14 = r14.f15517j
            if (r14 == 0) goto L_0x0650
            goto L_0x0654
        L_0x0650:
            boolean r14 = r10 instanceof u.n
            if (r14 == 0) goto L_0x065c
        L_0x0654:
            r18 = r1
            r23 = r4
            r22 = r5
            goto L_0x06d4
        L_0x065c:
            int r14 = r10.q()
            int r15 = r10.l()
            r18 = r1
            int r1 = r10.f15083b0
            r22 = r5
            r5 = 1
            if (r0 != r5) goto L_0x066e
            r5 = 2
        L_0x066e:
            boolean r5 = r6.F(r5, r10, r4)
            r5 = r5 | r11
            int r11 = r10.q()
            r23 = r4
            int r4 = r10.l()
            if (r11 == r14) goto L_0x06a2
            r10.N(r11)
            if (r2 == 0) goto L_0x06a1
            int r5 = r10.r()
            int r11 = r10.V
            int r5 = r5 + r11
            if (r5 <= r8) goto L_0x06a1
            int r5 = r10.r()
            int r11 = r10.V
            int r5 = r5 + r11
            u.e r11 = r10.j(r13)
            int r11 = r11.e()
            int r11 = r11 + r5
            int r8 = java.lang.Math.max(r8, r11)
        L_0x06a1:
            r5 = 1
        L_0x06a2:
            if (r4 == r15) goto L_0x06c8
            r10.K(r4)
            if (r7 == 0) goto L_0x06c7
            int r4 = r10.s()
            int r5 = r10.W
            int r4 = r4 + r5
            if (r4 <= r9) goto L_0x06c7
            int r4 = r10.s()
            int r5 = r10.W
            int r4 = r4 + r5
            u.e r5 = r10.j(r12)
            int r5 = r5.e()
            int r5 = r5 + r4
            int r4 = java.lang.Math.max(r9, r5)
            r9 = r4
        L_0x06c7:
            r5 = 1
        L_0x06c8:
            boolean r4 = r10.F
            if (r4 == 0) goto L_0x06d3
            int r4 = r10.f15083b0
            if (r1 == r4) goto L_0x06d3
            r1 = 1
            r11 = 1
            goto L_0x06d4
        L_0x06d3:
            r11 = r5
        L_0x06d4:
            int r3 = r3 + 1
            r1 = r18
            r5 = r22
            r4 = r23
            goto L_0x061d
        L_0x06de:
            r18 = r1
            r23 = r4
            r22 = r5
            if (r11 == 0) goto L_0x06fa
            int r0 = r0 + 1
            r3 = r20
            r1 = r21
            r4 = r22
            r6.N(r1, r0, r3, r4)
            r5 = 2
            r11 = 0
            r5 = r4
            r1 = r18
            r4 = r23
            goto L_0x0619
        L_0x06fa:
            r1 = r21
            goto L_0x0700
        L_0x06fd:
            r19 = r0
            r1 = r4
        L_0x0700:
            r0 = r19
            r1.E0 = r0
            r0 = 512(0x200, float:7.175E-43)
            boolean r0 = r1.V(r0)
            s.e.f13932p = r0
        L_0x070c:
            int r0 = r1.q()
            int r2 = r1.l()
            boolean r3 = r1.F0
            boolean r1 = r1.G0
            r4 = r16
            int r5 = r4.f15530d
            int r4 = r4.f15529c
            int r0 = r0 + r4
            int r2 = r2 + r5
            r4 = 0
            r5 = r25
            int r0 = android.view.View.resolveSizeAndState(r0, r5, r4)
            r5 = r26
            int r2 = android.view.View.resolveSizeAndState(r2, r5, r4)
            r4 = 16777215(0xffffff, float:2.3509886E-38)
            r0 = r0 & r4
            r2 = r2 & r4
            r4 = r24
            int r5 = r4.f1174m
            int r0 = java.lang.Math.min(r5, r0)
            int r5 = r4.f1175n
            int r2 = java.lang.Math.min(r5, r2)
            r5 = 16777216(0x1000000, float:2.3509887E-38)
            if (r3 == 0) goto L_0x0745
            r0 = r0 | r5
        L_0x0745:
            if (r1 == 0) goto L_0x0748
            r2 = r2 | r5
        L_0x0748:
            r4.setMeasuredDimension(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        u.f g10 = g(view);
        if ((view instanceof Guideline) && !(g10 instanceof j)) {
            d dVar = (d) view.getLayoutParams();
            j jVar = new j();
            dVar.f16386p0 = jVar;
            dVar.f16362d0 = true;
            jVar.Q(dVar.V);
        }
        if (view instanceof b) {
            b bVar = (b) view;
            bVar.i();
            ((d) view.getLayoutParams()).f16364e0 = true;
            ArrayList arrayList = this.f1170i;
            if (!arrayList.contains(bVar)) {
                arrayList.add(bVar);
            }
        }
        this.f1169h.put(view.getId(), view);
        this.f1176o = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f1169h.remove(view.getId());
        u.f g10 = g(view);
        this.f1171j.f15168r0.remove(g10);
        g10.C();
        this.f1170i.remove(view);
        this.f1176o = true;
    }

    public final void requestLayout() {
        this.f1176o = true;
        super.requestLayout();
    }

    public void setConstraintSet(m mVar) {
        this.f1178q = mVar;
    }

    public void setId(int i10) {
        int id = getId();
        SparseArray sparseArray = this.f1169h;
        sparseArray.remove(id);
        super.setId(i10);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i10) {
        if (i10 != this.f1175n) {
            this.f1175n = i10;
            requestLayout();
        }
    }

    public void setMaxWidth(int i10) {
        if (i10 != this.f1174m) {
            this.f1174m = i10;
            requestLayout();
        }
    }

    public void setMinHeight(int i10) {
        if (i10 != this.f1173l) {
            this.f1173l = i10;
            requestLayout();
        }
    }

    public void setMinWidth(int i10) {
        if (i10 != this.f1172k) {
            this.f1172k = i10;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(n nVar) {
        f fVar = this.f1179r;
        if (fVar != null) {
            fVar.getClass();
        }
    }

    public void setOptimizationLevel(int i10) {
        this.f1177p = i10;
        g gVar = this.f1171j;
        gVar.E0 = i10;
        e.f13932p = gVar.V(512);
    }

    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        h(attributeSet, i10);
    }

    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new d(layoutParams);
    }
}
