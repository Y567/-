package com.gyy;

public interface GrammarHandler {
    //用来代替空符
    char NULL_WORD_CHAR = '☯';
    String NULL_WORD_STR = "☯";
    /**
     * 添加文法规则
     * @param k 非终结符
     * @param s 规则
     */
    void addGrammar(char k, String s);

    /**
     * 输入语句验证是否符合文法规则
     * @param s 被验证语句
     * @return 成功返回true
     */
    boolean isMatch(String s);

    /**
     * 添加文法完毕后初始化才可验证语句
     * @param firstK 启始非终结符
     */
    void init(char firstK);
}

