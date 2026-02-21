package com.github.andreyasadchy.xtra.model.ui;

public enum VideoPeriodEnum {
    DAY("day"),
    WEEK("week"),
    MONTH("month"),
    ALL("all");
    
    private final String value;

    private VideoPeriodEnum(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public String toString() {
        return this.value;
    }
}
