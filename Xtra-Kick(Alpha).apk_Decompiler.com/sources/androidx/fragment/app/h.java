package androidx.fragment.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.i3;
import androidx.appcompat.widget.j3;
import com.github.andreyasadchy.xtra.model.Account;
import com.github.andreyasadchy.xtra.model.NotLoggedIn;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment;
import com.github.andreyasadchy.xtra.ui.games.GamesFragment;
import com.github.andreyasadchy.xtra.ui.login.LoginActivity;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import com.github.andreyasadchy.xtra.ui.settings.SettingsActivity;
import com.woxthebox.draglistview.R;
import g.l;
import g.r0;
import h3.e2;
import h3.f4;
import h3.n2;
import h3.w2;
import h3.x2;
import h6.g;
import h9.a0;
import h9.q;
import hb.h0;
import i0.e;
import j1.a;
import m.o;
import xa.j;

public final /* synthetic */ class h implements e, w2, i3 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1441h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1442i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f1443j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f1444k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f1445l;

    public /* synthetic */ h(Object obj, Object obj2, Object obj3, Object obj4, int i10) {
        this.f1441h = i10;
        this.f1442i = obj;
        this.f1443j = obj2;
        this.f1444k = obj3;
        this.f1445l = obj4;
    }

    public final void e(e2 e2Var) {
        x2 x2Var = (x2) this.f1442i;
        f4 f4Var = (f4) this.f1443j;
        Bundle bundle = (Bundle) this.f1444k;
        ResultReceiver resultReceiver = (ResultReceiver) this.f1445l;
        if (bundle == null) {
            int i10 = x2.f7435t;
            x2Var.getClass();
            bundle = Bundle.EMPTY;
        }
        n2 n2Var = x2Var.f7437g;
        a0 g10 = n2Var.f7231d.g(n2Var.f7237j, e2Var, f4Var, bundle);
        a.d(g10, "onCustomCommandOnHandler must return non-null future");
        if (resultReceiver != null) {
            g10.a(new r0(g10, 25, resultReceiver), q.f7765h);
        }
    }

    public final void f() {
        View view = (View) this.f1442i;
        n nVar = (n) this.f1443j;
        i iVar = (i) this.f1444k;
        h2 h2Var = (h2) this.f1445l;
        j.f("this$0", nVar);
        j.f("$animationInfo", iVar);
        j.f("$operation", h2Var);
        view.clearAnimation();
        nVar.f1506a.endViewTransition(view);
        iVar.b();
        if (c1.I(2)) {
            h2Var.toString();
        }
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String h12;
        int i10;
        String h13;
        int i11 = this.f1441h;
        Class<LoginActivity> cls = LoginActivity.class;
        Class<SettingsActivity> cls2 = SettingsActivity.class;
        Object obj = this.f1445l;
        Object obj2 = this.f1444k;
        Object obj3 = this.f1443j;
        Object obj4 = this.f1442i;
        switch (i11) {
            case 2:
                MainActivity mainActivity = (MainActivity) obj4;
                ChannelPagerFragment channelPagerFragment = (ChannelPagerFragment) obj3;
                Account account = (Account) obj2;
                j3 j3Var = (j3) obj;
                int i12 = ChannelPagerFragment.f3334r0;
                j.f("$activity", mainActivity);
                j.f("this$0", channelPagerFragment);
                j.f("$account", account);
                j.f("$this_apply", j3Var);
                int itemId = menuItem.getItemId();
                if (itemId == R.id.settings) {
                    mainActivity.C(channelPagerFragment, new Intent(mainActivity, cls2));
                } else if (itemId != R.id.login) {
                    ((o) j3Var.f895b).c(true);
                } else if (account instanceof NotLoggedIn) {
                    mainActivity.startActivityForResult(new Intent(mainActivity, cls), 1);
                } else {
                    l lVar = new l(mainActivity);
                    lVar.setTitle(channelPagerFragment.z(R.string.logout_title));
                    String login = account.getLogin();
                    if (login == null || (h13 = h0.h1(login)) == null) {
                        i10 = 0;
                    } else {
                        i10 = 0;
                        lVar.f6176a.f6086f = channelPagerFragment.A(R.string.logout_msg, h13);
                    }
                    lVar.a(channelPagerFragment.z(R.string.no), new g(i10));
                    lVar.b(channelPagerFragment.z(R.string.yes), new h6.h(mainActivity, i10));
                    lVar.c();
                }
                return true;
            default:
                MainActivity mainActivity2 = (MainActivity) obj4;
                GamesFragment gamesFragment = (GamesFragment) obj3;
                Account account2 = (Account) obj2;
                j3 j3Var2 = (j3) obj;
                int i13 = GamesFragment.f3425t0;
                j.f("$activity", mainActivity2);
                j.f("this$0", gamesFragment);
                j.f("$account", account2);
                j.f("$this_apply", j3Var2);
                int itemId2 = menuItem.getItemId();
                if (itemId2 == R.id.settings) {
                    mainActivity2.C(gamesFragment, new Intent(mainActivity2, cls2));
                } else if (itemId2 != R.id.login) {
                    ((o) j3Var2.f895b).c(true);
                } else if (account2 instanceof NotLoggedIn) {
                    mainActivity2.startActivityForResult(new Intent(mainActivity2, cls), 1);
                } else {
                    l lVar2 = new l(mainActivity2);
                    lVar2.setTitle(gamesFragment.z(R.string.logout_title));
                    String login2 = account2.getLogin();
                    if (!(login2 == null || (h12 = h0.h1(login2)) == null)) {
                        lVar2.f6176a.f6086f = gamesFragment.A(R.string.logout_msg, h12);
                    }
                    lVar2.a(gamesFragment.z(R.string.no), new g(5));
                    lVar2.b(gamesFragment.z(R.string.yes), new h6.h(mainActivity2, 5));
                    lVar2.c();
                }
                return true;
        }
    }
}
