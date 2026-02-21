package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.a0;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.s0;
import androidx.appcompat.widget.t1;
import com.google.android.material.button.MaterialButton;
import e8.d;
import g.p0;
import p8.a;
import y8.t;

public class MaterialComponentsViewInflater extends p0 {
    public final a0 a(Context context, AttributeSet attributeSet) {
        return new t(context, attributeSet);
    }

    public final c0 b(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    public final d0 c(Context context, AttributeSet attributeSet) {
        return new d(context, attributeSet);
    }

    public final s0 d(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    public final t1 e(Context context, AttributeSet attributeSet) {
        return new z8.a(context, attributeSet);
    }
}
