package z6;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.j3;
import com.github.andreyasadchy.xtra.model.offline.Bookmark;
import com.woxthebox.draglistview.R;
import fb.w;
import h3.f0;
import hb.h0;
import java.util.Locale;
import m.o;
import xa.j;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Context f17734h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Bookmark f17735i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f17736j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ d f17737k;

    public /* synthetic */ b(Context context, Bookmark bookmark, boolean z10, d dVar) {
        this.f17734h = context;
        this.f17735i = bookmark;
        this.f17736j = z10;
        this.f17737k = dVar;
    }

    public final void onClick(View view) {
        boolean z10;
        String str;
        int i10;
        MenuItem menuItem;
        Context context = this.f17734h;
        j.f("$context", context);
        d dVar = this.f17737k;
        j.f("this$0", dVar);
        j3 j3Var = new j3(context, view);
        j3Var.f(R.menu.offline_item);
        Bookmark bookmark = this.f17735i;
        String videoId = bookmark.getVideoId();
        if (videoId == null || w.h(videoId)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            ((o) j3Var.f895b).findItem(R.id.refresh).setVisible(true);
            ((o) j3Var.f895b).findItem(R.id.download).setVisible(true);
        }
        String type = bookmark.getType();
        if (type != null) {
            str = type.toLowerCase(Locale.ROOT);
            j.e("this as java.lang.String).toLowerCase(Locale.ROOT)", str);
        } else {
            str = null;
        }
        if (j.a(str, "archive")) {
            bookmark.getUserId();
            if (h0.l1(context).getBoolean("ui_bookmark_time_left", true)) {
                ((o) j3Var.f895b).findItem(R.id.vodIgnore).setVisible(true);
                if (this.f17736j) {
                    menuItem = ((o) j3Var.f895b).findItem(R.id.vodIgnore);
                    i10 = R.string.vod_remove_ignore;
                } else {
                    menuItem = ((o) j3Var.f895b).findItem(R.id.vodIgnore);
                    i10 = R.string.vod_ignore_user;
                }
                menuItem.setTitle(context.getString(i10));
            }
        }
        j3Var.f898e = new f0(dVar, bookmark, j3Var, 13);
        j3Var.h();
    }
}
