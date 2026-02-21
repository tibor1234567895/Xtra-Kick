package com.iheartradio.m3u8.data;

import java.util.List;
import java.util.Objects;

public class MediaData {
    private final String mAssociatedLanguage;
    private final boolean mAutoSelect;
    private final List<String> mCharacteristics;
    private final boolean mDefault;
    private final boolean mForced;
    private final String mGroupId;
    private final String mInStreamId;
    private final String mLanguage;
    private final String mName;
    private final MediaType mType;
    private final String mUri;

    public static class Builder {
        private String mAssociatedLanguage;
        private boolean mAutoSelect;
        private List<String> mCharacteristics;
        private boolean mDefault;
        private boolean mForced;
        private String mGroupId;
        private String mInStreamId;
        private String mLanguage;
        private String mName;
        private MediaType mType;
        private String mUri;

        public Builder() {
        }

        private Builder(MediaType mediaType, String str, String str2, String str3, String str4, String str5, boolean z10, boolean z11, boolean z12, String str6, List<String> list) {
            this.mType = mediaType;
            this.mUri = str;
            this.mGroupId = str2;
            this.mLanguage = str3;
            this.mAssociatedLanguage = str4;
            this.mName = str5;
            this.mDefault = z10;
            this.mAutoSelect = z11;
            this.mForced = z12;
            this.mInStreamId = str6;
            this.mCharacteristics = list;
        }

        public MediaData build() {
            return new MediaData(this.mType, this.mUri, this.mGroupId, this.mLanguage, this.mAssociatedLanguage, this.mName, this.mDefault, this.mAutoSelect, this.mForced, this.mInStreamId, this.mCharacteristics);
        }

        public Builder withAssociatedLanguage(String str) {
            this.mAssociatedLanguage = str;
            return this;
        }

        public Builder withAutoSelect(boolean z10) {
            this.mAutoSelect = z10;
            return this;
        }

        public Builder withCharacteristics(List<String> list) {
            this.mCharacteristics = list;
            return this;
        }

        public Builder withDefault(boolean z10) {
            this.mDefault = z10;
            return this;
        }

        public Builder withForced(boolean z10) {
            this.mForced = z10;
            return this;
        }

        public Builder withGroupId(String str) {
            this.mGroupId = str;
            return this;
        }

        public Builder withInStreamId(String str) {
            this.mInStreamId = str;
            return this;
        }

        public Builder withLanguage(String str) {
            this.mLanguage = str;
            return this;
        }

        public Builder withName(String str) {
            this.mName = str;
            return this;
        }

        public Builder withType(MediaType mediaType) {
            this.mType = mediaType;
            return this;
        }

        public Builder withUri(String str) {
            this.mUri = str;
            return this;
        }
    }

    private MediaData(MediaType mediaType, String str, String str2, String str3, String str4, String str5, boolean z10, boolean z11, boolean z12, String str6, List<String> list) {
        this.mType = mediaType;
        this.mUri = str;
        this.mGroupId = str2;
        this.mLanguage = str3;
        this.mAssociatedLanguage = str4;
        this.mName = str5;
        this.mDefault = z10;
        this.mAutoSelect = z11;
        this.mForced = z12;
        this.mInStreamId = str6;
        this.mCharacteristics = DataUtil.emptyOrUnmodifiable(list);
    }

    public Builder buildUpon() {
        return new Builder(this.mType, this.mUri, this.mGroupId, this.mLanguage, this.mAssociatedLanguage, this.mName, this.mDefault, this.mAutoSelect, this.mForced, this.mInStreamId, this.mCharacteristics);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MediaData)) {
            return false;
        }
        MediaData mediaData = (MediaData) obj;
        return this.mType == mediaData.mType && Objects.equals(this.mUri, mediaData.mUri) && Objects.equals(this.mGroupId, mediaData.mGroupId) && Objects.equals(this.mLanguage, mediaData.mLanguage) && Objects.equals(this.mAssociatedLanguage, mediaData.mAssociatedLanguage) && Objects.equals(this.mName, mediaData.mName) && this.mDefault == mediaData.mDefault && this.mAutoSelect == mediaData.mAutoSelect && this.mForced == mediaData.mForced && Objects.equals(this.mInStreamId, mediaData.mInStreamId) && Objects.equals(this.mCharacteristics, mediaData.mCharacteristics);
    }

    public String getAssociatedLanguage() {
        return this.mAssociatedLanguage;
    }

    public List<String> getCharacteristics() {
        return this.mCharacteristics;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public String getInStreamId() {
        return this.mInStreamId;
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    public String getName() {
        return this.mName;
    }

    public MediaType getType() {
        return this.mType;
    }

    public String getUri() {
        return this.mUri;
    }

    public boolean hasAssociatedLanguage() {
        return this.mAssociatedLanguage != null;
    }

    public boolean hasCharacteristics() {
        return !this.mCharacteristics.isEmpty();
    }

    public boolean hasInStreamId() {
        return this.mInStreamId != null;
    }

    public boolean hasLanguage() {
        return this.mLanguage != null;
    }

    public boolean hasUri() {
        String str = this.mUri;
        return str != null && !str.isEmpty();
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mAssociatedLanguage, Boolean.valueOf(this.mAutoSelect), this.mCharacteristics, Boolean.valueOf(this.mDefault), Boolean.valueOf(this.mForced), this.mGroupId, this.mInStreamId, this.mLanguage, this.mName, this.mType, this.mUri});
    }

    public boolean isAutoSelect() {
        return this.mAutoSelect;
    }

    public boolean isDefault() {
        return this.mDefault;
    }

    public boolean isForced() {
        return this.mForced;
    }

    public String toString() {
        return "MediaData [mType=" + this.mType + ", mUri=" + this.mUri + ", mGroupId=" + this.mGroupId + ", mLanguage=" + this.mLanguage + ", mAssociatedLanguage=" + this.mAssociatedLanguage + ", mName=" + this.mName + ", mDefault=" + this.mDefault + ", mAutoSelect=" + this.mAutoSelect + ", mForced=" + this.mForced + ", mInStreamId=" + this.mInStreamId + ", mCharacteristics=" + this.mCharacteristics + "]";
    }
}
