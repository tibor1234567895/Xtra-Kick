package b7;

import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.RadioButton;
import com.github.andreyasadchy.xtra.ui.search.SearchPagerFragment;
import fb.v;
import l.h;

public final /* synthetic */ class j implements DialogInterface.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f2656h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ m f2657i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ h f2658j;

    public /* synthetic */ j(m mVar, h hVar, int i10) {
        this.f2656h = i10;
        this.f2657i = mVar;
        this.f2658j = hVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        int i11;
        int i12;
        int i13;
        int i14 = this.f2656h;
        h hVar = this.f2658j;
        m mVar = this.f2657i;
        switch (i14) {
            case 0:
                k kVar = m.f2659v0;
                xa.j.f("this$0", mVar);
                xa.j.f("$this_with", hVar);
                l lVar = mVar.f2661u0;
                if (lVar != null) {
                    boolean isChecked = true ^ ((RadioButton) hVar.f9449k).isChecked();
                    Integer d10 = v.d(((EditText) hVar.f9448j).getText().toString());
                    if (d10 != null) {
                        i12 = d10.intValue();
                    } else {
                        i12 = 0;
                    }
                    ((SearchPagerFragment) lVar).r0(0, isChecked ? 1 : 0, i12);
                }
                mVar.m0(false, false);
                return;
            case 1:
                k kVar2 = m.f2659v0;
                xa.j.f("this$0", mVar);
                xa.j.f("$this_with", hVar);
                l lVar2 = mVar.f2661u0;
                if (lVar2 != null) {
                    boolean z10 = !((RadioButton) hVar.f9449k).isChecked();
                    Integer d11 = v.d(((EditText) hVar.f9448j).getText().toString());
                    if (d11 != null) {
                        i13 = d11.intValue();
                    } else {
                        i13 = 0;
                    }
                    ((SearchPagerFragment) lVar2).r0(1, z10 ? 1 : 0, i13);
                }
                mVar.m0(false, false);
                return;
            default:
                k kVar3 = m.f2659v0;
                xa.j.f("this$0", mVar);
                xa.j.f("$this_with", hVar);
                l lVar3 = mVar.f2661u0;
                if (lVar3 != null) {
                    boolean isChecked2 = true ^ ((RadioButton) hVar.f9449k).isChecked();
                    Integer d12 = v.d(((EditText) hVar.f9448j).getText().toString());
                    if (d12 != null) {
                        i11 = d12.intValue();
                    } else {
                        i11 = 0;
                    }
                    ((SearchPagerFragment) lVar3).r0(2, isChecked2 ? 1 : 0, i11);
                }
                mVar.m0(false, false);
                return;
        }
    }
}
