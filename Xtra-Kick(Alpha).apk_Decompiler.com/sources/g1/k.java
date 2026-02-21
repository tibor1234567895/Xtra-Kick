package g1;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import d9.o0;
import d9.p0;
import d9.r0;
import d9.r1;
import j1.l0;
import java.util.List;

public final class k extends Binder {

    /* renamed from: d  reason: collision with root package name */
    public static final int f6439d = (l0.f8453a >= 30 ? IBinder.getSuggestedMaxIpcSizeBytes() : 65536);

    /* renamed from: c  reason: collision with root package name */
    public final r0 f6440c;

    public k(List list) {
        this.f6440c = r0.j(list);
    }

    public static r1 a(IBinder iBinder) {
        int readInt;
        p0 p0Var = r0.f4657i;
        o0 o0Var = new o0();
        int i10 = 1;
        int i11 = 0;
        while (i10 != 0) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInt(i11);
                iBinder.transact(1, obtain, obtain2, 0);
                while (true) {
                    readInt = obtain2.readInt();
                    if (readInt != 1) {
                        break;
                    }
                    Bundle readBundle = obtain2.readBundle();
                    readBundle.getClass();
                    o0Var.c(readBundle);
                    i11++;
                }
                obtain2.recycle();
                obtain.recycle();
                i10 = readInt;
            } catch (RemoteException e10) {
                throw new RuntimeException(e10);
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }
        return o0Var.e();
    }

    public final boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 != 1) {
            return super.onTransact(i10, parcel, parcel2, i11);
        }
        int i12 = 0;
        if (parcel2 == null) {
            return false;
        }
        r0 r0Var = this.f6440c;
        int size = r0Var.size();
        int readInt = parcel.readInt();
        while (readInt < size && parcel2.dataSize() < f6439d) {
            parcel2.writeInt(1);
            parcel2.writeBundle((Bundle) r0Var.get(readInt));
            readInt++;
        }
        if (readInt < size) {
            i12 = 2;
        }
        parcel2.writeInt(i12);
        return true;
    }
}
