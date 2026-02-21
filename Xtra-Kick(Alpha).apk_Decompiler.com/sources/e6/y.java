package e6;

import a6.c0;
import a6.f;
import android.content.Context;
import com.github.andreyasadchy.xtra.model.offline.Bookmark;
import fb.w;
import hb.f0;
import hb.h0;
import java.io.File;
import la.v;
import pa.e;
import r3.n0;
import ra.i;
import wa.p;

public final class y extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Bookmark f5270i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ e0 f5271j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Context f5272k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(Bookmark bookmark, e0 e0Var, Context context, e eVar) {
        super(2, eVar);
        this.f5270i = bookmark;
        this.f5271j = e0Var;
        this.f5272k = context;
    }

    public final e create(Object obj, e eVar) {
        return new y(this.f5270i, this.f5271j, this.f5272k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((y) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        boolean z10;
        h0.O1(obj);
        Bookmark bookmark = this.f5270i;
        String videoId = bookmark.getVideoId();
        if (videoId == null || w.h(videoId)) {
            z10 = true;
        } else {
            z10 = false;
        }
        Context context = this.f5272k;
        e0 e0Var = this.f5271j;
        if (!z10) {
            if (((c0) e0Var.f5107c).a(Integer.parseInt(bookmark.getVideoId())) == null) {
                String file = context.getFilesDir().toString();
                String str = File.separator;
                String videoId2 = bookmark.getVideoId();
                new File(file + str + "thumbnails" + str + videoId2 + ".png").delete();
            }
        }
        if (bookmark.getUserId() != 0) {
            if (((a6.i) e0Var.f5106b).a(bookmark.getUserId()) == null) {
                if (((c0) e0Var.f5107c).b(bookmark.getUserId()).isEmpty()) {
                    String file2 = context.getFilesDir().toString();
                    String str2 = File.separator;
                    int userId = bookmark.getUserId();
                    new File(file2 + str2 + "profile_pics" + str2 + userId + ".png").delete();
                }
            }
        }
        f fVar = (f) e0Var.f5105a;
        n0 n0Var = fVar.f234a;
        n0Var.b();
        n0Var.c();
        try {
            fVar.f236c.i(bookmark);
            n0Var.r();
            n0Var.g();
            return v.f9814a;
        } catch (Throwable th) {
            n0Var.g();
            throw th;
        }
    }
}
