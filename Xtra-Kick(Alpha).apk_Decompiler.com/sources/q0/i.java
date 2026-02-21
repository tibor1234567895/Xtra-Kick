package q0;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.activity.h;

public final class i implements View.OnTouchListener {

    /* renamed from: y  reason: collision with root package name */
    public static final int f13101y = ViewConfiguration.getTapTimeout();

    /* renamed from: h  reason: collision with root package name */
    public final a f13102h;

    /* renamed from: i  reason: collision with root package name */
    public final AccelerateInterpolator f13103i = new AccelerateInterpolator();

    /* renamed from: j  reason: collision with root package name */
    public final View f13104j;

    /* renamed from: k  reason: collision with root package name */
    public h f13105k;

    /* renamed from: l  reason: collision with root package name */
    public final float[] f13106l;

    /* renamed from: m  reason: collision with root package name */
    public final float[] f13107m;

    /* renamed from: n  reason: collision with root package name */
    public int f13108n;

    /* renamed from: o  reason: collision with root package name */
    public int f13109o;

    /* renamed from: p  reason: collision with root package name */
    public final float[] f13110p;

    /* renamed from: q  reason: collision with root package name */
    public final float[] f13111q;

    /* renamed from: r  reason: collision with root package name */
    public final float[] f13112r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f13113s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f13114t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f13115u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f13116v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f13117w;

    /* renamed from: x  reason: collision with root package name */
    public final ListView f13118x;

    public i(ListView listView) {
        a aVar = new a();
        this.f13102h = aVar;
        float[] fArr = {0.0f, 0.0f};
        this.f13106l = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f13107m = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.f13110p = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.f13111q = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f13112r = fArr5;
        this.f13104j = listView;
        float f10 = Resources.getSystem().getDisplayMetrics().density;
        float f11 = ((float) ((int) ((1575.0f * f10) + 0.5f))) / 1000.0f;
        fArr5[0] = f11;
        fArr5[1] = f11;
        float f12 = ((float) ((int) ((f10 * 315.0f) + 0.5f))) / 1000.0f;
        fArr4[0] = f12;
        fArr4[1] = f12;
        this.f13108n = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.f13109o = f13101y;
        aVar.f13090a = 500;
        aVar.f13091b = 500;
        this.f13118x = listView;
    }

