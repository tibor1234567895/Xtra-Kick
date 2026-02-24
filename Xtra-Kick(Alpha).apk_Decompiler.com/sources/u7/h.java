package u7;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ViewGroup;

public final class h extends ViewGroup.MarginLayoutParams implements b {
    public static final Parcelable.Creator<h> CREATOR = new g();

    /* renamed from: h  reason: collision with root package name */
    public final int f15397h = 1;

    /* renamed from: i  reason: collision with root package name */
    public final float f15398i = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    public final float f15399j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    public final int f15400k = -1;

    /* renamed from: l  reason: collision with root package name */
    public final float f15401l = -1.0f;

    /* renamed from: m  reason: collision with root package name */
    public int f15402m = -1;

    /* renamed from: n  reason: collision with root package name */
    public int f15403n = -1;

    /* renamed from: o  reason: collision with root package name */
    public final int f15404o = 16777215;

    /* renamed from: p  reason: collision with root package name */
    public final int f15405p = 16777215;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f15406q;

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f15437b);
        this.f15397h = obtainStyledAttributes.getInt(8, 1);
        this.f15398i = obtainStyledAttributes.getFloat(2, 0.0f);
        this.f15399j = obtainStyledAttributes.getFloat(3, 1.0f);
        this.f15400k = obtainStyledAttributes.getInt(0, -1);
        this.f15401l = obtainStyledAttributes.getFraction(1, 1, 1, -1.0f);
        this.f15402m = obtainStyledAttributes.getDimensionPixelSize(7, -1);
        this.f15403n = obtainStyledAttributes.getDimensionPixelSize(6, -1);
        this.f15404o = obtainStyledAttributes.getDimensionPixelSize(5, 16777215);
        this.f15405p = obtainStyledAttributes.getDimensionPixelSize(4, 16777215);
        this.f15406q = obtainStyledAttributes.getBoolean(9, false);
        obtainStyledAttributes.recycle();
    }

    public final void a(int i10) {
        this.f15403n = i10;
    }

    public final float b() {
        return this.f15398i;
    }

    public final int c() {
        return this.height;
    }

    public final float d() {
        return this.f15401l;
    }

    public final int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f15400k;
    }

    public final float f() {
        return this.f15399j;
    }

    public final int getOrder() {
        return this.f15397h;
    }

    public final int i() {
        return this.rightMargin;
    }

    public final int j() {
        return this.f15403n;
    }

    public final int k() {
        return this.f15402m;
    }

    public final boolean l() {
        return this.f15406q;
    }

    public final int m() {
        return this.width;
    }

    public final int n() {
        return this.f15405p;
    }

    public final void o(int i10) {
        this.f15402m = i10;
    }

    public final int p() {
        return this.bottomMargin;
    }

    public final int q() {
        return this.leftMargin;
    }

    public final int s() {
        return this.f15404o;
    }

    public final int t() {
        return this.topMargin;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f15397h);
        parcel.writeFloat(this.f15398i);
        parcel.writeFloat(this.f15399j);
        parcel.writeInt(this.f15400k);
        parcel.writeFloat(this.f15401l);
        parcel.writeInt(this.f15402m);
        parcel.writeInt(this.f15403n);
        parcel.writeInt(this.f15404o);
        parcel.writeInt(this.f15405p);
        parcel.writeByte(this.f15406q ? (byte) 1 : 0);
        parcel.writeInt(this.bottomMargin);
        parcel.writeInt(this.leftMargin);
        parcel.writeInt(this.rightMargin);
        parcel.writeInt(this.topMargin);
        parcel.writeInt(this.height);
        parcel.writeInt(this.width);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(Parcel parcel) {
        super(0, 0);
        boolean z10 = false;
        this.f15397h = parcel.readInt();
        this.f15398i = parcel.readFloat();
        this.f15399j = parcel.readFloat();
        this.f15400k = parcel.readInt();
        this.f15401l = parcel.readFloat();
        this.f15402m = parcel.readInt();
        this.f15403n = parcel.readInt();
        this.f15404o = parcel.readInt();
        this.f15405p = parcel.readInt();
        this.f15406q = parcel.readByte() != 0 ? true : z10;
        this.bottomMargin = parcel.readInt();
        this.leftMargin = parcel.readInt();
        this.rightMargin = parcel.readInt();
        this.topMargin = parcel.readInt();
        this.height = parcel.readInt();
        this.width = parcel.readInt();
    }

    public h(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public h(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public h(h hVar) {
        super(hVar);
        this.f15397h = hVar.f15397h;
        this.f15398i = hVar.f15398i;
        this.f15399j = hVar.f15399j;
        this.f15400k = hVar.f15400k;
        this.f15401l = hVar.f15401l;
        this.f15402m = hVar.f15402m;
        this.f15403n = hVar.f15403n;
        this.f15404o = hVar.f15404o;
        this.f15405p = hVar.f15405p;
        this.f15406q = hVar.f15406q;
    }
}
