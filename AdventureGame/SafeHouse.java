public class SafeHouse extends NormalLocation{

    public SafeHouse(Player player) {
        super(player, "güvenli ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("güvenli evdesiniz");
        System.out.println("canınız yenilendi");
        this.getPlayer().setHealth(this.getPlayer().getOrijinalHealth());
        return true;
    }
}
