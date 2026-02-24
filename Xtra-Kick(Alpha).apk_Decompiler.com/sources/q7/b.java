package q7;

import android.util.TypedValue;
import android.view.View;
import androidx.activity.h;
import androidx.media3.ui.DefaultTimeBar;
import com.github.andreyasadchy.xtra.ui.view.SlidingLayout;
import com.woxthebox.draglistview.R;
import hb.h0;
import xa.j;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13403h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SlidingLayout f13404i;

    public /* synthetic */ b(SlidingLayout slidingLayout, int i10) {
        this.f13403h = i10;
        this.f13404i = slidingLayout;
    }

    public final void run() {
        View view;
        float f10;
        int i10 = this.f13403h;
        SlidingLayout slidingLayout = this.f13404i;
        switch (i10) {
            case 0:
                int i11 = SlidingLayout.B;
                j.f("this$0", slidingLayout);
                slidingLayout.f3537m = slidingLayout.getPaddingTop();
                if (slidingLayout.d()) {
                    f10 = 0.5f;
                    slidingLayout.f3543s = 0.5f;
                } else {
                    slidingLayout.f3543s = 0.3f;
                    f10 = 0.325f;
                }
                slidingLayout.f3544t = f10;
                slidingLayout.f3540p = TypedValue.applyDimension(1, 75.0f / (1.0f - f10), slidingLayout.getResources().getDisplayMetrics());
                if (!slidingLayout.d() || !slidingLayout.f3546v || !h0.W0(slidingLayout)) {
                    SlidingLayout.c(slidingLayout);
                } else {
                    slidingLayout.postDelayed(new h(16, slidingLayout), 750);
                }
                if (!slidingLayout.f3546v) {
                    slidingLayout.setScaleX(slidingLayout.f3543s);
                    slidingLayout.setScaleY(slidingLayout.f3544t);
                }
                View view2 = slidingLayout.f3534j;
                if (view2 != null) {
                    slidingLayout.f3536l = (DefaultTimeBar) view2.findViewById(R.id.exo_progress);
                    return;
                } else {
                    j.l("dragView");
                    throw null;
                }
            default:
                int i12 = SlidingLayout.B;
                j.f("this$0", slidingLayout);
                if (!slidingLayout.f3546v && !slidingLayout.d() && (view = slidingLayout.f3535k) != null) {
                    h0.J0(view);
                    return;
                }
                return;
        }
    }
}
