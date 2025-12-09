// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     ExercisesData data = Converter.fromJsonString(jsonString);

package com.apiverve.exercises.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static ExercisesData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(ExercisesData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(ExercisesData.class);
        writer = mapper.writerFor(ExercisesData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// ExercisesData.java

package com.apiverve.exercises.data;

import com.fasterxml.jackson.annotation.*;

public class ExercisesData {
    private long count;
    private String[] filteredOn;
    private Exercise[] exercises;

    @JsonProperty("count")
    public long getCount() { return count; }
    @JsonProperty("count")
    public void setCount(long value) { this.count = value; }

    @JsonProperty("filteredOn")
    public String[] getFilteredOn() { return filteredOn; }
    @JsonProperty("filteredOn")
    public void setFilteredOn(String[] value) { this.filteredOn = value; }

    @JsonProperty("exercises")
    public Exercise[] getExercises() { return exercises; }
    @JsonProperty("exercises")
    public void setExercises(Exercise[] value) { this.exercises = value; }
}

// Exercise.java

package com.apiverve.exercises.data;

import com.fasterxml.jackson.annotation.*;

public class Exercise {
    private String name;
    private String force;
    private String level;
    private String mechanic;
    private String equipment;
    private String[] instructions;
    private String muscle;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("force")
    public String getForce() { return force; }
    @JsonProperty("force")
    public void setForce(String value) { this.force = value; }

    @JsonProperty("level")
    public String getLevel() { return level; }
    @JsonProperty("level")
    public void setLevel(String value) { this.level = value; }

    @JsonProperty("mechanic")
    public String getMechanic() { return mechanic; }
    @JsonProperty("mechanic")
    public void setMechanic(String value) { this.mechanic = value; }

    @JsonProperty("equipment")
    public String getEquipment() { return equipment; }
    @JsonProperty("equipment")
    public void setEquipment(String value) { this.equipment = value; }

    @JsonProperty("instructions")
    public String[] getInstructions() { return instructions; }
    @JsonProperty("instructions")
    public void setInstructions(String[] value) { this.instructions = value; }

    @JsonProperty("muscle")
    public String getMuscle() { return muscle; }
    @JsonProperty("muscle")
    public void setMuscle(String value) { this.muscle = value; }
}