package ink.ptms.adyeshach.common.entity.type

import ink.ptms.adyeshach.common.editor.Editors
import ink.ptms.adyeshach.common.entity.EntityTypes
import org.bukkit.entity.Fox

/**
 * @author sky
 * @date 2020/8/4 23:15
 */
class AdyFox : AdyEntityAgeable(EntityTypes.FOX) {

    init {
        /*
        1.16,1.15
        16 ->Tupe(0:red,1:snow)
        17 ->0x01 Is sitting
             0x02 Unused
             0x04 Is crouching
             0x08 Is interested
             0x10 Is pouncing
             0x20 Is sleeping
             0x40 Is faceplanted
             0x80 Is defending
        18 ->First UUID(in UUIDs NBT)?
        19 ->Second UUID(in UUIDs NBT)?
        1.14
        15 ->Tupe(0:red,1:snow)
        16 ->0x1101 Sitting
             0x02 Unused
             0x04 Crouching
             0x08 Unknown
             0x10 Unknown
             0x20 Sleeping
             0x40 Unknown
             0x80 Unknown
        17 ->First UUID(in UUIDs NBT)?
        18 ->Second UUID(in UUIDs NBT)?
        1.13,1.12,1.11,1.10,1.9
        null
         */
        registerMeta(at(11700 to 17, 11500 to 16, 11400 to 15), "type", Fox.Type.RED.ordinal)
                .from(Editors.enums(Fox.Type::class) { _, entity, meta, index, _ -> "/adyeshachapi edit int ${entity.uniqueId} ${meta.key} $index" })
                .display { _, entity, _ ->
                    Fox.Type.values()[entity.getMetadata("type")].name
                }.build()
        registerMetaByteMask(at(11700 to 18, 11500 to 17, 11400 to 16), "isSitting", 0x01, false)
        registerMetaByteMask(at(11700 to 18, 11500 to 17, 11400 to 16), "isCrouching", 0x04, false)
        registerMetaByteMask(at(11700 to 18, 11500 to 17), "isInterested", 0x08, false)
        registerMetaByteMask(at(11700 to 18, 11500 to 17), "isPouncing", 0x10, false)
        registerMetaByteMask(at(11700 to 18, 11500 to 17, 11400 to 16), "isSleeping", 0x20, false)
        registerMetaByteMask(at(11700 to 18, 11500 to 17), "isFaceplanted", 0x40, false)
        registerMetaByteMask(at(11700 to 18, 11500 to 17), "isDefending", 0x80.toByte(), false)
    }

    fun getType(): Fox.Type {
        return Fox.Type.values()[getMetadata("type")]
    }

    fun setType(type: Fox.Type) {
        setMetadata("type", type)
    }

    fun isSitting(): Boolean {
        return getMetadata("isSitting")
    }

    fun setSitting(value: Boolean) {
        return setMetadata("isSitting", value)
    }

    fun isCrouching(): Boolean {
        return getMetadata("isCrouching")
    }

    fun setCrouching(value: Boolean) {
        return setMetadata("isCrouching", value)
    }

    fun isInterested(): Boolean {
        return getMetadata("isInterested")
    }

    fun setInterested(value: Boolean) {
        return setMetadata("isInterested", value)
    }

    fun isPouncing(): Boolean {
        return getMetadata("isPouncing")
    }

    fun setPouncing(value: Boolean) {
        return setMetadata("isPouncing", value)
    }

    fun isSleeping(): Boolean {
        return getMetadata("isSleeping")
    }

    fun setSleeping(value: Boolean) {
        return setMetadata("isSleeping", value)
    }

    fun isFaceplanted(): Boolean {
        return getMetadata("isFaceplanted")
    }

    fun setFaceplanted(value: Boolean) {
        return setMetadata("isFaceplanted", value)
    }

    fun isDefending(): Boolean {
        return getMetadata("isDefending")
    }

    fun setDefending(value: Boolean) {
        return setMetadata("isDefending", value)
    }
}