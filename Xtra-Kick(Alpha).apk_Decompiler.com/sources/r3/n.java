package r3;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class n extends Binder implements o {
    public n() {
        attachInterface(this, "androidx.room.IMultiInstanceInvalidationCallback");
    }

    public final IBinder asBinder() {
        return this;
    }

    public final boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 >= 1 && i10 <= 16777215) {
            parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationCallback");
        }
        if (i10 == 1598968902) {
            parcel2.writeString("androidx.room.IMultiInstanceInvalidationCallback");
            return true;
        } else if (i10 != 1) {
            return super.onTransact(i10, parcel, parcel2, i11);
        } else {
            ((c0) this).F(parcel.createStringArray());
            return true;
        }
    }
}
