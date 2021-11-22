package id.alexandrov.firstgame;

public class EnemyShip extends Ship<EnemyShip> {

    EnemyShip() {
        super();
    }

    @Override
    public void fire() {
        lasers.add(Laser.newRed().y(y ).x(x));
        lasers.add(Laser.newRed().y(y + height).x(x));
    }
}
