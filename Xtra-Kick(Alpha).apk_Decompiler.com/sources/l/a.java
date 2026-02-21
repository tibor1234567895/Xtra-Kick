package l;

import android.content.Context;
import androidx.emoji2.text.m;
import androidx.emoji2.text.n;
import androidx.emoji2.text.r;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import q5.c;

public final class a implements m {

    /* renamed from: a  reason: collision with root package name */
    public final Context f9431a;

    public a(Context context) {
        this.f9431a = context.getApplicationContext();
    }

    public static c b(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                Object newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (newInstance instanceof c) {
                    return (c) newInstance;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + newInstance);
            } catch (InstantiationException e10) {
                c(cls, e10);
                throw null;
            } catch (IllegalAccessException e11) {
                c(cls, e11);
                throw null;
            } catch (NoSuchMethodException e12) {
                c(cls, e12);
                throw null;
            } catch (InvocationTargetException e13) {
                c(cls, e13);
                throw null;
            }
        } catch (ClassNotFoundException e14) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e14);
        }
    }

    public static void c(Class cls, ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, reflectiveOperationException);
    }

    public final void a(n nVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new androidx.emoji2.text.a("EmojiCompatInitializer", 0));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new r(this, nVar, threadPoolExecutor, 0));
    }
}
