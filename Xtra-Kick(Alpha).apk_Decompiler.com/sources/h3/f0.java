package h3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.widget.i3;
import androidx.emoji2.text.r;
import androidx.preference.Preference;
import androidx.preference.SeekBarPreference;
import com.github.andreyasadchy.xtra.ui.settings.SettingsActivity;
import com.woxthebox.draglistview.R;
import g1.i1;
import h9.e0;
import h9.k0;
import h9.p;
import hb.h0;
import j1.a;
import j1.h;
import j1.l0;
import j1.q;
import java.io.Serializable;
import java.util.List;
import o3.s;
import s7.b;
import v1.c0;
import xa.j;

public final /* synthetic */ class f0 implements u0, q, h, w2, p, i3, s {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7018h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f7019i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f7020j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f7021k;

    public /* synthetic */ f0(Object obj, Object obj2, Object obj3, int i10) {
        this.f7018h = i10;
        this.f7019i = obj;
        this.f7020j = obj2;
        this.f7021k = obj3;
    }

    public final e0 apply(Object obj) {
        n2 n2Var = (n2) this.f7019i;
        int i10 = s3.f7316j;
        Handler handler = n2Var.f7239l;
        c0 c0Var = new c0(n2Var, (p3) this.f7020j, (e2) this.f7021k, (List) obj, 6);
        j4 j4Var = new j4(0);
        k0 n10 = k0.n();
        l0.L(handler, new r(n10, c0Var, j4Var, 5));
        return n10;
    }

    public final void b(Object obj) {
        ((z) obj).d(((i1) this.f7019i).f7101e.f7172b, new f4(Bundle.EMPTY, (String) this.f7020j), (Bundle) this.f7021k);
    }

    public final void c(Preference preference, Serializable serializable) {
        SettingsActivity.d dVar = (SettingsActivity.d) this.f7019i;
        androidx.fragment.app.f0 f0Var = (androidx.fragment.app.f0) this.f7020j;
        SeekBarPreference seekBarPreference = (SeekBarPreference) this.f7021k;
        int i10 = SettingsActivity.d.f3494s0;
        j.f("this$0", dVar);
        j.f("$activity", f0Var);
        j.f("$this_apply", seekBarPreference);
        j.f("<anonymous parameter 0>", preference);
        if (!dVar.f3496r0) {
            dVar.f3496r0 = true;
            dVar.d0().setResult(-1);
        }
        b bVar = b.f14365a;
        j.d("null cannot be cast to non-null type kotlin.Int", serializable);
        int intValue = ((Integer) serializable).intValue();
        bVar.getClass();
        int a10 = b.a(f0Var, intValue);
        seekBarPreference.v(seekBarPreference.f1887h.getString(R.string.pixels, new Object[]{Integer.valueOf(a10)}));
        SharedPreferences.Editor edit = h0.l1(f0Var).edit();
        j.e("editor", edit);
        edit.putInt("landscape_chat_width", a10);
        edit.apply();
    }

    public final void d(r rVar, int i10) {
        y0 y0Var = (y0) this.f7019i;
        y0Var.getClass();
        Bundle h10 = ((f4) this.f7020j).h();
        rVar.t(y0Var.f7455c, i10, h10, (Bundle) this.f7021k);
    }

    public final void e(e2 e2Var) {
        x2 x2Var = (x2) this.f7019i;
        f4 f4Var = (f4) this.f7020j;
        Bundle bundle = (Bundle) this.f7021k;
        if (bundle == null) {
            int i10 = x2.f7435t;
            x2Var.getClass();
            bundle = Bundle.EMPTY;
        }
        n2 n2Var = x2Var.f7437g;
        a.d(n2Var.f7231d.g(n2Var.f7237j, e2Var, f4Var, bundle), "onCustomCommandOnHandler must return non-null future");
    }

    public final void invoke(Object obj) {
        ((i1) obj).n(((Integer) this.f7021k).intValue(), ((j1) this.f7019i).f7131a.f7414j.f7117h, ((j1) this.f7020j).f7131a.f7414j.f7117h);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: com.github.andreyasadchy.xtra.model.offline.Bookmark} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: com.github.andreyasadchy.xtra.model.ui.Video} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: com.github.andreyasadchy.xtra.model.ui.Video} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: com.github.andreyasadchy.xtra.model.ui.Video} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: com.github.andreyasadchy.xtra.model.ui.Video} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onMenuItemClick(android.view.MenuItem r32) {
        /*
            r31 = this;
            r0 = r31
            r3 = 2131361930(0x7f0a008a, float:1.8343626E38)
            int r10 = r0.f7018h
            r11 = 2131362019(0x7f0a00e3, float:1.8343807E38)
            java.lang.String r12 = "$this_apply"
            java.lang.Class<com.github.andreyasadchy.xtra.ui.login.LoginActivity> r13 = com.github.andreyasadchy.xtra.ui.login.LoginActivity.class
            java.lang.Class<com.github.andreyasadchy.xtra.ui.settings.SettingsActivity> r14 = com.github.andreyasadchy.xtra.ui.settings.SettingsActivity.class
            r15 = 2131362187(0x7f0a018b, float:1.8344147E38)
            r2 = 2131362438(0x7f0a0286, float:1.8344657E38)
            java.lang.String r4 = "$account"
            java.lang.String r1 = "$activity"
            java.lang.String r7 = "this$0"
            java.lang.Object r8 = r0.f7021k
            java.lang.Object r5 = r0.f7020j
            java.lang.Object r6 = r0.f7019i
            r9 = 1
            switch(r10) {
                case 5: goto L_0x0497;
                case 6: goto L_0x0473;
                case 7: goto L_0x03f7;
                case 8: goto L_0x037a;
                case 9: goto L_0x02fd;
                case 10: goto L_0x0280;
                case 11: goto L_0x0202;
                case 12: goto L_0x0183;
                case 13: goto L_0x00f4;
                case 14: goto L_0x00cf;
                case 15: goto L_0x0026;
                case 16: goto L_0x004f;
                case 17: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x04b9
        L_0x0028:
            m7.h r6 = (m7.h) r6
            com.github.andreyasadchy.xtra.model.ui.Video r5 = (com.github.andreyasadchy.xtra.model.ui.Video) r5
            androidx.appcompat.widget.j3 r8 = (androidx.appcompat.widget.j3) r8
            int r1 = m7.g.f10692l
            xa.j.f(r7, r6)
            xa.j.f(r12, r8)
            int r1 = r32.getItemId()
            if (r1 != r11) goto L_0x003f
            wa.l r1 = r6.f10698g
            goto L_0x0043
        L_0x003f:
            if (r1 != r3) goto L_0x0047
            wa.l r1 = r6.f10699h
        L_0x0043:
            r1.invoke(r5)
            goto L_0x004e
        L_0x0047:
            java.lang.Object r1 = r8.f895b
            m.o r1 = (m.o) r1
            r1.c(r9)
        L_0x004e:
            return r9
        L_0x004f:
            com.github.andreyasadchy.xtra.ui.main.MainActivity r6 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r6
            com.github.andreyasadchy.xtra.ui.top.TopFragment r5 = (com.github.andreyasadchy.xtra.ui.top.TopFragment) r5
            com.github.andreyasadchy.xtra.model.Account r8 = (com.github.andreyasadchy.xtra.model.Account) r8
            int r3 = com.github.andreyasadchy.xtra.ui.top.TopFragment.f3513h0
            xa.j.f(r1, r6)
            xa.j.f(r7, r5)
            xa.j.f(r4, r8)
            int r1 = r32.getItemId()
            if (r1 != r2) goto L_0x006f
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r6, r14)
            r6.C(r5, r1)
            goto L_0x00ce
        L_0x006f:
            if (r1 != r15) goto L_0x00ce
            boolean r1 = r8 instanceof com.github.andreyasadchy.xtra.model.NotLoggedIn
            if (r1 == 0) goto L_0x007e
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r6, r13)
            r6.startActivityForResult(r1, r9)
            goto L_0x00ce
        L_0x007e:
            g.l r1 = new g.l
            r1.<init>(r6)
            r2 = 2131952074(0x7f1301ca, float:1.954058E38)
            java.lang.String r2 = r5.z(r2)
            r1.setTitle(r2)
            java.lang.String r2 = r8.getLogin()
            if (r2 == 0) goto L_0x00a9
            java.lang.String r2 = hb.h0.h1(r2)
            if (r2 == 0) goto L_0x00a9
            java.lang.Object[] r3 = new java.lang.Object[r9]
            r4 = 0
            r3[r4] = r2
            r2 = 2131952073(0x7f1301c9, float:1.9540578E38)
            java.lang.String r2 = r5.A(r2, r3)
            g.i r3 = r1.f6176a
            r3.f6086f = r2
        L_0x00a9:
            r2 = 2131952187(0x7f13023b, float:1.954081E38)
            java.lang.String r2 = r5.z(r2)
            h6.g r3 = new h6.g
            r4 = 9
            r3.<init>(r4)
            r1.a(r2, r3)
            r2 = 2131952458(0x7f13034a, float:1.954136E38)
            java.lang.String r2 = r5.z(r2)
            h6.h r3 = new h6.h
            r4 = 8
            r3.<init>(r6, r4)
            r1.b(r2, r3)
            r1.c()
        L_0x00ce:
            return r9
        L_0x00cf:
            a7.d r6 = (a7.d) r6
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r5 = (com.github.andreyasadchy.xtra.model.offline.OfflineVideo) r5
            androidx.appcompat.widget.j3 r8 = (androidx.appcompat.widget.j3) r8
            int r1 = a7.c.f271k
            xa.j.f(r7, r6)
            xa.j.f(r12, r8)
            int r1 = r32.getItemId()
            r2 = 2131362003(0x7f0a00d3, float:1.8343774E38)
            if (r1 != r2) goto L_0x00ec
            wa.l r1 = r6.f276c
            r1.invoke(r5)
            goto L_0x00f3
        L_0x00ec:
            java.lang.Object r1 = r8.f895b
            m.o r1 = (m.o) r1
            r1.c(r9)
        L_0x00f3:
            return r9
        L_0x00f4:
            z6.d r6 = (z6.d) r6
            com.github.andreyasadchy.xtra.model.offline.Bookmark r5 = (com.github.andreyasadchy.xtra.model.offline.Bookmark) r5
            androidx.appcompat.widget.j3 r8 = (androidx.appcompat.widget.j3) r8
            int r1 = z6.c.f17738k
            xa.j.f(r7, r6)
            xa.j.f(r12, r8)
            int r1 = r32.getItemId()
            r2 = 2131362003(0x7f0a00d3, float:1.8343774E38)
            if (r1 != r2) goto L_0x010e
            wa.l r1 = r6.f17746f
            goto L_0x0177
        L_0x010e:
            if (r1 != r11) goto L_0x015c
            java.lang.String r11 = r5.getVideoId()
            int r12 = r5.getUserId()
            java.lang.String r13 = r5.getUserLogin()
            java.lang.String r14 = r5.getUserName()
            java.lang.String r26 = r5.getUserLogo()
            int r22 = r5.getGameId()
            java.lang.String r23 = r5.getGameName()
            java.lang.String r15 = r5.getTitle()
            java.lang.String r16 = r5.getCreatedAt()
            java.lang.String r17 = r5.getThumbnail()
            java.lang.String r19 = r5.getType()
            java.lang.String r20 = r5.getDuration()
            java.lang.String r28 = r5.getAnimatedPreviewURL()
            com.github.andreyasadchy.xtra.model.ui.Video r5 = new com.github.andreyasadchy.xtra.model.ui.Video
            r10 = r5
            r18 = 0
            r21 = 0
            r24 = 0
            r25 = 0
            r27 = 0
            r29 = 91264(0x16480, float:1.27888E-40)
            r30 = 0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            wa.l r1 = r6.f17744d
            goto L_0x0177
        L_0x015c:
            r2 = 2131362617(0x7f0a0339, float:1.834502E38)
            if (r1 != r2) goto L_0x016c
            int r1 = r5.getUserId()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            wa.l r1 = r6.f17745e
            goto L_0x0177
        L_0x016c:
            r2 = 2131362374(0x7f0a0246, float:1.8344527E38)
            if (r1 != r2) goto L_0x017b
            java.lang.String r5 = r5.getVideoId()
            wa.l r1 = r6.f17743c
        L_0x0177:
            r1.invoke(r5)
            goto L_0x0182
        L_0x017b:
            java.lang.Object r1 = r8.f895b
            m.o r1 = (m.o) r1
            r1.c(r9)
        L_0x0182:
            return r9
        L_0x0183:
            com.github.andreyasadchy.xtra.ui.main.MainActivity r6 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r6
            com.github.andreyasadchy.xtra.ui.saved.SavedPagerFragment r5 = (com.github.andreyasadchy.xtra.ui.saved.SavedPagerFragment) r5
            com.github.andreyasadchy.xtra.model.Account r8 = (com.github.andreyasadchy.xtra.model.Account) r8
            int r3 = com.github.andreyasadchy.xtra.ui.saved.SavedPagerFragment.f3454k0
            xa.j.f(r1, r6)
            xa.j.f(r7, r5)
            xa.j.f(r4, r8)
            int r1 = r32.getItemId()
            if (r1 != r2) goto L_0x01a3
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r6, r14)
            r6.C(r5, r1)
            goto L_0x0201
        L_0x01a3:
            if (r1 != r15) goto L_0x0201
            boolean r1 = r8 instanceof com.github.andreyasadchy.xtra.model.NotLoggedIn
            if (r1 == 0) goto L_0x01b2
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r6, r13)
            r6.startActivityForResult(r1, r9)
            goto L_0x0201
        L_0x01b2:
            g.l r1 = new g.l
            r1.<init>(r6)
            r2 = 2131952074(0x7f1301ca, float:1.954058E38)
            java.lang.String r2 = r5.z(r2)
            r1.setTitle(r2)
            java.lang.String r2 = r8.getLogin()
            if (r2 == 0) goto L_0x01dd
            java.lang.String r2 = hb.h0.h1(r2)
            if (r2 == 0) goto L_0x01dd
            java.lang.Object[] r3 = new java.lang.Object[r9]
            r4 = 0
            r3[r4] = r2
            r2 = 2131952073(0x7f1301c9, float:1.9540578E38)
            java.lang.String r2 = r5.A(r2, r3)
            g.i r3 = r1.f6176a
            r3.f6086f = r2
        L_0x01dd:
            r2 = 2131952187(0x7f13023b, float:1.954081E38)
            java.lang.String r2 = r5.z(r2)
            h6.g r3 = new h6.g
            r4 = 8
            r3.<init>(r4)
            r1.a(r2, r3)
            r2 = 2131952458(0x7f13034a, float:1.954136E38)
            java.lang.String r2 = r5.z(r2)
            h6.h r3 = new h6.h
            r4 = 7
            r3.<init>(r6, r4)
            r1.b(r2, r3)
            r1.c()
        L_0x0201:
            return r9
        L_0x0202:
            com.github.andreyasadchy.xtra.ui.main.MainActivity r6 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r6
            com.github.andreyasadchy.xtra.ui.saved.SavedMediaFragment r5 = (com.github.andreyasadchy.xtra.ui.saved.SavedMediaFragment) r5
            com.github.andreyasadchy.xtra.model.Account r8 = (com.github.andreyasadchy.xtra.model.Account) r8
            int r3 = com.github.andreyasadchy.xtra.ui.saved.SavedMediaFragment.f3452h0
            xa.j.f(r1, r6)
            xa.j.f(r7, r5)
            xa.j.f(r4, r8)
            int r1 = r32.getItemId()
            if (r1 != r2) goto L_0x0222
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r6, r14)
            r6.C(r5, r1)
            goto L_0x027f
        L_0x0222:
            if (r1 != r15) goto L_0x027f
            boolean r1 = r8 instanceof com.github.andreyasadchy.xtra.model.NotLoggedIn
            if (r1 == 0) goto L_0x0231
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r6, r13)
            r6.startActivityForResult(r1, r9)
            goto L_0x027f
        L_0x0231:
            g.l r1 = new g.l
            r1.<init>(r6)
            r2 = 2131952074(0x7f1301ca, float:1.954058E38)
            java.lang.String r2 = r5.z(r2)
            r1.setTitle(r2)
            java.lang.String r2 = r8.getLogin()
            if (r2 == 0) goto L_0x025c
            java.lang.String r2 = hb.h0.h1(r2)
            if (r2 == 0) goto L_0x025c
            java.lang.Object[] r3 = new java.lang.Object[r9]
            r4 = 0
            r3[r4] = r2
            r2 = 2131952073(0x7f1301c9, float:1.9540578E38)
            java.lang.String r2 = r5.A(r2, r3)
            g.i r3 = r1.f6176a
            r3.f6086f = r2
        L_0x025c:
            r2 = 2131952187(0x7f13023b, float:1.954081E38)
            java.lang.String r2 = r5.z(r2)
            h6.g r3 = new h6.g
            r4 = 7
            r3.<init>(r4)
            r1.a(r2, r3)
            r2 = 2131952458(0x7f13034a, float:1.954136E38)
            java.lang.String r2 = r5.z(r2)
            h6.h r3 = new h6.h
            r4 = 6
            r3.<init>(r6, r4)
            r1.b(r2, r3)
            r1.c()
        L_0x027f:
            return r9
        L_0x0280:
            com.github.andreyasadchy.xtra.ui.main.MainActivity r6 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r6
            com.github.andreyasadchy.xtra.ui.games.GamePagerFragment r5 = (com.github.andreyasadchy.xtra.ui.games.GamePagerFragment) r5
            com.github.andreyasadchy.xtra.model.Account r8 = (com.github.andreyasadchy.xtra.model.Account) r8
            int r3 = com.github.andreyasadchy.xtra.ui.games.GamePagerFragment.f3417s0
            xa.j.f(r1, r6)
            xa.j.f(r7, r5)
            xa.j.f(r4, r8)
            int r1 = r32.getItemId()
            if (r1 != r2) goto L_0x02a0
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r6, r14)
            r6.C(r5, r1)
            goto L_0x02fc
        L_0x02a0:
            if (r1 != r15) goto L_0x02fc
            boolean r1 = r8 instanceof com.github.andreyasadchy.xtra.model.NotLoggedIn
            if (r1 == 0) goto L_0x02af
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r6, r13)
            r6.startActivityForResult(r1, r9)
            goto L_0x02fc
        L_0x02af:
            g.l r1 = new g.l
            r1.<init>(r6)
            r2 = 2131952074(0x7f1301ca, float:1.954058E38)
            java.lang.String r2 = r5.z(r2)
            r1.setTitle(r2)
            java.lang.String r2 = r8.getLogin()
            if (r2 == 0) goto L_0x02da
            java.lang.String r2 = hb.h0.h1(r2)
            if (r2 == 0) goto L_0x02da
            java.lang.Object[] r3 = new java.lang.Object[r9]
            r4 = 0
            r3[r4] = r2
            r2 = 2131952073(0x7f1301c9, float:1.9540578E38)
            java.lang.String r2 = r5.A(r2, r3)
            g.i r3 = r1.f6176a
            r3.f6086f = r2
        L_0x02da:
            r2 = 2131952187(0x7f13023b, float:1.954081E38)
            java.lang.String r2 = r5.z(r2)
            h6.g r3 = new h6.g
            r4 = 4
            r3.<init>(r4)
            r1.a(r2, r3)
            r2 = 2131952458(0x7f13034a, float:1.954136E38)
            java.lang.String r2 = r5.z(r2)
            h6.h r3 = new h6.h
            r3.<init>(r6, r4)
            r1.b(r2, r3)
            r1.c()
        L_0x02fc:
            return r9
        L_0x02fd:
            com.github.andreyasadchy.xtra.ui.main.MainActivity r6 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r6
            com.github.andreyasadchy.xtra.ui.games.GameMediaFragment r5 = (com.github.andreyasadchy.xtra.ui.games.GameMediaFragment) r5
            com.github.andreyasadchy.xtra.model.Account r8 = (com.github.andreyasadchy.xtra.model.Account) r8
            int r3 = com.github.andreyasadchy.xtra.ui.games.GameMediaFragment.f3411t0
            xa.j.f(r1, r6)
            xa.j.f(r7, r5)
            xa.j.f(r4, r8)
            int r1 = r32.getItemId()
            if (r1 != r2) goto L_0x031d
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r6, r14)
            r6.C(r5, r1)
            goto L_0x0379
        L_0x031d:
            if (r1 != r15) goto L_0x0379
            boolean r1 = r8 instanceof com.github.andreyasadchy.xtra.model.NotLoggedIn
            if (r1 == 0) goto L_0x032c
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r6, r13)
            r6.startActivityForResult(r1, r9)
            goto L_0x0379
        L_0x032c:
            g.l r1 = new g.l
            r1.<init>(r6)
            r2 = 2131952074(0x7f1301ca, float:1.954058E38)
            java.lang.String r2 = r5.z(r2)
            r1.setTitle(r2)
            java.lang.String r2 = r8.getLogin()
            if (r2 == 0) goto L_0x0357
            java.lang.String r2 = hb.h0.h1(r2)
            if (r2 == 0) goto L_0x0357
            java.lang.Object[] r3 = new java.lang.Object[r9]
            r4 = 0
            r3[r4] = r2
            r2 = 2131952073(0x7f1301c9, float:1.9540578E38)
            java.lang.String r2 = r5.A(r2, r3)
            g.i r3 = r1.f6176a
            r3.f6086f = r2
        L_0x0357:
            r2 = 2131952187(0x7f13023b, float:1.954081E38)
            java.lang.String r2 = r5.z(r2)
            h6.g r3 = new h6.g
            r4 = 3
            r3.<init>(r4)
            r1.a(r2, r3)
            r2 = 2131952458(0x7f13034a, float:1.954136E38)
            java.lang.String r2 = r5.z(r2)
            h6.h r3 = new h6.h
            r3.<init>(r6, r4)
            r1.b(r2, r3)
            r1.c()
        L_0x0379:
            return r9
        L_0x037a:
            com.github.andreyasadchy.xtra.ui.main.MainActivity r6 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r6
            com.github.andreyasadchy.xtra.ui.follow.FollowPagerFragment r5 = (com.github.andreyasadchy.xtra.ui.follow.FollowPagerFragment) r5
            com.github.andreyasadchy.xtra.model.Account r8 = (com.github.andreyasadchy.xtra.model.Account) r8
            int r3 = com.github.andreyasadchy.xtra.ui.follow.FollowPagerFragment.f3399k0
            xa.j.f(r1, r6)
            xa.j.f(r7, r5)
            xa.j.f(r4, r8)
            int r1 = r32.getItemId()
            if (r1 != r2) goto L_0x039a
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r6, r14)
            r6.C(r5, r1)
            goto L_0x03f6
        L_0x039a:
            if (r1 != r15) goto L_0x03f6
            boolean r1 = r8 instanceof com.github.andreyasadchy.xtra.model.NotLoggedIn
            if (r1 == 0) goto L_0x03a9
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r6, r13)
            r6.startActivityForResult(r1, r9)
            goto L_0x03f6
        L_0x03a9:
            g.l r1 = new g.l
            r1.<init>(r6)
            r2 = 2131952074(0x7f1301ca, float:1.954058E38)
            java.lang.String r2 = r5.z(r2)
            r1.setTitle(r2)
            java.lang.String r2 = r8.getLogin()
            if (r2 == 0) goto L_0x03d4
            java.lang.String r2 = hb.h0.h1(r2)
            if (r2 == 0) goto L_0x03d4
            java.lang.Object[] r3 = new java.lang.Object[r9]
            r4 = 0
            r3[r4] = r2
            r2 = 2131952073(0x7f1301c9, float:1.9540578E38)
            java.lang.String r2 = r5.A(r2, r3)
            g.i r3 = r1.f6176a
            r3.f6086f = r2
        L_0x03d4:
            r2 = 2131952187(0x7f13023b, float:1.954081E38)
            java.lang.String r2 = r5.z(r2)
            h6.g r3 = new h6.g
            r4 = 2
            r3.<init>(r4)
            r1.a(r2, r3)
            r2 = 2131952458(0x7f13034a, float:1.954136E38)
            java.lang.String r2 = r5.z(r2)
            h6.h r3 = new h6.h
            r3.<init>(r6, r4)
            r1.b(r2, r3)
            r1.c()
        L_0x03f6:
            return r9
        L_0x03f7:
            com.github.andreyasadchy.xtra.ui.main.MainActivity r6 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r6
            com.github.andreyasadchy.xtra.ui.follow.FollowMediaFragment r5 = (com.github.andreyasadchy.xtra.ui.follow.FollowMediaFragment) r5
            com.github.andreyasadchy.xtra.model.Account r8 = (com.github.andreyasadchy.xtra.model.Account) r8
            int r3 = com.github.andreyasadchy.xtra.ui.follow.FollowMediaFragment.f3397h0
            xa.j.f(r1, r6)
            xa.j.f(r7, r5)
            xa.j.f(r4, r8)
            int r1 = r32.getItemId()
            if (r1 != r2) goto L_0x0417
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r6, r14)
            r6.C(r5, r1)
            goto L_0x0472
        L_0x0417:
            if (r1 != r15) goto L_0x0472
            boolean r1 = r8 instanceof com.github.andreyasadchy.xtra.model.NotLoggedIn
            if (r1 == 0) goto L_0x0426
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r6, r13)
            r6.startActivityForResult(r1, r9)
            goto L_0x0472
        L_0x0426:
            g.l r1 = new g.l
            r1.<init>(r6)
            r2 = 2131952074(0x7f1301ca, float:1.954058E38)
            java.lang.String r2 = r5.z(r2)
            r1.setTitle(r2)
            java.lang.String r2 = r8.getLogin()
            if (r2 == 0) goto L_0x0451
            java.lang.String r2 = hb.h0.h1(r2)
            if (r2 == 0) goto L_0x0451
            java.lang.Object[] r3 = new java.lang.Object[r9]
            r4 = 0
            r3[r4] = r2
            r2 = 2131952073(0x7f1301c9, float:1.9540578E38)
            java.lang.String r2 = r5.A(r2, r3)
            g.i r3 = r1.f6176a
            r3.f6086f = r2
        L_0x0451:
            r2 = 2131952187(0x7f13023b, float:1.954081E38)
            java.lang.String r2 = r5.z(r2)
            h6.g r3 = new h6.g
            r3.<init>(r9)
            r1.a(r2, r3)
            r2 = 2131952458(0x7f13034a, float:1.954136E38)
            java.lang.String r2 = r5.z(r2)
            h6.h r3 = new h6.h
            r3.<init>(r6, r9)
            r1.b(r2, r3)
            r1.c()
        L_0x0472:
            return r9
        L_0x0473:
            k6.c r6 = (k6.c) r6
            com.github.andreyasadchy.xtra.model.ui.Clip r5 = (com.github.andreyasadchy.xtra.model.ui.Clip) r5
            androidx.appcompat.widget.j3 r8 = (androidx.appcompat.widget.j3) r8
            int r1 = k6.b.f9199k
            xa.j.f(r7, r6)
            xa.j.f(r12, r8)
            int r1 = r32.getItemId()
            if (r1 != r11) goto L_0x048f
            java.lang.Object r1 = r6.f9205f
            wa.l r1 = (wa.l) r1
            r1.invoke(r5)
            goto L_0x0496
        L_0x048f:
            java.lang.Object r1 = r8.f895b
            m.o r1 = (m.o) r1
            r1.c(r9)
        L_0x0496:
            return r9
        L_0x0497:
            j6.f r6 = (j6.f) r6
            com.github.andreyasadchy.xtra.model.ui.Clip r5 = (com.github.andreyasadchy.xtra.model.ui.Clip) r5
            androidx.appcompat.widget.j3 r8 = (androidx.appcompat.widget.j3) r8
            int r1 = j6.e.f8815l
            xa.j.f(r7, r6)
            xa.j.f(r12, r8)
            int r1 = r32.getItemId()
            if (r1 != r11) goto L_0x04b1
            wa.l r1 = r6.f8821e
            r1.invoke(r5)
            goto L_0x04b8
        L_0x04b1:
            java.lang.Object r1 = r8.f895b
            m.o r1 = (m.o) r1
            r1.c(r9)
        L_0x04b8:
            return r9
        L_0x04b9:
            n7.c r6 = (n7.c) r6
            com.github.andreyasadchy.xtra.model.ui.Video r5 = (com.github.andreyasadchy.xtra.model.ui.Video) r5
            androidx.appcompat.widget.j3 r8 = (androidx.appcompat.widget.j3) r8
            int r1 = n7.b.f11710k
            xa.j.f(r7, r6)
            xa.j.f(r12, r8)
            int r1 = r32.getItemId()
            if (r1 != r11) goto L_0x04d0
            wa.l r1 = r6.f11715g
            goto L_0x04d4
        L_0x04d0:
            if (r1 != r3) goto L_0x04d8
            wa.l r1 = r6.f11716h
        L_0x04d4:
            r1.invoke(r5)
            goto L_0x04df
        L_0x04d8:
            java.lang.Object r1 = r8.f895b
            m.o r1 = (m.o) r1
            r1.c(r9)
        L_0x04df:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.f0.onMenuItemClick(android.view.MenuItem):boolean");
    }
}
