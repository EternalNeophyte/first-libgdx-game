package id.alexandrov.firstgame;

public class PlayerShip extends Ship<PlayerShip> {

    PlayerShip() {
        super();
    }

    @Override
    public void fire() {
        lasers.add(Laser.newBlue().speed(2).y(y ).x(x));
        lasers.add(Laser.newBlue().speed(2).y(y + height).x(x));
    }
}
