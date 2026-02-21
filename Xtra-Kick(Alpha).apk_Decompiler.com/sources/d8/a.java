package d8;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g2;
import androidx.recyclerview.widget.o1;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.woxthebox.draglistview.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a extends o1 {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f4586a;

    /* renamed from: b  reason: collision with root package name */
    public List f4587b = Collections.unmodifiableList(new ArrayList());

    public a() {
        Paint paint = new Paint();
        this.f4586a = paint;
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, g2 g2Var) {
        onDrawOver(canvas, recyclerView);
        Paint paint = this.f4586a;
        paint.setStrokeWidth(recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
        for (c cVar : this.f4587b) {
            cVar.getClass();
            ThreadLocal threadLocal = e0.a.f4854a;
            float f10 = 1.0f - 0.0f;
            paint.setColor(Color.argb((int) ((((float) Color.alpha(-16776961)) * 0.0f) + (((float) Color.alpha(-65281)) * f10)), (int) ((((float) Color.red(-16776961)) * 0.0f) + (((float) Color.red(-65281)) * f10)), (int) ((((float) Color.green(-16776961)) * 0.0f) + (((float) Color.green(-65281)) * f10)), (int) ((((float) Color.blue(-16776961)) * 0.0f) + (((float) Color.blue(-65281)) * f10))));
            cVar.getClass();
            cVar.getClass();
            CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) recyclerView.getLayoutManager();
            canvas.drawLine(0.0f, (float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).getPaddingTop(), 0.0f, (float) (carouselLayoutManager.f2157v - carouselLayoutManager.getPaddingBottom()), paint);
        }
    }
}
