package z5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.j3;
import com.woxthebox.draglistview.R;
import e4.a;
import l.h;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f17637a;

    /* renamed from: b  reason: collision with root package name */
    public final j3 f17638b;

    /* renamed from: c  reason: collision with root package name */
    public final h f17639c;

    public /* synthetic */ f(LinearLayout linearLayout, j3 j3Var, h hVar, int i10) {
        this.f17637a = linearLayout;
        this.f17638b = j3Var;
        this.f17639c = hVar;
    }

    public static f a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_followed_channels, viewGroup, false);
        int i10 = R.id.recyclerViewLayout;
        View a10 = a.a(inflate, R.id.recyclerViewLayout);
        if (a10 != null) {
            j3 b10 = j3.b(a10);
            View a11 = a.a(inflate, R.id.sortBar);
            if (a11 != null) {
                return new f((LinearLayout) inflate, b10, h.j(a11), 1);
            }
            i10 = R.id.sortBar;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public static f b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_streams, viewGroup, false);
        int i10 = R.id.recyclerViewLayout;
        View a10 = a.a(inflate, R.id.recyclerViewLayout);
        if (a10 != null) {
            j3 b10 = j3.b(a10);
            View a11 = a.a(inflate, R.id.sortBar);
            if (a11 != null) {
                return new f((LinearLayout) inflate, b10, h.j(a11), 2);
            }
            i10 = R.id.sortBar;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public static f c(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_videos, viewGroup, false);
        int i10 = R.id.recyclerViewLayout;
        View a10 = a.a(inflate, R.id.recyclerViewLayout);
        if (a10 != null) {
            j3 b10 = j3.b(a10);
            View a11 = a.a(inflate, R.id.sortBar);
            if (a11 != null) {
                return new f((LinearLayout) inflate, b10, h.j(a11), 3);
            }
            i10 = R.id.sortBar;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }
}
