package i3;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.media3.ui.AspectRatioFrameLayout;
import androidx.media3.ui.SubtitleView;
import com.woxthebox.draglistview.R;
import d0.d;
import d9.r0;
import g1.b2;
import g1.d1;
import g1.k1;
import g1.v;
import i1.b;
import j1.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class g0 extends FrameLayout {
    public CharSequence A;
    public int B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;

    /* renamed from: h  reason: collision with root package name */
    public final d0 f8077h;

    /* renamed from: i  reason: collision with root package name */
    public final AspectRatioFrameLayout f8078i;

    /* renamed from: j  reason: collision with root package name */
    public final View f8079j;

    /* renamed from: k  reason: collision with root package name */
    public final View f8080k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f8081l;

    /* renamed from: m  reason: collision with root package name */
    public final ImageView f8082m;

    /* renamed from: n  reason: collision with root package name */
    public final SubtitleView f8083n;

    /* renamed from: o  reason: collision with root package name */
    public final View f8084o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f8085p;

    /* renamed from: q  reason: collision with root package name */
    public final w f8086q;

    /* renamed from: r  reason: collision with root package name */
    public final FrameLayout f8087r;

    /* renamed from: s  reason: collision with root package name */
    public final FrameLayout f8088s;

    /* renamed from: t  reason: collision with root package name */
    public k1 f8089t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f8090u;

    /* renamed from: v  reason: collision with root package name */
    public v f8091v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f8092w;

    /* renamed from: x  reason: collision with root package name */
    public Drawable f8093x;

    /* renamed from: y  reason: collision with root package name */
    public int f8094y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f8095z;

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public g0(android.content.Context r21, android.util.AttributeSet r22) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            r3 = 0
            r1.<init>(r0, r2, r3)
            i3.d0 r4 = new i3.d0
            r5 = r1
            com.github.andreyasadchy.xtra.ui.view.CustomPlayerView r5 = (com.github.andreyasadchy.xtra.ui.view.CustomPlayerView) r5
            r4.<init>(r5)
            r1.f8077h = r4
            boolean r5 = r20.isInEditMode()
            r6 = 0
            if (r5 == 0) goto L_0x006c
            r1.f8078i = r6
            r1.f8079j = r6
            r1.f8080k = r6
            r1.f8081l = r3
            r1.f8082m = r6
            r1.f8083n = r6
            r1.f8084o = r6
            r1.f8085p = r6
            r1.f8086q = r6
            r1.f8087r = r6
            r1.f8088s = r6
            android.widget.ImageView r2 = new android.widget.ImageView
            r2.<init>(r0)
            int r3 = j1.l0.f8453a
            r4 = 23
            r5 = 2131230894(0x7f0800ae, float:1.8077854E38)
            if (r3 < r4) goto L_0x0052
            android.content.res.Resources r3 = r20.getResources()
            android.graphics.drawable.Drawable r0 = j1.l0.p(r0, r3, r5)
            r2.setImageDrawable(r0)
            int r0 = r3.getColor(com.woxthebox.draglistview.R.color.exo_edit_mode_background_color, (android.content.res.Resources.Theme) null)
            r2.setBackgroundColor(r0)
            goto L_0x0067
        L_0x0052:
            android.content.res.Resources r3 = r20.getResources()
            android.graphics.drawable.Drawable r0 = j1.l0.p(r0, r3, r5)
            r2.setImageDrawable(r0)
            r0 = 2131099749(0x7f060065, float:1.781186E38)
            int r0 = r3.getColor(r0)
            r2.setBackgroundColor(r0)
        L_0x0067:
            r1.addView(r2)
            goto L_0x029b
        L_0x006c:
            r5 = 8
            r7 = 5000(0x1388, float:7.006E-42)
            r9 = 1
            r10 = 2131558467(0x7f0d0043, float:1.874225E38)
            if (r2 == 0) goto L_0x00ee
            android.content.res.Resources$Theme r11 = r21.getTheme()
            int[] r12 = i3.h0.f8101d
            android.content.res.TypedArray r11 = r11.obtainStyledAttributes(r2, r12, r3, r3)
            r12 = 27
            boolean r13 = r11.hasValue(r12)     // Catch:{ all -> 0x00e9 }
            int r12 = r11.getColor(r12, r3)     // Catch:{ all -> 0x00e9 }
            r14 = 14
            int r10 = r11.getResourceId(r14, r10)     // Catch:{ all -> 0x00e9 }
            r14 = 32
            boolean r14 = r11.getBoolean(r14, r9)     // Catch:{ all -> 0x00e9 }
            int r15 = r11.getResourceId(r5, r3)     // Catch:{ all -> 0x00e9 }
            r5 = 33
            boolean r5 = r11.getBoolean(r5, r9)     // Catch:{ all -> 0x00e9 }
            r6 = 28
            int r6 = r11.getInt(r6, r9)     // Catch:{ all -> 0x00e9 }
            r8 = 16
            int r8 = r11.getInt(r8, r3)     // Catch:{ all -> 0x00e9 }
            r3 = 25
            int r7 = r11.getInt(r3, r7)     // Catch:{ all -> 0x00e9 }
            r3 = 10
            boolean r3 = r11.getBoolean(r3, r9)     // Catch:{ all -> 0x00e9 }
            r17 = r3
            r3 = 3
            boolean r18 = r11.getBoolean(r3, r9)     // Catch:{ all -> 0x00e9 }
            r3 = 22
            r9 = 0
            int r3 = r11.getInteger(r3, r9)     // Catch:{ all -> 0x00e9 }
            boolean r9 = r1.f8095z     // Catch:{ all -> 0x00e9 }
            r19 = r3
            r3 = 11
            boolean r3 = r11.getBoolean(r3, r9)     // Catch:{ all -> 0x00e9 }
            r1.f8095z = r3     // Catch:{ all -> 0x00e9 }
            r3 = 9
            r9 = 1
            boolean r3 = r11.getBoolean(r3, r9)     // Catch:{ all -> 0x00e9 }
            r11.recycle()
            r11 = r10
            r9 = r19
            r10 = r3
            r3 = r17
            r17 = r7
            r7 = r18
            r18 = r5
            goto L_0x00ff
        L_0x00e9:
            r0 = move-exception
            r11.recycle()
            throw r0
        L_0x00ee:
            r3 = 1
            r6 = 1
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 1
            r11 = 2131558467(0x7f0d0043, float:1.874225E38)
            r12 = 0
            r13 = 0
            r14 = 1
            r15 = 0
            r17 = 5000(0x1388, float:7.006E-42)
            r18 = 1
        L_0x00ff:
            android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r21)
            r5.inflate(r11, r1)
            r5 = 262144(0x40000, float:3.67342E-40)
            r1.setDescendantFocusability(r5)
            r5 = 2131362057(0x7f0a0109, float:1.8343884E38)
            android.view.View r5 = r1.findViewById(r5)
            androidx.media3.ui.AspectRatioFrameLayout r5 = (androidx.media3.ui.AspectRatioFrameLayout) r5
            r1.f8078i = r5
            if (r5 == 0) goto L_0x011b
            r5.setResizeMode(r8)
        L_0x011b:
            r8 = 2131362090(0x7f0a012a, float:1.834395E38)
            android.view.View r8 = r1.findViewById(r8)
            r1.f8079j = r8
            if (r8 == 0) goto L_0x012b
            if (r13 == 0) goto L_0x012b
            r8.setBackgroundColor(r12)
        L_0x012b:
            r8 = 2
            if (r5 == 0) goto L_0x01af
            if (r6 == 0) goto L_0x01af
            android.view.ViewGroup$LayoutParams r11 = new android.view.ViewGroup$LayoutParams
            r12 = -1
            r11.<init>(r12, r12)
            if (r6 == r8) goto L_0x0191
            java.lang.Class<android.content.Context> r12 = android.content.Context.class
            r13 = 3
            if (r6 == r13) goto L_0x016b
            r13 = 4
            if (r6 == r13) goto L_0x0146
            android.view.SurfaceView r6 = new android.view.SurfaceView
            r6.<init>(r0)
            goto L_0x0196
        L_0x0146:
            java.lang.Class<b2.k> r6 = b2.k.class
            int r13 = b2.k.f2474i     // Catch:{ Exception -> 0x0162 }
            r13 = 1
            java.lang.Class[] r8 = new java.lang.Class[r13]     // Catch:{ Exception -> 0x0162 }
            r16 = 0
            r8[r16] = r12     // Catch:{ Exception -> 0x0162 }
            java.lang.reflect.Constructor r6 = r6.getConstructor(r8)     // Catch:{ Exception -> 0x0162 }
            java.lang.Object[] r8 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x0162 }
            r8[r16] = r0     // Catch:{ Exception -> 0x0162 }
            java.lang.Object r6 = r6.newInstance(r8)     // Catch:{ Exception -> 0x0162 }
            android.view.View r6 = (android.view.View) r6     // Catch:{ Exception -> 0x0162 }
            r1.f8080k = r6     // Catch:{ Exception -> 0x0162 }
            goto L_0x0198
        L_0x0162:
            r0 = move-exception
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "video_decoder_gl_surface_view requires an ExoPlayer dependency"
            r2.<init>(r3, r0)
            throw r2
        L_0x016b:
            java.lang.Class<c2.m> r6 = c2.m.class
            int r8 = c2.m.f2779s     // Catch:{ Exception -> 0x0188 }
            r8 = 1
            java.lang.Class[] r13 = new java.lang.Class[r8]     // Catch:{ Exception -> 0x0188 }
            r16 = 0
            r13[r16] = r12     // Catch:{ Exception -> 0x0188 }
            java.lang.reflect.Constructor r6 = r6.getConstructor(r13)     // Catch:{ Exception -> 0x0188 }
            java.lang.Object[] r12 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0188 }
            r12[r16] = r0     // Catch:{ Exception -> 0x0188 }
            java.lang.Object r6 = r6.newInstance(r12)     // Catch:{ Exception -> 0x0188 }
            android.view.View r6 = (android.view.View) r6     // Catch:{ Exception -> 0x0188 }
            r1.f8080k = r6     // Catch:{ Exception -> 0x0188 }
            r6 = 1
            goto L_0x0199
        L_0x0188:
            r0 = move-exception
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "spherical_gl_surface_view requires an ExoPlayer dependency"
            r2.<init>(r3, r0)
            throw r2
        L_0x0191:
            android.view.TextureView r6 = new android.view.TextureView
            r6.<init>(r0)
        L_0x0196:
            r1.f8080k = r6
        L_0x0198:
            r6 = 0
        L_0x0199:
            android.view.View r8 = r1.f8080k
            r8.setLayoutParams(r11)
            android.view.View r8 = r1.f8080k
            r8.setOnClickListener(r4)
            android.view.View r8 = r1.f8080k
            r11 = 0
            r8.setClickable(r11)
            android.view.View r8 = r1.f8080k
            r5.addView(r8, r11)
            goto L_0x01b4
        L_0x01af:
            r11 = 0
            r5 = 0
            r1.f8080k = r5
            r6 = 0
        L_0x01b4:
            r1.f8081l = r6
            r5 = 2131362049(0x7f0a0101, float:1.8343868E38)
            android.view.View r5 = r1.findViewById(r5)
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            r1.f8087r = r5
            r5 = 2131362075(0x7f0a011b, float:1.834392E38)
            android.view.View r5 = r1.findViewById(r5)
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            r1.f8088s = r5
            r5 = 2131362050(0x7f0a0102, float:1.834387E38)
            android.view.View r5 = r1.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r1.f8082m = r5
            if (r14 == 0) goto L_0x01dd
            if (r5 == 0) goto L_0x01dd
            r5 = 1
            goto L_0x01de
        L_0x01dd:
            r5 = 0
        L_0x01de:
            r1.f8092w = r5
            if (r15 == 0) goto L_0x01ee
            android.content.Context r5 = r20.getContext()
            java.lang.Object r6 = c0.g.f2717a
            android.graphics.drawable.Drawable r5 = c0.c.b(r5, r15)
            r1.f8093x = r5
        L_0x01ee:
            r5 = 2131362093(0x7f0a012d, float:1.8343957E38)
            android.view.View r5 = r1.findViewById(r5)
            androidx.media3.ui.SubtitleView r5 = (androidx.media3.ui.SubtitleView) r5
            r1.f8083n = r5
            if (r5 == 0) goto L_0x0201
            r5.a()
            r5.b()
        L_0x0201:
            r5 = 2131362054(0x7f0a0106, float:1.8343878E38)
            android.view.View r5 = r1.findViewById(r5)
            r1.f8084o = r5
            r6 = 8
            if (r5 == 0) goto L_0x0211
            r5.setVisibility(r6)
        L_0x0211:
            r1.f8094y = r9
            r5 = 2131362062(0x7f0a010e, float:1.8343894E38)
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r1.f8085p = r5
            if (r5 == 0) goto L_0x0223
            r5.setVisibility(r6)
        L_0x0223:
            r5 = 2131362058(0x7f0a010a, float:1.8343886E38)
            android.view.View r6 = r1.findViewById(r5)
            i3.w r6 = (i3.w) r6
            r8 = 2131362059(0x7f0a010b, float:1.8343888E38)
            android.view.View r8 = r1.findViewById(r8)
            if (r6 == 0) goto L_0x0238
            r1.f8086q = r6
            goto L_0x025f
        L_0x0238:
            if (r8 == 0) goto L_0x025c
            i3.w r6 = new i3.w
            r6.<init>(r0, r2)
            r1.f8086q = r6
            r6.setId(r5)
            android.view.ViewGroup$LayoutParams r0 = r8.getLayoutParams()
            r6.setLayoutParams(r0)
            android.view.ViewParent r0 = r8.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r2 = r0.indexOfChild(r8)
            r0.removeView(r8)
            r0.addView(r6, r2)
            goto L_0x025f
        L_0x025c:
            r0 = 0
            r1.f8086q = r0
        L_0x025f:
            i3.w r0 = r1.f8086q
            if (r0 == 0) goto L_0x0266
            r9 = r17
            goto L_0x0267
        L_0x0266:
            r9 = 0
        L_0x0267:
            r1.B = r9
            r1.E = r3
            r1.C = r7
            r1.D = r10
            if (r18 == 0) goto L_0x0275
            if (r0 == 0) goto L_0x0275
            r3 = 1
            goto L_0x0276
        L_0x0275:
            r3 = 0
        L_0x0276:
            r1.f8090u = r3
            if (r0 == 0) goto L_0x0292
            i3.c0 r0 = r0.f8186h
            int r2 = r0.f8063z
            r3 = 3
            if (r2 == r3) goto L_0x028b
            r3 = 2
            if (r2 != r3) goto L_0x0285
            goto L_0x028b
        L_0x0285:
            r0.g()
            r0.j(r3)
        L_0x028b:
            i3.w r0 = r1.f8086q
            java.util.concurrent.CopyOnWriteArrayList r0 = r0.f8192k
            r0.add(r4)
        L_0x0292:
            if (r18 == 0) goto L_0x0298
            r0 = 1
            r1.setClickable(r0)
        L_0x0298:
            r20.j()
        L_0x029b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.g0.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public static void a(TextureView textureView, int i10) {
        Matrix matrix = new Matrix();
        float width = (float) textureView.getWidth();
        float height = (float) textureView.getHeight();
        if (!(width == 0.0f || height == 0.0f || i10 == 0)) {
            float f10 = width / 2.0f;
            float f11 = height / 2.0f;
            matrix.postRotate((float) i10, f10, f11);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f10, f11);
        }
        textureView.setTransform(matrix);
    }

    public final boolean b() {
        k1 k1Var = this.f8089t;
        return k1Var != null && k1Var.L0(16) && this.f8089t.o() && this.f8089t.y();
    }

    public final void c(boolean z10) {
        if ((!b() || !this.D) && m()) {
            w wVar = this.f8086q;
            boolean z11 = wVar.i() && wVar.getShowTimeoutMs() <= 0;
            boolean e10 = e();
            if (z10 || z11 || e10) {
                f(e10);
            }
        }
    }

    public final boolean d(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float f10 = ((float) intrinsicWidth) / ((float) intrinsicHeight);
                AspectRatioFrameLayout aspectRatioFrameLayout = this.f8078i;
                if (aspectRatioFrameLayout != null) {
                    aspectRatioFrameLayout.setAspectRatio(f10);
                }
                ImageView imageView = this.f8082m;
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z10;
        boolean z11;
        k1 k1Var = this.f8089t;
        if (k1Var != null && k1Var.L0(16) && this.f8089t.o()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19 || keyCode == 270 || keyCode == 22 || keyCode == 271 || keyCode == 20 || keyCode == 269 || keyCode == 21 || keyCode == 268 || keyCode == 23) {
            z10 = true;
        } else {
            z10 = false;
        }
        w wVar = this.f8086q;
        if (!z10 || !m() || wVar.i()) {
            if (!m() || !wVar.d(keyEvent)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!z11 && !super.dispatchKeyEvent(keyEvent)) {
                if (!z10 || !m()) {
                    return false;
                }
                c(true);
                return false;
            }
        }
        c(true);
        return true;
    }

    public final boolean e() {
        k1 k1Var = this.f8089t;
        if (k1Var == null) {
            return true;
        }
        int b10 = k1Var.b();
        if (this.C && (!this.f8089t.L0(17) || !this.f8089t.j0().y())) {
            if (b10 == 1 || b10 == 4) {
                return true;
            }
            k1 k1Var2 = this.f8089t;
            k1Var2.getClass();
            if (!k1Var2.y()) {
                return true;
            }
        }
        return false;
    }

    public final void f(boolean z10) {
        int i10;
        if (m()) {
            if (z10) {
                i10 = 0;
            } else {
                i10 = this.B;
            }
            w wVar = this.f8086q;
            wVar.setShowTimeoutMs(i10);
            c0 c0Var = wVar.f8186h;
            w wVar2 = c0Var.f8038a;
            if (!wVar2.j()) {
                wVar2.setVisibility(0);
                wVar2.k();
                View view = wVar2.f8214v;
                if (view != null) {
                    view.requestFocus();
                }
            }
            c0Var.l();
        }
    }

    public final void g() {
        if (m() && this.f8089t != null) {
            w wVar = this.f8086q;
            if (!wVar.i()) {
                c(true);
            } else if (this.E) {
                wVar.h();
            }
        }
    }

    public List<d> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f8088s;
        if (frameLayout != null) {
            arrayList.add(new d((Object) frameLayout, 4, (Serializable) "Transparent overlay does not impact viewability"));
        }
        w wVar = this.f8086q;
        if (wVar != null) {
            arrayList.add(new d((Object) wVar, 1, (Serializable) null));
        }
        return r0.j(arrayList);
    }

    public ViewGroup getAdViewGroup() {
        FrameLayout frameLayout = this.f8087r;
        a.g(frameLayout, "exo_ad_overlay must be present for ad playback");
        return frameLayout;
    }

    public boolean getControllerAutoShow() {
        return this.C;
    }

    public boolean getControllerHideOnTouch() {
        return this.E;
    }

    public int getControllerShowTimeoutMs() {
        return this.B;
    }

    public Drawable getDefaultArtwork() {
        return this.f8093x;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.f8088s;
    }

    public k1 getPlayer() {
        return this.f8089t;
    }

    public int getResizeMode() {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f8078i;
        a.f(aspectRatioFrameLayout);
        return aspectRatioFrameLayout.getResizeMode();
    }

    public SubtitleView getSubtitleView() {
        return this.f8083n;
    }

    public boolean getUseArtwork() {
        return this.f8092w;
    }

    public boolean getUseController() {
        return this.f8090u;
    }

    public View getVideoSurfaceView() {
        return this.f8080k;
    }

    public final void h() {
        b2 b2Var;
        float f10;
        k1 k1Var = this.f8089t;
        if (k1Var != null) {
            b2Var = k1Var.N();
        } else {
            b2Var = b2.f6311l;
        }
        int i10 = b2Var.f6317h;
        float f11 = 0.0f;
        int i11 = b2Var.f6318i;
        if (i11 == 0 || i10 == 0) {
            f10 = 0.0f;
        } else {
            f10 = (((float) i10) * b2Var.f6320k) / ((float) i11);
        }
        View view = this.f8080k;
        if (view instanceof TextureView) {
            int i12 = b2Var.f6319j;
            if (f10 > 0.0f && (i12 == 90 || i12 == 270)) {
                f10 = 1.0f / f10;
            }
            int i13 = this.F;
            d0 d0Var = this.f8077h;
            if (i13 != 0) {
                view.removeOnLayoutChangeListener(d0Var);
            }
            this.F = i12;
            if (i12 != 0) {
                view.addOnLayoutChangeListener(d0Var);
            }
            a((TextureView) view, this.F);
        }
        if (!this.f8081l) {
            f11 = f10;
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f8078i;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r5.f8089t.y() == false) goto L_0x0020;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i() {
        /*
            r5 = this;
            android.view.View r0 = r5.f8084o
            if (r0 == 0) goto L_0x0029
            g1.k1 r1 = r5.f8089t
            r2 = 0
            if (r1 == 0) goto L_0x0020
            int r1 = r1.b()
            r3 = 2
            if (r1 != r3) goto L_0x0020
            int r1 = r5.f8094y
            r4 = 1
            if (r1 == r3) goto L_0x0021
            if (r1 != r4) goto L_0x0020
            g1.k1 r1 = r5.f8089t
            boolean r1 = r1.y()
            if (r1 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r4 = 0
        L_0x0021:
            if (r4 == 0) goto L_0x0024
            goto L_0x0026
        L_0x0024:
            r2 = 8
        L_0x0026:
            r0.setVisibility(r2)
        L_0x0029:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.g0.i():void");
    }

    public final void j() {
        int i10;
        Resources resources;
        String str = null;
        w wVar = this.f8086q;
        if (wVar != null && this.f8090u) {
            if (!wVar.i()) {
                resources = getResources();
                i10 = R.string.exo_controls_show;
            } else if (this.E) {
                resources = getResources();
                i10 = R.string.exo_controls_hide;
            }
            str = resources.getString(i10);
        }
        setContentDescription(str);
    }

    public final void k() {
        TextView textView = this.f8085p;
        if (textView != null) {
            CharSequence charSequence = this.A;
            if (charSequence != null) {
                textView.setText(charSequence);
                textView.setVisibility(0);
                return;
            }
            k1 k1Var = this.f8089t;
            if (k1Var != null) {
                d1 k10 = k1Var.k();
            }
            textView.setVisibility(8);
        }
    }

    public final void l(boolean z10) {
        boolean z11;
        byte[] bArr;
        k1 k1Var = this.f8089t;
        View view = this.f8079j;
        ImageView imageView = this.f8082m;
        boolean z12 = false;
        if (k1Var != null && k1Var.L0(30) && !k1Var.D().f6289h.isEmpty()) {
            if (z10 && !this.f8095z && view != null) {
                view.setVisibility(0);
            }
            if (!k1Var.D().i(2)) {
                if (view != null) {
                    view.setVisibility(0);
                }
                if (this.f8092w) {
                    a.f(imageView);
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    if (k1Var.L0(18) && (bArr = k1Var.C0().f6660q) != null) {
                        z12 = d(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
                    }
                    if (z12 || d(this.f8093x)) {
                        return;
                    }
                }
                if (imageView != null) {
                    imageView.setImageResource(17170445);
                    imageView.setVisibility(4);
                }
            } else if (imageView != null) {
                imageView.setImageResource(17170445);
                imageView.setVisibility(4);
            }
        } else if (!this.f8095z) {
            if (imageView != null) {
                imageView.setImageResource(17170445);
                imageView.setVisibility(4);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public final boolean m() {
        if (!this.f8090u) {
            return false;
        }
        a.f(this.f8086q);
        return true;
    }

    public final boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!m() || this.f8089t == null) {
            return false;
        }
        c(true);
        return true;
    }

    public final boolean performClick() {
        g();
        return super.performClick();
    }

    public void setAspectRatioListener(a aVar) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f8078i;
        a.f(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setAspectRatioListener(aVar);
    }

    public void setControllerAutoShow(boolean z10) {
        this.C = z10;
    }

    public void setControllerHideDuringAds(boolean z10) {
        this.D = z10;
    }

    public void setControllerHideOnTouch(boolean z10) {
        a.f(this.f8086q);
        this.E = z10;
        j();
    }

    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(l lVar) {
        w wVar = this.f8086q;
        a.f(wVar);
        wVar.setOnFullScreenModeChangedListener(lVar);
    }

    public void setControllerShowTimeoutMs(int i10) {
        w wVar = this.f8086q;
        a.f(wVar);
        this.B = i10;
        if (wVar.i()) {
            f(e());
        }
    }

    @Deprecated
    public void setControllerVisibilityListener(v vVar) {
        w wVar = this.f8086q;
        a.f(wVar);
        v vVar2 = this.f8091v;
        if (vVar2 != vVar) {
            CopyOnWriteArrayList copyOnWriteArrayList = wVar.f8192k;
            if (vVar2 != null) {
                copyOnWriteArrayList.remove(vVar2);
            }
            this.f8091v = vVar;
            if (vVar != null) {
                copyOnWriteArrayList.add(vVar);
                setControllerVisibilityListener((e0) null);
            }
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        a.e(this.f8085p != null);
        this.A = charSequence;
        k();
    }

    public void setDefaultArtwork(Drawable drawable) {
        if (this.f8093x != drawable) {
            this.f8093x = drawable;
            l(false);
        }
    }

    public void setErrorMessageProvider(v vVar) {
        if (vVar != null) {
            k();
        }
    }

    public void setFullscreenButtonClickListener(f0 f0Var) {
        w wVar = this.f8086q;
        a.f(wVar);
        wVar.setOnFullScreenModeChangedListener(this.f8077h);
    }

    public void setKeepContentOnPlayerReset(boolean z10) {
        if (this.f8095z != z10) {
            this.f8095z = z10;
            l(false);
        }
    }

    public void setPlayer(k1 k1Var) {
        boolean z10;
        boolean z11;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.e(z10);
        if (k1Var == null || k1Var.N0() == Looper.getMainLooper()) {
            z11 = true;
        } else {
            z11 = false;
        }
        a.b(z11);
        k1 k1Var2 = this.f8089t;
        if (k1Var2 != k1Var) {
            View view = this.f8080k;
            d0 d0Var = this.f8077h;
            if (k1Var2 != null) {
                k1Var2.z0(d0Var);
                if (k1Var2.L0(27)) {
                    if (view instanceof TextureView) {
                        k1Var2.M((TextureView) view);
                    } else if (view instanceof SurfaceView) {
                        k1Var2.c0((SurfaceView) view);
                    }
                }
            }
            SubtitleView subtitleView = this.f8083n;
            if (subtitleView != null) {
                subtitleView.setCues((List<b>) null);
            }
            this.f8089t = k1Var;
            boolean m10 = m();
            w wVar = this.f8086q;
            if (m10) {
                wVar.setPlayer(k1Var);
            }
            i();
            k();
            l(true);
            if (k1Var != null) {
                if (k1Var.L0(27)) {
                    if (view instanceof TextureView) {
                        k1Var.w0((TextureView) view);
                    } else if (view instanceof SurfaceView) {
                        k1Var.a0((SurfaceView) view);
                    }
                    h();
                }
                if (subtitleView != null && k1Var.L0(28)) {
                    subtitleView.setCues(k1Var.L().f7994h);
                }
                k1Var.x0(d0Var);
                c(false);
            } else if (wVar != null) {
                wVar.h();
            }
        }
    }

    public void setRepeatToggleModes(int i10) {
        w wVar = this.f8086q;
        a.f(wVar);
        wVar.setRepeatToggleModes(i10);
    }

    public void setResizeMode(int i10) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f8078i;
        a.f(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setResizeMode(i10);
    }

    public void setShowBuffering(int i10) {
        if (this.f8094y != i10) {
            this.f8094y = i10;
            i();
        }
    }

    public void setShowFastForwardButton(boolean z10) {
        w wVar = this.f8086q;
        a.f(wVar);
        wVar.setShowFastForwardButton(z10);
    }

    public void setShowMultiWindowTimeBar(boolean z10) {
        w wVar = this.f8086q;
        a.f(wVar);
        wVar.setShowMultiWindowTimeBar(z10);
    }

    public void setShowNextButton(boolean z10) {
        w wVar = this.f8086q;
        a.f(wVar);
        wVar.setShowNextButton(z10);
    }

    public void setShowPreviousButton(boolean z10) {
        w wVar = this.f8086q;
        a.f(wVar);
        wVar.setShowPreviousButton(z10);
    }

    public void setShowRewindButton(boolean z10) {
        w wVar = this.f8086q;
        a.f(wVar);
        wVar.setShowRewindButton(z10);
    }

    public void setShowShuffleButton(boolean z10) {
        w wVar = this.f8086q;
        a.f(wVar);
        wVar.setShowShuffleButton(z10);
    }

    public void setShowSubtitleButton(boolean z10) {
        w wVar = this.f8086q;
        a.f(wVar);
        wVar.setShowSubtitleButton(z10);
    }

    public void setShowVrButton(boolean z10) {
        w wVar = this.f8086q;
        a.f(wVar);
        wVar.setShowVrButton(z10);
    }

    public void setShutterBackgroundColor(int i10) {
        View view = this.f8079j;
        if (view != null) {
            view.setBackgroundColor(i10);
        }
    }

    public void setUseArtwork(boolean z10) {
        a.e(!z10 || this.f8082m != null);
        if (this.f8092w != z10) {
            this.f8092w = z10;
            l(false);
        }
    }

    public void setUseController(boolean z10) {
        k1 k1Var;
        boolean z11 = false;
        w wVar = this.f8086q;
        a.e(!z10 || wVar != null);
        if (z10 || hasOnClickListeners()) {
            z11 = true;
        }
        setClickable(z11);
        if (this.f8090u != z10) {
            this.f8090u = z10;
            if (m()) {
                k1Var = this.f8089t;
            } else {
                if (wVar != null) {
                    wVar.h();
                    k1Var = null;
                }
                j();
            }
            wVar.setPlayer(k1Var);
            j();
        }
    }

    public void setVisibility(int i10) {
        super.setVisibility(i10);
        View view = this.f8080k;
        if (view instanceof SurfaceView) {
            view.setVisibility(i10);
        }
    }

    public void setControllerVisibilityListener(e0 e0Var) {
        if (e0Var != null) {
            setControllerVisibilityListener((v) null);
        }
    }
}
