package io.github.t3wv.transformers;

import org.simpleframework.xml.transform.Transform;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NFSeLocalDateTimeTransformer implements Transform<LocalDateTime> {
    
    private static final DateTimeFormatter SIMPLE_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
    private static final DateTimeFormatter DATETIME_FORMATTER_2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    
    @Override
    public LocalDateTime read(final String data) {
        try {
            return LocalDateTime.parse(data, NFSeLocalDateTimeTransformer.DATETIME_FORMATTER);
        } catch (final Exception e) {
        	try {
            	return LocalDateTime.parse(data, NFSeLocalDateTimeTransformer.DATETIME_FORMATTER_2);
			} catch (Exception e2) {
	            return LocalDateTime.from(NFSeLocalDateTimeTransformer.SIMPLE_DATETIME_FORMATTER.parse(data));
			}
        }
    }
    
    @Override
    public String write(final LocalDateTime data) {
        return NFSeLocalDateTimeTransformer.SIMPLE_DATETIME_FORMATTER.format(data);
    }
}