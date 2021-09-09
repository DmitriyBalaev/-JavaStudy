package adapter.adapters;

import adapter.round.RoundPeg;
import adapter.square.SquarePeg;

public class SquarePegAdapter extends RoundPeg {
    private SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    @Override
    public double getRadius(){
        double result;
        result = (Math.sqrt(Math.pow(squarePeg.getWidth() / 2, 2)) * 2);
        return result;
    }
}
