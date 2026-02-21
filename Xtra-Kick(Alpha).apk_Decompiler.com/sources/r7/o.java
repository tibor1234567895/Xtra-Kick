package r7;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.c0;
import androidx.recyclerview.widget.k2;
import androidx.recyclerview.widget.w0;
import com.woxthebox.draglistview.R;
import n3.o3;
import wa.l;
import xa.j;

public final class o extends w0 {

    /* renamed from: b  reason: collision with root package name */
    public final c0 f13855b;

    /* renamed from: c  reason: collision with root package name */
    public final l f13856c;

    /* renamed from: d  reason: collision with root package name */
    public final String f13857d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(c0 c0Var, o3 o3Var, String str) {
        super(new m());
        j.f("fragment", c0Var);
        this.f13855b = c0Var;
        this.f13856c = o3Var;
        this.f13857d = str;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        if (r0 == null) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0062, code lost:
        if (r0 == null) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
        if (r0 != null) goto L_0x0065;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.k2 r9, int r10) {
        /*
            r8 = this;
            java.lang.String r0 = "holder"
            xa.j.f(r0, r9)
            androidx.recyclerview.widget.h r0 = r8.f2224a
            java.util.List r0 = r0.f2038f
            java.lang.Object r10 = r0.get(r10)
            com.github.andreyasadchy.xtra.model.chat.Emote r10 = (com.github.andreyasadchy.xtra.model.chat.Emote) r10
            android.view.View r9 = r9.itemView
            java.lang.String r0 = "null cannot be cast to non-null type android.widget.ImageView"
            xa.j.d(r0, r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            androidx.fragment.app.c0 r2 = r8.f13855b
            java.lang.String r0 = r8.f13857d
            int r1 = r0.hashCode()
            switch(r1) {
                case 50: goto L_0x0055;
                case 51: goto L_0x003f;
                case 52: goto L_0x0024;
                default: goto L_0x0023;
            }
        L_0x0023:
            goto L_0x0067
        L_0x0024:
            java.lang.String r1 = "4"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0067
            java.lang.String r0 = r10.getUrl4x()
            if (r0 != 0) goto L_0x0065
            java.lang.String r0 = r10.getUrl3x()
            if (r0 != 0) goto L_0x0065
            java.lang.String r0 = r10.getUrl2x()
            if (r0 != 0) goto L_0x0065
            goto L_0x0067
        L_0x003f:
            java.lang.String r1 = "3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0048
            goto L_0x0067
        L_0x0048:
            java.lang.String r0 = r10.getUrl3x()
            if (r0 != 0) goto L_0x0065
            java.lang.String r0 = r10.getUrl2x()
            if (r0 != 0) goto L_0x0065
            goto L_0x0067
        L_0x0055:
            java.lang.String r1 = "2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x005e
            goto L_0x0067
        L_0x005e:
            java.lang.String r0 = r10.getUrl2x()
            if (r0 != 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r3 = r0
            goto L_0x006c
        L_0x0067:
            java.lang.String r0 = r10.getUrl1x()
            goto L_0x0065
        L_0x006c:
            r4 = 0
            r5 = 0
            d5.r r6 = d5.u.f4492b
            java.lang.String r0 = "DATA"
            xa.j.e(r0, r6)
            r7 = 12
            r1 = r9
            hb.h0.c1(r1, r2, r3, r4, r5, r6, r7)
            h6.b r0 = new h6.b
            r1 = 20
            r0.<init>(r8, r1, r10)
            r9.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r7.o.onBindViewHolder(androidx.recyclerview.widget.k2, int):void");
    }

    public final k2 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        j.f("parent", viewGroup);
        return new n(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_emotes_list_item, viewGroup, false));
    }
}
