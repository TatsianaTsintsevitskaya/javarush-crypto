package com.javarush.cryptoanalyser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Выберите действие и введите его номер");
        System.out.println("1. Зашифровать текст в файле с помощью ключа");
        System.out.println("2. Расшифровать текст в файле с помощью ключа");
        System.out.println("3. Расшифровать текст в файле методом перебора ключа (брут-форс)");
        System.out.println("4. Расшифровать текст в файле методом статистического анализа");
        System.out.println("");
        System.out.println("Для выхода из программы введите exit");

        String STR = "Введите полный путь к файлу, содержимое которого хотите зашифровать";
        String KEY = "Введите ключ шифрования";
        String WEY = "Введите полный путь к файлу, в который хочешь записать зашифрованный текст";

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number == 1) {
            System.out.println(STR);
        }
    }
}


