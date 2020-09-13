package org.mcxiv.logic;


import org.util.annotations.SendField;

public class StrPack {
    @SendField
    String msg = "";

    public StrPack() {
    }

    public StrPack(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "org.mcxiv.logic.StrPack{" +
                "msg='" + msg + '\'' +
                '}';
    }

    public String getMsg() {
        return msg;
    }

}
