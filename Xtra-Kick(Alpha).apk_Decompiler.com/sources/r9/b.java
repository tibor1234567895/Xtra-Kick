package r9;

import v3.d;

public final class b extends a {
    public b() {
        super(5, 6);
    }

    public final void a(d dVar) {
        dVar.p("ALTER TABLE 'requests' ADD COLUMN '_extras' TEXT NOT NULL DEFAULT '{}'");
    }
}
