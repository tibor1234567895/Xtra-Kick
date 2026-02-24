package l6;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.c0;

public abstract class p extends c0 {

    /* renamed from: d0  reason: collision with root package name */
    public int f9656d0 = -1;

    /* renamed from: e0  reason: collision with root package name */
    public c0 f9657e0;

    /* renamed from: f0  reason: collision with root package name */
    public boolean f9658f0 = true;

    public final void K(int i10, int i11, Intent intent) {
        super.K(i10, i11, intent);
        if (i10 == 3 && i11 == -1) {
            d0().recreate();
        }
    }

    public final void N(Bundle bundle) {
        super.N(bundle);
        int i10 = -1;
        if (bundle != null) {
            i10 = bundle.getInt("previousItem", -1);
        }
        this.f9656d0 = i10;
        this.f9658f0 = bundle == null;
    }

    public final void W(Bundle bundle) {
        bundle.putInt("previousItem", this.f9656d0);
    }
}
