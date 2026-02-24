package h4;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g2;
import androidx.recyclerview.widget.y1;
import androidx.viewpager2.widget.ViewPager2;

public final class i extends LinearLayoutManager {
    public final /* synthetic */ ViewPager2 L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(ViewPager2 viewPager2) {
        super(1);
        this.L = viewPager2;
    }

    public final void N0(g2 g2Var, int[] iArr) {
        ViewPager2 viewPager2 = this.L;
        int offscreenPageLimit = viewPager2.getOffscreenPageLimit();
        if (offscreenPageLimit == -1) {
            super.N0(g2Var, iArr);
            return;
        }
        int pageSize = viewPager2.getPageSize() * offscreenPageLimit;
        iArr[0] = pageSize;
        iArr[1] = pageSize;
    }

    public final void e0(y1 y1Var, g2 g2Var, n0.i iVar) {
        super.e0(y1Var, g2Var, iVar);
        this.L.A.getClass();
    }

    public final boolean s0(y1 y1Var, g2 g2Var, int i10, Bundle bundle) {
        this.L.A.getClass();
        return super.s0(y1Var, g2Var, i10, bundle);
    }

    public final boolean x0(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
        return false;
    }
}
