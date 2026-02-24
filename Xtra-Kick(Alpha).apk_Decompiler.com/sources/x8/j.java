package x8;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.f5;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.internal.bind.l;
import com.woxthebox.draglistview.R;
import f0.b;
import f0.d;
import java.util.WeakHashMap;
import m0.c0;
import m0.c1;
import m0.j0;
import m0.p;
import m8.w;
import n0.g;
import n0.h;
import q0.a0;
import q0.t;
import y7.a;
import y7.c;

public final class j extends LinearLayout {

    /* renamed from: s  reason: collision with root package name */
    public static final /* synthetic */ int f16766s = 0;

    /* renamed from: h  reason: collision with root package name */
    public h f16767h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16768i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f16769j;

    /* renamed from: k  reason: collision with root package name */
    public View f16770k;

    /* renamed from: l  reason: collision with root package name */
    public a f16771l;

    /* renamed from: m  reason: collision with root package name */
    public View f16772m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f16773n;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f16774o;

    /* renamed from: p  reason: collision with root package name */
    public Drawable f16775p;

    /* renamed from: q  reason: collision with root package name */
    public int f16776q = 2;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ TabLayout f16777r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(TabLayout tabLayout, Context context) {
        super(context);
        e.a aVar;
        this.f16777r = tabLayout;
        f(context);
        int i10 = tabLayout.f3866l;
        WeakHashMap weakHashMap = c1.f10054a;
        j0.k(this, i10, tabLayout.f3867m, tabLayout.f3868n, tabLayout.f3869o);
        setGravity(17);
        setOrientation(tabLayout.K ^ true ? 1 : 0);
        setClickable(true);
        Context context2 = getContext();
        if (Build.VERSION.SDK_INT >= 24) {
            aVar = new e.a(13, (Object) c0.b(context2, 1002));
        } else {
            aVar = new e.a(13, (Object) null);
        }
        c1.s(this, aVar);
    }

    private a getBadge() {
        return this.f16771l;
    }

    private a getOrCreateBadge() {
        if (this.f16771l == null) {
            this.f16771l = new a(getContext(), (c) null);
        }
        c();
        a aVar = this.f16771l;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("Unable to create badge");
    }

