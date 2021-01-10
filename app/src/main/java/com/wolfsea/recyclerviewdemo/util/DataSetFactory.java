package com.wolfsea.recyclerviewdemo.util;
import com.wolfsea.recyclerviewdemo.bean.LocalRvData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public static List<String> createLetters(int itemCount) {

        List<String> letterList = new ArrayList<>();

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

            int itemCount = RANDOM.nextInt(25) + 5;
            List<String> letters = createLetters(itemCount);
            lettersList.add(letters);
        }

        return lettersList;
    }

    public static List<List<String>> createLettersList(int length) {

        List<List<String>> lettersList = new ArrayList<>();

        for (int i = 0; i < length; i++) {

            int itemCount = RANDOM.nextInt(25) + 5;
            List<String> letters = createLetters(itemCount);
            lettersList.add(letters);
        }

        return lettersList;
    }

    public static List<String> createTitles() {

        return Arrays.asList(TITLES);
    }

    public static List<String> createTitles(int itemCount) {

        String[] subStr = new String[itemCount];
        if (itemCount >= 0) {
            System.arraycopy(TITLES, 0, subStr, 0, itemCount);
        }
        return Arrays.asList(subStr);
    }

    public static Map<String, String> createDataSet() {

        Map<String, String> dataSet = new HashMap<>();
        final int LENGTH = TITLES.length;
        List<String> letterList = createLetters(LENGTH);

        for (int i = 0; i < LENGTH; i++) {

            String key = letterList.get(i);
            String value = TITLES[i];
            dataSet.put(key, value);
        }

        return dataSet;
    }

    public static List<LocalRvData> getDataSet() {

        List<LocalRvData> localRvDataList = new ArrayList<>();
        final int LENGTH = TITLES.length;
        List<String> letterList = createLetters(LENGTH);

        for (int i = 0; i < LENGTH; i++) {

            String key = letterList.get(i);
            String value = TITLES[i];
            LocalRvData localRvData = new LocalRvData(key, value);
            localRvDataList.add(localRvData);
        }

        return localRvDataList;
    }


}
