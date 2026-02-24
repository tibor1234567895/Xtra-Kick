package t6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.u1;
import androidx.lifecycle.v1;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g1;
import com.github.andreyasadchy.xtra.model.ui.ChannelViewerList;
import com.woxthebox.draglistview.R;
import e4.a;
import e6.x;
import hb.h0;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import pa.e;
import pa.h;
import xa.j;
import z5.i;

public final class o0 extends q {
    public static final l0 J0 = new l0(0);
    public i A0;
    public final ArrayList B0 = new ArrayList();
    public int C0;
    public final ArrayList D0 = new ArrayList();
    public int E0;
    public final ArrayList F0 = new ArrayList();
    public int G0;
    public final androidx.lifecycle.o0 H0 = new androidx.lifecycle.o0();
    public boolean I0;

    @Inject
    public o0(x xVar) {
        j.f("repository", xVar);
    }

    public static final void s0(o0 o0Var, ChannelViewerList channelViewerList, RecyclerView recyclerView) {
        g1 g1Var;
        i iVar = o0Var.A0;
        j.c(iVar);
        RecyclerView recyclerView2 = (RecyclerView) iVar.f17673k;
        int i10 = 100;
        if (j.a(recyclerView, recyclerView2)) {
            int size = channelViewerList.getModerators().size() - o0Var.C0;
            if (size <= 100) {
                i10 = size;
            }
            ArrayList arrayList = o0Var.B0;
            List<String> moderators = channelViewerList.getModerators();
            int i11 = o0Var.C0;
            arrayList.addAll(moderators.subList(i11, i11 + i10));
            o0Var.C0 += i10;
            g1Var = recyclerView2.getAdapter();
            if (g1Var == null) {
                return;
            }
        } else {
            RecyclerView recyclerView3 = (RecyclerView) iVar.f17669g;
            if (j.a(recyclerView, recyclerView3)) {
                int size2 = channelViewerList.getVips().size() - o0Var.E0;
                if (size2 <= 100) {
                    i10 = size2;
                }
                ArrayList arrayList2 = o0Var.D0;
                List<String> vips = channelViewerList.getVips();
                int i12 = o0Var.E0;
                arrayList2.addAll(vips.subList(i12, i12 + i10));
                o0Var.E0 += i10;
                g1Var = recyclerView3.getAdapter();
                if (g1Var == null) {
                    return;
                }
            } else {
                RecyclerView recyclerView4 = (RecyclerView) iVar.f17666d;
                if (j.a(recyclerView, recyclerView4)) {
                    int size3 = channelViewerList.getViewers().size() - o0Var.G0;
                    if (size3 <= 100) {
                        i10 = size3;
                    }
                    ArrayList arrayList3 = o0Var.F0;
                    List<String> viewers = channelViewerList.getViewers();
                    int i13 = o0Var.G0;
                    arrayList3.addAll(viewers.subList(i13, i13 + i10));
                    o0Var.G0 += i10;
                    g1Var = recyclerView4.getAdapter();
                    if (g1Var == null) {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
        g1Var.notifyItemRangeChanged(g1Var.getItemCount() - i10, i10);
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        View inflate = layoutInflater.inflate(R.layout.fragment_viewer_list, viewGroup, false);
        int i10 = R.id.broadcasterList;
        RecyclerView recyclerView = (RecyclerView) a.a(inflate, R.id.broadcasterList);
        if (recyclerView != null) {
            i10 = R.id.broadcasterText;
            TextView textView = (TextView) a.a(inflate, R.id.broadcasterText);
            if (textView != null) {
                i10 = R.id.moderatorsList;
                RecyclerView recyclerView2 = (RecyclerView) a.a(inflate, R.id.moderatorsList);
                if (recyclerView2 != null) {
                    i10 = R.id.moderatorsText;
                    TextView textView2 = (TextView) a.a(inflate, R.id.moderatorsText);
                    if (textView2 != null) {
                        NestedScrollView nestedScrollView = (NestedScrollView) inflate;
                        TextView textView3 = (TextView) a.a(inflate, R.id.userCount);
                        if (textView3 != null) {
                            RecyclerView recyclerView3 = (RecyclerView) a.a(inflate, R.id.viewersList);
                            if (recyclerView3 != null) {
                                TextView textView4 = (TextView) a.a(inflate, R.id.viewersText);
                                if (textView4 != null) {
                                    RecyclerView recyclerView4 = (RecyclerView) a.a(inflate, R.id.vipsList);
                                    if (recyclerView4 != null) {
                                        TextView textView5 = (TextView) a.a(inflate, R.id.vipsText);
                                        if (textView5 != null) {
                                            this.A0 = new i(nestedScrollView, recyclerView, textView, recyclerView2, textView2, nestedScrollView, textView3, recyclerView3, textView4, recyclerView4, textView5);
                                            j.e("binding.root", nestedScrollView);
                                            return nestedScrollView;
                                        }
                                        i10 = R.id.vipsText;
                                    } else {
                                        i10 = R.id.vipsList;
                                    }
                                } else {
                                    i10 = R.id.viewersText;
                                }
                            } else {
                                i10 = R.id.viewersList;
                            }
                        } else {
                            i10 = R.id.userCount;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public final void Q() {
        super.Q();
        this.A0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        j.f("view", view);
        i iVar = this.A0;
        j.c(iVar);
        boolean z10 = this.I0;
        androidx.lifecycle.o0 o0Var = this.H0;
        if (!z10) {
            this.I0 = true;
            o0Var.l((Object) null);
            h0.b1(h0.v0(this), (h) null, 0, new m0((e) null), 3);
        }
        o0Var.f(C(), new v1(14, new u1(iVar, 10, this)));
    }
}
