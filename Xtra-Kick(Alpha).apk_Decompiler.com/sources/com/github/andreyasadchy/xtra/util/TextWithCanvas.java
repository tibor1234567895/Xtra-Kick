package com.github.andreyasadchy.xtra.util;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.t1;
import xa.j;

public final class TextWithCanvas extends t1 {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextWithCanvas(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.f("context", context);
        j.f("attrs", attributeSet);
    }

    public final void draw(Canvas canvas) {
        for (int i10 = 0; i10 < 7; i10++) {
            super.draw(canvas);
        }
    }
}
