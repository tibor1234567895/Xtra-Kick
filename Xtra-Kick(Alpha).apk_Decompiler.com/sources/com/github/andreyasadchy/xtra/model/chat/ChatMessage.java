package com.github.andreyasadchy.xtra.model.chat;

import java.util.List;

public interface ChatMessage {
    List<Badge> getBadges();

    String getColor();

    List<KickEmote> getEmotes();

    String getFullMsg();

    String getId();

    String getMessage();

    int getUserId();

    String getUserLogin();

    String getUserName();

    boolean isAction();
}
