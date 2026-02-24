package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.chip.Chip;
import m8.q;

public final class a extends q {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ChipTextInputComboView f3945h;

    public a(ChipTextInputComboView chipTextInputComboView) {
        this.f3945h = chipTextInputComboView;
    }

    public final void afterTextChanged(Editable editable) {
        boolean isEmpty = TextUtils.isEmpty(editable);
        ChipTextInputComboView chipTextInputComboView = this.f3945h;
        if (isEmpty) {
            chipTextInputComboView.f3928h.setText(ChipTextInputComboView.a(chipTextInputComboView, "00"));
            return;
        }
        String a10 = ChipTextInputComboView.a(chipTextInputComboView, editable);
        Chip chip = chipTextInputComboView.f3928h;
        if (TextUtils.isEmpty(a10)) {
            a10 = ChipTextInputComboView.a(chipTextInputComboView, "00");
        }
        chip.setText(a10);
    }
}
