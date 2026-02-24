package y8;

import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n f17154a;

    public m(n nVar) {
        this.f17154a = nVar;
    }

    public final void a(TextInputLayout textInputLayout) {
        n nVar = this.f17154a;
        if (nVar.f17173z != textInputLayout.getEditText()) {
            EditText editText = nVar.f17173z;
            l lVar = nVar.C;
            if (editText != null) {
                editText.removeTextChangedListener(lVar);
                if (nVar.f17173z.getOnFocusChangeListener() == nVar.b().e()) {
                    nVar.f17173z.setOnFocusChangeListener((View.OnFocusChangeListener) null);
                }
            }
            EditText editText2 = textInputLayout.getEditText();
            nVar.f17173z = editText2;
            if (editText2 != null) {
                editText2.addTextChangedListener(lVar);
            }
            nVar.b().m(nVar.f17173z);
            nVar.i(nVar.b());
        }
    }
}
