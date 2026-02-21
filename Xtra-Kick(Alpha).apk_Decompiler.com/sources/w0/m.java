package w0;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;
import androidx.emoji2.text.p;

public final class m extends l {

    /* renamed from: a  reason: collision with root package name */
    public final k f16034a;

    public m(TextView textView) {
        this.f16034a = new k(textView);
    }

    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        boolean z10;
        if (p.f1267j != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return inputFilterArr;
        }
        return this.f16034a.a(inputFilterArr);
    }

    public final boolean b() {
        return this.f16034a.f16033c;
    }

    public final void c(boolean z10) {
        boolean z11;
        if (p.f1267j != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!(!z11)) {
            this.f16034a.c(z10);
        }
    }

    public final void d(boolean z10) {
        boolean z11;
        if (p.f1267j != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean z12 = !z11;
        k kVar = this.f16034a;
        if (z12) {
            kVar.f16033c = z10;
        } else {
            kVar.d(z10);
        }
    }

    public final TransformationMethod e(TransformationMethod transformationMethod) {
        boolean z10;
        if (p.f1267j != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return transformationMethod;
        }
        return this.f16034a.e(transformationMethod);
    }
}
