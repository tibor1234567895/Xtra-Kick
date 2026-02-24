package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import com.woxthebox.draglistview.R;

public final class t0 extends RatingBar {

    /* renamed from: h  reason: collision with root package name */
    public final r0 f1062h;

    public t0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.ratingBarStyle);
        q4.a(getContext(), this);
        r0 r0Var = new r0(this);
        this.f1062h = r0Var;
        r0Var.a(attributeSet, R.attr.ratingBarStyle);
    }

    public final synchronized void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        Bitmap bitmap = this.f1062h.f1031b;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i10, 0), getMeasuredHeight());
        }
    }
}
