package com.bumptech.glide.integration.webp;

import androidx.annotation.Keep;
import java.nio.ByteBuffer;
import w5.n;

@Keep
public class WebpImage {
    private int mBackgroundColor;
    private int mDurationMs;
    private int mFrameCount;
    private int[] mFrameDurations;
    private int mHeigth;
    private int mLoopCount;
    @Keep
    private long mNativePtr;
    private int mWidth;

    static {
        System.loadLibrary("glide-webp");
    }

    @Keep
    public WebpImage(long j10, int i10, int i11, int i12, int i13, int[] iArr, int i14, int i15) {
        if (j10 != 0) {
            this.mWidth = i10;
            this.mHeigth = i11;
            this.mFrameCount = i12;
            this.mDurationMs = i13;
            this.mFrameDurations = iArr;
            this.mLoopCount = i14;
            fixFrameDurations(iArr);
            this.mBackgroundColor = i15;
            this.mNativePtr = j10;
            return;
        }
        throw new RuntimeException("internal error: native WebpImage is 0");
    }

    public static WebpImage create(byte[] bArr) {
        n.b(bArr);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.put(bArr);
        allocateDirect.rewind();
        return nativeCreateFromDirectByteBuffer(allocateDirect);
    }

    private void fixFrameDurations(int[] iArr) {
        for (int i10 = 0; i10 < iArr.length; i10++) {
            if (iArr[i10] < 11) {
                iArr[i10] = 100;
            }
        }
    }

    private static native WebpImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native WebpFrame nativeGetFrame(int i10);

    private native int nativeGetSizeInBytes();

    public void dispose() {
        nativeDispose();
    }

    public void finalize() throws Throwable {
        nativeFinalize();
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getDuration() {
        return this.mDurationMs;
    }

    public WebpFrame getFrame(int i10) {
        return nativeGetFrame(i10);
    }

    public int getFrameCount() {
        return this.mFrameCount;
    }

    public int[] getFrameDurations() {
        return this.mFrameDurations;
    }

    public a getFrameInfo(int i10) {
        WebpFrame frame = getFrame(i10);
        try {
            return new a(i10, frame);
        } finally {
            frame.dispose();
        }
    }

    public int getHeight() {
        return this.mHeigth;
    }

    public int getLoopCount() {
        return this.mLoopCount;
    }

    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }

    public int getWidth() {
        return this.mWidth;
    }
}
