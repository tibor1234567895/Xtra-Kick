package q0;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.Objects;
import m0.h;
import m0.i;
import m0.z;

public final class b0 implements z {
    public final i a(View view, i iVar) {
        CharSequence charSequence;
        if (Log.isLoggable("ReceiveContent", 3)) {
            Objects.toString(iVar);
        }
        if (iVar.f10099a.z() == 2) {
            return iVar;
        }
        h hVar = iVar.f10099a;
        ClipData d10 = hVar.d();
        int b10 = hVar.b();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z10 = false;
        for (int i10 = 0; i10 < d10.getItemCount(); i10++) {
            ClipData.Item itemAt = d10.getItemAt(i10);
            if ((b10 & 1) != 0) {
                charSequence = itemAt.coerceToText(context);
                if (charSequence instanceof Spanned) {
                    charSequence = charSequence.toString();
                }
            } else {
                charSequence = itemAt.coerceToStyledText(context);
            }
            if (charSequence != null) {
                if (!z10) {
                    int selectionStart = Selection.getSelectionStart(editable);
                    int selectionEnd = Selection.getSelectionEnd(editable);
                    int max = Math.max(0, Math.min(selectionStart, selectionEnd));
                    int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
                    Selection.setSelection(editable, max2);
                    editable.replace(max, max2, charSequence);
                    z10 = true;
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), Constants.WRITE_NEW_LINE);
                    editable.insert(Selection.getSelectionEnd(editable), charSequence);
                }
            }
        }
        return null;
    }
}
