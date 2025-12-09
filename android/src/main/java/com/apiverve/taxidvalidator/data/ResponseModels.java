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
//     TaxIDValidatorData data = Converter.fromJsonString(jsonString);

package com.apiverve.taxidvalidator.data;

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

    public static TaxIDValidatorData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(TaxIDValidatorData obj) throws JsonProcessingException {
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
        reader = mapper.readerFor(TaxIDValidatorData.class);
        writer = mapper.writerFor(TaxIDValidatorData.class);
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

// TaxIDValidatorData.java

package com.apiverve.taxidvalidator.data;

import com.fasterxml.jackson.annotation.*;

public class TaxIDValidatorData {
    private boolean valid;
    private String taxid;
    private String type;
    private String typeFull;
    private String format;
    private String normalized;
    private String digitsOnly;
    private String masked;
    private String last4;
    private ValidationDetails validationDetails;
    private Object error;

    @JsonProperty("valid")
    public boolean getValid() { return valid; }
    @JsonProperty("valid")
    public void setValid(boolean value) { this.valid = value; }

    @JsonProperty("taxid")
    public String getTaxid() { return taxid; }
    @JsonProperty("taxid")
    public void setTaxid(String value) { this.taxid = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("type_full")
    public String getTypeFull() { return typeFull; }
    @JsonProperty("type_full")
    public void setTypeFull(String value) { this.typeFull = value; }

    @JsonProperty("format")
    public String getFormat() { return format; }
    @JsonProperty("format")
    public void setFormat(String value) { this.format = value; }

    @JsonProperty("normalized")
    public String getNormalized() { return normalized; }
    @JsonProperty("normalized")
    public void setNormalized(String value) { this.normalized = value; }

    @JsonProperty("digits_only")
    public String getDigitsOnly() { return digitsOnly; }
    @JsonProperty("digits_only")
    public void setDigitsOnly(String value) { this.digitsOnly = value; }

    @JsonProperty("masked")
    public String getMasked() { return masked; }
    @JsonProperty("masked")
    public void setMasked(String value) { this.masked = value; }

    @JsonProperty("last4")
    public String getLast4() { return last4; }
    @JsonProperty("last4")
    public void setLast4(String value) { this.last4 = value; }

    @JsonProperty("validation_details")
    public ValidationDetails getValidationDetails() { return validationDetails; }
    @JsonProperty("validation_details")
    public void setValidationDetails(ValidationDetails value) { this.validationDetails = value; }

    @JsonProperty("error")
    public Object getError() { return error; }
    @JsonProperty("error")
    public void setError(Object value) { this.error = value; }
}

// ValidationDetails.java

package com.apiverve.taxidvalidator.data;

import com.fasterxml.jackson.annotation.*;

public class ValidationDetails {
    private boolean formatValid;
    private boolean areaNumberValid;
    private boolean groupNumberValid;
    private boolean serialNumberValid;

    @JsonProperty("format_valid")
    public boolean getFormatValid() { return formatValid; }
    @JsonProperty("format_valid")
    public void setFormatValid(boolean value) { this.formatValid = value; }

    @JsonProperty("area_number_valid")
    public boolean getAreaNumberValid() { return areaNumberValid; }
    @JsonProperty("area_number_valid")
    public void setAreaNumberValid(boolean value) { this.areaNumberValid = value; }

    @JsonProperty("group_number_valid")
    public boolean getGroupNumberValid() { return groupNumberValid; }
    @JsonProperty("group_number_valid")
    public void setGroupNumberValid(boolean value) { this.groupNumberValid = value; }

    @JsonProperty("serial_number_valid")
    public boolean getSerialNumberValid() { return serialNumberValid; }
    @JsonProperty("serial_number_valid")
    public void setSerialNumberValid(boolean value) { this.serialNumberValid = value; }
}