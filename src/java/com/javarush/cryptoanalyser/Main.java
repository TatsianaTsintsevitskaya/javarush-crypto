package com.javarush.cryptoanalyser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
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
        String DONE = "Файл зашифрован";

        String rusAlphabet = "абвгдеёжзиклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        String symbol = "\",.!?:;-\\/ ";
        String digits = "0123456789";
        String cryptoAlphabet = rusAlphabet + symbol + digits;

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int key = scanner.nextInt();
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        if (number == 1) {
            System.out.println(STR);
        }

        try (FileReader in = new FileReader(file1);
             BufferedReader reader = new BufferedReader(in)){
            while (reader.ready()) {
                String line = reader.readLine();
            }
            System.out.println(KEY);
        }
        System.out.println(WEY);

        try (FileReader in = new FileReader(file2);
             BufferedReader reader = new BufferedReader(in)){
            while(reader.ready()){
                String line1 = reader.readLine();
            }
        }

        char[] chars = cryptoAlphabet.toCharArray();
        String text = file2;
        char[] textChars = text.toCharArray();
        char[] result = new char[textChars.length];

        int keyA = key;
        int keyB = chars.length - keyA;
        for (int i = 0; i < textChars.length; i++) {
            char textChar = textChars[i];
            for (int j = 0; j < chars.length; j++) {
                char ch = chars[j];
                if (textChar == ch) {
                    result[i] = chars[(j + keyB) % chars.length];
                }
            }
        }
        System.out.println(DONE);
    }
}


