package io.github.t3wv.utils;

import io.github.t3wv.transformers.NFSeRegistryMatcher;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.transform.RegistryMatcher;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;

public class NFSePersister extends Persister {

    private final boolean strict;

    public NFSePersister() {
        this(true, new NFSeRegistryMatcher());
    }

    public NFSePersister(final boolean strict) {
        this(strict, new NFSeRegistryMatcher());
    }

    public NFSePersister(final boolean strict, RegistryMatcher registryMatcher) {
        super(new AnnotationStrategy(), registryMatcher, new Format(0));
        this.strict = strict;

    }

    @Override
    public <T> T read(Class<? extends T> type, String source) throws Exception {
        return super.read(type, source, this.strict);
    }

    @Override
    public <T> T read(Class<? extends T> type, File source) throws Exception {
        return super.read(type, source, this.strict);
    }

    @Override
    public <T> T read(Class<? extends T> type, InputStream source) throws Exception {
        return super.read(type, source, this.strict);
    }

    @Override
    public <T> T read(Class<? extends T> type, Reader source) throws Exception {
        return super.read(type, source, this.strict);
    }

    @Override
    public <T> T read(Class<? extends T> type, InputNode source) throws Exception {
        return super.read(type, source, this.strict);
    }

    @Override
    public <T> T read(T value, String source) throws Exception {
        return super.read(value, source, this.strict);
    }

    @Override
    public <T> T read(T value, File source) throws Exception {
        return super.read(value, source, this.strict);
    }

    @Override
    public <T> T read(T value, InputStream source) throws Exception {
        return super.read(value, source, this.strict);
    }

    @Override
    public <T> T read(T value, Reader source) throws Exception {
        return super.read(value, source, this.strict);
    }

    @Override
    public <T> T read(T value, InputNode source) throws Exception {
        return super.read(value, source, this.strict);
    }

    public boolean isStrict() {
        return strict;
    }

}