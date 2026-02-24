package j6;

import android.os.Parcelable;
import android.view.View;
import androidx.recyclerview.widget.g1;
import com.github.andreyasadchy.xtra.model.offline.Bookmark;
import com.github.andreyasadchy.xtra.model.ui.Clip;
import com.github.andreyasadchy.xtra.model.ui.Video;
import k6.b;
import m7.g;
import m7.h;
import wa.l;
import xa.j;
import z6.d;

public final /* synthetic */ class c implements View.OnLongClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8810h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Parcelable f8811i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ g1 f8812j;

    public /* synthetic */ c(g1 g1Var, Parcelable parcelable, int i10) {
        this.f8810h = i10;
        this.f8812j = g1Var;
        this.f8811i = parcelable;
    }

    public final boolean onLongClick(View view) {
        int i10 = this.f8810h;
        Parcelable parcelable = this.f8811i;
        g1 g1Var = this.f8812j;
        switch (i10) {
            case 0:
                f fVar = (f) g1Var;
                j.f("this$0", fVar);
                fVar.f8821e.invoke((Clip) parcelable);
                return true;
            case 1:
                k6.c cVar = (k6.c) g1Var;
                int i11 = b.f9199k;
                j.f("this$0", cVar);
                ((l) cVar.f9205f).invoke((Clip) parcelable);
                return true;
            case 2:
                d dVar = (d) g1Var;
                int i12 = z6.c.f17738k;
                j.f("this$0", dVar);
                dVar.f17746f.invoke((Bookmark) parcelable);
                return true;
            case 3:
                h hVar = (h) g1Var;
                int i13 = g.f10692l;
                j.f("this$0", hVar);
                hVar.f10698g.invoke((Video) parcelable);
                return true;
            default:
                n7.c cVar2 = (n7.c) g1Var;
                int i14 = n7.b.f11710k;
                j.f("this$0", cVar2);
                cVar2.f11715g.invoke((Video) parcelable);
                return true;
        }
    }
}
