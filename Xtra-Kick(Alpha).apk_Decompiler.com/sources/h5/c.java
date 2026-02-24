package h5;

import android.content.res.AssetManager;
import android.net.Uri;
import b5.n;
import com.bumptech.glide.load.data.k;
import v5.b;

public final class c implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public final AssetManager f7557a;

    /* renamed from: b  reason: collision with root package name */
    public final a f7558b;

    public c(AssetManager assetManager, a aVar) {
        this.f7557a = assetManager;
        this.f7558b = aVar;
    }

    public final h0 a(Object obj, int i10, int i11, n nVar) {
        k kVar;
        Uri uri = (Uri) obj;
        String substring = uri.toString().substring(22);
        b bVar = new b(uri);
        int i12 = ((b) this.f7558b).f7554a;
        AssetManager assetManager = this.f7557a;
        switch (i12) {
            case 0:
                kVar = new k(assetManager, substring, 0);
                break;
            default:
                kVar = new k(assetManager, substring, 1);
                break;
        }
        return new h0(bVar, kVar);
    }

    public final boolean b(Object obj) {
        Uri uri = (Uri) obj;
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }
}
