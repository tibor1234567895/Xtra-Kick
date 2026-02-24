package retrofit2.converter.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import j9.b0;
import j9.n;
import j9.t;
import java.io.IOException;
import java.io.Reader;
import pb.u1;
import retrofit2.Converter;

final class GsonResponseBodyConverter<T> implements Converter<u1, T> {
    private final b0 adapter;
    private final n gson;

    public GsonResponseBodyConverter(n nVar, b0 b0Var) {
        this.gson = nVar;
        this.adapter = b0Var;
    }

    public T convert(u1 u1Var) throws IOException {
        n nVar = this.gson;
        Reader charStream = u1Var.charStream();
        nVar.getClass();
        JsonReader jsonReader = new JsonReader(charStream);
        jsonReader.setLenient(nVar.f8866i);
        try {
            T b10 = this.adapter.b(jsonReader);
            if (jsonReader.peek() == JsonToken.END_DOCUMENT) {
                return b10;
            }
            throw new t("JSON document was not fully consumed.");
        } finally {
            u1Var.close();
        }
    }
}
