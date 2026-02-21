package b7;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.c0;
import androidx.fragment.app.t;
import com.woxthebox.draglistview.R;
import e4.a;
import g.i;
import g.l;
import l.h;
import xa.j;

public final class m extends t {

    /* renamed from: v0  reason: collision with root package name */
    public static final k f2659v0 = new k(0);

    /* renamed from: t0  reason: collision with root package name */
    public h f2660t0;

    /* renamed from: u0  reason: collision with root package name */
    public l f2661u0;

    public final void M(Context context) {
        l lVar;
        j.f("context", context);
        super.M(context);
        c0 c0Var = this.C;
        if (c0Var instanceof l) {
            lVar = (l) c0Var;
        } else {
            lVar = null;
        }
        this.f2661u0 = lVar;
    }

    public final void Q() {
        super.Q();
        this.f2660t0 = null;
    }

    public final Dialog n0(Bundle bundle) {
        NestedScrollView nestedScrollView;
        LayoutInflater layoutInflater = this.R;
        if (layoutInflater == null) {
            layoutInflater = c0((Bundle) null);
        }
        View inflate = layoutInflater.inflate(R.layout.dialog_user_result, (ViewGroup) null, false);
        int i10 = R.id.editText;
        EditText editText = (EditText) a.a(inflate, R.id.editText);
        if (editText != null) {
            i10 = R.id.radioButton;
            RadioButton radioButton = (RadioButton) a.a(inflate, R.id.radioButton);
            if (radioButton != null) {
                i10 = R.id.radioButton2;
                RadioButton radioButton2 = (RadioButton) a.a(inflate, R.id.radioButton2);
                if (radioButton2 != null) {
                    this.f2660t0 = new h((NestedScrollView) inflate, editText, radioButton, radioButton2, 6);
                    l lVar = new l(f0());
                    h hVar = this.f2660t0;
                    j.c(hVar);
                    int i11 = hVar.f9446h;
                    Object obj = hVar.f9447i;
                    switch (i11) {
                        case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                            nestedScrollView = (NestedScrollView) obj;
                            break;
                        default:
                            nestedScrollView = (NestedScrollView) obj;
                            break;
                    }
                    l view = lVar.setView(nestedScrollView);
                    h hVar2 = this.f2660t0;
                    j.c(hVar2);
                    view.setPositiveButton(17039370, new j(this, hVar2, 0));
                    view.setNegativeButton(17039360, new j(this, hVar2, 1));
                    j jVar = new j(this, hVar2, 2);
                    i iVar = view.f6176a;
                    iVar.f6091k = iVar.f6081a.getText(R.string.view_profile);
                    iVar.f6092l = jVar;
                    g.m create = view.create();
                    j.e("builder.create()", create);
                    return create;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }
}
