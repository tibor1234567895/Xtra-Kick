package g;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.v4.media.h;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class o0 implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final View f6186h;

    /* renamed from: i  reason: collision with root package name */
    public final String f6187i;

    /* renamed from: j  reason: collision with root package name */
    public Method f6188j;

    /* renamed from: k  reason: collision with root package name */
    public Context f6189k;

    public o0(View view, String str) {
        this.f6186h = view;
        this.f6187i = str;
    }

    public final void onClick(View view) {
        String str;
        Method method;
        if (this.f6188j == null) {
            View view2 = this.f6186h;
            Context context = view2.getContext();
            while (true) {
                String str2 = this.f6187i;
                if (context != null) {
                    try {
                        if (!context.isRestricted() && (method = context.getClass().getMethod(str2, new Class[]{View.class})) != null) {
                            this.f6188j = method;
                            this.f6189k = context;
                            break;
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                    if (context instanceof ContextWrapper) {
                        context = ((ContextWrapper) context).getBaseContext();
                    } else {
                        context = null;
                    }
                } else {
                    int id = view2.getId();
                    if (id == -1) {
                        str = "";
                    } else {
                        str = " with id '" + view2.getContext().getResources().getResourceEntryName(id) + "'";
                    }
                    StringBuilder s10 = h.s("Could not find method ", str2, "(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                    s10.append(view2.getClass());
                    s10.append(str);
                    throw new IllegalStateException(s10.toString());
                }
            }
        }
        try {
            this.f6188j.invoke(this.f6189k, new Object[]{view});
        } catch (IllegalAccessException e10) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e10);
        } catch (InvocationTargetException e11) {
            throw new IllegalStateException("Could not execute method for android:onClick", e11);
        }
    }
}
