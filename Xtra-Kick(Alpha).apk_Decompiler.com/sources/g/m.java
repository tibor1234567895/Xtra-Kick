package g;

import android.content.Context;
import android.content.DialogInterface;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.woxthebox.draglistview.R;

public final class m extends m0 implements DialogInterface {

    /* renamed from: l  reason: collision with root package name */
    public final k f6179l = new k(getContext(), this, getWindow());

    public m(Context context, int i10) {
        super(context, i(context, i10));
    }

    public static int i(Context context, int i10) {
        if (((i10 >>> 24) & 255) >= 1) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02ce, code lost:
        if (r4 != null) goto L_0x02da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02d8, code lost:
        if (r4 != null) goto L_0x02da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0339, code lost:
        if (r2 != null) goto L_0x038c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0309  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0397  */
    /* JADX WARNING: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x028d  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x028f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r18) {
        /*
            r17 = this;
            super.onCreate(r18)
            r0 = r17
            g.k r1 = r0.f6179l
            g.m0 r2 = r1.f6122b
            int r3 = r1.F
            r2.setContentView((int) r3)
            android.view.Window r2 = r1.f6123c
            r3 = 2131362317(0x7f0a020d, float:1.8344411E38)
            android.view.View r3 = r2.findViewById(r3)
            r4 = 2131362561(0x7f0a0301, float:1.8344906E38)
            android.view.View r5 = r3.findViewById(r4)
            r6 = 2131361982(0x7f0a00be, float:1.8343732E38)
            android.view.View r7 = r3.findViewById(r6)
            r8 = 2131361942(0x7f0a0096, float:1.834365E38)
            android.view.View r9 = r3.findViewById(r8)
            r10 = 2131361995(0x7f0a00cb, float:1.8343758E38)
            android.view.View r3 = r3.findViewById(r10)
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            android.view.View r10 = r1.f6128h
            r12 = 0
            android.content.Context r13 = r1.f6121a
            if (r10 == 0) goto L_0x003d
            goto L_0x004d
        L_0x003d:
            int r10 = r1.f6129i
            if (r10 == 0) goto L_0x004c
            android.view.LayoutInflater r10 = android.view.LayoutInflater.from(r13)
            int r14 = r1.f6129i
            android.view.View r10 = r10.inflate(r14, r3, r12)
            goto L_0x004d
        L_0x004c:
            r10 = 0
        L_0x004d:
            if (r10 == 0) goto L_0x0051
            r15 = 1
            goto L_0x0052
        L_0x0051:
            r15 = 0
        L_0x0052:
            if (r15 == 0) goto L_0x005a
            boolean r16 = g.k.a(r10)
            if (r16 != 0) goto L_0x005f
        L_0x005a:
            r14 = 131072(0x20000, float:1.83671E-40)
            r2.setFlags(r14, r14)
        L_0x005f:
            r14 = -1
            r11 = 8
            if (r15 == 0) goto L_0x008a
            r15 = 2131361994(0x7f0a00ca, float:1.8343756E38)
            android.view.View r15 = r2.findViewById(r15)
            android.widget.FrameLayout r15 = (android.widget.FrameLayout) r15
            android.view.ViewGroup$LayoutParams r8 = new android.view.ViewGroup$LayoutParams
            r8.<init>(r14, r14)
            r15.addView(r10, r8)
            boolean r8 = r1.f6130j
            if (r8 == 0) goto L_0x007c
            r15.setPadding(r12, r12, r12, r12)
        L_0x007c:
            androidx.appcompat.app.AlertController$RecycleListView r8 = r1.f6127g
            if (r8 == 0) goto L_0x008d
            android.view.ViewGroup$LayoutParams r8 = r3.getLayoutParams()
            androidx.appcompat.widget.s2 r8 = (androidx.appcompat.widget.s2) r8
            r10 = 0
            r8.weight = r10
            goto L_0x008d
        L_0x008a:
            r3.setVisibility(r11)
        L_0x008d:
            android.view.View r4 = r3.findViewById(r4)
            android.view.View r6 = r3.findViewById(r6)
            r8 = 2131361942(0x7f0a0096, float:1.834365E38)
            android.view.View r8 = r3.findViewById(r8)
            android.view.ViewGroup r4 = g.k.c(r4, r5)
            android.view.ViewGroup r5 = g.k.c(r6, r7)
            android.view.ViewGroup r6 = g.k.c(r8, r9)
            r7 = 2131362401(0x7f0a0261, float:1.8344582E38)
            android.view.View r7 = r2.findViewById(r7)
            androidx.core.widget.NestedScrollView r7 = (androidx.core.widget.NestedScrollView) r7
            r1.f6143w = r7
            r7.setFocusable(r12)
            androidx.core.widget.NestedScrollView r7 = r1.f6143w
            r7.setNestedScrollingEnabled(r12)
            r7 = 16908299(0x102000b, float:2.387726E-38)
            android.view.View r7 = r5.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r1.B = r7
            if (r7 != 0) goto L_0x00c9
            goto L_0x00fe
        L_0x00c9:
            java.lang.CharSequence r8 = r1.f6126f
            if (r8 == 0) goto L_0x00d1
            r7.setText(r8)
            goto L_0x00fe
        L_0x00d1:
            r7.setVisibility(r11)
            androidx.core.widget.NestedScrollView r7 = r1.f6143w
            android.widget.TextView r8 = r1.B
            r7.removeView(r8)
            androidx.appcompat.app.AlertController$RecycleListView r7 = r1.f6127g
            if (r7 == 0) goto L_0x00fb
            androidx.core.widget.NestedScrollView r7 = r1.f6143w
            android.view.ViewParent r7 = r7.getParent()
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            androidx.core.widget.NestedScrollView r8 = r1.f6143w
            int r8 = r7.indexOfChild(r8)
            r7.removeViewAt(r8)
            androidx.appcompat.app.AlertController$RecycleListView r9 = r1.f6127g
            android.view.ViewGroup$LayoutParams r10 = new android.view.ViewGroup$LayoutParams
            r10.<init>(r14, r14)
            r7.addView(r9, r8, r10)
            goto L_0x00fe
        L_0x00fb:
            r5.setVisibility(r11)
        L_0x00fe:
            r7 = 16908313(0x1020019, float:2.38773E-38)
            android.view.View r7 = r6.findViewById(r7)
            android.widget.Button r7 = (android.widget.Button) r7
            r1.f6131k = r7
            g.c r8 = r1.M
            r7.setOnClickListener(r8)
            java.lang.CharSequence r7 = r1.f6132l
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            int r9 = r1.f6124d
            if (r7 == 0) goto L_0x0123
            android.graphics.drawable.Drawable r7 = r1.f6134n
            if (r7 != 0) goto L_0x0123
            android.widget.Button r7 = r1.f6131k
            r7.setVisibility(r11)
            r7 = 0
            goto L_0x013f
        L_0x0123:
            android.widget.Button r7 = r1.f6131k
            java.lang.CharSequence r10 = r1.f6132l
            r7.setText(r10)
            android.graphics.drawable.Drawable r7 = r1.f6134n
            if (r7 == 0) goto L_0x0139
            r7.setBounds(r12, r12, r9, r9)
            android.widget.Button r7 = r1.f6131k
            android.graphics.drawable.Drawable r10 = r1.f6134n
            r15 = 0
            r7.setCompoundDrawables(r10, r15, r15, r15)
        L_0x0139:
            android.widget.Button r7 = r1.f6131k
            r7.setVisibility(r12)
            r7 = 1
        L_0x013f:
            r10 = 16908314(0x102001a, float:2.3877302E-38)
            android.view.View r10 = r6.findViewById(r10)
            android.widget.Button r10 = (android.widget.Button) r10
            r1.f6135o = r10
            r10.setOnClickListener(r8)
            java.lang.CharSequence r10 = r1.f6136p
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x015f
            android.graphics.drawable.Drawable r10 = r1.f6138r
            if (r10 != 0) goto L_0x015f
            android.widget.Button r10 = r1.f6135o
            r10.setVisibility(r11)
            goto L_0x017c
        L_0x015f:
            android.widget.Button r10 = r1.f6135o
            java.lang.CharSequence r15 = r1.f6136p
            r10.setText(r15)
            android.graphics.drawable.Drawable r10 = r1.f6138r
            if (r10 == 0) goto L_0x0175
            r10.setBounds(r12, r12, r9, r9)
            android.widget.Button r10 = r1.f6135o
            android.graphics.drawable.Drawable r15 = r1.f6138r
            r14 = 0
            r10.setCompoundDrawables(r15, r14, r14, r14)
        L_0x0175:
            android.widget.Button r10 = r1.f6135o
            r10.setVisibility(r12)
            r7 = r7 | 2
        L_0x017c:
            r10 = 16908315(0x102001b, float:2.3877305E-38)
            android.view.View r10 = r6.findViewById(r10)
            android.widget.Button r10 = (android.widget.Button) r10
            r1.f6139s = r10
            r10.setOnClickListener(r8)
            java.lang.CharSequence r8 = r1.f6140t
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x019d
            android.graphics.drawable.Drawable r8 = r1.f6142v
            if (r8 != 0) goto L_0x019d
            android.widget.Button r8 = r1.f6139s
            r8.setVisibility(r11)
            r15 = 0
            goto L_0x01bc
        L_0x019d:
            android.widget.Button r8 = r1.f6139s
            java.lang.CharSequence r10 = r1.f6140t
            r8.setText(r10)
            android.graphics.drawable.Drawable r8 = r1.f6142v
            if (r8 == 0) goto L_0x01b4
            r8.setBounds(r12, r12, r9, r9)
            android.widget.Button r8 = r1.f6139s
            android.graphics.drawable.Drawable r9 = r1.f6142v
            r15 = 0
            r8.setCompoundDrawables(r9, r15, r15, r15)
            goto L_0x01b5
        L_0x01b4:
            r15 = 0
        L_0x01b5:
            android.widget.Button r8 = r1.f6139s
            r8.setVisibility(r12)
            r7 = r7 | 4
        L_0x01bc:
            android.util.TypedValue r8 = new android.util.TypedValue
            r8.<init>()
            android.content.res.Resources$Theme r9 = r13.getTheme()
            r10 = 2130968623(0x7f04002f, float:1.7545905E38)
            r13 = 1
            r9.resolveAttribute(r10, r8, r13)
            int r8 = r8.data
            if (r8 == 0) goto L_0x01d2
            r8 = 1
            goto L_0x01d3
        L_0x01d2:
            r8 = 0
        L_0x01d3:
            r9 = 2
            if (r8 == 0) goto L_0x01f5
            if (r7 != r13) goto L_0x01db
            android.widget.Button r8 = r1.f6131k
            goto L_0x01e5
        L_0x01db:
            if (r7 != r9) goto L_0x01e0
            android.widget.Button r8 = r1.f6135o
            goto L_0x01e5
        L_0x01e0:
            r8 = 4
            if (r7 != r8) goto L_0x01f5
            android.widget.Button r8 = r1.f6139s
        L_0x01e5:
            android.view.ViewGroup$LayoutParams r10 = r8.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r10 = (android.widget.LinearLayout.LayoutParams) r10
            r13 = 1
            r10.gravity = r13
            r13 = 1056964608(0x3f000000, float:0.5)
            r10.weight = r13
            r8.setLayoutParams(r10)
        L_0x01f5:
            if (r7 == 0) goto L_0x01f9
            r7 = 1
            goto L_0x01fa
        L_0x01f9:
            r7 = 0
        L_0x01fa:
            if (r7 != 0) goto L_0x01ff
            r6.setVisibility(r11)
        L_0x01ff:
            android.view.View r7 = r1.C
            r8 = 2131362550(0x7f0a02f6, float:1.8344884E38)
            if (r7 == 0) goto L_0x0217
            android.view.ViewGroup$LayoutParams r7 = new android.view.ViewGroup$LayoutParams
            r10 = -2
            r13 = -1
            r7.<init>(r13, r10)
            android.view.View r10 = r1.C
            r4.addView(r10, r12, r7)
            android.view.View r7 = r2.findViewById(r8)
            goto L_0x0284
        L_0x0217:
            r7 = 16908294(0x1020006, float:2.3877246E-38)
            android.view.View r7 = r2.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r1.f6146z = r7
            java.lang.CharSequence r7 = r1.f6125e
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            r10 = 1
            r7 = r7 ^ r10
            if (r7 == 0) goto L_0x0277
            boolean r7 = r1.K
            if (r7 == 0) goto L_0x0277
            r7 = 2131361871(0x7f0a004f, float:1.8343507E38)
            android.view.View r7 = r2.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r1.A = r7
            java.lang.CharSequence r8 = r1.f6125e
            r7.setText(r8)
            int r7 = r1.f6144x
            if (r7 == 0) goto L_0x024a
            android.widget.ImageView r8 = r1.f6146z
            r8.setImageResource(r7)
            goto L_0x0287
        L_0x024a:
            android.graphics.drawable.Drawable r7 = r1.f6145y
            if (r7 == 0) goto L_0x0254
            android.widget.ImageView r8 = r1.f6146z
            r8.setImageDrawable(r7)
            goto L_0x0287
        L_0x0254:
            android.widget.TextView r7 = r1.A
            android.widget.ImageView r8 = r1.f6146z
            int r8 = r8.getPaddingLeft()
            android.widget.ImageView r10 = r1.f6146z
            int r10 = r10.getPaddingTop()
            android.widget.ImageView r13 = r1.f6146z
            int r13 = r13.getPaddingRight()
            android.widget.ImageView r14 = r1.f6146z
            int r14 = r14.getPaddingBottom()
            r7.setPadding(r8, r10, r13, r14)
            android.widget.ImageView r7 = r1.f6146z
            r7.setVisibility(r11)
            goto L_0x0287
        L_0x0277:
            android.view.View r7 = r2.findViewById(r8)
            r7.setVisibility(r11)
            android.widget.ImageView r7 = r1.f6146z
            r7.setVisibility(r11)
            r7 = r4
        L_0x0284:
            r7.setVisibility(r11)
        L_0x0287:
            int r3 = r3.getVisibility()
            if (r3 == r11) goto L_0x028f
            r3 = 1
            goto L_0x0290
        L_0x028f:
            r3 = 0
        L_0x0290:
            if (r4 == 0) goto L_0x029a
            int r7 = r4.getVisibility()
            if (r7 == r11) goto L_0x029a
            r7 = 1
            goto L_0x029b
        L_0x029a:
            r7 = 0
        L_0x029b:
            int r6 = r6.getVisibility()
            if (r6 == r11) goto L_0x02a3
            r6 = 1
            goto L_0x02a4
        L_0x02a3:
            r6 = 0
        L_0x02a4:
            if (r6 != 0) goto L_0x02b2
            r8 = 2131362527(0x7f0a02df, float:1.8344837E38)
            android.view.View r8 = r5.findViewById(r8)
            if (r8 == 0) goto L_0x02b2
            r8.setVisibility(r12)
        L_0x02b2:
            if (r7 == 0) goto L_0x02d1
            androidx.core.widget.NestedScrollView r8 = r1.f6143w
            if (r8 == 0) goto L_0x02bc
            r10 = 1
            r8.setClipToPadding(r10)
        L_0x02bc:
            java.lang.CharSequence r8 = r1.f6126f
            if (r8 != 0) goto L_0x02c7
            androidx.appcompat.app.AlertController$RecycleListView r8 = r1.f6127g
            if (r8 == 0) goto L_0x02c5
            goto L_0x02c7
        L_0x02c5:
            r4 = r15
            goto L_0x02ce
        L_0x02c7:
            r8 = 2131362549(0x7f0a02f5, float:1.8344882E38)
            android.view.View r4 = r4.findViewById(r8)
        L_0x02ce:
            if (r4 == 0) goto L_0x02dd
            goto L_0x02da
        L_0x02d1:
            r4 = 2131362528(0x7f0a02e0, float:1.834484E38)
            android.view.View r4 = r5.findViewById(r4)
            if (r4 == 0) goto L_0x02dd
        L_0x02da:
            r4.setVisibility(r12)
        L_0x02dd:
            androidx.appcompat.app.AlertController$RecycleListView r4 = r1.f6127g
            boolean r8 = r4 instanceof androidx.appcompat.app.AlertController$RecycleListView
            if (r8 == 0) goto L_0x0307
            r4.getClass()
            if (r6 == 0) goto L_0x02ea
            if (r7 != 0) goto L_0x0307
        L_0x02ea:
            int r8 = r4.getPaddingLeft()
            if (r7 == 0) goto L_0x02f5
            int r10 = r4.getPaddingTop()
            goto L_0x02f7
        L_0x02f5:
            int r10 = r4.f543h
        L_0x02f7:
            int r11 = r4.getPaddingRight()
            if (r6 == 0) goto L_0x0302
            int r13 = r4.getPaddingBottom()
            goto L_0x0304
        L_0x0302:
            int r13 = r4.f544i
        L_0x0304:
            r4.setPadding(r8, r10, r11, r13)
        L_0x0307:
            if (r3 != 0) goto L_0x038f
            androidx.appcompat.app.AlertController$RecycleListView r3 = r1.f6127g
            if (r3 == 0) goto L_0x030e
            goto L_0x0310
        L_0x030e:
            androidx.core.widget.NestedScrollView r3 = r1.f6143w
        L_0x0310:
            if (r3 == 0) goto L_0x038f
            if (r6 == 0) goto L_0x0316
            r4 = 2
            goto L_0x0317
        L_0x0316:
            r4 = 0
        L_0x0317:
            r4 = r4 | r7
            r6 = 2131362399(0x7f0a025f, float:1.8344577E38)
            android.view.View r6 = r2.findViewById(r6)
            r7 = 2131362398(0x7f0a025e, float:1.8344575E38)
            android.view.View r2 = r2.findViewById(r7)
            int r7 = android.os.Build.VERSION.SDK_INT
            r8 = 23
            if (r7 < r8) goto L_0x033c
            java.util.WeakHashMap r9 = m0.c1.f10054a
            if (r7 < r8) goto L_0x0334
            r7 = 3
            m0.p0.d(r3, r4, r7)
        L_0x0334:
            if (r6 == 0) goto L_0x0339
            r5.removeView(r6)
        L_0x0339:
            if (r2 == 0) goto L_0x038f
            goto L_0x038c
        L_0x033c:
            if (r6 == 0) goto L_0x0346
            r3 = r4 & 1
            if (r3 != 0) goto L_0x0346
            r5.removeView(r6)
            r6 = r15
        L_0x0346:
            if (r2 == 0) goto L_0x0351
            r3 = r4 & 2
            if (r3 != 0) goto L_0x0351
            r5.removeView(r2)
            r11 = r15
            goto L_0x0352
        L_0x0351:
            r11 = r2
        L_0x0352:
            if (r6 != 0) goto L_0x0356
            if (r11 == 0) goto L_0x038f
        L_0x0356:
            java.lang.CharSequence r2 = r1.f6126f
            if (r2 == 0) goto L_0x036c
            androidx.core.widget.NestedScrollView r2 = r1.f6143w
            android.support.v4.media.session.u r3 = new android.support.v4.media.session.u
            r3.<init>(r1, r6, r11, r9)
            r2.setOnScrollChangeListener(r3)
            androidx.core.widget.NestedScrollView r2 = r1.f6143w
            g.d r3 = new g.d
            r3.<init>(r1, r6, r11, r12)
            goto L_0x0380
        L_0x036c:
            androidx.appcompat.app.AlertController$RecycleListView r2 = r1.f6127g
            if (r2 == 0) goto L_0x0384
            g.e r3 = new g.e
            r3.<init>(r6, r11)
            r2.setOnScrollListener(r3)
            androidx.appcompat.app.AlertController$RecycleListView r2 = r1.f6127g
            g.d r3 = new g.d
            r4 = 1
            r3.<init>(r1, r6, r11, r4)
        L_0x0380:
            r2.post(r3)
            goto L_0x038f
        L_0x0384:
            if (r6 == 0) goto L_0x0389
            r5.removeView(r6)
        L_0x0389:
            if (r11 == 0) goto L_0x038f
            r2 = r11
        L_0x038c:
            r5.removeView(r2)
        L_0x038f:
            androidx.appcompat.app.AlertController$RecycleListView r2 = r1.f6127g
            if (r2 == 0) goto L_0x03a6
            android.widget.ListAdapter r3 = r1.D
            if (r3 == 0) goto L_0x03a6
            r2.setAdapter(r3)
            int r1 = r1.E
            r3 = -1
            if (r1 <= r3) goto L_0x03a6
            r3 = 1
            r2.setItemChecked(r1, r3)
            r2.setSelection(r1)
        L_0x03a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g.m.onCreate(android.os.Bundle):void");
    }

    public final boolean onKeyDown(int i10, KeyEvent keyEvent) {
        boolean z10;
        NestedScrollView nestedScrollView = this.f6179l.f6143w;
        if (nestedScrollView == null || !nestedScrollView.k(keyEvent)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    public final boolean onKeyUp(int i10, KeyEvent keyEvent) {
        boolean z10;
        NestedScrollView nestedScrollView = this.f6179l.f6143w;
        if (nestedScrollView == null || !nestedScrollView.k(keyEvent)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        k kVar = this.f6179l;
        kVar.f6125e = charSequence;
        TextView textView = kVar.A;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
