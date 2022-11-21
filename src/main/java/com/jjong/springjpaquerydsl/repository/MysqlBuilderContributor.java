package com.jjong.springjpaquerydsl.repository;

import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.spi.MetadataBuilderContributor;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.DoubleType;
import org.hibernate.type.LocalDateType;
import org.hibernate.type.StringType;

/**
 * create on 2022/11/16. create by IntelliJ IDEA.
 *
 * <p> 클래스 설명 </p>
 *
 * @author Jongsang Han(henry)
 * @version 1.0
 * @see
 * @since 1.0
 */
public class MysqlBuilderContributor implements MetadataBuilderContributor {

  @Override
  public void contribute(MetadataBuilder metadataBuilder) {
    metadataBuilder.applySqlFunction("JSON_EXTRACT", new StandardSQLFunction("JSON_EXTRACT", StringType.INSTANCE))
        .applySqlFunction("JSON_UNQUOTE", new StandardSQLFunction("JSON_UNQUOTE", StringType.INSTANCE))
        .applySqlFunction("STR_TO_DATE", new StandardSQLFunction("STR_TO_DATE", LocalDateType.INSTANCE))
        .applySqlFunction("MATCH_AGAINST", new SQLFunctionTemplate(DoubleType.INSTANCE, "MATCH (?1) AGAINST (?2 IN BOOLEAN MODE)"));
  }
}
