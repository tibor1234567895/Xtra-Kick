package x;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;

public final class l {

    /* renamed from: n  reason: collision with root package name */
    public static final SparseIntArray f16478n;

    /* renamed from: a  reason: collision with root package name */
    public float f16479a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f16480b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f16481c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f16482d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f16483e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f16484f = Float.NaN;

    /* renamed from: g  reason: collision with root package name */
    public float f16485g = Float.NaN;

    /* renamed from: h  reason: collision with root package name */
    public int f16486h = -1;

    /* renamed from: i  reason: collision with root package name */
    public float f16487i = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    public float f16488j = 0.0f;

    /* renamed from: k  reason: collision with root package name */
    public float f16489k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    public boolean f16490l = false;

    /* renamed from: m  reason: collision with root package name */
    public float f16491m = 0.0f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16478n = sparseIntArray;
        sparseIntArray.append(6, 1);
        sparseIntArray.append(7, 2);
        sparseIntArray.append(8, 3);
        sparseIntArray.append(4, 4);
        sparseIntArray.append(5, 5);
        sparseIntArray.append(0, 6);
        sparseIntArray.append(1, 7);
        sparseIntArray.append(2, 8);
        sparseIntArray.append(3, 9);
        sparseIntArray.append(9, 10);
        sparseIntArray.append(10, 11);
        sparseIntArray.append(11, 12);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.f16506i);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            switch (f16478n.get(index)) {
                case 1:
                    this.f16479a = obtainStyledAttributes.getFloat(index, this.f16479a);
                    break;
                case 2:
                    this.f16480b = obtainStyledAttributes.getFloat(index, this.f16480b);
                    break;
                case 3:
                    this.f16481c = obtainStyledAttributes.getFloat(index, this.f16481c);
                    break;
                case 4:
                    this.f16482d = obtainStyledAttributes.getFloat(index, this.f16482d);
                    break;
                case Constants.MAX_COMPATIBILITY_VERSION:
                    this.f16483e = obtainStyledAttributes.getFloat(index, this.f16483e);
                    break;
                case 6:
                    this.f16484f = obtainStyledAttributes.getDimension(index, this.f16484f);
                    break;
                case 7:
                    this.f16485g = obtainStyledAttributes.getDimension(index, this.f16485g);
                    break;
                case 8:
                    this.f16487i = obtainStyledAttributes.getDimension(index, this.f16487i);
                    break;
                case 9:
                    this.f16488j = obtainStyledAttributes.getDimension(index, this.f16488j);
                    break;
                case 10:
                    this.f16489k = obtainStyledAttributes.getDimension(index, this.f16489k);
                    break;
                case 11:
                    this.f16490l = true;
                    this.f16491m = obtainStyledAttributes.getDimension(index, this.f16491m);
                    break;
                case 12:
                    this.f16486h = m.f(obtainStyledAttributes, index, this.f16486h);
                    break;
            }
        }
        obtainStyledAttributes.recycle();
    }
}
