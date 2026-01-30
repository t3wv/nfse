package io.github.t3wv.nfse.transformers;

import org.simpleframework.xml.transform.Transform;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class NFSeBigDecimalTransformer implements Transform<BigDecimal> {
        private final DecimalFormat formatter;

        public NFSeBigDecimalTransformer() {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.of("pt", "BR"));
            symbols.setDecimalSeparator(',');

            formatter = new DecimalFormat("#,##0.00", symbols);
            formatter.setParseBigDecimal(true);
            formatter.setGroupingUsed(false);
            formatter.setRoundingMode(RoundingMode.HALF_UP);
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
