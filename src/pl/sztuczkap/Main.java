package pl.sztuczkap;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        // przyklad z bledem NullPointerException
        String text = null;
        if (text != null) {  // standardowe sprawdzenie przy javie8
            System.out.println(text.length());
        }


        Optional<String> empty = Optional.empty();
//        Optional<String> optional = Optional.of(text);  // NullPointer Exception
        Optional<String> optional = Optional.ofNullable(text);
        System.out.println(optional.isPresent());
        System.out.println(optional.isEmpty());  // od javy 11

        // przyklad w petli
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }

    }
}
