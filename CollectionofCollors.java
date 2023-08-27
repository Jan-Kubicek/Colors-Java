package org.example;

import java.util.ArrayList;

public interface CollectionofCollors {
    static ArrayList<Color> seznamBarev = new ArrayList<>();

    static void addCollor(Color color){
        seznamBarev.add(color);
    }
    static Color getCollor(int Index){
        return seznamBarev.get(Index);
    }


}
