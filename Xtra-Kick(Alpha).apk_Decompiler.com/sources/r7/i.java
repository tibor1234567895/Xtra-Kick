package r7;

import android.content.Context;
import android.widget.ArrayAdapter;
import androidx.fragment.app.c0;
import com.github.andreyasadchy.xtra.model.chat.Emote;
import java.util.ArrayList;
import xa.j;

public final class i extends ArrayAdapter {

    /* renamed from: h  reason: collision with root package name */
    public final c0 f13850h;

    /* renamed from: i  reason: collision with root package name */
    public final String f13851i;

    static {
        new g(0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(Context context, c0 c0Var, ArrayList arrayList, String str) {
        super(context, 0, arrayList);
        j.f("list", arrayList);
        this.f13850h = c0Var;
        this.f13851i = str;
    }

    public final int getItemViewType(int i10) {
        return (getItem(i10) instanceof Emote) ^ true ? 1 : 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: r7.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v27, resolved type: r7.h} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0072, code lost:
        if (r10 != null) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0088, code lost:
        if (r10 == null) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0098, code lost:
        if (r10 == null) goto L_0x009d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r9, android.view.View r10, android.view.ViewGroup r11) {
        /*
            r8 = this;
            java.lang.String r0 = "parent"
            xa.j.f(r0, r11)
            java.lang.Object r0 = r8.getItem(r9)
            xa.j.c(r0)
            int r9 = r8.getItemViewType(r9)
            java.lang.String r1 = "view"
            r2 = 0
            java.lang.String r3 = "null cannot be cast to non-null type com.github.andreyasadchy.xtra.ui.view.chat.ChatView.AutoCompleteAdapter.ViewHolder"
            if (r9 != 0) goto L_0x00c4
            if (r10 != 0) goto L_0x0034
            android.content.Context r9 = r8.getContext()
            android.view.LayoutInflater r9 = android.view.LayoutInflater.from(r9)
            r10 = 2131558431(0x7f0d001f, float:1.8742178E38)
            android.view.View r9 = r9.inflate(r10, r11, r2)
            r7.h r10 = new r7.h
            xa.j.e(r1, r9)
            r10.<init>(r9)
            r9.setTag(r10)
            goto L_0x003e
        L_0x0034:
            java.lang.Object r9 = r10.getTag()
            xa.j.d(r3, r9)
            r10 = r9
            r7.h r10 = (r7.h) r10
        L_0x003e:
            com.github.andreyasadchy.xtra.model.chat.Emote r0 = (com.github.andreyasadchy.xtra.model.chat.Emote) r0
            android.view.View r9 = r10.f13849a
            r10 = 2131362157(0x7f0a016d, float:1.8344087E38)
            android.view.View r10 = r9.findViewById(r10)
            r1 = r10
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x00b0
            androidx.fragment.app.c0 r2 = r8.f13850h
            java.lang.String r10 = r8.f13851i
            int r11 = r10.hashCode()
            switch(r11) {
                case 50: goto L_0x008b;
                case 51: goto L_0x0075;
                case 52: goto L_0x005a;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x009d
        L_0x005a:
            java.lang.String r11 = "4"
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x009d
            java.lang.String r10 = r0.getUrl4x()
            if (r10 != 0) goto L_0x009b
            java.lang.String r10 = r0.getUrl3x()
            if (r10 != 0) goto L_0x009b
            java.lang.String r10 = r0.getUrl2x()
            if (r10 != 0) goto L_0x009b
            goto L_0x009d
        L_0x0075:
            java.lang.String r11 = "3"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x007e
            goto L_0x009d
        L_0x007e:
            java.lang.String r10 = r0.getUrl3x()
            if (r10 != 0) goto L_0x009b
            java.lang.String r10 = r0.getUrl2x()
            if (r10 != 0) goto L_0x009b
            goto L_0x009d
        L_0x008b:
            java.lang.String r11 = "2"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x0094
            goto L_0x009d
        L_0x0094:
            java.lang.String r10 = r0.getUrl2x()
            if (r10 != 0) goto L_0x009b
            goto L_0x009d
        L_0x009b:
            r3 = r10
            goto L_0x00a2
        L_0x009d:
            java.lang.String r10 = r0.getUrl1x()
            goto L_0x009b
        L_0x00a2:
            r4 = 0
            r5 = 0
            d5.r r6 = d5.u.f4492b
            java.lang.String r10 = "DATA"
            xa.j.e(r10, r6)
            r7 = 12
            hb.h0.c1(r1, r2, r3, r4, r5, r6, r7)
        L_0x00b0:
            r10 = 2131362274(0x7f0a01e2, float:1.8344324E38)
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 != 0) goto L_0x00bc
            goto L_0x00fe
        L_0x00bc:
            java.lang.String r11 = r0.getName()
            r10.setText(r11)
            goto L_0x00fe
        L_0x00c4:
            if (r10 != 0) goto L_0x00e1
            android.content.Context r9 = r8.getContext()
            android.view.LayoutInflater r9 = android.view.LayoutInflater.from(r9)
            r10 = 17367043(0x1090003, float:2.5162934E-38)
            android.view.View r9 = r9.inflate(r10, r11, r2)
            r7.h r10 = new r7.h
            xa.j.e(r1, r9)
            r10.<init>(r9)
            r9.setTag(r10)
            goto L_0x00eb
        L_0x00e1:
            java.lang.Object r9 = r10.getTag()
            xa.j.d(r3, r9)
            r10 = r9
            r7.h r10 = (r7.h) r10
        L_0x00eb:
            java.lang.String r9 = "null cannot be cast to non-null type android.widget.TextView"
            android.view.View r10 = r10.f13849a
            xa.j.d(r9, r10)
            r9 = r10
            android.widget.TextView r9 = (android.widget.TextView) r9
            com.github.andreyasadchy.xtra.model.chat.Chatter r0 = (com.github.andreyasadchy.xtra.model.chat.Chatter) r0
            java.lang.String r10 = r0.getName()
            r9.setText(r10)
        L_0x00fe:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: r7.i.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public final int getViewTypeCount() {
        return 2;
    }
}
