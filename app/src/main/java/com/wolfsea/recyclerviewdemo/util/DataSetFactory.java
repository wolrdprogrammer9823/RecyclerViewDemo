package com.wolfsea.recyclerviewdemo.util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author liuliheng
 * @desc  数据集工厂
 * @time 2020/11/12  21:42
 **/
public class DataSetFactory {

    private static final Random RANDOM = new Random();

    private static final String[] CHARACTERS = {
            "A","B","C","D","E",
            "F","G", "H","I","J",
            "K","L", "M","N","O",
            "P","Q", "R","S","T",
            "U","V", "W","X","Y",
            "Z",
    };

    public static final String[] TITLES = {
        "小星星",
        "你笑起来真好看",
        "公子向北走",
        "你的酒馆对我打了烊",
        "渡我不渡她",
        "黎明前的黑暗",
        "狂浪",
        "怀念青春",
        "浪子回头",
        "缘分一道桥",
        "绿色",
        "可能否",
        "彩蝶飞飞",
        "最美的期待",
        "你的答案",
    };

    public static List<String> createLetters() {

        List<String> letterList = new ArrayList<>();

        int itemCount = RANDOM.nextInt(25) + 5;
        for (int i = 0; i < itemCount; i++) {

            int index = RANDOM.nextInt(CHARACTERS.length);
            String character = CHARACTERS[index];
            letterList.add(character);
        }

        return letterList;
    }

    public static List<List<String>> createLettersList() {

        List<List<String>> lettersList = new ArrayList<>();

        final int LENGTH = TITLES.length;

        for (int i = 0; i < LENGTH; i++) {

            List<String> letters = createLetters();
            lettersList.add(letters);
        }

        return lettersList;
    }

    public static List<String> createTitles() {

        return Arrays.asList(TITLES);
    }

}
