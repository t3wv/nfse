package io.github.t3wv.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Validador de documentos XML contra esquemas XSD (XML Schema Definition).
 * <p>
 * Esta classe fornece métodos para validar documentos XML contra um ou mais esquemas XSD,
 * permitindo verificar se um XML está em conformidade com as regras definidas nos esquemas.
 * </p>
 * <p>
 * A validação pode ser realizada de diferentes formas:
 * <ul>
 *   <li>Verificação simples de validade (retorna true/false)</li>
 *   <li>Validação com coleta detalhada de erros e avisos</li>
 * </ul>
 * </p>
 * <p>
 * O validador aceita XMLs em diferentes formatos: String, byte[], InputStream ou File.
 * </p>
 */
public class NFSeXmlValidator {

    private final Schema schema;

    /**
     * Constrói um validador XML a partir de um ou mais esquemas XSD fornecidos como Source.
     * <p>
     * Este construtor permite especificar múltiplos esquemas XSD que serão combinados
     * para validar o documento XML. Útil quando o XML referencia múltiplos namespaces
     * ou quando há dependências entre esquemas.
     * </p>
     *
     * @param xsd Um ou mais esquemas XSD como objetos Source. Pelo menos um deve ser fornecido.
     * @throws SAXException Se houver erro ao processar os esquemas XSD fornecidos.
     */
    public NFSeXmlValidator(final Source... xsd) throws SAXException {
        final var factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        this.schema = factory.newSchema(xsd);
    }

    /**
     * Constrói um validador XML a partir de um ou mais caminhos de arquivos XSD.
     * <p>
     * Este construtor é uma conveniência que aceita caminhos de arquivos como String
     * e os converte internamente para objetos Source.
     * </p>
     *
     * @param xsd Um ou mais caminhos de arquivos XSD. Pelo menos um deve ser fornecido.
     * @throws SAXException Se houver erro ao processar os esquemas XSD fornecidos.
     */
    public NFSeXmlValidator(final String... xsd) throws SAXException {
        this(Arrays.stream(xsd).map(StreamSource::new).toArray(StreamSource[]::new));
    }

    /**
     * Valida um documento XML fornecido como String.
     * <p>
     * Este método verifica se o XML fornecido está em conformidade com os esquemas XSD
     * configurados no construtor. Retorna true se o XML for válido, false caso contrário.
     * </p>
     * <p>
     * Se o XML for nulo ou vazio, uma exceção será lançada.
     * </p>
     *
     * @param xml O documento XML a ser validado como String.
     * @return true se o XML for válido conforme os esquemas XSD, false caso contrário.
     * @throws IllegalArgumentException Se o XML fornecido for nulo ou vazio.
     */
    public boolean isValid(final String xml) {
        assert StringUtils.isNotBlank(xml) : "XML não informado ou inválido";
        try (final var reader = new StringReader(xml)) {
            return isValid(new StreamSource(reader));
        }
    }

    /**
     * Valida um documento XML fornecido como array de bytes.
     * <p>
     * Este método verifica se o XML fornecido está em conformidade com os esquemas XSD
     * configurados no construtor. Retorna true se o XML for válido, false caso contrário.
     * </p>
     * <p>
     * Se o array de bytes for nulo, uma exceção será lançada.
     * Se houver erro de I/O ao processar o array, o método retorna false.
     * </p>
     *
     * @param xml O documento XML a ser validado como array de bytes.
     * @return true se o XML for válido conforme os esquemas XSD, false caso contrário.
     * @throws IllegalArgumentException Se o array de bytes fornecido for nulo.
     */
    public boolean isValid(final byte[] xml) {
        assert xml != null : "XML não informado ou inválido";
        try (final var byteArrayInputStream = new ByteArrayInputStream(xml)) {
            return isValid(new StreamSource(byteArrayInputStream));
        } catch (final IOException e) {
            return false;
        }
    }

