package io.github.t3wv.transformers;

import org.simpleframework.xml.transform.Transform;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class NFSeBigDecimalTransformer implements Transform<BigDecimal> {
        private final DecimalFormat formatter;

        public NFSeBigDecimalTransformer() {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.of("pt", "BR"));
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');

            formatter = new DecimalFormat("#,##0.00", symbols);
            formatter.setParseBigDecimal(true);
        }

        @Override
        public BigDecimal read(String value) throws Exception {
            return (BigDecimal) formatter.parse(value);
        }

        @Override
        public String write(BigDecimal value) throws Exception {
            return formatter.format(value);
        }
}
