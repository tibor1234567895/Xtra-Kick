package com.xtrakick.app.util

import coil3.ImageLoader
import coil3.asImage
import coil3.decode.DecodeResult
import coil3.decode.Decoder
import coil3.fetch.SourceFetchResult
import coil3.request.Options
import coil3.request.maxBitmapSize
import coil3.size.Dimension
import com.bumptech.glide.integration.webp.WebpHeaderParser
import com.bumptech.glide.integration.webp.decoder.ByteBufferWebpDecoder
import com.bumptech.glide.load.Options as GlideOptions
import java.nio.ByteBuffer
import kotlinx.coroutines.runInterruptible

/** Adds animated WebP decoding to Coil on Android versions without ImageDecoder. */
internal class LegacyAnimatedWebpDecoder : Decoder.Factory {
    override fun create(result: SourceFetchResult, options: Options, imageLoader: ImageLoader): Decoder? {
        val source = result.source.source()
        val headerSize = WebpHeaderParser.MAX_WEBP_HEADER_SIZE.toLong()
        if (!source.request(headerSize)) return null
        val header = source.peek().readByteArray(headerSize)
        if (!WebpHeaderParser.isAnimatedWebpType(WebpHeaderParser.getType(header))) return null

        return Decoder {
            runInterruptible {
                val width = decodeSize(options.size.width, options.maxBitmapSize.width)
                val height = decodeSize(options.size.height, options.maxBitmapSize.height)
                val bytes = ByteBuffer.wrap(source.readByteArray())
                val resource = checkNotNull(ByteBufferWebpDecoder(options.context).decode(bytes, width, height, GlideOptions()))
                DecodeResult(resource.get().asImage(), isSampled = true)
            }
        }
    }

    private fun decodeSize(requested: Dimension, maximum: Dimension): Int {
        val requestedPixels = (requested as? Dimension.Pixels)?.px ?: Int.MAX_VALUE
        val maximumPixels = (maximum as? Dimension.Pixels)?.px ?: Int.MAX_VALUE
        return minOf(requestedPixels, maximumPixels)
    }
}
