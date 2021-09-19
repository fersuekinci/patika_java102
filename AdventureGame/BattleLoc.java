import java.util.Locale;
import java.util.Random;

public class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();

        System.out.println("şu an buradasınız : " + this.getName());
        System.out.println("dikkatli ol burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor");
        System.out.print("<S>avaş veya <K>aç : ");
        String selectCase = input.next().toUpperCase();

        if(!selectCase.equals("S") && !selectCase.equals("K")) {
            do {
                System.out.println("lütfen geçerli bir değer giriniz : ");
                System.out.print("<S>avaş veya <K>aç : ");
                selectCase = input.next().toUpperCase();
            } while (!selectCase.equals("S") && !selectCase.equals("K"));
        }
        if(selectCase.equals("S") && combat(obsNumber)) {
                return true;
        }
        else if(selectCase.equals("K")) {
            return true;
        }
        if(this.getPlayer().getHealth() <= 0) {
            System.out.println("öldünüz");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber){
        for (int i=1; i<=obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getOrijinalHealth());
            playerStats();
            obsStats(i);

            while(this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0){
                System.out.print("<V>ur veya <K>aç : ");
                String selectCombat = input.next().toUpperCase();
                Random random = new Random();
                int chance = random.nextInt(2);

                if(chance == 0)
                {
                    if(selectCombat.equals("V")) {
                        System.out.println();
                        System.out.println("siz vurdunuz");
                        this.getObstacle().setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        if(this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("canavar size vurdu");
                            int obsDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if(obsDamage < 0){
                                obsDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obsDamage);
                            afterHit();
                        }
                    }
                    else if(selectCombat.equals("K")) {
                        return false;
                    }
                    else {
                        System.out.print("geçersiz değer. lütfen tekrar deneyiniz : ");
                    }
                }
                else {
                    if(selectCombat.equals("V")) {
                        if(this.getObstacle().getHealth() > 0){
                            System.out.println();
                            System.out.println("canavar size vurdu");
                            int obsDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if(obsDamage < 0){
                                obsDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obsDamage);
                            afterHit();

                            System.out.println();
                            System.out.println("siz vurdunuz");
                            this.getObstacle().setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                        }
                    }
                    else if(selectCombat.equals("K")) {
                        return false;
                    }
                    else {
                        System.out.print("geçersiz değer. lütfen tekrar deneyiniz : ");
                    }
                }
            }
            if(this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("düşmanı yendiniz");
                System.out.println(this.getObstacle().getAward() + " para kazandınız");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("güncel paranız : " + this.getPlayer().getMoney());

                if( i == obsNumber){
                    if(this.award.equals("food") && !this.getPlayer().getInventory().isFood()) {
                        System.out.println(this.award + " kazandınız");
                        this.getPlayer().getInventory().setFood(true);
                    }

                    if(this.award.equals("water") && !this.getPlayer().getInventory().isWater()) {
                        System.out.println(this.award + " kazandınız");
                        this.getPlayer().getInventory().setWater(true);
                    }

                    if(this.award.equals("firewood") && !this.getPlayer().getInventory().isFirewood()) {
                        System.out.println(this.award + " kazandınız");
                        this.getPlayer().getInventory().setFirewood(true);
                    }
                }
            }
            else {
                return false;
            }
        }
        return false;
    }

    public void afterHit() {
        System.out.println("canınız : " + this.getPlayer().getHealth());
        System.out.println(this.obstacle.getName() + " canı : " + this.obstacle.getHealth());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("---------------------------");
        System.out.println("oyuncu değerleri");
        System.out.println("---------------------------");
        System.out.println("sağlık : " + this.getPlayer().getHealth());
        System.out.println("silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("para : " + this.getPlayer().getMoney());
    }

    public void obsStats(int i) {
        System.out.println("----------------------------");
        System.out.println(i + ". " + this.getObstacle().getName() + " değerleri ");
        System.out.println("----------------------------");
        System.out.println("sağlık : " + this.getObstacle().getHealth());
        System.out.println("hasar : " + this.getObstacle().getDamage());
        System.out.println("ödül : " + this.getObstacle().getAward());
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
