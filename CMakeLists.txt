cmake_minimum_required(VERSION 3.12)
project(scanner LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

if(APPLE)
    include_directories(/usr/local/include/antlr4-runtime)
    # 设置 flex 路径
    set(FLEX_HINT_PATHS /usr/local/opt/flex /opt/homebrew/opt/flex)

    # 查找 flex 的 include 目录
    find_path(FLEX_INCLUDE_DIR NAMES location.hh PATHS ${FLEX_HINT_PATHS} PATH_SUFFIXES include)
    find_library(FLEX_LIB NAMES fl PATHS ${FLEX_HINT_PATHS} PATH_SUFFIXES lib)

    if(FLEX_INCLUDE_DIR)
        include_directories(${FLEX_INCLUDE_DIR})
        message(STATUS "找到 Flex 头文件目录: ${FLEX_INCLUDE_DIR}")
    endif()

    if(FLEX_LIB)
        message(STATUS "找到 Flex 库: ${FLEX_LIB}")
    else()
        message(WARNING "未找到 Flex 库，尝试使用系统默认路径")
    endif()
    # 设置 bison 路径
    set(BISON_HINT_PATHS /usr/local/opt/bison /opt/homebrew/opt/bison)

    # 查找 bison 的 include 目录
    find_path(BISON_INCLUDE_DIR NAMES location.hh PATHS ${BISON_HINT_PATHS} PATH_SUFFIXES include)
    find_library(BISON_LIB NAMES y PATHS ${BISON_HINT_PATHS} PATH_SUFFIXES lib)

    if(BISON_INCLUDE_DIR)
        include_directories(${BISON_INCLUDE_DIR})
        message(STATUS "找到 Bison 头文件目录: ${BISON_INCLUDE_DIR}")
    endif()

    if(BISON_LIB)
        message(STATUS "找到 Bison 库: ${BISON_LIB}")
    else()
        message(WARNING "未找到 Bison 库，尝试使用系统默认路径")
    endif()

    # 设置编译器标志
    set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -L/usr/local/opt/bison/lib")
    set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -L/usr/local/opt/flex/lib")
    set(CMAKE_EXE_LINKER_FLAGS "${CMAKE_EXE_LINKER_FLAGS} -L/usr/local/opt/bison/lib -L/usr/local/opt/flex/lib")
    set(CMAKE_EXE_LINKER_FLAGS "${CMAKE_EXE_LINKER_FLAGS} -L/opt/homebrew/opt/flex/lib -L/opt/homebrew/opt/bison/lib")

elseif(UNIX AND NOT APPLE)
    message(STATUS "配置 Linux 环境")
    # Linux 下的配置
    # 通常 bison 会安装在标准路径，不需要特殊配置
    # 包含生成的头文件
endif()

# 查找必需的库 (对应 LIBS += -lantlr4-runtime)
find_library(ANTLR4_LIB NAMES antlr4-runtime REQUIRED)

# 设置目标可执行文件名称 (对应 target=scanner)
set(TARGET_NAME scanner)

# 设置源文件列表 (对应 objs=SysyBaseListener.o ... 转换为其对应的.cpp文件)
set(SOURCES
        generated/SysyBaseListener.cpp
        generated/SysyBaseVisitor.cpp
        generated/SysyLexer.cpp
        generated/SysyListener.cpp
        generated/SysyParser.cpp
        generated/SysyVisitor.cpp
        generated/main.cpp
)

# 创建可执行目标 (对应 main:$(objs))
add_executable(${TARGET_NAME} ${SOURCES})

# 链接库 (对应 $(LIBS) 即 -lantlr4-runtime)
target_link_libraries(${TARGET_NAME} PRIVATE ${ANTLR4_LIB})