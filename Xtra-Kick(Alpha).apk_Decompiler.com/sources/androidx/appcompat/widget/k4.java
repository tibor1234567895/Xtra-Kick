package androidx.appcompat.widget;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.widget.SearchView;

public final class k4 extends TouchDelegate {

    /* renamed from: a  reason: collision with root package name */
    public final View f913a;

    /* renamed from: b  reason: collision with root package name */
    public final Rect f914b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f915c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f916d;

    /* renamed from: e  reason: collision with root package name */
    public final int f917e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f918f;

    public k4(Rect rect, Rect rect2, SearchView.SearchAutoComplete searchAutoComplete) {
        super(rect, searchAutoComplete);
        int scaledTouchSlop = ViewConfiguration.get(searchAutoComplete.getContext()).getScaledTouchSlop();
        this.f917e = scaledTouchSlop;
        Rect rect3 = new Rect();
        this.f914b = rect3;
        Rect rect4 = new Rect();
        this.f916d = rect4;
        Rect rect5 = new Rect();
        this.f915c = rect5;
        rect3.set(rect);
        rect4.set(rect);
        int i10 = -scaledTouchSlop;
        rect4.inset(i10, i10);
        rect5.set(rect2);
        this.f913a = searchAutoComplete;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            float r0 = r8.getX()
            int r0 = (int) r0
            float r1 = r8.getY()
            int r1 = (int) r1
            int r2 = r8.getAction()
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 == r5) goto L_0x0020
            if (r2 == r3) goto L_0x0020
            r6 = 3
            if (r2 == r6) goto L_0x001b
            goto L_0x003d
        L_0x001b:
            boolean r2 = r7.f918f
            r7.f918f = r4
            goto L_0x002f
        L_0x0020:
            boolean r2 = r7.f918f
            if (r2 == 0) goto L_0x002f
            android.graphics.Rect r6 = r7.f916d
            boolean r6 = r6.contains(r0, r1)
            if (r6 != 0) goto L_0x002f
            r5 = r2
            r2 = 0
            goto L_0x003f
        L_0x002f:
            r5 = r2
        L_0x0030:
            r2 = 1
            goto L_0x003f
        L_0x0032:
            android.graphics.Rect r2 = r7.f914b
            boolean r2 = r2.contains(r0, r1)
            if (r2 == 0) goto L_0x003d
            r7.f918f = r5
            goto L_0x0030
        L_0x003d:
            r2 = 1
            r5 = 0
        L_0x003f:
            if (r5 == 0) goto L_0x0068
            android.graphics.Rect r4 = r7.f915c
            android.view.View r5 = r7.f913a
            if (r2 == 0) goto L_0x0059
            boolean r2 = r4.contains(r0, r1)
            if (r2 != 0) goto L_0x0059
            int r0 = r5.getWidth()
            int r0 = r0 / r3
            float r0 = (float) r0
            int r1 = r5.getHeight()
            int r1 = r1 / r3
            goto L_0x0060
        L_0x0059:
            int r2 = r4.left
            int r0 = r0 - r2
            float r0 = (float) r0
            int r2 = r4.top
            int r1 = r1 - r2
        L_0x0060:
            float r1 = (float) r1
            r8.setLocation(r0, r1)
            boolean r4 = r5.dispatchTouchEvent(r8)
        L_0x0068:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.k4.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
