package e8;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.media.h;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.appcompat.widget.d0;
import c4.f;
import com.woxthebox.draglistview.R;
import g8.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import m8.w;
import q0.b;

public final class d extends d0 {
    public static final int[] F = {R.attr.state_indeterminate};
    public static final int[] G = {R.attr.state_error};
    public static final int[][] H = {new int[]{16842910, R.attr.state_error}, new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    public static final int I = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    public boolean A;
    public CharSequence B;
    public CompoundButton.OnCheckedChangeListener C;
    public final f D;
    public final a E;

    /* renamed from: l  reason: collision with root package name */
    public final LinkedHashSet f5315l = new LinkedHashSet();

    /* renamed from: m  reason: collision with root package name */
    public final LinkedHashSet f5316m = new LinkedHashSet();

    /* renamed from: n  reason: collision with root package name */
    public ColorStateList f5317n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f5318o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f5319p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f5320q;

    /* renamed from: r  reason: collision with root package name */
    public CharSequence f5321r;

    /* renamed from: s  reason: collision with root package name */
    public Drawable f5322s;

    /* renamed from: t  reason: collision with root package name */
    public Drawable f5323t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f5324u;

    /* renamed from: v  reason: collision with root package name */
    public ColorStateList f5325v;

    /* renamed from: w  reason: collision with root package name */
    public ColorStateList f5326w;

    /* renamed from: x  reason: collision with root package name */
    public PorterDuff.Mode f5327x;

    /* renamed from: y  reason: collision with root package name */
    public int f5328y;

    /* renamed from: z  reason: collision with root package name */
    public int[] f5329z;

    /* JADX WARNING: Removed duplicated region for block: B:11:0x006a A[Catch:{ XmlPullParserException -> 0x007e, IOException -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0080 A[Catch:{ XmlPullParserException -> 0x007e, IOException -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00dc A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0139  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(android.content.Context r12, android.util.AttributeSet r13) {
        /*
            r11 = this;
            r0 = 2130968769(0x7f0400c1, float:1.75462E38)
            r1 = 2132018312(0x7f140488, float:1.9674927E38)
            android.content.Context r12 = a9.a.a(r12, r13, r0, r1)
            r11.<init>(r12, r13, r0)
            java.util.LinkedHashSet r12 = new java.util.LinkedHashSet
            r12.<init>()
            r11.f5315l = r12
            java.util.LinkedHashSet r12 = new java.util.LinkedHashSet
            r12.<init>()
            r11.f5316m = r12
            android.content.Context r12 = r11.getContext()
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            r2 = 24
            r3 = 2
            r4 = 0
            r5 = 2131231035(0x7f08013b, float:1.807814E38)
            if (r0 < r2) goto L_0x0051
            c4.f r0 = new c4.f
            r0.<init>(r12)
            android.content.res.Resources r2 = r12.getResources()
            android.content.res.Resources$Theme r12 = r12.getTheme()
            java.lang.ThreadLocal r6 = d0.s.f4115a
            android.graphics.drawable.Drawable r12 = d0.k.a(r2, r5, r12)
            r0.f2892h = r12
            l6.j r2 = r0.f2889m
            r12.setCallback(r2)
            c4.e r12 = new c4.e
            android.graphics.drawable.Drawable r2 = r0.f2892h
            android.graphics.drawable.Drawable$ConstantState r2 = r2.getConstantState()
            r12.<init>((android.graphics.drawable.Drawable.ConstantState) r2)
            goto L_0x0090
        L_0x0051:
            int r0 = c4.f.f2884n
            android.content.res.Resources r0 = r12.getResources()
            android.content.res.XmlResourceParser r0 = r0.getXml(r5)     // Catch:{ XmlPullParserException -> 0x007e, IOException -> 0x007c }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r0)     // Catch:{ XmlPullParserException -> 0x007e, IOException -> 0x007c }
        L_0x005f:
            int r5 = r0.next()     // Catch:{ XmlPullParserException -> 0x007e, IOException -> 0x007c }
            if (r5 == r3) goto L_0x0068
            if (r5 == r1) goto L_0x0068
            goto L_0x005f
        L_0x0068:
            if (r5 != r3) goto L_0x0080
            android.content.res.Resources r5 = r12.getResources()     // Catch:{ XmlPullParserException -> 0x007e, IOException -> 0x007c }
            android.content.res.Resources$Theme r6 = r12.getTheme()     // Catch:{ XmlPullParserException -> 0x007e, IOException -> 0x007c }
            c4.f r7 = new c4.f     // Catch:{ XmlPullParserException -> 0x007e, IOException -> 0x007c }
            r7.<init>(r12)     // Catch:{ XmlPullParserException -> 0x007e, IOException -> 0x007c }
            r7.inflate(r5, r0, r2, r6)     // Catch:{ XmlPullParserException -> 0x007e, IOException -> 0x007c }
            r0 = r7
            goto L_0x0090
        L_0x007c:
            r12 = move-exception
            goto L_0x0088
        L_0x007e:
            r12 = move-exception
            goto L_0x0088
        L_0x0080:
            org.xmlpull.v1.XmlPullParserException r12 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x007e, IOException -> 0x007c }
            java.lang.String r0 = "No start tag found"
            r12.<init>(r0)     // Catch:{ XmlPullParserException -> 0x007e, IOException -> 0x007c }
            throw r12     // Catch:{ XmlPullParserException -> 0x007e, IOException -> 0x007c }
        L_0x0088:
            java.lang.String r0 = "AnimatedVDCompat"
            java.lang.String r2 = "parser error"
            android.util.Log.e(r0, r2, r12)
            r0 = r4
        L_0x0090:
            r11.D = r0
            e8.a r12 = new e8.a
            r12.<init>(r11)
            r11.E = r12
            android.content.Context r12 = r11.getContext()
            android.graphics.drawable.Drawable r0 = q0.d.a(r11)
            r11.f5322s = r0
            android.content.res.ColorStateList r0 = r11.getSuperButtonTintList()
            r11.f5325v = r0
            r11.setSupportButtonTintList(r4)
            int[] r7 = v7.a.f15951t
            r9 = 2132018312(0x7f140488, float:1.9674927E38)
            r0 = 0
            int[] r10 = new int[r0]
            r8 = 2130968769(0x7f0400c1, float:1.75462E38)
            r5 = r12
            r6 = r13
            androidx.appcompat.widget.u4 r13 = m8.r.e(r5, r6, r7, r8, r9, r10)
            android.graphics.drawable.Drawable r2 = r13.e(r3)
            r11.f5323t = r2
            android.graphics.drawable.Drawable r2 = r11.f5322s
            if (r2 == 0) goto L_0x00fe
            r2 = 2130969201(0x7f040271, float:1.7547077E38)
            boolean r2 = q8.c.b(r12, r2, r0)
            if (r2 == 0) goto L_0x00fe
            int r2 = r13.i(r0, r0)
            int r3 = r13.i(r1, r0)
            int r5 = I
            if (r2 != r5) goto L_0x00e0
            if (r3 != 0) goto L_0x00e0
            r2 = 1
            goto L_0x00e1
        L_0x00e0:
            r2 = 0
        L_0x00e1:
            if (r2 == 0) goto L_0x00fe
            super.setButtonDrawable((android.graphics.drawable.Drawable) r4)
            r2 = 2131231034(0x7f08013a, float:1.8078138E38)
            android.graphics.drawable.Drawable r2 = h.a.a(r12, r2)
            r11.f5322s = r2
            r11.f5324u = r1
            android.graphics.drawable.Drawable r2 = r11.f5323t
            if (r2 != 0) goto L_0x00fe
            r2 = 2131231036(0x7f08013c, float:1.8078142E38)
            android.graphics.drawable.Drawable r2 = h.a.a(r12, r2)
            r11.f5323t = r2
        L_0x00fe:
            r2 = 3
            android.content.res.ColorStateList r12 = q8.d.b(r12, r13, r2)
            r11.f5326w = r12
            r12 = 4
            r2 = -1
            int r12 = r13.h(r12, r2)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r12 = m8.w.d(r12, r2)
            r11.f5327x = r12
            r12 = 10
            boolean r12 = r13.a(r12, r0)
            r11.f5318o = r12
            r12 = 6
            boolean r12 = r13.a(r12, r1)
            r11.f5319p = r12
            r12 = 9
            boolean r12 = r13.a(r12, r0)
            r11.f5320q = r12
            r12 = 8
            java.lang.CharSequence r12 = r13.k(r12)
            r11.f5321r = r12
            r12 = 7
            boolean r1 = r13.l(r12)
            if (r1 == 0) goto L_0x0140
            int r12 = r13.h(r12, r0)
            r11.setCheckedState(r12)
        L_0x0140:
            r13.n()
            r11.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e8.d.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private String getButtonStateDescription() {
        Resources resources;
        int i10;
        int i11 = this.f5328y;
        if (i11 == 1) {
            resources = getResources();
            i10 = R.string.mtrl_checkbox_state_description_checked;
        } else if (i11 == 0) {
            resources = getResources();
            i10 = R.string.mtrl_checkbox_state_description_unchecked;
        } else {
            resources = getResources();
            i10 = R.string.mtrl_checkbox_state_description_indeterminate;
        }
        return resources.getString(i10);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f5317n == null) {
            int b10 = a.b(this, R.attr.colorControlActivated);
            int b11 = a.b(this, R.attr.colorError);
            int b12 = a.b(this, R.attr.colorSurface);
            int b13 = a.b(this, R.attr.colorOnSurface);
            this.f5317n = new ColorStateList(H, new int[]{a.d(b12, 1.0f, b11), a.d(b12, 1.0f, b10), a.d(b12, 0.54f, b13), a.d(b12, 0.38f, b13), a.d(b12, 0.38f, b13)});
        }
        return this.f5317n;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f5325v;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void a() {
        int i10;
        int i11;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        androidx.appcompat.widget.d dVar;
        this.f5322s = i8.a.a(this.f5322s, this.f5325v, b.b(this));
        this.f5323t = i8.a.a(this.f5323t, this.f5326w, this.f5327x);
        if (this.f5324u) {
            f fVar = this.D;
            if (fVar != null) {
                Drawable drawable = fVar.f2892h;
                a aVar = this.E;
                if (drawable != null) {
                    AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
                    if (aVar.f2877a == null) {
                        aVar.f2877a = new c4.b(aVar);
                    }
                    boolean unused = animatedVectorDrawable.unregisterAnimationCallback(aVar.f2877a);
                }
                ArrayList arrayList = fVar.f2888l;
                c4.d dVar2 = fVar.f2885i;
                if (!(arrayList == null || aVar == null)) {
                    arrayList.remove(aVar);
                    if (fVar.f2888l.size() == 0 && (dVar = fVar.f2887k) != null) {
                        dVar2.f2879b.removeListener(dVar);
                        fVar.f2887k = null;
                    }
                }
                Drawable drawable2 = fVar.f2892h;
                if (drawable2 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) drawable2;
                    if (aVar.f2877a == null) {
                        aVar.f2877a = new c4.b(aVar);
                    }
                    animatedVectorDrawable2.registerAnimationCallback(aVar.f2877a);
                } else if (aVar != null) {
                    if (fVar.f2888l == null) {
                        fVar.f2888l = new ArrayList();
                    }
                    if (!fVar.f2888l.contains(aVar)) {
                        fVar.f2888l.add(aVar);
                        if (fVar.f2887k == null) {
                            fVar.f2887k = new androidx.appcompat.widget.d(2, fVar);
                        }
                        dVar2.f2879b.addListener(fVar.f2887k);
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Drawable drawable3 = this.f5322s;
                if ((drawable3 instanceof AnimatedStateListDrawable) && fVar != null) {
                    ((AnimatedStateListDrawable) drawable3).addTransition(R.id.checked, R.id.unchecked, fVar, false);
                    ((AnimatedStateListDrawable) this.f5322s).addTransition(R.id.indeterminate, R.id.unchecked, fVar, false);
                }
            }
        }
        Drawable drawable4 = this.f5322s;
        if (!(drawable4 == null || (colorStateList2 = this.f5325v) == null)) {
            f0.b.h(drawable4, colorStateList2);
        }
        Drawable drawable5 = this.f5323t;
        if (!(drawable5 == null || (colorStateList = this.f5326w) == null)) {
            f0.b.h(drawable5, colorStateList);
        }
        Drawable drawable6 = this.f5322s;
        Drawable drawable7 = this.f5323t;
        if (drawable6 == null) {
            drawable6 = drawable7;
        } else if (drawable7 != null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable6, drawable7});
            if (drawable7.getIntrinsicWidth() == -1 || drawable7.getIntrinsicHeight() == -1) {
                i11 = drawable6.getIntrinsicWidth();
                i10 = drawable6.getIntrinsicHeight();
            } else if (drawable7.getIntrinsicWidth() > drawable6.getIntrinsicWidth() || drawable7.getIntrinsicHeight() > drawable6.getIntrinsicHeight()) {
                float intrinsicWidth = ((float) drawable7.getIntrinsicWidth()) / ((float) drawable7.getIntrinsicHeight());
                if (intrinsicWidth >= ((float) drawable6.getIntrinsicWidth()) / ((float) drawable6.getIntrinsicHeight())) {
                    int intrinsicWidth2 = drawable6.getIntrinsicWidth();
                    int i12 = intrinsicWidth2;
                    i10 = (int) (((float) intrinsicWidth2) / intrinsicWidth);
                    i11 = i12;
                } else {
                    i10 = drawable6.getIntrinsicHeight();
                    i11 = (int) (intrinsicWidth * ((float) i10));
                }
            } else {
                i11 = drawable7.getIntrinsicWidth();
                i10 = drawable7.getIntrinsicHeight();
            }
            if (Build.VERSION.SDK_INT >= 23) {
                layerDrawable.setLayerSize(1, i11, i10);
                layerDrawable.setLayerGravity(1, 17);
            } else {
                int intrinsicWidth3 = (drawable6.getIntrinsicWidth() - i11) / 2;
                int intrinsicHeight = (drawable6.getIntrinsicHeight() - i10) / 2;
                layerDrawable.setLayerInset(1, intrinsicWidth3, intrinsicHeight, intrinsicWidth3, intrinsicHeight);
            }
            drawable6 = layerDrawable;
        }
        super.setButtonDrawable(drawable6);
        refreshDrawableState();
    }

    public Drawable getButtonDrawable() {
        return this.f5322s;
    }

    public Drawable getButtonIconDrawable() {
        return this.f5323t;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f5326w;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f5327x;
    }

    public ColorStateList getButtonTintList() {
        return this.f5325v;
    }

    public int getCheckedState() {
        return this.f5328y;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f5321r;
    }

    public final boolean isChecked() {
        return this.f5328y == 1;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5318o && this.f5325v == null && this.f5326w == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public final int[] onCreateDrawableState(int i10) {
        int[] copyOf;
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(onCreateDrawableState, F);
        }
        if (this.f5320q) {
            View.mergeDrawableStates(onCreateDrawableState, G);
        }
        int i11 = 0;
        while (true) {
            if (i11 >= onCreateDrawableState.length) {
                copyOf = Arrays.copyOf(onCreateDrawableState, onCreateDrawableState.length + 1);
                copyOf[onCreateDrawableState.length] = 16842912;
                break;
            }
            int i12 = onCreateDrawableState[i11];
            if (i12 == 16842912) {
                copyOf = onCreateDrawableState;
                break;
            } else if (i12 == 0) {
                copyOf = (int[]) onCreateDrawableState.clone();
                copyOf[i11] = 16842912;
                break;
            } else {
                i11++;
            }
        }
        this.f5329z = copyOf;
        return onCreateDrawableState;
    }

    public final void onDraw(Canvas canvas) {
        Drawable a10;
        int i10;
        if (!this.f5319p || !TextUtils.isEmpty(getText()) || (a10 = q0.d.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        if (w.c(this)) {
            i10 = -1;
        } else {
            i10 = 1;
        }
        int width = ((getWidth() - a10.getIntrinsicWidth()) / 2) * i10;
        int save = canvas.save();
        canvas.translate((float) width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
        if (getBackground() != null) {
            Rect bounds = a10.getBounds();
            f0.b.f(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && this.f5320q) {
            accessibilityNodeInfo.setText(accessibilityNodeInfo.getText() + ", " + this.f5321r);
        }
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        setCheckedState(cVar.f5314h);
    }

    public final Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f5314h = getCheckedState();
        return cVar;
    }

    public void setButtonDrawable(int i10) {
        setButtonDrawable(h.a.a(getContext(), i10));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.f5323t = drawable;
        a();
    }

    public void setButtonIconDrawableResource(int i10) {
        setButtonIconDrawable(h.a.a(getContext(), i10));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.f5326w != colorStateList) {
            this.f5326w = colorStateList;
            a();
        }
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.f5327x != mode) {
            this.f5327x = mode;
            a();
        }
    }

    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.f5325v != colorStateList) {
            this.f5325v = colorStateList;
            a();
        }
    }

    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        a();
    }

    public void setCenterIfNoTextEnabled(boolean z10) {
        this.f5319p = z10;
    }

    public void setChecked(boolean z10) {
        setCheckedState(z10 ? 1 : 0);
    }

    public void setCheckedState(int i10) {
        boolean z10;
        AutofillManager autofillManager;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f5328y != i10) {
            this.f5328y = i10;
            if (i10 == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            super.setChecked(z10);
            refreshDrawableState();
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 30 && this.B == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (!this.A) {
                this.A = true;
                LinkedHashSet linkedHashSet = this.f5316m;
                if (linkedHashSet != null) {
                    Iterator it = linkedHashSet.iterator();
                    if (it.hasNext()) {
                        h.y(it.next());
                        throw null;
                    }
                }
                if (!(this.f5328y == 2 || (onCheckedChangeListener = this.C) == null)) {
                    onCheckedChangeListener.onCheckedChanged(this, isChecked());
                }
                if (i11 >= 26 && (autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class)) != null) {
                    autofillManager.notifyValueChanged(this);
                }
                this.A = false;
            }
        }
    }

    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f5321r = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i10) {
        setErrorAccessibilityLabel(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setErrorShown(boolean z10) {
        if (this.f5320q != z10) {
            this.f5320q = z10;
            refreshDrawableState();
            Iterator it = this.f5315l.iterator();
            if (it.hasNext()) {
                h.y(it.next());
                throw null;
            }
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.C = onCheckedChangeListener;
    }

    public void setStateDescription(CharSequence charSequence) {
        this.B = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 30 && charSequence == null) {
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        ColorStateList colorStateList;
        this.f5318o = z10;
        if (z10) {
            colorStateList = getMaterialThemeColorsTintList();
        } else {
            colorStateList = null;
        }
        b.c(this, colorStateList);
    }

    public final void toggle() {
        setChecked(!isChecked());
    }

    public void setButtonDrawable(Drawable drawable) {
        this.f5322s = drawable;
        this.f5324u = false;
        a();
    }
}
