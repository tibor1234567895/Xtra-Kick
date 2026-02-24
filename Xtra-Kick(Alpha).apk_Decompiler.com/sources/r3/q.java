package r3;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class q extends Binder implements r {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f13733c = 0;

    public q() {
        attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
    }

    public final IBinder asBinder() {
        return this;
    }

    public final boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 >= 1 && i10 <= 16777215) {
            parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
        }
        if (i10 != 1598968902) {
            o oVar = null;
            if (i10 == 1) {
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof o)) {
                        oVar = new m(readStrongBinder);
                    } else {
                        oVar = (o) queryLocalInterface;
                    }
                }
                int g02 = ((e0) this).g0(oVar, parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(g02);
            } else if (i10 == 2) {
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
                    if (queryLocalInterface2 == null || !(queryLocalInterface2 instanceof o)) {
                        oVar = new m(readStrongBinder2);
                    } else {
                        oVar = (o) queryLocalInterface2;
                    }
                }
                ((e0) this).m0(oVar, parcel.readInt());
                parcel2.writeNoException();
            } else if (i10 != 3) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                ((e0) this).b0(parcel.readInt(), parcel.createStringArray());
            }
            return true;
        }
        parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
        return true;
    }
}
