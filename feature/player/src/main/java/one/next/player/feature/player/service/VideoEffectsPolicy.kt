package one.next.player.feature.player.service

import one.next.player.core.model.DecoderPriority

// Media3 video effects 对 extension renderer 没有稳定兼容承诺。
internal fun shouldApplyVideoEffects(decoderPriority: DecoderPriority): Boolean = decoderPriority != DecoderPriority.PREFER_APP
