package y8;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import t0.c;

public final class a0 extends c {
    public static final Parcelable.Creator<a0> CREATOR = new z();

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f17120j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f17121k;

    public a0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f17120j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f17121k = parcel.readInt() != 1 ? false : true;
    }

    public final String toString() {
        return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.f17120j + "}";
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f14484h, i10);
        TextUtils.writeToParcel(this.f17120j, parcel, i10);
        parcel.writeInt(this.f17121k ? 1 : 0);
    }

    public a0(Parcelable parcelable) {
        super(parcelable);
    }
}
