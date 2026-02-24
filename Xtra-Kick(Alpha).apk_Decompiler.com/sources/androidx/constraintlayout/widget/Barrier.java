package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import u.a;
import x.b;
import x.p;

public class Barrier extends b {

    /* renamed from: o  reason: collision with root package name */
    public int f1165o;

    /* renamed from: p  reason: collision with root package name */
    public int f1166p;

    /* renamed from: q  reason: collision with root package name */
    public a f1167q;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public final void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        this.f1167q = new a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, p.f16499b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == 26) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == 25) {
                    this.f1167q.f15042u0 = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 27) {
                    this.f1167q.f15043v0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f16350k = this.f1167q;
        i();
    }

    public boolean getAllowsGoneWidget() {
        return this.f1167q.f15042u0;
    }

    public int getMargin() {
        return this.f1167q.f15043v0;
    }

    public int getType() {
        return this.f1165o;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        if (r0 == 6) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r0 == 6) goto L_0x0014;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(u.f r4, boolean r5) {
        /*
            r3 = this;
            int r0 = r3.f1165o
            r3.f1166p = r0
            r1 = 6
            r2 = 5
            if (r5 == 0) goto L_0x000e
            if (r0 != r2) goto L_0x000b
            goto L_0x0014
        L_0x000b:
            if (r0 != r1) goto L_0x0017
            goto L_0x0010
        L_0x000e:
            if (r0 != r2) goto L_0x0012
        L_0x0010:
            r5 = 0
            goto L_0x0015
        L_0x0012:
            if (r0 != r1) goto L_0x0017
        L_0x0014:
            r5 = 1
        L_0x0015:
            r3.f1166p = r5
        L_0x0017:
            boolean r5 = r4 instanceof u.a
            if (r5 == 0) goto L_0x0021
            u.a r4 = (u.a) r4
            int r5 = r3.f1166p
            r4.f15041t0 = r5
        L_0x0021:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.Barrier.h(u.f, boolean):void");
    }

    public void setAllowsGoneWidget(boolean z10) {
        this.f1167q.f15042u0 = z10;
    }

    public void setDpMargin(int i10) {
        this.f1167q.f15043v0 = (int) ((((float) i10) * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i10) {
        this.f1167q.f15043v0 = i10;
    }

    public void setType(int i10) {
        this.f1165o = i10;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
