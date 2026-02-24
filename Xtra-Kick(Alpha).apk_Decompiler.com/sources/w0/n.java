package w0;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.widget.p4;
import androidx.emoji2.text.p;

public final class n implements TextWatcher {

    /* renamed from: h  reason: collision with root package name */
    public final EditText f16035h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f16036i = false;

    /* renamed from: j  reason: collision with root package name */
    public p4 f16037j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f16038k = true;

    public n(EditText editText) {
        this.f16035h = editText;
    }

    public static void a(EditText editText, int i10) {
        int i11;
        if (i10 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            p a10 = p.a();
            if (editableText == null) {
                i11 = 0;
            } else {
                a10.getClass();
                i11 = editableText.length();
            }
            a10.f(0, i11, editableText);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (r1 == false) goto L_0x001b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onTextChanged(java.lang.CharSequence r5, int r6, int r7, int r8) {
        /*
            r4 = this;
            android.widget.EditText r0 = r4.f16035h
            boolean r1 = r0.isInEditMode()
            if (r1 != 0) goto L_0x0054
            boolean r1 = r4.f16038k
            r2 = 1
            if (r1 == 0) goto L_0x001b
            boolean r1 = r4.f16036i
            r3 = 0
            if (r1 != 0) goto L_0x001c
            androidx.emoji2.text.p r1 = androidx.emoji2.text.p.f1267j
            if (r1 == 0) goto L_0x0018
            r1 = 1
            goto L_0x0019
        L_0x0018:
            r1 = 0
        L_0x0019:
            if (r1 != 0) goto L_0x001c
        L_0x001b:
            r3 = 1
        L_0x001c:
            if (r3 == 0) goto L_0x001f
            goto L_0x0054
        L_0x001f:
            if (r7 > r8) goto L_0x0054
            boolean r7 = r5 instanceof android.text.Spannable
            if (r7 == 0) goto L_0x0054
            androidx.emoji2.text.p r7 = androidx.emoji2.text.p.a()
            int r7 = r7.b()
            if (r7 == 0) goto L_0x0040
            if (r7 == r2) goto L_0x0035
            r5 = 3
            if (r7 == r5) goto L_0x0040
            goto L_0x0054
        L_0x0035:
            android.text.Spannable r5 = (android.text.Spannable) r5
            androidx.emoji2.text.p r7 = androidx.emoji2.text.p.a()
            int r8 = r8 + r6
            r7.f(r6, r8, r5)
            goto L_0x0054
        L_0x0040:
            androidx.emoji2.text.p r5 = androidx.emoji2.text.p.a()
            androidx.appcompat.widget.p4 r6 = r4.f16037j
            if (r6 != 0) goto L_0x004f
            androidx.appcompat.widget.p4 r6 = new androidx.appcompat.widget.p4
            r6.<init>((android.widget.EditText) r0)
            r4.f16037j = r6
        L_0x004f:
            androidx.appcompat.widget.p4 r6 = r4.f16037j
            r5.g(r6)
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.n.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }
}
