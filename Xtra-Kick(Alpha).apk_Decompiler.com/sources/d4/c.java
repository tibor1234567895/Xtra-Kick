package d4;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import q.e;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public final e f4325a;

    /* renamed from: b  reason: collision with root package name */
    public final e f4326b;

    /* renamed from: c  reason: collision with root package name */
    public final e f4327c;

    public c(e eVar, e eVar2, e eVar3) {
        this.f4325a = eVar;
        this.f4326b = eVar2;
        this.f4327c = eVar3;
    }

    public abstract d a();

    public final Class b(Class cls) {
        String name = cls.getName();
        e eVar = this.f4327c;
        Class cls2 = (Class) eVar.getOrDefault(name, (Object) null);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        eVar.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method c(String str) {
        e eVar = this.f4325a;
        Method method = (Method) eVar.getOrDefault(str, (Object) null);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Class<c> cls = c.class;
        Method declaredMethod = Class.forName(str, true, cls.getClassLoader()).getDeclaredMethod("read", new Class[]{cls});
        eVar.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method d(Class cls) {
        String name = cls.getName();
        e eVar = this.f4326b;
        Method method = (Method) eVar.getOrDefault(name, (Object) null);
        if (method != null) {
            return method;
        }
        Class b10 = b(cls);
        System.currentTimeMillis();
        Method declaredMethod = b10.getDeclaredMethod("write", new Class[]{cls, c.class});
        eVar.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean e(int i10);

    public final int f(int i10, int i11) {
        if (!e(i11)) {
            return i10;
        }
        return ((d) this).f4329e.readInt();
    }

    public final Parcelable g(Parcelable parcelable, int i10) {
        if (!e(i10)) {
            return parcelable;
        }
        return ((d) this).f4329e.readParcelable(d.class.getClassLoader());
    }

    public final e h() {
        String readString = ((d) this).f4329e.readString();
        if (readString == null) {
            return null;
        }
        d a10 = a();
        try {
            return (e) c(readString).invoke((Object) null, new Object[]{a10});
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e10);
        } catch (InvocationTargetException e11) {
            if (e11.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e11.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e12);
        } catch (ClassNotFoundException e13) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e13);
        }
    }

    public abstract void i(int i10);

    public final void j(int i10, int i11) {
        i(i11);
        ((d) this).f4329e.writeInt(i10);
    }

    public final void k(Parcelable parcelable, int i10) {
        i(i10);
        ((d) this).f4329e.writeParcelable(parcelable, 0);
    }

    public final void l(e eVar) {
        if (eVar == null) {
            ((d) this).f4329e.writeString((String) null);
            return;
        }
        try {
            ((d) this).f4329e.writeString(b(eVar.getClass()).getName());
            d a10 = a();
            try {
                d(eVar.getClass()).invoke((Object) null, new Object[]{eVar, a10});
                int i10 = a10.f4333i;
                if (i10 >= 0) {
                    int i11 = a10.f4328d.get(i10);
                    Parcel parcel = a10.f4329e;
                    int dataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i11);
                    parcel.writeInt(dataPosition - i11);
                    parcel.setDataPosition(dataPosition);
                }
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e10);
            } catch (InvocationTargetException e11) {
                if (e11.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e11.getCause());
                }
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e11);
            } catch (NoSuchMethodException e12) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e12);
            } catch (ClassNotFoundException e13) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e13);
            }
        } catch (ClassNotFoundException e14) {
            throw new RuntimeException(eVar.getClass().getSimpleName().concat(" does not have a Parcelizer"), e14);
        }
    }
}
