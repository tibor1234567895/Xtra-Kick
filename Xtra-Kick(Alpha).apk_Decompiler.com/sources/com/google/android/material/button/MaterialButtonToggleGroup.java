package com.google.android.material.button;

import a9.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import b4.e0;
import c8.e;
import com.google.android.material.timepicker.i;
import com.google.gson.internal.bind.l;
import com.woxthebox.draglistview.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import m0.j0;
import m0.p;
import m8.r;
import m8.w;
import s.g;
import t8.m;
import t8.n;

public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: r  reason: collision with root package name */
    public static final /* synthetic */ int f3707r = 0;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f3708h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final e0 f3709i = new e0(this);

    /* renamed from: j  reason: collision with root package name */
    public final LinkedHashSet f3710j = new LinkedHashSet();

    /* renamed from: k  reason: collision with root package name */
    public final g f3711k = new g(2, this);

    /* renamed from: l  reason: collision with root package name */
    public Integer[] f3712l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f3713m = false;

    /* renamed from: n  reason: collision with root package name */
    public boolean f3714n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f3715o;

    /* renamed from: p  reason: collision with root package name */
    public final int f3716p;

    /* renamed from: q  reason: collision with root package name */
    public HashSet f3717q = new HashSet();

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, R.attr.materialButtonToggleGroupStyle, 2132018320), attributeSet, R.attr.materialButtonToggleGroupStyle);
        TypedArray d10 = r.d(getContext(), attributeSet, v7.a.f15948q, R.attr.materialButtonToggleGroupStyle, 2132018320, new int[0]);
        setSingleSelection(d10.getBoolean(3, false));
        this.f3716p = d10.getResourceId(1, -1);
        this.f3715o = d10.getBoolean(2, false);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(d10.getBoolean(0, true));
        d10.recycle();
        WeakHashMap weakHashMap = c1.f10054a;
        i0.s(this, 1);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (d(i10)) {
                return i10;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (d(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if ((getChildAt(i11) instanceof MaterialButton) && d(i11)) {
                i10++;
            }
        }
        return i10;
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            WeakHashMap weakHashMap = c1.f10054a;
            materialButton.setId(j0.a());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f3709i);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public final void a() {
        LinearLayout.LayoutParams layoutParams;
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex != -1) {
            for (int i10 = firstVisibleChildIndex + 1; i10 < getChildCount(); i10++) {
                MaterialButton c10 = c(i10);
                int min = Math.min(c10.getStrokeWidth(), c(i10 - 1).getStrokeWidth());
                ViewGroup.LayoutParams layoutParams2 = c10.getLayoutParams();
                if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                    layoutParams = (LinearLayout.LayoutParams) layoutParams2;
                } else {
                    layoutParams = new LinearLayout.LayoutParams(layoutParams2.width, layoutParams2.height);
                }
                if (getOrientation() == 0) {
                    p.g(layoutParams, 0);
                    p.h(layoutParams, -min);
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = -min;
                    p.h(layoutParams, 0);
                }
                c10.setLayoutParams(layoutParams);
            }
            if (getChildCount() != 0 && firstVisibleChildIndex != -1) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c(firstVisibleChildIndex).getLayoutParams();
                if (getOrientation() == 1) {
                    layoutParams3.topMargin = 0;
                    layoutParams3.bottomMargin = 0;
                    return;
                }
                p.g(layoutParams3, 0);
                p.h(layoutParams3, 0);
                layoutParams3.leftMargin = 0;
                layoutParams3.rightMargin = 0;
            }
        }
    }

    public final void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i10, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        b(materialButton.getId(), materialButton.isChecked());
        n shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f3708h.add(new e(shapeAppearanceModel.f14782e, shapeAppearanceModel.f14785h, shapeAppearanceModel.f14783f, shapeAppearanceModel.f14784g));
        materialButton.setEnabled(isEnabled());
        c1.p(materialButton, new o3.j0(2, this));
    }

    public final void b(int i10, boolean z10) {
        if (i10 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i10);
            return;
        }
        HashSet hashSet = new HashSet(this.f3717q);
        if (z10 && !hashSet.contains(Integer.valueOf(i10))) {
            if (this.f3714n && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i10));
        } else if (!z10 && hashSet.contains(Integer.valueOf(i10))) {
            if (!this.f3715o || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i10));
            }
        } else {
            return;
        }
        e(hashSet);
    }

    public final MaterialButton c(int i10) {
        return (MaterialButton) getChildAt(i10);
    }

    public final boolean d(int i10) {
        return getChildAt(i10).getVisibility() != 8;
    }

    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f3711k);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            treeMap.put(c(i10), Integer.valueOf(i10));
        }
        this.f3712l = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e(Set set) {
        HashSet hashSet = this.f3717q;
        this.f3717q = new HashSet(set);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id = c(i10).getId();
            boolean contains = set.contains(Integer.valueOf(id));
            View findViewById = findViewById(id);
            if (findViewById instanceof MaterialButton) {
                this.f3713m = true;
                ((MaterialButton) findViewById).setChecked(contains);
                this.f3713m = false;
            }
            if (hashSet.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                set.contains(Integer.valueOf(id));
                Iterator it = this.f3710j.iterator();
                while (it.hasNext()) {
                    ((i) it.next()).a();
                }
            }
        }
        invalidate();
    }

    public final void f() {
        boolean z10;
        e eVar;
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i10 = 0; i10 < childCount; i10++) {
            MaterialButton c10 = c(i10);
            if (c10.getVisibility() != 8) {
                n shapeAppearanceModel = c10.getShapeAppearanceModel();
                shapeAppearanceModel.getClass();
                m mVar = new m(shapeAppearanceModel);
                e eVar2 = (e) this.f3708h.get(i10);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    if (getOrientation() == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    t8.a aVar = e.f3023e;
                    if (i10 == firstVisibleChildIndex) {
                        if (!z10) {
                            eVar = new e(eVar2.f3024a, aVar, eVar2.f3025b, aVar);
                        } else if (w.c(this)) {
                            eVar = new e(aVar, aVar, eVar2.f3025b, eVar2.f3026c);
                        } else {
                            eVar = new e(eVar2.f3024a, eVar2.f3027d, aVar, aVar);
                        }
                    } else if (i10 != lastVisibleChildIndex) {
                        eVar2 = null;
                    } else if (!z10) {
                        eVar = new e(aVar, eVar2.f3027d, aVar, eVar2.f3026c);
                    } else if (w.c(this)) {
                        eVar = new e(eVar2.f3024a, eVar2.f3027d, aVar, aVar);
                    } else {
                        eVar = new e(aVar, aVar, eVar2.f3025b, eVar2.f3026c);
                    }
                    eVar2 = eVar;
                }
                if (eVar2 == null) {
                    mVar.f14769e = new t8.a(0.0f);
                    mVar.f14770f = new t8.a(0.0f);
                    mVar.f14771g = new t8.a(0.0f);
                    mVar.f14772h = new t8.a(0.0f);
                } else {
                    mVar.f14769e = eVar2.f3024a;
                    mVar.f14772h = eVar2.f3027d;
                    mVar.f14770f = eVar2.f3025b;
                    mVar.f14771g = eVar2.f3026c;
                }
                c10.setShapeAppearanceModel(new n(mVar));
            }
        }
    }

    public int getCheckedButtonId() {
        if (!this.f3714n || this.f3717q.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f3717q.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id = c(i10).getId();
            if (this.f3717q.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    public final int getChildDrawingOrder(int i10, int i11) {
        Integer[] numArr = this.f3712l;
        if (numArr != null && i11 < numArr.length) {
            return numArr[i11].intValue();
        }
        Log.w("MButtonToggleGroup", "Child order wasn't updated");
        return i11;
    }

    public final void onFinishInflate() {
        super.onFinishInflate();
        int i10 = this.f3716p;
        if (i10 != -1) {
            e(Collections.singleton(Integer.valueOf(i10)));
        }
    }

    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i10;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        int visibleButtonCount = getVisibleButtonCount();
        if (this.f3714n) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) l.b(1, visibleButtonCount, i10).f4038a);
    }

    public final void onMeasure(int i10, int i11) {
        f();
        a();
        super.onMeasure(i10, i11);
    }

    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal((c8.a) null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f3708h.remove(indexOfChild);
        }
        f();
        a();
    }

    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            c(i10).setEnabled(z10);
        }
    }

    public void setSelectionRequired(boolean z10) {
        this.f3715o = z10;
    }

    public void setSingleSelection(int i10) {
        setSingleSelection(getResources().getBoolean(i10));
    }

    public void setSingleSelection(boolean z10) {
        if (this.f3714n != z10) {
            this.f3714n = z10;
            e(new HashSet());
        }
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            c(i10).setA11yClassName((this.f3714n ? RadioButton.class : ToggleButton.class).getName());
        }
    }
}
