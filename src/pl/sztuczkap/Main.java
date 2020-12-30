package pl.sztuczkap;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

/*        // przyklad z bledem NullPointerException
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
        }*/

        // ==========================================================

        String text = "Hello";
        String text2 = null;

        Optional<String> optional = Optional.of(text);
        optional.ifPresent(System.out::println);

        Optional<String> optional2 = Optional.ofNullable(text2);

        System.out.println(optional2.orElse("Hi"));  // przydatna do domyslnych wartosci

        System.out.println(optional2.orElseGet(() -> "Hi2")); // przekazujemy suppliera (roznica jest opoznione wywolanie)

        System.out.println(optional2.orElse(defaultValue()));

        System.out.println(optional2.orElseGet(defaultValue2()));

        //=============================

        // Supplier przyjmuje typ Optional
        Optional<String> optional3 = optional2.or(() -> Optional.of("HIII!"));

//        // tworzymy zmienna word do ktorej chcemy przypisac wartosc optionala
//        // chyba ze ten nie istnieje to  wrzucimy wartosc domyslana...
//        String word = optional2.orElseThrow(IllegalArgumentException::new);
//        System.out.println(word);
//

        optional2.ifPresentOrElse(success(), failure()); // zalążek programowania reaktywnego


        //=============================

    }

    // testujemy tworzac nowa metode
    private static String defaultValue() {
        System.out.println("Wywołanie");
        return "Hi!";
    }

    // przy orElseGet(defaultValue2())
    private static Supplier<String> defaultValue2() {
        return () -> {
            System.out.println("Wywołanie");
            return "Hi! Supplier";
        };

    }

    private static Consumer<String> success(){
        return text -> System.out.println(text);
    }

    private static Runnable failure(){
        return () -> System.out.println("optional is empty");
    }

}
