package ink.ptms.adyeshach.common.util.serializer.type

import ink.ptms.adyeshach.common.util.serializer.SerializerType
import com.google.gson.*
import ink.ptms.adyeshach.common.bukkit.data.VectorNull
import taboolib.common.util.Vector
import java.lang.reflect.Type

/**
 * @Author sky
 * @Since 2020-08-20 20:10
 */
@SerializerType(baseClass = Vector::class)
class TypePosition : JsonSerializer<Vector>, JsonDeserializer<Vector> {

    override fun serialize(a: Vector, p1: Type, p2: JsonSerializationContext): JsonElement {
        return JsonObject().run {
            addProperty("x", a.x)
            addProperty("y", a.y)
            addProperty("z", a.z)
            addProperty("empty", a is VectorNull)
            this
        }
    }

    override fun deserialize(a: JsonElement, p1: Type?, p2: JsonDeserializationContext): Vector {
        return if (a.asJsonObject.get("empty").asBoolean) {
            VectorNull()
        } else {
            Vector(
                    a.asJsonObject.get("x").asInt,
                    a.asJsonObject.get("y").asInt,
                    a.asJsonObject.get("z").asInt
            )
        }
    }
}