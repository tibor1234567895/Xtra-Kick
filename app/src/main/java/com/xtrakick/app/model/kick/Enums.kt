package com.xtrakick.app.model.kick

/**
 * Hand-written replacements for the Apollo-generated GraphQL enums previously in
 * `com.xtrakick.app.graphql.type`. The app is Kick-only; these values
 * survive solely as filter/sort parameters that are mapped to Kick URL query strings.
 * Keeping the same entry names and [rawValue] preserves all call-site logic without codegen.
 */
enum class BadgeImageSize(val rawValue: String) {
    NORMAL("NORMAL"),
    DOUBLE("DOUBLE"),
    QUADRUPLE("QUADRUPLE"),
}

enum class BroadcastType(val rawValue: String) {
    ARCHIVE("ARCHIVE"),
    HIGHLIGHT("HIGHLIGHT"),
    UPLOAD("UPLOAD"),
    PREMIERE_UPLOAD("PREMIERE_UPLOAD"),
    PAST_PREMIERE("PAST_PREMIERE"),
}

enum class ClipsPeriod(val rawValue: String) {
    LAST_DAY("LAST_DAY"),
    LAST_WEEK("LAST_WEEK"),
    LAST_MONTH("LAST_MONTH"),
    ALL_TIME("ALL_TIME"),
}

enum class EmoteType(val rawValue: String) {
    CHANNEL_POINTS("CHANNEL_POINTS"),
    BITS_BADGE_TIERS("BITS_BADGE_TIERS"),
    SUBSCRIPTIONS("SUBSCRIPTIONS"),
    PRIME("PRIME"),
    TURBO("TURBO"),
    TWO_FACTOR("TWO_FACTOR"),
    SMILIES("SMILIES"),
    GLOBALS("GLOBALS"),
    LIMITED_TIME("LIMITED_TIME"),
    HYPE_TRAIN("HYPE_TRAIN"),
    MEGA_COMMERCE("MEGA_COMMERCE"),
    ARCHIVE("ARCHIVE"),
    FOLLOWER("FOLLOWER"),
    UNKNOWN("UNKNOWN"),
}

enum class Language(val rawValue: String) {
    AR("AR"),
    ASL("ASL"),
    BG("BG"),
    CA("CA"),
    CS("CS"),
    DA("DA"),
    DE("DE"),
    EL("EL"),
    EN("EN"),
    ES("ES"),
    FI("FI"),
    FR("FR"),
    HI("HI"),
    HU("HU"),
    ID("ID"),
    IT("IT"),
    JA("JA"),
    KO("KO"),
    MS("MS"),
    NL("NL"),
    NO("NO"),
    OTHER("OTHER"),
    PL("PL"),
    PT("PT"),
    RO("RO"),
    RU("RU"),
    SK("SK"),
    SV("SV"),
    TH("TH"),
    TL("TL"),
    TR("TR"),
    UK("UK"),
    VI("VI"),
    ZH("ZH"),
    ZH_HK("ZH_HK"),
}

enum class StreamSort(val rawValue: String) {
    VIEWER_COUNT("VIEWER_COUNT"),
    VIEWER_COUNT_ASC("VIEWER_COUNT_ASC"),
    RECENT("RECENT"),
    RELEVANCE("RELEVANCE"),
}

enum class VideoSort(val rawValue: String) {
    TIME("TIME"),
    TIME_ASC("TIME_ASC"),
    VIEWS("VIEWS"),
}
