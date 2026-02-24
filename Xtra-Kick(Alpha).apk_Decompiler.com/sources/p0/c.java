package p0;

import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.Display;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import androidx.fragment.app.g;
import androidx.fragment.app.h2;
import androidx.fragment.app.j1;
import b2.t;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment;
import com.github.andreyasadchy.xtra.ui.games.GamePagerFragment;
import com.github.andreyasadchy.xtra.ui.saved.SavedPagerFragment;
import com.github.andreyasadchy.xtra.ui.search.SearchPagerFragment;
import com.woxthebox.draglistview.R;
import d2.f0;
import d2.i;
import d7.f;
import g1.g1;
import g1.i1;
import g1.l1;
import g1.z0;
import h3.a4;
import h3.b0;
import h3.d2;
import h3.e2;
import h3.i4;
import h3.j4;
import h3.l4;
import h3.m2;
import h3.n1;
import h3.n2;
import h3.o1;
import h3.o3;
import h3.r3;
import h3.s3;
import h3.t3;
import h3.y0;
import h3.z;
import h9.a0;
import i0.e;
import i1.d;
import j1.a;
import j1.h;
import j1.l0;
import j1.q;
import j1.v;
import j3.k0;
import m0.c1;
import m3.b;
import o8.k;
import xa.j;

