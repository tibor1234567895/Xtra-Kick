package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.woxthebox.draglistview.R;
import f.a;
import m.b;
import m.e;
import m0.c1;
import m0.d;

public final class z extends ViewGroup {

    /* renamed from: h  reason: collision with root package name */
    public final x f1136h;

    /* renamed from: i  reason: collision with root package name */
    public final y f1137i;

    /* renamed from: j  reason: collision with root package name */
    public final View f1138j;

    /* renamed from: k  reason: collision with root package name */
    public final Drawable f1139k;

    /* renamed from: l  reason: collision with root package name */
    public final FrameLayout f1140l;

    /* renamed from: m  reason: collision with root package name */
    public final ImageView f1141m;

    /* renamed from: n  reason: collision with root package name */
    public final FrameLayout f1142n;

    /* renamed from: o  reason: collision with root package name */
    public final int f1143o;

    /* renamed from: p  reason: collision with root package name */
    public d f1144p;

    /* renamed from: q  reason: collision with root package name */
    public final v f1145q = new v(this, 0);

    /* renamed from: r  reason: collision with root package name */
    public final e f1146r = new e(2, this);

    /* renamed from: s  reason: collision with root package name */
    public b3 f1147s;

    /* renamed from: t  reason: collision with root package name */
    public PopupWindow.OnDismissListener f1148t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f1149u;

    /* renamed from: v  reason: collision with root package name */
    public int f1150v = 4;

    /* renamed from: w  reason: collision with root package name */
    public boolean f1151w;

