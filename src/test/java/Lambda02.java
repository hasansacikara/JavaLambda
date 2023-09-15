import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {


        List<Integer> sayilar = new ArrayList<>(Arrays.asList(6, 5, 8, 7, 4, 5, 8, 4, 2, 6, 6, 5, 4, 7, 8));

        // listedeki her elemanın küpünü alıp bir ekleyip sonucu yazdırın
        sayilarinKupuArtiBir(sayilar);

        // listedeki tek sayiların küpünü alıp iki çıkartın
        tekSayilarinKupuEksiIki(sayilar);

        // listedeki çift sayiların karekökünü yazdırın
        ciftSayiKarakokPrnt(sayilar);

        // max sayiyi bul
        maxSayiBul(sayilar);

        // elemanların toplamı
        butunToplam(sayilar);

        // cift sayilarin hepsinin carpimi
        ciftSayilariCarp(sayilar);


    }

    public static void ciftSayilariCarp(List<Integer> sayilar) {
        System.out.println("\nListedeki cift sayilarin carpimi");

        System.out.println("bütün sayilarin carpimi : " + sayilar
                .stream()
                .filter(Lambda01::ciftMi)
                .reduce(Math::multiplyExact));

        System.out.println("function kullanarak : "+sayilar
                .stream()
                .filter(Lambda01::ciftMi)
                .reduce(1,(a,b) -> (a*b)));


    }

    public static void butunToplam(List<Integer> sayilar) {
        System.out.println("\nListedeki bütün sayilarin toplami");

        System.out.println(sayilar
                .stream()
                .reduce(0, (a, b) -> a + b));

        Integer toplam = sayilar.stream().reduce(0, (a, b) -> a + b);
        System.out.println("genel toplam : "+toplam);

        System.out.println(sayilar.stream().reduce(Integer::sum));

    }

    public static void maxSayiBul(List<Integer> sayilar) {

        System.out.println("\nListedeki en büyük sayi");
        System.out.println(sayilar
                .stream()
                .reduce(Math::max));
        Optional<Integer> maxSayi = sayilar.stream().reduce(Math::max);

    }

    public static void ciftSayiKarakokPrnt(List<Integer> sayilar) {

        System.out.println("\nCift sayilarin karakökü");
        sayilar
                .stream()
                .filter(t -> t % 2 == 0)
                .map(Math::sqrt)
                .forEach(t -> System.out.print(t +" ") );
        /*
        reduce() ==> manası azaltmak olarak geçiyor. Sonucun tek tek elemamana inmesini istediğimiz durumlarda kullanılır
        mesela bütün sayıların toplamı
        bütün sayıların max, min, çarpımı
         */


    }

    public static void tekSayilarinKupuEksiIki(List<Integer> sayilar) {

        System.out.println("\nTek sayilarin kupu -2");
        sayilar
                .stream()
                .filter(t -> t % 2 != 0)
                .map(t -> (t * t * t) - 2)
                .forEach(Lambda01::yazdir);

    }

    public static void sayilarinKupuArtiBir(List<Integer> sayilar) {
        System.out.println("\nSayilarin kupu +1");
        sayilar
                .stream()
                .map(t -> (t * t * t) + 1)
                .forEach(Lambda01::yazdir);

    }
}
