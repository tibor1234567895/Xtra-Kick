package i3;

public final /* synthetic */ class x implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8224h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ c0 f8225i;

    public /* synthetic */ x(c0 c0Var, int i10) {
        this.f8224h = i10;
        this.f8225i = c0Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r11 = this;
            int r0 = r11.f8224h
            r1 = 1
            r2 = 0
            i3.c0 r3 = r11.f8225i
            switch(r0) {
                case 0: goto L_0x00c6;
                case 1: goto L_0x00c0;
                case 2: goto L_0x00ba;
                case 3: goto L_0x00ad;
                case 4: goto L_0x00a8;
                case 5: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x00ca
        L_0x000b:
            android.view.ViewGroup r0 = r3.f8042e
            r4 = 4
            if (r0 == 0) goto L_0x001a
            boolean r5 = r3.A
            if (r5 == 0) goto L_0x0016
            r5 = 0
            goto L_0x0017
        L_0x0016:
            r5 = 4
        L_0x0017:
            r0.setVisibility(r5)
        L_0x001a:
            android.view.View r0 = r3.f8047j
            if (r0 == 0) goto L_0x0084
            i3.w r5 = r3.f8038a
            android.content.res.Resources r5 = r5.getResources()
            r6 = 2131165362(0x7f0700b2, float:1.7944939E38)
            int r5 = r5.getDimensionPixelSize(r6)
            android.view.ViewGroup$LayoutParams r6 = r0.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            if (r6 == 0) goto L_0x003d
            boolean r7 = r3.A
            if (r7 == 0) goto L_0x0038
            r5 = 0
        L_0x0038:
            r6.bottomMargin = r5
            r0.setLayoutParams(r6)
        L_0x003d:
            boolean r5 = r0 instanceof androidx.media3.ui.DefaultTimeBar
            if (r5 == 0) goto L_0x0084
            androidx.media3.ui.DefaultTimeBar r0 = (androidx.media3.ui.DefaultTimeBar) r0
            boolean r5 = r3.A
            r6 = 0
            android.graphics.Rect r7 = r0.f1828h
            android.animation.ValueAnimator r8 = r0.L
            if (r5 == 0) goto L_0x005d
            boolean r5 = r8.isStarted()
            if (r5 == 0) goto L_0x0055
            r8.cancel()
        L_0x0055:
            r0.N = r1
        L_0x0057:
            r0.M = r6
            r0.invalidate(r7)
            goto L_0x0084
        L_0x005d:
            int r5 = r3.f8063z
            if (r5 != r1) goto L_0x006d
            boolean r1 = r8.isStarted()
            if (r1 == 0) goto L_0x006a
            r8.cancel()
        L_0x006a:
            r0.N = r2
            goto L_0x0057
        L_0x006d:
            r1 = 3
            if (r5 == r1) goto L_0x0084
            boolean r1 = r8.isStarted()
            if (r1 == 0) goto L_0x0079
            r8.cancel()
        L_0x0079:
            r0.N = r2
            r1 = 1065353216(0x3f800000, float:1.0)
            r0.M = r1
            android.graphics.Rect r1 = r0.f1828h
            r0.invalidate(r1)
        L_0x0084:
            java.util.ArrayList r0 = r3.f8062y
            java.util.Iterator r0 = r0.iterator()
        L_0x008a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00a7
            java.lang.Object r1 = r0.next()
            android.view.View r1 = (android.view.View) r1
            boolean r5 = r3.A
            if (r5 == 0) goto L_0x00a2
            boolean r5 = i3.c0.k(r1)
            if (r5 == 0) goto L_0x00a2
            r5 = 4
            goto L_0x00a3
        L_0x00a2:
            r5 = 0
        L_0x00a3:
            r1.setVisibility(r5)
            goto L_0x008a
        L_0x00a7:
            return
        L_0x00a8:
            r0 = 2
            r3.j(r0)
            return
        L_0x00ad:
            android.animation.AnimatorSet r0 = r3.f8049l
            r0.start()
            i3.x r0 = r3.f8058u
            r1 = 2000(0x7d0, double:9.88E-321)
            r3.f(r0, r1)
            return
        L_0x00ba:
            android.animation.AnimatorSet r0 = r3.f8050m
            r0.start()
            return
        L_0x00c0:
            android.animation.AnimatorSet r0 = r3.f8051n
            r0.start()
            return
        L_0x00c6:
            r3.l()
            return
        L_0x00ca:
            android.view.ViewGroup r0 = r3.f8043f
            if (r0 == 0) goto L_0x0182
            android.view.ViewGroup r4 = r3.f8044g
            if (r4 != 0) goto L_0x00d4
            goto L_0x0182
        L_0x00d4:
            i3.w r5 = r3.f8038a
            int r6 = r5.getWidth()
            int r7 = r5.getPaddingLeft()
            int r6 = r6 - r7
            int r5 = r5.getPaddingRight()
            int r6 = r6 - r5
        L_0x00e4:
            int r5 = r4.getChildCount()
            if (r5 <= r1) goto L_0x00fb
            int r5 = r4.getChildCount()
            int r5 = r5 + -2
            android.view.View r7 = r4.getChildAt(r5)
            r4.removeViewAt(r5)
            r0.addView(r7, r2)
            goto L_0x00e4
        L_0x00fb:
            android.view.View r5 = r3.f8048k
            if (r5 == 0) goto L_0x0104
            r7 = 8
            r5.setVisibility(r7)
        L_0x0104:
            android.view.ViewGroup r7 = r3.f8046i
            int r7 = i3.c0.d(r7)
            int r8 = r0.getChildCount()
            int r8 = r8 - r1
            r9 = 0
        L_0x0110:
            if (r9 >= r8) goto L_0x011e
            android.view.View r10 = r0.getChildAt(r9)
            int r10 = i3.c0.d(r10)
            int r7 = r7 + r10
            int r9 = r9 + 1
            goto L_0x0110
        L_0x011e:
            if (r7 <= r6) goto L_0x0168
            if (r5 == 0) goto L_0x012a
            r5.setVisibility(r2)
            int r3 = i3.c0.d(r5)
            int r7 = r7 + r3
        L_0x012a:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r5 = 0
        L_0x0130:
            if (r5 >= r8) goto L_0x0144
            android.view.View r9 = r0.getChildAt(r5)
            int r10 = i3.c0.d(r9)
            int r7 = r7 - r10
            r3.add(r9)
            if (r7 > r6) goto L_0x0141
            goto L_0x0144
        L_0x0141:
            int r5 = r5 + 1
            goto L_0x0130
        L_0x0144:
            boolean r5 = r3.isEmpty()
            if (r5 != 0) goto L_0x0182
            int r5 = r3.size()
            r0.removeViews(r2, r5)
        L_0x0151:
            int r0 = r3.size()
            if (r2 >= r0) goto L_0x0182
            int r0 = r4.getChildCount()
            int r0 = r0 - r1
            java.lang.Object r5 = r3.get(r2)
            android.view.View r5 = (android.view.View) r5
            r4.addView(r5, r0)
            int r2 = r2 + 1
            goto L_0x0151
        L_0x0168:
            android.view.ViewGroup r0 = r3.f8045h
            if (r0 == 0) goto L_0x0182
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0182
            android.animation.ValueAnimator r0 = r3.f8055r
            boolean r1 = r0.isStarted()
            if (r1 != 0) goto L_0x0182
            android.animation.ValueAnimator r1 = r3.f8054q
            r1.cancel()
            r0.start()
        L_0x0182:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.x.run():void");
    }
}
