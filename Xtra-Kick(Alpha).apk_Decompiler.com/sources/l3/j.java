package l3;

import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.c0;
import b1.c;
import com.github.andreyasadchy.xtra.ui.clips.common.ClipsViewModel;
import com.github.andreyasadchy.xtra.ui.search.channels.ChannelSearchViewModel;
import com.github.andreyasadchy.xtra.ui.search.games.GameSearchViewModel;
import com.github.andreyasadchy.xtra.ui.search.tags.TagSearchViewModel;
import e6.x;
import f6.b;
import f6.y;
import j3.r;
import j3.r2;
import j4.a0;
import j4.d0;
import j4.e0;
import j4.f0;
import j4.h0;
import j4.i;
import j4.s;
import j4.t;
import j4.z;
import java.io.IOException;
import k6.g;
import la.v;
import n3.n4;
import q6.f;
import wa.a;
import wb.g0;
import wb.p0;
import xa.k;
import xa.q;
import xa.u;

public final class j extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9547h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f9548i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f9549j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(Object obj, int i10, Object obj2) {
        super(0);
        this.f9547h = i10;
        this.f9548i = obj;
        this.f9549j = obj2;
    }

    public final c a() {
        c cVar;
        c cVar2;
        int i10 = this.f9547h;
        Object obj = this.f9549j;
        Object obj2 = this.f9548i;
        switch (i10) {
            case 3:
                a aVar = (a) obj2;
                if (aVar == null || (cVar2 = (c) aVar.b()) == null) {
                    return ((c0) obj).d0().i();
                }
                return cVar2;
            default:
                a aVar2 = (a) obj2;
                if (aVar2 == null || (cVar = (c) aVar2.b()) == null) {
                    return ((ComponentActivity) obj).i();
                }
                return cVar;
        }
    }

    public final Object b() {
        switch (this.f9547h) {
            case 0:
                d();
                return v.f9814a;
            case 1:
                u uVar = new u();
                Object obj = this.f9548i;
                j4.c0 c0Var = (j4.c0) obj;
                e0 e0Var = c0Var.f8736a;
                if (c0Var.f8738c) {
                    int i10 = i.f8763a;
                    if (t.a(e0Var.v())) {
                        e0Var = new h0(hb.h0.o(new s(e0Var.v())), new f0(c0Var.f8737b.f14276a, 0), (d0) null);
                    }
                }
                try {
                    Drawable g10 = ImageDecoder.decodeDrawable(j4.c0.b((j4.c0) obj, e0Var), new a0(uVar, (j4.c0) obj, (q) this.f9549j));
                    xa.j.e("crossinline action: Imag…ction(info, source)\n    }", g10);
                    return g10;
                } finally {
                    ImageDecoder f10 = z.f(uVar.f16818h);
                    if (f10 != null) {
                        f10.close();
                    }
                    e0Var.close();
                }
            case 2:
                return c();
            case 3:
                return a();
            case 4:
                return a();
            case Constants.MAX_COMPATIBILITY_VERSION:
                return c();
            case 6:
                return c();
            case 7:
                return c();
            case 8:
                d();
                return v.f9814a;
            default:
                d();
                return v.f9814a;
        }
    }

    public final n4 c() {
        String str;
        int i10 = this.f9547h;
        Object obj = this.f9549j;
        Object obj2 = this.f9548i;
        switch (i10) {
            case 2:
                int i11 = k6.i.f9229a[((g) obj2).f9220b.ordinal()];
                if (i11 == 1) {
                    str = "day";
                } else if (i11 == 2) {
                    str = "week";
                } else if (i11 != 3) {
                    str = "all";
                } else {
                    str = "month";
                }
                ClipsViewModel clipsViewModel = (ClipsViewModel) obj;
                f fVar = clipsViewModel.f3374h;
                int i12 = fVar.f13359g;
                x xVar = clipsViewModel.f3372f;
                String str2 = fVar.f13360h;
                if (i12 == 0 && str2 == null) {
                    return new f6.s(fVar.f13354b, xVar, str);
                }
                if (str2 == null) {
                    str2 = "";
                }
                return new b(str2, xVar, 0);
            case Constants.MAX_COMPATIBILITY_VERSION:
                return new b((String) obj2, ((ChannelSearchViewModel) obj).f3476d, 1);
            case 6:
                return new b((String) obj2, ((GameSearchViewModel) obj).f3479d, 2);
            default:
                boolean z10 = ((TagSearchViewModel) obj2).f3489d.f5937e;
                return new y((String) obj);
        }
    }

    public final void d() {
        switch (this.f9547h) {
            case 0:
                r2 r2Var = (r2) this.f9549j;
                for (r b10 : (Iterable) r2Var.f8679f.getValue()) {
                    r2Var.b(b10);
                }
                return;
            case 8:
                wb.v vVar = (wb.v) this.f9548i;
                vVar.f16312i.a(vVar, (p0) ((u) this.f9549j).f16818h);
                return;
            default:
                try {
                    ((wb.v) this.f9548i).f16312i.b((g0) this.f9549j);
                    return;
                } catch (IOException e10) {
                    xb.s.f16851a.getClass();
                    xb.s.f16852b.getClass();
                    xb.s.i(4, "Http2Connection.Listener failure for " + ((wb.v) this.f9548i).f16314k, e10);
                    try {
                        ((g0) this.f9549j).c(wb.c.PROTOCOL_ERROR, e10);
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
        }
    }
}
