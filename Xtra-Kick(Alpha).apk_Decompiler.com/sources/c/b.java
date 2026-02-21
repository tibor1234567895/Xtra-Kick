package c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class b extends Binder implements c {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f2708c = 0;

    public b() {
        attachInterface(this, c.f2709b);
    }

    public final IBinder asBinder() {
        return this;
    }

    public final boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
        Object obj;
        String str = c.f2709b;
        if (i10 >= 1 && i10 <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i10 == 1598968902) {
            parcel2.writeString(str);
            return true;
        } else if (i10 != 1) {
            return super.onTransact(i10, parcel, parcel2, i11);
        } else {
            int readInt = parcel.readInt();
            Parcelable.Creator creator = Bundle.CREATOR;
            if (parcel.readInt() != 0) {
                obj = creator.createFromParcel(parcel);
            } else {
                obj = null;
            }
            ((e) this).x0(readInt, (Bundle) obj);
            return true;
        }
    }
}
