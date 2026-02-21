package l6;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g2;
import androidx.recyclerview.widget.o1;
import xa.j;

public final class o extends o1 {

    /* renamed from: a  reason: collision with root package name */
    public final int f9654a;

    /* renamed from: b  reason: collision with root package name */
    public final int f9655b;

    public o(int i10, int i11) {
        this.f9654a = i10;
        this.f9655b = i11;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, g2 g2Var) {
        j.f("outRect", rect);
        j.f("view", view);
        j.f("parent", recyclerView);
        j.f("state", g2Var);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i10 = this.f9654a;
        int i11 = this.f9655b;
        if (childAdapterPosition >= i11) {
            rect.top = i10;
        }
        if ((childAdapterPosition + 1) % i11 != 0) {
            rect.right = i10;
        }
        rect.bottom = i10;
    }
}
