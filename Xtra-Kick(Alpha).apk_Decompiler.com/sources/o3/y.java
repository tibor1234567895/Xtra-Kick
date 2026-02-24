package o3;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g2;
import androidx.recyclerview.widget.k2;
import androidx.recyclerview.widget.o1;

public final class y extends o1 {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f12179a;

    /* renamed from: b  reason: collision with root package name */
    public int f12180b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12181c = true;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ z f12182d;

    public y(z zVar) {
        this.f12182d = zVar;
    }

    public final boolean a(View view, RecyclerView recyclerView) {
        boolean z10;
        k2 childViewHolder = recyclerView.getChildViewHolder(view);
        boolean z11 = false;
        if (!(childViewHolder instanceof l0) || !((l0) childViewHolder).f12148l) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            return false;
        }
        boolean z12 = this.f12181c;
        int indexOfChild = recyclerView.indexOfChild(view);
        if (indexOfChild >= recyclerView.getChildCount() - 1) {
            return z12;
        }
        k2 childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(indexOfChild + 1));
        if ((childViewHolder2 instanceof l0) && ((l0) childViewHolder2).f12147k) {
            z11 = true;
        }
        return z11;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, g2 g2Var) {
        if (a(view, recyclerView)) {
            rect.bottom = this.f12180b;
        }
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, g2 g2Var) {
        if (this.f12179a != null) {
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = recyclerView.getChildAt(i10);
                if (a(childAt, recyclerView)) {
                    int height = childAt.getHeight() + ((int) childAt.getY());
                    this.f12179a.setBounds(0, height, width, this.f12180b + height);
                    this.f12179a.draw(canvas);
                }
            }
        }
    }
}
