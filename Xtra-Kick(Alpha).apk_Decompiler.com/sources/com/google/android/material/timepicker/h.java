package com.google.android.material.timepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class h implements Parcelable {
    public static final Parcelable.Creator<h> CREATOR = new g();

    /* renamed from: h  reason: collision with root package name */
    public final int f3952h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3953i;

    /* renamed from: j  reason: collision with root package name */
    public final int f3954j;

    /* renamed from: k  reason: collision with root package name */
    public final int f3955k;

    public h() {
        this(0, 0, 10, 0);
    }

    public final int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (com.google.android.material.timepicker.h) r5;
        r1 = r5.f3953i;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.android.material.timepicker.h
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            com.google.android.material.timepicker.h r5 = (com.google.android.material.timepicker.h) r5
            int r1 = r5.f3953i
            int r3 = r4.f3953i
            if (r3 != r1) goto L_0x0025
            int r1 = r4.f3954j
            int r3 = r5.f3954j
            if (r1 != r3) goto L_0x0025
            int r1 = r4.f3952h
            int r3 = r5.f3952h
            if (r1 != r3) goto L_0x0025
            int r1 = r4.f3955k
            int r5 = r5.f3955k
            if (r1 != r5) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.timepicker.h.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3952h), Integer.valueOf(this.f3953i), Integer.valueOf(this.f3954j), Integer.valueOf(this.f3955k)});
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f3953i);
        parcel.writeInt(this.f3954j);
        parcel.writeInt(this.f3955k);
        parcel.writeInt(this.f3952h);
    }

    public h(int i10, int i11, int i12, int i13) {
        this.f3953i = i10;
        this.f3954j = i11;
        this.f3955k = i12;
        this.f3952h = i13;
    }
}
