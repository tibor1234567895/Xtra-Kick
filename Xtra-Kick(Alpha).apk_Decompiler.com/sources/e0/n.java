package e0;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.activity.b;
import d0.g;
import d0.h;
import j0.i;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class n extends l {

    /* renamed from: g  reason: collision with root package name */
    public final Class f4876g;

    /* renamed from: h  reason: collision with root package name */
    public final Constructor f4877h;

    /* renamed from: i  reason: collision with root package name */
    public final Method f4878i;

    /* renamed from: j  reason: collision with root package name */
    public final Method f4879j;

    /* renamed from: k  reason: collision with root package name */
    public final Method f4880k;

    /* renamed from: l  reason: collision with root package name */
    public final Method f4881l;

    /* renamed from: m  reason: collision with root package name */
    public final Method f4882m;

    public n() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Constructor<?> constructor;
        Method method5;
        Class<?> cls;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method4 = m(cls);
            method3 = n(cls);
            method2 = cls.getMethod("freeze", new Class[0]);
            method5 = cls.getMethod("abortCreation", new Class[0]);
            method = o(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e10.getClass().getName()), e10);
            cls = null;
            method5 = null;
            constructor = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.f4876g = cls;
        this.f4877h = constructor;
        this.f4878i = method4;
        this.f4879j = method3;
        this.f4880k = method2;
        this.f4881l = method5;
        this.f4882m = method;
    }

    public static Method m(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class});
    }

    public static Method n(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2});
    }

    public final Typeface a(Context context, g gVar, Resources resources, int i10) {
        Object obj;
        if (!l()) {
            return super.a(context, gVar, resources, i10);
        }
        try {
            obj = this.f4877h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        for (h hVar : gVar.f4093a) {
            if (!i(context, obj, hVar.f4094a, hVar.f4098e, hVar.f4095b, hVar.f4096c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(hVar.f4097d))) {
                try {
                    this.f4881l.invoke(obj, new Object[0]);
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
                return null;
            }
        }
        if (!k(obj)) {
            return null;
        }
        return j(obj);
    }

    public final Typeface b(Context context, i[] iVarArr, int i10) {
        Object obj;
        Typeface j10;
        boolean z10;
        ParcelFileDescriptor openFileDescriptor;
        Throwable th;
        i[] iVarArr2 = iVarArr;
        int i11 = i10;
        if (iVarArr2.length < 1) {
            return null;
        }
        if (!l()) {
            i f10 = f(i11, iVarArr2);
            try {
                openFileDescriptor = context.getContentResolver().openFileDescriptor(f10.f8397a, "r", (CancellationSignal) null);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                b.C();
                Typeface q10 = b.p(openFileDescriptor.getFileDescriptor()).setWeight(f10.f8399c).setItalic(f10.f8400d).build();
                openFileDescriptor.close();
                return q10;
            } catch (IOException unused) {
                return null;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            HashMap hashMap = new HashMap();
            for (i iVar : iVarArr2) {
                if (iVar.f8401e == 0) {
                    Uri uri = iVar.f8397a;
                    if (!hashMap.containsKey(uri)) {
                        hashMap.put(uri, t.e(context, uri));
                    }
                }
                Context context2 = context;
            }
            Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
            try {
                obj = this.f4877h.newInstance(new Object[0]);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused2) {
                obj = null;
            }
            if (obj == null) {
                return null;
            }
            int length = iVarArr2.length;
            int i12 = 0;
            boolean z11 = false;
            while (true) {
                Method method = this.f4881l;
                if (i12 < length) {
                    i iVar2 = iVarArr2[i12];
                    ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(iVar2.f8397a);
                    if (byteBuffer != null) {
                        try {
                            z10 = ((Boolean) this.f4879j.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(iVar2.f8398b), null, Integer.valueOf(iVar2.f8399c), Integer.valueOf(iVar2.f8400d ? 1 : 0)})).booleanValue();
                        } catch (IllegalAccessException | InvocationTargetException unused3) {
                            z10 = false;
                        }
                        if (!z10) {
                            try {
                                method.invoke(obj, new Object[0]);
                                return null;
                            } catch (IllegalAccessException | InvocationTargetException unused4) {
                                return null;
                            }
                        } else {
                            z11 = true;
                        }
                    }
                    i12++;
                } else if (!z11) {
                    try {
                        method.invoke(obj, new Object[0]);
                        return null;
                    } catch (IllegalAccessException | InvocationTargetException unused5) {
                        return null;
                    }
                } else if (k(obj) && (j10 = j(obj)) != null) {
                    return Typeface.create(j10, i11);
                } else {
                    return null;
                }
            }
        }
        throw th;
    }

    public final Typeface d(Context context, Resources resources, int i10, String str, int i11) {
        Object obj;
        if (!l()) {
            return super.d(context, resources, i10, str, i11);
        }
        try {
            obj = this.f4877h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        if (!i(context, obj, str, 0, -1, -1, (FontVariationAxis[]) null)) {
            try {
                this.f4881l.invoke(obj, new Object[0]);
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
            return null;
        } else if (!k(obj)) {
            return null;
        } else {
            return j(obj);
        }
    }

    public final boolean i(Context context, Object obj, String str, int i10, int i11, int i12, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f4878i.invoke(obj, new Object[]{context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface j(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f4876g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f4882m.invoke((Object) null, new Object[]{newInstance, -1, -1});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean k(Object obj) {
        try {
            return ((Boolean) this.f4880k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean l() {
        Method method = this.f4878i;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return method != null;
    }

    public Method o(Class cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), cls2, cls2});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
