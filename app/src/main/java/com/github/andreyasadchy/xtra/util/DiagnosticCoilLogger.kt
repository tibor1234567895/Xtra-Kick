package com.github.andreyasadchy.xtra.util

import coil3.util.Logger

class DiagnosticCoilLogger(
    override var minLevel: Logger.Level = Logger.Level.Error,
) : Logger {

    override fun log(tag: String, level: Logger.Level, message: String?, throwable: Throwable?) {
        val text = message ?: throwable?.message ?: return
        when (level) {
            // Image CDN blips are expected network noise; keep them out of ERROR exports.
            Logger.Level.Warn, Logger.Level.Error -> DiagnosticLogger.w(tag, text, throwable)
            else -> {}
        }
    }
}
