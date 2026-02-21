package l6;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.MultiAutoCompleteTextView;
import androidx.fragment.app.c0;
import hb.h0;
import la.i;
import la.v;
import r7.l;
import r7.z;
import xa.j;
import z5.m;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ l f9600h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CharSequence f9601i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SpannableStringBuilder f9602j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f9603k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f9604l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f9605m;

    public /* synthetic */ g(l lVar, CharSequence charSequence, SpannableStringBuilder spannableStringBuilder, int i10, int i11, String str) {
        this.f9600h = lVar;
        this.f9601i = charSequence;
        this.f9602j = spannableStringBuilder;
        this.f9603k = i10;
        this.f9604l = i11;
        this.f9605m = str;
    }

    public final void onClick(View view) {
        l lVar = this.f9600h;
        j.f("this$0", lVar);
        CharSequence charSequence = this.f9601i;
        j.f("$originalMessage", charSequence);
        SpannableStringBuilder spannableStringBuilder = this.f9602j;
        j.f("$formattedMessage", spannableStringBuilder);
        l lVar2 = lVar.A;
        if (lVar2 != null) {
            Integer valueOf = Integer.valueOf(this.f9603k);
            Integer valueOf2 = Integer.valueOf(this.f9604l);
            int intValue = valueOf.intValue();
            int intValue2 = valueOf2.intValue();
            m mVar = lVar2.f13852h;
            MultiAutoCompleteTextView multiAutoCompleteTextView = mVar.f17716c;
            j.e("editText", multiAutoCompleteTextView);
            h0.P0(multiAutoCompleteTextView);
            mVar.f17716c.clearFocus();
            z.D0.getClass();
            z zVar = new z();
            zVar.j0(h0.r(new i("messaging", Boolean.valueOf(lVar2.f13853i)), new i("original", charSequence), new i("formatted", spannableStringBuilder), new i("userid", Integer.valueOf(intValue)), new i("channelId", Integer.valueOf(intValue2)), new i("full", this.f9605m)));
            c0 c0Var = lVar2.f13854j.E;
            if (c0Var != null) {
                zVar.q0(c0Var.u(), "closeOnPip");
                v vVar = v.f9814a;
                return;
            }
            j.l("fragment");
            throw null;
        }
    }
}
