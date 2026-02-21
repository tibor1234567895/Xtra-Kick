package yb;

import fb.c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import xa.j;
import xb.e;
import xb.r;
import xb.s;

public class i implements r {

    /* renamed from: f  reason: collision with root package name */
    public static final h f17307f = new h(0);

    /* renamed from: g  reason: collision with root package name */
    public static final g f17308g = new g();

    /* renamed from: a  reason: collision with root package name */
    public final Class f17309a;

    /* renamed from: b  reason: collision with root package name */
    public final Method f17310b;

    /* renamed from: c  reason: collision with root package name */
    public final Method f17311c;

    /* renamed from: d  reason: collision with root package name */
    public final Method f17312d;

    /* renamed from: e  reason: collision with root package name */
    public final Method f17313e;

    public i(Class cls) {
        this.f17309a = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", new Class[]{Boolean.TYPE});
        j.e("sslSocketClass.getDeclar…:class.javaPrimitiveType)", declaredMethod);
        this.f17310b = declaredMethod;
        this.f17311c = cls.getMethod("setHostname", new Class[]{String.class});
        this.f17312d = cls.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.f17313e = cls.getMethod("setAlpnProtocols", new Class[]{byte[].class});
    }

    public final boolean a(SSLSocket sSLSocket) {
        return this.f17309a.isInstance(sSLSocket);
    }

    public final String b(SSLSocket sSLSocket) {
        if (!a(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f17312d.invoke(sSLSocket, new Object[0]);
            if (bArr != null) {
                return new String(bArr, c.f5986b);
            }
            return null;
        } catch (IllegalAccessException e10) {
            throw new AssertionError(e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if ((cause instanceof NullPointerException) && j.a(((NullPointerException) cause).getMessage(), "ssl == null")) {
                return null;
            }
            throw new AssertionError(e11);
        }
    }

    public final boolean c() {
        e.f16826e.getClass();
        return e.f16827f;
    }

    public final void d(SSLSocket sSLSocket, String str, List list) {
        j.f("protocols", list);
        if (a(sSLSocket)) {
            try {
                this.f17310b.invoke(sSLSocket, new Object[]{Boolean.TRUE});
                if (str != null) {
                    this.f17311c.invoke(sSLSocket, new Object[]{str});
                }
                Method method = this.f17313e;
                s.f16851a.getClass();
                method.invoke(sSLSocket, new Object[]{r.b(list)});
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                throw new AssertionError(e11);
            }
        }
    }
}
