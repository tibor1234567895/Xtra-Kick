package t6;

import android.view.ViewTreeObserver;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.andreyasadchy.xtra.model.ui.ChannelViewerList;
import xa.j;
import z5.i;

public final /* synthetic */ class n0 implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f14638a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o0 f14639b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ChannelViewerList f14640c;

    public /* synthetic */ n0(i iVar, o0 o0Var, ChannelViewerList channelViewerList) {
        this.f14638a = iVar;
        this.f14639b = o0Var;
        this.f14640c = channelViewerList;
    }

    public final void onScrollChanged() {
        String str;
        RecyclerView recyclerView;
        i iVar = this.f14638a;
        j.f("$this_with", iVar);
        o0 o0Var = this.f14639b;
        j.f("this$0", o0Var);
        if (!((NestedScrollView) iVar.f17674l).canScrollVertically(1)) {
            int i10 = o0Var.C0;
            ChannelViewerList channelViewerList = this.f14640c;
            if (i10 != channelViewerList.getModerators().size()) {
                recyclerView = (RecyclerView) iVar.f17673k;
                str = "moderatorsList";
            } else if (o0Var.E0 != channelViewerList.getVips().size()) {
                recyclerView = (RecyclerView) iVar.f17669g;
                str = "vipsList";
            } else if (o0Var.G0 != channelViewerList.getViewers().size()) {
                recyclerView = (RecyclerView) iVar.f17666d;
                str = "viewersList";
            } else {
                return;
            }
            j.e(str, recyclerView);
            o0.s0(o0Var, channelViewerList, recyclerView);
        }
    }
}
