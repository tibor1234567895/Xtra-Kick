package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import la.v;
import pb.o1;
import pb.u1;
import retrofit2.Converter;
import retrofit2.http.Streaming;

final class BuiltInConverters extends Converter.Factory {
    private boolean checkForKotlinUnit = true;

    public static final class BufferingResponseBodyConverter implements Converter<u1, u1> {
        static final BufferingResponseBodyConverter INSTANCE = new BufferingResponseBodyConverter();

        public u1 convert(u1 u1Var) throws IOException {
            try {
                return Utils.buffer(u1Var);
            } finally {
                u1Var.close();
            }
        }
    }

    public static final class RequestBodyConverter implements Converter<o1, o1> {
        static final RequestBodyConverter INSTANCE = new RequestBodyConverter();

        public o1 convert(o1 o1Var) {
            return o1Var;
        }
    }

    public static final class StreamingResponseBodyConverter implements Converter<u1, u1> {
        static final StreamingResponseBodyConverter INSTANCE = new StreamingResponseBodyConverter();

        public u1 convert(u1 u1Var) {
            return u1Var;
        }
    }

    public static final class ToStringConverter implements Converter<Object, String> {
        static final ToStringConverter INSTANCE = new ToStringConverter();

        public String convert(Object obj) {
            return obj.toString();
        }
    }

    public static final class UnitResponseBodyConverter implements Converter<u1, v> {
        static final UnitResponseBodyConverter INSTANCE = new UnitResponseBodyConverter();

        public v convert(u1 u1Var) {
            u1Var.close();
            return v.f9814a;
        }
    }

    public static final class VoidResponseBodyConverter implements Converter<u1, Void> {
        static final VoidResponseBodyConverter INSTANCE = new VoidResponseBodyConverter();

        public Void convert(u1 u1Var) {
            u1Var.close();
            return null;
        }
    }

    public Converter<?, o1> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if (o1.class.isAssignableFrom(Utils.getRawType(type))) {
            return RequestBodyConverter.INSTANCE;
        }
        return null;
    }

    public Converter<u1, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == u1.class) {
            return Utils.isAnnotationPresent(annotationArr, Streaming.class) ? StreamingResponseBodyConverter.INSTANCE : BufferingResponseBodyConverter.INSTANCE;
        }
        if (type == Void.class) {
            return VoidResponseBodyConverter.INSTANCE;
        }
        if (!this.checkForKotlinUnit || type != v.class) {
            return null;
        }
        try {
            return UnitResponseBodyConverter.INSTANCE;
        } catch (NoClassDefFoundError unused) {
            this.checkForKotlinUnit = false;
            return null;
        }
    }
}
