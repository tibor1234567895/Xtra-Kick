package g;

import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;
import h.a;
import l.f;

public final class i0 extends ContentFrameLayout {

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ k0 f6104p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i0(k0 k0Var, f fVar) {
        super(fVar, (AttributeSet) null);
        this.f6104p = k0Var;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f6104p.K(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        if (motionEvent.getAction() == 0) {
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            if (x10 < -5 || y10 < -5 || x10 > getWidth() + 5 || y10 > getHeight() + 5) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                k0 k0Var = this.f6104p;
                k0Var.I(k0Var.Q(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void setBackgroundResource(int i10) {
        setBackgroundDrawable(a.a(getContext(), i10));
    }
}
