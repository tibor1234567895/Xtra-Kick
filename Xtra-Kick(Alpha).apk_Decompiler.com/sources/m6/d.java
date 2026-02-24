package m6;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.h;
import android.support.v4.media.session.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.i5;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.k;
import androidx.fragment.app.z1;
import androidx.lifecycle.o0;
import androidx.lifecycle.v1;
import androidx.lifecycle.x1;
import com.github.andreyasadchy.xtra.model.ui.Clip;
import com.github.andreyasadchy.xtra.ui.download.ClipDownloadViewModel;
import com.woxthebox.draglistview.R;
import e4.a;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import java.util.Map;
import la.e;
import ma.j0;
import xa.j;
import xa.v;

public final class d extends s {
    public static final c D0 = new c(0);
    public i5 B0;
    public final x1 C0;

    public d() {
        e t10 = h.t(new z1(8, this), 3);
        this.C0 = h0.K(this, v.a(ClipDownloadViewModel.class), new m(t10, 3), new n(t10, 3), new o(this, t10, 3));
    }

    public final void J() {
        boolean z10 = true;
        this.K = true;
        Bundle e02 = e0();
        x1 x1Var = this.C0;
        ClipDownloadViewModel clipDownloadViewModel = (ClipDownloadViewModel) x1Var.getValue();
        Parcelable parcelable = e02.getParcelable("clip");
        j.c(parcelable);
        Clip clip = (Clip) parcelable;
        Map map = (Map) e02.getSerializable("urls");
        if (clipDownloadViewModel.f3379g == null) {
            clipDownloadViewModel.f3379g = clip;
            if (map != null && !map.isEmpty()) {
                z10 = false;
            }
            if (z10) {
                h0.b1(h0.I0(clipDownloadViewModel), (pa.h) null, 0, new g(clip, clipDownloadViewModel, (pa.e) null), 3);
            } else {
                o0 o0Var = clipDownloadViewModel.f3378f;
                if (map == null) {
                    map = j0.d();
                }
                o0Var.l(map);
            }
        }
        ((ClipDownloadViewModel) x1Var.getValue()).f3378f.f(C(), new v1(7, new k(11, this)));
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        View inflate = layoutInflater.inflate(R.layout.dialog_clip_download, viewGroup, false);
        int i10 = R.id.cancel;
        Button button = (Button) a.a(inflate, R.id.cancel);
        if (button != null) {
            i10 = R.id.download;
            Button button2 = (Button) a.a(inflate, R.id.download);
            if (button2 != null) {
                i10 = R.id.progressBar;
                ProgressBar progressBar = (ProgressBar) a.a(inflate, R.id.progressBar);
                if (progressBar != null) {
                    i10 = R.id.selectQuality;
                    TextView textView = (TextView) a.a(inflate, R.id.selectQuality);
                    if (textView != null) {
                        i10 = R.id.spinner;
                        Spinner spinner = (Spinner) a.a(inflate, R.id.spinner);
                        if (spinner != null) {
                            i10 = R.id.storageSelectionContainer;
                            View a10 = a.a(inflate, R.id.storageSelectionContainer);
                            if (a10 != null) {
                                NestedScrollView nestedScrollView = (NestedScrollView) inflate;
                                this.B0 = new i5(nestedScrollView, button, button2, progressBar, textView, spinner, u.m(a10));
                                j.e("binding.root", nestedScrollView);
                                return nestedScrollView;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public final void Q() {
        super.Q();
        this.B0 = null;
    }
}
