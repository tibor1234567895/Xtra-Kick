package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.IOException;

final class ParcelFileDescriptorRewinder$InternalRewinder {

    /* renamed from: a  reason: collision with root package name */
    public final ParcelFileDescriptor f3215a;

    public ParcelFileDescriptorRewinder$InternalRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        this.f3215a = parcelFileDescriptor;
    }

    public ParcelFileDescriptor rewind() throws IOException {
        ParcelFileDescriptor parcelFileDescriptor = this.f3215a;
        try {
            Os.lseek(parcelFileDescriptor.getFileDescriptor(), 0, OsConstants.SEEK_SET);
            return parcelFileDescriptor;
        } catch (ErrnoException e10) {
            throw new IOException(e10);
        }
    }
}
