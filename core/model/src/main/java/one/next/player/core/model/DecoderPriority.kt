package one.next.player.core.model

enum class DecoderPriority {
    DEVICE_ONLY,
    PREFER_DEVICE,
    PREFER_APP,
}

fun DecoderPriority.next(): DecoderPriority = when (this) {
    DecoderPriority.DEVICE_ONLY -> DecoderPriority.PREFER_DEVICE
    DecoderPriority.PREFER_DEVICE -> DecoderPriority.PREFER_APP
    DecoderPriority.PREFER_APP -> DecoderPriority.DEVICE_ONLY
}
