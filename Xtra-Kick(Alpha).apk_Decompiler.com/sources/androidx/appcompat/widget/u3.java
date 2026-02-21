package androidx.appcompat.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.google.android.material.textfield.TextInputLayout;

public final class u3 implements TextWatcher {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1097h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1098i;

    public /* synthetic */ u3(int i10, Object obj) {
        this.f1097h = i10;
        this.f1098i = obj;
    }

    public final void afterTextChanged(Editable editable) {
        switch (this.f1097h) {
            case 0:
            case 1:
            case 2:
                return;
            default:
                TextInputLayout textInputLayout = (TextInputLayout) this.f1098i;
                textInputLayout.s(!textInputLayout.E0, false);
                if (textInputLayout.f3910r) {
                    textInputLayout.m(editable);
                }
                if (textInputLayout.f3926z) {
                    textInputLayout.t(editable);
                    return;
                }
                return;
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    /* JADX WARNING: type inference failed for: r9v8, types: [androidx.fragment.app.c0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onTextChanged(java.lang.CharSequence r8, int r9, int r10, int r11) {
        /*
            r7 = this;
            r9 = 8
            int r10 = r7.f1097h
            java.lang.Object r11 = r7.f1098i
            r0 = 0
            r1 = 1
            switch(r10) {
                case 0: goto L_0x0051;
                case 1: goto L_0x003c;
                case 2: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            return
        L_0x000c:
            if (r8 == 0) goto L_0x0016
            boolean r8 = fb.w.h(r8)
            r8 = r8 ^ r1
            if (r8 != r1) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            z5.m r11 = (z5.m) r11
            java.lang.String r8 = "clear"
            java.lang.String r9 = "send"
            android.widget.ImageButton r10 = r11.f17726m
            xa.j.e(r9, r10)
            if (r1 == 0) goto L_0x0030
            r10.setVisibility(r0)
            android.widget.ImageButton r9 = r11.f17715b
            xa.j.e(r8, r9)
            r9.setVisibility(r0)
            goto L_0x003b
        L_0x0030:
            hb.h0.J0(r10)
            android.widget.ImageButton r9 = r11.f17715b
            xa.j.e(r8, r9)
            hb.h0.J0(r9)
        L_0x003b:
            return
        L_0x003c:
            if (r8 == 0) goto L_0x0045
            int r8 = r8.length()
            if (r8 != r9) goto L_0x0045
            r0 = 1
        L_0x0045:
            if (r0 == 0) goto L_0x0050
            z5.c r11 = (z5.c) r11
            android.widget.TextView r8 = r11.f17608n
            com.github.andreyasadchy.xtra.ui.view.StrictEditText r8 = (com.github.andreyasadchy.xtra.ui.view.StrictEditText) r8
            r8.requestFocus()
        L_0x0050:
            return
        L_0x0051:
            androidx.appcompat.widget.SearchView r11 = (androidx.appcompat.widget.SearchView) r11
            androidx.appcompat.widget.SearchView$SearchAutoComplete r10 = r11.f657w
            android.text.Editable r10 = r10.getText()
            r11.f649h0 = r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            r10 = r10 ^ r1
            r11.x(r10)
            r10 = r10 ^ r1
            boolean r2 = r11.f647f0
            if (r2 == 0) goto L_0x0074
            boolean r2 = r11.V
            if (r2 != 0) goto L_0x0074
            if (r10 == 0) goto L_0x0074
            android.widget.ImageView r10 = r11.B
            r10.setVisibility(r9)
            r9 = 0
        L_0x0074:
            android.widget.ImageView r10 = r11.D
            r10.setVisibility(r9)
            r11.t()
            r11.w()
            androidx.appcompat.widget.e4 r9 = r11.R
            if (r9 == 0) goto L_0x0109
            java.lang.String r9 = r11.f648g0
            boolean r9 = android.text.TextUtils.equals(r8, r9)
            if (r9 != 0) goto L_0x0109
            androidx.appcompat.widget.e4 r9 = r11.R
            java.lang.String r10 = r8.toString()
            b7.c r9 = (b7.c) r9
            int r2 = r9.f2649a
            r3 = 3
            r4 = 0
            l6.f r5 = r9.f2651c
            java.lang.String r6 = "newText"
            switch(r2) {
                case 0: goto L_0x009f;
                default: goto L_0x009e;
            }
        L_0x009e:
            goto L_0x00db
        L_0x009f:
            xa.j.f(r6, r10)
            hb.c2 r2 = r9.f2650b
            if (r2 == 0) goto L_0x00a9
            r2.e(r4)
        L_0x00a9:
            int r2 = r10.length()
            if (r2 <= 0) goto L_0x00b0
            goto L_0x00b1
        L_0x00b0:
            r1 = 0
        L_0x00b1:
            com.github.andreyasadchy.xtra.ui.search.SearchPagerFragment r5 = (com.github.andreyasadchy.xtra.ui.search.SearchPagerFragment) r5
            if (r1 == 0) goto L_0x00ca
            androidx.lifecycle.LifecycleCoroutineScopeImpl r1 = hb.h0.v0(r5)
            b7.b r2 = new b7.b
            r2.<init>(r5, r10, r4)
            androidx.lifecycle.w r10 = new androidx.lifecycle.w
            r10.<init>(r1, r2, r4)
            hb.c2 r10 = hb.h0.b1(r1, r4, r0, r10, r3)
            r9.f2650b = r10
            goto L_0x0109
        L_0x00ca:
            androidx.fragment.app.c0 r9 = r5.q0()
            boolean r0 = r9 instanceof b7.i
            if (r0 == 0) goto L_0x00d5
            r4 = r9
            b7.i r4 = (b7.i) r4
        L_0x00d5:
            if (r4 == 0) goto L_0x0109
            r4.k(r10)
            goto L_0x0109
        L_0x00db:
            xa.j.f(r6, r10)
            hb.c2 r2 = r9.f2650b
            if (r2 == 0) goto L_0x00e5
            r2.e(r4)
        L_0x00e5:
            int r2 = r10.length()
            if (r2 <= 0) goto L_0x00ec
            goto L_0x00ed
        L_0x00ec:
            r1 = 0
        L_0x00ed:
            com.github.andreyasadchy.xtra.ui.search.tags.TagSearchFragment r5 = (com.github.andreyasadchy.xtra.ui.search.tags.TagSearchFragment) r5
            if (r1 == 0) goto L_0x0106
            androidx.lifecycle.LifecycleCoroutineScopeImpl r1 = hb.h0.v0(r5)
            f7.i r2 = new f7.i
            r2.<init>(r5, r10, r4)
            androidx.lifecycle.w r10 = new androidx.lifecycle.w
            r10.<init>(r1, r2, r4)
            hb.c2 r10 = hb.h0.b1(r1, r4, r0, r10, r3)
            r9.f2650b = r10
            goto L_0x0109
        L_0x0106:
            com.github.andreyasadchy.xtra.ui.search.tags.TagSearchFragment.s0(r5, r10)
        L_0x0109:
            java.lang.String r8 = r8.toString()
            r11.f648g0 = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.u3.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }
}
