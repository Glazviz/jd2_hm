package it.academy.util;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import java.util.Locale;

public class PhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    @Override
    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment context) {
        return super.toPhysicalCatalogName(toSnakeCase(name), context);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        return super.toPhysicalColumnName(toSnakeCase(name), context);
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment context) {
        return super.toPhysicalSchemaName(toSnakeCase(name), context);
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment context) {
        return super.toPhysicalSequenceName(toSnakeCase(name), context);
    }

    private final static String POSTFIX = "TBL_";

    @Override
    public Identifier toPhysicalTableName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
        if (identifier == null) {
            return null;
        }

        final String newName = (POSTFIX + identifier.getText()).toUpperCase();
        return Identifier.toIdentifier(newName.toUpperCase());
    }


    private Identifier toSnakeCase(Identifier id) {
        if (id == null)
            return id;

        String name = id.getText();
        String snakeName = name.replaceAll("([a-z]+)([A-Z]+)", "$1\\_$2").toUpperCase();
        if (!snakeName.equals(name))
            return new Identifier(snakeName, id.isQuoted());
        else
            return id;
    }


}
