package w0;

import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.p;
import androidx.emoji2.text.w;

public final class j implements KeyListener {

    /* renamed from: a  reason: collision with root package name */
    public final KeyListener f16029a;

    /* renamed from: b  reason: collision with root package name */
    public final i f16030b;

    public j(KeyListener keyListener) {
        i iVar = new i();
        this.f16029a = keyListener;
        this.f16030b = iVar;
    }

    public final void clearMetaKeyState(View view, Editable editable, int i10) {
        this.f16029a.clearMetaKeyState(view, editable, i10);
    }

    public final int getInputType() {
        return this.f16029a.getInputType();
    }

    public final boolean onKeyDown(View view, Editable editable, int i10, KeyEvent keyEvent) {
        boolean z10;
        boolean z11;
        this.f16030b.getClass();
        Object obj = p.f1266i;
        if (i10 == 67) {
            z10 = w.a(editable, keyEvent, false);
        } else if (i10 != 112) {
            z10 = false;
        } else {
            z10 = w.a(editable, keyEvent, true);
        }
        if (z10) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 || this.f16029a.onKeyDown(view, editable, i10, keyEvent)) {
            return true;
        }
        return false;
    }

    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f16029a.onKeyOther(view, editable, keyEvent);
    }

    public final boolean onKeyUp(View view, Editable editable, int i10, KeyEvent keyEvent) {
        return this.f16029a.onKeyUp(view, editable, i10, keyEvent);
    }
}
