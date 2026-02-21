package g;

import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.View;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final i f6176a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6177b;

    public l(Context context) {
        this(context, m.i(context, 0));
    }

    public final void a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        i iVar = this.f6176a;
        iVar.f6089i = charSequence;
        iVar.f6090j = onClickListener;
    }

    public final void b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        i iVar = this.f6176a;
        iVar.f6087g = charSequence;
        iVar.f6088h = onClickListener;
    }

    public final void c() {
        create().show();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: g.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: android.widget.ListAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: g.j} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: g.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: g.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v33, resolved type: g.f} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public g.m create() {
        /*
            r14 = this;
            g.m r0 = new g.m
            g.i r7 = r14.f6176a
            android.content.Context r1 = r7.f6081a
            int r2 = r14.f6177b
            r0.<init>(r1, r2)
            android.view.View r1 = r7.f6085e
            g.k r8 = r0.f6179l
            r9 = 0
            if (r1 == 0) goto L_0x0015
            r8.C = r1
            goto L_0x0036
        L_0x0015:
            java.lang.CharSequence r1 = r7.f6084d
            if (r1 == 0) goto L_0x0022
            r8.f6125e = r1
            android.widget.TextView r2 = r8.A
            if (r2 == 0) goto L_0x0022
            r2.setText(r1)
        L_0x0022:
            android.graphics.drawable.Drawable r1 = r7.f6083c
            if (r1 == 0) goto L_0x0036
            r8.f6145y = r1
            r8.f6144x = r9
            android.widget.ImageView r2 = r8.f6146z
            if (r2 == 0) goto L_0x0036
            r2.setVisibility(r9)
            android.widget.ImageView r2 = r8.f6146z
            r2.setImageDrawable(r1)
        L_0x0036:
            java.lang.CharSequence r1 = r7.f6086f
            if (r1 == 0) goto L_0x0043
            r8.f6126f = r1
            android.widget.TextView r2 = r8.B
            if (r2 == 0) goto L_0x0043
            r2.setText(r1)
        L_0x0043:
            java.lang.CharSequence r1 = r7.f6087g
            if (r1 != 0) goto L_0x0048
            goto L_0x004e
        L_0x0048:
            r2 = -1
            android.content.DialogInterface$OnClickListener r3 = r7.f6088h
            r8.d(r2, r1, r3)
        L_0x004e:
            java.lang.CharSequence r1 = r7.f6089i
            if (r1 != 0) goto L_0x0053
            goto L_0x0059
        L_0x0053:
            r2 = -2
            android.content.DialogInterface$OnClickListener r3 = r7.f6090j
            r8.d(r2, r1, r3)
        L_0x0059:
            java.lang.CharSequence r1 = r7.f6091k
            if (r1 != 0) goto L_0x005e
            goto L_0x0064
        L_0x005e:
            r2 = -3
            android.content.DialogInterface$OnClickListener r3 = r7.f6092l
            r8.d(r2, r1, r3)
        L_0x0064:
            java.lang.CharSequence[] r1 = r7.f6095o
            r10 = 1
            r11 = 0
            if (r1 != 0) goto L_0x006e
            android.widget.ListAdapter r1 = r7.f6096p
            if (r1 == 0) goto L_0x00cf
        L_0x006e:
            int r1 = r8.G
            android.view.LayoutInflater r2 = r7.f6082b
            android.view.View r1 = r2.inflate(r1, r11)
            r12 = r1
            androidx.appcompat.app.AlertController$RecycleListView r12 = (androidx.appcompat.app.AlertController$RecycleListView) r12
            boolean r1 = r7.f6100t
            if (r1 == 0) goto L_0x008c
            g.f r13 = new g.f
            android.content.Context r3 = r7.f6081a
            int r4 = r8.H
            java.lang.CharSequence[] r5 = r7.f6095o
            r1 = r13
            r2 = r7
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x00a3
        L_0x008c:
            boolean r1 = r7.f6101u
            if (r1 == 0) goto L_0x0093
            int r1 = r8.I
            goto L_0x0095
        L_0x0093:
            int r1 = r8.J
        L_0x0095:
            android.widget.ListAdapter r13 = r7.f6096p
            if (r13 == 0) goto L_0x009a
            goto L_0x00a3
        L_0x009a:
            g.j r13 = new g.j
            java.lang.CharSequence[] r2 = r7.f6095o
            android.content.Context r3 = r7.f6081a
            r13.<init>(r3, r1, r2)
        L_0x00a3:
            r8.D = r13
            int r1 = r7.f6102v
            r8.E = r1
            android.content.DialogInterface$OnClickListener r1 = r7.f6097q
            if (r1 == 0) goto L_0x00b3
            g.g r1 = new g.g
            r1.<init>(r7, r9, r8)
            goto L_0x00bc
        L_0x00b3:
            android.content.DialogInterface$OnMultiChoiceClickListener r1 = r7.f6103w
            if (r1 == 0) goto L_0x00bf
            g.h r1 = new g.h
            r1.<init>(r7, r12, r8)
        L_0x00bc:
            r12.setOnItemClickListener(r1)
        L_0x00bf:
            boolean r1 = r7.f6101u
            if (r1 == 0) goto L_0x00c5
            r1 = 1
            goto L_0x00ca
        L_0x00c5:
            boolean r1 = r7.f6100t
            if (r1 == 0) goto L_0x00cd
            r1 = 2
        L_0x00ca:
            r12.setChoiceMode(r1)
        L_0x00cd:
            r8.f6127g = r12
        L_0x00cf:
            android.view.View r1 = r7.f6098r
            if (r1 == 0) goto L_0x00d9
            r8.f6128h = r1
            r8.f6129i = r9
            r8.f6130j = r9
        L_0x00d9:
            boolean r1 = r7.f6093m
            r0.setCancelable(r1)
            boolean r1 = r7.f6093m
            if (r1 == 0) goto L_0x00e5
            r0.setCanceledOnTouchOutside(r10)
        L_0x00e5:
            r0.setOnCancelListener(r11)
            r0.setOnDismissListener(r11)
            android.content.DialogInterface$OnKeyListener r1 = r7.f6094n
            if (r1 == 0) goto L_0x00f2
            r0.setOnKeyListener(r1)
        L_0x00f2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g.l.create():g.m");
    }

    public Context getContext() {
        return this.f6176a.f6081a;
    }

    public l setNegativeButton(int i10, DialogInterface.OnClickListener onClickListener) {
        i iVar = this.f6176a;
        iVar.f6089i = iVar.f6081a.getText(i10);
        iVar.f6090j = onClickListener;
        return this;
    }

    public l setPositiveButton(int i10, DialogInterface.OnClickListener onClickListener) {
        i iVar = this.f6176a;
        iVar.f6087g = iVar.f6081a.getText(i10);
        iVar.f6088h = onClickListener;
        return this;
    }

    public l setTitle(CharSequence charSequence) {
        this.f6176a.f6084d = charSequence;
        return this;
    }

    public l setView(View view) {
        this.f6176a.f6098r = view;
        return this;
    }

    public l(Context context, int i10) {
        this.f6176a = new i(new ContextThemeWrapper(context, m.i(context, i10)));
        this.f6177b = i10;
    }
}
