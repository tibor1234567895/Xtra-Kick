package l6;

import android.content.DialogInterface;
import android.os.Bundle;
import com.github.andreyasadchy.xtra.ui.search.SearchPagerFragment;
import xa.j;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9587h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ d f9588i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Bundle f9589j;

    public /* synthetic */ a(d dVar, Bundle bundle, int i10) {
        this.f9587h = i10;
        this.f9588i = dVar;
        this.f9589j = bundle;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        int i11 = this.f9587h;
        Bundle bundle = this.f9589j;
        d dVar = this.f9588i;
        switch (i11) {
            case 0:
                b bVar = d.f9592u0;
                j.f("this$0", dVar);
                j.f("$args", bundle);
                c cVar = dVar.f9593t0;
                if (cVar != null) {
                    SearchPagerFragment searchPagerFragment = (SearchPagerFragment) cVar;
                    if (bundle.getInt("requestCode") == 0) {
                        searchPagerFragment.s0();
                    }
                }
                dVar.m0(false, false);
                return;
            case 1:
                b bVar2 = d.f9592u0;
                j.f("this$0", dVar);
                j.f("$args", bundle);
                if (dVar.f9593t0 != null) {
                    int i12 = bundle.getInt("requestCode");
                }
                dVar.m0(false, false);
                return;
            default:
                b bVar3 = d.f9592u0;
                j.f("this$0", dVar);
                j.f("$args", bundle);
                if (dVar.f9593t0 != null) {
                    int i13 = bundle.getInt("requestCode");
                }
                dVar.m0(false, false);
                return;
        }
    }
}
