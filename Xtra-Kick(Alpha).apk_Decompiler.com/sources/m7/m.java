package m7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.c0;
import com.woxthebox.draglistview.R;
import e4.a;
import l6.a0;
import l6.n;
import xa.j;
import z5.d;

public final class m extends n implements a0 {

    /* renamed from: y0  reason: collision with root package name */
    public static final j f10712y0 = new j(0);

    /* renamed from: v0  reason: collision with root package name */
    public d f10713v0;

    /* renamed from: w0  reason: collision with root package name */
    public k f10714w0;

    /* renamed from: x0  reason: collision with root package name */
    public int f10715x0;

    public final void M(Context context) {
        j.f("context", context);
        super.M(context);
        c0 c0Var = this.C;
        j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.ui.videos.VideosSortDialog.OnFilter", c0Var);
        this.f10714w0 = (k) c0Var;
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        View inflate = layoutInflater.inflate(R.layout.dialog_videos_sort, viewGroup, false);
        int i10 = R.id.all;
        if (((RadioButton) a.a(inflate, R.id.all)) != null) {
            i10 = R.id.apply;
            Button button = (Button) a.a(inflate, R.id.apply);
            if (button != null) {
                i10 = R.id.month;
                if (((RadioButton) a.a(inflate, R.id.month)) != null) {
                    i10 = R.id.period;
                    RadioGroup radioGroup = (RadioGroup) a.a(inflate, R.id.period);
                    if (radioGroup != null) {
                        i10 = R.id.saveDefault;
                        CheckBox checkBox = (CheckBox) a.a(inflate, R.id.saveDefault);
                        if (checkBox != null) {
                            i10 = R.id.saveSort;
                            CheckBox checkBox2 = (CheckBox) a.a(inflate, R.id.saveSort);
                            if (checkBox2 != null) {
                                i10 = R.id.selectLang;
                                Button button2 = (Button) a.a(inflate, R.id.selectLang);
                                if (button2 != null) {
                                    i10 = R.id.sort;
                                    RadioGroup radioGroup2 = (RadioGroup) a.a(inflate, R.id.sort);
                                    if (radioGroup2 != null) {
                                        i10 = R.id.sortType;
                                        RadioGroup radioGroup3 = (RadioGroup) a.a(inflate, R.id.sortType);
                                        if (radioGroup3 != null) {
                                            i10 = R.id.time;
                                            if (((RadioButton) a.a(inflate, R.id.time)) != null) {
                                                i10 = R.id.today;
                                                if (((RadioButton) a.a(inflate, R.id.today)) != null) {
                                                    i10 = R.id.typeAll;
                                                    if (((RadioButton) a.a(inflate, R.id.typeAll)) != null) {
                                                        i10 = R.id.typeArchive;
                                                        if (((RadioButton) a.a(inflate, R.id.typeArchive)) != null) {
                                                            i10 = R.id.typeHighlight;
                                                            if (((RadioButton) a.a(inflate, R.id.typeHighlight)) != null) {
                                                                i10 = R.id.typeUpload;
                                                                if (((RadioButton) a.a(inflate, R.id.typeUpload)) != null) {
                                                                    i10 = R.id.views;
                                                                    if (((RadioButton) a.a(inflate, R.id.views)) != null) {
                                                                        i10 = R.id.week;
                                                                        if (((RadioButton) a.a(inflate, R.id.week)) != null) {
                                                                            NestedScrollView nestedScrollView = (NestedScrollView) inflate;
                                                                            this.f10713v0 = new d(nestedScrollView, button, radioGroup, checkBox, checkBox2, button2, radioGroup2, radioGroup3);
                                                                            j.e("binding.root", nestedScrollView);
                                                                            return nestedScrollView;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public final void Q() {
        super.Q();
        this.f10713v0 = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007c, code lost:
        if ((!r1) != false) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b0, code lost:
        if ((!r1) != false) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f3, code lost:
        if ((!r1) != false) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f7, code lost:
        r1 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x015e, code lost:
        if ((!r1) != false) goto L_0x00f5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Z(android.view.View r19, android.os.Bundle r20) {
        /*
            r18 = this;
            r10 = r18
            java.lang.String r0 = "view"
            r9 = r19
            xa.j.f(r0, r9)
            z5.d r11 = r10.f10713v0
            xa.j.c(r11)
            android.os.Bundle r0 = r18.e0()
            androidx.fragment.app.c0 r1 = r10.C
            boolean r2 = r1 instanceof k6.e
            java.lang.String r3 = "gameId"
            java.lang.String r4 = "channelId"
            java.lang.String r7 = "sort"
            java.lang.String r8 = "selectLang"
            java.lang.String r14 = "period"
            java.lang.String r15 = "saveSort"
            r16 = 0
            android.widget.RadioGroup r13 = r11.f17615g
            android.widget.RadioGroup r5 = r11.f17614f
            android.widget.Button r12 = r11.f17613e
            android.widget.RadioGroup r6 = r11.f17610b
            android.widget.CheckBox r9 = r11.f17612d
            if (r2 == 0) goto L_0x00b3
            java.lang.String r1 = "clip_channel"
            boolean r1 = r0.getBoolean(r1)
            java.lang.String r2 = "sortType"
            xa.j.e(r7, r5)
            hb.h0.J0(r5)
            xa.j.e(r2, r13)
            hb.h0.J0(r13)
            if (r1 == 0) goto L_0x0080
            xa.j.e(r8, r12)
            hb.h0.J0(r12)
            android.content.Context r1 = r18.f0()
            r2 = 2131952277(0x7f130295, float:1.9540992E38)
            java.lang.String r1 = r1.getString(r2)
            r9.setText(r1)
            xa.j.e(r15, r9)
            androidx.fragment.app.c0 r1 = r10.C
            if (r1 == 0) goto L_0x006c
            android.os.Bundle r1 = r1.f1357m
            if (r1 == 0) goto L_0x006c
            java.lang.String r1 = r1.getString(r4)
            r17 = r1
            goto L_0x006e
        L_0x006c:
            r17 = 0
        L_0x006e:
            if (r17 == 0) goto L_0x0079
            boolean r1 = fb.w.h(r17)
            if (r1 == 0) goto L_0x0077
            goto L_0x0079
        L_0x0077:
            r1 = 0
            goto L_0x007a
        L_0x0079:
            r1 = 1
        L_0x007a:
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x00f7
            goto L_0x00f5
        L_0x0080:
            android.content.Context r1 = r18.f0()
            r2 = 2131952278(0x7f130296, float:1.9540994E38)
            java.lang.String r1 = r1.getString(r2)
            r9.setText(r1)
            xa.j.e(r15, r9)
            androidx.fragment.app.c0 r1 = r10.C
            if (r1 == 0) goto L_0x00a0
            android.os.Bundle r1 = r1.f1357m
            if (r1 == 0) goto L_0x00a0
            java.lang.String r1 = r1.getString(r3)
            r17 = r1
            goto L_0x00a2
        L_0x00a0:
            r17 = 0
        L_0x00a2:
            if (r17 == 0) goto L_0x00ad
            boolean r1 = fb.w.h(r17)
            if (r1 == 0) goto L_0x00ab
            goto L_0x00ad
        L_0x00ab:
            r1 = 0
            goto L_0x00ae
        L_0x00ad:
            r1 = 1
        L_0x00ae:
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x00f7
            goto L_0x00f5
        L_0x00b3:
            boolean r2 = r1 instanceof n7.g
            if (r2 == 0) goto L_0x00fd
            xa.j.e(r14, r6)
            hb.h0.J0(r6)
            xa.j.e(r8, r12)
            hb.h0.J0(r12)
            android.content.Context r1 = r18.f0()
            r2 = 2131952277(0x7f130295, float:1.9540992E38)
            java.lang.String r1 = r1.getString(r2)
            r9.setText(r1)
            xa.j.e(r15, r9)
            androidx.fragment.app.c0 r1 = r10.C
            if (r1 == 0) goto L_0x00e3
            android.os.Bundle r1 = r1.f1357m
            if (r1 == 0) goto L_0x00e3
            java.lang.String r1 = r1.getString(r4)
            r17 = r1
            goto L_0x00e5
        L_0x00e3:
            r17 = 0
        L_0x00e5:
            if (r17 == 0) goto L_0x00f0
            boolean r1 = fb.w.h(r17)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00f0
        L_0x00ee:
            r1 = 0
            goto L_0x00f1
        L_0x00f0:
            r1 = 1
        L_0x00f1:
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x00f7
        L_0x00f5:
            r1 = 0
            goto L_0x00f9
        L_0x00f7:
            r1 = 8
        L_0x00f9:
            r9.setVisibility(r1)
            goto L_0x0161
        L_0x00fd:
            boolean r2 = r1 instanceof o7.c
            if (r2 == 0) goto L_0x0114
            xa.j.e(r14, r6)
            hb.h0.J0(r6)
            xa.j.e(r8, r12)
            hb.h0.J0(r12)
            xa.j.e(r15, r9)
            hb.h0.J0(r9)
            goto L_0x0161
        L_0x0114:
            boolean r1 = r1 instanceof p7.c
            if (r1 == 0) goto L_0x0161
            com.github.andreyasadchy.xtra.model.Account$Companion r1 = com.github.andreyasadchy.xtra.model.Account.Companion
            android.content.Context r2 = r18.f0()
            com.github.andreyasadchy.xtra.model.Account r1 = r1.get(r2)
            int r1 = r1.getId()
            if (r1 != 0) goto L_0x012e
            xa.j.e(r14, r6)
            hb.h0.J0(r6)
        L_0x012e:
            android.content.Context r1 = r18.f0()
            r2 = 2131952278(0x7f130296, float:1.9540994E38)
            java.lang.String r1 = r1.getString(r2)
            r9.setText(r1)
            xa.j.e(r15, r9)
            androidx.fragment.app.c0 r1 = r10.C
            if (r1 == 0) goto L_0x014e
            android.os.Bundle r1 = r1.f1357m
            if (r1 == 0) goto L_0x014e
            java.lang.String r1 = r1.getString(r3)
            r17 = r1
            goto L_0x0150
        L_0x014e:
            r17 = 0
        L_0x0150:
            if (r17 == 0) goto L_0x015b
            boolean r1 = fb.w.h(r17)
            if (r1 == 0) goto L_0x0159
            goto L_0x015b
        L_0x0159:
            r1 = 0
            goto L_0x015c
        L_0x015b:
            r1 = 1
        L_0x015c:
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x00f7
            goto L_0x00f5
        L_0x0161:
            java.io.Serializable r1 = r0.getSerializable(r7)
            java.lang.String r2 = "null cannot be cast to non-null type com.github.andreyasadchy.xtra.model.ui.VideoSortEnum"
            xa.j.d(r2, r1)
            com.github.andreyasadchy.xtra.model.ui.VideoSortEnum r1 = (com.github.andreyasadchy.xtra.model.ui.VideoSortEnum) r1
            com.github.andreyasadchy.xtra.model.ui.VideoSortEnum r2 = com.github.andreyasadchy.xtra.model.ui.VideoSortEnum.TIME
            if (r1 != r2) goto L_0x0177
            r1 = 2131362544(0x7f0a02f0, float:1.8344872E38)
            r3 = 2131362544(0x7f0a02f0, float:1.8344872E38)
            goto L_0x017d
        L_0x0177:
            r1 = 2131362612(0x7f0a0334, float:1.834501E38)
            r3 = 2131362612(0x7f0a0334, float:1.834501E38)
        L_0x017d:
            java.io.Serializable r1 = r0.getSerializable(r14)
            java.lang.String r2 = "null cannot be cast to non-null type com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum"
            xa.j.d(r2, r1)
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r1 = (com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum) r1
            int[] r2 = m7.l.f10710a
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 4
            r4 = 3
            r7 = 2
            r8 = 1
            if (r1 == r8) goto L_0x01b7
            if (r1 == r7) goto L_0x01b0
            if (r1 == r4) goto L_0x01a9
            if (r1 != r2) goto L_0x01a3
            r1 = 2131361873(0x7f0a0051, float:1.834351E38)
            r8 = 2131361873(0x7f0a0051, float:1.834351E38)
            goto L_0x01bd
        L_0x01a3:
            la.g r0 = new la.g
            r0.<init>()
            throw r0
        L_0x01a9:
            r1 = 2131362242(0x7f0a01c2, float:1.834426E38)
            r8 = 2131362242(0x7f0a01c2, float:1.834426E38)
            goto L_0x01bd
        L_0x01b0:
            r1 = 2131362626(0x7f0a0342, float:1.8345038E38)
            r8 = 2131362626(0x7f0a0342, float:1.8345038E38)
            goto L_0x01bd
        L_0x01b7:
            r1 = 2131362552(0x7f0a02f8, float:1.8344888E38)
            r8 = 2131362552(0x7f0a02f8, float:1.8344888E38)
        L_0x01bd:
            java.lang.String r1 = "type"
            java.io.Serializable r1 = r0.getSerializable(r1)
            java.lang.String r14 = "null cannot be cast to non-null type com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum"
            xa.j.d(r14, r1)
            com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum r1 = (com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum) r1
            int[] r14 = m7.l.f10711b
            int r1 = r1.ordinal()
            r1 = r14[r1]
            r14 = 1
            if (r1 == r14) goto L_0x01f6
            if (r1 == r7) goto L_0x01ef
            if (r1 == r4) goto L_0x01e8
            if (r1 != r2) goto L_0x01e2
            r1 = 2131362574(0x7f0a030e, float:1.8344932E38)
            r4 = 2131362574(0x7f0a030e, float:1.8344932E38)
            goto L_0x01fc
        L_0x01e2:
            la.g r0 = new la.g
            r0.<init>()
            throw r0
        L_0x01e8:
            r1 = 2131362578(0x7f0a0312, float:1.834494E38)
            r4 = 2131362578(0x7f0a0312, float:1.834494E38)
            goto L_0x01fc
        L_0x01ef:
            r1 = 2131362576(0x7f0a0310, float:1.8344936E38)
            r4 = 2131362576(0x7f0a0310, float:1.8344936E38)
            goto L_0x01fc
        L_0x01f6:
            r1 = 2131362575(0x7f0a030f, float:1.8344934E38)
            r4 = 2131362575(0x7f0a030f, float:1.8344934E38)
        L_0x01fc:
            java.lang.String r1 = "language"
            java.io.Serializable r7 = r0.getSerializable(r1)
            java.lang.String r2 = "save_sort"
            boolean r14 = r0.getBoolean(r2)
            java.lang.String r2 = "save_default"
            boolean r15 = r0.getBoolean(r2)
            r5.check(r3)
            r6.check(r8)
            r13.check(r4)
            int r0 = r0.getInt(r1)
            r10.f10715x0 = r0
            r9.setChecked(r14)
            android.widget.CheckBox r0 = r11.f17611c
            r0.setChecked(r15)
            m7.i r13 = new m7.i
            r0 = r13
            r1 = r11
            r2 = r8
            r5 = r18
            r6 = r7
            r7 = r14
            r8 = r15
            r9 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            android.widget.Button r0 = r11.f17609a
            r0.setOnClickListener(r13)
            android.content.res.Resources r0 = r18.y()
            r1 = 2130903052(0x7f03000c, float:1.7412911E38)
            java.lang.String[] r0 = r0.getStringArray(r1)
            java.lang.String r1 = "resources.getStringArray…y.gqlUserLanguageEntries)"
            xa.j.e(r1, r0)
            java.util.List r0 = ma.p.j(r0)
            h6.b r1 = new h6.b
            r2 = 17
            r1.<init>(r10, r2, r0)
            r12.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m7.m.Z(android.view.View, android.os.Bundle):void");
    }

    public final void f(int i10, int i11, CharSequence charSequence) {
        if (i10 == 0) {
            this.f10715x0 = i11;
        }
    }
}
