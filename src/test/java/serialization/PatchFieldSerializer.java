package serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import models.requests.UserPatchRequest.PatchField;

import java.io.IOException;

public class PatchFieldSerializer
        extends JsonSerializer<PatchField<?>> {

    @Override
    public void serialize(
            PatchField<?> field,
            JsonGenerator gen,
            SerializerProvider serializers) throws IOException {

        serializers.defaultSerializeValue(
                field.getValue(),
                gen
        );
    }

    @Override
    public boolean isEmpty(
            SerializerProvider provider,
            PatchField<?> field) {

        return field == null || !field.isDefined();
    }
}