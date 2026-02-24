package androidx.appcompat.widget;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;
import g.i;
import g.l;
import g.m;

public final class a1 implements g1, DialogInterface.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public m f721h;

    /* renamed from: i  reason: collision with root package name */
    public ListAdapter f722i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f723j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ h1 f724k;

    public a1(h1 h1Var) {
        this.f724k = h1Var;
    }

    public final boolean b() {
        m mVar = this.f721h;
        if (mVar != null) {
            return mVar.isShowing();
        }
        return false;
    }

    public final int c() {
        return 0;
    }

    public final void dismiss() {
        m mVar = this.f721h;
        if (mVar != null) {
            mVar.dismiss();
            this.f721h = null;
        }
    }

    public final Drawable e() {
        return null;
    }

    public final void h(CharSequence charSequence) {
        this.f723j = charSequence;
    }

    public final void i(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    public final void j(int i10) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    public final void k(int i10) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    public final void l(int i10) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    public final void m(int i10, int i11) {
        if (this.f722i != null) {
            h1 h1Var = this.f724k;
            l lVar = new l(h1Var.getPopupContext());
            CharSequence charSequence = this.f723j;
            if (charSequence != null) {
                lVar.setTitle(charSequence);
            }
            ListAdapter listAdapter = this.f722i;
            int selectedItemPosition = h1Var.getSelectedItemPosition();
            i iVar = lVar.f6176a;
            iVar.f6096p = listAdapter;
            iVar.f6097q = this;
            iVar.f6102v = selectedItemPosition;
            iVar.f6101u = true;
            m create = lVar.create();
            this.f721h = create;
            AlertController$RecycleListView alertController$RecycleListView = create.f6179l.f6127g;
            y0.d(alertController$RecycleListView, i10);
            y0.c(alertController$RecycleListView, i11);
            this.f721h.show();
        }
    }

    public final int n() {
        return 0;
    }

    public final CharSequence o() {
        return this.f723j;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        h1 h1Var = this.f724k;
        h1Var.setSelection(i10);
        if (h1Var.getOnItemClickListener() != null) {
            h1Var.performItemClick((View) null, i10, this.f722i.getItemId(i10));
        }
        dismiss();
    }

    public final void p(ListAdapter listAdapter) {
        this.f722i = listAdapter;
    }
}
