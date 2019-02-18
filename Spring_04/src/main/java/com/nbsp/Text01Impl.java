package com.nbsp;

public class Text01Impl implements Text01 {
    @Override
    public void saveAccount() {

        System.out.println("保存了用户.....");
    }

    @Override
    public void DindAll() {
        System.out.println("查询了用户.....");

    }

    @Override
    public int FinAccounId() {
        System.out.println("删除了用户.....");
        return 0;
    }
}
