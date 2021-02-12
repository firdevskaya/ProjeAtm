package projectucustr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Ucuslar extends Musteri {
  HashMap<String, String> ucuslar = new HashMap<String,String>();
    List<String> locations = new ArrayList<String>();
    List<String> ucusSaati = new ArrayList<String>();

   public List setLocations(){
        locations.add("Ankara");
        locations.add("Erzurum");
        locations.add("Istanbul");
        return locations;
    }
    public List setSaat(){
        ucusSaati.add("06:00");
        ucusSaati.add("09:00");
        ucusSaati.add("11:00");
        ucusSaati.add("18:00");
        ucusSaati.add("21:30");
        ucusSaati.add("23:20");
        return ucusSaati;
    }
    public HashMap setUcus(){
        setLocations();
        setSaat();
        ucuslar.put(locations.get(0) + "==>" + locations.get(1),ucusSaati.get(0));
        ucuslar.put(locations.get(1) + "==>" + locations.get(0),ucusSaati.get(1));
        ucuslar.put(locations.get(0) + "==>" + locations.get(2),ucusSaati.get(4));
        ucuslar.put(locations.get(2) + "==>" + locations.get(0),ucusSaati.get(0));
        ucuslar.put(locations.get(1) + "==>" + locations.get(2),ucusSaati.get(2));
        ucuslar.put(locations.get(2) + "==>" + locations.get(1),ucusSaati.get(5));
        return ucuslar;
    }
    public void ucusSec() {
        HashMap<String, String> onayliUcuslar = new HashMap<String, String>();
        setUcus();
        Scanner scan = new Scanner(System.in);
        char cikis = ' ';
        String nereden = "";
        String nereye = "";
        String tarih = "";
        char tekYon = ' ';
        while (cikis != 'q') {
            System.out.print("Lutfen tekyon icin '1', gidis-donus icin '2' tusuna basiniz ");
            tekYon = scan.next().charAt(0);
            System.out.print("Gidis nereden: ");
            nereden = scan.next();
            System.out.print("Gidis nereye: ");
            nereye = scan.next();
            System.out.println("Gidis Tarihi (yyyy/mm/dd)");
            tarih = scan.next();
            if (ucuslar.containsKey(nereden + "==>" + nereye)) {
                System.out.println("Gidis ucus bilgileriniz:" + nereden + "==>" + nereye + " Tarih:" + tarih + " Saat:" + ucuslar.get(nereden + "==>" + nereye));
                System.out.println("Onayliyor musunuz?(E/H)");
                char onay = scan.next().toLowerCase().charAt(0);
                if (onay == 'e') {
                    System.out.println("Gidis ucus bilgileriniz:" + nereden + "==>" + nereye + " Tarih:" + tarih + " Saat:" + ucuslar.get(nereden + "==>" + nereye));
                    System.out.println("Ucus Numaraniz: " + setUcusNo(nereden, nereye, tarih));
                    onayliUcuslar.put("Gidis Ucus No ", setUcusNo(nereden, nereye, tarih));
                } else if (onay == 'h') {
                    System.out.println("Seciminizi guncelleyebilirsiniz...");
                } else {
                    System.out.println("'E' veya 'H' den birini seciniz...");
                }
            }
            if (tekYon == '2') {
                String gecici = nereden;
                nereden = nereye;
                nereye = gecici;
                System.out.println("Donus Tarihi (yyyy/mm/dd)");
                tarih = scan.next();
            }
            if (ucuslar.containsKey(nereden + "==>" + nereye)) {
                System.out.println("Donus ucus bilgileriniz:" + nereden + "==>" + nereye + " Tarih:" + tarih + " Saat:" + ucuslar.get(nereden + "==>" + nereye));
                System.out.println("Onayliyor musunuz?(E/H)");
                char onay = scan.next().toLowerCase().charAt(0);
                if (onay == 'e') {
                    System.out.println("Donus ucus bilgileriniz:" + nereden + "==>" + nereye + " Tarih:" + tarih + " Saat:" + ucuslar.get(nereden + "==>" + nereye));
                    System.out.println("Ucus Numaraniz: " + setUcusNo(nereden, nereye, tarih));
                    onayliUcuslar.put("Donus Ucus No ", setUcusNo(nereden, nereye, tarih));
                } else if (onay == 'h') {
                    System.out.println("Seciminizi guncelleyebilirsiniz...");
                } else {
                    System.out.println("'E' veya 'H' den birini seciniz...");
                }
            }
            System.out.println("Ucus arama islemini durudurmak icin 'Q' tusuna basiniz");
            System.out.println("Ucus arama islemine devam etmek icin herhangi sayi giriniz");
            cikis = scan.next().toLowerCase().charAt(0);
        }
        System.out.println(onayliUcuslar);
    }
}

	

