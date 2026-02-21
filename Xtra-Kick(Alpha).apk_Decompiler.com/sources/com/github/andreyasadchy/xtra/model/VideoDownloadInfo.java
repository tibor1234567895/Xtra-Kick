package com.github.andreyasadchy.xtra.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.andreyasadchy.xtra.model.ui.Video;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import xa.j;

public final class VideoDownloadInfo implements Parcelable {
    public static final Parcelable.Creator<VideoDownloadInfo> CREATOR = new Creator();
    private final long currentPosition;
    private final List<Long> durations;
    private final Map<String, String> qualities;
    private final List<Long> relativeStartTimes;
    private final long targetDuration;
    private final long totalDuration;
    private final Video video;

    public static final class Creator implements Parcelable.Creator<VideoDownloadInfo> {
        public final VideoDownloadInfo createFromParcel(Parcel parcel) {
            j.f("parcel", parcel);
            Video createFromParcel = Video.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            int i10 = 0;
            for (int i11 = 0; i11 != readInt; i11++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i12 = 0; i12 != readInt2; i12++) {
                arrayList.add(Long.valueOf(parcel.readLong()));
            }
            int readInt3 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt3);
            while (true) {
                long readLong = parcel.readLong();
                if (i10 == readInt3) {
                    return new VideoDownloadInfo(createFromParcel, linkedHashMap, arrayList, arrayList2, readLong, parcel.readLong(), parcel.readLong());
                }
                arrayList2.add(Long.valueOf(readLong));
                i10++;
            }
        }

        public final VideoDownloadInfo[] newArray(int i10) {
            return new VideoDownloadInfo[i10];
        }
    }

    public VideoDownloadInfo(Video video2, Map<String, String> map, List<Long> list, List<Long> list2, long j10, long j11, long j12) {
        j.f("video", video2);
        j.f("qualities", map);
        j.f("relativeStartTimes", list);
        j.f("durations", list2);
        this.video = video2;
        this.qualities = map;
        this.relativeStartTimes = list;
        this.durations = list2;
        this.totalDuration = j10;
        this.targetDuration = j11;
        this.currentPosition = j12;
    }

    public static /* synthetic */ VideoDownloadInfo copy$default(VideoDownloadInfo videoDownloadInfo, Video video2, Map map, List list, List list2, long j10, long j11, long j12, int i10, Object obj) {
        VideoDownloadInfo videoDownloadInfo2 = videoDownloadInfo;
        return videoDownloadInfo.copy((i10 & 1) != 0 ? videoDownloadInfo2.video : video2, (i10 & 2) != 0 ? videoDownloadInfo2.qualities : map, (i10 & 4) != 0 ? videoDownloadInfo2.relativeStartTimes : list, (i10 & 8) != 0 ? videoDownloadInfo2.durations : list2, (i10 & 16) != 0 ? videoDownloadInfo2.totalDuration : j10, (i10 & 32) != 0 ? videoDownloadInfo2.targetDuration : j11, (i10 & 64) != 0 ? videoDownloadInfo2.currentPosition : j12);
    }

    public final Video component1() {
        return this.video;
    }

    public final Map<String, String> component2() {
        return this.qualities;
    }

    public final List<Long> component3() {
        return this.relativeStartTimes;
    }

    public final List<Long> component4() {
        return this.durations;
    }

    public final long component5() {
        return this.totalDuration;
    }

    public final long component6() {
        return this.targetDuration;
    }

    public final long component7() {
        return this.currentPosition;
    }

    public final VideoDownloadInfo copy(Video video2, Map<String, String> map, List<Long> list, List<Long> list2, long j10, long j11, long j12) {
        j.f("video", video2);
        j.f("qualities", map);
        j.f("relativeStartTimes", list);
        List<Long> list3 = list2;
        j.f("durations", list3);
        return new VideoDownloadInfo(video2, map, list, list3, j10, j11, j12);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoDownloadInfo)) {
            return false;
        }
        VideoDownloadInfo videoDownloadInfo = (VideoDownloadInfo) obj;
        return j.a(this.video, videoDownloadInfo.video) && j.a(this.qualities, videoDownloadInfo.qualities) && j.a(this.relativeStartTimes, videoDownloadInfo.relativeStartTimes) && j.a(this.durations, videoDownloadInfo.durations) && this.totalDuration == videoDownloadInfo.totalDuration && this.targetDuration == videoDownloadInfo.targetDuration && this.currentPosition == videoDownloadInfo.currentPosition;
    }

    public final long getCurrentPosition() {
        return this.currentPosition;
    }

    public final List<Long> getDurations() {
        return this.durations;
    }

    public final Map<String, String> getQualities() {
        return this.qualities;
    }

    public final List<Long> getRelativeStartTimes() {
        return this.relativeStartTimes;
    }

    public final long getTargetDuration() {
        return this.targetDuration;
    }

    public final long getTotalDuration() {
        return this.totalDuration;
    }

    public final Video getVideo() {
        return this.video;
    }

    public int hashCode() {
        int hashCode = this.qualities.hashCode();
        int hashCode2 = this.relativeStartTimes.hashCode();
        int hashCode3 = this.durations.hashCode();
        long j10 = this.totalDuration;
        long j11 = this.targetDuration;
        long j12 = this.currentPosition;
        return ((((((hashCode3 + ((hashCode2 + ((hashCode + (this.video.hashCode() * 31)) * 31)) * 31)) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)));
    }

    public String toString() {
        Video video2 = this.video;
        Map<String, String> map = this.qualities;
        List<Long> list = this.relativeStartTimes;
        List<Long> list2 = this.durations;
        long j10 = this.totalDuration;
        long j11 = this.targetDuration;
        long j12 = this.currentPosition;
        return "VideoDownloadInfo(video=" + video2 + ", qualities=" + map + ", relativeStartTimes=" + list + ", durations=" + list2 + ", totalDuration=" + j10 + ", targetDuration=" + j11 + ", currentPosition=" + j12 + ")";
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.f("out", parcel);
        this.video.writeToParcel(parcel, i10);
        Map<String, String> map = this.qualities;
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
        List<Long> list = this.relativeStartTimes;
        parcel.writeInt(list.size());
        for (Long longValue : list) {
            parcel.writeLong(longValue.longValue());
        }
        List<Long> list2 = this.durations;
        parcel.writeInt(list2.size());
        for (Long longValue2 : list2) {
            parcel.writeLong(longValue2.longValue());
        }
        parcel.writeLong(this.totalDuration);
        parcel.writeLong(this.targetDuration);
        parcel.writeLong(this.currentPosition);
    }
}
