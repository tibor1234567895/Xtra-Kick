package xb;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;
import xa.j;

public final class m extends s {

    /* renamed from: i  reason: collision with root package name */
    public static final l f16839i = new l(0);

    /* renamed from: d  reason: collision with root package name */
    public final Method f16840d;

    /* renamed from: e  reason: collision with root package name */
    public final Method f16841e;

    /* renamed from: f  reason: collision with root package name */
    public final Method f16842f;

    /* renamed from: g  reason: collision with root package name */
    public final Class f16843g;

    /* renamed from: h  reason: collision with root package name */
    public final Class f16844h;

    public m(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.f16840d = method;
        this.f16841e = method2;
        this.f16842f = method3;
        this.f16843g = cls;
        this.f16844h = cls2;
    }

    public final void a(SSLSocket sSLSocket) {
        try {
            this.f16842f.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to remove ALPN", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to remove ALPN", e11);
        }
    }

    public final void d(SSLSocket sSLSocket, String str, List list) {
        j.f("protocols", list);
        s.f16851a.getClass();
        ArrayList a10 = r.a(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(s.class.getClassLoader(), new Class[]{this.f16843g, this.f16844h}, new k(a10));
            this.f16840d.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (InvocationTargetException e10) {
            throw new AssertionError("failed to set ALPN", e10);
        } catch (IllegalAccessException e11) {
            throw new AssertionError("failed to set ALPN", e11);
        }
    }

    public final String f(SSLSocket sSLSocket) {
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f16841e.invoke((Object) null, new Object[]{sSLSocket}));
            j.d("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider", invocationHandler);
            k kVar = (k) invocationHandler;
            boolean z10 = kVar.f16837b;
            if (!z10 && kVar.f16838c == null) {
                s.i(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (z10) {
                return null;
            } else {
                return kVar.f16838c;
            }
        } catch (InvocationTargetException e10) {
            throw new AssertionError("failed to get ALPN selected protocol", e10);
        } catch (IllegalAccessException e11) {
            throw new AssertionError("failed to get ALPN selected protocol", e11);
        }
    }
}
