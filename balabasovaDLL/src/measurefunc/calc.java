package measurefunc;

public class calc implements title{

    @Override
    public double km_to_m(double a) {
        return a*1000;
    }

    @Override
    public double mile_to_m(double a) {
        return a*1609;
    }

    @Override
    public double foot_to_m(double a) {
        return a/3.281;
    }

    @Override
    public double m_to_km(double a) {
        return a/1000;
    }

    @Override
    public double m_to_mile(double a) {
        return a/1609;
    }

    @Override
    public double m_to_foot(double a) {
        return a*3.281;
    }
}
