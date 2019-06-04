package lab5;

public class Circle implements CircleInterface {
    @Override
    public float getArea(float r) {
        return 0.5f * r * r * PI ;
    }

    @Override
    public float getCircumference(float r) {
        return 2 * r * PI;
    }
}
