#include <iostream>
#include <fstream>

#include "antlr4-runtime.h"
#include "SysyLexer.h"
#include "SysyParser.h"
#include "main.h"

using namespace antlr4;

// 假设你的词法规则中定义了以下token类型（根据实际情况调整）
std::string getTokenTypeName(int type) {
    static std::unordered_map<int, std::string> tokenNames = {
        {SysyLexer::INT, "INT"},
        {SysyLexer::FLOAT, "FLOAT"},
        {SysyLexer::RETURN, "RETURN"},
        {SysyLexer::ID, "ID"},
        {SysyLexer::INT_LIT, "INT_LIT"},
        {SysyLexer::FLOAT_LIT, "FLOAT_LIT"},
        {SysyLexer::LP, "LP"},
        {SysyLexer::RP, "RP"},
        {SysyLexer::LC, "LC"},
        {SysyLexer::RC, "RC"},
        {SysyLexer::COMMA, "COMMA"},
        {SysyLexer::SEMICOLON, "SEMICOLON"},
        {SysyLexer::ASSIGN, "ASSIGN"},
        {SysyLexer::ADD, "ADD"}
        // 添加其他token类型的映射...
    };

    auto it = tokenNames.find(type);
    if (it != tokenNames.end()) {
        return it->second;
    }
    return "UNKNOWN";
}

bool shouldSkipToken(int type) {
    // 跳过空白字符和注释
    return type == SysyLexer::WS ||
           type == SysyLexer::LINE_COMMENT ||
           type == SysyLexer::BLOCK_COMMENT ||
           type == antlr4::Token::EOF;
}

bool isErrorToken(int type) {
    // 假设你的词法分析器会将词法错误标记为特定类型
    // 比如不合法的整数（以0开头的八进制但包含8、9）
    return type == SysyLexer::ERROR_TOKEN; // 根据你的实际错误token类型调整
}

int main(int argc, const char* argv[]) {
    if (argc < 2) {
        std::cerr << "Usage: " << argv[0] << " <input_file>" << std::endl;
        return 1;
    }

    std::ifstream stream;
    stream.open(argv[1]);
    if (!stream.is_open()) {
        std::cerr << "Cannot open file: " << argv[1] << std::endl;
        return 1;
    }

    ANTLRInputStream input(stream);
    //ANTLRInputStream input(std::cin);
    SysyLexer lexer(&input);

    // 移除默认的错误监听器，使用自定义错误处理
    lexer.removeErrorListeners();

    CommonTokenStream tokens(&lexer);

    try {
        tokens.fill();

        for (auto token : tokens.getTokens()) {
            int type = token->getType();
            std::string text = token->getText();
            int line = token->getLine();

            // 跳过空白字符和注释
            if (shouldSkipToken(type)) {
                continue;
            }

            // 处理词法错误
            if (isErrorToken(type)) {
                std::cout << "Lexical error - " << line << " : " << text << std::endl;
                continue;
            }

            // 输出合法的token
            std::string typeName = getTokenTypeName(type);
            if (typeName != "UNKNOWN") {
                std::cout << text << " : " << typeName << std::endl;
            } else {
                // 对于未知token，也按错误处理
                std::cout << "Lexical error - " << line << " : " << text << std::endl;
            }
        }

    } catch (std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
        return 1;
    }

    return 0;
}