package mb;

import a.a;
import a.b;
import hb.h0;
import la.l;

public abstract class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f10838a = 0;

    static {
        Object obj;
        Object obj2;
        new a();
        Exception exc = new Exception();
        String simpleName = b.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(simpleName), "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            int i10 = l.f9802h;
            obj = ra.a.class.getCanonicalName();
        } catch (Throwable th) {
            int i11 = l.f9802h;
            obj = h0.I(th);
        }
        if (l.a(obj) != null) {
            obj = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        String str = (String) obj;
        try {
            obj2 = a0.class.getCanonicalName();
        } catch (Throwable th2) {
            int i12 = l.f9802h;
            obj2 = h0.I(th2);
        }
        if (l.a(obj2) != null) {
            obj2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        String str2 = (String) obj2;
    }
}
