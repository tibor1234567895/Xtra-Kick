package retrofit2;

import android.support.v4.media.h;
import dc.k;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Pattern;
import pb.b1;
import pb.c1;
import pb.h0;
import pb.i1;
import pb.j0;
import pb.n0;
import pb.o1;
import pb.p0;
import pb.r0;
import pb.s0;
import pb.t0;
import pb.w0;
import pb.x0;
import pb.y0;
import xa.j;

final class RequestBuilder {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private static final Pattern PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
    private final t0 baseUrl;
    private o1 body;
    private x0 contentType;
    private h0 formBuilder;
    private final boolean hasBody;
    private final n0 headersBuilder;
    private final String method;
    private y0 multipartBuilder;
    private String relativeUrl;
    private final i1 requestBuilder = new i1();
    private r0 urlBuilder;

    public static class ContentTypeOverridingRequestBody extends o1 {
        private final x0 contentType;
        private final o1 delegate;

        public ContentTypeOverridingRequestBody(o1 o1Var, x0 x0Var) {
            this.delegate = o1Var;
            this.contentType = x0Var;
        }

        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        public x0 contentType() {
            return this.contentType;
        }

        public void writeTo(k kVar) throws IOException {
            this.delegate.writeTo(kVar);
        }
    }

    public RequestBuilder(String str, t0 t0Var, String str2, p0 p0Var, x0 x0Var, boolean z10, boolean z11, boolean z12) {
        n0 n0Var;
        this.method = str;
        this.baseUrl = t0Var;
        this.relativeUrl = str2;
        this.contentType = x0Var;
        this.hasBody = z10;
        if (p0Var != null) {
            n0Var = p0Var.d();
        } else {
            n0Var = new n0();
        }
        this.headersBuilder = n0Var;
        if (z11) {
            this.formBuilder = new h0();
        } else if (z12) {
            y0 y0Var = new y0();
            this.multipartBuilder = y0Var;
            x0 x0Var2 = c1.f12778f;
            j.f("type", x0Var2);
            if (j.a(x0Var2.f13025b, "multipart")) {
                y0Var.f13037b = x0Var2;
                return;
            }
            throw new IllegalArgumentException(("multipart != " + x0Var2).toString());
        }
    }

