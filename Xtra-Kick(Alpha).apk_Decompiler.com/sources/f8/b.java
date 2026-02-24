package f8;

import android.graphics.Typeface;
import com.google.android.material.chip.Chip;
import m8.n;
import m8.o;
import q8.h;

public final class b extends h {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5940a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f5941b;

    public /* synthetic */ b(int i10, Object obj) {
        this.f5940a = i10;
        this.f5941b = obj;
    }

    public final void a(int i10) {
        switch (this.f5940a) {
            case 0:
                return;
            default:
                o oVar = (o) this.f5941b;
                oVar.f10790d = true;
                n nVar = (n) oVar.f10791e.get();
                if (nVar != null) {
                    nVar.a();
                    return;
                }
                return;
        }
    }

    public final void b(Typeface typeface, boolean z10) {
        CharSequence charSequence;
        int i10 = this.f5940a;
        Object obj = this.f5941b;
        switch (i10) {
            case 0:
                Chip chip = (Chip) obj;
                f fVar = chip.f3719l;
                if (fVar.K0) {
                    charSequence = fVar.L;
                } else {
                    charSequence = chip.getText();
                }
                chip.setText(charSequence);
                chip.requestLayout();
                chip.invalidate();
                return;
            default:
                if (!z10) {
                    o oVar = (o) obj;
                    oVar.f10790d = true;
                    n nVar = (n) oVar.f10791e.get();
                    if (nVar != null) {
                        nVar.a();
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
