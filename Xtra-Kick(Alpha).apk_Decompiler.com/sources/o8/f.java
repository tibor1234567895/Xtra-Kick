package o8;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import b4.a;
import c0.g;
import com.google.gson.internal.bind.l;
import com.woxthebox.draglistview.R;
import g.c;
import java.util.HashSet;
import java.util.WeakHashMap;
import l0.e;
import m.e0;
import m.o;
import m.q;
import m0.c1;
import m0.i0;
import m8.p;
import t8.i;
import t8.n;

public abstract class f extends ViewGroup implements e0 {
    public static final int[] K = {16842912};
    public static final int[] L = {-16842910};
    public int A = -1;
    public boolean B;
    public int C;
    public int D;
    public int E;
    public n F;
    public boolean G = false;
    public ColorStateList H;
    public i I;
    public o J;

    /* renamed from: h  reason: collision with root package name */
    public final a f12330h;

    /* renamed from: i  reason: collision with root package name */
    public final c f12331i;

    /* renamed from: j  reason: collision with root package name */
    public final e f12332j = new e(5);

    /* renamed from: k  reason: collision with root package name */
    public final SparseArray f12333k = new SparseArray(5);

    /* renamed from: l  reason: collision with root package name */
    public int f12334l;

    /* renamed from: m  reason: collision with root package name */
    public d[] f12335m;

    /* renamed from: n  reason: collision with root package name */
    public int f12336n = 0;

    /* renamed from: o  reason: collision with root package name */
    public int f12337o = 0;

    /* renamed from: p  reason: collision with root package name */
    public ColorStateList f12338p;

    /* renamed from: q  reason: collision with root package name */
    public int f12339q;

    /* renamed from: r  reason: collision with root package name */
    public ColorStateList f12340r;

    /* renamed from: s  reason: collision with root package name */
    public final ColorStateList f12341s = b();

    /* renamed from: t  reason: collision with root package name */
    public int f12342t;

    /* renamed from: u  reason: collision with root package name */
    public int f12343u;

    /* renamed from: v  reason: collision with root package name */
    public Drawable f12344v;

    /* renamed from: w  reason: collision with root package name */
    public ColorStateList f12345w;

    /* renamed from: x  reason: collision with root package name */
    public int f12346x;

    /* renamed from: y  reason: collision with root package name */
    public final SparseArray f12347y = new SparseArray(5);

    /* renamed from: z  reason: collision with root package name */
    public int f12348z = -1;

    public f(Context context) {
        super(context);
        if (isInEditMode()) {
            this.f12330h = null;
        } else {
            a aVar = new a();
            this.f12330h = aVar;
            aVar.K(0);
            aVar.z((long) n8.a.c(getContext(), R.attr.motionDurationMedium4, getResources().getInteger(R.integer.material_motion_duration_long_1)));
            aVar.B(n8.a.d(getContext(), R.attr.motionEasingStandard, w7.a.f16154b));
            aVar.H(new p());
        }
        this.f12331i = new c(6, this);
        WeakHashMap weakHashMap = c1.f10054a;
        i0.s(this, 1);
    }

    private d getNewItem() {
        d dVar = (d) this.f12332j.j();
        if (dVar == null) {
            return new a8.a(getContext());
        }
        return dVar;
    }

    private void setBadgeIfNeeded(d dVar) {
        y7.a aVar;
        int id = dVar.getId();
        if ((id != -1) && (aVar = (y7.a) this.f12347y.get(id)) != null) {
            dVar.setBadge(aVar);
        }
    }