    private static String canonicalizeForPath(String str, boolean z10) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int codePointAt = str.codePointAt(i10);
            if (codePointAt < 32 || codePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) != -1 || (!z10 && (codePointAt == 47 || codePointAt == 37))) {
                dc.j jVar = new dc.j();
                jVar.W0(0, i10, str);
                canonicalizeForPath(jVar, str, i10, length, z10);
                return jVar.j0();
            }
            i10 += Character.charCount(codePointAt);
        }
        return str;
    }

    public void addFormField(String str, String str2, boolean z10) {
        String str3 = str;
        String str4 = str2;
        h0 h0Var = this.formBuilder;
        h0Var.getClass();
        ArrayList arrayList = h0Var.f12865c;
        ArrayList arrayList2 = h0Var.f12864b;
        if (z10) {
            j.f("name", str3);
            j.f("value", str4);
            s0 s0Var = t0.f12987k;
            arrayList2.add(s0.a(s0Var, str, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", true, false, true, false, h0Var.f12863a, 83));
            arrayList.add(s0.a(s0Var, str2, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", true, false, true, false, h0Var.f12863a, 83));
            return;
        }
        j.f("name", str3);
        j.f("value", str4);
        s0 s0Var2 = t0.f12987k;
        arrayList2.add(s0.a(s0Var2, str, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", false, false, false, false, h0Var.f12863a, 91));
        arrayList.add(s0.a(s0Var2, str2, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", false, false, false, false, h0Var.f12863a, 91));
    }

    public void addHeader(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            try {
                x0.f13023d.getClass();
                this.contentType = w0.a(str2);
            } catch (IllegalArgumentException e10) {
                throw new IllegalArgumentException(h.m("Malformed content type: ", str2), e10);
            }
        } else {
            this.headersBuilder.a(str, str2);
        }
    }

    public void addHeaders(p0 p0Var) {
        n0 n0Var = this.headersBuilder;
        n0Var.getClass();
        j.f("headers", p0Var);
        int length = p0Var.f12931h.length / 2;
        for (int i10 = 0; i10 < length; i10++) {
            hb.h0.C(n0Var, p0Var.c(i10), p0Var.f(i10));
        }
    }

    public void addPart(p0 p0Var, o1 o1Var) {
        y0 y0Var = this.multipartBuilder;
        y0Var.getClass();
        j.f("body", o1Var);
        b1.f12772c.getClass();
        String str = null;
        boolean z10 = false;
        if ((p0Var != null ? p0Var.a("Content-Type") : null) == null) {
            if (p0Var != null) {
                str = p0Var.a("Content-Length");
            }
            if (str == null) {
                z10 = true;
            }
            if (z10) {
                y0Var.f13038c.add(new b1(p0Var, o1Var));
                return;
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
        }
        throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
    }

    public void addPathParam(String str, String str2, boolean z10) {
        if (this.relativeUrl != null) {
            String canonicalizeForPath = canonicalizeForPath(str2, z10);
            String str3 = this.relativeUrl;
            String replace = str3.replace("{" + str + "}", canonicalizeForPath);
            if (!PATH_TRAVERSAL.matcher(replace).matches()) {
                this.relativeUrl = replace;
                return;
            }
            throw new IllegalArgumentException(h.m("@Path parameters shouldn't perform path traversal ('.' or '..'): ", str2));
        }
        throw new AssertionError();
    }

    public void addQueryParam(String str, String str2, boolean z10) {
        r0 r0Var;
        String str3 = str;
        String str4 = this.relativeUrl;
        String str5 = null;
        if (str4 != null) {
            t0 t0Var = this.baseUrl;
            t0Var.getClass();
            try {
                r0Var = new r0();
                r0Var.c(t0Var, str4);
            } catch (IllegalArgumentException unused) {
                r0Var = null;
            }
            this.urlBuilder = r0Var;
            if (r0Var != null) {
                this.relativeUrl = null;
            } else {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        r0 r0Var2 = this.urlBuilder;
        r0Var2.getClass();
        if (z10) {
            j.f("encodedName", str3);
            if (r0Var2.f12959g == null) {
                r0Var2.f12959g = new ArrayList();
            }
            ArrayList arrayList = r0Var2.f12959g;
            j.c(arrayList);
            s0 s0Var = t0.f12987k;
            arrayList.add(s0.a(s0Var, str, 0, 0, " \"'<>#&=", true, false, true, false, (Charset) null, 211));
            ArrayList arrayList2 = r0Var2.f12959g;
            j.c(arrayList2);
            if (str2 != null) {
                str5 = s0.a(s0Var, str2, 0, 0, " \"'<>#&=", true, false, true, false, (Charset) null, 211);
            }
            arrayList2.add(str5);
            return;
        }
        j.f("name", str3);
        if (r0Var2.f12959g == null) {
            r0Var2.f12959g = new ArrayList();
        }
        ArrayList arrayList3 = r0Var2.f12959g;
        j.c(arrayList3);
        s0 s0Var2 = t0.f12987k;
        arrayList3.add(s0.a(s0Var2, str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, (Charset) null, 219));
        ArrayList arrayList4 = r0Var2.f12959g;
        j.c(arrayList4);
        if (str2 != null) {
            str5 = s0.a(s0Var2, str2, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, (Charset) null, 219);
        }
        arrayList4.add(str5);
    }

    public <T> void addTag(Class<T> cls, T t10) {
        this.requestBuilder.f(cls, t10);
    }

    public i1 get() {
        t0 t0Var;
        r0 r0Var = this.urlBuilder;
        if (r0Var != null) {
            t0Var = r0Var.a();
        } else {
            t0Var = this.baseUrl.h(this.relativeUrl);
            if (t0Var == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        ContentTypeOverridingRequestBody contentTypeOverridingRequestBody = this.body;
        if (contentTypeOverridingRequestBody == null) {
            h0 h0Var = this.formBuilder;
            if (h0Var != null) {
                contentTypeOverridingRequestBody = new j0(h0Var.f12864b, h0Var.f12865c);
            } else {
                y0 y0Var = this.multipartBuilder;
                if (y0Var != null) {
                    ArrayList arrayList = y0Var.f13038c;
                    if (!arrayList.isEmpty()) {
                        contentTypeOverridingRequestBody = new c1(y0Var.f13036a, y0Var.f13037b, qb.h.l(arrayList));
                    } else {
                        throw new IllegalStateException("Multipart body must have at least one part.".toString());
                    }
                } else if (this.hasBody) {
                    contentTypeOverridingRequestBody = o1.create((x0) null, new byte[0]);
                }
            }
        }
        x0 x0Var = this.contentType;
        if (x0Var != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, x0Var);
            } else {
                this.headersBuilder.a("Content-Type", x0Var.f13024a);
            }
        }
        i1 i1Var = this.requestBuilder;
        i1Var.getClass();
        i1Var.f12876a = t0Var;
        i1Var.f12878c = this.headersBuilder.b().d();
        i1Var.d(this.method, contentTypeOverridingRequestBody);
        return i1Var;
    }

    public void setBody(o1 o1Var) {
        this.body = o1Var;
    }

    public void setRelativeUrl(Object obj) {
        this.relativeUrl = obj.toString();
    }

    private static void canonicalizeForPath(dc.j jVar, String str, int i10, int i11, boolean z10) {
        dc.j jVar2 = null;
        while (i10 < i11) {
            int codePointAt = str.codePointAt(i10);
            if (!z10 || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) != -1 || (!z10 && (codePointAt == 47 || codePointAt == 37))) {
                    if (jVar2 == null) {
                        jVar2 = new dc.j();
                    }
                    jVar2.Y0(codePointAt);
                    while (!jVar2.R()) {
                        byte readByte = jVar2.readByte() & 255;
                        jVar.Q0(37);
                        char[] cArr = HEX_DIGITS;
                        jVar.Q0(cArr[(readByte >> 4) & 15]);
                        jVar.Q0(cArr[readByte & 15]);
                    }
                } else {
                    jVar.Y0(codePointAt);
                }
            }
            i10 += Character.charCount(codePointAt);
        }
    }

    public void addPart(b1 b1Var) {
        y0 y0Var = this.multipartBuilder;
        y0Var.getClass();
        j.f("part", b1Var);
        y0Var.f13038c.add(b1Var);
    }
}
