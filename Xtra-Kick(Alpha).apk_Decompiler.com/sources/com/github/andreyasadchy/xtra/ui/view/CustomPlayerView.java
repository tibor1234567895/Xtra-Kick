package com.github.andreyasadchy.xtra.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.activity.e;
import hb.h0;
import i3.g0;
import wa.a;
import xa.j;

public final class CustomPlayerView extends g0 {
    public static final /* synthetic */ int K = 0;
    public final e G = new e(20, this);
    public final float[] H = new float[2];
    public long I;
    public a J;

    static {
        new q7.a(0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.f("context", context);
        j.f("attrs", attributeSet);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        j.f("ev", motionEvent);
        if (!h0.S0(motionEvent, this.H)) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        e eVar = this.G;
        postDelayed(eVar, 300);
        if (currentTimeMillis - this.I < 300) {
            removeCallbacks(eVar);
            a aVar = this.J;
            if (aVar != null) {
                aVar.b();
            } else {
                j.l("listener");
                throw null;
            }
        }
        this.I = currentTimeMillis;
        return true;
    }

    public final void setOnDoubleTapListener(a aVar) {
        j.f("action", aVar);
        this.J = aVar;
    }
}