    /**
     * Valida um documento XML fornecido como InputStream.
     * <p>
     * Este método verifica se o XML fornecido está em conformidade com os esquemas XSD
     * configurados no construtor. Retorna true se o XML for válido, false caso contrário.
     * </p>
     * <p>
     * <b>Nota:</b> O InputStream não será fechado por este método. É responsabilidade
     * do chamador fechar o stream após o uso.
     * </p>
     * <p>
     * Se o InputStream for nulo, uma exceção será lançada.
     * </p>
     *
     * @param xml O documento XML a ser validado como InputStream.
     * @return true se o XML for válido conforme os esquemas XSD, false caso contrário.
     * @throws IllegalArgumentException Se o InputStream fornecido for nulo.
     */
    public boolean isValid(final InputStream xml) {
        assert xml != null : "XML não informado ou inválido";
        return isValid(new StreamSource(xml));
    }

    /**
     * Valida um documento XML fornecido como File.
     * <p>
     * Este método verifica se o XML fornecido está em conformidade com os esquemas XSD
     * configurados no construtor. Retorna true se o XML for válido, false caso contrário.
     * </p>
     * <p>
     * Se o File for nulo, uma exceção será lançada.
     * </p>
     *
     * @param xml O arquivo XML a ser validado.
     * @return true se o XML for válido conforme os esquemas XSD, false caso contrário.
     * @throws IllegalArgumentException Se o File fornecido for nulo.
     */
    public boolean isValid(final File xml) {
        assert xml != null : "XML não informado ou inválido";
        return isValid(new StreamSource(xml));
    }

    /**
     * Valida um documento XML fornecido como Source.
     * <p>
     * Este é o método privado que realiza a validação efetiva contra o esquema XSD.
     * Todos os outros métodos isValid() converte seus parâmetros para Source e chamam este método.
     * </p>
     *
     * @param source A fonte do documento XML a ser validado.
     * @return true se o XML for válido conforme os esquemas XSD, false caso contrário.
     */
    private boolean isValid(final Source source) {
        try {
            schema.newValidator().validate(source);
            return true;
        } catch (final SAXException | IOException e) {
            return false;
        }
    }

    /**
     * Valida um documento XML fornecido como String e retorna uma lista detalhada de erros e avisos.
     * <p>
     * Este método realiza a validação do XML e coleta todos os erros e avisos encontrados
     * durante o processo. Diferente do método isValid(), este método fornece informações
     * detalhadas sobre os problemas encontrados.
     * </p>
     * <p>
     * O retorno é um Pair onde:
     * <ul>
     *   <li>Left: Lista de erros (exceções) encontrados durante a validação</li>
     *   <li>Right: Lista de avisos encontrados durante a validação</li>
     * </ul>
     * </p>
     * <p>
     * Cada erro/aviso é formatado com informações sobre linha, coluna e mensagem.
     * </p>
     * <p>
     * Se o XML for nulo ou vazio, uma exceção será lançada.
     * </p>
     *
     * @param xml O documento XML a ser validado como String.
     * @return Um Pair contendo listas de erros (left) e avisos (right) encontrados durante a validação.
     * As listas são imutáveis e podem estar vazias se não houver erros/avisos.
     * @throws IllegalArgumentException Se o XML fornecido for nulo ou vazio.
     * @throws Exception                Se houver erro durante a validação (ex: erro de I/O, XML malformado).
     */
    public Pair<List<String>, List<String>> validateAndGetErrors(final String xml) throws Exception {
        assert StringUtils.isNotBlank(xml) : "XML não informado ou inválido";
        try (final var reader = new StringReader(xml)) {
            return validateAndGetErrors(new StreamSource(reader));
        }
    }

