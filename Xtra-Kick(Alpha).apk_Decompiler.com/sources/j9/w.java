package j9;

import androidx.fragment.app.y;
import com.google.gson.stream.JsonReader;
import l9.s;

public final class w {
    public static s a(JsonReader jsonReader) {
        boolean isLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            s a10 = s.a(jsonReader);
            jsonReader.setLenient(isLenient);
            return a10;
        } catch (StackOverflowError e10) {
            throw new y("Failed parsing JSON source: " + jsonReader + " to Json", (Throwable) e10);
        } catch (OutOfMemoryError e11) {
            throw new y("Failed parsing JSON source: " + jsonReader + " to Json", (Throwable) e11);
        } catch (Throwable th) {
            jsonReader.setLenient(isLenient);
            throw th;
        }
    }
}
