package com.javarush.cryptoanalyser;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.lang.System.in;

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

        Scanner scanner = new Scanner(in);
        int number = scanner.nextInt();
        if (number == 1) {
            System.out.println(STR);
        }

        Scanner scanner1 = new Scanner(in);
        String file1 = scanner1.nextLine();

        try (FileReader in = new FileReader(file1);
             BufferedReader reader = new BufferedReader(in)) {
            while (reader.ready()) {
                String line1 = reader.readLine();
            }
        }
        System.out.println(KEY);

        Scanner scanner2 = new Scanner(in);
        int key = scanner2.nextInt();

       // encrypt();
    }

    private static void encrypt(int key, String line1) {

        String rusAlphabet = "абвгдеёжзиклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        String symbol = "\",.!?:;-\\/ ";
        String digits = "0123456789";
        String cryptoAlphabet = rusAlphabet + symbol + digits;

        char[] chars = cryptoAlphabet.toCharArray();
        String text = line1;
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
        inFile();
    }

    public static void inFile() {
        String WEY = "Введите полный путь к файлу, в который хочешь записать зашифрованный текст";
        String DONE = "Файл зашифрован";
        String SECRET = "Введи полный путь к файлу, содержимое которого хочешь расшифровать";
        System.out.println(WEY);

        Scanner scanner3 = new Scanner(in);
        String file2 = scanner3.nextLine();
        try (BufferedWriter buff = new BufferedWriter(new FileWriter(file2))) {
     //       buff.write(file1);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(DONE);

        Scanner scanner = new Scanner(in);
        int number = scanner.nextInt();
        if (number == 2) {
            System.out.println(SECRET);
        }
       // bruteForce();
    }
        public static int bruteForce (String file2, String cryptoAlphabet){
            int lengthOfFile2 = file2.length();
            int lengthOfCryptoAlphabet = cryptoAlphabet.length();

            for (int i = 0; i < lengthOfFile2 - lengthOfCryptoAlphabet; i++) {

                int j;
                for (j = 0; j < lengthOfCryptoAlphabet; j++) {
                    if (file2.charAt(i + j) != cryptoAlphabet.charAt(j)) {
                        break;
                    }
                }
                if (j == lengthOfCryptoAlphabet) {
                    return i;
                }
            }
            return lengthOfFile2;
        }
    }






