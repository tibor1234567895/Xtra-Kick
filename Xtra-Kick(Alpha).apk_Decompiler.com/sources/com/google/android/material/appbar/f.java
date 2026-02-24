package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;
import t0.c;

public final class f extends c {
    public static final Parcelable.Creator<f> CREATOR = new e();

    /* renamed from: j  reason: collision with root package name */
    public boolean f3640j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3641k;

    /* renamed from: l  reason: collision with root package name */
    public int f3642l;

    /* renamed from: m  reason: collision with root package name */
    public float f3643m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f3644n;

    public f(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        boolean z10 = true;
        this.f3640j = parcel.readByte() != 0;
        this.f3641k = parcel.readByte() != 0;
        this.f3642l = parcel.readInt();
        this.f3643m = parcel.readFloat();
        this.f3644n = parcel.readByte() == 0 ? false : z10;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f14484h, i10);
        parcel.writeByte(this.f3640j ? (byte) 1 : 0);
        parcel.writeByte(this.f3641k ? (byte) 1 : 0);
        parcel.writeInt(this.f3642l);
        parcel.writeFloat(this.f3643m);
        parcel.writeByte(this.f3644n ? (byte) 1 : 0);
    }

    public f(Parcelable parcelable) {
        super(parcelable);
    }
}
