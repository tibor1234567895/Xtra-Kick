package t6;

import a7.e;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.widget.CheckBox;
import androidx.fragment.app.c0;
import c0.g;
import com.github.andreyasadchy.xtra.model.offline.Bookmark;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import com.github.andreyasadchy.xtra.ui.saved.bookmarks.BookmarksViewModel;
import com.github.andreyasadchy.xtra.ui.saved.downloads.DownloadsViewModel;
import hb.d1;
import hb.h0;
import l.h;
import w6.d;
import w6.f;
import xa.j;

public final /* synthetic */ class w0 implements DialogInterface.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f14670h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ c0 f14671i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f14672j;

    public /* synthetic */ w0(c0 c0Var, Object obj, int i10) {
        this.f14670h = i10;
        this.f14671i = c0Var;
        this.f14672j = obj;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        int i11 = this.f14670h;
        Object obj = this.f14672j;
        c0 c0Var = this.f14671i;
        switch (i11) {
            case 0:
                z0 z0Var = (z0) c0Var;
                h hVar = (h) obj;
                x0 x0Var = z0.f14677v0;
                j.f("this$0", z0Var);
                j.f("$this_with", hVar);
                y0 y0Var = z0Var.f14679u0;
                if (y0Var != null) {
                    ((l) y0Var).A0(-1, 0, 0, ((CheckBox) hVar.f9449k).isChecked());
                    z0Var.m0(false, false);
                    return;
                }
                j.l("listener");
                throw null;
            case 1:
                f fVar = (f) c0Var;
                String str = (String) obj;
                d dVar = f.H0;
                j.f("this$0", fVar);
                ClipboardManager clipboardManager = (ClipboardManager) g.d(fVar.f0(), ClipboardManager.class);
                if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("label", str));
                }
                dialogInterface.dismiss();
                return;
            case 2:
                z6.g gVar = (z6.g) c0Var;
                Bookmark bookmark = (Bookmark) obj;
                j.f("this$0", gVar);
                j.f("$it", bookmark);
                int i12 = z6.g.f17753r0;
                BookmarksViewModel q02 = gVar.q0();
                q02.f3458e.a(gVar.f0(), bookmark);
                return;
            default:
                e eVar = (e) c0Var;
                OfflineVideo offlineVideo = (OfflineVideo) obj;
                j.f("this$0", eVar);
                j.f("$it", offlineVideo);
                int i13 = e.f277r0;
                DownloadsViewModel downloadsViewModel = (DownloadsViewModel) eVar.f279p0.getValue();
                downloadsViewModel.f3465d.a(eVar.f0(), offlineVideo);
                h0.b1(d1.f7786h, (pa.h) null, 0, new a7.h(offlineVideo, downloadsViewModel, (pa.e) null), 3);
                return;
        }
    }
}