    public static float b(float f10, float f11, float f12) {
        return f10 > f12 ? f12 : f10 < f11 ? f11 : f10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float a(float r4, float r5, float r6, int r7) {
        /*
            r3 = this;
            float[] r0 = r3.f13106l
            r0 = r0[r7]
            float[] r1 = r3.f13107m
            r1 = r1[r7]
            float r0 = r0 * r5
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r4, r0)
            float r5 = r5 - r4
            float r4 = r3.c(r5, r0)
            float r4 = r4 - r1
            android.view.animation.AccelerateInterpolator r5 = r3.f13103i
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0026
            float r4 = -r4
            float r4 = r5.getInterpolation(r4)
            float r4 = -r4
            goto L_0x002e
        L_0x0026:
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0037
            float r4 = r5.getInterpolation(r4)
        L_0x002e:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r4 = b(r4, r5, r0)
            goto L_0x0038
        L_0x0037:
            r4 = 0
        L_0x0038:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 != 0) goto L_0x003d
            goto L_0x005c
        L_0x003d:
            float[] r0 = r3.f13110p
            r0 = r0[r7]
            float[] r1 = r3.f13111q
            r1 = r1[r7]
            float[] r2 = r3.f13112r
            r7 = r2[r7]
            float r0 = r0 * r6
            if (r5 <= 0) goto L_0x0054
            float r4 = r4 * r0
            float r2 = b(r4, r1, r7)
            goto L_0x005c
        L_0x0054:
            float r4 = -r4
            float r4 = r4 * r0
            float r4 = b(r4, r1, r7)
            float r2 = -r4
        L_0x005c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.i.a(float, float, float, int):float");
    }

    public final float c(float f10, float f11) {
        if (f11 == 0.0f) {
            return 0.0f;
        }
        int i10 = this.f13108n;
        if (i10 == 0 || i10 == 1) {
            if (f10 < f11) {
                return f10 >= 0.0f ? 1.0f - (f10 / f11) : (!this.f13116v || i10 != 1) ? 0.0f : 1.0f;
            }
            return 0.0f;
        } else if (i10 == 2 && f10 < 0.0f) {
            return f10 / (-f11);
        } else {
            return 0.0f;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x007c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.f13117w
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r8 = 3
            if (r0 == r8) goto L_0x0016
            goto L_0x007c
        L_0x0016:
            r7.e()
            goto L_0x007c
        L_0x001a:
            r7.f13115u = r2
            r7.f13113s = r1
        L_0x001e:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r7.f13104j
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r0, r3, r5, r1)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r9, r8, r3, r2)
            q0.a r9 = r7.f13102h
            r9.f13092c = r0
            r9.f13093d = r8
            boolean r8 = r7.f13116v
            if (r8 != 0) goto L_0x007c
            boolean r8 = r7.f()
            if (r8 == 0) goto L_0x007c
            androidx.activity.h r8 = r7.f13105k
            if (r8 != 0) goto L_0x0060
            androidx.activity.h r8 = new androidx.activity.h
            r9 = 4
            r8.<init>(r9, r7)
            r7.f13105k = r8
        L_0x0060:
            r7.f13116v = r2
            r7.f13114t = r2
            boolean r8 = r7.f13113s
            if (r8 != 0) goto L_0x0075
            int r8 = r7.f13109o
            if (r8 <= 0) goto L_0x0075
            androidx.activity.h r9 = r7.f13105k
            long r5 = (long) r8
            java.util.WeakHashMap r8 = m0.c1.f10054a
            m0.i0.n(r4, r9, r5)
            goto L_0x007a
        L_0x0075:
            androidx.activity.h r8 = r7.f13105k
            r8.run()
        L_0x007a:
            r7.f13113s = r2
        L_0x007c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.i.d(android.view.View, android.view.MotionEvent):boolean");
    }

    public final void e() {
        int i10 = 0;
        if (this.f13114t) {
            this.f13116v = false;
            return;
        }
        a aVar = this.f13102h;
        aVar.getClass();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i11 = (int) (currentAnimationTimeMillis - aVar.f13094e);
        int i12 = aVar.f13091b;
        if (i11 > i12) {
            i10 = i12;
        } else if (i11 >= 0) {
            i10 = i11;
        }
        aVar.f13098i = i10;
        aVar.f13097h = aVar.a(currentAnimationTimeMillis);
        aVar.f13096g = currentAnimationTimeMillis;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f() {
        /*
            r8 = this;
            q0.a r0 = r8.f13102h
            float r1 = r0.f13093d
            float r2 = java.lang.Math.abs(r1)
            float r1 = r1 / r2
            int r1 = (int) r1
            float r0 = r0.f13092c
            java.lang.Math.abs(r0)
            r0 = 0
            if (r1 == 0) goto L_0x0050
            android.widget.ListView r2 = r8.f13118x
            int r3 = r2.getCount()
            r4 = 1
            if (r3 != 0) goto L_0x001c
            goto L_0x004b
        L_0x001c:
            int r5 = r2.getChildCount()
            int r6 = r2.getFirstVisiblePosition()
            int r7 = r6 + r5
            if (r1 <= 0) goto L_0x003a
            if (r7 < r3) goto L_0x0049
            int r5 = r5 - r4
            android.view.View r1 = r2.getChildAt(r5)
            int r1 = r1.getBottom()
            int r2 = r2.getHeight()
            if (r1 > r2) goto L_0x0049
            goto L_0x004b
        L_0x003a:
            if (r1 >= 0) goto L_0x004b
            if (r6 > 0) goto L_0x0049
            android.view.View r1 = r2.getChildAt(r0)
            int r1 = r1.getTop()
            if (r1 < 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r1 = 1
            goto L_0x004c
        L_0x004b:
            r1 = 0
        L_0x004c:
            if (r1 != 0) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r0 = 1
        L_0x0050:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.i.f():boolean");
    }

    public final /* bridge */ /* synthetic */ boolean onTouch(View view, MotionEvent motionEvent) {
        d(view, motionEvent);
        return false;
    }
}
