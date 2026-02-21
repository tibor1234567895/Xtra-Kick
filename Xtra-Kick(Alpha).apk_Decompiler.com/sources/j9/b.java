package j9;

import java.lang.reflect.Field;

/* 'enum' modifier removed */
public final class b extends h {
    public b() {
        super("IDENTITY", 0);
    }

    public final String a(Field field) {
        return field.getName();
    }
}
