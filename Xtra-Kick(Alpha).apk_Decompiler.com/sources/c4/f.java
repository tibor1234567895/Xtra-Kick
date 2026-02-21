package c4;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.d;
import f0.a;
import f0.b;
import java.util.ArrayList;
import l6.j;
import org.xmlpull.v1.XmlPullParser;

public final class f extends j implements Animatable {

    /* renamed from: n  reason: collision with root package name */
    public static final /* synthetic */ int f2884n = 0;

    /* renamed from: i  reason: collision with root package name */
    public final d f2885i;

    /* renamed from: j  reason: collision with root package name */
    public final Context f2886j;

    /* renamed from: k  reason: collision with root package name */
    public d f2887k;

    /* renamed from: l  reason: collision with root package name */
    public ArrayList f2888l;

    /* renamed from: m  reason: collision with root package name */
    public final j f2889m;

    public f() {
        this((Context) null);
    }

    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            b.a(drawable, theme);
        }
    }

    public final boolean canApplyTheme() {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            return b.b(drawable);
        }
        return false;
    }

    public final void draw(Canvas canvas) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        d dVar = this.f2885i;
        dVar.f2878a.draw(canvas);
        if (dVar.f2879b.isStarted()) {
            invalidateSelf();
        }
    }

    public final int getAlpha() {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            return a.a(drawable);
        }
        return this.f2885i.f2878a.getAlpha();
    }

    public final int getChangingConfigurations() {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f2885i.getClass();
        return changingConfigurations | 0;
    }

    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            return b.c(drawable);
        }
        return this.f2885i.f2878a.getColorFilter();
    }

    public final Drawable.ConstantState getConstantState() {
        if (this.f2892h == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new e(this.f2892h.getConstantState());
    }

    public final int getIntrinsicHeight() {
        Drawable drawable = this.f2892h;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f2885i.f2878a.getIntrinsicHeight();
    }

    public final int getIntrinsicWidth() {
        Drawable drawable = this.f2892h;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f2885i.f2878a.getIntrinsicWidth();
    }

    public final int getOpacity() {
        Drawable drawable = this.f2892h;
        return drawable != null ? drawable.getOpacity() : this.f2885i.f2878a.getOpacity();
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }

    public final boolean isAutoMirrored() {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            return a.d(drawable);
        }
        return this.f2885i.f2878a.isAutoMirrored();
    }

    public final boolean isRunning() {
        Drawable drawable = this.f2892h;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f2885i.f2879b.isRunning();
    }

    public final boolean isStateful() {
        Drawable drawable = this.f2892h;
        return drawable != null ? drawable.isStateful() : this.f2885i.f2878a.isStateful();
    }

    public final Drawable mutate() {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f2885i.f2878a.setBounds(rect);
        }
    }

    public final boolean onLevelChange(int i10) {
        Drawable drawable = this.f2892h;
        return drawable != null ? drawable.setLevel(i10) : this.f2885i.f2878a.setLevel(i10);
    }

    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f2892h;
        return drawable != null ? drawable.setState(iArr) : this.f2885i.f2878a.setState(iArr);
    }

    public final void setAlpha(int i10) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else {
            this.f2885i.f2878a.setAlpha(i10);
        }
    }

    public final void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            a.e(drawable, z10);
        } else {
            this.f2885i.f2878a.setAutoMirrored(z10);
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f2885i.f2878a.setColorFilter(colorFilter);
        }
    }

    public final void setTint(int i10) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            f0.d.d(drawable, i10);
        } else {
            this.f2885i.f2878a.setTint(i10);
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            f0.d.e(drawable, colorStateList);
        } else {
            this.f2885i.f2878a.setTintList(colorStateList);
        }
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            f0.d.f(drawable, mode);
        } else {
            this.f2885i.f2878a.setTintMode(mode);
        }
    }

    public final boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        this.f2885i.f2878a.setVisible(z10, z11);
        return super.setVisible(z10, z11);
    }

    public final void start() {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        d dVar = this.f2885i;
        if (!dVar.f2879b.isStarted()) {
            dVar.f2879b.start();
            invalidateSelf();
        }
    }

    public final void stop() {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f2885i.f2879b.end();
        }
    }

    public f(Context context) {
        this.f2887k = null;
        this.f2888l = null;
        j jVar = new j(2, this);
        this.f2889m = jVar;
        this.f2886j = context;
        this.f2885i = new d(jVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007c A[Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0089 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void inflate(android.content.res.Resources r22, org.xmlpull.v1.XmlPullParser r23, android.util.AttributeSet r24, android.content.res.Resources.Theme r25) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r3 = r24
            r4 = r25
            android.graphics.drawable.Drawable r0 = r1.f2892h
            if (r0 == 0) goto L_0x0012
            r5 = r23
            f0.b.d(r0, r2, r5, r3, r4)
            return
        L_0x0012:
            r5 = r23
            int r0 = r23.getEventType()
            int r6 = r23.getDepth()
            r7 = 1
            int r6 = r6 + r7
        L_0x001e:
            c4.d r8 = r1.f2885i
            if (r0 == r7) goto L_0x017a
            int r9 = r23.getDepth()
            if (r9 >= r6) goto L_0x002b
            r9 = 3
            if (r0 == r9) goto L_0x017a
        L_0x002b:
            r9 = 2
            if (r0 != r9) goto L_0x0174
            java.lang.String r0 = r23.getName()
            java.lang.String r10 = "animated-vector"
            boolean r10 = r10.equals(r0)
            r11 = 0
            r12 = 24
            r13 = 0
            if (r10 == 0) goto L_0x00ae
            int[] r0 = c4.a.f2869e
            android.content.res.TypedArray r10 = d0.t.h(r2, r4, r3, r0)
            int r0 = r10.getResourceId(r13, r13)
            if (r0 == 0) goto L_0x00a9
            android.graphics.PorterDuff$Mode r14 = c4.s.f2949q
            int r14 = android.os.Build.VERSION.SDK_INT
            if (r14 < r12) goto L_0x0069
            c4.s r9 = new c4.s
            r9.<init>()
            java.lang.ThreadLocal r12 = d0.s.f4115a
            android.graphics.drawable.Drawable r0 = d0.k.a(r2, r0, r4)
            r9.f2892h = r0
            c4.r r0 = new c4.r
            android.graphics.drawable.Drawable r12 = r9.f2892h
            android.graphics.drawable.Drawable$ConstantState r12 = r12.getConstantState()
            r0.<init>(r12)
            goto L_0x0099
        L_0x0069:
            android.content.res.XmlResourceParser r0 = r2.getXml(r0)     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0085 }
            android.util.AttributeSet r12 = android.util.Xml.asAttributeSet(r0)     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0085 }
        L_0x0071:
            int r14 = r0.next()     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0085 }
            if (r14 == r9) goto L_0x007a
            if (r14 == r7) goto L_0x007a
            goto L_0x0071
        L_0x007a:
            if (r14 != r9) goto L_0x0089
            c4.s r9 = new c4.s     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0085 }
            r9.<init>()     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0085 }
            r9.inflate(r2, r0, r12, r4)     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0085 }
            goto L_0x0099
        L_0x0085:
            r0 = move-exception
            goto L_0x0091
        L_0x0087:
            r0 = move-exception
            goto L_0x0091
        L_0x0089:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0085 }
            java.lang.String r9 = "No start tag found"
            r0.<init>(r9)     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0085 }
            throw r0     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0085 }
        L_0x0091:
            java.lang.String r9 = "VectorDrawableCompat"
            java.lang.String r12 = "parser error"
            android.util.Log.e(r9, r12, r0)
            r9 = r11
        L_0x0099:
            r9.f2954m = r13
            l6.j r0 = r1.f2889m
            r9.setCallback(r0)
            c4.s r0 = r8.f2878a
            if (r0 == 0) goto L_0x00a7
            r0.setCallback(r11)
        L_0x00a7:
            r8.f2878a = r9
        L_0x00a9:
            r10.recycle()
            goto L_0x0174
        L_0x00ae:
            java.lang.String r9 = "target"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0174
            int[] r0 = c4.a.f2870f
            android.content.res.TypedArray r0 = r2.obtainAttributes(r3, r0)
            java.lang.String r9 = r0.getString(r13)
            int r10 = r0.getResourceId(r7, r13)
            if (r10 == 0) goto L_0x0171
            android.content.Context r13 = r1.f2886j
            if (r13 == 0) goto L_0x0166
            int r14 = android.os.Build.VERSION.SDK_INT
            if (r14 < r12) goto L_0x00d3
            android.animation.Animator r10 = android.animation.AnimatorInflater.loadAnimator(r13, r10)
            goto L_0x00f2
        L_0x00d3:
            android.content.res.Resources r14 = r13.getResources()
            android.content.res.Resources$Theme r15 = r13.getTheme()
            java.lang.String r12 = "Can't load animation resource ID #0x"
            android.content.res.XmlResourceParser r20 = r14.getAnimation(r10)     // Catch:{ XmlPullParserException -> 0x0146, IOException -> 0x012c }
            android.util.AttributeSet r17 = android.util.Xml.asAttributeSet(r20)     // Catch:{ XmlPullParserException -> 0x0126, IOException -> 0x0122, all -> 0x011e }
            r18 = 0
            r19 = 0
            r16 = r20
            android.animation.Animator r10 = c4.h.a(r13, r14, r15, r16, r17, r18, r19)     // Catch:{ XmlPullParserException -> 0x0126, IOException -> 0x0122, all -> 0x011e }
            r20.close()
        L_0x00f2:
            c4.s r12 = r8.f2878a
            c4.q r12 = r12.f2950i
            c4.p r12 = r12.f2937b
            q.e r12 = r12.f2935o
            java.lang.Object r11 = r12.getOrDefault(r9, r11)
            r10.setTarget(r11)
            java.util.ArrayList r11 = r8.f2880c
            if (r11 != 0) goto L_0x0113
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r8.f2880c = r11
            q.e r11 = new q.e
            r11.<init>()
            r8.f2881d = r11
        L_0x0113:
            java.util.ArrayList r11 = r8.f2880c
            r11.add(r10)
            q.e r8 = r8.f2881d
            r8.put(r10, r9)
            goto L_0x0171
        L_0x011e:
            r0 = move-exception
            r11 = r20
            goto L_0x0160
        L_0x0122:
            r0 = move-exception
            r11 = r20
            goto L_0x012d
        L_0x0126:
            r0 = move-exception
            r11 = r20
            goto L_0x0147
        L_0x012a:
            r0 = move-exception
            goto L_0x0160
        L_0x012c:
            r0 = move-exception
        L_0x012d:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException     // Catch:{ all -> 0x012a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
            r3.<init>(r12)     // Catch:{ all -> 0x012a }
            java.lang.String r4 = java.lang.Integer.toHexString(r10)     // Catch:{ all -> 0x012a }
            r3.append(r4)     // Catch:{ all -> 0x012a }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x012a }
            r2.<init>(r3)     // Catch:{ all -> 0x012a }
            r2.initCause(r0)     // Catch:{ all -> 0x012a }
            throw r2     // Catch:{ all -> 0x012a }
        L_0x0146:
            r0 = move-exception
        L_0x0147:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException     // Catch:{ all -> 0x012a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
            r3.<init>(r12)     // Catch:{ all -> 0x012a }
            java.lang.String r4 = java.lang.Integer.toHexString(r10)     // Catch:{ all -> 0x012a }
            r3.append(r4)     // Catch:{ all -> 0x012a }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x012a }
            r2.<init>(r3)     // Catch:{ all -> 0x012a }
            r2.initCause(r0)     // Catch:{ all -> 0x012a }
            throw r2     // Catch:{ all -> 0x012a }
        L_0x0160:
            if (r11 == 0) goto L_0x0165
            r11.close()
        L_0x0165:
            throw r0
        L_0x0166:
            r0.recycle()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "Context can't be null when inflating animators"
            r0.<init>(r2)
            throw r0
        L_0x0171:
            r0.recycle()
        L_0x0174:
            int r0 = r23.next()
            goto L_0x001e
        L_0x017a:
            android.animation.AnimatorSet r0 = r8.f2879b
            if (r0 != 0) goto L_0x0185
            android.animation.AnimatorSet r0 = new android.animation.AnimatorSet
            r0.<init>()
            r8.f2879b = r0
        L_0x0185:
            android.animation.AnimatorSet r0 = r8.f2879b
            java.util.ArrayList r2 = r8.f2880c
            r0.playTogether(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.f.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }
}
