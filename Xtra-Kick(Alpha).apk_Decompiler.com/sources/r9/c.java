package r9;

import v3.d;

public final class c extends a {
    public c() {
        super(4, 5);
    }

    public final void a(d dVar) {
        dVar.p("ALTER TABLE 'requests' ADD COLUMN '_download_on_enqueue' INTEGER NOT NULL DEFAULT 1");
    }
}
