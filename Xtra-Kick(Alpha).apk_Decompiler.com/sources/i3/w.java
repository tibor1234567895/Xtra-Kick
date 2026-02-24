package i3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.activity.e;
import androidx.media3.ui.DefaultTimeBar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g1;
import com.woxthebox.draglistview.R;
import d9.o0;
import d9.r0;
import g1.a0;
import g1.a2;
import g1.b;
import g1.c;
import g1.e1;
import g1.k1;
import g1.r1;
import g1.t0;
import g1.t1;
import g1.u1;
import g1.z1;
import j1.a;
import j1.l0;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.concurrent.CopyOnWriteArrayList;

public final class w extends FrameLayout {
    public static final float[] E0 = {0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    public final ImageView A;
    public final long[] A0;
    public final ImageView B;
    public final boolean[] B0;
    public final View C;
    public long C0;
    public final ImageView D;
    public boolean D0;
    public final ImageView E;
    public final ImageView F;
    public final View G;
    public final View H;
    public final View I;
    public final TextView J;
    public final TextView K;
    public final o0 L;
    public final StringBuilder M;
    public final Formatter N;
    public final r1 O;
    public final t1 P;
    public final e Q;
    public final Drawable R;
    public final Drawable S;
    public final Drawable T;
    public final String U;
    public final String V;
    public final String W;

    /* renamed from: a0  reason: collision with root package name */
    public final Drawable f8179a0;

    /* renamed from: b0  reason: collision with root package name */
    public final Drawable f8180b0;

    /* renamed from: c0  reason: collision with root package name */
    public final float f8181c0;

    /* renamed from: d0  reason: collision with root package name */
    public final float f8182d0;

    /* renamed from: e0  reason: collision with root package name */
    public final String f8183e0;

    /* renamed from: f0  reason: collision with root package name */
    public final String f8184f0;

    /* renamed from: g0  reason: collision with root package name */
    public final Drawable f8185g0;

    /* renamed from: h  reason: collision with root package name */
    public final c0 f8186h;

    /* renamed from: h0  reason: collision with root package name */
    public final Drawable f8187h0;

    /* renamed from: i  reason: collision with root package name */
    public final Resources f8188i;

    /* renamed from: i0  reason: collision with root package name */
    public final String f8189i0;

    /* renamed from: j  reason: collision with root package name */
    public final k f8190j;

    /* renamed from: j0  reason: collision with root package name */
    public final String f8191j0;

    /* renamed from: k  reason: collision with root package name */
    public final CopyOnWriteArrayList f8192k;

    /* renamed from: k0  reason: collision with root package name */
    public final Drawable f8193k0;

    /* renamed from: l  reason: collision with root package name */
    public final RecyclerView f8194l;

    /* renamed from: l0  reason: collision with root package name */
    public final Drawable f8195l0;

    /* renamed from: m  reason: collision with root package name */
    public final q f8196m;

    /* renamed from: m0  reason: collision with root package name */
    public final String f8197m0;

    /* renamed from: n  reason: collision with root package name */
    public final n f8198n;

    /* renamed from: n0  reason: collision with root package name */
    public final String f8199n0;

    /* renamed from: o  reason: collision with root package name */
    public final j f8200o;

    /* renamed from: o0  reason: collision with root package name */
    public k1 f8201o0;

    /* renamed from: p  reason: collision with root package name */
    public final j f8202p;

    /* renamed from: p0  reason: collision with root package name */
    public l f8203p0;

    /* renamed from: q  reason: collision with root package name */
    public final f f8204q;

    /* renamed from: q0  reason: collision with root package name */
    public boolean f8205q0;

    /* renamed from: r  reason: collision with root package name */
    public final PopupWindow f8206r;

    /* renamed from: r0  reason: collision with root package name */
    public boolean f8207r0;

    /* renamed from: s  reason: collision with root package name */
    public final int f8208s;

    /* renamed from: s0  reason: collision with root package name */
    public boolean f8209s0;

    /* renamed from: t  reason: collision with root package name */
    public final View f8210t;

    /* renamed from: t0  reason: collision with root package name */
    public boolean f8211t0;

    /* renamed from: u  reason: collision with root package name */
    public final View f8212u;

    /* renamed from: u0  reason: collision with root package name */
    public boolean f8213u0;

    /* renamed from: v  reason: collision with root package name */
    public final View f8214v;

    /* renamed from: v0  reason: collision with root package name */
    public int f8215v0 = 5000;

    /* renamed from: w  reason: collision with root package name */
    public final View f8216w;

    /* renamed from: w0  reason: collision with root package name */
    public int f8217w0 = 200;

    /* renamed from: x  reason: collision with root package name */
    public final View f8218x;

    /* renamed from: x0  reason: collision with root package name */
    public int f8219x0 = 0;

    /* renamed from: y  reason: collision with root package name */
    public final TextView f8220y;

    /* renamed from: y0  reason: collision with root package name */
    public long[] f8221y0;

    /* renamed from: z  reason: collision with root package name */
    public final TextView f8222z;

    /* renamed from: z0  reason: collision with root package name */
    public boolean[] f8223z0;

    static {
        t0.a("media3.ui");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public w(android.content.Context r30, android.util.AttributeSet r31) {
        /*
            r29 = this;
            r1 = r29
            r0 = r30
            r2 = r31
            r9 = 0
            r10 = 0
            r1.<init>(r0, r9, r10)
            r3 = 5000(0x1388, float:7.006E-42)
            r1.f8215v0 = r3
            r1.f8219x0 = r10
            r3 = 200(0xc8, float:2.8E-43)
            r1.f8217w0 = r3
            r11 = 23
            r3 = 18
            r12 = 2
            r4 = 2131558466(0x7f0d0042, float:1.8742249E38)
            r13 = 1
            if (r2 == 0) goto L_0x008c
            android.content.res.Resources$Theme r5 = r30.getTheme()
            int[] r6 = i3.h0.f8100c
            android.content.res.TypedArray r5 = r5.obtainStyledAttributes(r2, r6, r10, r10)
            r6 = 6
            int r4 = r5.getResourceId(r6, r4)     // Catch:{ all -> 0x0087 }
            int r6 = r1.f8215v0     // Catch:{ all -> 0x0087 }
            r7 = 21
            int r6 = r5.getInt(r7, r6)     // Catch:{ all -> 0x0087 }
            r1.f8215v0 = r6     // Catch:{ all -> 0x0087 }
            int r6 = r1.f8219x0     // Catch:{ all -> 0x0087 }
            r7 = 9
            int r6 = r5.getInt(r7, r6)     // Catch:{ all -> 0x0087 }
            r1.f8219x0 = r6     // Catch:{ all -> 0x0087 }
            boolean r6 = r5.getBoolean(r3, r13)     // Catch:{ all -> 0x0087 }
            r7 = 15
            boolean r7 = r5.getBoolean(r7, r13)     // Catch:{ all -> 0x0087 }
            r8 = 17
            boolean r8 = r5.getBoolean(r8, r13)     // Catch:{ all -> 0x0087 }
            r14 = 16
            boolean r14 = r5.getBoolean(r14, r13)     // Catch:{ all -> 0x0087 }
            r15 = 19
            boolean r15 = r5.getBoolean(r15, r10)     // Catch:{ all -> 0x0087 }
            r9 = 20
            boolean r9 = r5.getBoolean(r9, r10)     // Catch:{ all -> 0x0087 }
            r3 = 22
            boolean r3 = r5.getBoolean(r3, r10)     // Catch:{ all -> 0x0087 }
            int r10 = r1.f8217w0     // Catch:{ all -> 0x0087 }
            int r10 = r5.getInt(r11, r10)     // Catch:{ all -> 0x0087 }
            r1.setTimeBarMinUpdateInterval(r10)     // Catch:{ all -> 0x0087 }
            boolean r10 = r5.getBoolean(r12, r13)     // Catch:{ all -> 0x0087 }
            r5.recycle()
            r5 = r15
            r15 = r8
            r8 = r9
            r9 = r3
            r28 = r10
            r10 = r6
            r6 = r14
            r14 = r7
            r7 = r28
            goto L_0x0094
        L_0x0087:
            r0 = move-exception
            r5.recycle()
            throw r0
        L_0x008c:
            r5 = 0
            r6 = 1
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 1
            r14 = 1
            r15 = 1
        L_0x0094:
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r30)
            r3.inflate(r4, r1)
            r3 = 262144(0x40000, float:3.67342E-40)
            r1.setDescendantFocusability(r3)
            i3.k r4 = new i3.k
            r4.<init>(r1)
            r1.f8190j = r4
            java.util.concurrent.CopyOnWriteArrayList r3 = new java.util.concurrent.CopyOnWriteArrayList
            r3.<init>()
            r1.f8192k = r3
            g1.r1 r3 = new g1.r1
            r3.<init>()
            r1.O = r3
            g1.t1 r3 = new g1.t1
            r3.<init>()
            r1.P = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r1.M = r3
            java.util.Formatter r11 = new java.util.Formatter
            java.util.Locale r12 = java.util.Locale.getDefault()
            r11.<init>(r3, r12)
            r1.N = r11
            r3 = 0
            long[] r11 = new long[r3]
            r1.f8221y0 = r11
            boolean[] r11 = new boolean[r3]
            r1.f8223z0 = r11
            long[] r11 = new long[r3]
            r1.A0 = r11
            boolean[] r11 = new boolean[r3]
            r1.B0 = r11
            androidx.activity.e r3 = new androidx.activity.e
            r11 = 18
            r3.<init>(r11, r1)
            r1.Q = r3
            r3 = 2131362061(0x7f0a010d, float:1.8343892E38)
            android.view.View r3 = r1.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r1.J = r3
            r3 = 2131362080(0x7f0a0120, float:1.834393E38)
            android.view.View r3 = r1.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r1.K = r3
            r3 = 2131362092(0x7f0a012c, float:1.8343955E38)
            android.view.View r3 = r1.findViewById(r3)
            r11 = r3
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            r1.D = r11
            if (r11 == 0) goto L_0x010f
            r11.setOnClickListener(r4)
        L_0x010f:
            r3 = 2131362067(0x7f0a0113, float:1.8343904E38)
            android.view.View r3 = r1.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r1.E = r3
            i3.h r12 = new i3.h
            r13 = 0
            r12.<init>(r1, r13)
            r13 = 8
            if (r3 != 0) goto L_0x0125
            goto L_0x012b
        L_0x0125:
            r3.setVisibility(r13)
            r3.setOnClickListener(r12)
        L_0x012b:
            r3 = 2131362071(0x7f0a0117, float:1.8343912E38)
            android.view.View r3 = r1.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r1.F = r3
            i3.h r12 = new i3.h
            r13 = 1
            r12.<init>(r1, r13)
            if (r3 != 0) goto L_0x013f
            goto L_0x0147
        L_0x013f:
            r13 = 8
            r3.setVisibility(r13)
            r3.setOnClickListener(r12)
        L_0x0147:
            r3 = 2131362087(0x7f0a0127, float:1.8343945E38)
            android.view.View r3 = r1.findViewById(r3)
            r1.G = r3
            if (r3 == 0) goto L_0x0155
            r3.setOnClickListener(r4)
        L_0x0155:
            r3 = 2131362079(0x7f0a011f, float:1.8343928E38)
            android.view.View r3 = r1.findViewById(r3)
            r1.H = r3
            if (r3 == 0) goto L_0x0163
            r3.setOnClickListener(r4)
        L_0x0163:
            r3 = 2131362051(0x7f0a0103, float:1.8343872E38)
            android.view.View r3 = r1.findViewById(r3)
            r1.I = r3
            if (r3 == 0) goto L_0x0171
            r3.setOnClickListener(r4)
        L_0x0171:
            r3 = 2131362082(0x7f0a0122, float:1.8343935E38)
            android.view.View r12 = r1.findViewById(r3)
            i3.o0 r12 = (i3.o0) r12
            r13 = 2131362083(0x7f0a0123, float:1.8343937E38)
            android.view.View r13 = r1.findViewById(r13)
            if (r12 == 0) goto L_0x018a
            r1.L = r12
            r19 = r5
            r20 = r6
            goto L_0x01bd
        L_0x018a:
            if (r13 == 0) goto L_0x01b6
            androidx.media3.ui.DefaultTimeBar r12 = new androidx.media3.ui.DefaultTimeBar
            r19 = r5
            r5 = 2132017482(0x7f14014a, float:1.9673244E38)
            r20 = r6
            r6 = 0
            r12.<init>(r0, r6, r2, r5)
            r12.setId(r3)
            android.view.ViewGroup$LayoutParams r2 = r13.getLayoutParams()
            r12.setLayoutParams(r2)
            android.view.ViewParent r2 = r13.getParent()
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            int r3 = r2.indexOfChild(r13)
            r2.removeView(r13)
            r2.addView(r12, r3)
            r1.L = r12
            goto L_0x01bd
        L_0x01b6:
            r19 = r5
            r20 = r6
            r6 = 0
            r1.L = r6
        L_0x01bd:
            i3.o0 r2 = r1.L
            if (r2 == 0) goto L_0x01c8
            androidx.media3.ui.DefaultTimeBar r2 = (androidx.media3.ui.DefaultTimeBar) r2
            java.util.concurrent.CopyOnWriteArraySet r2 = r2.E
            r2.add(r4)
        L_0x01c8:
            r2 = 2131362078(0x7f0a011e, float:1.8343926E38)
            android.view.View r2 = r1.findViewById(r2)
            r1.f8214v = r2
            if (r2 == 0) goto L_0x01d6
            r2.setOnClickListener(r4)
        L_0x01d6:
            r2 = 2131362081(0x7f0a0121, float:1.8343933E38)
            android.view.View r12 = r1.findViewById(r2)
            r1.f8210t = r12
            if (r12 == 0) goto L_0x01e4
            r12.setOnClickListener(r4)
        L_0x01e4:
            r2 = 2131362072(0x7f0a0118, float:1.8343914E38)
            android.view.View r13 = r1.findViewById(r2)
            r1.f8212u = r13
            if (r13 == 0) goto L_0x01f2
            r13.setOnClickListener(r4)
        L_0x01f2:
            r3 = 2131296256(0x7f090000, float:1.8210424E38)
            java.lang.ThreadLocal r2 = d0.s.f4115a
            boolean r2 = r30.isRestricted()
            if (r2 == 0) goto L_0x0209
            r24 = r4
            r27 = r7
            r25 = r19
            r26 = r20
            r6 = 0
            r19 = r9
            r9 = r8
            goto L_0x022e
        L_0x0209:
            android.util.TypedValue r5 = new android.util.TypedValue
            r5.<init>()
            r6 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r2 = r30
            r24 = r4
            r4 = r5
            r25 = r19
            r5 = r6
            r26 = r20
            r6 = r21
            r27 = r7
            r7 = r22
            r19 = r9
            r9 = r8
            r8 = r23
            android.graphics.Typeface r6 = d0.s.b(r2, r3, r4, r5, r6, r7, r8)
        L_0x022e:
            r2 = 2131362085(0x7f0a0125, float:1.834394E38)
            android.view.View r2 = r1.findViewById(r2)
            if (r2 != 0) goto L_0x0241
            r3 = 2131362086(0x7f0a0126, float:1.8343943E38)
            android.view.View r3 = r1.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            goto L_0x0242
        L_0x0241:
            r3 = 0
        L_0x0242:
            r1.f8222z = r3
            if (r3 == 0) goto L_0x0249
            r3.setTypeface(r6)
        L_0x0249:
            if (r2 != 0) goto L_0x024c
            r2 = r3
        L_0x024c:
            r1.f8218x = r2
            r3 = r24
            if (r2 == 0) goto L_0x0255
            r2.setOnClickListener(r3)
        L_0x0255:
            r4 = 2131362065(0x7f0a0111, float:1.83439E38)
            android.view.View r4 = r1.findViewById(r4)
            if (r4 != 0) goto L_0x0268
            r5 = 2131362066(0x7f0a0112, float:1.8343902E38)
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            goto L_0x0269
        L_0x0268:
            r5 = 0
        L_0x0269:
            r1.f8220y = r5
            if (r5 == 0) goto L_0x0270
            r5.setTypeface(r6)
        L_0x0270:
            if (r4 != 0) goto L_0x0273
            r4 = r5
        L_0x0273:
            r1.f8216w = r4
            if (r4 == 0) goto L_0x027a
            r4.setOnClickListener(r3)
        L_0x027a:
            r5 = 2131362084(0x7f0a0124, float:1.8343939E38)
            android.view.View r5 = r1.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r1.A = r5
            if (r5 == 0) goto L_0x028a
            r5.setOnClickListener(r3)
        L_0x028a:
            r6 = 2131362089(0x7f0a0129, float:1.8343949E38)
            android.view.View r6 = r1.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r1.B = r6
            if (r6 == 0) goto L_0x029a
            r6.setOnClickListener(r3)
        L_0x029a:
            android.content.res.Resources r7 = r30.getResources()
            r1.f8188i = r7
            r8 = 2131427338(0x7f0b000a, float:1.847629E38)
            int r8 = r7.getInteger(r8)
            float r8 = (float) r8
            r20 = 1120403456(0x42c80000, float:100.0)
            float r8 = r8 / r20
            r1.f8181c0 = r8
            r8 = 2131427337(0x7f0b0009, float:1.8476287E38)
            int r8 = r7.getInteger(r8)
            float r8 = (float) r8
            float r8 = r8 / r20
            r1.f8182d0 = r8
            r8 = 2131362097(0x7f0a0131, float:1.8343965E38)
            android.view.View r8 = r1.findViewById(r8)
            r1.C = r8
            r31 = r5
            if (r8 == 0) goto L_0x02cb
            r5 = 0
            r1.l(r8, r5)
        L_0x02cb:
            i3.c0 r5 = new i3.c0
            r5.<init>(r1)
            r1.f8186h = r5
            r20 = r8
            r8 = r27
            r5.C = r8
            r18 = r9
            r8 = 2
            java.lang.String[] r9 = new java.lang.String[r8]
            android.graphics.drawable.Drawable[] r8 = new android.graphics.drawable.Drawable[r8]
            r21 = r11
            r11 = 2131951787(0x7f1300ab, float:1.9539998E38)
            java.lang.String r11 = r7.getString(r11)
            r17 = 0
            r9[r17] = r11
            r11 = 2131230969(0x7f0800f9, float:1.8078006E38)
            android.graphics.drawable.Drawable r11 = j1.l0.p(r0, r7, r11)
            r8[r17] = r11
            r11 = 2131951820(0x7f1300cc, float:1.9540065E38)
            java.lang.String r11 = r7.getString(r11)
            r16 = 1
            r9[r16] = r11
            r11 = 2131230951(0x7f0800e7, float:1.807797E38)
            android.graphics.drawable.Drawable r11 = j1.l0.p(r0, r7, r11)
            r8[r16] = r11
            i3.q r11 = new i3.q
            r11.<init>(r1, r9, r8)
            r1.f8196m = r11
            r8 = 2131165345(0x7f0700a1, float:1.7944904E38)
            int r8 = r7.getDimensionPixelSize(r8)
            r1.f8208s = r8
            android.view.LayoutInflater r8 = android.view.LayoutInflater.from(r30)
            r9 = 2131558468(0x7f0d0044, float:1.8742253E38)
            r22 = r6
            r6 = 0
            android.view.View r6 = r8.inflate(r9, r6)
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            r1.f8194l = r6
            r6.setAdapter(r11)
            androidx.recyclerview.widget.LinearLayoutManager r8 = new androidx.recyclerview.widget.LinearLayoutManager
            r29.getContext()
            r9 = 1
            r8.<init>(r9)
            r6.setLayoutManager(r8)
            android.widget.PopupWindow r8 = new android.widget.PopupWindow
            r11 = -2
            r8.<init>(r6, r11, r11, r9)
            r1.f8206r = r8
            int r6 = j1.l0.f8453a
            r11 = 23
            if (r6 >= r11) goto L_0x0351
            android.graphics.drawable.ColorDrawable r6 = new android.graphics.drawable.ColorDrawable
            r11 = 0
            r6.<init>(r11)
            r8.setBackgroundDrawable(r6)
        L_0x0351:
            r8.setOnDismissListener(r3)
            r1.D0 = r9
            i3.f r3 = new i3.f
            android.content.res.Resources r6 = r29.getResources()
            r3.<init>(r6)
            r1.f8204q = r3
            r3 = 2131230971(0x7f0800fb, float:1.807801E38)
            android.graphics.drawable.Drawable r3 = j1.l0.p(r0, r7, r3)
            r1.f8185g0 = r3
            r3 = 2131230970(0x7f0800fa, float:1.8078008E38)
            android.graphics.drawable.Drawable r3 = j1.l0.p(r0, r7, r3)
            r1.f8187h0 = r3
            r3 = 2131951776(0x7f1300a0, float:1.9539976E38)
            java.lang.String r3 = r7.getString(r3)
            r1.f8189i0 = r3
            r3 = 2131951775(0x7f13009f, float:1.9539974E38)
            java.lang.String r3 = r7.getString(r3)
            r1.f8191j0 = r3
            i3.j r3 = new i3.j
            r6 = 0
            r8 = 1
            r3.<init>(r1, r8, r6)
            r1.f8200o = r3
            i3.j r3 = new i3.j
            r3.<init>(r1, r6, r6)
            r1.f8202p = r3
            i3.n r3 = new i3.n
            r8 = 2130903049(0x7f030009, float:1.7412905E38)
            java.lang.String[] r8 = r7.getStringArray(r8)
            float[] r9 = E0
            r3.<init>(r1, r8, r9)
            r1.f8198n = r3
            r3 = 2131230955(0x7f0800eb, float:1.8077977E38)
            android.graphics.drawable.Drawable r3 = j1.l0.p(r0, r7, r3)
            r1.f8193k0 = r3
            r3 = 2131230954(0x7f0800ea, float:1.8077975E38)
            android.graphics.drawable.Drawable r3 = j1.l0.p(r0, r7, r3)
            r1.f8195l0 = r3
            r3 = 2131230963(0x7f0800f3, float:1.8077994E38)
            android.graphics.drawable.Drawable r3 = j1.l0.p(r0, r7, r3)
            r1.R = r3
            r3 = 2131230964(0x7f0800f4, float:1.8077996E38)
            android.graphics.drawable.Drawable r3 = j1.l0.p(r0, r7, r3)
            r1.S = r3
            r3 = 2131230962(0x7f0800f2, float:1.8077992E38)
            android.graphics.drawable.Drawable r3 = j1.l0.p(r0, r7, r3)
            r1.T = r3
            r3 = 2131230968(0x7f0800f8, float:1.8078004E38)
            android.graphics.drawable.Drawable r3 = j1.l0.p(r0, r7, r3)
            r1.f8179a0 = r3
            r3 = 2131230967(0x7f0800f7, float:1.8078002E38)
            android.graphics.drawable.Drawable r0 = j1.l0.p(r0, r7, r3)
            r1.f8180b0 = r0
            r0 = 2131951780(0x7f1300a4, float:1.9539984E38)
            java.lang.String r0 = r7.getString(r0)
            r1.f8197m0 = r0
            r0 = 2131951779(0x7f1300a3, float:1.9539982E38)
            java.lang.String r0 = r7.getString(r0)
            r1.f8199n0 = r0
            r0 = 2131951790(0x7f1300ae, float:1.9540004E38)
            java.lang.String r0 = r7.getString(r0)
            r1.U = r0
            r0 = 2131951791(0x7f1300af, float:1.9540006E38)
            java.lang.String r0 = r7.getString(r0)
            r1.V = r0
            r0 = 2131951789(0x7f1300ad, float:1.9540002E38)
            java.lang.String r0 = r7.getString(r0)
            r1.W = r0
            r0 = 2131951797(0x7f1300b5, float:1.9540019E38)
            java.lang.String r0 = r7.getString(r0)
            r1.f8183e0 = r0
            r0 = 2131951796(0x7f1300b4, float:1.9540017E38)
            java.lang.String r0 = r7.getString(r0)
            r1.f8184f0 = r0
            r0 = 2131362053(0x7f0a0105, float:1.8343876E38)
            android.view.View r0 = r1.findViewById(r0)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r3 = 1
            r5.i(r0, r3)
            r5.i(r4, r14)
            r5.i(r2, r10)
            r5.i(r12, r15)
            r14 = r26
            r5.i(r13, r14)
            r0 = r22
            r15 = r25
            r5.i(r0, r15)
            r9 = r18
            r3 = r21
            r5.i(r3, r9)
            r3 = r19
            r0 = r20
            r5.i(r0, r3)
            int r0 = r1.f8219x0
            if (r0 == 0) goto L_0x045b
            r0 = r31
            r10 = 1
            goto L_0x045e
        L_0x045b:
            r0 = r31
            r10 = 0
        L_0x045e:
            r5.i(r0, r10)
            androidx.activity.u r0 = new androidx.activity.u
            r2 = 1
            r0.<init>(r2, r1)
            r1.addOnLayoutChangeListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.w.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public static void a(w wVar) {
        String str;
        if (wVar.f8203p0 != null) {
            boolean z10 = !wVar.f8205q0;
            wVar.f8205q0 = z10;
            String str2 = wVar.f8197m0;
            Drawable drawable = wVar.f8193k0;
            String str3 = wVar.f8199n0;
            Drawable drawable2 = wVar.f8195l0;
            ImageView imageView = wVar.E;
            if (imageView != null) {
                if (z10) {
                    imageView.setImageDrawable(drawable);
                    str = str2;
                } else {
                    imageView.setImageDrawable(drawable2);
                    str = str3;
                }
                imageView.setContentDescription(str);
            }
            boolean z11 = wVar.f8205q0;
            ImageView imageView2 = wVar.F;
            if (imageView2 != null) {
                if (z11) {
                    imageView2.setImageDrawable(drawable);
                } else {
                    imageView2.setImageDrawable(drawable2);
                    str2 = str3;
                }
                imageView2.setContentDescription(str2);
            }
            l lVar = wVar.f8203p0;
            if (lVar != null) {
                ((d0) lVar).f8073j.getClass();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r9 = r9.j0();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(g1.k1 r9, g1.t1 r10) {
        /*
            r0 = 17
            boolean r0 = r9.L0(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            g1.u1 r9 = r9.j0()
            int r0 = r9.x()
            r2 = 1
            if (r0 <= r2) goto L_0x0031
            r3 = 100
            if (r0 <= r3) goto L_0x001a
            goto L_0x0031
        L_0x001a:
            r3 = 0
        L_0x001b:
            if (r3 >= r0) goto L_0x0030
            g1.t1 r4 = r9.v(r3, r10)
            long r4 = r4.f6588u
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x002d
            return r1
        L_0x002d:
            int r3 = r3 + 1
            goto L_0x001b
        L_0x0030:
            return r2
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.w.c(g1.k1, g1.t1):boolean");
    }

    public static void e(k1 k1Var) {
        int b10 = k1Var.b();
        if (b10 == 1 && k1Var.L0(2)) {
            k1Var.e();
        } else if (b10 == 4 && k1Var.L0(4)) {
            k1Var.R();
        }
        if (k1Var.L0(1)) {
            k1Var.P();
        }
    }

    /* access modifiers changed from: private */
    public void setPlaybackSpeed(float f10) {
        k1 k1Var = this.f8201o0;
        if (k1Var != null && k1Var.L0(13)) {
            k1 k1Var2 = this.f8201o0;
            k1Var2.d(new e1(f10, k1Var2.i().f6356i));
        }
    }

    public final boolean d(KeyEvent keyEvent) {
        boolean z10;
        int keyCode = keyEvent.getKeyCode();
        k1 k1Var = this.f8201o0;
        if (k1Var != null) {
            if (keyCode == 90 || keyCode == 89 || keyCode == 85 || keyCode == 79 || keyCode == 126 || keyCode == 127 || keyCode == 87 || keyCode == 88) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                if (keyEvent.getAction() == 0) {
                    if (keyCode == 90) {
                        if (k1Var.b() != 4 && k1Var.L0(12)) {
                            k1Var.v0();
                        }
                    } else if (keyCode == 89 && k1Var.L0(11)) {
                        k1Var.A0();
                    } else if (keyEvent.getRepeatCount() == 0) {
                        if (keyCode == 79 || keyCode == 85) {
                            int b10 = k1Var.b();
                            if (b10 == 1 || b10 == 4 || !k1Var.y()) {
                                e(k1Var);
                            } else if (k1Var.L0(1)) {
                                k1Var.g();
                            }
                        } else if (keyCode != 87) {
                            if (keyCode != 88) {
                                if (keyCode == 126) {
                                    e(k1Var);
                                } else if (keyCode == 127 && k1Var.L0(1)) {
                                    k1Var.g();
                                }
                            } else if (k1Var.L0(7)) {
                                k1Var.D0();
                            }
                        } else if (k1Var.L0(9)) {
                            k1Var.u0();
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return d(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public final void f(g1 g1Var, View view) {
        this.f8194l.setAdapter(g1Var);
        r();
        this.D0 = false;
        PopupWindow popupWindow = this.f8206r;
        popupWindow.dismiss();
        this.D0 = true;
        int width = getWidth() - popupWindow.getWidth();
        int i10 = this.f8208s;
        popupWindow.showAsDropDown(view, width - i10, (-popupWindow.getHeight()) - i10);
    }

    public final d9.r1 g(int i10, a2 a2Var) {
        boolean z10;
        o0 o0Var = new o0();
        r0 r0Var = a2Var.f6289h;
        for (int i11 = 0; i11 < r0Var.size(); i11++) {
            z1 z1Var = (z1) r0Var.get(i11);
            if (z1Var.f6778i.f6675j == i10) {
                for (int i12 = 0; i12 < z1Var.f6777h; i12++) {
                    if (z1Var.f6780k[i12] != 4) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    if (z10) {
                        a0 a0Var = z1Var.f6778i.f6676k[i12];
                        if ((a0Var.f6268k & 2) == 0) {
                            o0Var.c(new s(a2Var, i11, i12, this.f8204q.d(a0Var)));
                        }
                    }
                }
            }
        }
        return o0Var.e();
    }

    public k1 getPlayer() {
        return this.f8201o0;
    }

    public int getRepeatToggleModes() {
        return this.f8219x0;
    }

    public boolean getShowShuffleButton() {
        return this.f8186h.c(this.B);
    }

    public boolean getShowSubtitleButton() {
        return this.f8186h.c(this.D);
    }

    public int getShowTimeoutMs() {
        return this.f8215v0;
    }

    public boolean getShowVrButton() {
        return this.f8186h.c(this.C);
    }

    public final void h() {
        c0 c0Var = this.f8186h;
        int i10 = c0Var.f8063z;
        if (i10 != 3 && i10 != 2) {
            c0Var.g();
            if (!c0Var.C) {
                c0Var.j(2);
            } else if (c0Var.f8063z == 1) {
                c0Var.f8050m.start();
            } else {
                c0Var.f8051n.start();
            }
        }
    }

    public final boolean i() {
        c0 c0Var = this.f8186h;
        if (c0Var.f8063z != 0 || !c0Var.f8038a.j()) {
            return false;
        }
        return true;
    }

    public final boolean j() {
        return getVisibility() == 0;
    }

    public final void k() {
        n();
        m();
        q();
        s();
        u();
        o();
        t();
    }

    public final void l(View view, boolean z10) {
        if (view != null) {
            view.setEnabled(z10);
            view.setAlpha(z10 ? this.f8181c0 : this.f8182d0);
        }
    }

    public final void m() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        long j10;
        long j11;
        int i10;
        if (j() && this.f8207r0) {
            k1 k1Var = this.f8201o0;
            if (k1Var != null) {
                if (!this.f8209s0 || !c(k1Var, this.P)) {
                    i10 = 5;
                } else {
                    i10 = 10;
                }
                z13 = k1Var.L0(i10);
                z12 = k1Var.L0(7);
                z11 = k1Var.L0(11);
                z10 = k1Var.L0(12);
                z14 = k1Var.L0(9);
            } else {
                z14 = false;
                z13 = false;
                z12 = false;
                z11 = false;
                z10 = false;
            }
            Resources resources = this.f8188i;
            View view = this.f8218x;
            if (z11) {
                k1 k1Var2 = this.f8201o0;
                if (k1Var2 != null) {
                    j11 = k1Var2.G0();
                } else {
                    j11 = 5000;
                }
                int i11 = (int) (j11 / 1000);
                TextView textView = this.f8222z;
                if (textView != null) {
                    textView.setText(String.valueOf(i11));
                }
                if (view != null) {
                    view.setContentDescription(resources.getQuantityString(R.plurals.exo_controls_rewind_by_amount_description, i11, new Object[]{Integer.valueOf(i11)}));
                }
            }
            View view2 = this.f8216w;
            if (z10) {
                k1 k1Var3 = this.f8201o0;
                if (k1Var3 != null) {
                    j10 = k1Var3.q();
                } else {
                    j10 = 15000;
                }
                int i12 = (int) (j10 / 1000);
                TextView textView2 = this.f8220y;
                if (textView2 != null) {
                    textView2.setText(String.valueOf(i12));
                }
                if (view2 != null) {
                    view2.setContentDescription(resources.getQuantityString(R.plurals.exo_controls_fastforward_by_amount_description, i12, new Object[]{Integer.valueOf(i12)}));
                }
            }
            l(this.f8210t, z12);
            l(view, z11);
            l(view2, z10);
            l(this.f8212u, z14);
            o0 o0Var = this.L;
            if (o0Var != null) {
                o0Var.setEnabled(z13);
            }
        }
    }

    public final void n() {
        View view;
        boolean z10;
        int i10;
        int i11;
        if (j() && this.f8207r0 && (view = this.f8214v) != null) {
            k1 k1Var = this.f8201o0;
            boolean z11 = true;
            if (k1Var == null || k1Var.b() == 4 || this.f8201o0.b() == 1 || !this.f8201o0.y()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                i10 = R.drawable.exo_styled_controls_pause;
            } else {
                i10 = R.drawable.exo_styled_controls_play;
            }
            if (z10) {
                i11 = R.string.exo_controls_pause_description;
            } else {
                i11 = R.string.exo_controls_play_description;
            }
            Context context = getContext();
            Resources resources = this.f8188i;
            ((ImageView) view).setImageDrawable(l0.p(context, resources, i10));
            view.setContentDescription(resources.getString(i11));
            k1 k1Var2 = this.f8201o0;
            if (k1Var2 == null || !k1Var2.L0(1) || (this.f8201o0.L0(17) && this.f8201o0.j0().y())) {
                z11 = false;
            }
            l(view, z11);
        }
    }

    public final void o() {
        n nVar;
        k1 k1Var = this.f8201o0;
        if (k1Var != null) {
            float f10 = k1Var.i().f6355h;
            boolean z10 = false;
            float f11 = Float.MAX_VALUE;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                nVar = this.f8198n;
                float[] fArr = nVar.f8145b;
                if (i10 >= fArr.length) {
                    break;
                }
                float abs = Math.abs(f10 - fArr[i10]);
                if (abs < f11) {
                    i11 = i10;
                    f11 = abs;
                }
                i10++;
            }
            nVar.f8146c = i11;
            String str = nVar.f8144a[i11];
            q qVar = this.f8196m;
            qVar.f8154b[0] = str;
            if (qVar.a(1) || qVar.a(0)) {
                z10 = true;
            }
            l(this.G, z10);
        }
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c0 c0Var = this.f8186h;
        c0Var.f8038a.addOnLayoutChangeListener(c0Var.f8061x);
        this.f8207r0 = true;
        if (i()) {
            c0Var.h();
        }
        k();
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c0 c0Var = this.f8186h;
        c0Var.f8038a.removeOnLayoutChangeListener(c0Var.f8061x);
        this.f8207r0 = false;
        removeCallbacks(this.Q);
        c0Var.g();
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        View view = this.f8186h.f8039b;
        if (view != null) {
            view.layout(0, 0, i12 - i10, i13 - i11);
        }
    }

    public final void p() {
        long j10;
        long j11;
        if (j() && this.f8207r0) {
            k1 k1Var = this.f8201o0;
            if (k1Var == null || !k1Var.L0(16)) {
                j11 = 0;
                j10 = 0;
            } else {
                j11 = k1Var.t() + this.C0;
                j10 = k1Var.r0() + this.C0;
            }
            TextView textView = this.K;
            if (textView != null && !this.f8213u0) {
                textView.setText(l0.x(this.M, this.N, j11));
            }
            o0 o0Var = this.L;
            if (o0Var != null) {
                o0Var.setPosition(j11);
                o0Var.setBufferedPosition(j10);
            }
            e eVar = this.Q;
            removeCallbacks(eVar);
            int b10 = k1Var == null ? 1 : k1Var.b();
            long j12 = 1000;
            if (k1Var != null && k1Var.I()) {
                long min = Math.min(o0Var != null ? o0Var.getPreferredUpdateDelay() : 1000, 1000 - (j11 % 1000));
                float f10 = k1Var.i().f6355h;
                if (f10 > 0.0f) {
                    j12 = (long) (((float) min) / f10);
                }
                postDelayed(eVar, l0.i(j12, (long) this.f8217w0, 1000));
            } else if (b10 != 4 && b10 != 1) {
                postDelayed(eVar, 1000);
            }
        }
    }

    public final void q() {
        ImageView imageView;
        String str;
        if (j() && this.f8207r0 && (imageView = this.A) != null) {
            if (this.f8219x0 == 0) {
                l(imageView, false);
                return;
            }
            k1 k1Var = this.f8201o0;
            String str2 = this.U;
            Drawable drawable = this.R;
            if (k1Var == null || !k1Var.L0(15)) {
                l(imageView, false);
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str2);
                return;
            }
            l(imageView, true);
            int h10 = k1Var.h();
            if (h10 != 0) {
                if (h10 == 1) {
                    imageView.setImageDrawable(this.S);
                    str = this.V;
                } else if (h10 == 2) {
                    imageView.setImageDrawable(this.T);
                    str = this.W;
                } else {
                    return;
                }
                imageView.setContentDescription(str);
                return;
            }
            imageView.setImageDrawable(drawable);
            imageView.setContentDescription(str2);
        }
    }

    public final void r() {
        RecyclerView recyclerView = this.f8194l;
        recyclerView.measure(0, 0);
        int width = getWidth();
        int i10 = this.f8208s;
        int min = Math.min(recyclerView.getMeasuredWidth(), width - (i10 * 2));
        PopupWindow popupWindow = this.f8206r;
        popupWindow.setWidth(min);
        popupWindow.setHeight(Math.min(getHeight() - (i10 * 2), recyclerView.getMeasuredHeight()));
    }

    public final void s() {
        ImageView imageView;
        if (j() && this.f8207r0 && (imageView = this.B) != null) {
            k1 k1Var = this.f8201o0;
            if (!this.f8186h.c(imageView)) {
                l(imageView, false);
                return;
            }
            String str = this.f8184f0;
            Drawable drawable = this.f8180b0;
            if (k1Var == null || !k1Var.L0(14)) {
                l(imageView, false);
                imageView.setImageDrawable(drawable);
            } else {
                l(imageView, true);
                if (k1Var.o0()) {
                    drawable = this.f8179a0;
                }
                imageView.setImageDrawable(drawable);
                if (k1Var.o0()) {
                    str = this.f8183e0;
                }
            }
            imageView.setContentDescription(str);
        }
    }

    public void setAnimationEnabled(boolean z10) {
        this.f8186h.C = z10;
    }

    @Deprecated
    public void setOnFullScreenModeChangedListener(l lVar) {
        boolean z10;
        int i10;
        this.f8203p0 = lVar;
        int i11 = 0;
        boolean z11 = true;
        if (lVar != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        ImageView imageView = this.E;
        if (imageView != null) {
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            imageView.setVisibility(i10);
        }
        if (lVar == null) {
            z11 = false;
        }
        ImageView imageView2 = this.F;
        if (imageView2 != null) {
            if (!z11) {
                i11 = 8;
            }
            imageView2.setVisibility(i11);
        }
    }

    public void setPlayer(k1 k1Var) {
        boolean z10 = true;
        a.e(Looper.myLooper() == Looper.getMainLooper());
        if (!(k1Var == null || k1Var.N0() == Looper.getMainLooper())) {
            z10 = false;
        }
        a.b(z10);
        k1 k1Var2 = this.f8201o0;
        if (k1Var2 != k1Var) {
            k kVar = this.f8190j;
            if (k1Var2 != null) {
                k1Var2.z0(kVar);
            }
            this.f8201o0 = k1Var;
            if (k1Var != null) {
                k1Var.x0(kVar);
            }
            k();
        }
    }

    public void setProgressUpdateListener(o oVar) {
    }

    public void setRepeatToggleModes(int i10) {
        this.f8219x0 = i10;
        k1 k1Var = this.f8201o0;
        boolean z10 = false;
        if (k1Var != null && k1Var.L0(15)) {
            int h10 = this.f8201o0.h();
            if (i10 == 0 && h10 != 0) {
                this.f8201o0.f(0);
            } else if (i10 == 1 && h10 == 2) {
                this.f8201o0.f(1);
            } else if (i10 == 2 && h10 == 1) {
                this.f8201o0.f(2);
            }
        }
        if (i10 != 0) {
            z10 = true;
        }
        this.f8186h.i(this.A, z10);
        q();
    }

    public void setShowFastForwardButton(boolean z10) {
        this.f8186h.i(this.f8216w, z10);
        m();
    }

    public void setShowMultiWindowTimeBar(boolean z10) {
        this.f8209s0 = z10;
        t();
    }

    public void setShowNextButton(boolean z10) {
        this.f8186h.i(this.f8212u, z10);
        m();
    }

    public void setShowPreviousButton(boolean z10) {
        this.f8186h.i(this.f8210t, z10);
        m();
    }

    public void setShowRewindButton(boolean z10) {
        this.f8186h.i(this.f8218x, z10);
        m();
    }

    public void setShowShuffleButton(boolean z10) {
        this.f8186h.i(this.B, z10);
        s();
    }

    public void setShowSubtitleButton(boolean z10) {
        this.f8186h.i(this.D, z10);
    }

    public void setShowTimeoutMs(int i10) {
        this.f8215v0 = i10;
        if (i()) {
            this.f8186h.h();
        }
    }

    public void setShowVrButton(boolean z10) {
        this.f8186h.i(this.C, z10);
    }

    public void setTimeBarMinUpdateInterval(int i10) {
        this.f8217w0 = l0.h(i10, 16, 1000);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.C;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            l(view, onClickListener != null);
        }
    }

    public final void t() {
        boolean z10;
        u1 u1Var;
        int i10;
        long j10;
        boolean z11;
        long j11;
        int i11;
        int i12;
        u1 u1Var2;
        u1 u1Var3;
        boolean z12;
        boolean z13;
        int i13;
        k1 k1Var = this.f8201o0;
        if (k1Var != null) {
            boolean z14 = this.f8209s0;
            boolean z15 = false;
            boolean z16 = true;
            t1 t1Var = this.P;
            if (!z14 || !c(k1Var, t1Var)) {
                z10 = false;
            } else {
                z10 = true;
            }
            this.f8211t0 = z10;
            this.C0 = 0;
            if (k1Var.L0(17)) {
                u1Var = k1Var.j0();
            } else {
                u1Var = u1.f6622h;
            }
            long j12 = -9223372036854775807L;
            if (!u1Var.y()) {
                int U2 = k1Var.U();
                boolean z17 = this.f8211t0;
                if (z17) {
                    i11 = 0;
                } else {
                    i11 = U2;
                }
                if (z17) {
                    i12 = u1Var.x() - 1;
                } else {
                    i12 = U2;
                }
                j10 = 0;
                i10 = 0;
                while (true) {
                    if (i11 > i12) {
                        break;
                    }
                    if (i11 == U2) {
                        this.C0 = l0.Q(j10);
                    }
                    u1Var.v(i11, t1Var);
                    if (t1Var.f6588u == j12) {
                        a.e(this.f8211t0 ^ z16);
                        break;
                    }
                    int i14 = t1Var.f6589v;
                    while (i14 <= t1Var.f6590w) {
                        r1 r1Var = this.O;
                        u1Var.o(i14, r1Var, z15);
                        c cVar = r1Var.f6548n;
                        int i15 = cVar.f6332l;
                        while (i15 < cVar.f6329i) {
                            long l10 = r1Var.l(i15);
                            int i16 = U2;
                            if (l10 == Long.MIN_VALUE) {
                                u1Var3 = u1Var;
                                long j13 = r1Var.f6545k;
                                if (j13 == j12) {
                                    u1Var2 = u1Var3;
                                    i15++;
                                    U2 = i16;
                                    u1Var = u1Var2;
                                    j12 = -9223372036854775807L;
                                } else {
                                    l10 = j13;
                                }
                            } else {
                                u1Var3 = u1Var;
                            }
                            long j14 = l10 + r1Var.f6546l;
                            if (j14 >= 0) {
                                long[] jArr = this.f8221y0;
                                if (i10 == jArr.length) {
                                    if (jArr.length == 0) {
                                        i13 = 1;
                                    } else {
                                        i13 = jArr.length * 2;
                                    }
                                    this.f8221y0 = Arrays.copyOf(jArr, i13);
                                    this.f8223z0 = Arrays.copyOf(this.f8223z0, i13);
                                }
                                this.f8221y0[i10] = l0.Q(j10 + j14);
                                boolean[] zArr = this.f8223z0;
                                b i17 = r1Var.f6548n.i(i15);
                                int i18 = i17.f6300i;
                                if (i18 == -1) {
                                    u1Var2 = u1Var3;
                                } else {
                                    int i19 = 0;
                                    while (true) {
                                        u1Var2 = u1Var3;
                                        if (i19 >= i18) {
                                            z13 = true;
                                            z12 = false;
                                            break;
                                        }
                                        int i20 = i17.f6303l[i19];
                                        if (i20 == 0) {
                                            break;
                                        }
                                        b bVar = i17;
                                        z13 = true;
                                        if (i20 == 1) {
                                            break;
                                        }
                                        i19++;
                                        u1Var3 = u1Var2;
                                        i17 = bVar;
                                    }
                                    zArr[i10] = z12 ^ z13;
                                    i10++;
                                }
                                z13 = true;
                                z12 = true;
                                zArr[i10] = z12 ^ z13;
                                i10++;
                            } else {
                                u1Var2 = u1Var3;
                            }
                            i15++;
                            U2 = i16;
                            u1Var = u1Var2;
                            j12 = -9223372036854775807L;
                        }
                        int i21 = U2;
                        i14++;
                        u1Var = u1Var;
                        z15 = false;
                        j12 = -9223372036854775807L;
                    }
                    int i22 = U2;
                    j10 += t1Var.f6588u;
                    i11++;
                    u1Var = u1Var;
                    z15 = false;
                    z16 = true;
                    j12 = -9223372036854775807L;
                }
                z11 = true;
            } else {
                z11 = true;
                if (k1Var.L0(16)) {
                    long J2 = k1Var.J();
                    if (J2 != -9223372036854775807L) {
                        j11 = l0.H(J2);
                        j10 = j11;
                        i10 = 0;
                    }
                }
                j11 = 0;
                j10 = j11;
                i10 = 0;
            }
            long Q2 = l0.Q(j10);
            TextView textView = this.J;
            if (textView != null) {
                textView.setText(l0.x(this.M, this.N, Q2));
            }
            o0 o0Var = this.L;
            if (o0Var != null) {
                o0Var.setDuration(Q2);
                long[] jArr2 = this.A0;
                int length = jArr2.length;
                int i23 = i10 + length;
                long[] jArr3 = this.f8221y0;
                if (i23 > jArr3.length) {
                    this.f8221y0 = Arrays.copyOf(jArr3, i23);
                    this.f8223z0 = Arrays.copyOf(this.f8223z0, i23);
                }
                System.arraycopy(jArr2, 0, this.f8221y0, i10, length);
                System.arraycopy(this.B0, 0, this.f8223z0, i10, length);
                long[] jArr4 = this.f8221y0;
                boolean[] zArr2 = this.f8223z0;
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) o0Var;
                if (i23 != 0 && (jArr4 == null || zArr2 == null)) {
                    z11 = false;
                }
                a.b(z11);
                defaultTimeBar.T = i23;
                defaultTimeBar.U = jArr4;
                defaultTimeBar.V = zArr2;
                defaultTimeBar.f();
            }
            p();
        }
    }

    public final void u() {
        boolean z10;
        d9.r1 r1Var;
        j jVar = this.f8200o;
        jVar.getClass();
        jVar.f8177a = Collections.emptyList();
        j jVar2 = this.f8202p;
        jVar2.getClass();
        jVar2.f8177a = Collections.emptyList();
        k1 k1Var = this.f8201o0;
        boolean z11 = true;
        ImageView imageView = this.D;
        if (k1Var != null && k1Var.L0(30) && this.f8201o0.L0(29)) {
            a2 D2 = this.f8201o0.D();
            jVar2.c(g(1, D2));
            if (this.f8186h.c(imageView)) {
                r1Var = g(3, D2);
            } else {
                r1Var = d9.r1.f4658l;
            }
            jVar.c(r1Var);
        }
        if (jVar.getItemCount() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l(imageView, z10);
        q qVar = this.f8196m;
        if (!qVar.a(1) && !qVar.a(0)) {
            z11 = false;
        }
        l(this.G, z11);
    }
}
