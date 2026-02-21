package com.iheartradio.m3u8.data;

import java.util.List;

public interface IStreamInfo {
    int getAverageBandwidth();

    int getBandwidth();

    List<String> getCodecs();

    float getFrameRate();

    Resolution getResolution();

    String getVideo();

    boolean hasAverageBandwidth();

    boolean hasCodecs();

    boolean hasFrameRate();

    boolean hasResolution();

    boolean hasVideo();
}
