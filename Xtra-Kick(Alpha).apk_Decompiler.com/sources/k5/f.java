package k5;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.support.v4.media.session.u;
import b5.n;
import b5.p;
import d5.o0;
import java.nio.ByteBuffer;

public final class f implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f9152a;

    /* renamed from: b  reason: collision with root package name */
    public final w f9153b;

    public /* synthetic */ f(w wVar, int i10) {
        this.f9152a = i10;
        this.f9153b = wVar;
    }

    public final boolean a(Object obj, n nVar) {
        boolean z10;
        int i10 = this.f9152a;
        w wVar = this.f9153b;
        switch (i10) {
            case 0:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                wVar.getClass();
                return true;
            default:
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
                String str = Build.MANUFACTURER;
                if (("HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) && parcelFileDescriptor.getStatSize() > 536870912) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (z10) {
                    wVar.getClass();
                    if (!"robolectric".equals(Build.FINGERPRINT)) {
                        return true;
                    }
                }
                return false;
        }
    }

    public final o0 b(Object obj, int i10, int i11, n nVar) {
        int i12 = this.f9152a;
        w wVar = this.f9153b;
        switch (i12) {
            case 0:
                return wVar.a(new u((Object) (ByteBuffer) obj, (Object) wVar.f9194d, (Object) wVar.f9193c, 20, 0), i10, i11, nVar, w.f9189l);
            default:
                return wVar.a(new u((ParcelFileDescriptor) obj, wVar.f9194d, wVar.f9193c), i10, i11, nVar, w.f9189l);
        }
    }
}
