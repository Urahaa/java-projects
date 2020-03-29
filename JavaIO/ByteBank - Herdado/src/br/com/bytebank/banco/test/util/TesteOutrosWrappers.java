package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.List;

public class TesteOutrosWrappers {

    public static void main(String[] args) {

        Integer idadeRef = Integer.valueOf(29);//autoboxing
        System.out.println(idadeRef.doubleValue());//unboxing

        Double dRef = Double.valueOf(3.2);//autoboxing
        System.out.println(dRef.doubleValue());

        Boolean bRef = Boolean.TRUE;
        System.out.println(bRef.booleanValue());

        Number numero = Integer.valueOf(29);

        List<Number> lista = new ArrayList<>();
        lista.add(10);
        lista.add(32.6);
        lista.add(32.6f);

    }
}
