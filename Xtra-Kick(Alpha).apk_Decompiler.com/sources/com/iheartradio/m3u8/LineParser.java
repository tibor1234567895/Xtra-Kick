package com.iheartradio.m3u8;

interface LineParser {
    void parse(String str, ParseState parseState) throws ParseException;
}
