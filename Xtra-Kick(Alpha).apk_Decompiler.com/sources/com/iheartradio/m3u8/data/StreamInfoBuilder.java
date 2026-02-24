package com.iheartradio.m3u8.data;

import java.util.List;

public interface StreamInfoBuilder {
    StreamInfoBuilder withAverageBandwidth(int i10);

    StreamInfoBuilder withBandwidth(int i10);

    StreamInfoBuilder withCodecs(List<String> list);

    StreamInfoBuilder withFrameRate(float f10);

    StreamInfoBuilder withResolution(Resolution resolution);

    StreamInfoBuilder withVideo(String str);
}
