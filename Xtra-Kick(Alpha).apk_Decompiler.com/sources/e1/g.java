package e1;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import c.c;

public final class g extends v {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f4905d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ c.g f4906e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(String str, c.g gVar, int i10) {
        super(str);
        this.f4905d = i10;
        this.f4906e = gVar;
    }

    public final void b() {
        Bundle bundle = null;
        int i10 = this.f4905d;
        int i11 = -1;
        c.g gVar = this.f4906e;
        switch (i10) {
            case 0:
                if ((this.f4944c & 2) == 0) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("media_item", (Parcelable) null);
                    bundle = bundle2;
                    i11 = 0;
                }
                c cVar = gVar.f2715h;
                if (cVar != null) {
                    try {
                        cVar.x0(i11, bundle);
                        return;
                    } catch (RemoteException unused) {
                        return;
                    }
                } else {
                    return;
                }
            case 1:
                int i12 = this.f4944c & 4;
                c cVar2 = gVar.f2715h;
                if (cVar2 != null) {
                    try {
                        cVar2.x0(-1, (Bundle) null);
                        return;
                    } catch (RemoteException unused2) {
                        return;
                    }
                } else {
                    return;
                }
            default:
                c cVar3 = gVar.f2715h;
                if (cVar3 != null) {
                    try {
                        cVar3.x0(0, (Bundle) null);
                        return;
                    } catch (RemoteException unused3) {
                        return;
                    }
                } else {
                    return;
                }
        }
    }
}
