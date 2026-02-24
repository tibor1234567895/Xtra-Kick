package w0;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

public final class k extends l {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f16031a;

    /* renamed from: b  reason: collision with root package name */
    public final h f16032b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f16033c = true;

    public k(TextView textView) {
        this.f16031a = textView;
        this.f16032b = new h(textView);
    }

    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        if (!this.f16033c) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i10 = 0; i10 < inputFilterArr.length; i10++) {
                InputFilter inputFilter = inputFilterArr[i10];
                if (inputFilter instanceof h) {
                    sparseArray.put(i10, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length - sparseArray.size())];
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                if (sparseArray.indexOfKey(i12) < 0) {
                    inputFilterArr2[i11] = inputFilterArr[i12];
                    i11++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i13 = 0;
        while (true) {
            h hVar = this.f16032b;
            if (i13 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[(inputFilterArr.length + 1)];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = hVar;
                return inputFilterArr3;
            } else if (inputFilterArr[i13] == hVar) {
                return inputFilterArr;
            } else {
                i13++;
            }
        }
    }

    public final boolean b() {
        return this.f16033c;
    }

    public final void c(boolean z10) {
        if (z10) {
            TextView textView = this.f16031a;
            textView.setTransformationMethod(e(textView.getTransformationMethod()));
        }
    }

    public final void d(boolean z10) {
        this.f16033c = z10;
        TextView textView = this.f16031a;
        textView.setTransformationMethod(e(textView.getTransformationMethod()));
        textView.setFilters(a(textView.getFilters()));
    }

    public final TransformationMethod e(TransformationMethod transformationMethod) {
        if (this.f16033c) {
            if (!(transformationMethod instanceof o) && !(transformationMethod instanceof PasswordTransformationMethod)) {
                return new o(transformationMethod);
            }
            return transformationMethod;
        } else if (transformationMethod instanceof o) {
            return ((o) transformationMethod).f16039a;
        } else {
            return transformationMethod;
        }
    }
}
