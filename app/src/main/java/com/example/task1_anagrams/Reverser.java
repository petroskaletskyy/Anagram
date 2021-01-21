package com.example.task1_anagrams;

import android.text.Editable;
import android.text.TextUtils;

public class Reverser {

    public static String reverse(String str, String ignoredCharacters) {
        String[] arrayOfStrings = str.split(" ");
        for (int n = 0; n <= arrayOfStrings.length - 1; n++) {
            char[] arr = arrayOfStrings[n].toCharArray();
            for (int i = 0, j = arr.length - 1; i < j; ) {
                if (!ignoredCharactersCheck(arr[i], ignoredCharacters) && !ignoredCharactersCheck(arr[j], ignoredCharacters)) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                } else if (ignoredCharactersCheck(arr[i], ignoredCharacters)) {
                    i++;
                } else if (ignoredCharactersCheck(arr[j], ignoredCharacters)) {
                    j--;
                }
            }
            arrayOfStrings[n] = String.valueOf(arr);
        }
        return TextUtils.join(" ", arrayOfStrings);
    }

    public static boolean ignoredCharactersCheck(char ch, String ignoredCharacters) {
        boolean flag = false;

        char[] ignoredChars = ignoredCharacters.toCharArray();
        for (char element : ignoredChars) {
            if (element == ch) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}