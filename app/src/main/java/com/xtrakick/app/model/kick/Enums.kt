package com.xtrakick.app.model.kick

/**
 * Hand-written replacements for the Apollo-generated GraphQL enums previously in
 * `com.xtrakick.app.graphql.type`. The app is Kick-only; these values
 * survive solely as filter/sort parameters that are mapped to Kick URL query strings.
 * Keeping the same entry names and [rawValue] preserves all call-site logic without codegen.
 */
enum class ClipsPeriod(val rawValue: String) {
    LAST_DAY("LAST_DAY"),
    LAST_WEEK("LAST_WEEK"),
    LAST_MONTH("LAST_MONTH"),
    ALL_TIME("ALL_TIME"),
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
