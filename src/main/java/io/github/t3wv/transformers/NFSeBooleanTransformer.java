package io.github.t3wv.transformers;

import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.transform.Transform;

import java.util.List;

public class NFSeBooleanTransformer implements Transform<Boolean> {
    private static final List<String> TRUE_VALUES = List.of("1", "true", "yes", "s","sim", "verdadeiro");
    private static final List<String> FALSE_VALUES = List.of("0", "false", "no", "n","nao", "não", "falso");

    @Override
    public Boolean read(String value) {
        if (StringUtils.isNotBlank(value)) {
            String trimmedValue = value.trim().toLowerCase();
            if (TRUE_VALUES.contains(trimmedValue)) {
                return true;
            } else if (FALSE_VALUES.contains(trimmedValue)) {
                return false;
            }
        }
        return null;
    }

    @Override
    public String write(Boolean value) {
        return value ? "1" : "0";
    }
}
