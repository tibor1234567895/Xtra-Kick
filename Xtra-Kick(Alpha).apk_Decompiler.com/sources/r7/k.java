package r7;

import android.widget.MultiAutoCompleteTextView;
import fb.y;
import xa.j;

public final class k implements MultiAutoCompleteTextView.Tokenizer {
    public final int findTokenEnd(CharSequence charSequence, int i10) {
        j.f("text", charSequence);
        int length = charSequence.length();
        while (i10 < length) {
            if (charSequence.charAt(i10) == ' ') {
                return i10;
            }
            i10++;
        }
        return length;
    }

    public final int findTokenStart(CharSequence charSequence, int i10) {
        j.f("text", charSequence);
        int i11 = i10;
        while (i11 > 0 && charSequence.charAt(i11 - 1) != ' ') {
            i11--;
        }
        while (i11 < i10 && charSequence.charAt(i11) == ' ') {
            i11++;
        }
        return i11;
    }

    public final CharSequence terminateToken(CharSequence charSequence) {
        j.f("text", charSequence);
        if (y.G(charSequence, ':')) {
            charSequence = charSequence.subSequence(1, charSequence.length()).toString();
        }
        return charSequence + " ";
    }
}
