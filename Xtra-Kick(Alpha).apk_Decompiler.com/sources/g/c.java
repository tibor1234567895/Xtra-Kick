package g;

import android.view.View;
import androidx.media3.ui.TrackSelectionView;

public final class c implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6051h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f6052i;

    public /* synthetic */ c(int i10, Object obj) {
        this.f6051h = i10;
        this.f6052i = obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.os.Message} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: m.q} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v23 */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ce, code lost:
        if (r6 != false) goto L_0x00d0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r10) {
        /*
            r9 = this;
            r0 = 0
            int r1 = r9.f6051h
            r2 = 0
            r3 = 1
            java.lang.Object r4 = r9.f6052i
            switch(r1) {
                case 0: goto L_0x0120;
                case 1: goto L_0x0111;
                case 2: goto L_0x0055;
                case 3: goto L_0x004f;
                case 4: goto L_0x001d;
                case 5: goto L_0x000c;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0151
        L_0x000c:
            com.google.android.material.datepicker.n r4 = (com.google.android.material.datepicker.n) r4
            int r10 = r4.f3772i0
            r0 = 2
            if (r10 != r0) goto L_0x0017
            r4.n0(r3)
            goto L_0x001c
        L_0x0017:
            if (r10 != r3) goto L_0x001c
            r4.n0(r0)
        L_0x001c:
            return
        L_0x001d:
            b8.h r4 = (b8.h) r4
            boolean r10 = r4.f2683p
            if (r10 == 0) goto L_0x004e
            boolean r10 = r4.isShowing()
            if (r10 == 0) goto L_0x004e
            boolean r10 = r4.f2685r
            if (r10 != 0) goto L_0x0047
            android.content.Context r10 = r4.getContext()
            int[] r0 = new int[r3]
            r1 = 16843611(0x101035b, float:2.3695965E-38)
            r0[r2] = r1
            android.content.res.TypedArray r10 = r10.obtainStyledAttributes(r0)
            boolean r0 = r10.getBoolean(r2, r3)
            r4.f2684q = r0
            r10.recycle()
            r4.f2685r = r3
        L_0x0047:
            boolean r10 = r4.f2684q
            if (r10 == 0) goto L_0x004e
            r4.cancel()
        L_0x004e:
            return
        L_0x004f:
            androidx.preference.Preference r4 = (androidx.preference.Preference) r4
            r4.s(r10)
            return
        L_0x0055:
            androidx.media3.ui.TrackSelectionView r4 = (androidx.media3.ui.TrackSelectionView) r4
            android.widget.CheckedTextView r0 = r4.f1859j
            java.util.HashMap r1 = r4.f1863n
            if (r10 != r0) goto L_0x0064
            r4.f1868s = r3
            r1.clear()
            goto L_0x010d
        L_0x0064:
            android.widget.CheckedTextView r0 = r4.f1860k
            if (r10 != r0) goto L_0x006f
            r4.f1868s = r2
            r1.clear()
            goto L_0x010d
        L_0x006f:
            r4.f1868s = r2
            java.lang.Object r0 = r10.getTag()
            r0.getClass()
            i3.q0 r0 = (i3.q0) r0
            g1.z1 r5 = r0.f8157a
            g1.v1 r5 = r5.f6778i
            java.lang.Object r6 = r1.get(r5)
            g1.w1 r6 = (g1.w1) r6
            int r7 = r0.f8158b
            if (r6 != 0) goto L_0x00a3
            boolean r10 = r4.f1865p
            if (r10 != 0) goto L_0x0095
            int r10 = r1.size()
            if (r10 <= 0) goto L_0x0095
            r1.clear()
        L_0x0095:
            g1.w1 r10 = new g1.w1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
            d9.r1 r0 = d9.r0.n(r0)
            r10.<init>((g1.v1) r5, (java.util.List) r0)
            goto L_0x010a
        L_0x00a3:
            java.util.ArrayList r8 = new java.util.ArrayList
            d9.r0 r6 = r6.f6687i
            r8.<init>(r6)
            android.widget.CheckedTextView r10 = (android.widget.CheckedTextView) r10
            boolean r10 = r10.isChecked()
            boolean r6 = r4.f1864o
            if (r6 == 0) goto L_0x00bc
            g1.z1 r0 = r0.f8157a
            boolean r0 = r0.f6779j
            if (r0 == 0) goto L_0x00bc
            r0 = 1
            goto L_0x00bd
        L_0x00bc:
            r0 = 0
        L_0x00bd:
            if (r0 != 0) goto L_0x00d0
            boolean r6 = r4.f1865p
            if (r6 == 0) goto L_0x00cd
            java.util.ArrayList r6 = r4.f1862m
            int r6 = r6.size()
            if (r6 <= r3) goto L_0x00cd
            r6 = 1
            goto L_0x00ce
        L_0x00cd:
            r6 = 0
        L_0x00ce:
            if (r6 == 0) goto L_0x00d1
        L_0x00d0:
            r2 = 1
        L_0x00d1:
            if (r10 == 0) goto L_0x00ec
            if (r2 == 0) goto L_0x00ec
            java.lang.Integer r10 = java.lang.Integer.valueOf(r7)
            r8.remove(r10)
            boolean r10 = r8.isEmpty()
            if (r10 == 0) goto L_0x00e6
            r1.remove(r5)
            goto L_0x010d
        L_0x00e6:
            g1.w1 r10 = new g1.w1
            r10.<init>((g1.v1) r5, (java.util.List) r8)
            goto L_0x010a
        L_0x00ec:
            if (r10 != 0) goto L_0x010d
            if (r0 == 0) goto L_0x00fd
            java.lang.Integer r10 = java.lang.Integer.valueOf(r7)
            r8.add(r10)
            g1.w1 r10 = new g1.w1
            r10.<init>((g1.v1) r5, (java.util.List) r8)
            goto L_0x010a
        L_0x00fd:
            g1.w1 r10 = new g1.w1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
            d9.r1 r0 = d9.r0.n(r0)
            r10.<init>((g1.v1) r5, (java.util.List) r0)
        L_0x010a:
            r1.put(r5, r10)
        L_0x010d:
            r4.a()
            return
        L_0x0111:
            androidx.appcompat.widget.Toolbar r4 = (androidx.appcompat.widget.Toolbar) r4
            androidx.appcompat.widget.y4 r10 = r4.S
            if (r10 != 0) goto L_0x0118
            goto L_0x011a
        L_0x0118:
            m.q r0 = r10.f1134i
        L_0x011a:
            if (r0 == 0) goto L_0x011f
            r0.collapseActionView()
        L_0x011f:
            return
        L_0x0120:
            g.k r4 = (g.k) r4
            android.widget.Button r1 = r4.f6131k
            if (r10 != r1) goto L_0x012b
            android.os.Message r1 = r4.f6133m
            if (r1 == 0) goto L_0x012b
            goto L_0x013c
        L_0x012b:
            android.widget.Button r1 = r4.f6135o
            if (r10 != r1) goto L_0x0134
            android.os.Message r1 = r4.f6137q
            if (r1 == 0) goto L_0x0134
            goto L_0x013c
        L_0x0134:
            android.widget.Button r1 = r4.f6139s
            if (r10 != r1) goto L_0x0140
            android.os.Message r1 = r4.f6141u
            if (r1 == 0) goto L_0x0140
        L_0x013c:
            android.os.Message r0 = android.os.Message.obtain(r1)
        L_0x0140:
            if (r0 == 0) goto L_0x0145
            r0.sendToTarget()
        L_0x0145:
            android.support.v4.media.session.w r10 = r4.L
            g.m0 r0 = r4.f6122b
            android.os.Message r10 = r10.obtainMessage(r3, r0)
            r10.sendToTarget()
            return
        L_0x0151:
            o8.d r10 = (o8.d) r10
            m.q r10 = r10.getItemData()
            o8.f r4 = (o8.f) r4
            m.o r0 = r4.J
            o8.i r1 = r4.I
            boolean r0 = r0.q(r10, r1, r2)
            if (r0 != 0) goto L_0x0166
            r10.setChecked(r3)
        L_0x0166:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g.c.onClick(android.view.View):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(TrackSelectionView trackSelectionView) {
        this(2, trackSelectionView);
        this.f6051h = 2;
    }
}
