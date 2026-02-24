package m2;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.h;
import g1.a0;
import g1.y0;
import j1.l0;

public class d implements y0 {
    public static final Parcelable.Creator<d> CREATOR = new c();

    /* renamed from: h  reason: collision with root package name */
    public final String f10564h;

    /* renamed from: i  reason: collision with root package name */
    public final String f10565i;

    public d(Parcel parcel) {
        String readString = parcel.readString();
        int i10 = l0.f8453a;
        this.f10564h = readString;
        this.f10565i = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f10564h.equals(dVar.f10564h) && this.f10565i.equals(dVar.f10565i);
    }

    public final /* synthetic */ a0 g() {
        return null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(g1.u0 r7) {
        /*
            r6 = this;
            java.lang.String r0 = r6.f10564h
            r0.getClass()
            int r1 = r0.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r1) {
                case 62359119: goto L_0x003d;
                case 79833656: goto L_0x0032;
                case 428414940: goto L_0x0027;
                case 1746739798: goto L_0x001c;
                case 1939198791: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x0048
        L_0x0011:
            java.lang.String r1 = "ARTIST"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x001a
            goto L_0x0048
        L_0x001a:
            r0 = 4
            goto L_0x0049
        L_0x001c:
            java.lang.String r1 = "ALBUMARTIST"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0025
            goto L_0x0048
        L_0x0025:
            r0 = 3
            goto L_0x0049
        L_0x0027:
            java.lang.String r1 = "DESCRIPTION"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0030
            goto L_0x0048
        L_0x0030:
            r0 = 2
            goto L_0x0049
        L_0x0032:
            java.lang.String r1 = "TITLE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003b
            goto L_0x0048
        L_0x003b:
            r0 = 1
            goto L_0x0049
        L_0x003d:
            java.lang.String r1 = "ALBUM"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r0 = 0
            goto L_0x0049
        L_0x0048:
            r0 = -1
        L_0x0049:
            java.lang.String r1 = r6.f10565i
            if (r0 == 0) goto L_0x0062
            if (r0 == r5) goto L_0x005f
            if (r0 == r4) goto L_0x005c
            if (r0 == r3) goto L_0x0059
            if (r0 == r2) goto L_0x0056
            goto L_0x0064
        L_0x0056:
            r7.f6597b = r1
            goto L_0x0064
        L_0x0059:
            r7.f6599d = r1
            goto L_0x0064
        L_0x005c:
            r7.f6602g = r1
            goto L_0x0064
        L_0x005f:
            r7.f6596a = r1
            goto L_0x0064
        L_0x0062:
            r7.f6598c = r1
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.d.h(g1.u0):void");
    }

    public final int hashCode() {
        return this.f10565i.hashCode() + h.e(this.f10564h, 527, 31);
    }

    public final /* synthetic */ byte[] r() {
        return null;
    }

    public final String toString() {
        return "VC: " + this.f10564h + Constants.ATTRIBUTE_SEPARATOR + this.f10565i;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f10564h);
        parcel.writeString(this.f10565i);
    }

    public d(String str, String str2) {
        this.f10564h = str;
        this.f10565i = str2;
    }
}
