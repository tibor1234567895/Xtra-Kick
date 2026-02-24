package l6;

import androidx.recyclerview.widget.v1;

public final class v extends v1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f9674a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f9675b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f9676c;

    public /* synthetic */ v(Object obj, int i10, Object obj2) {
        this.f9674a = i10;
        this.f9675b = obj;
        this.f9676c = obj2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0040, code lost:
        if (((((float) r0) * 100.0f) / ((float) (r8.computeVerticalScrollRange() - r8.computeVerticalScrollExtent()))) > 3.0f) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView r8, int r9) {
        /*
            r7 = this;
            int r0 = r7.f9674a
            java.lang.Object r1 = r7.f9676c
            java.lang.Object r2 = r7.f9675b
            java.lang.String r3 = "recyclerView"
            r4 = 8
            r5 = 1
            r6 = 0
            switch(r0) {
                case 0: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x004b
        L_0x0010:
            xa.j.f(r3, r8)
            androidx.appcompat.widget.j3 r2 = (androidx.appcompat.widget.j3) r2
            java.lang.Object r9 = r2.f898e
            com.google.android.material.floatingactionbutton.FloatingActionButton r9 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r9
            java.lang.String r0 = "scrollTop"
            xa.j.e(r0, r9)
            l6.x r1 = (l6.x) r1
            int r0 = l6.x.f9680j0
            r1.getClass()
            int r0 = r8.computeVerticalScrollOffset()
            if (r0 >= 0) goto L_0x002c
            goto L_0x0043
        L_0x002c:
            int r1 = r8.computeVerticalScrollExtent()
            int r8 = r8.computeVerticalScrollRange()
            r2 = 1120403456(0x42c80000, float:100.0)
            float r0 = (float) r0
            float r0 = r0 * r2
            int r8 = r8 - r1
            float r8 = (float) r8
            float r0 = r0 / r8
            r8 = 1077936128(0x40400000, float:3.0)
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x0043
            goto L_0x0044
        L_0x0043:
            r5 = 0
        L_0x0044:
            if (r5 == 0) goto L_0x0047
            r4 = 0
        L_0x0047:
            r9.setVisibility(r4)
            return
        L_0x004b:
            xa.j.f(r3, r8)
            com.github.andreyasadchy.xtra.ui.view.chat.ChatView r2 = (com.github.andreyasadchy.xtra.ui.view.chat.ChatView) r2
            if (r9 != r5) goto L_0x0054
            r8 = 1
            goto L_0x0055
        L_0x0054:
            r8 = 0
        L_0x0055:
            r2.f3553z = r8
            z5.m r1 = (z5.m) r1
            android.widget.Button r8 = r1.f17714a
            java.lang.String r9 = "btnDown"
            xa.j.e(r9, r8)
            boolean r9 = com.github.andreyasadchy.xtra.ui.view.chat.ChatView.l(r2)
            if (r9 == 0) goto L_0x0068
            r9 = 0
            goto L_0x006a
        L_0x0068:
            r9 = 8
        L_0x006a:
            r8.setVisibility(r9)
            boolean r8 = r2.A
            if (r8 == 0) goto L_0x0093
            java.lang.String r8 = "flexbox"
            com.google.android.flexbox.FlexboxLayout r9 = r1.f17719f
            xa.j.e(r8, r9)
            int r0 = r9.getVisibility()
            if (r0 != r4) goto L_0x0080
            r0 = 1
            goto L_0x0081
        L_0x0080:
            r0 = 0
        L_0x0081:
            if (r0 == 0) goto L_0x0093
            xa.j.e(r8, r9)
            r9.setVisibility(r6)
            r7.b r8 = new r7.b
            r8.<init>(r1, r5)
            r0 = 5000(0x1388, double:2.4703E-320)
            r9.postDelayed(r8, r0)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.v.onScrollStateChanged(androidx.recyclerview.widget.RecyclerView, int):void");
    }
}