    /**
     * Valida um documento XML fornecido como array de bytes e retorna uma lista detalhada de erros e avisos.
     * <p>
     * Este método realiza a validação do XML e coleta todos os erros e avisos encontrados
     * durante o processo. Diferente do método isValid(), este método fornece informações
     * detalhadas sobre os problemas encontrados.
     * </p>
     * <p>
     * O retorno é um Pair onde:
     * <ul>
     *   <li>Left: Lista de erros (exceções) encontrados durante a validação</li>
     *   <li>Right: Lista de avisos encontrados durante a validação</li>
     * </ul>
     * </p>
     * <p>
     * Cada erro/aviso é formatado com informações sobre linha, coluna e mensagem.
     * </p>
     * <p>
     * Se o array de bytes for nulo, uma exceção será lançada.
     * </p>
     *
     * @param xml O documento XML a ser validado como array de bytes.
     * @return Um Pair contendo listas de erros (left) e avisos (right) encontrados durante a validação.
     * As listas são imutáveis e podem estar vazias se não houver erros/avisos.
     * @throws IllegalArgumentException Se o array de bytes fornecido for nulo.
     * @throws Exception                Se houver erro durante a validação (ex: erro de I/O, XML malformado).
     */
    public Pair<List<String>, List<String>> validateAndGetErrors(final byte[] xml) throws Exception {
        assert xml != null : "XML não informado ou inválido";
        try (final var inputStream = new ByteArrayInputStream(xml)) {
            return validateAndGetErrors(new StreamSource(inputStream));
        }
    }

    /**
     * Valida um documento XML fornecido como InputStream e retorna uma lista detalhada de erros e avisos.
     * <p>
     * Este método realiza a validação do XML e coleta todos os erros e avisos encontrados
     * durante o processo. Diferente do método isValid(), este método fornece informações
     * detalhadas sobre os problemas encontrados.
     * </p>
     * <p>
     * O retorno é um Pair onde:
     * <ul>
     *   <li>Left: Lista de erros (exceções) encontrados durante a validação</li>
     *   <li>Right: Lista de avisos encontrados durante a validação</li>
     * </ul>
     * </p>
     * <p>
     * Cada erro/aviso é formatado com informações sobre linha, coluna e mensagem.
     * </p>
     * <p>
     * <b>Nota:</b> O InputStream não será fechado por este método. É responsabilidade
     * do chamador fechar o stream após o uso.
     * </p>
     * <p>
     * Se o InputStream for nulo, uma exceção será lançada.
     * </p>
     *
     * @param xml O documento XML a ser validado como InputStream.
     * @return Um Pair contendo listas de erros (left) e avisos (right) encontrados durante a validação.
     * As listas são imutáveis e podem estar vazias se não houver erros/avisos.
     * @throws IllegalArgumentException Se o InputStream fornecido for nulo.
     * @throws Exception                Se houver erro durante a validação (ex: erro de I/O, XML malformado).
     */
    public Pair<List<String>, List<String>> validateAndGetErrors(final InputStream xml) throws Exception {
        assert xml != null : "XML não informado ou inválido";
        return validateAndGetErrors(new StreamSource(xml));
    }

    /**
     * Valida um documento XML fornecido como File e retorna uma lista detalhada de erros e avisos.
     * <p>
     * Este método realiza a validação do XML e coleta todos os erros e avisos encontrados
     * durante o processo. Diferente do método isValid(), este método fornece informações
     * detalhadas sobre os problemas encontrados.
     * </p>
     * <p>
     * O retorno é um Pair onde:
     * <ul>
     *   <li>Left: Lista de erros (exceções) encontrados durante a validação</li>
     *   <li>Right: Lista de avisos encontrados durante a validação</li>
     * </ul>
     * </p>
     * <p>
     * Cada erro/aviso é formatado com informações sobre linha, coluna e mensagem.
     * </p>
     * <p>
     * Se o File for nulo, uma exceção será lançada.
     * </p>
     *
     * @param xml O arquivo XML a ser validado.
     * @return Um Pair contendo listas de erros (left) e avisos (right) encontrados durante a validação.
     * As listas são imutáveis e podem estar vazias se não houver erros/avisos.
     * @throws IllegalArgumentException Se o File fornecido for nulo.
     * @throws Exception                Se houver erro durante a validação (ex: erro de I/O, XML malformado).
     */
    public Pair<List<String>, List<String>> validateAndGetErrors(final File xml) throws Exception {
        assert xml != null : "XML não informado ou inválido";
        return validateAndGetErrors(new StreamSource(xml));
    }

