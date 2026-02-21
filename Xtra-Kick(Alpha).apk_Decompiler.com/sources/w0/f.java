package w0;

import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import android.widget.TextView;
import androidx.emoji2.text.p;

public final class f extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f16023a;

    /* renamed from: b  reason: collision with root package name */
    public final e f16024b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        super(inputConnection, false);
        boolean z10;
        e eVar = new e();
        boolean z11 = false;
        this.f16023a = editText;
        this.f16024b = eVar;
        if (p.f1267j != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            p a10 = p.a();
            if ((a10.b() == 1 ? true : z11) && editorInfo != null) {
                if (editorInfo.extras == null) {
                    editorInfo.extras = new Bundle();
                }
                a10.f1272e.J(editorInfo);
            }
        }
    }

    public final boolean deleteSurroundingText(int i10, int i11) {
        Editable editableText = this.f16023a.getEditableText();
        this.f16024b.getClass();
        if (e.a(this, editableText, i10, i11, false) || super.deleteSurroundingText(i10, i11)) {
            return true;
        }
        return false;
    }

    public final boolean deleteSurroundingTextInCodePoints(int i10, int i11) {
        Editable editableText = this.f16023a.getEditableText();
        this.f16024b.getClass();
        if (e.a(this, editableText, i10, i11, true) || super.deleteSurroundingTextInCodePoints(i10, i11)) {
            return true;
        }
        return false;
    }
}
