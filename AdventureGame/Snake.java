//public class Snake extends Obstacle{
////    private int damage;
////    private String award;
//
//    public Snake() {
//        super(4,"yılan",3,12,0);
//        int randomDamage = (int)(Math.random() * 3) + 3;
//        this.setDamage(randomDamage);
//        this.setAward();
//    }

// ------------ ThreadLocalRandom.current().nextInt(0, 100); ---------------
//
//    private void setAward() {
//        int chanceTool = (int)(Math.random()*100);
//        int chanceSubTool = (int)(Math.random()*100);
//
//        if(chanceTool < 15){
//            if(chanceSubTool < 50){
//                setAward(new Weapon("tabanca",1,2,5));
//                System.out.println("sürprizzz siz " + getAward() + " kazandınız");
//            }
//            if(chanceSubTool >= 50 && chanceSubTool < 80){
//                setAward(new Weapon("kılıç",2,3,35));
//                System.out.println("sürprizzz siz " + getAward() + " kazandınız");
//            }
//            if(chanceSubTool >= 80 && chanceSubTool < 100){
//                setAward(new Weapon("tüfek",3,7,45));
//                System.out.println("sürprizzz siz " + getAward() + " kazandınız");
//            }
//        }
//        if(chanceTool >=15 && chanceTool <30){
//            if(chanceSubTool < 50){
//                setAward(new Armor(1,"hafif",1,15));
//                System.out.println("sürprizzz siz " + getAward() + " kazandınız");
//            }
//            if(chanceSubTool >= 50 && chanceSubTool < 80){
//                setAward(new Armor(2,"orta",3,25));
//                System.out.println("sürprizzz siz " + getAward() + " kazandınız");
//            }
//            if(chanceSubTool >=80 && chanceSubTool < 100){
//                setAward(new Armor(3,"ağır",5,40));
//                System.out.println("sürprizzz siz " + getAward() + " kazandınız");
//            }
//        }
//        if(chanceTool >=30 && chanceTool < 55){
//            if(chanceSubTool < 50){
//                setAward(1);
//                System.out.println("sürprizzz siz " + getAward() + " para kazandınız");
//            }
//            if(chanceSubTool >= 50 && chanceSubTool < 80){
//                setAward(5);
//                System.out.println("sürprizzz siz " + getAward() + " para kazandınız");
//            }
//            if(chanceSubTool >= 80 && chanceSubTool < 100){
//                setAward(10);
//                System.out.println("sürprizzz siz " + getAward() + " para kazandınız");
//            }
//        }
//        if(chanceTool >= 55){
//            setAward(0);
//            System.out.println("malaesef hiçbir şey kazanamadınız ");
//        }
//    }
//}
