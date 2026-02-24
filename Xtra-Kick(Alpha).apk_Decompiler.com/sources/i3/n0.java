package i3;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.recyclerview.widget.RecyclerView;
import i1.a;
import k1.q;

public final class n0 {
    private n0() {
    }

    public static void a(a aVar) {
        aVar.f7963k = -3.4028235E38f;
        aVar.f7962j = RecyclerView.UNDEFINED_DURATION;
        CharSequence charSequence = aVar.f7953a;
        if (charSequence instanceof Spanned) {
            if (!(charSequence instanceof Spannable)) {
                aVar.f7953a = SpannableString.valueOf(charSequence);
            }
            CharSequence charSequence2 = aVar.f7953a;
            charSequence2.getClass();
            b((Spannable) charSequence2, new q(3));
        }
    }

    public static void b(Spannable spannable, q qVar) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (qVar.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }

    public static float c(float f10, int i10, int i11, int i12) {
        float f11;
        if (f10 == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i10 == 0) {
            f11 = (float) i12;
        } else if (i10 == 1) {
            f11 = (float) i11;
        } else if (i10 != 2) {
            return -3.4028235E38f;
        } else {
            return f10;
        }
        return f10 * f11;
    }
}
