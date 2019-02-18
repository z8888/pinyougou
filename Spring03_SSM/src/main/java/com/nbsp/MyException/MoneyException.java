package com.nbsp.MyException;

public class MoneyException extends  RuntimeException {
    public MoneyException() {
    }

    public MoneyException(String s) {
        super(s);
    }

    public MoneyException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public MoneyException(Throwable throwable) {
        super(throwable);
    }

    public MoneyException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
