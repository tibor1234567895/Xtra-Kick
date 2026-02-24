package x;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import t.a;

public final class j {

    /* renamed from: j  reason: collision with root package name */
    public static final SparseIntArray f16464j;

    /* renamed from: a  reason: collision with root package name */
    public int f16465a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f16466b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f16467c = -1;

    /* renamed from: d  reason: collision with root package name */
    public float f16468d = Float.NaN;

    /* renamed from: e  reason: collision with root package name */
    public float f16469e = Float.NaN;

    /* renamed from: f  reason: collision with root package name */
    public float f16470f = Float.NaN;

    /* renamed from: g  reason: collision with root package name */
    public int f16471g = -1;

    /* renamed from: h  reason: collision with root package name */
    public String f16472h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f16473i = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16464j = sparseIntArray;
        sparseIntArray.append(3, 1);
        sparseIntArray.append(5, 2);
        sparseIntArray.append(9, 3);
        sparseIntArray.append(2, 4);
        sparseIntArray.append(1, 5);
        sparseIntArray.append(0, 6);
        sparseIntArray.append(4, 7);
        sparseIntArray.append(8, 8);
        sparseIntArray.append(7, 9);
        sparseIntArray.append(6, 10);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.f16503f);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            switch (f16464j.get(index)) {
                case 1:
                    this.f16469e = obtainStyledAttributes.getFloat(index, this.f16469e);
                    break;
                case 2:
                    this.f16467c = obtainStyledAttributes.getInt(index, this.f16467c);
                    break;
                case 3:
                    if (obtainStyledAttributes.peekValue(index).type != 3) {
                        String str = a.f14481b[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    } else {
                        obtainStyledAttributes.getString(index);
                        break;
                    }
                case 4:
                    obtainStyledAttributes.getInt(index, 0);
                    break;
                case Constants.MAX_COMPATIBILITY_VERSION:
                    this.f16465a = m.f(obtainStyledAttributes, index, this.f16465a);
                    break;
                case 6:
                    this.f16466b = obtainStyledAttributes.getInteger(index, this.f16466b);
                    break;
                case 7:
                    this.f16468d = obtainStyledAttributes.getFloat(index, this.f16468d);
                    break;
                case 8:
                    this.f16471g = obtainStyledAttributes.getInteger(index, this.f16471g);
                    break;
                case 9:
                    this.f16470f = obtainStyledAttributes.getFloat(index, this.f16470f);
                    break;
                case 10:
                    int i11 = obtainStyledAttributes.peekValue(index).type;
                    if (i11 != 1) {
                        if (i11 != 3) {
                            obtainStyledAttributes.getInteger(index, this.f16473i);
                            break;
                        } else {
                            String string = obtainStyledAttributes.getString(index);
                            this.f16472h = string;
                            if (string.indexOf(Constants.LIST_SEPARATOR) <= 0) {
                                break;
                            }
                        }
                    }
                    this.f16473i = obtainStyledAttributes.getResourceId(index, -1);
                    break;
            }
        }
        obtainStyledAttributes.recycle();
    }
}
