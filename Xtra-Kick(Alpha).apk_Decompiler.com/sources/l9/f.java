package l9;

import com.google.gson.internal.Excluder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import j9.n;
import o9.a;

public final class f extends b0 {

    /* renamed from: a  reason: collision with root package name */
    public b0 f9762a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f9763b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f9764c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ n f9765d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f9766e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Excluder f9767f;

    public f(Excluder excluder, boolean z10, boolean z11, n nVar, a aVar) {
        this.f9767f = excluder;
        this.f9763b = z10;
        this.f9764c = z11;
        this.f9765d = nVar;
        this.f9766e = aVar;
    }

    public final Object b(JsonReader jsonReader) {
        if (this.f9763b) {
            jsonReader.skipValue();
            return null;
        }
        b0 b0Var = this.f9762a;
        if (b0Var == null) {
            b0Var = this.f9765d.c(this.f9767f, this.f9766e);
            this.f9762a = b0Var;
        }
        return b0Var.b(jsonReader);
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        if (this.f9764c) {
            jsonWriter.nullValue();
            return;
        }
        b0 b0Var = this.f9762a;
        if (b0Var == null) {
            b0Var = this.f9765d.c(this.f9767f, this.f9766e);
            this.f9762a = b0Var;
        }
        b0Var.c(jsonWriter, obj);
    }
}
