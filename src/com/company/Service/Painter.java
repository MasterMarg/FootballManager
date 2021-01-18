package com.company.Service;

public class Painter {
    public enum Paint{
        ANSI_RESET("\u001B[0m"),
        ANSI_BOLD_RED("\u001B[31;1m"),
        ANSI_BOLD_BLUE("\u001B[34;1m");

        public final String color;

        Paint(String color){
            this.color = color;
        }
    }

    public static String getPainted(String string, Paint paint){
        return (paint.color+string+Paint.ANSI_RESET.color);
    }
}
