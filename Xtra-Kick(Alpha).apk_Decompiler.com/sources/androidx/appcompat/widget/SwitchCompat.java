package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.emoji2.text.p;
import com.woxthebox.draglistview.R;
import f0.b;
import f0.d;
import java.util.WeakHashMap;
import k.a;
import m0.c1;
import m0.e0;
import m0.l0;
import q0.a0;
import w0.l;

public class SwitchCompat extends CompoundButton {

    /* renamed from: b0  reason: collision with root package name */
    public static final n4 f668b0 = new n4(Float.class, "thumbPos", 0);

    /* renamed from: c0  reason: collision with root package name */
    public static final int[] f669c0 = {16842912};
    public int A;
    public final int B;
    public float C;
    public float D;
    public final VelocityTracker E = VelocityTracker.obtain();
    public final int F;
    public float G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public final TextPaint P;
    public ColorStateList Q;
    public StaticLayout R;
    public StaticLayout S;
    public a T;
    public ObjectAnimator U;
    public k0 V;
    public p4 W;

    /* renamed from: a0  reason: collision with root package name */
    public final Rect f670a0;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f671h;

    /* renamed from: i  reason: collision with root package name */
    public ColorStateList f672i = null;

    /* renamed from: j  reason: collision with root package name */
    public PorterDuff.Mode f673j = null;

    /* renamed from: k  reason: collision with root package name */
    public boolean f674k = false;

    /* renamed from: l  reason: collision with root package name */
    public boolean f675l = false;

    /* renamed from: m  reason: collision with root package name */
    public Drawable f676m;

    /* renamed from: n  reason: collision with root package name */
    public ColorStateList f677n = null;

    /* renamed from: o  reason: collision with root package name */
    public PorterDuff.Mode f678o = null;

    /* renamed from: p  reason: collision with root package name */
    public boolean f679p = false;

    /* renamed from: q  reason: collision with root package name */
    public boolean f680q = false;

    /* renamed from: r  reason: collision with root package name */
    public int f681r;

    /* renamed from: s  reason: collision with root package name */
    public int f682s;

    /* renamed from: t  reason: collision with root package name */
    public int f683t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f684u;

    /* renamed from: v  reason: collision with root package name */
    public CharSequence f685v;

    /* renamed from: w  reason: collision with root package name */
    public CharSequence f686w;

    /* renamed from: x  reason: collision with root package name */
    public CharSequence f687x;

