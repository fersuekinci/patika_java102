import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("-----------------------------------");
        System.out.println("macera oyununa hoşgeldiniz ! ");
        System.out.println("-----------------------------------");
        System.out.print("lütfen bir isim seçiniz : ");
        String playerName = input.nextLine();

        Player player = new Player(playerName);
        System.out.println(player.getName() + " oyuna hoşgeldiniz");
        System.out.println("lütfen bir karakter seçiniz ");
        player.selectChar();

        Location location = null;
        while(true){
            player.printInfo();
            System.out.println();
            System.out.println("----------bölgeler-----------");
            System.out.println();
            System.out.println("1- güvenli ev");
            System.out.println("2- mağaza");
            System.out.println("3- mağaraya git");
            System.out.println("4- ormana git");
            System.out.println("5- nehire git");
            System.out.println("0- çıkış yap");
            System.out.println("-----------------------------------");
            System.out.print("lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLocation = input.nextInt();

            while (selectLocation < 0 || selectLocation > 5) {
                System.out.println("Geçersiz bölge seçtiniz. Lütfen tekrar seçiniz :");
                selectLocation = input.nextInt();
            }

            boolean outOfFile = false;
            while(!outOfFile) {
                switch (selectLocation) {
                    case 0:
                        location = null;
                        outOfFile = true;
                        break;
                    case 1:
                        location = new SafeHouse(player);
                        outOfFile = true;
                        break;
                    case 2:
                        location = new ToolStore(player);
                        outOfFile = true;
                        break;
                    case 3:
                        if (player.getInventory().isFood()) {
                            System.out.println("Bu aşamayı çoktan geçtiniz.");
                            while (selectLocation == 3) {
                                System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
                                selectLocation = input.nextInt();
                            }
                        } else {
                            location = new Cave(player);//food
                            outOfFile = true;
                        }
                        break;
                    case 4:
                        if (player.getInventory().isFirewood()) {
                            System.out.println("bu aşamayı çoktan geçtiniz");
                            while (selectLocation == 4) {
                                System.out.print("lütfen gitmek istediğiniz bölgeyi seçiniz : ");
                                selectLocation = input.nextInt();
                            }
                        } else {
                            location = new Forest(player);//firewood
                            outOfFile = true;
                        }
                        break;
                    case 5:
                        if (player.getInventory().isWater()) {
                            System.out.println("bu aşamayı çoktan geçtiniz");
                            while (selectLocation == 5) {
                                System.out.print("lütfen gitmek istediğiniz bölgeyi seçiniz : ");
                                selectLocation = input.nextInt();
                            }
                        } else {
                            location = new River(player);//water
                            outOfFile = true;
                        }
                        break;
                }
            }

            if(location == null){
                System.out.println("oyundan çıkıldı");
                break;
            }

            if(!location.onLocation()) {
                System.out.println("game over");
                break;
            }

            if(player.getInventory().isWater() && player.getInventory().isFood() && player.getInventory().isFirewood()) {
                System.out.println("tebrikler oyunu kazandınız");
                break;
            }
        }
    }
}
