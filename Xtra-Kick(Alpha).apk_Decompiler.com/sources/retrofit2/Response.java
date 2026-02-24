package retrofit2;

import android.support.v4.media.h;
import java.util.Objects;
import pb.h1;
import pb.i1;
import pb.j1;
import pb.p0;
import pb.q1;
import pb.r1;
import pb.u1;
import retrofit2.OkHttpCall;

public final class Response<T> {
    private final T body;
    private final u1 errorBody;
    private final r1 rawResponse;

    private Response(r1 r1Var, T t10, u1 u1Var) {
        this.rawResponse = r1Var;
        this.body = t10;
        this.errorBody = u1Var;
    }

    public static <T> Response<T> error(int i10, u1 u1Var) {
        Objects.requireNonNull(u1Var, "body == null");
        if (i10 >= 400) {
            q1 q1Var = new q1();
            q1Var.f12940g = new OkHttpCall.NoContentResponseBody(u1Var.contentType(), u1Var.contentLength());
            q1Var.f12936c = i10;
            q1Var.c("Response.error()");
            q1Var.d(h1.HTTP_1_1);
            i1 i1Var = new i1();
            i1Var.g("http://localhost/");
            q1Var.e(new j1(i1Var));
            return error(u1Var, q1Var.a());
        }
        throw new IllegalArgumentException(h.i("code < 400: ", i10));
    }

    public static <T> Response<T> success(int i10, T t10) {
        if (i10 < 200 || i10 >= 300) {
            throw new IllegalArgumentException(h.i("code < 200 or >= 300: ", i10));
        }
        q1 q1Var = new q1();
        q1Var.f12936c = i10;
        q1Var.c("Response.success()");
        q1Var.d(h1.HTTP_1_1);
        i1 i1Var = new i1();
        i1Var.g("http://localhost/");
        q1Var.e(new j1(i1Var));
        return success(t10, q1Var.a());
    }

    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.f12964k;
    }

    public u1 errorBody() {
        return this.errorBody;
    }

    public p0 headers() {
        return this.rawResponse.f12966m;
    }

    public boolean isSuccessful() {
        return this.rawResponse.f12976w;
    }

    public String message() {
        return this.rawResponse.f12963j;
    }

    public r1 raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }

    public static <T> Response<T> success(T t10) {
        q1 q1Var = new q1();
        q1Var.f12936c = 200;
        q1Var.c("OK");
        q1Var.d(h1.HTTP_1_1);
        i1 i1Var = new i1();
        i1Var.g("http://localhost/");
        q1Var.e(new j1(i1Var));
        return success(t10, q1Var.a());
    }

    public static <T> Response<T> error(u1 u1Var, r1 r1Var) {
        Objects.requireNonNull(u1Var, "body == null");
        Objects.requireNonNull(r1Var, "rawResponse == null");
        if (!r1Var.f12976w) {
            return new Response<>(r1Var, (Object) null, u1Var);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> Response<T> success(T t10, p0 p0Var) {
        Objects.requireNonNull(p0Var, "headers == null");
        q1 q1Var = new q1();
        q1Var.f12936c = 200;
        q1Var.c("OK");
        q1Var.d(h1.HTTP_1_1);
        q1Var.b(p0Var);
        i1 i1Var = new i1();
        i1Var.g("http://localhost/");
        q1Var.e(new j1(i1Var));
        return success(t10, q1Var.a());
    }

    public static <T> Response<T> success(T t10, r1 r1Var) {
        Objects.requireNonNull(r1Var, "rawResponse == null");
        if (r1Var.f12976w) {
            return new Response<>(r1Var, t10, (u1) null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }
}
