package e7;

import android.os.Bundle;
import androidx.fragment.app.j1;
import com.github.andreyasadchy.xtra.ui.search.tags.TagSearchFragment;
import com.github.andreyasadchy.xtra.ui.view.chat.ChatView;
import com.woxthebox.draglistview.R;
import g1.u1;
import h3.d2;
import h3.m2;
import h3.n1;
import i7.c;
import n0.d;
import n0.x;
import x8.h;
import x8.k;
import xa.j;

public final /* synthetic */ class b implements j1, k, d, n1, m2, x {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f5294h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f5295i;

    public /* synthetic */ b(int i10, Object obj) {
        this.f5294h = i10;
        this.f5295i = obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(android.view.View r6) {
        /*
            r5 = this;
            java.lang.Object r6 = r5.f5295i
            com.google.android.material.sidesheet.SideSheetBehavior r6 = (com.google.android.material.sidesheet.SideSheetBehavior) r6
            r6.getClass()
            r0 = 1
            int r1 = r5.f5294h
            if (r1 == r0) goto L_0x004e
            r2 = 2
            if (r1 != r2) goto L_0x0010
            goto L_0x004e
        L_0x0010:
            java.lang.ref.WeakReference r2 = r6.f3849o
            if (r2 == 0) goto L_0x004a
            java.lang.Object r2 = r2.get()
            if (r2 != 0) goto L_0x001b
            goto L_0x004a
        L_0x001b:
            java.lang.ref.WeakReference r2 = r6.f3849o
            java.lang.Object r2 = r2.get()
            android.view.View r2 = (android.view.View) r2
            d0.o r3 = new d0.o
            r4 = 3
            r3.<init>(r6, r1, r4)
            android.view.ViewParent r6 = r2.getParent()
            if (r6 == 0) goto L_0x003f
            boolean r6 = r6.isLayoutRequested()
            if (r6 == 0) goto L_0x003f
            java.util.WeakHashMap r6 = m0.c1.f10054a
            boolean r6 = m0.l0.b(r2)
            if (r6 == 0) goto L_0x003f
            r6 = 1
            goto L_0x0040
        L_0x003f:
            r6 = 0
        L_0x0040:
            if (r6 == 0) goto L_0x0046
            r2.post(r3)
            goto L_0x004d
        L_0x0046:
            r3.run()
            goto L_0x004d
        L_0x004a:
            r6.s(r1)
        L_0x004d:
            return r0
        L_0x004e:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "STATE_"
            r2.<init>(r3)
            if (r1 != r0) goto L_0x005c
            java.lang.String r0 = "DRAGGING"
            goto L_0x005e
        L_0x005c:
            java.lang.String r0 = "SETTLING"
        L_0x005e:
            java.lang.String r1 = " should not be set externally."
            java.lang.String r0 = android.support.v4.media.h.p(r2, r0, r1)
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: e7.b.b(android.view.View):boolean");
    }

    public void e(h hVar, int i10) {
        String str;
        ChatView chatView = (ChatView) this.f5295i;
        int i11 = ChatView.I;
        j.f("this$0", chatView);
        if (i10 == 0) {
            str = chatView.getContext().getString(R.string.recent_emotes);
        } else if (i10 != 1) {
            str = "7TV/BTTV/FFZ";
        } else {
            str = "Twitch";
        }
        hVar.a(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        if (r6.f7078h.contains(r5) == false) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(h3.y0 r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f5295i
            java.util.List r0 = (java.util.List) r0
            boolean r1 = r8.H0()
            if (r1 != 0) goto L_0x000b
            goto L_0x0077
        L_0x000b:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            r3 = 0
        L_0x0012:
            int r4 = r0.size()
            if (r3 >= r4) goto L_0x004c
            java.lang.Object r4 = r0.get(r3)
            h3.d r4 = (h3.d) r4
            g1.g1 r5 = r8.f7470r
            int r6 = r4.f6972i
            boolean r5 = r5.i(r6)
            if (r5 != 0) goto L_0x0046
            h3.f4 r5 = r4.f6971h
            if (r5 == 0) goto L_0x0039
            h3.h4 r6 = r8.f7467o
            r6.getClass()
            d9.u0 r6 = r6.f7078h
            boolean r5 = r6.contains(r5)
            if (r5 != 0) goto L_0x0046
        L_0x0039:
            r5 = -1
            int r6 = r4.f6972i
            if (r6 == r5) goto L_0x0049
            h3.h4 r5 = r8.f7467o
            boolean r5 = r5.i(r6)
            if (r5 == 0) goto L_0x0049
        L_0x0046:
            r1.add(r4)
        L_0x0049:
            int r3 = r3 + 1
            goto L_0x0012
        L_0x004c:
            h3.b0 r0 = r8.f7453a
            r0.getClass()
            android.os.Looper r3 = android.os.Looper.myLooper()
            android.os.Looper r4 = r0.N0()
            if (r3 != r4) goto L_0x005c
            r2 = 1
        L_0x005c:
            j1.a.e(r2)
            h3.z r0 = r0.f6925d
            h9.a0 r0 = r0.w(r1)
            java.lang.String r1 = "MediaController.Listener#onSetCustomLayout() must not return null"
            j1.a.d(r0, r1)
            j1.p r1 = new j1.p
            r2 = 3
            int r3 = r7.f5294h
            r1.<init>((java.lang.Object) r8, (java.lang.Object) r0, (int) r3, (int) r2)
            h9.q r8 = h9.q.f7765h
            r0.a(r1, r8)
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e7.b.g(h3.y0):void");
    }

    public void i(d2 d2Var, int i10) {
        d2Var.m((u1) this.f5295i);
    }

    public void j(Bundle bundle, String str) {
        int i10 = this.f5294h;
        Object obj = this.f5295i;
        switch (i10) {
            case 0:
                g gVar = (g) obj;
                int i11 = g.f5307s0;
                j.f("this$0", gVar);
                j.f("<anonymous parameter 0>", str);
                if (bundle.getBoolean("refresh")) {
                    c cVar = gVar.f5310r0;
                    if (cVar != null) {
                        cVar.b();
                        return;
                    } else {
                        j.l("pagingAdapter");
                        throw null;
                    }
                } else {
                    return;
                }
            case 1:
                TagSearchFragment tagSearchFragment = (TagSearchFragment) obj;
                int i12 = TagSearchFragment.f3484t0;
                j.f("this$0", tagSearchFragment);
                j.f("<anonymous parameter 0>", str);
                if (bundle.getBoolean("refresh")) {
                    k6.c cVar2 = tagSearchFragment.f3488s0;
                    if (cVar2 != null) {
                        cVar2.b();
                        return;
                    } else {
                        j.l("pagingAdapter");
                        throw null;
                    }
                } else {
                    return;
                }
            default:
                g7.h hVar = (g7.h) obj;
                int i13 = g7.h.f6861t0;
                j.f("this$0", hVar);
                j.f("<anonymous parameter 0>", str);
                if (bundle.getBoolean("refresh")) {
                    m7.h hVar2 = hVar.f6864s0;
                    if (hVar2 != null) {
                        hVar2.b();
                        return;
                    } else {
                        j.l("pagingAdapter");
                        throw null;
                    }
                } else {
                    return;
                }
        }
    }

    public /* synthetic */ b(Object obj, int i10) {
        this.f5295i = obj;
        this.f5294h = i10;
    }
}
