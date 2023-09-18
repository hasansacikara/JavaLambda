import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Lambda04 {

   // pojo class içinde : constructor, variables, getter setter, toString()
    public static void main(String[] args) {

       //Universite u1 = new Universite();
       //Universite u1 = new Universite("Ktu","MakineMuh",571,93);
       //Universite u2 = new Universite("Bilkent","matematik",785,65);
       //Universite u3 = new Universite("İstanbul","hukuk",1445,71);
       //Universite u4 = new Universite("Marmara","Bilgisayar",1324,78);
       //Universite u5 = new Universite("yildiz","gemi",345,65);
       //Universite u1 = new Universite("Ktu", "MakineMuh", 571, 93);
       //Universite u2 = new Universite("Bilkent", "matematik", 785, 65);
       //Universite u3 = new Universite("İstanbul", "hukuk", 1445, 71);
       //Universite u4 = new Universite("Marmara", "Bilgisayar", 1324, 78);
       //Universite u5 = new Universite("yildiz", "gemi", 345, 65);

        List<Universite> unis = new ArrayList<>(Arrays.asList(u1,u2,u3,u4,u5));
        List<Universite> unis = new ArrayList<>(Arrays.asList(u1, u2, u3, u4, u5));

        // not ortalaması 74'ten büyük olan universiteleri yazdır
        notOrt74BuyukUniversiteler(unis);

        // bütün üniversitelerin not ortalaması 60'tan büyük mü
        butunUniversitelerNotOrtalamasiBuyuk60Mi(unis);


        // bütün üniversitelerin öğrenci sayısı 300 den fazla olmalı
        System.out.println(btnUniOgrSayisiMin300(unis));

        // üniversitelerimizde hukuk bölümü var mı
        System.out.println(universitlerdeHukukBolumuVarMi(unis));

        // bütün üniversiteli öğrenci sayısına göre b->k sıralayın
        System.out.println(ogrenciSayisinaGoreUniversiteler(unis));

        // bütün üniversiteli öğrenci sayısına göre b->k sıralayıp yazdıran method
        direkUniversiteleriOgrenciSayisinaGoreYazanProgram(unis);

        // not ortalaması en büyük üç üniversiteyi bulun
        System.out.println(notOrtalamasiEnBuyukUcUniversite(unis));

        // not ortalamasi en yüksek olan ikinci üniversiteyi print ediniz
        notOrtalamasiEnYuksekOlanIkinciUniversite(unis);

        // not ortalaması 70 üzerinde olan üniversitelerin toplam öğrenci sayisini print ediniz
        notOrtalamasiYetmisUstuUnivestielerinToplamOgrenciSayisi(unis);

        // // not ortalaması 70 üzerinde olan üniversitelerin toplam öğrenci sayisini print ediniz( bütün sayıların int olduğunu bildiğimiz zaman)
        notOrtalamasiYetmisUstuUnivestielerinToplamOgrenciSayisiToInt(unis);

        // ogrenci sayisi 600 den büyük olan universitelerin not ortalamalarının ortalamasını yazdırın
        ogrenciSayisi600denBuyukOlanUniOrtalamaNotOrtalamari(unis);

        // toplam kaç tane hukuk bölümü olduğunu print ediniz
        toplamKacAdedHukukBolumuVar(unis);
        // dinamik olarak farklı bölümler için arama yapmak istersek
        toplamKacBolumVar(unis , "makine");

        // ogrenci sayisi 600 den fazla olan universiteler içinde en yüksek not ortalamasını bulun
        ogrenciSayisi600denBuyukUniEnYuksekNotOrtalamasi(unis);

        // ogrenci sayisi 1000den az olan universtiler icinde en duşuk not ortalaması
        ogrenciSayisi1000DenKucukUniEnDusukNotOrtalamasi(unis);



    }

    public static void ogrenciSayisi1000DenKucukUniEnDusukNotOrtalamasi(List<Universite> unis) {

        System.out.println(unis
                .stream()
                .filter(t -> t.getOgrSayisi() < 1000)
                .mapToDouble(t -> t.getNotOrtalama())
                .min());
    }

    public static void ogrenciSayisi600denBuyukUniEnYuksekNotOrtalamasi(List<Universite> unis) {

        System.out.println(unis
                .stream()
                .filter(t -> t.getOgrSayisi() > 600)
                .mapToDouble(t -> t.getNotOrtalama())
                .max());
    }

    public static void toplamKacBolumVar(List<Universite> unis, String arananBolum) {

        System.out.println(unis
                .stream()
                .filter(t -> t.getBolum().toLowerCase().contains(arananBolum))
                .count());
    }

    public static void toplamKacAdedHukukBolumuVar(List<Universite> unis) {

        System.out.println(unis
                .stream()
                .filter(t -> t.getBolum().toLowerCase().contains("hukuk"))
                .count());

    }

    public static void ogrenciSayisi600denBuyukOlanUniOrtalamaNotOrtalamari(List<Universite> unis) {

        System.out.println(unis
                .stream()
                .filter(t -> t.getOgrSayisi() > 600)
                .mapToDouble(t -> t.getNotOrtalama())
                .average());

    }

    public static void notOrtalamasiYetmisUstuUnivestielerinToplamOgrenciSayisiToInt(List<Universite> unis) {

        System.out.println(unis
                .stream()
                .filter(t -> t.getNotOrtalama() > 70)
                .mapToInt(t -> t.getOgrSayisi())
                .sum());
    }

    public static void notOrtalamasiYetmisUstuUnivestielerinToplamOgrenciSayisi(List<Universite> unis) {
        System.out.println(unis
                .stream() // u1, u2, u3, u4, u5
                .filter(t -> t.getNotOrtalama() > 70) // u1, u3, u4
                .map(t -> t.getOgrSayisi()) //571, 1445, 1324
                .reduce(Integer::sum));
        //.reduce(Math::addExact));
        //.reduce(0, (t, u) -> t + u));
    }


    public static void notOrtalamasiEnYuksekOlanIkinciUniversite(List<Universite> unis) {

        System.out.println(unis
                .stream()
                .sorted(Comparator.comparing(Universite::getNotOrtalama).reversed())
                .map(t -> t.getUniName())
                .limit(2)
                .skip(1)
                .collect(Collectors.toList()));


    }


    public static List<String> notOrtalamasiEnBuyukUcUniversite(List<Universite> unis) {

        return unis
                .stream()
                .sorted(Comparator.comparing(Universite::getNotOrtalama).reversed())
                .map(t -> t.getUniName())
                .limit(3)
                .collect(Collectors.toList());


    }

    private static void direkUniversiteleriOgrenciSayisinaGoreYazanProgram(List<Universite> unis) {

        System.out.println(unis
                .stream()
                //.sorted(Comparator.comparing(Universite::getOgrSayisi).reversed())
                .sorted(Comparator.comparing(Universite::getOgrSayisi).reversed())
                .map(t -> t.getUniName())
                .limit(3) // en çok ögrenciye sahip 3 üniversite limiti
                .collect(Collectors.toList()));

    }

    public static List<String> ogrenciSayisinaGoreUniversiteler(List<Universite> unis) {

        return unis
                .stream()
                //.sorted(Comparator.comparing(Universite::getOgrSayisi).reversed())
                .sorted(Comparator.comparing(Universite::getOgrSayisi).reversed())
                .map(t -> t.getUniName())
                .limit(3) // en çok ögrenciye sahip 3 üniversite limiti
                .collect(Collectors.toList());


    }
    public static String btnUniOgrSayisiMin300(List<Universite> unis) {
//        return veri;


        return unis.stream().allMatch(t-> t.getOgrSayisi()>300 )
        return unis.stream().allMatch(t -> t.getOgrSayisi() > 300)
                ?
                "bütün üniversiteler beklentinin üstünde öğrenci sayısına sahip"
                :
         public static void butunUniversitelerNotOrtalamasiBuyuk60Mi(List<Universite> uni
        System.out.println("\nbütün üniversiteler not ortalaması kontrolu :");
        System.out.println(
                unis
                        .stream()
                        .allMatch(t -> t.getNotOrtalama() > 60)
                        ?
                        "bütün ünviversitelerin notu beklentinin üstünde"
                        :
                        "Hayal kırıklığı");
                        .stream()
                .allMatch(t -> t.getNotOrtalama() > 60)
                ?
                "bütün ünviversitelerin notu beklentinin üstünde"
                :
                "Hayal kırıklığı");

    }

    public static void notOrt74BuyukUniversiteler(List<Universite> unis) {
        System.out.println("\nNot ortalaması 74'ten büyük olan üniversite bilgileri");
        unis
                .stream()
                .filter(t -> t.getNotOrtalama()>74)
                .filter(t -> t.getNotOrtalama() > 74)
                .map(t -> t.getUniName())
                .forEach(t-> System.out.print(t + " "));

                .forEach(t -> System.out.print(t + " "));
    }
}