package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.woxthebox.draglistview.R;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import m0.j0;
import t8.i;
import t8.k;
import t8.m;
import t8.n;
import v7.a;

public abstract class f extends ConstraintLayout {

    /* renamed from: x  reason: collision with root package name */
    public final e f3949x = new e(this);

    /* renamed from: y  reason: collision with root package name */
    public int f3950y;

    /* renamed from: z  reason: collision with root package name */
    public i f3951z;

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        i iVar = new i();
        this.f3951z = iVar;
        k kVar = new k(0.5f);
        n nVar = iVar.f14744h.f14723a;
        nVar.getClass();
        m mVar = new m(nVar);
        mVar.f14769e = kVar;
        mVar.f14770f = kVar;
        mVar.f14771g = kVar;
        mVar.f14772h = kVar;
        iVar.setShapeAppearanceModel(new n(mVar));
        this.f3951z.k(ColorStateList.valueOf(-1));
        i iVar2 = this.f3951z;
        WeakHashMap weakHashMap = c1.f10054a;
        i0.q(this, iVar2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.B, R.attr.materialClockStyle, 0);
        this.f3950y = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
    }

    public final void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        if (view.getId() == -1) {
            WeakHashMap weakHashMap = c1.f10054a;
            view.setId(j0.a());
        }
        Handler handler = getHandler();
        if (handler != null) {
            e eVar = this.f3949x;
            handler.removeCallbacks(eVar);
            handler.post(eVar);
        }
    }

    public abstract void l();

    public final void onFinishInflate() {
        super.onFinishInflate();
        l();
    }

    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            e eVar = this.f3949x;
            handler.removeCallbacks(eVar);
            handler.post(eVar);
        }
    }

    public final void setBackgroundColor(int i10) {
        this.f3951z.k(ColorStateList.valueOf(i10));
    }
}
