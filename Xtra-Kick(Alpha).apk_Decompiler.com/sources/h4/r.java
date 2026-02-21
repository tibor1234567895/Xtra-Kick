package h4;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.n;
import o8.d;

public final class r implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7547h;

    /* renamed from: i  reason: collision with root package name */
    public final int f7548i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f7549j;

    public r(RecyclerView recyclerView, int i10) {
        this.f7547h = 0;
        this.f7548i = i10;
        this.f7549j = recyclerView;
    }

    public final void run() {
        int i10 = this.f7547h;
        int i11 = this.f7548i;
        Object obj = this.f7549j;
        switch (i10) {
            case 0:
                ((RecyclerView) obj).smoothScrollToPosition(i11);
                return;
            case 1:
                ((n) obj).f3775l0.smoothScrollToPosition(i11);
                return;
            default:
                int[] iArr = d.L;
                ((d) obj).h(i11);
                return;
        }
    }

    public /* synthetic */ r(Object obj, int i10, int i11) {
        this.f7547h = i11;
        this.f7549j = obj;
        this.f7548i = i10;
    }
}
