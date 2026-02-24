package u7;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.recyclerview.widget.r1;

public final class k extends r1 implements b {
    public static final Parcelable.Creator<k> CREATOR = new j();

    /* renamed from: l  reason: collision with root package name */
    public final float f15415l = 0.0f;

    /* renamed from: m  reason: collision with root package name */
    public final float f15416m = 1.0f;

    /* renamed from: n  reason: collision with root package name */
    public final int f15417n = -1;

    /* renamed from: o  reason: collision with root package name */
    public final float f15418o = -1.0f;

    /* renamed from: p  reason: collision with root package name */
    public int f15419p;

    /* renamed from: q  reason: collision with root package name */
    public int f15420q;

    /* renamed from: r  reason: collision with root package name */
    public final int f15421r = 16777215;

    /* renamed from: s  reason: collision with root package name */
    public final int f15422s = 16777215;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f15423t;

    public k() {
        super(-2, -2);
    }

    public final void a(int i10) {
        this.f15420q = i10;
    }

    public final float b() {
        return this.f15415l;
    }

    public final int c() {
        return this.height;
    }

    public final float d() {
        return this.f15418o;
    }

    public final int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f15417n;
    }

    public final float f() {
        return this.f15416m;
    }

    public final int getOrder() {
        return 1;
    }

    public final int i() {
        return this.rightMargin;
    }

    public final int j() {
        return this.f15420q;
    }

    public final int k() {
        return this.f15419p;
    }

    public final boolean l() {
        return this.f15423t;
    }

    public final int m() {
        return this.width;
    }

    public final int n() {
        return this.f15422s;
    }

    public final void o(int i10) {
        this.f15419p = i10;
    }

    public final int p() {
        return this.bottomMargin;
    }

    public final int q() {
        return this.leftMargin;
    }

    public final int s() {
        return this.f15421r;
    }

    public final int t() {
        return this.topMargin;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f15415l);
        parcel.writeFloat(this.f15416m);
        parcel.writeInt(this.f15417n);
        parcel.writeFloat(this.f15418o);
        parcel.writeInt(this.f15419p);
        parcel.writeInt(this.f15420q);
        parcel.writeInt(this.f15421r);
        parcel.writeInt(this.f15422s);
        parcel.writeByte(this.f15423t ? (byte) 1 : 0);
        parcel.writeInt(this.bottomMargin);
        parcel.writeInt(this.leftMargin);
        parcel.writeInt(this.rightMargin);
        parcel.writeInt(this.topMargin);
        parcel.writeInt(this.height);
        parcel.writeInt(this.width);
    }

    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public k(Parcel parcel) {
        super(-2, -2);
        this.f15415l = parcel.readFloat();
        this.f15416m = parcel.readFloat();
        this.f15417n = parcel.readInt();
        this.f15418o = parcel.readFloat();
        this.f15419p = parcel.readInt();
        this.f15420q = parcel.readInt();
        this.f15421r = parcel.readInt();
        this.f15422s = parcel.readInt();
        this.f15423t = parcel.readByte() != 0;
        this.bottomMargin = parcel.readInt();
        this.leftMargin = parcel.readInt();
        this.rightMargin = parcel.readInt();
        this.topMargin = parcel.readInt();
        this.height = parcel.readInt();
        this.width = parcel.readInt();
    }
}
