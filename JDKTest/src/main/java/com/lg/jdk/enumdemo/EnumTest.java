package com.lg.jdk.enumdemo;

import static com.lg.jdk.enumdemo.MsgStatus.DRAFT;

public class EnumTest {
    MsgStatus msgStatus;

    public EnumTest(MsgStatus msgStatus){
        this.msgStatus = msgStatus;
    }

    public void getMsg(){
        switch (msgStatus){
            case DRAFT:
                System.out.println("当前："+msgStatus+";上一个"+msgStatus.getLast()+";下一个"+msgStatus.getNext());
                break;
            case SENT:
                System.out.println("当前："+msgStatus+";上一个"+msgStatus.getLast()+";下一个"+msgStatus.getNext());
                break;
            case RECEIVED:
                System.out.println("当前："+msgStatus+";上一个"+msgStatus.getLast()+";下一个"+msgStatus.getNext());
                break;
            case VIEWED:
                System.out.println("当前："+msgStatus+";上一个"+msgStatus.getLast()+";下一个"+msgStatus.getNext());
                break;
            case DELETED:
                System.out.println("当前："+msgStatus+";上一个"+msgStatus.getLast()+";下一个"+msgStatus.getNext());
                break;
        }
    }

    public static void main(String[] args) {
//
        EnumTest enumTest1 = new EnumTest(MsgStatus.DRAFT);
        enumTest1.getMsg();
        EnumTest enumTest2 = new EnumTest(MsgStatus.SENT);
        enumTest2.getMsg();
        EnumTest enumTest3 = new EnumTest(MsgStatus.RECEIVED);
        enumTest3.getMsg();
        EnumTest enumTest4 = new EnumTest(MsgStatus.VIEWED);
        enumTest4.getMsg();
        EnumTest enumTest5 = new EnumTest(MsgStatus.DELETED);
        enumTest5.getMsg();

    }
}