    public z(Context context) {
        super(context, (AttributeSet) null, 0);
        int[] iArr = a.f5395e;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr, 0, 0);
        c1.o(this, context, iArr, (AttributeSet) null, obtainStyledAttributes, 0);
        this.f1150v = obtainStyledAttributes.getInt(1, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, this, true);
        y yVar = new y(this);
        this.f1137i = yVar;
        View findViewById = findViewById(R.id.activity_chooser_view_content);
        this.f1138j = findViewById;
        this.f1139k = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.default_activity_button);
        this.f1142n = frameLayout;
        frameLayout.setOnClickListener(yVar);
        frameLayout.setOnLongClickListener(yVar);
        ImageView imageView = (ImageView) frameLayout.findViewById(R.id.image);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.expand_activities_button);
        frameLayout2.setOnClickListener(yVar);
        frameLayout2.setAccessibilityDelegate(new w(0, this));
        frameLayout2.setOnTouchListener(new b(this, frameLayout2));
        this.f1140l = frameLayout2;
        ImageView imageView2 = (ImageView) frameLayout2.findViewById(R.id.image);
        this.f1141m = imageView2;
        imageView2.setImageDrawable(drawable);
        x xVar = new x(this);
        this.f1136h = xVar;
        xVar.registerDataSetObserver(new v(this, 1));
        Resources resources = context.getResources();
        this.f1143o = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }

    public final void a() {
        if (b()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f1146r);
            }
        }
    }

    public final boolean b() {
        return getListPopupWindow().b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0087 A[LOOP:0: B:34:0x0085->B:35:0x0087, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(int r13) {
        /*
            r12 = this;
            androidx.appcompat.widget.x r0 = r12.f1136h
            androidx.appcompat.widget.u r1 = r0.f1121h
            if (r1 == 0) goto L_0x00c9
            android.view.ViewTreeObserver r1 = r12.getViewTreeObserver()
            m.e r2 = r12.f1146r
            r1.addOnGlobalLayoutListener(r2)
            android.widget.FrameLayout r1 = r12.f1142n
            int r1 = r1.getVisibility()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x001b
            r1 = 1
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            androidx.appcompat.widget.u r4 = r0.f1121h
            int r4 = r4.e()
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r13 == r5) goto L_0x0037
            int r6 = r13 + r1
            if (r4 <= r6) goto L_0x0037
            boolean r4 = r0.f1125l
            if (r4 == r2) goto L_0x0034
            r0.f1125l = r2
            r0.notifyDataSetChanged()
        L_0x0034:
            int r13 = r13 + -1
            goto L_0x0040
        L_0x0037:
            boolean r4 = r0.f1125l
            if (r4 == 0) goto L_0x0040
            r0.f1125l = r3
            r0.notifyDataSetChanged()
        L_0x0040:
            r0.a(r13)
            androidx.appcompat.widget.b3 r13 = r12.getListPopupWindow()
            boolean r4 = r13.b()
            if (r4 != 0) goto L_0x00c8
            boolean r4 = r12.f1149u
            if (r4 != 0) goto L_0x0064
            if (r1 != 0) goto L_0x0054
            goto L_0x0064
        L_0x0054:
            boolean r1 = r0.f1123j
            if (r1 != 0) goto L_0x005c
            boolean r1 = r0.f1124k
            if (r1 == 0) goto L_0x0071
        L_0x005c:
            r0.f1123j = r3
            r0.f1124k = r3
        L_0x0060:
            r0.notifyDataSetChanged()
            goto L_0x0071
        L_0x0064:
            boolean r4 = r0.f1123j
            if (r4 != r2) goto L_0x006c
            boolean r4 = r0.f1124k
            if (r4 == r1) goto L_0x0071
        L_0x006c:
            r0.f1123j = r2
            r0.f1124k = r1
            goto L_0x0060
        L_0x0071:
            int r1 = r0.f1122i
            r0.f1122i = r5
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r3)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r3)
            int r6 = r0.getCount()
            r7 = 0
            r10 = r7
            r8 = 0
            r9 = 0
        L_0x0085:
            if (r8 >= r6) goto L_0x0099
            android.view.View r10 = r0.getView(r8, r10, r7)
            r10.measure(r4, r5)
            int r11 = r10.getMeasuredWidth()
            int r9 = java.lang.Math.max(r9, r11)
            int r8 = r8 + 1
            goto L_0x0085
        L_0x0099:
            r0.f1122i = r1
            int r0 = r12.f1143o
            int r0 = java.lang.Math.min(r9, r0)
            r13.q(r0)
            r13.d()
            m0.d r0 = r12.f1144p
            if (r0 == 0) goto L_0x00ae
            r0.i(r2)
        L_0x00ae:
            androidx.appcompat.widget.o2 r0 = r13.f753j
            android.content.Context r1 = r12.getContext()
            r2 = 2131951621(0x7f130005, float:1.9539662E38)
            java.lang.String r1 = r1.getString(r2)
            r0.setContentDescription(r1)
            androidx.appcompat.widget.o2 r13 = r13.f753j
            android.graphics.drawable.ColorDrawable r0 = new android.graphics.drawable.ColorDrawable
            r0.<init>(r3)
            r13.setSelector(r0)
        L_0x00c8:
            return
        L_0x00c9:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "No data model. Did you call #setDataModel?"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.z.c(int):void");
    }

    public u getDataModel() {
        return this.f1136h.f1121h;
    }

    public b3 getListPopupWindow() {
        if (this.f1147s == null) {
            b3 b3Var = new b3(getContext());
            this.f1147s = b3Var;
            b3Var.p(this.f1136h);
            b3 b3Var2 = this.f1147s;
            b3Var2.f765v = this;
            b3Var2.F = true;
            b3Var2.G.setFocusable(true);
            b3 b3Var3 = this.f1147s;
            y yVar = this.f1137i;
            b3Var3.f766w = yVar;
            b3Var3.G.setOnDismissListener(yVar);
        }
        return this.f1147s;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        u uVar = this.f1136h.f1121h;
        if (uVar != null) {
            uVar.registerObserver(this.f1145q);
        }
        this.f1151w = true;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u uVar = this.f1136h.f1121h;
        if (uVar != null) {
            uVar.unregisterObserver(this.f1145q);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1146r);
        }
        if (b()) {
            a();
        }
        this.f1151w = false;
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.f1138j.layout(0, 0, i12 - i10, i13 - i11);
        if (!b()) {
            a();
        }
    }

    public final void onMeasure(int i10, int i11) {
        if (this.f1142n.getVisibility() != 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i11), 1073741824);
        }
        View view = this.f1138j;
        measureChild(view, i10, i11);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(u uVar) {
        x xVar = this.f1136h;
        z zVar = xVar.f1126m;
        u uVar2 = zVar.f1136h.f1121h;
        v vVar = zVar.f1145q;
        if (uVar2 != null && zVar.isShown()) {
            uVar2.unregisterObserver(vVar);
        }
        xVar.f1121h = uVar;
        if (uVar != null && zVar.isShown()) {
            uVar.registerObserver(vVar);
        }
        xVar.notifyDataSetChanged();
        if (b()) {
            a();
            if (!b() && this.f1151w) {
                this.f1149u = false;
                c(this.f1150v);
            }
        }
    }

    public void setDefaultActionButtonContentDescription(int i10) {
    }

    public void setExpandActivityOverflowButtonContentDescription(int i10) {
        this.f1141m.setContentDescription(getContext().getString(i10));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1141m.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i10) {
        this.f1150v = i10;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f1148t = onDismissListener;
    }

    public void setProvider(d dVar) {
        this.f1144p = dVar;
    }
}
