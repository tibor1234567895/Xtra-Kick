package m6;

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
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.k;
import androidx.fragment.app.z1;
import androidx.lifecycle.o0;
import androidx.lifecycle.v1;
import androidx.lifecycle.x1;
import com.github.andreyasadchy.xtra.model.VideoDownloadInfo;
import com.github.andreyasadchy.xtra.model.ui.Video;
import com.github.andreyasadchy.xtra.ui.download.VideoDownloadViewModel;
import com.github.andreyasadchy.xtra.ui.view.StrictEditText;
import com.woxthebox.draglistview.R;
import e4.a;
import fb.y;
import h6.m;
import h6.n;
import h6.o;
import hb.d1;
import hb.h0;
import hb.p0;
import java.util.List;
import la.e;
import ma.j0;
import ma.r;
import xa.j;
import xa.v;
import z5.c;

public final class z extends u {
    public static final w D0 = new w(0);
    public c B0;
    public final x1 C0;

    public z() {
        e t10 = h.t(new z1(9, this), 4);
        this.C0 = h0.K(this, v.a(VideoDownloadViewModel.class), new m(t10, 4), new n(t10, 4), new o(this, t10, 4));
    }

    public static final void u0(z zVar, c cVar, VideoDownloadInfo videoDownloadInfo, VideoDownloadInfo videoDownloadInfo2) {
        int i10;
        int i11;
        boolean z10;
        int i12;
        z zVar2 = zVar;
        c cVar2 = cVar;
        View view = cVar2.f17607m;
        StrictEditText strictEditText = (StrictEditText) view;
        j.e("timeFrom", strictEditText);
        Long v02 = zVar.v0(strictEditText);
        if (v02 != null) {
            long longValue = v02.longValue();
            StrictEditText strictEditText2 = (StrictEditText) cVar2.f17608n;
            j.e("timeTo", strictEditText2);
            Long v03 = zVar.v0(strictEditText2);
            if (v03 != null) {
                long longValue2 = v03.longValue();
                if (longValue2 > videoDownloadInfo.getTotalDuration()) {
                    strictEditText2.requestFocus();
                    i10 = R.string.to_is_longer;
                } else {
                    int i13 = (longValue > longValue2 ? 1 : (longValue == longValue2 ? 0 : -1));
                    if (i13 < 0) {
                        if (longValue == 0) {
                            i11 = 0;
                        } else {
                            int c10 = r.c(videoDownloadInfo.getRelativeStartTimes(), new y(0, longValue, longValue - videoDownloadInfo.getTargetDuration()));
                            if (c10 < 0) {
                                c10 = -c10;
                            }
                            i11 = c10;
                        }
                        long longValue3 = ((Number) ma.z.z(videoDownloadInfo.getRelativeStartTimes())).longValue();
                        if (longValue2 > videoDownloadInfo.getTotalDuration() || longValue3 > longValue2) {
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        if (z10) {
                            i12 = r.d(videoDownloadInfo.getRelativeStartTimes());
                        } else {
                            i12 = r.c(videoDownloadInfo.getRelativeStartTimes(), new y(1, videoDownloadInfo.getTargetDuration() + longValue2, longValue2));
                            if (i12 < 0) {
                                i12 = -i12;
                            }
                        }
                        String obj = ((Spinner) cVar2.f17605k).getSelectedItem().toString();
                        String concat = y.Q((String) j0.e(videoDownloadInfo2.getQualities(), obj), '/').concat(Constants.LIST_SEPARATOR);
                        VideoDownloadViewModel videoDownloadViewModel = (VideoDownloadViewModel) zVar2.C0.getValue();
                        String r02 = zVar.r0();
                        j.f("url", concat);
                        j.f("path", r02);
                        j.f("quality", obj);
                        h0.b1(d1.f7786h, (pa.h) null, 0, new b0(videoDownloadViewModel, i11, i12, r02, obj, concat, (pa.e) null), 3);
                        zVar.m0(false, false);
                        return;
                    } else if (i13 >= 0) {
                        StrictEditText strictEditText3 = (StrictEditText) view;
                        strictEditText3.requestFocus();
                        strictEditText3.setError(zVar.z(R.string.from_is_greater));
                        return;
                    } else {
                        strictEditText2.requestFocus();
                        i10 = R.string.to_is_lesser;
                    }
                }
                strictEditText2.setError(zVar.z(i10));
            }
        }
    }

    public final void J() {
        this.K = true;
        x1 x1Var = this.C0;
        ((VideoDownloadViewModel) x1Var.getValue()).f3396g.f(C(), new v1(8, new k(12, this)));
        VideoDownloadInfo videoDownloadInfo = (VideoDownloadInfo) e0().getParcelable("videoInfo");
        if (videoDownloadInfo == null) {
            VideoDownloadViewModel videoDownloadViewModel = (VideoDownloadViewModel) x1Var.getValue();
            Parcelable parcelable = e0().getParcelable("video");
            j.c(parcelable);
            Video video = (Video) parcelable;
            String string = h0.l1(f0()).getString("token_playertype_video", "channel_home_live");
            if (videoDownloadViewModel.f3396g.d() == null) {
                h0.b1(h0.I0(videoDownloadViewModel), p0.f7834b, 0, new f0(video, videoDownloadViewModel, string, (pa.e) null), 2);
                return;
            }
            return;
        }
        o0 o0Var = ((VideoDownloadViewModel) x1Var.getValue()).f3396g;
        if (!j.a(o0Var.d(), videoDownloadInfo)) {
            o0Var.l(videoDownloadInfo);
        }
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LayoutInflater layoutInflater2 = layoutInflater;
        j.f("inflater", layoutInflater2);
        View inflate = layoutInflater2.inflate(R.layout.dialog_video_download, viewGroup, false);
        int i10 = R.id.cancel;
        Button button = (Button) a.a(inflate, R.id.cancel);
        if (button != null) {
            i10 = R.id.download;
            Button button2 = (Button) a.a(inflate, R.id.download);
            if (button2 != null) {
                i10 = R.id.duration;
                TextView textView = (TextView) a.a(inflate, R.id.duration);
                if (textView != null) {
                    i10 = R.id.from;
                    TextView textView2 = (TextView) a.a(inflate, R.id.from);
                    if (textView2 != null) {
                        i10 = R.id.guideline;
                        Guideline guideline = (Guideline) a.a(inflate, R.id.guideline);
                        if (guideline != null) {
                            i10 = R.id.progressBar;
                            ProgressBar progressBar = (ProgressBar) a.a(inflate, R.id.progressBar);
                            if (progressBar != null) {
                                i10 = R.id.selectQuality;
                                TextView textView3 = (TextView) a.a(inflate, R.id.selectQuality);
                                if (textView3 != null) {
                                    i10 = R.id.specifyTime;
                                    TextView textView4 = (TextView) a.a(inflate, R.id.specifyTime);
                                    if (textView4 != null) {
                                        i10 = R.id.spinner;
                                        Spinner spinner = (Spinner) a.a(inflate, R.id.spinner);
                                        if (spinner != null) {
                                            i10 = R.id.storageSelectionContainer;
                                            View a10 = a.a(inflate, R.id.storageSelectionContainer);
                                            if (a10 != null) {
                                                u m10 = u.m(a10);
                                                i10 = R.id.timeFrom;
                                                StrictEditText strictEditText = (StrictEditText) a.a(inflate, R.id.timeFrom);
                                                if (strictEditText != null) {
                                                    i10 = R.id.timeTo;
                                                    StrictEditText strictEditText2 = (StrictEditText) a.a(inflate, R.id.timeTo);
                                                    if (strictEditText2 != null) {
                                                        i10 = R.id.to;
                                                        TextView textView5 = (TextView) a.a(inflate, R.id.to);
                                                        if (textView5 != null) {
                                                            NestedScrollView nestedScrollView = (NestedScrollView) inflate;
                                                            this.B0 = new c(nestedScrollView, button, button2, textView, textView2, guideline, progressBar, textView3, textView4, spinner, m10, strictEditText, strictEditText2, textView5);
                                                            j.e("binding.root", nestedScrollView);
                                                            return nestedScrollView;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
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

    public final Long v0(StrictEditText strictEditText) {
        CharSequence text = strictEditText.getText();
        j.e("text", text);
        CharSequence hint = text.length() == 0 ? strictEditText.getHint() : strictEditText.getText();
        j.e("value", hint);
        List E = y.E(hint, new char[]{':'});
        try {
            if (E.size() == 3) {
                long parseLong = Long.parseLong((String) E.get(0));
                long parseLong2 = Long.parseLong((String) E.get(1));
                if (parseLong2 <= 59) {
                    long parseLong3 = Long.parseLong((String) E.get(2));
                    if (parseLong3 <= 59) {
                        return Long.valueOf(((parseLong2 * ((long) 60)) + (parseLong * ((long) 3600)) + parseLong3) * ((long) 1000));
                    }
                    throw new IllegalArgumentException();
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        } catch (Exception unused) {
            strictEditText.requestFocus();
            strictEditText.setError(z(R.string.invalid_time));
            return null;
        }
    }
}