public final /* synthetic */ class c implements e, q, h, i, n1, m2, r3, o3, k, x8.k, j1 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f12403h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f12404i;

    public /* synthetic */ c(int i10, Object obj) {
        this.f12403h = i10;
        this.f12404i = obj;
    }

    public final boolean a(MenuItem menuItem) {
        k0 k0Var = (k0) this.f12404i;
        int i10 = b.f10568a;
        j.f("$navController", k0Var);
        j.f("item", menuItem);
        return b.b(menuItem, k0Var);
    }

    public final void b(Object obj) {
        int i10 = this.f12403h;
        Object obj2 = this.f12404i;
        switch (i10) {
            case Constants.MAX_COMPATIBILITY_VERSION:
                ((p1.q) obj).e((Exception) obj2);
                return;
            case 10:
                ((b0) obj2).getClass();
                ((z) obj).b();
                return;
            case 18:
                int i11 = s3.f7316j;
                ((a4) obj).n((Surface) obj2);
                return;
            default:
                a4 a4Var = (a4) obj;
                n2 n2Var = (n2) ((s3) obj2).f7317d.get();
                if (n2Var != null && !n2Var.f() && n2Var.h()) {
                    a4Var.P();
                    return;
                }
                return;
        }
    }

    public final void c(a4 a4Var, e2 e2Var) {
        int i10 = s3.f7316j;
        ((h) this.f12404i).b(a4Var);
    }

    public final long d(long j10) {
        f0 f0Var = (f0) this.f12404i;
        return l0.i((j10 * ((long) f0Var.f4177e)) / 1000000, 0, f0Var.f4182j - 1);
    }

    public final void e(x8.h hVar, int i10) {
        int i11;
        int i12 = this.f12403h;
        int i13 = R.string.clips;
        int i14 = R.string.videos;
        Object obj = this.f12404i;
        switch (i12) {
            case 24:
                ChannelPagerFragment channelPagerFragment = (ChannelPagerFragment) obj;
                int i15 = ChannelPagerFragment.f3334r0;
                j.f("this$0", channelPagerFragment);
                if (i10 == 0) {
                    i13 = R.string.videos;
                } else if (i10 != 1) {
                    i13 = R.string.chat;
                }
                hVar.a(channelPagerFragment.z(i13));
                return;
            case 25:
                GamePagerFragment gamePagerFragment = (GamePagerFragment) obj;
                int i16 = GamePagerFragment.f3417s0;
                j.f("this$0", gamePagerFragment);
                if (i10 == 0) {
                    i13 = R.string.videos;
                } else if (i10 == 1) {
                    i13 = R.string.live;
                }
                hVar.a(gamePagerFragment.z(i13));
                return;
            case 26:
                SavedPagerFragment savedPagerFragment = (SavedPagerFragment) obj;
                int i17 = SavedPagerFragment.f3454k0;
                j.f("this$0", savedPagerFragment);
                if (i10 == 0) {
                    i11 = R.string.bookmarks;
                } else {
                    i11 = R.string.downloads;
                }
                hVar.a(savedPagerFragment.z(i11));
                return;
            default:
                SearchPagerFragment searchPagerFragment = (SearchPagerFragment) obj;
                int i18 = SearchPagerFragment.f3468s0;
                j.f("this$0", searchPagerFragment);
                if (i10 != 0) {
                    if (i10 == 1) {
                        i14 = R.string.streams;
                    } else if (i10 != 2) {
                        i14 = R.string.games;
                    } else {
                        i14 = R.string.channels;
                    }
                }
                hVar.a(searchPagerFragment.z(i14));
                return;
        }
    }

    public final void f() {
        h2 h2Var = (h2) this.f12404i;
        j.f("this$0", h2Var);
        h2Var.a();
    }

    public final void g(y0 y0Var) {
        b0 b0Var = y0Var.f7453a;
        int i10 = this.f12403h;
        Object obj = this.f12404i;
        switch (i10) {
            case 11:
                h3.i iVar = (h3.i) obj;
                int i11 = o1.f7265e;
                if (y0Var.f7475w != null) {
                    v.c("MCImplBase", "Cannot be notified about the connection result many times. Probably a bug or malicious app.");
                } else {
                    y0Var.f7475w = iVar.f7091j;
                    y0Var.f7467o = iVar.f7093l;
                    g1 g1Var = iVar.f7094m;
                    y0Var.f7468p = g1Var;
                    g1 g1Var2 = iVar.f7095n;
                    y0Var.f7469q = g1Var2;
                    y0Var.f7470r = t3.y(g1Var, g1Var2);
                    y0Var.f7466n = iVar.f7097p;
                    try {
                        iVar.f7091j.asBinder().linkToDeath(y0Var.f7459g, 0);
                        l4 l4Var = y0Var.f7457e;
                        new l4(l4Var.f7191h.a(), iVar.f7089h, iVar.f7090i, l4Var.f7191h.g(), iVar.f7091j, iVar.f7096o);
                        b0Var.Q0();
                        return;
                    } catch (RemoteException unused) {
                    }
                }
                b0Var.a();
                return;
            case 12:
                Bundle bundle = (Bundle) obj;
                int i12 = o1.f7265e;
                if (y0Var.H0()) {
                    b0Var.R0(new g(y0Var, 20, bundle));
                    return;
                }
                return;
            default:
                i4 i4Var = (i4) obj;
                int i13 = o1.f7265e;
                if (y0Var.H0() && y0Var.f7463k.isEmpty()) {
                    i4 i4Var2 = y0Var.f7466n.f7414j;
                    if (i4Var2.f7119j < i4Var.f7119j && t3.a(i4Var, i4Var2)) {
                        y0Var.f7466n = y0Var.f7466n.m(i4Var);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public final Object h(n2 n2Var, e2 e2Var, int i10) {
        int i11 = this.f12403h;
        Object obj = this.f12404i;
        switch (i11) {
            case 17:
                int i12 = s3.f7316j;
                a0 f10 = n2Var.f7231d.f(n2Var.f7237j, e2Var, (l1) obj);
                a.d(f10, "onSetRating must return non-null future");
                return f10;
            case 20:
                android.support.v4.media.h.y(n2Var);
                int i13 = s3.f7316j;
                throw null;
            default:
                o3 o3Var = (o3) obj;
                int i14 = s3.f7316j;
                if (!n2Var.f()) {
                    o3Var.c(n2Var.f7246s, e2Var);
                    s3.I0(e2Var, i10, new j4(0));
                }
                return a0.f7718i;
        }
    }

    public final void i(d2 d2Var, int i10) {
        int i11 = this.f12403h;
        Object obj = this.f12404i;
        switch (i11) {
            case 14:
                g1.q qVar = ((n2) obj).f7245r.f7427w;
                d2Var.l();
                return;
            case 15:
                d2Var.v();
                return;
            default:
                d2Var.c((g1.h) obj);
                return;
        }
    }

    public final void invoke(Object obj) {
        int i10 = this.f12403h;
        Object obj2 = this.f12404i;
        switch (i10) {
            case 2:
                ((i1) obj).t(((m1.k0) obj2).f10314h.N);
                return;
            case 3:
                ((i1) obj).S((z0) obj2);
                return;
            default:
                ((i1) obj).R((d) obj2);
                return;
        }
    }

    public final void j(Bundle bundle, String str) {
        int i10 = this.f12403h;
        Object obj = this.f12404i;
        switch (i10) {
            case 28:
                c7.h hVar = (c7.h) obj;
                int i11 = c7.h.f2991s0;
                j.f("this$0", hVar);
                j.f("<anonymous parameter 0>", str);
                if (bundle.getBoolean("refresh")) {
                    o6.c cVar = hVar.f2994r0;
                    if (cVar != null) {
                        cVar.b();
                        return;
                    } else {
                        j.l("pagingAdapter");
                        throw null;
                    }
                } else {
                    return;
                }
            default:
                f fVar = (f) obj;
                int i12 = f.f4577s0;
                j.f("this$0", fVar);
                j.f("<anonymous parameter 0>", str);
                if (bundle.getBoolean("refresh")) {
                    o6.c cVar2 = fVar.f4580r0;
                    if (cVar2 != null) {
                        cVar2.b();
                        return;
                    } else {
                        j.l("pagingAdapter");
                        throw null;
                    }
                } else {
                    return;
                }
        }
    }

    public final boolean k(e.a aVar, int i10, Bundle bundle) {
        View view = (View) this.f12404i;
        if (Build.VERSION.SDK_INT >= 25 && (i10 & 1) != 0) {
            try {
                ((g) aVar.f4852i).h();
                InputContentInfo d10 = a.d(((g) aVar.f4852i).f());
                if (bundle == null) {
                    bundle = new Bundle();
                } else {
                    bundle = new Bundle(bundle);
                }
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", d10);
            } catch (Exception e10) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e10);
            }
        }
        e.a aVar2 = new e.a(new ClipData(((g) aVar.f4852i).getDescription(), new ClipData.Item(((g) aVar.f4852i).g())), 2);
        ((m0.f) aVar2.f4852i).e(((g) aVar.f4852i).i());
        ((m0.f) aVar2.f4852i).c(bundle);
        if (c1.l(view, ((m0.f) aVar2.f4852i).a()) == null) {
            return true;
        }
        return false;
    }

    public final void l(Display display) {
        long j10;
        t tVar = (t) this.f12404i;
        tVar.getClass();
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            tVar.f2494k = refreshRate;
            j10 = (refreshRate * 80) / 100;
        } else {
            v.g("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            j10 = -9223372036854775807L;
            tVar.f2494k = -9223372036854775807L;
        }
        tVar.f2495l = j10;
    }
}
