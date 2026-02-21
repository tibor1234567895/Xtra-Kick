package ra;

import hb.h0;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import la.l;
import la.v;
import pa.e;
import xa.j;

public abstract class a implements e, d, Serializable {
    private final e<Object> completion;

    public a(e eVar) {
        this.completion = eVar;
    }

    public e<v> create(Object obj, e<?> eVar) {
        j.f("completion", eVar);
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public d getCallerFrame() {
        e<Object> eVar = this.completion;
        if (eVar instanceof d) {
            return (d) eVar;
        }
        return null;
    }

    public final e<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        int i10;
        String str;
        Object obj;
        Object obj2;
        Object obj3;
        Integer num;
        int i11;
        e eVar = (e) getClass().getAnnotation(e.class);
        String str2 = null;
        if (eVar == null) {
            return null;
        }
        int v10 = eVar.v();
        if (v10 <= 1) {
            int i12 = -1;
            try {
                Field declaredField = getClass().getDeclaredField("label");
                declaredField.setAccessible(true);
                Object obj4 = declaredField.get(this);
                if (obj4 instanceof Integer) {
                    num = (Integer) obj4;
                } else {
                    num = null;
                }
                if (num != null) {
                    i11 = num.intValue();
                } else {
                    i11 = 0;
                }
                i10 = i11 - 1;
            } catch (Exception unused) {
                i10 = -1;
            }
            if (i10 >= 0) {
                i12 = eVar.l()[i10];
            }
            f.f13893a.getClass();
            s9.a aVar = f.f13895c;
            s9.a aVar2 = f.f13894b;
            if (aVar == null) {
                try {
                    s9.a aVar3 = new s9.a(Class.class.getDeclaredMethod("getModule", new Class[0]), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
                    f.f13895c = aVar3;
                    aVar = aVar3;
                } catch (Exception unused2) {
                    f.f13895c = aVar2;
                    aVar = aVar2;
                }
            }
            if (aVar != aVar2) {
                Method method = (Method) aVar.f14391a;
                if (method != null) {
                    obj = method.invoke(getClass(), new Object[0]);
                } else {
                    obj = null;
                }
                if (obj != null) {
                    Method method2 = (Method) aVar.f14392b;
                    if (method2 != null) {
                        obj2 = method2.invoke(obj, new Object[0]);
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        Method method3 = (Method) aVar.f14393c;
                        if (method3 != null) {
                            obj3 = method3.invoke(obj2, new Object[0]);
                        } else {
                            obj3 = null;
                        }
                        if (obj3 instanceof String) {
                            str2 = (String) obj3;
                        }
                    }
                }
            }
            if (str2 == null) {
                str = eVar.c();
            } else {
                str = str2 + '/' + eVar.c();
            }
            return new StackTraceElement(str, eVar.m(), eVar.f(), i12);
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + v10 + ". Please update the Kotlin standard library.").toString());
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    public final void resumeWith(Object obj) {
        e eVar = this;
        while (true) {
            a aVar = (a) eVar;
            e eVar2 = aVar.completion;
            j.c(eVar2);
            try {
                obj = aVar.invokeSuspend(obj);
                if (obj != qa.a.COROUTINE_SUSPENDED) {
                    int i10 = l.f9802h;
                    aVar.releaseIntercepted();
                    if (eVar2 instanceof a) {
                        eVar = eVar2;
                    } else {
                        eVar2.resumeWith(obj);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th) {
                int i11 = l.f9802h;
                obj = h0.I(th);
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb2.append(stackTraceElement);
        return sb2.toString();
    }

    public e<v> create(e<?> eVar) {
        j.f("completion", eVar);
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }
}
