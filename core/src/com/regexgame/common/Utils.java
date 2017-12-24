package com.regexgame.common;

import com.badlogic.gdx.utils.Array;

public class Utils {
    public static <T> Array<T> toArray(Iterable<T> list) {
        Array<T> result = new Array<>();
        list.forEach(t -> result.add(t));
        return result;
    }

}
