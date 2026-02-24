package retrofit2;

import android.support.v4.media.h;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import pb.b1;
import pb.o0;
import pb.o1;
import pb.p0;

abstract class ParameterHandler<T> {

    public static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, o1> converter;
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f13901p;

        public Body(Method method2, int i10, Converter<T, o1> converter2) {
            this.method = method2;
            this.f13901p = i10;
            this.converter = converter2;
        }

        public void apply(RequestBuilder requestBuilder, T t10) {
            if (t10 != null) {
                try {
                    requestBuilder.setBody(this.converter.convert(t10));
                } catch (IOException e10) {
                    Method method2 = this.method;
                    int i10 = this.f13901p;
                    throw Utils.parameterError(method2, e10, i10, "Unable to convert " + t10 + " to RequestBody", new Object[0]);
                }
            } else {
                throw Utils.parameterError(this.method, this.f13901p, "Body parameter value must not be null.", new Object[0]);
            }
        }
    }

    public static final class Field<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        public Field(String str, Converter<T, String> converter, boolean z10) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z10;
        }

        public void apply(RequestBuilder requestBuilder, T t10) throws IOException {
            String convert;
            if (t10 != null && (convert = this.valueConverter.convert(t10)) != null) {
                requestBuilder.addFormField(this.name, convert, this.encoded);
            }
        }
    }

    public static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f13902p;
        private final Converter<T, String> valueConverter;

        public FieldMap(Method method2, int i10, Converter<T, String> converter, boolean z10) {
            this.method = method2;
            this.f13902p = i10;
            this.valueConverter = converter;
            this.encoded = z10;
        }

        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            String convert = this.valueConverter.convert(value);
                            if (convert != null) {
                                requestBuilder.addFormField(str, convert, this.encoded);
                            } else {
                                Method method2 = this.method;
                                int i10 = this.f13902p;
                                throw Utils.parameterError(method2, i10, "Field map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                            }
                        } else {
                            throw Utils.parameterError(this.method, this.f13902p, h.n("Field map contained null value for key '", str, "'."), new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.f13902p, "Field map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f13902p, "Field map was null.", new Object[0]);
        }
    }

    public static final class Header<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        public Header(String str, Converter<T, String> converter) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
        }

        public void apply(RequestBuilder requestBuilder, T t10) throws IOException {
            String convert;
            if (t10 != null && (convert = this.valueConverter.convert(t10)) != null) {
                requestBuilder.addHeader(this.name, convert);
            }
        }
    }

    public static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f13903p;
        private final Converter<T, String> valueConverter;

        public HeaderMap(Method method2, int i10, Converter<T, String> converter) {
            this.method = method2;
            this.f13903p = i10;
            this.valueConverter = converter;
        }

        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            requestBuilder.addHeader(str, this.valueConverter.convert(value));
                        } else {
                            throw Utils.parameterError(this.method, this.f13903p, h.n("Header map contained null value for key '", str, "'."), new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.f13903p, "Header map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f13903p, "Header map was null.", new Object[0]);
        }
    }

    public static final class Headers extends ParameterHandler<p0> {
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f13904p;

        public Headers(Method method2, int i10) {
            this.method = method2;
            this.f13904p = i10;
        }

        public void apply(RequestBuilder requestBuilder, p0 p0Var) {
            if (p0Var != null) {
                requestBuilder.addHeaders(p0Var);
                return;
            }
            throw Utils.parameterError(this.method, this.f13904p, "Headers parameter must not be null.", new Object[0]);
        }
    }

    public static final class Part<T> extends ParameterHandler<T> {
        private final Converter<T, o1> converter;
        private final p0 headers;
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f13905p;

        public Part(Method method2, int i10, p0 p0Var, Converter<T, o1> converter2) {
            this.method = method2;
            this.f13905p = i10;
            this.headers = p0Var;
            this.converter = converter2;
        }

        public void apply(RequestBuilder requestBuilder, T t10) {
            if (t10 != null) {
                try {
                    requestBuilder.addPart(this.headers, this.converter.convert(t10));
                } catch (IOException e10) {
                    Method method2 = this.method;
                    int i10 = this.f13905p;
                    throw Utils.parameterError(method2, i10, "Unable to convert " + t10 + " to RequestBody", e10);
                }
            }
        }
    }

    public static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f13906p;
        private final String transferEncoding;
        private final Converter<T, o1> valueConverter;

        public PartMap(Method method2, int i10, Converter<T, o1> converter, String str) {
            this.method = method2;
            this.f13906p = i10;
            this.valueConverter = converter;
            this.transferEncoding = str;
        }

        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            String[] strArr = {"Content-Disposition", h.n("form-data; name=\"", str, "\""), "Content-Transfer-Encoding", this.transferEncoding};
                            p0.f12930i.getClass();
                            requestBuilder.addPart(o0.a(strArr), this.valueConverter.convert(value));
                        } else {
                            throw Utils.parameterError(this.method, this.f13906p, h.n("Part map contained null value for key '", str, "'."), new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.f13906p, "Part map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f13906p, "Part map was null.", new Object[0]);
        }
    }

    public static final class Path<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Method method;
        private final String name;

        /* renamed from: p  reason: collision with root package name */
        private final int f13907p;
        private final Converter<T, String> valueConverter;

        public Path(Method method2, int i10, String str, Converter<T, String> converter, boolean z10) {
            this.method = method2;
            this.f13907p = i10;
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z10;
        }

        public void apply(RequestBuilder requestBuilder, T t10) throws IOException {
            if (t10 != null) {
                requestBuilder.addPathParam(this.name, this.valueConverter.convert(t10), this.encoded);
                return;
            }
            throw Utils.parameterError(this.method, this.f13907p, h.p(new StringBuilder("Path parameter \""), this.name, "\" value must not be null."), new Object[0]);
        }
    }

    public static final class Query<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        public Query(String str, Converter<T, String> converter, boolean z10) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z10;
        }

        public void apply(RequestBuilder requestBuilder, T t10) throws IOException {
            String convert;
            if (t10 != null && (convert = this.valueConverter.convert(t10)) != null) {
                requestBuilder.addQueryParam(this.name, convert, this.encoded);
            }
        }
    }

    public static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f13908p;
        private final Converter<T, String> valueConverter;

        public QueryMap(Method method2, int i10, Converter<T, String> converter, boolean z10) {
            this.method = method2;
            this.f13908p = i10;
            this.valueConverter = converter;
            this.encoded = z10;
        }

        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            String convert = this.valueConverter.convert(value);
                            if (convert != null) {
                                requestBuilder.addQueryParam(str, convert, this.encoded);
                            } else {
                                Method method2 = this.method;
                                int i10 = this.f13908p;
                                throw Utils.parameterError(method2, i10, "Query map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                            }
                        } else {
                            throw Utils.parameterError(this.method, this.f13908p, h.n("Query map contained null value for key '", str, "'."), new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.f13908p, "Query map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f13908p, "Query map was null", new Object[0]);
        }
    }

    public static final class QueryName<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Converter<T, String> nameConverter;

        public QueryName(Converter<T, String> converter, boolean z10) {
            this.nameConverter = converter;
            this.encoded = z10;
        }

        public void apply(RequestBuilder requestBuilder, T t10) throws IOException {
            if (t10 != null) {
                requestBuilder.addQueryParam(this.nameConverter.convert(t10), (String) null, this.encoded);
            }
        }
    }

    public static final class RawPart extends ParameterHandler<b1> {
        static final RawPart INSTANCE = new RawPart();

        private RawPart() {
        }

        public void apply(RequestBuilder requestBuilder, b1 b1Var) {
            if (b1Var != null) {
                requestBuilder.addPart(b1Var);
            }
        }
    }

    public static final class RelativeUrl extends ParameterHandler<Object> {
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f13909p;

        public RelativeUrl(Method method2, int i10) {
            this.method = method2;
            this.f13909p = i10;
        }

        public void apply(RequestBuilder requestBuilder, Object obj) {
            if (obj != null) {
                requestBuilder.setRelativeUrl(obj);
                return;
            }
            throw Utils.parameterError(this.method, this.f13909p, "@Url parameter is null.", new Object[0]);
        }
    }

    public static final class Tag<T> extends ParameterHandler<T> {
        final Class<T> cls;

        public Tag(Class<T> cls2) {
            this.cls = cls2;
        }

        public void apply(RequestBuilder requestBuilder, T t10) {
            requestBuilder.addTag(this.cls, t10);
        }
    }

    public abstract void apply(RequestBuilder requestBuilder, T t10) throws IOException;

    public final ParameterHandler<Object> array() {
        return new ParameterHandler<Object>() {
            public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
                if (obj != null) {
                    int length = Array.getLength(obj);
                    for (int i10 = 0; i10 < length; i10++) {
                        ParameterHandler.this.apply(requestBuilder, Array.get(obj, i10));
                    }
                }
            }
        };
    }

    public final ParameterHandler<Iterable<T>> iterable() {
        return new ParameterHandler<Iterable<T>>() {
            public void apply(RequestBuilder requestBuilder, Iterable<T> iterable) throws IOException {
                if (iterable != null) {
                    for (T apply : iterable) {
                        ParameterHandler.this.apply(requestBuilder, apply);
                    }
                }
            }
        };
    }
}
