package io.github.t3wv.transformers;

import org.simpleframework.xml.transform.Transform;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class NFSeZonedDateTimeTransformer implements Transform<ZonedDateTime> {
    
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss[XXX]");
    
    @Override
    public ZonedDateTime read(final String data) {
        return ZonedDateTime.parse(data, NFSeZonedDateTimeTransformer.FORMATTER);
    }
    
    @Override
    public String write(final ZonedDateTime data) {
        return NFSeZonedDateTimeTransformer.FORMATTER.format(data);
    }
}