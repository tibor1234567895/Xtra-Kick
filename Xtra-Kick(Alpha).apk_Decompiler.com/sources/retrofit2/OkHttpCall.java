package retrofit2;

import dc.j;
import dc.l;
import dc.s0;
import dc.t;
import hb.h0;
import java.io.IOException;
import java.util.Objects;
import pb.f1;
import pb.h;
import pb.i;
import pb.j1;
import pb.q1;
import pb.r1;
import pb.u1;
import pb.x0;
import tb.o;

final class OkHttpCall<T> implements Call<T> {
    private final Object[] args;
    private final h callFactory;
    private volatile boolean canceled;
    private Throwable creationFailure;
    private boolean executed;
    private i rawCall;
    private final RequestFactory requestFactory;
    private final Converter<u1, T> responseConverter;

    public static final class ExceptionCatchingResponseBody extends u1 {
        private final u1 delegate;
        private final l delegateSource;
        IOException thrownException;

        public ExceptionCatchingResponseBody(u1 u1Var) {
            this.delegate = u1Var;
            this.delegateSource = h0.o(new t(u1Var.source()) {
                public long read(j jVar, long j10) throws IOException {
                    try {
                        return super.read(jVar, j10);
                    } catch (IOException e10) {
                        ExceptionCatchingResponseBody.this.thrownException = e10;
                        throw e10;
                    }
                }
            });
        }

        public void close() {
            this.delegate.close();
        }

        public long contentLength() {
            return this.delegate.contentLength();
        }

        public x0 contentType() {
            return this.delegate.contentType();
        }

        public l source() {
            return this.delegateSource;
        }

        public void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    public static final class NoContentResponseBody extends u1 {
        private final long contentLength;
        private final x0 contentType;

        public NoContentResponseBody(x0 x0Var, long j10) {
            this.contentType = x0Var;
            this.contentLength = j10;
        }

        public long contentLength() {
            return this.contentLength;
        }

        public x0 contentType() {
            return this.contentType;
        }

        public l source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(RequestFactory requestFactory2, Object[] objArr, h hVar, Converter<u1, T> converter) {
        this.requestFactory = requestFactory2;
        this.args = objArr;
        this.callFactory = hVar;
        this.responseConverter = converter;
    }

    private i createRawCall() throws IOException {
        return ((f1) this.callFactory).a(this.requestFactory.create(this.args));
    }

    private i getRawCall() throws IOException {
        i iVar = this.rawCall;
        if (iVar != null) {
            return iVar;
        }
        Throwable th = this.creationFailure;
        if (th == null) {
            try {
                i createRawCall = createRawCall();
                this.rawCall = createRawCall;
                return createRawCall;
            } catch (IOException | Error | RuntimeException e10) {
                Utils.throwIfFatal(e10);
                this.creationFailure = e10;
                throw e10;
            }
        } else if (th instanceof IOException) {
            throw ((IOException) th);
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else {
            throw ((Error) th);
        }
    }

    public void cancel() {
        i iVar;
        this.canceled = true;
        synchronized (this) {
            iVar = this.rawCall;
        }
        if (iVar != null) {
            ((o) iVar).cancel();
        }
    }

    public void enqueue(final Callback<T> callback) {
        i iVar;
        Throwable th;
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                iVar = this.rawCall;
                th = this.creationFailure;
                if (iVar == null && th == null) {
                    try {
                        i createRawCall = createRawCall();
                        this.rawCall = createRawCall;
                        iVar = createRawCall;
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.throwIfFatal(th);
                        this.creationFailure = th;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.canceled) {
            ((o) iVar).cancel();
        }
        ((o) iVar).d(new pb.j() {
            private void callFailure(Throwable th) {
                try {
                    callback.onFailure(OkHttpCall.this, th);
                } catch (Throwable th2) {
                    Utils.throwIfFatal(th2);
                    th2.printStackTrace();
                }
            }

            public void onFailure(i iVar, IOException iOException) {
                callFailure(iOException);
            }

            public void onResponse(i iVar, r1 r1Var) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(r1Var));
                    } catch (Throwable th) {
                        Utils.throwIfFatal(th);
                        th.printStackTrace();
                    }
                } catch (Throwable th2) {
                    Utils.throwIfFatal(th2);
                    callFailure(th2);
                }
            }
        });
    }

    public Response<T> execute() throws IOException {
        i rawCall2;
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                rawCall2 = getRawCall();
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.canceled) {
            ((o) rawCall2).cancel();
        }
        return parseResponse(((o) rawCall2).e());
    }

    public boolean isCanceled() {
        boolean z10 = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            i iVar = this.rawCall;
            if (iVar == null || !((o) iVar).f14995w) {
                z10 = false;
            }
        }
        return z10;
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public Response<T> parseResponse(r1 r1Var) throws IOException {
        u1 u1Var = r1Var.f12967n;
        q1 q1Var = new q1(r1Var);
        q1Var.f12940g = new NoContentResponseBody(u1Var.contentType(), u1Var.contentLength());
        r1 a10 = q1Var.a();
        int i10 = a10.f12964k;
        if (i10 < 200 || i10 >= 300) {
            try {
                return Response.error(Utils.buffer(u1Var), a10);
            } finally {
                u1Var.close();
            }
        } else if (i10 == 204 || i10 == 205) {
            u1Var.close();
            return Response.success(null, a10);
        } else {
            ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(u1Var);
            try {
                return Response.success(this.responseConverter.convert(exceptionCatchingResponseBody), a10);
            } catch (RuntimeException e10) {
                exceptionCatchingResponseBody.throwIfCaught();
                throw e10;
            }
        }
    }

    public synchronized j1 request() {
        try {
        } catch (IOException e10) {
            throw new RuntimeException("Unable to create request.", e10);
        }
        return ((o) getRawCall()).f14981i;
    }

    public synchronized s0 timeout() {
        try {
        } catch (IOException e10) {
            throw new RuntimeException("Unable to create call.", e10);
        }
        return ((o) getRawCall()).f14985m;
    }

    public OkHttpCall<T> clone() {
        return new OkHttpCall<>(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }
}
