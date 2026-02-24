package m7;

import android.view.View;
import java.io.Serializable;
import z5.d;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ d f10701h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f10702i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f10703j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f10704k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ m f10705l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Serializable f10706m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f10707n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f10708o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ View f10709p;

    public /* synthetic */ i(d dVar, int i10, int i11, int i12, m mVar, Serializable serializable, boolean z10, boolean z11, View view) {
        this.f10701h = dVar;
        this.f10702i = i10;
        this.f10703j = i11;
        this.f10704k = i12;
        this.f10705l = mVar;
        this.f10706m = serializable;
        this.f10707n = z10;
        this.f10708o = z11;
        this.f10709p = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005a, code lost:
        if (r2 != r0.f10708o) goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r18) {
        /*
            r17 = this;
            r0 = r17
            m7.j r1 = m7.m.f10712y0
            java.lang.String r1 = "$this_with"
            z5.d r2 = r0.f10701h
            xa.j.f(r1, r2)
            java.lang.String r1 = "this$0"
            m7.m r3 = r0.f10705l
            xa.j.f(r1, r3)
            java.lang.String r1 = "$view"
            android.view.View r4 = r0.f10709p
            xa.j.f(r1, r4)
            android.widget.RadioGroup r1 = r2.f17610b
            int r1 = r1.getCheckedRadioButtonId()
            android.widget.RadioGroup r5 = r2.f17614f
            int r5 = r5.getCheckedRadioButtonId()
            android.widget.RadioGroup r6 = r2.f17615g
            int r6 = r6.getCheckedRadioButtonId()
            android.widget.CheckBox r7 = r2.f17612d
            boolean r15 = r7.isChecked()
            android.widget.CheckBox r2 = r2.f17611c
            boolean r2 = r2.isChecked()
            int r7 = r0.f10702i
            if (r1 != r7) goto L_0x005c
            int r7 = r0.f10703j
            if (r5 != r7) goto L_0x005c
            int r7 = r0.f10704k
            if (r6 != r7) goto L_0x005c
            int r7 = r3.f10715x0
            java.io.Serializable r8 = r0.f10706m
            boolean r9 = r8 instanceof java.lang.Integer
            if (r9 != 0) goto L_0x004c
            goto L_0x005c
        L_0x004c:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            if (r7 != r8) goto L_0x005c
            boolean r7 = r0.f10707n
            if (r15 != r7) goto L_0x005c
            boolean r7 = r0.f10708o
            if (r2 == r7) goto L_0x00c8
        L_0x005c:
            android.view.View r7 = r4.findViewById(r5)
            android.widget.RadioButton r7 = (android.widget.RadioButton) r7
            android.view.View r4 = r4.findViewById(r1)
            android.widget.RadioButton r4 = (android.widget.RadioButton) r4
            m7.k r8 = r3.f10714w0
            if (r8 == 0) goto L_0x00cc
            r9 = 2131362544(0x7f0a02f0, float:1.8344872E38)
            if (r5 != r9) goto L_0x0074
            com.github.andreyasadchy.xtra.model.ui.VideoSortEnum r5 = com.github.andreyasadchy.xtra.model.ui.VideoSortEnum.TIME
            goto L_0x0076
        L_0x0074:
            com.github.andreyasadchy.xtra.model.ui.VideoSortEnum r5 = com.github.andreyasadchy.xtra.model.ui.VideoSortEnum.VIEWS
        L_0x0076:
            r9 = r5
            java.lang.CharSequence r10 = r7.getText()
            java.lang.String r5 = "sortBtn.text"
            xa.j.e(r5, r10)
            r5 = 2131362552(0x7f0a02f8, float:1.8344888E38)
            if (r1 != r5) goto L_0x0089
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r1 = com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum.DAY
        L_0x0087:
            r11 = r1
            goto L_0x009c
        L_0x0089:
            r5 = 2131362626(0x7f0a0342, float:1.8345038E38)
            if (r1 != r5) goto L_0x0091
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r1 = com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum.WEEK
            goto L_0x0087
        L_0x0091:
            r5 = 2131362242(0x7f0a01c2, float:1.834426E38)
            if (r1 != r5) goto L_0x0099
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r1 = com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum.MONTH
            goto L_0x0087
        L_0x0099:
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r1 = com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum.ALL
            goto L_0x0087
        L_0x009c:
            java.lang.CharSequence r12 = r4.getText()
            java.lang.String r1 = "periodBtn.text"
            xa.j.e(r1, r12)
            r1 = 2131362575(0x7f0a030f, float:1.8344934E38)
            if (r6 != r1) goto L_0x00ae
            com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum r1 = com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum.ARCHIVE
        L_0x00ac:
            r13 = r1
            goto L_0x00c1
        L_0x00ae:
            r1 = 2131362576(0x7f0a0310, float:1.8344936E38)
            if (r6 != r1) goto L_0x00b6
            com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum r1 = com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum.HIGHLIGHT
            goto L_0x00ac
        L_0x00b6:
            r1 = 2131362578(0x7f0a0312, float:1.834494E38)
            if (r6 != r1) goto L_0x00be
            com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum r1 = com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum.UPLOAD
            goto L_0x00ac
        L_0x00be:
            com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum r1 = com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum.ALL
            goto L_0x00ac
        L_0x00c1:
            int r14 = r3.f10715x0
            r16 = r2
            r8.p(r9, r10, r11, r12, r13, r14, r15, r16)
        L_0x00c8:
            r3.l0()
            return
        L_0x00cc:
            java.lang.String r1 = "listener"
            xa.j.l(r1)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: m7.i.onClick(android.view.View):void");
    }
}
