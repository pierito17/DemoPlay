package com.demo.play.persistence.mapper;

import org.mapstruct.Named;

public class StateMapper {

    @Named("stringToState")
    public static boolean stringToState(String estado){
        if(estado.isBlank()) return false;

        return estado.equalsIgnoreCase("D");
    }

    @Named("stateToString")
    public static String stateToString(boolean state){
        if(state) return "D";
        else return "N";
    }
}
