package retrofit2;

import dc.s0;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import pb.j1;
import retrofit2.CallAdapter;

final class DefaultCallAdapterFactory extends CallAdapter.Factory {
    private final Executor callbackExecutor;

    public static final class ExecutorCallbackCall<T> implements Call<T> {
        final Executor callbackExecutor;
        final Call<T> delegate;

        public ExecutorCallbackCall(Executor executor, Call<T> call) {
            this.callbackExecutor = executor;
            this.delegate = call;
        }

        public void cancel() {
            this.delegate.cancel();
        }

        public void enqueue(final Callback<T> callback) {
            Objects.requireNonNull(callback, "callback == null");
            this.delegate.enqueue(new Callback<T>() {
                /* access modifiers changed from: private */
                public /* synthetic */ void lambda$onFailure$1(Callback callback, Throwable th) {
                    callback.onFailure(ExecutorCallbackCall.this, th);
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void lambda$onResponse$0(Callback callback, Response response) {
                    if (ExecutorCallbackCall.this.delegate.isCanceled()) {
                        callback.onFailure(ExecutorCallbackCall.this, new IOException("Canceled"));
                    } else {
                        callback.onResponse(ExecutorCallbackCall.this, response);
                    }
                }

                public void onFailure(Call<T> call, Throwable th) {
                    ExecutorCallbackCall.this.callbackExecutor.execute(new a(this, callback, th, 1));
                }

                public void onResponse(Call<T> call, Response<T> response) {
                    ExecutorCallbackCall.this.callbackExecutor.execute(new a(this, callback, response, 0));
                }
            });
        }

        public Response<T> execute() throws IOException {
            return this.delegate.execute();
        }

        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        public j1 request() {
            return this.delegate.request();
        }

        public s0 timeout() {
            return this.delegate.timeout();
        }

        public Call<T> clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }
    }

    public DefaultCallAdapterFactory(Executor executor) {
        this.callbackExecutor = executor;
    }

    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        final Executor executor = null;
        if (CallAdapter.Factory.getRawType(type) != Call.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            final Type parameterUpperBound = Utils.getParameterUpperBound(0, (ParameterizedType) type);
            if (!Utils.isAnnotationPresent(annotationArr, SkipCallbackExecutor.class)) {
                executor = this.callbackExecutor;
            }
            return new CallAdapter<Object, Call<?>>() {
                public Type responseType() {
                    return parameterUpperBound;
                }

                public Call<Object> adapt(Call<Object> call) {
                    Executor executor = executor;
                    return executor == null ? call : new ExecutorCallbackCall(executor, call);
                }
            };
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
