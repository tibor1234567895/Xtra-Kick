package k5;

import android.app.Service;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.media.h;
import android.view.View;
import b5.n;
import b5.q;
import d5.o0;
import d8.c;
import e5.k;
import j5.b;
import j9.t;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import l9.e;
import l9.p;
import m0.j;
import m0.q2;
import m0.y;
import m8.v;
import w5.d;
import y5.c0;

public final class a implements q, v, c0, y, p {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9123h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f9124i;

    /* renamed from: j  reason: collision with root package name */
    public Object f9125j;

    public a(c cVar, c cVar2) {
        this.f9123h = 6;
        cVar.getClass();
        cVar2.getClass();
        if (0.0f <= 0.0f) {
            this.f9124i = cVar;
            this.f9125j = cVar2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static h0 e(ImageDecoder.Source source, int i10, int i11, n nVar) {
        Drawable f10 = ImageDecoder.decodeDrawable(source, new b(i10, i11, nVar));
        if (j.v(f10)) {
            return new h0(2, j.e(f10));
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + f10);
    }

    public final q2 A(View view, q2 q2Var) {
        return ((v) this.f9124i).a(view, q2Var, new a2.j((a2.j) this.f9125j));
    }

    public final ga.c a(Service service) {
        service.getClass();
        this.f9125j = service;
        return this;
    }

    public final void b(Bitmap bitmap, e5.c cVar) {
        IOException iOException = ((d) this.f9125j).f16112i;
        if (iOException != null) {
            if (bitmap != null) {
                cVar.c(bitmap);
            }
            throw iOException;
        }
    }

    public final boolean c(Object obj, File file, n nVar) {
        return ((q) this.f9125j).c(new d(((BitmapDrawable) ((o0) obj).get()).getBitmap(), (e5.c) this.f9124i), file, nVar);
    }

    public final void d() {
        e0 e0Var = (e0) this.f9124i;
        synchronized (e0Var) {
            e0Var.f9148j = e0Var.f9146h.length;
        }
    }

    public final p f(o9.a aVar) {
        a aVar2;
        Type type = aVar.f12362b;
        Map map = (Map) this.f9124i;
        h.y(map.get(type));
        Class cls = aVar.f12361a;
        h.y(map.get(cls));
        p pVar = null;
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                ((n9.b) this.f9125j).a(declaredConstructor);
            }
            aVar2 = new a((Object) this, (Object) declaredConstructor, 9);
        } catch (NoSuchMethodException unused) {
            aVar2 = null;
        }
        if (aVar2 != null) {
            return aVar2;
        }
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                pVar = new e0.q(4);
            } else if (EnumSet.class.isAssignableFrom(cls)) {
                pVar = new a((Object) this, (Object) type, 10);
            } else if (Set.class.isAssignableFrom(cls)) {
                pVar = new e0.q(5);
            } else if (Queue.class.isAssignableFrom(cls)) {
                pVar = new e0.q(6);
            } else {
                pVar = new e0.q(7);
            }
        } else if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                pVar = new e0.q(8);
            } else if (ConcurrentMap.class.isAssignableFrom(cls)) {
                pVar = new e0.q(0);
            } else if (SortedMap.class.isAssignableFrom(cls)) {
                pVar = new e0.q(1);
            } else {
                if (type instanceof ParameterizedType) {
                    Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                    type2.getClass();
                    Type a10 = e.a(type2);
                    Class e10 = e.e(a10);
                    a10.hashCode();
                    if (!String.class.isAssignableFrom(e10)) {
                        pVar = new e0.q(2);
                    }
                }
                pVar = new e0.q(3);
            }
        }
        if (pVar != null) {
            return pVar;
        }
        return new l.h(this, cls, type);
    }

    public final b5.c g(n nVar) {
        return ((q) this.f9125j).g(nVar);
    }

    public final byte[] h(int i10) {
        Object obj = this.f9125j;
        return ((k) obj) == null ? new byte[i10] : (byte[]) ((k) obj).d(i10, byte[].class);
    }

    public final Object i() {
        int i10 = this.f9123h;
        Object obj = this.f9124i;
        switch (i10) {
            case 9:
                try {
                    return ((Constructor) obj).newInstance((Object[]) null);
                } catch (InstantiationException e10) {
                    throw new RuntimeException("Failed to invoke " + ((Constructor) obj) + " with no args", e10);
                } catch (InvocationTargetException e11) {
                    throw new RuntimeException("Failed to invoke " + ((Constructor) obj) + " with no args", e11.getTargetException());
                } catch (IllegalAccessException e12) {
                    throw new AssertionError(e12);
                }
            default:
                Type type = (Type) obj;
                if (type instanceof ParameterizedType) {
                    Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                    if (type2 instanceof Class) {
                        return EnumSet.noneOf((Class) type2);
                    }
                    throw new t("Invalid EnumSet type: " + type.toString());
                }
                throw new t("Invalid EnumSet type: " + type.toString());
        }
    }

    public final String toString() {
        switch (this.f9123h) {
            case 11:
                return ((Map) this.f9124i).toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ a(Object obj, int i10, Object obj2) {
        this.f9123h = i10;
        this.f9124i = obj;
        this.f9125j = obj2;
    }

    public /* synthetic */ a(Object obj, Object obj2, int i10) {
        this.f9123h = i10;
        this.f9125j = obj;
        this.f9124i = obj2;
    }

    public a(Map map) {
        this.f9123h = 11;
        this.f9125j = n9.b.f11760a;
        this.f9124i = map;
    }

    public a(y5.h hVar) {
        this.f9123h = 4;
        this.f9124i = hVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(y5.h hVar, int i10) {
        this(hVar);
        this.f9123h = 4;
    }
}
