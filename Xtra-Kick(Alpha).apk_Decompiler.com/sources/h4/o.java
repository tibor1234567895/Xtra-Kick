package h4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public final class o extends RecyclerView {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f7543h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(ViewPager2 viewPager2, Context context) {
        super(context, (AttributeSet) null);
        this.f7543h = viewPager2;
    }

    public final CharSequence getAccessibilityClassName() {
        this.f7543h.A.getClass();
        return super.getAccessibilityClassName();
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        ViewPager2 viewPager2 = this.f7543h;
        accessibilityEvent.setFromIndex(viewPager2.f2316k);
        accessibilityEvent.setToIndex(viewPager2.f2316k);
        viewPager2.A.j(accessibilityEvent);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f7543h.f2330y || !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f7543h.f2330y || !super.onTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }
}