    /**
     * Valida um documento XML fornecido como Source e retorna uma lista detalhada de erros e avisos.
     * <p>
     * Este é o método privado que realiza a validação efetiva com coleta de erros e avisos.
     * Todos os outros métodos validateAndGetErrors() convertem seus parâmetros para Source
     * e chamam este método.
     * </p>
     * <p>
     * Utiliza um ErrorHandler customizado (T3WXmlErrorHandler) para coletar todos os erros
     * e avisos encontrados durante a validação.
     * </p>
     *
     * @param xml A fonte do documento XML a ser validado.
     * @return Um Pair contendo listas de erros (left) e avisos (right) encontrados durante a validação.
     * As listas são imutáveis e podem estar vazias se não houver erros/avisos.
     * @throws Exception Se houver erro durante a validação (ex: erro de I/O, XML malformado).
     */
    private Pair<List<String>, List<String>> validateAndGetErrors(final Source xml) throws Exception {
        final var xsdErrorHandler = new T3WXmlErrorHandler();
        final var validator = schema.newValidator();
        validator.setErrorHandler(xsdErrorHandler);
        validator.validate(xml);

        return Pair.of(
                Collections.unmodifiableList(xsdErrorHandler.getExceptions()),
                Collections.unmodifiableList(xsdErrorHandler.getWarnings())
        );
    }

    /**
     * Classe interna que implementa ErrorHandler para coletar erros e avisos
     * durante a validação de documentos XML.
     * <p>
     * Esta classe mantém listas separadas para exceções (erros fatais e erros)
     * e avisos encontrados durante a validação. Cada erro/aviso é formatado
     * com informações sobre a linha, coluna e mensagem do problema.
     * </p>
     */
    private static class T3WXmlErrorHandler implements ErrorHandler {

        /**
         * Lista de exceções (erros) encontrados durante a validação.
         */
        private final List<String> exceptions;

        /**
         * Lista de avisos encontrados durante a validação.
         */
        private final List<String> warnings;

        /**
         * Constrói uma nova instância de T3WXmlErrorHandler.
         * <p>
         * Inicializa as listas de exceções e avisos como listas vazias.
         * </p>
         */
        public T3WXmlErrorHandler() {
            this.exceptions = new ArrayList<>();
            this.warnings = new ArrayList<>();
        }

        /**
         * Retorna a lista de avisos coletados durante a validação.
         *
         * @return Lista de mensagens de avisos.
         */
        public List<String> getWarnings() {
            return warnings;
        }

        /**
         * Retorna a lista de exceções (erros) coletados durante a validação.
         *
         * @return Lista de mensagens de erros.
         */
        public List<String> getExceptions() {
            return exceptions;
        }

        /**
         * Trata avisos encontrados durante a validação.
         * <p>
         * Adiciona o aviso formatado à lista de avisos.
         * </p>
         *
         * @param exception Exceção SAXParseException contendo informações sobre o aviso.
         */
        @Override
        public void warning(SAXParseException exception) {
            warnings.add(createMessage(exception));
        }

        /**
         * Trata erros encontrados durante a validação.
         * <p>
         * Adiciona o erro formatado à lista de exceções.
         * </p>
         *
         * @param exception Exceção SAXParseException contendo informações sobre o erro.
         */
        @Override
        public void error(SAXParseException exception) {
            exceptions.add(createMessage(exception));
        }

        /**
         * Trata erros fatais encontrados durante a validação.
         * <p>
         * Adiciona o erro fatal formatado à lista de exceções.
         * </p>
         *
         * @param exception Exceção SAXParseException contendo informações sobre o erro fatal.
         */
        @Override
        public void fatalError(SAXParseException exception) {
            exceptions.add(createMessage(exception));
        }

        private static String createMessage(final SAXParseException e) {
            return String.format("Line number: %s, Column number: %s. %s", e.getLineNumber(), e.getColumnNumber(), e.getMessage());
        }
    }
}