    public final void a(View view) {
        boolean z10;
        if (this.f16771l != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(false);
                viewGroup.setClipToPadding(false);
            }
            a aVar = this.f16771l;
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            aVar.setBounds(rect);
            aVar.h(view, (FrameLayout) null);
            if (aVar.d() != null) {
                aVar.d().setForeground(aVar);
            } else {
                view.getOverlay().add(aVar);
            }
            this.f16770k = view;
        }
    }

    public final void b() {
        boolean z10;
        if (this.f16771l != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            setClipChildren(true);
            setClipToPadding(true);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(true);
                viewGroup.setClipToPadding(true);
            }
            View view = this.f16770k;
            if (view != null) {
                a aVar = this.f16771l;
                if (aVar != null) {
                    if (aVar.d() != null) {
                        aVar.d().setForeground((Drawable) null);
                    } else {
                        view.getOverlay().remove(aVar);
                    }
                }
                this.f16770k = null;
            }
        }
    }

    public final void c() {
        boolean z10;
        View view;
        h hVar;
        h hVar2;
        if (this.f16771l != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (this.f16772m == null) {
                View view2 = this.f16769j;
                if (view2 == null || (hVar2 = this.f16767h) == null || hVar2.f16755a == null) {
                    view2 = this.f16768i;
                    if (!(view2 == null || (hVar = this.f16767h) == null || hVar.f16760f != 1)) {
                        if (this.f16770k != view2) {
                            b();
                            view = this.f16768i;
                        }
                        d(view2);
                        return;
                    }
                } else {
                    if (this.f16770k != view2) {
                        b();
                        view = this.f16769j;
                    }
                    d(view2);
                    return;
                }
                a(view);
                return;
            }
            b();
        }
    }

    public final void d(View view) {
        boolean z10;
        a aVar = this.f16771l;
        if (aVar != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 && view == this.f16770k) {
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            aVar.setBounds(rect);
            aVar.h(view, (FrameLayout) null);
        }
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f16775p;
        boolean z10 = false;
        if (drawable != null && drawable.isStateful()) {
            z10 = false | this.f16775p.setState(drawableState);
        }
        if (z10) {
            invalidate();
            this.f16777r.invalidate();
        }
    }

    public final void e() {
        boolean z10;
        g();
        h hVar = this.f16767h;
        boolean z11 = false;
        if (hVar != null) {
            TabLayout tabLayout = hVar.f16761g;
            if (tabLayout != null) {
                int selectedTabPosition = tabLayout.getSelectedTabPosition();
                if (selectedTabPosition == -1 || selectedTabPosition != hVar.f16758d) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (z10) {
                    z11 = true;
                }
            } else {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
        }
        setSelected(z11);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.graphics.drawable.RippleDrawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(android.content.Context r7) {
        /*
            r6 = this;
            com.google.android.material.tabs.TabLayout r0 = r6.f16777r
            int r1 = r0.A
            r2 = 0
            if (r1 == 0) goto L_0x001f
            android.graphics.drawable.Drawable r7 = h.a.a(r7, r1)
            r6.f16775p = r7
            if (r7 == 0) goto L_0x0021
            boolean r7 = r7.isStateful()
            if (r7 == 0) goto L_0x0021
            android.graphics.drawable.Drawable r7 = r6.f16775p
            int[] r1 = r6.getDrawableState()
            r7.setState(r1)
            goto L_0x0021
        L_0x001f:
            r6.f16775p = r2
        L_0x0021:
            android.graphics.drawable.GradientDrawable r7 = new android.graphics.drawable.GradientDrawable
            r7.<init>()
            r1 = 0
            r7.setColor(r1)
            android.content.res.ColorStateList r1 = r0.f3875u
            if (r1 == 0) goto L_0x0052
            android.graphics.drawable.GradientDrawable r1 = new android.graphics.drawable.GradientDrawable
            r1.<init>()
            r3 = 925353388(0x3727c5ac, float:1.0E-5)
            r1.setCornerRadius(r3)
            r3 = -1
            r1.setColor(r3)
            android.content.res.ColorStateList r3 = r0.f3875u
            android.content.res.ColorStateList r3 = r8.d.a(r3)
            android.graphics.drawable.RippleDrawable r4 = new android.graphics.drawable.RippleDrawable
            boolean r5 = r0.O
            if (r5 == 0) goto L_0x004a
            r7 = r2
        L_0x004a:
            if (r5 == 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r2 = r1
        L_0x004e:
            r4.<init>(r3, r7, r2)
            r7 = r4
        L_0x0052:
            java.util.WeakHashMap r1 = m0.c1.f10054a
            m0.i0.q(r6, r7)
            r0.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x8.j.f(android.content.Context):void");
    }

    public final void g() {
        View view;
        int i10;
        TextView textView;
        ViewParent parent;
        h hVar = this.f16767h;
        ImageView imageView = null;
        if (hVar != null) {
            view = hVar.f16759e;
        } else {
            view = null;
        }
        if (view != null) {
            ViewParent parent2 = view.getParent();
            if (parent2 != this) {
                if (parent2 != null) {
                    ((ViewGroup) parent2).removeView(view);
                }
                View view2 = this.f16772m;
                if (!(view2 == null || (parent = view2.getParent()) == null)) {
                    ((ViewGroup) parent).removeView(this.f16772m);
                }
                addView(view);
            }
            this.f16772m = view;
            TextView textView2 = this.f16768i;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            ImageView imageView2 = this.f16769j;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
                this.f16769j.setImageDrawable((Drawable) null);
            }
            TextView textView3 = (TextView) view.findViewById(16908308);
            this.f16773n = textView3;
            if (textView3 != null) {
                this.f16776q = t.b(textView3);
            }
            imageView = (ImageView) view.findViewById(16908294);
        } else {
            View view3 = this.f16772m;
            if (view3 != null) {
                removeView(view3);
                this.f16772m = null;
            }
            this.f16773n = null;
        }
        this.f16774o = imageView;
        if (this.f16772m == null) {
            if (this.f16769j == null) {
                ImageView imageView3 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, this, false);
                this.f16769j = imageView3;
                addView(imageView3, 0);
            }
            if (this.f16768i == null) {
                TextView textView4 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, this, false);
                this.f16768i = textView4;
                addView(textView4);
                this.f16776q = t.b(this.f16768i);
            }
            TextView textView5 = this.f16768i;
            TabLayout tabLayout = this.f16777r;
            a0.d(textView5, tabLayout.f3870p);
            if (!isSelected() || (i10 = tabLayout.f3872r) == -1) {
                textView = this.f16768i;
                i10 = tabLayout.f3871q;
            } else {
                textView = this.f16768i;
            }
            a0.d(textView, i10);
            ColorStateList colorStateList = tabLayout.f3873s;
            if (colorStateList != null) {
                this.f16768i.setTextColor(colorStateList);
            }
            h(this.f16768i, this.f16769j, true);
            c();
            ImageView imageView4 = this.f16769j;
            if (imageView4 != null) {
                imageView4.addOnLayoutChangeListener(new i(this, imageView4));
            }
            TextView textView6 = this.f16768i;
            if (textView6 != null) {
                textView6.addOnLayoutChangeListener(new i(this, textView6));
            }
        } else {
            TextView textView7 = this.f16773n;
            if (!(textView7 == null && imageView == null)) {
                h(textView7, imageView, false);
            }
        }
        if (hVar != null && !TextUtils.isEmpty(hVar.f16757c)) {
            setContentDescription(hVar.f16757c);
        }
    }

    public int getContentHeight() {
        View[] viewArr = {this.f16768i, this.f16769j, this.f16772m};
        int i10 = 0;
        int i11 = 0;
        boolean z10 = false;
        for (int i12 = 0; i12 < 3; i12++) {
            View view = viewArr[i12];
            if (view != null && view.getVisibility() == 0) {
                i11 = z10 ? Math.min(i11, view.getTop()) : view.getTop();
                i10 = z10 ? Math.max(i10, view.getBottom()) : view.getBottom();
                z10 = true;
            }
        }
        return i10 - i11;
    }

    public int getContentWidth() {
        View[] viewArr = {this.f16768i, this.f16769j, this.f16772m};
        int i10 = 0;
        int i11 = 0;
        boolean z10 = false;
        for (int i12 = 0; i12 < 3; i12++) {
            View view = viewArr[i12];
            if (view != null && view.getVisibility() == 0) {
                i11 = z10 ? Math.min(i11, view.getLeft()) : view.getLeft();
                i10 = z10 ? Math.max(i10, view.getRight()) : view.getRight();
                z10 = true;
            }
        }
        return i10 - i11;
    }

    public h getTab() {
        return this.f16767h;
    }

    public final void h(TextView textView, ImageView imageView, boolean z10) {
        Drawable drawable;
        CharSequence charSequence;
        int i10;
        CharSequence charSequence2;
        int i11;
        Drawable drawable2;
        h hVar = this.f16767h;
        CharSequence charSequence3 = null;
        if (hVar == null || (drawable2 = hVar.f16755a) == null) {
            drawable = null;
        } else {
            drawable = d.g(drawable2).mutate();
        }
        TabLayout tabLayout = this.f16777r;
        if (drawable != null) {
            b.h(drawable, tabLayout.f3874t);
            PorterDuff.Mode mode = tabLayout.f3878x;
            if (mode != null) {
                b.i(drawable, mode);
            }
        }
        h hVar2 = this.f16767h;
        if (hVar2 != null) {
            charSequence = hVar2.f16756b;
        } else {
            charSequence = null;
        }
        if (imageView != null) {
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
                setVisibility(0);
            } else {
                imageView.setVisibility(8);
                imageView.setImageDrawable((Drawable) null);
            }
        }
        boolean z11 = true;
        boolean z12 = !TextUtils.isEmpty(charSequence);
        if (textView != null) {
            if (!z12 || this.f16767h.f16760f != 1) {
                z11 = false;
            }
            if (z12) {
                charSequence2 = charSequence;
            } else {
                charSequence2 = null;
            }
            textView.setText(charSequence2);
            if (z11) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            textView.setVisibility(i11);
            if (z12) {
                setVisibility(0);
            }
        } else {
            z11 = false;
        }
        if (z10 && imageView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            if (!z11 || imageView.getVisibility() != 0) {
                i10 = 0;
            } else {
                i10 = (int) w.b(getContext(), 8);
            }
            if (tabLayout.K) {
                if (i10 != p.b(marginLayoutParams)) {
                    p.g(marginLayoutParams, i10);
                    marginLayoutParams.bottomMargin = 0;
                }
            } else if (i10 != marginLayoutParams.bottomMargin) {
                marginLayoutParams.bottomMargin = i10;
                p.g(marginLayoutParams, 0);
            }
            imageView.setLayoutParams(marginLayoutParams);
            imageView.requestLayout();
        }
        h hVar3 = this.f16767h;
        if (hVar3 != null) {
            charSequence3 = hVar3.f16757c;
        }
        if (Build.VERSION.SDK_INT > 23) {
            if (!z12) {
                charSequence = charSequence3;
            }
            f5.a(this, charSequence);
        }
    }

    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        a aVar = this.f16771l;
        if (aVar != null && aVar.isVisible()) {
            CharSequence contentDescription = getContentDescription();
            accessibilityNodeInfo.setContentDescription(contentDescription + ", " + this.f16771l.c());
        }
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) l.c(0, 1, this.f16767h.f16758d, 1, isSelected()).f4038a);
        if (isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) g.f10903e.f10911a);
        }
        h.a(accessibilityNodeInfo).putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(R.string.item_view_role_description));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008c, code lost:
        if (((r0 / r2.getPaint().getTextSize()) * r2.getLineWidth(0)) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) goto L_0x008e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            int r0 = android.view.View.MeasureSpec.getSize(r8)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            com.google.android.material.tabs.TabLayout r2 = r7.f16777r
            int r3 = r2.getTabMaxWidth()
            if (r3 <= 0) goto L_0x001c
            if (r1 == 0) goto L_0x0014
            if (r0 <= r3) goto L_0x001c
        L_0x0014:
            int r8 = r2.B
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r0)
        L_0x001c:
            super.onMeasure(r8, r9)
            android.widget.TextView r0 = r7.f16768i
            if (r0 == 0) goto L_0x009e
            float r0 = r2.f3879y
            int r1 = r7.f16776q
            android.widget.ImageView r3 = r7.f16769j
            r4 = 1
            if (r3 == 0) goto L_0x0034
            int r3 = r3.getVisibility()
            if (r3 != 0) goto L_0x0034
            r1 = 1
            goto L_0x0040
        L_0x0034:
            android.widget.TextView r3 = r7.f16768i
            if (r3 == 0) goto L_0x0040
            int r3 = r3.getLineCount()
            if (r3 <= r4) goto L_0x0040
            float r0 = r2.f3880z
        L_0x0040:
            android.widget.TextView r3 = r7.f16768i
            float r3 = r3.getTextSize()
            android.widget.TextView r5 = r7.f16768i
            int r5 = r5.getLineCount()
            android.widget.TextView r6 = r7.f16768i
            int r6 = q0.t.b(r6)
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x005a
            if (r6 < 0) goto L_0x009e
            if (r1 == r6) goto L_0x009e
        L_0x005a:
            int r2 = r2.J
            r6 = 0
            if (r2 != r4) goto L_0x008f
            if (r3 <= 0) goto L_0x008f
            if (r5 != r4) goto L_0x008f
            android.widget.TextView r2 = r7.f16768i
            android.text.Layout r2 = r2.getLayout()
            if (r2 == 0) goto L_0x008e
            float r3 = r2.getLineWidth(r6)
            android.text.TextPaint r2 = r2.getPaint()
            float r2 = r2.getTextSize()
            float r2 = r0 / r2
            float r2 = r2 * r3
            int r3 = r7.getMeasuredWidth()
            int r5 = r7.getPaddingLeft()
            int r3 = r3 - r5
            int r5 = r7.getPaddingRight()
            int r3 = r3 - r5
            float r3 = (float) r3
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x008f
        L_0x008e:
            r4 = 0
        L_0x008f:
            if (r4 == 0) goto L_0x009e
            android.widget.TextView r2 = r7.f16768i
            r2.setTextSize(r6, r0)
            android.widget.TextView r0 = r7.f16768i
            r0.setMaxLines(r1)
            super.onMeasure(r8, r9)
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x8.j.onMeasure(int, int):void");
    }

    public final boolean performClick() {
        boolean performClick = super.performClick();
        if (this.f16767h == null) {
            return performClick;
        }
        if (!performClick) {
            playSoundEffect(0);
        }
        h hVar = this.f16767h;
        TabLayout tabLayout = hVar.f16761g;
        if (tabLayout != null) {
            tabLayout.i(hVar, true);
            return true;
        }
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }

    public void setSelected(boolean z10) {
        if (isSelected() != z10) {
        }
        super.setSelected(z10);
        TextView textView = this.f16768i;
        if (textView != null) {
            textView.setSelected(z10);
        }
        ImageView imageView = this.f16769j;
        if (imageView != null) {
            imageView.setSelected(z10);
        }
        View view = this.f16772m;
        if (view != null) {
            view.setSelected(z10);
        }
    }

    public void setTab(h hVar) {
        if (hVar != this.f16767h) {
            this.f16767h = hVar;
            e();
        }
    }
}
