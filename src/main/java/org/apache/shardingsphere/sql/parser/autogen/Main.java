package org.apache.shardingsphere.sql.parser.autogen;

import org.antlr.v4.runtime.*;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

public class Main {
    public static void generateAllTokenMappings(Map<Integer, String> tokenNames) {
        Field[] fields = MySQLStatementLexer.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == int.class && java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                try {
                    int value = field.getInt(null);
                    tokenNames.put(value, field.getName());
                } catch (IllegalAccessException e) {
                    // 忽略无法访问的字段
                }
            }
        }
    }
    // 获取token类型名称的映射
    private static String getTokenTypeName(int type) {
        Map<Integer, String> tokenNames = new HashMap<>();
        generateAllTokenMappings(tokenNames);
        tokenNames.put(MySQLStatementLexer.BLOCK_COMMENT, "BLOCK_COMMENT");
        tokenNames.put(MySQLStatementLexer.INLINE_COMMENT, "INLINE_COMMENT");
        tokenNames.put(MySQLStatementLexer.AND_, "AND_");
        tokenNames.put(MySQLStatementLexer.OR_, "OR_");
        tokenNames.put(MySQLStatementLexer.NOT_, "NOT_");
        tokenNames.put(MySQLStatementLexer.TILDE_, "TILDE_");
        tokenNames.put(MySQLStatementLexer.VERTICAL_BAR_, "VERTICAL_BAR_");
        tokenNames.put(MySQLStatementLexer.AMPERSAND_, "AMPERSAND_");
        tokenNames.put(MySQLStatementLexer.SIGNED_LEFT_SHIFT_, "SIGNED_LEFT_SHIFT_");
        tokenNames.put(MySQLStatementLexer.SIGNED_RIGHT_SHIFT_, "SIGNED_RIGHT_SHIFT_");
        tokenNames.put(MySQLStatementLexer.CARET_, "CARET_");
        tokenNames.put(MySQLStatementLexer.MOD_, "MOD_");
        tokenNames.put(MySQLStatementLexer.COLON_, "COLON_");
        tokenNames.put(MySQLStatementLexer.PLUS_, "PLUS_");
        tokenNames.put(MySQLStatementLexer.MINUS_, "MINUS_");
        tokenNames.put(MySQLStatementLexer.ASTERISK_, "ASTERISK_");
        tokenNames.put(MySQLStatementLexer.SLASH_, "SLASH_");
        tokenNames.put(MySQLStatementLexer.BACKSLASH_, "BACKSLASH_");
        tokenNames.put(MySQLStatementLexer.DOT_, "DOT_");
        tokenNames.put(MySQLStatementLexer.DOT_ASTERISK_, "DOT_ASTERISK_");
        tokenNames.put(MySQLStatementLexer.SAFE_EQ_, "SAFE_EQ_");
        tokenNames.put(MySQLStatementLexer.DEQ_, "DEQ_");
        tokenNames.put(MySQLStatementLexer.EQ_, "EQ_");
        tokenNames.put(MySQLStatementLexer.NEQ_, "NEQ_");
        tokenNames.put(MySQLStatementLexer.GT_, "GT_");
        tokenNames.put(MySQLStatementLexer.GTE_, "GTE_");
        tokenNames.put(MySQLStatementLexer.LT_, "LT_");
        tokenNames.put(MySQLStatementLexer.LTE_, "LTE_");
        tokenNames.put(MySQLStatementLexer.POUND_, "POUND_");
        tokenNames.put(MySQLStatementLexer.LP_, "LP_");
        tokenNames.put(MySQLStatementLexer.RP_, "RP_");
        tokenNames.put(MySQLStatementLexer.LBE_, "LBE_");
        tokenNames.put(MySQLStatementLexer.RBE_, "RBE_");
        tokenNames.put(MySQLStatementLexer.LBT_, "LBT_");
        tokenNames.put(MySQLStatementLexer.RBT_, "RBT_");
        tokenNames.put(MySQLStatementLexer.COMMA_, "COMMA_");
        tokenNames.put(MySQLStatementLexer.DQ_, "DQ_");
        tokenNames.put(MySQLStatementLexer.SQ_, "SQ_");
        tokenNames.put(MySQLStatementLexer.BQ_, "BQ_");
        tokenNames.put(MySQLStatementLexer.QUESTION_, "QUESTION_");
        tokenNames.put(MySQLStatementLexer.AT_, "AT_");
        tokenNames.put(MySQLStatementLexer.SEMI_, "SEMI_");
        tokenNames.put(MySQLStatementLexer.ASSIGNMENT_, "ASSIGNMENT_");
        tokenNames.put(MySQLStatementLexer.JSON_SEPARATOR, "JSON_SEPARATOR");
        tokenNames.put(MySQLStatementLexer.JSON_UNQUOTED_SEPARATOR, "JSON_UNQUOTED_SEPARATOR");
        tokenNames.put(MySQLStatementLexer.WS, "WS");

        // 聚合函数
        tokenNames.put(MySQLStatementLexer.MAX, "MAX");
        tokenNames.put(MySQLStatementLexer.MIN, "MIN");
        tokenNames.put(MySQLStatementLexer.SUM, "SUM");
        tokenNames.put(MySQLStatementLexer.COUNT, "COUNT");
        tokenNames.put(MySQLStatementLexer.GROUP_CONCAT, "GROUP_CONCAT");

        // 函数
        tokenNames.put(MySQLStatementLexer.CAST, "CAST");
        tokenNames.put(MySQLStatementLexer.POSITION, "POSITION");
        tokenNames.put(MySQLStatementLexer.SUBSTRING, "SUBSTRING");
        tokenNames.put(MySQLStatementLexer.SUBSTR, "SUBSTR");
        tokenNames.put(MySQLStatementLexer.MID, "MID");
        tokenNames.put(MySQLStatementLexer.EXTRACT, "EXTRACT");
        tokenNames.put(MySQLStatementLexer.TRIM, "TRIM");
        tokenNames.put(MySQLStatementLexer.LAST_DAY, "LAST_DAY");

        // 算法和模式
        tokenNames.put(MySQLStatementLexer.TRADITIONAL, "TRADITIONAL");
        tokenNames.put(MySQLStatementLexer.TREE, "TREE");
        tokenNames.put(MySQLStatementLexer.MYSQL_MAIN, "MYSQL_MAIN");
        tokenNames.put(MySQLStatementLexer.MYSQL_ADMIN, "MYSQL_ADMIN");
        tokenNames.put(MySQLStatementLexer.INSTANT, "INSTANT");
        tokenNames.put(MySQLStatementLexer.INPLACE, "INPLACE");
        tokenNames.put(MySQLStatementLexer.COPY, "COPY");
        tokenNames.put(MySQLStatementLexer.UL_BINARY, "UL_BINARY");
        tokenNames.put(MySQLStatementLexer.AUTOCOMMIT, "AUTOCOMMIT");
        tokenNames.put(MySQLStatementLexer.REDO_LOG, "REDO_LOG");
        tokenNames.put(MySQLStatementLexer.DELIMITER, "DELIMITER");

        // 存储引擎
        tokenNames.put(MySQLStatementLexer.ARCHIVE, "ARCHIVE");
        tokenNames.put(MySQLStatementLexer.BLACKHOLE, "BLACKHOLE");
        tokenNames.put(MySQLStatementLexer.CSV, "CSV");
        tokenNames.put(MySQLStatementLexer.FEDERATED, "FEDERATED");
        tokenNames.put(MySQLStatementLexer.INNODB, "INNODB");
        tokenNames.put(MySQLStatementLexer.MEMORY, "MEMORY");
        tokenNames.put(MySQLStatementLexer.MRG_MYISAM, "MRG_MYISAM");
        tokenNames.put(MySQLStatementLexer.MYISAM, "MYISAM");
        tokenNames.put(MySQLStatementLexer.NDB, "NDB");
        tokenNames.put(MySQLStatementLexer.NDBCLUSTER, "NDBCLUSTER");
        tokenNames.put(MySQLStatementLexer.PERFORMANCE_SCHEMA, "PERFORMANCE_SCHEMA");
        tokenNames.put(MySQLStatementLexer.TOKUDB, "TOKUDB");

        // 关键字（按字母顺序补充部分重要关键字）
        tokenNames.put(MySQLStatementLexer.FOR_GENERATOR, "FOR_GENERATOR");
        tokenNames.put(MySQLStatementLexer.ACCESSIBLE, "ACCESSIBLE");
        tokenNames.put(MySQLStatementLexer.ACCOUNT, "ACCOUNT");
        tokenNames.put(MySQLStatementLexer.ACTION, "ACTION");
        tokenNames.put(MySQLStatementLexer.ACTIVE, "ACTIVE");
        tokenNames.put(MySQLStatementLexer.ADD, "ADD");
        tokenNames.put(MySQLStatementLexer.ADMIN, "ADMIN");
        tokenNames.put(MySQLStatementLexer.AFTER, "AFTER");
        tokenNames.put(MySQLStatementLexer.AGAINST, "AGAINST");
        tokenNames.put(MySQLStatementLexer.AGGREGATE, "AGGREGATE");
        tokenNames.put(MySQLStatementLexer.ALGORITHM, "ALGORITHM");
        tokenNames.put(MySQLStatementLexer.ALL, "ALL");
        tokenNames.put(MySQLStatementLexer.ALTER, "ALTER");
        tokenNames.put(MySQLStatementLexer.ALWAYS, "ALWAYS");
        tokenNames.put(MySQLStatementLexer.ANALYZE, "ANALYZE");
        tokenNames.put(MySQLStatementLexer.AND, "AND");
        tokenNames.put(MySQLStatementLexer.ANY, "ANY");
        tokenNames.put(MySQLStatementLexer.ARRAY, "ARRAY");
        tokenNames.put(MySQLStatementLexer.AS, "AS");
        tokenNames.put(MySQLStatementLexer.ASC, "ASC");
        tokenNames.put(MySQLStatementLexer.ASCII, "ASCII");
        tokenNames.put(MySQLStatementLexer.ASENSITIVE, "ASENSITIVE");
        tokenNames.put(MySQLStatementLexer.AT, "AT");
        tokenNames.put(MySQLStatementLexer.ATTRIBUTE, "ATTRIBUTE");
        tokenNames.put(MySQLStatementLexer.AUTOEXTEND_SIZE, "AUTOEXTEND_SIZE");
        tokenNames.put(MySQLStatementLexer.AUTHENTICATION, "AUTHENTICATION");
        tokenNames.put(MySQLStatementLexer.AUTO, "AUTO");
        tokenNames.put(MySQLStatementLexer.AUTO_INCREMENT, "AUTO_INCREMENT");
        tokenNames.put(MySQLStatementLexer.AVG, "AVG");
        tokenNames.put(MySQLStatementLexer.ASSIGN_GTIDS_TO_ANONYMOUS_TRANSACTIONS, "ASSIGN_GTIDS_TO_ANONYMOUS_TRANSACTIONS");
        tokenNames.put(MySQLStatementLexer.BIT_XOR, "BIT_XOR");
        tokenNames.put(MySQLStatementLexer.AVG_ROW_LENGTH, "AVG_ROW_LENGTH");

        // 继续补充其他关键字（由于数量很多，这里只展示部分，你可以按同样模式继续）
        tokenNames.put(MySQLStatementLexer.BACKUP, "BACKUP");
        tokenNames.put(MySQLStatementLexer.BEFORE, "BEFORE");
        tokenNames.put(MySQLStatementLexer.BERNOULLI, "BERNOULLI");
        tokenNames.put(MySQLStatementLexer.BEGIN, "BEGIN");
        tokenNames.put(MySQLStatementLexer.BETWEEN, "BETWEEN");
        tokenNames.put(MySQLStatementLexer.BIGINT, "BIGINT");
        tokenNames.put(MySQLStatementLexer.BINARY, "BINARY");
        tokenNames.put(MySQLStatementLexer.BINLOG, "BINLOG");
        tokenNames.put(MySQLStatementLexer.BIT, "BIT");
        tokenNames.put(MySQLStatementLexer.BLOB, "BLOB");
        tokenNames.put(MySQLStatementLexer.BLOCK, "BLOCK");
        tokenNames.put(MySQLStatementLexer.BOOL, "BOOL");
        tokenNames.put(MySQLStatementLexer.BOOLEAN, "BOOLEAN");
        tokenNames.put(MySQLStatementLexer.BOTH, "BOTH");
        tokenNames.put(MySQLStatementLexer.BTREE, "BTREE");
        tokenNames.put(MySQLStatementLexer.BUCKETS, "BUCKETS");
        tokenNames.put(MySQLStatementLexer.BULK, "BULK");
        tokenNames.put(MySQLStatementLexer.BY, "BY");
        tokenNames.put(MySQLStatementLexer.BYTE, "BYTE");
        tokenNames.put(MySQLStatementLexer.CACHE, "CACHE");
        tokenNames.put(MySQLStatementLexer.CALL, "CALL");
        tokenNames.put(MySQLStatementLexer.CASCADE, "CASCADE");
        tokenNames.put(MySQLStatementLexer.CASCADED, "CASCADED");
        tokenNames.put(MySQLStatementLexer.CASE, "CASE");

        // 数据类型
        tokenNames.put(MySQLStatementLexer.CHAR, "CHAR");
        tokenNames.put(MySQLStatementLexer.VARCHAR, "VARCHAR");
        tokenNames.put(MySQLStatementLexer.INT, "INT");
        tokenNames.put(MySQLStatementLexer.BIGINT, "BIGINT");
        tokenNames.put(MySQLStatementLexer.SMALLINT, "SMALLINT");
        tokenNames.put(MySQLStatementLexer.TINYINT, "TINYINT");
        tokenNames.put(MySQLStatementLexer.FLOAT, "FLOAT");
        tokenNames.put(MySQLStatementLexer.DOUBLE, "DOUBLE");
        tokenNames.put(MySQLStatementLexer.DECIMAL, "DECIMAL");
        tokenNames.put(MySQLStatementLexer.DATE, "DATE");
        tokenNames.put(MySQLStatementLexer.DATETIME, "DATETIME");
        tokenNames.put(MySQLStatementLexer.TIMESTAMP, "TIMESTAMP");
        tokenNames.put(MySQLStatementLexer.TIME, "TIME");
        tokenNames.put(MySQLStatementLexer.YEAR, "YEAR");
        tokenNames.put(MySQLStatementLexer.BLOB, "BLOB");
        tokenNames.put(MySQLStatementLexer.TEXT, "TEXT");
        tokenNames.put(MySQLStatementLexer.JSON, "JSON");

        // JSON函数
        tokenNames.put(MySQLStatementLexer.JSON_ARRAY, "JSON_ARRAY");
        tokenNames.put(MySQLStatementLexer.JSON_ARRAY_APPEND, "JSON_ARRAY_APPEND");
        tokenNames.put(MySQLStatementLexer.JSON_ARRAY_INSERT, "JSON_ARRAY_INSERT");
        tokenNames.put(MySQLStatementLexer.JSON_CONTAINS, "JSON_CONTAINS");
        tokenNames.put(MySQLStatementLexer.JSON_CONTAINS_PATH, "JSON_CONTAINS_PATH");
        tokenNames.put(MySQLStatementLexer.JSON_DEPTH, "JSON_DEPTH");
        tokenNames.put(MySQLStatementLexer.JSON_EXTRACT, "JSON_EXTRACT");
        tokenNames.put(MySQLStatementLexer.JSON_INSERT, "JSON_INSERT");
        tokenNames.put(MySQLStatementLexer.JSON_KEYS, "JSON_KEYS");
        tokenNames.put(MySQLStatementLexer.JSON_LENGTH, "JSON_LENGTH");
        tokenNames.put(MySQLStatementLexer.JSON_MERGE, "JSON_MERGE");
        tokenNames.put(MySQLStatementLexer.JSON_MERGE_PATCH, "JSON_MERGE_PATCH");
        tokenNames.put(MySQLStatementLexer.JSON_MERGE_PRESERVE, "JSON_MERGE_PRESERVE");
        tokenNames.put(MySQLStatementLexer.JSON_OBJECT, "JSON_OBJECT");
        tokenNames.put(MySQLStatementLexer.JSON_OVERLAPS, "JSON_OVERLAPS");
        tokenNames.put(MySQLStatementLexer.JSON_PRETTY, "JSON_PRETTY");
        tokenNames.put(MySQLStatementLexer.JSON_QUOTE, "JSON_QUOTE");
        tokenNames.put(MySQLStatementLexer.JSON_REMOVE, "JSON_REMOVE");
        tokenNames.put(MySQLStatementLexer.JSON_REPLACE, "JSON_REPLACE");
        tokenNames.put(MySQLStatementLexer.JSON_SCHEMA_VALID, "JSON_SCHEMA_VALID");
        tokenNames.put(MySQLStatementLexer.JSON_SCHEMA_VALIDATION_REPORT, "JSON_SCHEMA_VALIDATION_REPORT");
        tokenNames.put(MySQLStatementLexer.JSON_SEARCH, "JSON_SEARCH");
        tokenNames.put(MySQLStatementLexer.JSON_SET, "JSON_SET");
        tokenNames.put(MySQLStatementLexer.JSON_STORAGE_FREE, "JSON_STORAGE_FREE");
        tokenNames.put(MySQLStatementLexer.JSON_STORAGE_SIZE, "JSON_STORAGE_SIZE");
        tokenNames.put(MySQLStatementLexer.JSON_TYPE, "JSON_TYPE");
        tokenNames.put(MySQLStatementLexer.JSON_UNQUOTE, "JSON_UNQUOTE");
        tokenNames.put(MySQLStatementLexer.JSON_VALID, "JSON_VALID");

        // 字面量和标识符
        tokenNames.put(MySQLStatementLexer.FILESIZE_LITERAL, "FILESIZE_LITERAL");
        tokenNames.put(MySQLStatementLexer.SINGLE_QUOTED_TEXT, "SINGLE_QUOTED_TEXT");
        tokenNames.put(MySQLStatementLexer.DOUBLE_QUOTED_TEXT, "DOUBLE_QUOTED_TEXT");
        tokenNames.put(MySQLStatementLexer.BQUOTA_STRING, "BQUOTA_STRING");
        tokenNames.put(MySQLStatementLexer.NCHAR_TEXT, "NCHAR_TEXT");
        tokenNames.put(MySQLStatementLexer.UNDERSCORE_CHARSET, "UNDERSCORE_CHARSET");
        tokenNames.put(MySQLStatementLexer.NUMBER_, "NUMBER_");
        tokenNames.put(MySQLStatementLexer.INT_NUM_, "INT_NUM_");
        tokenNames.put(MySQLStatementLexer.FLOAT_NUM_, "FLOAT_NUM_");
        tokenNames.put(MySQLStatementLexer.DECIMAL_NUM_, "DECIMAL_NUM_");
        tokenNames.put(MySQLStatementLexer.HEX_DIGIT_, "HEX_DIGIT_");
        tokenNames.put(MySQLStatementLexer.BIT_NUM_, "BIT_NUM_");
        tokenNames.put(MySQLStatementLexer.IDENTIFIER_, "IDENTIFIER_");
        tokenNames.put(MySQLStatementLexer.IP_ADDRESS, "IP_ADDRESS");
        tokenNames.put(MySQLStatementLexer.NOT_SUPPORT_, "NOT_SUPPORT_");

        // 其他重要关键字
        tokenNames.put(MySQLStatementLexer.SELECT, "SELECT");
        tokenNames.put(MySQLStatementLexer.FROM, "FROM");
        tokenNames.put(MySQLStatementLexer.WHERE, "WHERE");
        tokenNames.put(MySQLStatementLexer.INSERT, "INSERT");
        tokenNames.put(MySQLStatementLexer.UPDATE, "UPDATE");
        tokenNames.put(MySQLStatementLexer.DELETE, "DELETE");
        tokenNames.put(MySQLStatementLexer.CREATE, "CREATE");
        tokenNames.put(MySQLStatementLexer.DROP, "DROP");
        tokenNames.put(MySQLStatementLexer.TABLE, "TABLE");
        tokenNames.put(MySQLStatementLexer.DATABASE, "DATABASE");
        tokenNames.put(MySQLStatementLexer.VIEW, "VIEW");
        tokenNames.put(MySQLStatementLexer.INDEX, "INDEX");
        tokenNames.put(MySQLStatementLexer.PROCEDURE, "PROCEDURE");
        tokenNames.put(MySQLStatementLexer.FUNCTION, "FUNCTION");
        tokenNames.put(MySQLStatementLexer.TRIGGER, "TRIGGER");
        tokenNames.put(MySQLStatementLexer.EVENT, "EVENT");
        tokenNames.put(MySQLStatementLexer.USER, "USER");
        tokenNames.put(MySQLStatementLexer.GRANT, "GRANT");
        tokenNames.put(MySQLStatementLexer.REVOKE, "REVOKE");
        tokenNames.put(MySQLStatementLexer.COMMIT, "COMMIT");
        tokenNames.put(MySQLStatementLexer.ROLLBACK, "ROLLBACK");
        tokenNames.put(MySQLStatementLexer.START, "START");
        tokenNames.put(MySQLStatementLexer.TRANSACTION, "TRANSACTION");

        String name = tokenNames.get(type);
        return name != null ? name : "UNKNOWN";
    }

    // 判断是否应该跳过该token
    private static boolean shouldSkipToken(int type) {
        return false;
    }

    // 判断是否是错误token
    private static boolean isErrorToken(int type) {
        return false; // 根据你的实际错误token类型调整
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Usage: java Main <input_file>");
            System.exit(1);
        }

        String inputFile = args[0];
        InputStream is = new FileInputStream(inputFile);

        try {
            // 创建输入流
            ANTLRInputStream input = new ANTLRInputStream(is);

            // 创建词法分析器
            MySQLStatementLexer lexer = new MySQLStatementLexer(input);

            // 移除默认的错误监听器
            lexer.removeErrorListeners();

            // 创建token流
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            tokens.fill();

            // 遍历所有token
            for (Token token : tokens.getTokens()) {
                int type = token.getType();
                String text = token.getText();
                int line = token.getLine();

                // 跳过空白字符和注释
                if (shouldSkipToken(type)) {
                    continue;
                }

                // 处理词法错误
                if (isErrorToken(type)) {
                    System.out.println("Lexical error - line " + line + " : " + text);
                    continue;
                }

                // 输出合法的token
                String typeName = getTokenTypeName(type);
                if (!"UNKNOWN".equals(typeName)) {
                    System.out.println(text + " : " + typeName);
                } else {
                    // 对于未知token，也按错误处理
                    System.out.println("UNKNOWN Lexical error - " + line + " : " + text);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        } finally {
            is.close();
        }
    }
}
