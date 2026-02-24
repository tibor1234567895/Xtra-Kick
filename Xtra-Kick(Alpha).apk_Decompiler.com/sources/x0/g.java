package x0;

import android.content.res.AssetManager;
import android.support.v4.media.h;
import android.system.OsConstants;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

public final class g {
    public static final byte[] A = {69, 88, 73, 70};
    public static final String[] B = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    public static final int[] C = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    public static final byte[] D = {65, 83, 67, 73, 73, 0, 0, 0};
    public static final d E = new d("StripOffsets", 273, 3);
    public static final d[][] F;
    public static final d[] G = {new d("SubIFDPointer", 330, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("InteroperabilityIFDPointer", 40965, 4), new d("CameraSettingsIFDPointer", 8224, 1), new d("ImageProcessingIFDPointer", 8256, 1)};
    public static final HashMap[] H = new HashMap[10];
    public static final HashMap[] I = new HashMap[10];
    public static final HashSet J = new HashSet(Arrays.asList(new String[]{"FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"}));
    public static final HashMap K = new HashMap();
    public static final Charset L;
    public static final byte[] M;
    public static final byte[] N;

    /* renamed from: l  reason: collision with root package name */
    public static final boolean f16528l = Log.isLoggable("ExifInterface", 3);

    /* renamed from: m  reason: collision with root package name */
    public static final int[] f16529m = {8, 8, 8};

    /* renamed from: n  reason: collision with root package name */
    public static final int[] f16530n = {8};

    /* renamed from: o  reason: collision with root package name */
    public static final byte[] f16531o = {-1, -40, -1};

    /* renamed from: p  reason: collision with root package name */
    public static final byte[] f16532p = {102, 116, 121, 112};

    /* renamed from: q  reason: collision with root package name */
    public static final byte[] f16533q = {109, 105, 102, 49};

    /* renamed from: r  reason: collision with root package name */
    public static final byte[] f16534r = {104, 101, 105, 99};

    /* renamed from: s  reason: collision with root package name */
    public static final byte[] f16535s = {79, 76, 89, 77, 80, 0};

    /* renamed from: t  reason: collision with root package name */
    public static final byte[] f16536t = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* renamed from: u  reason: collision with root package name */
    public static final byte[] f16537u = {-119, 80, 78, 71, 13, 10, 26, 10};

    /* renamed from: v  reason: collision with root package name */
    public static final byte[] f16538v = {101, 88, 73, 102};

    /* renamed from: w  reason: collision with root package name */
    public static final byte[] f16539w = {73, 72, 68, 82};

    /* renamed from: x  reason: collision with root package name */
    public static final byte[] f16540x = {73, 69, 78, 68};

    /* renamed from: y  reason: collision with root package name */
    public static final byte[] f16541y = {82, 73, 70, 70};

    /* renamed from: z  reason: collision with root package name */
    public static final byte[] f16542z = {87, 69, 66, 80};

    /* renamed from: a  reason: collision with root package name */
    public final FileDescriptor f16543a;

    /* renamed from: b  reason: collision with root package name */
    public final AssetManager.AssetInputStream f16544b;

    /* renamed from: c  reason: collision with root package name */
    public int f16545c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap[] f16546d;

    /* renamed from: e  reason: collision with root package name */
    public final HashSet f16547e;

    /* renamed from: f  reason: collision with root package name */
    public ByteOrder f16548f = ByteOrder.BIG_ENDIAN;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16549g;

    /* renamed from: h  reason: collision with root package name */
    public int f16550h;

    /* renamed from: i  reason: collision with root package name */
    public int f16551i;

    /* renamed from: j  reason: collision with root package name */
    public int f16552j;

    /* renamed from: k  reason: collision with root package name */
    public int f16553k;

    static {
        Arrays.asList(new Integer[]{1, 6, 3, 8});
        Arrays.asList(new Integer[]{2, 7, 4, 5});
        "VP8X".getBytes(Charset.defaultCharset());
        "VP8L".getBytes(Charset.defaultCharset());
        "VP8 ".getBytes(Charset.defaultCharset());
        "ANIM".getBytes(Charset.defaultCharset());
        "ANMF".getBytes(Charset.defaultCharset());
        d[] dVarArr = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d(256, 3, 4, "ImageWidth"), new d(257, 3, 4, "ImageLength"), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d(273, 3, 4, "StripOffsets"), new d("Orientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d(278, 3, 4, "RowsPerStrip"), new d(279, 3, 4, "StripByteCounts"), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("SensorTopBorder", 4, 4), new d("SensorLeftBorder", 5, 4), new d("SensorBottomBorder", 6, 4), new d("SensorRightBorder", 7, 4), new d("ISO", 23, 3), new d("JpgFromRaw", 46, 7), new d("Xmp", 700, 1)};
        F = new d[][]{dVarArr, new d[]{new d("ExposureTime", 33434, 5), new d("FNumber", 33437, 5), new d("ExposureProgram", 34850, 3), new d("SpectralSensitivity", 34852, 2), new d("PhotographicSensitivity", 34855, 3), new d("OECF", 34856, 7), new d("SensitivityType", 34864, 3), new d("StandardOutputSensitivity", 34865, 4), new d("RecommendedExposureIndex", 34866, 4), new d("ISOSpeed", 34867, 4), new d("ISOSpeedLatitudeyyy", 34868, 4), new d("ISOSpeedLatitudezzz", 34869, 4), new d("ExifVersion", 36864, 2), new d("DateTimeOriginal", 36867, 2), new d("DateTimeDigitized", 36868, 2), new d("OffsetTime", 36880, 2), new d("OffsetTimeOriginal", 36881, 2), new d("OffsetTimeDigitized", 36882, 2), new d("ComponentsConfiguration", 37121, 7), new d("CompressedBitsPerPixel", 37122, 5), new d("ShutterSpeedValue", 37377, 10), new d("ApertureValue", 37378, 5), new d("BrightnessValue", 37379, 10), new d("ExposureBiasValue", 37380, 10), new d("MaxApertureValue", 37381, 5), new d("SubjectDistance", 37382, 5), new d("MeteringMode", 37383, 3), new d("LightSource", 37384, 3), new d("Flash", 37385, 3), new d("FocalLength", 37386, 5), new d("SubjectArea", 37396, 3), new d("MakerNote", 37500, 7), new d("UserComment", 37510, 7), new d("SubSecTime", 37520, 2), new d("SubSecTimeOriginal", 37521, 2), new d("SubSecTimeDigitized", 37522, 2), new d("FlashpixVersion", 40960, 7), new d("ColorSpace", 40961, 3), new d(40962, 3, 4, "PixelXDimension"), new d(40963, 3, 4, "PixelYDimension"), new d("RelatedSoundFile", 40964, 2), new d("InteroperabilityIFDPointer", 40965, 4), new d("FlashEnergy", 41483, 5), new d("SpatialFrequencyResponse", 41484, 7), new d("FocalPlaneXResolution", 41486, 5), new d("FocalPlaneYResolution", 41487, 5), new d("FocalPlaneResolutionUnit", 41488, 3), new d("SubjectLocation", 41492, 3), new d("ExposureIndex", 41493, 5), new d("SensingMethod", 41495, 3), new d("FileSource", 41728, 7), new d("SceneType", 41729, 7), new d("CFAPattern", 41730, 7), new d("CustomRendered", 41985, 3), new d("ExposureMode", 41986, 3), new d("WhiteBalance", 41987, 3), new d("DigitalZoomRatio", 41988, 5), new d("FocalLengthIn35mmFilm", 41989, 3), new d("SceneCaptureType", 41990, 3), new d("GainControl", 41991, 3), new d("Contrast", 41992, 3), new d("Saturation", 41993, 3), new d("Sharpness", 41994, 3), new d("DeviceSettingDescription", 41995, 7), new d("SubjectDistanceRange", 41996, 3), new d("ImageUniqueID", 42016, 2), new d("CameraOwnerName", 42032, 2), new d("BodySerialNumber", 42033, 2), new d("LensSpecification", 42034, 5), new d("LensMake", 42035, 2), new d("LensModel", 42036, 2), new d("Gamma", 42240, 5), new d("DNGVersion", 50706, 1), new d(50720, 3, 4, "DefaultCropSize")}, new d[]{new d("GPSVersionID", 0, 1), new d("GPSLatitudeRef", 1, 2), new d(2, 5, 10, "GPSLatitude"), new d("GPSLongitudeRef", 3, 2), new d(4, 5, 10, "GPSLongitude"), new d("GPSAltitudeRef", 5, 1), new d("GPSAltitude", 6, 5), new d("GPSTimeStamp", 7, 5), new d("GPSSatellites", 8, 2), new d("GPSStatus", 9, 2), new d("GPSMeasureMode", 10, 2), new d("GPSDOP", 11, 5), new d("GPSSpeedRef", 12, 2), new d("GPSSpeed", 13, 5), new d("GPSTrackRef", 14, 2), new d("GPSTrack", 15, 5), new d("GPSImgDirectionRef", 16, 2), new d("GPSImgDirection", 17, 5), new d("GPSMapDatum", 18, 2), new d("GPSDestLatitudeRef", 19, 2), new d("GPSDestLatitude", 20, 5), new d("GPSDestLongitudeRef", 21, 2), new d("GPSDestLongitude", 22, 5), new d("GPSDestBearingRef", 23, 2), new d("GPSDestBearing", 24, 5), new d("GPSDestDistanceRef", 25, 2), new d("GPSDestDistance", 26, 5), new d("GPSProcessingMethod", 27, 7), new d("GPSAreaInformation", 28, 7), new d("GPSDateStamp", 29, 2), new d("GPSDifferential", 30, 3), new d("GPSHPositioningError", 31, 5)}, new d[]{new d("InteroperabilityIndex", 1, 2)}, new d[]{new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d(256, 3, 4, "ThumbnailImageWidth"), new d(257, 3, 4, "ThumbnailImageLength"), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d(273, 3, 4, "StripOffsets"), new d("ThumbnailOrientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d(278, 3, 4, "RowsPerStrip"), new d(279, 3, 4, "StripByteCounts"), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("DNGVersion", 50706, 1), new d(50720, 3, 4, "DefaultCropSize")}, dVarArr, new d[]{new d("ThumbnailImage", 256, 7), new d("CameraSettingsIFDPointer", 8224, 4), new d("ImageProcessingIFDPointer", 8256, 4)}, new d[]{new d("PreviewImageStart", 257, 4), new d("PreviewImageLength", 258, 4)}, new d[]{new d("AspectFrame", 4371, 3)}, new d[]{new d("ColorSpace", 55, 3)}};
        Charset forName = Charset.forName("US-ASCII");
        L = forName;
        M = "Exif\u0000\u0000".getBytes(forName);
        N = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        int i10 = 0;
        while (true) {
            d[][] dVarArr2 = F;
            if (i10 < dVarArr2.length) {
                H[i10] = new HashMap();
                I[i10] = new HashMap();
                for (d dVar : dVarArr2[i10]) {
                    H[i10].put(Integer.valueOf(dVar.f16522a), dVar);
                    I[i10].put(dVar.f16523b, dVar);
                }
                i10++;
            } else {
                HashMap hashMap = K;
                d[] dVarArr3 = G;
                hashMap.put(Integer.valueOf(dVarArr3[0].f16522a), 5);
                hashMap.put(Integer.valueOf(dVarArr3[1].f16522a), 1);
                hashMap.put(Integer.valueOf(dVarArr3[2].f16522a), 2);
                hashMap.put(Integer.valueOf(dVarArr3[3].f16522a), 3);
                hashMap.put(Integer.valueOf(dVarArr3[4].f16522a), 7);
                hashMap.put(Integer.valueOf(dVarArr3[5].f16522a), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
        }
    }

    public g(InputStream inputStream) {
        boolean z10;
        d[][] dVarArr = F;
        this.f16546d = new HashMap[dVarArr.length];
        this.f16547e = new HashSet(dVarArr.length);
        if (inputStream != null) {
            boolean z11 = true;
            FileDescriptor fileDescriptor = null;
            if (inputStream instanceof AssetManager.AssetInputStream) {
                this.f16544b = (AssetManager.AssetInputStream) inputStream;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    try {
                        h.c(fileInputStream.getFD(), 0, OsConstants.SEEK_CUR);
                        z10 = true;
                    } catch (Exception unused) {
                        z10 = false;
                    }
                    if (z10) {
                        this.f16544b = null;
                        fileDescriptor = fileInputStream.getFD();
                    }
                }
                this.f16544b = null;
            }
            this.f16543a = fileDescriptor;
            boolean z12 = f16528l;
            int i10 = 0;
            while (i10 < dVarArr.length) {
                try {
                    this.f16546d[i10] = new HashMap();
                    i10++;
                } catch (IOException | UnsupportedOperationException e10) {
                    if (z12) {
                        Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e10);
                    }
                    a();
                    if (!z12) {
                        return;
                    }
                } catch (Throwable th) {
                    a();
                    if (z12) {
                        q();
                    }
                    throw th;
                }
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            int g10 = g(bufferedInputStream);
            this.f16545c = g10;
            if ((g10 == 4 || g10 == 9 || g10 == 13 || g10 == 14) ? false : z11) {
                f fVar = new f((InputStream) bufferedInputStream);
                int i11 = this.f16545c;
                if (i11 == 12) {
                    e(fVar);
                } else if (i11 == 7) {
                    h(fVar);
                } else if (i11 == 10) {
                    l(fVar);
                } else {
                    k(fVar);
                }
                fVar.e((long) this.f16550h);
                v(fVar);
            } else {
                b bVar = new b((InputStream) bufferedInputStream);
                int i12 = this.f16545c;
                if (i12 == 4) {
                    f(bVar, 0, 0);
                } else if (i12 == 13) {
                    i(bVar);
                } else if (i12 == 9) {
                    j(bVar);
                } else if (i12 == 14) {
                    m(bVar);
                }
            }
            a();
            if (!z12) {
                return;
            }
            q();
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }

    public static ByteOrder r(b bVar) {
        short readShort = bVar.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
    }

    public final void a() {
        String b10 = b("DateTimeOriginal");
        HashMap[] hashMapArr = this.f16546d;
        if (b10 != null && b("DateTime") == null) {
            hashMapArr[0].put("DateTime", c.a(b10));
        }
        if (b("ImageWidth") == null) {
            hashMapArr[0].put("ImageWidth", c.b(0, this.f16548f));
        }
        if (b("ImageLength") == null) {
            hashMapArr[0].put("ImageLength", c.b(0, this.f16548f));
        }
        if (b("Orientation") == null) {
            hashMapArr[0].put("Orientation", c.b(0, this.f16548f));
        }
        if (b("LightSource") == null) {
            hashMapArr[1].put("LightSource", c.b(0, this.f16548f));
        }
    }

    public final String b(String str) {
        String str2;
        c d10 = d(str);
        if (d10 != null) {
            if (!J.contains(str)) {
                return d10.g(this.f16548f);
            }
            if (str.equals("GPSTimeStamp")) {
                int i10 = d10.f16518a;
                if (i10 == 5 || i10 == 10) {
                    e[] eVarArr = (e[]) d10.h(this.f16548f);
                    if (eVarArr == null || eVarArr.length != 3) {
                        str2 = "Invalid GPS Timestamp array. array=" + Arrays.toString(eVarArr);
                    } else {
                        e eVar = eVarArr[0];
                        e eVar2 = eVarArr[1];
                        e eVar3 = eVarArr[2];
                        return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) eVar.f16526a) / ((float) eVar.f16527b))), Integer.valueOf((int) (((float) eVar2.f16526a) / ((float) eVar2.f16527b))), Integer.valueOf((int) (((float) eVar3.f16526a) / ((float) eVar3.f16527b)))});
                    }
                } else {
                    str2 = h.i("GPS Timestamp format is not rational. format=", i10);
                }
                Log.w("ExifInterface", str2);
                return null;
            }
            try {
                return Double.toString(d10.e(this.f16548f));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final int c() {
        c d10 = d("Orientation");
        if (d10 == null) {
            return 1;
        }
        try {
            return d10.f(this.f16548f);
        } catch (NumberFormatException unused) {
            return 1;
        }
    }

    public final c d(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i10 = 0; i10 < F.length; i10++) {
            c cVar = (c) this.f16546d[i10].get(str);
            if (cVar != null) {
                return cVar;
            }
        }
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:52|53|54) */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x010a, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0113, code lost:
        throw new java.lang.UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0114, code lost:
        r1.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0117, code lost:
        throw r12;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x010c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(x0.f r12) {
        /*
            r11 = this;
            java.lang.String r0 = "yes"
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L_0x0118
            android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever
            r1.<init>()
            x0.a r2 = new x0.a     // Catch:{ RuntimeException -> 0x010c }
            r2.<init>(r12)     // Catch:{ RuntimeException -> 0x010c }
            x0.i.a(r1, r2)     // Catch:{ RuntimeException -> 0x010c }
            r2 = 33
            java.lang.String r2 = r1.extractMetadata(r2)     // Catch:{ RuntimeException -> 0x010c }
            r3 = 34
            java.lang.String r3 = r1.extractMetadata(r3)     // Catch:{ RuntimeException -> 0x010c }
            r4 = 26
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x010c }
            r5 = 17
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x010c }
            boolean r4 = r0.equals(r4)     // Catch:{ RuntimeException -> 0x010c }
            if (r4 == 0) goto L_0x0046
            r0 = 29
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x010c }
            r4 = 30
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x010c }
            r5 = 31
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x010c }
            goto L_0x0062
        L_0x0046:
            boolean r0 = r0.equals(r5)     // Catch:{ RuntimeException -> 0x010c }
            if (r0 == 0) goto L_0x005f
            r0 = 18
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x010c }
            r4 = 19
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x010c }
            r5 = 24
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x010c }
            goto L_0x0062
        L_0x005f:
            r0 = 0
            r4 = r0
            r5 = r4
        L_0x0062:
            java.util.HashMap[] r6 = r11.f16546d
            r7 = 0
            if (r0 == 0) goto L_0x0078
            r8 = r6[r7]     // Catch:{ RuntimeException -> 0x010c }
            java.lang.String r9 = "ImageWidth"
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ RuntimeException -> 0x010c }
            java.nio.ByteOrder r10 = r11.f16548f     // Catch:{ RuntimeException -> 0x010c }
            x0.c r0 = x0.c.d(r0, r10)     // Catch:{ RuntimeException -> 0x010c }
            r8.put(r9, r0)     // Catch:{ RuntimeException -> 0x010c }
        L_0x0078:
            if (r4 == 0) goto L_0x008b
            r0 = r6[r7]     // Catch:{ RuntimeException -> 0x010c }
            java.lang.String r8 = "ImageLength"
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ RuntimeException -> 0x010c }
            java.nio.ByteOrder r9 = r11.f16548f     // Catch:{ RuntimeException -> 0x010c }
            x0.c r4 = x0.c.d(r4, r9)     // Catch:{ RuntimeException -> 0x010c }
            r0.put(r8, r4)     // Catch:{ RuntimeException -> 0x010c }
        L_0x008b:
            r0 = 6
            if (r5 == 0) goto L_0x00b3
            int r4 = java.lang.Integer.parseInt(r5)     // Catch:{ RuntimeException -> 0x010c }
            r5 = 90
            if (r4 == r5) goto L_0x00a5
            r5 = 180(0xb4, float:2.52E-43)
            if (r4 == r5) goto L_0x00a3
            r5 = 270(0x10e, float:3.78E-43)
            if (r4 == r5) goto L_0x00a0
            r4 = 1
            goto L_0x00a6
        L_0x00a0:
            r4 = 8
            goto L_0x00a6
        L_0x00a3:
            r4 = 3
            goto L_0x00a6
        L_0x00a5:
            r4 = 6
        L_0x00a6:
            r5 = r6[r7]     // Catch:{ RuntimeException -> 0x010c }
            java.lang.String r6 = "Orientation"
            java.nio.ByteOrder r8 = r11.f16548f     // Catch:{ RuntimeException -> 0x010c }
            x0.c r4 = x0.c.d(r4, r8)     // Catch:{ RuntimeException -> 0x010c }
            r5.put(r6, r4)     // Catch:{ RuntimeException -> 0x010c }
        L_0x00b3:
            if (r2 == 0) goto L_0x0106
            if (r3 == 0) goto L_0x0106
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ RuntimeException -> 0x010c }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ RuntimeException -> 0x010c }
            if (r3 <= r0) goto L_0x00fe
            long r4 = (long) r2     // Catch:{ RuntimeException -> 0x010c }
            r12.e(r4)     // Catch:{ RuntimeException -> 0x010c }
            byte[] r4 = new byte[r0]     // Catch:{ RuntimeException -> 0x010c }
            int r5 = r12.read(r4)     // Catch:{ RuntimeException -> 0x010c }
            if (r5 != r0) goto L_0x00f6
            int r2 = r2 + r0
            int r3 = r3 + -6
            byte[] r0 = M     // Catch:{ RuntimeException -> 0x010c }
            boolean r0 = java.util.Arrays.equals(r4, r0)     // Catch:{ RuntimeException -> 0x010c }
            if (r0 == 0) goto L_0x00ee
            byte[] r0 = new byte[r3]     // Catch:{ RuntimeException -> 0x010c }
            int r12 = r12.read(r0)     // Catch:{ RuntimeException -> 0x010c }
            if (r12 != r3) goto L_0x00e6
            r11.f16550h = r2     // Catch:{ RuntimeException -> 0x010c }
            r11.s(r7, r0)     // Catch:{ RuntimeException -> 0x010c }
            goto L_0x0106
        L_0x00e6:
            java.io.IOException r12 = new java.io.IOException     // Catch:{ RuntimeException -> 0x010c }
            java.lang.String r0 = "Can't read exif"
            r12.<init>(r0)     // Catch:{ RuntimeException -> 0x010c }
            throw r12     // Catch:{ RuntimeException -> 0x010c }
        L_0x00ee:
            java.io.IOException r12 = new java.io.IOException     // Catch:{ RuntimeException -> 0x010c }
            java.lang.String r0 = "Invalid identifier"
            r12.<init>(r0)     // Catch:{ RuntimeException -> 0x010c }
            throw r12     // Catch:{ RuntimeException -> 0x010c }
        L_0x00f6:
            java.io.IOException r12 = new java.io.IOException     // Catch:{ RuntimeException -> 0x010c }
            java.lang.String r0 = "Can't read identifier"
            r12.<init>(r0)     // Catch:{ RuntimeException -> 0x010c }
            throw r12     // Catch:{ RuntimeException -> 0x010c }
        L_0x00fe:
            java.io.IOException r12 = new java.io.IOException     // Catch:{ RuntimeException -> 0x010c }
            java.lang.String r0 = "Invalid exif length"
            r12.<init>(r0)     // Catch:{ RuntimeException -> 0x010c }
            throw r12     // Catch:{ RuntimeException -> 0x010c }
        L_0x0106:
            r1.release()
            return
        L_0x010a:
            r12 = move-exception
            goto L_0x0114
        L_0x010c:
            java.lang.UnsupportedOperationException r12 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x010a }
            java.lang.String r0 = "Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported."
            r12.<init>(r0)     // Catch:{ all -> 0x010a }
            throw r12     // Catch:{ all -> 0x010a }
        L_0x0114:
            r1.release()
            throw r12
        L_0x0118:
            java.lang.UnsupportedOperationException r12 = new java.lang.UnsupportedOperationException
            java.lang.String r0 = "Reading EXIF from HEIF files is supported from SDK 28 and above"
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.g.e(x0.f):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0148 A[LOOP:0: B:8:0x0024->B:78:0x0148, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0150 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(x0.b r23, int r24, int r25) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r25
            boolean r3 = f16528l
            if (r3 == 0) goto L_0x000d
            java.util.Objects.toString(r23)
        L_0x000d:
            java.nio.ByteOrder r4 = java.nio.ByteOrder.BIG_ENDIAN
            r1.f16515i = r4
            byte r4 = r23.readByte()
            java.lang.String r5 = "Invalid marker: "
            r6 = -1
            if (r4 != r6) goto L_0x0193
            byte r7 = r23.readByte()
            r8 = -40
            if (r7 != r8) goto L_0x017b
            r4 = 2
            r5 = 2
        L_0x0024:
            byte r7 = r23.readByte()
            if (r7 != r6) goto L_0x0161
            r7 = 1
            int r5 = r5 + r7
            byte r8 = r23.readByte()
            if (r3 == 0) goto L_0x0037
            r9 = r8 & 255(0xff, float:3.57E-43)
            java.lang.Integer.toHexString(r9)
        L_0x0037:
            int r5 = r5 + r7
            r9 = -39
            if (r8 == r9) goto L_0x015c
            r9 = -38
            if (r8 != r9) goto L_0x0042
            goto L_0x015c
        L_0x0042:
            int r9 = r23.readUnsignedShort()
            int r9 = r9 - r4
            int r5 = r5 + r4
            if (r3 == 0) goto L_0x004f
            r10 = r8 & 255(0xff, float:3.57E-43)
            java.lang.Integer.toHexString(r10)
        L_0x004f:
            java.lang.String r10 = "Invalid length"
            if (r9 < 0) goto L_0x0156
            r11 = 0
            r12 = -31
            java.util.HashMap[] r13 = r0.f16546d
            if (r8 == r12) goto L_0x00cb
            r12 = -2
            if (r8 == r12) goto L_0x00a1
            switch(r8) {
                case -64: goto L_0x006b;
                case -63: goto L_0x006b;
                case -62: goto L_0x006b;
                case -61: goto L_0x006b;
                default: goto L_0x0060;
            }
        L_0x0060:
            switch(r8) {
                case -59: goto L_0x006b;
                case -58: goto L_0x006b;
                case -57: goto L_0x006b;
                default: goto L_0x0063;
            }
        L_0x0063:
            switch(r8) {
                case -55: goto L_0x006b;
                case -54: goto L_0x006b;
                case -53: goto L_0x006b;
                default: goto L_0x0066;
            }
        L_0x0066:
            switch(r8) {
                case -51: goto L_0x006b;
                case -50: goto L_0x006b;
                case -49: goto L_0x006b;
                default: goto L_0x0069;
            }
        L_0x0069:
            goto L_0x0146
        L_0x006b:
            r1.c(r7)
            r7 = r13[r2]
            r8 = 4
            if (r2 == r8) goto L_0x0076
            java.lang.String r11 = "ImageLength"
            goto L_0x0078
        L_0x0076:
            java.lang.String r11 = "ThumbnailImageLength"
        L_0x0078:
            int r12 = r23.readUnsignedShort()
            long r14 = (long) r12
            java.nio.ByteOrder r12 = r0.f16548f
            x0.c r12 = x0.c.b(r14, r12)
            r7.put(r11, r12)
            r7 = r13[r2]
            if (r2 == r8) goto L_0x008d
            java.lang.String r8 = "ImageWidth"
            goto L_0x008f
        L_0x008d:
            java.lang.String r8 = "ThumbnailImageWidth"
        L_0x008f:
            int r11 = r23.readUnsignedShort()
            long r11 = (long) r11
            java.nio.ByteOrder r13 = r0.f16548f
            x0.c r11 = x0.c.b(r11, r13)
            r7.put(r8, r11)
            int r9 = r9 + -5
            goto L_0x0146
        L_0x00a1:
            byte[] r8 = new byte[r9]
            int r12 = r1.read(r8)
            if (r12 != r9) goto L_0x00c3
            java.lang.String r9 = "UserComment"
            java.lang.String r12 = r0.b(r9)
            if (r12 != 0) goto L_0x0145
            r7 = r13[r7]
            java.lang.String r12 = new java.lang.String
            java.nio.charset.Charset r13 = L
            r12.<init>(r8, r13)
            x0.c r8 = x0.c.a(r12)
            r7.put(r9, r8)
            goto L_0x0145
        L_0x00c3:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid exif"
            r1.<init>(r2)
            throw r1
        L_0x00cb:
            byte[] r8 = new byte[r9]
            r1.readFully(r8)
            int r12 = r5 + r9
            byte[] r14 = M
            if (r14 != 0) goto L_0x00d8
        L_0x00d6:
            r4 = 0
            goto L_0x00ec
        L_0x00d8:
            int r15 = r14.length
            if (r9 >= r15) goto L_0x00dc
            goto L_0x00d6
        L_0x00dc:
            r15 = 0
        L_0x00dd:
            int r4 = r14.length
            if (r15 >= r4) goto L_0x00eb
            byte r4 = r8[r15]
            byte r6 = r14[r15]
            if (r4 == r6) goto L_0x00e7
            goto L_0x00d6
        L_0x00e7:
            int r15 = r15 + 1
            r6 = -1
            goto L_0x00dd
        L_0x00eb:
            r4 = 1
        L_0x00ec:
            if (r4 == 0) goto L_0x0105
            int r4 = r14.length
            byte[] r4 = java.util.Arrays.copyOfRange(r8, r4, r9)
            int r5 = r24 + r5
            int r6 = r14.length
            int r5 = r5 + r6
            r0.f16550h = r5
            r0.s(r2, r4)
            x0.b r5 = new x0.b
            r5.<init>((byte[]) r4)
            r0.v(r5)
            goto L_0x0144
        L_0x0105:
            byte[] r4 = N
            if (r4 != 0) goto L_0x010b
        L_0x0109:
            r7 = 0
            goto L_0x011d
        L_0x010b:
            int r6 = r4.length
            if (r9 >= r6) goto L_0x010f
            goto L_0x0109
        L_0x010f:
            r6 = 0
        L_0x0110:
            int r14 = r4.length
            if (r6 >= r14) goto L_0x011d
            byte r14 = r8[r6]
            byte r15 = r4[r6]
            if (r14 == r15) goto L_0x011a
            goto L_0x0109
        L_0x011a:
            int r6 = r6 + 1
            goto L_0x0110
        L_0x011d:
            if (r7 == 0) goto L_0x0144
            int r6 = r4.length
            int r5 = r5 + r6
            int r4 = r4.length
            byte[] r4 = java.util.Arrays.copyOfRange(r8, r4, r9)
            java.lang.String r6 = "Xmp"
            java.lang.String r7 = r0.b(r6)
            if (r7 != 0) goto L_0x0144
            r7 = r13[r11]
            x0.c r8 = new x0.c
            r20 = 1
            int r9 = r4.length
            long r13 = (long) r5
            r16 = r8
            r17 = r13
            r19 = r4
            r21 = r9
            r16.<init>(r17, r19, r20, r21)
            r7.put(r6, r8)
        L_0x0144:
            r5 = r12
        L_0x0145:
            r9 = 0
        L_0x0146:
            if (r9 < 0) goto L_0x0150
            r1.c(r9)
            int r5 = r5 + r9
            r4 = 2
            r6 = -1
            goto L_0x0024
        L_0x0150:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r10)
            throw r1
        L_0x0156:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r10)
            throw r1
        L_0x015c:
            java.nio.ByteOrder r2 = r0.f16548f
            r1.f16515i = r2
            return
        L_0x0161:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid marker:"
            r2.<init>(r3)
            r3 = r7 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x017b:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r5)
            r3 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0193:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r5)
            r3 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.g.f(x0.b, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c7, code lost:
        if (r6 != null) goto L_0x00c9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0115 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0117 A[SYNTHETIC, Splitter:B:106:0x0117] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0149 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int g(java.io.BufferedInputStream r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = 5000(0x1388, float:7.006E-42)
            r0.mark(r2)
            byte[] r3 = new byte[r2]
            r0.read(r3)
            r18.reset()
            r4 = 0
        L_0x0012:
            byte[] r5 = f16531o
            int r6 = r5.length
            r7 = 1
            if (r4 >= r6) goto L_0x0023
            byte r6 = r3[r4]
            byte r5 = r5[r4]
            if (r6 == r5) goto L_0x0020
            r4 = 0
            goto L_0x0024
        L_0x0020:
            int r4 = r4 + 1
            goto L_0x0012
        L_0x0023:
            r4 = 1
        L_0x0024:
            r5 = 4
            if (r4 == 0) goto L_0x0028
            return r5
        L_0x0028:
            java.lang.String r4 = "FUJIFILMCCD-RAW"
            java.nio.charset.Charset r6 = java.nio.charset.Charset.defaultCharset()
            byte[] r4 = r4.getBytes(r6)
            r6 = 0
        L_0x0033:
            int r8 = r4.length
            if (r6 >= r8) goto L_0x0041
            byte r8 = r3[r6]
            byte r9 = r4[r6]
            if (r8 == r9) goto L_0x003e
            r4 = 0
            goto L_0x0042
        L_0x003e:
            int r6 = r6 + 1
            goto L_0x0033
        L_0x0041:
            r4 = 1
        L_0x0042:
            if (r4 == 0) goto L_0x0047
            r0 = 9
            return r0
        L_0x0047:
            r4 = 0
            x0.b r6 = new x0.b     // Catch:{ Exception -> 0x00c5, all -> 0x00be }
            r6.<init>((byte[]) r3)     // Catch:{ Exception -> 0x00c5, all -> 0x00be }
            int r8 = r6.readInt()     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            long r8 = (long) r8     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            byte[] r10 = new byte[r5]     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            r6.read(r10)     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            byte[] r11 = f16532p     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            boolean r10 = java.util.Arrays.equals(r10, r11)     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            if (r10 != 0) goto L_0x0061
            goto L_0x00c9
        L_0x0061:
            r10 = 8
            r12 = 1
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 != 0) goto L_0x0074
            long r8 = r6.readLong()     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            r14 = 16
            int r16 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r16 >= 0) goto L_0x0075
            goto L_0x00c9
        L_0x0074:
            r14 = r10
        L_0x0075:
            long r0 = (long) r2     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x007b
            r8 = r0
        L_0x007b:
            long r8 = r8 - r14
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 >= 0) goto L_0x0081
            goto L_0x00c9
        L_0x0081:
            byte[] r0 = new byte[r5]     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            r1 = 0
            r10 = 0
            r11 = 0
        L_0x0087:
            r14 = 4
            long r14 = r8 / r14
            int r16 = (r1 > r14 ? 1 : (r1 == r14 ? 0 : -1))
            if (r16 >= 0) goto L_0x00c9
            int r14 = r6.read(r0)     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            if (r14 == r5) goto L_0x0096
            goto L_0x00c9
        L_0x0096:
            int r14 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r14 != 0) goto L_0x009b
            goto L_0x00b7
        L_0x009b:
            byte[] r14 = f16533q     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            boolean r14 = java.util.Arrays.equals(r0, r14)     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            if (r14 == 0) goto L_0x00a5
            r10 = 1
            goto L_0x00ae
        L_0x00a5:
            byte[] r14 = f16534r     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            boolean r14 = java.util.Arrays.equals(r0, r14)     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            if (r14 == 0) goto L_0x00ae
            r11 = 1
        L_0x00ae:
            if (r10 == 0) goto L_0x00b7
            if (r11 == 0) goto L_0x00b7
            r6.close()
            r0 = 1
            goto L_0x00cd
        L_0x00b7:
            long r1 = r1 + r12
            goto L_0x0087
        L_0x00b9:
            r0 = move-exception
            r4 = r6
            goto L_0x00bf
        L_0x00bc:
            goto L_0x00c7
        L_0x00be:
            r0 = move-exception
        L_0x00bf:
            if (r4 == 0) goto L_0x00c4
            r4.close()
        L_0x00c4:
            throw r0
        L_0x00c5:
            r6 = r4
        L_0x00c7:
            if (r6 == 0) goto L_0x00cc
        L_0x00c9:
            r6.close()
        L_0x00cc:
            r0 = 0
        L_0x00cd:
            if (r0 == 0) goto L_0x00d2
            r0 = 12
            return r0
        L_0x00d2:
            x0.b r1 = new x0.b     // Catch:{ Exception -> 0x0109, all -> 0x0100 }
            r1.<init>((byte[]) r3)     // Catch:{ Exception -> 0x0109, all -> 0x0100 }
            java.nio.ByteOrder r0 = r(r1)     // Catch:{ Exception -> 0x00fc, all -> 0x00f7 }
            r2 = r17
            r2.f16548f = r0     // Catch:{ Exception -> 0x00fe, all -> 0x00f5 }
            r1.f16515i = r0     // Catch:{ Exception -> 0x00fe, all -> 0x00f5 }
            short r0 = r1.readShort()     // Catch:{ Exception -> 0x00fe, all -> 0x00f5 }
            r6 = 20306(0x4f52, float:2.8455E-41)
            if (r0 == r6) goto L_0x00f0
            r6 = 21330(0x5352, float:2.989E-41)
            if (r0 != r6) goto L_0x00ee
            goto L_0x00f0
        L_0x00ee:
            r0 = 0
            goto L_0x00f1
        L_0x00f0:
            r0 = 1
        L_0x00f1:
            r1.close()
            goto L_0x0113
        L_0x00f5:
            r0 = move-exception
            goto L_0x00fa
        L_0x00f7:
            r0 = move-exception
            r2 = r17
        L_0x00fa:
            r4 = r1
            goto L_0x0103
        L_0x00fc:
            r2 = r17
        L_0x00fe:
            goto L_0x010d
        L_0x0100:
            r0 = move-exception
            r2 = r17
        L_0x0103:
            if (r4 == 0) goto L_0x0108
            r4.close()
        L_0x0108:
            throw r0
        L_0x0109:
            r2 = r17
            r1 = r4
        L_0x010d:
            if (r1 == 0) goto L_0x0112
            r1.close()
        L_0x0112:
            r0 = 0
        L_0x0113:
            if (r0 == 0) goto L_0x0117
            r0 = 7
            return r0
        L_0x0117:
            x0.b r1 = new x0.b     // Catch:{ Exception -> 0x0140, all -> 0x0139 }
            r1.<init>((byte[]) r3)     // Catch:{ Exception -> 0x0140, all -> 0x0139 }
            java.nio.ByteOrder r0 = r(r1)     // Catch:{ Exception -> 0x0136, all -> 0x0133 }
            r2.f16548f = r0     // Catch:{ Exception -> 0x0136, all -> 0x0133 }
            r1.f16515i = r0     // Catch:{ Exception -> 0x0136, all -> 0x0133 }
            short r0 = r1.readShort()     // Catch:{ Exception -> 0x0136, all -> 0x0133 }
            r4 = 85
            if (r0 != r4) goto L_0x012e
            r0 = 1
            goto L_0x012f
        L_0x012e:
            r0 = 0
        L_0x012f:
            r1.close()
            goto L_0x0147
        L_0x0133:
            r0 = move-exception
            r4 = r1
            goto L_0x013a
        L_0x0136:
            r4 = r1
            goto L_0x0141
        L_0x0139:
            r0 = move-exception
        L_0x013a:
            if (r4 == 0) goto L_0x013f
            r4.close()
        L_0x013f:
            throw r0
        L_0x0140:
        L_0x0141:
            if (r4 == 0) goto L_0x0146
            r4.close()
        L_0x0146:
            r0 = 0
        L_0x0147:
            if (r0 == 0) goto L_0x014c
            r0 = 10
            return r0
        L_0x014c:
            r0 = 0
        L_0x014d:
            byte[] r1 = f16537u
            int r4 = r1.length
            if (r0 >= r4) goto L_0x015d
            byte r4 = r3[r0]
            byte r1 = r1[r0]
            if (r4 == r1) goto L_0x015a
            r0 = 0
            goto L_0x015e
        L_0x015a:
            int r0 = r0 + 1
            goto L_0x014d
        L_0x015d:
            r0 = 1
        L_0x015e:
            if (r0 == 0) goto L_0x0163
            r0 = 13
            return r0
        L_0x0163:
            r0 = 0
        L_0x0164:
            byte[] r1 = f16541y
            int r4 = r1.length
            if (r0 >= r4) goto L_0x0173
            byte r4 = r3[r0]
            byte r1 = r1[r0]
            if (r4 == r1) goto L_0x0170
            goto L_0x0182
        L_0x0170:
            int r0 = r0 + 1
            goto L_0x0164
        L_0x0173:
            r0 = 0
        L_0x0174:
            byte[] r4 = f16542z
            int r6 = r4.length
            if (r0 >= r6) goto L_0x0187
            int r6 = r1.length
            int r6 = r6 + r0
            int r6 = r6 + r5
            byte r6 = r3[r6]
            byte r4 = r4[r0]
            if (r6 == r4) goto L_0x0184
        L_0x0182:
            r7 = 0
            goto L_0x0187
        L_0x0184:
            int r0 = r0 + 1
            goto L_0x0174
        L_0x0187:
            if (r7 == 0) goto L_0x018c
            r0 = 14
            return r0
        L_0x018c:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.g.g(java.io.BufferedInputStream):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(x0.f r7) {
        /*
            r6 = this;
            r6.k(r7)
            java.util.HashMap[] r7 = r6.f16546d
            r0 = 1
            r1 = r7[r0]
            java.lang.String r2 = "MakerNote"
            java.lang.Object r1 = r1.get(r2)
            x0.c r1 = (x0.c) r1
            if (r1 == 0) goto L_0x00da
            x0.f r2 = new x0.f
            byte[] r1 = r1.f16521d
            r2.<init>((byte[]) r1)
            java.nio.ByteOrder r1 = r6.f16548f
            r2.f16515i = r1
            byte[] r1 = f16535s
            int r3 = r1.length
            byte[] r3 = new byte[r3]
            r2.readFully(r3)
            r4 = 0
            r2.e(r4)
            byte[] r4 = f16536t
            int r5 = r4.length
            byte[] r5 = new byte[r5]
            r2.readFully(r5)
            boolean r1 = java.util.Arrays.equals(r3, r1)
            if (r1 == 0) goto L_0x003b
            r3 = 8
            goto L_0x0043
        L_0x003b:
            boolean r1 = java.util.Arrays.equals(r5, r4)
            if (r1 == 0) goto L_0x0046
            r3 = 12
        L_0x0043:
            r2.e(r3)
        L_0x0046:
            r1 = 6
            r6.t(r2, r1)
            r1 = 7
            r2 = r7[r1]
            java.lang.String r3 = "PreviewImageStart"
            java.lang.Object r2 = r2.get(r3)
            x0.c r2 = (x0.c) r2
            r1 = r7[r1]
            java.lang.String r3 = "PreviewImageLength"
            java.lang.Object r1 = r1.get(r3)
            x0.c r1 = (x0.c) r1
            if (r2 == 0) goto L_0x0072
            if (r1 == 0) goto L_0x0072
            r3 = 5
            r4 = r7[r3]
            java.lang.String r5 = "JPEGInterchangeFormat"
            r4.put(r5, r2)
            r2 = r7[r3]
            java.lang.String r3 = "JPEGInterchangeFormatLength"
            r2.put(r3, r1)
        L_0x0072:
            r1 = 8
            r1 = r7[r1]
            java.lang.String r2 = "AspectFrame"
            java.lang.Object r1 = r1.get(r2)
            x0.c r1 = (x0.c) r1
            if (r1 == 0) goto L_0x00da
            java.nio.ByteOrder r2 = r6.f16548f
            java.io.Serializable r1 = r1.h(r2)
            int[] r1 = (int[]) r1
            if (r1 == 0) goto L_0x00c3
            int r2 = r1.length
            r3 = 4
            if (r2 == r3) goto L_0x008f
            goto L_0x00c3
        L_0x008f:
            r2 = 2
            r2 = r1[r2]
            r3 = 0
            r4 = r1[r3]
            if (r2 <= r4) goto L_0x00da
            r5 = 3
            r5 = r1[r5]
            r1 = r1[r0]
            if (r5 <= r1) goto L_0x00da
            int r2 = r2 - r4
            int r2 = r2 + r0
            int r5 = r5 - r1
            int r5 = r5 + r0
            if (r2 >= r5) goto L_0x00a8
            int r2 = r2 + r5
            int r5 = r2 - r5
            int r2 = r2 - r5
        L_0x00a8:
            java.nio.ByteOrder r0 = r6.f16548f
            x0.c r0 = x0.c.d(r2, r0)
            java.nio.ByteOrder r1 = r6.f16548f
            x0.c r1 = x0.c.d(r5, r1)
            r2 = r7[r3]
            java.lang.String r4 = "ImageWidth"
            r2.put(r4, r0)
            r7 = r7[r3]
            java.lang.String r0 = "ImageLength"
            r7.put(r0, r1)
            goto L_0x00da
        L_0x00c3:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Invalid aspect frame values. frame="
            r7.<init>(r0)
            java.lang.String r0 = java.util.Arrays.toString(r1)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.lang.String r0 = "ExifInterface"
            android.util.Log.w(r0, r7)
        L_0x00da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.g.h(x0.f):void");
    }

    public final void i(b bVar) {
        if (f16528l) {
            Objects.toString(bVar);
        }
        bVar.f16515i = ByteOrder.BIG_ENDIAN;
        byte[] bArr = f16537u;
        bVar.c(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int readInt = bVar.readInt();
                int i10 = length + 4;
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int i11 = i10 + 4;
                    if (i11 == 16) {
                        if (!Arrays.equals(bArr2, f16539w)) {
                            throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                        }
                    }
                    if (!Arrays.equals(bArr2, f16540x)) {
                        if (Arrays.equals(bArr2, f16538v)) {
                            byte[] bArr3 = new byte[readInt];
                            if (bVar.read(bArr3) == readInt) {
                                int readInt2 = bVar.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr2);
                                crc32.update(bArr3);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.f16550h = i11;
                                    s(0, bArr3);
                                    y();
                                    v(new b(bArr3));
                                    return;
                                }
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + j.a(bArr2));
                        }
                        int i12 = readInt + 4;
                        bVar.c(i12);
                        length = i11 + i12;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void j(b bVar) {
        if (f16528l) {
            Objects.toString(bVar);
        }
        bVar.c(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i10 = ByteBuffer.wrap(bArr).getInt();
        int i11 = ByteBuffer.wrap(bArr2).getInt();
        int i12 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i11];
        bVar.c(i10 - bVar.f16516j);
        bVar.read(bArr4);
        f(new b(bArr4), i10, 5);
        bVar.c(i12 - bVar.f16516j);
        bVar.f16515i = ByteOrder.BIG_ENDIAN;
        int readInt = bVar.readInt();
        for (int i13 = 0; i13 < readInt; i13++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == E.f16522a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                c d10 = c.d(readShort, this.f16548f);
                c d11 = c.d(readShort2, this.f16548f);
                HashMap[] hashMapArr = this.f16546d;
                hashMapArr[0].put("ImageLength", d10);
                hashMapArr[0].put("ImageWidth", d11);
                return;
            }
            bVar.c(readUnsignedShort2);
        }
    }

    public final void k(f fVar) {
        p(fVar);
        t(fVar, 0);
        x(fVar, 0);
        x(fVar, 5);
        x(fVar, 4);
        y();
        if (this.f16545c == 8) {
            HashMap[] hashMapArr = this.f16546d;
            c cVar = (c) hashMapArr[1].get("MakerNote");
            if (cVar != null) {
                f fVar2 = new f(cVar.f16521d);
                fVar2.f16515i = this.f16548f;
                fVar2.c(6);
                t(fVar2, 9);
                c cVar2 = (c) hashMapArr[9].get("ColorSpace");
                if (cVar2 != null) {
                    hashMapArr[1].put("ColorSpace", cVar2);
                }
            }
        }
    }

    public final void l(f fVar) {
        if (f16528l) {
            Objects.toString(fVar);
        }
        k(fVar);
        HashMap[] hashMapArr = this.f16546d;
        c cVar = (c) hashMapArr[0].get("JpgFromRaw");
        if (cVar != null) {
            f(new b(cVar.f16521d), (int) cVar.f16520c, 5);
        }
        c cVar2 = (c) hashMapArr[0].get("ISO");
        c cVar3 = (c) hashMapArr[1].get("PhotographicSensitivity");
        if (cVar2 != null && cVar3 == null) {
            hashMapArr[1].put("PhotographicSensitivity", cVar2);
        }
    }

    public final void m(b bVar) {
        if (f16528l) {
            Objects.toString(bVar);
        }
        bVar.f16515i = ByteOrder.LITTLE_ENDIAN;
        bVar.c(f16541y.length);
        int readInt = bVar.readInt() + 8;
        byte[] bArr = f16542z;
        bVar.c(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int readInt2 = bVar.readInt();
                    int i10 = length + 4 + 4;
                    if (Arrays.equals(A, bArr2)) {
                        byte[] bArr3 = new byte[readInt2];
                        if (bVar.read(bArr3) == readInt2) {
                            this.f16550h = i10;
                            s(0, bArr3);
                            v(new b(bArr3));
                            return;
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + j.a(bArr2));
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    length = i10 + readInt2;
                    if (length != readInt) {
                        if (length <= readInt) {
                            bVar.c(readInt2);
                        } else {
                            throw new IOException("Encountered WebP file with invalid chunk size");
                        }
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void n(b bVar, HashMap hashMap) {
        c cVar = (c) hashMap.get("JPEGInterchangeFormat");
        c cVar2 = (c) hashMap.get("JPEGInterchangeFormatLength");
        if (cVar != null && cVar2 != null) {
            int f10 = cVar.f(this.f16548f);
            int f11 = cVar2.f(this.f16548f);
            if (this.f16545c == 7) {
                f10 += this.f16551i;
            }
            if (f10 > 0 && f11 > 0 && this.f16544b == null && this.f16543a == null) {
                bVar.skip((long) f10);
                bVar.read(new byte[f11]);
            }
        }
    }

    public final boolean o(HashMap hashMap) {
        c cVar = (c) hashMap.get("ImageLength");
        c cVar2 = (c) hashMap.get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            return false;
        }
        return cVar.f(this.f16548f) <= 512 && cVar2.f(this.f16548f) <= 512;
    }

    public final void p(b bVar) {
        ByteOrder r10 = r(bVar);
        this.f16548f = r10;
        bVar.f16515i = r10;
        int readUnsignedShort = bVar.readUnsignedShort();
        int i10 = this.f16545c;
        if (i10 == 7 || i10 == 10 || readUnsignedShort == 42) {
            int readInt = bVar.readInt();
            if (readInt >= 8) {
                int i11 = readInt - 8;
                if (i11 > 0) {
                    bVar.c(i11);
                    return;
                }
                return;
            }
            throw new IOException(h.i("Invalid first Ifd offset: ", readInt));
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    public final void q() {
        int i10 = 0;
        while (true) {
            HashMap[] hashMapArr = this.f16546d;
            if (i10 < hashMapArr.length) {
                hashMapArr[i10].size();
                for (Map.Entry entry : hashMapArr[i10].entrySet()) {
                    c cVar = (c) entry.getValue();
                    String str = (String) entry.getKey();
                    cVar.toString();
                    cVar.g(this.f16548f);
                }
                i10++;
            } else {
                return;
            }
        }
    }

    public final void s(int i10, byte[] bArr) {
        f fVar = new f(bArr);
        p(fVar);
        t(fVar, i10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x019a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t(x0.f r31, int r32) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            r2 = r32
            int r3 = r1.f16516j
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.util.HashSet r4 = r0.f16547e
            r4.add(r3)
            short r3 = r31.readShort()
            if (r3 > 0) goto L_0x0018
            return
        L_0x0018:
            r6 = 0
        L_0x0019:
            boolean r11 = f16528l
            r12 = 5
            java.util.HashMap[] r13 = r0.f16546d
            if (r6 >= r3) goto L_0x0244
            int r14 = r31.readUnsignedShort()
            int r15 = r31.readUnsignedShort()
            int r7 = r31.readInt()
            int r8 = r1.f16516j
            long r9 = (long) r8
            r20 = 4
            long r9 = r9 + r20
            java.util.HashMap[] r8 = H
            r8 = r8[r2]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r14)
            java.lang.Object r5 = r8.get(r5)
            x0.d r5 = (x0.d) r5
            if (r11 == 0) goto L_0x0074
            java.lang.Object[] r12 = new java.lang.Object[r12]
            java.lang.Integer r24 = java.lang.Integer.valueOf(r32)
            r22 = 0
            r12[r22] = r24
            java.lang.Integer r24 = java.lang.Integer.valueOf(r14)
            r19 = 1
            r12[r19] = r24
            if (r5 == 0) goto L_0x005a
            java.lang.String r8 = r5.f16523b
            goto L_0x005b
        L_0x005a:
            r8 = 0
        L_0x005b:
            r23 = 2
            r12[r23] = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r15)
            r24 = 3
            r12[r24] = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            r18 = 4
            r12[r18] = r8
            java.lang.String r8 = "ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d"
            java.lang.String.format(r8, r12)
        L_0x0074:
            if (r5 != 0) goto L_0x007f
        L_0x0076:
            r25 = r3
            r26 = r6
            r27 = r11
            r6 = r4
            goto L_0x00e7
        L_0x007f:
            if (r15 <= 0) goto L_0x0076
            int[] r8 = C
            int r12 = r8.length
            if (r15 < r12) goto L_0x0087
            goto L_0x0076
        L_0x0087:
            int r12 = r5.f16524c
            r25 = r3
            r3 = 7
            if (r12 == r3) goto L_0x00bb
            if (r15 != r3) goto L_0x0091
            goto L_0x00bb
        L_0x0091:
            if (r12 == r15) goto L_0x00bb
            int r3 = r5.f16525d
            if (r3 != r15) goto L_0x0098
            goto L_0x00bb
        L_0x0098:
            r26 = r6
            r6 = 4
            if (r12 == r6) goto L_0x009f
            if (r3 != r6) goto L_0x00a3
        L_0x009f:
            r6 = 3
            if (r15 != r6) goto L_0x00a3
            goto L_0x00bd
        L_0x00a3:
            r6 = 9
            if (r12 == r6) goto L_0x00a9
            if (r3 != r6) goto L_0x00ae
        L_0x00a9:
            r6 = 8
            if (r15 != r6) goto L_0x00ae
            goto L_0x00bd
        L_0x00ae:
            r6 = 12
            if (r12 == r6) goto L_0x00b4
            if (r3 != r6) goto L_0x00b9
        L_0x00b4:
            r3 = 11
            if (r15 != r3) goto L_0x00b9
            goto L_0x00bd
        L_0x00b9:
            r3 = 0
            goto L_0x00be
        L_0x00bb:
            r26 = r6
        L_0x00bd:
            r3 = 1
        L_0x00be:
            if (r3 != 0) goto L_0x00ca
            if (r11 == 0) goto L_0x00c6
            java.lang.String[] r3 = B
            r3 = r3[r15]
        L_0x00c6:
            r6 = r4
            r27 = r11
            goto L_0x00e7
        L_0x00ca:
            r3 = 7
            r6 = r4
            if (r15 != r3) goto L_0x00cf
            r15 = r12
        L_0x00cf:
            long r3 = (long) r7
            r8 = r8[r15]
            r27 = r11
            long r11 = (long) r8
            long r3 = r3 * r11
            r11 = 0
            int r8 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r8 < 0) goto L_0x00e9
            r11 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r8 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r8 <= 0) goto L_0x00e5
            goto L_0x00e9
        L_0x00e5:
            r8 = 1
            goto L_0x00ea
        L_0x00e7:
            r3 = 0
        L_0x00e9:
            r8 = 0
        L_0x00ea:
            if (r8 != 0) goto L_0x00f1
        L_0x00ec:
            r1.e(r9)
            goto L_0x0239
        L_0x00f1:
            java.lang.String r8 = "Compression"
            int r11 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1))
            if (r11 <= 0) goto L_0x0156
            int r11 = r31.readInt()
            int r12 = r0.f16545c
            r28 = r9
            r9 = 7
            if (r12 != r9) goto L_0x014f
            java.lang.String r9 = r5.f16523b
            java.lang.String r10 = "MakerNote"
            boolean r9 = r10.equals(r9)
            if (r9 == 0) goto L_0x010f
            r0.f16551i = r11
            goto L_0x014f
        L_0x010f:
            r9 = 6
            if (r2 != r9) goto L_0x014f
            java.lang.String r10 = "ThumbnailImage"
            java.lang.String r12 = r5.f16523b
            boolean r10 = r10.equals(r12)
            if (r10 == 0) goto L_0x014f
            r0.f16552j = r11
            r0.f16553k = r7
            java.nio.ByteOrder r10 = r0.f16548f
            x0.c r9 = x0.c.d(r9, r10)
            int r10 = r0.f16552j
            r20 = r3
            long r2 = (long) r10
            java.nio.ByteOrder r4 = r0.f16548f
            x0.c r2 = x0.c.b(r2, r4)
            int r3 = r0.f16553k
            long r3 = (long) r3
            java.nio.ByteOrder r10 = r0.f16548f
            x0.c r3 = x0.c.b(r3, r10)
            r4 = 4
            r10 = r13[r4]
            r10.put(r8, r9)
            r9 = r13[r4]
            java.lang.String r10 = "JPEGInterchangeFormat"
            r9.put(r10, r2)
            r2 = r13[r4]
            java.lang.String r4 = "JPEGInterchangeFormatLength"
            r2.put(r4, r3)
            goto L_0x0151
        L_0x014f:
            r20 = r3
        L_0x0151:
            long r2 = (long) r11
            r1.e(r2)
            goto L_0x015a
        L_0x0156:
            r20 = r3
            r28 = r9
        L_0x015a:
            java.util.HashMap r2 = K
            java.lang.Integer r3 = java.lang.Integer.valueOf(r14)
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 == 0) goto L_0x01ca
            r3 = 3
            if (r15 == r3) goto L_0x0193
            r3 = 4
            if (r15 == r3) goto L_0x0187
            r3 = 8
            if (r15 == r3) goto L_0x0182
            r3 = 9
            if (r15 == r3) goto L_0x017d
            r3 = 13
            if (r15 == r3) goto L_0x017d
            r3 = -1
            goto L_0x0198
        L_0x017d:
            int r3 = r31.readInt()
            goto L_0x0197
        L_0x0182:
            short r3 = r31.readShort()
            goto L_0x0197
        L_0x0187:
            int r3 = r31.readInt()
            long r3 = (long) r3
            r7 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r3 = r3 & r7
            goto L_0x0198
        L_0x0193:
            int r3 = r31.readUnsignedShort()
        L_0x0197:
            long r3 = (long) r3
        L_0x0198:
            if (r27 == 0) goto L_0x01ae
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.Long r8 = java.lang.Long.valueOf(r3)
            r9 = 0
            r7[r9] = r8
            java.lang.String r5 = r5.f16523b
            r8 = 1
            r7[r8] = r5
            java.lang.String r5 = "Offset: %d, tagName: %s"
            java.lang.String.format(r5, r7)
        L_0x01ae:
            r7 = 0
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x0235
            int r5 = (int) r3
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            boolean r5 = r6.contains(r5)
            if (r5 != 0) goto L_0x0235
            r1.e(r3)
            int r2 = r2.intValue()
            r0.t(r1, r2)
            goto L_0x0235
        L_0x01ca:
            int r2 = r1.f16516j
            int r3 = r0.f16550h
            int r2 = r2 + r3
            r3 = r20
            int r4 = (int) r3
            byte[] r3 = new byte[r4]
            r1.readFully(r3)
            x0.c r4 = new x0.c
            long r9 = (long) r2
            r16 = r4
            r17 = r9
            r19 = r3
            r20 = r15
            r21 = r7
            r16.<init>(r17, r19, r20, r21)
            r2 = r13[r32]
            java.lang.String r3 = r5.f16523b
            r2.put(r3, r4)
            java.lang.String r2 = "DNGVersion"
            java.lang.String r3 = r5.f16523b
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x01fb
            r2 = 3
            r0.f16545c = r2
        L_0x01fb:
            java.lang.String r2 = "Make"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x020b
            java.lang.String r2 = "Model"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0219
        L_0x020b:
            java.nio.ByteOrder r2 = r0.f16548f
            java.lang.String r2 = r4.g(r2)
            java.lang.String r5 = "PENTAX"
            boolean r2 = r2.contains(r5)
            if (r2 != 0) goto L_0x022a
        L_0x0219:
            boolean r2 = r8.equals(r3)
            if (r2 == 0) goto L_0x022e
            java.nio.ByteOrder r2 = r0.f16548f
            int r2 = r4.f(r2)
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r2 != r3) goto L_0x022e
        L_0x022a:
            r2 = 8
            r0.f16545c = r2
        L_0x022e:
            int r2 = r1.f16516j
            long r2 = (long) r2
            int r4 = (r2 > r28 ? 1 : (r2 == r28 ? 0 : -1))
            if (r4 == 0) goto L_0x0239
        L_0x0235:
            r9 = r28
            goto L_0x00ec
        L_0x0239:
            int r2 = r26 + 1
            short r2 = (short) r2
            r4 = r6
            r3 = r25
            r6 = r2
            r2 = r32
            goto L_0x0019
        L_0x0244:
            r6 = r4
            r27 = r11
            int r2 = r31.readInt()
            if (r27 == 0) goto L_0x025c
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            r5 = 0
            r3[r5] = r4
            java.lang.String r4 = "nextIfdOffset: %d"
            java.lang.String.format(r4, r3)
        L_0x025c:
            long r3 = (long) r2
            r7 = 0
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x0288
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            boolean r2 = r6.contains(r2)
            if (r2 != 0) goto L_0x0288
            r1.e(r3)
            r2 = 4
            r3 = r13[r2]
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x027d
            r0.t(r1, r2)
            goto L_0x0288
        L_0x027d:
            r2 = r13[r12]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0288
            r0.t(r1, r12)
        L_0x0288:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.g.t(x0.f, int):void");
    }

    public final void u(int i10, String str, String str2) {
        HashMap[] hashMapArr = this.f16546d;
        if (!hashMapArr[i10].isEmpty() && hashMapArr[i10].get(str) != null) {
            HashMap hashMap = hashMapArr[i10];
            hashMap.put(str2, hashMap.get(str));
            hashMapArr[i10].remove(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void v(x0.b r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.util.HashMap[] r2 = r0.f16546d
            r3 = 4
            r2 = r2[r3]
            java.lang.String r3 = "Compression"
            java.lang.Object r3 = r2.get(r3)
            x0.c r3 = (x0.c) r3
            if (r3 == 0) goto L_0x0108
            java.nio.ByteOrder r4 = r0.f16548f
            int r3 = r3.f(r4)
            r4 = 1
            r5 = 6
            if (r3 == r4) goto L_0x0024
            if (r3 == r5) goto L_0x0108
            r6 = 7
            if (r3 == r6) goto L_0x0024
            goto L_0x010b
        L_0x0024:
            java.lang.String r3 = "BitsPerSample"
            java.lang.Object r3 = r2.get(r3)
            x0.c r3 = (x0.c) r3
            r6 = 0
            if (r3 == 0) goto L_0x0069
            java.nio.ByteOrder r7 = r0.f16548f
            java.io.Serializable r3 = r3.h(r7)
            int[] r3 = (int[]) r3
            int[] r7 = f16529m
            boolean r8 = java.util.Arrays.equals(r7, r3)
            if (r8 == 0) goto L_0x0040
            goto L_0x0067
        L_0x0040:
            int r8 = r0.f16545c
            r9 = 3
            if (r8 != r9) goto L_0x0069
            java.lang.String r8 = "PhotometricInterpretation"
            java.lang.Object r8 = r2.get(r8)
            x0.c r8 = (x0.c) r8
            if (r8 == 0) goto L_0x0069
            java.nio.ByteOrder r9 = r0.f16548f
            int r8 = r8.f(r9)
            if (r8 != r4) goto L_0x005f
            int[] r9 = f16530n
            boolean r9 = java.util.Arrays.equals(r3, r9)
            if (r9 != 0) goto L_0x0067
        L_0x005f:
            if (r8 != r5) goto L_0x0069
            boolean r3 = java.util.Arrays.equals(r3, r7)
            if (r3 == 0) goto L_0x0069
        L_0x0067:
            r3 = 1
            goto L_0x006a
        L_0x0069:
            r3 = 0
        L_0x006a:
            if (r3 == 0) goto L_0x010b
            java.lang.String r3 = "StripOffsets"
            java.lang.Object r3 = r2.get(r3)
            x0.c r3 = (x0.c) r3
            java.lang.String r5 = "StripByteCounts"
            java.lang.Object r2 = r2.get(r5)
            x0.c r2 = (x0.c) r2
            if (r3 == 0) goto L_0x010b
            if (r2 == 0) goto L_0x010b
            java.nio.ByteOrder r5 = r0.f16548f
            java.io.Serializable r3 = r3.h(r5)
            long[] r3 = x0.j.b(r3)
            java.nio.ByteOrder r5 = r0.f16548f
            java.io.Serializable r2 = r2.h(r5)
            long[] r2 = x0.j.b(r2)
            if (r3 == 0) goto L_0x0100
            int r5 = r3.length
            if (r5 != 0) goto L_0x009b
            goto L_0x0100
        L_0x009b:
            if (r2 == 0) goto L_0x00fd
            int r5 = r2.length
            if (r5 != 0) goto L_0x00a1
            goto L_0x00fd
        L_0x00a1:
            int r5 = r3.length
            int r7 = r2.length
            if (r5 == r7) goto L_0x00a8
            java.lang.String r1 = "stripOffsets and stripByteCounts should have same length."
            goto L_0x0102
        L_0x00a8:
            int r5 = r2.length
            r7 = 0
            r9 = 0
        L_0x00ac:
            if (r9 >= r5) goto L_0x00b4
            r10 = r2[r9]
            long r7 = r7 + r10
            int r9 = r9 + 1
            goto L_0x00ac
        L_0x00b4:
            int r5 = (int) r7
            byte[] r5 = new byte[r5]
            r0.f16549g = r4
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x00bc:
            int r10 = r3.length
            if (r7 >= r10) goto L_0x00f6
            r10 = r3[r7]
            int r11 = (int) r10
            r12 = r2[r7]
            int r10 = (int) r12
            int r12 = r3.length
            int r12 = r12 - r4
            if (r7 >= r12) goto L_0x00d6
            int r12 = r11 + r10
            long r12 = (long) r12
            int r14 = r7 + 1
            r14 = r3[r14]
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 == 0) goto L_0x00d6
            r0.f16549g = r6
        L_0x00d6:
            int r11 = r11 - r8
            if (r11 >= 0) goto L_0x00da
            goto L_0x010b
        L_0x00da:
            long r12 = (long) r11
            long r14 = r1.skip(r12)
            int r16 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r16 == 0) goto L_0x00e4
            goto L_0x010b
        L_0x00e4:
            int r8 = r8 + r11
            byte[] r11 = new byte[r10]
            int r12 = r1.read(r11)
            if (r12 == r10) goto L_0x00ee
            goto L_0x010b
        L_0x00ee:
            int r8 = r8 + r10
            java.lang.System.arraycopy(r11, r6, r5, r9, r10)
            int r9 = r9 + r10
            int r7 = r7 + 1
            goto L_0x00bc
        L_0x00f6:
            boolean r1 = r0.f16549g
            if (r1 == 0) goto L_0x010b
            r1 = r3[r6]
            goto L_0x010b
        L_0x00fd:
            java.lang.String r1 = "stripByteCounts should not be null or have zero length."
            goto L_0x0102
        L_0x0100:
            java.lang.String r1 = "stripOffsets should not be null or have zero length."
        L_0x0102:
            java.lang.String r2 = "ExifInterface"
            android.util.Log.w(r2, r1)
            goto L_0x010b
        L_0x0108:
            r0.n(r1, r2)
        L_0x010b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.g.v(x0.b):void");
    }

    public final void w(int i10, int i11) {
        HashMap[] hashMapArr = this.f16546d;
        if (!hashMapArr[i10].isEmpty() && !hashMapArr[i11].isEmpty()) {
            c cVar = (c) hashMapArr[i10].get("ImageLength");
            c cVar2 = (c) hashMapArr[i10].get("ImageWidth");
            c cVar3 = (c) hashMapArr[i11].get("ImageLength");
            c cVar4 = (c) hashMapArr[i11].get("ImageWidth");
            if (cVar != null && cVar2 != null && cVar3 != null && cVar4 != null) {
                int f10 = cVar.f(this.f16548f);
                int f11 = cVar2.f(this.f16548f);
                int f12 = cVar3.f(this.f16548f);
                int f13 = cVar4.f(this.f16548f);
                if (f10 < f12 && f11 < f13) {
                    HashMap hashMap = hashMapArr[i10];
                    hashMapArr[i10] = hashMapArr[i11];
                    hashMapArr[i11] = hashMap;
                }
            }
        }
    }

    public final void x(f fVar, int i10) {
        StringBuilder sb2;
        String str;
        c cVar;
        c cVar2;
        HashMap[] hashMapArr = this.f16546d;
        c cVar3 = (c) hashMapArr[i10].get("DefaultCropSize");
        c cVar4 = (c) hashMapArr[i10].get("SensorTopBorder");
        c cVar5 = (c) hashMapArr[i10].get("SensorLeftBorder");
        c cVar6 = (c) hashMapArr[i10].get("SensorBottomBorder");
        c cVar7 = (c) hashMapArr[i10].get("SensorRightBorder");
        if (cVar3 != null) {
            if (cVar3.f16518a == 5) {
                e[] eVarArr = (e[]) cVar3.h(this.f16548f);
                if (eVarArr == null || eVarArr.length != 2) {
                    sb2 = new StringBuilder("Invalid crop size values. cropSize=");
                    str = Arrays.toString(eVarArr);
                    sb2.append(str);
                    Log.w("ExifInterface", sb2.toString());
                    return;
                }
                cVar2 = c.c(eVarArr[0], this.f16548f);
                cVar = c.c(eVarArr[1], this.f16548f);
            } else {
                int[] iArr = (int[]) cVar3.h(this.f16548f);
                if (iArr == null || iArr.length != 2) {
                    sb2 = new StringBuilder("Invalid crop size values. cropSize=");
                    str = Arrays.toString(iArr);
                    sb2.append(str);
                    Log.w("ExifInterface", sb2.toString());
                    return;
                }
                cVar2 = c.d(iArr[0], this.f16548f);
                cVar = c.d(iArr[1], this.f16548f);
            }
            hashMapArr[i10].put("ImageWidth", cVar2);
            hashMapArr[i10].put("ImageLength", cVar);
        } else if (cVar4 == null || cVar5 == null || cVar6 == null || cVar7 == null) {
            c cVar8 = (c) hashMapArr[i10].get("ImageLength");
            c cVar9 = (c) hashMapArr[i10].get("ImageWidth");
            if (cVar8 == null || cVar9 == null) {
                c cVar10 = (c) hashMapArr[i10].get("JPEGInterchangeFormat");
                c cVar11 = (c) hashMapArr[i10].get("JPEGInterchangeFormatLength");
                if (cVar10 != null && cVar11 != null) {
                    int f10 = cVar10.f(this.f16548f);
                    int f11 = cVar10.f(this.f16548f);
                    fVar.e((long) f10);
                    byte[] bArr = new byte[f11];
                    fVar.read(bArr);
                    f(new b(bArr), f10, i10);
                }
            }
        } else {
            int f12 = cVar4.f(this.f16548f);
            int f13 = cVar6.f(this.f16548f);
            int f14 = cVar7.f(this.f16548f);
            int f15 = cVar5.f(this.f16548f);
            if (f13 > f12 && f14 > f15) {
                c d10 = c.d(f13 - f12, this.f16548f);
                c d11 = c.d(f14 - f15, this.f16548f);
                hashMapArr[i10].put("ImageLength", d10);
                hashMapArr[i10].put("ImageWidth", d11);
            }
        }
    }

    public final void y() {
        w(0, 5);
        w(0, 4);
        w(5, 4);
        HashMap[] hashMapArr = this.f16546d;
        c cVar = (c) hashMapArr[1].get("PixelXDimension");
        c cVar2 = (c) hashMapArr[1].get("PixelYDimension");
        if (!(cVar == null || cVar2 == null)) {
            hashMapArr[0].put("ImageWidth", cVar);
            hashMapArr[0].put("ImageLength", cVar2);
        }
        if (hashMapArr[4].isEmpty() && o(hashMapArr[5])) {
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap();
        }
        o(hashMapArr[4]);
        u(0, "ThumbnailOrientation", "Orientation");
        u(0, "ThumbnailImageLength", "ImageLength");
        u(0, "ThumbnailImageWidth", "ImageWidth");
        u(5, "ThumbnailOrientation", "Orientation");
        u(5, "ThumbnailImageLength", "ImageLength");
        u(5, "ThumbnailImageWidth", "ImageWidth");
        u(4, "Orientation", "ThumbnailOrientation");
        u(4, "ImageLength", "ThumbnailImageLength");
        u(4, "ImageWidth", "ThumbnailImageWidth");
    }
}
