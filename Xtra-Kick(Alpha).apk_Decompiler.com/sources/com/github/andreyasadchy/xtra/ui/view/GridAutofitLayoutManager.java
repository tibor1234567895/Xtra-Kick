package com.github.andreyasadchy.xtra.ui.view;

import android.content.Context;
import android.support.v4.media.h;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.g2;
import androidx.recyclerview.widget.y1;
import xa.j;

public final class GridAutofitLayoutManager extends GridLayoutManager {
    public int T;
    public boolean U = true;

    public GridAutofitLayoutManager(Context context, int i10) {
        super(1);
        if (i10 <= 0) {
            throw new IllegalArgumentException(h.i("Width should be more than 0. Provided ", i10));
        } else if (this.T != i10) {
            this.T = i10;
            this.U = true;
        }
    }

    public final void n0(y1 y1Var, g2 g2Var) {
        int i10;
        int i11;
        int i12;
        j.f("state", g2Var);
        if (this.U && (i10 = this.f2156u) > 0 && (i11 = this.f2157v) > 0) {
            if (this.f1917w == 1) {
                i12 = (i10 - getPaddingRight()) - getPaddingLeft();
            } else {
                i12 = (i11 - getPaddingTop()) - getPaddingBottom();
            }
            z1(Math.max(1, i12 / this.T));
            this.U = false;
        }
        super.n0(y1Var, g2Var);
    }
}
