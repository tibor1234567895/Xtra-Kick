package k;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

public final class a implements TransformationMethod {

    /* renamed from: a  reason: collision with root package name */
    public final Locale f8933a;

    public a(Context context) {
        this.f8933a = context.getResources().getConfiguration().locale;
    }

    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f8933a);
        }
        return null;
    }

    public final void onFocusChanged(View view, CharSequence charSequence, boolean z10, int i10, Rect rect) {
    }
}
