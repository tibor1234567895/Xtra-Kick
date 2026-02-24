package w0;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.p;

public final class h implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f16027a;

    /* renamed from: b  reason: collision with root package name */
    public g f16028b;

    public h(TextView textView) {
        this.f16027a = textView;
    }

    public final CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        TextView textView = this.f16027a;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int b10 = p.a().b();
        if (b10 != 0) {
            boolean z10 = true;
            if (b10 == 1) {
                if (i13 == 0 && i12 == 0 && spanned.length() == 0 && charSequence == textView.getText()) {
                    z10 = false;
                }
                if (!z10 || charSequence == null) {
                    return charSequence;
                }
                if (!(i10 == 0 && i11 == charSequence.length())) {
                    charSequence = charSequence.subSequence(i10, i11);
                }
                return p.a().f(0, charSequence.length(), charSequence);
            } else if (b10 != 3) {
                return charSequence;
            }
        }
        p a10 = p.a();
        if (this.f16028b == null) {
            this.f16028b = new g(textView, this);
        }
        a10.g(this.f16028b);
        return charSequence;
    }
}
