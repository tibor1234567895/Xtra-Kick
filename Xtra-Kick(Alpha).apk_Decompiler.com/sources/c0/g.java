package c0;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import b0.f0;
import b0.l0;
import d0.c;
import d0.l;
import d0.m;
import d0.n;
import d0.s;
import i0.b;
import java.lang.reflect.InvocationTargetException;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f2717a = new Object();

    public static int a(Context context, String str) {
        boolean z10;
        if (str == null) {
            throw new NullPointerException("permission must be non-null");
        } else if (b.a() || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } else {
            l0 l0Var = new l0(context);
            if (Build.VERSION.SDK_INT >= 24) {
                z10 = f0.a(l0Var.f2376b);
            } else {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i10 = applicationInfo.uid;
                try {
                    Class<?> cls = Class.forName(AppOpsManager.class.getName());
                    Class cls2 = Integer.TYPE;
                    if (((Integer) cls.getMethod("checkOpNoThrow", new Class[]{cls2, cls2, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i10), packageName})).intValue() != 0) {
                        z10 = false;
                    }
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
                }
                z10 = true;
            }
            if (z10) {
                return 0;
            }
            return -1;
        }
    }

    public static int b(Context context, int i10) {
        return Build.VERSION.SDK_INT >= 23 ? d.a(context, i10) : context.getResources().getColor(i10);
    }

    public static ColorStateList c(Context context, int i10) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        m mVar;
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        n nVar = new n(resources, theme);
        synchronized (s.f4117c) {
            SparseArray sparseArray = (SparseArray) s.f4116b.get(nVar);
            colorStateList = null;
            if (!(sparseArray == null || sparseArray.size() <= 0 || (mVar = (m) sparseArray.get(i10)) == null)) {
                if (!mVar.f4105b.equals(resources.getConfiguration()) || (!(theme == null && mVar.f4106c == 0) && (theme == null || mVar.f4106c != theme.hashCode()))) {
                    sparseArray.remove(i10);
                } else {
                    colorStateList2 = mVar.f4104a;
                }
            }
            colorStateList2 = null;
        }
        if (colorStateList2 != null) {
            return colorStateList2;
        }
        ThreadLocal threadLocal = s.f4115a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        boolean z10 = true;
        resources.getValue(i10, typedValue, true);
        int i11 = typedValue.type;
        if (i11 < 28 || i11 > 31) {
            z10 = false;
        }
        if (!z10) {
            try {
                colorStateList = c.a(resources, resources.getXml(i10), theme);
            } catch (Exception e10) {
                Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e10);
            }
        }
        if (colorStateList != null) {
            s.a(nVar, i10, colorStateList, theme);
            return colorStateList;
        } else if (Build.VERSION.SDK_INT >= 23) {
            return l.b(resources, i10, theme);
        } else {
            return resources.getColorStateList(i10);
        }
    }

    public static Object d(Context context, Class cls) {
        String str;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23) {
            return d.b(context, cls);
        }
        if (i10 >= 23) {
            str = d.c(context, cls);
        } else {
            str = (String) f.f2716a.get(cls);
        }
        if (str != null) {
            return context.getSystemService(str);
        }
        return null;
    }
}
