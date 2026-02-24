package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.woxthebox.draglistview.R;

public final class v0 extends SeekBar {

    /* renamed from: h  reason: collision with root package name */
    public final w0 f1104h;

    public v0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarStyle);
        q4.a(getContext(), this);
        w0 w0Var = new w0(this);
        this.f1104h = w0Var;
        w0Var.a(attributeSet, R.attr.seekBarStyle);
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        w0 w0Var = this.f1104h;
        Drawable drawable = w0Var.f1114e;
        if (drawable != null && drawable.isStateful()) {
            SeekBar seekBar = w0Var.f1113d;
            if (drawable.setState(seekBar.getDrawableState())) {
                seekBar.invalidateDrawable(drawable);
            }
        }
    }

    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1104h.f1114e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public final synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1104h.d(canvas);
    }
}
