package retrofit2.converter.gson;

import com.google.gson.stream.JsonWriter;
import dc.i;
import dc.j;
import j9.b0;
import j9.n;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import pb.o1;
import pb.w0;
import pb.x0;
import retrofit2.Converter;

final class GsonRequestBodyConverter<T> implements Converter<T, o1> {
    private static final x0 MEDIA_TYPE = w0.a("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final b0 adapter;
    private final n gson;

    static {
        x0.f13023d.getClass();
    }

    public GsonRequestBodyConverter(n nVar, b0 b0Var) {
        this.gson = nVar;
        this.adapter = b0Var;
    }

    public o1 convert(T t10) throws IOException {
        j jVar = new j();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new i(jVar), UTF_8);
        n nVar = this.gson;
        if (nVar.f8864g) {
            outputStreamWriter.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(outputStreamWriter);
        if (nVar.f8865h) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setSerializeNulls(nVar.f8863f);
        this.adapter.c(jsonWriter, t10);
        jsonWriter.close();
        return o1.create(MEDIA_TYPE, jVar.m());
    }
}
