package m0;

import android.view.View;

public final class e0 extends g0 {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f10071e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e0(int i10, int i11) {
        super(i10, Boolean.class, 0, 28);
        this.f10071e = i11;
    }

    public final Boolean d(View view) {
        switch (this.f10071e) {
            case 0:
                return Boolean.valueOf(u0.d(view));
            default:
                return Boolean.valueOf(u0.c(view));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e0(int i10, int i11, int i12, int i13) {
        super(i10, CharSequence.class, i11, i12);
        this.f10071e = i13;
    }
}
