package o8;

import a8.b;
import a9.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.widget.u4;
import b4.e0;
import com.woxthebox.draglistview.R;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import l.l;
import m.c0;
import m0.c1;
import m0.i0;
import m8.r;
import q8.d;
import t8.i;
import t8.j;

public abstract class n extends FrameLayout {

    /* renamed from: h  reason: collision with root package name */
    public final e f12355h;

    /* renamed from: i  reason: collision with root package name */
    public final b f12356i;

    /* renamed from: j  reason: collision with root package name */
    public final i f12357j;

    /* renamed from: k  reason: collision with root package name */
    public l f12358k;

    /* renamed from: l  reason: collision with root package name */
    public k f12359l;

    /* renamed from: m  reason: collision with root package name */
    public j f12360m;

    public n(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, R.attr.bottomNavigationStyle, 2132018096), attributeSet, R.attr.bottomNavigationStyle);
        ColorStateList colorStateList;
        i iVar = new i();
        this.f12357j = iVar;
        Context context2 = getContext();
        u4 e10 = r.e(context2, attributeSet, v7.a.A, R.attr.bottomNavigationStyle, 2132018096, 10, 9);
        e eVar = new e(context2, getClass(), getMaxItemCount());
        this.f12355h = eVar;
        b bVar = new b(context2);
        this.f12356i = bVar;
        iVar.f12351h = bVar;
        iVar.f12353j = 1;
        bVar.setPresenter(iVar);
        eVar.b(iVar, eVar.f9972a);
        getContext();
        iVar.f12351h.J = eVar;
        if (e10.l(5)) {
            colorStateList = e10.b(5);
        } else {
            colorStateList = bVar.b();
        }
        bVar.setIconTintList(colorStateList);
        setItemIconSize(e10.d(4, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (e10.l(10)) {
            setItemTextAppearanceInactive(e10.i(10, 0));
        }
        if (e10.l(9)) {
            setItemTextAppearanceActive(e10.i(9, 0));
        }
        if (e10.l(11)) {
            setItemTextColor(e10.b(11));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            i iVar2 = new i();
            Drawable background = getBackground();
            if (background instanceof ColorDrawable) {
                iVar2.k(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            iVar2.i(context2);
            WeakHashMap weakHashMap = c1.f10054a;
            i0.q(this, iVar2);
        }
        if (e10.l(7)) {
            setItemPaddingTop(e10.d(7, 0));
        }
        if (e10.l(6)) {
            setItemPaddingBottom(e10.d(6, 0));
        }
        if (e10.l(1)) {
            setElevation((float) e10.d(1, 0));
        }
        f0.b.h(getBackground().mutate(), d.b(context2, e10, 0));
        setLabelVisibilityMode(e10.f1100b.getInteger(12, -1));
        int i10 = e10.i(3, 0);
        if (i10 != 0) {
            bVar.setItemBackgroundRes(i10);
        } else {
            setItemRippleColor(d.b(context2, e10, 8));
        }
        int i11 = e10.i(2, 0);
        if (i11 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(i11, v7.a.f15957z);
            setItemActiveIndicatorWidth(obtainStyledAttributes.getDimensionPixelSize(1, 0));
            setItemActiveIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(0, 0));
            setItemActiveIndicatorMarginHorizontal(obtainStyledAttributes.getDimensionPixelOffset(3, 0));
            setItemActiveIndicatorColor(d.a(context2, obtainStyledAttributes, 2));
            setItemActiveIndicatorShapeAppearance(new t8.n(t8.n.a(context2, obtainStyledAttributes.getResourceId(4, 0), 0, new t8.a((float) 0))));
            obtainStyledAttributes.recycle();
        }
        if (e10.l(13)) {
            int i12 = e10.i(13, 0);
            iVar.f12352i = true;
            getMenuInflater().inflate(i12, eVar);
            iVar.f12352i = false;
            iVar.e(true);
        }
        e10.n();
        addView(bVar);
        eVar.f9976e = new e0(25, this);
    }

    private MenuInflater getMenuInflater() {
        if (this.f12358k == null) {
            this.f12358k = new l(getContext());
        }
        return this.f12358k;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.f12356i.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorHeight() {
        return this.f12356i.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f12356i.getItemActiveIndicatorMarginHorizontal();
    }

    public t8.n getItemActiveIndicatorShapeAppearance() {
        return this.f12356i.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.f12356i.getItemActiveIndicatorWidth();
    }

    public Drawable getItemBackground() {
        return this.f12356i.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f12356i.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f12356i.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f12356i.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.f12356i.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.f12356i.getItemPaddingTop();
    }

    public ColorStateList getItemRippleColor() {
        return this.f12356i.getItemRippleColor();
    }

    public int getItemTextAppearanceActive() {
        return this.f12356i.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f12356i.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f12356i.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f12356i.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.f12355h;
    }

    public m.e0 getMenuView() {
        return this.f12356i;
    }

    public i getPresenter() {
        return this.f12357j;
    }

    public int getSelectedItemId() {
        return this.f12356i.getSelectedItemId();
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.c(this);
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof m)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        m mVar = (m) parcelable;
        super.onRestoreInstanceState(mVar.f14484h);
        Bundle bundle = mVar.f12354j;
        e eVar = this.f12355h;
        eVar.getClass();
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null) {
            CopyOnWriteArrayList copyOnWriteArrayList = eVar.f9992u;
            if (!copyOnWriteArrayList.isEmpty()) {
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    c0 c0Var = (c0) weakReference.get();
                    if (c0Var == null) {
                        copyOnWriteArrayList.remove(weakReference);
                    } else {
                        int id = c0Var.getId();
                        if (id > 0 && (parcelable2 = (Parcelable) sparseParcelableArray.get(id)) != null) {
                            c0Var.c(parcelable2);
                        }
                    }
                }
            }
        }
    }

    public final Parcelable onSaveInstanceState() {
        Parcelable j10;
        m mVar = new m(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        mVar.f12354j = bundle;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f12355h.f9992u;
        if (!copyOnWriteArrayList.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                c0 c0Var = (c0) weakReference.get();
                if (c0Var == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    int id = c0Var.getId();
                    if (id > 0 && (j10 = c0Var.j()) != null) {
                        sparseArray.put(id, j10);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
        return mVar;
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        j.b(this, f10);
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.f12356i.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z10) {
        this.f12356i.setItemActiveIndicatorEnabled(z10);
    }

    public void setItemActiveIndicatorHeight(int i10) {
        this.f12356i.setItemActiveIndicatorHeight(i10);
    }

    public void setItemActiveIndicatorMarginHorizontal(int i10) {
        this.f12356i.setItemActiveIndicatorMarginHorizontal(i10);
    }

    public void setItemActiveIndicatorShapeAppearance(t8.n nVar) {
        this.f12356i.setItemActiveIndicatorShapeAppearance(nVar);
    }

    public void setItemActiveIndicatorWidth(int i10) {
        this.f12356i.setItemActiveIndicatorWidth(i10);
    }

    public void setItemBackground(Drawable drawable) {
        this.f12356i.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i10) {
        this.f12356i.setItemBackgroundRes(i10);
    }

    public void setItemIconSize(int i10) {
        this.f12356i.setItemIconSize(i10);
    }

    public void setItemIconSizeRes(int i10) {
        setItemIconSize(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f12356i.setIconTintList(colorStateList);
    }

    public void setItemPaddingBottom(int i10) {
        this.f12356i.setItemPaddingBottom(i10);
    }

    public void setItemPaddingTop(int i10) {
        this.f12356i.setItemPaddingTop(i10);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f12356i.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(int i10) {
        this.f12356i.setItemTextAppearanceActive(i10);
    }

    public void setItemTextAppearanceInactive(int i10) {
        this.f12356i.setItemTextAppearanceInactive(i10);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f12356i.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i10) {
        b bVar = this.f12356i;
        if (bVar.getLabelVisibilityMode() != i10) {
            bVar.setLabelVisibilityMode(i10);
            this.f12357j.e(false);
        }
    }

    public void setOnItemReselectedListener(j jVar) {
        this.f12360m = jVar;
    }

    public void setOnItemSelectedListener(k kVar) {
        this.f12359l = kVar;
    }

    public void setSelectedItemId(int i10) {
        e eVar = this.f12355h;
        MenuItem findItem = eVar.findItem(i10);
        if (findItem != null && !eVar.q(findItem, this.f12357j, 0)) {
            findItem.setChecked(true);
        }
    }
}
