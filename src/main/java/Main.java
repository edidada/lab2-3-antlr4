import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.*;

public class Main {

    // 获取token类型名称的映射
    private static String getTokenTypeName(int type) {
        Map<Integer, String> tokenNames = new HashMap<>();
        tokenNames.put(SysyLexer.INT, "INT");
        tokenNames.put(SysyLexer.FLOAT, "FLOAT");
        tokenNames.put(SysyLexer.RETURN, "RETURN");
        tokenNames.put(SysyLexer.ID, "ID");
        tokenNames.put(SysyLexer.INT_LIT, "INT_LIT");
        tokenNames.put(SysyLexer.FLOAT_LIT, "FLOAT_LIT");
        tokenNames.put(SysyLexer.LP, "LP");
        tokenNames.put(SysyLexer.RP, "RP");
        tokenNames.put(SysyLexer.LC, "LC");
        tokenNames.put(SysyLexer.RC, "RC");
        tokenNames.put(SysyLexer.COMMA, "COMMA");
        tokenNames.put(SysyLexer.SEMICOLON, "SEMICOLON");
        tokenNames.put(SysyLexer.ASSIGN, "ASSIGN");
        tokenNames.put(SysyLexer.ADD, "ADD");
        // 添加其他token类型的映射...

        String name = tokenNames.get(type);
        return name != null ? name : "UNKNOWN";
    }

    // 判断是否应该跳过该token
    private static boolean shouldSkipToken(int type) {
        return type == SysyLexer.WS ||
                type == SysyLexer.LINE_COMMENT ||
                type == SysyLexer.BLOCK_COMMENT ||
                type == Token.EOF;
    }

    // 判断是否是错误token
    private static boolean isErrorToken(int type) {
        return type == SysyLexer.LEX_ERR; // 根据你的实际错误token类型调整
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
            SysyLexer lexer = new SysyLexer(input);

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
                    System.out.println("Lexical error - " + line + " : " + text);
                    continue;
                }

                // 输出合法的token
                String typeName = getTokenTypeName(type);
                if (!"UNKNOWN".equals(typeName)) {
                    System.out.println(text + " : " + typeName);
                } else {
                    // 对于未知token，也按错误处理
                    System.out.println("Lexical error - " + line + " : " + text);
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