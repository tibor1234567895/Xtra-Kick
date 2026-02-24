package b;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class b extends Binder implements c {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f2333c = 0;

    public b() {
        attachInterface(this, c.f2334a);
    }

    public final IBinder asBinder() {
        return this;
    }

    public final boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
        Object obj;
        String str = c.f2334a;
        if (i10 >= 1 && i10 <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i10 != 1598968902) {
            if (i10 == 1) {
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                String readString2 = parcel.readString();
                Parcelable.Creator creator = Notification.CREATOR;
                if (parcel.readInt() != 0) {
                    obj = creator.createFromParcel(parcel);
                } else {
                    obj = null;
                }
                f0(readString, readInt, readString2, (Notification) obj);
            } else if (i10 == 2) {
                U(parcel.readInt(), parcel.readString(), parcel.readString());
            } else if (i10 != 3) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                N(parcel.readString());
            }
            return true;
        }
        parcel2.writeString(str);
        return true;
    }
}
