package w0;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji2.text.p;

public final class o implements TransformationMethod {

    /* renamed from: a  reason: collision with root package name */
    public final TransformationMethod f16039a;

    public o(TransformationMethod transformationMethod) {
        this.f16039a = transformationMethod;
    }

    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f16039a;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        if (charSequence == null || p.a().b() != 1) {
            return charSequence;
        }
        p a10 = p.a();
        a10.getClass();
        return a10.f(0, charSequence.length(), charSequence);
    }

    public final void onFocusChanged(View view, CharSequence charSequence, boolean z10, int i10, Rect rect) {
        TransformationMethod transformationMethod = this.f16039a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z10, i10, rect);
        }
    }
}
