package l6;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.widget.j3;
import com.github.andreyasadchy.xtra.model.ui.StreamSortEnum;
import com.woxthebox.draglistview.R;
import hb.h0;
import j7.c;
import j7.d;
import j7.f;
import j7.g;
import j7.h;
import pa.e;
import xa.j;

public final /* synthetic */ class y implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9681h = 0;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f9682i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f9683j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f9684k;

    public /* synthetic */ y(int i10, b0 b0Var, Bundle bundle) {
        this.f9682i = i10;
        this.f9683j = b0Var;
        this.f9684k = bundle;
    }

    public final void onClick(View view) {
        StreamSortEnum streamSortEnum;
        int i10 = this.f9681h;
        int i11 = this.f9682i;
        Object obj = this.f9684k;
        Object obj2 = this.f9683j;
        switch (i10) {
            case 0:
                b0 b0Var = (b0) obj2;
                Bundle bundle = (Bundle) obj;
                z zVar = b0.f9590w0;
                j.f("this$0", b0Var);
                j.f("$arguments", bundle);
                int id = view.getId();
                if (id != i11) {
                    a0 a0Var = b0Var.f9591v0;
                    if (a0Var != null) {
                        int i12 = bundle.getInt("requestCode");
                        RadioButton radioButton = (RadioButton) view;
                        CharSequence text = radioButton.getText();
                        j.e("v as RadioButton).text", text);
                        Integer num = (Integer) radioButton.getTag();
                        a0Var.f(i12, id, text);
                    } else {
                        j.l("listenerSort");
                        throw null;
                    }
                }
                b0Var.l0();
                return;
            default:
                j3 j3Var = (j3) obj2;
                h hVar = (h) obj;
                f fVar = h.f8838x0;
                j.f("$this_with", j3Var);
                j.f("this$0", hVar);
                int checkedRadioButtonId = ((RadioGroup) j3Var.f897d).getCheckedRadioButtonId();
                if (checkedRadioButtonId != i11) {
                    g gVar = hVar.f8840w0;
                    if (gVar != null) {
                        if (checkedRadioButtonId == R.id.viewers_high) {
                            streamSortEnum = StreamSortEnum.VIEWERS_HIGH;
                        } else {
                            streamSortEnum = StreamSortEnum.VIEWERS_LOW;
                        }
                        d dVar = (d) gVar;
                        j.f("sort", streamSortEnum);
                        h0.b1(h0.v0(dVar.C()), (pa.h) null, 0, new c(dVar, streamSortEnum, (e) null), 3);
                    } else {
                        j.l("listener");
                        throw null;
                    }
                }
                hVar.l0();
                return;
        }
    }

    public /* synthetic */ y(j3 j3Var, int i10, h hVar) {
        this.f9683j = j3Var;
        this.f9682i = i10;
        this.f9684k = hVar;
    }
}
