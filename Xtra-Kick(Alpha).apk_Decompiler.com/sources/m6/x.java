package m6;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.github.andreyasadchy.xtra.ui.view.StrictEditText;
import xa.j;

public final class x implements TextWatcher {

    /* renamed from: h  reason: collision with root package name */
    public int f10674h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextView f10675i;

    public x(StrictEditText strictEditText) {
        this.f10675i = strictEditText;
    }

    public final void afterTextChanged(Editable editable) {
        j.f("s", editable);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        j.f("s", charSequence);
    }

    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        j.f("s", charSequence);
        TextView textView = this.f10675i;
        textView.setError((CharSequence) null);
        int length = charSequence.length();
        if (length == 2 || length == 5) {
            if (this.f10674h < length) {
                textView.append(Constants.EXT_TAG_END);
            } else {
                textView.getEditableText().delete(length - 1, length);
            }
        }
        this.f10674h = length;
    }
}
