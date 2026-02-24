package com.github.andreyasadchy.xtra.model.offline;

public interface Downloadable {
    String getBoxArtUrl();

    int getChannelId();

    String getChannelLogo();

    String getChannelName();

    String getChannelSlug();

    int getGameId();

    String getGameName();

    String getGameSlug();

    String getThumbnail();

    String getTitle();

    String getType();

    String getUploadDate();

    String getUuid();
}
