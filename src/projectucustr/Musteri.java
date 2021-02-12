package projectucustr;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Musteri {
	 private String isim;
	    private String musteriId;
	    private static int musteriPassword = 3000;
	    private static int id = 1000;
	    private static int flightNo=9000;
	    Scanner scan = new Scanner(System.in);	    HashMap<String,String> isimId = new HashMap<String,String>();
	    HashMap<String,Integer> isimPwd = new HashMap<String,Integer>();

	    public String getIsim() {
	        return isim;
	    }
	    public void setIsim(String isim) {
	        this.isim = isim;
	    }
	    public String getMusteriId() {
	        return musteriId;
	    }
	    public void setMusteriId(String musteriId) {
	        id++;
	        String arr[] = getIsim().split(" ");
	        this.musteriId = "" + arr[0].charAt(0) + arr[1].charAt(0) + id;
	    }
	    public static int getMusteriPassword() {
	        return musteriPassword;
	    }
	    public static void setMusteriPassword(int musteriPassword) {
	        Musteri.musteriPassword = musteriPassword;
	    }
	    public static int getId() {
	        return id;
	    }
	    public static void setId(int id) {
	        Musteri.id = id;
	    }
	    public static int getFlightNo() {
	        return flightNo;
	    }
	    public static void setFlightNo(int flightNo) {
	        Musteri.flightNo = flightNo;
	    }

	    public void musteriEkle(){
	        isimId.put(getIsim(), getMusteriId());
	        isimPwd.put(getIsim(), getMusteriPassword());
	    }
	    public void signIn(){
	        do{
	            System.out.println("Musteri eklemek ister misiniz? (E/H)");
	            char onay = scan.next().toLowerCase().charAt(0);
	            if(onay=='h'){
	                break;
	            }else if(onay=='e'){
	                System.out.print("Lutfen tam isminizi giriniz: ");
	                scan.nextLine();
	                setIsim(scan.nextLine());
	                try {
	                    setMusteriId(musteriId);
	                    setMusteriPassword(++musteriPassword);
	                    musteriEkle();
	                }catch(ArrayIndexOutOfBoundsException e){
	                    System.out.println("Soy isminizi de girmelisiniz");
	                }
	            }else{
	                System.out.println("Lutfen 'E' veya 'H' harflerinden birini giriniz...");
	            }
	        }while(true);
	        System.out.println(isimId);
	        System.out.println(isimPwd);
	    }
	    public void updatePassword(){
	        int newPwd;
	        String musteriId = "";
	        String isim = "";
	        int varolanPassword = 0;
	        do{
	            System.out.println("Password olusturmak icin isminizi giriniz");
	            System.out.println("Password olusturmayi sonlandirmak icin 'Q' tusuna basiniz");
	            scan.nextLine();
	            isim = scan.nextLine();
	            if(isim.equalsIgnoreCase("Q")){
	                System.out.println("Guvenlik Uyarisi: Passwordunuz degistirilmemistir");
	                break;
	            }
	            System.out.println("Eski passwordunuzu giriniz");
	            int eskiPwd = 0;
	            try {
	                eskiPwd = scan.nextInt();
	            }catch(InputMismatchException e){
	                System.out.println("Password rakamlardan olusmali");
	            }
	            try{
	                varolanPassword = isimPwd.get(isim);
	            }catch(NullPointerException e){
	                varolanPassword = -1;
	            }
	            if(!(eskiPwd==varolanPassword)){
	                System.out.println("Passwordunuz veya isminiz gecersizdir");
	            }else {
	                System.out.println("Yeni passwordunuzu giriniz");
	                newPwd = scan.nextInt();
	                scan.nextLine();
	                isimPwd.put(isim,newPwd);
	                break;
	            }
	        }while(true);
	        if(!(varolanPassword==-1)) {
	            System.out.println(isim + " Password:" + isimPwd.get(isim));
	        }
	    }
	    public String setUcusNo(String nereden, String nereye, String tarih){
	        String ucusNo = "" + nereden.charAt(0) + nereye.charAt(0) + tarih.substring(2,4) + tarih.substring(5,7) + tarih.substring(8);
	        return ucusNo;
	    }
	}
