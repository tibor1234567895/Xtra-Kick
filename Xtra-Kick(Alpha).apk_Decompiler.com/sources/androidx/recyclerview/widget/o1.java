package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

public abstract class o1 {
    @Deprecated
    public void getItemOffsets(Rect rect, int i10, RecyclerView recyclerView) {
        rect.set(0, 0, 0, 0);
    }

    @Deprecated
    public void onDraw(Canvas canvas, RecyclerView recyclerView) {
    }

    @Deprecated
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, g2 g2Var) {
        getItemOffsets(rect, ((r1) view.getLayoutParams()).u(), recyclerView);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, g2 g2Var) {
        onDraw(canvas, recyclerView);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, g2 g2Var) {
        onDrawOver(canvas, recyclerView);
    }
}
