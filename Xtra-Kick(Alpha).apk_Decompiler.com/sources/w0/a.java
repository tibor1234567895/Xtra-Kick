package w0;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.widget.p4;
import androidx.emoji2.text.p;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import l0.f;

public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public final EditText f16015a;

    /* renamed from: b  reason: collision with root package name */
    public final n f16016b;

    public a(EditText editText) {
        this.f16015a = editText;
        n nVar = new n(editText);
        this.f16016b = nVar;
        editText.addTextChangedListener(nVar);
        editText.setEditableFactory(d.getInstance());
    }

    public final KeyListener a(KeyListener keyListener) {
        if (keyListener instanceof j) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new j(keyListener);
    }

    public final InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        return inputConnection instanceof f ? inputConnection : new f(this.f16015a, inputConnection, editorInfo);
    }

    public final void c(boolean z10) {
        n nVar = this.f16016b;
        if (nVar.f16038k != z10) {
            if (nVar.f16037j != null) {
                p a10 = p.a();
                p4 p4Var = nVar.f16037j;
                a10.getClass();
                f.c(p4Var, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = a10.f1268a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    a10.f1269b.remove(p4Var);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            nVar.f16038k = z10;
            if (z10) {
                n.a(nVar.f16035h, p.a().b());
            }
        }
    }
}
