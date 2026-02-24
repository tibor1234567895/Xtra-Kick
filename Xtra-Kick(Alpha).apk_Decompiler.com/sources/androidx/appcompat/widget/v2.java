package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import androidx.fragment.app.c0;
import androidx.fragment.app.c1;
import androidx.preference.DropDownPreference;
import com.github.andreyasadchy.xtra.ui.follow.FollowMediaFragment;
import com.github.andreyasadchy.xtra.ui.games.GameMediaFragment;
import com.github.andreyasadchy.xtra.ui.saved.SavedMediaFragment;
import com.woxthebox.draglistview.R;
import fb.v;
import hb.h0;
import k7.a;
import o6.e;
import p6.c;
import xa.j;
import z5.h;
import z6.g;

public final class v2 implements AdapterView.OnItemSelectedListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1105h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1106i;

    public /* synthetic */ v2(int i10, Object obj) {
        this.f1105h = i10;
        this.f1106i = obj;
    }

    public final void onItemSelected(AdapterView adapterView, View view, int i10, long j10) {
        c0 c0Var;
        int i11;
        Integer d10;
        o2 o2Var;
        c0 c0Var2;
        int i12;
        Integer d11;
        c0 c0Var3;
        int i13 = this.f1105h;
        Object obj = this.f1106i;
        switch (i13) {
            case 0:
                if (i10 != -1 && (o2Var = ((b3) obj).f753j) != null) {
                    o2Var.setListSelectionHidden(false);
                    return;
                }
                return;
            case 1:
                ((SearchView) obj).q(i10);
                return;
            case 2:
                if (i10 >= 0) {
                    DropDownPreference dropDownPreference = (DropDownPreference) obj;
                    String charSequence = dropDownPreference.f1880b0[i10].toString();
                    if (!charSequence.equals(dropDownPreference.f1881c0)) {
                        dropDownPreference.a(charSequence);
                        dropDownPreference.B(charSequence);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                FollowMediaFragment followMediaFragment = (FollowMediaFragment) obj;
                int i14 = FollowMediaFragment.f3397h0;
                if (i10 != followMediaFragment.f9656d0) {
                    h hVar = followMediaFragment.f3398g0;
                    j.c(hVar);
                    if (followMediaFragment.f9658f0) {
                        String string = h0.l1(followMediaFragment.f0()).getString("ui_follow_default_page", "0");
                        if (string == null || (d11 = v.d(string)) == null) {
                            i12 = 0;
                        } else {
                            i12 = d11.intValue();
                        }
                        Spinner spinner = (Spinner) hVar.f17661g;
                        int i15 = 2;
                        if (i12 == 2) {
                            i15 = 1;
                        } else if (i12 != 3) {
                            i15 = 0;
                        }
                        spinner.setSelection(i15);
                        followMediaFragment.f9658f0 = false;
                    }
                    if (i10 == 0) {
                        c0Var2 = new a();
                    } else if (i10 != 1) {
                        c0Var2 = new c();
                    } else {
                        c0Var2 = new e();
                    }
                    c1 u10 = followMediaFragment.u();
                    u10.getClass();
                    androidx.fragment.app.a aVar = new androidx.fragment.app.a(u10);
                    aVar.e(R.id.fragmentContainer, c0Var2, (String) null);
                    aVar.g();
                    followMediaFragment.f9656d0 = i10;
                } else {
                    c0Var2 = followMediaFragment.u().D(R.id.fragmentContainer);
                }
                followMediaFragment.f9657e0 = c0Var2;
                return;
            case 4:
                GameMediaFragment gameMediaFragment = (GameMediaFragment) obj;
                if (i10 != gameMediaFragment.f3415r0) {
                    c0Var3 = gameMediaFragment.s0(i10);
                    c1 u11 = gameMediaFragment.u();
                    u11.getClass();
                    androidx.fragment.app.a aVar2 = new androidx.fragment.app.a(u11);
                    aVar2.e(R.id.fragmentContainer, c0Var3, (String) null);
                    aVar2.g();
                    gameMediaFragment.f3415r0 = i10;
                } else {
                    c0Var3 = gameMediaFragment.u().D(R.id.fragmentContainer);
                }
                gameMediaFragment.f3416s0 = c0Var3;
                return;
            default:
                SavedMediaFragment savedMediaFragment = (SavedMediaFragment) obj;
                int i16 = SavedMediaFragment.f3452h0;
                if (i10 != savedMediaFragment.f9656d0) {
                    h hVar2 = savedMediaFragment.f3453g0;
                    j.c(hVar2);
                    if (savedMediaFragment.f9658f0) {
                        Spinner spinner2 = (Spinner) hVar2.f17661g;
                        String string2 = h0.l1(savedMediaFragment.f0()).getString("ui_saved_default_page", "0");
                        if (string2 == null || (d10 = v.d(string2)) == null) {
                            i11 = 0;
                        } else {
                            i11 = d10.intValue();
                        }
                        spinner2.setSelection(i11);
                        savedMediaFragment.f9658f0 = false;
                    }
                    if (i10 == 0) {
                        c0Var = new g();
                    } else {
                        c0Var = new a7.e();
                    }
                    c1 u12 = savedMediaFragment.u();
                    u12.getClass();
                    androidx.fragment.app.a aVar3 = new androidx.fragment.app.a(u12);
                    aVar3.e(R.id.fragmentContainer, c0Var, (String) null);
                    aVar3.g();
                    savedMediaFragment.f9656d0 = i10;
                } else {
                    c0Var = savedMediaFragment.u().D(R.id.fragmentContainer);
                }
                savedMediaFragment.f9657e0 = c0Var;
                return;
        }
    }

    public final void onNothingSelected(AdapterView adapterView) {
    }
}
