package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.Playlist;
import java.io.IOException;
import java.io.OutputStream;

public class PlaylistWriter {
    private boolean mFirstWrite;
    private final OutputStream mOutputStream;
    private final boolean mShouldWriteByteOrderMark;
    private final Writer mWriter;

    /* renamed from: com.iheartradio.m3u8.PlaylistWriter$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.iheartradio.m3u8.PlaylistWriter.AnonymousClass1.<clinit>():void");
        }
    }

    public static class Builder {
        private Encoding mEncoding;
        private Format mFormat;
        private OutputStream mOutputStream;
        private boolean mUseByteOrderMark;

        public PlaylistWriter build() {
            return new PlaylistWriter(this.mOutputStream, this.mFormat, this.mEncoding, this.mUseByteOrderMark, (AnonymousClass1) null);
        }

        public Builder useByteOrderMark() {
            this.mUseByteOrderMark = true;
            return this;
        }

        public Builder withEncoding(Encoding encoding) {
            this.mEncoding = encoding;
            return this;
        }

        public Builder withFormat(Format format) {
            this.mFormat = format;
            return this;
        }

        public Builder withOutputStream(OutputStream outputStream) {
            this.mOutputStream = outputStream;
            return this;
        }
    }

    public PlaylistWriter(OutputStream outputStream, Format format, Encoding encoding) {
        this(outputStream, format, encoding, false);
    }

    private void writeByteOrderMark() throws IOException {
        if (this.mShouldWriteByteOrderMark && this.mFirstWrite) {
            int i10 = 0;
            while (true) {
                int[] iArr = Constants.UTF_8_BOM_BYTES;
                if (i10 < iArr.length) {
                    this.mOutputStream.write(iArr[i10]);
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    public void write(Playlist playlist) throws IOException, ParseException, PlaylistException {
        PlaylistValidation from = PlaylistValidation.from(playlist);
        if (from.isValid()) {
            writeByteOrderMark();
            this.mWriter.write(playlist);
            this.mFirstWrite = false;
            return;
        }
        throw new PlaylistException("", from.getErrors());
    }

    private PlaylistWriter(OutputStream outputStream, Format format, Encoding encoding, boolean z10) {
        Writer writer;
        this.mFirstWrite = true;
        if (outputStream == null) {
            throw new IllegalArgumentException("outputStream is null");
        } else if (format == null) {
            throw new IllegalArgumentException("format is null");
        } else if (encoding != null) {
            this.mOutputStream = outputStream;
            this.mShouldWriteByteOrderMark = encoding.supportsByteOrderMark && z10;
            int i10 = AnonymousClass1.$SwitchMap$com$iheartradio$m3u8$Format[format.ordinal()];
            if (i10 == 1) {
                writer = new M3uWriter(outputStream, encoding);
            } else if (i10 == 2) {
                writer = new ExtendedM3uWriter(outputStream, encoding);
            } else {
                throw new RuntimeException("unsupported format detected, this should be impossible: " + format);
            }
            this.mWriter = writer;
        } else {
            throw new IllegalArgumentException("encoding is null");
        }
    }

    public /* synthetic */ PlaylistWriter(OutputStream outputStream, Format format, Encoding encoding, boolean z10, AnonymousClass1 r52) {
        this(outputStream, format, encoding, z10);
    }
}
