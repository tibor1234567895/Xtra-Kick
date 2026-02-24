package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import x.d;

public class Guideline extends View {

    /* renamed from: h  reason: collision with root package name */
    public boolean f1184h = true;

    public Guideline(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public final void draw(Canvas canvas) {
    }

    public final void onMeasure(int i10, int i11) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z10) {
        this.f1184h = z10;
    }

    public void setGuidelineBegin(int i10) {
        d dVar = (d) getLayoutParams();
        if (!this.f1184h || dVar.f16355a != i10) {
            dVar.f16355a = i10;
            setLayoutParams(dVar);
        }
    }

    public void setGuidelineEnd(int i10) {
        d dVar = (d) getLayoutParams();
        if (!this.f1184h || dVar.f16357b != i10) {
            dVar.f16357b = i10;
            setLayoutParams(dVar);
        }
    }

    public void setGuidelinePercent(float f10) {
        d dVar = (d) getLayoutParams();
        if (!this.f1184h || dVar.f16359c != f10) {
            dVar.f16359c = f10;
            setLayoutParams(dVar);
        }
    }

    public void setVisibility(int i10) {
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
