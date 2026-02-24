package n2;

import c9.h;
import g1.z0;
import j2.b;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f11022c = Pattern.compile("(.+?)='(.*?)';", 32);

    /* renamed from: a  reason: collision with root package name */
    public final CharsetDecoder f11023a = h.f3035c.newDecoder();

    /* renamed from: b  reason: collision with root package name */
    public final CharsetDecoder f11024b = h.f3034b.newDecoder();

    public final z0 b(j2.a aVar, ByteBuffer byteBuffer) {
        String str;
        CharsetDecoder charsetDecoder = this.f11024b;
        CharsetDecoder charsetDecoder2 = this.f11023a;
        String str2 = null;
        try {
            str = charsetDecoder2.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                String charBuffer = charsetDecoder.decode(byteBuffer).toString();
                charsetDecoder.reset();
                byteBuffer.rewind();
                str = charBuffer;
            } catch (CharacterCodingException unused2) {
                charsetDecoder.reset();
                byteBuffer.rewind();
                str = null;
            } catch (Throwable th) {
                charsetDecoder.reset();
                byteBuffer.rewind();
                throw th;
            }
        } finally {
            charsetDecoder2.reset();
            byteBuffer.rewind();
        }
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        if (str == null) {
            return new z0(new e(bArr, (String) null, (String) null));
        }
        Matcher matcher = f11022c.matcher(str);
        String str3 = null;
        for (int i10 = 0; matcher.find(i10); i10 = matcher.end()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            if (group != null) {
                String a10 = c9.b.a(group);
                a10.getClass();
                if (a10.equals("streamurl")) {
                    str3 = group2;
                } else if (a10.equals("streamtitle")) {
                    str2 = group2;
                }
            }
        }
        return new z0(new e(bArr, str2, str3));
    }
}
