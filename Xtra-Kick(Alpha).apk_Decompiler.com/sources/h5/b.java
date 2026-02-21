package h5;

import android.content.res.AssetManager;

public final class b implements j0, a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7554a;

    /* renamed from: b  reason: collision with root package name */
    public final AssetManager f7555b;

    public /* synthetic */ b(AssetManager assetManager, int i10) {
        this.f7554a = i10;
        this.f7555b = assetManager;
    }

    public final i0 a(q0 q0Var) {
        int i10 = this.f7554a;
        AssetManager assetManager = this.f7555b;
        switch (i10) {
            case 0:
                return new c(assetManager, this);
            default:
                return new c(assetManager, this);
        }
    }

    public final void b() {
    }
}
