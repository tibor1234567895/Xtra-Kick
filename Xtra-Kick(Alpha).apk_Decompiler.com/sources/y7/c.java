package y7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new b();
    public Integer A;
    public Integer B;
    public Integer C;
    public Integer D;

    /* renamed from: h  reason: collision with root package name */
    public int f17087h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f17088i;

    /* renamed from: j  reason: collision with root package name */
    public Integer f17089j;

    /* renamed from: k  reason: collision with root package name */
    public Integer f17090k;

    /* renamed from: l  reason: collision with root package name */
    public Integer f17091l;

    /* renamed from: m  reason: collision with root package name */
    public Integer f17092m;

    /* renamed from: n  reason: collision with root package name */
    public Integer f17093n;

    /* renamed from: o  reason: collision with root package name */
    public Integer f17094o;

    /* renamed from: p  reason: collision with root package name */
    public int f17095p = 255;

    /* renamed from: q  reason: collision with root package name */
    public int f17096q = -2;

    /* renamed from: r  reason: collision with root package name */
    public int f17097r = -2;

    /* renamed from: s  reason: collision with root package name */
    public Locale f17098s;

    /* renamed from: t  reason: collision with root package name */
    public CharSequence f17099t;

    /* renamed from: u  reason: collision with root package name */
    public int f17100u;

    /* renamed from: v  reason: collision with root package name */
    public int f17101v;

    /* renamed from: w  reason: collision with root package name */
    public Integer f17102w;

    /* renamed from: x  reason: collision with root package name */
    public Boolean f17103x = Boolean.TRUE;

    /* renamed from: y  reason: collision with root package name */
    public Integer f17104y;

    /* renamed from: z  reason: collision with root package name */
    public Integer f17105z;

    public c() {
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f17087h);
        parcel.writeSerializable(this.f17088i);
        parcel.writeSerializable(this.f17089j);
        parcel.writeSerializable(this.f17090k);
        parcel.writeSerializable(this.f17091l);
        parcel.writeSerializable(this.f17092m);
        parcel.writeSerializable(this.f17093n);
        parcel.writeSerializable(this.f17094o);
        parcel.writeInt(this.f17095p);
        parcel.writeInt(this.f17096q);
        parcel.writeInt(this.f17097r);
        CharSequence charSequence = this.f17099t;
        parcel.writeString(charSequence == null ? null : charSequence.toString());
        parcel.writeInt(this.f17100u);
        parcel.writeSerializable(this.f17102w);
        parcel.writeSerializable(this.f17104y);
        parcel.writeSerializable(this.f17105z);
        parcel.writeSerializable(this.A);
        parcel.writeSerializable(this.B);
        parcel.writeSerializable(this.C);
        parcel.writeSerializable(this.D);
        parcel.writeSerializable(this.f17103x);
        parcel.writeSerializable(this.f17098s);
    }

    public c(Parcel parcel) {
        this.f17087h = parcel.readInt();
        this.f17088i = (Integer) parcel.readSerializable();
        this.f17089j = (Integer) parcel.readSerializable();
        this.f17090k = (Integer) parcel.readSerializable();
        this.f17091l = (Integer) parcel.readSerializable();
        this.f17092m = (Integer) parcel.readSerializable();
        this.f17093n = (Integer) parcel.readSerializable();
        this.f17094o = (Integer) parcel.readSerializable();
        this.f17095p = parcel.readInt();
        this.f17096q = parcel.readInt();
        this.f17097r = parcel.readInt();
        this.f17099t = parcel.readString();
        this.f17100u = parcel.readInt();
        this.f17102w = (Integer) parcel.readSerializable();
        this.f17104y = (Integer) parcel.readSerializable();
        this.f17105z = (Integer) parcel.readSerializable();
        this.A = (Integer) parcel.readSerializable();
        this.B = (Integer) parcel.readSerializable();
        this.C = (Integer) parcel.readSerializable();
        this.D = (Integer) parcel.readSerializable();
        this.f17103x = (Boolean) parcel.readSerializable();
        this.f17098s = (Locale) parcel.readSerializable();
    }
}
