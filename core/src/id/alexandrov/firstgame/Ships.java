package id.alexandrov.firstgame;

public class Ships {

    public static EnemyShip newEnemy() {
        return new EnemyShip()
                .body("enemy_D")
                .shield("shield1")
                .angle(90);
    }

    public static PlayerShip newPlayable() {
        return new PlayerShip()
                .body("ship_sidesC")
                .shield("shield1")
                .angle(270);
    }
}
