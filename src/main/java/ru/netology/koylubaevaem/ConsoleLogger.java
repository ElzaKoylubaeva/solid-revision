package ru.netology.koylubaevaem;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String msg)  {
        System.out.println(msg);
    }
}
