package hb;

import java.util.concurrent.CancellationException;
import xa.j;

public final class m1 extends CancellationException {

    /* renamed from: h  reason: collision with root package name */
    public final transient l1 f7825h;

    public m1(String str, Throwable th, l1 l1Var) {
        super(str);
        this.f7825h = l1Var;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof m1) {
                m1 m1Var = (m1) obj;
                if (!j.a(m1Var.getMessage(), getMessage()) || !j.a(m1Var.f7825h, this.f7825h) || !j.a(m1Var.getCause(), getCause())) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        j.c(message);
        int hashCode = (this.f7825h.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return hashCode + (cause != null ? cause.hashCode() : 0);
    }

    public final String toString() {
        return super.toString() + "; job=" + this.f7825h;
    }
}
