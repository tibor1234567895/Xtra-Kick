package t7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import j9.s;
import j9.t;
import j9.u;
import j9.v;
import j9.w;
import java.io.IOException;
import java.io.StringReader;
import xa.j;

public final class c {
    private c() {
    }

    public /* synthetic */ c(int i10) {
        this();
    }

    public static v a(String str) {
        j.f("<this>", str);
        new w();
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            s a10 = w.a(jsonReader);
            a10.getClass();
            if (!(a10 instanceof u)) {
                if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new t("Did not consume the entire document.");
                }
            }
            return a10.c();
        } catch (MalformedJsonException e10) {
            throw new t((Exception) e10);
        } catch (IOException e11) {
            throw new t((Exception) e11);
        } catch (NumberFormatException e12) {
            throw new t((Exception) e12);
        }
    }
}
