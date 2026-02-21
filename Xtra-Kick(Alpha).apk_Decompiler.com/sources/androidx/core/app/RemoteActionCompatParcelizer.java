package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import d4.c;
import d4.d;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(c cVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        Object obj = remoteActionCompat.f1204a;
        boolean z10 = true;
        if (cVar.e(1)) {
            obj = cVar.h();
        }
        remoteActionCompat.f1204a = (IconCompat) obj;
        CharSequence charSequence = remoteActionCompat.f1205b;
        if (cVar.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((d) cVar).f4329e);
        }
        remoteActionCompat.f1205b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f1206c;
        if (cVar.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((d) cVar).f4329e);
        }
        remoteActionCompat.f1206c = charSequence2;
        remoteActionCompat.f1207d = (PendingIntent) cVar.g(remoteActionCompat.f1207d, 4);
        boolean z11 = remoteActionCompat.f1208e;
        if (cVar.e(5)) {
            if (((d) cVar).f4329e.readInt() != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        remoteActionCompat.f1208e = z11;
        boolean z12 = remoteActionCompat.f1209f;
        if (cVar.e(6)) {
            if (((d) cVar).f4329e.readInt() == 0) {
                z10 = false;
            }
            z12 = z10;
        }
        remoteActionCompat.f1209f = z12;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, c cVar) {
        cVar.getClass();
        IconCompat iconCompat = remoteActionCompat.f1204a;
        cVar.i(1);
        cVar.l(iconCompat);
        CharSequence charSequence = remoteActionCompat.f1205b;
        cVar.i(2);
        Parcel parcel = ((d) cVar).f4329e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f1206c;
        cVar.i(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        cVar.k(remoteActionCompat.f1207d, 4);
        boolean z10 = remoteActionCompat.f1208e;
        cVar.i(5);
        parcel.writeInt(z10 ? 1 : 0);
        boolean z11 = remoteActionCompat.f1209f;
        cVar.i(6);
        parcel.writeInt(z11 ? 1 : 0);
    }
}
