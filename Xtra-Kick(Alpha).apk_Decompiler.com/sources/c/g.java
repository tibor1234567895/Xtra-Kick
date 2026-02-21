package c;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new d();

    /* renamed from: h  reason: collision with root package name */
    public c f2715h;

    public g(Parcel parcel) {
        c cVar;
        IBinder readStrongBinder = parcel.readStrongBinder();
        int i10 = b.f2708c;
        if (readStrongBinder == null) {
            cVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface(c.f2709b);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
                cVar = new a(readStrongBinder);
            } else {
                cVar = (c) queryLocalInterface;
            }
        }
        this.f2715h = cVar;
    }

    public final int describeContents() {
        return 0;
    }

    public void u(int i10, Bundle bundle) {
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        synchronized (this) {
            if (this.f2715h == null) {
                this.f2715h = new e(this);
            }
            parcel.writeStrongBinder(this.f2715h.asBinder());
        }
    }
}
