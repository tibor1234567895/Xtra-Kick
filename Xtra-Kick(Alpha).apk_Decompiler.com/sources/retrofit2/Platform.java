package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import m1.b;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.CallAdapter;
import retrofit2.Converter;

class Platform {
    private static final Platform PLATFORM = findPlatform();
    private final boolean hasJava8Types;
    private final Constructor<MethodHandles.Lookup> lookupConstructor;

    public static final class Android extends Platform {

        public static final class MainThreadExecutor implements Executor {
            private final Handler handler = new Handler(Looper.getMainLooper());

            public void execute(Runnable runnable) {
                this.handler.post(runnable);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Android() {
            super(Build.VERSION.SDK_INT >= 24);
        }

        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            if (Build.VERSION.SDK_INT >= 26) {
                return Platform.super.invokeDefaultMethod(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }
    }

    public Platform(boolean z10) {
        this.hasJava8Types = z10;
        Constructor<MethodHandles.Lookup> constructor = null;
        if (z10) {
            Class<MethodHandles.Lookup> cls = MethodHandles.Lookup.class;
            try {
                constructor = cls.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
                constructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.lookupConstructor = constructor;
    }

    private static Platform findPlatform() {
        return "Dalvik".equals(System.getProperty("java.vm.name")) ? new Android() : new Platform(true);
    }

    public static Platform get() {
        return PLATFORM;
    }

    public List<? extends CallAdapter.Factory> defaultCallAdapterFactories(Executor executor) {
        DefaultCallAdapterFactory defaultCallAdapterFactory = new DefaultCallAdapterFactory(executor);
        if (!this.hasJava8Types) {
            return Collections.singletonList(defaultCallAdapterFactory);
        }
        return Arrays.asList(new CallAdapter.Factory[]{CompletableFutureCallAdapterFactory.INSTANCE, defaultCallAdapterFactory});
    }

    public int defaultCallAdapterFactoriesSize() {
        return this.hasJava8Types ? 2 : 1;
    }

    public Executor defaultCallbackExecutor() {
        return null;
    }

    public List<? extends Converter.Factory> defaultConverterFactories() {
        return this.hasJava8Types ? Collections.singletonList(OptionalConverterFactory.INSTANCE) : Collections.emptyList();
    }

    public int defaultConverterFactoriesSize() {
        return this.hasJava8Types ? 1 : 0;
    }

    @IgnoreJRERequirement
    public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        MethodHandles.Lookup lookup;
        Constructor<MethodHandles.Lookup> constructor = this.lookupConstructor;
        if (constructor != null) {
            lookup = b.j(constructor.newInstance(new Object[]{cls, -1}));
        } else {
            lookup = MethodHandles.lookup();
        }
        return lookup.unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }

    @IgnoreJRERequirement
    public boolean isDefaultMethod(Method method) {
        return this.hasJava8Types && method.isDefault();
    }
}
