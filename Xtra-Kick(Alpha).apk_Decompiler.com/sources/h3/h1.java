package h3;

import android.os.Bundle;
import com.github.andreyasadchy.xtra.ui.follow.FollowPagerFragment;
import d9.r0;
import d9.r1;
import g1.s0;
import j1.h;
import java.util.List;
import x8.k;

public final /* synthetic */ class h1 implements h, r3, k {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7067h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f7068i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f7069j;

    public /* synthetic */ h1(int i10, Object obj, boolean z10) {
        this.f7067h = i10;
        this.f7069j = obj;
        this.f7068i = z10;
    }

    public final void b(Object obj) {
        i1 i1Var = (i1) this.f7069j;
        i1Var.getClass();
        Bundle bundle = new Bundle();
        bundle.putBoolean("androidx.media3.session.ARGUMENT_CAPTIONING_ENABLED", this.f7068i);
        ((z) obj).d(i1Var.f7101e.f7172b, new f4(Bundle.EMPTY, "androidx.media3.session.SESSION_COMMAND_ON_CAPTIONING_ENABLED_CHANGED"), bundle);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r5 != 1) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(x8.h r4, int r5) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f7069j
            com.github.andreyasadchy.xtra.ui.follow.FollowPagerFragment r0 = (com.github.andreyasadchy.xtra.ui.follow.FollowPagerFragment) r0
            int r1 = com.github.andreyasadchy.xtra.ui.follow.FollowPagerFragment.f3399k0
            java.lang.String r1 = "this$0"
            xa.j.f(r1, r0)
            boolean r1 = r3.f7068i
            r2 = 1
            if (r1 == 0) goto L_0x001c
            if (r5 == 0) goto L_0x0028
            if (r5 == r2) goto L_0x0024
            r1 = 2
            if (r5 == r1) goto L_0x0018
            goto L_0x0020
        L_0x0018:
            r5 = 2131952437(0x7f130335, float:1.9541317E38)
            goto L_0x002b
        L_0x001c:
            if (r5 == 0) goto L_0x0028
            if (r5 == r2) goto L_0x0024
        L_0x0020:
            r5 = 2131951703(0x7f130057, float:1.9539828E38)
            goto L_0x002b
        L_0x0024:
            r5 = 2131952068(0x7f1301c4, float:1.9540568E38)
            goto L_0x002b
        L_0x0028:
            r5 = 2131951864(0x7f1300f8, float:1.9540155E38)
        L_0x002b:
            java.lang.String r5 = r0.z(r5)
            r4.a(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.h1.e(x8.h, int):void");
    }

    public final Object h(n2 n2Var, e2 e2Var, int i10) {
        int i11;
        int i12 = -1;
        int i13 = this.f7067h;
        long j10 = -9223372036854775807L;
        boolean z10 = this.f7068i;
        Object obj = this.f7069j;
        switch (i13) {
            case 1:
                int i14 = s3.f7316j;
                r1 n10 = r0.n((s0) obj);
                if (z10) {
                    i11 = -1;
                } else {
                    i11 = n2Var.f7246s.U();
                }
                if (!z10) {
                    j10 = n2Var.f7246s.j();
                }
                return n2Var.i(e2Var, n10, i11, j10);
            default:
                List list = (List) obj;
                int i15 = s3.f7316j;
                if (!z10) {
                    i12 = n2Var.f7246s.U();
                }
                if (!z10) {
                    j10 = n2Var.f7246s.j();
                }
                return n2Var.i(e2Var, list, i12, j10);
        }
    }

    public /* synthetic */ h1(FollowPagerFragment followPagerFragment) {
        this.f7067h = 3;
        this.f7068i = false;
        this.f7069j = followPagerFragment;
    }
}
