package w0;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.widget.TextView;
import androidx.emoji2.text.l;
import androidx.emoji2.text.p;
import java.lang.ref.WeakReference;

public final class g extends l {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f16025a;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference f16026b;

    public g(TextView textView, h hVar) {
        this.f16025a = new WeakReference(textView);
        this.f16026b = new WeakReference(hVar);
    }

    public final void b() {
        boolean z10;
        int i10;
        InputFilter[] filters;
        TextView textView = (TextView) this.f16025a.get();
        InputFilter inputFilter = (InputFilter) this.f16026b.get();
        if (inputFilter != null && textView != null && (filters = textView.getFilters()) != null) {
            int i11 = 0;
            while (true) {
                if (i11 >= filters.length) {
                    break;
                } else if (filters[i11] == inputFilter) {
                    z10 = true;
                    break;
                } else {
                    i11++;
                }
            }
        }
        z10 = false;
        if (z10 && textView.isAttachedToWindow()) {
            CharSequence text = textView.getText();
            p a10 = p.a();
            if (text == null) {
                i10 = 0;
            } else {
                a10.getClass();
                i10 = text.length();
            }
            CharSequence f10 = a10.f(0, i10, text);
            if (text != f10) {
                int selectionStart = Selection.getSelectionStart(f10);
                int selectionEnd = Selection.getSelectionEnd(f10);
                textView.setText(f10);
                if (f10 instanceof Spannable) {
                    Spannable spannable = (Spannable) f10;
                    if (selectionStart >= 0 && selectionEnd >= 0) {
                        Selection.setSelection(spannable, selectionStart, selectionEnd);
                    } else if (selectionStart >= 0) {
                        Selection.setSelection(spannable, selectionStart);
                    } else if (selectionEnd >= 0) {
                        Selection.setSelection(spannable, selectionEnd);
                    }
                }
            }
        }
    }
}
