package com.iheartradio.m3u8;

interface AttributeWriter<T> {
    boolean containsAttribute(T t10);

    String write(T t10) throws ParseException;
}
