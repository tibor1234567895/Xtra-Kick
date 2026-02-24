package com.iheartradio.m3u8;

interface LineHandler {
    void handle(String str, ParseState parseState) throws ParseException;
}
