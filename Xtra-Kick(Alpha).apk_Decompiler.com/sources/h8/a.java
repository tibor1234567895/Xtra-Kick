package h8;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public final class a implements View.OnTouchListener {

    /* renamed from: h  reason: collision with root package name */
    public final Dialog f7714h;

    /* renamed from: i  reason: collision with root package name */
    public final int f7715i;

    /* renamed from: j  reason: collision with root package name */
    public final int f7716j;

    /* renamed from: k  reason: collision with root package name */
    public final int f7717k;

    public a(Dialog dialog, Rect rect) {
        this.f7714h = dialog;
        this.f7715i = rect.left;
        this.f7716j = rect.top;
        this.f7717k = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = findViewById.getLeft() + this.f7715i;
        int width = findViewById.getWidth() + left;
        int top = findViewById.getTop() + this.f7716j;
        if (new RectF((float) left, (float) top, (float) width, (float) (findViewById.getHeight() + top)).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i10 = this.f7717k;
            obtain.setLocation((float) ((-i10) - 1), (float) ((-i10) - 1));
        }
        view.performClick();
        return this.f7714h.onTouchEvent(obtain);
    }
}
