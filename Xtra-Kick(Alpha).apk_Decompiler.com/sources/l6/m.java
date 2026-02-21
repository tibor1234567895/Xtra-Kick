package l6;

import android.content.DialogInterface;
import android.view.View;
import android.widget.FrameLayout;
import b8.h;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.woxthebox.draglistview.R;
import xa.j;

public final /* synthetic */ class m implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f9652a;

    public /* synthetic */ m(h hVar) {
        this.f9652a = hVar;
    }

    public final void onShow(DialogInterface dialogInterface) {
        int i10 = n.f9653u0;
        h hVar = this.f9652a;
        j.f("$dialog", hVar);
        View findViewById = hVar.findViewById(R.id.design_bottom_sheet);
        j.d("null cannot be cast to non-null type android.widget.FrameLayout", findViewById);
        BottomSheetBehavior w10 = BottomSheetBehavior.w((FrameLayout) findViewById);
        j.e("from(bottomSheet)", w10);
        w10.J = true;
        w10.E(3);
    }
}
