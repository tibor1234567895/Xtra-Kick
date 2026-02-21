package androidx.media3.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import i3.a;
import i3.b;
import i3.h0;

public final class AspectRatioFrameLayout extends FrameLayout {

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ int f1824k = 0;

    /* renamed from: h  reason: collision with root package name */
    public final b f1825h;

    /* renamed from: i  reason: collision with root package name */
    public float f1826i;

    /* renamed from: j  reason: collision with root package name */
    public int f1827j = 0;

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, h0.f8098a, 0, 0);
            try {
                this.f1827j = obtainStyledAttributes.getInt(0, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f1825h = new b(this);
    }

    public int getResizeMode() {
        return this.f1827j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        if (r4 > 0.0f) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        if (r4 > 0.0f) goto L_0x004d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r9, int r10) {
        /*
            r8 = this;
            super.onMeasure(r9, r10)
            float r9 = r8.f1826i
            r10 = 0
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 > 0) goto L_0x000b
            return
        L_0x000b:
            int r9 = r8.getMeasuredWidth()
            int r0 = r8.getMeasuredHeight()
            float r1 = (float) r9
            float r2 = (float) r0
            float r3 = r1 / r2
            float r4 = r8.f1826i
            float r4 = r4 / r3
            r3 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 - r3
            float r3 = java.lang.Math.abs(r4)
            r5 = 1
            r6 = 1008981770(0x3c23d70a, float:0.01)
            i3.b r7 = r8.f1825h
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 > 0) goto L_0x0037
            boolean r9 = r7.f8027h
            if (r9 != 0) goto L_0x0036
            r7.f8027h = r5
            androidx.media3.ui.AspectRatioFrameLayout r9 = r7.f8028i
            r9.post(r7)
        L_0x0036:
            return
        L_0x0037:
            int r3 = r8.f1827j
            if (r3 == 0) goto L_0x0049
            if (r3 == r5) goto L_0x004d
            r6 = 2
            if (r3 == r6) goto L_0x0052
            r6 = 4
            if (r3 == r6) goto L_0x0044
            goto L_0x0057
        L_0x0044:
            int r10 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r10 <= 0) goto L_0x004d
            goto L_0x0052
        L_0x0049:
            int r10 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r10 <= 0) goto L_0x0052
        L_0x004d:
            float r10 = r8.f1826i
            float r1 = r1 / r10
            int r0 = (int) r1
            goto L_0x0057
        L_0x0052:
            float r9 = r8.f1826i
            float r2 = r2 * r9
            int r9 = (int) r2
        L_0x0057:
            boolean r10 = r7.f8027h
            if (r10 != 0) goto L_0x0062
            r7.f8027h = r5
            androidx.media3.ui.AspectRatioFrameLayout r10 = r7.f8028i
            r10.post(r7)
        L_0x0062:
            r10 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r10)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r10)
            super.onMeasure(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.AspectRatioFrameLayout.onMeasure(int, int):void");
    }

    public void setAspectRatio(float f10) {
        if (this.f1826i != f10) {
            this.f1826i = f10;
            requestLayout();
        }
    }

    public void setAspectRatioListener(a aVar) {
    }

    public void setResizeMode(int i10) {
        if (this.f1827j != i10) {
            this.f1827j = i10;
            requestLayout();
        }
    }
}