    /* renamed from: y  reason: collision with root package name */
    public CharSequence f688y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f689z;

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x010d, code lost:
        r10 = c0.g.c(r13, (r10 = r8.getResourceId(3, 0)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SwitchCompat(android.content.Context r13, android.util.AttributeSet r14) {
        /*
            r12 = this;
            r0 = 2130969743(0x7f04048f, float:1.7548177E38)
            r12.<init>(r13, r14, r0)
            r1 = 0
            r12.f672i = r1
            r12.f673j = r1
            r2 = 0
            r12.f674k = r2
            r12.f675l = r2
            r12.f677n = r1
            r12.f678o = r1
            r12.f679p = r2
            r12.f680q = r2
            android.view.VelocityTracker r3 = android.view.VelocityTracker.obtain()
            r12.E = r3
            r3 = 1
            r12.O = r3
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
            r12.f670a0 = r4
            android.content.Context r4 = r12.getContext()
            androidx.appcompat.widget.q4.a(r4, r12)
            android.text.TextPaint r4 = new android.text.TextPaint
            r4.<init>(r3)
            r12.P = r4
            android.content.res.Resources r5 = r12.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            float r5 = r5.density
            r4.density = r5
            int[] r8 = f.a.f5414x
            androidx.appcompat.widget.u4 r5 = new androidx.appcompat.widget.u4
            android.content.res.TypedArray r10 = r13.obtainStyledAttributes(r14, r8, r0, r2)
            r5.<init>(r13, r10)
            r11 = 2130969743(0x7f04048f, float:1.7548177E38)
            r6 = r12
            r7 = r13
            r9 = r14
            m0.c1.o(r6, r7, r8, r9, r10, r11)
            r6 = 2
            android.graphics.drawable.Drawable r7 = r5.e(r6)
            r12.f671h = r7
            if (r7 == 0) goto L_0x0062
            r7.setCallback(r12)
        L_0x0062:
            r7 = 11
            android.graphics.drawable.Drawable r7 = r5.e(r7)
            r12.f676m = r7
            if (r7 == 0) goto L_0x006f
            r7.setCallback(r12)
        L_0x006f:
            java.lang.CharSequence r7 = r5.k(r2)
            r12.setTextOnInternal(r7)
            java.lang.CharSequence r7 = r5.k(r3)
            r12.setTextOffInternal(r7)
            r7 = 3
            boolean r8 = r5.a(r7, r3)
            r12.f689z = r8
            r8 = 8
            int r8 = r5.d(r8, r2)
            r12.f681r = r8
            r8 = 5
            int r8 = r5.d(r8, r2)
            r12.f682s = r8
            r8 = 6
            int r8 = r5.d(r8, r2)
            r12.f683t = r8
            r8 = 4
            boolean r8 = r5.a(r8, r2)
            r12.f684u = r8
            r8 = 9
            android.content.res.ColorStateList r8 = r5.b(r8)
            if (r8 == 0) goto L_0x00ad
            r12.f672i = r8
            r12.f674k = r3
        L_0x00ad:
            r8 = 10
            r9 = -1
            int r8 = r5.h(r8, r9)
            android.graphics.PorterDuff$Mode r8 = androidx.appcompat.widget.i2.d(r8, r1)
            android.graphics.PorterDuff$Mode r10 = r12.f673j
            if (r10 == r8) goto L_0x00c0
            r12.f673j = r8
            r12.f675l = r3
        L_0x00c0:
            boolean r8 = r12.f674k
            if (r8 != 0) goto L_0x00c8
            boolean r8 = r12.f675l
            if (r8 == 0) goto L_0x00cb
        L_0x00c8:
            r12.a()
        L_0x00cb:
            r8 = 12
            android.content.res.ColorStateList r8 = r5.b(r8)
            if (r8 == 0) goto L_0x00d7
            r12.f677n = r8
            r12.f679p = r3
        L_0x00d7:
            r8 = 13
            int r8 = r5.h(r8, r9)
            android.graphics.PorterDuff$Mode r8 = androidx.appcompat.widget.i2.d(r8, r1)
            android.graphics.PorterDuff$Mode r10 = r12.f678o
            if (r10 == r8) goto L_0x00e9
            r12.f678o = r8
            r12.f680q = r3
        L_0x00e9:
            boolean r8 = r12.f679p
            if (r8 != 0) goto L_0x00f1
            boolean r8 = r12.f680q
            if (r8 == 0) goto L_0x00f4
        L_0x00f1:
            r12.b()
        L_0x00f4:
            r8 = 7
            int r8 = r5.i(r8, r2)
            if (r8 == 0) goto L_0x01a5
            int[] r10 = f.a.f5415y
            android.content.res.TypedArray r8 = r13.obtainStyledAttributes(r8, r10)
            boolean r10 = r8.hasValue(r7)
            if (r10 == 0) goto L_0x0114
            int r10 = r8.getResourceId(r7, r2)
            if (r10 == 0) goto L_0x0114
            android.content.res.ColorStateList r10 = c0.g.c(r13, r10)
            if (r10 == 0) goto L_0x0114
            goto L_0x0118
        L_0x0114:
            android.content.res.ColorStateList r10 = r8.getColorStateList(r7)
        L_0x0118:
            if (r10 == 0) goto L_0x011b
            goto L_0x011f
        L_0x011b:
            android.content.res.ColorStateList r10 = r12.getTextColors()
        L_0x011f:
            r12.Q = r10
            int r10 = r8.getDimensionPixelSize(r2, r2)
            if (r10 == 0) goto L_0x0136
            float r10 = (float) r10
            float r11 = r4.getTextSize()
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 == 0) goto L_0x0136
            r4.setTextSize(r10)
            r12.requestLayout()
        L_0x0136:
            int r10 = r8.getInt(r3, r9)
            int r9 = r8.getInt(r6, r9)
            if (r10 == r3) goto L_0x014c
            if (r10 == r6) goto L_0x0149
            if (r10 == r7) goto L_0x0146
            r7 = r1
            goto L_0x014e
        L_0x0146:
            android.graphics.Typeface r7 = android.graphics.Typeface.MONOSPACE
            goto L_0x014e
        L_0x0149:
            android.graphics.Typeface r7 = android.graphics.Typeface.SERIF
            goto L_0x014e
        L_0x014c:
            android.graphics.Typeface r7 = android.graphics.Typeface.SANS_SERIF
        L_0x014e:
            r10 = 0
            if (r9 <= 0) goto L_0x017c
            if (r7 != 0) goto L_0x0158
            android.graphics.Typeface r7 = android.graphics.Typeface.defaultFromStyle(r9)
            goto L_0x015c
        L_0x0158:
            android.graphics.Typeface r7 = android.graphics.Typeface.create(r7, r9)
        L_0x015c:
            r12.setSwitchTypeface(r7)
            if (r7 == 0) goto L_0x0166
            int r7 = r7.getStyle()
            goto L_0x0167
        L_0x0166:
            r7 = 0
        L_0x0167:
            int r7 = ~r7
            r7 = r7 & r9
            r9 = r7 & 1
            if (r9 == 0) goto L_0x016e
            goto L_0x016f
        L_0x016e:
            r3 = 0
        L_0x016f:
            r4.setFakeBoldText(r3)
            r3 = r7 & 2
            if (r3 == 0) goto L_0x0178
            r10 = -1098907648(0xffffffffbe800000, float:-0.25)
        L_0x0178:
            r4.setTextSkewX(r10)
            goto L_0x0185
        L_0x017c:
            r4.setFakeBoldText(r2)
            r4.setTextSkewX(r10)
            r12.setSwitchTypeface(r7)
        L_0x0185:
            r3 = 14
            boolean r2 = r8.getBoolean(r3, r2)
            if (r2 == 0) goto L_0x0196
            k.a r1 = new k.a
            android.content.Context r2 = r12.getContext()
            r1.<init>(r2)
        L_0x0196:
            r12.T = r1
            java.lang.CharSequence r1 = r12.f685v
            r12.setTextOnInternal(r1)
            java.lang.CharSequence r1 = r12.f687x
            r12.setTextOffInternal(r1)
            r8.recycle()
        L_0x01a5:
            androidx.appcompat.widget.q1 r1 = new androidx.appcompat.widget.q1
            r1.<init>(r12)
            r1.f(r14, r0)
            r5.n()
            android.view.ViewConfiguration r13 = android.view.ViewConfiguration.get(r13)
            int r1 = r13.getScaledTouchSlop()
            r12.B = r1
            int r13 = r13.getScaledMinimumFlingVelocity()
            r12.F = r13
            androidx.appcompat.widget.k0 r13 = r12.getEmojiTextViewHelper()
            r13.b(r14, r0)
            r12.refreshDrawableState()
            boolean r13 = r12.isChecked()
            r12.setChecked(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private k0 getEmojiTextViewHelper() {
        if (this.V == null) {
            this.V = new k0(this);
        }
        return this.V;
    }

    private boolean getTargetCheckedState() {
        return this.G > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((l5.a(this) ? 1.0f - this.G : this.G) * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f676m;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f670a0;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f671h;
        Rect c10 = drawable2 != null ? i2.c(drawable2) : i2.f871c;
        return ((((this.H - this.J) - rect.left) - rect.right) - c10.left) - c10.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f687x = charSequence;
        k0 emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod e10 = ((l) emojiTextViewHelper.f904b.f4852i).e(this.T);
        if (e10 != null) {
            charSequence = e10.getTransformation(charSequence, this);
        }
        this.f688y = charSequence;
        this.S = null;
        if (this.f689z) {
            e();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f685v = charSequence;
        k0 emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod e10 = ((l) emojiTextViewHelper.f904b.f4852i).e(this.T);
        if (e10 != null) {
            charSequence = e10.getTransformation(charSequence, this);
        }
        this.f686w = charSequence;
        this.R = null;
        if (this.f689z) {
            e();
        }
    }

    public final void a() {
        Drawable drawable = this.f671h;
        if (drawable == null) {
            return;
        }
        if (this.f674k || this.f675l) {
            Drawable mutate = d.g(drawable).mutate();
            this.f671h = mutate;
            if (this.f674k) {
                b.h(mutate, this.f672i);
            }
            if (this.f675l) {
                b.i(this.f671h, this.f673j);
            }
            if (this.f671h.isStateful()) {
                this.f671h.setState(getDrawableState());
            }
        }
    }

    public final void b() {
        Drawable drawable = this.f676m;
        if (drawable == null) {
            return;
        }
        if (this.f679p || this.f680q) {
            Drawable mutate = d.g(drawable).mutate();
            this.f676m = mutate;
            if (this.f679p) {
                b.h(mutate, this.f677n);
            }
            if (this.f680q) {
                b.i(this.f676m, this.f678o);
            }
            if (this.f676m.isStateful()) {
                this.f676m.setState(getDrawableState());
            }
        }
    }

    public final StaticLayout c(CharSequence charSequence) {
        TextPaint textPaint = this.P;
        return new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil((double) Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public final void d() {
        setTextOnInternal(this.f685v);
        setTextOffInternal(this.f687x);
        requestLayout();
    }

    public final void draw(Canvas canvas) {
        Rect rect;
        int i10;
        int i11;
        int i12 = this.K;
        int i13 = this.L;
        int i14 = this.M;
        int i15 = this.N;
        int thumbOffset = getThumbOffset() + i12;
        Drawable drawable = this.f671h;
        if (drawable != null) {
            rect = i2.c(drawable);
        } else {
            rect = i2.f871c;
        }
        Drawable drawable2 = this.f676m;
        Rect rect2 = this.f670a0;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i16 = rect2.left;
            thumbOffset += i16;
            if (rect != null) {
                int i17 = rect.left;
                if (i17 > i16) {
                    i12 += i17 - i16;
                }
                int i18 = rect.top;
                int i19 = rect2.top;
                if (i18 > i19) {
                    i10 = (i18 - i19) + i13;
                } else {
                    i10 = i13;
                }
                int i20 = rect.right;
                int i21 = rect2.right;
                if (i20 > i21) {
                    i14 -= i20 - i21;
                }
                int i22 = rect.bottom;
                int i23 = rect2.bottom;
                if (i22 > i23) {
                    i11 = i15 - (i22 - i23);
                    this.f676m.setBounds(i12, i10, i14, i11);
                }
            } else {
                i10 = i13;
            }
            i11 = i15;
            this.f676m.setBounds(i12, i10, i14, i11);
        }
        Drawable drawable3 = this.f671h;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i24 = thumbOffset - rect2.left;
            int i25 = thumbOffset + this.J + rect2.right;
            this.f671h.setBounds(i24, i13, i25, i15);
            Drawable background = getBackground();
            if (background != null) {
                b.f(background, i24, i13, i25, i15);
            }
        }
        super.draw(canvas);
    }

    public final void drawableHotspotChanged(float f10, float f11) {
        super.drawableHotspotChanged(f10, f11);
        Drawable drawable = this.f671h;
        if (drawable != null) {
            b.e(drawable, f10, f11);
        }
        Drawable drawable2 = this.f676m;
        if (drawable2 != null) {
            b.e(drawable2, f10, f11);
        }
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f671h;
        boolean z10 = false;
        if (drawable != null && drawable.isStateful()) {
            z10 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f676m;
        if (drawable2 != null && drawable2.isStateful()) {
            z10 |= drawable2.setState(drawableState);
        }
        if (z10) {
            invalidate();
        }
    }

    public final void e() {
        boolean z10;
        if (this.W == null && ((l) this.V.f904b.f4852i).b()) {
            if (p.f1267j != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                p a10 = p.a();
                int b10 = a10.b();
                if (b10 == 3 || b10 == 0) {
                    p4 p4Var = new p4(this);
                    this.W = p4Var;
                    a10.g(p4Var);
                }
            }
        }
    }

    public int getCompoundPaddingLeft() {
        if (!l5.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.H;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f683t : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (l5.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.H;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f683t : compoundPaddingRight;
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return a0.e(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f689z;
    }

    public boolean getSplitTrack() {
        return this.f684u;
    }

    public int getSwitchMinWidth() {
        return this.f682s;
    }

    public int getSwitchPadding() {
        return this.f683t;
    }

    public CharSequence getTextOff() {
        return this.f687x;
    }

    public CharSequence getTextOn() {
        return this.f685v;
    }

    public Drawable getThumbDrawable() {
        return this.f671h;
    }

    public final float getThumbPosition() {
        return this.G;
    }

    public int getThumbTextPadding() {
        return this.f681r;
    }

    public ColorStateList getThumbTintList() {
        return this.f672i;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f673j;
    }

    public Drawable getTrackDrawable() {
        return this.f676m;
    }

    public ColorStateList getTrackTintList() {
        return this.f677n;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f678o;
    }

    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f671h;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f676m;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.U;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.U.end();
            this.U = null;
        }
    }

    public final int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f669c0);
        }
        return onCreateDrawableState;
    }

    public final void onDraw(Canvas canvas) {
        int i10;
        super.onDraw(canvas);
        Drawable drawable = this.f676m;
        Rect rect = this.f670a0;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i11 = this.L;
        int i12 = this.N;
        int i13 = i11 + rect.top;
        int i14 = i12 - rect.bottom;
        Drawable drawable2 = this.f671h;
        if (drawable != null) {
            if (!this.f684u || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect c10 = i2.c(drawable2);
                drawable2.copyBounds(rect);
                rect.left += c10.left;
                rect.right -= c10.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        StaticLayout staticLayout = getTargetCheckedState() ? this.R : this.S;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.Q;
            TextPaint textPaint = this.P;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                i10 = bounds.left + bounds.right;
            } else {
                i10 = getWidth();
            }
            canvas.translate((float) ((i10 / 2) - (staticLayout.getWidth() / 2)), (float) (((i13 + i14) / 2) - (staticLayout.getHeight() / 2)));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f685v : this.f687x;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(text);
                sb2.append(' ');
                sb2.append(charSequence);
                accessibilityNodeInfo.setText(sb2);
            }
        }
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        super.onLayout(z10, i10, i11, i12, i13);
        int i19 = 0;
        if (this.f671h != null) {
            Drawable drawable = this.f676m;
            Rect rect = this.f670a0;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect c10 = i2.c(this.f671h);
            i14 = Math.max(0, c10.left - rect.left);
            i19 = Math.max(0, c10.right - rect.right);
        } else {
            i14 = 0;
        }
        if (l5.a(this)) {
            i16 = getPaddingLeft() + i14;
            i15 = ((this.H + i16) - i14) - i19;
        } else {
            i15 = (getWidth() - getPaddingRight()) - i19;
            i16 = (i15 - this.H) + i14 + i19;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop = getPaddingTop();
            int i20 = this.I;
            int height = (((getHeight() + paddingTop) - getPaddingBottom()) / 2) - (i20 / 2);
            int i21 = height;
            i17 = i20 + height;
            i18 = i21;
        } else if (gravity != 80) {
            i18 = getPaddingTop();
            i17 = this.I + i18;
        } else {
            i17 = getHeight() - getPaddingBottom();
            i18 = i17 - this.I;
        }
        this.K = i16;
        this.L = i18;
        this.N = i17;
        this.M = i15;
    }

    public final void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        if (this.f689z) {
            if (this.R == null) {
                this.R = c(this.f686w);
            }
            if (this.S == null) {
                this.S = c(this.f688y);
            }
        }
        Drawable drawable = this.f671h;
        int i14 = 0;
        Rect rect = this.f670a0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i13 = (this.f671h.getIntrinsicWidth() - rect.left) - rect.right;
            i12 = this.f671h.getIntrinsicHeight();
        } else {
            i13 = 0;
            i12 = 0;
        }
        this.J = Math.max(this.f689z ? (this.f681r * 2) + Math.max(this.R.getWidth(), this.S.getWidth()) : 0, i13);
        Drawable drawable2 = this.f676m;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i14 = this.f676m.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i15 = rect.left;
        int i16 = rect.right;
        Drawable drawable3 = this.f671h;
        if (drawable3 != null) {
            Rect c10 = i2.c(drawable3);
            i15 = Math.max(i15, c10.left);
            i16 = Math.max(i16, c10.right);
        }
        int max = this.O ? Math.max(this.f682s, (this.J * 2) + i15 + i16) : this.f682s;
        int max2 = Math.max(i14, i12);
        this.H = max;
        this.I = max2;
        super.onMeasure(i10, i11);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f685v : this.f687x;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
        if (r1 != 3) goto L_0x0147;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r11) {
        /*
            r10 = this;
            android.view.VelocityTracker r0 = r10.E
            r0.addMovement(r11)
            int r1 = r11.getActionMasked()
            int r2 = r10.B
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x00f8
            r5 = 3
            r6 = 0
            r7 = 2
            if (r1 == r4) goto L_0x0091
            if (r1 == r7) goto L_0x001a
            if (r1 == r5) goto L_0x0091
            goto L_0x0147
        L_0x001a:
            int r0 = r10.A
            if (r0 == r4) goto L_0x0061
            if (r0 == r7) goto L_0x0022
            goto L_0x0147
        L_0x0022:
            float r11 = r11.getX()
            int r0 = r10.getThumbScrollRange()
            float r1 = r10.C
            float r1 = r11 - r1
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L_0x0035
            float r0 = (float) r0
            float r1 = r1 / r0
            goto L_0x0040
        L_0x0035:
            int r0 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x003c
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0040
        L_0x003c:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0040:
            boolean r0 = androidx.appcompat.widget.l5.a(r10)
            if (r0 == 0) goto L_0x0047
            float r1 = -r1
        L_0x0047:
            float r0 = r10.G
            float r1 = r1 + r0
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x004f
            goto L_0x0057
        L_0x004f:
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0056
            r6 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0057
        L_0x0056:
            r6 = r1
        L_0x0057:
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x0060
            r10.C = r11
            r10.setThumbPosition(r6)
        L_0x0060:
            return r4
        L_0x0061:
            float r0 = r11.getX()
            float r1 = r11.getY()
            float r3 = r10.C
            float r3 = r0 - r3
            float r3 = java.lang.Math.abs(r3)
            float r5 = (float) r2
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x0083
            float r3 = r10.D
            float r3 = r1 - r3
            float r3 = java.lang.Math.abs(r3)
            float r2 = (float) r2
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0147
        L_0x0083:
            r10.A = r7
            android.view.ViewParent r11 = r10.getParent()
            r11.requestDisallowInterceptTouchEvent(r4)
            r10.C = r0
            r10.D = r1
            return r4
        L_0x0091:
            int r1 = r10.A
            if (r1 != r7) goto L_0x00f2
            r10.A = r3
            int r1 = r11.getAction()
            if (r1 != r4) goto L_0x00a5
            boolean r1 = r10.isEnabled()
            if (r1 == 0) goto L_0x00a5
            r1 = 1
            goto L_0x00a6
        L_0x00a5:
            r1 = 0
        L_0x00a6:
            boolean r2 = r10.isChecked()
            if (r1 == 0) goto L_0x00d8
            r1 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r1)
            float r0 = r0.getXVelocity()
            float r1 = java.lang.Math.abs(r0)
            int r7 = r10.F
            float r7 = (float) r7
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x00d3
            boolean r1 = androidx.appcompat.widget.l5.a(r10)
            if (r1 == 0) goto L_0x00cb
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x00d1
            goto L_0x00cf
        L_0x00cb:
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x00d1
        L_0x00cf:
            r0 = 1
            goto L_0x00d9
        L_0x00d1:
            r0 = 0
            goto L_0x00d9
        L_0x00d3:
            boolean r0 = r10.getTargetCheckedState()
            goto L_0x00d9
        L_0x00d8:
            r0 = r2
        L_0x00d9:
            if (r0 == r2) goto L_0x00de
            r10.playSoundEffect(r3)
        L_0x00de:
            r10.setChecked(r0)
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r11)
            r0.setAction(r5)
            super.onTouchEvent(r0)
            r0.recycle()
            super.onTouchEvent(r11)
            return r4
        L_0x00f2:
            r10.A = r3
            r0.clear()
            goto L_0x0147
        L_0x00f8:
            float r0 = r11.getX()
            float r1 = r11.getY()
            boolean r5 = r10.isEnabled()
            if (r5 == 0) goto L_0x0147
            android.graphics.drawable.Drawable r5 = r10.f671h
            if (r5 != 0) goto L_0x010b
            goto L_0x013f
        L_0x010b:
            int r5 = r10.getThumbOffset()
            android.graphics.drawable.Drawable r6 = r10.f671h
            android.graphics.Rect r7 = r10.f670a0
            r6.getPadding(r7)
            int r6 = r10.L
            int r6 = r6 - r2
            int r8 = r10.K
            int r8 = r8 + r5
            int r8 = r8 - r2
            int r5 = r10.J
            int r5 = r5 + r8
            int r9 = r7.left
            int r5 = r5 + r9
            int r7 = r7.right
            int r5 = r5 + r7
            int r5 = r5 + r2
            int r7 = r10.N
            int r7 = r7 + r2
            float r2 = (float) r8
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x013f
            float r2 = (float) r5
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x013f
            float r2 = (float) r6
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x013f
            float r2 = (float) r7
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x013f
            r3 = 1
        L_0x013f:
            if (r3 == 0) goto L_0x0147
            r10.A = r4
            r10.C = r0
            r10.D = r1
        L_0x0147:
            boolean r11 = super.onTouchEvent(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().c(z10);
    }

    public void setChecked(boolean z10) {
        super.setChecked(z10);
        boolean isChecked = isChecked();
        if (isChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                Object obj = this.f685v;
                if (obj == null) {
                    obj = getResources().getString(R.string.abc_capital_on);
                }
                WeakHashMap weakHashMap = c1.f10054a;
                new e0(R.id.tag_state_description, 64, 30, 2).c(this, obj);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            Object obj2 = this.f687x;
            if (obj2 == null) {
                obj2 = getResources().getString(R.string.abc_capital_off);
            }
            WeakHashMap weakHashMap2 = c1.f10054a;
            new e0(R.id.tag_state_description, 64, 30, 2).c(this, obj2);
        }
        float f10 = 0.0f;
        if (getWindowToken() != null) {
            WeakHashMap weakHashMap3 = c1.f10054a;
            if (l0.c(this)) {
                if (isChecked) {
                    f10 = 1.0f;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f668b0, new float[]{f10});
                this.U = ofFloat;
                ofFloat.setDuration(250);
                o4.a(this.U, true);
                this.U.start();
                return;
            }
        }
        ObjectAnimator objectAnimator = this.U;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        if (isChecked) {
            f10 = 1.0f;
        }
        setThumbPosition(f10);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(a0.f(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().d(z10);
        setTextOnInternal(this.f685v);
        setTextOffInternal(this.f687x);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z10) {
        this.O = z10;
        invalidate();
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z10) {
        if (this.f689z != z10) {
            this.f689z = z10;
            requestLayout();
            if (z10) {
                e();
            }
        }
    }

    public void setSplitTrack(boolean z10) {
        this.f684u = z10;
        invalidate();
    }

    public void setSwitchMinWidth(int i10) {
        this.f682s = i10;
        requestLayout();
    }

    public void setSwitchPadding(int i10) {
        this.f683t = i10;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.P;
        if ((textPaint.getTypeface() != null && !textPaint.getTypeface().equals(typeface)) || (textPaint.getTypeface() == null && typeface != null)) {
            textPaint.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (!isChecked() && Build.VERSION.SDK_INT >= 30) {
            Object obj = this.f687x;
            if (obj == null) {
                obj = getResources().getString(R.string.abc_capital_off);
            }
            WeakHashMap weakHashMap = c1.f10054a;
            new e0(R.id.tag_state_description, 64, 30, 2).c(this, obj);
        }
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked() && Build.VERSION.SDK_INT >= 30) {
            Object obj = this.f685v;
            if (obj == null) {
                obj = getResources().getString(R.string.abc_capital_on);
            }
            WeakHashMap weakHashMap = c1.f10054a;
            new e0(R.id.tag_state_description, 64, 30, 2).c(this, obj);
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f671h;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f671h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f10) {
        this.G = f10;
        invalidate();
    }

    public void setThumbResource(int i10) {
        setThumbDrawable(h.a.a(getContext(), i10));
    }

    public void setThumbTextPadding(int i10) {
        this.f681r = i10;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f672i = colorStateList;
        this.f674k = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f673j = mode;
        this.f675l = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f676m;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f676m = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i10) {
        setTrackDrawable(h.a.a(getContext(), i10));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f677n = colorStateList;
        this.f679p = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f678o = mode;
        this.f680q = true;
        b();
    }

    public final void toggle() {
        setChecked(!isChecked());
    }

    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f671h || drawable == this.f676m;
    }
}
