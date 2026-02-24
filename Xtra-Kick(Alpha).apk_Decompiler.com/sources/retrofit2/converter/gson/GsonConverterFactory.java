package retrofit2.converter.gson;

import j9.n;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import o9.a;
import pb.o1;
import pb.u1;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class GsonConverterFactory extends Converter.Factory {
    private final n gson;

    private GsonConverterFactory(n nVar) {
        this.gson = nVar;
    }

    public static GsonConverterFactory create() {
        return create(new n());
    }

    public Converter<?, o1> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new GsonRequestBodyConverter(this.gson, this.gson.b(new a(type)));
    }

    public Converter<u1, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new GsonResponseBodyConverter(this.gson, this.gson.b(new a(type)));
    }

    public static GsonConverterFactory create(n nVar) {
        if (nVar != null) {
            return new GsonConverterFactory(nVar);
        }
        throw new NullPointerException("gson == null");
    }
}
