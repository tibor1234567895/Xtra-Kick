package com.github.andreyasadchy.xtra.ui.view;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import androidx.appcompat.widget.j0;
import xa.j;

public final class StrictEditText extends j0 {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StrictEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.f("context", context);
        j.f("attrs", attributeSet);
    }

    public final void onSelectionChanged(int i10, int i11) {
        Editable text = getText();
        j.c(text);
        int length = text.length();
        if (i10 == length && i11 == length) {
            super.onSelectionChanged(i10, i11);
        } else {
            setSelection(length, length);
        }
    }
}
