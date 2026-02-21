package com.iheartradio.m3u8.data;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class EncryptionData {
    private final List<Byte> mInitializationVector;
    private final String mKeyFormat;
    private final List<Integer> mKeyFormatVersions;
    private final EncryptionMethod mMethod;
    private final String mUri;

    public static class Builder {
        private List<Byte> mInitializationVector;
        private String mKeyFormat;
        private List<Integer> mKeyFormatVersions;
        private EncryptionMethod mMethod;
        private String mUri;

        public Builder() {
        }

        private Builder(EncryptionMethod encryptionMethod, String str, List<Byte> list, String str2, List<Integer> list2) {
            this.mMethod = encryptionMethod;
            this.mUri = str;
            this.mInitializationVector = list;
            this.mKeyFormat = str2;
            this.mKeyFormatVersions = list2;
        }

        public EncryptionData build() {
            return new EncryptionData(this.mMethod, this.mUri, this.mInitializationVector, this.mKeyFormat, this.mKeyFormatVersions);
        }

        public Builder withInitializationVector(List<Byte> list) {
            this.mInitializationVector = list;
            return this;
        }

        public Builder withKeyFormat(String str) {
            this.mKeyFormat = str;
            return this;
        }

        public Builder withKeyFormatVersions(List<Integer> list) {
            this.mKeyFormatVersions = list;
            return this;
        }

        public Builder withMethod(EncryptionMethod encryptionMethod) {
            this.mMethod = encryptionMethod;
            return this;
        }

        public Builder withUri(String str) {
            this.mUri = str;
            return this;
        }
    }

    private EncryptionData(EncryptionMethod encryptionMethod, String str, List<Byte> list, String str2, List<Integer> list2) {
        this.mMethod = encryptionMethod;
        this.mUri = str;
        List<Integer> list3 = null;
        this.mInitializationVector = list == null ? null : Collections.unmodifiableList(list);
        this.mKeyFormat = str2;
        this.mKeyFormatVersions = list2 != null ? Collections.unmodifiableList(list2) : list3;
    }

    public Builder buildUpon() {
        return new Builder(this.mMethod, this.mUri, this.mInitializationVector, this.mKeyFormat, this.mKeyFormatVersions);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EncryptionData)) {
            return false;
        }
        EncryptionData encryptionData = (EncryptionData) obj;
        return Objects.equals(this.mInitializationVector, encryptionData.mInitializationVector) && Objects.equals(this.mKeyFormat, encryptionData.mKeyFormat) && Objects.equals(this.mKeyFormatVersions, encryptionData.mKeyFormatVersions) && Objects.equals(this.mMethod, encryptionData.mMethod) && Objects.equals(this.mUri, encryptionData.mUri);
    }

    public List<Byte> getInitializationVector() {
        return this.mInitializationVector;
    }

    public String getKeyFormat() {
        return this.mKeyFormat;
    }

    public List<Integer> getKeyFormatVersions() {
        return this.mKeyFormatVersions;
    }

    public EncryptionMethod getMethod() {
        return this.mMethod;
    }

    public String getUri() {
        return this.mUri;
    }

    public boolean hasInitializationVector() {
        return this.mInitializationVector != null;
    }

    public boolean hasKeyFormat() {
        return this.mKeyFormat != null;
    }

    public boolean hasKeyFormatVersions() {
        return this.mKeyFormatVersions != null;
    }

    public boolean hasUri() {
        String str = this.mUri;
        return str != null && !str.isEmpty();
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mInitializationVector, this.mKeyFormat, this.mKeyFormatVersions, this.mMethod, this.mUri});
    }
}
