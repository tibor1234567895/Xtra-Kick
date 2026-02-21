package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcel;
import android.os.Parcelable;
import d4.c;
import d4.d;
import java.nio.charset.Charset;

public class IconCompatParcelizer {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.core.graphics.drawable.IconCompat read(d4.c r5) {
        /*
            androidx.core.graphics.drawable.IconCompat r0 = new androidx.core.graphics.drawable.IconCompat
            r0.<init>()
            int r1 = r0.f1211a
            r2 = 1
            int r1 = r5.f(r1, r2)
            r0.f1211a = r1
            byte[] r1 = r0.f1213c
            r2 = 2
            boolean r3 = r5.e(r2)
            if (r3 != 0) goto L_0x0018
            goto L_0x002b
        L_0x0018:
            r1 = r5
            d4.d r1 = (d4.d) r1
            android.os.Parcel r1 = r1.f4329e
            int r3 = r1.readInt()
            if (r3 >= 0) goto L_0x0025
            r1 = 0
            goto L_0x002b
        L_0x0025:
            byte[] r3 = new byte[r3]
            r1.readByteArray(r3)
            r1 = r3
        L_0x002b:
            r0.f1213c = r1
            android.os.Parcelable r1 = r0.f1214d
            r3 = 3
            android.os.Parcelable r1 = r5.g(r1, r3)
            r0.f1214d = r1
            int r1 = r0.f1215e
            r4 = 4
            int r1 = r5.f(r1, r4)
            r0.f1215e = r1
            int r1 = r0.f1216f
            r4 = 5
            int r1 = r5.f(r1, r4)
            r0.f1216f = r1
            android.content.res.ColorStateList r1 = r0.f1217g
            r4 = 6
            android.os.Parcelable r1 = r5.g(r1, r4)
            android.content.res.ColorStateList r1 = (android.content.res.ColorStateList) r1
            r0.f1217g = r1
            java.lang.String r1 = r0.f1219i
            r4 = 7
            boolean r4 = r5.e(r4)
            if (r4 != 0) goto L_0x005d
            goto L_0x0066
        L_0x005d:
            r1 = r5
            d4.d r1 = (d4.d) r1
            android.os.Parcel r1 = r1.f4329e
            java.lang.String r1 = r1.readString()
        L_0x0066:
            r0.f1219i = r1
            java.lang.String r1 = r0.f1220j
            r4 = 8
            boolean r4 = r5.e(r4)
            if (r4 != 0) goto L_0x0073
            goto L_0x007b
        L_0x0073:
            d4.d r5 = (d4.d) r5
            android.os.Parcel r5 = r5.f4329e
            java.lang.String r1 = r5.readString()
        L_0x007b:
            r0.f1220j = r1
            java.lang.String r5 = r0.f1219i
            android.graphics.PorterDuff$Mode r5 = android.graphics.PorterDuff.Mode.valueOf(r5)
            r0.f1218h = r5
            int r5 = r0.f1211a
            r1 = 0
            switch(r5) {
                case -1: goto L_0x00c5;
                case 0: goto L_0x008b;
                case 1: goto L_0x00b4;
                case 2: goto L_0x0091;
                case 3: goto L_0x008c;
                case 4: goto L_0x0091;
                case 5: goto L_0x00b4;
                case 6: goto L_0x0091;
                default: goto L_0x008b;
            }
        L_0x008b:
            goto L_0x00d4
        L_0x008c:
            byte[] r5 = r0.f1213c
            r0.f1212b = r5
            goto L_0x00d4
        L_0x0091:
            java.lang.String r5 = new java.lang.String
            byte[] r3 = r0.f1213c
            java.lang.String r4 = "UTF-16"
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r4)
            r5.<init>(r3, r4)
            r0.f1212b = r5
            int r3 = r0.f1211a
            if (r3 != r2) goto L_0x00d4
            java.lang.String r2 = r0.f1220j
            if (r2 != 0) goto L_0x00d4
            java.lang.String r2 = ":"
            r3 = -1
            java.lang.String[] r5 = r5.split(r2, r3)
            r5 = r5[r1]
            r0.f1220j = r5
            goto L_0x00d4
        L_0x00b4:
            android.os.Parcelable r5 = r0.f1214d
            if (r5 == 0) goto L_0x00b9
            goto L_0x00c9
        L_0x00b9:
            byte[] r5 = r0.f1213c
            r0.f1212b = r5
            r0.f1211a = r3
            r0.f1215e = r1
            int r5 = r5.length
            r0.f1216f = r5
            goto L_0x00d4
        L_0x00c5:
            android.os.Parcelable r5 = r0.f1214d
            if (r5 == 0) goto L_0x00cc
        L_0x00c9:
            r0.f1212b = r5
            goto L_0x00d4
        L_0x00cc:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Invalid icon"
            r5.<init>(r0)
            throw r5
        L_0x00d4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompatParcelizer.read(d4.c):androidx.core.graphics.drawable.IconCompat");
    }

    public static void write(IconCompat iconCompat, c cVar) {
        cVar.getClass();
        iconCompat.f1219i = iconCompat.f1218h.name();
        switch (iconCompat.f1211a) {
            case -1:
            case 1:
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                iconCompat.f1214d = (Parcelable) iconCompat.f1212b;
                break;
            case 2:
                iconCompat.f1213c = ((String) iconCompat.f1212b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f1213c = (byte[]) iconCompat.f1212b;
                break;
            case 4:
            case 6:
                iconCompat.f1213c = iconCompat.f1212b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i10 = iconCompat.f1211a;
        if (-1 != i10) {
            cVar.j(i10, 1);
        }
        byte[] bArr = iconCompat.f1213c;
        if (bArr != null) {
            cVar.i(2);
            int length = bArr.length;
            Parcel parcel = ((d) cVar).f4329e;
            parcel.writeInt(length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f1214d;
        if (parcelable != null) {
            cVar.k(parcelable, 3);
        }
        int i11 = iconCompat.f1215e;
        if (i11 != 0) {
            cVar.j(i11, 4);
        }
        int i12 = iconCompat.f1216f;
        if (i12 != 0) {
            cVar.j(i12, 5);
        }
        ColorStateList colorStateList = iconCompat.f1217g;
        if (colorStateList != null) {
            cVar.k(colorStateList, 6);
        }
        String str = iconCompat.f1219i;
        if (str != null) {
            cVar.i(7);
            ((d) cVar).f4329e.writeString(str);
        }
        String str2 = iconCompat.f1220j;
        if (str2 != null) {
            cVar.i(8);
            ((d) cVar).f4329e.writeString(str2);
        }
    }
}
