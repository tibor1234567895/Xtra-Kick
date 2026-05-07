package com.github.andreyasadchy.xtra.util

import coil3.util.Logger

class DiagnosticCoilLogger(
    override var minLevel: Logger.Level = Logger.Level.Error,
) : Logger {

    override fun log(tag: String, level: Logger.Level, message: String?, throwable: Throwable?) {
        val text = message ?: throwable?.message ?: return
        when (level) {
            Logger.Level.Warn -> DiagnosticLogger.w(tag, text, throwable)
            Logger.Level.Error -> DiagnosticLogger.e(tag, text, throwable)
            else -> {}
        }
    }
}
