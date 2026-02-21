package x2;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import i1.b;
import j0.a;

public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final a f16596c = new a(16);

    /* renamed from: a  reason: collision with root package name */
    public final b f16597a;

    /* renamed from: b  reason: collision with root package name */
    public final int f16598b;

    public d(SpannableStringBuilder spannableStringBuilder, Layout.Alignment alignment, float f10, int i10, float f11, int i11, boolean z10, int i12, int i13) {
        i1.a aVar = new i1.a();
        aVar.f7953a = spannableStringBuilder;
        aVar.f7955c = alignment;
        aVar.f7957e = f10;
        aVar.f7958f = 0;
        aVar.f7959g = i10;
        aVar.f7960h = f11;
        aVar.f7961i = i11;
        aVar.f7964l = -3.4028235E38f;
        if (z10) {
            aVar.f7967o = i12;
            aVar.f7966n = true;
        }
        this.f16597a = aVar.a();
        this.f16598b = i13;
    }
}
