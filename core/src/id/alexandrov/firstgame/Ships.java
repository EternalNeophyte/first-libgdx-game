package id.alexandrov.firstgame;

public class Ships {

    public static Ship newEnemy() {
        return Ship.construct()
                .body("enemy_D")
                .shield("shield1")
                .doOnfire(ship -> {
                    ship.lasers.add(Laser.newRed().speed(2).y(ship.y ).x(ship.x));
                    ship.lasers.add(Laser.newRed().speed(2).y(ship.y + ship.height).x(ship.x));
                });
    }

    public static Ship newPlayable() {
        return Ship.construct()
                .body("ship_sidesC")
                .shield("shield1")
                .doOnfire(ship -> {
                    ship.lasers.add(Laser.newBlue().speed(2).y(ship.y ).x(ship.x));
                    ship.lasers.add(Laser.newBlue().speed(2).y(ship.y + ship.height).x(ship.x));
                });
    }
}