    public final void a() {
        boolean z10;
        boolean z11;
        removeAllViews();
        d[] dVarArr = this.f12335m;
        if (dVarArr != null) {
            for (d dVar : dVarArr) {
                if (dVar != null) {
                    this.f12332j.e(dVar);
                    if (dVar.K != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        ImageView imageView = dVar.f12322t;
                        if (imageView != null) {
                            dVar.setClipChildren(true);
                            dVar.setClipToPadding(true);
                            y7.a aVar = dVar.K;
                            if (aVar != null) {
                                if (aVar.d() != null) {
                                    aVar.d().setForeground((Drawable) null);
                                } else {
                                    imageView.getOverlay().remove(aVar);
                                }
                            }
                        }
                        dVar.K = null;
                    }
                    dVar.f12327y = null;
                    dVar.E = 0.0f;
                    dVar.f12310h = false;
                }
            }
        }
        if (this.J.size() == 0) {
            this.f12336n = 0;
            this.f12337o = 0;
            this.f12335m = null;
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < this.J.size(); i10++) {
            hashSet.add(Integer.valueOf(this.J.getItem(i10).getItemId()));
        }
        int i11 = 0;
        while (true) {
            SparseArray sparseArray = this.f12347y;
            if (i11 >= sparseArray.size()) {
                break;
            }
            int keyAt = sparseArray.keyAt(i11);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                sparseArray.delete(keyAt);
            }
            i11++;
        }
        this.f12335m = new d[this.J.size()];
        int i12 = this.f12334l;
        int size = this.J.l().size();
        if (i12 != -1 ? i12 != 0 : size <= 3) {
            z10 = false;
        } else {
            z10 = true;
        }
        for (int i13 = 0; i13 < this.J.size(); i13++) {
            this.I.f12352i = true;
            this.J.getItem(i13).setCheckable(true);
            this.I.f12352i = false;
            d newItem = getNewItem();
            this.f12335m[i13] = newItem;
            newItem.setIconTintList(this.f12338p);
            newItem.setIconSize(this.f12339q);
            newItem.setTextColor(this.f12341s);
            newItem.setTextAppearanceInactive(this.f12342t);
            newItem.setTextAppearanceActive(this.f12343u);
            newItem.setTextColor(this.f12340r);
            int i14 = this.f12348z;
            if (i14 != -1) {
                newItem.setItemPaddingTop(i14);
            }
            int i15 = this.A;
            if (i15 != -1) {
                newItem.setItemPaddingBottom(i15);
            }
            newItem.setActiveIndicatorWidth(this.C);
            newItem.setActiveIndicatorHeight(this.D);
            newItem.setActiveIndicatorMarginHorizontal(this.E);
            newItem.setActiveIndicatorDrawable(d());
            newItem.setActiveIndicatorResizeable(this.G);
            newItem.setActiveIndicatorEnabled(this.B);
            Drawable drawable = this.f12344v;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.f12346x);
            }
            newItem.setItemRippleColor(this.f12345w);
            newItem.setShifting(z10);
            newItem.setLabelVisibilityMode(this.f12334l);
            q qVar = (q) this.J.getItem(i13);
            newItem.b(qVar);
            newItem.setItemPosition(i13);
            SparseArray sparseArray2 = this.f12333k;
            int i16 = qVar.f9999a;
            newItem.setOnTouchListener((View.OnTouchListener) sparseArray2.get(i16));
            newItem.setOnClickListener(this.f12331i);
            int i17 = this.f12336n;
            if (i17 != 0 && i16 == i17) {
                this.f12337o = i13;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int min = Math.min(this.J.size() - 1, this.f12337o);
        this.f12337o = min;
        this.J.getItem(min).setChecked(true);
    }

    public final ColorStateList b() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(16842808, typedValue, true)) {
            return null;
        }
        ColorStateList c10 = g.c(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i10 = typedValue.data;
        int defaultColor = c10.getDefaultColor();
        int[] iArr = L;
        return new ColorStateList(new int[][]{iArr, K, ViewGroup.EMPTY_STATE_SET}, new int[]{c10.getColorForState(iArr, defaultColor), i10, defaultColor});
    }

    public final void c(o oVar) {
        this.J = oVar;
    }

    public final i d() {
        if (this.F == null || this.H == null) {
            return null;
        }
        i iVar = new i(this.F);
        iVar.k(this.H);
        return iVar;
    }

    public SparseArray<y7.a> getBadgeDrawables() {
        return this.f12347y;
    }

    public ColorStateList getIconTintList() {
        return this.f12338p;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.H;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.B;
    }

    public int getItemActiveIndicatorHeight() {
        return this.D;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.E;
    }

    public n getItemActiveIndicatorShapeAppearance() {
        return this.F;
    }

    public int getItemActiveIndicatorWidth() {
        return this.C;
    }

    public Drawable getItemBackground() {
        d[] dVarArr = this.f12335m;
        return (dVarArr == null || dVarArr.length <= 0) ? this.f12344v : dVarArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.f12346x;
    }

    public int getItemIconSize() {
        return this.f12339q;
    }

    public int getItemPaddingBottom() {
        return this.A;
    }

    public int getItemPaddingTop() {
        return this.f12348z;
    }

    public ColorStateList getItemRippleColor() {
        return this.f12345w;
    }

    public int getItemTextAppearanceActive() {
        return this.f12343u;
    }

    public int getItemTextAppearanceInactive() {
        return this.f12342t;
    }

    public ColorStateList getItemTextColor() {
        return this.f12340r;
    }

    public int getLabelVisibilityMode() {
        return this.f12334l;
    }

    public o getMenu() {
        return this.J;
    }

    public int getSelectedItemId() {
        return this.f12336n;
    }

    public int getSelectedItemPosition() {
        return this.f12337o;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) l.b(1, this.J.l().size(), 1).f4038a);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f12338p = colorStateList;
        d[] dVarArr = this.f12335m;
        if (dVarArr != null) {
            for (d iconTintList : dVarArr) {
                iconTintList.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.H = colorStateList;
        d[] dVarArr = this.f12335m;
        if (dVarArr != null) {
            for (d activeIndicatorDrawable : dVarArr) {
                activeIndicatorDrawable.setActiveIndicatorDrawable(d());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z10) {
        this.B = z10;
        d[] dVarArr = this.f12335m;
        if (dVarArr != null) {
            for (d activeIndicatorEnabled : dVarArr) {
                activeIndicatorEnabled.setActiveIndicatorEnabled(z10);
            }
        }
    }

    public void setItemActiveIndicatorHeight(int i10) {
        this.D = i10;
        d[] dVarArr = this.f12335m;
        if (dVarArr != null) {
            for (d activeIndicatorHeight : dVarArr) {
                activeIndicatorHeight.setActiveIndicatorHeight(i10);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int i10) {
        this.E = i10;
        d[] dVarArr = this.f12335m;
        if (dVarArr != null) {
            for (d activeIndicatorMarginHorizontal : dVarArr) {
                activeIndicatorMarginHorizontal.setActiveIndicatorMarginHorizontal(i10);
            }
        }
    }

    public void setItemActiveIndicatorResizeable(boolean z10) {
        this.G = z10;
        d[] dVarArr = this.f12335m;
        if (dVarArr != null) {
            for (d activeIndicatorResizeable : dVarArr) {
                activeIndicatorResizeable.setActiveIndicatorResizeable(z10);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(n nVar) {
        this.F = nVar;
        d[] dVarArr = this.f12335m;
        if (dVarArr != null) {
            for (d activeIndicatorDrawable : dVarArr) {
                activeIndicatorDrawable.setActiveIndicatorDrawable(d());
            }
        }
    }

    public void setItemActiveIndicatorWidth(int i10) {
        this.C = i10;
        d[] dVarArr = this.f12335m;
        if (dVarArr != null) {
            for (d activeIndicatorWidth : dVarArr) {
                activeIndicatorWidth.setActiveIndicatorWidth(i10);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.f12344v = drawable;
        d[] dVarArr = this.f12335m;
        if (dVarArr != null) {
            for (d itemBackground : dVarArr) {
                itemBackground.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i10) {
        this.f12346x = i10;
        d[] dVarArr = this.f12335m;
        if (dVarArr != null) {
            for (d itemBackground : dVarArr) {
                itemBackground.setItemBackground(i10);
            }
        }
    }

    public void setItemIconSize(int i10) {
        this.f12339q = i10;
        d[] dVarArr = this.f12335m;
        if (dVarArr != null) {
            for (d iconSize : dVarArr) {
                iconSize.setIconSize(i10);
            }
        }
    }

    public void setItemPaddingBottom(int i10) {
        this.A = i10;
        d[] dVarArr = this.f12335m;
        if (dVarArr != null) {
            for (d itemPaddingBottom : dVarArr) {
                itemPaddingBottom.setItemPaddingBottom(i10);
            }
        }
    }

    public void setItemPaddingTop(int i10) {
        this.f12348z = i10;
        d[] dVarArr = this.f12335m;
        if (dVarArr != null) {
            for (d itemPaddingTop : dVarArr) {
                itemPaddingTop.setItemPaddingTop(i10);
            }
        }
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f12345w = colorStateList;
        d[] dVarArr = this.f12335m;
        if (dVarArr != null) {
            for (d itemRippleColor : dVarArr) {
                itemRippleColor.setItemRippleColor(colorStateList);
            }
        }
    }

    public void setItemTextAppearanceActive(int i10) {
        this.f12343u = i10;
        d[] dVarArr = this.f12335m;
        if (dVarArr != null) {
            for (d dVar : dVarArr) {
                dVar.setTextAppearanceActive(i10);
                ColorStateList colorStateList = this.f12340r;
                if (colorStateList != null) {
                    dVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i10) {
        this.f12342t = i10;
        d[] dVarArr = this.f12335m;
        if (dVarArr != null) {
            for (d dVar : dVarArr) {
                dVar.setTextAppearanceInactive(i10);
                ColorStateList colorStateList = this.f12340r;
                if (colorStateList != null) {
                    dVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f12340r = colorStateList;
        d[] dVarArr = this.f12335m;
        if (dVarArr != null) {
            for (d textColor : dVarArr) {
                textColor.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i10) {
        this.f12334l = i10;
    }

    public void setPresenter(i iVar) {
        this.I = iVar;
    }
}
