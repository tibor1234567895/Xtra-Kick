package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.Playlist;
import java.io.IOException;
import java.io.InputStream;

public class PlaylistParser implements IPlaylistParser {
    private final IPlaylistParser mPlaylistParser;

    /* renamed from: com.iheartradio.m3u8.PlaylistParser$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$iheartradio$m3u8$Format;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.iheartradio.m3u8.Format[] r0 = com.iheartradio.m3u8.Format.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$iheartradio$m3u8$Format = r0
                com.iheartradio.m3u8.Format r1 = com.iheartradio.m3u8.Format.M3U     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$iheartradio$m3u8$Format     // Catch:{ NoSuchFieldError -> 0x001d }
                com.iheartradio.m3u8.Format r1 = com.iheartradio.m3u8.Format.EXT_M3U     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iheartradio.m3u8.PlaylistParser.AnonymousClass1.<clinit>():void");
        }
    }

    public PlaylistParser(InputStream inputStream, Format format, Encoding encoding) {
        this(inputStream, format, encoding, ParsingMode.STRICT);
    }

    private static Extension parseExtension(String str) {
        if (str != null) {
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf != -1) {
                String substring = str.substring(lastIndexOf + 1);
                Extension extension = Extension.M3U;
                if (extension.value.equalsIgnoreCase(substring)) {
                    return extension;
                }
                Extension extension2 = Extension.M3U8;
                if (extension2.value.equalsIgnoreCase(substring)) {
                    return extension2;
                }
                throw new IllegalArgumentException("filename extension should be .m3u or .m3u8: ".concat(str));
            }
            throw new IllegalArgumentException("filename has no extension: ".concat(str));
        }
        throw new IllegalArgumentException("filename is null");
    }

    public boolean isAvailable() {
        return this.mPlaylistParser.isAvailable();
    }

    public Playlist parse() throws IOException, ParseException, PlaylistException {
        return this.mPlaylistParser.parse();
    }

    public PlaylistParser(InputStream inputStream, Format format, Encoding encoding, ParsingMode parsingMode) {
        IPlaylistParser iPlaylistParser;
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream is null");
        } else if (format == null) {
            throw new IllegalArgumentException("format is null");
        } else if (encoding == null) {
            throw new IllegalArgumentException("encoding is null");
        } else if (parsingMode != null || format == Format.M3U) {
            int i10 = AnonymousClass1.$SwitchMap$com$iheartradio$m3u8$Format[format.ordinal()];
            if (i10 == 1) {
                iPlaylistParser = new M3uParser(inputStream, encoding);
            } else if (i10 == 2) {
                iPlaylistParser = new ExtendedM3uParser(inputStream, encoding, parsingMode);
            } else {
                throw new RuntimeException("unsupported format detected, this should be impossible: " + format);
            }
            this.mPlaylistParser = iPlaylistParser;
        } else {
            throw new IllegalArgumentException("parsingMode is null");
        }
    }

    public PlaylistParser(InputStream inputStream, Format format, Extension extension) {
        this(inputStream, format, extension.encoding, ParsingMode.STRICT);
    }

    public PlaylistParser(InputStream inputStream, Format format, Extension extension, ParsingMode parsingMode) {
        this(inputStream, format, extension.encoding, parsingMode);
    }

    public PlaylistParser(InputStream inputStream, Format format, String str) {
        this(inputStream, format, parseExtension(str), ParsingMode.STRICT);
    }

    public PlaylistParser(InputStream inputStream, Format format, String str, ParsingMode parsingMode) {
        this(inputStream, format, parseExtension(str), parsingMode);
    }
}
